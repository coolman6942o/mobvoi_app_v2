package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import c7.v;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes.dex */
public final class zzdt extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdt> CREATOR = new v();

    /* renamed from: a  reason: collision with root package name */
    private final int f10257a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f10258b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f10259c;

    public zzdt(int i10, boolean z10, boolean z11) {
        this.f10257a = i10;
        this.f10258b = z10;
        this.f10259c = z11;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 2, this.f10257a);
        a.c(parcel, 3, this.f10258b);
        a.c(parcel, 4, this.f10259c);
        a.b(parcel, a10);
    }
}
