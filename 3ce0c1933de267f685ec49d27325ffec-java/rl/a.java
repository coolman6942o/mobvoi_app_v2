package rl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kl.b;
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public int f33605a;

    /* renamed from: b  reason: collision with root package name */
    public int f33606b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f33607c;

    public a(int i10, int i11, byte[] bArr) {
        this.f33605a = i10;
        this.f33606b = i11;
        this.f33607c = bArr;
        boolean z10 = b.f30016b;
    }

    public static List<a> a(byte[] bArr) {
        String str;
        int i10;
        ArrayList arrayList = new ArrayList();
        int length = bArr.length;
        int i11 = 0;
        int i12 = 1;
        while (i11 < length) {
            int i13 = ((bArr[i11 + 1] << 8) & 65280) | (bArr[i11] & 255);
            int i14 = i11 + 2;
            int i15 = i14 + 1;
            byte b10 = bArr[i14];
            if (!b(i13)) {
                if (i13 <= 0 || i13 >= 255) {
                    int i16 = length - 1;
                    if (!c(bArr, i15, i16) && !f(bArr, i15, i16)) {
                        str = String.format("invalid type: 0x%04X", Integer.valueOf(i13));
                        il.b.c(str);
                        arrayList = null;
                        break;
                    }
                    il.b.k(b.f30016b, "no more data");
                } else {
                    il.b.c(String.format("undefined type: 0x%04X", Integer.valueOf(i13)));
                }
            }
            if (b10 == 0) {
                i11 = i15;
            } else {
                int i17 = i15 + b10;
                if (i17 > length) {
                    str = "invalid mp header length";
                    il.b.c(str);
                    arrayList = null;
                    break;
                }
                try {
                    a aVar = new a(i13, b10, Arrays.copyOfRange(bArr, i15, i17));
                    if (i13 == 1) {
                        i10 = i12 | 1;
                    } else if (i13 == 2) {
                        i10 = i12 | 2;
                    } else if (i13 == 3) {
                        i10 = i12 | 4;
                    } else {
                        if (i13 == 4) {
                            i10 = i12 | 8;
                        }
                        arrayList.add(aVar);
                        i11 = i17;
                    }
                    i12 = i10;
                    arrayList.add(aVar);
                    i11 = i17;
                } catch (Exception e10) {
                    il.b.e(e10.toString());
                }
            }
        }
        if (i12 != 15) {
            il.b.c(String.format("miss required type 0x%04X", Integer.valueOf(i12)));
            return null;
        }
        il.b.k(b.f30016b, String.format("requiredIndicator=0x%04X", Integer.valueOf(i12)));
        return arrayList;
    }

    public static boolean b(int i10) {
        if (!(i10 == 32 || i10 == 34 || i10 == 254 || i10 == 1 || i10 == 2 || i10 == 3 || i10 == 4)) {
            switch (i10) {
                case 17:
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                    break;
                default:
                    switch (i10) {
                        case 80:
                        case 81:
                        case 82:
                            break;
                        default:
                            return false;
                    }
            }
        }
        return true;
    }

    public static boolean c(byte[] bArr, int i10, int i11) {
        while (i10 <= i11) {
            if ((bArr[i10] & 255) != 0) {
                return false;
            }
            i10++;
        }
        return true;
    }

    public static boolean f(byte[] bArr, int i10, int i11) {
        while (i10 <= i11) {
            if ((bArr[i10] & 255) != 255) {
                return false;
            }
            i10++;
        }
        return true;
    }

    public byte[] d() {
        return this.f33607c;
    }

    public int e() {
        return this.f33605a;
    }

    public String toString() {
        return String.format(Locale.US, "definedId:0x%04d, data: (%d) %s", Integer.valueOf(this.f33605a), Integer.valueOf(this.f33606b), jl.a.a(this.f33607c));
    }
}
