package com.paypal.android.sdk;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RectShape;
/* loaded from: classes2.dex */
public final class t1 {
    public static final ColorStateList G;

    /* renamed from: e  reason: collision with root package name */
    public static final int f21978e;

    /* renamed from: f  reason: collision with root package name */
    public static final int f21979f;

    /* renamed from: k  reason: collision with root package name */
    private static int f21984k;

    /* renamed from: m  reason: collision with root package name */
    private static int f21986m;

    /* renamed from: t  reason: collision with root package name */
    public static final int f21993t;

    /* renamed from: u  reason: collision with root package name */
    public static final int f21994u;

    /* renamed from: v  reason: collision with root package name */
    public static final int f21995v;

    /* renamed from: w  reason: collision with root package name */
    public static final int f21996w;

    /* renamed from: x  reason: collision with root package name */
    public static final int f21997x;

    /* renamed from: y  reason: collision with root package name */
    public static final int f21998y;

    /* renamed from: a  reason: collision with root package name */
    private static int[] f21974a = {16842919, 16842910};

    /* renamed from: b  reason: collision with root package name */
    private static int[] f21975b = {16842910};

    /* renamed from: c  reason: collision with root package name */
    private static int[] f21976c = {-16842910};

    /* renamed from: d  reason: collision with root package name */
    private static int[] f21977d = {16842908};

    /* renamed from: g  reason: collision with root package name */
    private static int f21980g = Color.parseColor("#aa009CDE");

    /* renamed from: h  reason: collision with root package name */
    public static final Drawable f21981h = new ColorDrawable(Color.parseColor("#717074"));

    /* renamed from: i  reason: collision with root package name */
    public static final int f21982i = Color.parseColor("#f5f5f5");

    /* renamed from: j  reason: collision with root package name */
    public static final int f21983j = Color.parseColor("#c4dceb");

    /* renamed from: l  reason: collision with root package name */
    private static int f21985l = f21980g;

    /* renamed from: n  reason: collision with root package name */
    private static int f21987n = Color.parseColor("#c5ddeb");

    /* renamed from: o  reason: collision with root package name */
    private static int f21988o = Color.parseColor("#717074");

    /* renamed from: p  reason: collision with root package name */
    private static int f21989p = Color.parseColor("#aa717074");

    /* renamed from: q  reason: collision with root package name */
    private static int f21990q = Color.parseColor("#5a5a5d");

    /* renamed from: r  reason: collision with root package name */
    private static int f21991r = Color.parseColor("#f5f5f5");

    /* renamed from: s  reason: collision with root package name */
    public static final int f21992s = Color.parseColor("#e5e5e5");

    /* renamed from: z  reason: collision with root package name */
    public static final Typeface f21999z = Typeface.create("sans-serif-light", 0);
    public static final Typeface A = Typeface.create("sans-serif-light", 0);
    public static final Typeface B = Typeface.create("sans-serif-bold", 0);
    public static final Typeface C = Typeface.create("sans-serif", 2);
    public static final Typeface D = Typeface.create("sans-serif-light", 0);
    public static final Typeface E = Typeface.create("sans-serif", 0);
    public static final Typeface F = Typeface.create("sans-serif-light", 0);

    static {
        int parseColor = Color.parseColor("#003087");
        f21978e = parseColor;
        Color.parseColor("#aa003087");
        int parseColor2 = Color.parseColor("#009CDE");
        f21979f = parseColor2;
        f21984k = parseColor2;
        f21986m = parseColor;
        Color.parseColor("#333333");
        int parseColor3 = Color.parseColor("#515151");
        f21993t = parseColor3;
        int parseColor4 = Color.parseColor("#797979");
        f21994u = parseColor4;
        Color.parseColor("#b32317");
        f21995v = parseColor3;
        f21996w = parseColor3;
        f21997x = parseColor3;
        f21998y = parseColor4;
        Typeface.create("sans-serif-light", 0);
        G = new ColorStateList(new int[][]{f21974a, f21975b}, new int[]{f21986m, f21984k});
    }

    private static Drawable a(int i10, float f10) {
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RectShape());
        shapeDrawable.getPaint().setStrokeWidth(f10 * 2.0f);
        shapeDrawable.getPaint().setStyle(Paint.Style.STROKE);
        shapeDrawable.getPaint().setColor(f21982i);
        return new LayerDrawable(new Drawable[]{new ColorDrawable(i10), shapeDrawable});
    }

    private static Drawable b(int i10, int i11, float f10) {
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RectShape());
        shapeDrawable.getPaint().setStrokeWidth(2.0f * f10);
        shapeDrawable.getPaint().setStyle(Paint.Style.STROKE);
        shapeDrawable.getPaint().setColor(f21982i);
        ShapeDrawable shapeDrawable2 = new ShapeDrawable(new RectShape());
        shapeDrawable2.getPaint().setStrokeWidth(f10);
        shapeDrawable2.getPaint().setStyle(Paint.Style.STROKE);
        shapeDrawable2.getPaint().setColor(i11);
        return new LayerDrawable(new Drawable[]{new ColorDrawable(i10), shapeDrawable, shapeDrawable2});
    }

    public static Drawable c(Context context) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(f21974a, new ColorDrawable(f21986m));
        stateListDrawable.addState(f21976c, new ColorDrawable(f21987n));
        stateListDrawable.addState(f21977d, b(f21984k, f21985l, f(context)));
        stateListDrawable.addState(f21975b, a(f21984k, f(context)));
        return stateListDrawable;
    }

    public static Drawable d(Context context) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(f21974a, new ColorDrawable(f21990q));
        stateListDrawable.addState(f21976c, new ColorDrawable(f21991r));
        stateListDrawable.addState(f21977d, b(f21988o, f21989p, f(context)));
        stateListDrawable.addState(f21975b, a(f21988o, f(context)));
        return stateListDrawable;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static Drawable e(Context context) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(f21977d, b(0, f21985l, f(context)));
        stateListDrawable.addState(f21975b, new ColorDrawable(0));
        return stateListDrawable;
    }

    private static float f(Context context) {
        return (u1.v("4dip", context) / 2.0f) * context.getResources().getDisplayMetrics().density;
    }
}
