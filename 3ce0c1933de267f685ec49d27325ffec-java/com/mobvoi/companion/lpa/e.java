package com.mobvoi.companion.lpa;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.f;
import com.mobvoi.android.common.ui.viewbinding.FragmentViewBindingDelegate;
import com.mobvoi.companion.R;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.l;
import kotlin.reflect.KProperty;
import oc.h;
/* compiled from: EnableSuccessFragment.kt */
/* loaded from: classes2.dex */
public final class e extends j {

    /* renamed from: g  reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f17186g = {l.h(new PropertyReference1Impl(l.b(e.class), "viewBinding", "getViewBinding()Lcom/mobvoi/companion/databinding/FragmentEnableSuccessBinding;"))};

    /* renamed from: f  reason: collision with root package name */
    private final FragmentViewBindingDelegate f17187f = com.mobvoi.android.common.ui.viewbinding.a.b(this, a.INSTANCE);

    /* compiled from: EnableSuccessFragment.kt */
    /* loaded from: classes2.dex */
    /* synthetic */ class a extends FunctionReferenceImpl implements qo.l<View, h> {
        public static final a INSTANCE = new a();

        a() {
            super(1, h.class, "bind", "bind(Landroid/view/View;)Lcom/mobvoi/companion/databinding/FragmentEnableSuccessBinding;", 0);
        }

        /* renamed from: g */
        public final h invoke(View p02) {
            i.f(p02, "p0");
            return h.b(p02);
        }
    }

    public e() {
        super(R.layout.fragment_enable_success);
    }

    private final h d0() {
        return (h) this.f17187f.b(this, f17186g[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(e this$0, View view) {
        i.f(this$0, "this$0");
        f activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        i.f(view, "view");
        super.onViewCreated(view, bundle);
        d0().f31528b.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.companion.lpa.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                e.e0(e.this, view2);
            }
        });
    }
}
