package com.huawei.hms.scankit.p;

import com.huawei.hms.scankit.aiscan.common.A;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.aiscan.common.C0550a;
import com.huawei.hms.scankit.aiscan.common.EnumC0553d;
import com.huawei.hms.scankit.aiscan.common.x;
import com.huawei.hms.scankit.aiscan.common.z;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
/* compiled from: UPCEANReader.java */
/* loaded from: classes2.dex */
public abstract class M extends H {

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f14588a = {1, 1, 1};

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f14589b = {1, 1, 1, 1, 1};

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f14590c = {1, 1, 1, 1, 1, 1};

    /* renamed from: d  reason: collision with root package name */
    public static final int[][] f14591d;

    /* renamed from: e  reason: collision with root package name */
    public static final int[][] f14592e;

    /* renamed from: f  reason: collision with root package name */
    private final StringBuilder f14593f = new StringBuilder(20);

    /* renamed from: g  reason: collision with root package name */
    private final L f14594g = new L();

    static {
        int[][] iArr = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
        f14591d = iArr;
        int[][] iArr2 = new int[20];
        f14592e = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, 10);
        for (int i10 = 10; i10 < 20; i10++) {
            int[] iArr3 = f14591d[i10 - 10];
            int[] iArr4 = new int[iArr3.length];
            for (int i11 = 0; i11 < iArr3.length; i11++) {
                iArr4[i11] = iArr3[(iArr3.length - i11) - 1];
            }
            f14592e[i10] = iArr4;
        }
    }

    static int[] a(C0591h hVar) throws C0550a {
        return b(hVar, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ArrayList<int[]> b(C0591h hVar) throws C0550a {
        int d10 = hVar.d() / 2;
        ArrayList<int[]> arrayList = new ArrayList<>();
        int i10 = 0;
        while (i10 < d10) {
            try {
                int[] b10 = b(hVar, i10);
                arrayList.add(b10);
                i10 = b10[0] + 1;
            } catch (C0550a unused) {
            }
        }
        if (arrayList.size() != 0) {
            return arrayList;
        }
        throw C0550a.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int a(C0591h hVar, int[] iArr, StringBuilder sb2) throws C0550a;

    abstract BarcodeFormat a();

    abstract boolean a(int i10, int i11, C0591h hVar);

    abstract boolean a(int[] iArr, int[] iArr2) throws C0550a;

    @Override // com.huawei.hms.scankit.p.H
    public x a(int i10, C0591h hVar, Map<EnumC0553d, ?> map) throws C0550a {
        return a(i10, hVar, a(hVar), map);
    }

    public x a(int i10, C0591h hVar, int[] iArr, Map<EnumC0553d, ?> map) throws C0550a {
        A a10 = map == null ? null : (A) map.get(EnumC0553d.NEED_RESULT_POINT_CALLBACK);
        if (a10 != null) {
            a10.a(new z((iArr[0] + iArr[1]) / 2.0f, i10));
        }
        StringBuilder sb2 = this.f14593f;
        sb2.setLength(0);
        int a11 = a(hVar, iArr, sb2);
        if (a10 != null) {
            a10.a(new z(a11, i10));
        }
        int[] a12 = a(hVar, a11);
        if (a12[0] - a11 <= 1) {
            if (a10 != null) {
                a10.a(new z((a12[0] + a12[1]) / 2.0f, i10));
            }
            if (a(iArr, a12)) {
                int i11 = a12[1];
                if ((i11 - a12[0]) + i11 >= hVar.d() || !a(a12[0], i11, hVar)) {
                    throw C0550a.a();
                }
                String sb3 = sb2.toString();
                if (sb3.length() < 8) {
                    throw C0550a.a();
                } else if (a(sb3)) {
                    float f10 = i10;
                    x xVar = new x(sb3, null, new z[]{new z(iArr[0], f10), new z(a12[1], f10)}, a());
                    a(xVar, a12, i10, hVar, map);
                    return xVar;
                } else {
                    throw C0550a.a();
                }
            } else {
                throw C0550a.a();
            }
        } else {
            throw C0550a.a();
        }
    }

    static int[] b(C0591h hVar, int i10) throws C0550a {
        int[] iArr = new int[f14588a.length];
        int[] iArr2 = null;
        boolean z10 = false;
        while (!z10) {
            int[] iArr3 = f14588a;
            Arrays.fill(iArr, 0, iArr3.length, 0);
            iArr2 = a(hVar, i10, false, iArr3, iArr);
            int i11 = iArr2[0];
            int i12 = iArr2[1];
            int i13 = i11 - (i12 - i11);
            int i14 = i13 + 3;
            while (i13 <= i14 && (i13 < 0 || !(z10 = hVar.a(i13, i11, false, true)))) {
                i13++;
            }
            i10 = i12;
        }
        return iArr2;
    }

    public static int b(CharSequence charSequence) throws C0550a {
        int length = charSequence.length();
        int i10 = 0;
        for (int i11 = length - 1; i11 >= 0; i11 -= 2) {
            int charAt = charSequence.charAt(i11) - '0';
            if (charAt < 0 || charAt > 9) {
                throw C0550a.a();
            }
            i10 += charAt;
        }
        int i12 = i10 * 3;
        for (int i13 = length - 2; i13 >= 0; i13 -= 2) {
            int charAt2 = charSequence.charAt(i13) - '0';
            if (charAt2 < 0 || charAt2 > 9) {
                throw C0550a.a();
            }
            i12 += charAt2;
        }
        return (1000 - i12) % 10;
    }

    private void a(x xVar, int[] iArr, int i10, C0591h hVar, Map<EnumC0553d, ?> map) throws C0550a {
        int i11;
        boolean z10 = true;
        try {
            x a10 = this.f14594g.a(i10, hVar, iArr[1]);
            xVar.a(a10.f());
            i11 = a10.g().length();
        } catch (C0550a unused) {
            i11 = 0;
        }
        int[] iArr2 = map == null ? null : (int[]) map.get(EnumC0553d.ALLOWED_EAN_EXTENSIONS);
        if (iArr2 != null) {
            int length = iArr2.length;
            int i12 = 0;
            while (true) {
                if (i12 >= length) {
                    z10 = false;
                    break;
                } else if (i11 == iArr2[i12]) {
                    break;
                } else {
                    i12++;
                }
            }
            if (!z10) {
                throw C0550a.a();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(String str) throws C0550a {
        return a((CharSequence) str);
    }

    public static boolean a(CharSequence charSequence) throws C0550a {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        int i10 = length - 1;
        return b(charSequence.subSequence(0, i10)) == Character.digit(charSequence.charAt(i10), 10);
    }

    int[] a(C0591h hVar, int i10) throws C0550a {
        return a(hVar, i10, false, f14588a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int[] a(C0591h hVar, int i10, boolean z10, int[] iArr) throws C0550a {
        return a(hVar, i10, z10, iArr, new int[iArr.length]);
    }

    private static int[] a(C0591h hVar, int i10, boolean z10, int[] iArr, int[] iArr2) throws C0550a {
        int d10 = hVar.d();
        int c10 = z10 ? hVar.c(i10) : hVar.b(i10);
        int length = iArr.length;
        boolean z11 = z10;
        int i11 = 0;
        int i12 = c10;
        while (c10 < d10) {
            if (hVar.a(c10) == z11) {
                if (i11 != length - 1) {
                    i11++;
                } else if (H.a(iArr2, iArr, 0.8f) < 0.46f) {
                    return new int[]{i12, c10};
                } else {
                    i12 += iArr2[0] + iArr2[1];
                    int i13 = i11 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i13);
                    iArr2[i13] = 0;
                    iArr2[i11] = 0;
                    i11--;
                }
                iArr2[i11] = 1;
                z11 = !z11;
            } else if (i11 < 0 || i11 >= iArr2.length) {
                throw C0550a.a();
            } else {
                iArr2[i11] = iArr2[i11] + 1;
            }
            c10++;
        }
        throw C0550a.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(C0591h hVar, int[] iArr, int i10, int[][] iArr2) throws C0550a {
        H.a(hVar, i10, iArr);
        int length = iArr2.length;
        float f10 = 0.46f;
        int i11 = -1;
        for (int i12 = 0; i12 < length; i12++) {
            float a10 = H.a(iArr, iArr2[i12], 0.8f);
            if (a10 < f10) {
                i11 = i12;
                f10 = a10;
            }
        }
        if (i11 >= 0) {
            return i11;
        }
        throw C0550a.a();
    }
}
