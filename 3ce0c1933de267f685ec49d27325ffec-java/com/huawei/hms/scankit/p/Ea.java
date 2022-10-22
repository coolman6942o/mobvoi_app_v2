package com.huawei.hms.scankit.p;
/* compiled from: FormatInformation.java */
/* loaded from: classes2.dex */
final class Ea {

    /* renamed from: a  reason: collision with root package name */
    private static final int[][] f14505a = {new int[]{21522, 0}, new int[]{20773, 1}, new int[]{24188, 2}, new int[]{23371, 3}, new int[]{17913, 4}, new int[]{16590, 5}, new int[]{20375, 6}, new int[]{19104, 7}, new int[]{30660, 8}, new int[]{29427, 9}, new int[]{32170, 10}, new int[]{30877, 11}, new int[]{26159, 12}, new int[]{25368, 13}, new int[]{27713, 14}, new int[]{26998, 15}, new int[]{5769, 16}, new int[]{5054, 17}, new int[]{7399, 18}, new int[]{6608, 19}, new int[]{1890, 20}, new int[]{597, 21}, new int[]{3340, 22}, new int[]{2107, 23}, new int[]{13663, 24}, new int[]{12392, 25}, new int[]{16177, 26}, new int[]{14854, 27}, new int[]{9396, 28}, new int[]{8579, 29}, new int[]{11994, 30}, new int[]{11245, 31}};

    /* renamed from: b  reason: collision with root package name */
    private final EnumC0647za f14506b;

    /* renamed from: c  reason: collision with root package name */
    private final byte f14507c;

    private Ea(int i10) {
        this.f14506b = EnumC0647za.a((i10 >> 3) & 3);
        this.f14507c = (byte) (i10 & 7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Ea a(int i10, int i11) {
        Ea c10 = c(i10, i11);
        return c10 != null ? c10 : c(i10 ^ 21522, i11 ^ 21522);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i10, int i11) {
        return Integer.bitCount(i10 ^ i11);
    }

    private static Ea c(int i10, int i11) {
        int[][] iArr;
        int b10;
        int i12 = Integer.MAX_VALUE;
        int i13 = 0;
        for (int[] iArr2 : f14505a) {
            int i14 = iArr2[0];
            if (i14 == i10 || i14 == i11) {
                return new Ea(iArr2[1]);
            }
            int b11 = b(i10, i14);
            if (b11 < i12) {
                i13 = iArr2[1];
                i12 = b11;
            }
            if (i10 != i11 && (b10 = b(i11, i14)) < i12) {
                i13 = iArr2[1];
                i12 = b10;
            }
        }
        if (i12 <= 3) {
            return new Ea(i13);
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Ea)) {
            return false;
        }
        Ea ea2 = (Ea) obj;
        return this.f14506b == ea2.f14506b && this.f14507c == ea2.f14507c;
    }

    public int hashCode() {
        return (this.f14506b.ordinal() << 3) | this.f14507c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EnumC0647za b() {
        return this.f14506b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte a() {
        return this.f14507c;
    }
}
