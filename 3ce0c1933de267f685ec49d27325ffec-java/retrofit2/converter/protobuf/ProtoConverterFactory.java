package retrofit2.converter.protobuf;

import com.google.protobuf.e0;
import com.google.protobuf.l0;
import com.google.protobuf.q;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import okhttp3.a0;
import okhttp3.c0;
import retrofit2.Converter;
import retrofit2.Retrofit;
/* loaded from: classes3.dex */
public final class ProtoConverterFactory extends Converter.Factory {
    private final q registry;

    private ProtoConverterFactory(q qVar) {
        this.registry = qVar;
    }

    public static ProtoConverterFactory create() {
        return new ProtoConverterFactory(null);
    }

    public static ProtoConverterFactory createWithRegistry(q qVar) {
        return new ProtoConverterFactory(qVar);
    }

    @Override // retrofit2.Converter.Factory
    public Converter<?, a0> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
        if ((type instanceof Class) && e0.class.isAssignableFrom((Class) type)) {
            return new ProtoRequestBodyConverter();
        }
        return null;
    }

    @Override // retrofit2.Converter.Factory
    public Converter<c0, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        l0 l0Var;
        if (!(type instanceof Class)) {
            return null;
        }
        Class cls = (Class) type;
        if (!e0.class.isAssignableFrom(cls)) {
            return null;
        }
        try {
            try {
                l0Var = (l0) cls.getDeclaredMethod("parser", new Class[0]).invoke(null, new Object[0]);
            } catch (IllegalAccessException | NoSuchFieldException unused) {
                throw new IllegalArgumentException("Found a protobuf message but " + cls.getName() + " had no parser() method or PARSER field.");
            }
        } catch (IllegalAccessException | NoSuchMethodException unused2) {
            l0Var = (l0) cls.getDeclaredField("PARSER").get(null);
        } catch (InvocationTargetException e10) {
            throw new RuntimeException(e10.getCause());
        }
        return new ProtoResponseBodyConverter(l0Var, this.registry);
    }
}
