package com.google.android.gms.internal.measurement;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.util.Log;
import androidx.core.content.c;
/* loaded from: classes.dex */
public abstract class v6<T> {

    /* renamed from: f */
    private static final Object f9755f = new Object();
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: g */
    private static Context f9756g;

    /* renamed from: h */
    private static volatile Boolean f9757h;

    /* renamed from: a */
    private final f7 f9758a;

    /* renamed from: b */
    final String f9759b;

    /* renamed from: c */
    private final String f9760c;

    /* renamed from: d */
    private final T f9761d;

    /* renamed from: e */
    private volatile s6 f9762e;

    private v6(f7 f7Var, String str, T t10) {
        Uri uri;
        String str2;
        String str3;
        this.f9762e = null;
        uri = f7Var.f9279a;
        if (uri != null) {
            this.f9758a = f7Var;
            str2 = f7Var.f9280b;
            String valueOf = String.valueOf(str2);
            String valueOf2 = String.valueOf(str);
            this.f9760c = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
            str3 = f7Var.f9281c;
            String valueOf3 = String.valueOf(str3);
            String valueOf4 = String.valueOf(str);
            this.f9759b = valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3);
            this.f9761d = t10;
            return;
        }
        throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
    }

    public /* synthetic */ v6(f7 f7Var, String str, Object obj, z6 z6Var) {
        this(f7Var, str, obj);
    }

    public static void b(Context context) {
        Context applicationContext;
        synchronized (f9755f) {
            if ((Build.VERSION.SDK_INT < 24 || !context.isDeviceProtectedStorage()) && (applicationContext = context.getApplicationContext()) != null) {
                context = applicationContext;
            }
            if (f9756g != context) {
                f9757h = null;
            }
            f9756g = context;
        }
    }

    public static v6<Double> c(f7 f7Var, String str, double d10) {
        return new c7(f7Var, str, Double.valueOf(d10));
    }

    public static v6<Integer> d(f7 f7Var, String str, int i10) {
        return new a7(f7Var, str, Integer.valueOf(i10));
    }

    public static v6<Long> e(f7 f7Var, String str, long j10) {
        return new z6(f7Var, str, Long.valueOf(j10));
    }

    public static v6<String> f(f7 f7Var, String str, String str2) {
        return new d7(f7Var, str, str2);
    }

    public static v6<Boolean> g(f7 f7Var, String str, boolean z10) {
        return new b7(f7Var, str, Boolean.valueOf(z10));
    }

    private static <V> V h(e7<V> e7Var) {
        try {
            return e7Var.a();
        } catch (SecurityException unused) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                return e7Var.a();
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
    }

    public static boolean n(String str, boolean z10) {
        try {
            if (s()) {
                return ((Boolean) h(new e7(str, false) { // from class: com.google.android.gms.internal.measurement.y6

                    /* renamed from: a  reason: collision with root package name */
                    private final String f9824a;

                    /* renamed from: b  reason: collision with root package name */
                    private final boolean f9825b = false;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.f9824a = str;
                    }

                    @Override // com.google.android.gms.internal.measurement.e7
                    public final Object a() {
                        Boolean valueOf;
                        valueOf = Boolean.valueOf(q6.f(v6.f9756g.getContentResolver(), this.f9824a, this.f9825b));
                        return valueOf;
                    }
                })).booleanValue();
            }
            return false;
        } catch (SecurityException e10) {
            Log.e("PhenotypeFlag", "Unable to read GServices, returning default value.", e10);
            return false;
        }
    }

    @TargetApi(24)
    private final T q() {
        Uri uri;
        Uri uri2;
        if (!n("gms:phenotype:phenotype_flag:debug_bypass_phenotype", false)) {
            uri = this.f9758a.f9279a;
            if (uri == null) {
                return null;
            }
            if (this.f9762e == null) {
                ContentResolver contentResolver = f9756g.getContentResolver();
                uri2 = this.f9758a.f9279a;
                this.f9762e = s6.a(contentResolver, uri2);
            }
            String str = (String) h(new e7(this, this.f9762e) { // from class: com.google.android.gms.internal.measurement.w6

                /* renamed from: a  reason: collision with root package name */
                private final v6 f9784a;

                /* renamed from: b  reason: collision with root package name */
                private final s6 f9785b;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f9784a = this;
                    this.f9785b = r2;
                }

                @Override // com.google.android.gms.internal.measurement.e7
                public final Object a() {
                    return this.f9785b.c().get(this.f9784a.f9759b);
                }
            });
            if (str != null) {
                return p(str);
            }
            return null;
        }
        String valueOf = String.valueOf(this.f9759b);
        Log.w("PhenotypeFlag", valueOf.length() != 0 ? "Bypass reading Phenotype values for flag: ".concat(valueOf) : new String("Bypass reading Phenotype values for flag: "));
        return null;
    }

    private final T r() {
        if (!s()) {
            return null;
        }
        try {
            String str = (String) h(new e7(this) { // from class: com.google.android.gms.internal.measurement.x6

                /* renamed from: a  reason: collision with root package name */
                private final v6 f9806a;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    this.f9806a = this;
                }

                @Override // com.google.android.gms.internal.measurement.e7
                public final Object a() {
                    return this.f9806a.t();
                }
            });
            if (str != null) {
                return p(str);
            }
            return null;
        } catch (SecurityException e10) {
            String valueOf = String.valueOf(this.f9759b);
            Log.e("PhenotypeFlag", valueOf.length() != 0 ? "Unable to read GServices for flag: ".concat(valueOf) : new String("Unable to read GServices for flag: "), e10);
            return null;
        }
    }

    private static boolean s() {
        if (f9757h == null) {
            Context context = f9756g;
            boolean z10 = false;
            if (context == null) {
                return false;
            }
            if (c.a(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0) {
                z10 = true;
            }
            f9757h = Boolean.valueOf(z10);
        }
        return f9757h.booleanValue();
    }

    public final T a() {
        if (f9756g != null) {
            T q5 = q();
            if (q5 != null) {
                return q5;
            }
            T r10 = r();
            return r10 != null ? r10 : this.f9761d;
        }
        throw new IllegalStateException("Must call PhenotypeFlag.init() first");
    }

    protected abstract T p(String str);

    public final /* synthetic */ String t() {
        return q6.b(f9756g.getContentResolver(), this.f9760c, null);
    }
}
