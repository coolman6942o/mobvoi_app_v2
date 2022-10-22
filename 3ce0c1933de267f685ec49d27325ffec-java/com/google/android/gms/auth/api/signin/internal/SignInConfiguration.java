package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import b6.i;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import x5.a;
import x5.h;
/* loaded from: classes.dex */
public final class SignInConfiguration extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<SignInConfiguration> CREATOR = new h();

    /* renamed from: a  reason: collision with root package name */
    private final String f8419a;

    /* renamed from: b  reason: collision with root package name */
    private GoogleSignInOptions f8420b;

    public SignInConfiguration(String str, GoogleSignInOptions googleSignInOptions) {
        this.f8419a = i.g(str);
        this.f8420b = googleSignInOptions;
    }

    public final GoogleSignInOptions G0() {
        return this.f8420b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof SignInConfiguration)) {
            return false;
        }
        SignInConfiguration signInConfiguration = (SignInConfiguration) obj;
        if (this.f8419a.equals(signInConfiguration.f8419a)) {
            GoogleSignInOptions googleSignInOptions = this.f8420b;
            if (googleSignInOptions == null) {
                if (signInConfiguration.f8420b == null) {
                    return true;
                }
            } else if (googleSignInOptions.equals(signInConfiguration.f8420b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return new a().a(this.f8419a).a(this.f8420b).b();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = c6.a.a(parcel);
        c6.a.t(parcel, 2, this.f8419a, false);
        c6.a.r(parcel, 5, this.f8420b, i10, false);
        c6.a.b(parcel, a10);
    }
}
