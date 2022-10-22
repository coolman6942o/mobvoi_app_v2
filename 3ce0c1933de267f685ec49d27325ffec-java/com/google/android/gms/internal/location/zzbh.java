package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Locale;
import t6.c;
/* loaded from: classes.dex */
public final class zzbh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbh> CREATOR = new c();

    /* renamed from: a  reason: collision with root package name */
    private final String f9131a;

    /* renamed from: b  reason: collision with root package name */
    private final long f9132b;

    /* renamed from: c  reason: collision with root package name */
    private final short f9133c;

    /* renamed from: d  reason: collision with root package name */
    private final double f9134d;

    /* renamed from: e  reason: collision with root package name */
    private final double f9135e;

    /* renamed from: f  reason: collision with root package name */
    private final float f9136f;

    /* renamed from: g  reason: collision with root package name */
    private final int f9137g;

    /* renamed from: h  reason: collision with root package name */
    private final int f9138h;

    /* renamed from: i  reason: collision with root package name */
    private final int f9139i;

    public zzbh(String str, int i10, short s10, double d10, double d11, float f10, long j10, int i11, int i12) {
        if (str == null || str.length() > 100) {
            String valueOf = String.valueOf(str);
            throw new IllegalArgumentException(valueOf.length() != 0 ? "requestId is null or too long: ".concat(valueOf) : new String("requestId is null or too long: "));
        } else if (f10 <= 0.0f) {
            StringBuilder sb2 = new StringBuilder(31);
            sb2.append("invalid radius: ");
            sb2.append(f10);
            throw new IllegalArgumentException(sb2.toString());
        } else if (d10 > 90.0d || d10 < -90.0d) {
            StringBuilder sb3 = new StringBuilder(42);
            sb3.append("invalid latitude: ");
            sb3.append(d10);
            throw new IllegalArgumentException(sb3.toString());
        } else if (d11 > 180.0d || d11 < -180.0d) {
            StringBuilder sb4 = new StringBuilder(43);
            sb4.append("invalid longitude: ");
            sb4.append(d11);
            throw new IllegalArgumentException(sb4.toString());
        } else {
            int i13 = i10 & 7;
            if (i13 != 0) {
                this.f9133c = s10;
                this.f9131a = str;
                this.f9134d = d10;
                this.f9135e = d11;
                this.f9136f = f10;
                this.f9132b = j10;
                this.f9137g = i13;
                this.f9138h = i11;
                this.f9139i = i12;
                return;
            }
            StringBuilder sb5 = new StringBuilder(46);
            sb5.append("No supported transition specified: ");
            sb5.append(i10);
            throw new IllegalArgumentException(sb5.toString());
        }
    }

    public final String G0() {
        return this.f9131a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzbh)) {
            return false;
        }
        zzbh zzbhVar = (zzbh) obj;
        return this.f9136f == zzbhVar.f9136f && this.f9134d == zzbhVar.f9134d && this.f9135e == zzbhVar.f9135e && this.f9133c == zzbhVar.f9133c;
    }

    public final int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.f9134d);
        long doubleToLongBits2 = Double.doubleToLongBits(this.f9135e);
        return ((((((((((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) + 31) * 31) + ((int) ((doubleToLongBits2 >>> 32) ^ doubleToLongBits2))) * 31) + Float.floatToIntBits(this.f9136f)) * 31) + this.f9133c) * 31) + this.f9137g;
    }

    public final String toString() {
        Locale locale = Locale.US;
        Object[] objArr = new Object[9];
        objArr[0] = this.f9133c != 1 ? null : "CIRCLE";
        objArr[1] = this.f9131a.replaceAll("\\p{C}", "?");
        objArr[2] = Integer.valueOf(this.f9137g);
        objArr[3] = Double.valueOf(this.f9134d);
        objArr[4] = Double.valueOf(this.f9135e);
        objArr[5] = Float.valueOf(this.f9136f);
        objArr[6] = Integer.valueOf(this.f9138h / 1000);
        objArr[7] = Integer.valueOf(this.f9139i);
        objArr[8] = Long.valueOf(this.f9132b);
        return String.format(locale, "Geofence[%s id:%s transitions:%d %.6f, %.6f %.0fm, resp=%ds, dwell=%dms, @%d]", objArr);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.t(parcel, 1, G0(), false);
        a.o(parcel, 2, this.f9132b);
        a.s(parcel, 3, this.f9133c);
        a.g(parcel, 4, this.f9134d);
        a.g(parcel, 5, this.f9135e);
        a.i(parcel, 6, this.f9136f);
        a.l(parcel, 7, this.f9137g);
        a.l(parcel, 8, this.f9138h);
        a.l(parcel, 9, this.f9139i);
        a.b(parcel, a10);
    }
}
