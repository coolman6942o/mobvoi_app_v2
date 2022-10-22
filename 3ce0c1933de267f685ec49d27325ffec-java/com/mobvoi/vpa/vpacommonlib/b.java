package com.mobvoi.vpa.vpacommonlib;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.w;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
/* compiled from: FragmentAdapter.java */
/* loaded from: classes2.dex */
public class b extends RecyclerView.Adapter<RecyclerView.b0> {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f20872a;

    /* renamed from: e  reason: collision with root package name */
    private FragmentManager f20876e;

    /* renamed from: d  reason: collision with root package name */
    private int f20875d = 1;

    /* renamed from: f  reason: collision with root package name */
    private boolean f20877f = false;

    /* renamed from: g  reason: collision with root package name */
    private ArrayList<FragmentData> f20878g = new ArrayList<>();

    /* renamed from: h  reason: collision with root package name */
    private ArrayList<Integer> f20879h = new ArrayList<>();

    /* renamed from: i  reason: collision with root package name */
    private RecyclerView.i f20880i = new a();

    /* renamed from: b  reason: collision with root package name */
    private final int f20873b = -1000;

    /* renamed from: c  reason: collision with root package name */
    private final int f20874c = -1000;

    /* compiled from: FragmentAdapter.java */
    /* loaded from: classes2.dex */
    class a extends RecyclerView.i {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void a() {
            super.a();
            if (!b.this.f20877f) {
                b bVar = b.this;
                bVar.o(bVar.f20878g);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void b(int i10, int i11) {
            super.b(i10, i11);
            boolean unused = b.this.f20877f;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void d(int i10, int i11) {
            super.d(i10, i11);
            if (!b.this.f20877f) {
                b.this.p(i10, i11);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void e(int i10, int i11, int i12) {
            super.e(i10, i11, i12);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.i
        public void f(int i10, int i11) {
            super.f(i10, i11);
            if (!b.this.f20877f) {
                int i12 = i10 + i11;
                b.this.j(b.this.f20878g.subList(i10, i12), i10, i11);
                int i13 = i12 - 1;
                for (int i14 = 0; i14 < i11; i14++) {
                    b.this.f20879h.remove(i13 - i14);
                }
            }
        }
    }

    /* compiled from: FragmentAdapter.java */
    /* renamed from: com.mobvoi.vpa.vpacommonlib.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0245b extends c {
        C0245b(b bVar, View view) {
            super(bVar, view);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.b0
        public String toString() {
            return "Fragment :" + super.toString();
        }
    }

    /* compiled from: FragmentAdapter.java */
    /* loaded from: classes2.dex */
    private class c extends RecyclerView.b0 {

        /* renamed from: a  reason: collision with root package name */
        private FragmentData f20882a;

        public c(b bVar, View view) {
            super(view);
        }
    }

    public b(List<FragmentData> list, FragmentManager fragmentManager) {
        this.f20876e = fragmentManager;
        this.f20878g.addAll(list);
        l();
        registerAdapterDataObserver(this.f20880i);
    }

    private void i() {
        this.f20879h.clear();
        this.f20875d = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public void j(Collection<FragmentData> collection, int i10, int i11) {
        if (this.f20876e != null) {
            w wVar = null;
            for (FragmentData fragmentData : collection) {
                Fragment b10 = fragmentData.b();
                fragmentData.f();
                if (b10 != null) {
                    if (wVar == null) {
                        wVar = this.f20876e.l();
                    }
                    wVar.r(b10);
                    this.f20876e.c0();
                }
                for (int i12 = i10; i12 < i11 + 1; i12++) {
                    RecyclerView recyclerView = this.f20872a;
                    if (recyclerView != null) {
                        RecyclerView.t recycledViewPool = recyclerView.getRecycledViewPool();
                        recycledViewPool.k(this.f20879h.get(i12).intValue(), 0);
                        recycledViewPool.k(this.f20879h.get(i12).intValue(), 5);
                    }
                }
            }
            if (wVar != null) {
                wVar.k();
                this.f20876e.c0();
            }
        }
    }

    private Fragment k(FragmentData fragmentData) {
        if (fragmentData.b() != null) {
            return fragmentData.b();
        }
        Fragment g02 = this.f20876e.g0(fragmentData.d());
        if (g02 != null) {
            return g02;
        }
        Fragment m10 = m(fragmentData);
        m10.setMenuVisibility(false);
        m10.setUserVisibleHint(false);
        return m10;
    }

    private void l() {
        Iterator<FragmentData> it = this.f20878g.iterator();
        while (it.hasNext()) {
            it.next();
            ArrayList<Integer> arrayList = this.f20879h;
            int i10 = this.f20875d;
            this.f20875d = i10 + 1;
            arrayList.add(Integer.valueOf(i10));
        }
    }

    private Fragment m(FragmentData fragmentData) {
        try {
            Class<? extends Fragment> c10 = fragmentData.c();
            Fragment newInstance = fragmentData.c().newInstance();
            if (c10 != null) {
                Bundle a10 = fragmentData.a();
                a10.setClassLoader(newInstance.getClass().getClassLoader());
                Bundle bundle = a10.getBundle("argument");
                if (bundle != null) {
                    newInstance.setArguments(bundle);
                }
            }
            return newInstance;
        } catch (Exception e10) {
            e10.printStackTrace();
            throw new RuntimeException("Error when creating Fragment Class!", e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(List<FragmentData> list) {
        ArrayList<FragmentData> arrayList = this.f20878g;
        if (list != arrayList) {
            arrayList.clear();
            this.f20878g.addAll(list);
        }
        i();
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(int i10, int i11) {
        int intValue = this.f20879h.get(i10 - 1).intValue();
        for (int i12 = 0; i12 < i11; i12++) {
            intValue++;
            this.f20879h.add(Integer.valueOf(intValue));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f20878g.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i10) {
        return this.f20879h.get(i10).intValue();
    }

    public void n(List<FragmentData> list, boolean z10) {
        if (z10) {
            o(list);
            this.f20877f = true;
            notifyDataSetChanged();
            this.f20877f = false;
            return;
        }
        ArrayList<FragmentData> arrayList = this.f20878g;
        if (list != arrayList) {
            arrayList.addAll(list);
            i();
            l();
        }
        this.f20877f = true;
        notifyItemRangeInserted(this.f20878g.size() - list.size(), list.size());
        this.f20877f = false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.f20872a = recyclerView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.b0 b0Var, int i10) {
        ((c) b0Var).f20882a = this.f20878g.get(i10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.b0 onCreateViewHolder(ViewGroup viewGroup, int i10) {
        com.mobvoi.vpa.vpacommonlib.a aVar = new com.mobvoi.vpa.vpacommonlib.a(viewGroup.getContext());
        aVar.setLayoutParams(com.mobvoi.vpa.vpacommonlib.c.a(viewGroup, this.f20873b, this.f20874c));
        aVar.setId(i10);
        return new C0245b(this, aVar);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @SuppressLint({"NewApi"})
    public void onViewAttachedToWindow(RecyclerView.b0 b0Var) {
        super.onViewAttachedToWindow(b0Var);
        FragmentData fragmentData = ((c) b0Var).f20882a;
        int id2 = b0Var.itemView.getId();
        Fragment b10 = fragmentData.b();
        if (b10 == null) {
            fragmentData.g(id2);
            b10 = k(fragmentData);
            if (b10.isAdded()) {
                this.f20876e.l().r(b10).k();
                this.f20876e.c0();
            }
            Log.d("FragmentAdapter", "refresh fragment arguments before attached");
            Bundle bundle = fragmentData.a().getBundle("argument");
            if (bundle != null) {
                b10.setArguments(bundle);
            }
            this.f20876e.l().t(id2, b10, fragmentData.d()).k();
            this.f20876e.c0();
            fragmentData.h(b10);
        }
        b10.setUserVisibleHint(true);
        b10.setMenuVisibility(true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(RecyclerView.b0 b0Var) {
        super.onViewDetachedFromWindow(b0Var);
        Fragment b10 = ((c) b0Var).f20882a.b();
        if (b10 != null) {
            b10.setUserVisibleHint(false);
            b10.setMenuVisibility(false);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.b0 b0Var) {
        super.onViewRecycled(b0Var);
    }
}
