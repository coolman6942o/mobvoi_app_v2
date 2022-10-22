package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes.dex */
public class ResolveAccountResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ResolveAccountResponse> CREATOR = new p();

    /* renamed from: a  reason: collision with root package name */
    private final int f8885a;

    /* renamed from: b  reason: collision with root package name */
    private IBinder f8886b;

    /* renamed from: c  reason: collision with root package name */
    private ConnectionResult f8887c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f8888d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f8889e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResolveAccountResponse(int i10, IBinder iBinder, ConnectionResult connectionResult, boolean z10, boolean z11) {
        this.f8885a = i10;
        this.f8886b = iBinder;
        this.f8887c = connectionResult;
        this.f8888d = z10;
        this.f8889e = z11;
    }

    public f G0() {
        return f.a.m1(this.f8886b);
    }

    public ConnectionResult H0() {
        return this.f8887c;
    }

    public boolean I0() {
        return this.f8888d;
    }

    public boolean J0() {
        return this.f8889e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResolveAccountResponse)) {
            return false;
        }
        ResolveAccountResponse resolveAccountResponse = (ResolveAccountResponse) obj;
        return this.f8887c.equals(resolveAccountResponse.f8887c) && G0().equals(resolveAccountResponse.G0());
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 1, this.f8885a);
        a.k(parcel, 2, this.f8886b, false);
        a.r(parcel, 3, H0(), i10, false);
        a.c(parcel, 4, I0());
        a.c(parcel, 5, J0());
        a.b(parcel, a10);
    }
}
