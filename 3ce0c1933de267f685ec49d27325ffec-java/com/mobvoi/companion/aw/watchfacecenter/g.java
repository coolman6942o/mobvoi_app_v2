package com.mobvoi.companion.aw.watchfacecenter;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.f;
import ec.a;
import kotlin.jvm.internal.i;
/* compiled from: AWWatchFaceModule.kt */
/* loaded from: classes2.dex */
public final class g {
    public final a a(f activity) {
        i.f(activity, "activity");
        FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
        i.e(supportFragmentManager, "activity.supportFragmentManager");
        return new a(supportFragmentManager);
    }
}
