package a9;

import java.util.Formatter;
/* compiled from: DetectionResultColumn.java */
/* loaded from: classes.dex */
class g {

    /* renamed from: a  reason: collision with root package name */
    private final c f158a;

    /* renamed from: b  reason: collision with root package name */
    private final d[] f159b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(c cVar) {
        this.f158a = new c(cVar);
        this.f159b = new d[(cVar.f() - cVar.h()) + 1];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final c a() {
        return this.f158a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final d b(int i10) {
        return this.f159b[e(i10)];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final d c(int i10) {
        d dVar;
        d dVar2;
        d b10 = b(i10);
        if (b10 != null) {
            return b10;
        }
        for (int i11 = 1; i11 < 5; i11++) {
            int e10 = e(i10) - i11;
            if (e10 >= 0 && (dVar2 = this.f159b[e10]) != null) {
                return dVar2;
            }
            int e11 = e(i10) + i11;
            d[] dVarArr = this.f159b;
            if (e11 < dVarArr.length && (dVar = dVarArr[e11]) != null) {
                return dVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final d[] d() {
        return this.f159b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int e(int i10) {
        return i10 - this.f158a.h();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void f(int i10, d dVar) {
        this.f159b[e(i10)] = dVar;
    }

    public String toString() {
        d[] dVarArr;
        Formatter formatter = new Formatter();
        int i10 = 0;
        for (d dVar : this.f159b) {
            if (dVar == null) {
                i10++;
                formatter.format("%3d:    |   %n", Integer.valueOf(i10));
            } else {
                i10++;
                formatter.format("%3d: %3d|%3d%n", Integer.valueOf(i10), Integer.valueOf(dVar.c()), Integer.valueOf(dVar.e()));
            }
        }
        String formatter2 = formatter.toString();
        formatter.close();
        return formatter2;
    }
}
