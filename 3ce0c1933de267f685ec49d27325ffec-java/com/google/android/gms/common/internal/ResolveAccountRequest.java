package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes.dex */
public class ResolveAccountRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ResolveAccountRequest> CREATOR = new o();

    /* renamed from: a  reason: collision with root package name */
    private final int f8881a;

    /* renamed from: b  reason: collision with root package name */
    private final Account f8882b;

    /* renamed from: c  reason: collision with root package name */
    private final int f8883c;

    /* renamed from: d  reason: collision with root package name */
    private final GoogleSignInAccount f8884d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ResolveAccountRequest(int i10, Account account, int i11, GoogleSignInAccount googleSignInAccount) {
        this.f8881a = i10;
        this.f8882b = account;
        this.f8883c = i11;
        this.f8884d = googleSignInAccount;
    }

    public int G0() {
        return this.f8883c;
    }

    public GoogleSignInAccount H0() {
        return this.f8884d;
    }

    public Account o() {
        return this.f8882b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 1, this.f8881a);
        a.r(parcel, 2, o(), i10, false);
        a.l(parcel, 3, G0());
        a.r(parcel, 4, H0(), i10, false);
        a.b(parcel, a10);
    }

    public ResolveAccountRequest(Account account, int i10, GoogleSignInAccount googleSignInAccount) {
        this(2, account, i10, googleSignInAccount);
    }
}
