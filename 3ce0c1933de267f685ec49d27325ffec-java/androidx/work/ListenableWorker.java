package androidx.work;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import androidx.work.impl.utils.futures.c;
import com.google.common.util.concurrent.j;
import java.util.UUID;
import java.util.concurrent.Executor;
/* loaded from: classes.dex */
public abstract class ListenableWorker {

    /* renamed from: a  reason: collision with root package name */
    private Context f4671a;

    /* renamed from: b  reason: collision with root package name */
    private WorkerParameters f4672b;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f4673c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f4674d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f4675e;

    /* loaded from: classes.dex */
    public static abstract class a {

        /* renamed from: androidx.work.ListenableWorker$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0053a extends a {

            /* renamed from: a  reason: collision with root package name */
            private final d f4676a;

            public C0053a() {
                this(d.f4740c);
            }

            public d e() {
                return this.f4676a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || C0053a.class != obj.getClass()) {
                    return false;
                }
                return this.f4676a.equals(((C0053a) obj).f4676a);
            }

            public int hashCode() {
                return (C0053a.class.getName().hashCode() * 31) + this.f4676a.hashCode();
            }

            public String toString() {
                return "Failure {mOutputData=" + this.f4676a + '}';
            }

            public C0053a(d dVar) {
                this.f4676a = dVar;
            }
        }

        /* loaded from: classes.dex */
        public static final class b extends a {
            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && b.class == obj.getClass();
            }

            public int hashCode() {
                return b.class.getName().hashCode();
            }

            public String toString() {
                return "Retry";
            }
        }

        /* loaded from: classes.dex */
        public static final class c extends a {

            /* renamed from: a  reason: collision with root package name */
            private final d f4677a;

            public c() {
                this(d.f4740c);
            }

            public d e() {
                return this.f4677a;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (obj == null || c.class != obj.getClass()) {
                    return false;
                }
                return this.f4677a.equals(((c) obj).f4677a);
            }

            public int hashCode() {
                return (c.class.getName().hashCode() * 31) + this.f4677a.hashCode();
            }

            public String toString() {
                return "Success {mOutputData=" + this.f4677a + '}';
            }

            public c(d dVar) {
                this.f4677a = dVar;
            }
        }

        a() {
        }

        public static a a() {
            return new C0053a();
        }

        public static a b() {
            return new b();
        }

        public static a c() {
            return new c();
        }

        public static a d(d dVar) {
            return new c(dVar);
        }
    }

    @Keep
    @SuppressLint({"BanKeepAnnotation"})
    public ListenableWorker(Context context, WorkerParameters workerParameters) {
        if (context == null) {
            throw new IllegalArgumentException("Application Context is null");
        } else if (workerParameters != null) {
            this.f4671a = context;
            this.f4672b = workerParameters;
        } else {
            throw new IllegalArgumentException("WorkerParameters is null");
        }
    }

    public final Context a() {
        return this.f4671a;
    }

    public Executor c() {
        return this.f4672b.a();
    }

    public j<e> d() {
        c t10 = c.t();
        t10.q(new IllegalStateException("Expedited WorkRequests require a ListenableWorker to provide an implementation for `getForegroundInfoAsync()`"));
        return t10;
    }

    public final UUID f() {
        return this.f4672b.c();
    }

    public final d g() {
        return this.f4672b.d();
    }

    public a2.a h() {
        return this.f4672b.e();
    }

    public t i() {
        return this.f4672b.f();
    }

    public boolean j() {
        return this.f4675e;
    }

    public final boolean k() {
        return this.f4673c;
    }

    public final boolean l() {
        return this.f4674d;
    }

    public void m() {
    }

    public void n(boolean z10) {
        this.f4675e = z10;
    }

    public final void o() {
        this.f4674d = true;
    }

    public abstract j<a> p();

    public final void q() {
        this.f4673c = true;
        m();
    }
}
