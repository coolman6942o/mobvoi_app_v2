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
import java.util.Locale;
/* loaded from: classes.dex */
public class BjtCardInfoUtil {
    private static final String TAG = "BjtCardInfoUtil";

    public static CardInfo getBjtCardInfo(ApduLocalMultiExeCallback apduLocalMultiExeCallback) {
        b.e(TAG, "START GET BJT CARDINFO");
        if (apduLocalMultiExeCallback == null) {
            return null;
        }
        CardInfo cardInfo = new CardInfo();
        Rapdu transiveSelectApdu = transiveSelectApdu(apduLocalMultiExeCallback);
        if (transiveSelectApdu == null) {
            cardInfo.setCardStatus(EnumCardAppStatus.CARD_STATUS_UNKNOWN);
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
        String[] strArr = {"00B0840008", "00B0841808", "00B0840901", "00B0850001", "00B0850504", "00A40000021001", "805C000204"};
        Rapdu[] rapduArr = new Rapdu[7];
        int i10 = 0;
        for (int i11 = 0; i11 < 7; i11++) {
            rapduArr[i11] = transiveAPDU(apduLocalMultiExeCallback, strArr[i11]);
        }
        if (rapduArr[0] == null || rapduArr[4] == null || rapduArr[6] == null) {
            cardInfo.setCardStatus(EnumCardAppStatus.CARD_STATUS_UNKNOWN);
            return cardInfo;
        }
        cardInfo.setCardStatus(EnumCardAppStatus.CARD_STATUS_OK);
        String rapdu = rapduArr[0].getRapdu();
        if (rapduArr[1] != null && !TextUtils.isEmpty(rapduArr[1].getRapdu())) {
            String substring = rapduArr[1].getRapdu().substring(0, 8);
            String substring2 = rapduArr[1].getRapdu().substring(8, 16);
            String format = new SimpleDateFormat(LeisenIfaceConfig.CARD_DATE_FORMAT, Locale.getDefault()).format(new Date());
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
        if (rapduArr[2] != null && !TextUtils.isEmpty(rapduArr[2].getRapdu()) && !rapduArr[2].getRapdu().equalsIgnoreCase("02")) {
            cardInfo.setCardStatus(EnumCardAppStatus.CARD_STATUS_DISABLE);
        }
        if (rapduArr[3] != null && !TextUtils.isEmpty(rapduArr[3].getRapdu()) && rapduArr[3].getRapdu().equalsIgnoreCase(com.mobvoi.companion.ticpay.buscard.CardInfo.BLACK_LIST_BJT)) {
            cardInfo.setCardStatus(EnumCardAppStatus.CARD_STATUS_BLACKLIST);
        }
        int intValue = rapduArr[4].getRapdu().equalsIgnoreCase("ffffffff") ? 0 : new BigInteger(rapduArr[4].getRapdu(), 16).intValue();
        int intValue2 = new BigInteger(rapduArr[6].getRapdu(), 16).intValue();
        if (intValue < 0 || intValue2 < 0) {
            cardInfo.setCardStatus(EnumCardAppStatus.CARD_STATUS_WALLET_ERROR);
        } else if (intValue == 0 || intValue2 == 0) {
            i10 = intValue2 - intValue;
        } else {
            cardInfo.setCardStatus(EnumCardAppStatus.CARD_STATUS_WALLET_ERROR);
        }
        cardInfo.setCardNum(rapdu);
        cardInfo.setCardBalance(i10);
        apduLocalMultiExeCallback.closeSEChannel();
        b.e(TAG, "GET BJT CARDINFO END:" + cardInfo.toString());
        return cardInfo;
    }

    public static TradeInfo getBjtLastTradeInfo(ApduLocalMultiExeCallback apduLocalMultiExeCallback) {
        Rapdu transiveSelectApdu;
        Rapdu transiveAPDU;
        if (apduLocalMultiExeCallback == null || (transiveSelectApdu = transiveSelectApdu(apduLocalMultiExeCallback)) == null || !transiveSelectApdu.getSw().equalsIgnoreCase("9000") || transiveAPDU(apduLocalMultiExeCallback, "00A40000021001") == null || (transiveAPDU = transiveAPDU(apduLocalMultiExeCallback, "00B201C417")) == null) {
            return null;
        }
        apduLocalMultiExeCallback.closeSEChannel();
        return parseTradeRecord(transiveAPDU.getRapdu());
    }

    public static List<TradeInfo> getBjtTradeInfo(ApduLocalMultiExeCallback apduLocalMultiExeCallback) {
        b.e(TAG, "START GET BJT TRADEINFO");
        ArrayList arrayList = null;
        if (apduLocalMultiExeCallback == null) {
            return null;
        }
        Rapdu transiveSelectApdu = transiveSelectApdu(apduLocalMultiExeCallback);
        if (transiveSelectApdu != null && transiveSelectApdu.getSw().equalsIgnoreCase("9000")) {
            if (transiveAPDU(apduLocalMultiExeCallback, "00A40000021001") == null) {
                return null;
            }
            arrayList = new ArrayList();
            for (int i10 = 1; i10 < 11; i10++) {
                Rapdu transiveAPDU = transiveAPDU(apduLocalMultiExeCallback, "00B20" + Integer.toHexString(i10) + "C417");
                if (transiveAPDU == null || !transiveAPDU.getSw().equalsIgnoreCase("9000") || transiveAPDU.getRapdu().equalsIgnoreCase("0000000000000000000000000000000000000000000000")) {
                    break;
                }
                TradeInfo parseTradeRecord = parseTradeRecord(transiveAPDU.getRapdu());
                b.d("tradeInfo:" + parseTradeRecord.toString());
                arrayList.add(parseTradeRecord);
            }
            apduLocalMultiExeCallback.closeSEChannel();
            b.e(TAG, "GET BJT TRADEINFO END");
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
        return transiveAPDU(apduLocalMultiExeCallback, "00A40400089156000014010001");
    }
}
