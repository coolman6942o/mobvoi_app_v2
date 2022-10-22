package androidx.navigation;

import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.Lambda;
import qo.a;
/* compiled from: NavGraphViewModelLazy.kt */
/* loaded from: classes.dex */
public final class NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$2 extends Lambda implements a<f> {
    final /* synthetic */ int $navGraphId;
    final /* synthetic */ Fragment $this_navGraphViewModels;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NavGraphViewModelLazyKt$navGraphViewModels$backStackEntry$2(Fragment fragment, int i10) {
        super(0);
        this.$this_navGraphViewModels = fragment;
        this.$navGraphId = i10;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // qo.a
    public final f invoke() {
        return androidx.navigation.fragment.a.a(this.$this_navGraphViewModels).f(this.$navGraphId);
    }
}
