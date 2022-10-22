package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import c7.j0;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes.dex */
public final class zzfs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfs> CREATOR = new j0();

    /* renamed from: a  reason: collision with root package name */
    private final String f10285a;

    /* renamed from: b  reason: collision with root package name */
    private final String f10286b;

    /* renamed from: c  reason: collision with root package name */
    private final long f10287c;

    public zzfs(String str, String str2, long j10) {
        this.f10285a = str;
        this.f10286b = str2;
        this.f10287c = j10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.t(parcel, 2, this.f10285a, false);
        a.t(parcel, 3, this.f10286b, false);
        a.o(parcel, 4, this.f10287c);
        a.b(parcel, a10);
    }
}
