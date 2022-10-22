package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes.dex */
public class SignInButtonConfig extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SignInButtonConfig> CREATOR = new q();

    /* renamed from: a  reason: collision with root package name */
    private final int f8890a;

    /* renamed from: b  reason: collision with root package name */
    private final int f8891b;

    /* renamed from: c  reason: collision with root package name */
    private final int f8892c;
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    private final Scope[] f8893d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SignInButtonConfig(int i10, int i11, int i12, Scope[] scopeArr) {
        this.f8890a = i10;
        this.f8891b = i11;
        this.f8892c = i12;
        this.f8893d = scopeArr;
    }

    public int G0() {
        return this.f8891b;
    }

    public int H0() {
        return this.f8892c;
    }

    @Deprecated
    public Scope[] I0() {
        return this.f8893d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 1, this.f8890a);
        a.l(parcel, 2, G0());
        a.l(parcel, 3, H0());
        a.w(parcel, 4, I0(), i10, false);
        a.b(parcel, a10);
    }
}
