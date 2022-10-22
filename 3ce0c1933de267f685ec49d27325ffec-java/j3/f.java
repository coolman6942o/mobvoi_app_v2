package j3;

import android.graphics.Color;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
/* compiled from: ColorParser.java */
/* loaded from: classes.dex */
public class f implements j0<Integer> {

    /* renamed from: a  reason: collision with root package name */
    public static final f f29402a = new f();

    private f() {
    }

    /* renamed from: b */
    public Integer a(JsonReader jsonReader, float f10) throws IOException {
        boolean z10 = jsonReader.I() == JsonReader.Token.BEGIN_ARRAY;
        if (z10) {
            jsonReader.d();
        }
        double u10 = jsonReader.u();
        double u11 = jsonReader.u();
        double u12 = jsonReader.u();
        double u13 = jsonReader.u();
        if (z10) {
            jsonReader.i();
        }
        if (u10 <= 1.0d && u11 <= 1.0d && u12 <= 1.0d) {
            u10 *= 255.0d;
            u11 *= 255.0d;
            u12 *= 255.0d;
            if (u13 <= 1.0d) {
                u13 *= 255.0d;
            }
        }
        return Integer.valueOf(Color.argb((int) u13, (int) u10, (int) u11, (int) u12));
    }
}
