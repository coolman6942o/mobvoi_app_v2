package i;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.widget.ActionBarContextView;
import i.b;
import java.lang.ref.WeakReference;
/* compiled from: StandaloneActionMode.java */
/* loaded from: classes.dex */
public class e extends b implements e.a {

    /* renamed from: c  reason: collision with root package name */
    private Context f27913c;

    /* renamed from: d  reason: collision with root package name */
    private ActionBarContextView f27914d;

    /* renamed from: e  reason: collision with root package name */
    private b.a f27915e;

    /* renamed from: f  reason: collision with root package name */
    private WeakReference<View> f27916f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f27917g;

    /* renamed from: h  reason: collision with root package name */
    private androidx.appcompat.view.menu.e f27918h;

    public e(Context context, ActionBarContextView actionBarContextView, b.a aVar, boolean z10) {
        this.f27913c = context;
        this.f27914d = actionBarContextView;
        this.f27915e = aVar;
        androidx.appcompat.view.menu.e W = new androidx.appcompat.view.menu.e(actionBarContextView.getContext()).W(1);
        this.f27918h = W;
        W.V(this);
    }

    @Override // androidx.appcompat.view.menu.e.a
    public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
        return this.f27915e.a(this, menuItem);
    }

    @Override // androidx.appcompat.view.menu.e.a
    public void b(androidx.appcompat.view.menu.e eVar) {
        k();
        this.f27914d.l();
    }

    @Override // i.b
    public void c() {
        if (!this.f27917g) {
            this.f27917g = true;
            this.f27915e.b(this);
        }
    }

    @Override // i.b
    public View d() {
        WeakReference<View> weakReference = this.f27916f;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // i.b
    public Menu e() {
        return this.f27918h;
    }

    @Override // i.b
    public MenuInflater f() {
        return new g(this.f27914d.getContext());
    }

    @Override // i.b
    public CharSequence g() {
        return this.f27914d.getSubtitle();
    }

    @Override // i.b
    public CharSequence i() {
        return this.f27914d.getTitle();
    }

    @Override // i.b
    public void k() {
        this.f27915e.c(this, this.f27918h);
    }

    @Override // i.b
    public boolean l() {
        return this.f27914d.j();
    }

    @Override // i.b
    public void m(View view) {
        this.f27914d.setCustomView(view);
        this.f27916f = view != null ? new WeakReference<>(view) : null;
    }

    @Override // i.b
    public void n(int i10) {
        o(this.f27913c.getString(i10));
    }

    @Override // i.b
    public void o(CharSequence charSequence) {
        this.f27914d.setSubtitle(charSequence);
    }

    @Override // i.b
    public void q(int i10) {
        r(this.f27913c.getString(i10));
    }

    @Override // i.b
    public void r(CharSequence charSequence) {
        this.f27914d.setTitle(charSequence);
    }

    @Override // i.b
    public void s(boolean z10) {
        super.s(z10);
        this.f27914d.setTitleOptional(z10);
    }
}
