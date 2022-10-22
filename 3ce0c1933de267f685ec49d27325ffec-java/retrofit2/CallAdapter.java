package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
/* loaded from: classes3.dex */
public interface CallAdapter<R, T> {

    /* loaded from: classes3.dex */
    public static abstract class Factory {
        /* JADX INFO: Access modifiers changed from: protected */
        public static Type getParameterUpperBound(int i10, ParameterizedType parameterizedType) {
            return Utils.getParameterUpperBound(i10, parameterizedType);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        public static Class<?> getRawType(Type type) {
            return Utils.getRawType(type);
        }

        public abstract CallAdapter<?, ?> get(Type type, Annotation[] annotationArr, Retrofit retrofit);
    }

    T adapt(Call<R> call);

    Type responseType();
}
