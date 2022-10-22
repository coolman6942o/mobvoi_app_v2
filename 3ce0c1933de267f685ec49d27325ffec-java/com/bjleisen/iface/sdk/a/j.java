package com.bjleisen.iface.sdk.a;

import java.io.UnsupportedEncodingException;
/* compiled from: SimpleResponseHandler.java */
/* loaded from: classes.dex */
public abstract class j extends d {
    public abstract void a(String str, Throwable th2);

    @Override // com.bjleisen.iface.sdk.a.d
    public final void a(byte[] bArr) {
        d(a(bArr, m()));
    }

    public abstract void d(String str);

    @Override // com.bjleisen.iface.sdk.a.d
    public final void a(byte[] bArr, Throwable th2) {
        a(a(bArr, m()), th2);
    }

    private static String a(byte[] bArr, String str) {
        if (bArr == null) {
            return null;
        }
        try {
            return new String(bArr, str);
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }
}
