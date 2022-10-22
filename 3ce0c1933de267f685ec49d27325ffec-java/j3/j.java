package j3;

import com.airbnb.lottie.d;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.mobvoi.wear.providers.OtaColumn;
import g3.c;
import i3.i;
import java.io.IOException;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FontCharacterParser.java */
/* loaded from: classes.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.a f29412a = JsonReader.a.a("ch", OtaColumn.COLUMN_SIZE, "w", "style", "fFamily", "data");

    /* renamed from: b  reason: collision with root package name */
    private static final JsonReader.a f29413b = JsonReader.a.a("shapes");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static c a(JsonReader jsonReader, d dVar) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.h();
        String str = null;
        double d10 = 0.0d;
        String str2 = null;
        double d11 = 0.0d;
        char c10 = 0;
        while (jsonReader.o()) {
            int Q = jsonReader.Q(f29412a);
            if (Q == 0) {
                c10 = jsonReader.x().charAt(0);
            } else if (Q == 1) {
                d10 = jsonReader.u();
            } else if (Q == 2) {
                d11 = jsonReader.u();
            } else if (Q == 3) {
                str = jsonReader.x();
            } else if (Q == 4) {
                str2 = jsonReader.x();
            } else if (Q != 5) {
                jsonReader.T();
                jsonReader.V();
            } else {
                jsonReader.h();
                while (jsonReader.o()) {
                    if (jsonReader.Q(f29413b) != 0) {
                        jsonReader.T();
                        jsonReader.V();
                    } else {
                        jsonReader.d();
                        while (jsonReader.o()) {
                            arrayList.add((i) g.a(jsonReader, dVar));
                        }
                        jsonReader.i();
                    }
                }
                jsonReader.n();
            }
        }
        jsonReader.n();
        return new c(arrayList, c10, d10, d11, str, str2);
    }
}
