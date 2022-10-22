package com.google.android.gms.internal.measurement;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import androidx.collection.a;
import b6.i;
import com.google.android.gms.measurement.AppMeasurement;
import java.io.IOException;
import java.util.Map;
/* loaded from: classes.dex */
public final class y1 extends i5 implements c0 {

    /* renamed from: j  reason: collision with root package name */
    private static int f9807j = 65535;

    /* renamed from: k  reason: collision with root package name */
    private static int f9808k = 2;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, Map<String, String>> f9809d = new a();

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, Map<String, Boolean>> f9810e = new a();

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, Map<String, Boolean>> f9811f = new a();

    /* renamed from: g  reason: collision with root package name */
    private final Map<String, b6> f9812g = new a();

    /* renamed from: i  reason: collision with root package name */
    private final Map<String, String> f9814i = new a();

    /* renamed from: h  reason: collision with root package name */
    private final Map<String, Map<String, Integer>> f9813h = new a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public y1(j5 j5Var) {
        super(j5Var);
    }

    private static Map<String, String> A(b6 b6Var) {
        c6[] c6VarArr;
        a aVar = new a();
        if (!(b6Var == null || (c6VarArr = b6Var.f9187f) == null)) {
            for (c6 c6Var : c6VarArr) {
                if (c6Var != null) {
                    aVar.put(c6Var.f9205c, c6Var.f9206d);
                }
            }
        }
        return aVar;
    }

    private final void B(String str, b6 b6Var) {
        a6[] a6VarArr;
        a aVar = new a();
        a aVar2 = new a();
        a aVar3 = new a();
        if (!(b6Var == null || (a6VarArr = b6Var.f9188g) == null)) {
            for (a6 a6Var : a6VarArr) {
                if (TextUtils.isEmpty(a6Var.f9168c)) {
                    c().N().a("EventConfig contained null event name");
                } else {
                    String a10 = AppMeasurement.a.a(a6Var.f9168c);
                    if (!TextUtils.isEmpty(a10)) {
                        a6Var.f9168c = a10;
                    }
                    aVar.put(a6Var.f9168c, a6Var.f9169d);
                    aVar2.put(a6Var.f9168c, a6Var.f9170e);
                    Integer num = a6Var.f9171f;
                    if (num != null) {
                        if (num.intValue() < f9808k || a6Var.f9171f.intValue() > f9807j) {
                            c().N().c("Invalid sampling rate. Event name, sample rate", a6Var.f9168c, a6Var.f9171f);
                        } else {
                            aVar3.put(a6Var.f9168c, a6Var.f9171f);
                        }
                    }
                }
            }
        }
        this.f9810e.put(str, aVar);
        this.f9811f.put(str, aVar2);
        this.f9813h.put(str, aVar3);
    }

    private final void D(String str) {
        w();
        e();
        i.g(str);
        if (this.f9812g.get(str) == null) {
            byte[] h02 = u().h0(str);
            if (h02 == null) {
                this.f9809d.put(str, null);
                this.f9810e.put(str, null);
                this.f9811f.put(str, null);
                this.f9812g.put(str, null);
                this.f9814i.put(str, null);
                this.f9813h.put(str, null);
                return;
            }
            b6 z10 = z(str, h02);
            this.f9809d.put(str, A(z10));
            B(str, z10);
            this.f9812g.put(str, z10);
            this.f9814i.put(str, null);
        }
    }

    private final b6 z(String str, byte[] bArr) {
        if (bArr == null) {
            return new b6();
        }
        g c10 = g.c(bArr, 0, bArr.length);
        b6 b6Var = new b6();
        try {
            b6Var.c(c10);
            c().R().c("Parsed config. version, gmp_app_id", b6Var.f9184c, b6Var.f9185d);
            return b6Var;
        } catch (IOException e10) {
            c().N().c("Unable to merge remote config. appId", z0.I(str), e10);
            return new b6();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean C(String str, byte[] bArr, String str2) {
        byte[] bArr2;
        ContentValues contentValues;
        y5[] y5VarArr;
        w();
        e();
        i.g(str);
        b6 z10 = z(str, bArr);
        int i10 = 0;
        if (z10 == null) {
            return false;
        }
        B(str, z10);
        this.f9812g.put(str, z10);
        this.f9814i.put(str, str2);
        this.f9809d.put(str, A(z10));
        x t10 = t();
        u5[] u5VarArr = z10.f9189h;
        i.k(u5VarArr);
        int length = u5VarArr.length;
        int i11 = 0;
        while (i11 < length) {
            u5 u5Var = u5VarArr[i11];
            v5[] v5VarArr = u5Var.f9711e;
            int length2 = v5VarArr.length;
            int i12 = i10;
            while (i12 < length2) {
                v5 v5Var = v5VarArr[i12];
                String a10 = AppMeasurement.a.a(v5Var.f9751d);
                if (a10 != null) {
                    v5Var.f9751d = a10;
                }
                w5[] w5VarArr = v5Var.f9752e;
                int length3 = w5VarArr.length;
                for (int i13 = i10; i13 < length3; i13++) {
                    w5 w5Var = w5VarArr[i13];
                    String a11 = AppMeasurement.d.a(w5Var.f9783f);
                    if (a11 != null) {
                        w5Var.f9783f = a11;
                    }
                }
                i12++;
                i10 = 0;
            }
            for (y5 y5Var : u5Var.f9710d) {
                String a12 = AppMeasurement.e.a(y5Var.f9822d);
                if (a12 != null) {
                    y5Var.f9822d = a12;
                }
            }
            i11++;
            i10 = 0;
        }
        t10.u().P(str, u5VarArr);
        try {
            z10.f9189h = null;
            int f10 = z10.f();
            bArr2 = new byte[f10];
            z10.b(h.p(bArr2, 0, f10));
        } catch (IOException e10) {
            c().N().c("Unable to serialize reduced-size config. Storing full config instead. appId", z0.I(str), e10);
            bArr2 = bArr;
        }
        d0 u10 = u();
        i.g(str);
        u10.e();
        u10.w();
        new ContentValues().put("remote_config", bArr2);
        try {
            if (u10.B().update("apps", contentValues, "app_id = ?", new String[]{str}) == 0) {
                u10.c().K().d("Failed to update remote config (got 0). appId", z0.I(str));
            }
        } catch (SQLiteException e11) {
            u10.c().K().c("Error storing remote config. appId", z0.I(str), e11);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final b6 E(String str) {
        w();
        e();
        i.g(str);
        D(str);
        return this.f9812g.get(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String F(String str) {
        e();
        return this.f9814i.get(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void G(String str) {
        e();
        this.f9814i.put(str, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void H(String str) {
        e();
        this.f9812g.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean I(String str) {
        return "1".equals(a(str, "measurement.upload.blacklist_internal"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean J(String str) {
        return "1".equals(a(str, "measurement.upload.blacklist_public"));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean K(String str, String str2) {
        Boolean bool;
        e();
        D(str);
        if (I(str) && r5.j0(str2)) {
            return true;
        }
        if (J(str) && r5.d0(str2)) {
            return true;
        }
        Map<String, Boolean> map = this.f9810e.get(str);
        if (map == null || (bool = map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean L(String str, String str2) {
        Boolean bool;
        e();
        D(str);
        if ("ecommerce_purchase".equals(str2)) {
            return true;
        }
        Map<String, Boolean> map = this.f9811f.get(str);
        if (map == null || (bool = map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int M(String str, String str2) {
        Integer num;
        e();
        D(str);
        Map<String, Integer> map = this.f9813h.get(str);
        if (map == null || (num = map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    @Override // com.google.android.gms.internal.measurement.c0
    public final String a(String str, String str2) {
        e();
        D(str);
        Map<String, String> map = this.f9809d.get(str);
        if (map != null) {
            return map.get(str2);
        }
        return null;
    }

    @Override // com.google.android.gms.internal.measurement.i5
    protected final boolean x() {
        return false;
    }
}
