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
public class WhtCardInfoUtil {
    private static final String TAG = "WhtCardInfoUtil";

    public static CardInfo getWhtCardInfo(ApduLocalMultiExeCallback apduLocalMultiExeCallback) {
        String str;
        b.e(TAG, "START GET WHT CARDINFO");
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
        String[] strArr = {"00A40000021001", "0020000003123456", "00B095001F", "805C000204"};
        Rapdu[] rapduArr = new Rapdu[4];
        for (int i10 = 0; i10 < 4; i10++) {
            rapduArr[i10] = transiveAPDU(apduLocalMultiExeCallback, strArr[i10]);
        }
        if (rapduArr[0] == null || !rapduArr[0].getSw().equals("9000")) {
            cardInfo.setCardStatus(EnumCardAppStatus.CARD_STATUS_UNKNOWN);
            return cardInfo;
        } else if (rapduArr[1] == null || !rapduArr[1].getSw().equals("9000")) {
            cardInfo.setCardStatus(EnumCardAppStatus.CARD_STATUS_UNKNOWN);
            return cardInfo;
        } else if (rapduArr[2] == null || !rapduArr[2].getSw().equals("9000")) {
            cardInfo.setCardStatus(EnumCardAppStatus.CARD_STATUS_UNKNOWN);
            return cardInfo;
        } else if (rapduArr[3] == null || !rapduArr[3].getSw().equals("9000")) {
            cardInfo.setCardStatus(EnumCardAppStatus.CARD_STATUS_UNKNOWN);
            return cardInfo;
        } else {
            cardInfo.setCardStatus(EnumCardAppStatus.CARD_STATUS_OK);
            String rapdu = rapduArr[2].getRapdu();
            String sw2 = rapduArr[2].getSw();
            if (TextUtils.isEmpty(rapdu) || !sw2.equals("9000")) {
                str = "";
            } else if (!rapdu.substring(16, 18).equalsIgnoreCase("01")) {
                cardInfo.setCardStatus(EnumCardAppStatus.CARD_STATUS_DISABLE);
                return cardInfo;
            } else {
                str = rapdu.substring(24, 40);
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
            }
            int intValue = new BigInteger(rapduArr[3].getRapdu(), 16).intValue();
            cardInfo.setCardNum(str);
            cardInfo.setCardBalance(intValue);
            apduLocalMultiExeCallback.closeSEChannel();
            b.e(TAG, "GET WHT CARDINFO END:" + cardInfo.toString());
            return cardInfo;
        }
    }

    public static List<TradeInfo> getWhtTradeInfo(ApduLocalMultiExeCallback apduLocalMultiExeCallback) {
        Rapdu transiveAPDU;
        Rapdu transiveAPDU2;
        b.e(TAG, "START GET WHT TRADEINFO");
        ArrayList arrayList = null;
        if (apduLocalMultiExeCallback == null) {
            return null;
        }
        Rapdu transiveSelectApdu = transiveSelectApdu(apduLocalMultiExeCallback);
        if (transiveSelectApdu != null && transiveSelectApdu.getSw().equalsIgnoreCase("9000") && (transiveAPDU = transiveAPDU(apduLocalMultiExeCallback, "00A40000021001")) != null && transiveAPDU.getSw().equalsIgnoreCase("9000") && (transiveAPDU2 = transiveAPDU(apduLocalMultiExeCallback, "0020000003123456")) != null && transiveAPDU2.getSw().equalsIgnoreCase("9000")) {
            arrayList = new ArrayList();
            for (int i10 = 1; i10 < 11; i10++) {
                Rapdu transiveAPDU3 = transiveAPDU(apduLocalMultiExeCallback, "00B20" + Integer.toHexString(i10) + "C417");
                if (transiveAPDU3 == null || !transiveAPDU3.getSw().equalsIgnoreCase("9000") || transiveAPDU3.getRapdu().equalsIgnoreCase("0000000000000000000000000000000000000000000000")) {
                    break;
                }
                TradeInfo parseTradeRecord = parseTradeRecord(transiveAPDU3.getRapdu());
                b.d("tradeInfo:" + parseTradeRecord.toString());
                arrayList.add(parseTradeRecord);
            }
            apduLocalMultiExeCallback.closeSEChannel();
            b.e(TAG, "GET WHT TRADEINFO END");
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
        } else if ("06".equals(substring2)) {
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
        return transiveAPDU(apduLocalMultiExeCallback, "00A4040010D1560001360103000057485401000001");
    }
}
