package yg;

import android.content.Context;
import ef.q;
import ef.r;
import ef.u;
import gf.e;
import java.util.List;
import jf.d;
import jf.f;
/* compiled from: SyncServer.java */
/* loaded from: classes2.dex */
public class g implements jf.a, jf.b, d, jf.c {

    /* renamed from: a  reason: collision with root package name */
    private final gf.c f37094a = new a();

    /* renamed from: b  reason: collision with root package name */
    private final e f37095b;

    /* renamed from: c  reason: collision with root package name */
    private final wg.a f37096c;

    /* compiled from: SyncServer.java */
    /* loaded from: classes2.dex */
    class a extends gf.c {
        a() {
        }

        @Override // jf.i
        public String a() {
            return g.this.a();
        }
    }

    /* compiled from: SyncServer.java */
    /* loaded from: classes2.dex */
    class b extends wg.a {
        b(g gVar, Context context) {
            super(context);
        }
    }

    /* compiled from: SyncServer.java */
    /* loaded from: classes2.dex */
    class c extends e {
        c(g gVar, Context context) {
            super(context);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // gf.e, gf.d
        public void k(String str) {
            super.k(str);
            sb.a.d(com.mobvoi.android.common.utils.b.e(), "btFitShare");
        }
    }

    public g(Context context) {
        this.f37096c = new b(this, context);
        this.f37095b = new c(this, context);
    }

    @Override // jf.i
    public String a() {
        return "peer";
    }

    @Override // jf.d
    public void b(f<jf.e> fVar) {
    }

    @Override // jf.a
    public void c(List<String> list) {
        this.f37094a.c(list);
    }

    @Override // jf.a
    public void d(f<List<String>> fVar) {
        this.f37094a.d(fVar);
    }

    @Override // jf.c
    public void e(q qVar) {
    }

    @Override // jf.b
    public void f(f<List<r>> fVar) {
    }

    @Override // jf.d
    public void g(List<u> list) {
    }

    @Override // jf.b
    public void h(List<String> list) {
    }

    @Override // jf.c
    public void i(f<String> fVar) {
    }

    public void j(String str) {
        this.f37094a.n(str);
        this.f37096c.n(str);
        this.f37095b.n(str);
    }

    public void k(boolean z10) {
        this.f37094a.o(z10);
    }

    public void l() {
        this.f37094a.p();
        this.f37096c.p();
        this.f37095b.p();
    }
}
