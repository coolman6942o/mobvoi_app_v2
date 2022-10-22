package com.google.protobuf;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Utf8.java */
/* loaded from: classes.dex */
public final class d1 {

    /* renamed from: a  reason: collision with root package name */
    private static final a f13219a;

    /* compiled from: Utf8.java */
    /* loaded from: classes.dex */
    static abstract class a {
        a() {
        }

        abstract int a(CharSequence charSequence, byte[] bArr, int i10, int i11);

        final boolean b(byte[] bArr, int i10, int i11) {
            return c(0, bArr, i10, i11) == 0;
        }

        abstract int c(int i10, byte[] bArr, int i11, int i12);
    }

    /* compiled from: Utf8.java */
    /* loaded from: classes.dex */
    static final class b extends a {
        b() {
        }

        private static int d(byte[] bArr, int i10, int i11) {
            while (i10 < i11 && bArr[i10] >= 0) {
                i10++;
            }
            if (i10 >= i11) {
                return 0;
            }
            return e(bArr, i10, i11);
        }

        private static int e(byte[] bArr, int i10, int i11) {
            while (i10 < i11) {
                int i12 = i10 + 1;
                byte b10 = bArr[i10];
                if (b10 < 0) {
                    if (b10 < -32) {
                        if (i12 >= i11) {
                            return b10;
                        }
                        if (b10 >= -62) {
                            i10 = i12 + 1;
                            if (bArr[i12] > -65) {
                            }
                        }
                        return -1;
                    } else if (b10 < -16) {
                        if (i12 >= i11 - 1) {
                            return d1.k(bArr, i12, i11);
                        }
                        int i13 = i12 + 1;
                        byte b11 = bArr[i12];
                        if (b11 <= -65 && ((b10 != -32 || b11 >= -96) && (b10 != -19 || b11 < -96))) {
                            i10 = i13 + 1;
                            if (bArr[i13] > -65) {
                            }
                        }
                        return -1;
                    } else if (i12 >= i11 - 2) {
                        return d1.k(bArr, i12, i11);
                    } else {
                        int i14 = i12 + 1;
                        byte b12 = bArr[i12];
                        if (b12 <= -65 && (((b10 << 28) + (b12 + 112)) >> 30) == 0) {
                            int i15 = i14 + 1;
                            if (bArr[i14] <= -65) {
                                i12 = i15 + 1;
                                if (bArr[i15] > -65) {
                                }
                            }
                        }
                        return -1;
                    }
                }
                i10 = i12;
            }
            return 0;
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
            return r10 + r0;
         */
        @Override // com.google.protobuf.d1.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        int a(CharSequence charSequence, byte[] bArr, int i10, int i11) {
            int i12;
            int i13;
            int i14;
            char charAt;
            int length = charSequence.length();
            int i15 = i11 + i10;
            int i16 = 0;
            while (i16 < length && (i14 = i16 + i10) < i15 && (charAt = charSequence.charAt(i16)) < 128) {
                bArr[i14] = (byte) charAt;
                i16++;
            }
            int i17 = i10 + i16;
            while (i16 < length) {
                char charAt2 = charSequence.charAt(i16);
                if (charAt2 >= 128 || i17 >= i15) {
                    if (charAt2 < 2048 && i17 <= i15 - 2) {
                        int i18 = i17 + 1;
                        bArr[i17] = (byte) ((charAt2 >>> 6) | 960);
                        i17 = i18 + 1;
                        bArr[i18] = (byte) ((charAt2 & '?') | 128);
                    } else if ((charAt2 < 55296 || 57343 < charAt2) && i17 <= i15 - 3) {
                        int i19 = i17 + 1;
                        bArr[i17] = (byte) ((charAt2 >>> '\f') | 480);
                        int i20 = i19 + 1;
                        bArr[i19] = (byte) (((charAt2 >>> 6) & 63) | 128);
                        i13 = i20 + 1;
                        bArr[i20] = (byte) ((charAt2 & '?') | 128);
                    } else if (i17 <= i15 - 4) {
                        int i21 = i16 + 1;
                        if (i21 != charSequence.length()) {
                            char charAt3 = charSequence.charAt(i21);
                            if (Character.isSurrogatePair(charAt2, charAt3)) {
                                int codePoint = Character.toCodePoint(charAt2, charAt3);
                                int i22 = i17 + 1;
                                bArr[i17] = (byte) ((codePoint >>> 18) | 240);
                                int i23 = i22 + 1;
                                bArr[i22] = (byte) (((codePoint >>> 12) & 63) | 128);
                                int i24 = i23 + 1;
                                bArr[i23] = (byte) (((codePoint >>> 6) & 63) | 128);
                                i17 = i24 + 1;
                                bArr[i24] = (byte) ((codePoint & 63) | 128);
                                i16 = i21;
                            } else {
                                i16 = i21;
                            }
                        }
                        throw new c(i16 - 1, length);
                    } else if (55296 > charAt2 || charAt2 > 57343 || ((i12 = i16 + 1) != charSequence.length() && Character.isSurrogatePair(charAt2, charSequence.charAt(i12)))) {
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + i17);
                    } else {
                        throw new c(i16, length);
                    }
                    i16++;
                } else {
                    i13 = i17 + 1;
                    bArr[i17] = (byte) charAt2;
                }
                i17 = i13;
                i16++;
            }
            return i17;
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0015, code lost:
            if (r8[r9] > (-65)) goto L12;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0046, code lost:
            if (r8[r9] > (-65)) goto L31;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x007f, code lost:
            if (r8[r9] > (-65)) goto L52;
         */
        @Override // com.google.protobuf.d1.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        int c(int i10, byte[] bArr, int i11, int i12) {
            int i13;
            if (i10 != 0) {
                if (i11 >= i12) {
                    return i10;
                }
                byte b10 = (byte) i10;
                if (b10 < -32) {
                    if (b10 >= -62) {
                        i13 = i11 + 1;
                    }
                    return -1;
                } else if (b10 < -16) {
                    byte b11 = (byte) (~(i10 >> 8));
                    if (b11 == 0) {
                        int i14 = i11 + 1;
                        byte b12 = bArr[i11];
                        if (i14 >= i12) {
                            return d1.i(b10, b12);
                        }
                        i11 = i14;
                        b11 = b12;
                    }
                    if (b11 <= -65 && ((b10 != -32 || b11 >= -96) && (b10 != -19 || b11 < -96))) {
                        i13 = i11 + 1;
                    }
                    return -1;
                } else {
                    byte b13 = (byte) (~(i10 >> 8));
                    byte b14 = 0;
                    if (b13 == 0) {
                        int i15 = i11 + 1;
                        b13 = bArr[i11];
                        if (i15 >= i12) {
                            return d1.i(b10, b13);
                        }
                        i11 = i15;
                    } else {
                        b14 = (byte) (i10 >> 16);
                    }
                    if (b14 == 0) {
                        int i16 = i11 + 1;
                        b14 = bArr[i11];
                        if (i16 >= i12) {
                            return d1.j(b10, b13, b14);
                        }
                        i11 = i16;
                    }
                    if (b13 <= -65 && (((b10 << 28) + (b13 + 112)) >> 30) == 0 && b14 <= -65) {
                        i13 = i11 + 1;
                    }
                    return -1;
                }
                i11 = i13;
            }
            return d(bArr, i11, i12);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Utf8.java */
    /* loaded from: classes.dex */
    public static class c extends IllegalArgumentException {
        c(int i10, int i11) {
            super("Unpaired surrogate at index " + i10 + " of " + i11);
        }
    }

    /* compiled from: Utf8.java */
    /* loaded from: classes.dex */
    static final class d extends a {
        d() {
        }

        static boolean d() {
            return c1.h() && c1.i();
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x0039, code lost:
            return -1;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x008e, code lost:
            return -1;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private static int e(byte[] bArr, long j10, int i10) {
            long j11;
            int f10 = f(bArr, j10, i10);
            int i11 = i10 - f10;
            long j12 = j10 + f10;
            while (true) {
                byte b10 = 0;
                while (true) {
                    if (i11 <= 0) {
                        break;
                    }
                    long j13 = j12 + 1;
                    b10 = c1.e(bArr, j12);
                    if (b10 < 0) {
                        j12 = j13;
                        break;
                    }
                    i11--;
                    j12 = j13;
                }
                if (i11 == 0) {
                    return 0;
                }
                int i12 = i11 - 1;
                if (b10 >= -32) {
                    if (b10 >= -16) {
                        if (i12 >= 3) {
                            i11 = i12 - 3;
                            long j14 = j12 + 1;
                            byte e10 = c1.e(bArr, j12);
                            if (e10 > -65 || (((b10 << 28) + (e10 + 112)) >> 30) != 0) {
                                break;
                            }
                            long j15 = j14 + 1;
                            if (c1.e(bArr, j14) > -65) {
                                break;
                            }
                            j11 = 1 + j15;
                            if (c1.e(bArr, j15) > -65) {
                                break;
                            }
                        } else {
                            return g(bArr, b10, j12, i12);
                        }
                    } else if (i12 >= 2) {
                        i11 = i12 - 2;
                        long j16 = j12 + 1;
                        byte e11 = c1.e(bArr, j12);
                        if (e11 > -65 || ((b10 == -32 && e11 < -96) || (b10 == -19 && e11 >= -96))) {
                            break;
                        }
                        j11 = 1 + j16;
                        if (c1.e(bArr, j16) > -65) {
                            break;
                        }
                    } else {
                        return g(bArr, b10, j12, i12);
                    }
                } else if (i12 != 0) {
                    i11 = i12 - 1;
                    if (b10 < -62) {
                        break;
                    }
                    j11 = 1 + j12;
                    if (c1.e(bArr, j12) > -65) {
                        break;
                    }
                } else {
                    return b10;
                }
                j12 = j11;
            }
        }

        private static int f(byte[] bArr, long j10, int i10) {
            if (i10 < 16) {
                return 0;
            }
            int i11 = ((int) j10) & 7;
            for (int i12 = i11; i12 > 0; i12--) {
                j10 = 1 + j10;
                if (c1.e(bArr, j10) < 0) {
                    return i11 - i12;
                }
            }
            int i13 = i10 - i11;
            while (i13 >= 8 && (c1.f(bArr, j10) & (-9187201950435737472L)) == 0) {
                j10 += 8;
                i13 -= 8;
            }
            return i10 - i13;
        }

        private static int g(byte[] bArr, int i10, long j10, int i11) {
            if (i11 == 0) {
                return d1.h(i10);
            }
            if (i11 == 1) {
                return d1.i(i10, c1.e(bArr, j10));
            }
            if (i11 == 2) {
                return d1.j(i10, c1.e(bArr, j10), c1.e(bArr, j10 + 1));
            }
            throw new AssertionError();
        }

        @Override // com.google.protobuf.d1.a
        int a(CharSequence charSequence, byte[] bArr, int i10, int i11) {
            char c10;
            long j10;
            long d10;
            long j11;
            char c11;
            long j12;
            int i12;
            char charAt;
            long d11 = c1.d() + i10;
            long j13 = i11 + d11;
            int length = charSequence.length();
            if (length > i11 || bArr.length - i11 < i10) {
                throw new ArrayIndexOutOfBoundsException("Failed writing " + charSequence.charAt(length - 1) + " at index " + (i10 + i11));
            }
            int i13 = 0;
            while (true) {
                c10 = 128;
                j10 = 1;
                if (i13 >= length || (charAt = charSequence.charAt(i13)) >= 128) {
                    break;
                }
                d11 = 1 + d11;
                c1.j(bArr, d11, (byte) charAt);
                i13++;
            }
            if (i13 == length) {
                d10 = c1.d();
            } else {
                while (i13 < length) {
                    char charAt2 = charSequence.charAt(i13);
                    if (charAt2 < c10 && d11 < j13) {
                        j11 = d11 + j10;
                        c1.j(bArr, d11, (byte) charAt2);
                        j12 = j10;
                        c11 = c10;
                    } else if (charAt2 < 2048 && d11 <= j13 - 2) {
                        long j14 = d11 + j10;
                        c1.j(bArr, d11, (byte) ((charAt2 >>> 6) | 960));
                        j11 = j14 + j10;
                        c1.j(bArr, j14, (byte) ((charAt2 & '?') | 128));
                        j12 = j10;
                        c11 = 128;
                    } else if ((charAt2 < 55296 || 57343 < charAt2) && d11 <= j13 - 3) {
                        long j15 = d11 + j10;
                        c1.j(bArr, d11, (byte) ((charAt2 >>> '\f') | 480));
                        long j16 = j15 + j10;
                        c1.j(bArr, j15, (byte) (((charAt2 >>> 6) & 63) | 128));
                        j11 = j16 + 1;
                        c1.j(bArr, j16, (byte) ((charAt2 & '?') | 128));
                        j12 = 1;
                        c11 = 128;
                    } else if (d11 <= j13 - 4) {
                        int i14 = i13 + 1;
                        if (i14 != length) {
                            char charAt3 = charSequence.charAt(i14);
                            if (Character.isSurrogatePair(charAt2, charAt3)) {
                                int codePoint = Character.toCodePoint(charAt2, charAt3);
                                long j17 = d11 + 1;
                                c1.j(bArr, d11, (byte) ((codePoint >>> 18) | 240));
                                long j18 = j17 + 1;
                                c11 = 128;
                                c1.j(bArr, j17, (byte) (((codePoint >>> 12) & 63) | 128));
                                long j19 = j18 + 1;
                                c1.j(bArr, j18, (byte) (((codePoint >>> 6) & 63) | 128));
                                j12 = 1;
                                j11 = j19 + 1;
                                c1.j(bArr, j19, (byte) ((codePoint & 63) | 128));
                                i13 = i14;
                            } else {
                                i13 = i14;
                            }
                        }
                        throw new c(i13 - 1, length);
                    } else if (55296 > charAt2 || charAt2 > 57343 || ((i12 = i13 + 1) != length && Character.isSurrogatePair(charAt2, charSequence.charAt(i12)))) {
                        throw new ArrayIndexOutOfBoundsException("Failed writing " + charAt2 + " at index " + d11);
                    } else {
                        throw new c(i13, length);
                    }
                    i13++;
                    c10 = c11;
                    j10 = j12;
                    d11 = j11;
                }
                d10 = c1.d();
            }
            return (int) (d11 - d10);
        }

        /* JADX WARN: Code restructure failed: missing block: B:34:0x0063, code lost:
            if (com.google.protobuf.c1.e(r13, r2) > (-65)) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00a8, code lost:
            if (com.google.protobuf.c1.e(r13, r2) > (-65)) goto L57;
         */
        @Override // com.google.protobuf.d1.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        int c(int i10, byte[] bArr, int i11, int i12) {
            long j10;
            byte b10 = 0;
            if ((i11 | i12 | (bArr.length - i12)) >= 0) {
                long d10 = c1.d() + i11;
                long d11 = c1.d() + i12;
                if (i10 != 0) {
                    if (d10 >= d11) {
                        return i10;
                    }
                    byte b11 = (byte) i10;
                    if (b11 < -32) {
                        if (b11 >= -62) {
                            d10 = 1 + d10;
                            if (c1.e(bArr, d10) <= -65) {
                            }
                        }
                        return -1;
                    }
                    if (b11 < -16) {
                        byte b12 = (byte) (~(i10 >> 8));
                        if (b12 == 0) {
                            long j11 = d10 + 1;
                            b12 = c1.e(bArr, d10);
                            if (j11 >= d11) {
                                return d1.i(b11, b12);
                            }
                            d10 = j11;
                        }
                        if (b12 <= -65 && ((b11 != -32 || b12 >= -96) && (b11 != -19 || b12 < -96))) {
                            j10 = d10 + 1;
                        }
                        return -1;
                    }
                    byte b13 = (byte) (~(i10 >> 8));
                    if (b13 == 0) {
                        long j12 = d10 + 1;
                        b13 = c1.e(bArr, d10);
                        if (j12 >= d11) {
                            return d1.i(b11, b13);
                        }
                        d10 = j12;
                    } else {
                        b10 = (byte) (i10 >> 16);
                    }
                    if (b10 == 0) {
                        long j13 = d10 + 1;
                        b10 = c1.e(bArr, d10);
                        if (j13 >= d11) {
                            return d1.j(b11, b13, b10);
                        }
                        d10 = j13;
                    }
                    if (b13 <= -65 && (((b11 << 28) + (b13 + 112)) >> 30) == 0 && b10 <= -65) {
                        j10 = d10 + 1;
                    }
                    return -1;
                    d10 = j10;
                }
                return e(bArr, d10, (int) (d11 - d10));
            }
            throw new ArrayIndexOutOfBoundsException(String.format("Array length=%d, index=%d, limit=%d", Integer.valueOf(bArr.length), Integer.valueOf(i11), Integer.valueOf(i12)));
        }
    }

    static {
        f13219a = d.d() ? new d() : new b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(CharSequence charSequence, byte[] bArr, int i10, int i11) {
        return f13219a.a(charSequence, bArr, i10, i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int f(CharSequence charSequence) {
        int length = charSequence.length();
        int i10 = 0;
        while (i10 < length && charSequence.charAt(i10) < 128) {
            i10++;
        }
        int i11 = length;
        while (true) {
            if (i10 < length) {
                char charAt = charSequence.charAt(i10);
                if (charAt >= 2048) {
                    i11 += g(charSequence, i10);
                    break;
                }
                i11 += (127 - charAt) >>> 31;
                i10++;
            } else {
                break;
            }
        }
        if (i11 >= length) {
            return i11;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (i11 + 4294967296L));
    }

    private static int g(CharSequence charSequence, int i10) {
        int length = charSequence.length();
        int i11 = 0;
        while (i10 < length) {
            char charAt = charSequence.charAt(i10);
            if (charAt < 2048) {
                i11 += (127 - charAt) >>> 31;
            } else {
                i11 += 2;
                if (55296 <= charAt && charAt <= 57343) {
                    if (Character.codePointAt(charSequence, i10) >= 65536) {
                        i10++;
                    } else {
                        throw new c(i10, length);
                    }
                }
            }
            i10++;
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int h(int i10) {
        if (i10 > -12) {
            return -1;
        }
        return i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int i(int i10, int i11) {
        if (i10 > -12 || i11 > -65) {
            return -1;
        }
        return i10 ^ (i11 << 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int j(int i10, int i11, int i12) {
        if (i10 > -12 || i11 > -65 || i12 > -65) {
            return -1;
        }
        return (i10 ^ (i11 << 8)) ^ (i12 << 16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int k(byte[] bArr, int i10, int i11) {
        byte b10 = bArr[i10 - 1];
        int i12 = i11 - i10;
        if (i12 == 0) {
            return h(b10);
        }
        if (i12 == 1) {
            return i(b10, bArr[i10]);
        }
        if (i12 == 2) {
            return j(b10, bArr[i10], bArr[i10 + 1]);
        }
        throw new AssertionError();
    }

    public static boolean l(byte[] bArr) {
        return f13219a.b(bArr, 0, bArr.length);
    }

    public static boolean m(byte[] bArr, int i10, int i11) {
        return f13219a.b(bArr, i10, i11);
    }

    public static int n(int i10, byte[] bArr, int i11, int i12) {
        return f13219a.c(i10, bArr, i11, i12);
    }
}
