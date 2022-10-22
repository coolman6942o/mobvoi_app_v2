package b;

import il.b;
import jl.a;
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public byte f4952a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f4953b = 0;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f4954c = null;

    /* renamed from: d  reason: collision with root package name */
    public short f4955d = -1;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f4956e = null;

    public static byte[] c(int i10, byte[] bArr) {
        int length = bArr != null ? bArr.length : 0;
        byte[] bArr2 = new byte[length + 4];
        bArr2[0] = -86;
        bArr2[1] = (byte) i10;
        bArr2[2] = (byte) (length & 255);
        bArr2[3] = (byte) ((length >> 8) & 255);
        if (length > 0) {
            System.arraycopy(bArr, 0, bArr2, 4, length);
        }
        return bArr2;
    }

    public static byte[] d(short s10, byte[] bArr) {
        int length = bArr != null ? bArr.length : 0;
        byte[] bArr2 = new byte[length + 2];
        bArr2[0] = (byte) (s10 & 255);
        bArr2[1] = (byte) ((s10 >> 8) & 255);
        if (length > 0) {
            System.arraycopy(bArr, 0, bArr2, 2, length);
        }
        return bArr2;
    }

    public static e f(byte[] bArr) {
        e eVar = new e();
        if (eVar.b(bArr)) {
            return eVar;
        }
        return null;
    }

    public short a() {
        return this.f4955d;
    }

    public boolean b(byte[] bArr) {
        String str;
        if (bArr == null || bArr.length < 4) {
            str = "LT_LENGTH_ERROR";
        } else {
            byte b10 = bArr[0];
            this.f4952a = bArr[1];
            int i10 = ((bArr[3] << 8) | (bArr[2] & 255)) & 65535;
            this.f4953b = i10;
            if (b10 != -86) {
                str = String.format("LT_SYNCWORD_ERROR: %s", a.a(bArr));
            } else if (i10 < 2) {
                str = String.format("LT_PAYLOAD_OPCODE_LENGTH_ERROR: %s", a.a(bArr));
            } else if (bArr.length < i10 + 4) {
                str = String.format("LT_PAYLOAD_LENGTH_ERROR: %s", a.a(bArr));
            } else {
                byte[] bArr2 = new byte[i10];
                this.f4954c = bArr2;
                System.arraycopy(bArr, 4, bArr2, 0, i10);
                byte[] bArr3 = this.f4954c;
                this.f4955d = (short) (((bArr3[0] & 255) | (bArr3[1] << 8)) & 65535);
                int i11 = this.f4953b - 2;
                byte[] bArr4 = new byte[i11];
                this.f4956e = bArr4;
                System.arraycopy(bArr, 6, bArr4, 0, i11);
                return true;
            }
        }
        b.l(str);
        return false;
    }

    public int e() {
        return this.f4953b + 4;
    }

    public byte[] g() {
        return this.f4956e;
    }

    public byte[] h() {
        return this.f4954c;
    }

    public byte i() {
        return this.f4952a;
    }

    public boolean j() {
        return this.f4955d == 0;
    }

    public a k() {
        return a.d(this.f4956e);
    }
}
