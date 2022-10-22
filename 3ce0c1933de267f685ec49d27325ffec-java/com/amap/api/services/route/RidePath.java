package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class RidePath extends Path {
    public static final Parcelable.Creator<RidePath> CREATOR = new a();

    /* renamed from: c  reason: collision with root package name */
    private List<RideStep> f7465c;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<RidePath> {
        a() {
        }

        /* renamed from: a */
        public RidePath createFromParcel(Parcel parcel) {
            return new RidePath(parcel);
        }

        /* renamed from: b */
        public RidePath[] newArray(int i10) {
            return null;
        }
    }

    public RidePath(Parcel parcel) {
        super(parcel);
        this.f7465c = new ArrayList();
        this.f7465c = parcel.createTypedArrayList(RideStep.CREATOR);
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeTypedList(this.f7465c);
    }

    public RidePath() {
        this.f7465c = new ArrayList();
    }
}
