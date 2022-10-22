package com.bjleisen.iface.sdk.util;

import android.text.TextUtils;
import com.bjleisen.iface.sdk.apdu.ApduLocalMultiExeCallback;
import com.bjleisen.iface.sdk.apdu.LeisenIfaceConfig;
import com.bjleisen.iface.sdk.bean.CardInfo;
import com.bjleisen.iface.sdk.bean.Rapdu;
import com.bjleisen.iface.sdk.bean.TradeInfo;
import com.bjleisen.iface.sdk.enums.EnumCardAppStatus;
import g9.a;
import h9.b;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/* loaded from: classes.dex */
public class TjtCardInfoUtil {
    private static final String TAG = "TjtCardInfoUtil";

    public static CardInfo getTjtCardInfo(ApduLocalMultiExeCallback apduLocalMultiExeCallback) {
        b.e(TAG, "START GET TJT CARDINFO");
        if (apduLocalMultiExeCallback == null) {
            return null;
        }
        CardInfo cardInfo = new CardInfo();
        Rapdu transiveSelectApdu = transiveSelectApdu(apduLocalMultiExeCallback);
        if (transiveSelectApdu == null) {
            cardInfo.setCardStatus(EnumCardAppStatus.CARD_STATUS_APPLET_NO_EXIST);
            return cardInfo;
        }
        String sw = transiveSelectApdu.getSw();
        if (!sw.equalsIgnoreCase("9000")) {
            if (sw.equalsIgnoreCase("6A82")) {
                cardInfo.setCardStatus(EnumCardAppStatus.CARD_STATUS_APPLET_NO_EXIST);
            } else {
                cardInfo.setCardStatus(EnumCardAppStatus.CARD_STATUS_UNKNOWN);
            }
            return cardInfo;
        }
        String[] strArr = {"00B0950000", "805C050210"};
        Rapdu[] rapduArr = new Rapdu[2];
        for (int i10 = 0; i10 < 2; i10++) {
            rapduArr[i10] = transiveAPDU(apduLocalMultiExeCallback, strArr[i10]);
        }
        if (rapduArr[0] == null || !rapduArr[0].getSw().equals("9000")) {
            cardInfo.setCardStatus(EnumCardAppStatus.CARD_STATUS_UNKNOWN);
            return cardInfo;
        } else if (rapduArr[1] == null || !rapduArr[1].getSw().equals("9000")) {
            cardInfo.setCardStatus(EnumCardAppStatus.CARD_STATUS_UNKNOWN);
            return cardInfo;
        } else {
            cardInfo.setCardStatus(EnumCardAppStatus.CARD_STATUS_OK);
            String rapdu = rapduArr[0].getRapdu();
            if (TextUtils.isEmpty(rapdu)) {
                cardInfo.setCardStatus(EnumCardAppStatus.CARD_STATUS_UNKNOWN);
                return cardInfo;
            } else if (!TextUtils.equals("01", rapdu.substring(18, 20))) {
                cardInfo.setCardStatus(EnumCardAppStatus.CARD_STATUS_DISABLE);
                return cardInfo;
            } else {
                cardInfo.setCardNum(rapdu.substring(20, 40).substring(1));
                String substring = rapdu.substring(40, 48);
                String substring2 = rapdu.substring(48, 56);
                String format = new SimpleDateFormat(LeisenIfaceConfig.CARD_DATE_FORMAT).format(new Date());
                if (!a.d(substring, LeisenIfaceConfig.CARD_DATE_FORMAT) || !a.d(substring2, LeisenIfaceConfig.CARD_DATE_FORMAT) || !a.e(substring, substring2, LeisenIfaceConfig.CARD_DATE_FORMAT)) {
                    cardInfo.setCardStatus(EnumCardAppStatus.CARD_STATUS_INVALID_DATE);
                } else if (!a.e(substring, format, LeisenIfaceConfig.CARD_DATE_FORMAT)) {
                    cardInfo.setCardStatus(EnumCardAppStatus.CARD_STATUS_UNENABLED_DATE);
                } else if (!a.e(format, substring2, LeisenIfaceConfig.CARD_DATE_FORMAT)) {
                    cardInfo.setCardStatus(EnumCardAppStatus.CARD_STATUS_OUT_DATE);
                }
                cardInfo.setStartDate(substring);
                cardInfo.setExpiryDate(substring2);
                String rapdu2 = rapduArr[1].getRapdu();
                int intValue = new BigInteger(rapdu2.substring(0, 8), 16).intValue();
                new BigInteger(rapdu2.substring(8, 16), 16).intValue();
                int intValue2 = new BigInteger(rapdu2.substring(16, 24), 16).intValue();
                new BigInteger(rapdu2.substring(24, 32), 16).intValue();
                cardInfo.setCardBalance(intValue - intValue2);
                apduLocalMultiExeCallback.closeSEChannel();
                b.e(TAG, "GET TJT CARDINFO END:" + cardInfo.toString());
                return cardInfo;
            }
        }
    }

    public static List<TradeInfo> getTjtTradeInfo(ApduLocalMultiExeCallback apduLocalMultiExeCallback) {
        b.e(TAG, "START GET TJT TRADEINFO");
        ArrayList arrayList = null;
        if (apduLocalMultiExeCallback == null) {
            return null;
        }
        Rapdu transiveSelectApdu = transiveSelectApdu(apduLocalMultiExeCallback);
        if (transiveSelectApdu != null && transiveSelectApdu.getSw().equalsIgnoreCase("9000")) {
            arrayList = new ArrayList();
            for (int i10 = 1; i10 < 11; i10++) {
                Rapdu transiveAPDU = transiveAPDU(apduLocalMultiExeCallback, "00B20" + Integer.toHexString(i10) + "C400");
                if (transiveAPDU == null || !transiveAPDU.getSw().equalsIgnoreCase("9000") || transiveAPDU.getRapdu().equalsIgnoreCase("0000000000000000000000000000000000000000000000")) {
                    break;
                }
                TradeInfo parseTradeRecord = parseTradeRecord(transiveAPDU.getRapdu());
                b.d("tradeInfo:" + parseTradeRecord.toString());
                arrayList.add(parseTradeRecord);
            }
            apduLocalMultiExeCallback.closeSEChannel();
            b.e(TAG, "GET TJT TRADEINFO END");
        }
        return arrayList;
    }

    private static TradeInfo parseTradeRecord(String str) {
        String substring = str.substring(0, 4);
        int intValue = new BigInteger(str.substring(10, 18), 16).intValue();
        String substring2 = str.substring(18, 20);
        String substring3 = str.substring(32, 40);
        String substring4 = str.substring(40, 46);
        String substring5 = str.substring(20, 32);
        TradeInfo tradeInfo = new TradeInfo();
        tradeInfo.setTradeNo(substring);
        tradeInfo.setTradeMoney(intValue);
        tradeInfo.setTradeDate(substring3);
        tradeInfo.setTradeTime(substring4);
        tradeInfo.setTradeRecord(str);
        tradeInfo.setPosId(substring5);
        if ("02".equals(substring2)) {
            tradeInfo.setTradeType(1);
        } else if ("06".equals(substring2) || "12".equals(substring2)) {
            tradeInfo.setTradeType(0);
        }
        return tradeInfo;
    }

    private static Rapdu transiveAPDU(ApduLocalMultiExeCallback apduLocalMultiExeCallback, String str) {
        Rapdu transiveAPDU = apduLocalMultiExeCallback.transiveAPDU(str);
        if (transiveAPDU != null && !TextUtils.isEmpty(transiveAPDU.getSw())) {
            return transiveAPDU;
        }
        apduLocalMultiExeCallback.closeSEChannel();
        return null;
    }

    private static Rapdu transiveSelectApdu(ApduLocalMultiExeCallback apduLocalMultiExeCallback) {
        return transiveAPDU(apduLocalMultiExeCallback, "00A4040010A00000063201010501131121FF000000");
    }
}
