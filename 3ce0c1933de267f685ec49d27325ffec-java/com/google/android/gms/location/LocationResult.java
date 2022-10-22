package com.google.android.gms.location;

import android.location.Location;
import android.os.Parcel;
import android.os.Parcelable;
import c6.a;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public final class LocationResult extends AbstractSafeParcelable implements ReflectedParcelable {

    /* renamed from: a  reason: collision with root package name */
    private final List<Location> f9938a;

    /* renamed from: b  reason: collision with root package name */
    static final List<Location> f9937b = Collections.emptyList();
    public static final Parcelable.Creator<LocationResult> CREATOR = new d();

    /* JADX INFO: Access modifiers changed from: package-private */
    public LocationResult(List<Location> list) {
        this.f9938a = list;
    }

    public final Location G0() {
        int size = this.f9938a.size();
        if (size == 0) {
            return null;
        }
        return this.f9938a.get(size - 1);
    }

    public final List<Location> H0() {
        return this.f9938a;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof LocationResult)) {
            return false;
        }
        LocationResult locationResult = (LocationResult) obj;
        if (locationResult.f9938a.size() != this.f9938a.size()) {
            return false;
        }
        Iterator<Location> it = this.f9938a.iterator();
        for (Location location : locationResult.f9938a) {
            if (it.next().getTime() != location.getTime()) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i10 = 17;
        for (Location location : this.f9938a) {
            long time = location.getTime();
            i10 = (i10 * 31) + ((int) (time ^ (time >>> 32)));
        }
        return i10;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f9938a);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 27);
        sb2.append("LocationResult[locations: ");
        sb2.append(valueOf);
        sb2.append("]");
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.x(parcel, 1, H0(), false);
        a.b(parcel, a10);
    }
}
