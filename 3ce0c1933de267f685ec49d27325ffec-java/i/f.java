package i;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import i.b;
import j.c;
import j.d;
import java.util.ArrayList;
/* compiled from: SupportActionModeWrapper.java */
/* loaded from: classes.dex */
public class f extends ActionMode {

    /* renamed from: a  reason: collision with root package name */
    final Context f27919a;

    /* renamed from: b  reason: collision with root package name */
    final b f27920b;

    /* compiled from: SupportActionModeWrapper.java */
    /* loaded from: classes.dex */
    public static class a implements b.a {

        /* renamed from: a  reason: collision with root package name */
        final ActionMode.Callback f27921a;

        /* renamed from: b  reason: collision with root package name */
        final Context f27922b;

        /* renamed from: c  reason: collision with root package name */
        final ArrayList<f> f27923c = new ArrayList<>();

        /* renamed from: d  reason: collision with root package name */
        final androidx.collection.f<Menu, Menu> f27924d = new androidx.collection.f<>();

        public a(Context context, ActionMode.Callback callback) {
            this.f27922b = context;
            this.f27921a = callback;
        }

        private Menu f(Menu menu) {
            Menu menu2 = this.f27924d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            d dVar = new d(this.f27922b, (d0.a) menu);
            this.f27924d.put(menu, dVar);
            return dVar;
        }

        @Override // i.b.a
        public boolean a(b bVar, MenuItem menuItem) {
            return this.f27921a.onActionItemClicked(e(bVar), new c(this.f27922b, (d0.b) menuItem));
        }

        @Override // i.b.a
        public void b(b bVar) {
            this.f27921a.onDestroyActionMode(e(bVar));
        }

        @Override // i.b.a
        public boolean c(b bVar, Menu menu) {
            return this.f27921a.onPrepareActionMode(e(bVar), f(menu));
        }

        @Override // i.b.a
        public boolean d(b bVar, Menu menu) {
            return this.f27921a.onCreateActionMode(e(bVar), f(menu));
        }

        public ActionMode e(b bVar) {
            int size = this.f27923c.size();
            for (int i10 = 0; i10 < size; i10++) {
                f fVar = this.f27923c.get(i10);
                if (fVar != null && fVar.f27920b == bVar) {
                    return fVar;
                }
            }
            f fVar2 = new f(this.f27922b, bVar);
            this.f27923c.add(fVar2);
            return fVar2;
        }
    }

    public f(Context context, b bVar) {
        this.f27919a = context;
        this.f27920b = bVar;
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.f27920b.c();
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.f27920b.d();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return new d(this.f27919a, (d0.a) this.f27920b.e());
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.f27920b.f();
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.f27920b.g();
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.f27920b.h();
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.f27920b.i();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.f27920b.j();
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.f27920b.k();
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.f27920b.l();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.f27920b.m(view);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.f27920b.o(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.f27920b.p(obj);
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.f27920b.r(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z10) {
        this.f27920b.s(z10);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i10) {
        this.f27920b.n(i10);
    }

    @Override // android.view.ActionMode
    public void setTitle(int i10) {
        this.f27920b.q(i10);
    }
}
