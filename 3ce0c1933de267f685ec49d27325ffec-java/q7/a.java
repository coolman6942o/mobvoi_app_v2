package q7;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.TypedValue;
import b0.d;
import t7.b;
/* compiled from: MotionUtils.java */
/* loaded from: classes.dex */
public class a {
    private static float a(String[] strArr, int i10) {
        float parseFloat = Float.parseFloat(strArr[i10]);
        if (parseFloat >= 0.0f && parseFloat <= 1.0f) {
            return parseFloat;
        }
        throw new IllegalArgumentException("Motion easing control point value must be between 0 and 1; instead got: " + parseFloat);
    }

    private static String b(String str, String str2) {
        return str.substring(str2.length() + 1, str.length() - 1);
    }

    private static boolean c(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        sb2.append("(");
        return str.startsWith(sb2.toString()) && str.endsWith(")");
    }

    public static int d(Context context, int i10, int i11) {
        return b.c(context, i10, i11);
    }

    public static TimeInterpolator e(Context context, int i10, TimeInterpolator timeInterpolator) {
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i10, typedValue, true)) {
            return timeInterpolator;
        }
        if (typedValue.type == 3) {
            String valueOf = String.valueOf(typedValue.string);
            if (c(valueOf, "cubic-bezier")) {
                String[] split = b(valueOf, "cubic-bezier").split(",");
                if (split.length == 4) {
                    return l0.b.a(a(split, 0), a(split, 1), a(split, 2), a(split, 3));
                }
                throw new IllegalArgumentException("Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: " + split.length);
            } else if (c(valueOf, "path")) {
                return l0.b.b(d.e(b(valueOf, "path")));
            } else {
                throw new IllegalArgumentException("Invalid motion easing type: " + valueOf);
            }
        } else {
            throw new IllegalArgumentException("Motion easing theme attribute must be a string");
        }
    }
}
