package j3;

import android.graphics.Color;
import com.airbnb.lottie.parser.moshi.JsonReader;
import i3.c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import k3.g;
/* compiled from: GradientColorParser.java */
/* loaded from: classes.dex */
public class l implements j0<c> {

    /* renamed from: a  reason: collision with root package name */
    private int f29415a;

    public l(int i10) {
        this.f29415a = i10;
    }

    private void b(c cVar, List<Float> list) {
        int i10 = this.f29415a * 4;
        if (list.size() > i10) {
            int size = (list.size() - i10) / 2;
            double[] dArr = new double[size];
            double[] dArr2 = new double[size];
            int i11 = 0;
            while (i10 < list.size()) {
                if (i10 % 2 == 0) {
                    dArr[i11] = list.get(i10).floatValue();
                } else {
                    dArr2[i11] = list.get(i10).floatValue();
                    i11++;
                }
                i10++;
            }
            for (int i12 = 0; i12 < cVar.c(); i12++) {
                int i13 = cVar.a()[i12];
                cVar.a()[i12] = Color.argb(c(cVar.b()[i12], dArr, dArr2), Color.red(i13), Color.green(i13), Color.blue(i13));
            }
        }
    }

    private int c(double d10, double[] dArr, double[] dArr2) {
        double d11;
        int i10 = 1;
        while (true) {
            if (i10 >= dArr.length) {
                d11 = dArr2[dArr2.length - 1];
                break;
            }
            int i11 = i10 - 1;
            double d12 = dArr[i11];
            double d13 = dArr[i10];
            if (dArr[i10] >= d10) {
                d11 = g.i(dArr2[i11], dArr2[i10], (d10 - d12) / (d13 - d12));
                break;
            }
            i10++;
        }
        return (int) (d11 * 255.0d);
    }

    /* renamed from: d */
    public c a(JsonReader jsonReader, float f10) throws IOException {
        ArrayList arrayList = new ArrayList();
        boolean z10 = jsonReader.I() == JsonReader.Token.BEGIN_ARRAY;
        if (z10) {
            jsonReader.d();
        }
        while (jsonReader.o()) {
            arrayList.add(Float.valueOf((float) jsonReader.u()));
        }
        if (z10) {
            jsonReader.i();
        }
        if (this.f29415a == -1) {
            this.f29415a = arrayList.size() / 4;
        }
        int i10 = this.f29415a;
        float[] fArr = new float[i10];
        int[] iArr = new int[i10];
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < this.f29415a * 4; i13++) {
            int i14 = i13 / 4;
            double floatValue = arrayList.get(i13).floatValue();
            int i15 = i13 % 4;
            if (i15 == 0) {
                fArr[i14] = (float) floatValue;
            } else if (i15 == 1) {
                i11 = (int) (floatValue * 255.0d);
            } else if (i15 == 2) {
                i12 = (int) (floatValue * 255.0d);
            } else if (i15 == 3) {
                iArr[i14] = Color.argb(255, i11, i12, (int) (floatValue * 255.0d));
            }
        }
        c cVar = new c(fArr, iArr);
        b(cVar, arrayList);
        return cVar;
    }
}
