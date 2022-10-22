package j3;

import com.airbnb.lottie.d;
import com.airbnb.lottie.parser.moshi.JsonReader;
import h3.a;
import h3.k;
import java.io.IOException;
/* compiled from: AnimatableTextPropertiesParser.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static JsonReader.a f29392a = JsonReader.a.a("a");

    /* renamed from: b  reason: collision with root package name */
    private static JsonReader.a f29393b = JsonReader.a.a("fc", "sc", "sw", "t");

    public static k a(JsonReader jsonReader, d dVar) throws IOException {
        jsonReader.h();
        k kVar = null;
        while (jsonReader.o()) {
            if (jsonReader.Q(f29392a) != 0) {
                jsonReader.T();
                jsonReader.V();
            } else {
                kVar = b(jsonReader, dVar);
            }
        }
        jsonReader.n();
        return kVar == null ? new k(null, null, null, null) : kVar;
    }

    private static k b(JsonReader jsonReader, d dVar) throws IOException {
        jsonReader.h();
        a aVar = null;
        a aVar2 = null;
        h3.b bVar = null;
        h3.b bVar2 = null;
        while (jsonReader.o()) {
            int Q = jsonReader.Q(f29393b);
            if (Q == 0) {
                aVar = d.c(jsonReader, dVar);
            } else if (Q == 1) {
                aVar2 = d.c(jsonReader, dVar);
            } else if (Q == 2) {
                bVar = d.e(jsonReader, dVar);
            } else if (Q != 3) {
                jsonReader.T();
                jsonReader.V();
            } else {
                bVar2 = d.e(jsonReader, dVar);
            }
        }
        jsonReader.n();
        return new k(aVar, aVar2, bVar, bVar2);
    }
}
