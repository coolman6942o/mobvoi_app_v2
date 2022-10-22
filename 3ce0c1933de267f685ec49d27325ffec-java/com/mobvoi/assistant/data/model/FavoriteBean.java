package com.mobvoi.assistant.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.mobvoi.android.common.json.JsonBean;
import com.mobvoi.wear.util.TelephonyUtil;
import h8.c;
/* loaded from: classes2.dex */
public class FavoriteBean implements JsonBean, Parcelable {
    public static final int ARTICLE_CATEGORY = 5;
    public static final Parcelable.Creator<FavoriteBean> CREATOR = new a();
    public static final String PUBLIC_NUM = "public_num";
    public static final String RECOMMEND = "recommend";
    public static final String TENCENT_NEW = "tencent_new";
    @c("addTime")
    public long addTime;
    @c("articleId")
    public String articleId;
    @c("artist")
    public String artist;
    @c("categoryId")
    public int categoryId;
    @c("categoryName")
    public String categoryName;
    @c("id")

    /* renamed from: id  reason: collision with root package name */
    public String f15721id;
    @c("image")
    public String image;
    @c("linkUrl")
    public String linkUrl;
    @c("query")
    public String query;
    @c(TelephonyUtil.KEY_SIM_ACTIVITIED_SOURCE)
    public String source;
    @c("title")
    public String title;
    @c("type")
    public String type;
    @c("userId")
    public String userId;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<FavoriteBean> {
        a() {
        }

        /* renamed from: a */
        public FavoriteBean createFromParcel(Parcel parcel) {
            return new FavoriteBean(parcel);
        }

        /* renamed from: b */
        public FavoriteBean[] newArray(int i10) {
            return new FavoriteBean[i10];
        }
    }

    public FavoriteBean() {
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
        return this.f15721id.equals(((FavoriteBean) obj).f15721id);
    }

    public int hashCode() {
        return this.f15721id.hashCode();
    }

    public String toString() {
        return "FavoriteBean{id='" + this.f15721id + "', categoryId=" + this.categoryId + ", categoryName='" + this.categoryName + "', userId='" + this.userId + "', addTime=" + this.addTime + ", image='" + this.image + "', title='" + this.title + "', artist='" + this.artist + "', linkUrl='" + this.linkUrl + "', query='" + this.query + "', source='" + this.source + "', articleId='" + this.articleId + "', type='" + this.type + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f15721id);
        parcel.writeInt(this.categoryId);
        parcel.writeString(this.categoryName);
        parcel.writeLong(this.addTime);
        parcel.writeString(this.image);
        parcel.writeString(this.title);
        parcel.writeString(this.artist);
        parcel.writeString(this.linkUrl);
        parcel.writeString(this.query);
        parcel.writeString(this.source);
        parcel.writeString(this.articleId);
    }

    protected FavoriteBean(Parcel parcel) {
        this.f15721id = parcel.readString();
        this.categoryId = parcel.readInt();
        this.categoryName = parcel.readString();
        this.addTime = parcel.readLong();
        this.image = parcel.readString();
        this.title = parcel.readString();
        this.artist = parcel.readString();
        this.linkUrl = parcel.readString();
        this.query = parcel.readString();
        this.source = parcel.readString();
        this.articleId = parcel.readString();
    }
}
