package com.amap.api.mapcore2d;

import android.content.Context;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import k4.g;
import k4.j;
import k4.m;
/* compiled from: Log.java */
/* loaded from: classes.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static final String f6986a = "/a/";

    /* renamed from: b  reason: collision with root package name */
    static final String f6987b = "b";

    /* renamed from: c  reason: collision with root package name */
    static final String f6988c = "c";

    /* renamed from: d  reason: collision with root package name */
    static final String f6989d = "d";

    /* compiled from: Log.java */
    /* loaded from: classes.dex */
    static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f6990a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f6991b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Throwable f6992c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f6993d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f6994e;

        a(Context context, int i10, Throwable th2, String str, String str2) {
            this.f6990a = context;
            this.f6991b = i10;
            this.f6992c = th2;
            this.f6993d = str;
            this.f6994e = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                m a10 = h.a(this.f6990a, this.f6991b);
                if (a10 != null) {
                    a10.f(this.f6990a, this.f6992c, this.f6993d, this.f6994e);
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    static m a(Context context, int i10) {
        if (i10 == 0) {
            return new k(i10);
        }
        if (i10 == 1) {
            return new l(i10);
        }
        if (i10 != 2) {
            return null;
        }
        return new j(i10);
    }

    public static Class<? extends m> b(int i10) {
        if (i10 == 0) {
            return k4.h.class;
        }
        if (i10 == 1) {
            return j.class;
        }
        if (i10 != 2) {
            return null;
        }
        return g.class;
    }

    public static String c(Context context, String str) {
        return context.getFilesDir().getAbsolutePath() + f6986a + str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(Context context, Throwable th2, int i10, String str, String str2) {
        try {
            ExecutorService d10 = i.d();
            if (d10 != null && !d10.isShutdown()) {
                d10.submit(new a(context, i10, th2, str, str2));
            }
        } catch (RejectedExecutionException unused) {
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
    }

    public static m e(int i10) {
        if (i10 == 0) {
            return new k4.h();
        }
        if (i10 == 1) {
            return new j();
        }
        if (i10 != 2) {
            return null;
        }
        return new g();
    }

    public static String f(int i10) {
        if (i10 == 0) {
            return f6988c;
        }
        if (i10 != 1) {
            return i10 != 2 ? "" : f6989d;
        }
        return f6987b;
    }
}
