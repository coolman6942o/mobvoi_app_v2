package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class SearchCity implements Parcelable {
    public static final Parcelable.Creator<SearchCity> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private String f7516a;

    /* renamed from: b  reason: collision with root package name */
    private String f7517b;

    /* renamed from: c  reason: collision with root package name */
    private String f7518c;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<SearchCity> {
        a() {
        }

        /* renamed from: a */
        public SearchCity createFromParcel(Parcel parcel) {
            return new SearchCity(parcel);
        }

        /* renamed from: b */
        public SearchCity[] newArray(int i10) {
            return null;
        }
    }

    public SearchCity(Parcel parcel) {
        this.f7516a = parcel.readString();
        this.f7517b = parcel.readString();
        this.f7518c = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f7516a);
        parcel.writeString(this.f7517b);
        parcel.writeString(this.f7518c);
    }

    public SearchCity() {
    }
}
