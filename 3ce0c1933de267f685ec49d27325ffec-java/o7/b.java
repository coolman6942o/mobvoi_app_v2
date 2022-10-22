package o7;

import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
/* compiled from: ExpandableWidgetHelper.java */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final View f31452a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f31453b = false;

    /* renamed from: c  reason: collision with root package name */
    private int f31454c = 0;

    public b(a aVar) {
        this.f31452a = (View) aVar;
    }

    private void a() {
        ViewParent parent = this.f31452a.getParent();
        if (parent instanceof CoordinatorLayout) {
            ((CoordinatorLayout) parent).f(this.f31452a);
        }
    }

    public int b() {
        return this.f31454c;
    }

    public boolean c() {
        return this.f31453b;
    }

    public void d(Bundle bundle) {
        this.f31453b = bundle.getBoolean("expanded", false);
        this.f31454c = bundle.getInt("expandedComponentIdHint", 0);
        if (this.f31453b) {
            a();
        }
    }

    public Bundle e() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("expanded", this.f31453b);
        bundle.putInt("expandedComponentIdHint", this.f31454c);
        return bundle;
    }

    public void f(int i10) {
        this.f31454c = i10;
    }
}
