package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import b6.i;
import c6.a;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Collections;
import java.util.List;
import w6.k;
/* loaded from: classes.dex */
public class ActivityTransitionResult extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ActivityTransitionResult> CREATOR = new k();

    /* renamed from: a  reason: collision with root package name */
    private final List<ActivityTransitionEvent> f9917a;

    public ActivityTransitionResult(List<ActivityTransitionEvent> list) {
        i.l(list, "transitionEvents list can't be null.");
        if (!list.isEmpty()) {
            for (int i10 = 1; i10 < list.size(); i10++) {
                i.a(list.get(i10).H0() >= list.get(i10 + (-1)).H0());
            }
        }
        this.f9917a = Collections.unmodifiableList(list);
    }

    public List<ActivityTransitionEvent> G0() {
        return this.f9917a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f9917a.equals(((ActivityTransitionResult) obj).f9917a);
    }

    public int hashCode() {
        return this.f9917a.hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.x(parcel, 1, G0(), false);
        a.b(parcel, a10);
    }
}
