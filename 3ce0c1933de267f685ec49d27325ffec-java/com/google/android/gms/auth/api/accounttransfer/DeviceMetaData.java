package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes.dex */
public class DeviceMetaData extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DeviceMetaData> CREATOR = new e();

    /* renamed from: a  reason: collision with root package name */
    private final int f8295a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f8296b;

    /* renamed from: c  reason: collision with root package name */
    private long f8297c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f8298d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DeviceMetaData(int i10, boolean z10, long j10, boolean z11) {
        this.f8295a = i10;
        this.f8296b = z10;
        this.f8297c = j10;
        this.f8298d = z11;
    }

    public long G0() {
        return this.f8297c;
    }

    public boolean H0() {
        return this.f8298d;
    }

    public boolean I0() {
        return this.f8296b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 1, this.f8295a);
        a.c(parcel, 2, I0());
        a.o(parcel, 3, G0());
        a.c(parcel, 4, H0());
        a.b(parcel, a10);
    }
}
