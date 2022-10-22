package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import b6.h;
import b6.i;
import c6.a;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import w6.j;
/* loaded from: classes.dex */
public class ActivityTransitionRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ActivityTransitionRequest> CREATOR = new j();

    /* renamed from: d  reason: collision with root package name */
    public static final Comparator<ActivityTransition> f9913d = new j();

    /* renamed from: a  reason: collision with root package name */
    private final List<ActivityTransition> f9914a;

    /* renamed from: b  reason: collision with root package name */
    private final String f9915b;

    /* renamed from: c  reason: collision with root package name */
    private final List<ClientIdentity> f9916c;

    public ActivityTransitionRequest(List<ActivityTransition> list, String str, List<ClientIdentity> list2) {
        i.l(list, "transitions can't be null");
        i.b(list.size() > 0, "transitions can't be empty.");
        TreeSet treeSet = new TreeSet(f9913d);
        for (ActivityTransition activityTransition : list) {
            i.b(treeSet.add(activityTransition), String.format("Found duplicated transition: %s.", activityTransition));
        }
        this.f9914a = Collections.unmodifiableList(list);
        this.f9915b = str;
        this.f9916c = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ActivityTransitionRequest activityTransitionRequest = (ActivityTransitionRequest) obj;
            if (h.a(this.f9914a, activityTransitionRequest.f9914a) && h.a(this.f9915b, activityTransitionRequest.f9915b) && h.a(this.f9916c, activityTransitionRequest.f9916c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.f9914a.hashCode() * 31;
        String str = this.f9915b;
        int i10 = 0;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        List<ClientIdentity> list = this.f9916c;
        if (list != null) {
            i10 = list.hashCode();
        }
        return hashCode2 + i10;
    }

    public String toString() {
        String valueOf = String.valueOf(this.f9914a);
        String str = this.f9915b;
        String valueOf2 = String.valueOf(this.f9916c);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 61 + String.valueOf(str).length() + valueOf2.length());
        sb2.append("ActivityTransitionRequest [mTransitions=");
        sb2.append(valueOf);
        sb2.append(", mTag='");
        sb2.append(str);
        sb2.append('\'');
        sb2.append(", mClients=");
        sb2.append(valueOf2);
        sb2.append(']');
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int a10 = a.a(parcel);
        a.x(parcel, 1, this.f9914a, false);
        a.t(parcel, 2, this.f9915b, false);
        a.x(parcel, 3, this.f9916c, false);
        a.b(parcel, a10);
    }
}
