package com.mobvoi.android.common.ui.viewbinding;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import androidx.fragment.app.Fragment;
import io.d;
import io.f;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.i;
import qo.l;
/* compiled from: ViewBindingExtensions.kt */
/* loaded from: classes2.dex */
public final class a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewBindingExtensions.kt */
    /* renamed from: com.mobvoi.android.common.ui.viewbinding.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0187a extends Lambda implements qo.a<VB> {
        final /* synthetic */ l<LayoutInflater, VB> $inflateBlock;
        final /* synthetic */ Activity $this_activityBinding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C0187a(l<? super LayoutInflater, ? extends VB> lVar, Activity activity) {
            super(0);
            this.$inflateBlock = lVar;
            this.$this_activityBinding = activity;
        }

        /* JADX WARN: Incorrect return type in method signature: ()TVB; */
        /* renamed from: a */
        public final p1.a invoke() {
            l<LayoutInflater, VB> lVar = this.$inflateBlock;
            LayoutInflater layoutInflater = this.$this_activityBinding.getLayoutInflater();
            i.e(layoutInflater, "layoutInflater");
            return (p1.a) lVar.invoke(layoutInflater);
        }
    }

    public static final <VB extends p1.a> d<VB> a(Activity activity, l<? super LayoutInflater, ? extends VB> inflateBlock) {
        d<VB> a10;
        i.f(activity, "<this>");
        i.f(inflateBlock, "inflateBlock");
        a10 = f.a(new C0187a(inflateBlock, activity));
        return a10;
    }

    public static final <VB extends p1.a> FragmentViewBindingDelegate<VB> b(Fragment fragment, l<? super View, ? extends VB> bindBlock) {
        i.f(fragment, "<this>");
        i.f(bindBlock, "bindBlock");
        return new FragmentViewBindingDelegate<>(bindBlock);
    }
}
