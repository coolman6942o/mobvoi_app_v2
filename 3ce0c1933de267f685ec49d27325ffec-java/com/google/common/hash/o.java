package com.google.common.hash;

import com.google.common.hash.r;
/* compiled from: LongAdder.java */
/* loaded from: classes.dex */
final class o extends r implements m {
    private static final long serialVersionUID = 7249069246863182397L;

    @Override // com.google.common.hash.m
    public void a() {
        c(1L);
    }

    @Override // com.google.common.hash.m
    public long b() {
        long j10 = this.base;
        r.b[] bVarArr = this.cells;
        if (bVarArr != null) {
            for (r.b bVar : bVarArr) {
                if (bVar != null) {
                    j10 += bVar.f12324a;
                }
            }
        }
        return j10;
    }

    @Override // com.google.common.hash.m
    public void c(long j10) {
        int length;
        r.b bVar;
        r.b[] bVarArr = this.cells;
        if (bVarArr == null) {
            long j11 = this.base;
            if (g(j11, j11 + j10)) {
                return;
            }
        }
        int[] iArr = r.threadHashCode.get();
        boolean z10 = true;
        if (!(iArr == null || bVarArr == null || (length = bVarArr.length) < 1 || (bVar = bVarArr[(length - 1) & iArr[0]]) == null)) {
            long j12 = bVar.f12324a;
            z10 = bVar.a(j12, j12 + j10);
            if (z10) {
                return;
            }
        }
        k(j10, iArr, z10);
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return b();
    }

    @Override // java.lang.Number
    public float floatValue() {
        return (float) b();
    }

    @Override // com.google.common.hash.r
    final long i(long j10, long j11) {
        return j10 + j11;
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) b();
    }

    @Override // java.lang.Number
    public long longValue() {
        return b();
    }

    public String toString() {
        return Long.toString(b());
    }
}
