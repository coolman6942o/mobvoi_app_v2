package androidx.navigation;

import androidx.lifecycle.h0;
import io.d;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.i;
import qo.a;
import wo.j;
/* compiled from: NavGraphViewModelLazy.kt */
/* loaded from: classes.dex */
public final class NavGraphViewModelLazyKt$navGraphViewModels$1 extends Lambda implements a<h0.b> {
    final /* synthetic */ d $backStackEntry;
    final /* synthetic */ j $backStackEntry$metadata;
    final /* synthetic */ a $factoryProducer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavGraphViewModelLazyKt$navGraphViewModels$1(a aVar, d dVar, j jVar) {
        super(0);
        this.$factoryProducer = aVar;
        this.$backStackEntry = dVar;
        this.$backStackEntry$metadata = jVar;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // qo.a
    public final h0.b invoke() {
        h0.b bVar;
        a aVar = this.$factoryProducer;
        if (aVar != null && (bVar = (h0.b) aVar.invoke()) != null) {
            return bVar;
        }
        f backStackEntry = (f) this.$backStackEntry.getValue();
        i.c(backStackEntry, "backStackEntry");
        h0.b defaultViewModelProviderFactory = backStackEntry.getDefaultViewModelProviderFactory();
        i.c(defaultViewModelProviderFactory, "backStackEntry.defaultViewModelProviderFactory");
        return defaultViewModelProviderFactory;
    }
}
