package com.amap.api.services.district;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes.dex */
public final class DistrictItem implements Parcelable {
    public static final Parcelable.Creator<DistrictItem> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private String f7319a;

    /* renamed from: b  reason: collision with root package name */
    private String f7320b;

    /* renamed from: c  reason: collision with root package name */
    private String f7321c;

    /* renamed from: d  reason: collision with root package name */
    private LatLonPoint f7322d;

    /* renamed from: e  reason: collision with root package name */
    private String f7323e;

    /* renamed from: f  reason: collision with root package name */
    private List<DistrictItem> f7324f;

    /* renamed from: g  reason: collision with root package name */
    private String[] f7325g;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<DistrictItem> {
        a() {
        }

        /* renamed from: a */
        public DistrictItem createFromParcel(Parcel parcel) {
            return new DistrictItem(parcel);
        }

        /* renamed from: b */
        public DistrictItem[] newArray(int i10) {
            return new DistrictItem[i10];
        }
    }

    public DistrictItem() {
        this.f7324f = new ArrayList();
        this.f7325g = new String[0];
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || DistrictItem.class != obj.getClass()) {
            return false;
        }
        DistrictItem districtItem = (DistrictItem) obj;
        String str = this.f7320b;
        if (str == null) {
            if (districtItem.f7320b != null) {
                return false;
            }
        } else if (!str.equals(districtItem.f7320b)) {
            return false;
        }
        LatLonPoint latLonPoint = this.f7322d;
        if (latLonPoint == null) {
            if (districtItem.f7322d != null) {
                return false;
            }
        } else if (!latLonPoint.equals(districtItem.f7322d)) {
            return false;
        }
        String str2 = this.f7319a;
        if (str2 == null) {
            if (districtItem.f7319a != null) {
                return false;
            }
        } else if (!str2.equals(districtItem.f7319a)) {
            return false;
        }
        if (!Arrays.equals(this.f7325g, districtItem.f7325g)) {
            return false;
        }
        List<DistrictItem> list = this.f7324f;
        if (list == null) {
            if (districtItem.f7324f != null) {
                return false;
            }
        } else if (!list.equals(districtItem.f7324f)) {
            return false;
        }
        String str3 = this.f7323e;
        if (str3 == null) {
            if (districtItem.f7323e != null) {
                return false;
            }
        } else if (!str3.equals(districtItem.f7323e)) {
            return false;
        }
        String str4 = this.f7321c;
        if (str4 == null) {
            if (districtItem.f7321c != null) {
                return false;
            }
        } else if (!str4.equals(districtItem.f7321c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        String str = this.f7320b;
        int i10 = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        LatLonPoint latLonPoint = this.f7322d;
        int hashCode2 = (hashCode + (latLonPoint == null ? 0 : latLonPoint.hashCode())) * 31;
        String str2 = this.f7319a;
        int hashCode3 = (((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + Arrays.hashCode(this.f7325g)) * 31;
        List<DistrictItem> list = this.f7324f;
        int hashCode4 = (hashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        String str3 = this.f7323e;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.f7321c;
        if (str4 != null) {
            i10 = str4.hashCode();
        }
        return hashCode5 + i10;
    }

    public String toString() {
        return "DistrictItem [mCitycode=" + this.f7319a + ", mAdcode=" + this.f7320b + ", mName=" + this.f7321c + ", mCenter=" + this.f7322d + ", mLevel=" + this.f7323e + ", mDistricts=" + this.f7324f + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f7319a);
        parcel.writeString(this.f7320b);
        parcel.writeString(this.f7321c);
        parcel.writeParcelable(this.f7322d, i10);
        parcel.writeString(this.f7323e);
        parcel.writeTypedList(this.f7324f);
        parcel.writeInt(this.f7325g.length);
        parcel.writeStringArray(this.f7325g);
    }

    public DistrictItem(Parcel parcel) {
        this.f7324f = new ArrayList();
        this.f7325g = new String[0];
        this.f7319a = parcel.readString();
        this.f7320b = parcel.readString();
        this.f7321c = parcel.readString();
        this.f7322d = (LatLonPoint) parcel.readParcelable(LatLonPoint.class.getClassLoader());
        this.f7323e = parcel.readString();
        this.f7324f = parcel.createTypedArrayList(CREATOR);
        String[] strArr = new String[parcel.readInt()];
        this.f7325g = strArr;
        parcel.readStringArray(strArr);
    }
}
