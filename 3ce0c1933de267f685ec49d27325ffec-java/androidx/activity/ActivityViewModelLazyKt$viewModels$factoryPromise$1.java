package androidx.activity;

import androidx.lifecycle.h0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.i;
import qo.a;
/* compiled from: ActivityViewModelLazy.kt */
/* loaded from: classes.dex */
public final class ActivityViewModelLazyKt$viewModels$factoryPromise$1 extends Lambda implements a<h0.b> {
    final /* synthetic */ ComponentActivity $this_viewModels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActivityViewModelLazyKt$viewModels$factoryPromise$1(ComponentActivity componentActivity) {
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
