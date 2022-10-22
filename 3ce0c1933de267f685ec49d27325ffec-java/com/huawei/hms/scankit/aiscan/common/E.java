package com.huawei.hms.scankit.aiscan.common;

import java.util.List;
/* compiled from: Util.java */
/* loaded from: classes2.dex */
public class E {
    public static List<x> a(List<x> list) {
        x xVar;
        x xVar2;
        for (int i10 = 0; i10 < list.size() - 1; i10++) {
            for (int size = list.size() - 1; size > i10; size--) {
                if (list.get(i10).g().equals(list.get(size).g()) && a(xVar.f(), xVar2.f()) > 0.5d) {
                    list.remove(size);
                }
            }
        }
        return list;
    }

    public static float a(z[] zVarArr, z[] zVarArr2) {
        float f10 = Float.MAX_VALUE;
        float f11 = Float.MIN_VALUE;
        float f12 = Float.MAX_VALUE;
        float f13 = Float.MAX_VALUE;
        float f14 = Float.MIN_VALUE;
        float f15 = Float.MIN_VALUE;
        for (z zVar : zVarArr) {
            if (zVar.b() > f14) {
                f14 = zVar.b();
            }
            if (zVar.b() < f12) {
                f12 = zVar.b();
            }
            if (zVar.c() > f15) {
                f15 = zVar.c();
            }
            if (zVar.c() < f13) {
                f13 = zVar.c();
            }
        }
        float f16 = Float.MAX_VALUE;
        float f17 = Float.MIN_VALUE;
        for (z zVar2 : zVarArr2) {
            if (zVar2.b() > f11) {
                f11 = zVar2.b();
            }
            if (zVar2.b() < f10) {
                f10 = zVar2.b();
            }
            if (zVar2.c() > f17) {
                f17 = zVar2.c();
            }
            if (zVar2.c() < f16) {
                f16 = zVar2.c();
            }
        }
        float f18 = (f11 < f14 ? f11 : f14) - (f10 > f12 ? f10 : f12);
        float f19 = (f17 < f15 ? f17 : f15) - (f16 > f13 ? f16 : f13);
        if (f18 < 0.0f) {
            f18 = 0.0f;
        }
        if (f19 < 0.0f) {
            f19 = 0.0f;
        }
        float f20 = f18 * f19;
        return f20 / ((((f14 - f12) * (f15 - f13)) + ((f11 - f10) * (f17 - f16))) - f20);
    }
}
