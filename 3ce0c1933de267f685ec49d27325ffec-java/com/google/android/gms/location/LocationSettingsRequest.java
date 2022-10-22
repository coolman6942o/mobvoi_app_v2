package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class LocationSettingsRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<LocationSettingsRequest> CREATOR = new f();

    /* renamed from: a  reason: collision with root package name */
    private final List<LocationRequest> f9939a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f9940b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f9941c;

    /* renamed from: d  reason: collision with root package name */
    private zzae f9942d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocationSettingsRequest(List<LocationRequest> list, boolean z10, boolean z11, zzae zzaeVar) {
        this.f9939a = list;
        this.f9940b = z10;
        this.f9941c = z11;
        this.f9942d = zzaeVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.x(parcel, 1, Collections.unmodifiableList(this.f9939a), false);
        a.c(parcel, 2, this.f9940b);
        a.c(parcel, 3, this.f9941c);
        a.r(parcel, 5, this.f9942d, i10, false);
        a.b(parcel, a10);
    }
}
