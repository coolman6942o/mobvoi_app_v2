package rx.internal.util;

import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Notification;
import rx.c;
import rx.exceptions.OnErrorNotImplementedException;
import rx.internal.operators.v;
/* loaded from: classes3.dex */
public enum InternalObservableUtils {
    ;
    
    public static final h LONG_COUNTER = new yp.h<Long, Object, Long>() { // from class: rx.internal.util.InternalObservableUtils.h
        /* renamed from: b */
        public Long a(Long l10, Object obj) {
            return Long.valueOf(l10.longValue() + 1);
        }
    };
    public static final f OBJECT_EQUALS = new yp.h<Object, Object, Boolean>() { // from class: rx.internal.util.InternalObservableUtils.f
        /* renamed from: b */
        public Boolean a(Object obj, Object obj2) {
            return Boolean.valueOf(obj == obj2 || (obj != null && obj.equals(obj2)));
        }
    };
    public static final q TO_ARRAY = new yp.g<List<? extends rx.c<?>>, rx.c<?>[]>() { // from class: rx.internal.util.InternalObservableUtils.q
        /* renamed from: a */
        public rx.c<?>[] call(List<? extends rx.c<?>> list) {
            return (rx.c[]) list.toArray(new rx.c[list.size()]);
        }
    };
    static final o RETURNS_VOID = new o();
    public static final g COUNTER = new yp.h<Integer, Object, Integer>() { // from class: rx.internal.util.InternalObservableUtils.g
        /* renamed from: b */
        public Integer a(Integer num, Object obj) {
            return Integer.valueOf(num.intValue() + 1);
        }
    };
    static final e ERROR_EXTRACTOR = new e();
    public static final yp.b<Throwable> ERROR_NOT_IMPLEMENTED = new yp.b<Throwable>() { // from class: rx.internal.util.InternalObservableUtils.c
        /* renamed from: a */
        public void call(Throwable th2) {
            throw new OnErrorNotImplementedException(th2);
        }
    };
    public static final c.b<Boolean, Object> IS_EMPTY = new v(rx.internal.util.j.a(), true);

    /* loaded from: classes3.dex */
    static final class a<T, R> implements yp.h<R, T, R> {

        /* renamed from: a  reason: collision with root package name */
        final yp.c<R, ? super T> f34078a;

        public a(yp.c<R, ? super T> cVar) {
            this.f34078a = cVar;
        }

        @Override // yp.h
        public R a(R r10, T t10) {
            this.f34078a.a(r10, t10);
            return r10;
        }
    }

    /* loaded from: classes3.dex */
    static final class b implements yp.g<Object, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final Object f34079a;

        public b(Object obj) {
            this.f34079a = obj;
        }

        /* renamed from: a */
        public Boolean call(Object obj) {
            Object obj2 = this.f34079a;
            return Boolean.valueOf(obj == obj2 || (obj != null && obj.equals(obj2)));
        }
    }

    /* loaded from: classes3.dex */
    static final class d implements yp.g<Object, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final Class<?> f34080a;

        public d(Class<?> cls) {
            this.f34080a = cls;
        }

        /* renamed from: a */
        public Boolean call(Object obj) {
            return Boolean.valueOf(this.f34080a.isInstance(obj));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class e implements yp.g<Notification<?>, Throwable> {
        e() {
        }

        /* renamed from: a */
        public Throwable call(Notification<?> notification) {
            return notification.e();
        }
    }

    /* loaded from: classes3.dex */
    static final class i implements yp.g<rx.c<? extends Notification<?>>, rx.c<?>> {

        /* renamed from: a  reason: collision with root package name */
        final yp.g<? super rx.c<? extends Void>, ? extends rx.c<?>> f34081a;

        public i(yp.g<? super rx.c<? extends Void>, ? extends rx.c<?>> gVar) {
            this.f34081a = gVar;
        }

        /* renamed from: a */
        public rx.c<?> call(rx.c<? extends Notification<?>> cVar) {
            return this.f34081a.call(cVar.D(InternalObservableUtils.RETURNS_VOID));
        }
    }

    /* loaded from: classes3.dex */
    static final class j<T> implements yp.f<zp.a<T>> {

        /* renamed from: a  reason: collision with root package name */
        private final rx.c<T> f34082a;

        /* renamed from: b  reason: collision with root package name */
        private final int f34083b;

        j(rx.c<T> cVar, int i10) {
            this.f34082a = cVar;
            this.f34083b = i10;
        }

        /* renamed from: a */
        public zp.a<T> call() {
            return this.f34082a.P(this.f34083b);
        }
    }

    /* loaded from: classes3.dex */
    static final class k<T> implements yp.f<zp.a<T>> {

        /* renamed from: a  reason: collision with root package name */
        private final TimeUnit f34084a;

        /* renamed from: b  reason: collision with root package name */
        private final rx.c<T> f34085b;

        /* renamed from: c  reason: collision with root package name */
        private final long f34086c;

        /* renamed from: d  reason: collision with root package name */
        private final rx.f f34087d;

        k(rx.c<T> cVar, long j10, TimeUnit timeUnit, rx.f fVar) {
            this.f34084a = timeUnit;
            this.f34085b = cVar;
            this.f34086c = j10;
            this.f34087d = fVar;
        }

        /* renamed from: a */
        public zp.a<T> call() {
            return this.f34085b.R(this.f34086c, this.f34084a, this.f34087d);
        }
    }

    /* loaded from: classes3.dex */
    static final class l<T> implements yp.f<zp.a<T>> {

        /* renamed from: a  reason: collision with root package name */
        private final rx.c<T> f34088a;

        l(rx.c<T> cVar) {
            this.f34088a = cVar;
        }

        /* renamed from: a */
        public zp.a<T> call() {
            return this.f34088a.O();
        }
    }

    /* loaded from: classes3.dex */
    static final class m<T> implements yp.f<zp.a<T>> {

        /* renamed from: a  reason: collision with root package name */
        private final long f34089a;

        /* renamed from: b  reason: collision with root package name */
        private final TimeUnit f34090b;

        /* renamed from: c  reason: collision with root package name */
        private final rx.f f34091c;

        /* renamed from: d  reason: collision with root package name */
        private final int f34092d;

        /* renamed from: e  reason: collision with root package name */
        private final rx.c<T> f34093e;

        m(rx.c<T> cVar, int i10, long j10, TimeUnit timeUnit, rx.f fVar) {
            this.f34089a = j10;
            this.f34090b = timeUnit;
            this.f34091c = fVar;
            this.f34092d = i10;
            this.f34093e = cVar;
        }

        /* renamed from: a */
        public zp.a<T> call() {
            return this.f34093e.Q(this.f34092d, this.f34089a, this.f34090b, this.f34091c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class n implements yp.g<rx.c<? extends Notification<?>>, rx.c<?>> {

        /* renamed from: a  reason: collision with root package name */
        final yp.g<? super rx.c<? extends Throwable>, ? extends rx.c<?>> f34094a;

        public n(yp.g<? super rx.c<? extends Throwable>, ? extends rx.c<?>> gVar) {
            this.f34094a = gVar;
        }

        /* renamed from: a */
        public rx.c<?> call(rx.c<? extends Notification<?>> cVar) {
            return this.f34094a.call(cVar.D(InternalObservableUtils.ERROR_EXTRACTOR));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class o implements yp.g<Object, Void> {
        o() {
        }

        /* renamed from: a */
        public Void call(Object obj) {
            return null;
        }
    }

    /* loaded from: classes3.dex */
    static final class p<T, R> implements yp.g<rx.c<T>, rx.c<R>> {

        /* renamed from: a  reason: collision with root package name */
        final yp.g<? super rx.c<T>, ? extends rx.c<R>> f34095a;

        /* renamed from: b  reason: collision with root package name */
        final rx.f f34096b;

        public p(yp.g<? super rx.c<T>, ? extends rx.c<R>> gVar, rx.f fVar) {
            this.f34095a = gVar;
            this.f34096b = fVar;
        }

        /* renamed from: a */
        public rx.c<R> call(rx.c<T> cVar) {
            return this.f34095a.call(cVar).H(this.f34096b);
        }
    }

    public static <T, R> yp.h<R, T, R> createCollectorCaller(yp.c<R, ? super T> cVar) {
        return new a(cVar);
    }

    public static yp.g<rx.c<? extends Notification<?>>, rx.c<?>> createRepeatDematerializer(yp.g<? super rx.c<? extends Void>, ? extends rx.c<?>> gVar) {
        return new i(gVar);
    }

    public static <T, R> yp.g<rx.c<T>, rx.c<R>> createReplaySelectorAndObserveOn(yp.g<? super rx.c<T>, ? extends rx.c<R>> gVar, rx.f fVar) {
        return new p(gVar, fVar);
    }

    public static <T> yp.f<zp.a<T>> createReplaySupplier(rx.c<T> cVar) {
        return new l(cVar);
    }

    public static yp.g<rx.c<? extends Notification<?>>, rx.c<?>> createRetryDematerializer(yp.g<? super rx.c<? extends Throwable>, ? extends rx.c<?>> gVar) {
        return new n(gVar);
    }

    public static yp.g<Object, Boolean> equalsWith(Object obj) {
        return new b(obj);
    }

    public static yp.g<Object, Boolean> isInstanceOf(Class<?> cls) {
        return new d(cls);
    }

    public static <T> yp.f<zp.a<T>> createReplaySupplier(rx.c<T> cVar, int i10) {
        return new j(cVar, i10);
    }

    public static <T> yp.f<zp.a<T>> createReplaySupplier(rx.c<T> cVar, long j10, TimeUnit timeUnit, rx.f fVar) {
        return new k(cVar, j10, timeUnit, fVar);
    }

    public static <T> yp.f<zp.a<T>> createReplaySupplier(rx.c<T> cVar, int i10, long j10, TimeUnit timeUnit, rx.f fVar) {
        return new m(cVar, i10, j10, timeUnit, fVar);
    }
}
