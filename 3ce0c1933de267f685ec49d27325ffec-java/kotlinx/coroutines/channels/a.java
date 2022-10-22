package kotlinx.coroutines.channels;

import io.h;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.f;
import kotlinx.coroutines.internal.k;
import kotlinx.coroutines.internal.l;
import kotlinx.coroutines.internal.r;
import kotlinx.coroutines.internal.w;
import kotlinx.coroutines.m;
import kotlinx.coroutines.n;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p;
/* compiled from: AbstractChannel.kt */
/* loaded from: classes3.dex */
public abstract class a<E> extends kotlinx.coroutines.channels.c<E> implements kotlinx.coroutines.channels.e<E> {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractChannel.kt */
    /* renamed from: kotlinx.coroutines.channels.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0375a<E> extends k<E> {

        /* renamed from: d  reason: collision with root package name */
        public final m<Object> f30128d;

        /* renamed from: e  reason: collision with root package name */
        public final int f30129e;

        public C0375a(m<Object> mVar, int i10) {
            this.f30128d = mVar;
            this.f30129e = i10;
        }

        @Override // kotlinx.coroutines.channels.m
        public void e(E e10) {
            this.f30128d.k(o.f30262a);
        }

        @Override // kotlinx.coroutines.channels.m
        public w f(E e10, l.b bVar) {
            Object b10 = this.f30128d.b(z(e10), null, x(e10));
            if (b10 == null) {
                return null;
            }
            if (n0.a()) {
                if (!(b10 == o.f30262a)) {
                    throw new AssertionError();
                }
            }
            return o.f30262a;
        }

        @Override // kotlinx.coroutines.internal.l
        public String toString() {
            return "ReceiveElement@" + o0.b(this) + "[receiveMode=" + this.f30129e + ']';
        }

        @Override // kotlinx.coroutines.channels.k
        public void y(h<?> hVar) {
            if (this.f30129e == 1) {
                m<Object> mVar = this.f30128d;
                g b10 = g.b(g.f30154b.a(hVar.f30158d));
                Result.a aVar = Result.Companion;
                mVar.resumeWith(Result.m28constructorimpl(b10));
                return;
            }
            m<Object> mVar2 = this.f30128d;
            Throwable C = hVar.C();
            Result.a aVar2 = Result.Companion;
            mVar2.resumeWith(Result.m28constructorimpl(h.a(C)));
        }

        public final Object z(E e10) {
            return this.f30129e == 1 ? g.b(g.f30154b.c(e10)) : e10;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractChannel.kt */
    /* loaded from: classes3.dex */
    public static final class b<E> extends C0375a<E> {

        /* renamed from: f  reason: collision with root package name */
        public final qo.l<E, io.m> f30130f;

        /* JADX WARN: Multi-variable type inference failed */
        public b(m<Object> mVar, int i10, qo.l<? super E, io.m> lVar) {
            super(mVar, i10);
            this.f30130f = lVar;
        }

        @Override // kotlinx.coroutines.channels.k
        public qo.l<Throwable, io.m> x(E e10) {
            return r.a(this.f30130f, e10, this.f30128d.getContext());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractChannel.kt */
    /* loaded from: classes3.dex */
    public final class c extends kotlinx.coroutines.e {

        /* renamed from: a  reason: collision with root package name */
        private final k<?> f30131a;

        public c(k<?> kVar) {
            this.f30131a = kVar;
        }

        @Override // kotlinx.coroutines.l
        public void a(Throwable th2) {
            if (this.f30131a.s()) {
                a.this.E();
            }
        }

        @Override // qo.l
        public /* bridge */ /* synthetic */ io.m invoke(Throwable th2) {
            a(th2);
            return io.m.f28349a;
        }

        public String toString() {
            return "RemoveReceiveOnCancel[" + this.f30131a + ']';
        }
    }

    /* compiled from: LockFreeLinkedList.kt */
    /* loaded from: classes3.dex */
    public static final class d extends l.a {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ a f30133d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(l lVar, a aVar) {
            super(lVar);
            this.f30133d = aVar;
        }

        /* renamed from: i */
        public Object g(l lVar) {
            if (this.f30133d.D()) {
                return null;
            }
            return k.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbstractChannel.kt */
    @kotlin.coroutines.jvm.internal.d(c = "kotlinx.coroutines.channels.AbstractChannel", f = "AbstractChannel.kt", l = {632}, m = "receiveCatching-JP2dKIU")
    /* loaded from: classes3.dex */
    public static final class e extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ a<E> this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(a<E> aVar, kotlin.coroutines.c<? super e> cVar) {
            super(cVar);
            this.this$0 = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object d10;
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            Object b10 = this.this$0.b(this);
            d10 = kotlin.coroutines.intrinsics.b.d();
            return b10 == d10 ? b10 : g.b(b10);
        }
    }

    public a(qo.l<? super E, io.m> lVar) {
        super(lVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean A(k<? super E> kVar) {
        boolean B = B(kVar);
        if (B) {
            F();
        }
        return B;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [kotlinx.coroutines.channels.a$a] */
    private final <R> Object H(int i10, kotlin.coroutines.c<? super R> cVar) {
        kotlin.coroutines.c c10;
        b bVar;
        Object d10;
        c10 = IntrinsicsKt__IntrinsicsJvmKt.c(cVar);
        n a10 = p.a(c10);
        if (this.f30141b == null) {
            bVar = new C0375a(a10, i10);
        } else {
            bVar = new b(a10, i10, this.f30141b);
        }
        while (true) {
            if (!A(bVar)) {
                Object G = G();
                if (!(G instanceof h)) {
                    if (G != kotlinx.coroutines.channels.b.f30137d) {
                        a10.g(bVar.z(G), bVar.x(G));
                        break;
                    }
                } else {
                    bVar.y((h) G);
                    break;
                }
            } else {
                I(a10, bVar);
                break;
            }
        }
        Object v10 = a10.v();
        d10 = kotlin.coroutines.intrinsics.b.d();
        if (v10 == d10) {
            f.c(cVar);
        }
        return v10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I(m<?> mVar, k<?> kVar) {
        mVar.j(new c(kVar));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean B(k<? super E> kVar) {
        int v10;
        l o10;
        if (C()) {
            l k10 = k();
            do {
                o10 = k10.o();
                if (!(!(o10 instanceof o))) {
                    return false;
                }
            } while (!o10.h(kVar, k10));
        } else {
            l k11 = k();
            d dVar = new d(kVar, this);
            do {
                l o11 = k11.o();
                if (!(!(o11 instanceof o))) {
                    return false;
                }
                v10 = o11.v(kVar, k11, dVar);
                if (v10 != 1) {
                }
            } while (v10 != 2);
            return false;
        }
        return true;
    }

    protected abstract boolean C();

    protected abstract boolean D();

    protected void E() {
    }

    protected void F() {
    }

    protected Object G() {
        while (true) {
            o x10 = x();
            if (x10 == null) {
                return kotlinx.coroutines.channels.b.f30137d;
            }
            w y10 = x10.y(null);
            if (y10 != null) {
                if (n0.a()) {
                    if (!(y10 == o.f30262a)) {
                        throw new AssertionError();
                    }
                }
                x10.w();
                return x10.x();
            }
            x10.z();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.l
    public final Object a() {
        Object G = G();
        return G == kotlinx.coroutines.channels.b.f30137d ? g.f30154b.b() : G instanceof h ? g.f30154b.a(((h) G).f30158d) : g.f30154b.c(G);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    @Override // kotlinx.coroutines.channels.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object b(kotlin.coroutines.c<? super g<? extends E>> cVar) {
        e eVar;
        Object d10;
        int i10;
        if (cVar instanceof e) {
            eVar = (e) cVar;
            int i11 = eVar.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                eVar.label = i11 - Integer.MIN_VALUE;
                Object obj = eVar.result;
                d10 = kotlin.coroutines.intrinsics.b.d();
                i10 = eVar.label;
                if (i10 != 0) {
                    h.b(obj);
                    Object G = G();
                    if (G != kotlinx.coroutines.channels.b.f30137d) {
                        return G instanceof h ? g.f30154b.a(((h) G).f30158d) : g.f30154b.c(G);
                    }
                    eVar.label = 1;
                    obj = H(1, eVar);
                    if (obj == d10) {
                        return d10;
                    }
                } else if (i10 == 1) {
                    h.b(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return ((g) obj).h();
            }
        }
        eVar = new e(this, cVar);
        Object obj2 = eVar.result;
        d10 = kotlin.coroutines.intrinsics.b.d();
        i10 = eVar.label;
        if (i10 != 0) {
        }
        return ((g) obj2).h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.c
    public m<E> w() {
        m<E> w10 = super.w();
        if (w10 != null && !(w10 instanceof h)) {
            E();
        }
        return w10;
    }
}
