package com.google.android.gms.common.stats;

import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
/* loaded from: classes.dex */
public abstract class StatsEvent extends AbstractSafeParcelable implements ReflectedParcelable {
    public abstract int G0();

    public abstract long H0();

    public abstract long I0();

    public abstract String J0();

    public String toString() {
        long H0 = H0();
        int G0 = G0();
        long I0 = I0();
        String J0 = J0();
        StringBuilder sb2 = new StringBuilder(String.valueOf(J0).length() + 53);
        sb2.append(H0);
        sb2.append("\t");
        sb2.append(G0);
        sb2.append("\t");
        sb2.append(I0);
        sb2.append(J0);
        return sb2.toString();
    }
}
