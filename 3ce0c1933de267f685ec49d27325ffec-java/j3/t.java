package j3;

import android.graphics.Rect;
import androidx.collection.g;
import com.airbnb.lottie.d;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import g3.b;
import g3.c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import k3.h;
/* compiled from: LottieCompositionMoshiParser.java */
/* loaded from: classes.dex */
public class t {

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.a f29431a = JsonReader.a.a("w", "h", "ip", "op", "fr", "v", "layers", "assets", "fonts", "chars", "markers");

    /* renamed from: b  reason: collision with root package name */
    static JsonReader.a f29432b = JsonReader.a.a("id", "layers", "w", "h", "p", "u");

    /* renamed from: c  reason: collision with root package name */
    private static final JsonReader.a f29433c = JsonReader.a.a("list");

    /* renamed from: d  reason: collision with root package name */
    private static final JsonReader.a f29434d = JsonReader.a.a("cm", "tm", "dr");

    public static d a(JsonReader jsonReader) throws IOException {
        ArrayList arrayList;
        HashMap hashMap;
        JsonReader jsonReader2 = jsonReader;
        float e10 = h.e();
        androidx.collection.d<Layer> dVar = new androidx.collection.d<>();
        ArrayList arrayList2 = new ArrayList();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = new HashMap();
        ArrayList arrayList3 = new ArrayList();
        g<c> gVar = new g<>();
        d dVar2 = new d();
        jsonReader.h();
        float f10 = 0.0f;
        float f11 = 0.0f;
        float f12 = 0.0f;
        int i10 = 0;
        int i11 = 0;
        while (jsonReader.o()) {
            switch (jsonReader2.Q(f29431a)) {
                case 0:
                    i10 = jsonReader.v();
                    continue;
                    jsonReader2 = jsonReader;
                case 1:
                    i11 = jsonReader.v();
                    continue;
                    jsonReader2 = jsonReader;
                case 2:
                    f10 = (float) jsonReader.u();
                    continue;
                    jsonReader2 = jsonReader;
                case 3:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    f11 = ((float) jsonReader.u()) - 0.01f;
                    break;
                case 4:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    f12 = (float) jsonReader.u();
                    break;
                case 5:
                    String[] split = jsonReader.x().split("\\.");
                    if (!h.j(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), 4, 4, 0)) {
                        dVar2.a("Lottie only supports bodymovin >= 4.4.0");
                    }
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    break;
                case 6:
                    e(jsonReader2, dVar2, arrayList2, dVar);
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    break;
                case 7:
                    b(jsonReader2, dVar2, hashMap2, hashMap3);
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    break;
                case 8:
                    d(jsonReader2, hashMap4);
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    break;
                case 9:
                    c(jsonReader2, dVar2, gVar);
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    break;
                case 10:
                    f(jsonReader2, dVar2, arrayList3);
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    break;
                default:
                    hashMap = hashMap4;
                    arrayList = arrayList3;
                    jsonReader.T();
                    jsonReader.V();
                    break;
            }
            hashMap4 = hashMap;
            arrayList3 = arrayList;
            jsonReader2 = jsonReader;
        }
        dVar2.r(new Rect(0, 0, (int) (i10 * e10), (int) (i11 * e10)), f10, f11, f12, arrayList2, dVar, hashMap2, hashMap3, gVar, hashMap4, arrayList3);
        return dVar2;
    }

    private static void b(JsonReader jsonReader, d dVar, Map<String, List<Layer>> map, Map<String, com.airbnb.lottie.g> map2) throws IOException {
        jsonReader.d();
        while (jsonReader.o()) {
            ArrayList arrayList = new ArrayList();
            androidx.collection.d dVar2 = new androidx.collection.d();
            jsonReader.h();
            int i10 = 0;
            String str = null;
            int i11 = 0;
            String str2 = null;
            String str3 = null;
            while (jsonReader.o()) {
                int Q = jsonReader.Q(f29432b);
                if (Q == 0) {
                    str = jsonReader.x();
                } else if (Q == 1) {
                    jsonReader.d();
                    while (jsonReader.o()) {
                        Layer b10 = s.b(jsonReader, dVar);
                        dVar2.k(b10.b(), b10);
                        arrayList.add(b10);
                    }
                    jsonReader.i();
                } else if (Q == 2) {
                    i10 = jsonReader.v();
                } else if (Q == 3) {
                    i11 = jsonReader.v();
                } else if (Q == 4) {
                    str2 = jsonReader.x();
                } else if (Q != 5) {
                    jsonReader.T();
                    jsonReader.V();
                } else {
                    str3 = jsonReader.x();
                }
            }
            jsonReader.n();
            if (str2 != null) {
                com.airbnb.lottie.g gVar = new com.airbnb.lottie.g(i10, i11, str, str2, str3);
                map2.put(gVar.d(), gVar);
            } else {
                map.put(str, arrayList);
            }
        }
        jsonReader.i();
    }

    private static void c(JsonReader jsonReader, d dVar, g<c> gVar) throws IOException {
        jsonReader.d();
        while (jsonReader.o()) {
            c a10 = j.a(jsonReader, dVar);
            gVar.j(a10.hashCode(), a10);
        }
        jsonReader.i();
    }

    private static void d(JsonReader jsonReader, Map<String, b> map) throws IOException {
        jsonReader.h();
        while (jsonReader.o()) {
            if (jsonReader.Q(f29433c) != 0) {
                jsonReader.T();
                jsonReader.V();
            } else {
                jsonReader.d();
                while (jsonReader.o()) {
                    b a10 = k.a(jsonReader);
                    map.put(a10.b(), a10);
                }
                jsonReader.i();
            }
        }
        jsonReader.n();
    }

    private static void e(JsonReader jsonReader, d dVar, List<Layer> list, androidx.collection.d<Layer> dVar2) throws IOException {
        jsonReader.d();
        int i10 = 0;
        while (jsonReader.o()) {
            Layer b10 = s.b(jsonReader, dVar);
            if (b10.d() == Layer.LayerType.IMAGE) {
                i10++;
            }
            list.add(b10);
            dVar2.k(b10.b(), b10);
            if (i10 > 4) {
                k3.d.c("You have " + i10 + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        jsonReader.i();
    }

    private static void f(JsonReader jsonReader, d dVar, List<g3.g> list) throws IOException {
        jsonReader.d();
        while (jsonReader.o()) {
            String str = null;
            jsonReader.h();
            float f10 = 0.0f;
            float f11 = 0.0f;
            while (jsonReader.o()) {
                int Q = jsonReader.Q(f29434d);
                if (Q == 0) {
                    str = jsonReader.x();
                } else if (Q == 1) {
                    f10 = (float) jsonReader.u();
                } else if (Q != 2) {
                    jsonReader.T();
                    jsonReader.V();
                } else {
                    f11 = (float) jsonReader.u();
                }
            }
            jsonReader.n();
            list.add(new g3.g(str, f10, f11));
        }
        jsonReader.i();
    }
}
