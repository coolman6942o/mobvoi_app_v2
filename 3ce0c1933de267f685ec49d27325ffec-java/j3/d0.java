package j3;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import g3.a;
import i3.g;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* compiled from: ShapeDataParser.java */
/* loaded from: classes.dex */
public class d0 implements j0<g> {

    /* renamed from: a  reason: collision with root package name */
    public static final d0 f29398a = new d0();

    /* renamed from: b  reason: collision with root package name */
    private static final JsonReader.a f29399b = JsonReader.a.a("c", "v", "i", "o");

    private d0() {
    }

    /* renamed from: b */
    public g a(JsonReader jsonReader, float f10) throws IOException {
        if (jsonReader.I() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.d();
        }
        jsonReader.h();
        List<PointF> list = null;
        List<PointF> list2 = null;
        List<PointF> list3 = null;
        boolean z10 = false;
        while (jsonReader.o()) {
            int Q = jsonReader.Q(f29399b);
            if (Q == 0) {
                z10 = jsonReader.q();
            } else if (Q == 1) {
                list = p.f(jsonReader, f10);
            } else if (Q == 2) {
                list2 = p.f(jsonReader, f10);
            } else if (Q != 3) {
                jsonReader.T();
                jsonReader.V();
            } else {
                list3 = p.f(jsonReader, f10);
            }
        }
        jsonReader.n();
        if (jsonReader.I() == JsonReader.Token.END_ARRAY) {
            jsonReader.i();
        }
        if (list == null || list2 == null || list3 == null) {
            throw new IllegalArgumentException("Shape data was missing information.");
        } else if (list.isEmpty()) {
            return new g(new PointF(), false, Collections.emptyList());
        } else {
            int size = list.size();
            PointF pointF = list.get(0);
            ArrayList arrayList = new ArrayList(size);
            for (int i10 = 1; i10 < size; i10++) {
                PointF pointF2 = list.get(i10);
                int i11 = i10 - 1;
                arrayList.add(new a(k3.g.a(list.get(i11), list3.get(i11)), k3.g.a(pointF2, list2.get(i10)), pointF2));
            }
            if (z10) {
                PointF pointF3 = list.get(0);
                int i12 = size - 1;
                arrayList.add(new a(k3.g.a(list.get(i12), list3.get(i12)), k3.g.a(pointF3, list2.get(0)), pointF3));
            }
            return new g(pointF, z10, arrayList);
        }
    }
}
