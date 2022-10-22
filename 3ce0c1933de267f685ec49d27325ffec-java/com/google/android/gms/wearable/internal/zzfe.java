package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import c7.e0;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.wearable.i;
import com.mobvoi.wear.lpa.LpaConstants;
/* loaded from: classes.dex */
public final class zzfe extends AbstractSafeParcelable implements i {
    public static final Parcelable.Creator<zzfe> CREATOR = new e0();

    /* renamed from: a  reason: collision with root package name */
    private final int f10275a;

    /* renamed from: b  reason: collision with root package name */
    private final String f10276b;

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f10277c;

    /* renamed from: d  reason: collision with root package name */
    private final String f10278d;

    public zzfe(int i10, String str, byte[] bArr, String str2) {
        this.f10275a = i10;
        this.f10276b = str;
        this.f10277c = bArr;
        this.f10278d = str2;
    }

    public final int G0() {
        return this.f10275a;
    }

    @Override // com.google.android.gms.wearable.i
    public final String a() {
        return this.f10276b;
    }

    @Override // com.google.android.gms.wearable.i
    public final byte[] c() {
        return this.f10277c;
    }

    public final String toString() {
        int i10 = this.f10275a;
        String str = this.f10276b;
        byte[] bArr = this.f10277c;
        String valueOf = String.valueOf(bArr == null ? LpaConstants.VALUE_NULL : Integer.valueOf(bArr.length));
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 43 + valueOf.length());
        sb2.append("MessageEventParcelable[");
        sb2.append(i10);
        sb2.append(",");
        sb2.append(str);
        sb2.append(", size=");
        sb2.append(valueOf);
        sb2.append("]");
        return sb2.toString();
    }

    @Override // com.google.android.gms.wearable.i
    public final String u() {
        return this.f10278d;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 2, G0());
        a.t(parcel, 3, a(), false);
        a.f(parcel, 4, c(), false);
        a.t(parcel, 5, u(), false);
        a.b(parcel, a10);
    }
}
