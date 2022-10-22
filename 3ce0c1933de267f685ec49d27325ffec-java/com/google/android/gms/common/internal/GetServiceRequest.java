package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.c;
import com.google.android.gms.common.internal.f;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes.dex */
public class GetServiceRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GetServiceRequest> CREATOR = new t();

    /* renamed from: a  reason: collision with root package name */
    private final int f8870a;

    /* renamed from: b  reason: collision with root package name */
    private final int f8871b;

    /* renamed from: c  reason: collision with root package name */
    private int f8872c;

    /* renamed from: d  reason: collision with root package name */
    String f8873d;

    /* renamed from: e  reason: collision with root package name */
    IBinder f8874e;

    /* renamed from: f  reason: collision with root package name */
    Scope[] f8875f;

    /* renamed from: g  reason: collision with root package name */
    Bundle f8876g;

    /* renamed from: h  reason: collision with root package name */
    Account f8877h;

    /* renamed from: i  reason: collision with root package name */
    Feature[] f8878i;

    /* renamed from: j  reason: collision with root package name */
    Feature[] f8879j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f8880k;

    public GetServiceRequest(int i10) {
        this.f8870a = 4;
        this.f8872c = c.f8812a;
        this.f8871b = i10;
        this.f8880k = true;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 1, this.f8870a);
        a.l(parcel, 2, this.f8871b);
        a.l(parcel, 3, this.f8872c);
        a.t(parcel, 4, this.f8873d, false);
        a.k(parcel, 5, this.f8874e, false);
        a.w(parcel, 6, this.f8875f, i10, false);
        a.d(parcel, 7, this.f8876g, false);
        a.r(parcel, 8, this.f8877h, i10, false);
        a.w(parcel, 10, this.f8878i, i10, false);
        a.w(parcel, 11, this.f8879j, i10, false);
        a.c(parcel, 12, this.f8880k);
        a.b(parcel, a10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GetServiceRequest(int i10, int i11, int i12, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, Feature[] featureArr, Feature[] featureArr2, boolean z10) {
        this.f8870a = i10;
        this.f8871b = i11;
        this.f8872c = i12;
        if ("com.google.android.gms".equals(str)) {
            this.f8873d = "com.google.android.gms";
        } else {
            this.f8873d = str;
        }
        if (i10 < 2) {
            this.f8877h = iBinder != null ? a.U1(f.a.m1(iBinder)) : null;
        } else {
            this.f8874e = iBinder;
            this.f8877h = account;
        }
        this.f8875f = scopeArr;
        this.f8876g = bundle;
        this.f8878i = featureArr;
        this.f8879j = featureArr2;
        this.f8880k = z10;
    }
}
