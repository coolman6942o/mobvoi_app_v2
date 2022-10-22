package i8;

import com.google.gson.e;
import com.google.gson.i;
import com.google.gson.j;
import com.google.gson.k;
import com.google.gson.o;
import com.google.gson.p;
import com.google.gson.q;
import com.google.gson.r;
import java.io.IOException;
/* compiled from: TreeTypeAdapter.java */
/* loaded from: classes.dex */
public final class l<T> extends q<T> {

    /* renamed from: a  reason: collision with root package name */
    private final p<T> f28154a;

    /* renamed from: b  reason: collision with root package name */
    private final j<T> f28155b;

    /* renamed from: c  reason: collision with root package name */
    final e f28156c;

    /* renamed from: d  reason: collision with root package name */
    private final com.google.gson.reflect.a<T> f28157d;

    /* renamed from: e  reason: collision with root package name */
    private final r f28158e;

    /* renamed from: f  reason: collision with root package name */
    private final l<T>.b f28159f = new b();

    /* renamed from: g  reason: collision with root package name */
    private q<T> f28160g;

    /* compiled from: TreeTypeAdapter.java */
    /* loaded from: classes.dex */
    private final class b implements o, i {
        private b(l lVar) {
        }
    }

    public l(p<T> pVar, j<T> jVar, e eVar, com.google.gson.reflect.a<T> aVar, r rVar) {
        this.f28154a = pVar;
        this.f28155b = jVar;
        this.f28156c = eVar;
        this.f28157d = aVar;
        this.f28158e = rVar;
    }

    private q<T> e() {
        q<T> qVar = this.f28160g;
        if (qVar != null) {
            return qVar;
        }
        q<T> n10 = this.f28156c.n(this.f28158e, this.f28157d);
        this.f28160g = n10;
        return n10;
    }

    @Override // com.google.gson.q
    public T b(com.google.gson.stream.a aVar) throws IOException {
        if (this.f28155b == null) {
            return e().b(aVar);
        }
        k a10 = com.google.gson.internal.j.a(aVar);
        if (a10.e()) {
            return null;
        }
        return this.f28155b.a(a10, this.f28157d.getType(), this.f28159f);
    }

    @Override // com.google.gson.q
    public void d(com.google.gson.stream.b bVar, T t10) throws IOException {
        p<T> pVar = this.f28154a;
        if (pVar == null) {
            e().d(bVar, t10);
        } else if (t10 == null) {
            bVar.I();
        } else {
            com.google.gson.internal.j.b(pVar.b(t10, this.f28157d.getType(), this.f28159f), bVar);
        }
    }
}
