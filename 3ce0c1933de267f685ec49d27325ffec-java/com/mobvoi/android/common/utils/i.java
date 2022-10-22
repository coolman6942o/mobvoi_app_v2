package com.mobvoi.android.common.utils;

import java.util.Objects;
/* compiled from: InsecureSHA1PRNGKeyDerivator.java */
/* loaded from: classes2.dex */
class i {

    /* renamed from: h  reason: collision with root package name */
    private static final int[] f15439h = {Integer.MIN_VALUE, 8388608, 32768, 128};

    /* renamed from: i  reason: collision with root package name */
    private static final int[] f15440i = {0, 40, 48, 56};

    /* renamed from: j  reason: collision with root package name */
    private static final int[] f15441j = {0, 8, 16, 24};

    /* renamed from: k  reason: collision with root package name */
    private static final int[] f15442k = {0, 24, 16, 8};

    /* renamed from: l  reason: collision with root package name */
    private static final int[] f15443l = {-1, 16777215, 65535, 255};

    /* renamed from: a  reason: collision with root package name */
    private transient int[] f15444a;

    /* renamed from: b  reason: collision with root package name */
    private transient long f15445b = 0;

    /* renamed from: c  reason: collision with root package name */
    private transient int[] f15446c = new int[37];

    /* renamed from: d  reason: collision with root package name */
    private transient byte[] f15447d = new byte[20];

    /* renamed from: e  reason: collision with root package name */
    private transient int f15448e = 20;

    /* renamed from: f  reason: collision with root package name */
    private transient long f15449f = 0;

    /* renamed from: g  reason: collision with root package name */
    private transient int f15450g = 0;

    private i() {
        int[] iArr = new int[87];
        this.f15444a = iArr;
        iArr[82] = 1732584193;
        iArr[83] = -271733879;
        iArr[84] = -1732584194;
        iArr[85] = 271733878;
        iArr[86] = -1009589776;
    }

    private static void a(int[] iArr) {
        int i10;
        int i11;
        int i12;
        int i13 = iArr[82];
        int i14 = iArr[83];
        int i15 = iArr[84];
        int i16 = iArr[85];
        int i17 = iArr[86];
        for (int i18 = 16; i18 < 80; i18++) {
            int i19 = ((iArr[i18 - 3] ^ iArr[i18 - 8]) ^ iArr[i18 - 14]) ^ iArr[i18 - 16];
            iArr[i18] = (i19 >>> 31) | (i19 << 1);
        }
        int i20 = 0;
        while (true) {
            i10 = 20;
            if (i20 < 20) {
                i13 = i17 + iArr[i20] + 1518500249 + ((i13 << 5) | (i13 >>> 27)) + ((i14 & i15) | ((~i14) & i16));
                i15 = (i14 >>> 2) | (i14 << 30);
                i20++;
                i14 = i13;
                i17 = i16;
                i16 = i15;
            }
        }
        while (true) {
            i11 = 40;
            if (i10 < 40) {
                i13 = i17 + iArr[i10] + 1859775393 + ((i13 << 5) | (i13 >>> 27)) + ((i14 ^ i15) ^ i16);
                i15 = (i14 >>> 2) | (i14 << 30);
                i10++;
                i14 = i13;
                i17 = i16;
                i16 = i15;
            }
        }
        while (true) {
            i12 = 60;
            if (i11 < 60) {
                i13 = ((i17 + iArr[i11]) - 1894007588) + ((i13 << 5) | (i13 >>> 27)) + ((i14 & i15) | (i14 & i16) | (i15 & i16));
                i15 = (i14 >>> 2) | (i14 << 30);
                i11++;
                i14 = i13;
                i17 = i16;
                i16 = i15;
            }
        }
        while (i12 < 80) {
            i13 = ((i17 + iArr[i12]) - 899497514) + ((i13 << 5) | (i13 >>> 27)) + ((i14 ^ i15) ^ i16);
            i15 = (i14 >>> 2) | (i14 << 30);
            i12++;
            i14 = i13;
            i17 = i16;
            i16 = i15;
        }
        iArr[82] = iArr[82] + i13;
        iArr[83] = iArr[83] + i14;
        iArr[84] = iArr[84] + i15;
        iArr[85] = iArr[85] + i16;
        iArr[86] = iArr[86] + i17;
    }

    public static byte[] b(byte[] bArr, int i10) {
        i iVar = new i();
        iVar.d(bArr);
        byte[] bArr2 = new byte[i10];
        iVar.c(bArr2);
        return bArr2;
    }

    private void d(byte[] bArr) {
        Objects.requireNonNull(bArr, "seed == null");
        if (this.f15450g == 2) {
            System.arraycopy(this.f15446c, 0, this.f15444a, 82, 5);
        }
        this.f15450g = 1;
        if (bArr.length != 0) {
            f(bArr);
        }
    }

    private static void e(int[] iArr, byte[] bArr, int i10, int i11) {
        int i12 = iArr[81];
        int i13 = i12 >> 2;
        int i14 = i12 & 3;
        iArr[81] = (((i12 + i11) - i10) + 1) & 63;
        if (i14 != 0) {
            while (i10 <= i11 && i14 < 4) {
                iArr[i13] = iArr[i13] | ((bArr[i10] & 255) << ((3 - i14) << 3));
                i14++;
                i10++;
            }
            if (i14 == 4 && (i13 = i13 + 1) == 16) {
                a(iArr);
                i13 = 0;
            }
            if (i10 > i11) {
                return;
            }
        }
        int i15 = ((i11 - i10) + 1) >> 2;
        for (int i16 = 0; i16 < i15; i16++) {
            iArr[i13] = ((bArr[i10] & 255) << 24) | ((bArr[i10 + 1] & 255) << 16) | ((bArr[i10 + 2] & 255) << 8) | (bArr[i10 + 3] & 255);
            i10 += 4;
            i13++;
            if (i13 >= 16) {
                a(iArr);
                i13 = 0;
            }
        }
        int i17 = (i11 - i10) + 1;
        if (i17 != 0) {
            int i18 = (bArr[i10] & 255) << 24;
            if (i17 != 1) {
                i18 |= (bArr[i10 + 1] & 255) << 16;
                if (i17 != 2) {
                    i18 |= (bArr[i10 + 2] & 255) << 8;
                }
            }
            iArr[i13] = i18;
        }
    }

    private void f(byte[] bArr) {
        e(this.f15444a, bArr, 0, bArr.length - 1);
        this.f15445b += bArr.length;
    }

    protected synchronized void c(byte[] bArr) {
        int i10;
        int i11;
        int i12;
        int i13;
        try {
            if (bArr != null) {
                int[] iArr = this.f15444a;
                int i14 = iArr[81] == 0 ? 0 : (iArr[81] + 7) >> 2;
                int i15 = this.f15450g;
                if (i15 != 0) {
                    if (i15 == 1) {
                        System.arraycopy(iArr, 82, this.f15446c, 0, 5);
                        for (int i16 = i14 + 3; i16 < 18; i16++) {
                            this.f15444a[i16] = 0;
                        }
                        long j10 = (this.f15445b << 3) + 64;
                        int[] iArr2 = this.f15444a;
                        if (iArr2[81] < 48) {
                            iArr2[14] = (int) (j10 >>> 32);
                            iArr2[15] = (int) (j10 & (-1));
                            i10 = i14;
                        } else {
                            int[] iArr3 = this.f15446c;
                            i10 = i14;
                            iArr3[19] = (int) (j10 >>> 32);
                            iArr3[20] = (int) (j10 & (-1));
                        }
                        this.f15448e = 20;
                    } else {
                        i10 = i14;
                    }
                    this.f15450g = 2;
                    if (bArr.length != 0) {
                        int i17 = this.f15448e;
                        int length = 20 - i17 < bArr.length - 0 ? 20 - i17 : bArr.length - 0;
                        if (length > 0) {
                            System.arraycopy(this.f15447d, i17, bArr, 0, length);
                            this.f15448e += length;
                            i11 = length + 0;
                        } else {
                            i11 = 0;
                        }
                        if (i11 < bArr.length) {
                            int i18 = this.f15444a[81] & 3;
                            while (true) {
                                if (i18 == 0) {
                                    int[] iArr4 = this.f15444a;
                                    long j11 = this.f15449f;
                                    iArr4[i10] = (int) (j11 >>> 32);
                                    iArr4[i10 + 1] = (int) (j11 & (-1));
                                    iArr4[i10 + 2] = f15439h[0];
                                    i12 = i11;
                                } else {
                                    int[] iArr5 = this.f15444a;
                                    int i19 = iArr5[i10];
                                    long j12 = this.f15449f;
                                    i12 = i11;
                                    iArr5[i10] = ((int) ((j12 >>> f15440i[i18]) & f15443l[i18])) | i19;
                                    iArr5[i10 + 1] = (int) ((j12 >>> f15441j[i18]) & (-1));
                                    iArr5[i10 + 2] = (int) ((j12 << f15442k[i18]) | f15439h[i18]);
                                }
                                int[] iArr6 = this.f15444a;
                                if (iArr6[81] > 48) {
                                    int[] iArr7 = this.f15446c;
                                    iArr7[5] = iArr6[16];
                                    iArr7[6] = iArr6[17];
                                }
                                a(iArr6);
                                int[] iArr8 = this.f15444a;
                                if (iArr8[81] > 48) {
                                    System.arraycopy(iArr8, 0, this.f15446c, 21, 16);
                                    System.arraycopy(this.f15446c, 5, this.f15444a, 0, 16);
                                    a(this.f15444a);
                                    System.arraycopy(this.f15446c, 21, this.f15444a, 0, 16);
                                }
                                this.f15449f++;
                                int i20 = 0;
                                for (int i21 = 0; i21 < 5; i21++) {
                                    int i22 = this.f15444a[i21 + 82];
                                    byte[] bArr2 = this.f15447d;
                                    bArr2[i20] = (byte) (i22 >>> 24);
                                    bArr2[i20 + 1] = (byte) (i22 >>> 16);
                                    bArr2[i20 + 2] = (byte) (i22 >>> 8);
                                    bArr2[i20 + 3] = (byte) i22;
                                    i20 += 4;
                                }
                                this.f15448e = 0;
                                int length2 = 20 < bArr.length - i12 ? 20 : bArr.length - i12;
                                if (length2 > 0) {
                                    int i23 = i12;
                                    System.arraycopy(this.f15447d, 0, bArr, i23, length2);
                                    i13 = i23 + length2;
                                    this.f15448e += length2;
                                } else {
                                    i13 = i12;
                                }
                                i11 = i13;
                                if (i11 >= bArr.length) {
                                    return;
                                }
                            }
                        }
                    }
                } else {
                    throw new IllegalStateException("No seed supplied!");
                }
            } else {
                throw new NullPointerException("bytes == null");
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
