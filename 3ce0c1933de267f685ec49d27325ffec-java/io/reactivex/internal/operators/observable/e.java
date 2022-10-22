package io.reactivex.internal.operators.observable;

import io.reactivex.internal.util.c;
import io.reactivex.internal.util.f;
import io.reactivex.j;
import io.reactivex.p;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: BlockingObservableNext.java */
/* loaded from: classes3.dex */
public final class e<T> implements Iterable<T> {

    /* renamed from: a  reason: collision with root package name */
    final p<T> f28542a;

    /* compiled from: BlockingObservableNext.java */
    /* loaded from: classes3.dex */
    static final class a<T> implements Iterator<T> {

        /* renamed from: a  reason: collision with root package name */
        private final b<T> f28543a;

        /* renamed from: b  reason: collision with root package name */
        private final p<T> f28544b;

        /* renamed from: c  reason: collision with root package name */
        private T f28545c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f28546d = true;

        /* renamed from: e  reason: collision with root package name */
        private boolean f28547e = true;

        /* renamed from: f  reason: collision with root package name */
        private Throwable f28548f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f28549g;

        a(p<T> pVar, b<T> bVar) {
            this.f28544b = pVar;
            this.f28543a = bVar;
        }

        private boolean a() {
            if (!this.f28549g) {
                this.f28549g = true;
                this.f28543a.c();
                new w1(this.f28544b).subscribe(this.f28543a);
            }
            try {
                j<T> d10 = this.f28543a.d();
                if (d10.h()) {
                    this.f28547e = false;
                    this.f28545c = d10.e();
                    return true;
                }
                this.f28546d = false;
                if (d10.f()) {
                    return false;
                }
                Throwable d11 = d10.d();
                this.f28548f = d11;
                throw f.d(d11);
            } catch (InterruptedException e10) {
                this.f28543a.dispose();
                this.f28548f = e10;
                throw f.d(e10);
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Throwable th2 = this.f28548f;
            if (th2 != null) {
                throw f.d(th2);
            } else if (!this.f28546d) {
                return false;
            } else {
                return !this.f28547e || a();
            }
        }

        @Override // java.util.Iterator
        public T next() {
            Throwable th2 = this.f28548f;
            if (th2 != null) {
                throw f.d(th2);
            } else if (hasNext()) {
                this.f28547e = true;
                return this.f28545c;
            } else {
                throw new NoSuchElementException("No more elements");
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Read only iterator");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BlockingObservableNext.java */
    /* loaded from: classes3.dex */
    public static final class b<T> extends eo.b<j<T>> {

        /* renamed from: b  reason: collision with root package name */
        private final BlockingQueue<j<T>> f28550b = new ArrayBlockingQueue(1);

        /* renamed from: c  reason: collision with root package name */
        final AtomicInteger f28551c = new AtomicInteger();

        b() {
        }

        /* renamed from: b */
        public void onNext(j<T> jVar) {
            if (this.f28551c.getAndSet(0) == 1 || !jVar.h()) {
                while (!this.f28550b.offer(jVar)) {
                    j<T> poll = this.f28550b.poll();
                    if (poll != null && !poll.h()) {
                        jVar = poll;
                    }
                }
            }
        }

        void c() {
            this.f28551c.set(1);
        }

        public j<T> d() throws InterruptedException {
            c();
            c.b();
            return this.f28550b.take();
        }

        @Override // io.reactivex.r
        public void onComplete() {
        }

        @Override // io.reactivex.r
        public void onError(Throwable th2) {
            fo.a.s(th2);
        }
    }

    public e(p<T> pVar) {
        this.f28542a = pVar;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return new a(this.f28542a, new b());
    }
}
