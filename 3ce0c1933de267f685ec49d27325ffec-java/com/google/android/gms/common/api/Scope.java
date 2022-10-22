package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import b6.i;
import c6.a;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes.dex */
public final class Scope extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new m();

    /* renamed from: a  reason: collision with root package name */
    private final int f8442a;

    /* renamed from: b  reason: collision with root package name */
    private final String f8443b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Scope(int i10, String str) {
        i.h(str, "scopeUri must not be null or empty");
        this.f8442a = i10;
        this.f8443b = str;
    }

    public final String G0() {
        return this.f8443b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scope)) {
            return false;
        }
        return this.f8443b.equals(((Scope) obj).f8443b);
    }

    public final int hashCode() {
        return this.f8443b.hashCode();
    }

    public final String toString() {
        return this.f8443b;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 1, this.f8442a);
        a.t(parcel, 2, G0(), false);
        a.b(parcel, a10);
    }

    public Scope(String str) {
        this(1, str);
    }
}
