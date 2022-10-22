package com.mobvoi.companion.health;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.o;
import androidx.lifecycle.y;
import com.mobvoi.android.common.utils.k;
import io.m;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: HomeTabLifeCycleChecker.kt */
/* loaded from: classes2.dex */
public final class HomeTabLifeCycleChecker implements o {

    /* renamed from: a  reason: collision with root package name */
    private final qo.a<m> f16758a;

    /* compiled from: HomeTabLifeCycleChecker.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    static {
        new a(null);
    }

    public HomeTabLifeCycleChecker(qo.a<m> block) {
        i.f(block, "block");
        this.f16758a = block;
    }

    @y(Lifecycle.Event.ON_START)
    private final void onAppMoveToForeground() {
        k.a("HomeTabLifeCycleChecker", "HealthFragment: detect app move to foreground");
        this.f16758a.invoke();
    }
}
