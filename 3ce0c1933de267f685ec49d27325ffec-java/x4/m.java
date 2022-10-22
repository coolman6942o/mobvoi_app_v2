package x4;

import java.util.Queue;
import n5.g;
import n5.k;
/* compiled from: ModelCache.java */
/* loaded from: classes.dex */
public class m<A, B> {

    /* renamed from: a  reason: collision with root package name */
    private final g<b<A>, B> f36397a;

    /* compiled from: ModelCache.java */
    /* loaded from: classes.dex */
    class a extends g<b<A>, B> {
        a(m mVar, long j10) {
            super(j10);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: n */
        public void j(b<A> bVar, B b10) {
            bVar.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ModelCache.java */
    /* loaded from: classes.dex */
    public static final class b<A> {

        /* renamed from: d  reason: collision with root package name */
        private static final Queue<b<?>> f36398d = k.e(0);

        /* renamed from: a  reason: collision with root package name */
        private int f36399a;

        /* renamed from: b  reason: collision with root package name */
        private int f36400b;

        /* renamed from: c  reason: collision with root package name */
        private A f36401c;

        private b() {
        }

        static <A> b<A> a(A a10, int i10, int i11) {
            b<A> bVar;
            Queue<b<?>> queue = f36398d;
            synchronized (queue) {
                bVar = (b<A>) queue.poll();
            }
            if (bVar == null) {
                bVar = new b<>();
            }
            bVar.b(a10, i10, i11);
            return bVar;
        }

        private void b(A a10, int i10, int i11) {
            this.f36401c = a10;
            this.f36400b = i10;
            this.f36399a = i11;
        }

        public void c() {
            Queue<b<?>> queue = f36398d;
            synchronized (queue) {
                queue.offer(this);
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.f36400b == bVar.f36400b && this.f36399a == bVar.f36399a && this.f36401c.equals(bVar.f36401c);
        }

        public int hashCode() {
            return (((this.f36399a * 31) + this.f36400b) * 31) + this.f36401c.hashCode();
        }
    }

    public m(long j10) {
        this.f36397a = new a(this, j10);
    }

    public B a(A a10, int i10, int i11) {
        b<A> a11 = b.a(a10, i10, i11);
        B g10 = this.f36397a.g(a11);
        a11.c();
        return g10;
    }

    public void b(A a10, int i10, int i11, B b10) {
        this.f36397a.k(b.a(a10, i10, i11), b10);
    }
}
