package com.google.android.material.tabs;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import java.lang.ref.WeakReference;
/* compiled from: TabLayoutMediator.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private final TabLayout f11405a;

    /* renamed from: b  reason: collision with root package name */
    private final ViewPager2 f11406b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f11407c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f11408d;

    /* renamed from: e  reason: collision with root package name */
    private final b f11409e;

    /* renamed from: f  reason: collision with root package name */
    private RecyclerView.Adapter<?> f11410f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f11411g;

    /* renamed from: h  reason: collision with root package name */
    private C0130c f11412h;

    /* renamed from: i  reason: collision with root package name */
    private TabLayout.d f11413i;

    /* renamed from: j  reason: collision with root package name */
    private RecyclerView.i f11414j;

    /* compiled from: TabLayoutMediator.java */
    /* loaded from: classes.dex */
    private class a extends RecyclerView.i {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void a() {
            c.this.b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void b(int i10, int i11) {
            c.this.b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void c(int i10, int i11, Object obj) {
            c.this.b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void d(int i10, int i11) {
            c.this.b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void e(int i10, int i11, int i12) {
            c.this.b();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void f(int i10, int i11) {
            c.this.b();
        }
    }

    /* compiled from: TabLayoutMediator.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(TabLayout.g gVar, int i10);
    }

    /* compiled from: TabLayoutMediator.java */
    /* renamed from: com.google.android.material.tabs.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0130c extends ViewPager2.i {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<TabLayout> f11416a;

        /* renamed from: b  reason: collision with root package name */
        private int f11417b;

        /* renamed from: c  reason: collision with root package name */
        private int f11418c;

        C0130c(TabLayout tabLayout) {
            this.f11416a = new WeakReference<>(tabLayout);
            d();
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void a(int i10) {
            this.f11417b = this.f11418c;
            this.f11418c = i10;
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void b(int i10, float f10, int i11) {
            TabLayout tabLayout = this.f11416a.get();
            if (tabLayout != null) {
                int i12 = this.f11418c;
                boolean z10 = false;
                boolean z11 = i12 != 2 || this.f11417b == 1;
                if (!(i12 == 2 && this.f11417b == 0)) {
                    z10 = true;
                }
                tabLayout.J(i10, f10, z11, z10);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void c(int i10) {
            TabLayout tabLayout = this.f11416a.get();
            if (tabLayout != null && tabLayout.getSelectedTabPosition() != i10 && i10 < tabLayout.getTabCount()) {
                int i11 = this.f11418c;
                tabLayout.G(tabLayout.x(i10), i11 == 0 || (i11 == 2 && this.f11417b == 0));
            }
        }

        void d() {
            this.f11418c = 0;
            this.f11417b = 0;
        }
    }

    /* compiled from: TabLayoutMediator.java */
    /* loaded from: classes.dex */
    private static class d implements TabLayout.d {

        /* renamed from: a  reason: collision with root package name */
        private final ViewPager2 f11419a;

        /* renamed from: b  reason: collision with root package name */
        private final boolean f11420b;

        d(ViewPager2 viewPager2, boolean z10) {
            this.f11419a = viewPager2;
            this.f11420b = z10;
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void a(TabLayout.g gVar) {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void b(TabLayout.g gVar) {
            this.f11419a.j(gVar.g(), this.f11420b);
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void c(TabLayout.g gVar) {
        }
    }

    public c(TabLayout tabLayout, ViewPager2 viewPager2, b bVar) {
        this(tabLayout, viewPager2, true, bVar);
    }

    public void a() {
        if (!this.f11411g) {
            RecyclerView.Adapter<?> adapter = this.f11406b.getAdapter();
            this.f11410f = adapter;
            if (adapter != null) {
                this.f11411g = true;
                C0130c cVar = new C0130c(this.f11405a);
                this.f11412h = cVar;
                this.f11406b.g(cVar);
                d dVar = new d(this.f11406b, this.f11408d);
                this.f11413i = dVar;
                this.f11405a.d(dVar);
                if (this.f11407c) {
                    a aVar = new a();
                    this.f11414j = aVar;
                    this.f11410f.registerAdapterDataObserver(aVar);
                }
                b();
                this.f11405a.I(this.f11406b.getCurrentItem(), 0.0f, true);
                return;
            }
            throw new IllegalStateException("TabLayoutMediator attached before ViewPager2 has an adapter");
        }
        throw new IllegalStateException("TabLayoutMediator is already attached");
    }

    void b() {
        this.f11405a.C();
        RecyclerView.Adapter<?> adapter = this.f11410f;
        if (adapter != null) {
            int itemCount = adapter.getItemCount();
            for (int i10 = 0; i10 < itemCount; i10++) {
                TabLayout.g z10 = this.f11405a.z();
                this.f11409e.a(z10, i10);
                this.f11405a.g(z10, false);
            }
            if (itemCount > 0) {
                int min = Math.min(this.f11406b.getCurrentItem(), this.f11405a.getTabCount() - 1);
                if (min != this.f11405a.getSelectedTabPosition()) {
                    TabLayout tabLayout = this.f11405a;
                    tabLayout.F(tabLayout.x(min));
                }
            }
        }
    }

    public c(TabLayout tabLayout, ViewPager2 viewPager2, boolean z10, b bVar) {
        this(tabLayout, viewPager2, z10, true, bVar);
    }

    public c(TabLayout tabLayout, ViewPager2 viewPager2, boolean z10, boolean z11, b bVar) {
        this.f11405a = tabLayout;
        this.f11406b = viewPager2;
        this.f11407c = z10;
        this.f11408d = z11;
        this.f11409e = bVar;
    }
}
