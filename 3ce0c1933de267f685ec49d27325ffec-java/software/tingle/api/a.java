package software.tingle.api;

import android.text.TextUtils;
import io.m;
import java.io.IOException;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Lambda;
import kotlin.text.u;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.t0;
import okhttp3.Headers;
import okhttp3.b0;
import okhttp3.c0;
import okhttp3.v;
import okhttp3.w;
import okhttp3.y;
import okhttp3.z;
import qo.p;
/* compiled from: AbstractHttpApiClient.kt */
/* loaded from: classes3.dex */
public abstract class a {
    public static final C0497a Companion = new C0497a(null);
    private static final w MEDIA_TYPE_JSON;
    private static final w MEDIA_TYPE_PATH_JSON;
    private static final w MEDIA_TYPE_PLUS_JSON;
    private static final w MEDIA_TYPE_TEXT_JSON;
    private final software.tingle.api.authentication.c authenticationProvider;
    private final io.d backChannel$delegate;
    private final com.google.gson.e gson = new com.google.gson.e();

    /* compiled from: AbstractHttpApiClient.kt */
    /* renamed from: software.tingle.api.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0497a {
        private C0497a() {
        }

        public /* synthetic */ C0497a(kotlin.jvm.internal.f fVar) {
            this();
        }

        public final w a() {
            return a.MEDIA_TYPE_JSON;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: AbstractHttpApiClient.kt */
    @FunctionalInterface
    /* loaded from: classes3.dex */
    public interface b<T1, T2, T3, T4, R> {
        R a(T1 t12, T2 t22, T3 t32, T4 t42);
    }

    /* compiled from: AbstractHttpApiClient.kt */
    /* loaded from: classes3.dex */
    static final class c extends Lambda implements qo.a<y> {
        c() {
            super(0);
        }

        @Override // qo.a
        public final y invoke() {
            v vVar = a.this.authenticationProvider;
            if (vVar == null) {
                vVar = new software.tingle.api.authentication.b();
            }
            return a.this.buildBackChannel(new y.a().a(vVar));
        }
    }

    /* compiled from: AbstractHttpApiClient.kt */
    /* loaded from: classes3.dex */
    public static final class d implements b<Integer, Headers, TResult, software.tingle.api.c, software.tingle.api.d<TResult>> {
        d() {
        }

        @Override // software.tingle.api.a.b
        public /* bridge */ /* synthetic */ Object a(Integer num, Headers headers, Object obj, software.tingle.api.c cVar) {
            return b(num.intValue(), headers, obj, cVar);
        }

        public software.tingle.api.d<TResult> b(int i10, Headers t22, TResult tresult, software.tingle.api.c cVar) {
            kotlin.jvm.internal.i.f(t22, "t2");
            return new software.tingle.api.d<>(i10, t22, tresult, cVar);
        }
    }

    /* compiled from: AbstractHttpApiClient.kt */
    /* loaded from: classes3.dex */
    public static final class e implements b<Integer, Headers, TResult, TError, software.tingle.api.b<TResult, TError>> {
        e() {
        }

        @Override // software.tingle.api.a.b
        public /* bridge */ /* synthetic */ Object a(Integer num, Headers headers, Object obj, Object obj2) {
            return b(num.intValue(), headers, obj, obj2);
        }

        public software.tingle.api.b<TResult, TError> b(int i10, Headers t22, TResult tresult, TError terror) {
            kotlin.jvm.internal.i.f(t22, "t2");
            return new software.tingle.api.b<>(i10, t22, tresult, terror);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: AbstractHttpApiClient.kt */
    @kotlin.coroutines.jvm.internal.d(c = "software.tingle.api.AbstractHttpApiClient$executeAsync$2", f = "AbstractHttpApiClient.kt", l = {}, m = "invokeSuspend")
    /* loaded from: classes3.dex */
    public static final class f extends SuspendLambda implements p<l0, kotlin.coroutines.c<? super software.tingle.api.d<TResult>>, Object> {
        final /* synthetic */ z.a $builder;
        final /* synthetic */ Class<TResult> $classOfTResult;
        final /* synthetic */ h $func;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        f(z.a aVar, Class<TResult> cls, h hVar, kotlin.coroutines.c<? super f> cVar) {
            super(2, cVar);
            this.$builder = aVar;
            this.$classOfTResult = cls;
            this.$func = hVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.c<m> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new f(this.$builder, this.$classOfTResult, this.$func, cVar);
        }

        public final Object invoke(l0 l0Var, kotlin.coroutines.c<? super software.tingle.api.d<TResult>> cVar) {
            return ((f) create(l0Var, cVar)).invokeSuspend(m.f28349a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.b.d();
            if (this.label == 0) {
                io.h.b(obj);
                return a.this.execute(this.$builder, this.$classOfTResult, software.tingle.api.c.class, this.$func);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: AbstractHttpApiClient.kt */
    @kotlin.coroutines.jvm.internal.d(c = "software.tingle.api.AbstractHttpApiClient$executeAsync$4", f = "AbstractHttpApiClient.kt", l = {}, m = "invokeSuspend")
    /* loaded from: classes3.dex */
    static final class g extends SuspendLambda implements p<l0, kotlin.coroutines.c<? super software.tingle.api.b<TResult, TError>>, Object> {
        final /* synthetic */ z.a $builder;
        final /* synthetic */ Class<TError> $classOfTError;
        final /* synthetic */ Class<TResult> $classOfTResult;
        final /* synthetic */ i $func;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        g(z.a aVar, Class<TResult> cls, Class<TError> cls2, i iVar, kotlin.coroutines.c<? super g> cVar) {
            super(2, cVar);
            this.$builder = aVar;
            this.$classOfTResult = cls;
            this.$classOfTError = cls2;
            this.$func = iVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final kotlin.coroutines.c<m> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new g(this.$builder, this.$classOfTResult, this.$classOfTError, this.$func, cVar);
        }

        public final Object invoke(l0 l0Var, kotlin.coroutines.c<? super software.tingle.api.b<TResult, TError>> cVar) {
            return ((g) create(l0Var, cVar)).invokeSuspend(m.f28349a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            kotlin.coroutines.intrinsics.b.d();
            if (this.label == 0) {
                io.h.b(obj);
                return a.this.execute(this.$builder, this.$classOfTResult, this.$classOfTError, this.$func);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: AbstractHttpApiClient.kt */
    /* loaded from: classes3.dex */
    public static final class h implements b<Integer, Headers, TResult, software.tingle.api.c, software.tingle.api.d<TResult>> {
        h() {
        }

        @Override // software.tingle.api.a.b
        public /* bridge */ /* synthetic */ Object a(Integer num, Headers headers, Object obj, software.tingle.api.c cVar) {
            return b(num.intValue(), headers, obj, cVar);
        }

        public software.tingle.api.d<TResult> b(int i10, Headers t22, TResult tresult, software.tingle.api.c cVar) {
            kotlin.jvm.internal.i.f(t22, "t2");
            return new software.tingle.api.d<>(i10, t22, tresult, cVar);
        }
    }

    /* compiled from: AbstractHttpApiClient.kt */
    /* loaded from: classes3.dex */
    public static final class i implements b<Integer, Headers, TResult, TError, software.tingle.api.b<TResult, TError>> {
        i() {
        }

        @Override // software.tingle.api.a.b
        public /* bridge */ /* synthetic */ Object a(Integer num, Headers headers, Object obj, Object obj2) {
            return b(num.intValue(), headers, obj, obj2);
        }

        public software.tingle.api.b<TResult, TError> b(int i10, Headers t22, TResult tresult, TError terror) {
            kotlin.jvm.internal.i.f(t22, "t2");
            return new software.tingle.api.b<>(i10, t22, tresult, terror);
        }
    }

    static {
        w.a aVar = w.f32297g;
        MEDIA_TYPE_JSON = aVar.a("application/json; charset=utf-8");
        MEDIA_TYPE_TEXT_JSON = aVar.a("text/json");
        MEDIA_TYPE_PATH_JSON = aVar.a("application/json-path+json");
        MEDIA_TYPE_PLUS_JSON = aVar.a("application/*+json");
    }

    public a(software.tingle.api.authentication.c cVar) {
        io.d a10;
        this.authenticationProvider = cVar;
        a10 = io.f.a(new c());
        this.backChannel$delegate = a10;
    }

    private final y getBackChannel() {
        return (y) this.backChannel$delegate.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public y buildBackChannel(y.a builder) {
        kotlin.jvm.internal.i.f(builder, "builder");
        return builder.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <TResult> software.tingle.api.d<TResult> execute(z.a builder, Class<TResult> cls) throws IOException {
        kotlin.jvm.internal.i.f(builder, "builder");
        return (software.tingle.api.d) execute(builder, cls, software.tingle.api.c.class, new d());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <TResult> Object executeAsync(z.a aVar, Class<TResult> cls, kotlin.coroutines.c<? super software.tingle.api.d<TResult>> cVar) throws IOException {
        return kotlinx.coroutines.h.d(t0.b(), new f(aVar, cls, new h(), null), cVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String makeJson(Object obj) {
        String s10 = this.gson.s(obj);
        kotlin.jvm.internal.i.e(s10, "gson.toJson(o)");
        return s10;
    }

    protected final <TResult, TError> software.tingle.api.b<TResult, TError> execute(z.a builder, Class<TResult> cls, Class<TError> classOfTError) throws IOException {
        kotlin.jvm.internal.i.f(builder, "builder");
        kotlin.jvm.internal.i.f(classOfTError, "classOfTError");
        return execute(builder, cls, classOfTError, new e());
    }

    protected final <TResult, TError> Object executeAsync(z.a aVar, Class<TResult> cls, Class<TError> cls2, kotlin.coroutines.c<? super software.tingle.api.b<TResult, TError>> cVar) throws IOException {
        return kotlinx.coroutines.h.d(t0.b(), new g(aVar, cls, cls2, new i(), null), cVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0065, code lost:
        if (r9 != false) goto L22;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected final <TResource, TError, TResourceResponse extends software.tingle.api.b<TResource, TError>> TResourceResponse execute(z.a builder, Class<TResource> cls, Class<TError> classOfTError, b<Integer, Headers, TResource, TError, TResourceResponse> resultBuilderFunction) throws IOException {
        Object obj;
        Object obj2;
        boolean G;
        kotlin.jvm.internal.i.f(builder, "builder");
        kotlin.jvm.internal.i.f(classOfTError, "classOfTError");
        kotlin.jvm.internal.i.f(resultBuilderFunction, "resultBuilderFunction");
        b0 execute = getBackChannel().a(builder.b()).execute();
        c0 c10 = execute.c();
        int n10 = execute.n();
        Object obj3 = null;
        if (c10 == null) {
            obj = null;
        } else if (n10 == 200 || n10 == 201 || n10 == 204) {
            w contentType = c10.contentType();
            String g10 = contentType == null ? null : contentType.g();
            boolean z10 = true;
            if (!TextUtils.isEmpty(g10)) {
                kotlin.jvm.internal.i.d(g10);
                G = u.G(g10, "json", true);
            }
            z10 = false;
            if (z10 && cls != null) {
                obj2 = this.gson.h(c10.charStream(), cls);
                c10.close();
                obj = obj3;
                obj3 = obj2;
            }
            obj2 = null;
            c10.close();
            obj = obj3;
            obj3 = obj2;
        } else {
            if (n10 == 400) {
                obj3 = this.gson.h(c10.charStream(), classOfTError);
                obj2 = null;
                c10.close();
                obj = obj3;
                obj3 = obj2;
            }
            obj2 = null;
            c10.close();
            obj = obj3;
            obj3 = obj2;
        }
        return (TResourceResponse) resultBuilderFunction.a(Integer.valueOf(n10), execute.x(), obj3, obj);
    }
}
