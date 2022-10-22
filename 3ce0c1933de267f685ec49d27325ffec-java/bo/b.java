package bo;

import java.util.Objects;
import zn.d;
/* compiled from: ObjectHelper.java */
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    static final d<Object, Object> f5393a = new a();

    /* compiled from: ObjectHelper.java */
    /* loaded from: classes2.dex */
    static final class a implements d<Object, Object> {
        a() {
        }

        @Override // zn.d
        public boolean test(Object obj, Object obj2) {
            return b.c(obj, obj2);
        }
    }

    public static int a(int i10, int i11) {
        if (i10 < i11) {
            return -1;
        }
        return i10 > i11 ? 1 : 0;
    }

    public static int b(long j10, long j11) {
        int i10 = (j10 > j11 ? 1 : (j10 == j11 ? 0 : -1));
        if (i10 < 0) {
            return -1;
        }
        return i10 > 0 ? 1 : 0;
    }

    public static boolean c(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static <T> d<T, T> d() {
        return (d<T, T>) f5393a;
    }

    public static <T> T e(T t10, String str) {
        Objects.requireNonNull(t10, str);
        return t10;
    }

    public static int f(int i10, String str) {
        if (i10 > 0) {
            return i10;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + i10);
    }

    public static long g(long j10, String str) {
        if (j10 > 0) {
            return j10;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + j10);
    }
}
