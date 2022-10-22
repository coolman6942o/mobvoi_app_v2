package j3;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
/* compiled from: IntegerParser.java */
/* loaded from: classes.dex */
public class o implements j0<Integer> {

    /* renamed from: a  reason: collision with root package name */
    public static final o f29421a = new o();

    private o() {
    }

    /* renamed from: b */
    public Integer a(JsonReader jsonReader, float f10) throws IOException {
        return Integer.valueOf(Math.round(p.g(jsonReader) * f10));
    }
}
