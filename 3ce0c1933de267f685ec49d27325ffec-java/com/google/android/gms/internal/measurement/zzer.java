package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class zzer extends AbstractSafeParcelable implements Iterable<String> {
    public static final Parcelable.Creator<zzer> CREATOR = new n0();

    /* renamed from: a  reason: collision with root package name */
    private final Bundle f9887a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzer(Bundle bundle) {
        this.f9887a = bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object G0(String str) {
        return this.f9887a.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Long H0(String str) {
        return Long.valueOf(this.f9887a.getLong(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String I0(String str) {
        return this.f9887a.getString(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Double K0(String str) {
        return Double.valueOf(this.f9887a.getDouble(str));
    }

    public final Bundle L0() {
        return new Bundle(this.f9887a);
    }

    @Override // java.lang.Iterable
    public final Iterator<String> iterator() {
        return new m0(this);
    }

    public final int size() {
        return this.f9887a.size();
    }

    public final String toString() {
        return this.f9887a.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.d(parcel, 2, L0(), false);
        a.b(parcel, a10);
    }
}
