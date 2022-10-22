package com.huawei.hms.scankit.p;

import java.util.ArrayList;
import java.util.List;
/* compiled from: ParticleProperties.java */
/* loaded from: classes2.dex */
public class Gc implements Fc {

    /* renamed from: a  reason: collision with root package name */
    private List<Fc> f14538a = new ArrayList();

    @Override // com.huawei.hms.scankit.p.Fc
    public void a(zc zcVar) {
        for (Fc fc2 : this.f14538a) {
            fc2.a(zcVar);
        }
    }

    public void a(Fc fc2) {
        if (this.f14538a == null) {
            this.f14538a = new ArrayList();
        }
        this.f14538a.add(fc2);
    }
}
