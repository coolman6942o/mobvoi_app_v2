package androidx.work;

import android.util.Log;
/* compiled from: Logger.java */
/* loaded from: classes.dex */
public abstract class k {

    /* renamed from: a  reason: collision with root package name */
    private static k f4890a = null;

    /* renamed from: b  reason: collision with root package name */
    private static final int f4891b = 20;

    /* compiled from: Logger.java */
    /* loaded from: classes.dex */
    public static class a extends k {

        /* renamed from: c  reason: collision with root package name */
        private int f4892c;

        public a(int i10) {
            super(i10);
            this.f4892c = i10;
        }

        @Override // androidx.work.k
        public void a(String str, String str2, Throwable... thArr) {
            if (this.f4892c > 3) {
                return;
            }
            if (thArr == null || thArr.length < 1) {
                Log.d(str, str2);
            } else {
                Log.d(str, str2, thArr[0]);
            }
        }

        @Override // androidx.work.k
        public void b(String str, String str2, Throwable... thArr) {
            if (this.f4892c > 6) {
                return;
            }
            if (thArr == null || thArr.length < 1) {
                Log.e(str, str2);
            } else {
                Log.e(str, str2, thArr[0]);
            }
        }

        @Override // androidx.work.k
        public void d(String str, String str2, Throwable... thArr) {
            if (this.f4892c > 4) {
                return;
            }
            if (thArr == null || thArr.length < 1) {
                Log.i(str, str2);
            } else {
                Log.i(str, str2, thArr[0]);
            }
        }

        @Override // androidx.work.k
        public void g(String str, String str2, Throwable... thArr) {
            if (this.f4892c > 2) {
                return;
            }
            if (thArr == null || thArr.length < 1) {
                Log.v(str, str2);
            } else {
                Log.v(str, str2, thArr[0]);
            }
        }

        @Override // androidx.work.k
        public void h(String str, String str2, Throwable... thArr) {
            if (this.f4892c > 5) {
                return;
            }
            if (thArr == null || thArr.length < 1) {
                Log.w(str, str2);
            } else {
                Log.w(str, str2, thArr[0]);
            }
        }
    }

    public k(int i10) {
    }

    public static synchronized k c() {
        k kVar;
        synchronized (k.class) {
            if (f4890a == null) {
                f4890a = new a(3);
            }
            kVar = f4890a;
        }
        return kVar;
    }

    public static synchronized void e(k kVar) {
        synchronized (k.class) {
            f4890a = kVar;
        }
    }

    public static String f(String str) {
        int length = str.length();
        StringBuilder sb2 = new StringBuilder(23);
        sb2.append("WM-");
        int i10 = f4891b;
        if (length >= i10) {
            sb2.append(str.substring(0, i10));
        } else {
            sb2.append(str);
        }
        return sb2.toString();
    }

    public abstract void a(String str, String str2, Throwable... thArr);

    public abstract void b(String str, String str2, Throwable... thArr);

    public abstract void d(String str, String str2, Throwable... thArr);

    public abstract void g(String str, String str2, Throwable... thArr);

    public abstract void h(String str, String str2, Throwable... thArr);
}
