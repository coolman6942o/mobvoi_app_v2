package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.d0;
import java.util.Map;
import java.util.WeakHashMap;
import k0.c;
import k0.d;
/* compiled from: RecyclerViewAccessibilityDelegate.java */
/* loaded from: classes.dex */
public class o extends androidx.core.view.a {

    /* renamed from: d  reason: collision with root package name */
    final RecyclerView f4110d;

    /* renamed from: e  reason: collision with root package name */
    private final a f4111e;

    /* compiled from: RecyclerViewAccessibilityDelegate.java */
    /* loaded from: classes.dex */
    public static class a extends androidx.core.view.a {

        /* renamed from: d  reason: collision with root package name */
        final o f4112d;

        /* renamed from: e  reason: collision with root package name */
        private Map<View, androidx.core.view.a> f4113e = new WeakHashMap();

        public a(o oVar) {
            this.f4112d = oVar;
        }

        @Override // androidx.core.view.a
        public boolean a(View view, AccessibilityEvent accessibilityEvent) {
            androidx.core.view.a aVar = this.f4113e.get(view);
            if (aVar != null) {
                return aVar.a(view, accessibilityEvent);
            }
            return super.a(view, accessibilityEvent);
        }

        @Override // androidx.core.view.a
        public d b(View view) {
            androidx.core.view.a aVar = this.f4113e.get(view);
            if (aVar != null) {
                return aVar.b(view);
            }
            return super.b(view);
        }

        @Override // androidx.core.view.a
        public void f(View view, AccessibilityEvent accessibilityEvent) {
            androidx.core.view.a aVar = this.f4113e.get(view);
            if (aVar != null) {
                aVar.f(view, accessibilityEvent);
            } else {
                super.f(view, accessibilityEvent);
            }
        }

        @Override // androidx.core.view.a
        public void g(View view, c cVar) {
            if (this.f4112d.o() || this.f4112d.f4110d.getLayoutManager() == null) {
                super.g(view, cVar);
                return;
            }
            this.f4112d.f4110d.getLayoutManager().P0(view, cVar);
            androidx.core.view.a aVar = this.f4113e.get(view);
            if (aVar != null) {
                aVar.g(view, cVar);
            } else {
                super.g(view, cVar);
            }
        }

        @Override // androidx.core.view.a
        public void h(View view, AccessibilityEvent accessibilityEvent) {
            androidx.core.view.a aVar = this.f4113e.get(view);
            if (aVar != null) {
                aVar.h(view, accessibilityEvent);
            } else {
                super.h(view, accessibilityEvent);
            }
        }

        @Override // androidx.core.view.a
        public boolean i(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            androidx.core.view.a aVar = this.f4113e.get(viewGroup);
            if (aVar != null) {
                return aVar.i(viewGroup, view, accessibilityEvent);
            }
            return super.i(viewGroup, view, accessibilityEvent);
        }

        @Override // androidx.core.view.a
        public boolean j(View view, int i10, Bundle bundle) {
            if (this.f4112d.o() || this.f4112d.f4110d.getLayoutManager() == null) {
                return super.j(view, i10, bundle);
            }
            androidx.core.view.a aVar = this.f4113e.get(view);
            if (aVar != null) {
                if (aVar.j(view, i10, bundle)) {
                    return true;
                }
            } else if (super.j(view, i10, bundle)) {
                return true;
            }
            return this.f4112d.f4110d.getLayoutManager().j1(view, i10, bundle);
        }

        @Override // androidx.core.view.a
        public void l(View view, int i10) {
            androidx.core.view.a aVar = this.f4113e.get(view);
            if (aVar != null) {
                aVar.l(view, i10);
            } else {
                super.l(view, i10);
            }
        }

        @Override // androidx.core.view.a
        public void m(View view, AccessibilityEvent accessibilityEvent) {
            androidx.core.view.a aVar = this.f4113e.get(view);
            if (aVar != null) {
                aVar.m(view, accessibilityEvent);
            } else {
                super.m(view, accessibilityEvent);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public androidx.core.view.a n(View view) {
            return this.f4113e.remove(view);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void o(View view) {
            androidx.core.view.a n10 = d0.n(view);
            if (n10 != null && n10 != this) {
                this.f4113e.put(view, n10);
            }
        }
    }

    public o(RecyclerView recyclerView) {
        this.f4110d = recyclerView;
        androidx.core.view.a n10 = n();
        if (n10 == null || !(n10 instanceof a)) {
            this.f4111e = new a(this);
        } else {
            this.f4111e = (a) n10;
        }
    }

    @Override // androidx.core.view.a
    public void f(View view, AccessibilityEvent accessibilityEvent) {
        super.f(view, accessibilityEvent);
        if ((view instanceof RecyclerView) && !o()) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().L0(accessibilityEvent);
            }
        }
    }

    @Override // androidx.core.view.a
    public void g(View view, c cVar) {
        super.g(view, cVar);
        if (!o() && this.f4110d.getLayoutManager() != null) {
            this.f4110d.getLayoutManager().O0(cVar);
        }
    }

    @Override // androidx.core.view.a
    public boolean j(View view, int i10, Bundle bundle) {
        if (super.j(view, i10, bundle)) {
            return true;
        }
        if (o() || this.f4110d.getLayoutManager() == null) {
            return false;
        }
        return this.f4110d.getLayoutManager().h1(i10, bundle);
    }

    public androidx.core.view.a n() {
        return this.f4111e;
    }

    boolean o() {
        return this.f4110d.r0();
    }
}
