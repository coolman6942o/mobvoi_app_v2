package j3;

import android.graphics.Color;
import android.graphics.Rect;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.huawei.hms.mlkit.common.ha.d;
import h3.b;
import h3.j;
import h3.k;
import h3.l;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import k3.h;
import l3.a;
/* compiled from: LayerParser.java */
/* loaded from: classes.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.a f29428a = JsonReader.a.a("nm", "ind", "refId", "ty", "parent", "sw", "sh", "sc", "ks", "tt", "masksProperties", "shapes", "t", "ef", "sr", "st", "w", "h", "ip", "op", "tm", "cl", "hd");

    /* renamed from: b  reason: collision with root package name */
    private static final JsonReader.a f29429b = JsonReader.a.a(d.f14069a, "a");

    /* renamed from: c  reason: collision with root package name */
    private static final JsonReader.a f29430c = JsonReader.a.a("nm");

    public static Layer a(com.airbnb.lottie.d dVar) {
        Rect b10 = dVar.b();
        return new Layer(Collections.emptyList(), dVar, "__container", -1L, Layer.LayerType.PRE_COMP, -1L, null, Collections.emptyList(), new l(), 0, 0, 0, 0.0f, 0.0f, b10.width(), b10.height(), null, null, Collections.emptyList(), Layer.MatteType.NONE, null, false);
    }

    public static Layer b(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        ArrayList arrayList;
        ArrayList arrayList2;
        float f10;
        Layer.MatteType matteType = Layer.MatteType.NONE;
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        jsonReader.h();
        Float valueOf = Float.valueOf(1.0f);
        Layer.LayerType layerType = null;
        Float valueOf2 = Float.valueOf(0.0f);
        String str = "UNSET";
        long j10 = 0;
        long j11 = -1;
        Layer.MatteType matteType2 = matteType;
        float f11 = 1.0f;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        boolean z10 = false;
        String str2 = null;
        l lVar = null;
        j jVar = null;
        k kVar = null;
        b bVar = null;
        float f12 = 0.0f;
        float f13 = 0.0f;
        float f14 = 0.0f;
        String str3 = null;
        while (jsonReader.o()) {
            switch (jsonReader.Q(f29428a)) {
                case 0:
                    str = jsonReader.x();
                    break;
                case 1:
                    j10 = jsonReader.v();
                    break;
                case 2:
                    str2 = jsonReader.x();
                    break;
                case 3:
                    int v10 = jsonReader.v();
                    layerType = Layer.LayerType.UNKNOWN;
                    if (v10 >= layerType.ordinal()) {
                        break;
                    } else {
                        layerType = Layer.LayerType.values()[v10];
                        break;
                    }
                case 4:
                    j11 = jsonReader.v();
                    break;
                case 5:
                    i10 = (int) (jsonReader.v() * h.e());
                    break;
                case 6:
                    i11 = (int) (jsonReader.v() * h.e());
                    break;
                case 7:
                    i12 = Color.parseColor(jsonReader.x());
                    break;
                case 8:
                    lVar = c.g(jsonReader, dVar);
                    break;
                case 9:
                    matteType2 = Layer.MatteType.values()[jsonReader.v()];
                    dVar.q(1);
                    break;
                case 10:
                    jsonReader.d();
                    while (jsonReader.o()) {
                        arrayList3.add(u.a(jsonReader, dVar));
                    }
                    dVar.q(arrayList3.size());
                    jsonReader.i();
                    break;
                case 11:
                    jsonReader.d();
                    while (jsonReader.o()) {
                        i3.b a10 = g.a(jsonReader, dVar);
                        if (a10 != null) {
                            arrayList4.add(a10);
                        }
                    }
                    jsonReader.i();
                    break;
                case 12:
                    jsonReader.h();
                    while (jsonReader.o()) {
                        int Q = jsonReader.Q(f29429b);
                        if (Q == 0) {
                            jVar = d.d(jsonReader, dVar);
                        } else if (Q != 1) {
                            jsonReader.T();
                            jsonReader.V();
                        } else {
                            jsonReader.d();
                            if (jsonReader.o()) {
                                kVar = b.a(jsonReader, dVar);
                            }
                            while (jsonReader.o()) {
                                jsonReader.V();
                            }
                            jsonReader.i();
                        }
                    }
                    jsonReader.n();
                    break;
                case 13:
                    jsonReader.d();
                    ArrayList arrayList5 = new ArrayList();
                    while (jsonReader.o()) {
                        jsonReader.h();
                        while (jsonReader.o()) {
                            if (jsonReader.Q(f29430c) != 0) {
                                jsonReader.T();
                                jsonReader.V();
                            } else {
                                arrayList5.add(jsonReader.x());
                            }
                        }
                        jsonReader.n();
                    }
                    jsonReader.i();
                    dVar.a("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList5);
                    break;
                case 14:
                    f11 = (float) jsonReader.u();
                    break;
                case 15:
                    f14 = (float) jsonReader.u();
                    break;
                case 16:
                    i13 = (int) (jsonReader.v() * h.e());
                    break;
                case 17:
                    i14 = (int) (jsonReader.v() * h.e());
                    break;
                case 18:
                    f12 = (float) jsonReader.u();
                    break;
                case 19:
                    f13 = (float) jsonReader.u();
                    break;
                case 20:
                    bVar = d.f(jsonReader, dVar, false);
                    break;
                case 21:
                    str3 = jsonReader.x();
                    break;
                case 22:
                    z10 = jsonReader.q();
                    break;
                default:
                    jsonReader.T();
                    jsonReader.V();
                    break;
            }
        }
        jsonReader.n();
        float f15 = f12 / f11;
        float f16 = f13 / f11;
        ArrayList arrayList6 = new ArrayList();
        if (f15 > 0.0f) {
            arrayList = arrayList3;
            arrayList2 = arrayList6;
            arrayList2.add(new a(dVar, valueOf2, valueOf2, null, 0.0f, Float.valueOf(f15)));
            f10 = 0.0f;
        } else {
            arrayList = arrayList3;
            arrayList2 = arrayList6;
            f10 = 0.0f;
        }
        if (f16 <= f10) {
            f16 = dVar.f();
        }
        arrayList2.add(new a(dVar, valueOf, valueOf, null, f15, Float.valueOf(f16)));
        arrayList2.add(new a(dVar, valueOf2, valueOf2, null, f16, Float.valueOf(Float.MAX_VALUE)));
        if (str.endsWith(".ai") || "ai".equals(str3)) {
            dVar.a("Convert your Illustrator layers to shape layers.");
        }
        return new Layer(arrayList4, dVar, str, j10, layerType, j11, str2, arrayList, lVar, i10, i11, i12, f11, f14, i13, i14, jVar, kVar, arrayList2, matteType2, bVar, z10);
    }
}
