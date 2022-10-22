package com.cardiex.arty.lite.exceptions;

import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import software.tingle.api.c;
/* compiled from: ApiException.kt */
/* loaded from: classes.dex */
public final class APIException extends ArtyException {
    public APIException() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ APIException(c cVar, Integer num, String str, String str2, Throwable th2, int i10, f fVar) {
        this(r11, (i10 & 2) != 0 ? 0 : num, (i10 & 4) != 0 ? r11 == null ? null : r11.a() : str, (i10 & 8) != 0 ? r11 == null ? null : r11.b() : str2, (i10 & 16) != 0 ? null : th2);
        c cVar2 = (i10 & 1) != 0 ? null : cVar;
    }

    public APIException(c cVar, Integer num, String str, String str2, Throwable th2) {
        super(cVar, num, str, th2, str2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public APIException(Throwable throwable) {
        this(null, null, null, throwable.getMessage(), throwable, 7, null);
        i.f(throwable, "throwable");
    }
}
