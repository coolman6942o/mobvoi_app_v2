package com.google.android.gms.internal.auth;

import android.os.Parcel;
import android.os.Parcelable;
import b6.i;
import c6.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes.dex */
public final class zzab extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzab> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final int f9084a = 1;

    /* renamed from: b  reason: collision with root package name */
    private final String f9085b;

    /* renamed from: c  reason: collision with root package name */
    private final int f9086c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzab(int i10, String str, int i11) {
        this.f9085b = (String) i.k(str);
        this.f9086c = i11;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 1, this.f9084a);
        a.t(parcel, 2, this.f9085b, false);
        a.l(parcel, 3, this.f9086c);
        a.b(parcel, a10);
    }
}
