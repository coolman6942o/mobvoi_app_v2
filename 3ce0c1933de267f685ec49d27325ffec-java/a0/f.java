package a0;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import com.unionpay.tsmservice.mi.data.Constant;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import z.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GradientColorInflaterCompat.java */
/* loaded from: classes.dex */
public final class f {
    private static a a(a aVar, int i10, int i11, boolean z10, int i12) {
        if (aVar != null) {
            return aVar;
        }
        if (z10) {
            return new a(i10, i12, i11);
        }
        return new a(i10, i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Shader b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws IOException, XmlPullParserException {
        String name = xmlPullParser.getName();
        if (name.equals("gradient")) {
            TypedArray s10 = i.s(resources, theme, attributeSet, c.f37207z);
            float j10 = i.j(s10, xmlPullParser, Constant.KEY_STARTPOSITION_X, c.I, 0.0f);
            float j11 = i.j(s10, xmlPullParser, Constant.KEY_STARTPOSITION_Y, c.J, 0.0f);
            float j12 = i.j(s10, xmlPullParser, "endX", c.K, 0.0f);
            float j13 = i.j(s10, xmlPullParser, "endY", c.L, 0.0f);
            float j14 = i.j(s10, xmlPullParser, "centerX", c.D, 0.0f);
            float j15 = i.j(s10, xmlPullParser, "centerY", c.E, 0.0f);
            int k10 = i.k(s10, xmlPullParser, "type", c.C, 0);
            int f10 = i.f(s10, xmlPullParser, "startColor", c.A, 0);
            boolean r10 = i.r(xmlPullParser, "centerColor");
            int f11 = i.f(s10, xmlPullParser, "centerColor", c.H, 0);
            int f12 = i.f(s10, xmlPullParser, "endColor", c.B, 0);
            int k11 = i.k(s10, xmlPullParser, "tileMode", c.G, 0);
            float j16 = i.j(s10, xmlPullParser, "gradientRadius", c.F, 0.0f);
            s10.recycle();
            a a10 = a(c(resources, xmlPullParser, attributeSet, theme), f10, f12, r10, f11);
            if (k10 != 1) {
                if (k10 != 2) {
                    return new LinearGradient(j10, j11, j12, j13, a10.f48a, a10.f49b, d(k11));
                }
                return new SweepGradient(j14, j15, a10.f48a, a10.f49b);
            } else if (j16 > 0.0f) {
                return new RadialGradient(j14, j15, j16, a10.f48a, a10.f49b, d(k11));
            } else {
                throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
            }
        } else {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid gradient color tag " + name);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0080, code lost:
        throw new org.xmlpull.v1.XmlPullParserException(r10.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static a c(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth;
        int depth2 = xmlPullParser.getDepth() + 1;
        ArrayList arrayList = new ArrayList(20);
        ArrayList arrayList2 = new ArrayList(20);
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                break;
            } else if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                TypedArray s10 = i.s(resources, theme, attributeSet, c.M);
                int i10 = c.N;
                boolean hasValue = s10.hasValue(i10);
                int i11 = c.O;
                boolean hasValue2 = s10.hasValue(i11);
                if (!hasValue || !hasValue2) {
                    break;
                }
                int color = s10.getColor(i10, 0);
                float f10 = s10.getFloat(i11, 0.0f);
                s10.recycle();
                arrayList2.add(Integer.valueOf(color));
                arrayList.add(Float.valueOf(f10));
            }
        }
        if (arrayList2.size() > 0) {
            return new a(arrayList2, arrayList);
        }
        return null;
    }

    private static Shader.TileMode d(int i10) {
        if (i10 == 1) {
            return Shader.TileMode.REPEAT;
        }
        if (i10 != 2) {
            return Shader.TileMode.CLAMP;
        }
        return Shader.TileMode.MIRROR;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GradientColorInflaterCompat.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        final int[] f48a;

        /* renamed from: b  reason: collision with root package name */
        final float[] f49b;

        a(List<Integer> list, List<Float> list2) {
            int size = list.size();
            this.f48a = new int[size];
            this.f49b = new float[size];
            for (int i10 = 0; i10 < size; i10++) {
                this.f48a[i10] = list.get(i10).intValue();
                this.f49b[i10] = list2.get(i10).floatValue();
            }
        }

        a(int i10, int i11) {
            this.f48a = new int[]{i10, i11};
            this.f49b = new float[]{0.0f, 1.0f};
        }

        a(int i10, int i11, int i12) {
            this.f48a = new int[]{i10, i11, i12};
            this.f49b = new float[]{0.0f, 0.5f, 1.0f};
        }
    }
}
