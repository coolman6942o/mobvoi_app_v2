package a9;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.b;
import com.google.zxing.i;
/* compiled from: BoundingBox.java */
/* loaded from: classes.dex */
final class c {

    /* renamed from: a  reason: collision with root package name */
    private b f135a;

    /* renamed from: b  reason: collision with root package name */
    private i f136b;

    /* renamed from: c  reason: collision with root package name */
    private i f137c;

    /* renamed from: d  reason: collision with root package name */
    private i f138d;

    /* renamed from: e  reason: collision with root package name */
    private i f139e;

    /* renamed from: f  reason: collision with root package name */
    private int f140f;

    /* renamed from: g  reason: collision with root package name */
    private int f141g;

    /* renamed from: h  reason: collision with root package name */
    private int f142h;

    /* renamed from: i  reason: collision with root package name */
    private int f143i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, i iVar, i iVar2, i iVar3, i iVar4) throws NotFoundException {
        if (!(iVar == null && iVar3 == null) && (!(iVar2 == null && iVar4 == null) && ((iVar == null || iVar2 != null) && (iVar3 == null || iVar4 != null)))) {
            k(bVar, iVar, iVar2, iVar3, iVar4);
            return;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private void b() {
        if (this.f136b == null) {
            this.f136b = new i(0.0f, this.f138d.d());
            this.f137c = new i(0.0f, this.f139e.d());
        } else if (this.f138d == null) {
            this.f138d = new i(this.f135a.k() - 1, this.f136b.d());
            this.f139e = new i(this.f135a.k() - 1, this.f137c.d());
        }
        this.f140f = (int) Math.min(this.f136b.c(), this.f137c.c());
        this.f141g = (int) Math.max(this.f138d.c(), this.f139e.c());
        this.f142h = (int) Math.min(this.f136b.d(), this.f138d.d());
        this.f143i = (int) Math.max(this.f137c.d(), this.f139e.d());
    }

    private void k(b bVar, i iVar, i iVar2, i iVar3, i iVar4) {
        this.f135a = bVar;
        this.f136b = iVar;
        this.f137c = iVar2;
        this.f138d = iVar3;
        this.f139e = iVar4;
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c l(c cVar, c cVar2) throws NotFoundException {
        return cVar == null ? cVar2 : cVar2 == null ? cVar : new c(cVar.f135a, cVar.f136b, cVar.f137c, cVar2.f138d, cVar2.f139e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public c a(int i10, int i11, boolean z10) throws NotFoundException {
        i iVar;
        i iVar2;
        i iVar3;
        i iVar4;
        i iVar5 = this.f136b;
        i iVar6 = this.f137c;
        i iVar7 = this.f138d;
        i iVar8 = this.f139e;
        if (i10 > 0) {
            i iVar9 = z10 ? iVar5 : iVar7;
            int d10 = ((int) iVar9.d()) - i10;
            if (d10 < 0) {
                d10 = 0;
            }
            i iVar10 = new i(iVar9.c(), d10);
            if (z10) {
                iVar2 = iVar10;
            } else {
                iVar = iVar10;
                iVar2 = iVar5;
                if (i11 <= 0) {
                    i iVar11 = z10 ? this.f137c : this.f139e;
                    int d11 = ((int) iVar11.d()) + i11;
                    if (d11 >= this.f135a.g()) {
                        d11 = this.f135a.g() - 1;
                    }
                    i iVar12 = new i(iVar11.c(), d11);
                    if (z10) {
                        iVar4 = iVar12;
                    } else {
                        iVar3 = iVar12;
                        iVar4 = iVar6;
                        b();
                        return new c(this.f135a, iVar2, iVar4, iVar, iVar3);
                    }
                } else {
                    iVar4 = iVar6;
                }
                iVar3 = iVar8;
                b();
                return new c(this.f135a, iVar2, iVar4, iVar, iVar3);
            }
        } else {
            iVar2 = iVar5;
        }
        iVar = iVar7;
        if (i11 <= 0) {
        }
        iVar3 = iVar8;
        b();
        return new c(this.f135a, iVar2, iVar4, iVar, iVar3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i c() {
        return this.f137c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i d() {
        return this.f139e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f141g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.f143i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.f140f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int h() {
        return this.f142h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i i() {
        return this.f136b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i j() {
        return this.f138d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(c cVar) {
        k(cVar.f135a, cVar.f136b, cVar.f137c, cVar.f138d, cVar.f139e);
    }
}
