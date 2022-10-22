package com.mobvoi.companion.lpa;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import com.mobvoi.android.common.ui.viewbinding.FragmentViewBindingDelegate;
import com.mobvoi.companion.R;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.l;
import kotlin.reflect.KProperty;
import oc.i;
/* compiled from: EsimHelpPageRow.kt */
/* loaded from: classes2.dex */
public final class h extends g implements View.OnClickListener {

    /* renamed from: d  reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f17198d = {l.h(new PropertyReference1Impl(l.b(h.class), "viewBinding", "getViewBinding()Lcom/mobvoi/companion/databinding/FragmentEsimHelpRowBinding;"))};

    /* renamed from: b  reason: collision with root package name */
    private boolean f17199b = true;

    /* renamed from: c  reason: collision with root package name */
    private final FragmentViewBindingDelegate f17200c = com.mobvoi.android.common.ui.viewbinding.a.b(this, b.INSTANCE);

    /* compiled from: EsimHelpPageRow.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: EsimHelpPageRow.kt */
    /* loaded from: classes2.dex */
    /* synthetic */ class b extends FunctionReferenceImpl implements qo.l<View, i> {
        public static final b INSTANCE = new b();

        b() {
            super(1, i.class, "bind", "bind(Landroid/view/View;)Lcom/mobvoi/companion/databinding/FragmentEsimHelpRowBinding;", 0);
        }

        /* renamed from: g */
        public final i invoke(View p02) {
            kotlin.jvm.internal.i.f(p02, "p0");
            return i.b(p02);
        }
    }

    static {
        new a(null);
    }

    public h() {
        super(R.layout.fragment_esim_help_row);
    }

    private final i d0() {
        return (i) this.f17200c.b(this, f17198d[0]);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v10) {
        kotlin.jvm.internal.i.f(v10, "v");
        if (v10.getId() == R.id.function_btn) {
            if (!this.f17199b) {
                a0("https://activities.chumenwenwen.com/ticwatch-help2/aw/page/v4/help-communication-setting.html");
            } else if (Y()) {
                c0();
            }
        } else if (v10.getId() == R.id.esim_issues) {
            a0("https://activities.chumenwenwen.com/ticwatch-help2/aw/page/v4/help-communication-setting.html");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        kotlin.jvm.internal.i.f(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            Drawable drawable = null;
            if (kotlin.jvm.internal.i.b("regiion_us", arguments.getString("regiion"))) {
                if (getActivity() != null) {
                    androidx.fragment.app.f activity = getActivity();
                    kotlin.jvm.internal.i.d(activity);
                    drawable = androidx.core.content.b.e(activity, R.drawable.esim_us_android);
                }
                d0().f31531c.setImageDrawable(drawable);
                d0().f31532d.setText(R.string.esim_us_intro);
                d0().f31533e.setText(R.string.esim_faq);
                d0().f31530b.setVisibility(8);
                this.f17199b = false;
            } else if (kotlin.jvm.internal.i.b("regiion_eu", arguments.getString("regiion"))) {
                if (getActivity() != null) {
                    androidx.fragment.app.f activity2 = getActivity();
                    kotlin.jvm.internal.i.d(activity2);
                    drawable = androidx.core.content.b.e(activity2, R.drawable.esim_eu_android);
                }
                d0().f31531c.setImageDrawable(drawable);
                d0().f31532d.setText(R.string.esim_eu_intro);
                d0().f31533e.setText(R.string.esim_scan_qr);
                d0().f31530b.getPaint().setFlags(8);
            }
        }
        d0().f31533e.setOnClickListener(this);
        d0().f31530b.setOnClickListener(this);
    }
}
