package bo;

import io.reactivex.exceptions.OnErrorNotImplementedException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
/* compiled from: Functions.java */
/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    static final zn.o<Object, Object> f5357a = new v();

    /* renamed from: b  reason: collision with root package name */
    public static final Runnable f5358b = new q();

    /* renamed from: c  reason: collision with root package name */
    public static final zn.a f5359c = new n();

    /* renamed from: d  reason: collision with root package name */
    static final zn.g<Object> f5360d = new o();

    /* renamed from: e  reason: collision with root package name */
    public static final zn.g<Throwable> f5361e = new f0();

    /* renamed from: f  reason: collision with root package name */
    static final zn.p<Object> f5362f = new k0();

    /* renamed from: g  reason: collision with root package name */
    static final zn.p<Object> f5363g = new t();

    /* renamed from: h  reason: collision with root package name */
    static final Callable<Object> f5364h = new e0();

    /* renamed from: i  reason: collision with root package name */
    static final Comparator<Object> f5365i = new a0();

    /* compiled from: Functions.java */
    /* renamed from: bo.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    static final class C0077a<T> implements zn.g<T> {

        /* renamed from: a  reason: collision with root package name */
        final zn.a f5366a;

        C0077a(zn.a aVar) {
            this.f5366a = aVar;
        }

        @Override // zn.g
        public void accept(T t10) throws Exception {
            this.f5366a.run();
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes2.dex */
    static final class a0 implements Comparator<Object> {
        a0() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes2.dex */
    static final class b<T1, T2, R> implements zn.o<Object[], R> {

        /* renamed from: a  reason: collision with root package name */
        final zn.c<? super T1, ? super T2, ? extends R> f5367a;

        b(zn.c<? super T1, ? super T2, ? extends R> cVar) {
            this.f5367a = cVar;
        }

        /* renamed from: a */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 2) {
                return this.f5367a.apply(objArr[0], objArr[1]);
            }
            throw new IllegalArgumentException("Array of size 2 expected but got " + objArr.length);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes2.dex */
    static final class b0<T> implements zn.a {

        /* renamed from: a  reason: collision with root package name */
        final zn.g<? super io.reactivex.j<T>> f5368a;

        b0(zn.g<? super io.reactivex.j<T>> gVar) {
            this.f5368a = gVar;
        }

        @Override // zn.a
        public void run() throws Exception {
            this.f5368a.accept(io.reactivex.j.a());
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes2.dex */
    static final class c<T1, T2, T3, R> implements zn.o<Object[], R> {

        /* renamed from: a  reason: collision with root package name */
        final zn.h<T1, T2, T3, R> f5369a;

        c(zn.h<T1, T2, T3, R> hVar) {
            this.f5369a = hVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: a */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 3) {
                return (R) this.f5369a.a(objArr[0], objArr[1], objArr[2]);
            }
            throw new IllegalArgumentException("Array of size 3 expected but got " + objArr.length);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes2.dex */
    static final class c0<T> implements zn.g<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        final zn.g<? super io.reactivex.j<T>> f5370a;

        c0(zn.g<? super io.reactivex.j<T>> gVar) {
            this.f5370a = gVar;
        }

        /* renamed from: a */
        public void accept(Throwable th2) throws Exception {
            this.f5370a.accept(io.reactivex.j.b(th2));
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes2.dex */
    static final class d<T1, T2, T3, T4, R> implements zn.o<Object[], R> {

        /* renamed from: a  reason: collision with root package name */
        final zn.i<T1, T2, T3, T4, R> f5371a;

        d(zn.i<T1, T2, T3, T4, R> iVar) {
            this.f5371a = iVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: a */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 4) {
                return (R) this.f5371a.a(objArr[0], objArr[1], objArr[2], objArr[3]);
            }
            throw new IllegalArgumentException("Array of size 4 expected but got " + objArr.length);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes2.dex */
    static final class d0<T> implements zn.g<T> {

        /* renamed from: a  reason: collision with root package name */
        final zn.g<? super io.reactivex.j<T>> f5372a;

        d0(zn.g<? super io.reactivex.j<T>> gVar) {
            this.f5372a = gVar;
        }

        @Override // zn.g
        public void accept(T t10) throws Exception {
            this.f5372a.accept(io.reactivex.j.c(t10));
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes2.dex */
    static final class e<T1, T2, T3, T4, T5, R> implements zn.o<Object[], R> {

        /* renamed from: a  reason: collision with root package name */
        private final zn.j<T1, T2, T3, T4, T5, R> f5373a;

        e(zn.j<T1, T2, T3, T4, T5, R> jVar) {
            this.f5373a = jVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: a */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 5) {
                return (R) this.f5373a.a(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4]);
            }
            throw new IllegalArgumentException("Array of size 5 expected but got " + objArr.length);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes2.dex */
    static final class e0 implements Callable<Object> {
        e0() {
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            return null;
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes2.dex */
    static final class f<T1, T2, T3, T4, T5, T6, R> implements zn.o<Object[], R> {

        /* renamed from: a  reason: collision with root package name */
        final zn.k<T1, T2, T3, T4, T5, T6, R> f5374a;

        f(zn.k<T1, T2, T3, T4, T5, T6, R> kVar) {
            this.f5374a = kVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: a */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 6) {
                return (R) this.f5374a.a(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5]);
            }
            throw new IllegalArgumentException("Array of size 6 expected but got " + objArr.length);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes2.dex */
    static final class f0 implements zn.g<Throwable> {
        f0() {
        }

        /* renamed from: a */
        public void accept(Throwable th2) {
            fo.a.s(new OnErrorNotImplementedException(th2));
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes2.dex */
    static final class g<T1, T2, T3, T4, T5, T6, T7, R> implements zn.o<Object[], R> {

        /* renamed from: a  reason: collision with root package name */
        final zn.l<T1, T2, T3, T4, T5, T6, T7, R> f5375a;

        g(zn.l<T1, T2, T3, T4, T5, T6, T7, R> lVar) {
            this.f5375a = lVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: a */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 7) {
                return (R) this.f5375a.a(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6]);
            }
            throw new IllegalArgumentException("Array of size 7 expected but got " + objArr.length);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes2.dex */
    static final class g0<T> implements zn.o<T, go.b<T>> {

        /* renamed from: a  reason: collision with root package name */
        final TimeUnit f5376a;

        /* renamed from: b  reason: collision with root package name */
        final io.reactivex.s f5377b;

        g0(TimeUnit timeUnit, io.reactivex.s sVar) {
            this.f5376a = timeUnit;
            this.f5377b = sVar;
        }

        /* renamed from: a */
        public go.b<T> apply(T t10) throws Exception {
            return new go.b<>(t10, this.f5377b.b(this.f5376a), this.f5376a);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes2.dex */
    static final class h<T1, T2, T3, T4, T5, T6, T7, T8, R> implements zn.o<Object[], R> {

        /* renamed from: a  reason: collision with root package name */
        final zn.m<T1, T2, T3, T4, T5, T6, T7, T8, R> f5378a;

        h(zn.m<T1, T2, T3, T4, T5, T6, T7, T8, R> mVar) {
            this.f5378a = mVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: a */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 8) {
                return (R) this.f5378a.a(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7]);
            }
            throw new IllegalArgumentException("Array of size 8 expected but got " + objArr.length);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes2.dex */
    static final class h0<K, T> implements zn.b<Map<K, T>, T> {

        /* renamed from: a  reason: collision with root package name */
        private final zn.o<? super T, ? extends K> f5379a;

        h0(zn.o<? super T, ? extends K> oVar) {
            this.f5379a = oVar;
        }

        /* renamed from: a */
        public void accept(Map<K, T> map, T t10) throws Exception {
            map.put(this.f5379a.apply(t10), t10);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes2.dex */
    static final class i<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> implements zn.o<Object[], R> {

        /* renamed from: a  reason: collision with root package name */
        final zn.n<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> f5380a;

        i(zn.n<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> nVar) {
            this.f5380a = nVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: a */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 9) {
                return (R) this.f5380a.a(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7], objArr[8]);
            }
            throw new IllegalArgumentException("Array of size 9 expected but got " + objArr.length);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes2.dex */
    static final class i0<K, V, T> implements zn.b<Map<K, V>, T> {

        /* renamed from: a  reason: collision with root package name */
        private final zn.o<? super T, ? extends V> f5381a;

        /* renamed from: b  reason: collision with root package name */
        private final zn.o<? super T, ? extends K> f5382b;

        i0(zn.o<? super T, ? extends V> oVar, zn.o<? super T, ? extends K> oVar2) {
            this.f5381a = oVar;
            this.f5382b = oVar2;
        }

        /* renamed from: a */
        public void accept(Map<K, V> map, T t10) throws Exception {
            map.put(this.f5382b.apply(t10), this.f5381a.apply(t10));
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes2.dex */
    static final class j<T> implements Callable<List<T>> {

        /* renamed from: a  reason: collision with root package name */
        final int f5383a;

        j(int i10) {
            this.f5383a = i10;
        }

        /* renamed from: a */
        public List<T> call() throws Exception {
            return new ArrayList(this.f5383a);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes2.dex */
    static final class j0<K, V, T> implements zn.b<Map<K, Collection<V>>, T> {

        /* renamed from: a  reason: collision with root package name */
        private final zn.o<? super K, ? extends Collection<? super V>> f5384a;

        /* renamed from: b  reason: collision with root package name */
        private final zn.o<? super T, ? extends V> f5385b;

        /* renamed from: c  reason: collision with root package name */
        private final zn.o<? super T, ? extends K> f5386c;

        j0(zn.o<? super K, ? extends Collection<? super V>> oVar, zn.o<? super T, ? extends V> oVar2, zn.o<? super T, ? extends K> oVar3) {
            this.f5384a = oVar;
            this.f5385b = oVar2;
            this.f5386c = oVar3;
        }

        /* renamed from: a */
        public void accept(Map<K, Collection<V>> map, T t10) throws Exception {
            K apply = this.f5386c.apply(t10);
            Collection<? super V> collection = map.get(apply);
            if (collection == null) {
                collection = this.f5384a.apply(apply);
                map.put(apply, collection);
            }
            collection.add(this.f5385b.apply(t10));
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes2.dex */
    static final class k<T> implements zn.p<T> {

        /* renamed from: a  reason: collision with root package name */
        final zn.e f5387a;

        k(zn.e eVar) {
            this.f5387a = eVar;
        }

        @Override // zn.p
        public boolean test(T t10) throws Exception {
            return !this.f5387a.a();
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes2.dex */
    static final class k0 implements zn.p<Object> {
        k0() {
        }

        @Override // zn.p
        public boolean test(Object obj) {
            return true;
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes2.dex */
    static final class l<T, U> implements zn.o<T, U> {

        /* renamed from: a  reason: collision with root package name */
        final Class<U> f5388a;

        l(Class<U> cls) {
            this.f5388a = cls;
        }

        @Override // zn.o
        public U apply(T t10) throws Exception {
            return this.f5388a.cast(t10);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes2.dex */
    static final class m<T, U> implements zn.p<T> {

        /* renamed from: a  reason: collision with root package name */
        final Class<U> f5389a;

        m(Class<U> cls) {
            this.f5389a = cls;
        }

        @Override // zn.p
        public boolean test(T t10) throws Exception {
            return this.f5389a.isInstance(t10);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes2.dex */
    static final class n implements zn.a {
        n() {
        }

        @Override // zn.a
        public void run() {
        }

        public String toString() {
            return "EmptyAction";
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes2.dex */
    static final class o implements zn.g<Object> {
        o() {
        }

        @Override // zn.g
        public void accept(Object obj) {
        }

        public String toString() {
            return "EmptyConsumer";
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes2.dex */
    static final class p {
        p() {
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes2.dex */
    static final class q implements Runnable {
        q() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }

        public String toString() {
            return "EmptyRunnable";
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes2.dex */
    static final class r<T> implements zn.p<T> {

        /* renamed from: a  reason: collision with root package name */
        final T f5390a;

        r(T t10) {
            this.f5390a = t10;
        }

        @Override // zn.p
        public boolean test(T t10) throws Exception {
            return bo.b.c(t10, this.f5390a);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes2.dex */
    static final class s implements zn.g<Throwable> {
        s() {
        }

        /* renamed from: a */
        public void accept(Throwable th2) {
            fo.a.s(th2);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes2.dex */
    static final class t implements zn.p<Object> {
        t() {
        }

        @Override // zn.p
        public boolean test(Object obj) {
            return false;
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes2.dex */
    enum u implements Callable<Set<Object>> {
        INSTANCE;

        /* renamed from: a */
        public Set<Object> call() throws Exception {
            return new HashSet();
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes2.dex */
    static final class v implements zn.o<Object, Object> {
        v() {
        }

        @Override // zn.o
        public Object apply(Object obj) {
            return obj;
        }

        public String toString() {
            return "IdentityFunction";
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes2.dex */
    static final class w<T, U> implements Callable<U>, zn.o<T, U> {

        /* renamed from: a  reason: collision with root package name */
        final U f5391a;

        w(U u10) {
            this.f5391a = u10;
        }

        @Override // zn.o
        public U apply(T t10) throws Exception {
            return this.f5391a;
        }

        @Override // java.util.concurrent.Callable
        public U call() throws Exception {
            return this.f5391a;
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes2.dex */
    static final class x<T> implements zn.o<List<T>, List<T>> {

        /* renamed from: a  reason: collision with root package name */
        final Comparator<? super T> f5392a;

        x(Comparator<? super T> comparator) {
            this.f5392a = comparator;
        }

        /* renamed from: a */
        public List<T> apply(List<T> list) {
            Collections.sort(list, this.f5392a);
            return list;
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes2.dex */
    static final class y implements zn.g<vp.c> {
        y() {
        }

        /* renamed from: a */
        public void accept(vp.c cVar) throws Exception {
            cVar.request(Long.MAX_VALUE);
        }
    }

    /* compiled from: Functions.java */
    /* loaded from: classes2.dex */
    enum z implements Comparator<Object> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    static {
        new s();
        new p();
        new y();
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> zn.o<Object[], R> A(zn.l<T1, T2, T3, T4, T5, T6, T7, R> lVar) {
        bo.b.e(lVar, "f is null");
        return new g(lVar);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> zn.o<Object[], R> B(zn.m<T1, T2, T3, T4, T5, T6, T7, T8, R> mVar) {
        bo.b.e(mVar, "f is null");
        return new h(mVar);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> zn.o<Object[], R> C(zn.n<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> nVar) {
        bo.b.e(nVar, "f is null");
        return new i(nVar);
    }

    public static <T, K> zn.b<Map<K, T>, T> D(zn.o<? super T, ? extends K> oVar) {
        return new h0(oVar);
    }

    public static <T, K, V> zn.b<Map<K, V>, T> E(zn.o<? super T, ? extends K> oVar, zn.o<? super T, ? extends V> oVar2) {
        return new i0(oVar2, oVar);
    }

    public static <T, K, V> zn.b<Map<K, Collection<V>>, T> F(zn.o<? super T, ? extends K> oVar, zn.o<? super T, ? extends V> oVar2, zn.o<? super K, ? extends Collection<? super V>> oVar3) {
        return new j0(oVar3, oVar2, oVar);
    }

    public static <T> zn.g<T> a(zn.a aVar) {
        return new C0077a(aVar);
    }

    public static <T> zn.p<T> b() {
        return (zn.p<T>) f5363g;
    }

    public static <T> zn.p<T> c() {
        return (zn.p<T>) f5362f;
    }

    public static <T, U> zn.o<T, U> d(Class<U> cls) {
        return new l(cls);
    }

    public static <T> Callable<List<T>> e(int i10) {
        return new j(i10);
    }

    public static <T> Callable<Set<T>> f() {
        return u.INSTANCE;
    }

    public static <T> zn.g<T> g() {
        return (zn.g<T>) f5360d;
    }

    public static <T> zn.p<T> h(T t10) {
        return new r(t10);
    }

    public static <T> zn.o<T, T> i() {
        return (zn.o<T, T>) f5357a;
    }

    public static <T, U> zn.p<T> j(Class<U> cls) {
        return new m(cls);
    }

    public static <T> Callable<T> k(T t10) {
        return new w(t10);
    }

    public static <T, U> zn.o<T, U> l(U u10) {
        return new w(u10);
    }

    public static <T> zn.o<List<T>, List<T>> m(Comparator<? super T> comparator) {
        return new x(comparator);
    }

    public static <T> Comparator<T> n() {
        return z.INSTANCE;
    }

    public static <T> Comparator<T> o() {
        return (Comparator<T>) f5365i;
    }

    public static <T> zn.a p(zn.g<? super io.reactivex.j<T>> gVar) {
        return new b0(gVar);
    }

    public static <T> zn.g<Throwable> q(zn.g<? super io.reactivex.j<T>> gVar) {
        return new c0(gVar);
    }

    public static <T> zn.g<T> r(zn.g<? super io.reactivex.j<T>> gVar) {
        return new d0(gVar);
    }

    public static <T> Callable<T> s() {
        return (Callable<T>) f5364h;
    }

    public static <T> zn.p<T> t(zn.e eVar) {
        return new k(eVar);
    }

    public static <T> zn.o<T, go.b<T>> u(TimeUnit timeUnit, io.reactivex.s sVar) {
        return new g0(timeUnit, sVar);
    }

    public static <T1, T2, R> zn.o<Object[], R> v(zn.c<? super T1, ? super T2, ? extends R> cVar) {
        bo.b.e(cVar, "f is null");
        return new b(cVar);
    }

    public static <T1, T2, T3, R> zn.o<Object[], R> w(zn.h<T1, T2, T3, R> hVar) {
        bo.b.e(hVar, "f is null");
        return new c(hVar);
    }

    public static <T1, T2, T3, T4, R> zn.o<Object[], R> x(zn.i<T1, T2, T3, T4, R> iVar) {
        bo.b.e(iVar, "f is null");
        return new d(iVar);
    }

    public static <T1, T2, T3, T4, T5, R> zn.o<Object[], R> y(zn.j<T1, T2, T3, T4, T5, R> jVar) {
        bo.b.e(jVar, "f is null");
        return new e(jVar);
    }

    public static <T1, T2, T3, T4, T5, T6, R> zn.o<Object[], R> z(zn.k<T1, T2, T3, T4, T5, T6, R> kVar) {
        bo.b.e(kVar, "f is null");
        return new f(kVar);
    }
}
