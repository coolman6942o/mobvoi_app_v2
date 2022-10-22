package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import okhttp3.a0;
import okhttp3.c0;
/* loaded from: classes3.dex */
public interface Converter<F, T> {

    /* loaded from: classes3.dex */
    public static abstract class Factory {
        protected static Type getParameterUpperBound(int i10, ParameterizedType parameterizedType) {
            return Utils.getParameterUpperBound(i10, parameterizedType);
        }

        protected static Class<?> getRawType(Type type) {
            return Utils.getRawType(type);
        }

        public Converter<?, a0> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
            return null;
        }

        public Converter<c0, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
            return null;
        }

        public Converter<?, String> stringConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
            return null;
        }
    }

    T convert(F f10) throws IOException;
}
