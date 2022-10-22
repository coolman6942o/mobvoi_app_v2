package j3;

import com.airbnb.lottie.d;
import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.huawei.hms.scankit.C0559e;
import h3.b;
import java.io.IOException;
/* compiled from: ShapeTrimPathParser.java */
/* loaded from: classes.dex */
class i0 {

    /* renamed from: a  reason: collision with root package name */
    private static JsonReader.a f29411a = JsonReader.a.a("s", C0559e.f14347a, "o", "nm", "m", "hd");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ShapeTrimPath a(JsonReader jsonReader, d dVar) throws IOException {
        String str = null;
        boolean z10 = false;
        ShapeTrimPath.Type type = null;
        b bVar = null;
        b bVar2 = null;
        b bVar3 = null;
        while (jsonReader.o()) {
            int Q = jsonReader.Q(f29411a);
            if (Q == 0) {
                bVar = d.f(jsonReader, dVar, false);
            } else if (Q == 1) {
                bVar2 = d.f(jsonReader, dVar, false);
            } else if (Q == 2) {
                bVar3 = d.f(jsonReader, dVar, false);
            } else if (Q == 3) {
                str = jsonReader.x();
            } else if (Q == 4) {
                type = ShapeTrimPath.Type.forId(jsonReader.v());
            } else if (Q != 5) {
                jsonReader.V();
            } else {
                z10 = jsonReader.q();
            }
        }
        return new ShapeTrimPath(str, type, bVar, bVar2, bVar3, z10);
    }
}
