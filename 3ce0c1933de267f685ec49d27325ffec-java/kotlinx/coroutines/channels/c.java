package kotlinx.coroutines.channels;

import io.h;
import io.m;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.internal.UndeliveredElementException;
import kotlinx.coroutines.internal.j;
import kotlinx.coroutines.internal.k;
import kotlinx.coroutines.internal.l;
import kotlinx.coroutines.internal.r;
import kotlinx.coroutines.internal.w;
import kotlinx.coroutines.n;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p;
import qo.l;
/* compiled from: AbstractChannel.kt */
/* loaded from: classes3.dex */
public abstract class c<E> implements p<E> {

    /* renamed from: d  reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f30140d = AtomicReferenceFieldUpdater.newUpdater(c.class, Object.class, "onCloseHandler");

    /* renamed from: b  reason: collision with root package name */
    protected final l<E, m> f30141b;

    /* renamed from: c  reason: collision with root package name */
    private final j f30142c = new j();
    private volatile /* synthetic */ Object onCloseHandler = null;

    /* compiled from: AbstractChannel.kt */
    /* loaded from: classes3.dex */
    public static final class a<E> extends o {

        /* renamed from: d  reason: collision with root package name */
        public final E f30143d;

        public a(E e10) {
            this.f30143d = e10;
        }

        @Override // kotlinx.coroutines.internal.l
        public String toString() {
            return "SendBuffered@" + o0.b(this) + '(' + this.f30143d + ')';
        }

        @Override // kotlinx.coroutines.channels.o
        public void w() {
        }

        @Override // kotlinx.coroutines.channels.o
        public Object x() {
            return this.f30143d;
        }

        @Override // kotlinx.coroutines.channels.o
        public w y(l.b bVar) {
            return o.f30262a;
        }
    }

    /* compiled from: LockFreeLinkedList.kt */
    /* loaded from: classes3.dex */
    public static final class b extends l.a {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ c f30144d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(kotlinx.coroutines.internal.l lVar, c cVar) {
            super(lVar);
            this.f30144d = cVar;
        }

        /* renamed from: i */
        public Object g(kotlinx.coroutines.internal.l lVar) {
            if (this.f30144d.q()) {
                return null;
            }
            return k.a();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(qo.l<? super E, m> lVar) {
        this.f30141b = lVar;
    }

    private final int g() {
        j jVar = this.f30142c;
        int i10 = 0;
        for (kotlinx.coroutines.internal.l lVar = (kotlinx.coroutines.internal.l) jVar.m(); !i.b(lVar, jVar); lVar = lVar.n()) {
            if (lVar instanceof kotlinx.coroutines.internal.l) {
                i10++;
            }
        }
        return i10;
    }

    private final String l() {
        String str;
        kotlinx.coroutines.internal.l n10 = this.f30142c.n();
        if (n10 == this.f30142c) {
            return "EmptyQueue";
        }
        if (n10 instanceof h) {
            str = n10.toString();
        } else if (n10 instanceof k) {
            str = "ReceiveQueued";
        } else {
            str = n10 instanceof o ? "SendQueued" : i.n("UNEXPECTED:", n10);
        }
        kotlinx.coroutines.internal.l o10 = this.f30142c.o();
        if (o10 == n10) {
            return str;
        }
        String str2 = str + ",queueSize=" + g();
        if (!(o10 instanceof h)) {
            return str2;
        }
        return str2 + ",closedForSend=" + o10;
    }

    private final void m(h<?> hVar) {
        Object b10 = kotlinx.coroutines.internal.i.b(null, 1, null);
        while (true) {
            kotlinx.coroutines.internal.l o10 = hVar.o();
            k kVar = o10 instanceof k ? (k) o10 : null;
            if (kVar == null) {
                break;
            } else if (!kVar.s()) {
                kVar.p();
            } else {
                b10 = kotlinx.coroutines.internal.i.c(b10, kVar);
            }
        }
        if (b10 != null) {
            if (!(b10 instanceof ArrayList)) {
                ((k) b10).y(hVar);
            } else {
                ArrayList arrayList = (ArrayList) b10;
                int size = arrayList.size() - 1;
                if (size >= 0) {
                    while (true) {
                        int i10 = size - 1;
                        ((k) arrayList.get(size)).y(hVar);
                        if (i10 < 0) {
                            break;
                        }
                        size = i10;
                    }
                }
            }
        }
        t(hVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(kotlin.coroutines.c<?> cVar, E e10, h<?> hVar) {
        UndeliveredElementException d10;
        m(hVar);
        Throwable D = hVar.D();
        qo.l<E, m> lVar = this.f30141b;
        if (lVar == null || (d10 = r.d(lVar, e10, null, 2, null)) == null) {
            Result.a aVar = Result.Companion;
            cVar.resumeWith(Result.m28constructorimpl(h.a(D)));
            return;
        }
        io.b.a(d10, D);
        Result.a aVar2 = Result.Companion;
        cVar.resumeWith(Result.m28constructorimpl(h.a(d10)));
    }

    private final void o(Throwable th2) {
        w wVar;
        Object obj = this.onCloseHandler;
        if (obj != null && obj != (wVar = kotlinx.coroutines.channels.b.f30139f) && f30140d.compareAndSet(this, obj, wVar)) {
            ((qo.l) kotlin.jvm.internal.o.b(obj, 1)).invoke(th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean r() {
        return !(this.f30142c.n() instanceof m) && q();
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x006f, code lost:
        r4 = r0.v();
        r0 = kotlin.coroutines.intrinsics.b.d();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0077, code lost:
        if (r4 != r0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0079, code lost:
        kotlin.coroutines.jvm.internal.f.c(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x007c, code lost:
        r5 = kotlin.coroutines.intrinsics.b.d();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0080, code lost:
        if (r4 != r5) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0082, code lost:
        return r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0085, code lost:
        return io.m.f28349a;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Object v(E e10, kotlin.coroutines.c<? super m> cVar) {
        kotlin.coroutines.c c10;
        o oVar;
        c10 = IntrinsicsKt__IntrinsicsJvmKt.c(cVar);
        n a10 = p.a(c10);
        while (true) {
            if (r()) {
                if (this.f30141b == null) {
                    oVar = new q(e10, a10);
                } else {
                    oVar = new r(e10, a10, this.f30141b);
                }
                Object h10 = h(oVar);
                if (h10 == null) {
                    p.b(a10, oVar);
                    break;
                } else if (h10 instanceof h) {
                    n(a10, e10, (h) h10);
                    break;
                } else if (h10 != kotlinx.coroutines.channels.b.f30138e && !(h10 instanceof k)) {
                    throw new IllegalStateException(i.n("enqueueSend returned ", h10).toString());
                }
            }
            Object s10 = s(e10);
            if (s10 == kotlinx.coroutines.channels.b.f30135b) {
                m mVar = m.f28349a;
                Result.a aVar = Result.Companion;
                a10.resumeWith(Result.m28constructorimpl(mVar));
                break;
            } else if (s10 != kotlinx.coroutines.channels.b.f30136c) {
                if (s10 instanceof h) {
                    n(a10, e10, (h) s10);
                } else {
                    throw new IllegalStateException(i.n("offerInternal returned ", s10).toString());
                }
            }
        }
    }

    @Override // kotlinx.coroutines.channels.p
    public boolean c(Throwable th2) {
        boolean z10;
        h<?> hVar = new h<>(th2);
        kotlinx.coroutines.internal.l lVar = this.f30142c;
        while (true) {
            kotlinx.coroutines.internal.l o10 = lVar.o();
            z10 = true;
            if (!(o10 instanceof h)) {
                if (o10.h(hVar, lVar)) {
                    break;
                }
            } else {
                z10 = false;
                break;
            }
        }
        if (!z10) {
            hVar = (h) this.f30142c.o();
        }
        m(hVar);
        if (z10) {
            o(th2);
        }
        return z10;
    }

    @Override // kotlinx.coroutines.channels.p
    public final Object d(E e10, kotlin.coroutines.c<? super m> cVar) {
        Object d10;
        if (s(e10) == kotlinx.coroutines.channels.b.f30135b) {
            return m.f28349a;
        }
        Object v10 = v(e10, cVar);
        d10 = kotlin.coroutines.intrinsics.b.d();
        return v10 == d10 ? v10 : m.f28349a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object h(o oVar) {
        boolean z10;
        kotlinx.coroutines.internal.l o10;
        if (p()) {
            kotlinx.coroutines.internal.l lVar = this.f30142c;
            do {
                o10 = lVar.o();
                if (o10 instanceof m) {
                    return o10;
                }
            } while (!o10.h(oVar, lVar));
            return null;
        }
        kotlinx.coroutines.internal.l lVar2 = this.f30142c;
        b bVar = new b(oVar, this);
        while (true) {
            kotlinx.coroutines.internal.l o11 = lVar2.o();
            if (!(o11 instanceof m)) {
                int v10 = o11.v(oVar, lVar2, bVar);
                z10 = true;
                if (v10 != 1) {
                    if (v10 == 2) {
                        z10 = false;
                        break;
                    }
                } else {
                    break;
                }
            } else {
                return o11;
            }
        }
        if (!z10) {
            return kotlinx.coroutines.channels.b.f30138e;
        }
        return null;
    }

    protected String i() {
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final h<?> j() {
        kotlinx.coroutines.internal.l o10 = this.f30142c.o();
        h<?> hVar = o10 instanceof h ? (h) o10 : null;
        if (hVar == null) {
            return null;
        }
        m(hVar);
        return hVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final j k() {
        return this.f30142c;
    }

    protected abstract boolean p();

    protected abstract boolean q();

    /* JADX INFO: Access modifiers changed from: protected */
    public Object s(E e10) {
        m<E> w10;
        w f10;
        do {
            w10 = w();
            if (w10 == null) {
                return kotlinx.coroutines.channels.b.f30136c;
            }
            f10 = w10.f(e10, null);
        } while (f10 == null);
        if (n0.a()) {
            if (!(f10 == o.f30262a)) {
                throw new AssertionError();
            }
        }
        w10.e(e10);
        return w10.a();
    }

    protected void t(kotlinx.coroutines.internal.l lVar) {
    }

    public String toString() {
        return o0.a(this) + '@' + o0.b(this) + '{' + l() + '}' + i();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final m<?> u(E e10) {
        kotlinx.coroutines.internal.l o10;
        kotlinx.coroutines.internal.l lVar = this.f30142c;
        a aVar = new a(e10);
        do {
            o10 = lVar.o();
            if (o10 instanceof m) {
                return (m) o10;
            }
        } while (!o10.h(aVar, lVar));
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public m<E> w() {
        kotlinx.coroutines.internal.l lVar;
        kotlinx.coroutines.internal.l t10;
        j jVar = this.f30142c;
        while (true) {
            lVar = (kotlinx.coroutines.internal.l) jVar.m();
            lVar = null;
            if (lVar != jVar && (lVar instanceof m)) {
                if (((((m) lVar) instanceof h) && !lVar.r()) || (t10 = lVar.t()) == null) {
                    break;
                }
                t10.q();
            }
        }
        return (m) lVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final o x() {
        kotlinx.coroutines.internal.l lVar;
        kotlinx.coroutines.internal.l t10;
        j jVar = this.f30142c;
        while (true) {
            lVar = (kotlinx.coroutines.internal.l) jVar.m();
            lVar = null;
            if (lVar != jVar && (lVar instanceof o)) {
                if (((((o) lVar) instanceof h) && !lVar.r()) || (t10 = lVar.t()) == null) {
                    break;
                }
                t10.q();
            }
        }
        return (o) lVar;
    }
}
