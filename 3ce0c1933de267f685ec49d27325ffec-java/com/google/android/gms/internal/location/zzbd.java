package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import b6.h;
import c6.a;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.location.LocationRequest;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class zzbd extends AbstractSafeParcelable {

    /* renamed from: a  reason: collision with root package name */
    private LocationRequest f9118a;

    /* renamed from: b  reason: collision with root package name */
    private List<ClientIdentity> f9119b;

    /* renamed from: c  reason: collision with root package name */
    private String f9120c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f9121d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f9122e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f9123f;

    /* renamed from: g  reason: collision with root package name */
    private String f9124g;

    /* renamed from: h  reason: collision with root package name */
    static final List<ClientIdentity> f9117h = Collections.emptyList();
    public static final Parcelable.Creator<zzbd> CREATOR = new r();

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbd(LocationRequest locationRequest, List<ClientIdentity> list, String str, boolean z10, boolean z11, boolean z12, String str2) {
        this.f9118a = locationRequest;
        this.f9119b = list;
        this.f9120c = str;
        this.f9121d = z10;
        this.f9122e = z11;
        this.f9123f = z12;
        this.f9124g = str2;
    }

    @Deprecated
    public static zzbd G0(LocationRequest locationRequest) {
        return new zzbd(locationRequest, f9117h, null, false, false, false, null);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzbd)) {
            return false;
        }
        zzbd zzbdVar = (zzbd) obj;
        return h.a(this.f9118a, zzbdVar.f9118a) && h.a(this.f9119b, zzbdVar.f9119b) && h.a(this.f9120c, zzbdVar.f9120c) && this.f9121d == zzbdVar.f9121d && this.f9122e == zzbdVar.f9122e && this.f9123f == zzbdVar.f9123f && h.a(this.f9124g, zzbdVar.f9124g);
    }

    public final int hashCode() {
        return this.f9118a.hashCode();
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f9118a);
        if (this.f9120c != null) {
            sb2.append(" tag=");
            sb2.append(this.f9120c);
        }
        if (this.f9124g != null) {
            sb2.append(" moduleId=");
            sb2.append(this.f9124g);
        }
        sb2.append(" hideAppOps=");
        sb2.append(this.f9121d);
        sb2.append(" clients=");
        sb2.append(this.f9119b);
        sb2.append(" forceCoarseLocation=");
        sb2.append(this.f9122e);
        if (this.f9123f) {
            sb2.append(" exemptFromBackgroundThrottle");
        }
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.r(parcel, 1, this.f9118a, i10, false);
        a.x(parcel, 5, this.f9119b, false);
        a.t(parcel, 6, this.f9120c, false);
        a.c(parcel, 7, this.f9121d);
        a.c(parcel, 8, this.f9122e);
        a.c(parcel, 9, this.f9123f);
        a.t(parcel, 10, this.f9124g, false);
        a.b(parcel, a10);
    }
}
