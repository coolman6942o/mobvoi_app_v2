package androidx.appcompat.view.menu;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.view.menu.k;
import d.g;
import java.util.ArrayList;
/* compiled from: ListMenuPresenter.java */
/* loaded from: classes.dex */
public class c implements j, AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    Context f680a;

    /* renamed from: b  reason: collision with root package name */
    LayoutInflater f681b;

    /* renamed from: c  reason: collision with root package name */
    e f682c;

    /* renamed from: d  reason: collision with root package name */
    ExpandedMenuView f683d;

    /* renamed from: e  reason: collision with root package name */
    int f684e;

    /* renamed from: f  reason: collision with root package name */
    int f685f;

    /* renamed from: g  reason: collision with root package name */
    int f686g;

    /* renamed from: h  reason: collision with root package name */
    private j.a f687h;

    /* renamed from: i  reason: collision with root package name */
    a f688i;

    /* renamed from: j  reason: collision with root package name */
    private int f689j;

    /* compiled from: ListMenuPresenter.java */
    /* loaded from: classes.dex */
    private class a extends BaseAdapter {

        /* renamed from: a  reason: collision with root package name */
        private int f690a = -1;

        public a() {
            a();
        }

        void a() {
            g x10 = c.this.f682c.x();
            if (x10 != null) {
                ArrayList<g> B = c.this.f682c.B();
                int size = B.size();
                for (int i10 = 0; i10 < size; i10++) {
                    if (B.get(i10) == x10) {
                        this.f690a = i10;
                        return;
                    }
                }
            }
            this.f690a = -1;
        }

        /* renamed from: b */
        public g getItem(int i10) {
            ArrayList<g> B = c.this.f682c.B();
            int i11 = i10 + c.this.f684e;
            int i12 = this.f690a;
            if (i12 >= 0 && i11 >= i12) {
                i11++;
            }
            return B.get(i11);
        }

        @Override // android.widget.Adapter
        public int getCount() {
            int size = c.this.f682c.B().size() - c.this.f684e;
            return this.f690a < 0 ? size : size - 1;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i10) {
            return i10;
        }

        @Override // android.widget.Adapter
        public View getView(int i10, View view, ViewGroup viewGroup) {
            if (view == null) {
                c cVar = c.this;
                view = cVar.f681b.inflate(cVar.f686g, viewGroup, false);
            }
            ((k.a) view).e(getItem(i10), 0);
            return view;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }
    }

    public c(Context context, int i10) {
        this(i10, 0);
        this.f680a = context;
        this.f681b = LayoutInflater.from(context);
    }

    public ListAdapter a() {
        if (this.f688i == null) {
            this.f688i = new a();
        }
        return this.f688i;
    }

    public k b(ViewGroup viewGroup) {
        if (this.f683d == null) {
            this.f683d = (ExpandedMenuView) this.f681b.inflate(g.f24821g, viewGroup, false);
            if (this.f688i == null) {
                this.f688i = new a();
            }
            this.f683d.setAdapter((ListAdapter) this.f688i);
            this.f683d.setOnItemClickListener(this);
        }
        return this.f683d;
    }

    @Override // androidx.appcompat.view.menu.j
    public void c(e eVar, boolean z10) {
        j.a aVar = this.f687h;
        if (aVar != null) {
            aVar.c(eVar, z10);
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public void d(boolean z10) {
        a aVar = this.f688i;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean e() {
        return false;
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
        return this.f689j;
    }

    @Override // androidx.appcompat.view.menu.j
    public void h(j.a aVar) {
        this.f687h = aVar;
    }

    @Override // androidx.appcompat.view.menu.j
    public void i(Context context, e eVar) {
        if (this.f685f != 0) {
            ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, this.f685f);
            this.f680a = contextThemeWrapper;
            this.f681b = LayoutInflater.from(contextThemeWrapper);
        } else if (this.f680a != null) {
            this.f680a = context;
            if (this.f681b == null) {
                this.f681b = LayoutInflater.from(context);
            }
        }
        this.f682c = eVar;
        a aVar = this.f688i;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public void j(Parcelable parcelable) {
        k((Bundle) parcelable);
    }

    public void k(Bundle bundle) {
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.f683d.restoreHierarchyState(sparseParcelableArray);
        }
    }

    @Override // androidx.appcompat.view.menu.j
    public boolean l(m mVar) {
        if (!mVar.hasVisibleItems()) {
            return false;
        }
        new f(mVar).b(null);
        j.a aVar = this.f687h;
        if (aVar == null) {
            return true;
        }
        aVar.d(mVar);
        return true;
    }

    @Override // androidx.appcompat.view.menu.j
    public Parcelable m() {
        if (this.f683d == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        n(bundle);
        return bundle;
    }

    public void n(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        ExpandedMenuView expandedMenuView = this.f683d;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        this.f682c.O(this.f688i.getItem(i10), this, 0);
    }

    public c(int i10, int i11) {
        this.f686g = i10;
        this.f685f = i11;
    }
}
