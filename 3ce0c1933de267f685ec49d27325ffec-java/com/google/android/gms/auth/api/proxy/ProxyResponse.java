package com.google.android.gms.auth.api.proxy;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes.dex */
public class ProxyResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ProxyResponse> CREATOR = new b();

    /* renamed from: a  reason: collision with root package name */
    private final int f8367a;

    /* renamed from: b  reason: collision with root package name */
    public final int f8368b;

    /* renamed from: c  reason: collision with root package name */
    public final PendingIntent f8369c;

    /* renamed from: d  reason: collision with root package name */
    public final int f8370d;

    /* renamed from: e  reason: collision with root package name */
    private final Bundle f8371e;

    /* renamed from: f  reason: collision with root package name */
    public final byte[] f8372f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProxyResponse(int i10, int i11, PendingIntent pendingIntent, int i12, Bundle bundle, byte[] bArr) {
        this.f8367a = i10;
        this.f8368b = i11;
        this.f8370d = i12;
        this.f8371e = bundle;
        this.f8372f = bArr;
        this.f8369c = pendingIntent;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 1, this.f8368b);
        a.r(parcel, 2, this.f8369c, i10, false);
        a.l(parcel, 3, this.f8370d);
        a.d(parcel, 4, this.f8371e, false);
        a.f(parcel, 5, this.f8372f, false);
        a.l(parcel, 1000, this.f8367a);
        a.b(parcel, a10);
    }
}
