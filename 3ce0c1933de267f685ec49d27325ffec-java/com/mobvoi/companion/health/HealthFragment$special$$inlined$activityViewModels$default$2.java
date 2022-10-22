package com.mobvoi.companion.health;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.h0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.i;
import qo.a;
/* compiled from: FragmentViewModelLazy.kt */
/* loaded from: classes2.dex */
public final class HealthFragment$special$$inlined$activityViewModels$default$2 extends Lambda implements a<h0.b> {
    final /* synthetic */ Fragment $this_activityViewModels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HealthFragment$special$$inlined$activityViewModels$default$2(Fragment fragment) {
        super(0);
        this.$this_activityViewModels = fragment;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // qo.a
    public final h0.b invoke() {
        h0.b defaultViewModelProviderFactory = this.$this_activityViewModels.requireActivity().getDefaultViewModelProviderFactory();
        i.e(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
        return defaultViewModelProviderFactory;
    }
}
