package com.mobvoi.companion.health;

import androidx.activity.ComponentActivity;
import androidx.lifecycle.h0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.i;
import qo.a;
/* compiled from: ActivityViewModelLazy.kt */
/* loaded from: classes2.dex */
public final class MedalCenterActivity$special$$inlined$viewModels$default$1 extends Lambda implements a<h0.b> {
    final /* synthetic */ ComponentActivity $this_viewModels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MedalCenterActivity$special$$inlined$viewModels$default$1(ComponentActivity componentActivity) {
        super(0);
        this.$this_viewModels = componentActivity;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // qo.a
    public final h0.b invoke() {
        h0.b defaultViewModelProviderFactory = this.$this_viewModels.getDefaultViewModelProviderFactory();
        i.e(defaultViewModelProviderFactory, "defaultViewModelProviderFactory");
        return defaultViewModelProviderFactory;
    }
}
