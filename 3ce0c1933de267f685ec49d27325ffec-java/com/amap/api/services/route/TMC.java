package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class TMC implements Parcelable {
    public static final Parcelable.Creator<TMC> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private int f7519a;

    /* renamed from: b  reason: collision with root package name */
    private String f7520b;

    /* renamed from: c  reason: collision with root package name */
    private List<LatLonPoint> f7521c;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<TMC> {
        a() {
        }

        /* renamed from: a */
        public TMC createFromParcel(Parcel parcel) {
            return new TMC(parcel);
        }

        /* renamed from: b */
        public TMC[] newArray(int i10) {
            return null;
        }
    }

    public TMC(Parcel parcel) {
        this.f7521c = new ArrayList();
        this.f7519a = parcel.readInt();
        this.f7520b = parcel.readString();
        this.f7521c = parcel.createTypedArrayList(LatLonPoint.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f7519a);
        parcel.writeString(this.f7520b);
        parcel.writeTypedList(this.f7521c);
    }

    public TMC() {
        this.f7521c = new ArrayList();
    }
}
