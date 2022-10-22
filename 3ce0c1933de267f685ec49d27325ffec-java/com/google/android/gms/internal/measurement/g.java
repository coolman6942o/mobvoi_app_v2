package com.google.android.gms.internal.measurement;

import java.io.IOException;
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f9282a;

    /* renamed from: b  reason: collision with root package name */
    private final int f9283b;

    /* renamed from: c  reason: collision with root package name */
    private int f9284c;

    /* renamed from: d  reason: collision with root package name */
    private int f9285d;

    /* renamed from: e  reason: collision with root package name */
    private int f9286e;

    /* renamed from: f  reason: collision with root package name */
    private int f9287f;

    /* renamed from: h  reason: collision with root package name */
    private int f9289h;

    /* renamed from: g  reason: collision with root package name */
    private int f9288g = Integer.MAX_VALUE;

    /* renamed from: i  reason: collision with root package name */
    private int f9290i = 64;

    private g(byte[] bArr, int i10, int i11) {
        this.f9282a = bArr;
        this.f9283b = i10;
        this.f9284c = i11 + i10;
        this.f9286e = i10;
    }

    public static g c(byte[] bArr, int i10, int i11) {
        return new g(bArr, 0, i11);
    }

    private final void j(int i10) throws IOException {
        if (i10 >= 0) {
            int i11 = this.f9286e;
            int i12 = i11 + i10;
            int i13 = this.f9288g;
            if (i12 > i13) {
                j(i13 - i11);
                throw zzacd.a();
            } else if (i10 <= this.f9284c - i11) {
                this.f9286e = i11 + i10;
            } else {
                throw zzacd.a();
            }
        } else {
            throw zzacd.b();
        }
    }

    private final void m() {
        int i10 = this.f9284c + this.f9285d;
        this.f9284c = i10;
        int i11 = this.f9288g;
        if (i10 > i11) {
            int i12 = i10 - i11;
            this.f9285d = i12;
            this.f9284c = i10 - i12;
            return;
        }
        this.f9285d = 0;
    }

    private final byte u() throws IOException {
        int i10 = this.f9286e;
        if (i10 != this.f9284c) {
            byte[] bArr = this.f9282a;
            this.f9286e = i10 + 1;
            return bArr[i10];
        }
        throw zzacd.a();
    }

    public final int a() {
        return this.f9286e - this.f9283b;
    }

    public final String b() throws IOException {
        int p10 = p();
        if (p10 >= 0) {
            int i10 = this.f9284c;
            int i11 = this.f9286e;
            if (p10 <= i10 - i11) {
                String str = new String(this.f9282a, i11, p10, m.f9496a);
                this.f9286e += p10;
                return str;
            }
            throw zzacd.a();
        }
        throw zzacd.b();
    }

    public final void d(n nVar) throws IOException {
        int p10 = p();
        if (this.f9289h < this.f9290i) {
            int e10 = e(p10);
            this.f9289h++;
            nVar.c(this);
            f(0);
            this.f9289h--;
            h(e10);
            return;
        }
        throw zzacd.d();
    }

    public final int e(int i10) throws zzacd {
        if (i10 >= 0) {
            int i11 = i10 + this.f9286e;
            int i12 = this.f9288g;
            if (i11 <= i12) {
                this.f9288g = i11;
                m();
                return i12;
            }
            throw zzacd.a();
        }
        throw zzacd.b();
    }

    public final void f(int i10) throws zzacd {
        if (this.f9287f != i10) {
            throw new zzacd("Protocol message end-group tag did not match expected tag.");
        }
    }

    public final boolean g(int i10) throws IOException {
        int n10;
        int i11 = i10 & 7;
        if (i11 == 0) {
            p();
            return true;
        } else if (i11 == 1) {
            s();
            return true;
        } else if (i11 == 2) {
            j(p());
            return true;
        } else if (i11 == 3) {
            do {
                n10 = n();
                if (n10 == 0) {
                    break;
                }
            } while (g(n10));
            f(((i10 >>> 3) << 3) | 4);
            return true;
        } else if (i11 == 4) {
            return false;
        } else {
            if (i11 == 5) {
                r();
                return true;
            }
            throw new zzacd("Protocol message tag had invalid wire type.");
        }
    }

    public final void h(int i10) {
        this.f9288g = i10;
        m();
    }

    public final void i(int i10) {
        l(i10, this.f9287f);
    }

    public final byte[] k(int i10, int i11) {
        if (i11 == 0) {
            return q.f9600c;
        }
        byte[] bArr = new byte[i11];
        System.arraycopy(this.f9282a, this.f9283b + i10, bArr, 0, i11);
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void l(int i10, int i11) {
        int i12 = this.f9286e;
        int i13 = this.f9283b;
        if (i10 > i12 - i13) {
            StringBuilder sb2 = new StringBuilder(50);
            sb2.append("Position ");
            sb2.append(i10);
            sb2.append(" is beyond current ");
            sb2.append(this.f9286e - this.f9283b);
            throw new IllegalArgumentException(sb2.toString());
        } else if (i10 >= 0) {
            this.f9286e = i13 + i10;
            this.f9287f = i11;
        } else {
            StringBuilder sb3 = new StringBuilder(24);
            sb3.append("Bad position ");
            sb3.append(i10);
            throw new IllegalArgumentException(sb3.toString());
        }
    }

    public final int n() throws IOException {
        if (this.f9286e == this.f9284c) {
            this.f9287f = 0;
            return 0;
        }
        int p10 = p();
        this.f9287f = p10;
        if (p10 != 0) {
            return p10;
        }
        throw new zzacd("Protocol message contained an invalid tag (zero).");
    }

    public final boolean o() throws IOException {
        return p() != 0;
    }

    public final int p() throws IOException {
        int i10;
        byte u10 = u();
        if (u10 >= 0) {
            return u10;
        }
        int i11 = u10 & Byte.MAX_VALUE;
        byte u11 = u();
        if (u11 >= 0) {
            i10 = u11 << 7;
        } else {
            i11 |= (u11 & Byte.MAX_VALUE) << 7;
            byte u12 = u();
            if (u12 >= 0) {
                i10 = u12 << 14;
            } else {
                i11 |= (u12 & Byte.MAX_VALUE) << 14;
                byte u13 = u();
                if (u13 >= 0) {
                    i10 = u13 << 21;
                } else {
                    int i12 = i11 | ((u13 & Byte.MAX_VALUE) << 21);
                    byte u14 = u();
                    int i13 = i12 | (u14 << 28);
                    if (u14 >= 0) {
                        return i13;
                    }
                    for (int i14 = 0; i14 < 5; i14++) {
                        if (u() >= 0) {
                            return i13;
                        }
                    }
                    throw zzacd.c();
                }
            }
        }
        return i11 | i10;
    }

    public final long q() throws IOException {
        long j10 = 0;
        for (int i10 = 0; i10 < 64; i10 += 7) {
            byte u10 = u();
            j10 |= (u10 & Byte.MAX_VALUE) << i10;
            if ((u10 & 128) == 0) {
                return j10;
            }
        }
        throw zzacd.c();
    }

    public final int r() throws IOException {
        return (u() & 255) | ((u() & 255) << 8) | ((u() & 255) << 16) | ((u() & 255) << 24);
    }

    public final long s() throws IOException {
        byte u10 = u();
        byte u11 = u();
        return ((u11 & 255) << 8) | (u10 & 255) | ((u() & 255) << 16) | ((u() & 255) << 24) | ((u() & 255) << 32) | ((u() & 255) << 40) | ((u() & 255) << 48) | ((u() & 255) << 56);
    }

    public final int t() {
        int i10 = this.f9288g;
        if (i10 == Integer.MAX_VALUE) {
            return -1;
        }
        return i10 - this.f9286e;
    }
}
