package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import t6.a;
/* loaded from: classes.dex */
public final class zzad extends AbstractSafeParcelable implements h {
    public static final Parcelable.Creator<zzad> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final Status f9116a;

    static {
        new zzad(Status.f8444e);
    }

    public zzad(Status status) {
        this.f9116a = status;
    }

    @Override // com.google.android.gms.common.api.h
    public final Status getStatus() {
        return this.f9116a;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = c6.a.a(parcel);
        c6.a.r(parcel, 1, getStatus(), i10, false);
        c6.a.b(parcel, a10);
    }
}
