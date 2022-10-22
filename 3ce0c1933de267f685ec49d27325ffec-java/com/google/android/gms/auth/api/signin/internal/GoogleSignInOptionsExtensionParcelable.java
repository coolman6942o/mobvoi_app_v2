package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes.dex */
public class GoogleSignInOptionsExtensionParcelable extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GoogleSignInOptionsExtensionParcelable> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final int f8416a;

    /* renamed from: b  reason: collision with root package name */
    private int f8417b;

    /* renamed from: c  reason: collision with root package name */
    private Bundle f8418c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GoogleSignInOptionsExtensionParcelable(int i10, int i11, Bundle bundle) {
        this.f8416a = i10;
        this.f8417b = i11;
        this.f8418c = bundle;
    }

    public int G0() {
        return this.f8417b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 1, this.f8416a);
        a.l(parcel, 2, G0());
        a.d(parcel, 3, this.f8418c, false);
        a.b(parcel, a10);
    }
}
