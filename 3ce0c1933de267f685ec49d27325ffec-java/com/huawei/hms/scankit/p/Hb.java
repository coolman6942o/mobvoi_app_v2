package com.huawei.hms.scankit.p;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Token.java */
/* loaded from: classes2.dex */
public abstract class Hb {

    /* renamed from: a  reason: collision with root package name */
    static final Hb f14540a = new Fb(null, 0, 0);

    /* renamed from: b  reason: collision with root package name */
    private final Hb f14541b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Hb(Hb hb2) {
        this.f14541b = hb2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Hb a() {
        return this.f14541b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void a(C0591h hVar, byte[] bArr);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Hb b(int i10, int i11) {
        return new Cb(this, i10, i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Hb a(int i10, int i11) {
        return new Fb(this, i10, i11);
    }
}
