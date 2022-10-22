package com.mobvoi.companion.health.share;
/* compiled from: HealthShareActivity.kt */
/* loaded from: classes2.dex */
public final class h {
    public static final String a(int i10) {
        if (i10 < 100000) {
            return String.valueOf(i10);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(i10 / 1000);
        sb2.append('K');
        return sb2.toString();
    }
}
