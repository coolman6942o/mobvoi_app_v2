package jf;

import android.text.TextUtils;
import ef.r;
import ef.u;
import hf.h;
import hf.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import jf.g;
import nf.k;
/* compiled from: ServerSyncer.java */
/* loaded from: classes2.dex */
public abstract class g {

    /* renamed from: d  reason: collision with root package name */
    private final d f29567d;

    /* renamed from: a  reason: collision with root package name */
    private final xe.b f29564a = h();

    /* renamed from: b  reason: collision with root package name */
    private final h f29565b = g();

    /* renamed from: c  reason: collision with root package name */
    private final c f29566c = e();

    /* renamed from: e  reason: collision with root package name */
    private final b f29568e = d();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ServerSyncer.java */
    /* loaded from: classes2.dex */
    public class b implements f<List<String>> {

        /* renamed from: a  reason: collision with root package name */
        private jf.a f29569a;

        private b() {
        }

        private void b(String str) {
            g.this.f29564a.c(str);
        }

        private boolean c(String str, String str2) {
            return g.this.f29564a.k(str, str2);
        }

        private void d(String str) {
            g.this.f29564a.d(str);
            g.this.f29564a.f(str);
        }

        private void e(String str, String str2, boolean z10) {
            g.this.f29564a.p(str, str2, z10);
        }

        /* renamed from: f */
        public void a(List<String> list) {
            if (!list.isEmpty()) {
                ArrayList arrayList = new ArrayList(list.size());
                g.this.f29564a.n();
                for (String str : list) {
                    String a10 = this.f29569a.a();
                    String k10 = g.this.f29565b.k();
                    if (!g.this.f29564a.l(str)) {
                        arrayList.add(str);
                    } else {
                        if (!c(k10, str)) {
                            b(str);
                        } else {
                            d(str);
                            e(a10, str, true);
                            if (!TextUtils.equals(k10, a10)) {
                                e(k10, str, false);
                            }
                        }
                        arrayList.add(str);
                    }
                }
                g.this.f29564a.endBatchEdit();
                g.this.f29565b.q();
                this.f29569a.c(arrayList);
            }
        }

        void g(jf.a aVar) {
            jf.a aVar2 = this.f29569a;
            if (aVar2 != aVar) {
                if (aVar2 != null) {
                    aVar2.d(null);
                }
                this.f29569a = aVar;
                aVar.d(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ServerSyncer.java */
    /* loaded from: classes2.dex */
    public class c implements f<List<r>> {

        /* renamed from: a  reason: collision with root package name */
        private jf.b f29571a;

        private c() {
        }

        /* renamed from: b */
        public void a(List<r> list) {
            ArrayList arrayList = new ArrayList(list.size());
            g.this.f29564a.n();
            for (r rVar : list) {
                if (rVar.e()) {
                    String str = rVar.b().f25984c;
                    if (!g.this.f29564a.l(str)) {
                        g.this.f29564a.h(rVar);
                        g.this.f29564a.p(this.f29571a.a(), str, true);
                        g.this.f29564a.p(g.this.f29565b.k(), str, false);
                    }
                    arrayList.add(str);
                }
            }
            g.this.f29564a.endBatchEdit();
            g.this.f29565b.r();
            this.f29571a.h(arrayList);
        }

        void c(jf.b bVar) {
            jf.b bVar2 = this.f29571a;
            if (bVar2 != bVar) {
                if (bVar2 != null) {
                    bVar2.f(null);
                }
                this.f29571a = bVar;
                bVar.f(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ServerSyncer.java */
    /* loaded from: classes2.dex */
    public class d {

        /* renamed from: a  reason: collision with root package name */
        private jf.d f29573a;

        /* renamed from: b  reason: collision with root package name */
        private jf.c f29574b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f29575c;

        /* renamed from: d  reason: collision with root package name */
        private final f<e> f29576d = new a();

        /* renamed from: e  reason: collision with root package name */
        private final f<String> f29577e = new b();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ServerSyncer.java */
        /* loaded from: classes2.dex */
        public class a implements f<e> {

            /* JADX INFO: Access modifiers changed from: package-private */
            /* compiled from: ServerSyncer.java */
            /* renamed from: jf.g$d$a$a  reason: collision with other inner class name */
            /* loaded from: classes2.dex */
            public class C0355a implements k<Collection<u>> {

                /* renamed from: a  reason: collision with root package name */
                private boolean f29580a = false;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ nf.h f29581b;

                /* renamed from: c  reason: collision with root package name */
                final /* synthetic */ e f29582c;

                C0355a(nf.h hVar, e eVar) {
                    this.f29581b = hVar;
                    this.f29582c = eVar;
                }

                /* renamed from: a */
                public void i(nf.h<Collection<u>> hVar, Collection<u> collection) {
                    if (this.f29580a) {
                        this.f29581b.c(this);
                    }
                    List<u> d10 = d.this.d(collection, this.f29582c);
                    if (!this.f29580a) {
                        this.f29580a = true;
                        h hVar2 = g.this.f29565b;
                        e eVar = this.f29582c;
                        hVar2.m(eVar.f29561a, eVar.f29562b, eVar.f29563c);
                    } else if (!d10.isEmpty()) {
                        this.f29581b.c(this);
                        d.this.f29573a.g(d10);
                        g.this.f29564a.n();
                        for (u uVar : d10) {
                            g.this.f29564a.p(d.this.f29573a.a(), uVar.f25984c, true);
                        }
                        g.this.f29564a.endBatchEdit();
                    }
                }
            }

            a() {
            }

            /* renamed from: b */
            public void a(e eVar) {
                nf.h<Collection<u>> p10 = g.this.f29565b.p();
                p10.a(new C0355a(p10, eVar));
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ServerSyncer.java */
        /* loaded from: classes2.dex */
        public class b implements f<String> {
            b() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ void c(r rVar, Throwable th2) {
                d.this.f29574b.e(rVar == null ? null : rVar.a());
            }

            /* renamed from: d */
            public void a(String str) {
                g.this.f29565b.l(str, new o() { // from class: jf.h
                    @Override // hf.o
                    public final void a(Object obj, Throwable th2) {
                        g.d.b.this.c((r) obj, th2);
                    }
                });
            }
        }

        public d(boolean z10) {
            this.f29575c = z10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public List<u> d(Collection<u> collection, e eVar) {
            ArrayList arrayList = new ArrayList();
            for (u uVar : collection) {
                long j10 = uVar.f25989h;
                int i10 = eVar.f29563c;
                if (i10 >= 0 && i10 <= arrayList.size()) {
                    break;
                }
                Date date = eVar.f29562b;
                long time = date == null ? 0L : date.getTime();
                Date date2 = eVar.f29561a;
                long currentTimeMillis = date2 == null ? System.currentTimeMillis() : date2.getTime();
                if (j10 >= time && j10 < currentTimeMillis && (this.f29575c || !uVar.g())) {
                    arrayList.add(uVar);
                }
            }
            return arrayList;
        }

        void e(jf.c cVar) {
            jf.c cVar2 = this.f29574b;
            if (cVar2 != cVar) {
                if (cVar2 != null) {
                    cVar2.i(null);
                }
                this.f29574b = cVar;
                cVar.i(this.f29577e);
            }
        }

        void f(jf.d dVar) {
            jf.d dVar2 = this.f29573a;
            if (dVar2 != dVar) {
                if (dVar2 != null) {
                    dVar2.b(null);
                }
                this.f29573a = dVar;
                dVar.b(this.f29576d);
            }
        }
    }

    public g(boolean z10) {
        this.f29567d = f(z10);
    }

    private b d() {
        return new b();
    }

    private c e() {
        return new c();
    }

    private d f(boolean z10) {
        return new d(z10);
    }

    public void c() {
        this.f29566c.c(j());
        this.f29567d.f(l());
        this.f29567d.e(k());
        this.f29568e.g(i());
    }

    protected abstract h g();

    protected abstract xe.b h();

    protected abstract jf.a i();

    protected abstract jf.b j();

    protected abstract jf.c k();

    protected abstract jf.d l();
}
