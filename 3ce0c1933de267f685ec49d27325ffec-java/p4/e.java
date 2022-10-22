package p4;

import android.graphics.Bitmap;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;
import p4.a;
/* compiled from: StandardGifDecoder.java */
/* loaded from: classes.dex */
public class e implements a {

    /* renamed from: u  reason: collision with root package name */
    private static final String f32589u = "e";

    /* renamed from: a  reason: collision with root package name */
    private int[] f32590a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f32591b;

    /* renamed from: c  reason: collision with root package name */
    private final a.AbstractC0451a f32592c;

    /* renamed from: d  reason: collision with root package name */
    private ByteBuffer f32593d;

    /* renamed from: e  reason: collision with root package name */
    private byte[] f32594e;

    /* renamed from: f  reason: collision with root package name */
    private short[] f32595f;

    /* renamed from: g  reason: collision with root package name */
    private byte[] f32596g;

    /* renamed from: h  reason: collision with root package name */
    private byte[] f32597h;

    /* renamed from: i  reason: collision with root package name */
    private byte[] f32598i;

    /* renamed from: j  reason: collision with root package name */
    private int[] f32599j;

    /* renamed from: k  reason: collision with root package name */
    private int f32600k;

    /* renamed from: l  reason: collision with root package name */
    private c f32601l;

    /* renamed from: m  reason: collision with root package name */
    private Bitmap f32602m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f32603n;

    /* renamed from: o  reason: collision with root package name */
    private int f32604o;

    /* renamed from: p  reason: collision with root package name */
    private int f32605p;

    /* renamed from: q  reason: collision with root package name */
    private int f32606q;

    /* renamed from: r  reason: collision with root package name */
    private int f32607r;

    /* renamed from: s  reason: collision with root package name */
    private Boolean f32608s;

    /* renamed from: t  reason: collision with root package name */
    private Bitmap.Config f32609t;

    public e(a.AbstractC0451a aVar, c cVar, ByteBuffer byteBuffer, int i10) {
        this(aVar);
        r(cVar, byteBuffer, i10);
    }

    private int j(int i10, int i11, int i12) {
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        for (int i18 = i10; i18 < this.f32605p + i10; i18++) {
            byte[] bArr = this.f32598i;
            if (i18 >= bArr.length || i18 >= i11) {
                break;
            }
            int i19 = this.f32590a[bArr[i18] & 255];
            if (i19 != 0) {
                i13 += (i19 >> 24) & 255;
                i14 += (i19 >> 16) & 255;
                i15 += (i19 >> 8) & 255;
                i16 += i19 & 255;
                i17++;
            }
        }
        int i20 = i10 + i12;
        for (int i21 = i20; i21 < this.f32605p + i20; i21++) {
            byte[] bArr2 = this.f32598i;
            if (i21 >= bArr2.length || i21 >= i11) {
                break;
            }
            int i22 = this.f32590a[bArr2[i21] & 255];
            if (i22 != 0) {
                i13 += (i22 >> 24) & 255;
                i14 += (i22 >> 16) & 255;
                i15 += (i22 >> 8) & 255;
                i16 += i22 & 255;
                i17++;
            }
        }
        if (i17 == 0) {
            return 0;
        }
        return ((i13 / i17) << 24) | ((i14 / i17) << 16) | ((i15 / i17) << 8) | (i16 / i17);
    }

    private void k(b bVar) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int[] iArr = this.f32599j;
        int i15 = bVar.f32564d;
        int i16 = this.f32605p;
        int i17 = i15 / i16;
        int i18 = bVar.f32562b / i16;
        int i19 = bVar.f32563c / i16;
        int i20 = bVar.f32561a / i16;
        boolean z10 = this.f32600k == 0;
        int i21 = this.f32607r;
        int i22 = this.f32606q;
        byte[] bArr = this.f32598i;
        int[] iArr2 = this.f32590a;
        Boolean bool = this.f32608s;
        int i23 = 8;
        int i24 = 0;
        int i25 = 0;
        int i26 = 1;
        while (i24 < i17) {
            Boolean bool2 = bool;
            if (bVar.f32565e) {
                if (i25 >= i17) {
                    i10 = i17;
                    int i27 = i26 + 1;
                    if (i27 == 2) {
                        i25 = 4;
                        i26 = i27;
                    } else if (i27 == 3) {
                        i23 = 4;
                        i26 = i27;
                        i25 = 2;
                    } else if (i27 != 4) {
                        i26 = i27;
                    } else {
                        i26 = i27;
                        i25 = 1;
                        i23 = 2;
                    }
                } else {
                    i10 = i17;
                }
                i11 = i25 + i23;
            } else {
                i10 = i17;
                i11 = i25;
                i25 = i24;
            }
            int i28 = i25 + i18;
            boolean z11 = i16 == 1;
            if (i28 < i22) {
                int i29 = i28 * i21;
                int i30 = i29 + i20;
                int i31 = i30 + i19;
                int i32 = i29 + i21;
                if (i32 < i31) {
                    i31 = i32;
                }
                i12 = i11;
                int i33 = i24 * i16 * bVar.f32563c;
                if (z11) {
                    for (int i34 = i30; i34 < i31; i34++) {
                        i18 = i18;
                        int i35 = iArr2[bArr[i33] & 255];
                        if (i35 != 0) {
                            iArr[i34] = i35;
                        } else if (z10 && bool2 == null) {
                            bool2 = Boolean.TRUE;
                        }
                        i33 += i16;
                    }
                } else {
                    i14 = i18;
                    int i36 = ((i31 - i30) * i16) + i33;
                    int i37 = i30;
                    while (true) {
                        i13 = i19;
                        if (i37 < i31) {
                            int j10 = j(i33, i36, bVar.f32563c);
                            if (j10 != 0) {
                                iArr[i37] = j10;
                            } else if (z10 && bool2 == null) {
                                bool2 = Boolean.TRUE;
                            }
                            i33 += i16;
                            i37++;
                            i19 = i13;
                        }
                    }
                    bool = bool2;
                    i24++;
                    i18 = i14;
                    i19 = i13;
                    i17 = i10;
                    i25 = i12;
                }
            } else {
                i12 = i11;
            }
            i14 = i18;
            i13 = i19;
            bool = bool2;
            i24++;
            i18 = i14;
            i19 = i13;
            i17 = i10;
            i25 = i12;
        }
        Boolean bool3 = bool;
        if (this.f32608s == null) {
            this.f32608s = Boolean.valueOf(bool3 == null ? false : bool3.booleanValue());
        }
    }

    private void l(b bVar) {
        b bVar2 = bVar;
        int[] iArr = this.f32599j;
        int i10 = bVar2.f32564d;
        int i11 = bVar2.f32562b;
        int i12 = bVar2.f32563c;
        int i13 = bVar2.f32561a;
        boolean z10 = this.f32600k == 0;
        int i14 = this.f32607r;
        byte[] bArr = this.f32598i;
        int[] iArr2 = this.f32590a;
        int i15 = 0;
        byte b10 = -1;
        while (i15 < i10) {
            int i16 = (i15 + i11) * i14;
            int i17 = i16 + i13;
            int i18 = i17 + i12;
            int i19 = i16 + i14;
            if (i19 < i18) {
                i18 = i19;
            }
            int i20 = bVar2.f32563c * i15;
            for (int i21 = i17; i21 < i18; i21++) {
                byte b11 = bArr[i20];
                i10 = i10;
                int i22 = b11 & 255;
                if (i22 != b10) {
                    int i23 = iArr2[i22];
                    if (i23 != 0) {
                        iArr[i21] = i23;
                    } else {
                        b10 = b11;
                    }
                }
                i20++;
            }
            i15++;
            bVar2 = bVar;
        }
        Boolean bool = this.f32608s;
        this.f32608s = Boolean.valueOf((bool != null && bool.booleanValue()) || (this.f32608s == null && z10 && b10 != -1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void m(b bVar) {
        int i10;
        int i11;
        short s10;
        e eVar = this;
        if (bVar != null) {
            eVar.f32593d.position(bVar.f32570j);
        }
        if (bVar == null) {
            c cVar = eVar.f32601l;
            i10 = cVar.f32577f;
            i11 = cVar.f32578g;
        } else {
            i10 = bVar.f32563c;
            i11 = bVar.f32564d;
        }
        int i12 = i10 * i11;
        byte[] bArr = eVar.f32598i;
        if (bArr == null || bArr.length < i12) {
            eVar.f32598i = eVar.f32592c.e(i12);
        }
        byte[] bArr2 = eVar.f32598i;
        if (eVar.f32595f == null) {
            eVar.f32595f = new short[4096];
        }
        short[] sArr = eVar.f32595f;
        if (eVar.f32596g == null) {
            eVar.f32596g = new byte[4096];
        }
        byte[] bArr3 = eVar.f32596g;
        if (eVar.f32597h == null) {
            eVar.f32597h = new byte[4097];
        }
        byte[] bArr4 = eVar.f32597h;
        int q5 = q();
        int i13 = 1 << q5;
        int i14 = i13 + 1;
        int i15 = i13 + 2;
        int i16 = q5 + 1;
        int i17 = (1 << i16) - 1;
        int i18 = 0;
        for (int i19 = 0; i19 < i13; i19++) {
            sArr[i19] = 0;
            bArr3[i19] = (byte) i19;
        }
        byte[] bArr5 = eVar.f32594e;
        int i20 = -1;
        int i21 = i16;
        int i22 = i15;
        int i23 = i17;
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        int i29 = 0;
        int i30 = 0;
        while (true) {
            if (i18 >= i12) {
                break;
            }
            if (i24 == 0) {
                i24 = p();
                if (i24 <= 0) {
                    eVar.f32604o = 3;
                    break;
                }
                i25 = 0;
            }
            i27 += (bArr5[i25] & 255) << i26;
            int i31 = i26 + 8;
            i25++;
            i24--;
            int i32 = i22;
            int i33 = i21;
            int i34 = i20;
            int i35 = i16;
            int i36 = i29;
            while (true) {
                if (i31 < i33) {
                    i26 = i31;
                    i20 = i34;
                    i22 = i32;
                    eVar = this;
                    i29 = i36;
                    i16 = i35;
                    i21 = i33;
                    break;
                }
                int i37 = i15;
                int i38 = i27 & i23;
                i27 >>= i33;
                i31 -= i33;
                if (i38 == i13) {
                    i23 = i17;
                    i33 = i35;
                    i32 = i37;
                    i15 = i32;
                    i34 = -1;
                } else if (i38 == i14) {
                    i26 = i31;
                    i29 = i36;
                    i22 = i32;
                    i16 = i35;
                    i15 = i37;
                    i20 = i34;
                    i21 = i33;
                    eVar = this;
                    break;
                } else if (i34 == -1) {
                    bArr2[i28] = bArr3[i38];
                    i28++;
                    i18++;
                    i34 = i38;
                    i36 = i34;
                    i15 = i37;
                    i31 = i31;
                } else {
                    if (i38 >= i32) {
                        bArr4[i30] = (byte) i36;
                        i30++;
                        s10 = i34;
                    } else {
                        s10 = i38;
                    }
                    while (s10 >= i13) {
                        bArr4[i30] = bArr3[s10];
                        i30++;
                        s10 = sArr[s10];
                    }
                    i36 = bArr3[s10] & 255;
                    byte b10 = (byte) i36;
                    bArr2[i28] = b10;
                    while (true) {
                        i28++;
                        i18++;
                        if (i30 <= 0) {
                            break;
                        }
                        i30--;
                        bArr2[i28] = bArr4[i30];
                    }
                    bArr4 = bArr4;
                    if (i32 < 4096) {
                        sArr[i32] = (short) i34;
                        bArr3[i32] = b10;
                        i32++;
                        if ((i32 & i23) == 0 && i32 < 4096) {
                            i33++;
                            i23 += i32;
                        }
                    }
                    i34 = i38;
                    i15 = i37;
                    i31 = i31;
                }
            }
        }
        Arrays.fill(bArr2, i28, i12, (byte) 0);
    }

    private Bitmap o() {
        Boolean bool = this.f32608s;
        Bitmap a10 = this.f32592c.a(this.f32607r, this.f32606q, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.f32609t);
        a10.setHasAlpha(true);
        return a10;
    }

    private int p() {
        int q5 = q();
        if (q5 <= 0) {
            return q5;
        }
        ByteBuffer byteBuffer = this.f32593d;
        byteBuffer.get(this.f32594e, 0, Math.min(q5, byteBuffer.remaining()));
        return q5;
    }

    private int q() {
        return this.f32593d.get() & 255;
    }

    private Bitmap s(b bVar, b bVar2) {
        int i10;
        int i11;
        Bitmap bitmap;
        int[] iArr = this.f32599j;
        int i12 = 0;
        if (bVar2 == null) {
            Bitmap bitmap2 = this.f32602m;
            if (bitmap2 != null) {
                this.f32592c.c(bitmap2);
            }
            this.f32602m = null;
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null && bVar2.f32567g == 3 && this.f32602m == null) {
            Arrays.fill(iArr, 0);
        }
        if (bVar2 != null && (i11 = bVar2.f32567g) > 0) {
            if (i11 == 2) {
                if (!bVar.f32566f) {
                    c cVar = this.f32601l;
                    i12 = cVar.f32583l;
                    if (bVar.f32571k == null || cVar.f32581j != bVar.f32568h) {
                    }
                }
                int i13 = bVar2.f32564d;
                int i14 = this.f32605p;
                int i15 = i13 / i14;
                int i16 = bVar2.f32562b / i14;
                int i17 = bVar2.f32563c / i14;
                int i18 = bVar2.f32561a / i14;
                int i19 = this.f32607r;
                int i20 = (i16 * i19) + i18;
                int i21 = (i15 * i19) + i20;
                while (i20 < i21) {
                    int i22 = i20 + i17;
                    for (int i23 = i20; i23 < i22; i23++) {
                        iArr[i23] = i12;
                    }
                    i20 += this.f32607r;
                }
            } else if (i11 == 3 && (bitmap = this.f32602m) != null) {
                int i24 = this.f32607r;
                bitmap.getPixels(iArr, 0, i24, 0, 0, i24, this.f32606q);
            }
        }
        m(bVar);
        if (bVar.f32565e || this.f32605p != 1) {
            k(bVar);
        } else {
            l(bVar);
        }
        if (this.f32603n && ((i10 = bVar.f32567g) == 0 || i10 == 1)) {
            if (this.f32602m == null) {
                this.f32602m = o();
            }
            Bitmap bitmap3 = this.f32602m;
            int i25 = this.f32607r;
            bitmap3.setPixels(iArr, 0, i25, 0, 0, i25, this.f32606q);
        }
        Bitmap o10 = o();
        int i26 = this.f32607r;
        o10.setPixels(iArr, 0, i26, 0, 0, i26, this.f32606q);
        return o10;
    }

    @Override // p4.a
    public synchronized Bitmap a() {
        if (this.f32601l.f32574c <= 0 || this.f32600k < 0) {
            String str = f32589u;
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "Unable to decode frame, frameCount=" + this.f32601l.f32574c + ", framePointer=" + this.f32600k);
            }
            this.f32604o = 1;
        }
        int i10 = this.f32604o;
        if (!(i10 == 1 || i10 == 2)) {
            this.f32604o = 0;
            if (this.f32594e == null) {
                this.f32594e = this.f32592c.e(255);
            }
            b bVar = this.f32601l.f32576e.get(this.f32600k);
            int i11 = this.f32600k - 1;
            b bVar2 = i11 >= 0 ? this.f32601l.f32576e.get(i11) : null;
            int[] iArr = bVar.f32571k;
            if (iArr == null) {
                iArr = this.f32601l.f32572a;
            }
            this.f32590a = iArr;
            if (iArr == null) {
                String str2 = f32589u;
                if (Log.isLoggable(str2, 3)) {
                    Log.d(str2, "No valid color table found for frame #" + this.f32600k);
                }
                this.f32604o = 1;
                return null;
            }
            if (bVar.f32566f) {
                System.arraycopy(iArr, 0, this.f32591b, 0, iArr.length);
                int[] iArr2 = this.f32591b;
                this.f32590a = iArr2;
                iArr2[bVar.f32568h] = 0;
                if (bVar.f32567g == 2 && this.f32600k == 0) {
                    this.f32608s = Boolean.TRUE;
                }
            }
            return s(bVar, bVar2);
        }
        String str3 = f32589u;
        if (Log.isLoggable(str3, 3)) {
            Log.d(str3, "Unable to decode frame, status=" + this.f32604o);
        }
        return null;
    }

    @Override // p4.a
    public void b() {
        this.f32600k = (this.f32600k + 1) % this.f32601l.f32574c;
    }

    @Override // p4.a
    public ByteBuffer c() {
        return this.f32593d;
    }

    @Override // p4.a
    public void clear() {
        this.f32601l = null;
        byte[] bArr = this.f32598i;
        if (bArr != null) {
            this.f32592c.d(bArr);
        }
        int[] iArr = this.f32599j;
        if (iArr != null) {
            this.f32592c.f(iArr);
        }
        Bitmap bitmap = this.f32602m;
        if (bitmap != null) {
            this.f32592c.c(bitmap);
        }
        this.f32602m = null;
        this.f32593d = null;
        this.f32608s = null;
        byte[] bArr2 = this.f32594e;
        if (bArr2 != null) {
            this.f32592c.d(bArr2);
        }
    }

    @Override // p4.a
    public int d() {
        return this.f32601l.f32574c;
    }

    @Override // p4.a
    public int e() {
        int i10;
        if (this.f32601l.f32574c <= 0 || (i10 = this.f32600k) < 0) {
            return 0;
        }
        return n(i10);
    }

    @Override // p4.a
    public void f(Bitmap.Config config) {
        if (config == Bitmap.Config.ARGB_8888 || config == Bitmap.Config.RGB_565) {
            this.f32609t = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888 + " or " + Bitmap.Config.RGB_565);
    }

    @Override // p4.a
    public void g() {
        this.f32600k = -1;
    }

    @Override // p4.a
    public int h() {
        return this.f32600k;
    }

    @Override // p4.a
    public int i() {
        return this.f32593d.limit() + this.f32598i.length + (this.f32599j.length * 4);
    }

    public int n(int i10) {
        if (i10 >= 0) {
            c cVar = this.f32601l;
            if (i10 < cVar.f32574c) {
                return cVar.f32576e.get(i10).f32569i;
            }
        }
        return -1;
    }

    public synchronized void r(c cVar, ByteBuffer byteBuffer, int i10) {
        if (i10 > 0) {
            int highestOneBit = Integer.highestOneBit(i10);
            this.f32604o = 0;
            this.f32601l = cVar;
            this.f32600k = -1;
            ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
            this.f32593d = asReadOnlyBuffer;
            asReadOnlyBuffer.position(0);
            this.f32593d.order(ByteOrder.LITTLE_ENDIAN);
            this.f32603n = false;
            Iterator<b> it = cVar.f32576e.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().f32567g == 3) {
                        this.f32603n = true;
                        break;
                    }
                } else {
                    break;
                }
            }
            this.f32605p = highestOneBit;
            int i11 = cVar.f32577f;
            this.f32607r = i11 / highestOneBit;
            int i12 = cVar.f32578g;
            this.f32606q = i12 / highestOneBit;
            this.f32598i = this.f32592c.e(i11 * i12);
            this.f32599j = this.f32592c.b(this.f32607r * this.f32606q);
        } else {
            throw new IllegalArgumentException("Sample size must be >=0, not: " + i10);
        }
    }

    public e(a.AbstractC0451a aVar) {
        this.f32591b = new int[256];
        this.f32609t = Bitmap.Config.ARGB_8888;
        this.f32592c = aVar;
        this.f32601l = new c();
    }
}
