package j3;

import android.graphics.PointF;
import com.airbnb.lottie.d;
import com.airbnb.lottie.parser.moshi.JsonReader;
import h3.b;
import h3.e;
import h3.i;
import h3.m;
import java.io.IOException;
import java.util.ArrayList;
import k3.h;
/* compiled from: AnimatablePathValueParser.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static JsonReader.a f29390a = JsonReader.a.a("k", "x", "y");

    public static e a(JsonReader jsonReader, d dVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.I() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.d();
            while (jsonReader.o()) {
                arrayList.add(w.a(jsonReader, dVar));
            }
            jsonReader.i();
            r.b(arrayList);
        } else {
            arrayList.add(new l3.a(p.e(jsonReader, h.e())));
        }
        return new e(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static m<PointF, PointF> b(JsonReader jsonReader, d dVar) throws IOException {
        jsonReader.h();
        e eVar = null;
        boolean z10 = false;
        b bVar = null;
        b bVar2 = null;
        while (jsonReader.I() != JsonReader.Token.END_OBJECT) {
            int Q = jsonReader.Q(f29390a);
            if (Q == 0) {
                eVar = a(jsonReader, dVar);
            } else if (Q != 1) {
                if (Q != 2) {
                    jsonReader.T();
                    jsonReader.V();
                } else if (jsonReader.I() == JsonReader.Token.STRING) {
                    jsonReader.V();
                    z10 = true;
                } else {
                    bVar = d.e(jsonReader, dVar);
                }
            } else if (jsonReader.I() == JsonReader.Token.STRING) {
                jsonReader.V();
                z10 = true;
            } else {
                bVar2 = d.e(jsonReader, dVar);
            }
        }
        jsonReader.n();
        if (z10) {
            dVar.a("Lottie doesn't support expressions.");
        }
        return eVar != null ? eVar : new i(bVar2, bVar);
    }
}
