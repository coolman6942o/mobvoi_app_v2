package com.amap.api.services.traffic;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class TrafficStatusEvaluation implements Parcelable {
    public static final Parcelable.Creator<TrafficStatusEvaluation> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private String f7547a;

    /* renamed from: b  reason: collision with root package name */
    private String f7548b;

    /* renamed from: c  reason: collision with root package name */
    private String f7549c;

    /* renamed from: d  reason: collision with root package name */
    private String f7550d;

    /* renamed from: e  reason: collision with root package name */
    private String f7551e;

    /* renamed from: f  reason: collision with root package name */
    private String f7552f;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<TrafficStatusEvaluation> {
        a() {
        }

        /* renamed from: a */
        public TrafficStatusEvaluation createFromParcel(Parcel parcel) {
            return new TrafficStatusEvaluation(parcel);
        }

        /* renamed from: b */
        public TrafficStatusEvaluation[] newArray(int i10) {
            return new TrafficStatusEvaluation[i10];
        }
    }

    public TrafficStatusEvaluation() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f7547a);
        parcel.writeString(this.f7548b);
        parcel.writeString(this.f7549c);
        parcel.writeString(this.f7550d);
        parcel.writeString(this.f7551e);
        parcel.writeString(this.f7552f);
    }

    protected TrafficStatusEvaluation(Parcel parcel) {
        this.f7547a = parcel.readString();
        this.f7548b = parcel.readString();
        this.f7549c = parcel.readString();
        this.f7550d = parcel.readString();
        this.f7551e = parcel.readString();
        this.f7552f = parcel.readString();
    }
}
