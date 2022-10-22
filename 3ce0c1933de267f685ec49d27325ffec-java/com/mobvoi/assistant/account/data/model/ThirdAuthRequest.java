package com.mobvoi.assistant.account.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.mobvoi.android.common.json.JsonBean;
import h8.c;
import java.io.Serializable;
/* loaded from: classes2.dex */
public class ThirdAuthRequest implements JsonBean, Serializable, Parcelable {
    public static final Parcelable.Creator<ThirdAuthRequest> CREATOR = new a();
    @c("access_token")
    public String accessToken;
    @c("expires_in")
    public int expiresIn;
    @c("refresh_token")
    public String refreshToken;
    @c("uid")
    public String uid;
    @c("union_id")
    public String unionId;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<ThirdAuthRequest> {
        a() {
        }

        /* renamed from: a */
        public ThirdAuthRequest createFromParcel(Parcel parcel) {
            return new ThirdAuthRequest(parcel);
        }

        /* renamed from: b */
        public ThirdAuthRequest[] newArray(int i10) {
            return new ThirdAuthRequest[i10];
        }
    }

    protected ThirdAuthRequest(Parcel parcel) {
        this.accessToken = parcel.readString();
        this.refreshToken = parcel.readString();
        this.uid = parcel.readString();
        this.unionId = parcel.readString();
        this.expiresIn = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.accessToken);
        parcel.writeString(this.refreshToken);
        parcel.writeString(this.uid);
        parcel.writeString(this.unionId);
        parcel.writeInt(this.expiresIn);
    }

    public ThirdAuthRequest() {
    }
}
