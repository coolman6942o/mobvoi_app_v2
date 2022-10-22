package j3;

import android.graphics.PointF;
import com.airbnb.lottie.d;
import com.airbnb.lottie.parser.moshi.JsonReader;
import h3.b;
import h3.e;
import h3.g;
import h3.i;
import h3.l;
import h3.m;
import java.io.IOException;
import l3.a;
/* compiled from: AnimatableTransformParser.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static JsonReader.a f29395a = JsonReader.a.a("a", "p", "s", "rz", "r", "o", "so", "eo", "sk", "sa");

    /* renamed from: b  reason: collision with root package name */
    private static JsonReader.a f29396b = JsonReader.a.a("k");

    private static boolean a(e eVar) {
        return eVar == null || (eVar.c() && eVar.b().get(0).f30404b.equals(0.0f, 0.0f));
    }

    private static boolean b(m<PointF, PointF> mVar) {
        return mVar == null || (!(mVar instanceof i) && mVar.c() && mVar.b().get(0).f30404b.equals(0.0f, 0.0f));
    }

    private static boolean c(b bVar) {
        return bVar == null || (bVar.c() && bVar.b().get(0).f30404b.floatValue() == 0.0f);
    }

    private static boolean d(g gVar) {
        return gVar == null || (gVar.c() && gVar.b().get(0).f30404b.a(1.0f, 1.0f));
    }

    private static boolean e(b bVar) {
        return bVar == null || (bVar.c() && bVar.b().get(0).f30404b.floatValue() == 0.0f);
    }

    private static boolean f(b bVar) {
        return bVar == null || (bVar.c() && bVar.b().get(0).f30404b.floatValue() == 0.0f);
    }

    public static l g(JsonReader jsonReader, d dVar) throws IOException {
        boolean z10;
        boolean z11 = false;
        boolean z12 = jsonReader.I() == JsonReader.Token.BEGIN_OBJECT;
        if (z12) {
            jsonReader.h();
        }
        b bVar = null;
        e eVar = null;
        m<PointF, PointF> mVar = null;
        g gVar = null;
        b bVar2 = null;
        b bVar3 = null;
        h3.d dVar2 = null;
        b bVar4 = null;
        b bVar5 = null;
        while (jsonReader.o()) {
            switch (jsonReader.Q(f29395a)) {
                case 0:
                    z11 = z11;
                    jsonReader.h();
                    while (jsonReader.o()) {
                        if (jsonReader.Q(f29396b) != 0) {
                            jsonReader.T();
                            jsonReader.V();
                        } else {
                            eVar = a.a(jsonReader, dVar);
                        }
                    }
                    jsonReader.n();
                    continue;
                case 1:
                    mVar = a.b(jsonReader, dVar);
                    continue;
                case 2:
                    gVar = d.j(jsonReader, dVar);
                    continue;
                case 3:
                    dVar.a("Lottie doesn't support 3D layers.");
                    break;
                case 4:
                    break;
                case 5:
                    dVar2 = d.h(jsonReader, dVar);
                    continue;
                case 6:
                    bVar4 = d.f(jsonReader, dVar, z11);
                    continue;
                case 7:
                    bVar5 = d.f(jsonReader, dVar, z11);
                    continue;
                case 8:
                    bVar2 = d.f(jsonReader, dVar, z11);
                    continue;
                case 9:
                    bVar3 = d.f(jsonReader, dVar, z11);
                    continue;
                default:
                    jsonReader.T();
                    jsonReader.V();
                    continue;
            }
            b f10 = d.f(jsonReader, dVar, z11);
            if (f10.b().isEmpty()) {
                f10.b().add(new a<>(dVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(dVar.f())));
            } else if (f10.b().get(0).f30404b == null) {
                z10 = false;
                f10.b().set(0, new a<>(dVar, Float.valueOf(0.0f), Float.valueOf(0.0f), null, 0.0f, Float.valueOf(dVar.f())));
                z11 = z10;
                bVar = f10;
            }
            z10 = false;
            z11 = z10;
            bVar = f10;
        }
        if (z12) {
            jsonReader.n();
        }
        e eVar2 = a(eVar) ? null : eVar;
        m<PointF, PointF> mVar2 = b(mVar) ? null : mVar;
        b bVar6 = c(bVar) ? null : bVar;
        if (d(gVar)) {
            gVar = null;
        }
        return new l(eVar2, mVar2, gVar, bVar6, dVar2, bVar4, bVar5, f(bVar2) ? null : bVar2, e(bVar3) ? null : bVar3);
    }
}
