package com.mobvoi.companion.profile;

import androidx.lifecycle.i0;
import androidx.lifecycle.j0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.i;
import qo.a;
/* compiled from: FragmentViewModelLazy.kt */
/* loaded from: classes2.dex */
public final class AWProfileFragment$special$$inlined$viewModels$default$2 extends Lambda implements a<i0> {
    final /* synthetic */ a $ownerProducer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AWProfileFragment$special$$inlined$viewModels$default$2(a aVar) {
        super(0);
        this.$ownerProducer = aVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // qo.a
    public final i0 invoke() {
        i0 viewModelStore = ((j0) this.$ownerProducer.invoke()).getViewModelStore();
        i.e(viewModelStore, "ownerProducer().viewModelStore");
        return viewModelStore;
    }
}
