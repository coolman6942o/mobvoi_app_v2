package com.mobvoi.companion.health;

import android.content.Context;
import android.util.TypedValue;
import kotlin.jvm.internal.i;
/* compiled from: HomeTabExtensions.kt */
/* loaded from: classes2.dex */
public final class u1 {
    public static final int a(Context context) {
        i.f(context, "<this>");
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static final float b(Context context, int i10) {
        i.f(context, "<this>");
        return TypedValue.applyDimension(2, i10, context.getResources().getDisplayMetrics());
    }
}
