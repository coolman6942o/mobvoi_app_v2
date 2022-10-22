package com.google.zxing;

import p8.a;
/* compiled from: ResultPoint.java */
/* loaded from: classes.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private final float f13452a;

    /* renamed from: b  reason: collision with root package name */
    private final float f13453b;

    public i(float f10, float f11) {
        this.f13452a = f10;
        this.f13453b = f11;
    }

    private static float a(i iVar, i iVar2, i iVar3) {
        float f10 = iVar2.f13452a;
        float f11 = iVar2.f13453b;
        return ((iVar3.f13452a - f10) * (iVar.f13453b - f11)) - ((iVar3.f13453b - f11) * (iVar.f13452a - f10));
    }

    public static float b(i iVar, i iVar2) {
        return a.a(iVar.f13452a, iVar.f13453b, iVar2.f13452a, iVar2.f13453b);
    }

    public static void e(i[] iVarArr) {
        i iVar;
        i iVar2;
        i iVar3;
        float b10 = b(iVarArr[0], iVarArr[1]);
        float b11 = b(iVarArr[1], iVarArr[2]);
        float b12 = b(iVarArr[0], iVarArr[2]);
        if (b11 >= b10 && b11 >= b12) {
            iVar3 = iVarArr[0];
            iVar2 = iVarArr[1];
            iVar = iVarArr[2];
        } else if (b12 < b11 || b12 < b10) {
            iVar3 = iVarArr[2];
            iVar2 = iVarArr[0];
            iVar = iVarArr[1];
        } else {
            iVar3 = iVarArr[1];
            iVar2 = iVarArr[0];
            iVar = iVarArr[2];
        }
        if (a(iVar2, iVar3, iVar) < 0.0f) {
            iVar2 = iVar;
            iVar = iVar2;
        }
        iVarArr[0] = iVar2;
        iVarArr[1] = iVar3;
        iVarArr[2] = iVar;
    }

    public final float c() {
        return this.f13452a;
    }

    public final float d() {
        return this.f13453b;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof i) {
            i iVar = (i) obj;
            if (this.f13452a == iVar.f13452a && this.f13453b == iVar.f13453b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f13452a) * 31) + Float.floatToIntBits(this.f13453b);
    }

    public final String toString() {
        return "(" + this.f13452a + ',' + this.f13453b + ')';
    }
}
