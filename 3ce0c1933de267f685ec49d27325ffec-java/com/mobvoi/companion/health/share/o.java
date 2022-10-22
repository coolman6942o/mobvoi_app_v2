package com.mobvoi.companion.health.share;

import kotlin.jvm.internal.i;
import qo.p;
/* compiled from: HealthShareChartViewModel.kt */
/* loaded from: classes2.dex */
public final class o {
    public static final <T1, T2, R> R a(T1 t12, T2 t22, p<? super T1, ? super T2, ? extends R> block) {
        i.f(block, "block");
        if (t12 == null || t22 == null) {
            return null;
        }
        return block.invoke(t12, t22);
    }
}
