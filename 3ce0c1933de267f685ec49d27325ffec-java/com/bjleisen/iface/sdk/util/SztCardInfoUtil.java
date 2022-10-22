package com.bjleisen.iface.sdk.util;

import android.text.TextUtils;
import com.bjleisen.iface.sdk.apdu.ApduLocalMultiExeCallback;
import com.bjleisen.iface.sdk.apdu.LeisenIfaceConfig;
import com.bjleisen.iface.sdk.bean.CardInfo;
import com.bjleisen.iface.sdk.bean.Rapdu;
import com.bjleisen.iface.sdk.bean.TradeInfo;
import com.bjleisen.iface.sdk.enums.EnumCardAppStatus;
import h9.a;
import h9.b;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/* loaded from: classes.dex */
public class SztCardInfoUtil {
    private static final String TAG = "SztCardInfoUtil";

    public static CardInfo getSztCardInfo(ApduLocalMultiExeCallback apduLocalMultiExeCallback) {
        b.e(TAG, "START GET SZT CARDINFO");
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
        String[] strArr = {"805c000204", "00b0950020", "00b201cc20", "00b09a001c"};
        Rapdu[] rapduArr = new Rapdu[4];
        for (int i10 = 0; i10 < 4; i10++) {
            rapduArr[i10] = transiveAPDU(apduLocalMultiExeCallback, strArr[i10]);
        }
        if (rapduArr[0] == null || rapduArr[1] == null) {
            cardInfo.setCardStatus(EnumCardAppStatus.CARD_STATUS_UNKNOWN);
            return cardInfo;
        } else if (!rapduArr[0].getSw().equalsIgnoreCase("9000") || !rapduArr[1].getSw().equalsIgnoreCase("9000")) {
            cardInfo.setCardStatus(EnumCardAppStatus.CARD_STATUS_UNKNOWN);
            return cardInfo;
        } else {
            cardInfo.setCardStatus(EnumCardAppStatus.CARD_STATUS_OK);
            int intValue = new BigInteger(rapduArr[0].getRapdu().substring(1), 16).intValue();
            String valueOf = String.valueOf(Integer.parseInt(a.a(reverseArray(a.c(rapduArr[1].getRapdu().substring(32, 40)))), 16));
            if (rapduArr[2] != null && !TextUtils.isEmpty(rapduArr[2].getRapdu()) && !rapduArr[2].getRapdu().substring(6, 8).equalsIgnoreCase("03")) {
                cardInfo.setCardStatus(EnumCardAppStatus.CARD_STATUS_DISABLE);
            }
            if (rapduArr[3] != null && !TextUtils.isEmpty(rapduArr[3].getRapdu())) {
                String substring = rapduArr[3].getRapdu().substring(0, 16);
                if (substring.equalsIgnoreCase("0000000000000000")) {
                    cardInfo.setCardStatus(EnumCardAppStatus.CARD_STATUS_DISABLE);
                } else {
                    String substring2 = substring.substring(0, 8);
                    String substring3 = substring.substring(8, 16);
                    String format = new SimpleDateFormat(LeisenIfaceConfig.CARD_DATE_FORMAT).format(new Date());
                    if (!g9.a.d(substring2, LeisenIfaceConfig.CARD_DATE_FORMAT) || !g9.a.d(substring3, LeisenIfaceConfig.CARD_DATE_FORMAT) || !g9.a.e(substring2, substring3, LeisenIfaceConfig.CARD_DATE_FORMAT)) {
                        cardInfo.setCardStatus(EnumCardAppStatus.CARD_STATUS_INVALID_DATE);
                    } else if (!g9.a.e(substring2, format, LeisenIfaceConfig.CARD_DATE_FORMAT)) {
                        cardInfo.setCardStatus(EnumCardAppStatus.CARD_STATUS_UNENABLED_DATE);
                    }
                    cardInfo.setStartDate(substring2);
                    cardInfo.setExpiryDate(substring3);
                }
            }
            cardInfo.setCardNum(valueOf);
            cardInfo.setCardBalance(intValue);
            apduLocalMultiExeCallback.closeSEChannel();
            b.e(TAG, "GET SZT CARDINFO END:" + cardInfo.toString());
            return cardInfo;
        }
    }

    public static TradeInfo getSztLastTradeInfo(ApduLocalMultiExeCallback apduLocalMultiExeCallback) {
        Rapdu transiveSelectApdu;
        Rapdu transiveAPDU;
        if (apduLocalMultiExeCallback == null || (transiveSelectApdu = transiveSelectApdu(apduLocalMultiExeCallback)) == null || !transiveSelectApdu.getSw().equalsIgnoreCase("9000") || (transiveAPDU = transiveAPDU(apduLocalMultiExeCallback, "00B201C417")) == null) {
            return null;
        }
        apduLocalMultiExeCallback.closeSEChannel();
        return parseTradeRecord(transiveAPDU.getRapdu());
    }

    public static List<TradeInfo> getSztTradeInfo(ApduLocalMultiExeCallback apduLocalMultiExeCallback) {
        Rapdu transiveSelectApdu;
        b.e(TAG, "START GET SZT TRADEINFO");
        if (apduLocalMultiExeCallback == null || (transiveSelectApdu = transiveSelectApdu(apduLocalMultiExeCallback)) == null || !transiveSelectApdu.getSw().equalsIgnoreCase("9000")) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i10 = 1; i10 < 11; i10++) {
            Rapdu transiveAPDU = transiveAPDU(apduLocalMultiExeCallback, "00B20" + Integer.toHexString(i10) + "C417");
            if (transiveAPDU == null) {
                return null;
            }
            TradeInfo parseTradeRecord = parseTradeRecord(transiveAPDU.getRapdu());
            b.d("tradeInfo:" + parseTradeRecord.toString());
            if ("00000000".equals(parseTradeRecord.getTradeDate()) && "000000".equals(parseTradeRecord.getTradeTime())) {
                break;
            }
            arrayList.add(parseTradeRecord);
        }
        apduLocalMultiExeCallback.closeSEChannel();
        b.e(TAG, "GET SZT TRADEINFO END");
        return arrayList;
    }

    private static TradeInfo parseTradeRecord(String str) {
        String substring = str.substring(0, 4);
        int intValue = new BigInteger(str.substring(10, 18), 16).intValue();
        String substring2 = str.substring(32, 40);
        String substring3 = str.substring(40, 46);
        String substring4 = str.substring(18, 20);
        TradeInfo tradeInfo = new TradeInfo();
        tradeInfo.setTradeNo(substring);
        tradeInfo.setTradeMoney(intValue);
        tradeInfo.setTradeDate(substring2);
        tradeInfo.setTradeTime(substring3);
        tradeInfo.setTradeRecord(str);
        if ("02".equals(substring4)) {
            tradeInfo.setTradeType(1);
        } else if (com.mobvoi.companion.ticpay.buscard.TradeInfo.CONSUMPTION2.equals(substring4)) {
            tradeInfo.setTradeType(0);
        }
        return tradeInfo;
    }

    private static byte[] reverseArray(byte[] bArr) {
        int length = bArr.length - 1;
        for (byte b10 = 0; length > b10 * 2; b10 = (byte) (b10 + 1)) {
            byte b11 = bArr[b10];
            int i10 = length - b10;
            bArr[b10] = bArr[i10];
            bArr[i10] = b11;
        }
        return bArr;
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
        String[] strArr = {"00A404000E535A542E57414C4C45542E454E56", "00A40000021001"};
        Rapdu rapdu = null;
        for (int i10 = 0; i10 < 2 && (rapdu = transiveAPDU(apduLocalMultiExeCallback, strArr[i10])) != null && rapdu.getSw().equalsIgnoreCase("9000"); i10++) {
        }
        return rapdu;
    }
}
