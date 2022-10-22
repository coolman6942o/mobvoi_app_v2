package androidx.fragment.app;

import androidx.lifecycle.i0;
import androidx.lifecycle.j0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.i;
import qo.a;
/* compiled from: FragmentViewModelLazy.kt */
/* loaded from: classes.dex */
public final class FragmentViewModelLazyKt$viewModels$2 extends Lambda implements a<i0> {
    final /* synthetic */ a<j0> $ownerProducer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FragmentViewModelLazyKt$viewModels$2(a<? extends j0> aVar) {
        super(0);
        this.$ownerProducer = aVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // qo.a
    public final i0 invoke() {
        i0 viewModelStore = this.$ownerProducer.invoke().getViewModelStore();
        i.e(viewModelStore, "ownerProducer().viewModelStore");
        return viewModelStore;
    }
}
