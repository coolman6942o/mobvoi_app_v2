package j;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.collection.f;
import d0.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BaseMenuWrapper.java */
/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a  reason: collision with root package name */
    final Context f29349a;

    /* renamed from: b  reason: collision with root package name */
    private f<d0.b, MenuItem> f29350b;

    /* renamed from: c  reason: collision with root package name */
    private f<c, SubMenu> f29351c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context) {
        this.f29349a = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final MenuItem c(MenuItem menuItem) {
        if (!(menuItem instanceof d0.b)) {
            return menuItem;
        }
        d0.b bVar = (d0.b) menuItem;
        if (this.f29350b == null) {
            this.f29350b = new f<>();
        }
        MenuItem menuItem2 = this.f29350b.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        c cVar = new c(this.f29349a, bVar);
        this.f29350b.put(bVar, cVar);
        return cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final SubMenu d(SubMenu subMenu) {
        if (!(subMenu instanceof c)) {
            return subMenu;
        }
        c cVar = (c) subMenu;
        if (this.f29351c == null) {
            this.f29351c = new f<>();
        }
        SubMenu subMenu2 = this.f29351c.get(cVar);
        if (subMenu2 != null) {
            return subMenu2;
        }
        f fVar = new f(this.f29349a, cVar);
        this.f29351c.put(cVar, fVar);
        return fVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e() {
        f<d0.b, MenuItem> fVar = this.f29350b;
        if (fVar != null) {
            fVar.clear();
        }
        f<c, SubMenu> fVar2 = this.f29351c;
        if (fVar2 != null) {
            fVar2.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void f(int i10) {
        if (this.f29350b != null) {
            int i11 = 0;
            while (i11 < this.f29350b.size()) {
                if (this.f29350b.j(i11).getGroupId() == i10) {
                    this.f29350b.l(i11);
                    i11--;
                }
                i11++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void g(int i10) {
        if (this.f29350b != null) {
            for (int i11 = 0; i11 < this.f29350b.size(); i11++) {
                if (this.f29350b.j(i11).getItemId() == i10) {
                    this.f29350b.l(i11);
                    return;
                }
            }
        }
    }
}
