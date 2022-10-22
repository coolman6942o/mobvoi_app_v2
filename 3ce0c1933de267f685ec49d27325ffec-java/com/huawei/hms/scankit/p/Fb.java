package com.huawei.hms.scankit.p;
/* compiled from: SimpleToken.java */
/* loaded from: classes2.dex */
final class Fb extends Hb {

    /* renamed from: c  reason: collision with root package name */
    private final short f14529c;

    /* renamed from: d  reason: collision with root package name */
    private final short f14530d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fb(Hb hb2, int i10, int i11) {
        super(hb2);
        this.f14529c = (short) i10;
        this.f14530d = (short) i11;
    }

    @Override // com.huawei.hms.scankit.p.Hb
    void a(C0591h hVar, byte[] bArr) {
        hVar.a(this.f14529c, this.f14530d);
    }

    public String toString() {
        short s10 = this.f14529c;
        int i10 = 1 << this.f14530d;
        int i11 = (s10 & (i10 - 1)) | i10;
        return '<' + Integer.toBinaryString(i11 | (1 << this.f14530d)).substring(1) + '>';
    }
}
