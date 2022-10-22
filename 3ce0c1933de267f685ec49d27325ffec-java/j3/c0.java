package j3;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import l3.d;
/* compiled from: ScaleXYParser.java */
/* loaded from: classes.dex */
public class c0 implements j0<d> {

    /* renamed from: a  reason: collision with root package name */
    public static final c0 f29397a = new c0();

    private c0() {
    }

    /* renamed from: b */
    public d a(JsonReader jsonReader, float f10) throws IOException {
        boolean z10 = jsonReader.I() == JsonReader.Token.BEGIN_ARRAY;
        if (z10) {
            jsonReader.d();
        }
        float u10 = (float) jsonReader.u();
        float u11 = (float) jsonReader.u();
        while (jsonReader.o()) {
            jsonReader.V();
        }
        if (z10) {
            jsonReader.i();
        }
        return new d((u10 / 100.0f) * f10, (u11 / 100.0f) * f10);
    }
}
