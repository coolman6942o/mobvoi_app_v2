package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.k;
import java.util.ArrayList;
/* compiled from: BaseMenuPresenter.java */
/* loaded from: classes.dex */
public abstract class a implements j {

    /* renamed from: a  reason: collision with root package name */
    protected Context f636a;

    /* renamed from: b  reason: collision with root package name */
    protected Context f637b;

    /* renamed from: c  reason: collision with root package name */
    protected e f638c;

    /* renamed from: d  reason: collision with root package name */
    protected LayoutInflater f639d;

    /* renamed from: e  reason: collision with root package name */
    private j.a f640e;

    /* renamed from: f  reason: collision with root package name */
    private int f641f;

    /* renamed from: g  reason: collision with root package name */
    private int f642g;

    /* renamed from: h  reason: collision with root package name */
    protected k f643h;

    /* renamed from: i  reason: collision with root package name */
    private int f644i;

    public a(Context context, int i10, int i11) {
        this.f636a = context;
        this.f639d = LayoutInflater.from(context);
        this.f641f = i10;
        this.f642g = i11;
    }

    protected void a(View view, int i10) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f643h).addView(view, i10);
    }

    public abstract void b(g gVar, k.a aVar);

    @Override // androidx.appcompat.view.menu.j
    public void c(e eVar, boolean z10) {
        j.a aVar = this.f640e;
        if (aVar != null) {
            aVar.c(eVar, z10);
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public void d(boolean z10) {
        ViewGroup viewGroup = (ViewGroup) this.f643h;
        if (viewGroup != null) {
            e eVar = this.f638c;
            int i10 = 0;
            if (eVar != null) {
                eVar.t();
                ArrayList<g> G = this.f638c.G();
                int size = G.size();
                int i11 = 0;
                for (int i12 = 0; i12 < size; i12++) {
                    g gVar = G.get(i12);
                    if (s(i11, gVar)) {
                        View childAt = viewGroup.getChildAt(i11);
                        g itemData = childAt instanceof k.a ? ((k.a) childAt).getItemData() : null;
                        View p10 = p(gVar, childAt, viewGroup);
                        if (gVar != itemData) {
                            p10.setPressed(false);
                            p10.jumpDrawablesToCurrentState();
                        }
                        if (p10 != childAt) {
                            a(p10, i11);
                        }
                        i11++;
                    }
                }
                i10 = i11;
            }
            while (i10 < viewGroup.getChildCount()) {
                if (!n(viewGroup, i10)) {
                    i10++;
                }
            }
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean f(e eVar, g gVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean g(e eVar, g gVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.j
    public int getId() {
        return this.f644i;
    }

    @Override // androidx.appcompat.view.menu.j
    public void h(j.a aVar) {
        this.f640e = aVar;
    }

    @Override // androidx.appcompat.view.menu.j
    public void i(Context context, e eVar) {
        this.f637b = context;
        LayoutInflater.from(context);
        this.f638c = eVar;
    }

    public k.a k(ViewGroup viewGroup) {
        return (k.a) this.f639d.inflate(this.f642g, viewGroup, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [androidx.appcompat.view.menu.e] */
    @Override // androidx.appcompat.view.menu.j
    public boolean l(m mVar) {
        j.a aVar = this.f640e;
        m mVar2 = mVar;
        if (aVar == null) {
            return false;
        }
        if (mVar == null) {
            mVar2 = this.f638c;
        }
        return aVar.d(mVar2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean n(ViewGroup viewGroup, int i10) {
        viewGroup.removeViewAt(i10);
        return true;
    }

    public j.a o() {
        return this.f640e;
    }

    public View p(g gVar, View view, ViewGroup viewGroup) {
        k.a aVar;
        if (view instanceof k.a) {
            aVar = (k.a) view;
        } else {
            aVar = k(viewGroup);
        }
        b(gVar, aVar);
        return (View) aVar;
    }

    public k q(ViewGroup viewGroup) {
        if (this.f643h == null) {
            k kVar = (k) this.f639d.inflate(this.f641f, viewGroup, false);
            this.f643h = kVar;
            kVar.b(this.f638c);
            d(true);
        }
        return this.f643h;
    }

    public void r(int i10) {
        this.f644i = i10;
    }

    public abstract boolean s(int i10, g gVar);
}
