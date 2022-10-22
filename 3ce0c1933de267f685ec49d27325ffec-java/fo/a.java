package fo;

import io.reactivex.e;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.exceptions.UndeliverableException;
import io.reactivex.h;
import io.reactivex.internal.util.f;
import io.reactivex.k;
import io.reactivex.r;
import io.reactivex.s;
import io.reactivex.t;
import io.reactivex.u;
import java.util.concurrent.Callable;
import vp.b;
import zn.c;
import zn.g;
import zn.o;
/* compiled from: RxJavaPlugins.java */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    static volatile g<? super Throwable> f27147a;

    /* renamed from: b  reason: collision with root package name */
    static volatile o<? super Runnable, ? extends Runnable> f27148b;

    /* renamed from: c  reason: collision with root package name */
    static volatile o<? super Callable<s>, ? extends s> f27149c;

    /* renamed from: d  reason: collision with root package name */
    static volatile o<? super Callable<s>, ? extends s> f27150d;

    /* renamed from: e  reason: collision with root package name */
    static volatile o<? super Callable<s>, ? extends s> f27151e;

    /* renamed from: f  reason: collision with root package name */
    static volatile o<? super Callable<s>, ? extends s> f27152f;

    /* renamed from: g  reason: collision with root package name */
    static volatile o<? super s, ? extends s> f27153g;

    /* renamed from: h  reason: collision with root package name */
    static volatile o<? super s, ? extends s> f27154h;

    /* renamed from: i  reason: collision with root package name */
    static volatile o<? super e, ? extends e> f27155i;

    /* renamed from: j  reason: collision with root package name */
    static volatile o<? super k, ? extends k> f27156j;

    /* renamed from: k  reason: collision with root package name */
    static volatile o<? super p001do.a, ? extends p001do.a> f27157k;

    /* renamed from: l  reason: collision with root package name */
    static volatile o<? super io.reactivex.g, ? extends io.reactivex.g> f27158l;

    /* renamed from: m  reason: collision with root package name */
    static volatile o<? super t, ? extends t> f27159m;

    /* renamed from: n  reason: collision with root package name */
    static volatile o<? super io.reactivex.a, ? extends io.reactivex.a> f27160n;

    /* renamed from: o  reason: collision with root package name */
    static volatile c<? super e, ? super b, ? extends b> f27161o;

    /* renamed from: p  reason: collision with root package name */
    static volatile c<? super io.reactivex.g, ? super h, ? extends h> f27162p;

    /* renamed from: q  reason: collision with root package name */
    static volatile c<? super k, ? super r, ? extends r> f27163q;

    /* renamed from: r  reason: collision with root package name */
    static volatile c<? super t, ? super u, ? extends u> f27164r;

    /* renamed from: s  reason: collision with root package name */
    static volatile c<? super io.reactivex.a, ? super io.reactivex.b, ? extends io.reactivex.b> f27165s;

    /* renamed from: t  reason: collision with root package name */
    static volatile zn.e f27166t;

    /* renamed from: u  reason: collision with root package name */
    static volatile boolean f27167u;

    static void A(Throwable th2) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th2);
    }

    static <T, U, R> R a(c<T, U, R> cVar, T t10, U u10) {
        try {
            return cVar.apply(t10, u10);
        } catch (Throwable th2) {
            throw f.d(th2);
        }
    }

    static <T, R> R b(o<T, R> oVar, T t10) {
        try {
            return oVar.apply(t10);
        } catch (Throwable th2) {
            throw f.d(th2);
        }
    }

    static s c(o<? super Callable<s>, ? extends s> oVar, Callable<s> callable) {
        return (s) bo.b.e(b(oVar, callable), "Scheduler Callable result can't be null");
    }

    static s d(Callable<s> callable) {
        try {
            return (s) bo.b.e(callable.call(), "Scheduler Callable result can't be null");
        } catch (Throwable th2) {
            throw f.d(th2);
        }
    }

    public static s e(Callable<s> callable) {
        bo.b.e(callable, "Scheduler Callable can't be null");
        o<? super Callable<s>, ? extends s> oVar = f27149c;
        if (oVar == null) {
            return d(callable);
        }
        return c(oVar, callable);
    }

    public static s f(Callable<s> callable) {
        bo.b.e(callable, "Scheduler Callable can't be null");
        o<? super Callable<s>, ? extends s> oVar = f27151e;
        if (oVar == null) {
            return d(callable);
        }
        return c(oVar, callable);
    }

    public static s g(Callable<s> callable) {
        bo.b.e(callable, "Scheduler Callable can't be null");
        o<? super Callable<s>, ? extends s> oVar = f27152f;
        if (oVar == null) {
            return d(callable);
        }
        return c(oVar, callable);
    }

    public static s h(Callable<s> callable) {
        bo.b.e(callable, "Scheduler Callable can't be null");
        o<? super Callable<s>, ? extends s> oVar = f27150d;
        if (oVar == null) {
            return d(callable);
        }
        return c(oVar, callable);
    }

    static boolean i(Throwable th2) {
        return (th2 instanceof OnErrorNotImplementedException) || (th2 instanceof MissingBackpressureException) || (th2 instanceof IllegalStateException) || (th2 instanceof NullPointerException) || (th2 instanceof IllegalArgumentException) || (th2 instanceof CompositeException);
    }

    public static boolean j() {
        return f27167u;
    }

    public static <T> p001do.a<T> k(p001do.a<T> aVar) {
        o<? super p001do.a, ? extends p001do.a> oVar = f27157k;
        return oVar != null ? (p001do.a) b(oVar, aVar) : aVar;
    }

    public static io.reactivex.a l(io.reactivex.a aVar) {
        o<? super io.reactivex.a, ? extends io.reactivex.a> oVar = f27160n;
        return oVar != null ? (io.reactivex.a) b(oVar, aVar) : aVar;
    }

    public static <T> e<T> m(e<T> eVar) {
        o<? super e, ? extends e> oVar = f27155i;
        return oVar != null ? (e) b(oVar, eVar) : eVar;
    }

    public static <T> io.reactivex.g<T> n(io.reactivex.g<T> gVar) {
        o<? super io.reactivex.g, ? extends io.reactivex.g> oVar = f27158l;
        return oVar != null ? (io.reactivex.g) b(oVar, gVar) : gVar;
    }

    public static <T> k<T> o(k<T> kVar) {
        o<? super k, ? extends k> oVar = f27156j;
        return oVar != null ? (k) b(oVar, kVar) : kVar;
    }

    public static <T> t<T> p(t<T> tVar) {
        o<? super t, ? extends t> oVar = f27159m;
        return oVar != null ? (t) b(oVar, tVar) : tVar;
    }

    public static boolean q() {
        zn.e eVar = f27166t;
        if (eVar == null) {
            return false;
        }
        try {
            return eVar.a();
        } catch (Throwable th2) {
            throw f.d(th2);
        }
    }

    public static s r(s sVar) {
        o<? super s, ? extends s> oVar = f27153g;
        return oVar == null ? sVar : (s) b(oVar, sVar);
    }

    public static void s(Throwable th2) {
        g<? super Throwable> gVar = f27147a;
        if (th2 == null) {
            th2 = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        } else if (!i(th2)) {
            th2 = new UndeliverableException(th2);
        }
        if (gVar != null) {
            try {
                gVar.accept(th2);
                return;
            } catch (Throwable th3) {
                th3.printStackTrace();
                A(th3);
            }
        }
        th2.printStackTrace();
        A(th2);
    }

    public static s t(s sVar) {
        o<? super s, ? extends s> oVar = f27154h;
        return oVar == null ? sVar : (s) b(oVar, sVar);
    }

    public static Runnable u(Runnable runnable) {
        bo.b.e(runnable, "run is null");
        o<? super Runnable, ? extends Runnable> oVar = f27148b;
        return oVar == null ? runnable : (Runnable) b(oVar, runnable);
    }

    public static io.reactivex.b v(io.reactivex.a aVar, io.reactivex.b bVar) {
        c<? super io.reactivex.a, ? super io.reactivex.b, ? extends io.reactivex.b> cVar = f27165s;
        return cVar != null ? (io.reactivex.b) a(cVar, aVar, bVar) : bVar;
    }

    public static <T> h<? super T> w(io.reactivex.g<T> gVar, h<? super T> hVar) {
        c<? super io.reactivex.g, ? super h, ? extends h> cVar = f27162p;
        return cVar != null ? (h) a(cVar, gVar, hVar) : hVar;
    }

    public static <T> r<? super T> x(k<T> kVar, r<? super T> rVar) {
        c<? super k, ? super r, ? extends r> cVar = f27163q;
        return cVar != null ? (r) a(cVar, kVar, rVar) : rVar;
    }

    public static <T> u<? super T> y(t<T> tVar, u<? super T> uVar) {
        c<? super t, ? super u, ? extends u> cVar = f27164r;
        return cVar != null ? (u) a(cVar, tVar, uVar) : uVar;
    }

    public static <T> b<? super T> z(e<T> eVar, b<? super T> bVar) {
        c<? super e, ? super b, ? extends b> cVar = f27161o;
        return cVar != null ? (b) a(cVar, eVar, bVar) : bVar;
    }
}
