package j3;

import android.graphics.Color;
import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* compiled from: JsonUtils.java */
/* loaded from: classes.dex */
class p {

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.a f29422a = JsonReader.a.a("x", "y");

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: JsonUtils.java */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f29423a;

        static {
            int[] iArr = new int[JsonReader.Token.values().length];
            f29423a = iArr;
            try {
                iArr[JsonReader.Token.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f29423a[JsonReader.Token.BEGIN_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f29423a[JsonReader.Token.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static PointF a(JsonReader jsonReader, float f10) throws IOException {
        jsonReader.d();
        float u10 = (float) jsonReader.u();
        float u11 = (float) jsonReader.u();
        while (jsonReader.I() != JsonReader.Token.END_ARRAY) {
            jsonReader.V();
        }
        jsonReader.i();
        return new PointF(u10 * f10, u11 * f10);
    }

    private static PointF b(JsonReader jsonReader, float f10) throws IOException {
        float u10 = (float) jsonReader.u();
        float u11 = (float) jsonReader.u();
        while (jsonReader.o()) {
            jsonReader.V();
        }
        return new PointF(u10 * f10, u11 * f10);
    }

    private static PointF c(JsonReader jsonReader, float f10) throws IOException {
        jsonReader.h();
        float f11 = 0.0f;
        float f12 = 0.0f;
        while (jsonReader.o()) {
            int Q = jsonReader.Q(f29422a);
            if (Q == 0) {
                f11 = g(jsonReader);
            } else if (Q != 1) {
                jsonReader.T();
                jsonReader.V();
            } else {
                f12 = g(jsonReader);
            }
        }
        jsonReader.n();
        return new PointF(f11 * f10, f12 * f10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(JsonReader jsonReader) throws IOException {
        jsonReader.d();
        int u10 = (int) (jsonReader.u() * 255.0d);
        int u11 = (int) (jsonReader.u() * 255.0d);
        int u12 = (int) (jsonReader.u() * 255.0d);
        while (jsonReader.o()) {
            jsonReader.V();
        }
        jsonReader.i();
        return Color.argb(255, u10, u11, u12);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static PointF e(JsonReader jsonReader, float f10) throws IOException {
        int i10 = a.f29423a[jsonReader.I().ordinal()];
        if (i10 == 1) {
            return b(jsonReader, f10);
        }
        if (i10 == 2) {
            return a(jsonReader, f10);
        }
        if (i10 == 3) {
            return c(jsonReader, f10);
        }
        throw new IllegalArgumentException("Unknown point starts with " + jsonReader.I());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<PointF> f(JsonReader jsonReader, float f10) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.d();
        while (jsonReader.I() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.d();
            arrayList.add(e(jsonReader, f10));
            jsonReader.i();
        }
        jsonReader.i();
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float g(JsonReader jsonReader) throws IOException {
        JsonReader.Token I = jsonReader.I();
        int i10 = a.f29423a[I.ordinal()];
        if (i10 == 1) {
            return (float) jsonReader.u();
        }
        if (i10 == 2) {
            jsonReader.d();
            float u10 = (float) jsonReader.u();
            while (jsonReader.o()) {
                jsonReader.V();
            }
            jsonReader.i();
            return u10;
        }
        throw new IllegalArgumentException("Unknown value for token of type " + I);
    }
}
