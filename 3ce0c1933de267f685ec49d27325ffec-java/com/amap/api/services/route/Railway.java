package com.amap.api.services.route;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class Railway implements Parcelable {
    public static final Parcelable.Creator<Railway> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private String f7453a;

    /* renamed from: b  reason: collision with root package name */
    private String f7454b;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<Railway> {
        a() {
        }

        /* renamed from: a */
        public Railway createFromParcel(Parcel parcel) {
            return new Railway(parcel);
        }

        /* renamed from: b */
        public Railway[] newArray(int i10) {
            return new Railway[i10];
        }
    }

    public Railway() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f7453a);
        parcel.writeString(this.f7454b);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Railway(Parcel parcel) {
        this.f7453a = parcel.readString();
        this.f7454b = parcel.readString();
    }
}
