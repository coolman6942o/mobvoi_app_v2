package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import b6.i;
import c6.a;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes.dex */
public final class CredentialRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<CredentialRequest> CREATOR = new d();

    /* renamed from: a  reason: collision with root package name */
    private final int f8342a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f8343b;

    /* renamed from: c  reason: collision with root package name */
    private final String[] f8344c;

    /* renamed from: d  reason: collision with root package name */
    private final CredentialPickerConfig f8345d;

    /* renamed from: e  reason: collision with root package name */
    private final CredentialPickerConfig f8346e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f8347f;

    /* renamed from: g  reason: collision with root package name */
    private final String f8348g;

    /* renamed from: h  reason: collision with root package name */
    private final String f8349h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f8350i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CredentialRequest(int i10, boolean z10, String[] strArr, CredentialPickerConfig credentialPickerConfig, CredentialPickerConfig credentialPickerConfig2, boolean z11, String str, String str2, boolean z12) {
        this.f8342a = i10;
        this.f8343b = z10;
        this.f8344c = (String[]) i.k(strArr);
        this.f8345d = credentialPickerConfig == null ? new CredentialPickerConfig.a().a() : credentialPickerConfig;
        this.f8346e = credentialPickerConfig2 == null ? new CredentialPickerConfig.a().a() : credentialPickerConfig2;
        if (i10 < 3) {
            this.f8347f = true;
            this.f8348g = null;
            this.f8349h = null;
        } else {
            this.f8347f = z11;
            this.f8348g = str;
            this.f8349h = str2;
        }
        this.f8350i = z12;
    }

    public final String[] G0() {
        return this.f8344c;
    }

    public final CredentialPickerConfig H0() {
        return this.f8346e;
    }

    public final CredentialPickerConfig I0() {
        return this.f8345d;
    }

    public final String J0() {
        return this.f8349h;
    }

    public final String K0() {
        return this.f8348g;
    }

    public final boolean L0() {
        return this.f8347f;
    }

    public final boolean M0() {
        return this.f8343b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.c(parcel, 1, M0());
        a.u(parcel, 2, G0(), false);
        a.r(parcel, 3, I0(), i10, false);
        a.r(parcel, 4, H0(), i10, false);
        a.c(parcel, 5, L0());
        a.t(parcel, 6, K0(), false);
        a.t(parcel, 7, J0(), false);
        a.l(parcel, 1000, this.f8342a);
        a.c(parcel, 8, this.f8350i);
        a.b(parcel, a10);
    }
}
