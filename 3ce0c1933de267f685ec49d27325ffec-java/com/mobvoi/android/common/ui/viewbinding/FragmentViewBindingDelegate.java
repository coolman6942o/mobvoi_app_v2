package com.mobvoi.android.common.ui.viewbinding;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.o;
import androidx.lifecycle.y;
import kotlin.jvm.internal.i;
import p1.a;
import qo.l;
import wo.j;
/* compiled from: ViewBindingExtensions.kt */
/* loaded from: classes2.dex */
public final class FragmentViewBindingDelegate<VB extends a> {

    /* renamed from: a  reason: collision with root package name */
    private final l<View, VB> f15358a;

    /* renamed from: b  reason: collision with root package name */
    private VB f15359b;

    /* JADX WARN: Multi-variable type inference failed */
    public FragmentViewBindingDelegate(l<? super View, ? extends VB> block) {
        i.f(block, "block");
        this.f15358a = block;
    }

    public VB b(Fragment thisRef, j<?> property) {
        i.f(thisRef, "thisRef");
        i.f(property, "property");
        if (this.f15359b == null) {
            l<View, VB> lVar = this.f15358a;
            View requireView = thisRef.requireView();
            i.e(requireView, "thisRef.requireView()");
            this.f15359b = lVar.invoke(requireView);
        }
        thisRef.getViewLifecycleOwner().getLifecycle().a(new o() { // from class: com.mobvoi.android.common.ui.viewbinding.FragmentViewBindingDelegate$getValue$$inlined$doOnDestroyView$1
            @y(Lifecycle.Event.ON_DESTROY)
            public final void onDestroyView() {
                FragmentViewBindingDelegate.this.f15359b = null;
            }
        });
        VB vb2 = this.f15359b;
        i.d(vb2);
        return vb2;
    }
}
