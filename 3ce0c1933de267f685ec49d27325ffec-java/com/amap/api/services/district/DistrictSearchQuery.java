package com.amap.api.services.district;

import android.os.Parcel;
import android.os.Parcelable;
import n4.o;
/* loaded from: classes.dex */
public class DistrictSearchQuery implements Parcelable, Cloneable {
    public static final Parcelable.Creator<DistrictSearchQuery> CREATOR = new a();

    /* renamed from: c  reason: collision with root package name */
    private String f7330c;

    /* renamed from: d  reason: collision with root package name */
    private String f7331d;

    /* renamed from: a  reason: collision with root package name */
    private int f7328a = 1;

    /* renamed from: b  reason: collision with root package name */
    private int f7329b = 20;

    /* renamed from: e  reason: collision with root package name */
    private boolean f7332e = true;

    /* renamed from: f  reason: collision with root package name */
    private boolean f7333f = false;

    /* renamed from: g  reason: collision with root package name */
    private boolean f7334g = false;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<DistrictSearchQuery> {
        a() {
        }

        /* renamed from: a */
        public DistrictSearchQuery createFromParcel(Parcel parcel) {
            DistrictSearchQuery districtSearchQuery = new DistrictSearchQuery();
            districtSearchQuery.b(parcel.readString());
            districtSearchQuery.c(parcel.readString());
            districtSearchQuery.d(parcel.readInt());
            districtSearchQuery.e(parcel.readInt());
            boolean z10 = false;
            districtSearchQuery.i(parcel.readByte() == 1);
            districtSearchQuery.f(parcel.readByte() == 1);
            if (parcel.readByte() == 1) {
                z10 = true;
            }
            districtSearchQuery.g(z10);
            return districtSearchQuery;
        }

        /* renamed from: b */
        public DistrictSearchQuery[] newArray(int i10) {
            return new DistrictSearchQuery[i10];
        }
    }

    /* renamed from: a */
    public DistrictSearchQuery clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e10) {
            o.b(e10, "DistrictSearchQuery", "clone");
        }
        DistrictSearchQuery districtSearchQuery = new DistrictSearchQuery();
        districtSearchQuery.b(this.f7330c);
        districtSearchQuery.c(this.f7331d);
        districtSearchQuery.d(this.f7328a);
        districtSearchQuery.e(this.f7329b);
        districtSearchQuery.i(this.f7332e);
        districtSearchQuery.f(this.f7334g);
        districtSearchQuery.g(this.f7333f);
        return districtSearchQuery;
    }

    public void b(String str) {
        this.f7330c = str;
    }

    public void c(String str) {
        this.f7331d = str;
    }

    public void d(int i10) {
        this.f7328a = i10;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void e(int i10) {
        this.f7329b = i10;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DistrictSearchQuery districtSearchQuery = (DistrictSearchQuery) obj;
        if (this.f7334g != districtSearchQuery.f7334g) {
            return false;
        }
        String str = this.f7330c;
        if (str == null) {
            if (districtSearchQuery.f7330c != null) {
                return false;
            }
        } else if (!str.equals(districtSearchQuery.f7330c)) {
            return false;
        }
        return this.f7328a == districtSearchQuery.f7328a && this.f7329b == districtSearchQuery.f7329b && this.f7332e == districtSearchQuery.f7332e;
    }

    public void f(boolean z10) {
        this.f7334g = z10;
    }

    public void g(boolean z10) {
        this.f7333f = z10;
    }

    public int hashCode() {
        int i10 = 1231;
        int i11 = ((this.f7334g ? 1231 : 1237) + 31) * 31;
        String str = this.f7330c;
        int i12 = 0;
        int hashCode = (i11 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f7331d;
        if (str2 != null) {
            i12 = str2.hashCode();
        }
        int i13 = (((((hashCode + i12) * 31) + this.f7328a) * 31) + this.f7329b) * 31;
        if (!this.f7332e) {
            i10 = 1237;
        }
        return i13 + i10;
    }

    public void i(boolean z10) {
        this.f7332e = z10;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f7330c);
        parcel.writeString(this.f7331d);
        parcel.writeInt(this.f7328a);
        parcel.writeInt(this.f7329b);
        parcel.writeByte(this.f7332e ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f7334g ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f7333f ? (byte) 1 : (byte) 0);
    }
}
