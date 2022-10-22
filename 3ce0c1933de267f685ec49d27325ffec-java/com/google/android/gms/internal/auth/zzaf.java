package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable;
import b6.i;
import c6.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes.dex */
public final class zzaf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaf> CREATOR = new c();

    /* renamed from: a  reason: collision with root package name */
    private final int f9089a = 1;

    /* renamed from: b  reason: collision with root package name */
    private final String f9090b;

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f9091c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaf(int i10, String str, byte[] bArr) {
        this.f9090b = (String) i.k(str);
        this.f9091c = (byte[]) i.k(bArr);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 1, this.f9089a);
        a.t(parcel, 2, this.f9090b, false);
        a.f(parcel, 3, this.f9091c, false);
        a.b(parcel, a10);
    }
}
