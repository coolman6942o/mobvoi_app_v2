package j3;

import android.graphics.PointF;
import com.airbnb.lottie.d;
import com.airbnb.lottie.parser.moshi.JsonReader;
import h3.b;
import h3.f;
import h3.m;
import i3.e;
import java.io.IOException;
/* compiled from: RectangleShapeParser.java */
/* loaded from: classes.dex */
class a0 {

    /* renamed from: a  reason: collision with root package name */
    private static JsonReader.a f29391a = JsonReader.a.a("nm", "p", "s", "r", "hd");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e a(JsonReader jsonReader, d dVar) throws IOException {
        boolean z10 = false;
        String str = null;
        m<PointF, PointF> mVar = null;
        f fVar = null;
        b bVar = null;
        while (jsonReader.o()) {
            int Q = jsonReader.Q(f29391a);
            if (Q == 0) {
                str = jsonReader.x();
            } else if (Q == 1) {
                mVar = a.b(jsonReader, dVar);
            } else if (Q == 2) {
                fVar = d.i(jsonReader, dVar);
            } else if (Q == 3) {
                bVar = d.e(jsonReader, dVar);
            } else if (Q != 4) {
                jsonReader.V();
            } else {
                z10 = jsonReader.q();
            }
        }
        return new e(str, mVar, fVar, bVar, z10);
    }
}
