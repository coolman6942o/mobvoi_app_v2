package com.google.android.gms.internal.auth;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import b6.i;
import c6.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes.dex */
public final class zzah extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzah> CREATOR = new d();

    /* renamed from: a  reason: collision with root package name */
    private final int f9092a = 1;

    /* renamed from: b  reason: collision with root package name */
    private final String f9093b;

    /* renamed from: c  reason: collision with root package name */
    private final PendingIntent f9094c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzah(int i10, String str, PendingIntent pendingIntent) {
        this.f9093b = (String) i.k(str);
        this.f9094c = (PendingIntent) i.k(pendingIntent);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 1, this.f9092a);
        a.t(parcel, 2, this.f9093b, false);
        a.r(parcel, 3, this.f9094c, i10, false);
        a.b(parcel, a10);
    }
}
