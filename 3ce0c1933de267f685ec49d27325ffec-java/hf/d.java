package hf;

import ef.r;
import java.util.List;
import xe.b;
import zf.k;
/* compiled from: ClientPoster.java */
/* loaded from: classes2.dex */
class d implements o<List<String>> {

    /* renamed from: a  reason: collision with root package name */
    private final b f27825a;

    /* renamed from: b  reason: collision with root package name */
    private j f27826b;

    /* renamed from: c  reason: collision with root package name */
    private k f27827c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.f27825a = bVar;
    }

    private boolean c(List<r> list) {
        j jVar = this.f27826b;
        if (jVar == null || !jVar.isConnected()) {
            return false;
        }
        if (list.isEmpty()) {
            return true;
        }
        this.f27826b.d(list);
        return true;
    }

    /* renamed from: b */
    public void a(List<String> list, Throwable th2) {
        k kVar;
        if (list != null && !list.isEmpty() && this.f27826b != null) {
            this.f27825a.n();
            for (String str : list) {
                this.f27825a.p(this.f27826b.a(), str, true);
            }
            this.f27825a.endBatchEdit();
        } else if (th2 != null && (kVar = this.f27827c) != null) {
            kVar.a(th2);
        }
    }

    public void d(j jVar) {
        j jVar2 = this.f27826b;
        if (jVar2 != jVar) {
            if (jVar2 != null) {
                jVar2.e(null);
            }
            this.f27826b = jVar;
            jVar.e(this);
        }
    }

    public void e(k kVar) {
        this.f27827c = kVar;
    }

    public boolean f() {
        List<r> i10 = this.f27825a.i(this.f27826b.a());
        return i10.isEmpty() || c(i10);
    }
}
