package com.bjleisen.iface.sdk.util;

import android.text.TextUtils;
import com.bjleisen.iface.sdk.apdu.ApduLocalMultiExeCallback;
import com.bjleisen.iface.sdk.bean.CardInfo;
import com.bjleisen.iface.sdk.bean.Rapdu;
import com.bjleisen.iface.sdk.bean.TradeInfo;
import com.bjleisen.iface.sdk.enums.EnumCardAppStatus;
import h9.b;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class HctCardInfoUtil {
    private static final String TAG = "HctCardInfoUtil";

    public static CardInfo getHctCardInfo(ApduLocalMultiExeCallback apduLocalMultiExeCallback) {
        b.e(TAG, "START GET HCT CARDINFO");
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
        String[] strArr = {"00B0950A0A", "00A40000023F01", "805C000204"};
        Rapdu[] rapduArr = new Rapdu[3];
        for (int i10 = 0; i10 < 3; i10++) {
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
        } else {
            cardInfo.setCardStatus(EnumCardAppStatus.CARD_STATUS_OK);
            String rapdu = rapduArr[0].getRapdu();
            String substring = (TextUtils.isEmpty(rapdu) || !rapduArr[0].getSw().equals("9000")) ? "" : rapdu.substring(1, rapdu.length());
            int intValue = new BigInteger(rapduArr[2].getRapdu(), 16).intValue();
            cardInfo.setCardNum(substring);
            cardInfo.setCardBalance(intValue);
            apduLocalMultiExeCallback.closeSEChannel();
            b.e(TAG, "GET HCT CARDINFO END:" + cardInfo.toString());
            return cardInfo;
        }
    }

    public static List<TradeInfo> getHctTradeInfo(ApduLocalMultiExeCallback apduLocalMultiExeCallback) {
        Rapdu transiveAPDU;
        b.e(TAG, "START GET HCT TRADEINFO");
        ArrayList arrayList = null;
        if (apduLocalMultiExeCallback == null) {
            return null;
        }
        Rapdu transiveSelectApdu = transiveSelectApdu(apduLocalMultiExeCallback);
        if (transiveSelectApdu != null && transiveSelectApdu.getSw().equalsIgnoreCase("9000") && (transiveAPDU = transiveAPDU(apduLocalMultiExeCallback, "00A40000023F01")) != null && transiveAPDU.getSw().equalsIgnoreCase("9000")) {
            arrayList = new ArrayList();
            for (int i10 = 1; i10 < 11; i10++) {
                Rapdu transiveAPDU2 = transiveAPDU(apduLocalMultiExeCallback, "00B20" + Integer.toHexString(i10) + "C417");
                if (transiveAPDU2 == null || !transiveAPDU2.getSw().equalsIgnoreCase("9000") || transiveAPDU2.getRapdu().equalsIgnoreCase("0000000000000000000000000000000000000000000000")) {
                    break;
                }
                TradeInfo parseTradeRecord = parseTradeRecord(transiveAPDU2.getRapdu());
                b.d("tradeInfo:" + parseTradeRecord.toString());
                arrayList.add(parseTradeRecord);
            }
            apduLocalMultiExeCallback.closeSEChannel();
            b.e(TAG, "GET HCT TRADEINFO END");
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
        return transiveAPDU(apduLocalMultiExeCallback, "00A4040010A00000063201010501592610FF000000");
    }
}
