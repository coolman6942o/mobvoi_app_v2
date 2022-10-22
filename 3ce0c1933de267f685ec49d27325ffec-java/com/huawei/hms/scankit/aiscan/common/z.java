package com.huawei.hms.scankit.aiscan.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.scankit.p.Ka;
/* compiled from: ResultPoint.java */
/* loaded from: classes2.dex */
public class z implements Parcelable {
    public static final Parcelable.Creator<z> CREATOR = new y();

    /* renamed from: a  reason: collision with root package name */
    private final float f14304a;

    /* renamed from: b  reason: collision with root package name */
    private final float f14305b;

    /* renamed from: c  reason: collision with root package name */
    private int f14306c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f14307d;

    public z(float f10, float f11, int i10) {
        this.f14306c = 0;
        this.f14307d = false;
        this.f14304a = f10;
        this.f14305b = f11;
        this.f14306c = i10;
    }

    private static int[] a(float f10, float f11, float f12) {
        int i10;
        int i11;
        int i12;
        int i13 = (f10 > f11 ? 1 : (f10 == f11 ? 0 : -1));
        if (i13 < 0 || f10 < f12) {
            if (f12 < f10 || f12 < f11) {
                if (f10 > f10) {
                    i10 = 1;
                    i11 = 0;
                } else {
                    i11 = 1;
                    i10 = 0;
                }
                i12 = 2;
            } else {
                i12 = 1;
                if (i13 > 0) {
                    i11 = 0;
                    i10 = 2;
                } else {
                    i10 = 0;
                    i11 = 2;
                }
            }
        } else if (f11 > f12) {
            i10 = 1;
            i12 = 0;
            i11 = 2;
        } else {
            i11 = 1;
            i12 = 0;
            i10 = 2;
        }
        return new int[]{i12, i11, i10};
    }

    public int a() {
        return this.f14306c;
    }

    public final float b() {
        return this.f14304a;
    }

    public final float c() {
        return this.f14305b;
    }

    public boolean d() {
        return this.f14307d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        return ((double) Math.abs(this.f14304a - zVar.f14304a)) < 1.0E-4d && ((double) Math.abs(this.f14305b - zVar.f14305b)) < 1.0E-4d;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f14304a) * 31) + Float.floatToIntBits(this.f14305b);
    }

    public final String toString() {
        return "(" + this.f14304a + ',' + this.f14305b + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeFloat(this.f14304a);
        parcel.writeFloat(this.f14305b);
    }

    public static void a(z[] zVarArr) {
        float a10 = a(zVarArr[0], zVarArr[1]);
        float a11 = a(zVarArr[1], zVarArr[2]);
        float a12 = a(zVarArr[0], zVarArr[2]);
        int[] a13 = a(a11, a10, a12);
        int i10 = a13[0];
        int i11 = a13[1];
        int i12 = a13[2];
        z zVar = zVarArr[i10];
        z zVar2 = zVarArr[i11];
        z zVar3 = zVarArr[i12];
        float[] fArr = {a11, a12, a10};
        if (Ka.f14568f % 2 == 0 && fArr[i11] / fArr[i10] < 1.1d) {
            zVar = zVarArr[i10];
            zVar2 = zVarArr[i11];
            zVar3 = zVarArr[i12];
        }
        if (a(zVar2, zVar, zVar3) < 0.0f) {
            zVar2 = zVar3;
            zVar3 = zVar2;
        }
        zVarArr[0] = zVar2;
        zVarArr[1] = zVar;
        zVarArr[2] = zVar3;
    }

    public z(float f10, float f11) {
        this.f14306c = 0;
        this.f14307d = false;
        this.f14304a = f10;
        this.f14305b = f11;
    }

    public z(float f10, float f11, boolean z10) {
        this.f14306c = 0;
        this.f14307d = false;
        this.f14304a = f10;
        this.f14305b = f11;
        this.f14307d = z10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public z(Parcel parcel) {
        this.f14306c = 0;
        this.f14307d = false;
        this.f14304a = parcel.readFloat();
        this.f14305b = parcel.readFloat();
    }

    public static float a(z zVar, z zVar2) {
        return n.a(zVar.f14304a, zVar.f14305b, zVar2.f14304a, zVar2.f14305b);
    }

    private static float a(z zVar, z zVar2, z zVar3) {
        float f10 = zVar2.f14304a;
        float f11 = zVar2.f14305b;
        return ((zVar3.f14304a - f10) * (zVar.f14305b - f11)) - ((zVar3.f14305b - f11) * (zVar.f14304a - f10));
    }
}
