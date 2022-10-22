package androidx.navigation;

import androidx.lifecycle.i0;
import io.d;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.i;
import qo.a;
import wo.j;
/* compiled from: NavGraphViewModelLazy.kt */
/* loaded from: classes.dex */
public final class NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$1 extends Lambda implements a<i0> {
    final /* synthetic */ d $backStackEntry;
    final /* synthetic */ j $backStackEntry$metadata;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavGraphViewModelLazyKt$navGraphViewModels$storeProducer$1(d dVar, j jVar) {
        super(0);
        this.$backStackEntry = dVar;
        this.$backStackEntry$metadata = jVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // qo.a
    public final i0 invoke() {
        f backStackEntry = (f) this.$backStackEntry.getValue();
        i.c(backStackEntry, "backStackEntry");
        i0 viewModelStore = backStackEntry.getViewModelStore();
        i.c(viewModelStore, "backStackEntry.viewModelStore");
        return viewModelStore;
    }
}
