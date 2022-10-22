package com.cardiex.arty.lite.exceptions;

import java.io.IOException;
import java.util.List;
import kotlin.collections.m;
import kotlin.collections.u;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.text.t;
/* compiled from: ApiConnectionException.kt */
/* loaded from: classes.dex */
public final class APIConnectionException extends ArtyException {
    public static final Companion Companion = new Companion(null);

    /* compiled from: ApiConnectionException.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public static /* synthetic */ APIConnectionException create$lite_release$default(Companion companion, IOException iOException, String str, int i10, Object obj) {
            if ((i10 & 2) != 0) {
                str = null;
            }
            return companion.create$lite_release(iOException, str);
        }

        /* JADX WARN: Code restructure failed: missing block: B:5:0x002a, code lost:
            if (r15 != false) goto L6;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final /* synthetic */ APIConnectionException create$lite_release(IOException e10, String str) {
            List k10;
            String K;
            boolean s10;
            i.f(e10, "e");
            String[] strArr = new String[2];
            boolean z10 = false;
            strArr[0] = "ARTY";
            StringBuilder sb2 = new StringBuilder();
            sb2.append('(');
            sb2.append((Object) str);
            sb2.append(')');
            String sb3 = sb2.toString();
            if (str != null) {
                s10 = t.s(str);
            }
            z10 = true;
            if (z10) {
                sb3 = null;
            }
            strArr[1] = sb3;
            k10 = m.k(strArr);
            K = u.K(k10, " ", null, null, 0, null, null, 62, null);
            return new APIConnectionException("IOException during API request to " + K + ": " + ((Object) e10.getMessage()) + ". Please check your internet connection and try again. ", e10);
        }
    }

    public APIConnectionException() {
        this(null, null, 3, null);
    }

    public /* synthetic */ APIConnectionException(String str, Throwable th2, int i10, f fVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : th2);
    }

    public APIConnectionException(String str, Throwable th2) {
        super(null, null, null, th2, str, 7, null);
    }
}
