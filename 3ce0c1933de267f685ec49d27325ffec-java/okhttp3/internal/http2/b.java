package okhttp3.internal.http2;

import com.mobvoi.wear.info.IntentInfo;
import com.mobvoi.wear.util.TelephonyUtil;
import io.m;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Ref$LongRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import okhttp3.internal.http2.c;
import okio.ByteString;
/* compiled from: Http2Connection.kt */
/* loaded from: classes3.dex */
public final class b implements Closeable {
    private static final lp.d C;
    public static final c D = new c(null);
    private final e A;
    private final Set<Integer> B;

    /* renamed from: a */
    private final boolean f32055a;

    /* renamed from: b */
    private final d f32056b;

    /* renamed from: c */
    private final Map<Integer, okhttp3.internal.http2.d> f32057c = new LinkedHashMap();

    /* renamed from: d */
    private final String f32058d;

    /* renamed from: e */
    private int f32059e;

    /* renamed from: f */
    private int f32060f;

    /* renamed from: g */
    private boolean f32061g;

    /* renamed from: h */
    private final ip.e f32062h;

    /* renamed from: i */
    private final ip.d f32063i;

    /* renamed from: j */
    private final ip.d f32064j;

    /* renamed from: k */
    private final ip.d f32065k;

    /* renamed from: l */
    private final okhttp3.internal.http2.g f32066l;

    /* renamed from: m */
    private long f32067m;

    /* renamed from: n */
    private long f32068n;

    /* renamed from: o */
    private long f32069o;

    /* renamed from: p */
    private long f32070p;

    /* renamed from: q */
    private long f32071q;

    /* renamed from: r */
    private long f32072r;

    /* renamed from: s */
    private final lp.d f32073s;

    /* renamed from: t */
    private lp.d f32074t;

    /* renamed from: u */
    private long f32075u;

    /* renamed from: v */
    private long f32076v;

    /* renamed from: w */
    private long f32077w;

    /* renamed from: x */
    private long f32078x;

    /* renamed from: y */
    private final Socket f32079y;

    /* renamed from: z */
    private final okhttp3.internal.http2.e f32080z;

    /* compiled from: TaskQueue.kt */
    /* loaded from: classes3.dex */
    public static final class a extends ip.a {

        /* renamed from: e */
        final /* synthetic */ b f32081e;

        /* renamed from: f */
        final /* synthetic */ long f32082f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, String str2, b bVar, long j10) {
            super(str2, false, 2, null);
            this.f32081e = bVar;
            this.f32082f = j10;
        }

        @Override // ip.a
        public long f() {
            boolean z10;
            synchronized (this.f32081e) {
                if (this.f32081e.f32068n < this.f32081e.f32067m) {
                    z10 = true;
                } else {
                    this.f32081e.f32067m++;
                    z10 = false;
                }
            }
            if (z10) {
                this.f32081e.h0(null);
                return -1L;
            }
            this.f32081e.Y0(false, 1, 0);
            return this.f32082f;
        }
    }

    /* compiled from: Http2Connection.kt */
    /* renamed from: okhttp3.internal.http2.b$b */
    /* loaded from: classes3.dex */
    public static final class C0431b {

        /* renamed from: a */
        public Socket f32083a;

        /* renamed from: b */
        public String f32084b;

        /* renamed from: c */
        public okio.e f32085c;

        /* renamed from: d */
        public okio.d f32086d;

        /* renamed from: e */
        private d f32087e = d.f32092a;

        /* renamed from: f */
        private okhttp3.internal.http2.g f32088f = okhttp3.internal.http2.g.f32180a;

        /* renamed from: g */
        private int f32089g;

        /* renamed from: h */
        private boolean f32090h;

        /* renamed from: i */
        private final ip.e f32091i;

        public C0431b(boolean z10, ip.e taskRunner) {
            kotlin.jvm.internal.i.f(taskRunner, "taskRunner");
            this.f32090h = z10;
            this.f32091i = taskRunner;
        }

        public final b a() {
            return new b(this);
        }

        public final boolean b() {
            return this.f32090h;
        }

        public final String c() {
            String str = this.f32084b;
            if (str == null) {
                kotlin.jvm.internal.i.u("connectionName");
            }
            return str;
        }

        public final d d() {
            return this.f32087e;
        }

        public final int e() {
            return this.f32089g;
        }

        public final okhttp3.internal.http2.g f() {
            return this.f32088f;
        }

        public final okio.d g() {
            okio.d dVar = this.f32086d;
            if (dVar == null) {
                kotlin.jvm.internal.i.u("sink");
            }
            return dVar;
        }

        public final Socket h() {
            Socket socket = this.f32083a;
            if (socket == null) {
                kotlin.jvm.internal.i.u("socket");
            }
            return socket;
        }

        public final okio.e i() {
            okio.e eVar = this.f32085c;
            if (eVar == null) {
                kotlin.jvm.internal.i.u(TelephonyUtil.KEY_SIM_ACTIVITIED_SOURCE);
            }
            return eVar;
        }

        public final ip.e j() {
            return this.f32091i;
        }

        public final C0431b k(d listener) {
            kotlin.jvm.internal.i.f(listener, "listener");
            this.f32087e = listener;
            return this;
        }

        public final C0431b l(int i10) {
            this.f32089g = i10;
            return this;
        }

        public final C0431b m(Socket socket, String peerName, okio.e source, okio.d sink) throws IOException {
            String str;
            kotlin.jvm.internal.i.f(socket, "socket");
            kotlin.jvm.internal.i.f(peerName, "peerName");
            kotlin.jvm.internal.i.f(source, "source");
            kotlin.jvm.internal.i.f(sink, "sink");
            this.f32083a = socket;
            if (this.f32090h) {
                str = gp.b.f27633i + ' ' + peerName;
            } else {
                str = "MockWebServer " + peerName;
            }
            this.f32084b = str;
            this.f32085c = source;
            this.f32086d = sink;
            return this;
        }
    }

    /* compiled from: Http2Connection.kt */
    /* loaded from: classes3.dex */
    public static final class c {
        private c() {
        }

        public final lp.d a() {
            return b.C;
        }

        public /* synthetic */ c(kotlin.jvm.internal.f fVar) {
            this();
        }
    }

    /* compiled from: Http2Connection.kt */
    /* loaded from: classes3.dex */
    public static abstract class d {

        /* renamed from: a */
        public static final d f32092a = new a();

        /* compiled from: Http2Connection.kt */
        /* loaded from: classes3.dex */
        public static final class a extends d {
            a() {
            }

            @Override // okhttp3.internal.http2.b.d
            public void c(okhttp3.internal.http2.d stream) throws IOException {
                kotlin.jvm.internal.i.f(stream, "stream");
                stream.d(ErrorCode.REFUSED_STREAM, null);
            }
        }

        /* compiled from: Http2Connection.kt */
        /* renamed from: okhttp3.internal.http2.b$d$b */
        /* loaded from: classes3.dex */
        public static final class C0432b {
            private C0432b() {
            }

            public /* synthetic */ C0432b(kotlin.jvm.internal.f fVar) {
                this();
            }
        }

        static {
            new C0432b(null);
        }

        public void b(b connection, lp.d settings) {
            kotlin.jvm.internal.i.f(connection, "connection");
            kotlin.jvm.internal.i.f(settings, "settings");
        }

        public abstract void c(okhttp3.internal.http2.d dVar) throws IOException;
    }

    /* compiled from: Http2Connection.kt */
    /* loaded from: classes3.dex */
    public final class e implements c.AbstractC0434c, qo.a<m> {

        /* renamed from: a */
        private final okhttp3.internal.http2.c f32093a;

        /* renamed from: b */
        final /* synthetic */ b f32094b;

        /* compiled from: TaskQueue.kt */
        /* loaded from: classes3.dex */
        public static final class a extends ip.a {

            /* renamed from: e */
            final /* synthetic */ e f32095e;

            /* renamed from: f */
            final /* synthetic */ Ref$ObjectRef f32096f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str, boolean z10, String str2, boolean z11, e eVar, Ref$ObjectRef ref$ObjectRef, boolean z12, lp.d dVar, Ref$LongRef ref$LongRef, Ref$ObjectRef ref$ObjectRef2) {
                super(str2, z11);
                this.f32095e = eVar;
                this.f32096f = ref$ObjectRef;
            }

            @Override // ip.a
            public long f() {
                this.f32095e.f32094b.m0().b(this.f32095e.f32094b, (lp.d) this.f32096f.element);
                return -1L;
            }
        }

        /* compiled from: TaskQueue.kt */
        /* renamed from: okhttp3.internal.http2.b$e$b */
        /* loaded from: classes3.dex */
        public static final class C0433b extends ip.a {

            /* renamed from: e */
            final /* synthetic */ okhttp3.internal.http2.d f32097e;

            /* renamed from: f */
            final /* synthetic */ e f32098f;

            /* renamed from: g */
            final /* synthetic */ List f32099g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0433b(String str, boolean z10, String str2, boolean z11, okhttp3.internal.http2.d dVar, e eVar, okhttp3.internal.http2.d dVar2, int i10, List list, boolean z12) {
                super(str2, z11);
                this.f32097e = dVar;
                this.f32098f = eVar;
                this.f32099g = list;
            }

            @Override // ip.a
            public long f() {
                try {
                    this.f32098f.f32094b.m0().c(this.f32097e);
                    return -1L;
                } catch (IOException e10) {
                    okhttp3.internal.platform.h g10 = okhttp3.internal.platform.h.f32213c.g();
                    g10.k("Http2Connection.Listener failure for " + this.f32098f.f32094b.j0(), 4, e10);
                    try {
                        this.f32097e.d(ErrorCode.PROTOCOL_ERROR, e10);
                        return -1L;
                    } catch (IOException unused) {
                        return -1L;
                    }
                }
            }
        }

        /* compiled from: TaskQueue.kt */
        /* loaded from: classes3.dex */
        public static final class c extends ip.a {

            /* renamed from: e */
            final /* synthetic */ e f32100e;

            /* renamed from: f */
            final /* synthetic */ int f32101f;

            /* renamed from: g */
            final /* synthetic */ int f32102g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(String str, boolean z10, String str2, boolean z11, e eVar, int i10, int i11) {
                super(str2, z11);
                this.f32100e = eVar;
                this.f32101f = i10;
                this.f32102g = i11;
            }

            @Override // ip.a
            public long f() {
                this.f32100e.f32094b.Y0(true, this.f32101f, this.f32102g);
                return -1L;
            }
        }

        /* compiled from: TaskQueue.kt */
        /* loaded from: classes3.dex */
        public static final class d extends ip.a {

            /* renamed from: e */
            final /* synthetic */ e f32103e;

            /* renamed from: f */
            final /* synthetic */ boolean f32104f;

            /* renamed from: g */
            final /* synthetic */ lp.d f32105g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(String str, boolean z10, String str2, boolean z11, e eVar, boolean z12, lp.d dVar) {
                super(str2, z11);
                this.f32103e = eVar;
                this.f32104f = z12;
                this.f32105g = dVar;
            }

            @Override // ip.a
            public long f() {
                this.f32103e.k(this.f32104f, this.f32105g);
                return -1L;
            }
        }

        public e(b bVar, okhttp3.internal.http2.c reader) {
            kotlin.jvm.internal.i.f(reader, "reader");
            this.f32094b = bVar;
            this.f32093a = reader;
        }

        @Override // okhttp3.internal.http2.c.AbstractC0434c
        public void a() {
        }

        @Override // okhttp3.internal.http2.c.AbstractC0434c
        public void b(boolean z10, int i10, int i11, List<lp.a> headerBlock) {
            kotlin.jvm.internal.i.f(headerBlock, "headerBlock");
            if (this.f32094b.N0(i10)) {
                this.f32094b.K0(i10, headerBlock, z10);
                return;
            }
            synchronized (this.f32094b) {
                okhttp3.internal.http2.d u02 = this.f32094b.u0(i10);
                if (u02 != null) {
                    m mVar = m.f28349a;
                    u02.x(gp.b.L(headerBlock), z10);
                } else if (!this.f32094b.f32061g) {
                    if (i10 > this.f32094b.k0()) {
                        if (i10 % 2 != this.f32094b.o0() % 2) {
                            okhttp3.internal.http2.d dVar = new okhttp3.internal.http2.d(i10, this.f32094b, false, z10, gp.b.L(headerBlock));
                            this.f32094b.Q0(i10);
                            this.f32094b.w0().put(Integer.valueOf(i10), dVar);
                            String str = this.f32094b.j0() + '[' + i10 + "] onStream";
                            this.f32094b.f32062h.i().i(new C0433b(str, true, str, true, dVar, this, u02, i10, headerBlock, z10), 0L);
                        }
                    }
                }
            }
        }

        @Override // okhttp3.internal.http2.c.AbstractC0434c
        public void c(int i10, long j10) {
            if (i10 == 0) {
                synchronized (this.f32094b) {
                    b bVar = this.f32094b;
                    bVar.f32078x = bVar.z0() + j10;
                    b bVar2 = this.f32094b;
                    if (bVar2 != null) {
                        bVar2.notifyAll();
                        m mVar = m.f28349a;
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                    }
                }
                return;
            }
            okhttp3.internal.http2.d u02 = this.f32094b.u0(i10);
            if (u02 != null) {
                synchronized (u02) {
                    u02.a(j10);
                    m mVar2 = m.f28349a;
                }
            }
        }

        @Override // okhttp3.internal.http2.c.AbstractC0434c
        public void d(boolean z10, lp.d settings) {
            kotlin.jvm.internal.i.f(settings, "settings");
            String str = this.f32094b.j0() + " applyAndAckSettings";
            this.f32094b.f32063i.i(new d(str, true, str, true, this, z10, settings), 0L);
        }

        @Override // okhttp3.internal.http2.c.AbstractC0434c
        public void e(boolean z10, int i10, okio.e source, int i11) throws IOException {
            kotlin.jvm.internal.i.f(source, "source");
            if (this.f32094b.N0(i10)) {
                this.f32094b.J0(i10, source, i11, z10);
                return;
            }
            okhttp3.internal.http2.d u02 = this.f32094b.u0(i10);
            if (u02 == null) {
                this.f32094b.a1(i10, ErrorCode.PROTOCOL_ERROR);
                long j10 = i11;
                this.f32094b.V0(j10);
                source.f(j10);
                return;
            }
            u02.w(source, i11);
            if (z10) {
                u02.x(gp.b.f27626b, true);
            }
        }

        @Override // okhttp3.internal.http2.c.AbstractC0434c
        public void f(boolean z10, int i10, int i11) {
            if (z10) {
                synchronized (this.f32094b) {
                    if (i10 == 1) {
                        this.f32094b.f32068n++;
                    } else if (i10 != 2) {
                        if (i10 == 3) {
                            this.f32094b.f32071q++;
                            b bVar = this.f32094b;
                            if (bVar != null) {
                                bVar.notifyAll();
                            } else {
                                throw new NullPointerException("null cannot be cast to non-null type java.lang.Object");
                            }
                        }
                        m mVar = m.f28349a;
                    } else {
                        this.f32094b.f32070p++;
                    }
                }
                return;
            }
            String str = this.f32094b.j0() + " ping";
            this.f32094b.f32063i.i(new c(str, true, str, true, this, i10, i11), 0L);
        }

        @Override // okhttp3.internal.http2.c.AbstractC0434c
        public void g(int i10, int i11, int i12, boolean z10) {
        }

        @Override // okhttp3.internal.http2.c.AbstractC0434c
        public void h(int i10, ErrorCode errorCode) {
            kotlin.jvm.internal.i.f(errorCode, "errorCode");
            if (this.f32094b.N0(i10)) {
                this.f32094b.M0(i10, errorCode);
                return;
            }
            okhttp3.internal.http2.d O0 = this.f32094b.O0(i10);
            if (O0 != null) {
                O0.y(errorCode);
            }
        }

        @Override // okhttp3.internal.http2.c.AbstractC0434c
        public void i(int i10, int i11, List<lp.a> requestHeaders) {
            kotlin.jvm.internal.i.f(requestHeaders, "requestHeaders");
            this.f32094b.L0(i11, requestHeaders);
        }

        @Override // qo.a
        public /* bridge */ /* synthetic */ m invoke() {
            l();
            return m.f28349a;
        }

        @Override // okhttp3.internal.http2.c.AbstractC0434c
        public void j(int i10, ErrorCode errorCode, ByteString debugData) {
            int i11;
            okhttp3.internal.http2.d[] dVarArr;
            kotlin.jvm.internal.i.f(errorCode, "errorCode");
            kotlin.jvm.internal.i.f(debugData, "debugData");
            debugData.size();
            synchronized (this.f32094b) {
                Object[] array = this.f32094b.w0().values().toArray(new okhttp3.internal.http2.d[0]);
                if (array != null) {
                    dVarArr = (okhttp3.internal.http2.d[]) array;
                    this.f32094b.f32061g = true;
                    m mVar = m.f28349a;
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            }
            for (okhttp3.internal.http2.d dVar : dVarArr) {
                if (dVar.j() > i10 && dVar.t()) {
                    dVar.y(ErrorCode.REFUSED_STREAM);
                    this.f32094b.O0(dVar.j());
                }
            }
        }

        /* JADX WARN: Can't wrap try/catch for region: R(8:(2:15|(10:17|21|22|53|23|24|51|25|28|29)(2:18|19))|53|23|24|51|25|28|29) */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x00d8, code lost:
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x00d9, code lost:
            r21.f32094b.h0(r0);
         */
        /* JADX WARN: Multi-variable type inference failed */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void k(boolean z10, lp.d settings) {
            b bVar;
            Throwable th2;
            T t10;
            T t11;
            kotlin.jvm.internal.i.f(settings, "settings");
            Ref$LongRef ref$LongRef = new Ref$LongRef();
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            synchronized (this.f32094b.A0()) {
                b bVar2 = this.f32094b;
                synchronized (bVar2) {
                    try {
                        lp.d t02 = this.f32094b.t0();
                        if (z10) {
                            t10 = settings;
                        } else {
                            lp.d dVar = new lp.d();
                            dVar.g(t02);
                            dVar.g(settings);
                            m mVar = m.f28349a;
                            t10 = dVar;
                        }
                        ref$ObjectRef2.element = t10;
                        long c10 = ((lp.d) t10).c() - t02.c();
                        ref$LongRef.element = c10;
                        try {
                            if (c10 != 0 && !this.f32094b.w0().isEmpty()) {
                                Object[] array = this.f32094b.w0().values().toArray(new okhttp3.internal.http2.d[0]);
                                if (array != null) {
                                    t11 = (okhttp3.internal.http2.d[]) array;
                                    ref$ObjectRef.element = t11;
                                    this.f32094b.R0((lp.d) ref$ObjectRef2.element);
                                    String str = this.f32094b.j0() + " onSettings";
                                    bVar = bVar2;
                                    this.f32094b.f32065k.i(new a(str, true, str, true, this, ref$ObjectRef2, z10, settings, ref$LongRef, ref$ObjectRef), 0L);
                                    m mVar2 = m.f28349a;
                                    this.f32094b.A0().c((lp.d) ref$ObjectRef2.element);
                                    m mVar3 = m.f28349a;
                                } else {
                                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                                }
                            }
                            this.f32094b.f32065k.i(new a(str, true, str, true, this, ref$ObjectRef2, z10, settings, ref$LongRef, ref$ObjectRef), 0L);
                            m mVar22 = m.f28349a;
                            this.f32094b.A0().c((lp.d) ref$ObjectRef2.element);
                            m mVar32 = m.f28349a;
                        } catch (Throwable th3) {
                            th2 = th3;
                            throw th2;
                        }
                        t11 = 0;
                        ref$ObjectRef.element = t11;
                        this.f32094b.R0((lp.d) ref$ObjectRef2.element);
                        String str2 = this.f32094b.j0() + " onSettings";
                        bVar = bVar2;
                    } catch (Throwable th4) {
                        th2 = th4;
                        bVar = bVar2;
                    }
                }
            }
            T t12 = ref$ObjectRef.element;
            if (((okhttp3.internal.http2.d[]) t12) != null) {
                okhttp3.internal.http2.d[] dVarArr = (okhttp3.internal.http2.d[]) t12;
                kotlin.jvm.internal.i.d(dVarArr);
                for (okhttp3.internal.http2.d dVar2 : dVarArr) {
                    synchronized (dVar2) {
                        dVar2.a(ref$LongRef.element);
                        m mVar4 = m.f28349a;
                    }
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [okhttp3.internal.http2.ErrorCode] */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r0v4, types: [java.io.Closeable, okhttp3.internal.http2.c] */
        public void l() {
            Throwable th2;
            ErrorCode errorCode;
            ErrorCode errorCode2 = ErrorCode.INTERNAL_ERROR;
            IOException e10 = null;
            try {
                try {
                    this.f32093a.h(this);
                    while (this.f32093a.d(false, this)) {
                    }
                    ErrorCode errorCode3 = ErrorCode.NO_ERROR;
                    try {
                        this.f32094b.g0(errorCode3, ErrorCode.CANCEL, null);
                        errorCode = errorCode3;
                    } catch (IOException e11) {
                        e10 = e11;
                        ErrorCode errorCode4 = ErrorCode.PROTOCOL_ERROR;
                        b bVar = this.f32094b;
                        bVar.g0(errorCode4, errorCode4, e10);
                        errorCode = bVar;
                        errorCode2 = this.f32093a;
                        gp.b.j(errorCode2);
                    }
                } catch (Throwable th3) {
                    th2 = th3;
                    this.f32094b.g0(errorCode, errorCode2, e10);
                    gp.b.j(this.f32093a);
                    throw th2;
                }
            } catch (IOException e12) {
                e10 = e12;
            } catch (Throwable th4) {
                th2 = th4;
                errorCode = errorCode2;
                this.f32094b.g0(errorCode, errorCode2, e10);
                gp.b.j(this.f32093a);
                throw th2;
            }
            errorCode2 = this.f32093a;
            gp.b.j(errorCode2);
        }
    }

    /* compiled from: TaskQueue.kt */
    /* loaded from: classes3.dex */
    public static final class f extends ip.a {

        /* renamed from: e */
        final /* synthetic */ b f32106e;

        /* renamed from: f */
        final /* synthetic */ int f32107f;

        /* renamed from: g */
        final /* synthetic */ okio.c f32108g;

        /* renamed from: h */
        final /* synthetic */ int f32109h;

        /* renamed from: i */
        final /* synthetic */ boolean f32110i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str, boolean z10, String str2, boolean z11, b bVar, int i10, okio.c cVar, int i11, boolean z12) {
            super(str2, z11);
            this.f32106e = bVar;
            this.f32107f = i10;
            this.f32108g = cVar;
            this.f32109h = i11;
            this.f32110i = z12;
        }

        @Override // ip.a
        public long f() {
            try {
                boolean d10 = this.f32106e.f32066l.d(this.f32107f, this.f32108g, this.f32109h, this.f32110i);
                if (d10) {
                    this.f32106e.A0().x(this.f32107f, ErrorCode.CANCEL);
                }
                if (!d10 && !this.f32110i) {
                    return -1L;
                }
                synchronized (this.f32106e) {
                    this.f32106e.B.remove(Integer.valueOf(this.f32107f));
                }
                return -1L;
            } catch (IOException unused) {
                return -1L;
            }
        }
    }

    /* compiled from: TaskQueue.kt */
    /* loaded from: classes3.dex */
    public static final class g extends ip.a {

        /* renamed from: e */
        final /* synthetic */ b f32111e;

        /* renamed from: f */
        final /* synthetic */ int f32112f;

        /* renamed from: g */
        final /* synthetic */ List f32113g;

        /* renamed from: h */
        final /* synthetic */ boolean f32114h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(String str, boolean z10, String str2, boolean z11, b bVar, int i10, List list, boolean z12) {
            super(str2, z11);
            this.f32111e = bVar;
            this.f32112f = i10;
            this.f32113g = list;
            this.f32114h = z12;
        }

        @Override // ip.a
        public long f() {
            boolean b10 = this.f32111e.f32066l.b(this.f32112f, this.f32113g, this.f32114h);
            if (b10) {
                try {
                    this.f32111e.A0().x(this.f32112f, ErrorCode.CANCEL);
                } catch (IOException unused) {
                    return -1L;
                }
            }
            if (!b10 && !this.f32114h) {
                return -1L;
            }
            synchronized (this.f32111e) {
                this.f32111e.B.remove(Integer.valueOf(this.f32112f));
            }
            return -1L;
        }
    }

    /* compiled from: TaskQueue.kt */
    /* loaded from: classes3.dex */
    public static final class h extends ip.a {

        /* renamed from: e */
        final /* synthetic */ b f32115e;

        /* renamed from: f */
        final /* synthetic */ int f32116f;

        /* renamed from: g */
        final /* synthetic */ List f32117g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public h(String str, boolean z10, String str2, boolean z11, b bVar, int i10, List list) {
            super(str2, z11);
            this.f32115e = bVar;
            this.f32116f = i10;
            this.f32117g = list;
        }

        @Override // ip.a
        public long f() {
            if (!this.f32115e.f32066l.a(this.f32116f, this.f32117g)) {
                return -1L;
            }
            try {
                this.f32115e.A0().x(this.f32116f, ErrorCode.CANCEL);
                synchronized (this.f32115e) {
                    this.f32115e.B.remove(Integer.valueOf(this.f32116f));
                }
                return -1L;
            } catch (IOException unused) {
                return -1L;
            }
        }
    }

    /* compiled from: TaskQueue.kt */
    /* loaded from: classes3.dex */
    public static final class i extends ip.a {

        /* renamed from: e */
        final /* synthetic */ b f32118e;

        /* renamed from: f */
        final /* synthetic */ int f32119f;

        /* renamed from: g */
        final /* synthetic */ ErrorCode f32120g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public i(String str, boolean z10, String str2, boolean z11, b bVar, int i10, ErrorCode errorCode) {
            super(str2, z11);
            this.f32118e = bVar;
            this.f32119f = i10;
            this.f32120g = errorCode;
        }

        @Override // ip.a
        public long f() {
            this.f32118e.f32066l.c(this.f32119f, this.f32120g);
            synchronized (this.f32118e) {
                this.f32118e.B.remove(Integer.valueOf(this.f32119f));
                m mVar = m.f28349a;
            }
            return -1L;
        }
    }

    /* compiled from: TaskQueue.kt */
    /* loaded from: classes3.dex */
    public static final class j extends ip.a {

        /* renamed from: e */
        final /* synthetic */ b f32121e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public j(String str, boolean z10, String str2, boolean z11, b bVar) {
            super(str2, z11);
            this.f32121e = bVar;
        }

        @Override // ip.a
        public long f() {
            this.f32121e.Y0(false, 2, 0);
            return -1L;
        }
    }

    /* compiled from: TaskQueue.kt */
    /* loaded from: classes3.dex */
    public static final class k extends ip.a {

        /* renamed from: e */
        final /* synthetic */ b f32122e;

        /* renamed from: f */
        final /* synthetic */ int f32123f;

        /* renamed from: g */
        final /* synthetic */ ErrorCode f32124g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public k(String str, boolean z10, String str2, boolean z11, b bVar, int i10, ErrorCode errorCode) {
            super(str2, z11);
            this.f32122e = bVar;
            this.f32123f = i10;
            this.f32124g = errorCode;
        }

        @Override // ip.a
        public long f() {
            try {
                this.f32122e.Z0(this.f32123f, this.f32124g);
                return -1L;
            } catch (IOException e10) {
                this.f32122e.h0(e10);
                return -1L;
            }
        }
    }

    /* compiled from: TaskQueue.kt */
    /* loaded from: classes3.dex */
    public static final class l extends ip.a {

        /* renamed from: e */
        final /* synthetic */ b f32125e;

        /* renamed from: f */
        final /* synthetic */ int f32126f;

        /* renamed from: g */
        final /* synthetic */ long f32127g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(String str, boolean z10, String str2, boolean z11, b bVar, int i10, long j10) {
            super(str2, z11);
            this.f32125e = bVar;
            this.f32126f = i10;
            this.f32127g = j10;
        }

        @Override // ip.a
        public long f() {
            try {
                this.f32125e.A0().I(this.f32126f, this.f32127g);
                return -1L;
            } catch (IOException e10) {
                this.f32125e.h0(e10);
                return -1L;
            }
        }
    }

    static {
        lp.d dVar = new lp.d();
        dVar.h(7, 65535);
        dVar.h(5, 16384);
        C = dVar;
    }

    public b(C0431b builder) {
        lp.d dVar;
        kotlin.jvm.internal.i.f(builder, "builder");
        boolean b10 = builder.b();
        this.f32055a = b10;
        this.f32056b = builder.d();
        String c10 = builder.c();
        this.f32058d = c10;
        this.f32060f = builder.b() ? 3 : 2;
        ip.e j10 = builder.j();
        this.f32062h = j10;
        ip.d i10 = j10.i();
        this.f32063i = i10;
        this.f32064j = j10.i();
        this.f32065k = j10.i();
        this.f32066l = builder.f();
        lp.d dVar2 = new lp.d();
        if (builder.b()) {
            dVar2.h(7, IntentInfo.FLAG_RECEIVER_INCLUDE_BACKGROUND);
        }
        m mVar = m.f28349a;
        this.f32073s = dVar2;
        this.f32074t = C;
        this.f32078x = dVar.c();
        this.f32079y = builder.h();
        this.f32080z = new okhttp3.internal.http2.e(builder.g(), b10);
        this.A = new e(this, new okhttp3.internal.http2.c(builder.i(), b10));
        this.B = new LinkedHashSet();
        if (builder.e() != 0) {
            long nanos = TimeUnit.MILLISECONDS.toNanos(builder.e());
            String str = c10 + " ping";
            i10.i(new a(str, str, this, nanos), nanos);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0048 A[Catch: all -> 0x0081, TryCatch #1 {, blocks: (B:4:0x0006, B:23:0x0053, B:25:0x0056, B:26:0x005c, B:28:0x0061, B:33:0x006f, B:34:0x007a, B:5:0x0007, B:7:0x000e, B:8:0x0013, B:10:0x0017, B:12:0x002a, B:14:0x0032, B:19:0x0042, B:21:0x0048, B:22:0x0051, B:35:0x007b, B:36:0x0080), top: B:39:0x0006 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final okhttp3.internal.http2.d H0(int i10, List<lp.a> list, boolean z10) throws IOException {
        int i11;
        okhttp3.internal.http2.d dVar;
        boolean z11;
        boolean z12 = !z10;
        synchronized (this.f32080z) {
            synchronized (this) {
                if (this.f32060f > 1073741823) {
                    S0(ErrorCode.REFUSED_STREAM);
                }
                if (!this.f32061g) {
                    i11 = this.f32060f;
                    this.f32060f = i11 + 2;
                    dVar = new okhttp3.internal.http2.d(i11, this, z12, false, null);
                    if (z10 && this.f32077w < this.f32078x && dVar.r() < dVar.q()) {
                        z11 = false;
                        if (dVar.u()) {
                            this.f32057c.put(Integer.valueOf(i11), dVar);
                        }
                        m mVar = m.f28349a;
                    }
                    z11 = true;
                    if (dVar.u()) {
                    }
                    m mVar2 = m.f28349a;
                } else {
                    throw new ConnectionShutdownException();
                }
            }
            if (i10 == 0) {
                this.f32080z.q(z12, i11, list);
            } else if (true ^ this.f32055a) {
                this.f32080z.w(i10, i11, list);
            } else {
                throw new IllegalArgumentException("client streams shouldn't have associated stream IDs".toString());
            }
        }
        if (z11) {
            this.f32080z.flush();
        }
        return dVar;
    }

    public static /* synthetic */ void U0(b bVar, boolean z10, ip.e eVar, int i10, Object obj) throws IOException {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        if ((i10 & 2) != 0) {
            eVar = ip.e.f29318h;
        }
        bVar.T0(z10, eVar);
    }

    public final void h0(IOException iOException) {
        ErrorCode errorCode = ErrorCode.PROTOCOL_ERROR;
        g0(errorCode, errorCode, iOException);
    }

    public final okhttp3.internal.http2.e A0() {
        return this.f32080z;
    }

    public final synchronized boolean G0(long j10) {
        if (this.f32061g) {
            return false;
        }
        if (this.f32070p < this.f32069o) {
            if (j10 >= this.f32072r) {
                return false;
            }
        }
        return true;
    }

    public final okhttp3.internal.http2.d I0(List<lp.a> requestHeaders, boolean z10) throws IOException {
        kotlin.jvm.internal.i.f(requestHeaders, "requestHeaders");
        return H0(0, requestHeaders, z10);
    }

    public final void J0(int i10, okio.e source, int i11, boolean z10) throws IOException {
        kotlin.jvm.internal.i.f(source, "source");
        okio.c cVar = new okio.c();
        long j10 = i11;
        source.B0(j10);
        source.read(cVar, j10);
        String str = this.f32058d + '[' + i10 + "] onData";
        this.f32064j.i(new f(str, true, str, true, this, i10, cVar, i11, z10), 0L);
    }

    public final void K0(int i10, List<lp.a> requestHeaders, boolean z10) {
        kotlin.jvm.internal.i.f(requestHeaders, "requestHeaders");
        String str = this.f32058d + '[' + i10 + "] onHeaders";
        this.f32064j.i(new g(str, true, str, true, this, i10, requestHeaders, z10), 0L);
    }

    public final void L0(int i10, List<lp.a> requestHeaders) {
        kotlin.jvm.internal.i.f(requestHeaders, "requestHeaders");
        synchronized (this) {
            if (this.B.contains(Integer.valueOf(i10))) {
                a1(i10, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.B.add(Integer.valueOf(i10));
            String str = this.f32058d + '[' + i10 + "] onRequest";
            this.f32064j.i(new h(str, true, str, true, this, i10, requestHeaders), 0L);
        }
    }

    public final void M0(int i10, ErrorCode errorCode) {
        kotlin.jvm.internal.i.f(errorCode, "errorCode");
        String str = this.f32058d + '[' + i10 + "] onReset";
        this.f32064j.i(new i(str, true, str, true, this, i10, errorCode), 0L);
    }

    public final boolean N0(int i10) {
        return i10 != 0 && (i10 & 1) == 0;
    }

    public final synchronized okhttp3.internal.http2.d O0(int i10) {
        okhttp3.internal.http2.d remove;
        remove = this.f32057c.remove(Integer.valueOf(i10));
        notifyAll();
        return remove;
    }

    public final void P0() {
        synchronized (this) {
            long j10 = this.f32070p;
            long j11 = this.f32069o;
            if (j10 >= j11) {
                this.f32069o = j11 + 1;
                this.f32072r = System.nanoTime() + 1000000000;
                m mVar = m.f28349a;
                String str = this.f32058d + " ping";
                this.f32063i.i(new j(str, true, str, true, this), 0L);
            }
        }
    }

    public final void Q0(int i10) {
        this.f32059e = i10;
    }

    public final void R0(lp.d dVar) {
        kotlin.jvm.internal.i.f(dVar, "<set-?>");
        this.f32074t = dVar;
    }

    public final void S0(ErrorCode statusCode) throws IOException {
        kotlin.jvm.internal.i.f(statusCode, "statusCode");
        synchronized (this.f32080z) {
            synchronized (this) {
                if (!this.f32061g) {
                    this.f32061g = true;
                    int i10 = this.f32059e;
                    m mVar = m.f28349a;
                    this.f32080z.o(i10, statusCode, gp.b.f27625a);
                }
            }
        }
    }

    public final void T0(boolean z10, ip.e taskRunner) throws IOException {
        kotlin.jvm.internal.i.f(taskRunner, "taskRunner");
        if (z10) {
            this.f32080z.d();
            this.f32080z.E(this.f32073s);
            int c10 = this.f32073s.c();
            if (c10 != 65535) {
                this.f32080z.I(0, c10 - 65535);
            }
        }
        ip.d i10 = taskRunner.i();
        String str = this.f32058d;
        i10.i(new ip.c(this.A, str, true, str, true), 0L);
    }

    public final synchronized void V0(long j10) {
        long j11 = this.f32075u + j10;
        this.f32075u = j11;
        long j12 = j11 - this.f32076v;
        if (j12 >= this.f32073s.c() / 2) {
            b1(0, j12);
            this.f32076v += j12;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
        throw new java.io.IOException("stream closed");
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0033, code lost:
        r2 = java.lang.Math.min((int) java.lang.Math.min(r12, r6 - r4), r8.f32080z.u());
        r6 = r2;
        r8.f32077w += r6;
        r4 = io.m.f28349a;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void W0(int i10, boolean z10, okio.c cVar, long j10) throws IOException {
        int min;
        long j11;
        if (j10 == 0) {
            this.f32080z.h(z10, i10, cVar, 0);
            return;
        }
        loop0: while (j10 > 0) {
            synchronized (this) {
                while (true) {
                    try {
                        long j12 = this.f32077w;
                        long j13 = this.f32078x;
                        if (j12 >= j13) {
                            if (!this.f32057c.containsKey(Integer.valueOf(i10))) {
                                break loop0;
                            }
                            wait();
                        } else {
                            break;
                        }
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException();
                    }
                }
            }
            j10 -= j11;
            this.f32080z.h(z10 && j10 == 0, i10, cVar, min);
        }
    }

    public final void X0(int i10, boolean z10, List<lp.a> alternating) throws IOException {
        kotlin.jvm.internal.i.f(alternating, "alternating");
        this.f32080z.q(z10, i10, alternating);
    }

    public final void Y0(boolean z10, int i10, int i11) {
        try {
            this.f32080z.v(z10, i10, i11);
        } catch (IOException e10) {
            h0(e10);
        }
    }

    public final void Z0(int i10, ErrorCode statusCode) throws IOException {
        kotlin.jvm.internal.i.f(statusCode, "statusCode");
        this.f32080z.x(i10, statusCode);
    }

    public final void a1(int i10, ErrorCode errorCode) {
        kotlin.jvm.internal.i.f(errorCode, "errorCode");
        String str = this.f32058d + '[' + i10 + "] writeSynReset";
        this.f32063i.i(new k(str, true, str, true, this, i10, errorCode), 0L);
    }

    public final void b1(int i10, long j10) {
        String str = this.f32058d + '[' + i10 + "] windowUpdate";
        this.f32063i.i(new l(str, true, str, true, this, i10, j10), 0L);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        g0(ErrorCode.NO_ERROR, ErrorCode.CANCEL, null);
    }

    public final void flush() throws IOException {
        this.f32080z.flush();
    }

    public final void g0(ErrorCode connectionCode, ErrorCode streamCode, IOException iOException) {
        int i10;
        kotlin.jvm.internal.i.f(connectionCode, "connectionCode");
        kotlin.jvm.internal.i.f(streamCode, "streamCode");
        if (!gp.b.f27632h || !Thread.holdsLock(this)) {
            try {
                S0(connectionCode);
            } catch (IOException unused) {
            }
            okhttp3.internal.http2.d[] dVarArr = null;
            synchronized (this) {
                if (!this.f32057c.isEmpty()) {
                    Object[] array = this.f32057c.values().toArray(new okhttp3.internal.http2.d[0]);
                    if (array != null) {
                        dVarArr = (okhttp3.internal.http2.d[]) array;
                        this.f32057c.clear();
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                }
                m mVar = m.f28349a;
            }
            if (dVarArr != null) {
                for (okhttp3.internal.http2.d dVar : dVarArr) {
                    try {
                        dVar.d(streamCode, iOException);
                    } catch (IOException unused2) {
                    }
                }
            }
            try {
                this.f32080z.close();
            } catch (IOException unused3) {
            }
            try {
                this.f32079y.close();
            } catch (IOException unused4) {
            }
            this.f32063i.n();
            this.f32064j.n();
            this.f32065k.n();
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Thread ");
        Thread currentThread = Thread.currentThread();
        kotlin.jvm.internal.i.e(currentThread, "Thread.currentThread()");
        sb2.append(currentThread.getName());
        sb2.append(" MUST NOT hold lock on ");
        sb2.append(this);
        throw new AssertionError(sb2.toString());
    }

    public final boolean i0() {
        return this.f32055a;
    }

    public final String j0() {
        return this.f32058d;
    }

    public final int k0() {
        return this.f32059e;
    }

    public final d m0() {
        return this.f32056b;
    }

    public final int o0() {
        return this.f32060f;
    }

    public final lp.d r0() {
        return this.f32073s;
    }

    public final lp.d t0() {
        return this.f32074t;
    }

    public final synchronized okhttp3.internal.http2.d u0(int i10) {
        return this.f32057c.get(Integer.valueOf(i10));
    }

    public final Map<Integer, okhttp3.internal.http2.d> w0() {
        return this.f32057c;
    }

    public final long z0() {
        return this.f32078x;
    }
}
