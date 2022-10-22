package jk;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.h0;
import gk.b;
/* compiled from: BaseFragment.java */
/* loaded from: classes2.dex */
public abstract class a extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    protected b f29645a;

    public abstract int Y();

    public abstract void Z();

    public abstract void a0(View view);

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(Y(), viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f29645a.w();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        this.f29645a = (b) new h0(this).a(b.class);
        a0(view);
        Z();
    }
}
