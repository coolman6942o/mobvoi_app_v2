package j3;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
/* compiled from: FloatParser.java */
/* loaded from: classes.dex */
public class i implements j0<Float> {

    /* renamed from: a  reason: collision with root package name */
    public static final i f29410a = new i();

    private i() {
    }

    /* renamed from: b */
    public Float a(JsonReader jsonReader, float f10) throws IOException {
        return Float.valueOf(p.g(jsonReader) * f10);
    }
}
