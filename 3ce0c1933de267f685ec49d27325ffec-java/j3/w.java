package j3;

import com.airbnb.lottie.d;
import com.airbnb.lottie.parser.moshi.JsonReader;
import e3.h;
import java.io.IOException;
/* compiled from: PathKeyframeParser.java */
/* loaded from: classes.dex */
class w {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static h a(JsonReader jsonReader, d dVar) throws IOException {
        return new h(dVar, q.b(jsonReader, dVar, k3.h.e(), x.f29436a, jsonReader.I() == JsonReader.Token.BEGIN_OBJECT));
    }
}
