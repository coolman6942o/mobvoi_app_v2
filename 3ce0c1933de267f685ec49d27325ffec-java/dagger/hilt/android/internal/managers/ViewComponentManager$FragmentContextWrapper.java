package dagger.hilt.android.internal.managers;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.LayoutInflater;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.n;
import androidx.lifecycle.p;
import tn.c;
/* loaded from: classes2.dex */
public final class ViewComponentManager$FragmentContextWrapper extends ContextWrapper {

    /* renamed from: a  reason: collision with root package name */
    private Fragment f25577a;

    /* renamed from: b  reason: collision with root package name */
    private LayoutInflater f25578b;

    /* renamed from: c  reason: collision with root package name */
    private LayoutInflater f25579c;

    /* renamed from: d  reason: collision with root package name */
    private final n f25580d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewComponentManager$FragmentContextWrapper(Context context, Fragment fragment) {
        super((Context) c.a(context));
        n nVar = new n() { // from class: dagger.hilt.android.internal.managers.ViewComponentManager$FragmentContextWrapper.1
            @Override // androidx.lifecycle.n
            public void c(p pVar, Lifecycle.Event event) {
                if (event == Lifecycle.Event.ON_DESTROY) {
                    ViewComponentManager$FragmentContextWrapper.this.f25577a = null;
                    ViewComponentManager$FragmentContextWrapper.this.f25578b = null;
                    ViewComponentManager$FragmentContextWrapper.this.f25579c = null;
                }
            }
        };
        this.f25580d = nVar;
        this.f25578b = null;
        Fragment fragment2 = (Fragment) c.a(fragment);
        this.f25577a = fragment2;
        fragment2.getLifecycle().a(nVar);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f25579c == null) {
            if (this.f25578b == null) {
                this.f25578b = (LayoutInflater) getBaseContext().getSystemService("layout_inflater");
            }
            this.f25579c = this.f25578b.cloneInContext(this);
        }
        return this.f25579c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewComponentManager$FragmentContextWrapper(LayoutInflater layoutInflater, Fragment fragment) {
        super((Context) c.a(((LayoutInflater) c.a(layoutInflater)).getContext()));
        n nVar = new n() { // from class: dagger.hilt.android.internal.managers.ViewComponentManager$FragmentContextWrapper.1
            @Override // androidx.lifecycle.n
            public void c(p pVar, Lifecycle.Event event) {
                if (event == Lifecycle.Event.ON_DESTROY) {
                    ViewComponentManager$FragmentContextWrapper.this.f25577a = null;
                    ViewComponentManager$FragmentContextWrapper.this.f25578b = null;
                    ViewComponentManager$FragmentContextWrapper.this.f25579c = null;
                }
            }
        };
        this.f25580d = nVar;
        this.f25578b = layoutInflater;
        Fragment fragment2 = (Fragment) c.a(fragment);
        this.f25577a = fragment2;
        fragment2.getLifecycle().a(nVar);
    }
}
