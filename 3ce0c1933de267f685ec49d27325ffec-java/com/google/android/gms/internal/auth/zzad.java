package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable;
import b6.i;
import c6.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes.dex */
public final class zzad extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzad> CREATOR = new b();

    /* renamed from: a  reason: collision with root package name */
    private final int f9087a = 1;

    /* renamed from: b  reason: collision with root package name */
    private final String f9088b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzad(int i10, String str) {
        this.f9088b = (String) i.k(str);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 1, this.f9087a);
        a.t(parcel, 2, this.f9088b, false);
        a.b(parcel, a10);
    }
}
