package j3;

import com.airbnb.lottie.model.DocumentData;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
/* compiled from: DocumentDataParser.java */
/* loaded from: classes.dex */
public class h implements j0<DocumentData> {

    /* renamed from: a  reason: collision with root package name */
    public static final h f29406a = new h();

    /* renamed from: b  reason: collision with root package name */
    private static final JsonReader.a f29407b = JsonReader.a.a("t", "f", "s", "j", "tr", "lh", "ls", "fc", "sc", "sw", "of");

    private h() {
    }

    /* renamed from: b */
    public DocumentData a(JsonReader jsonReader, float f10) throws IOException {
        DocumentData.Justification justification = DocumentData.Justification.CENTER;
        jsonReader.h();
        String str = null;
        int i10 = 0;
        float f11 = 0.0f;
        boolean z10 = true;
        DocumentData.Justification justification2 = justification;
        String str2 = null;
        int i11 = 0;
        int i12 = 0;
        float f12 = 0.0f;
        float f13 = 0.0f;
        float f14 = 0.0f;
        while (jsonReader.o()) {
            switch (jsonReader.Q(f29407b)) {
                case 0:
                    str = jsonReader.x();
                    break;
                case 1:
                    str2 = jsonReader.x();
                    break;
                case 2:
                    f11 = (float) jsonReader.u();
                    break;
                case 3:
                    int v10 = jsonReader.v();
                    justification2 = DocumentData.Justification.CENTER;
                    if (v10 <= justification2.ordinal() && v10 >= 0) {
                        justification2 = DocumentData.Justification.values()[v10];
                        break;
                    }
                    break;
                case 4:
                    i10 = jsonReader.v();
                    break;
                case 5:
                    f12 = (float) jsonReader.u();
                    break;
                case 6:
                    f13 = (float) jsonReader.u();
                    break;
                case 7:
                    i11 = p.d(jsonReader);
                    break;
                case 8:
                    i12 = p.d(jsonReader);
                    break;
                case 9:
                    f14 = (float) jsonReader.u();
                    break;
                case 10:
                    z10 = jsonReader.q();
                    break;
                default:
                    jsonReader.T();
                    jsonReader.V();
                    break;
            }
        }
        jsonReader.n();
        return new DocumentData(str, str2, f11, justification2, i10, f12, f13, i11, i12, f14, z10);
    }
}
