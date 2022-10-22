package androidx.appcompat.app;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.appcompat.app.a;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.f0;
import androidx.appcompat.widget.z0;
import androidx.core.view.d0;
import j0.h;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ToolbarActionBar.java */
/* loaded from: classes.dex */
public class k extends androidx.appcompat.app.a {

    /* renamed from: a  reason: collision with root package name */
    final f0 f545a;

    /* renamed from: b  reason: collision with root package name */
    final Window.Callback f546b;

    /* renamed from: d  reason: collision with root package name */
    boolean f548d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f549e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f550f;

    /* renamed from: i  reason: collision with root package name */
    private final Toolbar.f f553i;

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<a.b> f551g = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    private final Runnable f552h = new a();

    /* renamed from: c  reason: collision with root package name */
    final AppCompatDelegateImpl.i f547c = new e();

    /* compiled from: ToolbarActionBar.java */
    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            k.this.D();
        }
    }

    /* compiled from: ToolbarActionBar.java */
    /* loaded from: classes.dex */
    class b implements Toolbar.f {
        b() {
        }

        @Override // androidx.appcompat.widget.Toolbar.f
        public boolean onMenuItemClick(MenuItem menuItem) {
            return k.this.f546b.onMenuItemSelected(0, menuItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ToolbarActionBar.java */
    /* loaded from: classes.dex */
    public final class c implements j.a {

        /* renamed from: a  reason: collision with root package name */
        private boolean f556a;

        c() {
        }

        @Override // androidx.appcompat.view.menu.j.a
        public void c(androidx.appcompat.view.menu.e eVar, boolean z10) {
            if (!this.f556a) {
                this.f556a = true;
                k.this.f545a.h();
                k.this.f546b.onPanelClosed(108, eVar);
                this.f556a = false;
            }
        }

        @Override // androidx.appcompat.view.menu.j.a
        public boolean d(androidx.appcompat.view.menu.e eVar) {
            k.this.f546b.onMenuOpened(108, eVar);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ToolbarActionBar.java */
    /* loaded from: classes.dex */
    public final class d implements e.a {
        d() {
        }

        @Override // androidx.appcompat.view.menu.e.a
        public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
            return false;
        }

        @Override // androidx.appcompat.view.menu.e.a
        public void b(androidx.appcompat.view.menu.e eVar) {
            if (k.this.f545a.b()) {
                k.this.f546b.onPanelClosed(108, eVar);
            } else if (k.this.f546b.onPreparePanel(0, null, eVar)) {
                k.this.f546b.onMenuOpened(108, eVar);
            }
        }
    }

    /* compiled from: ToolbarActionBar.java */
    /* loaded from: classes.dex */
    private class e implements AppCompatDelegateImpl.i {
        e() {
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.i
        public boolean a(int i10) {
            if (i10 != 0) {
                return false;
            }
            k kVar = k.this;
            if (kVar.f548d) {
                return false;
            }
            kVar.f545a.c();
            k.this.f548d = true;
            return false;
        }

        @Override // androidx.appcompat.app.AppCompatDelegateImpl.i
        public View onCreatePanelView(int i10) {
            if (i10 == 0) {
                return new View(k.this.f545a.getContext());
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(Toolbar toolbar, CharSequence charSequence, Window.Callback callback) {
        b bVar = new b();
        this.f553i = bVar;
        h.g(toolbar);
        z0 z0Var = new z0(toolbar, false);
        this.f545a = z0Var;
        this.f546b = (Window.Callback) h.g(callback);
        z0Var.setWindowCallback(callback);
        toolbar.setOnMenuItemClickListener(bVar);
        z0Var.setWindowTitle(charSequence);
    }

    private Menu C() {
        if (!this.f549e) {
            this.f545a.q(new c(), new d());
            this.f549e = true;
        }
        return this.f545a.l();
    }

    @Override // androidx.appcompat.app.a
    public void A(CharSequence charSequence) {
        this.f545a.setWindowTitle(charSequence);
    }

    void D() {
        Menu C = C();
        androidx.appcompat.view.menu.e eVar = C instanceof androidx.appcompat.view.menu.e ? (androidx.appcompat.view.menu.e) C : null;
        if (eVar != null) {
            eVar.h0();
        }
        try {
            C.clear();
            if (!this.f546b.onCreatePanelMenu(0, C) || !this.f546b.onPreparePanel(0, null, C)) {
                C.clear();
            }
        } finally {
            if (eVar != null) {
                eVar.g0();
            }
        }
    }

    public void E(int i10, int i11) {
        this.f545a.k((i10 & i11) | ((~i11) & this.f545a.u()));
    }

    @Override // androidx.appcompat.app.a
    public boolean g() {
        return this.f545a.f();
    }

    @Override // androidx.appcompat.app.a
    public boolean h() {
        if (!this.f545a.j()) {
            return false;
        }
        this.f545a.collapseActionView();
        return true;
    }

    @Override // androidx.appcompat.app.a
    public void i(boolean z10) {
        if (z10 != this.f550f) {
            this.f550f = z10;
            int size = this.f551g.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f551g.get(i10).a(z10);
            }
        }
    }

    @Override // androidx.appcompat.app.a
    public int j() {
        return this.f545a.u();
    }

    @Override // androidx.appcompat.app.a
    public Context k() {
        return this.f545a.getContext();
    }

    @Override // androidx.appcompat.app.a
    public void l() {
        this.f545a.r(8);
    }

    @Override // androidx.appcompat.app.a
    public boolean m() {
        this.f545a.s().removeCallbacks(this.f552h);
        d0.l0(this.f545a.s(), this.f552h);
        return true;
    }

    @Override // androidx.appcompat.app.a
    public void n(Configuration configuration) {
        super.n(configuration);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.appcompat.app.a
    public void o() {
        this.f545a.s().removeCallbacks(this.f552h);
    }

    @Override // androidx.appcompat.app.a
    public boolean p(int i10, KeyEvent keyEvent) {
        Menu C = C();
        if (C == null) {
            return false;
        }
        boolean z10 = true;
        if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() == 1) {
            z10 = false;
        }
        C.setQwertyMode(z10);
        return C.performShortcut(i10, keyEvent, 0);
    }

    @Override // androidx.appcompat.app.a
    public boolean q(KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1) {
            r();
        }
        return true;
    }

    @Override // androidx.appcompat.app.a
    public boolean r() {
        return this.f545a.g();
    }

    @Override // androidx.appcompat.app.a
    public void s(boolean z10) {
    }

    @Override // androidx.appcompat.app.a
    public void t(boolean z10) {
        E(z10 ? 4 : 0, 4);
    }

    @Override // androidx.appcompat.app.a
    public void u(boolean z10) {
        E(z10 ? 8 : 0, 8);
    }

    @Override // androidx.appcompat.app.a
    public void v(int i10) {
        this.f545a.v(i10);
    }

    @Override // androidx.appcompat.app.a
    public void w(int i10) {
        this.f545a.p(i10);
    }

    @Override // androidx.appcompat.app.a
    public void x(Drawable drawable) {
        this.f545a.y(drawable);
    }

    @Override // androidx.appcompat.app.a
    public void y(boolean z10) {
    }

    @Override // androidx.appcompat.app.a
    public void z(CharSequence charSequence) {
        this.f545a.setTitle(charSequence);
    }
}
