package com.mobvoi.companion.lpa;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.w;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.companion.BrowserActivity;
import com.mobvoi.companion.R;
import com.mobvoi.companion.base.perms.PermissionActivity;
import com.mobvoi.companion.browser.BasicBrowserActivity;
import com.mobvoi.wear.permission.PermissionRequestActivity;
import hc.e;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: EsimBaseFragment.kt */
/* loaded from: classes2.dex */
public abstract class g extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f17193a = {"android.permission.CAMERA"};

    /* compiled from: EsimBaseFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    static {
        new a(null);
    }

    public g(int i10) {
        super(i10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean Y() {
        androidx.fragment.app.f activity = getActivity();
        if (activity == null) {
            return false;
        }
        String[] strArr = f17193a;
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

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Z(int i10) {
        Intent intent = new Intent(getActivity(), BrowserActivity.class);
        if (i10 == R.id.esim_issues) {
            intent.putExtra("url", "https://activities.chumenwenwen.com/ticwatch-help2/aw/page/v4/help-communication-setting.html");
        }
        intent.putExtra(BasicBrowserActivity.KEY_FLAG_GOBACK, true);
        intent.putExtra(BasicBrowserActivity.KEY_TITLE, getString(R.string.item_4g_center));
        startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a0(String str) {
        Intent intent = new Intent(getActivity(), BrowserActivity.class);
        intent.putExtra("url", str);
        intent.putExtra(BasicBrowserActivity.KEY_FLAG_GOBACK, true);
        intent.putExtra(BasicBrowserActivity.KEY_TITLE, getString(R.string.item_4g_center));
        startActivity(intent);
    }

    protected final void b0(String str) {
        androidx.fragment.app.f activity = getActivity();
        i.d(activity);
        w l10 = activity.getSupportFragmentManager().l();
        i.e(l10, "activity!!.supportFragmentManager.beginTransaction()");
        g0 g0Var = new g0();
        Bundle bundle = new Bundle();
        bundle.putString("esim_select_region_extra", str);
        g0Var.setArguments(bundle);
        l10.s(R.id.fragment, g0Var);
        l10.h(null);
        l10.k();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c0() {
        Intent intent = new Intent(getActivity(), BrowserActivity.class);
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        if (i.b("zh", language)) {
            language = i.n(language, i.b("CN", locale.getCountry()) ? "_rCN" : "_rTW");
        }
        intent.putExtra("url", i.n("https://activities.chumenwenwen.com/oversea-opencard/index.html?lang=", language));
        intent.putExtra(BasicBrowserActivity.KEY_FLAG_GOBACK, false);
        startActivityForResult(intent, 1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 0 && i11 == -1) {
            c0();
        } else if (i10 == 1 && i11 == -1 && intent != null && intent.getExtras() != null) {
            Bundle extras = intent.getExtras();
            i.d(extras);
            String string = extras.getString("esim_select_region_extra");
            k.a("EsimBaseFragment", i.n("JSONStr == ", string));
            b0(string);
        }
    }
}
