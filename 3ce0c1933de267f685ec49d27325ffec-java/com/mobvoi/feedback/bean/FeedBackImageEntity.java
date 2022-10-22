package com.mobvoi.feedback.bean;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.Objects;
/* loaded from: classes2.dex */
public class FeedBackImageEntity implements Parcelable {
    public static final Parcelable.Creator<FeedBackImageEntity> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public String f17896a;

    /* renamed from: b  reason: collision with root package name */
    public Uri f17897b;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<FeedBackImageEntity> {
        a() {
        }

        /* renamed from: a */
        public FeedBackImageEntity createFromParcel(Parcel parcel) {
            return new FeedBackImageEntity(parcel);
        }

        /* renamed from: b */
        public FeedBackImageEntity[] newArray(int i10) {
            return new FeedBackImageEntity[i10];
        }
    }

    protected FeedBackImageEntity(Parcel parcel) {
        this.f17896a = parcel.readString();
        this.f17897b = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FeedBackImageEntity feedBackImageEntity = (FeedBackImageEntity) obj;
        return TextUtils.equals(this.f17896a, feedBackImageEntity.f17896a) && this.f17897b.equals(feedBackImageEntity.f17897b);
    }

    public int hashCode() {
        return Objects.hash(this.f17896a, this.f17897b);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f17896a);
        parcel.writeParcelable(this.f17897b, i10);
    }

    public FeedBackImageEntity(String str, Uri uri) {
        this.f17896a = str;
        this.f17897b = uri;
    }
}
