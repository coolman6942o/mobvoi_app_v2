package j3;

import android.graphics.Path;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.huawei.hms.scankit.C0559e;
import h3.c;
import h3.f;
import i3.d;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GradientFillParser.java */
/* loaded from: classes.dex */
public class m {

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.a f29416a = JsonReader.a.a("nm", "g", "o", "t", "s", C0559e.f14347a, "r", "hd");

    /* renamed from: b  reason: collision with root package name */
    private static final JsonReader.a f29417b = JsonReader.a.a("p", "k");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d a(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        String str = null;
        boolean z10 = false;
        Path.FillType fillType = Path.FillType.WINDING;
        GradientType gradientType = null;
        c cVar = null;
        h3.d dVar2 = null;
        f fVar = null;
        f fVar2 = null;
        while (jsonReader.o()) {
            switch (jsonReader.Q(f29416a)) {
                case 0:
                    str = jsonReader.x();
                    break;
                case 1:
                    int i10 = -1;
                    jsonReader.h();
                    while (jsonReader.o()) {
                        int Q = jsonReader.Q(f29417b);
                        if (Q == 0) {
                            i10 = jsonReader.v();
                        } else if (Q != 1) {
                            jsonReader.T();
                            jsonReader.V();
                        } else {
                            cVar = d.g(jsonReader, dVar, i10);
                        }
                    }
                    jsonReader.n();
                    break;
                case 2:
                    dVar2 = d.h(jsonReader, dVar);
                    break;
                case 3:
                    gradientType = jsonReader.v() == 1 ? GradientType.LINEAR : GradientType.RADIAL;
                    break;
                case 4:
                    fVar = d.i(jsonReader, dVar);
                    break;
                case 5:
                    fVar2 = d.i(jsonReader, dVar);
                    break;
                case 6:
                    fillType = jsonReader.v() == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                    break;
                case 7:
                    z10 = jsonReader.q();
                    break;
                default:
                    jsonReader.T();
                    jsonReader.V();
                    break;
            }
        }
        return new d(str, gradientType, fillType, cVar, dVar2, fVar, fVar2, null, null, z10);
    }
}
