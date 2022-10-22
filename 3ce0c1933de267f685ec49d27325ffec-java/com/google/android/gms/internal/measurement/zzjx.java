package com.google.android.gms.internal.measurement;

import android.os.Parcel;
import android.os.Parcelable;
import b6.i;
import c6.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes.dex */
public final class zzjx extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzjx> CREATOR = new p5();

    /* renamed from: a  reason: collision with root package name */
    private final int f9892a;

    /* renamed from: b  reason: collision with root package name */
    public final String f9893b;

    /* renamed from: c  reason: collision with root package name */
    public final long f9894c;

    /* renamed from: d  reason: collision with root package name */
    private final Long f9895d;

    /* renamed from: e  reason: collision with root package name */
    private final String f9896e;

    /* renamed from: f  reason: collision with root package name */
    public final String f9897f;

    /* renamed from: g  reason: collision with root package name */
    private final Double f9898g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjx(int i10, String str, long j10, Long l10, Float f10, String str2, String str3, Double d10) {
        this.f9892a = i10;
        this.f9893b = str;
        this.f9894c = j10;
        this.f9895d = l10;
        if (i10 == 1) {
            this.f9898g = f10 != null ? Double.valueOf(f10.doubleValue()) : null;
        } else {
            this.f9898g = d10;
        }
        this.f9896e = str2;
        this.f9897f = str3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjx(q5 q5Var) {
        this(q5Var.f9615c, q5Var.f9616d, q5Var.f9617e, q5Var.f9614b);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzjx(String str, long j10, Object obj, String str2) {
        i.g(str);
        this.f9892a = 2;
        this.f9893b = str;
        this.f9894c = j10;
        this.f9897f = str2;
        if (obj == null) {
            this.f9895d = null;
            this.f9898g = null;
            this.f9896e = null;
        } else if (obj instanceof Long) {
            this.f9895d = (Long) obj;
            this.f9898g = null;
            this.f9896e = null;
        } else if (obj instanceof String) {
            this.f9895d = null;
            this.f9898g = null;
            this.f9896e = (String) obj;
        } else if (obj instanceof Double) {
            this.f9895d = null;
            this.f9898g = (Double) obj;
            this.f9896e = null;
        } else {
            throw new IllegalArgumentException("User attribute given of un-supported type");
        }
    }

    public final Object G0() {
        Long l10 = this.f9895d;
        if (l10 != null) {
            return l10;
        }
        Double d10 = this.f9898g;
        if (d10 != null) {
            return d10;
        }
        String str = this.f9896e;
        if (str != null) {
            return str;
        }
        return null;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 1, this.f9892a);
        a.t(parcel, 2, this.f9893b, false);
        a.o(parcel, 3, this.f9894c);
        a.p(parcel, 4, this.f9895d, false);
        a.j(parcel, 5, null, false);
        a.t(parcel, 6, this.f9896e, false);
        a.t(parcel, 7, this.f9897f, false);
        a.h(parcel, 8, this.f9898g, false);
        a.b(parcel, a10);
    }
}
