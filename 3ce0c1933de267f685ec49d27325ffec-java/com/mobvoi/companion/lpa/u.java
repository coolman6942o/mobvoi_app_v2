package com.mobvoi.companion.lpa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.w;
import com.mobvoi.android.common.ui.viewbinding.FragmentViewBindingDelegate;
import com.mobvoi.companion.BrowserActivity;
import com.mobvoi.companion.R;
import com.mobvoi.companion.browser.BasicBrowserActivity;
import com.mobvoi.companion.setting.CompanionSetting;
import com.mobvoi.wear.common.base.TicwatchModels;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.l;
import kotlin.reflect.KProperty;
import yd.q;
/* compiled from: JupiterSimTutorialFragment.kt */
/* loaded from: classes2.dex */
public final class u extends Fragment implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f17239b = {l.h(new PropertyReference1Impl(l.b(u.class), "viewBinding", "getViewBinding()Lcom/mobvoi/companion/databinding/FragmentJupiterSimTutorialBinding;"))};

    /* renamed from: a  reason: collision with root package name */
    private final FragmentViewBindingDelegate f17240a = com.mobvoi.android.common.ui.viewbinding.a.b(this, b.INSTANCE);

    /* compiled from: JupiterSimTutorialFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: JupiterSimTutorialFragment.kt */
    /* loaded from: classes2.dex */
    /* synthetic */ class b extends FunctionReferenceImpl implements qo.l<View, oc.l> {
        public static final b INSTANCE = new b();

        b() {
            super(1, oc.l.class, "bind", "bind(Landroid/view/View;)Lcom/mobvoi/companion/databinding/FragmentJupiterSimTutorialBinding;", 0);
        }

        /* renamed from: g */
        public final oc.l invoke(View p02) {
            i.f(p02, "p0");
            return oc.l.b(p02);
        }
    }

    static {
        new a(null);
    }

    public u() {
        super(R.layout.fragment_jupiter_sim_tutorial);
    }

    private final oc.l Y() {
        return (oc.l) this.f17240a.b(this, f17239b[0]);
    }

    private final void Z(int i10) {
        if (getActivity() != null) {
            Intent intent = new Intent(getActivity(), BrowserActivity.class);
            boolean z10 = TicwatchModels.isRover(CompanionSetting.getWearModel()) || TicwatchModels.isRover3X(CompanionSetting.getWearModel());
            if (i10 == R.id.how_to_open) {
                if (z10) {
                    intent.putExtra("url", "https://activities.mobvoi.com/ticwatch-help2/aw-zh/page/v4/help-setting-new.html?type=pro3");
                } else {
                    intent.putExtra("url", "https://activities.mobvoi.com/ticwatch-help2/aw-zh/page/v4/help-setting-new.html");
                }
            } else if (i10 == R.id.open_online) {
                if (z10) {
                    intent.putExtra("url", "http://activities.chumenwenwen.com/ticwatch-help2/aw-zh/page/esim-guide.html?type=pro3");
                } else {
                    intent.putExtra("url", "http://activities.chumenwenwen.com/ticwatch-help2/aw-zh/page/esim-guide.html");
                }
            }
            intent.putExtra(BasicBrowserActivity.KEY_FLAG_GOBACK, true);
            intent.putExtra(BasicBrowserActivity.KEY_TITLE, getString(R.string.item_4g_center));
            androidx.fragment.app.f activity = getActivity();
            i.d(activity);
            activity.startActivity(intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v10) {
        i.f(v10, "v");
        int id2 = v10.getId();
        int i10 = R.id.how_to_open;
        if (id2 == i10) {
            Z(i10);
            return;
        }
        int i11 = R.id.open_online;
        if (id2 == i11) {
            Z(i11);
        } else if (id2 == R.id.open_offline) {
            androidx.fragment.app.f activity = getActivity();
            i.d(activity);
            w l10 = activity.getSupportFragmentManager().l();
            i.e(l10, "activity!!.supportFragmentManager.beginTransaction()");
            l10.s(R.id.fragment, new w());
            l10.h(null);
            l10.k();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        q.d(getActivity());
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        i.f(view, "view");
        super.onViewCreated(view, bundle);
        Y().f31544b.setOnClickListener(this);
        Y().f31546d.setOnClickListener(this);
        Y().f31545c.setOnClickListener(this);
    }
}
