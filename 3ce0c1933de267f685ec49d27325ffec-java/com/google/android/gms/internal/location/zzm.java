package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import b6.h;
import c6.a;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.location.zzj;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class zzm extends AbstractSafeParcelable {

    /* renamed from: a  reason: collision with root package name */
    private zzj f9142a;

    /* renamed from: b  reason: collision with root package name */
    private List<ClientIdentity> f9143b;

    /* renamed from: c  reason: collision with root package name */
    private String f9144c;

    /* renamed from: d  reason: collision with root package name */
    static final List<ClientIdentity> f9140d = Collections.emptyList();

    /* renamed from: e  reason: collision with root package name */
    static final zzj f9141e = new zzj();
    public static final Parcelable.Creator<zzm> CREATOR = new w();

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzm(zzj zzjVar, List<ClientIdentity> list, String str) {
        this.f9142a = zzjVar;
        this.f9143b = list;
        this.f9144c = str;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzm)) {
            return false;
        }
        zzm zzmVar = (zzm) obj;
        return h.a(this.f9142a, zzmVar.f9142a) && h.a(this.f9143b, zzmVar.f9143b) && h.a(this.f9144c, zzmVar.f9144c);
    }

    public final int hashCode() {
        return this.f9142a.hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.r(parcel, 1, this.f9142a, i10, false);
        a.x(parcel, 2, this.f9143b, false);
        a.t(parcel, 3, this.f9144c, false);
        a.b(parcel, a10);
    }
}
