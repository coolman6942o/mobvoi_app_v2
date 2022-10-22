package com.cardiex.arty.lite.exceptions;

import com.huawei.agconnect.exception.AGCServerException;
import kotlin.jvm.internal.i;
import software.tingle.api.c;
/* compiled from: AuthenticationException.kt */
/* loaded from: classes.dex */
public final class AuthenticationException extends ArtyException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AuthenticationException(c problem) {
        super(problem, Integer.valueOf((int) AGCServerException.TOKEN_INVALID), null, null, null, 28, null);
        i.f(problem, "problem");
    }
}
