package retrofit2.adapter.rxjava2;

import io.reactivex.a;
import io.reactivex.e;
import io.reactivex.g;
import io.reactivex.k;
import io.reactivex.s;
import io.reactivex.t;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import retrofit2.CallAdapter;
import retrofit2.Response;
import retrofit2.Retrofit;
/* loaded from: classes3.dex */
public final class RxJava2CallAdapterFactory extends CallAdapter.Factory {
    private final boolean isAsync;
    private final s scheduler;

    private RxJava2CallAdapterFactory(s sVar, boolean z10) {
        this.scheduler = sVar;
        this.isAsync = z10;
    }

    public static RxJava2CallAdapterFactory create() {
        return new RxJava2CallAdapterFactory(null, false);
    }

    public static RxJava2CallAdapterFactory createAsync() {
        return new RxJava2CallAdapterFactory(null, true);
    }

    public static RxJava2CallAdapterFactory createWithScheduler(s sVar) {
        Objects.requireNonNull(sVar, "scheduler == null");
        return new RxJava2CallAdapterFactory(sVar, false);
    }

    @Override // retrofit2.CallAdapter.Factory
    public CallAdapter<?, ?> get(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        boolean z10;
        boolean z11;
        Type type2;
        Class<?> rawType = CallAdapter.Factory.getRawType(type);
        if (rawType == a.class) {
            return new RxJava2CallAdapter(Void.class, this.scheduler, this.isAsync, false, true, false, false, false, true);
        }
        boolean z12 = rawType == e.class;
        boolean z13 = rawType == t.class;
        boolean z14 = rawType == g.class;
        if (rawType != k.class && !z12 && !z13 && !z14) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            String str = !z12 ? !z13 ? z14 ? "Maybe" : "Observable" : "Single" : "Flowable";
            throw new IllegalStateException(str + " return type must be parameterized as " + str + "<Foo> or " + str + "<? extends Foo>");
        }
        Type parameterUpperBound = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) type);
        Class<?> rawType2 = CallAdapter.Factory.getRawType(parameterUpperBound);
        if (rawType2 == Response.class) {
            if (parameterUpperBound instanceof ParameterizedType) {
                type2 = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) parameterUpperBound);
                z11 = false;
                z10 = false;
            } else {
                throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
            }
        } else if (rawType2 != Result.class) {
            type2 = parameterUpperBound;
            z10 = true;
            z11 = false;
        } else if (parameterUpperBound instanceof ParameterizedType) {
            type2 = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) parameterUpperBound);
            z11 = true;
            z10 = false;
        } else {
            throw new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
        }
        return new RxJava2CallAdapter(type2, this.scheduler, this.isAsync, z11, z10, z12, z13, z14, false);
    }
}
