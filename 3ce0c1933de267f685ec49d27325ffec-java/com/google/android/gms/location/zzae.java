package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes.dex */
public final class zzae extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzae> CREATOR = new e();

    /* renamed from: a  reason: collision with root package name */
    private final String f9960a;

    /* renamed from: b  reason: collision with root package name */
    private final String f9961b;

    /* renamed from: c  reason: collision with root package name */
    private final String f9962c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzae(String str, String str2, String str3) {
        this.f9962c = str;
        this.f9960a = str2;
        this.f9961b = str3;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.t(parcel, 1, this.f9960a, false);
        a.t(parcel, 2, this.f9961b, false);
        a.t(parcel, 5, this.f9962c, false);
        a.b(parcel, a10);
    }
}
