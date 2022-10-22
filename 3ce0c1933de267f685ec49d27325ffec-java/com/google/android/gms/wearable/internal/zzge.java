package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import c7.p0;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;
/* loaded from: classes.dex */
public final class zzge extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzge> CREATOR = new p0();

    /* renamed from: a  reason: collision with root package name */
    private final int f10295a;

    /* renamed from: b  reason: collision with root package name */
    private final long f10296b;

    /* renamed from: c  reason: collision with root package name */
    private final List<zzfs> f10297c;

    public zzge(int i10, long j10, List<zzfs> list) {
        this.f10295a = i10;
        this.f10296b = j10;
        this.f10297c = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 2, this.f10295a);
        a.o(parcel, 3, this.f10296b);
        a.x(parcel, 4, this.f10297c, false);
        a.b(parcel, a10);
    }
}
