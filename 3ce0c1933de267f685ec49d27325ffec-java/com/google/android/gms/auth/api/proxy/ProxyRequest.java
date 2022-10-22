package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes.dex */
public class ProxyRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ProxyRequest> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final int f8361a;

    /* renamed from: b  reason: collision with root package name */
    public final String f8362b;

    /* renamed from: c  reason: collision with root package name */
    public final int f8363c;

    /* renamed from: d  reason: collision with root package name */
    public final long f8364d;

    /* renamed from: e  reason: collision with root package name */
    public final byte[] f8365e;

    /* renamed from: f  reason: collision with root package name */
    private Bundle f8366f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProxyRequest(int i10, String str, int i11, long j10, byte[] bArr, Bundle bundle) {
        this.f8361a = i10;
        this.f8362b = str;
        this.f8363c = i11;
        this.f8364d = j10;
        this.f8365e = bArr;
        this.f8366f = bundle;
    }

    public String toString() {
        String str = this.f8362b;
        int i10 = this.f8363c;
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 42);
        sb2.append("ProxyRequest[ url: ");
        sb2.append(str);
        sb2.append(", method: ");
        sb2.append(i10);
        sb2.append(" ]");
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.t(parcel, 1, this.f8362b, false);
        a.l(parcel, 2, this.f8363c);
        a.o(parcel, 3, this.f8364d);
        a.f(parcel, 4, this.f8365e, false);
        a.d(parcel, 5, this.f8366f, false);
        a.l(parcel, 1000, this.f8361a);
        a.b(parcel, a10);
    }
}
