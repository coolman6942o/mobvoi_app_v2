package com.huawei.hms.scankit.aiscan.common;

import com.huawei.hms.scankit.p.C0587g;
import com.huawei.hms.scankit.p.Ka;
import com.huawei.hms.scankit.util.LoadOpencvJNIUtil;
import java.util.Collection;
import java.util.Map;
import java.util.Vector;
/* compiled from: TwoDimDecoder.java */
/* loaded from: classes2.dex */
public class D {
    public static byte[] a(C0587g gVar, Map<EnumC0553d, Object> map, x xVar, int[] iArr, double[] dArr) throws C0550a {
        Collection collection = null;
        if (gVar == null) {
            return null;
        }
        if (map != null) {
            collection = (Collection) map.get(EnumC0553d.POSSIBLE_FORMATS);
        }
        if (!(collection == null || collection.contains(BarcodeFormat.QR_CODE) || collection.contains(BarcodeFormat.PDF_417)) || xVar == null || xVar.g() != null) {
            iArr[0] = gVar.e();
            iArr[1] = gVar.c();
            return gVar.d();
        }
        if (collection != null) {
            collection.clear();
            EnumC0553d dVar = EnumC0553d.POSSIBLE_FORMATS;
            map.remove(dVar);
            collection.add(xVar.b());
            map.put(dVar, collection);
        } else if (map != null) {
            EnumC0553d dVar2 = EnumC0553d.POSSIBLE_FORMATS;
            map.remove(dVar2);
            Vector vector = new Vector();
            vector.add(xVar.b());
            map.put(dVar2, vector);
        }
        float f10 = 3.0f / Ka.f14567e;
        if (f10 < 1.0f) {
            f10 = 1.0f;
        }
        dArr[5] = f10;
        return a(gVar, xVar.f(), dArr, iArr);
    }

    private static byte[] a(C0587g gVar, z[] zVarArr, double[] dArr, int[] iArr) throws C0550a {
        if (zVarArr == null) {
            iArr[0] = gVar.e();
            iArr[1] = gVar.c();
            return gVar.d();
        }
        int e10 = gVar.e();
        int i10 = e10;
        int c10 = gVar.c();
        int i11 = 0;
        int i12 = 0;
        for (z zVar : zVarArr) {
            if (zVar != null) {
                if (((int) zVar.b()) < i10) {
                    i10 = (int) zVar.b();
                }
                if (((int) zVar.c()) < c10) {
                    c10 = (int) zVar.c();
                }
                if (((int) zVar.b()) > i11) {
                    i11 = (int) zVar.b();
                }
                if (((int) zVar.c()) > i12) {
                    i12 = (int) zVar.c();
                }
            }
        }
        return a(zVarArr, gVar, iArr, Math.max(i11 - i10, i12 - c10), dArr);
    }

    private static byte[] a(z[] zVarArr, C0587g gVar, int[] iArr, float f10, double[] dArr) throws C0550a {
        float b10 = zVarArr[0].b();
        float b11 = zVarArr[1].b();
        float b12 = zVarArr[2].b();
        float c10 = zVarArr[0].c();
        float c11 = zVarArr[1].c();
        float c12 = zVarArr[2].c();
        if (b10 < 0.0f || b11 < 0.0f || b12 < 0.0f || c10 < 0.0f || c11 < 0.0f || c12 < 0.0f || b10 > gVar.e() || b11 > gVar.e() || b12 > gVar.e() || c10 > gVar.c() || c11 > gVar.c() || c12 > gVar.c()) {
            iArr[0] = gVar.e();
            iArr[1] = gVar.c();
            throw C0550a.a();
        }
        int i10 = ((int) (c10 + c12)) / 2;
        int i11 = (int) ((((int) (b10 + b12)) / 2) - f10);
        if (i11 < 0) {
            i11 = 0;
        }
        int i12 = (int) (i10 - f10);
        if (i12 < 0) {
            i12 = 0;
        }
        int i13 = ((int) f10) * 2;
        int e10 = i11 + i13 <= gVar.e() ? i13 : gVar.e() - i11;
        if (i12 + i13 > gVar.c()) {
            i13 = gVar.c() - i12;
        }
        C0587g a10 = gVar.a(i11, i12, e10, i13);
        dArr[0] = dArr[0] + Math.toDegrees(a(zVarArr[0], zVarArr[1])) + 90.0d;
        dArr[1] = i11;
        dArr[2] = i12;
        double d10 = e10;
        dArr[3] = d10;
        double d11 = i13;
        dArr[4] = d11;
        double radians = Math.toRadians(dArr[0]);
        int abs = (int) (((Math.abs(Math.sin(radians)) * d10) + (Math.abs(Math.cos(radians)) * d11)) * dArr[5]);
        int abs2 = (int) (((d11 * Math.abs(Math.sin(radians))) + (d10 * Math.abs(Math.cos(radians)))) * dArr[5]);
        iArr[0] = abs2;
        iArr[1] = abs;
        byte[] imageRotate = LoadOpencvJNIUtil.imageRotate(a10.d(), a10.c(), a10.e(), abs, abs2, (float) dArr[0], dArr[5]);
        if (imageRotate != null) {
            return imageRotate;
        }
        iArr[0] = gVar.e();
        iArr[1] = gVar.c();
        return gVar.d();
    }

    public static double a(z zVar, z zVar2) {
        return Math.atan2(zVar2.c() - zVar.c(), zVar2.b() - zVar.b());
    }

    public static z[] a(z[] zVarArr, int i10, int i11, double[] dArr) {
        z zVar;
        double d10;
        z[] zVarArr2;
        z zVar2;
        z[] zVarArr3 = zVarArr;
        z zVar3 = null;
        if (zVarArr3 == null) {
            return null;
        }
        int i12 = dArr[3] != 0.0d ? (int) dArr[3] : i10;
        int i13 = dArr[4] != 0.0d ? (int) dArr[4] : i11;
        double d11 = dArr[5];
        z[] zVarArr4 = new z[zVarArr3.length];
        int i14 = 0;
        double radians = Math.toRadians(dArr[0]);
        double cos = Math.cos(radians) * d11;
        double sin = Math.sin(radians) * d11;
        double d12 = i13;
        double d13 = i12;
        double abs = (((Math.abs(sin) - sin) * d12) + ((Math.abs(cos) - cos) * d13)) / 2.0d;
        double d14 = -sin;
        double abs2 = ((d12 * (Math.abs(cos) - cos)) + (d13 * (Math.abs(sin) + sin))) / 2.0d;
        while (i14 < zVarArr3.length) {
            if (zVarArr3[i14] != null) {
                zVarArr2 = zVarArr4;
                double b10 = (((zVar.b() - abs) * cos) + ((abs2 - zVar.c()) * sin)) / ((cos * cos) - (sin * d14));
                d10 = d14;
                zVarArr2[i14] = new z((float) (Math.round(b10) + ((int) dArr[1])), (float) (Math.round(sin == 0.0d ? (zVar.c() - abs2) / cos : ((zVar.b() - abs) - (cos * b10)) / sin) + ((int) dArr[2])));
                zVar2 = null;
            } else {
                zVar2 = zVar3;
                zVarArr2 = zVarArr4;
                d10 = d14;
                zVarArr2[i14] = zVar2;
            }
            i14++;
            d14 = d10;
            zVar3 = zVar2;
            zVarArr4 = zVarArr2;
            zVarArr3 = zVarArr;
        }
        return zVarArr4;
    }
}
