package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import z6.q;
/* loaded from: classes.dex */
public final class Tile extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Tile> CREATOR = new q();

    /* renamed from: a  reason: collision with root package name */
    public final int f10116a;

    /* renamed from: b  reason: collision with root package name */
    public final int f10117b;

    /* renamed from: c  reason: collision with root package name */
    public final byte[] f10118c;

    public Tile(int i10, int i11, byte[] bArr) {
        this.f10116a = i10;
        this.f10117b = i11;
        this.f10118c = bArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 2, this.f10116a);
        a.l(parcel, 3, this.f10117b);
        a.f(parcel, 4, this.f10118c, false);
        a.b(parcel, a10);
    }
}
