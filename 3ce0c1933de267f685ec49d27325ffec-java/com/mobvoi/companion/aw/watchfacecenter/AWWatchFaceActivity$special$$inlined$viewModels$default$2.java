package com.mobvoi.companion.aw.watchfacecenter;

import androidx.activity.ComponentActivity;
import androidx.lifecycle.i0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.i;
import qo.a;
/* compiled from: ActivityViewModelLazy.kt */
/* loaded from: classes2.dex */
public final class AWWatchFaceActivity$special$$inlined$viewModels$default$2 extends Lambda implements a<i0> {
    final /* synthetic */ ComponentActivity $this_viewModels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AWWatchFaceActivity$special$$inlined$viewModels$default$2(ComponentActivity componentActivity) {
        super(0);
        this.$this_viewModels = componentActivity;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // qo.a
    public final i0 invoke() {
        i0 viewModelStore = this.$this_viewModels.getViewModelStore();
        i.e(viewModelStore, "viewModelStore");
        return viewModelStore;
    }
}
