package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.a0;
import okhttp3.c0;
import retrofit2.Converter;
import retrofit2.http.Streaming;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public final class BuiltInConverters extends Converter.Factory {

    /* loaded from: classes3.dex */
    static final class BufferingResponseBodyConverter implements Converter<c0, c0> {
        static final BufferingResponseBodyConverter INSTANCE = new BufferingResponseBodyConverter();

        BufferingResponseBodyConverter() {
        }

        public c0 convert(c0 c0Var) throws IOException {
            try {
                return Utils.buffer(c0Var);
            } finally {
                c0Var.close();
            }
        }
    }

    /* loaded from: classes3.dex */
    static final class RequestBodyConverter implements Converter<a0, a0> {
        static final RequestBodyConverter INSTANCE = new RequestBodyConverter();

        RequestBodyConverter() {
        }

        public a0 convert(a0 a0Var) throws IOException {
            return a0Var;
        }
    }

    /* loaded from: classes3.dex */
    static final class StreamingResponseBodyConverter implements Converter<c0, c0> {
        static final StreamingResponseBodyConverter INSTANCE = new StreamingResponseBodyConverter();

        StreamingResponseBodyConverter() {
        }

        public c0 convert(c0 c0Var) throws IOException {
            return c0Var;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class ToStringConverter implements Converter<Object, String> {
        static final ToStringConverter INSTANCE = new ToStringConverter();

        ToStringConverter() {
        }

        @Override // retrofit2.Converter
        public String convert(Object obj) {
            return obj.toString();
        }
    }

    /* loaded from: classes3.dex */
    static final class VoidResponseBodyConverter implements Converter<c0, Void> {
        static final VoidResponseBodyConverter INSTANCE = new VoidResponseBodyConverter();

        VoidResponseBodyConverter() {
        }

        public Void convert(c0 c0Var) throws IOException {
            c0Var.close();
            return null;
        }
    }

    @Override // retrofit2.Converter.Factory
    public Converter<?, a0> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
        if (a0.class.isAssignableFrom(Utils.getRawType(type))) {
            return RequestBodyConverter.INSTANCE;
        }
        return null;
    }

    @Override // retrofit2.Converter.Factory
    public Converter<c0, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (type == c0.class) {
            if (Utils.isAnnotationPresent(annotationArr, Streaming.class)) {
                return StreamingResponseBodyConverter.INSTANCE;
            }
            return BufferingResponseBodyConverter.INSTANCE;
        } else if (type == Void.class) {
            return VoidResponseBodyConverter.INSTANCE;
        } else {
            return null;
        }
    }
}
