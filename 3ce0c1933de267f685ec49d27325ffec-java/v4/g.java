package v4;

import android.annotation.SuppressLint;
import q4.b;
import t4.c;
import v4.h;
/* compiled from: LruResourceCache.java */
/* loaded from: classes.dex */
public class g extends n5.g<b, c<?>> implements h {

    /* renamed from: d  reason: collision with root package name */
    private h.a f35601d;

    public g(long j10) {
        super(j10);
    }

    @Override // v4.h
    @SuppressLint({"InlinedApi"})
    public void a(int i10) {
        if (i10 >= 40) {
            b();
        } else if (i10 >= 20 || i10 == 15) {
            m(h() / 2);
        }
    }

    @Override // v4.h
    public /* bridge */ /* synthetic */ c c(b bVar) {
        return (c) super.l(bVar);
    }

    @Override // v4.h
    public void d(h.a aVar) {
        this.f35601d = aVar;
    }

    @Override // v4.h
    public /* bridge */ /* synthetic */ c e(b bVar, c cVar) {
        return (c) super.k(bVar, cVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: n */
    public int i(c<?> cVar) {
        if (cVar == null) {
            return super.i(null);
        }
        return cVar.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: o */
    public void j(b bVar, c<?> cVar) {
        h.a aVar = this.f35601d;
        if (aVar != null && cVar != null) {
            aVar.a(cVar);
        }
    }
}
