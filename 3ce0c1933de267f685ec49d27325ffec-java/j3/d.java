package j3;

import com.airbnb.lottie.parser.moshi.JsonReader;
import h3.b;
import h3.c;
import h3.f;
import h3.g;
import h3.j;
import java.io.IOException;
import java.util.List;
import k3.h;
import l3.a;
/* compiled from: AnimatableValueParser.java */
/* loaded from: classes.dex */
public class d {
    private static <T> List<a<T>> a(JsonReader jsonReader, float f10, com.airbnb.lottie.d dVar, j0<T> j0Var) throws IOException {
        return r.a(jsonReader, dVar, f10, j0Var);
    }

    private static <T> List<a<T>> b(JsonReader jsonReader, com.airbnb.lottie.d dVar, j0<T> j0Var) throws IOException {
        return r.a(jsonReader, dVar, 1.0f, j0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static h3.a c(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        return new h3.a(b(jsonReader, dVar, f.f29402a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static j d(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        return new j(b(jsonReader, dVar, h.f29406a));
    }

    public static b e(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        return f(jsonReader, dVar, true);
    }

    public static b f(JsonReader jsonReader, com.airbnb.lottie.d dVar, boolean z10) throws IOException {
        return new b(a(jsonReader, z10 ? h.e() : 1.0f, dVar, i.f29410a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c g(JsonReader jsonReader, com.airbnb.lottie.d dVar, int i10) throws IOException {
        return new c(b(jsonReader, dVar, new l(i10)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static h3.d h(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        return new h3.d(b(jsonReader, dVar, o.f29421a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static f i(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        return new f(a(jsonReader, h.e(), dVar, y.f29437a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static g j(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        return new g(b(jsonReader, dVar, c0.f29397a));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static h3.h k(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        return new h3.h(a(jsonReader, h.e(), dVar, d0.f29398a));
    }
}
