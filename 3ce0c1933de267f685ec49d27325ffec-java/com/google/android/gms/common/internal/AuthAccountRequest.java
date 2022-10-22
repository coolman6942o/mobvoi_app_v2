package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes.dex */
public class AuthAccountRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AuthAccountRequest> CREATOR = new l();

    /* renamed from: a  reason: collision with root package name */
    private final int f8861a;
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    private final IBinder f8862b;

    /* renamed from: c  reason: collision with root package name */
    private final Scope[] f8863c;

    /* renamed from: d  reason: collision with root package name */
    private Integer f8864d;

    /* renamed from: e  reason: collision with root package name */
    private Integer f8865e;

    /* renamed from: f  reason: collision with root package name */
    private Account f8866f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AuthAccountRequest(int i10, IBinder iBinder, Scope[] scopeArr, Integer num, Integer num2, Account account) {
        this.f8861a = i10;
        this.f8862b = iBinder;
        this.f8863c = scopeArr;
        this.f8864d = num;
        this.f8865e = num2;
        this.f8866f = account;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 1, this.f8861a);
        a.k(parcel, 2, this.f8862b, false);
        a.w(parcel, 3, this.f8863c, i10, false);
        a.m(parcel, 4, this.f8864d, false);
        a.m(parcel, 5, this.f8865e, false);
        a.r(parcel, 6, this.f8866f, i10, false);
        a.b(parcel, a10);
    }
}
