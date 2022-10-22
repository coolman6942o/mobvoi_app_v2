package com.google.android.gms.internal.measurement;

import java.io.IOException;
/* loaded from: classes.dex */
public final class i6 extends i<i6> {

    /* renamed from: c  reason: collision with root package name */
    public long[] f9371c;

    /* renamed from: d  reason: collision with root package name */
    public long[] f9372d;

    public i6() {
        long[] jArr = q.f9598a;
        this.f9371c = jArr;
        this.f9372d = jArr;
        this.f9353b = null;
        this.f9521a = -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.i, com.google.android.gms.internal.measurement.n
    public final int a() {
        long[] jArr;
        int a10 = super.a();
        long[] jArr2 = this.f9371c;
        int i10 = 0;
        if (jArr2 != null && jArr2.length > 0) {
            int i11 = 0;
            int i12 = 0;
            while (true) {
                jArr = this.f9371c;
                if (i11 >= jArr.length) {
                    break;
                }
                i12 += h.j(jArr[i11]);
                i11++;
            }
            a10 = a10 + i12 + (jArr.length * 1);
        }
        long[] jArr3 = this.f9372d;
        if (jArr3 == null || jArr3.length <= 0) {
            return a10;
        }
        int i13 = 0;
        while (true) {
            long[] jArr4 = this.f9372d;
            if (i10 >= jArr4.length) {
                return a10 + i13 + (jArr4.length * 1);
            }
            i13 += h.j(jArr4[i10]);
            i10++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.i, com.google.android.gms.internal.measurement.n
    public final void b(h hVar) throws IOException {
        long[] jArr = this.f9371c;
        int i10 = 0;
        if (jArr != null && jArr.length > 0) {
            int i11 = 0;
            while (true) {
                long[] jArr2 = this.f9371c;
                if (i11 >= jArr2.length) {
                    break;
                }
                hVar.d(1, jArr2[i11]);
                i11++;
            }
        }
        long[] jArr3 = this.f9372d;
        if (jArr3 != null && jArr3.length > 0) {
            while (true) {
                long[] jArr4 = this.f9372d;
                if (i10 >= jArr4.length) {
                    break;
                }
                hVar.d(2, jArr4[i10]);
                i10++;
            }
        }
        super.b(hVar);
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final /* synthetic */ n c(g gVar) throws IOException {
        int e10;
        while (true) {
            int n10 = gVar.n();
            if (n10 == 0) {
                return this;
            }
            if (n10 != 8) {
                if (n10 == 10) {
                    e10 = gVar.e(gVar.p());
                    int a10 = gVar.a();
                    int i10 = 0;
                    while (gVar.t() > 0) {
                        gVar.q();
                        i10++;
                    }
                    gVar.i(a10);
                    long[] jArr = this.f9371c;
                    int length = jArr == null ? 0 : jArr.length;
                    int i11 = i10 + length;
                    long[] jArr2 = new long[i11];
                    if (length != 0) {
                        System.arraycopy(jArr, 0, jArr2, 0, length);
                    }
                    while (length < i11) {
                        jArr2[length] = gVar.q();
                        length++;
                    }
                    this.f9371c = jArr2;
                } else if (n10 == 16) {
                    int a11 = q.a(gVar, 16);
                    long[] jArr3 = this.f9372d;
                    int length2 = jArr3 == null ? 0 : jArr3.length;
                    int i12 = a11 + length2;
                    long[] jArr4 = new long[i12];
                    if (length2 != 0) {
                        System.arraycopy(jArr3, 0, jArr4, 0, length2);
                    }
                    while (length2 < i12 - 1) {
                        jArr4[length2] = gVar.q();
                        gVar.n();
                        length2++;
                    }
                    jArr4[length2] = gVar.q();
                    this.f9372d = jArr4;
                } else if (n10 == 18) {
                    e10 = gVar.e(gVar.p());
                    int a12 = gVar.a();
                    int i13 = 0;
                    while (gVar.t() > 0) {
                        gVar.q();
                        i13++;
                    }
                    gVar.i(a12);
                    long[] jArr5 = this.f9372d;
                    int length3 = jArr5 == null ? 0 : jArr5.length;
                    int i14 = i13 + length3;
                    long[] jArr6 = new long[i14];
                    if (length3 != 0) {
                        System.arraycopy(jArr5, 0, jArr6, 0, length3);
                    }
                    while (length3 < i14) {
                        jArr6[length3] = gVar.q();
                        length3++;
                    }
                    this.f9372d = jArr6;
                } else if (!super.g(gVar, n10)) {
                    return this;
                }
                gVar.h(e10);
            } else {
                int a13 = q.a(gVar, 8);
                long[] jArr7 = this.f9371c;
                int length4 = jArr7 == null ? 0 : jArr7.length;
                int i15 = a13 + length4;
                long[] jArr8 = new long[i15];
                if (length4 != 0) {
                    System.arraycopy(jArr7, 0, jArr8, 0, length4);
                }
                while (length4 < i15 - 1) {
                    jArr8[length4] = gVar.q();
                    gVar.n();
                    length4++;
                }
                jArr8[length4] = gVar.q();
                this.f9371c = jArr8;
            }
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i6)) {
            return false;
        }
        i6 i6Var = (i6) obj;
        if (!m.a(this.f9371c, i6Var.f9371c) || !m.a(this.f9372d, i6Var.f9372d)) {
            return false;
        }
        k kVar = this.f9353b;
        if (kVar != null && !kVar.b()) {
            return this.f9353b.equals(i6Var.f9353b);
        }
        k kVar2 = i6Var.f9353b;
        return kVar2 == null || kVar2.b();
    }

    public final int hashCode() {
        int hashCode = (((((i6.class.getName().hashCode() + 527) * 31) + m.c(this.f9371c)) * 31) + m.c(this.f9372d)) * 31;
        k kVar = this.f9353b;
        return hashCode + ((kVar == null || kVar.b()) ? 0 : this.f9353b.hashCode());
    }
}
