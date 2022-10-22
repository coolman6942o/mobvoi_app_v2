package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class IndoorData implements Parcelable {
    public static final Parcelable.Creator<IndoorData> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private String f7386a;

    /* renamed from: b  reason: collision with root package name */
    private int f7387b;

    /* renamed from: c  reason: collision with root package name */
    private String f7388c;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<IndoorData> {
        a() {
        }

        /* renamed from: a */
        public IndoorData createFromParcel(Parcel parcel) {
            return new IndoorData(parcel);
        }

        /* renamed from: b */
        public IndoorData[] newArray(int i10) {
            return new IndoorData[i10];
        }
    }

    protected IndoorData(Parcel parcel) {
        this.f7386a = parcel.readString();
        this.f7387b = parcel.readInt();
        this.f7388c = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f7386a);
        parcel.writeInt(this.f7387b);
        parcel.writeString(this.f7388c);
    }
}
