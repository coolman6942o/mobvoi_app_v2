package com.google.android.gms.location;

import java.util.Comparator;
/* loaded from: classes.dex */
final class j implements Comparator<ActivityTransition> {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(ActivityTransition activityTransition, ActivityTransition activityTransition2) {
        ActivityTransition activityTransition3 = activityTransition;
        ActivityTransition activityTransition4 = activityTransition2;
        int G0 = activityTransition3.G0();
        int G02 = activityTransition4.G0();
        if (G0 != G02) {
            return G0 < G02 ? -1 : 1;
        }
        int H0 = activityTransition3.H0();
        int H02 = activityTransition4.H0();
        if (H0 == H02) {
            return 0;
        }
        return H0 < H02 ? -1 : 1;
    }
}
