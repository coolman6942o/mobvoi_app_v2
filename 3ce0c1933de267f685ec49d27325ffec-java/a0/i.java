package a0;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import org.xmlpull.v1.XmlPullParser;
/* compiled from: TypedArrayUtils.java */
/* loaded from: classes.dex */
public class i {
    public static int a(Context context, int i10, int i11) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(i10, typedValue, true);
        return typedValue.resourceId != 0 ? i10 : i11;
    }

    public static boolean b(TypedArray typedArray, int i10, int i11, boolean z10) {
        return typedArray.getBoolean(i10, typedArray.getBoolean(i11, z10));
    }

    public static Drawable c(TypedArray typedArray, int i10, int i11) {
        Drawable drawable = typedArray.getDrawable(i10);
        return drawable == null ? typedArray.getDrawable(i11) : drawable;
    }

    public static int d(TypedArray typedArray, int i10, int i11, int i12) {
        return typedArray.getInt(i10, typedArray.getInt(i11, i12));
    }

    public static boolean e(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i10, boolean z10) {
        return !r(xmlPullParser, str) ? z10 : typedArray.getBoolean(i10, z10);
    }

    public static int f(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i10, int i11) {
        return !r(xmlPullParser, str) ? i11 : typedArray.getColor(i10, i11);
    }

    public static ColorStateList g(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i10) {
        if (!r(xmlPullParser, str)) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i10, typedValue);
        int i11 = typedValue.type;
        if (i11 == 2) {
            throw new UnsupportedOperationException("Failed to resolve attribute at index " + i10 + ": " + typedValue);
        } else if (i11 < 28 || i11 > 31) {
            return c.d(typedArray.getResources(), typedArray.getResourceId(i10, 0), theme);
        } else {
            return h(typedValue);
        }
    }

    private static ColorStateList h(TypedValue typedValue) {
        return ColorStateList.valueOf(typedValue.data);
    }

    public static d i(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i10, int i11) {
        if (r(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i10, typedValue);
            int i12 = typedValue.type;
            if (i12 >= 28 && i12 <= 31) {
                return d.b(typedValue.data);
            }
            d g10 = d.g(typedArray.getResources(), typedArray.getResourceId(i10, 0), theme);
            if (g10 != null) {
                return g10;
            }
        }
        return d.b(i11);
    }

    public static float j(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i10, float f10) {
        return !r(xmlPullParser, str) ? f10 : typedArray.getFloat(i10, f10);
    }

    public static int k(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i10, int i11) {
        return !r(xmlPullParser, str) ? i11 : typedArray.getInt(i10, i11);
    }

    public static int l(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i10, int i11) {
        return !r(xmlPullParser, str) ? i11 : typedArray.getResourceId(i10, i11);
    }

    public static String m(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i10) {
        if (!r(xmlPullParser, str)) {
            return null;
        }
        return typedArray.getString(i10);
    }

    public static int n(TypedArray typedArray, int i10, int i11, int i12) {
        return typedArray.getResourceId(i10, typedArray.getResourceId(i11, i12));
    }

    public static String o(TypedArray typedArray, int i10, int i11) {
        String string = typedArray.getString(i10);
        return string == null ? typedArray.getString(i11) : string;
    }

    public static CharSequence p(TypedArray typedArray, int i10, int i11) {
        CharSequence text = typedArray.getText(i10);
        return text == null ? typedArray.getText(i11) : text;
    }

    public static CharSequence[] q(TypedArray typedArray, int i10, int i11) {
        CharSequence[] textArray = typedArray.getTextArray(i10);
        return textArray == null ? typedArray.getTextArray(i11) : textArray;
    }

    public static boolean r(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }

    public static TypedArray s(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public static TypedValue t(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i10) {
        if (!r(xmlPullParser, str)) {
            return null;
        }
        return typedArray.peekValue(i10);
    }
}
