package com.realsil.sdk.core.bluetooth.scanner;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import com.realsil.sdk.core.bluetooth.scanner.compat.CompatScanFilter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class ScannerParams implements Parcelable {
    public static final Parcelable.Creator<ScannerParams> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public int f22121a;

    /* renamed from: b  reason: collision with root package name */
    public int f22122b;

    /* renamed from: c  reason: collision with root package name */
    public String f22123c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f22124d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f22125e;

    /* renamed from: f  reason: collision with root package name */
    public String f22126f;

    /* renamed from: g  reason: collision with root package name */
    public int f22127g;

    /* renamed from: h  reason: collision with root package name */
    public long f22128h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f22129i;

    /* renamed from: j  reason: collision with root package name */
    public long f22130j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f22131k;

    /* renamed from: l  reason: collision with root package name */
    public int f22132l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f22133m;

    /* renamed from: n  reason: collision with root package name */
    public int f22134n;

    /* renamed from: o  reason: collision with root package name */
    public ParcelUuid[] f22135o;

    /* renamed from: p  reason: collision with root package name */
    public List<CompatScanFilter> f22136p;

    /* loaded from: classes2.dex */
    public static class a implements Parcelable.Creator<ScannerParams> {
        @Override // android.os.Parcelable.Creator
        public ScannerParams createFromParcel(Parcel parcel) {
            return new ScannerParams(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ScannerParams[] newArray(int i10) {
            return new ScannerParams[i10];
        }
    }

    public ScannerParams() {
        this(0);
    }

    public ScannerParams(int i10) {
        this.f22121a = 0;
        this.f22122b = 0;
        this.f22124d = false;
        this.f22125e = true;
        this.f22127g = -1000;
        this.f22128h = 10000L;
        this.f22130j = 5000L;
        this.f22131k = true;
        this.f22132l = 255;
        this.f22133m = true;
        this.f22136p = new ArrayList();
        this.f22121a = i10;
        this.f22129i = false;
        this.f22122b = 0;
    }

    public ScannerParams(Parcel parcel) {
        boolean z10 = false;
        this.f22121a = 0;
        this.f22122b = 0;
        this.f22124d = false;
        this.f22125e = true;
        this.f22127g = -1000;
        this.f22128h = 10000L;
        this.f22130j = 5000L;
        this.f22131k = true;
        this.f22132l = 255;
        this.f22133m = true;
        this.f22136p = new ArrayList();
        this.f22121a = parcel.readInt();
        this.f22122b = parcel.readInt();
        this.f22123c = parcel.readString();
        this.f22124d = parcel.readByte() != 0;
        this.f22125e = parcel.readByte() != 0;
        this.f22126f = parcel.readString();
        this.f22127g = parcel.readInt();
        this.f22128h = parcel.readLong();
        this.f22129i = parcel.readByte() != 0;
        this.f22130j = parcel.readLong();
        this.f22131k = parcel.readByte() != 0;
        this.f22132l = parcel.readInt();
        this.f22133m = parcel.readByte() != 0 ? true : z10;
        this.f22134n = parcel.readInt();
        this.f22135o = (ParcelUuid[]) parcel.createTypedArray(ParcelUuid.CREATOR);
        this.f22136p = parcel.createTypedArrayList(CompatScanFilter.CREATOR);
    }

    public String a() {
        return this.f22126f;
    }

    public long b() {
        return this.f22130j;
    }

    public int c() {
        return this.f22134n;
    }

    public ParcelUuid[] d() {
        return this.f22135o;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f22123c;
    }

    public int f() {
        return this.f22132l;
    }

    public int g() {
        return this.f22127g;
    }

    public List<CompatScanFilter> h() {
        return this.f22136p;
    }

    public int i() {
        return this.f22122b;
    }

    public int j() {
        return this.f22121a;
    }

    public long k() {
        return this.f22128h;
    }

    public boolean l() {
        return this.f22129i;
    }

    public boolean m() {
        return this.f22133m;
    }

    public boolean o() {
        return this.f22124d;
    }

    public boolean p() {
        return this.f22125e;
    }

    public void r(String str) {
        this.f22126f = str;
    }

    public void s(List<CompatScanFilter> list) {
        this.f22136p = list;
    }

    public void t(long j10) {
        this.f22128h = j10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f22121a);
        parcel.writeInt(this.f22122b);
        parcel.writeString(this.f22123c);
        parcel.writeByte(this.f22124d ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f22125e ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f22126f);
        parcel.writeInt(this.f22127g);
        parcel.writeLong(this.f22128h);
        parcel.writeByte(this.f22129i ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.f22130j);
        parcel.writeByte(this.f22131k ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f22132l);
        parcel.writeByte(this.f22133m ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f22134n);
        parcel.writeTypedArray(this.f22135o, i10);
        parcel.writeTypedList(this.f22136p);
    }
}
