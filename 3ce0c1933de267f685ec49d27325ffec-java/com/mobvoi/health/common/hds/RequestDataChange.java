package com.mobvoi.health.common.hds;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.mobvoi.health.common.data.pojo.DataType;
/* loaded from: classes2.dex */
public class RequestDataChange implements Parcelable {
    public static final Parcelable.Creator<RequestDataChange> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public final DataType f17981a;

    /* renamed from: b  reason: collision with root package name */
    public final int f17982b;

    /* renamed from: c  reason: collision with root package name */
    public final int f17983c;

    /* renamed from: d  reason: collision with root package name */
    private final IBinder f17984d;

    /* renamed from: e  reason: collision with root package name */
    private final int f17985e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f17986f;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<RequestDataChange> {
        a() {
        }

        /* renamed from: a */
        public RequestDataChange createFromParcel(Parcel parcel) {
            return new RequestDataChange(parcel, null);
        }

        /* renamed from: b */
        public RequestDataChange[] newArray(int i10) {
            return new RequestDataChange[i10];
        }
    }

    /* synthetic */ RequestDataChange(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        DataType dataType = this.f17981a;
        parcel.writeInt(dataType == null ? -1 : dataType.typeCode);
        parcel.writeInt(this.f17982b);
        parcel.writeInt(this.f17983c);
        parcel.writeStrongBinder(this.f17984d);
        parcel.writeInt(this.f17985e);
        parcel.writeByte(this.f17986f ? (byte) 1 : (byte) 0);
    }

    private RequestDataChange(Parcel parcel) {
        this.f17981a = DataType.from(parcel.readInt());
        this.f17982b = parcel.readInt();
        this.f17983c = parcel.readInt();
        this.f17984d = parcel.readStrongBinder();
        boolean z10 = true;
        if (parcel.dataAvail() > 0) {
            this.f17985e = parcel.readInt();
        } else {
            this.f17985e = 1;
        }
        if (this.f17985e >= 2) {
            this.f17986f = parcel.readByte() != 1 ? false : z10;
        } else {
            this.f17986f = false;
        }
    }
}
