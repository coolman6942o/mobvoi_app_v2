package com.google.protobuf.nano;

import java.io.IOException;
/* compiled from: CodedInputByteBufferNano.java */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f13287a;

    /* renamed from: b  reason: collision with root package name */
    private int f13288b;

    /* renamed from: c  reason: collision with root package name */
    private int f13289c;

    /* renamed from: d  reason: collision with root package name */
    private int f13290d;

    /* renamed from: e  reason: collision with root package name */
    private int f13291e;

    /* renamed from: f  reason: collision with root package name */
    private int f13292f;

    /* renamed from: h  reason: collision with root package name */
    private int f13294h;

    /* renamed from: g  reason: collision with root package name */
    private int f13293g = Integer.MAX_VALUE;

    /* renamed from: i  reason: collision with root package name */
    private int f13295i = 64;

    private a(byte[] bArr, int i10, int i11) {
        this.f13287a = bArr;
        this.f13288b = i10;
        this.f13289c = i11 + i10;
        this.f13291e = i10;
    }

    public static long b(long j10) {
        return (-(j10 & 1)) ^ (j10 >>> 1);
    }

    public static a e(byte[] bArr, int i10, int i11) {
        return new a(bArr, i10, i11);
    }

    private void y() {
        int i10 = this.f13289c + this.f13290d;
        this.f13289c = i10;
        int i11 = this.f13293g;
        if (i10 > i11) {
            int i12 = i10 - i11;
            this.f13290d = i12;
            this.f13289c = i10 - i12;
            return;
        }
        this.f13290d = 0;
    }

    public boolean A(int i10) throws IOException {
        int c10 = e.c(i10);
        if (c10 == 0) {
            k();
            return true;
        } else if (c10 == 1) {
            q();
            return true;
        } else if (c10 == 2) {
            C(r());
            return true;
        } else if (c10 == 3) {
            B();
            a(e.d(e.b(i10), 4));
            return true;
        } else if (c10 == 4) {
            return false;
        } else {
            if (c10 == 5) {
                p();
                return true;
            }
            throw InvalidProtocolBufferNanoException.c();
        }
    }

    public void B() throws IOException {
        int v10;
        do {
            v10 = v();
            if (v10 == 0) {
                return;
            }
        } while (A(v10));
    }

    public void C(int i10) throws IOException {
        if (i10 >= 0) {
            int i11 = this.f13291e;
            int i12 = i11 + i10;
            int i13 = this.f13293g;
            if (i12 > i13) {
                C(i13 - i11);
                throw InvalidProtocolBufferNanoException.i();
            } else if (i10 <= this.f13289c - i11) {
                this.f13291e = i11 + i10;
            } else {
                throw InvalidProtocolBufferNanoException.i();
            }
        } else {
            throw InvalidProtocolBufferNanoException.g();
        }
    }

    public void a(int i10) throws InvalidProtocolBufferNanoException {
        if (this.f13292f != i10) {
            throw InvalidProtocolBufferNanoException.a();
        }
    }

    public int c() {
        return this.f13291e - this.f13288b;
    }

    public boolean d() {
        return this.f13291e == this.f13289c;
    }

    public void f(int i10) {
        this.f13293g = i10;
        y();
    }

    public int g(int i10) throws InvalidProtocolBufferNanoException {
        if (i10 >= 0) {
            int i11 = i10 + this.f13291e;
            int i12 = this.f13293g;
            if (i11 <= i12) {
                this.f13293g = i11;
                y();
                return i12;
            }
            throw InvalidProtocolBufferNanoException.i();
        }
        throw InvalidProtocolBufferNanoException.g();
    }

    public boolean h() throws IOException {
        return r() != 0;
    }

    public byte[] i() throws IOException {
        int r10 = r();
        int i10 = this.f13289c;
        int i11 = this.f13291e;
        if (r10 <= i10 - i11 && r10 > 0) {
            byte[] bArr = new byte[r10];
            System.arraycopy(this.f13287a, i11, bArr, 0, r10);
            this.f13291e += r10;
            return bArr;
        } else if (r10 == 0) {
            return e.f13298a;
        } else {
            return o(r10);
        }
    }

    public float j() throws IOException {
        return Float.intBitsToFloat(p());
    }

    public int k() throws IOException {
        return r();
    }

    public long l() throws IOException {
        return s();
    }

    public void m(c cVar) throws IOException {
        int r10 = r();
        if (this.f13294h < this.f13295i) {
            int g10 = g(r10);
            this.f13294h++;
            cVar.mergeFrom(this);
            a(0);
            this.f13294h--;
            f(g10);
            return;
        }
        throw InvalidProtocolBufferNanoException.h();
    }

    public byte n() throws IOException {
        int i10 = this.f13291e;
        if (i10 != this.f13289c) {
            byte[] bArr = this.f13287a;
            this.f13291e = i10 + 1;
            return bArr[i10];
        }
        throw InvalidProtocolBufferNanoException.i();
    }

    public byte[] o(int i10) throws IOException {
        if (i10 >= 0) {
            int i11 = this.f13291e;
            int i12 = i11 + i10;
            int i13 = this.f13293g;
            if (i12 > i13) {
                C(i13 - i11);
                throw InvalidProtocolBufferNanoException.i();
            } else if (i10 <= this.f13289c - i11) {
                byte[] bArr = new byte[i10];
                System.arraycopy(this.f13287a, i11, bArr, 0, i10);
                this.f13291e += i10;
                return bArr;
            } else {
                throw InvalidProtocolBufferNanoException.i();
            }
        } else {
            throw InvalidProtocolBufferNanoException.g();
        }
    }

    public int p() throws IOException {
        return (n() & 255) | ((n() & 255) << 8) | ((n() & 255) << 16) | ((n() & 255) << 24);
    }

    public long q() throws IOException {
        byte n10 = n();
        byte n11 = n();
        return ((n11 & 255) << 8) | (n10 & 255) | ((n() & 255) << 16) | ((n() & 255) << 24) | ((n() & 255) << 32) | ((n() & 255) << 40) | ((n() & 255) << 48) | ((n() & 255) << 56);
    }

    public int r() throws IOException {
        int i10;
        byte n10 = n();
        if (n10 >= 0) {
            return n10;
        }
        int i11 = n10 & Byte.MAX_VALUE;
        byte n11 = n();
        if (n11 >= 0) {
            i10 = n11 << 7;
        } else {
            i11 |= (n11 & Byte.MAX_VALUE) << 7;
            byte n12 = n();
            if (n12 >= 0) {
                i10 = n12 << 14;
            } else {
                i11 |= (n12 & Byte.MAX_VALUE) << 14;
                byte n13 = n();
                if (n13 >= 0) {
                    i10 = n13 << 21;
                } else {
                    int i12 = i11 | ((n13 & Byte.MAX_VALUE) << 21);
                    byte n14 = n();
                    int i13 = i12 | (n14 << 28);
                    if (n14 >= 0) {
                        return i13;
                    }
                    for (int i14 = 0; i14 < 5; i14++) {
                        if (n() >= 0) {
                            return i13;
                        }
                    }
                    throw InvalidProtocolBufferNanoException.d();
                }
            }
        }
        return i11 | i10;
    }

    public long s() throws IOException {
        long j10 = 0;
        for (int i10 = 0; i10 < 64; i10 += 7) {
            byte n10 = n();
            j10 |= (n10 & Byte.MAX_VALUE) << i10;
            if ((n10 & 128) == 0) {
                return j10;
            }
        }
        throw InvalidProtocolBufferNanoException.d();
    }

    public long t() throws IOException {
        return b(s());
    }

    public String u() throws IOException {
        int r10 = r();
        int i10 = this.f13289c;
        int i11 = this.f13291e;
        if (r10 > i10 - i11 || r10 <= 0) {
            return new String(o(r10), b.f13296a);
        }
        String str = new String(this.f13287a, i11, r10, b.f13296a);
        this.f13291e += r10;
        return str;
    }

    public int v() throws IOException {
        if (d()) {
            this.f13292f = 0;
            return 0;
        }
        int r10 = r();
        this.f13292f = r10;
        if (r10 != 0) {
            return r10;
        }
        throw InvalidProtocolBufferNanoException.b();
    }

    public int w() throws IOException {
        return r();
    }

    public long x() throws IOException {
        return s();
    }

    public void z(int i10) {
        int i11 = this.f13291e;
        int i12 = this.f13288b;
        if (i10 > i11 - i12) {
            throw new IllegalArgumentException("Position " + i10 + " is beyond current " + (this.f13291e - this.f13288b));
        } else if (i10 >= 0) {
            this.f13291e = i12 + i10;
        } else {
            throw new IllegalArgumentException("Bad position " + i10);
        }
    }
}
