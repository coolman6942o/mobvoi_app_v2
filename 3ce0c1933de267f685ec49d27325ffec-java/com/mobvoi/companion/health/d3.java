package com.mobvoi.companion.health;

import android.content.Context;
import androidx.fragment.app.f;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.mobvoi.companion.health.MedalCenterActivity;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.i;
import tc.d;
/* compiled from: MedalCenterModule.kt */
/* loaded from: classes2.dex */
public final class d3 {
    public final LinearLayoutManager a(Context context) {
        i.f(context, "context");
        return new LinearLayoutManager(context, 1, false);
    }

    public final MonthMedalAdapter b(Context context, Runnable runnable) {
        i.f(context, "context");
        i.f(runnable, "runnable");
        return new MonthMedalAdapter(context, null, runnable);
    }

    public final Runnable c(f activity) {
        i.f(activity, "activity");
        return new MedalCenterActivity.b((MedalCenterActivity) activity);
    }

    public final List<d> d() {
        return new ArrayList();
    }
}
