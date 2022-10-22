package com.bjleisen.iface.sdk.util;

import android.text.TextUtils;
import com.bjleisen.iface.sdk.apdu.ApduLocalMultiExeCallback;
import com.bjleisen.iface.sdk.bean.Rapdu;
import com.bjleisen.iface.sdk.util.CardTemplateInfo;
import com.bjleisen.iface.sdk.util.TradeTemplateInfo;
import com.google.gson.e;
import h9.a;
import h9.b;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public final class CardInfoParserUtil {
    private static final String TAG = "CardInfoParserUtil";

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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.lang.Integer] */
    public static String parserCardInfo(String str, ApduLocalMultiExeCallback apduLocalMultiExeCallback) {
        String str2;
        String str3 = TAG;
        b.g(str3, "cardData:" + str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (apduLocalMultiExeCallback == null) {
            b.e(str3, "sdk未初始化");
            return null;
        }
        try {
            CardTemplateInfo cardTemplateInfo = (CardTemplateInfo) new e().j(str, CardTemplateInfo.class);
            if (cardTemplateInfo == null) {
                b.e(str3, "卡信息模板错误");
                return null;
            }
            List<CardTemplateInfo.ApdusBean> apdus = cardTemplateInfo.getApdus();
            if (apdus != null && apdus.size() > 0) {
                List<CardTemplateInfo.ParserTemplateBean> parserTemplate = cardTemplateInfo.getParserTemplate();
                if (parserTemplate != null && parserTemplate.size() > 0) {
                    HashMap hashMap = new HashMap();
                    ArrayList arrayList = new ArrayList();
                    for (CardTemplateInfo.ApdusBean apdusBean : apdus) {
                        Rapdu transiveAPDU = transiveAPDU(apduLocalMultiExeCallback, apdusBean.getApdu(), apdusBean.getSw());
                        if (transiveAPDU == null) {
                            b.d("指令执行失败");
                            return null;
                        }
                        arrayList.add(transiveAPDU);
                    }
                    apduLocalMultiExeCallback.closeSEChannel();
                    for (CardTemplateInfo.ParserTemplateBean parserTemplateBean : parserTemplate) {
                        CardTemplateInfo.ParserTemplateBean.SubDatasBean subDatas = parserTemplateBean.getSubDatas();
                        int apduIndex = subDatas.getApduIndex();
                        if (arrayList.size() > apduIndex) {
                            Rapdu rapdu = (Rapdu) arrayList.get(apduIndex);
                            if (rapdu == null) {
                                str2 = null;
                            } else if (subDatas.isSwRefer()) {
                                str2 = rapdu.getSw();
                            } else {
                                String substring = rapdu.getRapdu().substring(subDatas.getStartIndex(), subDatas.getEndIndex());
                                CardTemplateInfo.ParserTemplateBean.ParserMethodBean parserMethod = parserTemplateBean.getParserMethod();
                                str2 = substring;
                                if (parserMethod != null) {
                                    String str4 = substring;
                                    if (parserMethod.isTransferLittleEndian()) {
                                        str4 = a.a(reverseArray(a.c(substring)));
                                    }
                                    str2 = str4;
                                    if (parserMethod.isTransferDecimalSystem()) {
                                        str2 = Integer.valueOf(new BigInteger(str4, 16).intValue());
                                    }
                                }
                            }
                            hashMap.put(parserTemplateBean.getFunctionName(), str2);
                        }
                    }
                    return new e().s(hashMap);
                }
                b.e(str3, "卡信息模板错误:空解析模板");
                return null;
            }
            b.e(str3, "卡信息模板错误:空指令集");
            return null;
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.lang.Integer] */
    public static String parserCardInfoDelayMatchSw(String str, ApduLocalMultiExeCallback apduLocalMultiExeCallback) {
        String str2;
        String str3 = TAG;
        b.g(str3, "cardData:" + str);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (apduLocalMultiExeCallback == null) {
            b.e(str3, "sdk未初始化");
            return null;
        }
        try {
            CardTemplateInfo cardTemplateInfo = (CardTemplateInfo) new e().j(str, CardTemplateInfo.class);
            if (cardTemplateInfo == null) {
                b.e(str3, "卡信息模板错误");
                return null;
            }
            List<CardTemplateInfo.ApdusBean> apdus = cardTemplateInfo.getApdus();
            if (apdus != null && apdus.size() > 0) {
                List<CardTemplateInfo.ParserTemplateBean> parserTemplate = cardTemplateInfo.getParserTemplate();
                if (parserTemplate != null && parserTemplate.size() > 0) {
                    HashMap hashMap = new HashMap();
                    ArrayList arrayList = new ArrayList();
                    for (CardTemplateInfo.ApdusBean apdusBean : apdus) {
                        Rapdu transiveAPDU = transiveAPDU(apduLocalMultiExeCallback, apdusBean.getApdu());
                        if (transiveAPDU == null) {
                            return null;
                        }
                        arrayList.add(transiveAPDU);
                    }
                    apduLocalMultiExeCallback.closeSEChannel();
                    b.d("卡信息数据解析Start");
                    for (CardTemplateInfo.ParserTemplateBean parserTemplateBean : parserTemplate) {
                        CardTemplateInfo.ParserTemplateBean.SubDatasBean subDatas = parserTemplateBean.getSubDatas();
                        int apduIndex = subDatas.getApduIndex();
                        if (arrayList.size() > apduIndex) {
                            Rapdu rapdu = (Rapdu) arrayList.get(apduIndex);
                            CardTemplateInfo.ApdusBean apdusBean2 = apdus.get(apduIndex);
                            b.d("解析字段：" + parserTemplateBean.getFunctionName() + ",索引：" + apduIndex);
                            b.d("Capdu:" + apdusBean2.getApdu() + ",expSw:" + apdusBean2.getSw());
                            b.d("Rapdu:" + rapdu.getRapdu() + ",sw:" + rapdu.getSw());
                            if (isMatchSw(apdusBean2.getSw(), rapdu.getSw())) {
                                b.f("match");
                                if (subDatas.isSwRefer()) {
                                    str2 = rapdu.getSw();
                                } else {
                                    String substring = rapdu.getRapdu().substring(subDatas.getStartIndex(), subDatas.getEndIndex());
                                    CardTemplateInfo.ParserTemplateBean.ParserMethodBean parserMethod = parserTemplateBean.getParserMethod();
                                    str2 = substring;
                                    if (parserMethod != null) {
                                        String str4 = substring;
                                        if (parserMethod.isTransferLittleEndian()) {
                                            str4 = a.a(reverseArray(a.c(substring)));
                                        }
                                        str2 = str4;
                                        if (parserMethod.isTransferDecimalSystem()) {
                                            str2 = Integer.valueOf(new BigInteger(str4, 16).intValue());
                                        }
                                    }
                                }
                                hashMap.put(parserTemplateBean.getFunctionName(), str2);
                            }
                        }
                    }
                    b.d("卡信息数据解析Finish");
                    return new e().s(hashMap);
                }
                b.e(str3, "卡信息模板错误:空解析模板");
                return null;
            }
            b.e(str3, "卡信息模板错误:空指令集");
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
                    if (transiveAPDU.getRapdu().equalsIgnoreCase("0000000000000000000000000000000000000000000000")) {
                        break;
                    }
                    arrayList.add(transiveAPDU);
                }
                apduLocalMultiExeCallback.closeSEChannel();
                ArrayList arrayList2 = new ArrayList();
                List<TradeTemplateInfo.ParserTemplateBean.SubDatasBean> subDatas = parserTemplate.getSubDatas();
                for (int apduStartIndex = parserTemplate.getApduStartIndex(); apduStartIndex <= parserTemplate.getApduEndIndex(); apduStartIndex++) {
                    if (apduStartIndex < arrayList.size()) {
                        String rapdu = ((Rapdu) arrayList.get(apduStartIndex)).getRapdu();
                        HashMap hashMap = new HashMap();
                        for (TradeTemplateInfo.ParserTemplateBean.SubDatasBean subDatasBean : subDatas) {
                            ?? substring = rapdu.substring(subDatasBean.getStartIndex(), subDatasBean.getEndIndex());
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
        if (transiveAPDU != null && !TextUtils.isEmpty(transiveAPDU.getSw()) && isMatchSw(str2, transiveAPDU.getSw())) {
            return transiveAPDU;
        }
        String str3 = TAG;
        b.e(str3, "执行" + str + "失败");
        apduLocalMultiExeCallback.closeSEChannel();
        return null;
    }

    private static Rapdu transiveAPDU(ApduLocalMultiExeCallback apduLocalMultiExeCallback, String str) {
        Rapdu transiveAPDU = apduLocalMultiExeCallback.transiveAPDU(str);
        if (transiveAPDU != null && !TextUtils.isEmpty(transiveAPDU.getSw())) {
            return transiveAPDU;
        }
        String str2 = TAG;
        b.e(str2, "执行" + str + "失败");
        apduLocalMultiExeCallback.closeSEChannel();
        return null;
    }
}
