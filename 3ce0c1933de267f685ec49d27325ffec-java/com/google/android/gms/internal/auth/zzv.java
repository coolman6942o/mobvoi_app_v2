package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable;
import b6.i;
import c6.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes.dex */
public final class zzv extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzv> CREATOR = new e();

    /* renamed from: a  reason: collision with root package name */
    private final int f9095a = 1;

    /* renamed from: b  reason: collision with root package name */
    private final String f9096b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzv(int i10, String str) {
        this.f9096b = (String) i.k(str);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 1, this.f9095a);
        a.t(parcel, 2, this.f9096b, false);
        a.b(parcel, a10);
    }
}
