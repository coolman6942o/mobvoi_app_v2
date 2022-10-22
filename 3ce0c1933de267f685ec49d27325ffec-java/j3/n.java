package j3;

import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.model.content.a;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.huawei.hms.mlkit.common.ha.d;
import com.huawei.hms.scankit.C0559e;
import h3.b;
import h3.c;
import h3.f;
import java.io.IOException;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GradientStrokeParser.java */
/* loaded from: classes.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    private static JsonReader.a f29418a = JsonReader.a.a("nm", "g", "o", "t", "s", C0559e.f14347a, "w", "lc", "lj", "ml", "hd", d.f14069a);

    /* renamed from: b  reason: collision with root package name */
    private static final JsonReader.a f29419b = JsonReader.a.a("p", "k");

    /* renamed from: c  reason: collision with root package name */
    private static final JsonReader.a f29420c = JsonReader.a.a("n", "v");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a a(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        c cVar;
        ArrayList arrayList = new ArrayList();
        float f10 = 0.0f;
        String str = null;
        GradientType gradientType = null;
        c cVar2 = null;
        h3.d dVar2 = null;
        f fVar = null;
        f fVar2 = null;
        b bVar = null;
        ShapeStroke.LineCapType lineCapType = null;
        ShapeStroke.LineJoinType lineJoinType = null;
        b bVar2 = null;
        boolean z10 = false;
        while (jsonReader.o()) {
            switch (jsonReader.Q(f29418a)) {
                case 0:
                    str = jsonReader.x();
                    break;
                case 1:
                    int i10 = -1;
                    jsonReader.h();
                    while (jsonReader.o()) {
                        int Q = jsonReader.Q(f29419b);
                        if (Q != 0) {
                            cVar = cVar2;
                            if (Q != 1) {
                                jsonReader.T();
                                jsonReader.V();
                            } else {
                                cVar2 = d.g(jsonReader, dVar, i10);
                            }
                        } else {
                            cVar = cVar2;
                            i10 = jsonReader.v();
                        }
                        cVar2 = cVar;
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
                    bVar = d.e(jsonReader, dVar);
                    break;
                case 7:
                    lineCapType = ShapeStroke.LineCapType.values()[jsonReader.v() - 1];
                    break;
                case 8:
                    lineJoinType = ShapeStroke.LineJoinType.values()[jsonReader.v() - 1];
                    break;
                case 9:
                    f10 = (float) jsonReader.u();
                    break;
                case 10:
                    z10 = jsonReader.q();
                    break;
                case 11:
                    jsonReader.d();
                    while (jsonReader.o()) {
                        jsonReader.h();
                        String str2 = null;
                        b bVar3 = null;
                        while (jsonReader.o()) {
                            int Q2 = jsonReader.Q(f29420c);
                            if (Q2 != 0) {
                                bVar2 = bVar2;
                                if (Q2 != 1) {
                                    jsonReader.T();
                                    jsonReader.V();
                                } else {
                                    bVar3 = d.e(jsonReader, dVar);
                                }
                            } else {
                                str2 = jsonReader.x();
                            }
                        }
                        bVar2 = bVar2;
                        jsonReader.n();
                        if (str2.equals("o")) {
                            bVar2 = bVar3;
                        } else if (str2.equals(d.f14069a) || str2.equals("g")) {
                            dVar.t(true);
                            arrayList.add(bVar3);
                        }
                    }
                    bVar2 = bVar2;
                    jsonReader.i();
                    if (arrayList.size() == 1) {
                        arrayList.add(arrayList.get(0));
                    }
                    break;
                default:
                    jsonReader.T();
                    jsonReader.V();
                    break;
            }
        }
        return new a(str, gradientType, cVar2, dVar2, fVar, fVar2, bVar, lineCapType, lineJoinType, f10, arrayList, bVar2, z10);
    }
}
