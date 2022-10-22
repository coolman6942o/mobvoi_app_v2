package com.laser.tsm.sdk.util;

import com.google.gson.e;
import com.laser.tsm.sdk.AppConfig;
import com.laser.tsm.sdk.business.ActivateAppletBusinessForReq;
import com.laser.tsm.sdk.business.ApduResBean;
import com.laser.tsm.sdk.business.AppletListBusinessForReq;
import com.laser.tsm.sdk.business.AppletOperBusinessForReq;
import com.laser.tsm.sdk.business.BaseBusinessForReq;
import com.laser.tsm.sdk.business.BaseBusinessForReqNext;
import com.laser.tsm.sdk.business.BaseRequest;
import com.laser.tsm.sdk.business.GPACOperBusinessForReq;
import com.laser.tsm.sdk.business.SEStateOperBusinessForReq;
import com.laser.tsm.sdk.business.SSDOperBusinessForReq;
/* loaded from: classes2.dex */
public class AppJsonUtil {
    private static void fillBaseData(BaseRequest<?> baseRequest) {
        baseRequest.setClientVersion(AppConfig.CLIENTVERSION);
        baseRequest.setImei(AppConfig.IMEI);
        baseRequest.setMobileType(AppConfig.MOBILETYPE);
        baseRequest.setVersion("1.0");
        baseRequest.setCplc(AppConfig.CPLC);
        baseRequest.setSeid(AppConfig.SEID);
    }

    public static String getActivateAppletJsonResult(int i10, String str, int i11) {
        BaseRequest baseRequest = new BaseRequest();
        fillBaseData(baseRequest);
        ActivateAppletBusinessForReq activateAppletBusinessForReq = new ActivateAppletBusinessForReq();
        activateAppletBusinessForReq.setType(i10);
        activateAppletBusinessForReq.setAppAid(str);
        activateAppletBusinessForReq.setTaskIndex(i11);
        baseRequest.setBusiness(activateAppletBusinessForReq);
        return new e().s(baseRequest);
    }

    public static String getAppletListReqInfo(int i10, int i11, int i12, int i13, int i14) {
        BaseRequest baseRequest = new BaseRequest();
        fillBaseData(baseRequest);
        AppletListBusinessForReq appletListBusinessForReq = new AppletListBusinessForReq();
        appletListBusinessForReq.setType(i10);
        appletListBusinessForReq.setAppType(i11);
        appletListBusinessForReq.setOsType(i12);
        appletListBusinessForReq.setPageSize(i13);
        appletListBusinessForReq.setPageNumber(i14);
        baseRequest.setBusiness(appletListBusinessForReq);
        return new e().s(baseRequest);
    }

    public static String getBaseReqInfo(int i10) {
        BaseRequest baseRequest = new BaseRequest();
        fillBaseData(baseRequest);
        BaseBusinessForReq baseBusinessForReq = new BaseBusinessForReq();
        baseBusinessForReq.setType(i10);
        baseRequest.setBusiness(baseBusinessForReq);
        return new e().s(baseRequest);
    }

    public static String getBaseReqJsonResult(int i10, int i11) {
        BaseRequest baseRequest = new BaseRequest();
        fillBaseData(baseRequest);
        BaseBusinessForReq baseBusinessForReq = new BaseBusinessForReq();
        baseBusinessForReq.setType(i10);
        baseBusinessForReq.setTaskIndex(i11);
        baseRequest.setBusiness(baseBusinessForReq);
        return new e().s(baseRequest);
    }

    public static String getOperAppletJsonResult(int i10, int i11, String str, String str2, int i12) {
        BaseRequest baseRequest = new BaseRequest();
        fillBaseData(baseRequest);
        AppletOperBusinessForReq appletOperBusinessForReq = new AppletOperBusinessForReq();
        appletOperBusinessForReq.setType(i10);
        appletOperBusinessForReq.setAppAid(str);
        appletOperBusinessForReq.setAppletVersion(str2);
        appletOperBusinessForReq.setOperType(i11);
        appletOperBusinessForReq.setTaskIndex(i12);
        baseRequest.setBusiness(appletOperBusinessForReq);
        return new e().s(baseRequest);
    }

    public static String getOperGPACJsonResult(int i10, int i11, String str, int i12) {
        BaseRequest baseRequest = new BaseRequest();
        fillBaseData(baseRequest);
        GPACOperBusinessForReq gPACOperBusinessForReq = new GPACOperBusinessForReq();
        gPACOperBusinessForReq.setType(i10);
        gPACOperBusinessForReq.setAppAid(str);
        gPACOperBusinessForReq.setOperType(i11);
        gPACOperBusinessForReq.setTaskIndex(i12);
        baseRequest.setBusiness(gPACOperBusinessForReq);
        return new e().s(baseRequest);
    }

    public static String getOperSSDJsonResult(int i10, int i11, String str, String str2, String str3, int i12) {
        BaseRequest baseRequest = new BaseRequest();
        fillBaseData(baseRequest);
        SSDOperBusinessForReq sSDOperBusinessForReq = new SSDOperBusinessForReq();
        sSDOperBusinessForReq.setType(i10);
        sSDOperBusinessForReq.setSsdAid(str);
        sSDOperBusinessForReq.setOperType(i11);
        sSDOperBusinessForReq.setCin(str2);
        sSDOperBusinessForReq.setIin(str3);
        sSDOperBusinessForReq.setTaskIndex(i12);
        baseRequest.setBusiness(sSDOperBusinessForReq);
        return new e().s(baseRequest);
    }

    public static String getReqNextJsonResult(int i10, ApduResBean apduResBean, int i11, int i12) {
        BaseRequest baseRequest = new BaseRequest();
        fillBaseData(baseRequest);
        BaseBusinessForReqNext baseBusinessForReqNext = new BaseBusinessForReqNext();
        baseBusinessForReqNext.setType(i10);
        baseBusinessForReqNext.setRapduList(apduResBean);
        baseBusinessForReqNext.setResult(i11);
        baseBusinessForReqNext.setTaskIndex(i12);
        baseRequest.setBusiness(baseBusinessForReqNext);
        return new e().s(baseRequest);
    }

    public static String getSEStateOperReqInfo(int i10, int i11) {
        BaseRequest baseRequest = new BaseRequest();
        fillBaseData(baseRequest);
        SEStateOperBusinessForReq sEStateOperBusinessForReq = new SEStateOperBusinessForReq();
        sEStateOperBusinessForReq.setType(i10);
        sEStateOperBusinessForReq.setOperType(i11);
        baseRequest.setBusiness(sEStateOperBusinessForReq);
        return new e().s(baseRequest);
    }
}
