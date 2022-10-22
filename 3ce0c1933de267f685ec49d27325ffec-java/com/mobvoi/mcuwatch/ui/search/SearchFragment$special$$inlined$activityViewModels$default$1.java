package com.mobvoi.mcuwatch.ui.search;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.i0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.i;
import qo.a;
/* compiled from: FragmentViewModelLazy.kt */
/* loaded from: classes2.dex */
public final class SearchFragment$special$$inlined$activityViewModels$default$1 extends Lambda implements a<i0> {
    final /* synthetic */ Fragment $this_activityViewModels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchFragment$special$$inlined$activityViewModels$default$1(Fragment fragment) {
        super(0);
        this.$this_activityViewModels = fragment;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // qo.a
    public final i0 invoke() {
        i0 viewModelStore = this.$this_activityViewModels.requireActivity().getViewModelStore();
        i.e(viewModelStore, "requireActivity().viewModelStore");
        return viewModelStore;
    }
}
