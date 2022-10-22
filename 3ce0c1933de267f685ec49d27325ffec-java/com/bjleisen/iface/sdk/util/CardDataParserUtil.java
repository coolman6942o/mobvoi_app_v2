package com.bjleisen.iface.sdk.util;

import android.text.TextUtils;
import com.bjleisen.iface.sdk.apdu.ApduLocalMultiExeCallback;
import com.bjleisen.iface.sdk.bean.Rapdu;
import com.bjleisen.iface.sdk.util.CardTemplateData;
import com.bjleisen.iface.sdk.util.TradeTemplateInfo;
import com.google.gson.e;
import h9.a;
import h9.b;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public final class CardDataParserUtil {
    private static final String TAG = "CardDataParserUtil";

    private static boolean isMatchSw(Object obj, String str) {
        if (obj == null) {
            return false;
        }
        String str2 = (String) obj;
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        return Pattern.compile(str2).matcher(str).find();
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x013c, code lost:
        r10.closeSEChannel();
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0143, code lost:
        if (r0.size() > 0) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0145, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x014f, code lost:
        return new com.google.gson.e().s(r0);
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v13, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v14, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v16, types: [java.lang.Integer] */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v21 */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String parserCardInfo(String str, ApduLocalMultiExeCallback apduLocalMultiExeCallback) {
        ?? r62;
        String str2 = TAG;
        b.g(str2, "cardData:" + str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (apduLocalMultiExeCallback == null) {
            b.e(str2, "sdk未初始化");
            return null;
        }
        try {
            CardTemplateData cardTemplateData = (CardTemplateData) new e().j(str, CardTemplateData.class);
            if (cardTemplateData == null) {
                b.e(str2, "卡信息模板错误");
                return null;
            }
            List<CardTemplateData.ApdusBean> apdus = cardTemplateData.getApdus();
            if (apdus != null && apdus.size() > 0) {
                HashMap hashMap = new HashMap();
                Iterator<CardTemplateData.ApdusBean> it = apdus.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    CardTemplateData.ApdusBean next = it.next();
                    Rapdu transiveAPDU = transiveAPDU(apduLocalMultiExeCallback, next.getApdu(), next.getSw());
                    if (transiveAPDU == null) {
                        b.e(TAG, "指令执行失败");
                        return null;
                    }
                    String sw = next.getSw();
                    String sw2 = transiveAPDU.getSw();
                    List<CardTemplateData.ApdusBean.ParserTemplateBean> parserTemplate = next.getParserTemplate();
                    if (!isMatchSw(sw, sw2)) {
                        if (parserTemplate != null && parserTemplate.size() > 0) {
                            for (CardTemplateData.ApdusBean.ParserTemplateBean parserTemplateBean : parserTemplate) {
                                String swReferData = parserTemplateBean.getSwReferData();
                                hashMap.put(parserTemplateBean.getFunctionName(), (TextUtils.isEmpty(swReferData) || !isMatchSw(swReferData, sw2)) ? null : sw2);
                            }
                        }
                        if (next.isInterruptedNextApdu()) {
                            b.e(TAG, "中断执行指令");
                            break;
                        }
                    } else if (parserTemplate != null && parserTemplate.size() > 0) {
                        for (CardTemplateData.ApdusBean.ParserTemplateBean parserTemplateBean2 : parserTemplate) {
                            CardTemplateData.ApdusBean.ParserTemplateBean.SubDatasBean subDatas = parserTemplateBean2.getSubDatas();
                            if (subDatas != null) {
                                r62 = transiveAPDU.getRapdu().substring(subDatas.getStartIndex(), subDatas.getEndIndex());
                                CardTemplateData.ApdusBean.ParserTemplateBean.ParserMethodBean parserMethod = parserTemplateBean2.getParserMethod();
                                if (parserMethod != null) {
                                    r62 = r62;
                                    if (parserMethod.isTransferLittleEndian()) {
                                        r62 = a.a(reverseArray(a.c(r62)));
                                    }
                                    if (parserMethod.isTransferDecimalSystem()) {
                                        r62 = Integer.valueOf(new BigInteger((String) r62, 16).intValue());
                                    }
                                }
                            } else {
                                String swReferData2 = parserTemplateBean2.getSwReferData();
                                r62 = (TextUtils.isEmpty(swReferData2) || !isMatchSw(swReferData2, sw2)) ? 0 : sw2;
                            }
                            hashMap.put(parserTemplateBean2.getFunctionName(), r62);
                        }
                    }
                }
            }
            b.e(str2, "卡信息模板错误:空指令集");
            return null;
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.lang.Integer] */
    public static String parserTradeInfo(String str, ApduLocalMultiExeCallback apduLocalMultiExeCallback) {
        b.f("tradeData:" + str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (apduLocalMultiExeCallback == null) {
            b.e(TAG, "sdk未初始化");
            return null;
        }
        try {
            TradeTemplateInfo tradeTemplateInfo = (TradeTemplateInfo) new e().j(str, TradeTemplateInfo.class);
            if (tradeTemplateInfo == null) {
                b.e(TAG, "卡信息模板错误");
                return null;
            }
            List<TradeTemplateInfo.ApdusBean> apdus = tradeTemplateInfo.getApdus();
            if (apdus != null && apdus.size() > 0) {
                TradeTemplateInfo.ParserTemplateBean parserTemplate = tradeTemplateInfo.getParserTemplate();
                if (parserTemplate == null) {
                    b.e(TAG, "卡信息模板错误:空解析模板");
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                for (TradeTemplateInfo.ApdusBean apdusBean : apdus) {
                    Rapdu transiveAPDU = transiveAPDU(apduLocalMultiExeCallback, apdusBean.getApdu(), apdusBean.getSw());
                    if (transiveAPDU == null) {
                        return null;
                    }
                    arrayList.add(transiveAPDU);
                }
                ArrayList arrayList2 = new ArrayList();
                List<TradeTemplateInfo.ParserTemplateBean.SubDatasBean> subDatas = parserTemplate.getSubDatas();
                if (arrayList.size() <= parserTemplate.getApduStartIndex()) {
                    return null;
                }
                for (int apduStartIndex = parserTemplate.getApduStartIndex(); apduStartIndex <= parserTemplate.getApduEndIndex(); apduStartIndex++) {
                    Rapdu rapdu = (Rapdu) arrayList.get(apduStartIndex);
                    if (rapdu.getSw().equalsIgnoreCase("9000")) {
                        String rapdu2 = rapdu.getRapdu();
                        HashMap hashMap = new HashMap();
                        for (TradeTemplateInfo.ParserTemplateBean.SubDatasBean subDatasBean : subDatas) {
                            ?? substring = rapdu2.substring(subDatasBean.getStartIndex(), subDatasBean.getEndIndex());
                            TradeTemplateInfo.ParserTemplateBean.SubDatasBean.ParserMethodBean parserMethod = subDatasBean.getParserMethod();
                            if (parserMethod != null && parserMethod.isIsTransferDecimalSystem()) {
                                substring = Integer.valueOf(new BigInteger((String) substring, 16).intValue());
                            }
                            hashMap.put(subDatasBean.getFunctionName(), substring);
                        }
                        arrayList2.add(hashMap);
                    }
                }
                return new e().s(arrayList2);
            }
            b.e(TAG, "卡信息模板错误:空指令集");
            return null;
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
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

    private static Rapdu transiveAPDU(ApduLocalMultiExeCallback apduLocalMultiExeCallback, String str, String str2) {
        Rapdu transiveAPDU = apduLocalMultiExeCallback.transiveAPDU(str);
        if (transiveAPDU != null && !TextUtils.isEmpty(transiveAPDU.getSw())) {
            return transiveAPDU;
        }
        String str3 = TAG;
        b.e(str3, "执行" + str + "失败");
        apduLocalMultiExeCallback.closeSEChannel();
        return null;
    }
}
