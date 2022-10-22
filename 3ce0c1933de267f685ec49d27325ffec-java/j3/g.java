package j3;

import com.airbnb.lottie.parser.moshi.JsonReader;
import com.huawei.hms.mlkit.common.ha.d;
import i3.b;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ContentModelParser.java */
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static JsonReader.a f29404a = JsonReader.a.a("ty", d.f14069a);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00b4, code lost:
        if (r2.equals("gf") == false) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static b a(JsonReader jsonReader, com.airbnb.lottie.d dVar) throws IOException {
        b bVar;
        String str;
        jsonReader.h();
        char c10 = 2;
        int i10 = 2;
        while (true) {
            bVar = null;
            if (!jsonReader.o()) {
                str = null;
                break;
            }
            int Q = jsonReader.Q(f29404a);
            if (Q == 0) {
                str = jsonReader.x();
                break;
            } else if (Q != 1) {
                jsonReader.T();
                jsonReader.V();
            } else {
                i10 = jsonReader.v();
            }
        }
        if (str == null) {
            return null;
        }
        c10 = 65535;
        switch (str.hashCode()) {
            case 3239:
                if (str.equals("el")) {
                    c10 = 0;
                    break;
                }
                break;
            case 3270:
                if (str.equals("fl")) {
                    c10 = 1;
                    break;
                }
                break;
            case 3295:
                break;
            case 3307:
                if (str.equals("gr")) {
                    c10 = 3;
                    break;
                }
                break;
            case 3308:
                if (str.equals("gs")) {
                    c10 = 4;
                    break;
                }
                break;
            case 3488:
                if (str.equals("mm")) {
                    c10 = 5;
                    break;
                }
                break;
            case 3633:
                if (str.equals("rc")) {
                    c10 = 6;
                    break;
                }
                break;
            case 3646:
                if (str.equals("rp")) {
                    c10 = 7;
                    break;
                }
                break;
            case 3669:
                if (str.equals("sh")) {
                    c10 = '\b';
                    break;
                }
                break;
            case 3679:
                if (str.equals("sr")) {
                    c10 = '\t';
                    break;
                }
                break;
            case 3681:
                if (str.equals("st")) {
                    c10 = '\n';
                    break;
                }
                break;
            case 3705:
                if (str.equals("tm")) {
                    c10 = 11;
                    break;
                }
                break;
            case 3710:
                if (str.equals("tr")) {
                    c10 = '\f';
                    break;
                }
                break;
        }
        switch (c10) {
            case 0:
                bVar = e.a(jsonReader, dVar, i10);
                break;
            case 1:
                bVar = e0.a(jsonReader, dVar);
                break;
            case 2:
                bVar = m.a(jsonReader, dVar);
                break;
            case 3:
                bVar = f0.a(jsonReader, dVar);
                break;
            case 4:
                bVar = n.a(jsonReader, dVar);
                break;
            case 5:
                bVar = v.a(jsonReader);
                dVar.a("Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove().");
                break;
            case 6:
                bVar = a0.a(jsonReader, dVar);
                break;
            case 7:
                bVar = b0.a(jsonReader, dVar);
                break;
            case '\b':
                bVar = g0.a(jsonReader, dVar);
                break;
            case '\t':
                bVar = z.a(jsonReader, dVar);
                break;
            case '\n':
                bVar = h0.a(jsonReader, dVar);
                break;
            case 11:
                bVar = i0.a(jsonReader, dVar);
                break;
            case '\f':
                bVar = c.g(jsonReader, dVar);
                break;
            default:
                k3.d.c("Unknown shape type " + str);
                break;
        }
        while (jsonReader.o()) {
            jsonReader.V();
        }
        jsonReader.n();
        return bVar;
    }
}
