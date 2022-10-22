package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable;
import b6.i;
import c6.a;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes.dex */
public class SignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<SignInAccount> CREATOR = new e();
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    private String f8412a;

    /* renamed from: b  reason: collision with root package name */
    private GoogleSignInAccount f8413b;
    @Deprecated

    /* renamed from: c  reason: collision with root package name */
    private String f8414c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SignInAccount(String str, GoogleSignInAccount googleSignInAccount, String str2) {
        this.f8413b = googleSignInAccount;
        this.f8412a = i.h(str, "8.3 and 8.4 SDKs require non-null email");
        this.f8414c = i.h(str2, "8.3 and 8.4 SDKs require non-null userId");
    }

    public final GoogleSignInAccount W() {
        return this.f8413b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.t(parcel, 4, this.f8412a, false);
        a.r(parcel, 7, this.f8413b, i10, false);
        a.t(parcel, 8, this.f8414c, false);
        a.b(parcel, a10);
    }
}
