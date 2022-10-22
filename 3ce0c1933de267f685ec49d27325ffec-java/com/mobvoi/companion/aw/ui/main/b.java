package com.mobvoi.companion.aw.ui.main;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import butterknife.ButterKnife;
import butterknife.Unbinder;
/* compiled from: BaseFragment.java */
/* loaded from: classes2.dex */
public abstract class b extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private Unbinder f16297a;

    protected abstract int Y();

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof a) {
            a aVar = (a) context;
            return;
        }
        throw new RuntimeException(context.toString() + " must extend BaseActivity");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(Y(), viewGroup, false);
        this.f16297a = ButterKnife.a(this, inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Unbinder unbinder = this.f16297a;
        if (unbinder != null) {
            unbinder.a();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (Build.VERSION.SDK_INT >= 23) {
            return;
        }
        if (activity instanceof a) {
            a aVar = (a) activity;
            return;
        }
        throw new RuntimeException(activity.toString() + " must extend BaseActivity");
    }
}
