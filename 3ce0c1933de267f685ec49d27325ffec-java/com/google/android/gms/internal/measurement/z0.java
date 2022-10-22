package com.google.android.gms.internal.measurement;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import b6.i;
import com.google.android.gms.measurement.AppMeasurement;
/* loaded from: classes.dex */
public final class z0 extends z2 {

    /* renamed from: e  reason: collision with root package name */
    private String f9828e;

    /* renamed from: c  reason: collision with root package name */
    private char f9826c = 0;

    /* renamed from: d  reason: collision with root package name */
    private long f9827d = -1;

    /* renamed from: f  reason: collision with root package name */
    private final b1 f9829f = new b1(this, 6, false, false);

    /* renamed from: g  reason: collision with root package name */
    private final b1 f9830g = new b1(this, 6, true, false);

    /* renamed from: h  reason: collision with root package name */
    private final b1 f9831h = new b1(this, 6, false, true);

    /* renamed from: i  reason: collision with root package name */
    private final b1 f9832i = new b1(this, 5, false, false);

    /* renamed from: j  reason: collision with root package name */
    private final b1 f9833j = new b1(this, 5, false, true);

    /* renamed from: k  reason: collision with root package name */
    private final b1 f9834k = new b1(this, 4, false, false);

    /* renamed from: l  reason: collision with root package name */
    private final b1 f9835l = new b1(this, 3, false, false);

    /* renamed from: m  reason: collision with root package name */
    private final b1 f9836m = new b1(this, 2, false, false);

    /* JADX INFO: Access modifiers changed from: package-private */
    public z0(d2 d2Var) {
        super(d2Var);
        new b1(this, 5, true, false);
    }

    private static String D(boolean z10, Object obj) {
        String str;
        StackTraceElement[] stackTrace;
        String className;
        String str2 = "";
        if (obj == null) {
            return str2;
        }
        if (obj instanceof Integer) {
            obj = Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Long) {
            if (!z10) {
                return String.valueOf(obj);
            }
            Long l10 = (Long) obj;
            if (Math.abs(l10.longValue()) < 100) {
                return String.valueOf(obj);
            }
            if (String.valueOf(obj).charAt(0) == '-') {
                str2 = "-";
            }
            String valueOf = String.valueOf(Math.abs(l10.longValue()));
            long round = Math.round(Math.pow(10.0d, valueOf.length() - 1));
            long round2 = Math.round(Math.pow(10.0d, valueOf.length()) - 1.0d);
            StringBuilder sb2 = new StringBuilder(str2.length() + 43 + str2.length());
            sb2.append(str2);
            sb2.append(round);
            sb2.append("...");
            sb2.append(str2);
            sb2.append(round2);
            return sb2.toString();
        } else if (obj instanceof Boolean) {
            return String.valueOf(obj);
        } else {
            if (obj instanceof Throwable) {
                Throwable th2 = (Throwable) obj;
                StringBuilder sb3 = new StringBuilder(z10 ? th2.getClass().getName() : th2.toString());
                String J = J(AppMeasurement.class.getCanonicalName());
                String J2 = J(d2.class.getCanonicalName());
                for (StackTraceElement stackTraceElement : th2.getStackTrace()) {
                    if (!stackTraceElement.isNativeMethod() && (className = stackTraceElement.getClassName()) != null) {
                        String J3 = J(className);
                        if (J3.equals(J) || J3.equals(J2)) {
                            sb3.append(": ");
                            sb3.append(stackTraceElement);
                            break;
                        }
                    }
                }
                return sb3.toString();
            } else if (!(obj instanceof c1)) {
                return z10 ? "-" : String.valueOf(obj);
            } else {
                str = ((c1) obj).f9190a;
                return str;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String E(boolean z10, String str, Object obj, Object obj2, Object obj3) {
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        String D = D(z10, obj);
        String D2 = D(z10, obj2);
        String D3 = D(z10, obj3);
        StringBuilder sb2 = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb2.append(str);
            str2 = ": ";
        }
        String str3 = ", ";
        if (!TextUtils.isEmpty(D)) {
            sb2.append(str2);
            sb2.append(D);
            str2 = str3;
        }
        if (!TextUtils.isEmpty(D2)) {
            sb2.append(str2);
            sb2.append(D2);
        } else {
            str3 = str2;
        }
        if (!TextUtils.isEmpty(D3)) {
            sb2.append(str3);
            sb2.append(D3);
        }
        return sb2.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Object I(String str) {
        if (str == null) {
            return null;
        }
        return new c1(str);
    }

    private static String J(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf == -1 ? str : str.substring(0, lastIndexOf);
    }

    private final String S() {
        String str;
        synchronized (this) {
            if (this.f9828e == null) {
                this.f9828e = p0.f9561c.a();
            }
            str = this.f9828e;
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void F(int i10, String str) {
        Log.println(i10, S(), str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void G(int i10, boolean z10, boolean z11, String str, Object obj, Object obj2, Object obj3) {
        String str2;
        if (!z10 && z(i10)) {
            F(i10, E(false, str, obj, obj2, obj3));
        }
        if (!z11 && i10 >= 5) {
            i.k(str);
            z1 x02 = this.f9815a.x0();
            if (x02 == null) {
                str2 = "Scheduler not set. Not logging error/warn";
            } else if (!x02.t()) {
                str2 = "Scheduler not initialized. Not logging error/warn";
            } else {
                if (i10 < 0) {
                    i10 = 0;
                }
                if (i10 >= 9) {
                    i10 = 8;
                }
                x02.J(new a1(this, i10, str, obj, obj2, obj3));
                return;
            }
            F(6, str2);
        }
    }

    public final b1 K() {
        return this.f9829f;
    }

    public final b1 L() {
        return this.f9830g;
    }

    public final b1 M() {
        return this.f9831h;
    }

    public final b1 N() {
        return this.f9832i;
    }

    public final b1 O() {
        return this.f9833j;
    }

    public final b1 P() {
        return this.f9834k;
    }

    public final b1 Q() {
        return this.f9835l;
    }

    public final b1 R() {
        return this.f9836m;
    }

    public final String T() {
        Pair<String, Long> c10 = r().f9431d.c();
        if (c10 == null || c10 == k1.f9429y) {
            return null;
        }
        String valueOf = String.valueOf(c10.second);
        String str = (String) c10.first;
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 1 + String.valueOf(str).length());
        sb2.append(valueOf);
        sb2.append(":");
        sb2.append(str);
        return sb2.toString();
    }

    @Override // com.google.android.gms.internal.measurement.z2
    protected final boolean v() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean z(int i10) {
        return Log.isLoggable(S(), i10);
    }
}
