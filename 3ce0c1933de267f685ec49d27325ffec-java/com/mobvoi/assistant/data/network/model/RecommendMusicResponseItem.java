package com.mobvoi.assistant.data.network.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.mobvoi.wear.contacts.ContactConstant;
import h8.c;
/* loaded from: classes2.dex */
public class RecommendMusicResponseItem implements Parcelable {
    public static final Parcelable.Creator<RecommendMusicResponseItem> CREATOR = new a();
    @c("createdAt")

    /* renamed from: a  reason: collision with root package name */
    long f15809a;
    @c("id")

    /* renamed from: b  reason: collision with root package name */
    int f15810b;
    @c(ContactConstant.CallsRecordKeys.NAME)

    /* renamed from: c  reason: collision with root package name */
    String f15811c;
    @c("picture")

    /* renamed from: d  reason: collision with root package name */
    String f15812d;
    @c("query")

    /* renamed from: e  reason: collision with root package name */
    String f15813e;
    @c("updatedAt")

    /* renamed from: f  reason: collision with root package name */
    long f15814f;
    @c("weight")

    /* renamed from: g  reason: collision with root package name */
    int f15815g;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<RecommendMusicResponseItem> {
        a() {
        }

        /* renamed from: a */
        public RecommendMusicResponseItem createFromParcel(Parcel parcel) {
            return new RecommendMusicResponseItem(parcel);
        }

        /* renamed from: b */
        public RecommendMusicResponseItem[] newArray(int i10) {
            return new RecommendMusicResponseItem[i10];
        }
    }

    protected RecommendMusicResponseItem(Parcel parcel) {
        this.f15809a = parcel.readLong();
        this.f15810b = parcel.readInt();
        this.f15811c = parcel.readString();
        this.f15812d = parcel.readString();
        this.f15813e = parcel.readString();
        this.f15814f = parcel.readLong();
        this.f15815g = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeLong(this.f15809a);
        parcel.writeInt(this.f15810b);
        parcel.writeString(this.f15811c);
        parcel.writeString(this.f15812d);
        parcel.writeString(this.f15813e);
        parcel.writeLong(this.f15814f);
        parcel.writeInt(this.f15815g);
    }
}
