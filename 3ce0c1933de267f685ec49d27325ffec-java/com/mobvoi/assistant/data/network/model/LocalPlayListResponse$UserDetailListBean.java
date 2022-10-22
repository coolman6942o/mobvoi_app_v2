package com.mobvoi.assistant.data.network.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.mobvoi.android.common.json.JsonBean;
import h8.c;
import java.util.List;
/* loaded from: classes2.dex */
public class LocalPlayListResponse$UserDetailListBean implements JsonBean, Parcelable {
    public static final Parcelable.Creator<LocalPlayListResponse$UserDetailListBean> CREATOR = new a();
    @c("user_playlist")
    public UserPlaylistBean userPlaylist;
    @c("user_resource_list")
    public List<UserResourceListBean> userResourceList;

    /* loaded from: classes2.dex */
    public static class UserPlaylistBean implements JsonBean, Parcelable {
        public static final Parcelable.Creator<UserPlaylistBean> CREATOR = new a();
        @c("device_id")
        public String deviceId;
        @c("playlist_id")
        public String playlistId;
        @c("playlist_name")
        public String playlistName;
        @c("playlist_type")
        public int playlistType;
        @c("resource_count")
        public int resourceCount;
        @c("wwid")
        public String wwid;

        /* loaded from: classes2.dex */
        class a implements Parcelable.Creator<UserPlaylistBean> {
            a() {
            }

            /* renamed from: a */
            public UserPlaylistBean createFromParcel(Parcel parcel) {
                return new UserPlaylistBean(parcel);
            }

            /* renamed from: b */
            public UserPlaylistBean[] newArray(int i10) {
                return new UserPlaylistBean[i10];
            }
        }

        protected UserPlaylistBean(Parcel parcel) {
            this.deviceId = parcel.readString();
            this.playlistId = parcel.readString();
            this.playlistName = parcel.readString();
            this.playlistType = parcel.readInt();
            this.resourceCount = parcel.readInt();
            this.wwid = parcel.readString();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeString(this.deviceId);
            parcel.writeString(this.playlistId);
            parcel.writeString(this.playlistName);
            parcel.writeInt(this.playlistType);
            parcel.writeInt(this.resourceCount);
            parcel.writeString(this.wwid);
        }
    }

    /* loaded from: classes2.dex */
    public static class UserResourceListBean implements JsonBean, Parcelable {
        public static final Parcelable.Creator<UserResourceListBean> CREATOR = new a();
        @c("author")
        public String author;
        @c("download_status")
        public int downloadStatus;
        @c("duration")
        public int duration;
        @c("is_favorite")
        public boolean isFavorite;
        public boolean oldFavourite;
        @c("order")
        public int order;
        @c("playlist_id")
        public String playlistId;
        @c("resource_id")
        public String resourceId;
        @c("resource_name")
        public String resourceName;
        @c("resource_url")
        public String resourceUrl;

        /* loaded from: classes2.dex */
        class a implements Parcelable.Creator<UserResourceListBean> {
            a() {
            }

            /* renamed from: a */
            public UserResourceListBean createFromParcel(Parcel parcel) {
                return new UserResourceListBean(parcel);
            }

            /* renamed from: b */
            public UserResourceListBean[] newArray(int i10) {
                return new UserResourceListBean[i10];
            }
        }

        protected UserResourceListBean(Parcel parcel) {
            this.author = parcel.readString();
            this.downloadStatus = parcel.readInt();
            this.duration = parcel.readInt();
            boolean z10 = true;
            this.isFavorite = parcel.readByte() != 0;
            this.order = parcel.readInt();
            this.playlistId = parcel.readString();
            this.resourceId = parcel.readString();
            this.resourceName = parcel.readString();
            this.resourceUrl = parcel.readString();
            this.oldFavourite = parcel.readByte() == 0 ? false : z10;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeString(this.author);
            parcel.writeInt(this.downloadStatus);
            parcel.writeInt(this.duration);
            parcel.writeByte(this.isFavorite ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.order);
            parcel.writeString(this.playlistId);
            parcel.writeString(this.resourceId);
            parcel.writeString(this.resourceName);
            parcel.writeString(this.resourceUrl);
            parcel.writeByte(this.oldFavourite ? (byte) 1 : (byte) 0);
        }
    }

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<LocalPlayListResponse$UserDetailListBean> {
        a() {
        }

        /* renamed from: a */
        public LocalPlayListResponse$UserDetailListBean createFromParcel(Parcel parcel) {
            return new LocalPlayListResponse$UserDetailListBean(parcel);
        }

        /* renamed from: b */
        public LocalPlayListResponse$UserDetailListBean[] newArray(int i10) {
            return new LocalPlayListResponse$UserDetailListBean[i10];
        }
    }

    protected LocalPlayListResponse$UserDetailListBean(Parcel parcel) {
        this.userPlaylist = (UserPlaylistBean) parcel.readParcelable(UserPlaylistBean.class.getClassLoader());
        this.userResourceList = parcel.createTypedArrayList(UserResourceListBean.CREATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeParcelable(this.userPlaylist, i10);
        parcel.writeTypedList(this.userResourceList);
    }
}
