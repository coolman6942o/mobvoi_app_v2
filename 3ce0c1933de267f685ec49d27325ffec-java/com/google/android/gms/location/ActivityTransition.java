package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import b6.h;
import b6.i;
import c6.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes.dex */
public class ActivityTransition extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ActivityTransition> CREATOR = new i();

    /* renamed from: a  reason: collision with root package name */
    private final int f9908a;

    /* renamed from: b  reason: collision with root package name */
    private final int f9909b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ActivityTransition(int i10, int i11) {
        this.f9908a = i10;
        this.f9909b = i11;
    }

    public static void I0(int i10) {
        boolean z10 = true;
        if (i10 < 0 || i10 > 1) {
            z10 = false;
        }
        StringBuilder sb2 = new StringBuilder(41);
        sb2.append("Transition type ");
        sb2.append(i10);
        sb2.append(" is not valid.");
        i.b(z10, sb2.toString());
    }

    public int G0() {
        return this.f9908a;
    }

    public int H0() {
        return this.f9909b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityTransition)) {
            return false;
        }
        ActivityTransition activityTransition = (ActivityTransition) obj;
        return this.f9908a == activityTransition.f9908a && this.f9909b == activityTransition.f9909b;
    }

    public int hashCode() {
        return h.b(Integer.valueOf(this.f9908a), Integer.valueOf(this.f9909b));
    }

    public String toString() {
        int i10 = this.f9908a;
        int i11 = this.f9909b;
        StringBuilder sb2 = new StringBuilder(75);
        sb2.append("ActivityTransition [mActivityType=");
        sb2.append(i10);
        sb2.append(", mTransitionType=");
        sb2.append(i11);
        sb2.append(']');
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 1, G0());
        a.l(parcel, 2, H0());
        a.b(parcel, a10);
    }
}
