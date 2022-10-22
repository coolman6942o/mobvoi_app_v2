package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import c6.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes.dex */
public class AccountChangeEventsRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AccountChangeEventsRequest> CREATOR = new b();

    /* renamed from: a  reason: collision with root package name */
    private final int f8282a;

    /* renamed from: b  reason: collision with root package name */
    private int f8283b;
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    private String f8284c;

    /* renamed from: d  reason: collision with root package name */
    private Account f8285d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AccountChangeEventsRequest(int i10, int i11, String str, Account account) {
        this.f8282a = i10;
        this.f8283b = i11;
        this.f8284c = str;
        if (account != null || TextUtils.isEmpty(str)) {
            this.f8285d = account;
        } else {
            this.f8285d = new Account(str, "com.google");
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 1, this.f8282a);
        a.l(parcel, 2, this.f8283b);
        a.t(parcel, 3, this.f8284c, false);
        a.r(parcel, 4, this.f8285d, i10, false);
        a.b(parcel, a10);
    }

    public AccountChangeEventsRequest() {
        this.f8282a = 1;
    }
}
