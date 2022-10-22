package com.unionpay.mobile.android.utils;

import android.content.res.ColorStateList;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import java.util.Arrays;
/* loaded from: classes2.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f24146a = {16842910};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f24147b = {16842908};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f24148c = {-16842910};

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f24149d = {16842910, 16842919};

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f24150e = {16842910, 16842908};

    /* renamed from: f  reason: collision with root package name */
    private static final int[] f24151f = {16842910, 16842912};

    public static ColorStateList a(int i10, int i11) {
        return a(i10, i11, i11, i10);
    }

    public static ColorStateList a(int i10, int i11, int i12, int i13) {
        return new ColorStateList(new int[][]{new int[]{16842919, 16842910}, new int[]{16842910, 16842908}, new int[]{16842910}, new int[]{16842908}, new int[]{16842909}, new int[0]}, new int[]{i11, i12, i10, i12, i13, i13});
    }

    public static Drawable a(int i10, int[] iArr, float[] fArr, float f10, float f11, float f12, float f13) {
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(a(i10, 18.0f), null, null));
        shapeDrawable.getPaint().setShader(new LinearGradient(f10, f11, f12, f13, iArr, fArr, Shader.TileMode.CLAMP));
        return shapeDrawable;
    }

    public static Drawable a(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(f24149d, drawable2);
        stateListDrawable.addState(f24150e, drawable2);
        if (drawable4 != null) {
            stateListDrawable.addState(f24151f, drawable4);
        }
        stateListDrawable.addState(f24146a, drawable);
        stateListDrawable.addState(f24147b, drawable2);
        if (drawable3 != null) {
            stateListDrawable.addState(f24148c, drawable3);
        }
        return stateListDrawable;
    }

    public static ShapeDrawable a(int i10, int i11, float f10) {
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(a(i11, f10), null, null));
        shapeDrawable.getPaint().setStrokeWidth(1.0f);
        shapeDrawable.getPaint().setColor(i10);
        shapeDrawable.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
        return shapeDrawable;
    }

    private static float[] a(int i10, float f10) {
        float[] fArr = new float[8];
        Arrays.fill(fArr, 0.0f);
        if (i10 == 0) {
            return fArr;
        }
        if ((i10 & 1) != 0) {
            fArr[1] = f10;
            fArr[0] = f10;
        }
        if ((i10 & 2) != 0) {
            fArr[3] = f10;
            fArr[2] = f10;
        }
        if ((i10 & 4) != 0) {
            fArr[5] = f10;
            fArr[4] = f10;
        }
        if ((i10 & 8) != 0) {
            fArr[7] = f10;
            fArr[6] = f10;
        }
        return fArr;
    }
}
