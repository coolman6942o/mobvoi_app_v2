package com.alipay.sdk.app;

import com.amap.api.services.core.AMapException;
/* loaded from: classes.dex */
public enum c {
    SUCCEEDED(9000, "处理成功"),
    FAILED(AMapException.CODE_AMAP_SHARE_LICENSE_IS_EXPIRED, "系统繁忙，请稍后再试"),
    CANCELED(6001, "用户取消"),
    NETWORK_ERROR(6002, "网络连接异常"),
    PARAMS_ERROR(AMapException.CODE_AMAP_SHARE_FAILURE, "参数错误"),
    DOUBLE_REQUEST(5000, "重复请求"),
    PAY_WAITTING(8000, "支付结果确认中");
    

    /* renamed from: a  reason: collision with root package name */
    public int f6905a;

    /* renamed from: b  reason: collision with root package name */
    public String f6906b;

    c(int i10, String str) {
        this.f6905a = i10;
        this.f6906b = str;
    }

    public void a(int i10) {
        this.f6905a = i10;
    }

    public int b() {
        return this.f6905a;
    }

    public static c b(int i10) {
        if (i10 == 4001) {
            return PARAMS_ERROR;
        }
        if (i10 == 5000) {
            return DOUBLE_REQUEST;
        }
        if (i10 == 8000) {
            return PAY_WAITTING;
        }
        if (i10 == 9000) {
            return SUCCEEDED;
        }
        if (i10 == 6001) {
            return CANCELED;
        }
        if (i10 != 6002) {
            return FAILED;
        }
        return NETWORK_ERROR;
    }

    public void a(String str) {
        this.f6906b = str;
    }

    public String a() {
        return this.f6906b;
    }
}
