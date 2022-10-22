package com.amap.api.services.poisearch;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class PoiItemExtension implements Parcelable {
    public static final Parcelable.Creator<PoiItemExtension> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private String f7391a;

    /* renamed from: b  reason: collision with root package name */
    private String f7392b;

    /* loaded from: classes.dex */
    static class a implements Parcelable.Creator<PoiItemExtension> {
        a() {
        }

        /* renamed from: a */
        public PoiItemExtension createFromParcel(Parcel parcel) {
            return new PoiItemExtension(parcel);
        }

        /* renamed from: b */
        public PoiItemExtension[] newArray(int i10) {
            return new PoiItemExtension[i10];
        }
    }

    protected PoiItemExtension(Parcel parcel) {
        this.f7391a = parcel.readString();
        this.f7392b = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f7391a);
        parcel.writeString(this.f7392b);
    }
}
