package xo;

import io.h;
import io.m;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Result;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.b;
import kotlin.jvm.internal.i;
import ro.a;
/* compiled from: SequenceBuilder.kt */
/* loaded from: classes3.dex */
final class f<T> extends g<T> implements Iterator<T>, c<m>, a {

    /* renamed from: a  reason: collision with root package name */
    private int f36632a;

    /* renamed from: b  reason: collision with root package name */
    private T f36633b;

    /* renamed from: c  reason: collision with root package name */
    private Iterator<? extends T> f36634c;

    /* renamed from: d  reason: collision with root package name */
    private c<? super m> f36635d;

    private final Throwable e() {
        int i10 = this.f36632a;
        if (i10 == 4) {
            return new NoSuchElementException();
        }
        if (i10 == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.f36632a);
    }

    private final T f() {
        if (hasNext()) {
            return next();
        }
        throw new NoSuchElementException();
    }

    @Override // xo.g
    public Object d(T t10, c<? super m> cVar) {
        Object d10;
        Object d11;
        Object d12;
        this.f36633b = t10;
        this.f36632a = 3;
        this.f36635d = cVar;
        d10 = b.d();
        d11 = b.d();
        if (d10 == d11) {
            kotlin.coroutines.jvm.internal.f.c(cVar);
        }
        d12 = b.d();
        return d10 == d12 ? d10 : m.f28349a;
    }

    @Override // kotlin.coroutines.c
    public kotlin.coroutines.f getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }

    public final void h(c<? super m> cVar) {
        this.f36635d = cVar;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        while (true) {
            int i10 = this.f36632a;
            if (i10 != 0) {
                if (i10 == 1) {
                    Iterator<? extends T> it = this.f36634c;
                    i.d(it);
                    if (it.hasNext()) {
                        this.f36632a = 2;
                        return true;
                    }
                    this.f36634c = null;
                } else if (i10 == 2 || i10 == 3) {
                    return true;
                } else {
                    if (i10 == 4) {
                        return false;
                    }
                    throw e();
                }
            }
            this.f36632a = 5;
            c<? super m> cVar = this.f36635d;
            i.d(cVar);
            this.f36635d = null;
            m mVar = m.f28349a;
            Result.a aVar = Result.Companion;
            cVar.resumeWith(Result.m28constructorimpl(mVar));
        }
    }

    @Override // java.util.Iterator
    public T next() {
        int i10 = this.f36632a;
        if (i10 == 0 || i10 == 1) {
            return f();
        }
        if (i10 == 2) {
            this.f36632a = 1;
            Iterator<? extends T> it = this.f36634c;
            i.d(it);
            return it.next();
        } else if (i10 == 3) {
            this.f36632a = 0;
            T t10 = this.f36633b;
            this.f36633b = null;
            return t10;
        } else {
            throw e();
        }
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // kotlin.coroutines.c
    public void resumeWith(Object obj) {
        h.b(obj);
        this.f36632a = 4;
    }
}
