package com.amap.api.services.a;

import android.content.Context;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import n4.f;
import n4.i;
import n4.l;
/* compiled from: Log.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static final String f7190a = "/a/";

    /* renamed from: b  reason: collision with root package name */
    static final String f7191b = "b";

    /* renamed from: c  reason: collision with root package name */
    static final String f7192c = "c";

    /* renamed from: d  reason: collision with root package name */
    static final String f7193d = "d";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Log.java */
    /* loaded from: classes.dex */
    public static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f7194a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f7195b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Throwable f7196c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f7197d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f7198e;

        a(Context context, int i10, Throwable th2, String str, String str2) {
            this.f7194a = context;
            this.f7195b = i10;
            this.f7196c = th2;
            this.f7197d = str;
            this.f7198e = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                l a10 = g.a(this.f7194a, this.f7195b);
                if (a10 != null) {
                    a10.f(this.f7194a, this.f7196c, this.f7197d, this.f7198e);
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    static l a(Context context, int i10) {
        if (i10 == 0) {
            return new j(i10);
        }
        if (i10 == 1) {
            return new k(i10);
        }
        if (i10 != 2) {
            return null;
        }
        return new i(i10);
    }

    public static Class<? extends l> b(int i10) {
        if (i10 == 0) {
            return n4.g.class;
        }
        if (i10 == 1) {
            return i.class;
        }
        if (i10 != 2) {
            return null;
        }
        return f.class;
    }

    public static String c(Context context, String str) {
        return context.getFilesDir().getAbsolutePath() + f7190a + str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(Context context, Throwable th2, int i10, String str, String str2) {
        try {
            ExecutorService d10 = h.d();
            if (d10 != null && !d10.isShutdown()) {
                d10.submit(new a(context, i10, th2, str, str2));
            }
        } catch (RejectedExecutionException unused) {
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
    }

    public static l e(int i10) {
        if (i10 == 0) {
            return new n4.g();
        }
        if (i10 == 1) {
            return new i();
        }
        if (i10 != 2) {
            return null;
        }
        return new f();
    }

    public static String f(int i10) {
        if (i10 == 0) {
            return f7192c;
        }
        if (i10 != 1) {
            return i10 != 2 ? "" : f7193d;
        }
        return f7191b;
    }
}
