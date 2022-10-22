package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.services.core.LatLonPoint;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class WalkStep implements Parcelable {
    public static final Parcelable.Creator<WalkStep> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private String f7531a;

    /* renamed from: b  reason: collision with root package name */
    private String f7532b;

    /* renamed from: c  reason: collision with root package name */
    private String f7533c;

    /* renamed from: d  reason: collision with root package name */
    private float f7534d;

    /* renamed from: e  reason: collision with root package name */
    private float f7535e;

    /* renamed from: f  reason: collision with root package name */
    private List<LatLonPoint> f7536f;

    /* renamed from: g  reason: collision with root package name */
    private String f7537g;

    /* renamed from: h  reason: collision with root package name */
    private String f7538h;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<WalkStep> {
        a() {
        }

        /* renamed from: a */
        public WalkStep createFromParcel(Parcel parcel) {
            return new WalkStep(parcel);
        }

        /* renamed from: b */
        public WalkStep[] newArray(int i10) {
            return null;
        }
    }

    public WalkStep(Parcel parcel) {
        this.f7536f = new ArrayList();
        this.f7531a = parcel.readString();
        this.f7532b = parcel.readString();
        this.f7533c = parcel.readString();
        this.f7534d = parcel.readFloat();
        this.f7535e = parcel.readFloat();
        this.f7536f = parcel.createTypedArrayList(LatLonPoint.CREATOR);
        this.f7537g = parcel.readString();
        this.f7538h = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f7531a);
        parcel.writeString(this.f7532b);
        parcel.writeString(this.f7533c);
        parcel.writeFloat(this.f7534d);
        parcel.writeFloat(this.f7535e);
        parcel.writeTypedList(this.f7536f);
        parcel.writeString(this.f7537g);
        parcel.writeString(this.f7538h);
    }

    public WalkStep() {
        this.f7536f = new ArrayList();
    }
}
