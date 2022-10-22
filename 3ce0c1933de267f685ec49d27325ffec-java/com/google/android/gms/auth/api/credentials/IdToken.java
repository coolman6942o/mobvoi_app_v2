package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import b6.h;
import b6.i;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import u5.a;
/* loaded from: classes.dex */
public final class IdToken extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<IdToken> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final String f8359a;

    /* renamed from: b  reason: collision with root package name */
    private final String f8360b;

    public IdToken(String str, String str2) {
        i.b(!TextUtils.isEmpty(str), "account type string cannot be null or empty");
        i.b(!TextUtils.isEmpty(str2), "id token string cannot be null or empty");
        this.f8359a = str;
        this.f8360b = str2;
    }

    public final String G0() {
        return this.f8359a;
    }

    public final String H0() {
        return this.f8360b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IdToken)) {
            return false;
        }
        IdToken idToken = (IdToken) obj;
        return h.a(this.f8359a, idToken.f8359a) && h.a(this.f8360b, idToken.f8360b);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = c6.a.a(parcel);
        c6.a.t(parcel, 1, G0(), false);
        c6.a.t(parcel, 2, H0(), false);
        c6.a.b(parcel, a10);
    }
}
