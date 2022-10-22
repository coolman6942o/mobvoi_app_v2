package com.mobvoi.companion.lpa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.mobvoi.android.common.ui.viewbinding.FragmentViewBindingDelegate;
import com.mobvoi.companion.BrowserActivity;
import com.mobvoi.companion.R;
import com.mobvoi.companion.base.perms.PermissionActivity;
import com.mobvoi.companion.browser.BasicBrowserActivity;
import com.mobvoi.wear.permission.PermissionRequestActivity;
import hc.e;
import java.util.Arrays;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.l;
import kotlin.reflect.KProperty;
import oc.m;
/* compiled from: OfflineSimTutorialFragment.kt */
/* loaded from: classes2.dex */
public final class w extends Fragment implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f17242b = {l.h(new PropertyReference1Impl(l.b(w.class), "viewBinding", "getViewBinding()Lcom/mobvoi/companion/databinding/FragmentOfflineSimBinding;"))};

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f17243c = {"android.permission.CAMERA"};

    /* renamed from: a  reason: collision with root package name */
    private final FragmentViewBindingDelegate f17244a = com.mobvoi.android.common.ui.viewbinding.a.b(this, b.INSTANCE);

    /* compiled from: OfflineSimTutorialFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: OfflineSimTutorialFragment.kt */
    /* loaded from: classes2.dex */
    /* synthetic */ class b extends FunctionReferenceImpl implements qo.l<View, m> {
        public static final b INSTANCE = new b();

        b() {
            super(1, m.class, "bind", "bind(Landroid/view/View;)Lcom/mobvoi/companion/databinding/FragmentOfflineSimBinding;", 0);
        }

        /* renamed from: g */
        public final m invoke(View p02) {
            i.f(p02, "p0");
            return m.b(p02);
        }
    }

    static {
        new a(null);
    }

    public w() {
        super(R.layout.fragment_offline_sim);
    }

    private final boolean Y() {
        androidx.fragment.app.f activity = getActivity();
        i.d(activity);
        String[] strArr = f17243c;
        if (e.i(activity, (String[]) Arrays.copyOf(strArr, strArr.length))) {
            return true;
        }
        String string = getString(R.string.camera_permission_rational_text);
        i.e(string, "getString(R.string.camera_permission_rational_text)");
        Intent intent = new Intent(getActivity(), PermissionActivity.class);
        intent.putExtra(PermissionRequestActivity.EXTRAS_KEY_PERMISSIONS, strArr);
        intent.putExtra(PermissionRequestActivity.EXTRAS_KEY_RATIONALE_MSG, string);
        intent.putExtra(PermissionRequestActivity.EXTRAS_KEY_GO_SETTINGS_MSG, string);
        intent.addFlags(4194304);
        startActivityForResult(intent, 0);
        return false;
    }

    private final m Z() {
        return (m) this.f17244a.b(this, f17242b[0]);
    }

    private final void a0() {
        androidx.fragment.app.f activity = getActivity();
        i.d(activity);
        androidx.fragment.app.w l10 = activity.getSupportFragmentManager().l();
        i.e(l10, "activity!!.supportFragmentManager.beginTransaction()");
        l10.s(R.id.fragment, new g0());
        l10.h(null);
        l10.k();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 0 && i11 == -1) {
            a0();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v10) {
        i.f(v10, "v");
        if (getActivity() != null) {
            if (v10.getId() == R.id.see_regions) {
                Intent intent = new Intent(getActivity(), BrowserActivity.class);
                intent.putExtra("url", "https://activities.mobvoi.com/ticwatch-help2/aw-zh/page/v4/help-regional.html?system=android&version=4g");
                intent.putExtra(BasicBrowserActivity.KEY_FLAG_GOBACK, true);
                intent.putExtra(BasicBrowserActivity.KEY_TITLE, getString(R.string.item_4g_center));
                androidx.fragment.app.f activity = getActivity();
                i.d(activity);
                activity.startActivity(intent);
            } else if (v10.getId() == R.id.open_now && Y()) {
                a0();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        i.f(view, "view");
        super.onViewCreated(view, bundle);
        Z().f31549c.setOnClickListener(this);
        Z().f31548b.setOnClickListener(this);
    }
}
