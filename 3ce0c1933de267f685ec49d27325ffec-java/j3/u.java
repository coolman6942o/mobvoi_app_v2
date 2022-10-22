package j3;

import com.airbnb.lottie.d;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.parser.moshi.JsonReader;
import h3.h;
import java.io.IOException;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MaskParser.java */
/* loaded from: classes.dex */
public class u {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006a, code lost:
        if (r1.equals("s") == false) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Mask a(JsonReader jsonReader, d dVar) throws IOException {
        boolean z10;
        jsonReader.h();
        Mask.MaskMode maskMode = null;
        boolean z11 = false;
        h hVar = null;
        h3.d dVar2 = null;
        while (jsonReader.o()) {
            String w10 = jsonReader.w();
            w10.hashCode();
            char c10 = 3;
            switch (w10.hashCode()) {
                case 111:
                    if (w10.equals("o")) {
                        z10 = false;
                        break;
                    }
                    z10 = true;
                    break;
                case 3588:
                    if (w10.equals("pt")) {
                        z10 = true;
                        break;
                    }
                    z10 = true;
                    break;
                case 104433:
                    if (w10.equals("inv")) {
                        z10 = true;
                        break;
                    }
                    z10 = true;
                    break;
                case 3357091:
                    if (w10.equals("mode")) {
                        z10 = true;
                        break;
                    }
                    z10 = true;
                    break;
                default:
                    z10 = true;
                    break;
            }
            switch (z10) {
                case false:
                    dVar2 = d.h(jsonReader, dVar);
                    break;
                case true:
                    hVar = d.k(jsonReader, dVar);
                    break;
                case true:
                    z11 = jsonReader.q();
                    break;
                case true:
                    String x10 = jsonReader.x();
                    x10.hashCode();
                    switch (x10.hashCode()) {
                        case 97:
                            if (x10.equals("a")) {
                                c10 = 0;
                                break;
                            }
                            c10 = 65535;
                            break;
                        case 105:
                            if (x10.equals("i")) {
                                c10 = 1;
                                break;
                            }
                            c10 = 65535;
                            break;
                        case 110:
                            if (x10.equals("n")) {
                                c10 = 2;
                                break;
                            }
                            c10 = 65535;
                            break;
                        case 115:
                            break;
                        default:
                            c10 = 65535;
                            break;
                    }
                    switch (c10) {
                        case 0:
                            maskMode = Mask.MaskMode.MASK_MODE_ADD;
                            continue;
                        case 1:
                            dVar.a("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                            maskMode = Mask.MaskMode.MASK_MODE_INTERSECT;
                            continue;
                        case 2:
                            maskMode = Mask.MaskMode.MASK_MODE_NONE;
                            continue;
                        case 3:
                            maskMode = Mask.MaskMode.MASK_MODE_SUBTRACT;
                            continue;
                        default:
                            k3.d.c("Unknown mask mode " + w10 + ". Defaulting to Add.");
                            maskMode = Mask.MaskMode.MASK_MODE_ADD;
                            continue;
                    }
                default:
                    jsonReader.V();
                    break;
            }
        }
        jsonReader.n();
        return new Mask(maskMode, hVar, dVar2, z11);
    }
}
