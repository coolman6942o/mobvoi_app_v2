package androidx.recyclerview.widget;

import androidx.collection.d;
import androidx.collection.f;
import androidx.recyclerview.widget.RecyclerView;
import j0.e;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ViewInfoStore.java */
/* loaded from: classes.dex */
public class t {

    /* renamed from: a  reason: collision with root package name */
    final f<RecyclerView.b0, a> f4126a = new f<>();

    /* renamed from: b  reason: collision with root package name */
    final d<RecyclerView.b0> f4127b = new d<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewInfoStore.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: d  reason: collision with root package name */
        static e<a> f4128d = new j0.f(20);

        /* renamed from: a  reason: collision with root package name */
        int f4129a;

        /* renamed from: b  reason: collision with root package name */
        RecyclerView.l.c f4130b;

        /* renamed from: c  reason: collision with root package name */
        RecyclerView.l.c f4131c;

        private a() {
        }

        static void a() {
            do {
            } while (f4128d.b() != null);
        }

        static a b() {
            a b10 = f4128d.b();
            return b10 == null ? new a() : b10;
        }

        static void c(a aVar) {
            aVar.f4129a = 0;
            aVar.f4130b = null;
            aVar.f4131c = null;
            f4128d.a(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewInfoStore.java */
    /* loaded from: classes.dex */
    public interface b {
        void a(RecyclerView.b0 b0Var);

        void b(RecyclerView.b0 b0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2);

        void c(RecyclerView.b0 b0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2);

        void d(RecyclerView.b0 b0Var, RecyclerView.l.c cVar, RecyclerView.l.c cVar2);
    }

    private RecyclerView.l.c l(RecyclerView.b0 b0Var, int i10) {
        a n10;
        RecyclerView.l.c cVar;
        int g10 = this.f4126a.g(b0Var);
        if (g10 >= 0 && (n10 = this.f4126a.n(g10)) != null) {
            int i11 = n10.f4129a;
            if ((i11 & i10) != 0) {
                int i12 = (~i10) & i11;
                n10.f4129a = i12;
                if (i10 == 4) {
                    cVar = n10.f4130b;
                } else if (i10 == 8) {
                    cVar = n10.f4131c;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((i12 & 12) == 0) {
                    this.f4126a.l(g10);
                    a.c(n10);
                }
                return cVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(RecyclerView.b0 b0Var, RecyclerView.l.c cVar) {
        a aVar = this.f4126a.get(b0Var);
        if (aVar == null) {
            aVar = a.b();
            this.f4126a.put(b0Var, aVar);
        }
        aVar.f4129a |= 2;
        aVar.f4130b = cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(RecyclerView.b0 b0Var) {
        a aVar = this.f4126a.get(b0Var);
        if (aVar == null) {
            aVar = a.b();
            this.f4126a.put(b0Var, aVar);
        }
        aVar.f4129a |= 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(long j10, RecyclerView.b0 b0Var) {
        this.f4127b.k(j10, b0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(RecyclerView.b0 b0Var, RecyclerView.l.c cVar) {
        a aVar = this.f4126a.get(b0Var);
        if (aVar == null) {
            aVar = a.b();
            this.f4126a.put(b0Var, aVar);
        }
        aVar.f4131c = cVar;
        aVar.f4129a |= 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(RecyclerView.b0 b0Var, RecyclerView.l.c cVar) {
        a aVar = this.f4126a.get(b0Var);
        if (aVar == null) {
            aVar = a.b();
            this.f4126a.put(b0Var, aVar);
        }
        aVar.f4130b = cVar;
        aVar.f4129a |= 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        this.f4126a.clear();
        this.f4127b.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecyclerView.b0 g(long j10) {
        return this.f4127b.f(j10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h(RecyclerView.b0 b0Var) {
        a aVar = this.f4126a.get(b0Var);
        return (aVar == null || (aVar.f4129a & 1) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean i(RecyclerView.b0 b0Var) {
        a aVar = this.f4126a.get(b0Var);
        return (aVar == null || (aVar.f4129a & 4) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        a.a();
    }

    public void k(RecyclerView.b0 b0Var) {
        p(b0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecyclerView.l.c m(RecyclerView.b0 b0Var) {
        return l(b0Var, 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecyclerView.l.c n(RecyclerView.b0 b0Var) {
        return l(b0Var, 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(b bVar) {
        for (int size = this.f4126a.size() - 1; size >= 0; size--) {
            RecyclerView.b0 j10 = this.f4126a.j(size);
            a l10 = this.f4126a.l(size);
            int i10 = l10.f4129a;
            if ((i10 & 3) == 3) {
                bVar.a(j10);
            } else if ((i10 & 1) != 0) {
                RecyclerView.l.c cVar = l10.f4130b;
                if (cVar == null) {
                    bVar.a(j10);
                } else {
                    bVar.c(j10, cVar, l10.f4131c);
                }
            } else if ((i10 & 14) == 14) {
                bVar.b(j10, l10.f4130b, l10.f4131c);
            } else if ((i10 & 12) == 12) {
                bVar.d(j10, l10.f4130b, l10.f4131c);
            } else if ((i10 & 4) != 0) {
                bVar.c(j10, l10.f4130b, null);
            } else if ((i10 & 8) != 0) {
                bVar.b(j10, l10.f4130b, l10.f4131c);
            }
            a.c(l10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(RecyclerView.b0 b0Var) {
        a aVar = this.f4126a.get(b0Var);
        if (aVar != null) {
            aVar.f4129a &= -2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(RecyclerView.b0 b0Var) {
        int n10 = this.f4127b.n() - 1;
        while (true) {
            if (n10 < 0) {
                break;
            } else if (b0Var == this.f4127b.o(n10)) {
                this.f4127b.m(n10);
                break;
            } else {
                n10--;
            }
        }
        a remove = this.f4126a.remove(b0Var);
        if (remove != null) {
            a.c(remove);
        }
    }
}
