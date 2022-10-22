package p4;

import android.util.Log;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
/* compiled from: GifHeaderParser.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: b  reason: collision with root package name */
    private ByteBuffer f32586b;

    /* renamed from: c  reason: collision with root package name */
    private c f32587c;

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f32585a = new byte[256];

    /* renamed from: d  reason: collision with root package name */
    private int f32588d = 0;

    private boolean b() {
        return this.f32587c.f32573b != 0;
    }

    private int d() {
        try {
            return this.f32586b.get() & 255;
        } catch (Exception unused) {
            this.f32587c.f32573b = 1;
            return 0;
        }
    }

    private void e() {
        this.f32587c.f32575d.f32561a = n();
        this.f32587c.f32575d.f32562b = n();
        this.f32587c.f32575d.f32563c = n();
        this.f32587c.f32575d.f32564d = n();
        int d10 = d();
        boolean z10 = false;
        boolean z11 = (d10 & 128) != 0;
        int pow = (int) Math.pow(2.0d, (d10 & 7) + 1);
        b bVar = this.f32587c.f32575d;
        if ((d10 & 64) != 0) {
            z10 = true;
        }
        bVar.f32565e = z10;
        if (z11) {
            bVar.f32571k = g(pow);
        } else {
            bVar.f32571k = null;
        }
        this.f32587c.f32575d.f32570j = this.f32586b.position();
        r();
        if (!b()) {
            c cVar = this.f32587c;
            cVar.f32574c++;
            cVar.f32576e.add(cVar.f32575d);
        }
    }

    private void f() {
        int d10 = d();
        this.f32588d = d10;
        if (d10 > 0) {
            int i10 = 0;
            int i11 = 0;
            while (true) {
                try {
                    i11 = this.f32588d;
                    if (i10 < i11) {
                        i11 -= i10;
                        this.f32586b.get(this.f32585a, i10, i11);
                        i10 += i11;
                    } else {
                        return;
                    }
                } catch (Exception e10) {
                    if (Log.isLoggable("GifHeaderParser", 3)) {
                        Log.d("GifHeaderParser", "Error Reading Block n: " + i10 + " count: " + i11 + " blockSize: " + this.f32588d, e10);
                    }
                    this.f32587c.f32573b = 1;
                    return;
                }
            }
        }
    }

    private int[] g(int i10) {
        byte[] bArr = new byte[i10 * 3];
        int[] iArr = null;
        try {
            this.f32586b.get(bArr);
            iArr = new int[256];
            int i11 = 0;
            int i12 = 0;
            while (i11 < i10) {
                int i13 = i12 + 1;
                int i14 = bArr[i12] & 255;
                int i15 = i13 + 1;
                i12 = i15 + 1;
                i11++;
                iArr[i11] = (i14 << 16) | (-16777216) | ((bArr[i13] & 255) << 8) | (bArr[i15] & 255);
            }
        } catch (BufferUnderflowException e10) {
            if (Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", e10);
            }
            this.f32587c.f32573b = 1;
        }
        return iArr;
    }

    private void h() {
        i(Integer.MAX_VALUE);
    }

    private void i(int i10) {
        boolean z10 = false;
        while (!z10 && !b() && this.f32587c.f32574c <= i10) {
            int d10 = d();
            if (d10 == 33) {
                int d11 = d();
                if (d11 == 1) {
                    q();
                } else if (d11 == 249) {
                    this.f32587c.f32575d = new b();
                    j();
                } else if (d11 == 254) {
                    q();
                } else if (d11 != 255) {
                    q();
                } else {
                    f();
                    StringBuilder sb2 = new StringBuilder();
                    for (int i11 = 0; i11 < 11; i11++) {
                        sb2.append((char) this.f32585a[i11]);
                    }
                    if (sb2.toString().equals("NETSCAPE2.0")) {
                        m();
                    } else {
                        q();
                    }
                }
            } else if (d10 == 44) {
                c cVar = this.f32587c;
                if (cVar.f32575d == null) {
                    cVar.f32575d = new b();
                }
                e();
            } else if (d10 != 59) {
                this.f32587c.f32573b = 1;
            } else {
                z10 = true;
            }
        }
    }

    private void j() {
        d();
        int d10 = d();
        b bVar = this.f32587c.f32575d;
        int i10 = (d10 & 28) >> 2;
        bVar.f32567g = i10;
        boolean z10 = true;
        if (i10 == 0) {
            bVar.f32567g = 1;
        }
        if ((d10 & 1) == 0) {
            z10 = false;
        }
        bVar.f32566f = z10;
        int n10 = n();
        if (n10 < 2) {
            n10 = 10;
        }
        b bVar2 = this.f32587c.f32575d;
        bVar2.f32569i = n10 * 10;
        bVar2.f32568h = d();
        d();
    }

    private void k() {
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < 6; i10++) {
            sb2.append((char) d());
        }
        if (!sb2.toString().startsWith("GIF")) {
            this.f32587c.f32573b = 1;
            return;
        }
        l();
        if (this.f32587c.f32579h && !b()) {
            c cVar = this.f32587c;
            cVar.f32572a = g(cVar.f32580i);
            c cVar2 = this.f32587c;
            cVar2.f32583l = cVar2.f32572a[cVar2.f32581j];
        }
    }

    private void l() {
        this.f32587c.f32577f = n();
        this.f32587c.f32578g = n();
        int d10 = d();
        c cVar = this.f32587c;
        cVar.f32579h = (d10 & 128) != 0;
        cVar.f32580i = (int) Math.pow(2.0d, (d10 & 7) + 1);
        this.f32587c.f32581j = d();
        this.f32587c.f32582k = d();
    }

    private void m() {
        do {
            f();
            byte[] bArr = this.f32585a;
            if (bArr[0] == 1) {
                this.f32587c.f32584m = ((bArr[2] & 255) << 8) | (bArr[1] & 255);
            }
            if (this.f32588d <= 0) {
                return;
            }
        } while (!b());
    }

    private int n() {
        return this.f32586b.getShort();
    }

    private void o() {
        this.f32586b = null;
        Arrays.fill(this.f32585a, (byte) 0);
        this.f32587c = new c();
        this.f32588d = 0;
    }

    private void q() {
        int d10;
        do {
            d10 = d();
            this.f32586b.position(Math.min(this.f32586b.position() + d10, this.f32586b.limit()));
        } while (d10 > 0);
    }

    private void r() {
        d();
        q();
    }

    public void a() {
        this.f32586b = null;
        this.f32587c = null;
    }

    public c c() {
        if (this.f32586b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        } else if (b()) {
            return this.f32587c;
        } else {
            k();
            if (!b()) {
                h();
                c cVar = this.f32587c;
                if (cVar.f32574c < 0) {
                    cVar.f32573b = 1;
                }
            }
            return this.f32587c;
        }
    }

    public d p(ByteBuffer byteBuffer) {
        o();
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.f32586b = asReadOnlyBuffer;
        asReadOnlyBuffer.position(0);
        this.f32586b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }
}
