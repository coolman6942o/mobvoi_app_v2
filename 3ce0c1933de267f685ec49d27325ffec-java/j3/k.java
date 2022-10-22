package j3;

import com.airbnb.lottie.parser.moshi.JsonReader;
import g3.b;
import java.io.IOException;
/* compiled from: FontParser.java */
/* loaded from: classes.dex */
class k {

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.a f29414a = JsonReader.a.a("fFamily", "fName", "fStyle", "ascent");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static b a(JsonReader jsonReader) throws IOException {
        jsonReader.h();
        String str = null;
        float f10 = 0.0f;
        String str2 = null;
        String str3 = null;
        while (jsonReader.o()) {
            int Q = jsonReader.Q(f29414a);
            if (Q == 0) {
                str = jsonReader.x();
            } else if (Q == 1) {
                str3 = jsonReader.x();
            } else if (Q == 2) {
                str2 = jsonReader.x();
            } else if (Q != 3) {
                jsonReader.T();
                jsonReader.V();
            } else {
                f10 = (float) jsonReader.u();
            }
        }
        jsonReader.n();
        return new b(str, str3, str2, f10);
    }
}
