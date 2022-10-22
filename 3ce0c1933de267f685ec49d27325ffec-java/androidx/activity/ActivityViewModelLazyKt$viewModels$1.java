package androidx.activity;

import androidx.lifecycle.i0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.i;
import qo.a;
/* compiled from: ActivityViewModelLazy.kt */
/* loaded from: classes.dex */
public final class ActivityViewModelLazyKt$viewModels$1 extends Lambda implements a<i0> {
    final /* synthetic */ ComponentActivity $this_viewModels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivityViewModelLazyKt$viewModels$1(ComponentActivity componentActivity) {
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
