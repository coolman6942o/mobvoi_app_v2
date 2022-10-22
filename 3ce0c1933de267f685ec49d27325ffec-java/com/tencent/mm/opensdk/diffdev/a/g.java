package com.tencent.mm.opensdk.diffdev.a;

import com.huawei.agconnect.exception.AGCServerException;
/* loaded from: classes2.dex */
public enum g {
    UUID_EXPIRED(402),
    UUID_CANCELED(AGCServerException.AUTHENTICATION_FAILED),
    UUID_SCANED(404),
    UUID_CONFIRM(405),
    UUID_KEEP_CONNECT(408),
    UUID_ERROR(AGCServerException.UNKNOW_EXCEPTION);
    
    private int code;

    g(int i10) {
        this.code = i10;
    }

    public final int getCode() {
        return this.code;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "UUIDStatusCode:" + this.code;
    }
}
