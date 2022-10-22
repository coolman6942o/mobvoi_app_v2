package com.mobvoi.assistant.data.network.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.mobvoi.wear.contacts.ContactConstant;
import com.mobvoi.wear.providers.AppUpdateColumn;
import h8.c;
/* loaded from: classes2.dex */
public class AuthListResponse$OauthServiceInfoBean$OauthInfoBean implements Parcelable {
    public static final Parcelable.Creator<AuthListResponse$OauthServiceInfoBean$OauthInfoBean> CREATOR = new a();
    @c("access_token")

    /* renamed from: a  reason: collision with root package name */
    public String f15729a;
    @c(AppUpdateColumn.ICON_URL)

    /* renamed from: b  reason: collision with root package name */
    public String f15730b;
    @c("need_auth")

    /* renamed from: c  reason: collision with root package name */
    public boolean f15731c;
    @c("is_bound")

    /* renamed from: d  reason: collision with root package name */
    public boolean f15732d;
    @c(ContactConstant.CallsRecordKeys.NAME)

    /* renamed from: e  reason: collision with root package name */
    public String f15733e;
    @c("promotion_info")

    /* renamed from: f  reason: collision with root package name */
    public PromotionInfoBean f15734f;
    @c("auth_url")

    /* renamed from: g  reason: collision with root package name */
    public String f15735g;
    @c("type")

    /* renamed from: h  reason: collision with root package name */
    public String f15736h;
    @c("support_version_android")

    /* renamed from: i  reason: collision with root package name */
    public int f15737i;

    /* loaded from: classes2.dex */
    public static class PromotionInfoBean implements Parcelable {
        public static final Parcelable.Creator<PromotionInfoBean> CREATOR = new a();
        @c("msg")

        /* renamed from: a  reason: collision with root package name */
        public String f15738a;
        @c("url_text")

        /* renamed from: b  reason: collision with root package name */
        public String f15739b;
        @c("url")

        /* renamed from: c  reason: collision with root package name */
        public String f15740c;

        /* loaded from: classes2.dex */
        class a implements Parcelable.Creator<PromotionInfoBean> {
            a() {
            }

            /* renamed from: a */
            public PromotionInfoBean createFromParcel(Parcel parcel) {
                return new PromotionInfoBean(parcel);
            }

            /* renamed from: b */
            public PromotionInfoBean[] newArray(int i10) {
                return new PromotionInfoBean[i10];
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeString(this.f15738a);
            parcel.writeString(this.f15739b);
            parcel.writeString(this.f15740c);
        }

        private PromotionInfoBean(Parcel parcel) {
            this.f15738a = parcel.readString();
            this.f15739b = parcel.readString();
            this.f15740c = parcel.readString();
        }
    }

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<AuthListResponse$OauthServiceInfoBean$OauthInfoBean> {
        a() {
        }

        /* renamed from: a */
        public AuthListResponse$OauthServiceInfoBean$OauthInfoBean createFromParcel(Parcel parcel) {
            return new AuthListResponse$OauthServiceInfoBean$OauthInfoBean(parcel);
        }

        /* renamed from: b */
        public AuthListResponse$OauthServiceInfoBean$OauthInfoBean[] newArray(int i10) {
            return new AuthListResponse$OauthServiceInfoBean$OauthInfoBean[i10];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f15730b);
        parcel.writeByte(this.f15731c ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f15732d ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f15733e);
        parcel.writeParcelable(this.f15734f, i10);
        parcel.writeString(this.f15735g);
        parcel.writeString(this.f15736h);
        parcel.writeString(this.f15729a);
    }

    private AuthListResponse$OauthServiceInfoBean$OauthInfoBean(Parcel parcel) {
        this.f15730b = parcel.readString();
        boolean z10 = true;
        this.f15731c = parcel.readByte() != 0;
        this.f15732d = parcel.readByte() == 0 ? false : z10;
        this.f15733e = parcel.readString();
        this.f15734f = (PromotionInfoBean) parcel.readParcelable(PromotionInfoBean.class.getClassLoader());
        this.f15735g = parcel.readString();
        this.f15736h = parcel.readString();
        this.f15729a = parcel.readString();
    }
}
