package tj;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.h0;
import on.a;
import tn.b;
import tn.c;
import tn.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Hilt_FullTextFragment.java */
/* loaded from: classes2.dex */
public abstract class f extends Fragment implements b {

    /* renamed from: a  reason: collision with root package name */
    private ContextWrapper f35199a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f35200b;

    /* renamed from: c  reason: collision with root package name */
    private volatile dagger.hilt.android.internal.managers.f f35201c;

    /* renamed from: d  reason: collision with root package name */
    private final Object f35202d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private boolean f35203e = false;

    private void a0() {
        if (this.f35199a == null) {
            this.f35199a = dagger.hilt.android.internal.managers.f.b(super.getContext(), this);
            this.f35200b = a.a(super.getContext());
        }
    }

    public final dagger.hilt.android.internal.managers.f Y() {
        if (this.f35201c == null) {
            synchronized (this.f35202d) {
                if (this.f35201c == null) {
                    this.f35201c = Z();
                }
            }
        }
        return this.f35201c;
    }

    protected dagger.hilt.android.internal.managers.f Z() {
        return new dagger.hilt.android.internal.managers.f(this);
    }

    protected void b0() {
        if (!this.f35203e) {
            this.f35203e = true;
            ((e) h()).f((d) d.a(this));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public Context getContext() {
        if (super.getContext() == null && !this.f35200b) {
            return null;
        }
        a0();
        return this.f35199a;
    }

    @Override // androidx.fragment.app.Fragment, androidx.lifecycle.j
    public h0.b getDefaultViewModelProviderFactory() {
        return rn.a.b(this, super.getDefaultViewModelProviderFactory());
    }

    @Override // tn.b
    public final Object h() {
        return Y().h();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        a0();
        b0();
    }

    @Override // androidx.fragment.app.Fragment
    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        return LayoutInflater.from(dagger.hilt.android.internal.managers.f.c(super.onGetLayoutInflater(bundle), this));
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ContextWrapper contextWrapper = this.f35199a;
        c.c(contextWrapper == null || dagger.hilt.android.internal.managers.f.d(contextWrapper) == activity, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        a0();
        b0();
    }
}
