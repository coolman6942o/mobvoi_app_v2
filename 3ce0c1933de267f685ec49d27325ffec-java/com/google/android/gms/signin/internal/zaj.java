package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes.dex */
public final class zaj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zaj> CREATOR = new i();

    /* renamed from: a  reason: collision with root package name */
    private final int f10146a;

    /* renamed from: b  reason: collision with root package name */
    private final ConnectionResult f10147b;

    /* renamed from: c  reason: collision with root package name */
    private final ResolveAccountResponse f10148c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zaj(int i10, ConnectionResult connectionResult, ResolveAccountResponse resolveAccountResponse) {
        this.f10146a = i10;
        this.f10147b = connectionResult;
        this.f10148c = resolveAccountResponse;
    }

    public final ConnectionResult G0() {
        return this.f10147b;
    }

    public final ResolveAccountResponse H0() {
        return this.f10148c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 1, this.f10146a);
        a.r(parcel, 2, this.f10147b, i10, false);
        a.r(parcel, 3, this.f10148c, i10, false);
        a.b(parcel, a10);
    }

    public zaj(int i10) {
        this(new ConnectionResult(8, null), null);
    }

    private zaj(ConnectionResult connectionResult, ResolveAccountResponse resolveAccountResponse) {
        this(1, connectionResult, null);
    }
}
