package androidx.navigation.fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.Lambda;
import qo.a;
/* compiled from: FragmentNavArgsLazy.kt */
/* loaded from: classes.dex */
public final class FragmentNavArgsLazyKt$navArgs$1 extends Lambda implements a<Bundle> {
    final /* synthetic */ Fragment $this_navArgs;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FragmentNavArgsLazyKt$navArgs$1(Fragment fragment) {
        super(0);
        this.$this_navArgs = fragment;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // qo.a
    public final Bundle invoke() {
        Bundle arguments = this.$this_navArgs.getArguments();
        if (arguments != null) {
            return arguments;
        }
        throw new IllegalStateException("Fragment " + this.$this_navArgs + " has null arguments");
    }
}
