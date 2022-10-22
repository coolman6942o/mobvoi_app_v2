package com.tendcloud.tenddata;

import android.util.EventLogTags;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
/* compiled from: td */
/* loaded from: classes2.dex */
public final class al {

    /* renamed from: a  reason: collision with root package name */
    private static byte[] f22618a = new byte[0];

    /* renamed from: b  reason: collision with root package name */
    private static volatile int f22619b;

    /* renamed from: c  reason: collision with root package name */
    private static volatile IvParameterSpec f22620c;

    /* renamed from: d  reason: collision with root package name */
    private static volatile byte[] f22621d;

    /* renamed from: e  reason: collision with root package name */
    private static volatile SecretKey f22622e;

    static {
        synchronized (EventLogTags.class) {
            try {
                if (f22619b == 0) {
                    f22619b = aq.a();
                }
                if (f22620c == null) {
                    f22620c = an.a();
                }
                if (f22621d == null) {
                    f22621d = an.b();
                }
                if (f22622e == null) {
                    f22622e = an.a(String.valueOf(f22619b).toCharArray(), f22621d);
                }
            } catch (Throwable unused) {
            }
        }
    }

    private al() {
    }

    public static byte[] a(byte[] bArr) {
        try {
            return an.a(bArr, f22622e, f22620c);
        } catch (Throwable th2) {
            bf.postSDKError(th2);
            return f22618a;
        }
    }

    public static byte[] b(byte[] bArr) {
        try {
            return an.b(bArr, f22622e, f22620c);
        } catch (Throwable th2) {
            bf.postSDKError(th2);
            return f22618a;
        }
    }
}
