package com.huawei.hms.scankit.aiscan.common;

import com.huawei.hms.scankit.p.C0567b;
import com.huawei.hms.scankit.p.C0584fa;
import com.huawei.hms.scankit.p.C0587g;
import com.huawei.hms.scankit.p.C0605l;
import com.huawei.hms.scankit.p.C0614o;
import com.huawei.hms.scankit.p.C0634v;
import com.huawei.hms.scankit.p.C0637w;
import com.huawei.hms.scankit.p.F;
import com.huawei.hms.scankit.p.Ha;
import com.huawei.hms.scankit.p.Ka;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
/* compiled from: MultiFormatReader.java */
/* loaded from: classes2.dex */
public final class o implements t {
    public static boolean a(x xVar, float f10, float f11) {
        double abs = Math.abs(xVar.f()[0].b() - xVar.f()[1].b()) / f10;
        return (abs < 0.55d && ((double) f11) > 1.5d) || abs < 0.3d;
    }

    @Override // com.huawei.hms.scankit.aiscan.common.t
    public x a(C0587g gVar, Map<EnumC0553d, ?> map) throws C0550a {
        return a(gVar, a(map), map);
    }

    public t[] a(Map<EnumC0553d, ?> map) {
        Collection collection = map == null ? null : (Collection) map.get(EnumC0553d.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(BarcodeFormat.UPC_A) || collection.contains(BarcodeFormat.UPC_E) || collection.contains(BarcodeFormat.EAN_13) || collection.contains(BarcodeFormat.EAN_8) || collection.contains(BarcodeFormat.CODABAR) || collection.contains(BarcodeFormat.CODE_39) || collection.contains(BarcodeFormat.CODE_93) || collection.contains(BarcodeFormat.CODE_128) || collection.contains(BarcodeFormat.ITF)) {
                arrayList.add(new F(map));
            }
            if (collection.contains(BarcodeFormat.QR_CODE)) {
                arrayList.add(new Ha());
            }
            if (collection.contains(BarcodeFormat.DATA_MATRIX)) {
                arrayList.add(new C0614o());
            }
            if (collection.contains(BarcodeFormat.AZTEC)) {
                arrayList.add(new C0567b());
            }
            if (collection.contains(BarcodeFormat.PDF_417)) {
                arrayList.add(new C0584fa());
            }
        }
        return (t[]) arrayList.toArray(new t[arrayList.size()]);
    }

    private x a(C0587g gVar, t[] tVarArr, Map<EnumC0553d, ?> map) throws C0550a {
        if (tVarArr != null) {
            for (t tVar : tVarArr) {
                try {
                    x a10 = tVar.a(gVar, map);
                    if (!(a10 == null || a10.f() == null)) {
                        int i10 = 0;
                        for (z zVar : a10.f()) {
                            if (zVar != null) {
                                i10++;
                            }
                        }
                        if (i10 == 0 && a10.b() == BarcodeFormat.PDF_417) {
                            throw C0550a.a();
                            break;
                        }
                    }
                    return a10;
                } catch (C0550a unused) {
                }
            }
        }
        throw C0550a.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public x a(C0587g gVar, C0587g gVar2, Map<EnumC0553d, Object> map, l lVar, C0634v vVar) throws C0550a {
        boolean z10;
        x xVar;
        z[] f10;
        boolean containsKey = map.containsKey(EnumC0553d.PHOTO_MODE);
        float[] fArr = {1.0f, 0.0f};
        if (gVar2 != null) {
            xVar = a(gVar2, lVar, map, fArr, vVar);
        } else if (containsKey || !Ka.f14563a) {
            xVar = a(gVar, lVar, map, fArr);
            if (fArr[1] > 1.0f) {
                z10 = true;
                if (xVar == null) {
                    if (z10 && (f10 = xVar.f()) != null) {
                        for (int i10 = 0; i10 < f10.length; i10++) {
                            if (f10[i10] != null) {
                                f10[i10] = new z(f10[i10].c(), (gVar.c() - 1) - f10[i10].b());
                            }
                        }
                    }
                    return xVar;
                }
                throw C0550a.a();
            }
        } else {
            xVar = null;
        }
        z10 = false;
        if (xVar == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private x a(C0587g gVar, l lVar, Map<EnumC0553d, Object> map, float[] fArr, C0634v vVar) throws C0550a {
        x xVar;
        x xVar2;
        float n10 = vVar.n();
        float e10 = gVar.e() < gVar.c() ? gVar.e() : gVar.c();
        float f10 = e10 / 500.0f;
        float f11 = 1.0f;
        if (f10 < 1.0f) {
            f10 = 1.0f;
        }
        C0587g g10 = lVar.g(gVar, f10);
        t[] a10 = a(map);
        float b10 = vVar.a() > 0.0f ? vVar.b() / vVar.a() : 1.0f;
        x xVar3 = null;
        try {
            xVar2 = a(g10, a10, map);
        } catch (C0550a unused) {
        }
        try {
            if (a(xVar2, n10 / f10, b10)) {
                throw C0550a.a();
            }
        } catch (C0550a unused2) {
            xVar3 = xVar2;
            if (Ka.f14573k) {
                float f12 = e10 / 250.0f;
                if (f12 >= 1.0f) {
                    f11 = f12;
                }
                g10 = lVar.f(gVar, f11);
                try {
                    map.put(EnumC0553d.PHOTO_MODE_NUM, 2);
                    xVar = a(lVar.e(g10), a10, map);
                } catch (C0550a unused3) {
                    map.put(EnumC0553d.PHOTO_MODE_NUM, 1);
                    xVar = a(lVar.f(g10), a10, map);
                    if (a(xVar, n10 / f11, b10)) {
                        throw C0550a.a();
                    }
                }
                if (!a(xVar, n10 / f11, b10)) {
                    f10 = f11;
                    fArr[0] = f10;
                    if (xVar != null) {
                    }
                    return xVar;
                }
                throw C0550a.a();
            } else {
                xVar2 = xVar3;
                xVar = xVar2;
                fArr[0] = f10;
                if (xVar != null) {
                }
                return xVar;
            }
        }
        xVar = xVar2;
        fArr[0] = f10;
        if (xVar != null) {
            C0637w.a(g10.b(), xVar, f10, vVar);
        }
        return xVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x007f, code lost:
        r10 = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private x a(C0587g gVar, l lVar, Map<EnumC0553d, Object> map, float[] fArr) throws C0550a {
        C0587g gVar2;
        x xVar;
        float f10 = 1.0f;
        float min = (Math.min(gVar.c(), gVar.e()) * 1.0f) / 1080.0f;
        if (Ka.f14563a) {
            gVar2 = lVar.a(gVar, min);
        } else {
            if (min > 1.5f) {
                f10 = min;
            }
            gVar2 = lVar.a(gVar, f10);
            min = f10;
        }
        t[] a10 = a(map);
        if (Ka.f14564b || !Ka.f14563a) {
            x xVar2 = null;
            int i10 = 0;
            while (true) {
                if (i10 >= 2) {
                    break;
                } else if (i10 == 1) {
                    xVar2 = a(lVar.c(k.a(gVar2)), a10, map);
                    fArr[1] = 2.0f;
                    break;
                } else {
                    try {
                        try {
                            xVar = a(lVar.b(gVar2), a10, map);
                            break;
                        } catch (C0550a unused) {
                            if (Ka.f14573k) {
                                map.put(EnumC0553d.PHOTO_MODE_NUM, 1);
                                xVar = a(lVar.d(gVar2), a10, map);
                                break;
                            }
                        }
                    } catch (C0550a unused2) {
                    }
                }
                i10++;
            }
        } else {
            map.put(EnumC0553d.PHOTO_MODE_NUM, 0);
            xVar = a(gVar2, a10, map);
        }
        if (xVar != null) {
            C0637w.a(gVar2.b(), xVar, min, (C0634v) null);
        }
        fArr[0] = min;
        return xVar;
    }

    public x a(C0587g gVar, C0587g gVar2, C0587g gVar3, Map<EnumC0553d, ?> map, l lVar, C0634v vVar) throws C0550a {
        if (gVar3 != null) {
            return a(gVar3, lVar, map, vVar);
        }
        return a(gVar, gVar2, lVar, map);
    }

    public x a(C0587g gVar, l lVar, Map<EnumC0553d, ?> map, C0634v vVar) throws C0550a {
        int e10 = gVar.e();
        int c10 = gVar.c();
        int i10 = e10 < c10 ? e10 : c10;
        float f10 = 1.0f;
        float f11 = i10 * 1.0f;
        float f12 = f11 / 128.0f;
        if (f12 < 1.0f && Ka.f14565c) {
            gVar = lVar.e(gVar, f12);
        }
        C0587g gVar2 = gVar;
        float f13 = f11 / 500.0f;
        if (f13 >= 1.0f) {
            f10 = f13;
        }
        try {
            x a10 = a(lVar.g(gVar2, f10), a(map), map);
            if (a10 == null || a10.g() == null) {
                if (!Ka.f14565c && a10 != null && a10.g() == null && a10.f().length >= 3) {
                    z[] zVarArr = (z[]) a10.f().clone();
                }
                throw C0550a.a();
            }
            C0637w.a(a10.f(), f10, vVar);
            return a10;
        } catch (C0550a unused) {
            x a11 = a(i10, gVar2, lVar, map, vVar);
            if (a11 != null) {
                if (0 != 0) {
                    a11.a();
                    a11.b(null);
                    C0637w.a(a11.f(), f10, vVar);
                }
                return a11;
            }
            throw C0550a.a();
        }
    }

    private x a(int i10, C0587g gVar, l lVar, Map<EnumC0553d, ?> map, C0634v vVar) throws C0550a {
        float f10 = (i10 * 1.0f) / 250.0f;
        if (f10 < 1.0f) {
            f10 = 1.0f;
        }
        C0587g f11 = lVar.f(gVar, f10);
        t[] a10 = a(map);
        try {
            try {
                x a11 = a(lVar.e(f11), a10, map);
                if (a11 == null || a11.g() == null) {
                    throw C0550a.a();
                }
                C0637w.a(a11.f(), f10, vVar);
                return a11;
            } catch (C0550a unused) {
                x a12 = a(lVar.f(f11), a10, map);
                if (a12 == null || a12.g() == null) {
                    throw C0550a.a();
                }
                C0637w.a(a12.f(), f10, vVar);
                return a12;
            }
        } catch (C0550a unused2) {
            x a13 = a(new C0587g(new C0605l(gVar.a().c())), a10, map);
            if (!(a13 == null || a13.g() == null)) {
                C0637w.a(a13.f(), 1.0f, vVar);
            }
            return a13;
        }
    }

    public x a(C0587g gVar, C0587g gVar2, l lVar, Map<EnumC0553d, ?> map) throws C0550a {
        C0587g gVar3;
        int e10 = gVar.e();
        int c10 = gVar.c();
        int i10 = e10 < c10 ? e10 : c10;
        float f10 = 1.0f;
        float f11 = (i10 * 1.0f) / 1080.0f;
        if (f11 <= 1.0f) {
            f11 = 1.0f;
        }
        if (Ka.f14563a) {
            gVar3 = lVar.a(gVar, f11);
        } else {
            if (f11 > 1.5f) {
                f10 = f11;
            }
            f11 = f10;
            gVar3 = lVar.a(gVar, f10);
        }
        try {
            x a10 = a(gVar3, a(map), map);
            if (a10 == null || a10.g() == null) {
                if (!Ka.f14565c && a10 != null && a10.g() == null && a10.f().length >= 3) {
                    z[] zVarArr = (z[]) a10.f().clone();
                }
                throw C0550a.a();
            }
            C0637w.a(a10.f(), f11, (C0634v) null);
            return a10;
        } catch (C0550a unused) {
            x a11 = a(i10, lVar, gVar, gVar2, map);
            if (a11 != null) {
                if (0 != 0) {
                    a11.a();
                    a11.b(null);
                }
                return a11;
            }
            throw C0550a.a();
        }
    }

    private x a(int i10, l lVar, C0587g gVar, C0587g gVar2, Map<EnumC0553d, ?> map) throws C0550a {
        t[] a10 = a(map);
        float f10 = 1.0f;
        try {
            if (Ka.f14563a) {
                float f11 = (i10 * 1.0f) / 500.0f;
                if (f11 <= 1.0f) {
                    f11 = 1.0f;
                }
                x a11 = a(lVar.g(lVar.g(gVar, f11)), a10, map);
                if (!(a11 == null || a11.g() == null)) {
                    C0637w.a(a11.f(), f11, (C0634v) null);
                    return a11;
                }
            }
            throw C0550a.a();
        } catch (C0550a unused) {
            float f12 = (i10 * 1.0f) / 1080.0f;
            if (f12 > 1.0f) {
                f10 = f12;
            }
            x a12 = a(lVar.b(gVar2, f10), a10, map);
            if (!(a12 == null || a12.g() == null)) {
                C0637w.a(a12.f(), f10, (C0634v) null);
            }
            return a12;
        }
    }
}
