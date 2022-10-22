package com.google.android.gms.internal.measurement;

import java.io.IOException;
/* loaded from: classes.dex */
public final class e6 extends i<e6> {

    /* renamed from: h  reason: collision with root package name */
    private static volatile e6[] f9256h;

    /* renamed from: c  reason: collision with root package name */
    public f6[] f9257c = f6.h();

    /* renamed from: d  reason: collision with root package name */
    public String f9258d = null;

    /* renamed from: e  reason: collision with root package name */
    public Long f9259e = null;

    /* renamed from: f  reason: collision with root package name */
    public Long f9260f = null;

    /* renamed from: g  reason: collision with root package name */
    public Integer f9261g = null;

    public e6() {
        this.f9353b = null;
        this.f9521a = -1;
    }

    public static e6[] h() {
        if (f9256h == null) {
            synchronized (m.f9497b) {
                if (f9256h == null) {
                    f9256h = new e6[0];
                }
            }
        }
        return f9256h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.i, com.google.android.gms.internal.measurement.n
    public final int a() {
        int a10 = super.a();
        f6[] f6VarArr = this.f9257c;
        if (f6VarArr != null && f6VarArr.length > 0) {
            int i10 = 0;
            while (true) {
                f6[] f6VarArr2 = this.f9257c;
                if (i10 >= f6VarArr2.length) {
                    break;
                }
                f6 f6Var = f6VarArr2[i10];
                if (f6Var != null) {
                    a10 += h.o(1, f6Var);
                }
                i10++;
            }
        }
        String str = this.f9258d;
        if (str != null) {
            a10 += h.u(2, str);
        }
        Long l10 = this.f9259e;
        if (l10 != null) {
            a10 += h.t(3, l10.longValue());
        }
        Long l11 = this.f9260f;
        if (l11 != null) {
            a10 += h.t(4, l11.longValue());
        }
        Integer num = this.f9261g;
        return num != null ? a10 + h.w(5, num.intValue()) : a10;
    }

    @Override // com.google.android.gms.internal.measurement.i, com.google.android.gms.internal.measurement.n
    public final void b(h hVar) throws IOException {
        f6[] f6VarArr = this.f9257c;
        if (f6VarArr != null && f6VarArr.length > 0) {
            int i10 = 0;
            while (true) {
                f6[] f6VarArr2 = this.f9257c;
                if (i10 >= f6VarArr2.length) {
                    break;
                }
                f6 f6Var = f6VarArr2[i10];
                if (f6Var != null) {
                    hVar.e(1, f6Var);
                }
                i10++;
            }
        }
        String str = this.f9258d;
        if (str != null) {
            hVar.r(2, str);
        }
        Long l10 = this.f9259e;
        if (l10 != null) {
            hVar.q(3, l10.longValue());
        }
        Long l11 = this.f9260f;
        if (l11 != null) {
            hVar.q(4, l11.longValue());
        }
        Integer num = this.f9261g;
        if (num != null) {
            hVar.v(5, num.intValue());
        }
        super.b(hVar);
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final /* synthetic */ n c(g gVar) throws IOException {
        while (true) {
            int n10 = gVar.n();
            if (n10 == 0) {
                return this;
            }
            if (n10 == 10) {
                int a10 = q.a(gVar, 10);
                f6[] f6VarArr = this.f9257c;
                int length = f6VarArr == null ? 0 : f6VarArr.length;
                int i10 = a10 + length;
                f6[] f6VarArr2 = new f6[i10];
                if (length != 0) {
                    System.arraycopy(f6VarArr, 0, f6VarArr2, 0, length);
                }
                while (length < i10 - 1) {
                    f6VarArr2[length] = new f6();
                    gVar.d(f6VarArr2[length]);
                    gVar.n();
                    length++;
                }
                f6VarArr2[length] = new f6();
                gVar.d(f6VarArr2[length]);
                this.f9257c = f6VarArr2;
            } else if (n10 == 18) {
                this.f9258d = gVar.b();
            } else if (n10 == 24) {
                this.f9259e = Long.valueOf(gVar.q());
            } else if (n10 == 32) {
                this.f9260f = Long.valueOf(gVar.q());
            } else if (n10 == 40) {
                this.f9261g = Integer.valueOf(gVar.p());
            } else if (!super.g(gVar, n10)) {
                return this;
            }
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof e6)) {
            return false;
        }
        e6 e6Var = (e6) obj;
        if (!m.b(this.f9257c, e6Var.f9257c)) {
            return false;
        }
        String str = this.f9258d;
        if (str == null) {
            if (e6Var.f9258d != null) {
                return false;
            }
        } else if (!str.equals(e6Var.f9258d)) {
            return false;
        }
        Long l10 = this.f9259e;
        if (l10 == null) {
            if (e6Var.f9259e != null) {
                return false;
            }
        } else if (!l10.equals(e6Var.f9259e)) {
            return false;
        }
        Long l11 = this.f9260f;
        if (l11 == null) {
            if (e6Var.f9260f != null) {
                return false;
            }
        } else if (!l11.equals(e6Var.f9260f)) {
            return false;
        }
        Integer num = this.f9261g;
        if (num == null) {
            if (e6Var.f9261g != null) {
                return false;
            }
        } else if (!num.equals(e6Var.f9261g)) {
            return false;
        }
        k kVar = this.f9353b;
        if (kVar != null && !kVar.b()) {
            return this.f9353b.equals(e6Var.f9353b);
        }
        k kVar2 = e6Var.f9353b;
        return kVar2 == null || kVar2.b();
    }

    public final int hashCode() {
        int hashCode = (((e6.class.getName().hashCode() + 527) * 31) + m.d(this.f9257c)) * 31;
        String str = this.f9258d;
        int i10 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Long l10 = this.f9259e;
        int hashCode3 = (hashCode2 + (l10 == null ? 0 : l10.hashCode())) * 31;
        Long l11 = this.f9260f;
        int hashCode4 = (hashCode3 + (l11 == null ? 0 : l11.hashCode())) * 31;
        Integer num = this.f9261g;
        int hashCode5 = (hashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        k kVar = this.f9353b;
        if (kVar != null && !kVar.b()) {
            i10 = this.f9353b.hashCode();
        }
        return hashCode5 + i10;
    }
}
