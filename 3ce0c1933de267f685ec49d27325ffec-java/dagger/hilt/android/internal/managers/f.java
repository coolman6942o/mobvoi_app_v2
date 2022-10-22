package dagger.hilt.android.internal.managers;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.LayoutInflater;
import androidx.fragment.app.Fragment;
import qn.c;
import tn.b;
/* compiled from: FragmentComponentManager.java */
/* loaded from: classes2.dex */
public class f implements b<Object> {

    /* renamed from: a  reason: collision with root package name */
    private volatile Object f25595a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f25596b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private final Fragment f25597c;

    /* compiled from: FragmentComponentManager.java */
    /* loaded from: classes2.dex */
    public interface a {
        c i();
    }

    public f(Fragment fragment) {
        this.f25597c = fragment;
    }

    private Object a() {
        tn.c.b(this.f25597c.getHost(), "Hilt Fragments must be attached before creating the component.");
        tn.c.c(this.f25597c.getHost() instanceof b, "Hilt Fragments must be attached to an @AndroidEntryPoint Activity. Found: %s", this.f25597c.getHost().getClass());
        e(this.f25597c);
        return ((a) ln.a.a(this.f25597c.getHost(), a.class)).i().a(this.f25597c).build();
    }

    public static ContextWrapper b(Context context, Fragment fragment) {
        return new ViewComponentManager$FragmentContextWrapper(context, fragment);
    }

    public static ContextWrapper c(LayoutInflater layoutInflater, Fragment fragment) {
        return new ViewComponentManager$FragmentContextWrapper(layoutInflater, fragment);
    }

    public static final Context d(Context context) {
        while ((context instanceof ContextWrapper) && !(context instanceof Activity)) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        return context;
    }

    protected void e(Fragment fragment) {
    }

    @Override // tn.b
    public Object h() {
        if (this.f25595a == null) {
            synchronized (this.f25596b) {
                if (this.f25595a == null) {
                    this.f25595a = a();
                }
            }
        }
        return this.f25595a;
    }
}
