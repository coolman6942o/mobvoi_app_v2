package j3;

import com.airbnb.lottie.d;
import com.airbnb.lottie.parser.moshi.JsonReader;
import i3.b;
import i3.i;
import java.io.IOException;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShapeGroupParser.java */
/* loaded from: classes.dex */
public class f0 {

    /* renamed from: a  reason: collision with root package name */
    private static JsonReader.a f29403a = JsonReader.a.a("nm", "hd", "it");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static i a(JsonReader jsonReader, d dVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        String str = null;
        boolean z10 = false;
        while (jsonReader.o()) {
            int Q = jsonReader.Q(f29403a);
            if (Q == 0) {
                str = jsonReader.x();
            } else if (Q == 1) {
                z10 = jsonReader.q();
            } else if (Q != 2) {
                jsonReader.V();
            } else {
                jsonReader.d();
                while (jsonReader.o()) {
                    b a10 = g.a(jsonReader, dVar);
                    if (a10 != null) {
                        arrayList.add(a10);
                    }
                }
                jsonReader.i();
            }
        }
        return new i(str, arrayList, z10);
    }
}
