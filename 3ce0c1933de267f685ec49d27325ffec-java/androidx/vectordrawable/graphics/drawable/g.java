package androidx.vectordrawable.graphics.drawable;

import a0.i;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import b0.d;
import com.amap.api.services.core.AMapException;
import org.xmlpull.v1.XmlPullParser;
/* compiled from: PathInterpolatorCompat.java */
/* loaded from: classes.dex */
public class g implements Interpolator {

    /* renamed from: a  reason: collision with root package name */
    private float[] f4465a;

    /* renamed from: b  reason: collision with root package name */
    private float[] f4466b;

    public g(Context context, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        this(context.getResources(), context.getTheme(), attributeSet, xmlPullParser);
    }

    private void a(float f10, float f11, float f12, float f13) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f10, f11, f12, f13, 1.0f, 1.0f);
        b(path);
    }

    private void b(Path path) {
        int i10 = 0;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int min = Math.min((int) AMapException.CODE_AMAP_ROUTE_OUT_OF_SERVICE, ((int) (length / 0.002f)) + 1);
        if (min > 0) {
            this.f4465a = new float[min];
            this.f4466b = new float[min];
            float[] fArr = new float[2];
            for (int i11 = 0; i11 < min; i11++) {
                pathMeasure.getPosTan((i11 * length) / (min - 1), fArr, null);
                this.f4465a[i11] = fArr[0];
                this.f4466b[i11] = fArr[1];
            }
            if (Math.abs(this.f4465a[0]) <= 1.0E-5d && Math.abs(this.f4466b[0]) <= 1.0E-5d) {
                int i12 = min - 1;
                if (Math.abs(this.f4465a[i12] - 1.0f) <= 1.0E-5d && Math.abs(this.f4466b[i12] - 1.0f) <= 1.0E-5d) {
                    float f10 = 0.0f;
                    int i13 = 0;
                    while (i10 < min) {
                        float[] fArr2 = this.f4465a;
                        i13++;
                        float f11 = fArr2[i13];
                        if (f11 >= f10) {
                            fArr2[i10] = f11;
                            i10++;
                            f10 = f11;
                        } else {
                            throw new IllegalArgumentException("The Path cannot loop back on itself, x :" + f11);
                        }
                    }
                    if (pathMeasure.nextContour()) {
                        throw new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
                    }
                    return;
                }
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("The Path must start at (0,0) and end at (1,1) start: ");
            sb2.append(this.f4465a[0]);
            sb2.append(",");
            sb2.append(this.f4466b[0]);
            sb2.append(" end:");
            int i14 = min - 1;
            sb2.append(this.f4465a[i14]);
            sb2.append(",");
            sb2.append(this.f4466b[i14]);
            throw new IllegalArgumentException(sb2.toString());
        }
        throw new IllegalArgumentException("The Path has a invalid length " + length);
    }

    private void c(float f10, float f11) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f10, f11, 1.0f, 1.0f);
        b(path);
    }

    private void d(TypedArray typedArray, XmlPullParser xmlPullParser) {
        if (i.r(xmlPullParser, "pathData")) {
            String m10 = i.m(typedArray, xmlPullParser, "pathData", 4);
            Path e10 = d.e(m10);
            if (e10 != null) {
                b(e10);
                return;
            }
            throw new InflateException("The path is null, which is created from " + m10);
        } else if (!i.r(xmlPullParser, "controlX1")) {
            throw new InflateException("pathInterpolator requires the controlX1 attribute");
        } else if (i.r(xmlPullParser, "controlY1")) {
            float j10 = i.j(typedArray, xmlPullParser, "controlX1", 0, 0.0f);
            float j11 = i.j(typedArray, xmlPullParser, "controlY1", 1, 0.0f);
            boolean r10 = i.r(xmlPullParser, "controlX2");
            if (r10 != i.r(xmlPullParser, "controlY2")) {
                throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
            } else if (!r10) {
                c(j10, j11);
            } else {
                a(j10, j11, i.j(typedArray, xmlPullParser, "controlX2", 2, 0.0f), i.j(typedArray, xmlPullParser, "controlY2", 3, 0.0f));
            }
        } else {
            throw new InflateException("pathInterpolator requires the controlY1 attribute");
        }
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f10) {
        if (f10 <= 0.0f) {
            return 0.0f;
        }
        if (f10 >= 1.0f) {
            return 1.0f;
        }
        int i10 = 0;
        int length = this.f4465a.length - 1;
        while (length - i10 > 1) {
            int i11 = (i10 + length) / 2;
            if (f10 < this.f4465a[i11]) {
                length = i11;
            } else {
                i10 = i11;
            }
        }
        float[] fArr = this.f4465a;
        float f11 = fArr[length] - fArr[i10];
        if (f11 == 0.0f) {
            return this.f4466b[i10];
        }
        float[] fArr2 = this.f4466b;
        float f12 = fArr2[i10];
        return f12 + (((f10 - fArr[i10]) / f11) * (fArr2[length] - f12));
    }

    public g(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray s10 = i.s(resources, theme, attributeSet, a.f4451l);
        d(s10, xmlPullParser);
        s10.recycle();
    }
}
