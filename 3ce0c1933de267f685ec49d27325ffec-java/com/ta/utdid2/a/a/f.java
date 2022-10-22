package com.ta.utdid2.a.a;
/* loaded from: classes2.dex */
public class f {

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: d  reason: collision with root package name */
        public int[] f22417d;

        /* renamed from: x  reason: collision with root package name */
        public int f22418x;

        /* renamed from: y  reason: collision with root package name */
        public int f22419y;

        public a() {
            this.f22417d = new int[256];
        }
    }

    public static byte[] a(byte[] bArr) {
        a a10;
        if (bArr == null || (a10 = a("QrMgt8GGYI6T52ZY5AnhtxkLzb8egpFn3j5JELI8H6wtACbUnZ5cc3aYTsTRbmkAkRJeYbtx92LPBWm7nBO9UIl7y5i5MQNmUZNf5QENurR5tGyo7yJ2G0MBjWvy6iAtlAbacKP0SwOUeUWx5dsBdyhxa7Id1APtybSdDgicBDuNjI0mlZFUzZSS9dmN8lBD0WTVOMz0pRZbR3cysomRXOO1ghqjJdTcyDIxzpNAEszN8RMGjrzyU7Hjbmwi6YNK")) == null) {
            return null;
        }
        return a(bArr, a10);
    }

    public static a a(String str) {
        if (str == null) {
            return null;
        }
        a aVar = new a();
        for (int i10 = 0; i10 < 256; i10++) {
            aVar.f22417d[i10] = i10;
        }
        aVar.f22418x = 0;
        aVar.f22419y = 0;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < 256; i13++) {
            try {
                char charAt = str.charAt(i11);
                int[] iArr = aVar.f22417d;
                i12 = ((charAt + iArr[i13]) + i12) % 256;
                int i14 = iArr[i13];
                iArr[i13] = iArr[i12];
                iArr[i12] = i14;
                i11 = (i11 + 1) % str.length();
            } catch (Exception unused) {
                return null;
            }
        }
        return aVar;
    }

    public static byte[] a(byte[] bArr, a aVar) {
        if (bArr == null || aVar == null) {
            return null;
        }
        int i10 = aVar.f22418x;
        int i11 = aVar.f22419y;
        for (int i12 = 0; i12 < bArr.length; i12++) {
            i10 = (i10 + 1) % 256;
            int[] iArr = aVar.f22417d;
            i11 = (iArr[i10] + i11) % 256;
            int i13 = iArr[i10];
            iArr[i10] = iArr[i11];
            iArr[i11] = i13;
            bArr[i12] = (byte) (iArr[(iArr[i10] + iArr[i11]) % 256] ^ bArr[i12]);
        }
        aVar.f22418x = i10;
        aVar.f22419y = i11;
        return bArr;
    }
}
