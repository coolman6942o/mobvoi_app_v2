package j3;

import com.airbnb.lottie.d;
import com.airbnb.lottie.parser.moshi.JsonReader;
import h3.b;
import h3.l;
import i3.f;
import java.io.IOException;
/* compiled from: RepeaterParser.java */
/* loaded from: classes.dex */
class b0 {

    /* renamed from: a  reason: collision with root package name */
    private static JsonReader.a f29394a = JsonReader.a.a("nm", "c", "o", "tr", "hd");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static f a(JsonReader jsonReader, d dVar) throws IOException {
        String str = null;
        boolean z10 = false;
        b bVar = null;
        b bVar2 = null;
        l lVar = null;
        while (jsonReader.o()) {
            int Q = jsonReader.Q(f29394a);
            if (Q == 0) {
                str = jsonReader.x();
            } else if (Q == 1) {
                bVar = d.f(jsonReader, dVar, false);
            } else if (Q == 2) {
                bVar2 = d.f(jsonReader, dVar, false);
            } else if (Q == 3) {
                lVar = c.g(jsonReader, dVar);
            } else if (Q != 4) {
                jsonReader.V();
            } else {
                z10 = jsonReader.q();
            }
        }
        return new f(str, bVar, bVar2, lVar, z10);
    }
}
