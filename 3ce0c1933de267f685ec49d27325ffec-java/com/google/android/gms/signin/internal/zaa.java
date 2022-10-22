package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.h;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes.dex */
public final class zaa extends AbstractSafeParcelable implements h {
    public static final Parcelable.Creator<zaa> CREATOR = new b();

    /* renamed from: a  reason: collision with root package name */
    private final int f10141a;

    /* renamed from: b  reason: collision with root package name */
    private int f10142b;

    /* renamed from: c  reason: collision with root package name */
    private Intent f10143c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zaa(int i10, int i11, Intent intent) {
        this.f10141a = i10;
        this.f10142b = i11;
        this.f10143c = intent;
    }

    @Override // com.google.android.gms.common.api.h
    public final Status getStatus() {
        if (this.f10142b == 0) {
            return Status.f8444e;
        }
        return Status.f8447h;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 1, this.f10141a);
        a.l(parcel, 2, this.f10142b);
        a.r(parcel, 3, this.f10143c, i10, false);
        a.b(parcel, a10);
    }

    public zaa() {
        this(0, null);
    }

    private zaa(int i10, Intent intent) {
        this(2, 0, null);
    }
}
