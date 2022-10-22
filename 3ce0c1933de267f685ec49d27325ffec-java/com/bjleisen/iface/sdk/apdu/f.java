package com.bjleisen.iface.sdk.apdu;

import com.bjleisen.iface.sdk.bean.Rapdu;
import com.bjleisen.iface.sdk.bean.req.AbnormalOrderDetailBusiReqInfo;
import com.bjleisen.iface.sdk.bean.req.ActionBusiReqInfo;
import com.bjleisen.iface.sdk.bean.req.AppletDetailBusiReqInfo;
import com.bjleisen.iface.sdk.bean.req.AppletOperBusiReqInfo;
import com.bjleisen.iface.sdk.bean.req.ApplyInvoiceReqInfo;
import com.bjleisen.iface.sdk.bean.req.CardTemplateReqInfo;
import com.bjleisen.iface.sdk.bean.req.CompletedOrderBusiReqInfo;
import com.bjleisen.iface.sdk.bean.req.NextBusiReqInfo;
import com.bjleisen.iface.sdk.bean.req.OrderBusiReqInfo;
import com.bjleisen.iface.sdk.bean.req.OtOperBusiReqInfo;
import com.bjleisen.iface.sdk.bean.req.PayOrderBusiReqInfo;
import com.bjleisen.iface.sdk.bean.req.PayOrderCalculateBusiReqInfo;
import com.bjleisen.iface.sdk.bean.req.PayOrderStatusBusiReqInfo;
import com.bjleisen.iface.sdk.bean.req.QueryInvoiceReqInfo;
import com.bjleisen.iface.sdk.bean.req.RefundBusiReqInfo;
import com.bjleisen.iface.sdk.bean.req.RegUserInfoReqInfo;
import com.bjleisen.iface.sdk.bean.req.RegisterBusiReqInfo;
import com.bjleisen.iface.sdk.bean.req.ReqInfo;
import com.bjleisen.iface.sdk.bean.req.ReservedField;
import com.bjleisen.iface.sdk.bean.req.SuggestFeedbackBusiReqInfo;
import com.bjleisen.iface.sdk.bean.req.SyncBusiReqInfo;
import com.bjleisen.iface.sdk.bean.req.TransCardRechargeBusiReqInfo;
import com.bjleisen.iface.sdk.bean.req.VertifyMessageBusiReqInfo;
import com.bjleisen.iface.sdk.bean.req.VertifyRemovalCodeBusiReqInfo;
import com.bjleisen.iface.sdk.bean.req.ZytBindingCardBusiReqInfo;
import com.bjleisen.iface.sdk.bean.req.ZytRechargeBusiReqInfo;
import com.bjleisen.iface.sdk.bean.req.ZytSearchTradeBusiReqInfo;
import com.google.gson.e;
import java.util.List;
/* compiled from: AppJsonUtil.java */
/* loaded from: classes.dex */
public final class f {
    public static String a(int i10) {
        ReqInfo reqInfo = new ReqInfo();
        a(reqInfo);
        reqInfo.setBusinessType(i10);
        return new e().s(reqInfo);
    }

    public static String b(String str) {
        ReqInfo reqInfo = new ReqInfo();
        a(reqInfo);
        reqInfo.setBusinessType(20482);
        AbnormalOrderDetailBusiReqInfo abnormalOrderDetailBusiReqInfo = new AbnormalOrderDetailBusiReqInfo();
        abnormalOrderDetailBusiReqInfo.setOrderId(str);
        reqInfo.setBusiReqInfo(abnormalOrderDetailBusiReqInfo);
        return new e().s(reqInfo);
    }

    public static String c(String str) {
        ReqInfo reqInfo = new ReqInfo();
        a(reqInfo);
        reqInfo.setBusinessType(12291);
        PayOrderStatusBusiReqInfo payOrderStatusBusiReqInfo = new PayOrderStatusBusiReqInfo();
        payOrderStatusBusiReqInfo.setOrderId(str);
        reqInfo.setBusiReqInfo(payOrderStatusBusiReqInfo);
        return new e().s(reqInfo);
    }

    public static String d(String str) {
        ReqInfo reqInfo = new ReqInfo();
        a(reqInfo);
        reqInfo.setBusinessType(8193);
        SuggestFeedbackBusiReqInfo suggestFeedbackBusiReqInfo = new SuggestFeedbackBusiReqInfo();
        suggestFeedbackBusiReqInfo.setSuggestMsg(str);
        reqInfo.setBusiReqInfo(suggestFeedbackBusiReqInfo);
        return new e().s(reqInfo);
    }

    public static String e(String str) {
        ReqInfo reqInfo = new ReqInfo();
        a(reqInfo);
        reqInfo.setBusinessType(20488);
        RefundBusiReqInfo refundBusiReqInfo = new RefundBusiReqInfo();
        refundBusiReqInfo.setOrderId(str);
        reqInfo.setBusiReqInfo(refundBusiReqInfo);
        return new e().s(reqInfo);
    }

    public static String a(int i10, String str, String str2, int i11, String str3, int i12, String str4) {
        ReqInfo reqInfo = new ReqInfo();
        a(reqInfo);
        reqInfo.setBusinessType(i10);
        RegUserInfoReqInfo regUserInfoReqInfo = new RegUserInfoReqInfo();
        regUserInfoReqInfo.setPhoneNumber(str);
        regUserInfoReqInfo.setIssueType(i11);
        regUserInfoReqInfo.setUserName(str3);
        regUserInfoReqInfo.setUserIdType(i12);
        regUserInfoReqInfo.setUserId(str4);
        regUserInfoReqInfo.setInstanceAid(str2);
        reqInfo.setBusiReqInfo(regUserInfoReqInfo);
        return new e().s(reqInfo);
    }

    public static String b(String str, int i10) {
        ReqInfo reqInfo = new ReqInfo();
        a(reqInfo);
        reqInfo.setBusinessType(20485);
        QueryInvoiceReqInfo queryInvoiceReqInfo = new QueryInvoiceReqInfo();
        queryInvoiceReqInfo.setOrderId(str);
        queryInvoiceReqInfo.setInvoiceType(i10);
        reqInfo.setBusiReqInfo(queryInvoiceReqInfo);
        return new e().s(reqInfo);
    }

    public static String c(String str, int i10) {
        ReqInfo reqInfo = new ReqInfo();
        a(reqInfo);
        reqInfo.setBusinessType(4099);
        ActionBusiReqInfo actionBusiReqInfo = new ActionBusiReqInfo();
        actionBusiReqInfo.setInstanceAid(str);
        actionBusiReqInfo.setTranStatus(i10);
        reqInfo.setBusiReqInfo(actionBusiReqInfo);
        return new e().s(reqInfo);
    }

    public static String b(String str, String str2, int i10) {
        ReqInfo reqInfo = new ReqInfo();
        a(reqInfo);
        reqInfo.setBusinessType(3);
        AppletDetailBusiReqInfo appletDetailBusiReqInfo = new AppletDetailBusiReqInfo();
        appletDetailBusiReqInfo.setInstanceAid(str);
        appletDetailBusiReqInfo.setAppletVersion(str2);
        appletDetailBusiReqInfo.setTranStatus(i10);
        reqInfo.setBusiReqInfo(appletDetailBusiReqInfo);
        return new e().s(reqInfo);
    }

    public static String c(String str, String str2, int i10) {
        ReqInfo reqInfo = new ReqInfo();
        a(reqInfo);
        reqInfo.setBusinessType(8);
        SyncBusiReqInfo syncBusiReqInfo = new SyncBusiReqInfo();
        syncBusiReqInfo.setAppType(1);
        syncBusiReqInfo.setInstanceAid(str);
        syncBusiReqInfo.setAppletVersion(str2);
        syncBusiReqInfo.setAppStatus(i10);
        reqInfo.setBusiReqInfo(syncBusiReqInfo);
        return new e().s(reqInfo);
    }

    public static String a(String str, String str2, int i10, int i11, String str3, int i12, int i13, String str4) {
        ReqInfo reqInfo = new ReqInfo();
        a(reqInfo);
        reqInfo.setBusinessType(12289);
        PayOrderBusiReqInfo payOrderBusiReqInfo = new PayOrderBusiReqInfo();
        payOrderBusiReqInfo.setInstanceAid(str);
        payOrderBusiReqInfo.setFavouableId(str3);
        payOrderBusiReqInfo.setPayMoney(i10);
        payOrderBusiReqInfo.setPayWay(i12);
        payOrderBusiReqInfo.setCardNo(str2);
        payOrderBusiReqInfo.setTranStatus(i11);
        payOrderBusiReqInfo.setMoneyType(i13);
        payOrderBusiReqInfo.setProductId(null);
        payOrderBusiReqInfo.setOtherOrderInfo(str4);
        reqInfo.setBusiReqInfo(payOrderBusiReqInfo);
        return new e().s(reqInfo);
    }

    public static String b(String str, int i10, String str2) {
        ReqInfo reqInfo = new ReqInfo();
        a(reqInfo);
        reqInfo.setBusinessType(17);
        VertifyMessageBusiReqInfo vertifyMessageBusiReqInfo = new VertifyMessageBusiReqInfo();
        vertifyMessageBusiReqInfo.setVerificationCode(str2);
        vertifyMessageBusiReqInfo.setIssueType(i10);
        vertifyMessageBusiReqInfo.setInstanceAid(str);
        reqInfo.setBusiReqInfo(vertifyMessageBusiReqInfo);
        return new e().s(reqInfo);
    }

    public static String a(String str) {
        ReqInfo reqInfo = new ReqInfo();
        a(reqInfo);
        reqInfo.setBusinessType(4101);
        CardTemplateReqInfo cardTemplateReqInfo = new CardTemplateReqInfo();
        cardTemplateReqInfo.setInstanceAid(str);
        reqInfo.setBusiReqInfo(cardTemplateReqInfo);
        return new e().s(reqInfo);
    }

    public static String b(String str, String str2) {
        ReqInfo reqInfo = new ReqInfo();
        a(reqInfo);
        reqInfo.setBusinessType(20486);
        VertifyRemovalCodeBusiReqInfo vertifyRemovalCodeBusiReqInfo = new VertifyRemovalCodeBusiReqInfo();
        vertifyRemovalCodeBusiReqInfo.setInstanceAid(str);
        vertifyRemovalCodeBusiReqInfo.setRemovalCode(str2);
        reqInfo.setBusiReqInfo(vertifyRemovalCodeBusiReqInfo);
        return new e().s(reqInfo);
    }

    public static String a(String str, int i10) {
        ReqInfo reqInfo = new ReqInfo();
        a(reqInfo);
        reqInfo.setBusinessType(20489);
        CardTemplateReqInfo cardTemplateReqInfo = new CardTemplateReqInfo();
        cardTemplateReqInfo.setInstanceAid(str);
        cardTemplateReqInfo.setType(i10);
        reqInfo.setBusiReqInfo(cardTemplateReqInfo);
        return new e().s(reqInfo);
    }

    public static String a(String str, int i10, String str2) {
        ReqInfo reqInfo = new ReqInfo();
        a(reqInfo);
        reqInfo.setBusinessType(20484);
        ApplyInvoiceReqInfo applyInvoiceReqInfo = new ApplyInvoiceReqInfo();
        applyInvoiceReqInfo.setOrderId(str);
        applyInvoiceReqInfo.setInvoicesType(i10);
        applyInvoiceReqInfo.setInvoicesAddress(str2);
        reqInfo.setBusiReqInfo(applyInvoiceReqInfo);
        return new e().s(reqInfo);
    }

    public static String a(String str, int i10, int i11) {
        ReqInfo reqInfo = new ReqInfo();
        a(reqInfo);
        reqInfo.setBusinessType(20483);
        CompletedOrderBusiReqInfo completedOrderBusiReqInfo = new CompletedOrderBusiReqInfo();
        completedOrderBusiReqInfo.setInstanceAid(str);
        completedOrderBusiReqInfo.setPage(i11);
        completedOrderBusiReqInfo.setRows(i10);
        reqInfo.setBusiReqInfo(completedOrderBusiReqInfo);
        return new e().s(reqInfo);
    }

    public static String a(String str, int i10, int i11, int i12) {
        ReqInfo reqInfo = new ReqInfo();
        a(reqInfo);
        reqInfo.setBusinessType(20487);
        OrderBusiReqInfo orderBusiReqInfo = new OrderBusiReqInfo();
        orderBusiReqInfo.setInstanceAid(str);
        orderBusiReqInfo.setQueryOrderType(i10);
        orderBusiReqInfo.setPage(i12);
        orderBusiReqInfo.setRows(i11);
        reqInfo.setBusiReqInfo(orderBusiReqInfo);
        return new e().s(reqInfo);
    }

    public static String a(String str, String str2, int i10, int i11) {
        ReqInfo reqInfo = new ReqInfo();
        a(reqInfo);
        reqInfo.setBusinessType(12290);
        PayOrderCalculateBusiReqInfo payOrderCalculateBusiReqInfo = new PayOrderCalculateBusiReqInfo();
        payOrderCalculateBusiReqInfo.setAppletVersion(str2);
        payOrderCalculateBusiReqInfo.setInstanceAid(str);
        payOrderCalculateBusiReqInfo.setPayMoney(i10);
        payOrderCalculateBusiReqInfo.setTranStatus(i11);
        reqInfo.setBusiReqInfo(payOrderCalculateBusiReqInfo);
        return new e().s(reqInfo);
    }

    public static String a(String str, String str2, int i10) {
        ReqInfo reqInfo = new ReqInfo();
        a(reqInfo);
        reqInfo.setBusinessType(7);
        OtOperBusiReqInfo otOperBusiReqInfo = new OtOperBusiReqInfo();
        otOperBusiReqInfo.setInstanceAid(str);
        otOperBusiReqInfo.setEuid(str2);
        otOperBusiReqInfo.setCplc(LeisenIfaceConfig.aD);
        otOperBusiReqInfo.setOtType(i10);
        reqInfo.setBusiReqInfo(otOperBusiReqInfo);
        return new e().s(reqInfo);
    }

    public static String a() {
        ReqInfo reqInfo = new ReqInfo();
        a(reqInfo);
        reqInfo.setBusinessType(1);
        RegisterBusiReqInfo registerBusiReqInfo = new RegisterBusiReqInfo();
        registerBusiReqInfo.setCplc(LeisenIfaceConfig.aD);
        registerBusiReqInfo.setUserInfoId(LeisenIfaceConfig.aF);
        reqInfo.setBusiReqInfo(registerBusiReqInfo);
        return new e().s(reqInfo);
    }

    public static String a(int i10, String str, String str2, String str3, String str4, String str5, String str6, ReservedField reservedField) {
        ReqInfo reqInfo = new ReqInfo();
        a(reqInfo);
        reqInfo.setBusinessType(4);
        AppletOperBusiReqInfo appletOperBusiReqInfo = new AppletOperBusiReqInfo();
        appletOperBusiReqInfo.setInstanceAid(str);
        appletOperBusiReqInfo.setOperType(i10);
        appletOperBusiReqInfo.setAppletVersion(str2);
        appletOperBusiReqInfo.setOrderId(str3);
        appletOperBusiReqInfo.setCin(str4);
        appletOperBusiReqInfo.setIin(str5);
        appletOperBusiReqInfo.setRemovalCode(str6);
        appletOperBusiReqInfo.setReservedField(reservedField);
        reqInfo.setBusiReqInfo(appletOperBusiReqInfo);
        return new e().s(reqInfo);
    }

    public static String a(String str, int i10, ReservedField reservedField) {
        ReqInfo reqInfo = new ReqInfo();
        a(reqInfo);
        reqInfo.setBusinessType(5);
        TransCardRechargeBusiReqInfo transCardRechargeBusiReqInfo = new TransCardRechargeBusiReqInfo();
        transCardRechargeBusiReqInfo.setCardNo(null);
        transCardRechargeBusiReqInfo.setType(0);
        transCardRechargeBusiReqInfo.setTranOrderId(str);
        transCardRechargeBusiReqInfo.setCardTradeNo(null);
        transCardRechargeBusiReqInfo.setDealType(i10);
        transCardRechargeBusiReqInfo.setLastTradeRecord(null);
        transCardRechargeBusiReqInfo.setReservedField(reservedField);
        reqInfo.setBusiReqInfo(transCardRechargeBusiReqInfo);
        return new e().s(reqInfo);
    }

    public static String a(String str, List<Rapdu> list) {
        ReqInfo reqInfo = new ReqInfo();
        a(reqInfo);
        reqInfo.setBusinessType(6);
        NextBusiReqInfo nextBusiReqInfo = new NextBusiReqInfo();
        nextBusiReqInfo.setRapdu(list);
        nextBusiReqInfo.setTaskSeqNum(str);
        reqInfo.setBusiReqInfo(nextBusiReqInfo);
        return new e().s(reqInfo);
    }

    public static String a(String str, String str2) {
        ReqInfo reqInfo = new ReqInfo();
        a(reqInfo);
        reqInfo.setBusinessType(9);
        ZytBindingCardBusiReqInfo zytBindingCardBusiReqInfo = new ZytBindingCardBusiReqInfo();
        zytBindingCardBusiReqInfo.setInstanceAid(str);
        zytBindingCardBusiReqInfo.setPin(str2);
        reqInfo.setBusiReqInfo(zytBindingCardBusiReqInfo);
        return new e().s(reqInfo);
    }

    public static String a(String str, String str2, String str3) {
        ReqInfo reqInfo = new ReqInfo();
        a(reqInfo);
        reqInfo.setBusinessType(12292);
        ZytRechargeBusiReqInfo zytRechargeBusiReqInfo = new ZytRechargeBusiReqInfo();
        zytRechargeBusiReqInfo.setInstanceAid(str);
        zytRechargeBusiReqInfo.setCardNo(str2);
        zytRechargeBusiReqInfo.setOrderId(str3);
        reqInfo.setBusiReqInfo(zytRechargeBusiReqInfo);
        return new e().s(reqInfo);
    }

    public static String a(String str, String str2, String str3, String str4, int i10, String str5, String str6, int i11) {
        ReqInfo reqInfo = new ReqInfo();
        a(reqInfo);
        reqInfo.setBusinessType(12293);
        ZytSearchTradeBusiReqInfo zytSearchTradeBusiReqInfo = new ZytSearchTradeBusiReqInfo();
        zytSearchTradeBusiReqInfo.setInstanceAid(str);
        zytSearchTradeBusiReqInfo.setCardNo(str2);
        zytSearchTradeBusiReqInfo.setStartDate(str3);
        zytSearchTradeBusiReqInfo.setEndDate(str4);
        zytSearchTradeBusiReqInfo.setRtning(i10);
        zytSearchTradeBusiReqInfo.setTranDate(str5);
        zytSearchTradeBusiReqInfo.setTranTime(str6);
        zytSearchTradeBusiReqInfo.setRtnindNo(i11);
        reqInfo.setBusiReqInfo(zytSearchTradeBusiReqInfo);
        return new e().s(reqInfo);
    }

    private static void a(ReqInfo<?> reqInfo) {
        reqInfo.setVersion(LeisenIfaceConfig.aw);
        reqInfo.setSeid(LeisenIfaceConfig.aE);
        reqInfo.setAppVersion(LeisenIfaceConfig.ax);
        reqInfo.setImei(LeisenIfaceConfig.ay);
        reqInfo.setPhoneModel(LeisenIfaceConfig.aB);
        reqInfo.setDeviceModel(LeisenIfaceConfig.aG);
        reqInfo.setCallAppPackageName(LeisenIfaceConfig.as);
        reqInfo.setCallAppHash(LeisenIfaceConfig.az);
        reqInfo.setPhoneOsVersion(LeisenIfaceConfig.aA);
        reqInfo.setMsisdn(LeisenIfaceConfig.at);
        reqInfo.setSeTsmId(LeisenIfaceConfig.au);
        reqInfo.setPhoneOsType(LeisenIfaceConfig.av);
        reqInfo.setBasePhoneVersion(LeisenIfaceConfig.aC);
        reqInfo.setUserAccountId(LeisenIfaceConfig.aF);
    }
}
