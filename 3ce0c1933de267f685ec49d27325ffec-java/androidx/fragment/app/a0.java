package androidx.fragment.app;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.c0;
import androidx.lifecycle.h0;
import androidx.lifecycle.i0;
import androidx.lifecycle.j;
import androidx.lifecycle.j0;
import androidx.lifecycle.q;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.b;
import androidx.savedstate.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FragmentViewLifecycleOwner.java */
/* loaded from: classes.dex */
public class a0 implements j, c, j0 {

    /* renamed from: a  reason: collision with root package name */
    private final Fragment f3045a;

    /* renamed from: b  reason: collision with root package name */
    private final i0 f3046b;

    /* renamed from: c  reason: collision with root package name */
    private h0.b f3047c;

    /* renamed from: d  reason: collision with root package name */
    private q f3048d = null;

    /* renamed from: e  reason: collision with root package name */
    private b f3049e = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a0(Fragment fragment, i0 i0Var) {
        this.f3045a = fragment;
        this.f3046b = i0Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Lifecycle.Event event) {
        this.f3048d.h(event);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        if (this.f3048d == null) {
            this.f3048d = new q(this);
            this.f3049e = b.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        return this.f3048d != null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(Bundle bundle) {
        this.f3049e.c(bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(Bundle bundle) {
        this.f3049e.d(bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(Lifecycle.State state) {
        this.f3048d.o(state);
    }

    @Override // androidx.lifecycle.j
    public h0.b getDefaultViewModelProviderFactory() {
        h0.b defaultViewModelProviderFactory = this.f3045a.getDefaultViewModelProviderFactory();
        if (!defaultViewModelProviderFactory.equals(this.f3045a.mDefaultFactory)) {
            this.f3047c = defaultViewModelProviderFactory;
            return defaultViewModelProviderFactory;
        }
        if (this.f3047c == null) {
            Application application = null;
            Context applicationContext = this.f3045a.requireContext().getApplicationContext();
            while (true) {
                if (!(applicationContext instanceof ContextWrapper)) {
                    break;
                } else if (applicationContext instanceof Application) {
                    application = applicationContext;
                    break;
                } else {
                    applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
                }
            }
            this.f3047c = new c0(application, this, this.f3045a.getArguments());
        }
        return this.f3047c;
    }

    @Override // androidx.lifecycle.p
    public Lifecycle getLifecycle() {
        b();
        return this.f3048d;
    }

    @Override // androidx.savedstate.c
    public SavedStateRegistry getSavedStateRegistry() {
        b();
        return this.f3049e.b();
    }

    @Override // androidx.lifecycle.j0
    public i0 getViewModelStore() {
        b();
        return this.f3046b;
    }
}
