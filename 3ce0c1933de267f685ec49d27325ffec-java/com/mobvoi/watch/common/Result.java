package com.mobvoi.watch.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.mobvoi.wear.util.ParcelableUtils;
import com.unionpay.tsmservice.data.Constant;
/* loaded from: classes2.dex */
public class Result implements Parcelable {
    public static final Parcelable.Creator<Result> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private int f20885a;

    /* renamed from: b  reason: collision with root package name */
    private String f20886b;

    /* renamed from: c  reason: collision with root package name */
    private Object f20887c;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<Result> {
        a() {
        }

        /* renamed from: a */
        public Result createFromParcel(Parcel parcel) {
            Result result = new Result(0, null);
            result.b(parcel);
            return result;
        }

        /* renamed from: b */
        public Result[] newArray(int i10) {
            return new Result[i10];
        }
    }

    static {
        new Result(1, Constant.CASH_LOAD_SUCCESS);
        new Result(0, "failed");
        new Result(2, "result is empty");
        new Result(3, "not found message receiver.");
    }

    public Result(int i10, String str, Object obj) {
        this.f20885a = i10;
        this.f20886b = str;
        this.f20887c = obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Parcel parcel) {
        this.f20885a = parcel.readInt();
        this.f20886b = parcel.readString();
        this.f20887c = ParcelableUtils.readValue(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format("code:%s,message:%s", Integer.valueOf(this.f20885a), this.f20886b);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f20885a);
        ParcelableUtils.writeString(parcel, this.f20886b);
        ParcelableUtils.writeValue(parcel, this.f20887c);
    }

    public Result(int i10, String str) {
        this(i10, str, null);
    }
}
