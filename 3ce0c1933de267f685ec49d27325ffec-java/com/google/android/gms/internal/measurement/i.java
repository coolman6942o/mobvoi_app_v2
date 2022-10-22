package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.i;
import java.io.IOException;
/* loaded from: classes.dex */
public abstract class i<M extends i<M>> extends n {

    /* renamed from: b  reason: collision with root package name */
    protected k f9353b;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.measurement.n
    public int a() {
        if (this.f9353b == null) {
            return 0;
        }
        int i10 = 0;
        for (int i11 = 0; i11 < this.f9353b.c(); i11++) {
            i10 += this.f9353b.f(i11).b();
        }
        return i10;
    }

    @Override // com.google.android.gms.internal.measurement.n
    public void b(h hVar) throws IOException {
        if (this.f9353b != null) {
            for (int i10 = 0; i10 < this.f9353b.c(); i10++) {
                this.f9353b.f(i10).c(hVar);
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.n
    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        i iVar = (i) super.clone();
        m.e(this, iVar);
        return iVar;
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final /* synthetic */ n d() throws CloneNotSupportedException {
        return (i) clone();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean g(g gVar, int i10) throws IOException {
        int a10 = gVar.a();
        if (!gVar.g(i10)) {
            return false;
        }
        int i11 = i10 >>> 3;
        p pVar = new p(i10, gVar.k(a10, gVar.a() - a10));
        l lVar = null;
        k kVar = this.f9353b;
        if (kVar == null) {
            this.f9353b = new k();
        } else {
            lVar = kVar.e(i11);
        }
        if (lVar == null) {
            lVar = new l();
            this.f9353b.d(i11, lVar);
        }
        lVar.d(pVar);
        return true;
    }
}
