package e7;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;
/* compiled from: MatrixEvaluator.java */
/* loaded from: classes.dex */
public class g implements TypeEvaluator<Matrix> {

    /* renamed from: a  reason: collision with root package name */
    private final float[] f25843a = new float[9];

    /* renamed from: b  reason: collision with root package name */
    private final float[] f25844b = new float[9];

    /* renamed from: c  reason: collision with root package name */
    private final Matrix f25845c = new Matrix();

    public Matrix a(float f10, Matrix matrix, Matrix matrix2) {
        matrix.getValues(this.f25843a);
        matrix2.getValues(this.f25844b);
        for (int i10 = 0; i10 < 9; i10++) {
            float[] fArr = this.f25844b;
            float f11 = fArr[i10];
            float[] fArr2 = this.f25843a;
            fArr[i10] = fArr2[i10] + ((f11 - fArr2[i10]) * f10);
        }
        this.f25845c.setValues(this.f25844b);
        return this.f25845c;
    }
}
