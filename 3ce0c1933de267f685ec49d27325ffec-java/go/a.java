package go;

import io.reactivex.internal.schedulers.i;
import io.reactivex.internal.schedulers.j;
import io.reactivex.s;
import java.util.concurrent.Callable;
/* compiled from: Schedulers.java */
/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    static final s f27615a = fo.a.e(new b());

    /* renamed from: b  reason: collision with root package name */
    static final s f27616b = fo.a.f(new c());

    /* renamed from: c  reason: collision with root package name */
    static final s f27617c = j.f();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Schedulers.java */
    /* renamed from: go.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0293a {

        /* renamed from: a  reason: collision with root package name */
        static final s f27618a = new io.reactivex.internal.schedulers.b();
    }

    /* compiled from: Schedulers.java */
    /* loaded from: classes3.dex */
    static final class b implements Callable<s> {
        b() {
        }

        /* renamed from: a */
        public s call() throws Exception {
            return C0293a.f27618a;
        }
    }

    /* compiled from: Schedulers.java */
    /* loaded from: classes3.dex */
    static final class c implements Callable<s> {
        c() {
        }

        /* renamed from: a */
        public s call() throws Exception {
            return d.f27619a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Schedulers.java */
    /* loaded from: classes3.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        static final s f27619a = new io.reactivex.internal.schedulers.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Schedulers.java */
    /* loaded from: classes3.dex */
    public static final class e {

        /* renamed from: a  reason: collision with root package name */
        static final s f27620a = new io.reactivex.internal.schedulers.e();
    }

    /* compiled from: Schedulers.java */
    /* loaded from: classes3.dex */
    static final class f implements Callable<s> {
        f() {
        }

        /* renamed from: a */
        public s call() throws Exception {
            return e.f27620a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Schedulers.java */
    /* loaded from: classes3.dex */
    public static final class g {

        /* renamed from: a  reason: collision with root package name */
        static final s f27621a = new i();
    }

    /* compiled from: Schedulers.java */
    /* loaded from: classes3.dex */
    static final class h implements Callable<s> {
        h() {
        }

        /* renamed from: a */
        public s call() throws Exception {
            return g.f27621a;
        }
    }

    static {
        fo.a.h(new h());
        fo.a.g(new f());
    }

    public static s a() {
        return fo.a.r(f27615a);
    }

    public static s b() {
        return fo.a.t(f27616b);
    }

    public static s c() {
        return f27617c;
    }
}
