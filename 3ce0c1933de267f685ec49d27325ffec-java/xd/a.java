package xd;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.c0;
import retrofit2.Converter;
import retrofit2.Retrofit;
/* compiled from: StringConverterFactory.java */
/* loaded from: classes2.dex */
public class a extends Converter.Factory {

    /* compiled from: StringConverterFactory.java */
    /* renamed from: xd.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    final class C0532a implements Converter<c0, String> {
        C0532a(a aVar) {
        }

        /* renamed from: a */
        public String convert(c0 c0Var) throws IOException {
            return c0Var.string();
        }
    }

    private a() {
    }

    public static a a() {
        return new a();
    }

    @Override // retrofit2.Converter.Factory
    public Converter<c0, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        return new C0532a(this);
    }
}
