package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import b6.h;
import c6.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes.dex */
public final class zzaj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaj> CREATOR = new g();

    /* renamed from: a  reason: collision with root package name */
    private final int f9963a;

    /* renamed from: b  reason: collision with root package name */
    private final int f9964b;

    /* renamed from: c  reason: collision with root package name */
    private final long f9965c;

    /* renamed from: d  reason: collision with root package name */
    private final long f9966d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaj(int i10, int i11, long j10, long j11) {
        this.f9963a = i10;
        this.f9964b = i11;
        this.f9965c = j10;
        this.f9966d = j11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzaj.class == obj.getClass()) {
            zzaj zzajVar = (zzaj) obj;
            if (this.f9963a == zzajVar.f9963a && this.f9964b == zzajVar.f9964b && this.f9965c == zzajVar.f9965c && this.f9966d == zzajVar.f9966d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return h.b(Integer.valueOf(this.f9964b), Integer.valueOf(this.f9963a), Long.valueOf(this.f9966d), Long.valueOf(this.f9965c));
    }

    public final String toString() {
        return "NetworkLocationStatus: Wifi status: " + this.f9963a + " Cell status: " + this.f9964b + " elapsed time NS: " + this.f9966d + " system time ms: " + this.f9965c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 1, this.f9963a);
        a.l(parcel, 2, this.f9964b);
        a.o(parcel, 3, this.f9965c);
        a.o(parcel, 4, this.f9966d);
        a.b(parcel, a10);
    }
}
