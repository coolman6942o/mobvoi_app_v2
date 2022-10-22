package j3;

import com.airbnb.lottie.d;
import com.airbnb.lottie.parser.moshi.JsonReader;
import h3.h;
import i3.j;
import java.io.IOException;
/* compiled from: ShapePathParser.java */
/* loaded from: classes.dex */
class g0 {

    /* renamed from: a  reason: collision with root package name */
    static JsonReader.a f29405a = JsonReader.a.a("nm", "ind", "ks", "hd");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static j a(JsonReader jsonReader, d dVar) throws IOException {
        int i10 = 0;
        String str = null;
        h hVar = null;
        boolean z10 = false;
        while (jsonReader.o()) {
            int Q = jsonReader.Q(f29405a);
            if (Q == 0) {
                str = jsonReader.x();
            } else if (Q == 1) {
                i10 = jsonReader.v();
            } else if (Q == 2) {
                hVar = d.k(jsonReader, dVar);
            } else if (Q != 3) {
                jsonReader.V();
            } else {
                z10 = jsonReader.q();
            }
        }
        return new j(str, i10, hVar, z10);
    }
}
