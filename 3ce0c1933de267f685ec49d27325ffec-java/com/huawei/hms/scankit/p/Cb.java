package com.huawei.hms.scankit.p;
/* compiled from: BinaryShiftToken.java */
/* loaded from: classes2.dex */
final class Cb extends Hb {

    /* renamed from: c  reason: collision with root package name */
    private final short f14486c;

    /* renamed from: d  reason: collision with root package name */
    private final short f14487d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Cb(Hb hb2, int i10, int i11) {
        super(hb2);
        this.f14486c = (short) i10;
        this.f14487d = (short) i11;
    }

    @Override // com.huawei.hms.scankit.p.Hb
    public void a(C0591h hVar, byte[] bArr) {
        int i10 = 0;
        while (true) {
            short s10 = this.f14487d;
            if (i10 < s10) {
                if (i10 == 0 || (i10 == 31 && s10 <= 62)) {
                    hVar.a(31, 5);
                    short s11 = this.f14487d;
                    if (s11 > 62) {
                        hVar.a(s11 - 31, 16);
                    } else if (i10 == 0) {
                        hVar.a(Math.min((int) s11, 31), 5);
                    } else {
                        hVar.a(s11 - 31, 5);
                    }
                }
                hVar.a(bArr[this.f14486c + i10], 8);
                i10++;
            } else {
                return;
            }
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("<");
        sb2.append((int) this.f14486c);
        sb2.append("::");
        sb2.append((this.f14486c + this.f14487d) - 1);
        sb2.append('>');
        return sb2.toString();
    }
}
