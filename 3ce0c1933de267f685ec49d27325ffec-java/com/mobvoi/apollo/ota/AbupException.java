package com.mobvoi.apollo.ota;

import kotlin.jvm.internal.i;
/* compiled from: AbupService.kt */
/* loaded from: classes2.dex */
public final class AbupException extends Exception {
    private final int code;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbupException(int i10, String msg) {
        super(msg);
        i.f(msg, "msg");
        this.code = i10;
    }

    public final int getCode() {
        return this.code;
    }
}
