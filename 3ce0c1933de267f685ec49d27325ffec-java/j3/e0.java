package j3;

import android.graphics.Path;
import com.airbnb.lottie.d;
import com.airbnb.lottie.parser.moshi.JsonReader;
import h3.a;
import i3.h;
import java.io.IOException;
/* compiled from: ShapeFillParser.java */
/* loaded from: classes.dex */
class e0 {

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.a f29401a = JsonReader.a.a("nm", "c", "o", "fillEnabled", "r", "hd");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static h a(JsonReader jsonReader, d dVar) throws IOException {
        String str = null;
        boolean z10 = false;
        boolean z11 = false;
        int i10 = 1;
        a aVar = null;
        h3.d dVar2 = null;
        while (jsonReader.o()) {
            int Q = jsonReader.Q(f29401a);
            if (Q == 0) {
                str = jsonReader.x();
            } else if (Q == 1) {
                aVar = d.c(jsonReader, dVar);
            } else if (Q == 2) {
                dVar2 = d.h(jsonReader, dVar);
            } else if (Q == 3) {
                z10 = jsonReader.q();
            } else if (Q == 4) {
                i10 = jsonReader.v();
            } else if (Q != 5) {
                jsonReader.T();
                jsonReader.V();
            } else {
                z11 = jsonReader.q();
            }
        }
        return new h(str, z10, i10 == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD, aVar, dVar2, z11);
    }
}
