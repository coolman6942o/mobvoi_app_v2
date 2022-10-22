package com.amap.api.services.traffic;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
/* loaded from: classes.dex */
public class TrafficStatusResult implements Parcelable {
    public static final Parcelable.Creator<TrafficStatusResult> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private String f7560a;

    /* renamed from: b  reason: collision with root package name */
    private TrafficStatusEvaluation f7561b;

    /* renamed from: c  reason: collision with root package name */
    private List<TrafficStatusInfo> f7562c;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<TrafficStatusResult> {
        a() {
        }

        /* renamed from: a */
        public TrafficStatusResult createFromParcel(Parcel parcel) {
            return new TrafficStatusResult(parcel);
        }

        /* renamed from: b */
        public TrafficStatusResult[] newArray(int i10) {
            return new TrafficStatusResult[i10];
        }
    }

    public TrafficStatusResult() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f7560a);
        parcel.writeParcelable(this.f7561b, i10);
        parcel.writeTypedList(this.f7562c);
    }

    protected TrafficStatusResult(Parcel parcel) {
        this.f7560a = parcel.readString();
        this.f7561b = (TrafficStatusEvaluation) parcel.readParcelable(TrafficStatusEvaluation.class.getClassLoader());
        this.f7562c = parcel.createTypedArrayList(TrafficStatusInfo.CREATOR);
    }
}
