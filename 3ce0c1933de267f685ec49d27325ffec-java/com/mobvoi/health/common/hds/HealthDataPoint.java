package com.mobvoi.health.common.hds;

import android.os.Parcel;
import android.os.Parcelable;
import com.mobvoi.health.common.data.pojo.DataType;
/* loaded from: classes2.dex */
public class HealthDataPoint implements Parcelable {
    public static final Parcelable.Creator<HealthDataPoint> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public DataType f17977a;

    /* renamed from: b  reason: collision with root package name */
    public long f17978b;

    /* renamed from: c  reason: collision with root package name */
    public long f17979c;

    /* renamed from: d  reason: collision with root package name */
    public String f17980d;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<HealthDataPoint> {
        a() {
        }

        /* renamed from: a */
        public HealthDataPoint createFromParcel(Parcel parcel) {
            return new HealthDataPoint(parcel, null);
        }

        /* renamed from: b */
        public HealthDataPoint[] newArray(int i10) {
            return new HealthDataPoint[i10];
        }
    }

    /* synthetic */ HealthDataPoint(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        DataType dataType = this.f17977a;
        parcel.writeInt(dataType == null ? -1 : dataType.typeCode);
        parcel.writeLong(this.f17978b);
        parcel.writeLong(this.f17979c);
        parcel.writeString(this.f17980d);
    }

    private HealthDataPoint(Parcel parcel) {
        this.f17977a = DataType.from(parcel.readInt());
        this.f17978b = parcel.readLong();
        this.f17979c = parcel.readLong();
        this.f17980d = parcel.readString();
    }
}
