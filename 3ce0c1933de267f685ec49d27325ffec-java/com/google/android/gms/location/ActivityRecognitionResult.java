package com.google.android.gms.location;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import b6.i;
import c6.a;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;
import w6.h;
/* loaded from: classes.dex */
public class ActivityRecognitionResult extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<ActivityRecognitionResult> CREATOR = new h();

    /* renamed from: a  reason: collision with root package name */
    private List<DetectedActivity> f9903a;

    /* renamed from: b  reason: collision with root package name */
    private long f9904b;

    /* renamed from: c  reason: collision with root package name */
    private long f9905c;

    /* renamed from: d  reason: collision with root package name */
    private int f9906d;

    /* renamed from: e  reason: collision with root package name */
    private Bundle f9907e;

    public ActivityRecognitionResult(List<DetectedActivity> list, long j10, long j11, int i10, Bundle bundle) {
        boolean z10 = true;
        i.b(list != null && list.size() > 0, "Must have at least 1 detected activity");
        i.b((j10 <= 0 || j11 <= 0) ? false : z10, "Must set times");
        this.f9903a = list;
        this.f9904b = j10;
        this.f9905c = j11;
        this.f9906d = i10;
        this.f9907e = bundle;
    }

    private static boolean G0(Bundle bundle, Bundle bundle2) {
        if (bundle == null && bundle2 == null) {
            return true;
        }
        if ((bundle == null && bundle2 != null) || ((bundle != null && bundle2 == null) || bundle.size() != bundle2.size())) {
            return false;
        }
        for (String str : bundle.keySet()) {
            if (!bundle2.containsKey(str)) {
                return false;
            }
            if (bundle.get(str) == null) {
                if (bundle2.get(str) != null) {
                    return false;
                }
            } else if (bundle.get(str) instanceof Bundle) {
                if (!G0(bundle.getBundle(str), bundle2.getBundle(str))) {
                    return false;
                }
            } else if (!bundle.get(str).equals(bundle2.get(str))) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ActivityRecognitionResult activityRecognitionResult = (ActivityRecognitionResult) obj;
            if (this.f9904b == activityRecognitionResult.f9904b && this.f9905c == activityRecognitionResult.f9905c && this.f9906d == activityRecognitionResult.f9906d && b6.h.a(this.f9903a, activityRecognitionResult.f9903a) && G0(this.f9907e, activityRecognitionResult.f9907e)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return b6.h.b(Long.valueOf(this.f9904b), Long.valueOf(this.f9905c), Integer.valueOf(this.f9906d), this.f9903a, this.f9907e);
    }

    public String toString() {
        String valueOf = String.valueOf(this.f9903a);
        long j10 = this.f9904b;
        long j11 = this.f9905c;
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 124);
        sb2.append("ActivityRecognitionResult [probableActivities=");
        sb2.append(valueOf);
        sb2.append(", timeMillis=");
        sb2.append(j10);
        sb2.append(", elapsedRealtimeMillis=");
        sb2.append(j11);
        sb2.append("]");
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.x(parcel, 1, this.f9903a, false);
        a.o(parcel, 2, this.f9904b);
        a.o(parcel, 3, this.f9905c);
        a.l(parcel, 4, this.f9906d);
        a.d(parcel, 5, this.f9907e, false);
        a.b(parcel, a10);
    }
}
