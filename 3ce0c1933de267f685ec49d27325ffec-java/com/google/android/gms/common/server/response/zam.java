package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
/* loaded from: classes.dex */
public final class zam extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zam> CREATOR = new b();

    /* renamed from: a  reason: collision with root package name */
    private final int f9017a;

    /* renamed from: b  reason: collision with root package name */
    final String f9018b;

    /* renamed from: c  reason: collision with root package name */
    final FastJsonResponse.Field<?, ?> f9019c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zam(int i10, String str, FastJsonResponse.Field<?, ?> field) {
        this.f9017a = i10;
        this.f9018b = str;
        this.f9019c = field;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 1, this.f9017a);
        a.t(parcel, 2, this.f9018b, false);
        a.r(parcel, 3, this.f9019c, i10, false);
        a.b(parcel, a10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zam(String str, FastJsonResponse.Field<?, ?> field) {
        this.f9017a = 1;
        this.f9018b = str;
        this.f9019c = field;
    }
}
