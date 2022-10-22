package j3;

import com.airbnb.lottie.model.content.MergePaths;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
/* compiled from: MergePathsParser.java */
/* loaded from: classes.dex */
class v {

    /* renamed from: a  reason: collision with root package name */
    private static final JsonReader.a f29435a = JsonReader.a.a("nm", "mm", "hd");

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MergePaths a(JsonReader jsonReader) throws IOException {
        String str = null;
        boolean z10 = false;
        MergePaths.MergePathsMode mergePathsMode = null;
        while (jsonReader.o()) {
            int Q = jsonReader.Q(f29435a);
            if (Q == 0) {
                str = jsonReader.x();
            } else if (Q == 1) {
                mergePathsMode = MergePaths.MergePathsMode.forId(jsonReader.v());
            } else if (Q != 2) {
                jsonReader.T();
                jsonReader.V();
            } else {
                z10 = jsonReader.q();
            }
        }
        return new MergePaths(str, mergePathsMode, z10);
    }
}
