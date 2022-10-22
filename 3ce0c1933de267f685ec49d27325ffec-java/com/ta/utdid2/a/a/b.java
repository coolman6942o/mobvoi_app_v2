package com.ta.utdid2.a.a;

import android.annotation.SuppressLint;
import java.io.UnsupportedEncodingException;
/* loaded from: classes2.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ boolean f22407a = true;

    /* loaded from: classes2.dex */
    public static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        public int f22408a;

        /* renamed from: a  reason: collision with other field name */
        public byte[] f0a;
    }

    /* renamed from: com.ta.utdid2.a.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0249b extends a {

        /* renamed from: a  reason: collision with root package name */
        public static final int[] f22409a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        /* renamed from: b  reason: collision with root package name */
        public static final int[] f22410b = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -2, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, 63, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

        /* renamed from: c  reason: collision with root package name */
        public final int[] f22411c;
        public int state;
        public int value;

        public C0249b(int i10, byte[] bArr) {
            ((a) this).f0a = bArr;
            this.f22411c = (i10 & 8) == 0 ? f22409a : f22410b;
            this.state = 0;
            this.value = 0;
        }

        public boolean a(byte[] bArr, int i10, int i11, boolean z10) {
            int i12 = this.state;
            if (i12 == 6) {
                return false;
            }
            int i13 = i11 + i10;
            int i14 = this.value;
            byte[] bArr2 = ((a) this).f0a;
            int[] iArr = this.f22411c;
            int i15 = 0;
            int i16 = i14;
            int i17 = i12;
            int i18 = i10;
            while (i18 < i13) {
                if (i17 == 0) {
                    while (true) {
                        int i19 = i18 + 4;
                        if (i19 > i13 || (i16 = (iArr[bArr[i18] & 255] << 18) | (iArr[bArr[i18 + 1] & 255] << 12) | (iArr[bArr[i18 + 2] & 255] << 6) | iArr[bArr[i18 + 3] & 255]) < 0) {
                            break;
                        }
                        bArr2[i15 + 2] = (byte) i16;
                        bArr2[i15 + 1] = (byte) (i16 >> 8);
                        bArr2[i15] = (byte) (i16 >> 16);
                        i15 += 3;
                        i18 = i19;
                    }
                    if (i18 >= i13) {
                        break;
                    }
                }
                i18++;
                int i20 = iArr[bArr[i18] & 255];
                if (i17 != 0) {
                    if (i17 == 1) {
                        if (i20 < 0) {
                            if (i20 != -1) {
                                this.state = 6;
                                return false;
                            }
                        }
                        i20 |= i16 << 6;
                    } else if (i17 == 2) {
                        if (i20 < 0) {
                            if (i20 == -2) {
                                i15++;
                                bArr2[i15] = (byte) (i16 >> 4);
                                i17 = 4;
                            } else if (i20 != -1) {
                                this.state = 6;
                                return false;
                            }
                        }
                        i20 |= i16 << 6;
                    } else if (i17 != 3) {
                        if (i17 != 4) {
                            if (i17 == 5 && i20 != -1) {
                                this.state = 6;
                                return false;
                            }
                        } else if (i20 == -2) {
                            i17++;
                        } else if (i20 != -1) {
                            this.state = 6;
                            return false;
                        }
                    } else if (i20 >= 0) {
                        int i21 = i20 | (i16 << 6);
                        bArr2[i15 + 2] = (byte) i21;
                        bArr2[i15 + 1] = (byte) (i21 >> 8);
                        bArr2[i15] = (byte) (i21 >> 16);
                        i15 += 3;
                        i16 = i21;
                        i17 = 0;
                    } else if (i20 == -2) {
                        bArr2[i15 + 1] = (byte) (i16 >> 2);
                        bArr2[i15] = (byte) (i16 >> 10);
                        i15 += 2;
                        i17 = 5;
                    } else if (i20 != -1) {
                        this.state = 6;
                        return false;
                    }
                    i17++;
                    i16 = i20;
                } else {
                    if (i20 < 0) {
                        if (i20 != -1) {
                            this.state = 6;
                            return false;
                        }
                    }
                    i17++;
                    i16 = i20;
                }
            }
            if (!z10) {
                this.state = i17;
                this.value = i16;
                ((a) this).f22408a = i15;
                return true;
            } else if (i17 != 1) {
                if (i17 == 2) {
                    i15++;
                    bArr2[i15] = (byte) (i16 >> 4);
                } else if (i17 == 3) {
                    int i22 = i15 + 1;
                    bArr2[i15] = (byte) (i16 >> 10);
                    i15 = i22 + 1;
                    bArr2[i22] = (byte) (i16 >> 2);
                } else if (i17 == 4) {
                    this.state = 6;
                    return false;
                }
                this.state = i17;
                ((a) this).f22408a = i15;
                return true;
            } else {
                this.state = 6;
                return false;
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class c extends a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ boolean f22412a = true;

        /* renamed from: b  reason: collision with root package name */
        public static final byte[] f22413b = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};

        /* renamed from: c  reason: collision with root package name */
        public static final byte[] f22414c = {65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 45, 95};

        /* renamed from: b  reason: collision with other field name */
        public int f1b;

        /* renamed from: b  reason: collision with other field name */
        public final boolean f2b;

        /* renamed from: c  reason: collision with other field name */
        public final boolean f3c;
        public int count;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f22415d;

        /* renamed from: d  reason: collision with other field name */
        public final byte[] f4d;

        /* renamed from: e  reason: collision with root package name */
        public final byte[] f22416e;

        public c(int i10, byte[] bArr) {
            ((a) this).f0a = bArr;
            boolean z10 = true;
            this.f2b = (i10 & 1) == 0;
            boolean z11 = (i10 & 2) == 0;
            this.f3c = z11;
            this.f22415d = (i10 & 4) == 0 ? false : z10;
            this.f22416e = (i10 & 8) == 0 ? f22413b : f22414c;
            this.f4d = new byte[2];
            this.f1b = 0;
            this.count = z11 ? 19 : -1;
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
            */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0094  */
        /* JADX WARN: Removed duplicated region for block: B:79:0x01be  */
        /* JADX WARN: Removed duplicated region for block: B:84:0x01cb A[ADDED_TO_REGION] */
        /* JADX WARN: Removed duplicated region for block: B:96:0x00e6 A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x00dd -> B:21:0x008a). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean a(byte[] r19, int r20, int r21, boolean r22) {
            /*
                Method dump skipped, instructions count: 514
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ta.utdid2.a.a.b.c.a(byte[], int, int, boolean):boolean");
        }
    }

    public static byte[] decode(String str, int i10) {
        return decode(str.getBytes(), i10);
    }

    public static byte[] encode(byte[] bArr, int i10) {
        return encode(bArr, 0, bArr.length, i10);
    }

    public static String encodeToString(byte[] bArr, int i10) {
        try {
            return new String(encode(bArr, i10), "US-ASCII");
        } catch (UnsupportedEncodingException e10) {
            throw new AssertionError(e10);
        }
    }

    public static byte[] decode(byte[] bArr, int i10) {
        return decode(bArr, 0, bArr.length, i10);
    }

    @SuppressLint({"Assert"})
    public static byte[] encode(byte[] bArr, int i10, int i11, int i12) {
        c cVar = new c(i12, null);
        int i13 = (i11 / 3) * 4;
        int i14 = 2;
        if (!cVar.f2b) {
            int i15 = i11 % 3;
            if (i15 == 1) {
                i13 += 2;
            } else if (i15 == 2) {
                i13 += 3;
            }
        } else if (i11 % 3 > 0) {
            i13 += 4;
        }
        if (cVar.f3c && i11 > 0) {
            int i16 = ((i11 - 1) / 57) + 1;
            if (!cVar.f22415d) {
                i14 = 1;
            }
            i13 += i16 * i14;
        }
        ((a) cVar).f0a = new byte[i13];
        cVar.a(bArr, i10, i11, true);
        if (f22407a || ((a) cVar).f22408a == i13) {
            return ((a) cVar).f0a;
        }
        throw new AssertionError();
    }

    public static byte[] decode(byte[] bArr, int i10, int i11, int i12) {
        C0249b bVar = new C0249b(i12, new byte[(i11 * 3) / 4]);
        if (bVar.a(bArr, i10, i11, true)) {
            int i13 = ((a) bVar).f22408a;
            byte[] bArr2 = ((a) bVar).f0a;
            if (i13 == bArr2.length) {
                return bArr2;
            }
            byte[] bArr3 = new byte[i13];
            System.arraycopy(bArr2, 0, bArr3, 0, i13);
            return bArr3;
        }
        throw new IllegalArgumentException("bad base-64");
    }
}
