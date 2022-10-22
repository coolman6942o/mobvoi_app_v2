package j3;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
/* compiled from: PointFParser.java */
/* loaded from: classes.dex */
public class y implements j0<PointF> {

    /* renamed from: a  reason: collision with root package name */
    public static final y f29437a = new y();

    private y() {
    }

    /* renamed from: b */
    public PointF a(JsonReader jsonReader, float f10) throws IOException {
        JsonReader.Token I = jsonReader.I();
        if (I == JsonReader.Token.BEGIN_ARRAY) {
            return p.e(jsonReader, f10);
        }
        if (I == JsonReader.Token.BEGIN_OBJECT) {
            return p.e(jsonReader, f10);
        }
        if (I == JsonReader.Token.NUMBER) {
            PointF pointF = new PointF(((float) jsonReader.u()) * f10, ((float) jsonReader.u()) * f10);
            while (jsonReader.o()) {
                jsonReader.V();
            }
            return pointF;
        }
        throw new IllegalArgumentException("Cannot convert json to point. Next token is " + I);
    }
}
