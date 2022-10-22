package j3;

import com.airbnb.lottie.model.content.ShapeStroke;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.huawei.hms.mlkit.common.ha.d;
import h3.a;
import h3.b;
import java.io.IOException;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShapeStrokeParser.java */
/* loaded from: classes.dex */
public class h0 {

    /* renamed from: a  reason: collision with root package name */
    private static JsonReader.a f29408a = JsonReader.a.a("nm", "c", "w", "o", "lc", "lj", "ml", "hd", d.f14069a);

    /* renamed from: b  reason: collision with root package name */
    private static final JsonReader.a f29409b = JsonReader.a.a("n", "v");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static ShapeStroke a(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        char c10;
        ArrayList arrayList = new ArrayList();
        float f10 = 0.0f;
        boolean z10 = false;
        String str = null;
        b bVar = null;
        a aVar = null;
        h3.d dVar2 = null;
        b bVar2 = null;
        ShapeStroke.LineCapType lineCapType = null;
        ShapeStroke.LineJoinType lineJoinType = null;
        while (jsonReader.o()) {
            switch (jsonReader.Q(f29408a)) {
                case 0:
                    str = jsonReader.x();
                    break;
                case 1:
                    aVar = d.c(jsonReader, dVar);
                    break;
                case 2:
                    bVar2 = d.e(jsonReader, dVar);
                    break;
                case 3:
                    dVar2 = d.h(jsonReader, dVar);
                    break;
                case 4:
                    lineCapType = ShapeStroke.LineCapType.values()[jsonReader.v() - 1];
                    break;
                case 5:
                    lineJoinType = ShapeStroke.LineJoinType.values()[jsonReader.v() - 1];
                    break;
                case 6:
                    f10 = (float) jsonReader.u();
                    break;
                case 7:
                    z10 = jsonReader.q();
                    break;
                case 8:
                    jsonReader.d();
                    while (jsonReader.o()) {
                        jsonReader.h();
                        String str2 = null;
                        b bVar3 = null;
                        while (jsonReader.o()) {
                            int Q = jsonReader.Q(f29409b);
                            if (Q == 0) {
                                str2 = jsonReader.x();
                            } else if (Q != 1) {
                                jsonReader.T();
                                jsonReader.V();
                            } else {
                                bVar3 = d.e(jsonReader, dVar);
                            }
                        }
                        jsonReader.n();
                        str2.hashCode();
                        switch (str2.hashCode()) {
                            case 100:
                                if (str2.equals(d.f14069a)) {
                                    c10 = 0;
                                    break;
                                }
                                c10 = 65535;
                                break;
                            case 103:
                                if (str2.equals("g")) {
                                    c10 = 1;
                                    break;
                                }
                                c10 = 65535;
                                break;
                            case 111:
                                if (str2.equals("o")) {
                                    c10 = 2;
                                    break;
                                }
                                c10 = 65535;
                                break;
                            default:
                                c10 = 65535;
                                break;
                        }
                        switch (c10) {
                            case 0:
                            case 1:
                                dVar.t(true);
                                arrayList.add(bVar3);
                                break;
                            case 2:
                                bVar = bVar3;
                                break;
                        }
                    }
                    jsonReader.i();
                    if (arrayList.size() != 1) {
                        break;
                    } else {
                        arrayList.add(arrayList.get(0));
                        break;
                    }
                    break;
                default:
                    jsonReader.V();
                    break;
            }
        }
        return new ShapeStroke(str, bVar, arrayList, aVar, dVar2, bVar2, lineCapType, lineJoinType, f10, z10);
    }
}
