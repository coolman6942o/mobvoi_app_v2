package com.cardiex.arty.lite;

import kotlin.jvm.internal.f;
import kotlin.text.t;
/* compiled from: AuthTokenValidator.kt */
/* loaded from: classes.dex */
public final class AuthTokenValidator {
    public static final Companion Companion = new Companion(null);
    private static final AuthTokenValidator SHARED = new AuthTokenValidator();

    /* compiled from: AuthTokenValidator.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public final AuthTokenValidator get$lite_release() {
            return AuthTokenValidator.SHARED;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0010 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String requireValid(String str) {
        boolean z10;
        boolean s10;
        if (str != null) {
            s10 = t.s(str);
            if (!s10) {
                z10 = false;
                if (!(true ^ z10)) {
                    return str;
                }
                throw new IllegalArgumentException("Invalid access token: You must use a valid access token  to make an Arty API request. ".toString());
            }
        }
        z10 = true;
        if (!(true ^ z10)) {
        }
    }
}
