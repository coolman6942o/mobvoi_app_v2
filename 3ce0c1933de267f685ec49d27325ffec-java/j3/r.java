package j3;

import com.airbnb.lottie.d;
import com.airbnb.lottie.parser.moshi.JsonReader;
import e3.h;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import l3.a;
/* compiled from: KeyframesParser.java */
/* loaded from: classes.dex */
class r {

    /* renamed from: a  reason: collision with root package name */
    static JsonReader.a f29427a = JsonReader.a.a("k");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> List<a<T>> a(JsonReader jsonReader, d dVar, float f10, j0<T> j0Var) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.I() == JsonReader.Token.STRING) {
            dVar.a("Lottie doesn't support expressions.");
            return arrayList;
        }
        jsonReader.h();
        while (jsonReader.o()) {
            if (jsonReader.Q(f29427a) != 0) {
                jsonReader.V();
            } else if (jsonReader.I() == JsonReader.Token.BEGIN_ARRAY) {
                jsonReader.d();
                if (jsonReader.I() == JsonReader.Token.NUMBER) {
                    arrayList.add(q.b(jsonReader, dVar, f10, j0Var, false));
                } else {
                    while (jsonReader.o()) {
                        arrayList.add(q.b(jsonReader, dVar, f10, j0Var, true));
                    }
                }
                jsonReader.i();
            } else {
                arrayList.add(q.b(jsonReader, dVar, f10, j0Var, false));
            }
        }
        jsonReader.n();
        b(arrayList);
        return arrayList;
    }

    public static <T> void b(List<? extends a<T>> list) {
        int i10;
        T t10;
        int size = list.size();
        int i11 = 0;
        while (true) {
            i10 = size - 1;
            if (i11 >= i10) {
                break;
            }
            a<T> aVar = list.get(i11);
            i11++;
            a<T> aVar2 = list.get(i11);
            aVar.f30408f = Float.valueOf(aVar2.f30407e);
            if (aVar.f30405c == null && (t10 = aVar2.f30404b) != null) {
                aVar.f30405c = t10;
                if (aVar instanceof h) {
                    ((h) aVar).i();
                }
            }
        }
        a<T> aVar3 = list.get(i10);
        if ((aVar3.f30404b == null || aVar3.f30405c == null) && list.size() > 1) {
            list.remove(aVar3);
        }
    }
}
