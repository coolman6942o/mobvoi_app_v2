package com.google.common.hash;

import com.google.common.base.p;
import java.io.Serializable;
/* compiled from: HashCode.java */
/* loaded from: classes.dex */
public abstract class h {
    private static final char[] hexDigits = "0123456789abcdef".toCharArray();

    /* compiled from: HashCode.java */
    /* loaded from: classes.dex */
    private static final class a extends h implements Serializable {
        private static final long serialVersionUID = 0;
        final byte[] bytes;

        a(byte[] bArr) {
            this.bytes = (byte[]) p.o(bArr);
        }

        @Override // com.google.common.hash.h
        public byte[] a() {
            return (byte[]) this.bytes.clone();
        }

        @Override // com.google.common.hash.h
        public int b() {
            byte[] bArr = this.bytes;
            p.w(bArr.length >= 4, "HashCode#asInt() requires >= 4 bytes (it only has %s bytes).", bArr.length);
            byte[] bArr2 = this.bytes;
            return ((bArr2[3] & 255) << 24) | (bArr2[0] & 255) | ((bArr2[1] & 255) << 8) | ((bArr2[2] & 255) << 16);
        }

        @Override // com.google.common.hash.h
        public long c() {
            byte[] bArr = this.bytes;
            p.w(bArr.length >= 8, "HashCode#asLong() requires >= 8 bytes (it only has %s bytes).", bArr.length);
            return j();
        }

        @Override // com.google.common.hash.h
        public int d() {
            return this.bytes.length * 8;
        }

        @Override // com.google.common.hash.h
        boolean g(h hVar) {
            if (this.bytes.length != hVar.i().length) {
                return false;
            }
            boolean z10 = true;
            int i10 = 0;
            while (true) {
                byte[] bArr = this.bytes;
                if (i10 >= bArr.length) {
                    return z10;
                }
                z10 &= bArr[i10] == hVar.i()[i10];
                i10++;
            }
        }

        @Override // com.google.common.hash.h
        byte[] i() {
            return this.bytes;
        }

        public long j() {
            long j10 = this.bytes[0] & 255;
            for (int i10 = 1; i10 < Math.min(this.bytes.length, 8); i10++) {
                j10 |= (this.bytes[i10] & 255) << (i10 * 8);
            }
            return j10;
        }
    }

    h() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static h h(byte[] bArr) {
        return new a(bArr);
    }

    public abstract byte[] a();

    public abstract int b();

    public abstract long c();

    public abstract int d();

    public final boolean equals(Object obj) {
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return d() == hVar.d() && g(hVar);
    }

    abstract boolean g(h hVar);

    public final int hashCode() {
        if (d() >= 32) {
            return b();
        }
        byte[] i10 = i();
        int i11 = i10[0] & 255;
        for (int i12 = 1; i12 < i10.length; i12++) {
            i11 |= (i10[i12] & 255) << (i12 * 8);
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] i() {
        return a();
    }

    public final String toString() {
        byte[] i10 = i();
        StringBuilder sb2 = new StringBuilder(i10.length * 2);
        for (byte b10 : i10) {
            char[] cArr = hexDigits;
            sb2.append(cArr[(b10 >> 4) & 15]);
            sb2.append(cArr[b10 & 15]);
        }
        return sb2.toString();
    }
}
