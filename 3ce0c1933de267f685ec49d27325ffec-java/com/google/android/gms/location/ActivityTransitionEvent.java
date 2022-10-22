package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import b6.h;
import c6.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import w6.i;
/* loaded from: classes.dex */
public class ActivityTransitionEvent extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ActivityTransitionEvent> CREATOR = new i();

    /* renamed from: a  reason: collision with root package name */
    private final int f9910a;

    /* renamed from: b  reason: collision with root package name */
    private final int f9911b;

    /* renamed from: c  reason: collision with root package name */
    private final long f9912c;

    public ActivityTransitionEvent(int i10, int i11, long j10) {
        DetectedActivity.I0(i10);
        ActivityTransition.I0(i11);
        this.f9910a = i10;
        this.f9911b = i11;
        this.f9912c = j10;
    }

    public int G0() {
        return this.f9910a;
    }

    public long H0() {
        return this.f9912c;
    }

    public int I0() {
        return this.f9911b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityTransitionEvent)) {
            return false;
        }
        ActivityTransitionEvent activityTransitionEvent = (ActivityTransitionEvent) obj;
        return this.f9910a == activityTransitionEvent.f9910a && this.f9911b == activityTransitionEvent.f9911b && this.f9912c == activityTransitionEvent.f9912c;
    }

    public int hashCode() {
        return h.b(Integer.valueOf(this.f9910a), Integer.valueOf(this.f9911b), Long.valueOf(this.f9912c));
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        int i10 = this.f9910a;
        StringBuilder sb3 = new StringBuilder(24);
        sb3.append("ActivityType ");
        sb3.append(i10);
        sb2.append(sb3.toString());
        sb2.append(" ");
        int i11 = this.f9911b;
        StringBuilder sb4 = new StringBuilder(26);
        sb4.append("TransitionType ");
        sb4.append(i11);
        sb2.append(sb4.toString());
        sb2.append(" ");
        long j10 = this.f9912c;
        StringBuilder sb5 = new StringBuilder(41);
        sb5.append("ElapsedRealTimeNanos ");
        sb5.append(j10);
        sb2.append(sb5.toString());
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.l(parcel, 1, G0());
        a.l(parcel, 2, I0());
        a.o(parcel, 3, H0());
        a.b(parcel, a10);
    }
}
