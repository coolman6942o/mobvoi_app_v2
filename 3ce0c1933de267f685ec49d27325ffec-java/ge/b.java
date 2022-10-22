package ge;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.mobvoi.device.DeviceListFragment;
import je.a;
import kc.f;
/* compiled from: DeviceContainerFragment.java */
/* loaded from: classes2.dex */
public class b extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private a f27399a;

    /* renamed from: b  reason: collision with root package name */
    private FragmentManager f27400b;

    protected void Y() {
        if (this.f27400b == null) {
            this.f27400b = getChildFragmentManager();
        }
        if (Z()) {
            b0(new i(), "DeviceMain");
        } else {
            b0(new DeviceListFragment(), "DeviceList");
        }
    }

    protected boolean Z() {
        return !TextUtils.isEmpty(ta.a.s());
    }

    public void a0() {
        Y();
    }

    public void b0(Fragment fragment, String str) {
        this.f27400b.l().s(this.f27399a.f29552b.getId(), fragment).h(str).k();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f27399a = a.d(layoutInflater);
        Y();
        this.f27399a.f29552b.setPaddingRelative(0, f.b(), 0, 0);
        return this.f27399a.a();
    }
}
