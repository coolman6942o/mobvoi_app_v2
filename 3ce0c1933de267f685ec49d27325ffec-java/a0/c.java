package a0;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.util.TypedValue;
import android.util.Xml;
import g0.a;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: ColorStateListInflaterCompat.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<TypedValue> f33a = new ThreadLocal<>();

    public static ColorStateList a(Resources resources, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next == 2) {
            return b(resources, xmlPullParser, asAttributeSet, theme);
        }
        throw new XmlPullParserException("No start tag found");
    }

    public static ColorStateList b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        String name = xmlPullParser.getName();
        if (name.equals("selector")) {
            return e(resources, xmlPullParser, attributeSet, theme);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
    }

    private static TypedValue c() {
        ThreadLocal<TypedValue> threadLocal = f33a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    public static ColorStateList d(Resources resources, int i10, Resources.Theme theme) {
        try {
            return a(resources, resources.getXml(i10), theme);
        } catch (Exception e10) {
            Log.e("CSLCompat", "Failed to inflate ColorStateList.", e10);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static ColorStateList e(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth;
        int i10;
        float f10;
        int attributeCount;
        int i11;
        Resources resources2 = resources;
        int i12 = 1;
        int depth2 = xmlPullParser.getDepth() + 1;
        int[][] iArr = new int[20];
        int[] iArr2 = new int[20];
        int i13 = 0;
        while (true) {
            int next = xmlPullParser.next();
            if (next == i12 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                TypedArray h10 = h(resources2, theme, attributeSet, z.c.f37182a);
                int i14 = z.c.f37183b;
                int resourceId = h10.getResourceId(i14, -1);
                if (resourceId == -1 || f(resources2, resourceId)) {
                    i10 = h10.getColor(i14, -65281);
                } else {
                    try {
                        i10 = a(resources2, resources2.getXml(resourceId), theme).getDefaultColor();
                    } catch (Exception unused) {
                        i10 = h10.getColor(z.c.f37183b, -65281);
                    }
                }
                float f11 = 1.0f;
                int i15 = z.c.f37184c;
                if (h10.hasValue(i15)) {
                    f11 = h10.getFloat(i15, 1.0f);
                } else {
                    int i16 = z.c.f37186e;
                    if (h10.hasValue(i16)) {
                        f11 = h10.getFloat(i16, 1.0f);
                    }
                }
                if (a.c()) {
                    int i17 = z.c.f37185d;
                    if (h10.hasValue(i17)) {
                        f10 = h10.getFloat(i17, -1.0f);
                        h10.recycle();
                        attributeCount = attributeSet.getAttributeCount();
                        int[] iArr3 = new int[attributeCount];
                        int i18 = 0;
                        for (i11 = 0; i11 < attributeCount; i11++) {
                            int attributeNameResource = attributeSet.getAttributeNameResource(i11);
                            if (!(attributeNameResource == 16843173 || attributeNameResource == 16843551 || attributeNameResource == z.a.f37153a || attributeNameResource == z.a.f37154b)) {
                                i18++;
                                if (!attributeSet.getAttributeBooleanValue(i11, false)) {
                                    attributeNameResource = -attributeNameResource;
                                }
                                iArr3[i18] = attributeNameResource;
                            }
                        }
                        int[] trimStateSet = StateSet.trimStateSet(iArr3, i18);
                        iArr2 = g.a(iArr2, i13, g(i10, f11, f10));
                        iArr = (int[][]) g.b(iArr, i13, trimStateSet);
                        i13++;
                    }
                }
                f10 = h10.getFloat(z.c.f37187f, -1.0f);
                h10.recycle();
                attributeCount = attributeSet.getAttributeCount();
                int[] iArr32 = new int[attributeCount];
                int i182 = 0;
                while (i11 < attributeCount) {
                }
                int[] trimStateSet2 = StateSet.trimStateSet(iArr32, i182);
                iArr2 = g.a(iArr2, i13, g(i10, f11, f10));
                iArr = (int[][]) g.b(iArr, i13, trimStateSet2);
                i13++;
            }
            i12 = 1;
            resources2 = resources;
        }
        int[] iArr4 = new int[i13];
        int[][] iArr5 = new int[i13];
        System.arraycopy(iArr2, 0, iArr4, 0, i13);
        System.arraycopy(iArr, 0, iArr5, 0, i13);
        return new ColorStateList(iArr5, iArr4);
    }

    private static boolean f(Resources resources, int i10) {
        TypedValue c10 = c();
        resources.getValue(i10, c10, true);
        int i11 = c10.type;
        return i11 >= 28 && i11 <= 31;
    }

    private static int g(int i10, float f10, float f11) {
        boolean z10 = f11 >= 0.0f && f11 <= 100.0f;
        if (f10 == 1.0f && !z10) {
            return i10;
        }
        int b10 = e0.a.b((int) ((Color.alpha(i10) * f10) + 0.5f), 0, 255);
        if (z10) {
            a c10 = a.c(i10);
            i10 = a.m(c10.j(), c10.i(), f11);
        }
        return (i10 & 16777215) | (b10 << 24);
    }

    private static TypedArray h(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }
}
