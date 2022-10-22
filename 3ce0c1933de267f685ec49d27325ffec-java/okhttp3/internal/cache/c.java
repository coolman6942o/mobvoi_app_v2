package okhttp3.internal.cache;

import com.mobvoi.wear.util.LogCleaner;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.text.t;
import okhttp3.Headers;
import okhttp3.b0;
import okhttp3.d;
import okhttp3.z;
/* compiled from: CacheStrategy.kt */
/* loaded from: classes3.dex */
public final class c {

    /* renamed from: c  reason: collision with root package name */
    public static final a f31879c = new a(null);

    /* renamed from: a  reason: collision with root package name */
    private final z f31880a;

    /* renamed from: b  reason: collision with root package name */
    private final b0 f31881b;

    /* compiled from: CacheStrategy.kt */
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public final boolean a(b0 response, z request) {
            i.f(response, "response");
            i.f(request, "request");
            int n10 = response.n();
            if (!(n10 == 200 || n10 == 410 || n10 == 414 || n10 == 501 || n10 == 203 || n10 == 204)) {
                if (n10 != 307) {
                    if (!(n10 == 308 || n10 == 404 || n10 == 405)) {
                        switch (n10) {
                            case 300:
                            case 301:
                                break;
                            case 302:
                                break;
                            default:
                                return false;
                        }
                    }
                }
                if (b0.w(response, "Expires", null, 2, null) == null && response.d().c() == -1 && !response.d().b() && !response.d().a()) {
                    return false;
                }
            }
            return !response.d().h() && !request.b().h();
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: CacheStrategy.kt */
    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private Date f31882a;

        /* renamed from: b  reason: collision with root package name */
        private String f31883b;

        /* renamed from: c  reason: collision with root package name */
        private Date f31884c;

        /* renamed from: d  reason: collision with root package name */
        private String f31885d;

        /* renamed from: e  reason: collision with root package name */
        private Date f31886e;

        /* renamed from: f  reason: collision with root package name */
        private long f31887f;

        /* renamed from: g  reason: collision with root package name */
        private long f31888g;

        /* renamed from: h  reason: collision with root package name */
        private String f31889h;

        /* renamed from: i  reason: collision with root package name */
        private int f31890i;

        /* renamed from: j  reason: collision with root package name */
        private final long f31891j;

        /* renamed from: k  reason: collision with root package name */
        private final z f31892k;

        /* renamed from: l  reason: collision with root package name */
        private final b0 f31893l;

        public b(long j10, z request, b0 b0Var) {
            boolean p10;
            boolean p11;
            boolean p12;
            boolean p13;
            boolean p14;
            i.f(request, "request");
            this.f31891j = j10;
            this.f31892k = request;
            this.f31893l = b0Var;
            this.f31890i = -1;
            if (b0Var != null) {
                this.f31887f = b0Var.h0();
                this.f31888g = b0Var.W();
                Headers x10 = b0Var.x();
                int size = x10.size();
                for (int i10 = 0; i10 < size; i10++) {
                    String name = x10.name(i10);
                    String value = x10.value(i10);
                    p10 = t.p(name, "Date", true);
                    if (p10) {
                        this.f31882a = jp.c.a(value);
                        this.f31883b = value;
                    } else {
                        p11 = t.p(name, "Expires", true);
                        if (p11) {
                            this.f31886e = jp.c.a(value);
                        } else {
                            p12 = t.p(name, "Last-Modified", true);
                            if (p12) {
                                this.f31884c = jp.c.a(value);
                                this.f31885d = value;
                            } else {
                                p13 = t.p(name, "ETag", true);
                                if (p13) {
                                    this.f31889h = value;
                                } else {
                                    p14 = t.p(name, "Age", true);
                                    if (p14) {
                                        this.f31890i = gp.b.R(value, -1);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        private final long a() {
            Date date = this.f31882a;
            long j10 = 0;
            if (date != null) {
                j10 = Math.max(0L, this.f31888g - date.getTime());
            }
            int i10 = this.f31890i;
            if (i10 != -1) {
                j10 = Math.max(j10, TimeUnit.SECONDS.toMillis(i10));
            }
            long j11 = this.f31888g;
            return j10 + (j11 - this.f31887f) + (this.f31891j - j11);
        }

        private final c c() {
            if (this.f31893l == null) {
                return new c(this.f31892k, null);
            }
            if (this.f31892k.g() && this.f31893l.q() == null) {
                return new c(this.f31892k, null);
            }
            if (!c.f31879c.a(this.f31893l, this.f31892k)) {
                return new c(this.f31892k, null);
            }
            d b10 = this.f31892k.b();
            if (b10.g() || e(this.f31892k)) {
                return new c(this.f31892k, null);
            }
            d d10 = this.f31893l.d();
            long a10 = a();
            long d11 = d();
            if (b10.c() != -1) {
                d11 = Math.min(d11, TimeUnit.SECONDS.toMillis(b10.c()));
            }
            long j10 = 0;
            long millis = b10.e() != -1 ? TimeUnit.SECONDS.toMillis(b10.e()) : 0L;
            if (!d10.f() && b10.d() != -1) {
                j10 = TimeUnit.SECONDS.toMillis(b10.d());
            }
            if (!d10.g()) {
                long j11 = millis + a10;
                if (j11 < j10 + d11) {
                    b0.a Q = this.f31893l.Q();
                    if (j11 >= d11) {
                        Q.a("Warning", "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (a10 > LogCleaner.ONE_DAY && f()) {
                        Q.a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new c(null, Q.c());
                }
            }
            String str = this.f31889h;
            String str2 = "If-Modified-Since";
            if (str != null) {
                str2 = "If-None-Match";
            } else if (this.f31884c != null) {
                str = this.f31885d;
            } else if (this.f31882a == null) {
                return new c(this.f31892k, null);
            } else {
                str = this.f31883b;
            }
            Headers.a newBuilder = this.f31892k.f().newBuilder();
            i.d(str);
            newBuilder.d(str2, str);
            return new c(this.f31892k.i().i(newBuilder.f()).b(), this.f31893l);
        }

        private final long d() {
            b0 b0Var = this.f31893l;
            i.d(b0Var);
            d d10 = b0Var.d();
            if (d10.c() != -1) {
                return TimeUnit.SECONDS.toMillis(d10.c());
            }
            Date date = this.f31886e;
            if (date != null) {
                Date date2 = this.f31882a;
                long time = date.getTime() - (date2 != null ? date2.getTime() : this.f31888g);
                if (time > 0) {
                    return time;
                }
                return 0L;
            } else if (this.f31884c == null || this.f31893l.g0().l().o() != null) {
                return 0L;
            } else {
                Date date3 = this.f31882a;
                long time2 = date3 != null ? date3.getTime() : this.f31887f;
                Date date4 = this.f31884c;
                i.d(date4);
                long time3 = time2 - date4.getTime();
                if (time3 > 0) {
                    return time3 / 10;
                }
                return 0L;
            }
        }

        private final boolean e(z zVar) {
            return (zVar.d("If-Modified-Since") == null && zVar.d("If-None-Match") == null) ? false : true;
        }

        private final boolean f() {
            b0 b0Var = this.f31893l;
            i.d(b0Var);
            return b0Var.d().c() == -1 && this.f31886e == null;
        }

        public final c b() {
            c c10 = c();
            return (c10.b() == null || !this.f31892k.b().i()) ? c10 : new c(null, null);
        }
    }

    public c(z zVar, b0 b0Var) {
        this.f31880a = zVar;
        this.f31881b = b0Var;
    }

    public final b0 a() {
        return this.f31881b;
    }

    public final z b() {
        return this.f31880a;
    }
}
