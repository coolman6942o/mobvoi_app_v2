package zi;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.f;
import androidx.fragment.app.w;
import com.mobvoi.companion.BrowserActivity;
import com.mobvoi.companion.R;
import com.mobvoi.companion.base.perms.PermissionActivity;
import com.mobvoi.companion.browser.BasicBrowserActivity;
import com.mobvoi.wear.permission.PermissionRequestActivity;
import hc.e;
/* compiled from: OfflineSimTutorialFragment.java */
/* loaded from: classes2.dex */
public class b extends Fragment implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f37610a = {"android.permission.CAMERA"};

    private boolean Y() {
        f activity = getActivity();
        String[] strArr = f37610a;
        if (e.i(activity, strArr)) {
            return true;
        }
        String string = getString(R.string.camera_permission_rational_text);
        Intent intent = new Intent(getActivity(), PermissionActivity.class);
        intent.putExtra(PermissionRequestActivity.EXTRAS_KEY_PERMISSIONS, strArr);
        intent.putExtra(PermissionRequestActivity.EXTRAS_KEY_RATIONALE_MSG, string);
        intent.putExtra(PermissionRequestActivity.EXTRAS_KEY_GO_SETTINGS_MSG, string);
        intent.addFlags(4194304);
        startActivityForResult(intent, 0);
        return false;
    }

    private void Z() {
        w l10 = getActivity().getSupportFragmentManager().l();
        l10.s(R.id.fragment, new d());
        l10.h(null);
        l10.k();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 0 && i11 == -1) {
            Z();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.see_regions) {
            Intent intent = new Intent(getActivity(), BrowserActivity.class);
            intent.putExtra("url", "https://activities.mobvoi.com/ticwatch-help2/aw-zh/page/v4/help-regional.html?system=android&version=4g");
            intent.putExtra(BasicBrowserActivity.KEY_FLAG_GOBACK, true);
            intent.putExtra(BasicBrowserActivity.KEY_TITLE, getString(R.string.item_4g_center));
            getActivity().startActivity(intent);
        } else if (view.getId() == R.id.open_now && Y()) {
            Z();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_offline_sim, viewGroup, false);
        inflate.findViewById(R.id.see_regions).setOnClickListener(this);
        inflate.findViewById(R.id.open_now).setOnClickListener(this);
        return inflate;
    }
}
