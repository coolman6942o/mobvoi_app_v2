package cn.com.fmsh.communication.core;

import x2.c;
/* loaded from: classes.dex */
public class MessageHead {

    /* renamed from: a  reason: collision with root package name */
    private /* synthetic */ byte f6054a;

    /* renamed from: d  reason: collision with root package name */
    private /* synthetic */ long f6057d = 0;

    /* renamed from: b  reason: collision with root package name */
    private /* synthetic */ ControlWord f6055b = new ControlWord();

    /* renamed from: c  reason: collision with root package name */
    private /* synthetic */ byte[] f6056c = new byte[4];

    /* renamed from: e  reason: collision with root package name */
    private /* synthetic */ byte[] f6058e = new byte[4];

    /* loaded from: classes.dex */
    public enum CheckType {
        NOCHECK(0),
        MAC(1),
        CRC16(2);
        

        /* renamed from: a  reason: collision with root package name */
        private /* synthetic */ int f6060a;

        /* synthetic */ CheckType(int i10) {
            this.f6060a = i10;
        }

        public int getValue() {
            return this.f6060a;
        }
    }

    /* loaded from: classes.dex */
    public enum SecurityLevel {
        PLAIN(0),
        CIPHER(1);
        

        /* renamed from: a  reason: collision with root package name */
        private /* synthetic */ int f6062a;

        /* synthetic */ SecurityLevel(int i10) {
            this.f6062a = i10;
        }

        public int getValue() {
            return this.f6062a;
        }
    }

    public void a(byte[] bArr) {
        if (bArr != null && bArr.length == 12) {
            this.f6054a = bArr[0];
            this.f6055b.b(bArr[1]);
            for (int i10 = 0; i10 < 2; i10++) {
                this.f6056c[i10] = bArr[i10 + 2];
            }
            byte[] bArr2 = new byte[4];
            for (int i11 = 0; i11 < 4; i11++) {
                bArr2[i11] = bArr[i11 + 4];
            }
            this.f6057d = c.g(c.s(new byte[1], bArr2));
            for (int i12 = 0; i12 < 4; i12++) {
                this.f6058e[i12] = bArr[i12 + 8];
            }
        }
    }

    public ControlWord b() {
        return this.f6055b;
    }

    public byte[] c() {
        return this.f6056c;
    }

    public long d() {
        return this.f6057d;
    }

    public byte[] e() {
        return this.f6058e;
    }

    public void f(ControlWord controlWord) {
        this.f6055b = controlWord;
    }

    public void g(byte b10) {
        this.f6054a = b10;
    }

    public void h(byte[] bArr) {
        this.f6056c = bArr;
    }

    public void i(long j10) {
        this.f6057d = j10;
    }

    public void j(byte[] bArr) {
        this.f6058e = bArr;
    }

    public byte[] k() {
        byte[] bArr = new byte[12];
        bArr[0] = this.f6054a;
        bArr[1] = this.f6055b.j();
        for (int i10 = 0; i10 < 2; i10++) {
            bArr[i10 + 2] = this.f6056c[i10];
        }
        byte[] t10 = c.t(this.f6057d, 4);
        for (int i11 = 0; i11 < 4; i11++) {
            bArr[i11 + 4] = t10[i11];
        }
        for (int i12 = 0; i12 < 4; i12++) {
            bArr[i12 + 8] = this.f6058e[i12];
        }
        return bArr;
    }
}
