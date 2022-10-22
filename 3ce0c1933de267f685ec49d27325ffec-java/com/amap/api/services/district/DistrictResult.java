package com.amap.api.services.district;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public final class DistrictResult implements Parcelable {

    /* renamed from: a  reason: collision with root package name */
    private DistrictSearchQuery f7326a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<DistrictItem> f7327b;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator<DistrictResult> {
        a(DistrictResult districtResult) {
        }

        /* renamed from: a */
        public DistrictResult createFromParcel(Parcel parcel) {
            return new DistrictResult(parcel);
        }

        /* renamed from: b */
        public DistrictResult[] newArray(int i10) {
            return new DistrictResult[i10];
        }
    }

    public DistrictResult() {
        this.f7327b = new ArrayList<>();
        new a(this);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DistrictResult.class != obj.getClass()) {
            return false;
        }
        DistrictResult districtResult = (DistrictResult) obj;
        DistrictSearchQuery districtSearchQuery = this.f7326a;
        if (districtSearchQuery == null) {
            if (districtResult.f7326a != null) {
                return false;
            }
        } else if (!districtSearchQuery.equals(districtResult.f7326a)) {
            return false;
        }
        ArrayList<DistrictItem> arrayList = this.f7327b;
        if (arrayList == null) {
            if (districtResult.f7327b != null) {
                return false;
            }
        } else if (!arrayList.equals(districtResult.f7327b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        DistrictSearchQuery districtSearchQuery = this.f7326a;
        int i10 = 0;
        int hashCode = ((districtSearchQuery == null ? 0 : districtSearchQuery.hashCode()) + 31) * 31;
        ArrayList<DistrictItem> arrayList = this.f7327b;
        if (arrayList != null) {
            i10 = arrayList.hashCode();
        }
        return hashCode + i10;
    }

    public String toString() {
        return "DistrictResult [mDisQuery=" + this.f7326a + ", mDistricts=" + this.f7327b + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.f7326a, i10);
        parcel.writeTypedList(this.f7327b);
    }

    protected DistrictResult(Parcel parcel) {
        this.f7327b = new ArrayList<>();
        new a(this);
        this.f7326a = (DistrictSearchQuery) parcel.readParcelable(DistrictSearchQuery.class.getClassLoader());
        this.f7327b = parcel.createTypedArrayList(DistrictItem.CREATOR);
    }
}
