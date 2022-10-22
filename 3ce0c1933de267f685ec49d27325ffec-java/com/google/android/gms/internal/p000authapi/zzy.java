package com.google.android.gms.internal.p000authapi;

import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import p6.g;
/* renamed from: com.google.android.gms.internal.auth-api.zzy  reason: invalid package */
/* loaded from: classes.dex */
public final class zzy extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzy> CREATOR = new g();

    /* renamed from: a  reason: collision with root package name */
    private final Credential f9083a;

    public zzy(Credential credential) {
        this.f9083a = credential;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.r(parcel, 1, this.f9083a, i10, false);
        a.b(parcel, a10);
    }
}
