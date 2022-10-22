package com.google.protobuf;

import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Objects;
/* compiled from: Internal.java */
/* loaded from: classes.dex */
public final class u {

    /* renamed from: a  reason: collision with root package name */
    static final Charset f13364a = Charset.forName("UTF-8");

    /* renamed from: b  reason: collision with root package name */
    static final Charset f13365b = Charset.forName("ISO-8859-1");

    /* renamed from: c  reason: collision with root package name */
    public static final byte[] f13366c;

    /* compiled from: Internal.java */
    /* loaded from: classes.dex */
    public interface a {
        int getNumber();
    }

    /* compiled from: Internal.java */
    /* loaded from: classes.dex */
    public interface b<T extends a> {
    }

    static {
        byte[] bArr = new byte[0];
        f13366c = bArr;
        ByteBuffer.wrap(bArr);
        i.g(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T a(T t10, String str) {
        Objects.requireNonNull(t10, str);
        return t10;
    }

    public static <T extends e0> T b(Class<T> cls) {
        try {
            Method method = cls.getMethod("getDefaultInstance", new Class[0]);
            return (T) method.invoke(method, new Object[0]);
        } catch (Exception e10) {
            throw new RuntimeException("Failed to get default instance for " + cls, e10);
        }
    }

    public static int c(boolean z10) {
        return z10 ? 1231 : 1237;
    }

    public static int d(byte[] bArr) {
        return e(bArr, 0, bArr.length);
    }

    static int e(byte[] bArr, int i10, int i11) {
        int j10 = j(i11, bArr, i10, i11);
        if (j10 == 0) {
            return 1;
        }
        return j10;
    }

    public static int f(a aVar) {
        return aVar.getNumber();
    }

    public static int g(List<? extends a> list) {
        int i10 = 1;
        for (a aVar : list) {
            i10 = (i10 * 31) + f(aVar);
        }
        return i10;
    }

    public static int h(long j10) {
        return (int) (j10 ^ (j10 >>> 32));
    }

    public static boolean i(byte[] bArr) {
        return d1.l(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int j(int i10, byte[] bArr, int i11, int i12) {
        for (int i13 = i11; i13 < i11 + i12; i13++) {
            i10 = (i10 * 31) + bArr[i13];
        }
        return i10;
    }

    public static String k(byte[] bArr) {
        return new String(bArr, f13364a);
    }
}
