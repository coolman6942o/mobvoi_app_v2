package com.huawei.hms.scankit;

import android.graphics.Bitmap;
import android.util.Log;
import com.huawei.hms.feature.DynamicModuleInitializer;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.aiscan.common.E;
import com.huawei.hms.scankit.aiscan.common.m;
import com.huawei.hms.scankit.aiscan.common.p;
import com.huawei.hms.scankit.aiscan.common.r;
import com.huawei.hms.scankit.aiscan.common.s;
import com.huawei.hms.scankit.aiscan.common.x;
import com.huawei.hms.scankit.p.C0634v;
import com.huawei.hms.scankit.p.Ja;
import com.huawei.hms.scankit.p.Ka;
import com.huawei.hms.scankit.util.a;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* compiled from: DecodeMultiCodes.java */
/* loaded from: classes2.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f14398a = true;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f14399b = false;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f14400c = false;

    /* renamed from: d  reason: collision with root package name */
    private static LinkedList<C0634v> f14401d = new LinkedList<>();

    /* renamed from: e  reason: collision with root package name */
    private static LinkedList<p> f14402e = new LinkedList<>();

    /* renamed from: f  reason: collision with root package name */
    private static LinkedList<p> f14403f = new LinkedList<>();

    static {
        if (DynamicModuleInitializer.getContext() != null) {
            Log.i("ScankitDecode", "static initializer: InitModuleBegin");
            z.b(DynamicModuleInitializer.getContext(), "detect.ms");
            z.c(DynamicModuleInitializer.getContext(), "anchors.bin");
            z.a(DynamicModuleInitializer.getContext(), "angle.ms");
            Log.i("ScankitDecode", "static initializer: InitModuleEnd");
            return;
        }
        Log.e("ScankitDecode", "static initializer: context null");
    }

    public static x a(List<BarcodeFormat> list, l lVar) {
        if (list.size() > 0) {
            return lVar.d(list, null);
        }
        return null;
    }

    public static x[] b(Bitmap bitmap, E e10) {
        byte[] bArr;
        try {
            e10.f14072a = bitmap.getWidth();
            int height = bitmap.getHeight();
            e10.f14073b = height;
            int i10 = e10.f14072a;
            int[] iArr = new int[i10 * height];
            bitmap.getPixels(iArr, 0, i10, 0, 0, i10, height);
            bArr = new s(e10.f14072a, e10.f14073b, iArr).b();
        } catch (IllegalArgumentException unused) {
            a.b("exception", "IllegalArgumentException");
            bArr = null;
            return b(bArr, e10);
        } catch (Exception unused2) {
            a.b("exception", "Exception");
            bArr = null;
            return b(bArr, e10);
        } catch (OutOfMemoryError unused3) {
            a.b("exception", "OutOfMemoryError");
            bArr = null;
            return b(bArr, e10);
        } catch (UnsatisfiedLinkError unused4) {
            a.b("exception", "UnsatisfiedLinkError");
            bArr = null;
            return b(bArr, e10);
        } catch (UnsupportedOperationException unused5) {
            a.b("exception", "UnsupportedArgumentException");
            bArr = null;
            return b(bArr, e10);
        }
        return b(bArr, e10);
    }

    private static m c(byte[] bArr, E e10) {
        int i10 = e10.f14072a;
        int i11 = e10.f14073b;
        if (!e10.f14075d) {
            return new r(bArr, i10, i11, 0, 0, i10, i11, false);
        }
        byte[] bArr2 = new byte[i10 * i11];
        for (int i12 = 0; i12 < i11; i12++) {
            for (int i13 = 0; i13 < i10; i13++) {
                bArr2[(((i13 * i11) + i11) - i12) - 1] = bArr[(i12 * i10) + i13];
            }
        }
        e10.f14072a = i11;
        e10.f14073b = i10;
        return new r(bArr2, i11, i10, 0, 0, i11, i10, false);
    }

    public static x[] a(Bitmap bitmap, E e10) {
        byte[] bArr;
        try {
            e10.f14072a = bitmap.getWidth();
            int height = bitmap.getHeight();
            e10.f14073b = height;
            int i10 = e10.f14072a;
            int[] iArr = new int[i10 * height];
            bitmap.getPixels(iArr, 0, i10, 0, 0, i10, height);
            bArr = new s(e10.f14072a, e10.f14073b, iArr).b();
        } catch (IllegalArgumentException unused) {
            a.b("exception", "IllegalArgumentException");
            bArr = null;
            return a(bArr, e10);
        } catch (Exception unused2) {
            a.b("exception", "Exception");
            bArr = null;
            return a(bArr, e10);
        } catch (OutOfMemoryError unused3) {
            a.b("exception", "OutOfMemoryError");
            bArr = null;
            return a(bArr, e10);
        } catch (UnsatisfiedLinkError unused4) {
            a.b("exception", "UnsatisfiedLinkError");
            bArr = null;
            return a(bArr, e10);
        } catch (UnsupportedOperationException unused5) {
            a.b("exception", "UnsupportedArgumentException");
            bArr = null;
            return a(bArr, e10);
        }
        return a(bArr, e10);
    }

    public static x[] b(byte[] bArr, E e10) {
        x[] xVarArr = new x[0];
        try {
            return a(bArr, e10, true);
        } catch (IllegalArgumentException unused) {
            a.b("exception", "IllegalArgumentException");
            return xVarArr;
        } catch (Exception unused2) {
            a.b("exception", "Exception");
            return xVarArr;
        } catch (OutOfMemoryError unused3) {
            a.b("exception", "OutOfMemoryError");
            return xVarArr;
        } catch (UnsatisfiedLinkError unused4) {
            a.b("exception", "UnsatisfiedLinkError");
            return xVarArr;
        } catch (UnsupportedOperationException unused5) {
            a.b("exception", "UnsupportedArgumentException");
            return xVarArr;
        }
    }

    public static x[] a(ByteBuffer byteBuffer, E e10) {
        return a(byteBuffer.array(), e10);
    }

    public static x[] a(byte[] bArr, E e10) {
        x[] xVarArr = new x[0];
        try {
            x[] a10 = a(bArr, e10, false);
            int length = a10.length;
            int[] iArr = new int[length];
            int i10 = 0;
            int i11 = 0;
            while (i10 < a10.length) {
                int i12 = i10 + 1;
                for (int i13 = i12; i13 < a10.length; i13++) {
                    if (E.a(a10[i10].f(), a10[i13].f()) > 0.7d) {
                        iArr[i13] = 1;
                        i11++;
                    }
                }
                i10 = i12;
            }
            int length2 = a10.length - i11;
            xVarArr = new x[length2];
            for (int i14 = 0; i14 < length2; i14++) {
                int i15 = i14;
                while (i15 < length) {
                    if (iArr[i15] != 1) {
                        break;
                    }
                    i15++;
                }
                xVarArr[i14] = a10[i15];
            }
        } catch (IllegalArgumentException unused) {
            a.b("exception", "IllegalArgumentException");
        } catch (Exception unused2) {
            a.b("exception", "Exception");
        } catch (OutOfMemoryError unused3) {
            a.b("exception", "OutOfMemoryError");
        } catch (UnsatisfiedLinkError unused4) {
            a.b("exception", "UnsatisfiedLinkError");
        } catch (UnsupportedOperationException unused5) {
            a.b("exception", "UnsupportedArgumentException");
        }
        return xVarArr;
    }

    public static x[] b(m mVar, E e10) {
        boolean z10;
        a.c("ScankitDecode", "scankit mode:LITESDK1");
        Ka.a(e10);
        List<C0634v> arrayList = new ArrayList<>();
        if (e10.f14072a < 30 || e10.f14073b < 30 || mVar == null) {
            throw new IllegalArgumentException("widthOrHeight is Illeagle");
        }
        List<List<BarcodeFormat>> a10 = Ja.a(e10.f14074c);
        List<BarcodeFormat> list = a10.get(0);
        List<BarcodeFormat> list2 = a10.get(1);
        List<BarcodeFormat> list3 = a10.get(2);
        List<BarcodeFormat> list4 = a10.get(3);
        List<BarcodeFormat> list5 = a10.get(4);
        l lVar = new l(mVar);
        x xVar = null;
        x a11 = (!f14398a || f14400c) ? null : a(list, lVar);
        if (a11 == null || a11.g() == null) {
            arrayList = lVar.a(0, Ka.f14574l);
        }
        if (arrayList.size() > 0) {
            a11 = b(arrayList, lVar, a10);
        } else if (Ka.f14565c || !Ka.f14563a || Ka.f14564b) {
            if ((a11 == null || a11.g() == null) && list3.size() > 0) {
                a11 = lVar.c(list3, null);
            }
            if ((a11 == null || a11.g() == null) && list2.size() > 0 && (!Ka.f14563a || Ka.f14565c)) {
                a11 = lVar.a(list2, (C0634v) null);
            }
            if ((a11 == null || a11.g() == null) && list5.size() > 0) {
                a11 = lVar.b(list5, null);
            }
            if ((a11 == null || a11.g() == null) && list4.size() > 0) {
                a11 = lVar.b(list4, null);
            }
        }
        if (e10.f14076e && ((a11 == null || a11.g() == null) && !f14398a && f14399b && !f14400c)) {
            a11 = a(list, lVar);
            f14399b = false;
        }
        float f10 = 1.0f;
        if (!Ka.f14565c) {
            z10 = lVar.a();
            int i10 = Ka.f14569g - 1;
            if (i10 <= 0) {
                i10 = 0;
            }
            Ka.f14569g = i10;
            if (arrayList.size() > 0) {
                z10 = z10 || lVar.a(arrayList);
            }
            if (lVar.d() > 0.0f) {
                f10 = Math.max(1.0f, lVar.d());
            } else {
                f10 = Math.max(1.0f, Math.max(lVar.b(), lVar.c()));
            }
            xVar = l.a(arrayList, lVar);
        } else {
            z10 = false;
        }
        if (a11 != null && a11.g() != null) {
            a.c("ScankitDecode", "ScanCode successful");
            return new x[]{a11};
        } else if (z10) {
            a.c("ScankitDecode", "ScanCode need zoom");
            x xVar2 = new x(f10);
            xVar2.a(true);
            return new x[]{xVar2};
        } else if (arrayList.size() <= 0 || xVar == null) {
            a.c("ScankitDecode", "ScanCode null");
            return new x[0];
        } else {
            a.c("ScankitDecode", "ScanCode need exposure");
            return new x[]{xVar};
        }
    }

    public static x[] a(m mVar, E e10) {
        x a10;
        List arrayList = new ArrayList();
        Ka.a(e10);
        Ka.a(1);
        if (e10.f14072a < 30 || e10.f14073b < 30 || mVar == null) {
            throw new IllegalArgumentException("width or Height is Illeagle");
        }
        List<List<BarcodeFormat>> a11 = Ja.a(e10.f14074c);
        List<BarcodeFormat> list = a11.get(0);
        List<BarcodeFormat> list2 = a11.get(1);
        List<BarcodeFormat> list3 = a11.get(2);
        List<BarcodeFormat> list4 = a11.get(3);
        l lVar = new l(mVar);
        List<C0634v> a12 = lVar.a(1, Ka.f14574l);
        if (a12.size() > 0) {
            arrayList = a(a12, lVar, a11);
        } else if (!((!Ka.f14565c && Ka.f14563a) || (a10 = a(lVar, list, list2, list3, list4)) == null || a10.g() == null)) {
            arrayList.add(a10);
        }
        List<x> a13 = E.a(arrayList);
        return a13.size() > 0 ? (x[]) a13.toArray(new x[0]) : new x[0];
    }

    private static x a(l lVar, List<BarcodeFormat> list, List<BarcodeFormat> list2, List<BarcodeFormat> list3, List<BarcodeFormat> list4) {
        x e10 = list.size() > 0 ? lVar.e(list, null) : null;
        if ((e10 == null || e10.g() == null) && list3.size() > 0) {
            e10 = lVar.c(list3, null);
        }
        if ((e10 == null || e10.g() == null) && list2.size() > 0 && (!Ka.f14563a || Ka.f14565c)) {
            e10 = lVar.a(list2, (C0634v) null);
        }
        return ((e10 == null || e10.g() == null) && list4.size() > 0) ? lVar.b(list4, null) : e10;
    }

    public static List<x> a(List<C0634v> list, l lVar, List<List<BarcodeFormat>> list2) {
        x f10;
        List<BarcodeFormat> list3 = list2.get(0);
        List<BarcodeFormat> list4 = list2.get(1);
        List<BarcodeFormat> list5 = list2.get(2);
        List<BarcodeFormat> list6 = list2.get(3);
        List<BarcodeFormat> list7 = list2.get(4);
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        while (true) {
            x xVar = null;
            if (i10 >= list.size()) {
                break;
            }
            lVar.f14412i.a();
            C0634v vVar = list.get(i10);
            boolean z10 = vVar.g() == 5.0f;
            boolean z11 = vVar.g() == 1.0f;
            boolean z12 = vVar.g() == 3.0f;
            boolean z13 = vVar.g() == 2.0f;
            boolean z14 = vVar.g() == 4.0f;
            if (Ka.f14564b) {
                z10 = vVar.g() == 1.0f;
                z11 = vVar.g() == 2.0f;
                z12 = vVar.g() == 2.0f;
                z14 = vVar.g() == 1.0f;
                z13 = vVar.g() == 2.0f;
            }
            lVar.a(vVar);
            if (list3.size() > 0 && z11) {
                xVar = lVar.d(list3, vVar);
            }
            if ((xVar == null || xVar.g() == null) && list6.size() > 0 && z12) {
                xVar = lVar.b(list6, vVar);
            }
            if ((xVar == null || xVar.g() == null) && list5.size() > 0 && z14) {
                xVar = lVar.c(list5, vVar);
            }
            if ((xVar == null || xVar.g() == null) && list7.size() > 0 && z13) {
                xVar = lVar.b(list7, vVar);
            }
            if ((xVar == null || xVar.g() == null) && list4.size() > 0 && z10) {
                xVar = lVar.a(list4, vVar);
            }
            if (!(xVar == null || xVar.g() == null)) {
                arrayList.add(xVar);
            }
            i10++;
        }
        if (arrayList.size() == 0 && list3.size() > 0 && (f10 = lVar.f(list3, null)) != null && f10.g() != null) {
            arrayList.add(f10);
        }
        return arrayList;
    }

    public static x b(List<C0634v> list, l lVar, List<List<BarcodeFormat>> list2) {
        List<BarcodeFormat> list3 = list2.get(0);
        List<BarcodeFormat> list4 = list2.get(1);
        List<BarcodeFormat> list5 = list2.get(2);
        List<BarcodeFormat> list6 = list2.get(3);
        List<BarcodeFormat> list7 = list2.get(4);
        x xVar = null;
        for (int i10 = 0; i10 < list.size(); i10++) {
            if (i10 > 0) {
                lVar.f14412i.a();
            }
            C0634v vVar = list.get(i10);
            boolean z10 = vVar.g() == 5.0f;
            boolean z11 = vVar.g() == 1.0f;
            boolean z12 = vVar.g() == 2.0f;
            boolean z13 = vVar.g() == 3.0f;
            boolean z14 = vVar.g() == 4.0f;
            if (Ka.f14564b) {
                z10 = vVar.g() == 1.0f;
                z11 = vVar.g() == 2.0f;
                z12 = vVar.g() == 2.0f;
                z13 = vVar.g() == 2.0f;
                z14 = vVar.g() == 1.0f;
            }
            lVar.a(vVar);
            if ((xVar == null || xVar.g() == null) && list3.size() > 0 && z11) {
                f14399b = true;
                xVar = lVar.d(list3, vVar);
            }
            if ((xVar == null || xVar.g() == null) && list6.size() > 0 && z13) {
                xVar = lVar.b(list6, vVar);
            }
            if ((xVar == null || xVar.g() == null) && list7.size() > 0 && z12) {
                xVar = lVar.b(list7, vVar);
            }
            if ((xVar == null || xVar.g() == null) && list5.size() > 0 && z14) {
                xVar = lVar.c(list5, vVar);
            }
            if ((xVar == null || xVar.g() == null) && list4.size() > 0 && z10) {
                xVar = lVar.a(list4, vVar);
            }
            if (!(xVar == null || xVar.g() == null)) {
                break;
            }
        }
        return xVar;
    }

    public static void a(boolean z10) {
        Ka.f14563a = z10;
    }

    private static void a() {
        f14400c = false;
        f14401d = new LinkedList<>();
        f14402e = new LinkedList<>();
        f14403f = new LinkedList<>();
    }

    public static x[] a(byte[] bArr, E e10, boolean z10) {
        int i10;
        int i11;
        LinkedList linkedList = new LinkedList();
        a();
        int min = Math.min(e10.f14072a, e10.f14073b);
        float f10 = min;
        float max = Math.max(e10.f14072a, e10.f14073b) / f10;
        int i12 = (int) (f10 * 1.78f);
        m c10 = c(bArr, e10);
        E e11 = new E(e10);
        if (min > 500 && e10.f14072a >= e10.f14073b && e10.f14076e && max > 3.0f) {
            f14400c = true;
            e11.f14072a = i12;
            int i13 = e10.f14072a - 1;
            while (i13 >= 0) {
                i13 -= i12;
                int i14 = i13 >= 0 ? i13 : 0;
                e11.f14079h = i14;
                e11.f14080i = 0;
                a(c10, i14, 0, e11);
            }
            Collections.sort(f14401d);
            x a10 = a(c10, e11, linkedList, z10, true, i12);
            if (a10 != null) {
                return new x[]{a10};
            }
            f14401d = new LinkedList<>();
            Collections.sort(f14402e);
            HashSet hashSet = new HashSet();
            Iterator<p> it = f14402e.iterator();
            while (it.hasNext()) {
                p next = it.next();
                if (hashSet.add(Integer.valueOf(next.f14256b)) && (i11 = next.f14256b) >= i12 && i11 <= (e10.f14072a - 1) - i12) {
                    e11.f14072a = i12;
                    e11.f14081j = true;
                    int i15 = i11 - (i12 / 2);
                    e11.f14079h = i15;
                    e11.f14080i = 0;
                    a(c10, i15, 0, e11);
                }
            }
            Collections.sort(f14401d);
            x a11 = a(c10, e11, linkedList, z10, true, i12);
            if (a11 != null) {
                return new x[]{a11};
            }
        } else if (min <= 500 || !e10.f14076e || max <= 3.0f) {
            f14400c = false;
            if (z10) {
                return b(c10, e10);
            }
            return a(c10, e10);
        } else {
            f14400c = true;
            e11.f14073b = i12;
            int i16 = e10.f14073b - 1;
            while (i16 >= 0) {
                i16 -= i12;
                int i17 = i16 >= 0 ? i16 : 0;
                e11.f14079h = 0;
                e11.f14080i = i17;
                a(c10, 0, i17, e11);
            }
            Collections.sort(f14401d);
            x a12 = a(c10, e10, linkedList, z10, false, i12);
            if (a12 != null) {
                return new x[]{a12};
            }
            f14401d = new LinkedList<>();
            Collections.sort(f14403f);
            HashSet hashSet2 = new HashSet();
            Iterator<p> it2 = f14403f.iterator();
            while (it2.hasNext()) {
                p next2 = it2.next();
                if (hashSet2.add(Integer.valueOf(next2.f14256b)) && (i10 = next2.f14256b) >= i12 && i10 <= (e10.f14073b - 1) - i12) {
                    int i18 = i10 - (i12 / 2);
                    e11.f14073b = i12;
                    e11.f14081j = true;
                    e11.f14079h = 0;
                    e11.f14080i = i18;
                    a(c10, 0, i18, e11);
                }
            }
            Collections.sort(f14401d);
            x a13 = a(c10, e10, linkedList, z10, false, i12);
            if (a13 != null) {
                return new x[]{a13};
            }
        }
        x[] xVarArr = new x[linkedList.size()];
        linkedList.toArray(xVarArr);
        return xVarArr;
    }

    private static void a(m mVar, int i10, int i11, E e10) {
        Ka.a(e10);
        byte[] b10 = mVar.a(i10, i11, e10.f14072a, e10.f14073b).b();
        int i12 = e10.f14072a;
        int i13 = e10.f14073b;
        List<C0634v> a10 = new l(new r(b10, i12, i13, 0, 0, i12, i13, false)).a(0, Ka.f14574l);
        if (!e10.f14081j) {
            a(a10, e10);
        }
        for (C0634v vVar : a10) {
            vVar.a(e10.f14079h, e10.f14080i);
            f14401d.offer(vVar);
        }
    }

    private static x a(m mVar, E e10, LinkedList<x> linkedList, boolean z10, boolean z11, int i10) {
        l lVar = new l(mVar);
        List<List<BarcodeFormat>> a10 = Ja.a(e10.f14074c);
        if (z10) {
            x b10 = b(f14401d, lVar, a10);
            if (b10 == null || b10.g() == null) {
                return null;
            }
            return b10;
        }
        for (x xVar : a(f14401d, lVar, a10)) {
            linkedList.offer(xVar);
        }
        return null;
    }

    private static void a(List<C0634v> list, E e10) {
        for (C0634v vVar : list) {
            if (vVar.d() < e10.f14072a * 0.1f) {
                f14402e.offer(new p(vVar, e10.f14079h));
            } else {
                float d10 = vVar.d() + vVar.f();
                int i10 = e10.f14072a;
                if (d10 > i10 * 0.9f) {
                    f14402e.offer(new p(vVar, e10.f14079h + i10));
                }
            }
            if (vVar.e() < e10.f14073b * 0.1f) {
                f14403f.offer(new p(vVar, e10.f14080i));
            } else {
                float e11 = vVar.e() + vVar.c();
                int i11 = e10.f14073b;
                if (e11 > i11 * 0.9f) {
                    f14403f.offer(new p(vVar, e10.f14080i + i11));
                }
            }
        }
    }
}
