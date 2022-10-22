package com.google.android.gms.common.server;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import f6.a;
/* loaded from: classes.dex */
public class FavaDiagnosticsEntity extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<FavaDiagnosticsEntity> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final int f8982a;

    /* renamed from: b  reason: collision with root package name */
    private final String f8983b;

    /* renamed from: c  reason: collision with root package name */
    private final int f8984c;

    public FavaDiagnosticsEntity(int i10, String str, int i11) {
        this.f8982a = i10;
        this.f8983b = str;
        this.f8984c = i11;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int a10 = c6.a.a(parcel);
        c6.a.l(parcel, 1, this.f8982a);
        c6.a.t(parcel, 2, this.f8983b, false);
        c6.a.l(parcel, 3, this.f8984c);
        c6.a.b(parcel, a10);
    }
}
