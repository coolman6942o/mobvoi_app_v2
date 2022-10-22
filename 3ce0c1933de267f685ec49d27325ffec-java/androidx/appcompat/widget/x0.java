package androidx.appcompat.widget;

import a0.h;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import e.a;
/* compiled from: TintTypedArray.java */
/* loaded from: classes.dex */
public class x0 {

    /* renamed from: a  reason: collision with root package name */
    private final Context f1361a;

    /* renamed from: b  reason: collision with root package name */
    private final TypedArray f1362b;

    /* renamed from: c  reason: collision with root package name */
    private TypedValue f1363c;

    private x0(Context context, TypedArray typedArray) {
        this.f1361a = context;
        this.f1362b = typedArray;
    }

    public static x0 t(Context context, int i10, int[] iArr) {
        return new x0(context, context.obtainStyledAttributes(i10, iArr));
    }

    public static x0 u(Context context, AttributeSet attributeSet, int[] iArr) {
        return new x0(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static x0 v(Context context, AttributeSet attributeSet, int[] iArr, int i10, int i11) {
        return new x0(context, context.obtainStyledAttributes(attributeSet, iArr, i10, i11));
    }

    public boolean a(int i10, boolean z10) {
        return this.f1362b.getBoolean(i10, z10);
    }

    public int b(int i10, int i11) {
        return this.f1362b.getColor(i10, i11);
    }

    public ColorStateList c(int i10) {
        int resourceId;
        ColorStateList a10;
        return (!this.f1362b.hasValue(i10) || (resourceId = this.f1362b.getResourceId(i10, 0)) == 0 || (a10 = a.a(this.f1361a, resourceId)) == null) ? this.f1362b.getColorStateList(i10) : a10;
    }

    public float d(int i10, float f10) {
        return this.f1362b.getDimension(i10, f10);
    }

    public int e(int i10, int i11) {
        return this.f1362b.getDimensionPixelOffset(i10, i11);
    }

    public int f(int i10, int i11) {
        return this.f1362b.getDimensionPixelSize(i10, i11);
    }

    public Drawable g(int i10) {
        int resourceId;
        if (!this.f1362b.hasValue(i10) || (resourceId = this.f1362b.getResourceId(i10, 0)) == 0) {
            return this.f1362b.getDrawable(i10);
        }
        return a.b(this.f1361a, resourceId);
    }

    public Drawable h(int i10) {
        int resourceId;
        if (!this.f1362b.hasValue(i10) || (resourceId = this.f1362b.getResourceId(i10, 0)) == 0) {
            return null;
        }
        return j.b().d(this.f1361a, resourceId, true);
    }

    public float i(int i10, float f10) {
        return this.f1362b.getFloat(i10, f10);
    }

    public Typeface j(int i10, int i11, h.d dVar) {
        int resourceId = this.f1362b.getResourceId(i10, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f1363c == null) {
            this.f1363c = new TypedValue();
        }
        return h.i(this.f1361a, resourceId, this.f1363c, i11, dVar);
    }

    public int k(int i10, int i11) {
        return this.f1362b.getInt(i10, i11);
    }

    public int l(int i10, int i11) {
        return this.f1362b.getInteger(i10, i11);
    }

    public int m(int i10, int i11) {
        return this.f1362b.getLayoutDimension(i10, i11);
    }

    public int n(int i10, int i11) {
        return this.f1362b.getResourceId(i10, i11);
    }

    public String o(int i10) {
        return this.f1362b.getString(i10);
    }

    public CharSequence p(int i10) {
        return this.f1362b.getText(i10);
    }

    public CharSequence[] q(int i10) {
        return this.f1362b.getTextArray(i10);
    }

    public TypedArray r() {
        return this.f1362b;
    }

    public boolean s(int i10) {
        return this.f1362b.hasValue(i10);
    }

    public void w() {
        this.f1362b.recycle();
    }
}
