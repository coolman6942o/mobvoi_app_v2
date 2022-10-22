package com.cardiex.arty.lite.exceptions;

import com.cardiex.arty.lite.exceptions.APIConnectionException;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import kotlin.collections.m;
import kotlin.collections.u;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import org.json.JSONException;
import software.tingle.api.c;
/* compiled from: ArtyException.kt */
/* loaded from: classes.dex */
public abstract class ArtyException extends Exception {
    public static final Companion Companion = new Companion(null);
    private final String errorCode;
    private final c problem;
    private final Integer statusCode;

    /* compiled from: ArtyException.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final ArtyException create(Throwable throwable) {
            APIException aPIException;
            i.f(throwable, "throwable");
            if (throwable instanceof ArtyException) {
                return (ArtyException) throwable;
            }
            if (throwable instanceof JSONException) {
                aPIException = new APIException(throwable);
            } else if (throwable instanceof IOException) {
                return APIConnectionException.Companion.create$lite_release$default(APIConnectionException.Companion, (IOException) throwable, null, 2, null);
            } else {
                aPIException = new APIException(throwable);
            }
            return aPIException;
        }
    }

    public ArtyException() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ ArtyException(c cVar, Integer num, String str, Throwable th2, String str2, int i10, f fVar) {
        this(r11, (i10 & 2) != 0 ? 0 : num, (i10 & 4) != 0 ? r11 == null ? null : r11.a() : str, (i10 & 8) != 0 ? null : th2, (i10 & 16) != 0 ? r11 == null ? null : r11.b() : str2);
        c cVar2 = (i10 & 1) != 0 ? null : cVar;
    }

    private final boolean typedEquals(ArtyException artyException) {
        return i.b(this.problem, artyException.problem) && i.b(this.statusCode, artyException.statusCode) && i.b(this.errorCode, artyException.errorCode) && i.b(getMessage(), artyException.getMessage());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ArtyException) {
            return typedEquals((ArtyException) obj);
        }
        return false;
    }

    public final String getErrorCode() {
        return this.errorCode;
    }

    public final c getProblem() {
        return this.problem;
    }

    public final Integer getStatusCode() {
        return this.statusCode;
    }

    public int hashCode() {
        return Objects.hash(this.problem, this.statusCode, this.errorCode, getMessage());
    }

    @Override // java.lang.Throwable
    public String toString() {
        List k10;
        String K;
        k10 = m.k(i.n("Response code: ", this.statusCode), i.n("Error Code: ", this.errorCode), String.valueOf(getMessage()), super.toString());
        K = u.K(k10, "\n", null, null, 0, null, null, 62, null);
        return K;
    }

    public ArtyException(c cVar, Integer num, String str, Throwable th2, String str2) {
        super(str2, th2);
        this.problem = cVar;
        this.statusCode = num;
        this.errorCode = str;
    }
}
