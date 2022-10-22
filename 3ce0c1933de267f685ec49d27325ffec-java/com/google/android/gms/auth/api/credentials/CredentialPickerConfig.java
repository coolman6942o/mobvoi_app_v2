package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes.dex */
public final class CredentialPickerConfig extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<CredentialPickerConfig> CREATOR = new c();

    /* renamed from: a  reason: collision with root package name */
    private final int f8335a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f8336b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f8337c;

    /* renamed from: d  reason: collision with root package name */
    private final int f8338d;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private boolean f8339a = false;

        /* renamed from: b  reason: collision with root package name */
        private boolean f8340b = true;

        /* renamed from: c  reason: collision with root package name */
        private int f8341c = 1;

        public CredentialPickerConfig a() {
            return new CredentialPickerConfig(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CredentialPickerConfig(int i10, boolean z10, boolean z11, boolean z12, int i11) {
        this.f8335a = i10;
        this.f8336b = z10;
        this.f8337c = z11;
        if (i10 < 2) {
            this.f8338d = z12 ? 3 : 1;
        } else {
            this.f8338d = i11;
        }
    }

    @Deprecated
    public final boolean G0() {
        return this.f8338d == 3;
    }

    public final boolean H0() {
        return this.f8336b;
    }

    public final boolean I0() {
        return this.f8337c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = c6.a.a(parcel);
        c6.a.c(parcel, 1, H0());
        c6.a.c(parcel, 2, I0());
        c6.a.c(parcel, 3, G0());
        c6.a.l(parcel, 4, this.f8338d);
        c6.a.l(parcel, 1000, this.f8335a);
        c6.a.b(parcel, a10);
    }

    private CredentialPickerConfig(a aVar) {
        this(2, aVar.f8339a, aVar.f8340b, false, aVar.f8341c);
    }
}
