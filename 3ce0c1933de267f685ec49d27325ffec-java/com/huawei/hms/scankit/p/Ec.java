package com.huawei.hms.scankit.p;

import java.util.ArrayList;
import java.util.List;
/* compiled from: ParticleAnimators.java */
/* loaded from: classes2.dex */
public class Ec implements Cc {

    /* renamed from: a  reason: collision with root package name */
    private List<Cc> f14513a = new ArrayList();

    @Override // com.huawei.hms.scankit.p.Cc
    public void a(zc zcVar, long j10) {
        for (Cc cc2 : this.f14513a) {
            cc2.a(zcVar, j10);
        }
    }

    public void a(Cc cc2) {
        if (this.f14513a == null) {
            this.f14513a = new ArrayList();
        }
        this.f14513a.add(cc2);
    }
}
