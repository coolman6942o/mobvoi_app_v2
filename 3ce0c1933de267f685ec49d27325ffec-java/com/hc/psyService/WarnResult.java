package com.hc.psyService;

import android.os.Parcel;
import android.os.Parcelable;
import com.mobvoi.android.common.utils.d;
/* loaded from: classes.dex */
public class WarnResult implements Parcelable {
    public static final Parcelable.Creator<WarnResult> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private int f13483a;

    /* renamed from: b  reason: collision with root package name */
    private long f13484b;

    /* renamed from: c  reason: collision with root package name */
    public int f13485c;

    /* renamed from: d  reason: collision with root package name */
    private String f13486d;

    /* loaded from: classes.dex */
    class a implements Parcelable.Creator<WarnResult> {
        a() {
        }

        /* renamed from: a */
        public WarnResult createFromParcel(Parcel parcel) {
            return new WarnResult(parcel);
        }

        /* renamed from: b */
        public WarnResult[] newArray(int i10) {
            return new WarnResult[i10];
        }
    }

    protected WarnResult(Parcel parcel) {
        this.f13483a = parcel.readInt();
        this.f13484b = parcel.readLong();
        this.f13485c = parcel.readInt();
        this.f13486d = parcel.readString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "WarnResult{status=" + this.f13483a + ", dataTime=" + d.a(this.f13484b) + ", count=" + this.f13485c + ", hr='" + this.f13486d + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeInt(this.f13483a);
        parcel.writeLong(this.f13484b);
        parcel.writeInt(this.f13485c);
        parcel.writeString(this.f13486d);
    }
}
