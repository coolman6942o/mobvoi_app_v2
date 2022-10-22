package com.huawei.hms.scankit.aiscan.common;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.scankit.p.C0634v;
import java.util.ArrayList;
import java.util.List;
/* compiled from: Result.java */
/* loaded from: classes2.dex */
public final class x implements Parcelable {
    public static final Parcelable.Creator<x> CREATOR = new w();

    /* renamed from: a  reason: collision with root package name */
    private final String f14293a;

    /* renamed from: b  reason: collision with root package name */
    private final byte[] f14294b;

    /* renamed from: c  reason: collision with root package name */
    private final int f14295c;

    /* renamed from: d  reason: collision with root package name */
    private z[] f14296d;

    /* renamed from: e  reason: collision with root package name */
    private BarcodeFormat f14297e;

    /* renamed from: f  reason: collision with root package name */
    private final long f14298f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f14299g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f14300h;

    /* renamed from: i  reason: collision with root package name */
    private final float f14301i;

    /* renamed from: j  reason: collision with root package name */
    private int f14302j;

    /* renamed from: k  reason: collision with root package name */
    private List<Rect> f14303k;

    public x(float f10) {
        this.f14299g = false;
        this.f14301i = f10;
        this.f14293a = null;
        this.f14294b = new byte[0];
        this.f14295c = 0;
        this.f14296d = new z[0];
        this.f14297e = BarcodeFormat.NONE;
        this.f14298f = 0L;
        this.f14300h = false;
        this.f14302j = 0;
        this.f14303k = new ArrayList();
    }

    public void a(boolean z10) {
        this.f14299g = z10;
    }

    public BarcodeFormat b() {
        return this.f14297e;
    }

    public List<Rect> c() {
        return this.f14303k;
    }

    public int d() {
        return this.f14302j;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public byte[] e() {
        return this.f14294b;
    }

    public z[] f() {
        return this.f14296d;
    }

    public String g() {
        return this.f14293a;
    }

    public float h() {
        return this.f14301i;
    }

    public String toString() {
        return this.f14293a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f14293a);
        parcel.writeByteArray(this.f14294b);
        parcel.writeInt(this.f14295c);
        parcel.writeTypedArray(this.f14296d, i10);
        parcel.writeParcelable(this.f14297e, i10);
        parcel.writeLong(this.f14298f);
        parcel.writeInt(this.f14299g ? 1 : 0);
        parcel.writeInt(this.f14300h ? 1 : 0);
        parcel.writeFloat(this.f14301i);
        parcel.writeInt(this.f14302j);
        parcel.writeList(this.f14303k);
    }

    public void a(float f10) {
        if (f10 < 50.0f) {
            this.f14302j = 2;
        } else if (f10 < 90.0f) {
            this.f14302j = 1;
        } else if (f10 < 140.0f) {
            this.f14302j = 0;
        } else if (f10 < 190.0f) {
            this.f14302j = -1;
        } else if (f10 <= 255.0f) {
            this.f14302j = -2;
        }
    }

    public void b(z[] zVarArr) {
        this.f14296d = zVarArr;
    }

    public void a(C0634v vVar) {
        int d10 = (int) vVar.d();
        int e10 = (int) vVar.e();
        this.f14303k.add(new Rect(d10, e10, ((int) vVar.f()) + d10, ((int) vVar.c()) + e10));
    }

    public void a(z[] zVarArr) {
        z[] zVarArr2 = this.f14296d;
        if (zVarArr2 == null) {
            this.f14296d = zVarArr;
        } else if (zVarArr != null && zVarArr.length > 0) {
            z[] zVarArr3 = new z[zVarArr2.length + zVarArr.length];
            System.arraycopy(zVarArr2, 0, zVarArr3, 0, zVarArr2.length);
            System.arraycopy(zVarArr, 0, zVarArr3, zVarArr2.length, zVarArr.length);
            this.f14296d = zVarArr3;
        }
    }

    public x(String str, byte[] bArr, z[] zVarArr, BarcodeFormat barcodeFormat) {
        this(str, bArr, zVarArr, barcodeFormat, System.currentTimeMillis());
    }

    public x(String str, byte[] bArr, z[] zVarArr, BarcodeFormat barcodeFormat, long j10) {
        this(str, bArr, bArr == null ? 0 : bArr.length * 8, zVarArr, barcodeFormat, j10);
    }

    public x(String str, byte[] bArr, int i10, z[] zVarArr, BarcodeFormat barcodeFormat, long j10) {
        this.f14299g = false;
        this.f14293a = str;
        this.f14294b = bArr;
        this.f14295c = i10;
        this.f14296d = zVarArr;
        this.f14297e = barcodeFormat;
        this.f14298f = j10;
        this.f14301i = 1.0f;
        this.f14300h = false;
    }

    public void a() {
        this.f14296d = new z[0];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public x(Parcel parcel) {
        boolean z10 = false;
        this.f14299g = false;
        this.f14293a = parcel.readString();
        this.f14294b = parcel.createByteArray();
        this.f14295c = parcel.readInt();
        this.f14296d = (z[]) parcel.createTypedArray(z.CREATOR);
        this.f14297e = (BarcodeFormat) parcel.readParcelable(x.class.getClassLoader());
        this.f14298f = parcel.readLong();
        this.f14299g = parcel.readInt() == 1;
        this.f14300h = parcel.readInt() == 1 ? true : z10;
        this.f14301i = parcel.readFloat();
        this.f14302j = parcel.readInt();
        if (this.f14303k == null) {
            this.f14303k = new ArrayList();
        }
        parcel.readList(this.f14303k, x.class.getClassLoader());
    }
}
