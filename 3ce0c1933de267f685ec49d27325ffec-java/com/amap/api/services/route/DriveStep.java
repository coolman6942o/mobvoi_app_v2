package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class DriveStep implements Parcelable {
    public static final Parcelable.Creator<DriveStep> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private String f7438a;

    /* renamed from: b  reason: collision with root package name */
    private String f7439b;

    /* renamed from: c  reason: collision with root package name */
    private String f7440c;

    /* renamed from: d  reason: collision with root package name */
    private float f7441d;

    /* renamed from: e  reason: collision with root package name */
    private float f7442e;

    /* renamed from: f  reason: collision with root package name */
    private float f7443f;

    /* renamed from: g  reason: collision with root package name */
    private String f7444g;

    /* renamed from: h  reason: collision with root package name */
    private float f7445h;

    /* renamed from: i  reason: collision with root package name */
    private List<LatLonPoint> f7446i;

    /* renamed from: j  reason: collision with root package name */
    private String f7447j;

    /* renamed from: k  reason: collision with root package name */
    private String f7448k;

    /* renamed from: l  reason: collision with root package name */
    private List<RouteSearchCity> f7449l;

    /* renamed from: m  reason: collision with root package name */
    private List<TMC> f7450m;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<DriveStep> {
        a() {
        }

        /* renamed from: a */
        public DriveStep createFromParcel(Parcel parcel) {
            return new DriveStep(parcel);
        }

        /* renamed from: b */
        public DriveStep[] newArray(int i10) {
            return null;
        }
    }

    public DriveStep(Parcel parcel) {
        this.f7446i = new ArrayList();
        this.f7449l = new ArrayList();
        this.f7450m = new ArrayList();
        this.f7438a = parcel.readString();
        this.f7439b = parcel.readString();
        this.f7440c = parcel.readString();
        this.f7441d = parcel.readFloat();
        this.f7442e = parcel.readFloat();
        this.f7443f = parcel.readFloat();
        this.f7444g = parcel.readString();
        this.f7445h = parcel.readFloat();
        this.f7446i = parcel.createTypedArrayList(LatLonPoint.CREATOR);
        this.f7447j = parcel.readString();
        this.f7448k = parcel.readString();
        this.f7449l = parcel.createTypedArrayList(RouteSearchCity.CREATOR);
        this.f7450m = parcel.createTypedArrayList(TMC.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f7438a);
        parcel.writeString(this.f7439b);
        parcel.writeString(this.f7440c);
        parcel.writeFloat(this.f7441d);
        parcel.writeFloat(this.f7442e);
        parcel.writeFloat(this.f7443f);
        parcel.writeString(this.f7444g);
        parcel.writeFloat(this.f7445h);
        parcel.writeTypedList(this.f7446i);
        parcel.writeString(this.f7447j);
        parcel.writeString(this.f7448k);
        parcel.writeTypedList(this.f7449l);
        parcel.writeTypedList(this.f7450m);
    }

    public DriveStep() {
        this.f7446i = new ArrayList();
        this.f7449l = new ArrayList();
        this.f7450m = new ArrayList();
    }
}
