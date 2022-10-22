package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.C0550a;
import com.huawei.hms.scankit.aiscan.common.z;
/* compiled from: BoundingBox.java */
/* loaded from: classes2.dex */
final class Q {

    /* renamed from: a  reason: collision with root package name */
    private final C0595i f14610a;

    /* renamed from: b  reason: collision with root package name */
    private final z f14611b;

    /* renamed from: c  reason: collision with root package name */
    private final z f14612c;

    /* renamed from: d  reason: collision with root package name */
    private final z f14613d;

    /* renamed from: e  reason: collision with root package name */
    private final z f14614e;

    /* renamed from: f  reason: collision with root package name */
    private final int f14615f;

    /* renamed from: g  reason: collision with root package name */
    private final int f14616g;

    /* renamed from: h  reason: collision with root package name */
    private final int f14617h;

    /* renamed from: i  reason: collision with root package name */
    private final int f14618i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Q(C0595i iVar, z zVar, z zVar2, z zVar3, z zVar4) throws C0550a {
        boolean z10 = false;
        boolean z11 = zVar == null || zVar2 == null;
        z10 = (zVar3 == null || zVar4 == null) ? true : z10;
        if (!z11 || !z10) {
            if (z11) {
                zVar = new z(0.0f, zVar3.c());
                zVar2 = new z(0.0f, zVar4.c());
            } else if (z10) {
                zVar3 = new z(iVar.d() - 1, zVar.c());
                zVar4 = new z(iVar.d() - 1, zVar2.c());
            }
            this.f14610a = iVar;
            this.f14611b = zVar;
            this.f14612c = zVar2;
            this.f14613d = zVar3;
            this.f14614e = zVar4;
            this.f14615f = (int) Math.min(zVar.b(), zVar2.b());
            this.f14616g = (int) Math.max(zVar3.b(), zVar4.b());
            this.f14617h = (int) Math.min(zVar.c(), zVar3.c());
            this.f14618i = (int) Math.max(zVar2.c(), zVar4.c());
            return;
        }
        throw C0550a.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Q a(Q q5, Q q10) throws C0550a {
        return q5 == null ? q10 : q10 == null ? q5 : new Q(q5.f14610a, q5.f14611b, q5.f14612c, q10.f14613d, q10.f14614e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public z b() {
        return this.f14614e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        return this.f14616g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.f14618i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.f14615f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.f14617h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public z g() {
        return this.f14611b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public z h() {
        return this.f14613d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Q a(int i10, int i11, boolean z10) throws C0550a {
        z zVar;
        z zVar2;
        z zVar3;
        z zVar4;
        z zVar5 = this.f14611b;
        z zVar6 = this.f14612c;
        z zVar7 = this.f14613d;
        z zVar8 = this.f14614e;
        if (i10 > 0) {
            z zVar9 = z10 ? zVar5 : zVar7;
            int c10 = ((int) zVar9.c()) - i10;
            if (c10 < 0) {
                c10 = 0;
            }
            z zVar10 = new z(zVar9.b(), c10);
            if (z10) {
                zVar2 = zVar10;
            } else {
                zVar = zVar10;
                zVar2 = zVar5;
                if (i11 <= 0) {
                    z zVar11 = z10 ? this.f14612c : this.f14614e;
                    int c11 = ((int) zVar11.c()) + i11;
                    if (c11 >= this.f14610a.b()) {
                        c11 = this.f14610a.b() - 1;
                    }
                    z zVar12 = new z(zVar11.b(), c11);
                    if (z10) {
                        zVar4 = zVar12;
                    } else {
                        zVar3 = zVar12;
                        zVar4 = zVar6;
                        return new Q(this.f14610a, zVar2, zVar4, zVar, zVar3);
                    }
                } else {
                    zVar4 = zVar6;
                }
                zVar3 = zVar8;
                return new Q(this.f14610a, zVar2, zVar4, zVar, zVar3);
            }
        } else {
            zVar2 = zVar5;
        }
        zVar = zVar7;
        if (i11 <= 0) {
        }
        zVar3 = zVar8;
        return new Q(this.f14610a, zVar2, zVar4, zVar, zVar3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public z a() {
        return this.f14612c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Q(Q q5) {
        this.f14610a = q5.f14610a;
        this.f14611b = q5.g();
        this.f14612c = q5.a();
        this.f14613d = q5.h();
        this.f14614e = q5.b();
        this.f14615f = q5.e();
        this.f14616g = q5.c();
        this.f14617h = q5.f();
        this.f14618i = q5.d();
    }
}
