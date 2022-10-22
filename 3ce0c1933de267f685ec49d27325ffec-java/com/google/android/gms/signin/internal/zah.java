package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes.dex */
public final class zah extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zah> CREATOR = new h();

    /* renamed from: a  reason: collision with root package name */
    private final int f10144a;

    /* renamed from: b  reason: collision with root package name */
    private final ResolveAccountRequest f10145b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zah(int i10, ResolveAccountRequest resolveAccountRequest) {
        this.f10144a = i10;
        this.f10145b = resolveAccountRequest;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 1, this.f10144a);
        a.r(parcel, 2, this.f10145b, i10, false);
        a.b(parcel, a10);
    }

    public zah(ResolveAccountRequest resolveAccountRequest) {
        this(1, resolveAccountRequest);
    }
}
