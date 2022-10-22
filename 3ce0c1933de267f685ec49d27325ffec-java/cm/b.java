package cm;

import com.realsil.sdk.dfu.model.CharacteristicInfo;
import com.realsil.sdk.dfu.model.ImageVersionInfo;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import jl.a;
/* loaded from: classes2.dex */
public class b {
    public byte[] A;
    public byte[] D;
    public int E;
    public int F;
    public int G;
    public int H;
    public int I;
    public int J;
    public int K;
    public boolean N;
    public byte[] P;
    public List<ImageVersionInfo> Q;
    public byte[] R;
    public List<ImageVersionInfo> S;
    public byte[] T;
    public List<CharacteristicInfo> U;
    public int V;
    public int W;
    public byte X;
    public byte Y;

    /* renamed from: a  reason: collision with root package name */
    public int f5995a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f5996b;

    /* renamed from: c  reason: collision with root package name */
    public int f5997c;

    /* renamed from: d  reason: collision with root package name */
    public int f5998d;

    /* renamed from: e  reason: collision with root package name */
    public int f5999e;

    /* renamed from: f  reason: collision with root package name */
    public int f6000f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f6001g;

    /* renamed from: h  reason: collision with root package name */
    public int f6002h;

    /* renamed from: i  reason: collision with root package name */
    public int f6003i;

    /* renamed from: l  reason: collision with root package name */
    public int f6006l;

    /* renamed from: p  reason: collision with root package name */
    public boolean f6010p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f6011q;

    /* renamed from: s  reason: collision with root package name */
    public boolean f6013s;

    /* renamed from: v  reason: collision with root package name */
    public boolean f6016v;

    /* renamed from: j  reason: collision with root package name */
    public int f6004j = 3;

    /* renamed from: k  reason: collision with root package name */
    public int f6005k = 0;

    /* renamed from: m  reason: collision with root package name */
    public int f6007m = 0;

    /* renamed from: n  reason: collision with root package name */
    public int f6008n = 0;

    /* renamed from: o  reason: collision with root package name */
    public int f6009o = 2;

    /* renamed from: r  reason: collision with root package name */
    public int f6012r = 1;

    /* renamed from: t  reason: collision with root package name */
    public int f6014t = 0;

    /* renamed from: u  reason: collision with root package name */
    public boolean f6015u = true;

    /* renamed from: w  reason: collision with root package name */
    public int f6017w = 0;

    /* renamed from: x  reason: collision with root package name */
    public int f6018x = 0;

    /* renamed from: y  reason: collision with root package name */
    public int f6019y = 0;

    /* renamed from: z  reason: collision with root package name */
    public boolean f6020z = false;
    public int B = 256;
    public int C = 0;
    public int L = 0;
    public int M = 1;
    public int O = 0;

    public int A() {
        return this.W;
    }

    public int B() {
        return this.G;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0029, code lost:
        if (r0 != 10) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0079, code lost:
        if (r0 != 10) goto L52;
     */
    /* JADX WARN: Removed duplicated region for block: B:54:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0090 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int C() {
        ImageVersionInfo imageVersionInfo;
        int a10;
        int i10 = this.f5995a;
        if (i10 == 16) {
            int i11 = this.f6004j;
            if (i11 > 3) {
                if (i11 != 5) {
                    if (i11 != 9) {
                        if (i11 != 12) {
                            if (i11 != 4) {
                                if (i11 != 6) {
                                    if (i11 != 7) {
                                        if (i11 != 8) {
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                a10 = a(4, this.L);
                imageVersionInfo = p(a10);
                if (imageVersionInfo != null) {
                    return imageVersionInfo.d();
                }
                return 0;
            }
            a10 = a(0, this.L);
            imageVersionInfo = p(a10);
            if (imageVersionInfo != null) {
            }
        } else if (i10 == 17) {
            int i12 = this.f6004j;
            if (i12 > 3) {
                if (!(i12 == 5 || i12 == 9 || i12 == 12)) {
                    if (i12 == 4 || i12 == 6 || i12 == 7 || i12 == 8 || i12 == 10) {
                        if (this.f6005k >= 6) {
                            imageVersionInfo = q(10130);
                            if (imageVersionInfo != null) {
                            }
                        }
                    }
                    imageVersionInfo = null;
                    if (imageVersionInfo != null) {
                    }
                }
                a10 = a(4, this.L);
                imageVersionInfo = p(a10);
                if (imageVersionInfo != null) {
                }
            }
            a10 = a(0, this.L);
            imageVersionInfo = p(a10);
            if (imageVersionInfo != null) {
            }
        } else {
            int i13 = this.f6005k;
            if (i13 == 0) {
                return this.E;
            }
            if (i13 == 1) {
                int i14 = this.f6004j;
                if (i14 > 3) {
                    if (i14 != 5) {
                        if (i14 != 9) {
                            if (i14 != 12) {
                                if (i14 != 4) {
                                    if (i14 != 6) {
                                        if (i14 != 7) {
                                            if (i14 != 8) {
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    a10 = a(4, this.L);
                    imageVersionInfo = p(a10);
                    if (imageVersionInfo != null) {
                    }
                }
                a10 = a(0, this.L);
                imageVersionInfo = p(a10);
                if (imageVersionInfo != null) {
                }
            } else if (i13 == 2) {
                return this.E;
            }
            imageVersionInfo = null;
            if (imageVersionInfo != null) {
            }
        }
    }

    public int D() {
        return this.f6002h;
    }

    public int E() {
        return this.f5995a;
    }

    public byte[] F() {
        return this.A;
    }

    public int G() {
        return this.f6019y;
    }

    public int H() {
        return this.f6018x;
    }

    public int I() {
        return this.f6003i;
    }

    public int J() {
        int i10 = this.O;
        if (i10 == 1) {
            return 0;
        }
        return i10 == 2 ? 1 : 15;
    }

    public int K() {
        return this.M;
    }

    public final void L() {
        int i10;
        int i11;
        int i12;
        int i13;
        byte b10;
        int i14;
        int i15 = 0;
        il.b.j(String.format("imageVersionIndicator = 0x%08x, \ninactiveImageVersionValues = %s", Integer.valueOf(this.L), a.a(this.R)));
        ArrayList arrayList = new ArrayList();
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        while (i16 < 16) {
            int i19 = (this.L >> (i16 * 2)) & 3;
            if (i19 == 0) {
                ImageVersionInfo imageVersionInfo = new ImageVersionInfo(i16, i19, -1, i15);
                il.b.j(imageVersionInfo.toString());
                arrayList.add(imageVersionInfo);
            } else {
                byte[] bArr = this.R;
                if (bArr == null || (i13 = i17 + 3) >= bArr.length) {
                    il.b.k(true, "imageVersion loss, offset=" + i17);
                    i10 = 0;
                } else {
                    if (this.f5995a != 17) {
                        i14 = ((bArr[i13] << 24) & (-16777216)) | ((bArr[i17 + 2] << 16) & 16711680) | ((bArr[i17 + 1] << 8) & 65280);
                        b10 = bArr[i17];
                    } else if (this.f6005k < 5) {
                        i14 = ((bArr[i13] << 24) & (-16777216)) | ((bArr[i17 + 2] << 16) & 16711680) | ((bArr[i17 + 1] << 8) & 65280);
                        b10 = bArr[i17];
                    } else if (i16 == 2) {
                        i14 = ((bArr[i17] << 24) & (-16777216)) | ((bArr[i17 + 1] << 16) & 16711680) | ((bArr[i17 + 2] << 8) & 65280);
                        b10 = bArr[i13];
                    } else {
                        i14 = ((bArr[i13] << 24) & (-16777216)) | ((bArr[i17 + 2] << 16) & 16711680) | ((bArr[i17 + 1] << 8) & 65280);
                        b10 = bArr[i17];
                    }
                    i10 = i14 | (b10 & 255);
                    i17 += 4;
                }
                byte[] bArr2 = this.T;
                if (bArr2 == null || (i12 = i18 + 3) >= bArr2.length) {
                    il.b.k(true, "sectionsize loss, offset=" + i18);
                    i11 = 0;
                } else {
                    i11 = ((bArr2[i18 + 2] << 16) & 16711680) | ((-16777216) & (bArr2[i12] << 24)) | (65280 & (bArr2[i18 + 1] << 8)) | (bArr2[i18] & 255);
                    i18 += 4;
                }
                ImageVersionInfo imageVersionInfo2 = new ImageVersionInfo(i16, i19, i10, i11);
                il.b.j(imageVersionInfo2.toString());
                arrayList.add(imageVersionInfo2);
            }
            i16++;
            i15 = 0;
        }
        this.S = arrayList;
    }

    public final void M() {
        int i10;
        byte b10;
        int i11;
        il.b.j(String.format("imageVersionIndicator = 0x%08x, \ninactiveImageVersionValues = %s", Integer.valueOf(this.L), a.a(this.R)));
        byte[] bArr = this.R;
        if (bArr == null || bArr.length <= 0) {
            this.S = new ArrayList();
            return;
        }
        int i12 = bArr[0] & 255;
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        int i13 = 1;
        for (int i14 = 0; i14 < i12; i14++) {
            byte[] bArr2 = this.R;
            if (bArr2 != null && (i10 = i13 + 5) < bArr2.length) {
                int i15 = (bArr2[i13] & 255) | ((bArr2[i13 + 1] << 8) & 65280);
                if (i15 == 10128) {
                    i11 = ((bArr2[i13 + 2] << 24) & (-16777216)) | ((bArr2[i13 + 3] << 16) & 16711680) | ((bArr2[i13 + 4] << 8) & 65280);
                    b10 = bArr2[i10];
                } else {
                    i11 = ((bArr2[i10] << 24) & (-16777216)) | ((bArr2[i13 + 4] << 16) & 16711680) | ((bArr2[i13 + 3] << 8) & 65280);
                    b10 = bArr2[i13 + 2];
                }
                hashMap.put(Integer.valueOf(i15), Integer.valueOf(i11 | (b10 & 255)));
            }
            byte[] bArr3 = this.T;
            if (bArr3 != null && (i13 * 4) + 3 < bArr3.length) {
                hashMap2.put(Integer.valueOf(((bArr3[i13 + 1] << 8) & 65280) | (bArr3[i13] & 255)), Integer.valueOf((bArr3[i13 + 2] & 255) | ((bArr3[i13 + 5] << 24) & (-16777216)) | ((bArr3[i13 + 4] << 16) & 16711680) | ((bArr3[i13 + 3] << 8) & 65280)));
            }
            i13 += 6;
        }
        for (Integer num : hashMap.keySet()) {
            int intValue = num.intValue();
            int i16 = this.O;
            ImageVersionInfo imageVersionInfo = new ImageVersionInfo(255, i16 == 1 ? 2 : i16 == 2 ? 1 : 3, (!hashMap.containsKey(Integer.valueOf(intValue)) || hashMap.get(Integer.valueOf(intValue)) == null) ? 0 : ((Integer) hashMap.get(Integer.valueOf(intValue))).intValue(), (!hashMap2.containsKey(Integer.valueOf(intValue)) || hashMap2.get(Integer.valueOf(intValue)) == null) ? 0 : ((Integer) hashMap2.get(Integer.valueOf(intValue))).intValue(), intValue);
            il.b.j(imageVersionInfo.toString());
            arrayList.add(imageVersionInfo);
        }
        this.S = arrayList;
    }

    public boolean N() {
        return this.f6011q;
    }

    public boolean O() {
        return this.N;
    }

    public boolean P() {
        return this.f6001g;
    }

    public boolean Q() {
        return this.f6010p;
    }

    public boolean R() {
        return this.f6016v;
    }

    public boolean S() {
        return this.f6020z;
    }

    public void T(byte[] bArr) {
        U(bArr, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:72:0x0183, code lost:
        if (r12.L == 0) goto L73;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void U(byte[] bArr, int i10) {
        if (bArr != null) {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            int remaining = wrap.remaining();
            if (remaining > i10) {
                int i11 = remaining - i10;
                try {
                    if (i11 <= 1) {
                        this.f6004j = 3;
                        this.f6005k = 0;
                        this.f6007m = (byte) (wrap.get(i10) & 15);
                        byte b10 = (byte) ((wrap.get(i10) & 240) >> 4);
                        this.f6008n = b10;
                        int i12 = this.f6007m;
                        if (i12 == 15 && b10 == 15) {
                            this.N = false;
                            this.O = 0;
                        } else {
                            this.N = true;
                            if (!(i12 == 1 || b10 == 1)) {
                                this.O = 1;
                            }
                            this.O = 2;
                        }
                        l0(2);
                        return;
                    }
                    this.f6004j = wrap.get(i10) & 255;
                    byte b11 = (byte) (wrap.get(i10 + 1) & 15);
                    this.f6005k = b11;
                    if (b11 == 0) {
                        if (i11 >= 3) {
                            int i13 = i10 + 2;
                            this.f6007m = (byte) (wrap.get(i13) & 15);
                            this.f6008n = (byte) ((wrap.get(i13) & 240) >> 4);
                        }
                        this.C = 0;
                        if (i11 >= 4) {
                            l0(wrap.get(i10 + 3));
                        }
                        if (i11 >= 6) {
                            this.B = (wrap.get(i10 + 5) << 8) | wrap.get(4);
                        }
                        if (i11 >= 14) {
                            this.H = (wrap.get(i10 + 7) << 8) | wrap.get(i10 + 6);
                            this.I = (wrap.get(i10 + 9) << 8) | wrap.get(i10 + 8);
                            this.J = (wrap.get(i10 + 11) << 8) | wrap.get(i10 + 10);
                            this.K = wrap.get(i10 + 12) | (wrap.get(i10 + 13) << 8);
                        }
                        j();
                        int i14 = this.f6007m;
                        if (i14 == 15 && this.f6008n == 15) {
                            this.N = false;
                            this.O = 0;
                            return;
                        }
                        this.N = true;
                        if (!(i14 == 1 || this.f6008n == 1)) {
                            this.O = 1;
                            return;
                        }
                        this.O = 2;
                    } else if (b11 == 1) {
                        if (i11 >= 3) {
                            this.f6006l = wrap.get(i10 + 2) & 255;
                        }
                        if (i11 >= 4) {
                            l0(wrap.get(i10 + 3));
                        }
                        if (i11 >= 5) {
                            this.B = wrap.getShort(i10 + 4) & 65535;
                        }
                        if (i11 >= 7) {
                            this.C = wrap.get(i10 + 6) & 255;
                        }
                        if (i11 >= 12) {
                            this.L = wrap.getInt(i10 + 8);
                        }
                        j();
                        if (this.L == 0) {
                            this.N = false;
                            return;
                        }
                        i();
                    } else if (b11 == 2) {
                        if (i11 >= 3) {
                            this.f6006l = wrap.get(i10 + 2) & 255;
                        }
                        if (i11 >= 4) {
                            l0(wrap.get(i10 + 3));
                        }
                        if (i11 >= 5) {
                            this.B = wrap.getShort(i10 + 4) & 65535;
                        }
                        if (i11 >= 7) {
                            this.W = wrap.getShort(i10 + 6);
                        }
                        if (i11 >= 8) {
                            this.E = wrap.getShort(i10 + 7) & 65535;
                        }
                        j();
                    }
                } catch (Exception e10) {
                    il.b.l(e10.toString());
                }
            }
        }
    }

    public void V(byte[] bArr) {
        W(bArr, 0);
    }

    public void W(byte[] bArr, int i10) {
        if (bArr != null) {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            int remaining = wrap.remaining();
            if (remaining > i10) {
                int i11 = remaining - i10;
                try {
                    this.f6004j = wrap.get(i10) & 255;
                    byte b10 = (byte) (wrap.get(i10 + 1) & 15);
                    this.f6005k = b10;
                    if (b10 < 4) {
                        if (i11 >= 3) {
                            this.f6006l = wrap.get(i10 + 2) & 255;
                        }
                        if (i11 >= 4) {
                            int i12 = wrap.get(i10 + 3) & 255;
                            this.f6009o = i12;
                            this.f6010p = (i12 & 1) != 0;
                            this.f6011q = ((i12 & 2) >> 1) != 0;
                            this.f6012r = (i12 & 4) >> 2;
                            this.f6013s = ((i12 & 8) >> 3) != 0;
                            this.f6014t = (i12 & 16) >> 4;
                            this.f6016v = ((i12 & 32) >> 5) != 0;
                            this.f6017w = (i12 & 64) >> 6;
                            this.f6018x = (i12 & 128) >> 7;
                        }
                        if (i11 >= 5) {
                            this.f6019y = wrap.get(i10 + 4) & 255 & 1;
                        }
                        if (i11 >= 7) {
                            this.C = wrap.get(i10 + 6) & 255;
                        }
                        if (i11 >= 12) {
                            this.L = wrap.getInt(i10 + 8);
                        }
                    } else {
                        if (i11 >= 3) {
                            int i13 = wrap.get(i10 + 2) & 255;
                            this.f6009o = i13;
                            this.f6010p = (i13 & 1) != 0;
                            this.f6011q = ((i13 & 2) >> 1) != 0;
                            this.f6012r = (i13 & 4) >> 2;
                            this.f6014t = (i13 & 8) >> 3;
                            this.f6015u = ((i13 & 16) >> 4) == 1;
                            this.f6020z = ((i13 & 32) >> 5) == 1;
                        }
                        if (i11 >= 4) {
                            int i14 = wrap.get(i10 + 3) & 255;
                            int i15 = i14 & 3;
                            this.f6019y = i15;
                            this.f6017w = (i14 & 12) >> 2;
                            this.f6016v = i15 == 2;
                        }
                        if (i11 >= 5) {
                            this.C = wrap.get(i10 + 4) & 255;
                        }
                        if (i11 >= 6) {
                            int i16 = wrap.get(i10 + 5) & 255;
                            if (i16 == 0) {
                                this.N = false;
                                this.O = 0;
                                this.L = 3;
                            } else if (i16 == 1) {
                                this.N = true;
                                this.O = 2;
                                this.L = 1;
                            } else if (i16 == 2) {
                                this.N = true;
                                this.O = 1;
                                this.L = 2;
                            }
                        }
                        if (i11 >= 7) {
                            this.V = wrap.getShort(i10 + 6) & 65535;
                        }
                    }
                } catch (Exception e10) {
                    il.b.l(e10.toString());
                }
                if (this.L == 0) {
                    this.N = false;
                } else {
                    i();
                }
                b();
            }
        }
    }

    public void X(byte[] bArr) {
        Y(bArr, 0);
    }

    public void Y(byte[] bArr, int i10) {
        if (bArr != null) {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            int remaining = wrap.remaining();
            if (remaining <= i10) {
                il.b.j(String.format(Locale.US, "invalid offset:%d, len is %d", Integer.valueOf(i10), Integer.valueOf(remaining)));
                return;
            }
            int i11 = remaining - i10;
            if (i11 >= 1) {
                this.f6004j = wrap.get(i10) & 255;
            }
            if (i11 >= 2) {
                this.f6005k = (byte) (wrap.get(i10 + 1) & 15);
            }
            if (this.f6005k <= 5) {
                if (i11 >= 3) {
                    this.f6006l = wrap.get(i10 + 2);
                }
                if (i11 >= 4) {
                    int i12 = wrap.get(i10 + 3) & 255;
                    this.f6009o = i12;
                    this.f6010p = (i12 & 1) != 0;
                    this.f6011q = ((i12 & 2) >> 1) != 0;
                    this.f6012r = (i12 & 4) >> 2;
                    this.f6013s = ((i12 & 8) >> 3) != 0;
                    this.f6014t = (i12 & 16) >> 4;
                    this.f6016v = ((i12 & 32) >> 5) != 0;
                    this.f6017w = (i12 & 64) >> 6;
                }
                if (i11 >= 5) {
                    this.f6019y = wrap.get(i10 + 4) & 255 & 1;
                }
                if (i11 >= 7) {
                    this.C = wrap.get(i10 + 6) & 255;
                }
                if (i11 >= 12) {
                    this.L = wrap.getInt(i10 + 8);
                }
                if (this.L == 0) {
                    this.N = false;
                } else {
                    i();
                }
            } else {
                if (i11 >= 3) {
                    int i13 = wrap.get(i10 + 2) & 255;
                    this.f6009o = i13;
                    this.f6010p = (i13 & 1) != 0;
                    this.f6011q = ((i13 & 2) >> 1) != 0;
                    this.f6012r = (i13 & 4) >> 2;
                    this.f6014t = (i13 & 8) >> 3;
                    this.f6020z = ((i13 & 16) >> 4) != 0;
                }
                if (i11 >= 4) {
                    int i14 = wrap.get(i10 + 3) & 255;
                    int i15 = i14 & 3;
                    this.f6019y = i15;
                    this.f6017w = (i14 & 12) >> 2;
                    this.f6016v = i15 == 2;
                }
                if (i11 >= 5) {
                    this.C = wrap.get(i10 + 4) & 255;
                }
                if (i11 >= 6) {
                    int i16 = wrap.get(i10 + 5) & 255;
                    if (i16 == 0) {
                        this.N = false;
                        this.O = 0;
                        this.L = 3;
                    } else if (i16 == 1) {
                        this.N = true;
                        this.O = 2;
                        this.L = 1;
                    } else if (i16 == 2) {
                        this.N = true;
                        this.O = 1;
                        this.L = 2;
                    }
                }
                if (i11 >= 7) {
                    this.V = wrap.getShort(i10 + 6) & 65535;
                }
            }
            b();
        }
    }

    public void Z(byte[] bArr) {
        a0(bArr, 0);
    }

    public final int a(int i10, int i11) {
        return i10;
    }

    public void a0(byte[] bArr, int i10) {
        if (bArr != null) {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            int remaining = wrap.remaining();
            if (remaining > i10) {
                int i11 = remaining - i10;
                try {
                    if (i11 <= 1) {
                        this.f6004j = 3;
                        this.f6005k = 0;
                        this.f6007m = (byte) (wrap.get(i10) & 15);
                        byte b10 = (byte) ((wrap.get(i10) & 240) >> 4);
                        this.f6008n = b10;
                        int i12 = this.f6007m;
                        if (i12 == 15 && b10 == 15) {
                            this.N = false;
                            this.O = 0;
                        } else {
                            this.N = true;
                            if (!(i12 == 1 || b10 == 1)) {
                                this.O = 1;
                            }
                            this.O = 2;
                        }
                        l0(2);
                        return;
                    }
                    this.f6004j = wrap.get(i10) & 255;
                    this.f6005k = (byte) (15 & wrap.get(i10 + 1));
                    if (i11 >= 3) {
                        this.f6006l = wrap.get(i10 + 2) & 255;
                    }
                    if (i11 >= 4) {
                        l0(wrap.get(i10 + 3));
                    }
                    if (i11 >= 5) {
                        this.B = wrap.getShort(i10 + 4) & 65535;
                    }
                    if (i11 >= 7) {
                        this.C = wrap.get(i10 + 6) & 255;
                    }
                    if (i11 >= 12) {
                        this.L = wrap.getInt(i10 + 8);
                    }
                    j();
                    if (this.L == 0) {
                        this.N = false;
                    } else {
                        i();
                    }
                } catch (Exception e10) {
                    il.b.l(e10.toString());
                }
            }
        }
    }

    public final void b() {
        int i10;
        if (!this.N) {
            if (this.f6014t != 1) {
                this.M = 1;
                return;
            } else if (this.C != 0) {
                i10 = 3;
                this.M = i10;
            }
        }
        i10 = 2;
        this.M = i10;
    }

    public void b0(byte[] bArr) {
        c0(bArr, 0);
    }

    public void c(byte[] bArr) {
        d(bArr, 0);
    }

    public void c0(byte[] bArr, int i10) {
        if (bArr != null) {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            wrap.order(ByteOrder.LITTLE_ENDIAN);
            int remaining = wrap.remaining();
            if (remaining > i10) {
                int i11 = remaining - i10;
                try {
                    this.f6004j = wrap.get(i10) & 255;
                    this.f6005k = (byte) (wrap.get(i10 + 1) & 15);
                    if (i11 >= 3) {
                        int i12 = wrap.get(i10 + 2) & 255;
                        this.f6009o = i12;
                        this.f6010p = (i12 & 1) != 0;
                        this.f6011q = ((i12 & 2) >> 1) != 0;
                        this.f6012r = (i12 & 4) >> 2;
                        this.f6014t = (i12 & 8) >> 3;
                        this.f6015u = ((i12 & 16) >> 4) == 1;
                        this.f6020z = ((i12 & 32) >> 5) == 1;
                    }
                    if (i11 >= 4) {
                        int i13 = wrap.get(i10 + 3) & 255;
                        int i14 = i13 & 3;
                        this.f6019y = i14;
                        this.f6017w = (i13 & 12) >> 2;
                        this.f6016v = i14 == 2;
                    }
                    if (i11 >= 6) {
                        this.C = wrap.getShort(i10 + 4) & 65535;
                    }
                    if (i11 >= 7) {
                        int i15 = wrap.get(i10 + 6) & 255;
                        if (i15 == 0) {
                            this.N = false;
                            this.O = 0;
                            this.L = 3;
                        } else if (i15 == 1) {
                            this.N = true;
                            this.O = 2;
                            this.L = 1;
                        } else if (i15 == 2) {
                            this.N = true;
                            this.O = 1;
                            this.L = 2;
                        }
                    }
                    if (i11 >= 8) {
                        this.V = wrap.getShort(i10 + 7) & 65535;
                    }
                } catch (Exception e10) {
                    il.b.l(e10.toString());
                }
                if (this.L == 0) {
                    this.N = false;
                } else {
                    i();
                }
                b();
            }
        }
    }

    public void d(byte[] bArr, int i10) {
        int length = bArr.length - i10;
        byte[] bArr2 = this.P;
        if (bArr2 == null || bArr2.length <= 0) {
            byte[] bArr3 = new byte[length];
            this.P = bArr3;
            System.arraycopy(bArr, i10, bArr3, 0, length);
        } else {
            byte[] bArr4 = new byte[bArr2.length + length];
            System.arraycopy(bArr2, 0, bArr4, 0, bArr2.length);
            System.arraycopy(bArr, i10, bArr4, this.P.length, length);
            this.P = bArr4;
        }
        k();
    }

    public void d0(byte[] bArr) {
        this.P = bArr;
        k();
    }

    public void e(int i10, byte[] bArr) {
        if (this.U == null) {
            this.U = new ArrayList();
        }
        this.U.add(new CharacteristicInfo(i10, bArr));
    }

    public void e0(int i10) {
        this.F = i10;
    }

    public void f(byte[] bArr) {
        byte[] bArr2 = this.T;
        if (bArr2 == null || bArr2.length <= 0) {
            this.T = bArr;
        } else {
            byte[] bArr3 = new byte[bArr2.length + bArr.length];
            System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
            System.arraycopy(bArr, 0, bArr3, this.T.length, bArr.length);
            this.T = bArr3;
        }
        k();
    }

    public void f0(int i10) {
        g0(i10, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0016, code lost:
        h(r5, 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002c, code lost:
        if (r5[0] == 0) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0010, code lost:
        if (r5[0] == 0) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0012, code lost:
        d(r5, 1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void g(byte[] bArr) {
        int i10 = this.f5995a;
        if (i10 == 20) {
            if (bArr == null || bArr.length < 1) {
            }
        } else if (i10 != 17 || this.f6005k < 6) {
            d(bArr, 0);
        } else if (bArr == null || bArr.length < 1) {
        }
    }

    public void g0(int i10, int i11) {
        this.f6001g = true;
        this.f6002h = i10;
        this.f6003i = i11;
    }

    public void h(byte[] bArr, int i10) {
        int length = bArr.length - i10;
        byte[] bArr2 = this.R;
        if (bArr2 == null || bArr2.length <= 0) {
            byte[] bArr3 = new byte[length];
            this.R = bArr3;
            System.arraycopy(bArr, i10, bArr3, 0, length);
        } else {
            byte[] bArr4 = new byte[bArr2.length + bArr.length];
            System.arraycopy(bArr2, 0, bArr4, 0, bArr2.length);
            System.arraycopy(bArr, i10, bArr4, this.R.length, bArr.length - i10);
            this.R = bArr4;
        }
        n();
    }

    public void h0(byte[] bArr) {
        this.D = bArr;
    }

    public final void i() {
        this.O = 0;
        for (int i10 = 0; i10 < 16; i10++) {
            int i11 = (this.L >> (i10 * 2)) & 3;
            if (i11 == 1) {
                if (this.O == 0) {
                    this.O = 2;
                }
            } else if (i11 == 2) {
                this.O = 1;
            }
        }
        this.N = this.O != 0;
        il.b.j(String.format("imageVersionIndicator = 0x%08x, bankEnabled=%b, updateBankIndicator=0x%02X", Integer.valueOf(this.L), Boolean.valueOf(this.N), Integer.valueOf(this.O)));
    }

    public void i0(byte[] bArr) {
        this.T = bArr;
        il.b.j(String.format("imageVersionIndicator = 0x%08x, \nimageSectionSizeValues=%s", Integer.valueOf(this.L), a.a(this.T)));
        k();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0013, code lost:
        if (r3.C != 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x001f, code lost:
        if (r3.C != 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0021, code lost:
        r3.M = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0025, code lost:
        r3.M = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0008, code lost:
        if (r3.f6014t == 1) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void j() {
        int i10 = this.f6005k;
        if (i10 != 0) {
            if (i10 == 1) {
                if (this.f6014t == 1) {
                }
                this.M = 1;
            }
            if (i10 != 2 && this.f6014t == 1) {
            }
            this.M = 1;
        }
    }

    public void j0(byte[] bArr) {
        int i10 = this.f5995a;
        if (i10 == 20) {
            if (bArr != null && bArr.length >= 1) {
                byte b10 = bArr[0];
                int length = bArr.length - 1;
                byte[] bArr2 = new byte[length];
                System.arraycopy(bArr, 1, bArr2, 0, length);
                if (b10 == 0) {
                    d0(bArr2);
                } else {
                    k0(bArr2);
                }
            }
        } else if (i10 != 17 || this.f6005k < 6) {
            d0(bArr);
        } else if (bArr != null && bArr.length >= 1) {
            byte b11 = bArr[0];
            int length2 = bArr.length - 1;
            byte[] bArr3 = new byte[length2];
            System.arraycopy(bArr, 1, bArr3, 0, length2);
            if (b11 == 0) {
                d0(bArr3);
            } else {
                k0(bArr3);
            }
        }
    }

    public final void k() {
        il.b.k(true, "wrapperImageVersionInfos");
        int i10 = this.f5995a;
        if (i10 != 20 && ((i10 != 17 || this.f6005k < 6) && (i10 != 16 || this.f6005k < 3))) {
            l();
        } else {
            m();
        }
    }

    public void k0(byte[] bArr) {
        this.R = bArr;
        n();
    }

    public final void l() {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        byte b10;
        il.b.j(String.format("wrapperImageVersionWithBitNumber:indicator = 0x%08x, \nvalues = %s", Integer.valueOf(this.L), a.a(this.P)));
        ArrayList arrayList = new ArrayList();
        int i15 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < 16; i17++) {
            int i18 = (this.L >> (i17 * 2)) & 3;
            if (i18 == 0) {
                ImageVersionInfo imageVersionInfo = new ImageVersionInfo(i17, i18, -1, 0);
                il.b.j(imageVersionInfo.toString());
                arrayList.add(imageVersionInfo);
            } else {
                byte[] bArr = this.P;
                if (bArr == null || (i13 = i15 + 3) >= bArr.length) {
                    il.b.j("imageVersion loss, offset=" + i15);
                    i10 = 0;
                } else {
                    if (this.f5995a != 17) {
                        i14 = ((bArr[i13] << 24) & (-16777216)) | ((bArr[i15 + 2] << 16) & 16711680) | ((bArr[i15 + 1] << 8) & 65280);
                        b10 = bArr[i15];
                    } else if (this.f6005k < 5) {
                        i14 = ((bArr[i13] << 24) & (-16777216)) | ((bArr[i15 + 2] << 16) & 16711680) | ((bArr[i15 + 1] << 8) & 65280);
                        b10 = bArr[i15];
                    } else if (i17 == 2) {
                        i10 = (bArr[i13] & 255) | ((bArr[i15] << 24) & (-16777216)) | ((bArr[i15 + 1] << 16) & 16711680) | ((bArr[i15 + 2] << 8) & 65280);
                        i15 += 4;
                    } else {
                        i14 = ((bArr[i13] << 24) & (-16777216)) | ((bArr[i15 + 2] << 16) & 16711680) | ((bArr[i15 + 1] << 8) & 65280);
                        b10 = bArr[i15];
                    }
                    i10 = (b10 & 255) | i14;
                    i15 += 4;
                }
                byte[] bArr2 = this.T;
                if (bArr2 == null || (i12 = i16 + 3) >= bArr2.length) {
                    il.b.j("sectionsize loss, offset=" + i16);
                    i11 = 0;
                } else {
                    i11 = ((bArr2[i16 + 2] << 16) & 16711680) | ((-16777216) & (bArr2[i12] << 24)) | (65280 & (bArr2[i16 + 1] << 8)) | (bArr2[i16] & 255);
                    i16 += 4;
                }
                ImageVersionInfo imageVersionInfo2 = new ImageVersionInfo(i17, i18, i10, i11);
                il.b.j(imageVersionInfo2.toString());
                arrayList.add(imageVersionInfo2);
            }
        }
        this.Q = arrayList;
        b();
    }

    public void l0(int i10) {
        this.f6009o = i10;
        boolean z10 = false;
        this.f6010p = (i10 & 1) != 0;
        this.f6011q = ((i10 & 2) >> 1) != 0;
        this.f6012r = (i10 & 4) >> 2;
        this.f6013s = ((i10 & 8) >> 3) != 0;
        this.f6014t = (i10 & 16) >> 4;
        if (((i10 & 32) >> 5) != 0) {
            z10 = true;
        }
        this.f6016v = z10;
        j();
    }

    public final void m() {
        int i10;
        int i11;
        il.b.j(String.format("wrapperImageVersionWithImageId, indicator = 0x%08x, \nvalues = %s", Integer.valueOf(this.L), a.a(this.P)));
        byte[] bArr = this.P;
        if (bArr == null || bArr.length <= 0) {
            this.Q = new ArrayList();
            return;
        }
        int i12 = bArr[0] & 255;
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        int i13 = 1;
        for (int i14 = 0; i14 < i12; i14++) {
            byte[] bArr2 = this.P;
            if (bArr2 != null && (i11 = i13 + 5) < bArr2.length) {
                int i15 = (bArr2[i13] & 255) | ((bArr2[i13 + 1] << 8) & 65280);
                hashMap.put(Integer.valueOf(i15), Integer.valueOf(i15 == 10128 ? (bArr2[i11] & 255) | ((bArr2[i13 + 2] << 24) & (-16777216)) | ((bArr2[i13 + 3] << 16) & 16711680) | ((bArr2[i13 + 4] << 8) & 65280) : (bArr2[i13 + 2] & 255) | ((bArr2[i11] << 24) & (-16777216)) | ((bArr2[i13 + 4] << 16) & 16711680) | ((bArr2[i13 + 3] << 8) & 65280)));
            }
            byte[] bArr3 = this.T;
            if (bArr3 != null && (i10 = i13 + 5) < bArr3.length) {
                hashMap2.put(Integer.valueOf(((bArr3[i13 + 1] << 8) & 65280) | (bArr3[i13] & 255)), Integer.valueOf((bArr3[i13 + 2] & 255) | ((bArr3[i10] << 24) & (-16777216)) | (16711680 & (bArr3[i13 + 4] << 16)) | ((bArr3[i13 + 3] << 8) & 65280)));
            }
            i13 += 6;
        }
        for (Integer num : hashMap.keySet()) {
            int intValue = num.intValue();
            int i16 = this.O;
            ImageVersionInfo imageVersionInfo = new ImageVersionInfo(255, i16 == 1 ? 2 : i16 == 2 ? 1 : 3, (!hashMap.containsKey(Integer.valueOf(intValue)) || hashMap.get(Integer.valueOf(intValue)) == null) ? 0 : ((Integer) hashMap.get(Integer.valueOf(intValue))).intValue(), (!hashMap2.containsKey(Integer.valueOf(intValue)) || hashMap2.get(Integer.valueOf(intValue)) == null) ? 0 : ((Integer) hashMap2.get(Integer.valueOf(intValue))).intValue(), intValue);
            il.b.j(imageVersionInfo.toString());
            arrayList.add(imageVersionInfo);
        }
        this.Q = arrayList;
        b();
    }

    public void m0(int i10) {
        this.G = i10;
    }

    public final void n() {
        int i10 = this.f5995a;
        if (i10 != 20 && ((i10 != 17 || this.f6005k < 6) && (i10 != 16 || this.f6005k < 3))) {
            L();
        } else {
            M();
        }
    }

    public void n0(int i10) {
        this.E = i10;
    }

    public int o() {
        int i10 = this.O;
        if (i10 == 1) {
            return 1;
        }
        return i10 == 2 ? 0 : 15;
    }

    public void o0(byte[] bArr) {
        if (bArr == null || bArr.length < 7) {
            this.f5996b = false;
            this.f5997c = 0;
            this.f5998d = 0;
            this.f5999e = 0;
            this.f6000f = 0;
            return;
        }
        this.f5996b = true;
        this.f5997c = bArr[0];
        this.f5998d = (bArr[2] << 8) | bArr[1];
        this.f5999e = (bArr[4] << 8) | bArr[3];
        this.f6000f = bArr[5] | (bArr[6] << 8);
    }

    public ImageVersionInfo p(int i10) {
        List<ImageVersionInfo> list = this.Q;
        if (list != null && list.size() > 0) {
            for (ImageVersionInfo imageVersionInfo : this.Q) {
                if (imageVersionInfo.a() == i10) {
                    return imageVersionInfo;
                }
            }
        }
        return null;
    }

    public void p0(byte[] bArr) {
        this.A = bArr;
    }

    public ImageVersionInfo q(int i10) {
        List<ImageVersionInfo> list = this.Q;
        if (list != null && list.size() > 0) {
            for (ImageVersionInfo imageVersionInfo : this.Q) {
                if (imageVersionInfo.b() == i10) {
                    return imageVersionInfo;
                }
            }
        }
        return null;
    }

    public void q0(int i10) {
        this.f6018x = i10;
    }

    public int r() {
        return this.f6012r;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0029, code lost:
        if (r0 != 10) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x007d, code lost:
        if (r0 != 10) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int s() {
        ImageVersionInfo imageVersionInfo;
        int i10 = this.f5995a;
        if (i10 == 16) {
            int i11 = this.f6004j;
            if (i11 > 3) {
                if (i11 != 5) {
                    if (i11 != 9) {
                        if (i11 != 12) {
                            if (i11 != 4) {
                                if (i11 != 6) {
                                    if (i11 != 7) {
                                        if (i11 != 8) {
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                imageVersionInfo = p(a(5, this.L));
            }
            imageVersionInfo = null;
        } else if (i10 == 17) {
            int i12 = this.f6004j;
            if (i12 > 3) {
                if (!(i12 == 5 || i12 == 9 || i12 == 12)) {
                    if (i12 == 4 || i12 == 6 || i12 == 7 || i12 == 8 || i12 == 10) {
                        if (this.f6005k >= 6) {
                            imageVersionInfo = q(10131);
                        }
                    }
                }
                imageVersionInfo = p(a(5, this.L));
            }
            imageVersionInfo = null;
        } else {
            int i13 = this.f6005k;
            if (i13 == 0) {
                return this.F;
            }
            if (i13 >= 1) {
                int i14 = this.f6004j;
                if (i14 <= 3) {
                    imageVersionInfo = this.O == 2 ? p(2) : p(1);
                } else {
                    if (i14 != 5) {
                        if (i14 != 9) {
                            if (i14 != 12) {
                                if (i14 != 4) {
                                    if (i14 != 6) {
                                        if (i14 != 7) {
                                            if (i14 != 8) {
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    imageVersionInfo = p(a(5, this.L));
                }
            }
            imageVersionInfo = null;
        }
        if (imageVersionInfo != null) {
            return imageVersionInfo.d();
        }
        return 0;
    }

    public int t() {
        return this.f6017w;
    }

    public String toString() {
        String str;
        String str2;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("DeviceInfo{\n");
        sb2.append(String.format("IPV=%s\n", z()));
        boolean z10 = this.f5996b;
        if (z10) {
            sb2.append("PnP_ID:\n");
            Locale locale = Locale.US;
            sb2.append(String.format(locale, "\tvendorIdSource=0x%04X(%d)\n", Integer.valueOf(this.f5997c), Integer.valueOf(this.f5997c)));
            sb2.append(String.format(locale, "\tvendorId=0x%04X(%d)\n", Integer.valueOf(this.f5998d), Integer.valueOf(this.f5998d)));
            sb2.append(String.format(locale, "\tproductId=0x%04X(%d)\n", Integer.valueOf(this.f5999e), Integer.valueOf(this.f5999e)));
            str = String.format(locale, "\tproductVersion=0x%04X(%d)\n", Integer.valueOf(this.f6000f), Integer.valueOf(this.f6000f));
        } else {
            str = String.format("DIS=%b\n", Boolean.valueOf(z10));
        }
        sb2.append(str);
        boolean z11 = this.f6001g;
        sb2.append(z11 ? String.format(Locale.US, "primaryBat=0x%02X(%d), secondaryBat=0x%02X(%d)\n", Integer.valueOf(this.f6002h), Integer.valueOf(this.f6002h), Integer.valueOf(this.f6003i), Integer.valueOf(this.f6003i)) : String.format("BAS=%b\n", Boolean.valueOf(z11)));
        sb2.append(String.format("mode=0x%02X\n", Integer.valueOf(this.f6009o)));
        sb2.append(String.format("\tbufferCheckEnabled=%b\n", Boolean.valueOf(this.f6010p)));
        if (this.f6010p) {
            sb2.append(String.format(Locale.US, "\t\tmaxBuffercheckSize=0x%04X(%d)\n", Integer.valueOf(this.B), Integer.valueOf(this.B)));
        }
        sb2.append(String.format("\taesEncryptEnabled=%b", Boolean.valueOf(this.f6011q)));
        if (this.f6011q) {
            sb2.append(String.format("\t\taesEncryptMode=0x%02X\n", Integer.valueOf(this.f6012r)));
        }
        sb2.append(String.format("\n\tcopyImageEnabled=%b\n", Boolean.valueOf(this.f6013s)));
        sb2.append(String.format("\tupdateImageFlag=0x%02X\n", Integer.valueOf(this.f6014t)));
        sb2.append(String.format("\trwsEnabled=%b, rwsMode=0x%02X, budRole: 0x%02X\n", Boolean.valueOf(this.f6016v), Integer.valueOf(this.f6019y), Integer.valueOf(this.f6017w)));
        if (this.f6016v) {
            sb2.append(String.format("\t\trwsUpdateFlag:0x%02X, rwsBdAddr: %s\n", Integer.valueOf(this.f6018x), fl.a.d(this.A)));
        }
        Locale locale2 = Locale.US;
        sb2.append(String.format(locale2, "otaTempBufferSize=0x%04X(%d)\n", Integer.valueOf(this.C), Integer.valueOf(this.C)));
        sb2.append(String.format("mUpdateMechanism=0x%02X\n", Integer.valueOf(this.M)));
        int i10 = this.f5995a;
        if (i10 == 0) {
            int i11 = this.f6005k;
            if (i11 == 0) {
                sb2.append(String.format(locale2, "\tpatchVersion=0x%04X\n", Integer.valueOf(this.E)));
                sb2.append(String.format(locale2, "\tpatchFreeBank=0x%02X\n", Integer.valueOf(this.f6008n)));
                sb2.append(String.format(locale2, "\tappVersion=0x%04X\n", Integer.valueOf(this.F)));
                sb2.append(String.format("\tappFreeBank=0x%02X\n", Integer.valueOf(this.f6007m)));
                sb2.append(String.format(locale2, "\tpatchExtensionVersion=%d\n", Integer.valueOf(this.G)));
                if (this.f6004j > 3) {
                    sb2.append(String.format(locale2, "\tappData0=%d\n", Integer.valueOf(this.H)));
                    sb2.append(String.format(locale2, "\tappData1=%d\n", Integer.valueOf(this.I)));
                    sb2.append(String.format(locale2, "\tappData2=%d\n", Integer.valueOf(this.J)));
                    str2 = String.format(locale2, "\tappData3=%d\n", Integer.valueOf(this.K));
                    sb2.append(str2);
                }
            } else {
                if (i11 == 1) {
                    sb2.append(String.format(locale2, "\tsecureVersion=0x%04X(%d)\n", Integer.valueOf(this.f6006l), Integer.valueOf(this.f6006l)));
                    sb2.append(String.format(locale2, "\timageVersionIndicator=0x%08X\n", Integer.valueOf(this.L)));
                    str2 = String.format(locale2, "\tupdateBankIndicator=0x%02X\n", Integer.valueOf(this.O));
                } else if (i11 == 2) {
                    sb2.append(String.format(locale2, "\tnoTempImageId=0x%04X\n", Integer.valueOf(this.W)));
                    str2 = String.format(locale2, "\tpatchVersion=0x%04X\n", Integer.valueOf(this.E));
                }
                sb2.append(str2);
            }
        } else {
            if (i10 == 17) {
                sb2.append(String.format(locale2, "\tsecureVersion=0x%04X(%d)\n", Integer.valueOf(this.f6006l), Integer.valueOf(this.f6006l)));
                sb2.append(String.format(locale2, "\timageVersionIndicator=0x%08X\n", Integer.valueOf(this.L)));
                sb2.append(String.format(locale2, "\tupdateBankIndicator=0x%02X(%d)\n", Integer.valueOf(this.O), Integer.valueOf(this.O)));
                if (this.f6005k >= 6) {
                    str2 = String.format(locale2, "\tmtu=0x%04X\n", Integer.valueOf(this.V));
                }
            } else {
                sb2.append(String.format(locale2, "\tsecureVersion=0x%04X(%d)\n", Integer.valueOf(this.f6006l), Integer.valueOf(this.f6006l)));
                sb2.append(String.format(locale2, "\timageVersionIndicator=0x%08X\n", Integer.valueOf(this.L)));
                str2 = String.format(locale2, "\tupdateBankIndicator=0x%02X(%d)\n", Integer.valueOf(this.O), Integer.valueOf(this.O));
            }
            sb2.append(str2);
        }
        sb2.append(String.format("bankEnabled=%b\n", Boolean.valueOf(this.N)));
        List<ImageVersionInfo> list = this.Q;
        if (list != null && list.size() > 0) {
            sb2.append("activeImages:\n");
            Iterator<ImageVersionInfo> it = this.Q.iterator();
            while (it.hasNext()) {
                sb2.append("\t" + it.next().toString() + "\n");
            }
        }
        List<ImageVersionInfo> list2 = this.S;
        if (list2 != null && list2.size() > 0) {
            sb2.append("inactiveImages:\n");
            Iterator<ImageVersionInfo> it2 = this.S.iterator();
            while (it2.hasNext()) {
                sb2.append(it2.next().toString() + "\n");
            }
        }
        sb2.append("}");
        return sb2.toString();
    }

    public byte[] u() {
        return this.D;
    }

    public List<ImageVersionInfo> v() {
        return this.Q;
    }

    public ImageVersionInfo w(int i10) {
        List<ImageVersionInfo> list = this.S;
        if (list != null && list.size() > 0) {
            for (ImageVersionInfo imageVersionInfo : this.S) {
                if (imageVersionInfo.a() == i10) {
                    return imageVersionInfo;
                }
            }
        }
        return null;
    }

    public ImageVersionInfo x(int i10) {
        List<ImageVersionInfo> list = this.S;
        if (list != null && list.size() > 0) {
            for (ImageVersionInfo imageVersionInfo : this.S) {
                if (imageVersionInfo.b() == i10) {
                    return imageVersionInfo;
                }
            }
        }
        return null;
    }

    public int y() {
        int i10 = this.O;
        if (i10 == 1) {
            return 0;
        }
        return i10 == 2 ? 1 : 15;
    }

    public String z() {
        return String.format("I%02XP%04XV%02XCID%02XPID%02X", Integer.valueOf(this.f6004j), Integer.valueOf(this.f5995a), Integer.valueOf(this.f6005k), Byte.valueOf(this.X), Byte.valueOf(this.Y));
    }
}
