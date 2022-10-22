package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import b6.i;
import c6.a;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes.dex */
public final class HintRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<HintRequest> CREATOR = new e();

    /* renamed from: a  reason: collision with root package name */
    private final int f8351a;

    /* renamed from: b  reason: collision with root package name */
    private final CredentialPickerConfig f8352b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f8353c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f8354d;

    /* renamed from: e  reason: collision with root package name */
    private final String[] f8355e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f8356f;

    /* renamed from: g  reason: collision with root package name */
    private final String f8357g;

    /* renamed from: h  reason: collision with root package name */
    private final String f8358h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HintRequest(int i10, CredentialPickerConfig credentialPickerConfig, boolean z10, boolean z11, String[] strArr, boolean z12, String str, String str2) {
        this.f8351a = i10;
        this.f8352b = (CredentialPickerConfig) i.k(credentialPickerConfig);
        this.f8353c = z10;
        this.f8354d = z11;
        this.f8355e = (String[]) i.k(strArr);
        if (i10 < 2) {
            this.f8356f = true;
            this.f8357g = null;
            this.f8358h = null;
            return;
        }
        this.f8356f = z12;
        this.f8357g = str;
        this.f8358h = str2;
    }

    public final String[] G0() {
        return this.f8355e;
    }

    public final CredentialPickerConfig H0() {
        return this.f8352b;
    }

    public final String I0() {
        return this.f8358h;
    }

    public final String J0() {
        return this.f8357g;
    }

    public final boolean K0() {
        return this.f8353c;
    }

    public final boolean L0() {
        return this.f8356f;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.r(parcel, 1, H0(), i10, false);
        a.c(parcel, 2, K0());
        a.c(parcel, 3, this.f8354d);
        a.u(parcel, 4, G0(), false);
        a.c(parcel, 5, L0());
        a.t(parcel, 6, J0(), false);
        a.t(parcel, 7, I0(), false);
        a.l(parcel, 1000, this.f8351a);
        a.b(parcel, a10);
    }
}
