package j3;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.huawei.hms.mlkit.common.ha.d;
import h3.f;
import h3.m;
import i3.a;
import java.io.IOException;
/* compiled from: CircleShapeParser.java */
/* loaded from: classes.dex */
class e {

    /* renamed from: a  reason: collision with root package name */
    private static JsonReader.a f29400a = JsonReader.a.a("nm", "p", "s", "hd", d.f14069a);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a a(JsonReader jsonReader, com.airbnb.lottie.d dVar, int i10) throws IOException {
        String str = null;
        boolean z10 = i10 == 3;
        boolean z11 = false;
        m<PointF, PointF> mVar = null;
        f fVar = null;
        while (jsonReader.o()) {
            int Q = jsonReader.Q(f29400a);
            if (Q == 0) {
                str = jsonReader.x();
            } else if (Q == 1) {
                mVar = a.b(jsonReader, dVar);
            } else if (Q == 2) {
                fVar = d.i(jsonReader, dVar);
            } else if (Q == 3) {
                z11 = jsonReader.q();
            } else if (Q != 4) {
                jsonReader.T();
                jsonReader.V();
            } else {
                z10 = jsonReader.v() == 3;
            }
        }
        return new a(str, mVar, fVar, z10, z11);
    }
}
