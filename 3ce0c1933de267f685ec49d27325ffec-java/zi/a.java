package zi;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.w;
import com.mobvoi.companion.BrowserActivity;
import com.mobvoi.companion.R;
import com.mobvoi.companion.browser.BasicBrowserActivity;
import yd.q;
/* compiled from: JupiterSimTutorialFragment.java */
/* loaded from: classes2.dex */
public class a extends Fragment implements View.OnClickListener {
    private void Y(int i10) {
        Intent intent = new Intent(getActivity(), BrowserActivity.class);
        if (i10 == R.id.how_to_open) {
            intent.putExtra("url", "https://activities.mobvoi.com/ticwatch-help2/aw-zh/page/v5/esim-gtw.html");
        } else if (i10 == R.id.open_online) {
            intent.putExtra("url", "http://activities.chumenwenwen.com/ticwatch-help2/aw-zh/page/esim-guide.html?type=pro3");
        }
        intent.putExtra(BasicBrowserActivity.KEY_FLAG_GOBACK, true);
        intent.putExtra(BasicBrowserActivity.KEY_TITLE, getString(R.string.item_4g_center));
        getActivity().startActivity(intent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id2 = view.getId();
        int i10 = R.id.how_to_open;
        if (id2 == i10) {
            Y(i10);
            return;
        }
        int id3 = view.getId();
        int i11 = R.id.open_online;
        if (id3 == i11) {
            Y(i11);
        } else if (view.getId() == R.id.open_offline) {
            w l10 = getActivity().getSupportFragmentManager().l();
            l10.s(R.id.fragment, new b());
            l10.h(null);
            l10.k();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_jupiter_sim_tutorial, viewGroup, false);
        inflate.findViewById(R.id.how_to_open).setOnClickListener(this);
        inflate.findViewById(R.id.open_online).setOnClickListener(this);
        inflate.findViewById(R.id.open_offline).setOnClickListener(this);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        q.d(getActivity());
    }
}
