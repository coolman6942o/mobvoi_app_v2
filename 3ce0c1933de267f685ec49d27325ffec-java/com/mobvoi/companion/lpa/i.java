package com.mobvoi.companion.lpa;

import aa.c;
import android.os.Bundle;
import android.view.View;
import com.mobvoi.android.common.ui.viewbinding.FragmentViewBindingDelegate;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.companion.R;
import com.mobvoi.wear.msgproxy.MessageProxyClient;
import com.mobvoi.wear.msgproxy.MessageProxyException;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.l;
import kotlin.reflect.KProperty;
import oc.j;
/* compiled from: EsimTutorialForTaiwan.kt */
/* loaded from: classes2.dex */
public final class i extends g implements View.OnClickListener {

    /* renamed from: c  reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f17201c = {l.h(new PropertyReference1Impl(l.b(i.class), "viewBinding", "getViewBinding()Lcom/mobvoi/companion/databinding/FragmentEsimTaiwanTutorialBinding;"))};

    /* renamed from: b  reason: collision with root package name */
    private final FragmentViewBindingDelegate f17202b = com.mobvoi.android.common.ui.viewbinding.a.b(this, b.INSTANCE);

    /* compiled from: EsimTutorialForTaiwan.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: EsimTutorialForTaiwan.kt */
    /* loaded from: classes2.dex */
    /* synthetic */ class b extends FunctionReferenceImpl implements qo.l<View, j> {
        public static final b INSTANCE = new b();

        b() {
            super(1, j.class, "bind", "bind(Landroid/view/View;)Lcom/mobvoi/companion/databinding/FragmentEsimTaiwanTutorialBinding;", 0);
        }

        /* renamed from: g */
        public final j invoke(View p02) {
            kotlin.jvm.internal.i.f(p02, "p0");
            return j.b(p02);
        }
    }

    static {
        new a(null);
    }

    public i() {
        super(R.layout.fragment_esim_taiwan_tutorial);
    }

    private final j d0() {
        return (j) this.f17202b.b(this, f17201c[0]);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v10) {
        kotlin.jvm.internal.i.f(v10, "v");
        int id2 = v10.getId();
        int i10 = R.id.esim_issues;
        if (id2 == i10) {
            Z(i10);
        } else if (v10.getId() == R.id.open_offline) {
            try {
                if (!MessageProxyClient.getInstance().hasConnectedNodes()) {
                    c.c(R.string.check_connection);
                } else if (Y()) {
                    c0();
                }
            } catch (MessageProxyException e10) {
                k.e("EsimTutorialForTaiwan", "", e10);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.i.f(view, "view");
        super.onViewCreated(view, bundle);
        d0().f31535b.setOnClickListener(this);
        d0().f31536c.setOnClickListener(this);
    }
}
