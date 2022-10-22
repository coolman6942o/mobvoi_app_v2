package com.google.android.material.elevation;

import android.content.Context;
import d7.b;
import d7.d;
import n7.a;
/* loaded from: classes.dex */
public enum SurfaceColors {
    SURFACE_0(d.f25214q),
    SURFACE_1(d.f25216r),
    SURFACE_2(d.f25218s),
    SURFACE_3(d.f25220t),
    SURFACE_4(d.f25222u),
    SURFACE_5(d.f25224v);
    
    private final int elevationResId;

    SurfaceColors(int i10) {
        this.elevationResId = i10;
    }

    public static int getColorForElevation(Context context, float f10) {
        return new a(context).b(j7.a.b(context, b.f25161q, 0), f10);
    }

    public int getColor(Context context) {
        return getColorForElevation(context, context.getResources().getDimension(this.elevationResId));
    }
}
