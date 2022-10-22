package com.mobvoi.watch.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.mobvoi.wear.util.ParcelableUtils;
/* loaded from: classes2.dex */
public class RequestParam implements Parcelable {
    public static final Parcelable.Creator<RequestParam> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private Object f20883a;

    /* renamed from: b  reason: collision with root package name */
    private Object f20884b;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<RequestParam> {
        a() {
        }

        /* renamed from: a */
        public RequestParam createFromParcel(Parcel parcel) {
            RequestParam requestParam = new RequestParam();
            requestParam.a(parcel);
            return requestParam;
        }

        /* renamed from: b */
        public RequestParam[] newArray(int i10) {
            return new RequestParam[i10];
        }
    }

    protected void a(Parcel parcel) {
        this.f20883a = ParcelableUtils.readValue(parcel);
        this.f20884b = ParcelableUtils.readValue(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        ParcelableUtils.writeValue(parcel, this.f20883a);
        ParcelableUtils.writeValue(parcel, this.f20884b);
    }
}
