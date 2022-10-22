package u7;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.util.StateSet;
import b0.a;
/* compiled from: RippleUtils.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f35338a;

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f35339b;

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f35340c;

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f35341d;

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f35342e;

    /* renamed from: f  reason: collision with root package name */
    private static final int[] f35343f;

    /* renamed from: g  reason: collision with root package name */
    private static final int[] f35344g;

    /* renamed from: h  reason: collision with root package name */
    private static final int[] f35345h;

    /* renamed from: i  reason: collision with root package name */
    private static final int[] f35346i;

    /* renamed from: j  reason: collision with root package name */
    private static final int[] f35347j;

    /* renamed from: k  reason: collision with root package name */
    private static final int[] f35348k;

    /* renamed from: l  reason: collision with root package name */
    static final String f35349l;

    static {
        f35338a = Build.VERSION.SDK_INT >= 21;
        f35339b = new int[]{16842919};
        f35340c = new int[]{16843623, 16842908};
        f35341d = new int[]{16842908};
        f35342e = new int[]{16843623};
        f35343f = new int[]{16842913, 16842919};
        f35344g = new int[]{16842913, 16843623, 16842908};
        f35345h = new int[]{16842913, 16842908};
        f35346i = new int[]{16842913, 16843623};
        f35347j = new int[]{16842913};
        f35348k = new int[]{16842910, 16842919};
        f35349l = b.class.getSimpleName();
    }

    private b() {
    }

    public static ColorStateList a(ColorStateList colorStateList) {
        if (f35338a) {
            return new ColorStateList(new int[][]{f35347j, StateSet.NOTHING}, new int[]{c(colorStateList, f35343f), c(colorStateList, f35339b)});
        }
        int[] iArr = f35343f;
        int[] iArr2 = f35344g;
        int[] iArr3 = f35345h;
        int[] iArr4 = f35346i;
        int[] iArr5 = f35339b;
        int[] iArr6 = f35340c;
        int[] iArr7 = f35341d;
        int[] iArr8 = f35342e;
        return new ColorStateList(new int[][]{iArr, iArr2, iArr3, iArr4, f35347j, iArr5, iArr6, iArr7, iArr8, StateSet.NOTHING}, new int[]{c(colorStateList, iArr), c(colorStateList, iArr2), c(colorStateList, iArr3), c(colorStateList, iArr4), 0, c(colorStateList, iArr5), c(colorStateList, iArr6), c(colorStateList, iArr7), c(colorStateList, iArr8), 0});
    }

    @TargetApi(21)
    private static int b(int i10) {
        return a.j(i10, Math.min(Color.alpha(i10) * 2, 255));
    }

    private static int c(ColorStateList colorStateList, int[] iArr) {
        int colorForState = colorStateList != null ? colorStateList.getColorForState(iArr, colorStateList.getDefaultColor()) : 0;
        return f35338a ? b(colorForState) : colorForState;
    }

    public static ColorStateList d(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return ColorStateList.valueOf(0);
        }
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 22 && i10 <= 27 && Color.alpha(colorStateList.getDefaultColor()) == 0 && Color.alpha(colorStateList.getColorForState(f35348k, 0)) != 0) {
            Log.w(f35349l, "Use a non-transparent color for the default color as it will be used to finish ripple animations.");
        }
        return colorStateList;
    }

    public static boolean e(int[] iArr) {
        boolean z10 = false;
        boolean z11 = false;
        for (int i10 : iArr) {
            if (i10 == 16842910) {
                z10 = true;
            } else if (i10 == 16842908 || i10 == 16842919 || i10 == 16843623) {
                z11 = true;
            }
        }
        return z10 && z11;
    }
}
