package nf;

import a0.h;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.mobvoi.android.common.utils.k;
import eg.f;
/* compiled from: BaseFragment.java */
/* loaded from: classes2.dex */
public class b extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private static final String f31229a = f.f26043a + "ui.base";

    public final int Y(int i10) {
        return h.d(getResources(), i10, requireActivity().getTheme());
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        k.p(f31229a, "%s:onCreate", getClass().getSimpleName());
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.p(f31229a, "%s:onCreateView", getClass().getSimpleName());
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        k.p(f31229a, "%s:onDestroy", getClass().getSimpleName());
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        k.p(f31229a, "%s:onDestroyView", getClass().getSimpleName());
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        k.p(f31229a, "%s:onPause", getClass().getSimpleName());
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        k.p(f31229a, "%s:onResume", getClass().getSimpleName());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        k.p(f31229a, "%s:onStart", getClass().getSimpleName());
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        k.p(f31229a, "%s:onStop", getClass().getSimpleName());
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        k.p(f31229a, "%s:onViewCreated", getClass().getSimpleName());
    }
}
