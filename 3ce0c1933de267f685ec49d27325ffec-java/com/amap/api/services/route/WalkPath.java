package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class WalkPath extends Path {
    public static final Parcelable.Creator<WalkPath> CREATOR = new a();

    /* renamed from: c  reason: collision with root package name */
    private List<WalkStep> f7528c;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<WalkPath> {
        a() {
        }

        /* renamed from: a */
        public WalkPath createFromParcel(Parcel parcel) {
            return new WalkPath(parcel);
        }

        /* renamed from: b */
        public WalkPath[] newArray(int i10) {
            return null;
        }
    }

    public WalkPath(Parcel parcel) {
        super(parcel);
        this.f7528c = new ArrayList();
        this.f7528c = parcel.createTypedArrayList(WalkStep.CREATOR);
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.amap.api.services.route.Path, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        super.writeToParcel(parcel, i10);
        parcel.writeTypedList(this.f7528c);
    }

    public WalkPath() {
        this.f7528c = new ArrayList();
    }
}
