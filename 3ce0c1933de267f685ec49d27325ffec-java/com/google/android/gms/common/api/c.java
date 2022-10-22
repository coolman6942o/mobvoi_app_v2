package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import b6.c;
import b6.i;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.api.internal.e;
import com.google.android.gms.common.api.internal.f2;
import com.google.android.gms.common.api.internal.h1;
import com.google.android.gms.common.api.internal.i;
import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.common.api.internal.m;
import com.google.android.gms.common.api.internal.o;
import com.google.android.gms.common.api.internal.q;
import com.google.android.gms.common.api.internal.q1;
import com.google.android.gms.tasks.b;
import java.util.Collections;
import java.util.Set;
/* loaded from: classes.dex */
public class c<O extends a.d> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f8455a;

    /* renamed from: b  reason: collision with root package name */
    private final com.google.android.gms.common.api.a<O> f8456b;

    /* renamed from: c  reason: collision with root package name */
    private final O f8457c;

    /* renamed from: d  reason: collision with root package name */
    private final f2<O> f8458d;

    /* renamed from: e  reason: collision with root package name */
    private final Looper f8459e;

    /* renamed from: f  reason: collision with root package name */
    private final int f8460f;

    /* renamed from: g  reason: collision with root package name */
    private final m f8461g;

    /* renamed from: h  reason: collision with root package name */
    protected final e f8462h;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final m f8463a;

        /* renamed from: b  reason: collision with root package name */
        public final Looper f8464b;

        /* renamed from: com.google.android.gms.common.api.c$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0107a {

            /* renamed from: a  reason: collision with root package name */
            private m f8465a;

            /* renamed from: b  reason: collision with root package name */
            private Looper f8466b;

            public a a() {
                if (this.f8465a == null) {
                    this.f8465a = new com.google.android.gms.common.api.internal.a();
                }
                if (this.f8466b == null) {
                    this.f8466b = Looper.getMainLooper();
                }
                return new a(this.f8465a, this.f8466b);
            }

            public C0107a b(m mVar) {
                i.l(mVar, "StatusExceptionMapper must not be null.");
                this.f8465a = mVar;
                return this;
            }
        }

        static {
            new C0107a().a();
        }

        private a(m mVar, Account account, Looper looper) {
            this.f8463a = mVar;
            this.f8464b = looper;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(Context context, com.google.android.gms.common.api.a<O> aVar, Looper looper) {
        i.l(context, "Null context is not permitted.");
        i.l(aVar, "Api must not be null.");
        i.l(looper, "Looper must not be null.");
        Context applicationContext = context.getApplicationContext();
        this.f8455a = applicationContext;
        this.f8456b = aVar;
        this.f8457c = null;
        this.f8459e = looper;
        this.f8458d = f2.a(aVar);
        new h1(this);
        e m10 = e.m(applicationContext);
        this.f8462h = m10;
        this.f8460f = m10.p();
        this.f8461g = new com.google.android.gms.common.api.internal.a();
    }

    private final <A extends a.b, T extends com.google.android.gms.common.api.internal.c<? extends h, A>> T l(int i10, T t10) {
        t10.q();
        this.f8462h.j(this, i10, t10);
        return t10;
    }

    private final <TResult, A extends a.b> b<TResult> n(int i10, o<A, TResult> oVar) {
        com.google.android.gms.tasks.c cVar = new com.google.android.gms.tasks.c();
        this.f8462h.k(this, i10, oVar, cVar, this.f8461g);
        return cVar.a();
    }

    protected c.a a() {
        Account account;
        Set<Scope> set;
        GoogleSignInAccount W;
        GoogleSignInAccount W2;
        c.a aVar = new c.a();
        O o10 = this.f8457c;
        if (!(o10 instanceof a.d.b) || (W2 = ((a.d.b) o10).W()) == null) {
            O o11 = this.f8457c;
            account = o11 instanceof a.d.AbstractC0106a ? ((a.d.AbstractC0106a) o11).o() : null;
        } else {
            account = W2.o();
        }
        c.a c10 = aVar.c(account);
        O o12 = this.f8457c;
        if (!(o12 instanceof a.d.b) || (W = ((a.d.b) o12).W()) == null) {
            set = Collections.emptySet();
        } else {
            set = W.L0();
        }
        return c10.a(set).d(this.f8455a.getClass().getName()).e(this.f8455a.getPackageName());
    }

    public <A extends a.b, T extends com.google.android.gms.common.api.internal.c<? extends h, A>> T b(T t10) {
        return (T) l(0, t10);
    }

    public <TResult, A extends a.b> b<TResult> c(o<A, TResult> oVar) {
        return n(0, oVar);
    }

    @Deprecated
    public <A extends a.b, T extends k<A, ?>, U extends q<A, ?>> b<Void> d(T t10, U u10) {
        i.k(t10);
        i.k(u10);
        i.l(t10.b(), "Listener has already been released.");
        i.l(u10.a(), "Listener has already been released.");
        i.b(t10.b().equals(u10.a()), "Listener registration and unregistration methods must be constructed with the same ListenerHolder.");
        return this.f8462h.f(this, t10, u10);
    }

    public b<Boolean> e(i.a<?> aVar) {
        b6.i.l(aVar, "Listener key cannot be null.");
        return this.f8462h.e(this, aVar);
    }

    public <A extends a.b, T extends com.google.android.gms.common.api.internal.c<? extends h, A>> T f(T t10) {
        return (T) l(1, t10);
    }

    public final com.google.android.gms.common.api.a<O> g() {
        return this.f8456b;
    }

    public Context h() {
        return this.f8455a;
    }

    public final int i() {
        return this.f8460f;
    }

    public Looper j() {
        return this.f8459e;
    }

    /* JADX WARN: Type inference failed for: r9v1, types: [com.google.android.gms.common.api.a$f] */
    public a.f k(Looper looper, e.a<O> aVar) {
        return this.f8456b.d().c(this.f8455a, looper, a().b(), this.f8457c, aVar, aVar);
    }

    public q1 m(Context context, Handler handler) {
        return new q1(context, handler, a().b());
    }

    public final f2<O> o() {
        return this.f8458d;
    }

    public c(Context context, com.google.android.gms.common.api.a<O> aVar, O o10, a aVar2) {
        b6.i.l(context, "Null context is not permitted.");
        b6.i.l(aVar, "Api must not be null.");
        b6.i.l(aVar2, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        Context applicationContext = context.getApplicationContext();
        this.f8455a = applicationContext;
        this.f8456b = aVar;
        this.f8457c = o10;
        this.f8459e = aVar2.f8464b;
        this.f8458d = f2.b(aVar, o10);
        new h1(this);
        e m10 = e.m(applicationContext);
        this.f8462h = m10;
        this.f8460f = m10.p();
        this.f8461g = aVar2.f8463a;
        m10.i(this);
    }

    @Deprecated
    public c(Context context, com.google.android.gms.common.api.a<O> aVar, O o10, m mVar) {
        this(context, aVar, o10, new a.C0107a().b(mVar).a());
    }
}
