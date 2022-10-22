package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;
import androidx.collection.b;
import i.b;
import java.lang.ref.WeakReference;
import java.util.Iterator;
/* compiled from: AppCompatDelegate.java */
/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a  reason: collision with root package name */
    private static int f518a = -100;

    /* renamed from: b  reason: collision with root package name */
    private static final b<WeakReference<f>> f519b = new b<>();

    /* renamed from: c  reason: collision with root package name */
    private static final Object f520c = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void A(f fVar) {
        synchronized (f520c) {
            B(fVar);
        }
    }

    private static void B(f fVar) {
        synchronized (f520c) {
            Iterator<WeakReference<f>> it = f519b.iterator();
            while (it.hasNext()) {
                f fVar2 = it.next().get();
                if (fVar2 == fVar || fVar2 == null) {
                    it.remove();
                }
            }
        }
    }

    public static void G(int i10) {
        if (i10 != -1 && i10 != 0 && i10 != 1 && i10 != 2 && i10 != 3) {
            Log.d("AppCompatDelegate", "setDefaultNightMode() called with an unknown mode");
        } else if (f518a != i10) {
            f518a = i10;
            f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(f fVar) {
        synchronized (f520c) {
            B(fVar);
            f519b.add(new WeakReference<>(fVar));
        }
    }

    private static void f() {
        synchronized (f520c) {
            Iterator<WeakReference<f>> it = f519b.iterator();
            while (it.hasNext()) {
                f fVar = it.next().get();
                if (fVar != null) {
                    fVar.e();
                }
            }
        }
    }

    public static f i(Activity activity, e eVar) {
        return new AppCompatDelegateImpl(activity, eVar);
    }

    public static f j(Dialog dialog, e eVar) {
        return new AppCompatDelegateImpl(dialog, eVar);
    }

    public static int l() {
        return f518a;
    }

    public abstract boolean C(int i10);

    public abstract void D(int i10);

    public abstract void E(View view);

    public abstract void F(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void H(Toolbar toolbar);

    public void I(int i10) {
    }

    public abstract void J(CharSequence charSequence);

    public abstract i.b K(b.a aVar);

    public abstract void d(View view, ViewGroup.LayoutParams layoutParams);

    public abstract boolean e();

    @Deprecated
    public void g(Context context) {
    }

    public Context h(Context context) {
        g(context);
        return context;
    }

    public abstract <T extends View> T k(int i10);

    public abstract b m();

    public int n() {
        return -100;
    }

    public abstract MenuInflater o();

    public abstract a p();

    public abstract void q();

    public abstract void r();

    public abstract void s(Configuration configuration);

    public abstract void t(Bundle bundle);

    public abstract void u();

    public abstract void v(Bundle bundle);

    public abstract void w();

    public abstract void x(Bundle bundle);

    public abstract void y();

    public abstract void z();
}
