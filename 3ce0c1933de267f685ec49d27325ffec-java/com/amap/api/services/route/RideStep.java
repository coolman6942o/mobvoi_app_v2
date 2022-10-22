package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class RideStep implements Parcelable {
    public static final Parcelable.Creator<RideStep> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private String f7468a;

    /* renamed from: b  reason: collision with root package name */
    private String f7469b;

    /* renamed from: c  reason: collision with root package name */
    private String f7470c;

    /* renamed from: d  reason: collision with root package name */
    private float f7471d;

    /* renamed from: e  reason: collision with root package name */
    private float f7472e;

    /* renamed from: f  reason: collision with root package name */
    private List<LatLonPoint> f7473f;

    /* renamed from: g  reason: collision with root package name */
    private String f7474g;

    /* renamed from: h  reason: collision with root package name */
    private String f7475h;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<RideStep> {
        a() {
        }

        /* renamed from: a */
        public RideStep createFromParcel(Parcel parcel) {
            return new RideStep(parcel);
        }

        /* renamed from: b */
        public RideStep[] newArray(int i10) {
            return new RideStep[i10];
        }
    }

    public RideStep() {
        this.f7473f = new ArrayList();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f7468a);
        parcel.writeString(this.f7469b);
        parcel.writeString(this.f7470c);
        parcel.writeFloat(this.f7471d);
        parcel.writeFloat(this.f7472e);
        parcel.writeTypedList(this.f7473f);
        parcel.writeString(this.f7474g);
        parcel.writeString(this.f7475h);
    }

    protected RideStep(Parcel parcel) {
        this.f7473f = new ArrayList();
        this.f7468a = parcel.readString();
        this.f7469b = parcel.readString();
        this.f7470c = parcel.readString();
        this.f7471d = parcel.readFloat();
        this.f7472e = parcel.readFloat();
        this.f7473f = parcel.createTypedArrayList(LatLonPoint.CREATOR);
        this.f7474g = parcel.readString();
        this.f7475h = parcel.readString();
    }
}
