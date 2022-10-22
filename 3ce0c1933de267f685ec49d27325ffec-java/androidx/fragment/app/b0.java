package androidx.fragment.app;

import androidx.lifecycle.f0;
import androidx.lifecycle.g0;
import androidx.lifecycle.h0;
import androidx.lifecycle.i0;
import io.d;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.i;
import wo.c;
/* compiled from: FragmentViewModelLazy.kt */
/* loaded from: classes.dex */
public final class b0 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: FragmentViewModelLazy.kt */
    /* loaded from: classes.dex */
    public static final class a extends Lambda implements qo.a<h0.b> {
        final /* synthetic */ Fragment $this_createViewModelLazy;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Fragment fragment) {
            super(0);
            this.$this_createViewModelLazy = fragment;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // qo.a
        public final h0.b invoke() {
            h0.b defaultViewModelProviderFactory = this.$this_createViewModelLazy.getDefaultViewModelProviderFactory();
            i.e(defaultViewModelProviderFactory, "defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    }

    public static final <VM extends f0> d<VM> a(Fragment fragment, c<VM> viewModelClass, qo.a<? extends i0> storeProducer, qo.a<? extends h0.b> aVar) {
        i.f(fragment, "<this>");
        i.f(viewModelClass, "viewModelClass");
        i.f(storeProducer, "storeProducer");
        if (aVar == null) {
            aVar = new a(fragment);
        }
        return new g0(viewModelClass, storeProducer, aVar);
    }
}
