package retrofit2.converter.gson;

import com.google.gson.e;
import com.google.gson.reflect.a;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Objects;
import okhttp3.a0;
import okhttp3.c0;
import retrofit2.Converter;
import retrofit2.Retrofit;
/* loaded from: classes3.dex */
public final class GsonConverterFactory extends Converter.Factory {
    private final e gson;

    private GsonConverterFactory(e eVar) {
        this.gson = eVar;
    }

    public static GsonConverterFactory create() {
        return create(new e());
    }

    @Override // retrofit2.Converter.Factory
    public Converter<?, a0> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit retrofit) {
        return new GsonRequestBodyConverter(this.gson, this.gson.l(a.get(type)));
    }

    @Override // retrofit2.Converter.Factory
    public Converter<c0, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        return new GsonResponseBodyConverter(this.gson, this.gson.l(a.get(type)));
    }

    public static GsonConverterFactory create(e eVar) {
        Objects.requireNonNull(eVar, "gson == null");
        return new GsonConverterFactory(eVar);
    }
}
