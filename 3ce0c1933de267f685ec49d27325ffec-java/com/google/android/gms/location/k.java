package com.google.android.gms.location;

import java.util.Comparator;
/* loaded from: classes.dex */
final class k implements Comparator<DetectedActivity> {
    @Override // java.util.Comparator
    public final /* synthetic */ int compare(DetectedActivity detectedActivity, DetectedActivity detectedActivity2) {
        DetectedActivity detectedActivity3 = detectedActivity;
        DetectedActivity detectedActivity4 = detectedActivity2;
        int compareTo = Integer.valueOf(detectedActivity4.G0()).compareTo(Integer.valueOf(detectedActivity3.G0()));
        return compareTo == 0 ? Integer.valueOf(detectedActivity3.H0()).compareTo(Integer.valueOf(detectedActivity4.H0())) : compareTo;
    }
}
