package com.mobvoi.companion.health.share;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import kotlin.jvm.internal.i;
/* compiled from: HealthSharable.kt */
/* loaded from: classes2.dex */
public final class b {
    public static final Bitmap a(View view) {
        i.f(view, "view");
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        i.e(createBitmap, "createBitmap(view.width, view.height, Bitmap.Config.ARGB_8888)");
        view.draw(new Canvas(createBitmap));
        return createBitmap;
    }
}
