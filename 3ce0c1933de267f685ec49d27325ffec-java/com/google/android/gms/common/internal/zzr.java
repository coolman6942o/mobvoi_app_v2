package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
@Deprecated
/* loaded from: classes.dex */
public final class zzr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzr> CREATOR = new d0();

    /* renamed from: a  reason: collision with root package name */
    private final int f8971a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzr(int i10) {
        this.f8971a = i10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 1, this.f8971a);
        a.b(parcel, a10);
    }
}
