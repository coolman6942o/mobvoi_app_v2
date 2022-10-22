package retrofit2.adapter.rxjava;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import retrofit2.CallAdapter;
import retrofit2.Response;
import retrofit2.Retrofit;
import rx.a;
import rx.c;
import rx.f;
import rx.g;
/* loaded from: classes3.dex */
public final class RxJavaCallAdapterFactory extends CallAdapter.Factory {
    private final boolean isAsync;
    private final f scheduler;

    private RxJavaCallAdapterFactory(f fVar, boolean z10) {
        this.scheduler = fVar;
        this.isAsync = z10;
    }

    public static RxJavaCallAdapterFactory create() {
        return new RxJavaCallAdapterFactory(null, false);
    }

    public static RxJavaCallAdapterFactory createAsync() {
        return new RxJavaCallAdapterFactory(null, true);
    }

    public static RxJavaCallAdapterFactory createWithScheduler(f fVar) {
        Objects.requireNonNull(fVar, "scheduler == null");
        return new RxJavaCallAdapterFactory(fVar, false);
    }

    @Override // retrofit2.CallAdapter.Factory
    public CallAdapter<?, ?> get(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        boolean z10;
        boolean z11;
        Type type2;
        Class<?> rawType = CallAdapter.Factory.getRawType(type);
        boolean z12 = rawType == g.class;
        boolean z13 = rawType == a.class;
        if (rawType != c.class && !z12 && !z13) {
            return null;
        }
        if (z13) {
            return new RxJavaCallAdapter(Void.class, this.scheduler, this.isAsync, false, true, false, true);
        }
        if (!(type instanceof ParameterizedType)) {
            String str = z12 ? "Single" : "Observable";
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
        return new RxJavaCallAdapter(type2, this.scheduler, this.isAsync, z11, z10, z12, false);
    }
}
