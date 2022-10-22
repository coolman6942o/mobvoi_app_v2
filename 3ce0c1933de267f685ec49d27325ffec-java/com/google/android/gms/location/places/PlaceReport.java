package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import b6.h;
import c6.a;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.mobvoi.wear.util.TelephonyUtil;
/* loaded from: classes.dex */
public class PlaceReport extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<PlaceReport> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final int f9956a;

    /* renamed from: b  reason: collision with root package name */
    private final String f9957b;

    /* renamed from: c  reason: collision with root package name */
    private final String f9958c;

    /* renamed from: d  reason: collision with root package name */
    private final String f9959d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PlaceReport(int i10, String str, String str2, String str3) {
        this.f9956a = i10;
        this.f9957b = str;
        this.f9958c = str2;
        this.f9959d = str3;
    }

    public String G0() {
        return this.f9957b;
    }

    public String H0() {
        return this.f9958c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlaceReport)) {
            return false;
        }
        PlaceReport placeReport = (PlaceReport) obj;
        return h.a(this.f9957b, placeReport.f9957b) && h.a(this.f9958c, placeReport.f9958c) && h.a(this.f9959d, placeReport.f9959d);
    }

    public int hashCode() {
        return h.b(this.f9957b, this.f9958c, this.f9959d);
    }

    public String toString() {
        h.a c10 = h.c(this);
        c10.a("placeId", this.f9957b);
        c10.a("tag", this.f9958c);
        if (!"unknown".equals(this.f9959d)) {
            c10.a(TelephonyUtil.KEY_SIM_ACTIVITIED_SOURCE, this.f9959d);
        }
        return c10.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 1, this.f9956a);
        a.t(parcel, 2, G0(), false);
        a.t(parcel, 3, H0(), false);
        a.t(parcel, 4, this.f9959d, false);
        a.b(parcel, a10);
    }
}
