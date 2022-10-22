package androidx.vectordrawable.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import b0.d;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: VectorDrawableCompat.java */
/* loaded from: classes.dex */
public class i extends androidx.vectordrawable.graphics.drawable.h {

    /* renamed from: j  reason: collision with root package name */
    static final PorterDuff.Mode f4468j = PorterDuff.Mode.SRC_IN;

    /* renamed from: b  reason: collision with root package name */
    private h f4469b;

    /* renamed from: c  reason: collision with root package name */
    private PorterDuffColorFilter f4470c;

    /* renamed from: d  reason: collision with root package name */
    private ColorFilter f4471d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f4472e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f4473f;

    /* renamed from: g  reason: collision with root package name */
    private final float[] f4474g;

    /* renamed from: h  reason: collision with root package name */
    private final Matrix f4475h;

    /* renamed from: i  reason: collision with root package name */
    private final Rect f4476i;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class b extends f {
        b() {
        }

        private void f(TypedArray typedArray, XmlPullParser xmlPullParser) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f4503b = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.f4502a = b0.d.d(string2);
            }
            this.f4504c = a0.i.k(typedArray, xmlPullParser, "fillType", 2, 0);
        }

        @Override // androidx.vectordrawable.graphics.drawable.i.f
        public boolean c() {
            return true;
        }

        public void e(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (a0.i.r(xmlPullParser, "pathData")) {
                TypedArray s10 = a0.i.s(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f4443d);
                f(s10, xmlPullParser);
                s10.recycle();
            }
        }

        b(b bVar) {
            super(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static abstract class e {
        private e() {
        }

        public boolean a() {
            return false;
        }

        public boolean b(int[] iArr) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class h extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        int f4523a;

        /* renamed from: b  reason: collision with root package name */
        g f4524b;

        /* renamed from: c  reason: collision with root package name */
        ColorStateList f4525c;

        /* renamed from: d  reason: collision with root package name */
        PorterDuff.Mode f4526d;

        /* renamed from: e  reason: collision with root package name */
        boolean f4527e;

        /* renamed from: f  reason: collision with root package name */
        Bitmap f4528f;

        /* renamed from: g  reason: collision with root package name */
        ColorStateList f4529g;

        /* renamed from: h  reason: collision with root package name */
        PorterDuff.Mode f4530h;

        /* renamed from: i  reason: collision with root package name */
        int f4531i;

        /* renamed from: j  reason: collision with root package name */
        boolean f4532j;

        /* renamed from: k  reason: collision with root package name */
        boolean f4533k;

        /* renamed from: l  reason: collision with root package name */
        Paint f4534l;

        public h(h hVar) {
            this.f4525c = null;
            this.f4526d = i.f4468j;
            if (hVar != null) {
                this.f4523a = hVar.f4523a;
                g gVar = new g(hVar.f4524b);
                this.f4524b = gVar;
                if (hVar.f4524b.f4511e != null) {
                    gVar.f4511e = new Paint(hVar.f4524b.f4511e);
                }
                if (hVar.f4524b.f4510d != null) {
                    this.f4524b.f4510d = new Paint(hVar.f4524b.f4510d);
                }
                this.f4525c = hVar.f4525c;
                this.f4526d = hVar.f4526d;
                this.f4527e = hVar.f4527e;
            }
        }

        public boolean a(int i10, int i11) {
            return i10 == this.f4528f.getWidth() && i11 == this.f4528f.getHeight();
        }

        public boolean b() {
            return !this.f4533k && this.f4529g == this.f4525c && this.f4530h == this.f4526d && this.f4532j == this.f4527e && this.f4531i == this.f4524b.getRootAlpha();
        }

        public void c(int i10, int i11) {
            if (this.f4528f == null || !a(i10, i11)) {
                this.f4528f = Bitmap.createBitmap(i10, i11, Bitmap.Config.ARGB_8888);
                this.f4533k = true;
            }
        }

        public void d(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f4528f, (Rect) null, rect, e(colorFilter));
        }

        public Paint e(ColorFilter colorFilter) {
            if (!f() && colorFilter == null) {
                return null;
            }
            if (this.f4534l == null) {
                Paint paint = new Paint();
                this.f4534l = paint;
                paint.setFilterBitmap(true);
            }
            this.f4534l.setAlpha(this.f4524b.getRootAlpha());
            this.f4534l.setColorFilter(colorFilter);
            return this.f4534l;
        }

        public boolean f() {
            return this.f4524b.getRootAlpha() < 255;
        }

        public boolean g() {
            return this.f4524b.f();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f4523a;
        }

        public boolean h(int[] iArr) {
            boolean g10 = this.f4524b.g(iArr);
            this.f4533k |= g10;
            return g10;
        }

        public void i() {
            this.f4529g = this.f4525c;
            this.f4530h = this.f4526d;
            this.f4531i = this.f4524b.getRootAlpha();
            this.f4532j = this.f4527e;
            this.f4533k = false;
        }

        public void j(int i10, int i11) {
            this.f4528f.eraseColor(0);
            this.f4524b.b(new Canvas(this.f4528f), i10, i11, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new i(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new i(this);
        }

        public h() {
            this.f4525c = null;
            this.f4526d = i.f4468j;
            this.f4524b = new g();
        }
    }

    i() {
        this.f4473f = true;
        this.f4474g = new float[9];
        this.f4475h = new Matrix();
        this.f4476i = new Rect();
        this.f4469b = new h();
    }

    static int a(int i10, float f10) {
        return (i10 & 16777215) | (((int) (Color.alpha(i10) * f10)) << 24);
    }

    public static i b(Resources resources, int i10, Resources.Theme theme) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            i iVar = new i();
            iVar.f4467a = a0.h.f(resources, i10, theme);
            new C0051i(iVar.f4467a.getConstantState());
            return iVar;
        }
        try {
            XmlResourceParser xml = resources.getXml(i10);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            while (true) {
                next = xml.next();
                if (next == 2 || next == 1) {
                    break;
                }
            }
            if (next == 2) {
                return c(resources, xml, asAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (IOException e10) {
            Log.e("VectorDrawableCompat", "parser error", e10);
            return null;
        } catch (XmlPullParserException e11) {
            Log.e("VectorDrawableCompat", "parser error", e11);
            return null;
        }
    }

    public static i c(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        i iVar = new i();
        iVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return iVar;
    }

    private void e(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        h hVar = this.f4469b;
        g gVar = hVar.f4524b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(gVar.f4514h);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z10 = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                d dVar = (d) arrayDeque.peek();
                if ("path".equals(name)) {
                    c cVar = new c();
                    cVar.g(resources, attributeSet, theme, xmlPullParser);
                    dVar.f4490b.add(cVar);
                    if (cVar.getPathName() != null) {
                        gVar.f4522p.put(cVar.getPathName(), cVar);
                    }
                    z10 = false;
                    hVar.f4523a = cVar.f4505d | hVar.f4523a;
                } else if ("clip-path".equals(name)) {
                    b bVar = new b();
                    bVar.e(resources, attributeSet, theme, xmlPullParser);
                    dVar.f4490b.add(bVar);
                    if (bVar.getPathName() != null) {
                        gVar.f4522p.put(bVar.getPathName(), bVar);
                    }
                    hVar.f4523a = bVar.f4505d | hVar.f4523a;
                } else if ("group".equals(name)) {
                    d dVar2 = new d();
                    dVar2.c(resources, attributeSet, theme, xmlPullParser);
                    dVar.f4490b.add(dVar2);
                    arrayDeque.push(dVar2);
                    if (dVar2.getGroupName() != null) {
                        gVar.f4522p.put(dVar2.getGroupName(), dVar2);
                    }
                    hVar.f4523a = dVar2.f4499k | hVar.f4523a;
                }
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z10) {
            throw new XmlPullParserException("no path defined");
        }
    }

    private boolean f() {
        return Build.VERSION.SDK_INT >= 17 && isAutoMirrored() && androidx.core.graphics.drawable.a.f(this) == 1;
    }

    private static PorterDuff.Mode g(int i10, PorterDuff.Mode mode) {
        if (i10 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i10 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i10 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i10) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    private void i(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException {
        h hVar = this.f4469b;
        g gVar = hVar.f4524b;
        hVar.f4526d = g(a0.i.k(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList g10 = a0.i.g(typedArray, xmlPullParser, theme, "tint", 1);
        if (g10 != null) {
            hVar.f4525c = g10;
        }
        hVar.f4527e = a0.i.e(typedArray, xmlPullParser, "autoMirrored", 5, hVar.f4527e);
        gVar.f4517k = a0.i.j(typedArray, xmlPullParser, "viewportWidth", 7, gVar.f4517k);
        float j10 = a0.i.j(typedArray, xmlPullParser, "viewportHeight", 8, gVar.f4518l);
        gVar.f4518l = j10;
        if (gVar.f4517k <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (j10 > 0.0f) {
            gVar.f4515i = typedArray.getDimension(3, gVar.f4515i);
            float dimension = typedArray.getDimension(2, gVar.f4516j);
            gVar.f4516j = dimension;
            if (gVar.f4515i <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (dimension > 0.0f) {
                gVar.setAlpha(a0.i.j(typedArray, xmlPullParser, "alpha", 4, gVar.getAlpha()));
                String string = typedArray.getString(0);
                if (string != null) {
                    gVar.f4520n = string;
                    gVar.f4522p.put(string, gVar);
                }
            } else {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
            }
        } else {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f4467a;
        if (drawable == null) {
            return false;
        }
        androidx.core.graphics.drawable.a.b(drawable);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object d(String str) {
        return this.f4469b.f4524b.f4522p.get(str);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f4467a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.f4476i);
        if (this.f4476i.width() > 0 && this.f4476i.height() > 0) {
            ColorFilter colorFilter = this.f4471d;
            if (colorFilter == null) {
                colorFilter = this.f4470c;
            }
            canvas.getMatrix(this.f4475h);
            this.f4475h.getValues(this.f4474g);
            float abs = Math.abs(this.f4474g[0]);
            float abs2 = Math.abs(this.f4474g[4]);
            float abs3 = Math.abs(this.f4474g[1]);
            float abs4 = Math.abs(this.f4474g[3]);
            if (!(abs3 == 0.0f && abs4 == 0.0f)) {
                abs = 1.0f;
                abs2 = 1.0f;
            }
            int min = Math.min(2048, (int) (this.f4476i.width() * abs));
            int min2 = Math.min(2048, (int) (this.f4476i.height() * abs2));
            if (min > 0 && min2 > 0) {
                int save = canvas.save();
                Rect rect = this.f4476i;
                canvas.translate(rect.left, rect.top);
                if (f()) {
                    canvas.translate(this.f4476i.width(), 0.0f);
                    canvas.scale(-1.0f, 1.0f);
                }
                this.f4476i.offsetTo(0, 0);
                this.f4469b.c(min, min2);
                if (!this.f4473f) {
                    this.f4469b.j(min, min2);
                } else if (!this.f4469b.b()) {
                    this.f4469b.j(min, min2);
                    this.f4469b.i();
                }
                this.f4469b.d(canvas, colorFilter, this.f4476i);
                canvas.restoreToCount(save);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f4467a;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.d(drawable);
        }
        return this.f4469b.f4524b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f4467a;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f4469b.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f4467a;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.e(drawable);
        }
        return this.f4471d;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f4467a != null && Build.VERSION.SDK_INT >= 24) {
            return new C0051i(this.f4467a.getConstantState());
        }
        this.f4469b.f4523a = getChangingConfigurations();
        return this.f4469b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f4467a;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return (int) this.f4469b.f4524b.f4516j;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f4467a;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return (int) this.f4469b.f4524b.f4515i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f4467a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(boolean z10) {
        this.f4473f = z10;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.f4467a;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable drawable = this.f4467a;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f4467a;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.h(drawable);
        }
        return this.f4469b.f4527e;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        h hVar;
        ColorStateList colorStateList;
        Drawable drawable = this.f4467a;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return super.isStateful() || ((hVar = this.f4469b) != null && (hVar.g() || ((colorStateList = this.f4469b.f4525c) != null && colorStateList.isStateful())));
    }

    PorterDuffColorFilter j(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f4467a;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f4472e && super.mutate() == this) {
            this.f4469b = new h(this.f4469b);
            this.f4472e = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f4467a;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        Drawable drawable = this.f4467a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        boolean z10 = false;
        h hVar = this.f4469b;
        ColorStateList colorStateList = hVar.f4525c;
        if (!(colorStateList == null || (mode = hVar.f4526d) == null)) {
            this.f4470c = j(this.f4470c, colorStateList, mode);
            invalidateSelf();
            z10 = true;
        }
        if (!hVar.g() || !hVar.h(iArr)) {
            return z10;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j10) {
        Drawable drawable = this.f4467a;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j10);
        } else {
            super.scheduleSelf(runnable, j10);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        Drawable drawable = this.f4467a;
        if (drawable != null) {
            drawable.setAlpha(i10);
        } else if (this.f4469b.f4524b.getRootAlpha() != i10) {
            this.f4469b.f4524b.setRootAlpha(i10);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z10) {
        Drawable drawable = this.f4467a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.j(drawable, z10);
        } else {
            this.f4469b.f4527e = z10;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f4467a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        this.f4471d = colorFilter;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, c0.d
    public void setTint(int i10) {
        Drawable drawable = this.f4467a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.n(drawable, i10);
        } else {
            setTintList(ColorStateList.valueOf(i10));
        }
    }

    @Override // android.graphics.drawable.Drawable, c0.d
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f4467a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.o(drawable, colorStateList);
            return;
        }
        h hVar = this.f4469b;
        if (hVar.f4525c != colorStateList) {
            hVar.f4525c = colorStateList;
            this.f4470c = j(this.f4470c, colorStateList, hVar.f4526d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable, c0.d
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f4467a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.p(drawable, mode);
            return;
        }
        h hVar = this.f4469b;
        if (hVar.f4526d != mode) {
            hVar.f4526d = mode;
            this.f4470c = j(this.f4470c, hVar.f4525c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        Drawable drawable = this.f4467a;
        if (drawable != null) {
            return drawable.setVisible(z10, z11);
        }
        return super.setVisible(z10, z11);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f4467a;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: androidx.vectordrawable.graphics.drawable.i$i  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0051i extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        private final Drawable.ConstantState f4535a;

        public C0051i(Drawable.ConstantState constantState) {
            this.f4535a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f4535a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f4535a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            i iVar = new i();
            iVar.f4467a = (VectorDrawable) this.f4535a.newDrawable();
            return iVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            i iVar = new i();
            iVar.f4467a = (VectorDrawable) this.f4535a.newDrawable(resources);
            return iVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            i iVar = new i();
            iVar.f4467a = (VectorDrawable) this.f4535a.newDrawable(resources, theme);
            return iVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static abstract class f extends e {

        /* renamed from: a  reason: collision with root package name */
        protected d.b[] f4502a;

        /* renamed from: b  reason: collision with root package name */
        String f4503b;

        /* renamed from: c  reason: collision with root package name */
        int f4504c;

        /* renamed from: d  reason: collision with root package name */
        int f4505d;

        public f() {
            super();
            this.f4502a = null;
            this.f4504c = 0;
        }

        public boolean c() {
            return false;
        }

        public void d(Path path) {
            path.reset();
            d.b[] bVarArr = this.f4502a;
            if (bVarArr != null) {
                d.b.e(bVarArr, path);
            }
        }

        public d.b[] getPathData() {
            return this.f4502a;
        }

        public String getPathName() {
            return this.f4503b;
        }

        public void setPathData(d.b[] bVarArr) {
            if (!b0.d.b(this.f4502a, bVarArr)) {
                this.f4502a = b0.d.f(bVarArr);
            } else {
                b0.d.j(this.f4502a, bVarArr);
            }
        }

        public f(f fVar) {
            super();
            this.f4502a = null;
            this.f4504c = 0;
            this.f4503b = fVar.f4503b;
            this.f4505d = fVar.f4505d;
            this.f4502a = b0.d.f(fVar.f4502a);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.f4467a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.g(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        h hVar = this.f4469b;
        hVar.f4524b = new g();
        TypedArray s10 = a0.i.s(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f4440a);
        i(s10, xmlPullParser, theme);
        s10.recycle();
        hVar.f4523a = getChangingConfigurations();
        hVar.f4533k = true;
        e(resources, xmlPullParser, attributeSet, theme);
        this.f4470c = j(this.f4470c, hVar.f4525c, hVar.f4526d);
    }

    i(h hVar) {
        this.f4473f = true;
        this.f4474g = new float[9];
        this.f4475h = new Matrix();
        this.f4476i = new Rect();
        this.f4469b = hVar;
        this.f4470c = j(this.f4470c, hVar.f4525c, hVar.f4526d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class c extends f {

        /* renamed from: e  reason: collision with root package name */
        private int[] f4477e;

        /* renamed from: f  reason: collision with root package name */
        a0.d f4478f;

        /* renamed from: g  reason: collision with root package name */
        float f4479g;

        /* renamed from: h  reason: collision with root package name */
        a0.d f4480h;

        /* renamed from: i  reason: collision with root package name */
        float f4481i;

        /* renamed from: j  reason: collision with root package name */
        float f4482j;

        /* renamed from: k  reason: collision with root package name */
        float f4483k;

        /* renamed from: l  reason: collision with root package name */
        float f4484l;

        /* renamed from: m  reason: collision with root package name */
        float f4485m;

        /* renamed from: n  reason: collision with root package name */
        Paint.Cap f4486n;

        /* renamed from: o  reason: collision with root package name */
        Paint.Join f4487o;

        /* renamed from: p  reason: collision with root package name */
        float f4488p;

        c() {
            this.f4479g = 0.0f;
            this.f4481i = 1.0f;
            this.f4482j = 1.0f;
            this.f4483k = 0.0f;
            this.f4484l = 1.0f;
            this.f4485m = 0.0f;
            this.f4486n = Paint.Cap.BUTT;
            this.f4487o = Paint.Join.MITER;
            this.f4488p = 4.0f;
        }

        private Paint.Cap e(int i10, Paint.Cap cap) {
            if (i10 == 0) {
                return Paint.Cap.BUTT;
            }
            if (i10 != 1) {
                return i10 != 2 ? cap : Paint.Cap.SQUARE;
            }
            return Paint.Cap.ROUND;
        }

        private Paint.Join f(int i10, Paint.Join join) {
            if (i10 == 0) {
                return Paint.Join.MITER;
            }
            if (i10 != 1) {
                return i10 != 2 ? join : Paint.Join.BEVEL;
            }
            return Paint.Join.ROUND;
        }

        private void h(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.f4477e = null;
            if (a0.i.r(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.f4503b = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.f4502a = b0.d.d(string2);
                }
                this.f4480h = a0.i.i(typedArray, xmlPullParser, theme, "fillColor", 1, 0);
                this.f4482j = a0.i.j(typedArray, xmlPullParser, "fillAlpha", 12, this.f4482j);
                this.f4486n = e(a0.i.k(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.f4486n);
                this.f4487o = f(a0.i.k(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.f4487o);
                this.f4488p = a0.i.j(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.f4488p);
                this.f4478f = a0.i.i(typedArray, xmlPullParser, theme, "strokeColor", 3, 0);
                this.f4481i = a0.i.j(typedArray, xmlPullParser, "strokeAlpha", 11, this.f4481i);
                this.f4479g = a0.i.j(typedArray, xmlPullParser, "strokeWidth", 4, this.f4479g);
                this.f4484l = a0.i.j(typedArray, xmlPullParser, "trimPathEnd", 6, this.f4484l);
                this.f4485m = a0.i.j(typedArray, xmlPullParser, "trimPathOffset", 7, this.f4485m);
                this.f4483k = a0.i.j(typedArray, xmlPullParser, "trimPathStart", 5, this.f4483k);
                this.f4504c = a0.i.k(typedArray, xmlPullParser, "fillType", 13, this.f4504c);
            }
        }

        @Override // androidx.vectordrawable.graphics.drawable.i.e
        public boolean a() {
            return this.f4480h.i() || this.f4478f.i();
        }

        @Override // androidx.vectordrawable.graphics.drawable.i.e
        public boolean b(int[] iArr) {
            return this.f4478f.j(iArr) | this.f4480h.j(iArr);
        }

        public void g(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray s10 = a0.i.s(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f4442c);
            h(s10, xmlPullParser, theme);
            s10.recycle();
        }

        float getFillAlpha() {
            return this.f4482j;
        }

        int getFillColor() {
            return this.f4480h.e();
        }

        float getStrokeAlpha() {
            return this.f4481i;
        }

        int getStrokeColor() {
            return this.f4478f.e();
        }

        float getStrokeWidth() {
            return this.f4479g;
        }

        float getTrimPathEnd() {
            return this.f4484l;
        }

        float getTrimPathOffset() {
            return this.f4485m;
        }

        float getTrimPathStart() {
            return this.f4483k;
        }

        void setFillAlpha(float f10) {
            this.f4482j = f10;
        }

        void setFillColor(int i10) {
            this.f4480h.k(i10);
        }

        void setStrokeAlpha(float f10) {
            this.f4481i = f10;
        }

        void setStrokeColor(int i10) {
            this.f4478f.k(i10);
        }

        void setStrokeWidth(float f10) {
            this.f4479g = f10;
        }

        void setTrimPathEnd(float f10) {
            this.f4484l = f10;
        }

        void setTrimPathOffset(float f10) {
            this.f4485m = f10;
        }

        void setTrimPathStart(float f10) {
            this.f4483k = f10;
        }

        c(c cVar) {
            super(cVar);
            this.f4479g = 0.0f;
            this.f4481i = 1.0f;
            this.f4482j = 1.0f;
            this.f4483k = 0.0f;
            this.f4484l = 1.0f;
            this.f4485m = 0.0f;
            this.f4486n = Paint.Cap.BUTT;
            this.f4487o = Paint.Join.MITER;
            this.f4488p = 4.0f;
            this.f4477e = cVar.f4477e;
            this.f4478f = cVar.f4478f;
            this.f4479g = cVar.f4479g;
            this.f4481i = cVar.f4481i;
            this.f4480h = cVar.f4480h;
            this.f4504c = cVar.f4504c;
            this.f4482j = cVar.f4482j;
            this.f4483k = cVar.f4483k;
            this.f4484l = cVar.f4484l;
            this.f4485m = cVar.f4485m;
            this.f4486n = cVar.f4486n;
            this.f4487o = cVar.f4487o;
            this.f4488p = cVar.f4488p;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class g {

        /* renamed from: q  reason: collision with root package name */
        private static final Matrix f4506q = new Matrix();

        /* renamed from: a  reason: collision with root package name */
        private final Path f4507a;

        /* renamed from: b  reason: collision with root package name */
        private final Path f4508b;

        /* renamed from: c  reason: collision with root package name */
        private final Matrix f4509c;

        /* renamed from: d  reason: collision with root package name */
        Paint f4510d;

        /* renamed from: e  reason: collision with root package name */
        Paint f4511e;

        /* renamed from: f  reason: collision with root package name */
        private PathMeasure f4512f;

        /* renamed from: g  reason: collision with root package name */
        private int f4513g;

        /* renamed from: h  reason: collision with root package name */
        final d f4514h;

        /* renamed from: i  reason: collision with root package name */
        float f4515i;

        /* renamed from: j  reason: collision with root package name */
        float f4516j;

        /* renamed from: k  reason: collision with root package name */
        float f4517k;

        /* renamed from: l  reason: collision with root package name */
        float f4518l;

        /* renamed from: m  reason: collision with root package name */
        int f4519m;

        /* renamed from: n  reason: collision with root package name */
        String f4520n;

        /* renamed from: o  reason: collision with root package name */
        Boolean f4521o;

        /* renamed from: p  reason: collision with root package name */
        final androidx.collection.a<String, Object> f4522p;

        public g() {
            this.f4509c = new Matrix();
            this.f4515i = 0.0f;
            this.f4516j = 0.0f;
            this.f4517k = 0.0f;
            this.f4518l = 0.0f;
            this.f4519m = 255;
            this.f4520n = null;
            this.f4521o = null;
            this.f4522p = new androidx.collection.a<>();
            this.f4514h = new d();
            this.f4507a = new Path();
            this.f4508b = new Path();
        }

        private static float a(float f10, float f11, float f12, float f13) {
            return (f10 * f13) - (f11 * f12);
        }

        private void c(d dVar, Matrix matrix, Canvas canvas, int i10, int i11, ColorFilter colorFilter) {
            dVar.f4489a.set(matrix);
            dVar.f4489a.preConcat(dVar.f4498j);
            canvas.save();
            for (int i12 = 0; i12 < dVar.f4490b.size(); i12++) {
                e eVar = dVar.f4490b.get(i12);
                if (eVar instanceof d) {
                    c((d) eVar, dVar.f4489a, canvas, i10, i11, colorFilter);
                } else if (eVar instanceof f) {
                    d(dVar, (f) eVar, canvas, i10, i11, colorFilter);
                }
            }
            canvas.restore();
        }

        private void d(d dVar, f fVar, Canvas canvas, int i10, int i11, ColorFilter colorFilter) {
            float f10 = i10 / this.f4517k;
            float f11 = i11 / this.f4518l;
            float min = Math.min(f10, f11);
            Matrix matrix = dVar.f4489a;
            this.f4509c.set(matrix);
            this.f4509c.postScale(f10, f11);
            float e10 = e(matrix);
            if (e10 != 0.0f) {
                fVar.d(this.f4507a);
                Path path = this.f4507a;
                this.f4508b.reset();
                if (fVar.c()) {
                    this.f4508b.setFillType(fVar.f4504c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                    this.f4508b.addPath(path, this.f4509c);
                    canvas.clipPath(this.f4508b);
                    return;
                }
                c cVar = (c) fVar;
                float f12 = cVar.f4483k;
                if (!(f12 == 0.0f && cVar.f4484l == 1.0f)) {
                    float f13 = cVar.f4485m;
                    float f14 = (f12 + f13) % 1.0f;
                    float f15 = (cVar.f4484l + f13) % 1.0f;
                    if (this.f4512f == null) {
                        this.f4512f = new PathMeasure();
                    }
                    this.f4512f.setPath(this.f4507a, false);
                    float length = this.f4512f.getLength();
                    float f16 = f14 * length;
                    float f17 = f15 * length;
                    path.reset();
                    if (f16 > f17) {
                        this.f4512f.getSegment(f16, length, path, true);
                        this.f4512f.getSegment(0.0f, f17, path, true);
                    } else {
                        this.f4512f.getSegment(f16, f17, path, true);
                    }
                    path.rLineTo(0.0f, 0.0f);
                }
                this.f4508b.addPath(path, this.f4509c);
                if (cVar.f4480h.l()) {
                    a0.d dVar2 = cVar.f4480h;
                    if (this.f4511e == null) {
                        Paint paint = new Paint(1);
                        this.f4511e = paint;
                        paint.setStyle(Paint.Style.FILL);
                    }
                    Paint paint2 = this.f4511e;
                    if (dVar2.h()) {
                        Shader f18 = dVar2.f();
                        f18.setLocalMatrix(this.f4509c);
                        paint2.setShader(f18);
                        paint2.setAlpha(Math.round(cVar.f4482j * 255.0f));
                    } else {
                        paint2.setShader(null);
                        paint2.setAlpha(255);
                        paint2.setColor(i.a(dVar2.e(), cVar.f4482j));
                    }
                    paint2.setColorFilter(colorFilter);
                    this.f4508b.setFillType(cVar.f4504c == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                    canvas.drawPath(this.f4508b, paint2);
                }
                if (cVar.f4478f.l()) {
                    a0.d dVar3 = cVar.f4478f;
                    if (this.f4510d == null) {
                        Paint paint3 = new Paint(1);
                        this.f4510d = paint3;
                        paint3.setStyle(Paint.Style.STROKE);
                    }
                    Paint paint4 = this.f4510d;
                    Paint.Join join = cVar.f4487o;
                    if (join != null) {
                        paint4.setStrokeJoin(join);
                    }
                    Paint.Cap cap = cVar.f4486n;
                    if (cap != null) {
                        paint4.setStrokeCap(cap);
                    }
                    paint4.setStrokeMiter(cVar.f4488p);
                    if (dVar3.h()) {
                        Shader f19 = dVar3.f();
                        f19.setLocalMatrix(this.f4509c);
                        paint4.setShader(f19);
                        paint4.setAlpha(Math.round(cVar.f4481i * 255.0f));
                    } else {
                        paint4.setShader(null);
                        paint4.setAlpha(255);
                        paint4.setColor(i.a(dVar3.e(), cVar.f4481i));
                    }
                    paint4.setColorFilter(colorFilter);
                    paint4.setStrokeWidth(cVar.f4479g * min * e10);
                    canvas.drawPath(this.f4508b, paint4);
                }
            }
        }

        private float e(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float a10 = a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float max = Math.max((float) Math.hypot(fArr[0], fArr[1]), (float) Math.hypot(fArr[2], fArr[3]));
            if (max > 0.0f) {
                return Math.abs(a10) / max;
            }
            return 0.0f;
        }

        public void b(Canvas canvas, int i10, int i11, ColorFilter colorFilter) {
            c(this.f4514h, f4506q, canvas, i10, i11, colorFilter);
        }

        public boolean f() {
            if (this.f4521o == null) {
                this.f4521o = Boolean.valueOf(this.f4514h.a());
            }
            return this.f4521o.booleanValue();
        }

        public boolean g(int[] iArr) {
            return this.f4514h.b(iArr);
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public int getRootAlpha() {
            return this.f4519m;
        }

        public void setAlpha(float f10) {
            setRootAlpha((int) (f10 * 255.0f));
        }

        public void setRootAlpha(int i10) {
            this.f4519m = i10;
        }

        public g(g gVar) {
            this.f4509c = new Matrix();
            this.f4515i = 0.0f;
            this.f4516j = 0.0f;
            this.f4517k = 0.0f;
            this.f4518l = 0.0f;
            this.f4519m = 255;
            this.f4520n = null;
            this.f4521o = null;
            androidx.collection.a<String, Object> aVar = new androidx.collection.a<>();
            this.f4522p = aVar;
            this.f4514h = new d(gVar.f4514h, aVar);
            this.f4507a = new Path(gVar.f4507a);
            this.f4508b = new Path(gVar.f4508b);
            this.f4515i = gVar.f4515i;
            this.f4516j = gVar.f4516j;
            this.f4517k = gVar.f4517k;
            this.f4518l = gVar.f4518l;
            this.f4513g = gVar.f4513g;
            this.f4519m = gVar.f4519m;
            this.f4520n = gVar.f4520n;
            String str = gVar.f4520n;
            if (str != null) {
                aVar.put(str, this);
            }
            this.f4521o = gVar.f4521o;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class d extends e {

        /* renamed from: a  reason: collision with root package name */
        final Matrix f4489a;

        /* renamed from: b  reason: collision with root package name */
        final ArrayList<e> f4490b;

        /* renamed from: c  reason: collision with root package name */
        float f4491c;

        /* renamed from: d  reason: collision with root package name */
        private float f4492d;

        /* renamed from: e  reason: collision with root package name */
        private float f4493e;

        /* renamed from: f  reason: collision with root package name */
        private float f4494f;

        /* renamed from: g  reason: collision with root package name */
        private float f4495g;

        /* renamed from: h  reason: collision with root package name */
        private float f4496h;

        /* renamed from: i  reason: collision with root package name */
        private float f4497i;

        /* renamed from: j  reason: collision with root package name */
        final Matrix f4498j;

        /* renamed from: k  reason: collision with root package name */
        int f4499k;

        /* renamed from: l  reason: collision with root package name */
        private int[] f4500l;

        /* renamed from: m  reason: collision with root package name */
        private String f4501m;

        public d(d dVar, androidx.collection.a<String, Object> aVar) {
            super();
            f fVar;
            this.f4489a = new Matrix();
            this.f4490b = new ArrayList<>();
            this.f4491c = 0.0f;
            this.f4492d = 0.0f;
            this.f4493e = 0.0f;
            this.f4494f = 1.0f;
            this.f4495g = 1.0f;
            this.f4496h = 0.0f;
            this.f4497i = 0.0f;
            Matrix matrix = new Matrix();
            this.f4498j = matrix;
            this.f4501m = null;
            this.f4491c = dVar.f4491c;
            this.f4492d = dVar.f4492d;
            this.f4493e = dVar.f4493e;
            this.f4494f = dVar.f4494f;
            this.f4495g = dVar.f4495g;
            this.f4496h = dVar.f4496h;
            this.f4497i = dVar.f4497i;
            this.f4500l = dVar.f4500l;
            String str = dVar.f4501m;
            this.f4501m = str;
            this.f4499k = dVar.f4499k;
            if (str != null) {
                aVar.put(str, this);
            }
            matrix.set(dVar.f4498j);
            ArrayList<e> arrayList = dVar.f4490b;
            for (int i10 = 0; i10 < arrayList.size(); i10++) {
                e eVar = arrayList.get(i10);
                if (eVar instanceof d) {
                    this.f4490b.add(new d((d) eVar, aVar));
                } else {
                    if (eVar instanceof c) {
                        fVar = new c((c) eVar);
                    } else if (eVar instanceof b) {
                        fVar = new b((b) eVar);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.f4490b.add(fVar);
                    String str2 = fVar.f4503b;
                    if (str2 != null) {
                        aVar.put(str2, fVar);
                    }
                }
            }
        }

        private void d() {
            this.f4498j.reset();
            this.f4498j.postTranslate(-this.f4492d, -this.f4493e);
            this.f4498j.postScale(this.f4494f, this.f4495g);
            this.f4498j.postRotate(this.f4491c, 0.0f, 0.0f);
            this.f4498j.postTranslate(this.f4496h + this.f4492d, this.f4497i + this.f4493e);
        }

        private void e(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f4500l = null;
            this.f4491c = a0.i.j(typedArray, xmlPullParser, "rotation", 5, this.f4491c);
            this.f4492d = typedArray.getFloat(1, this.f4492d);
            this.f4493e = typedArray.getFloat(2, this.f4493e);
            this.f4494f = a0.i.j(typedArray, xmlPullParser, "scaleX", 3, this.f4494f);
            this.f4495g = a0.i.j(typedArray, xmlPullParser, "scaleY", 4, this.f4495g);
            this.f4496h = a0.i.j(typedArray, xmlPullParser, "translateX", 6, this.f4496h);
            this.f4497i = a0.i.j(typedArray, xmlPullParser, "translateY", 7, this.f4497i);
            String string = typedArray.getString(0);
            if (string != null) {
                this.f4501m = string;
            }
            d();
        }

        @Override // androidx.vectordrawable.graphics.drawable.i.e
        public boolean a() {
            for (int i10 = 0; i10 < this.f4490b.size(); i10++) {
                if (this.f4490b.get(i10).a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.vectordrawable.graphics.drawable.i.e
        public boolean b(int[] iArr) {
            boolean z10 = false;
            for (int i10 = 0; i10 < this.f4490b.size(); i10++) {
                z10 |= this.f4490b.get(i10).b(iArr);
            }
            return z10;
        }

        public void c(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray s10 = a0.i.s(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f4441b);
            e(s10, xmlPullParser);
            s10.recycle();
        }

        public String getGroupName() {
            return this.f4501m;
        }

        public Matrix getLocalMatrix() {
            return this.f4498j;
        }

        public float getPivotX() {
            return this.f4492d;
        }

        public float getPivotY() {
            return this.f4493e;
        }

        public float getRotation() {
            return this.f4491c;
        }

        public float getScaleX() {
            return this.f4494f;
        }

        public float getScaleY() {
            return this.f4495g;
        }

        public float getTranslateX() {
            return this.f4496h;
        }

        public float getTranslateY() {
            return this.f4497i;
        }

        public void setPivotX(float f10) {
            if (f10 != this.f4492d) {
                this.f4492d = f10;
                d();
            }
        }

        public void setPivotY(float f10) {
            if (f10 != this.f4493e) {
                this.f4493e = f10;
                d();
            }
        }

        public void setRotation(float f10) {
            if (f10 != this.f4491c) {
                this.f4491c = f10;
                d();
            }
        }

        public void setScaleX(float f10) {
            if (f10 != this.f4494f) {
                this.f4494f = f10;
                d();
            }
        }

        public void setScaleY(float f10) {
            if (f10 != this.f4495g) {
                this.f4495g = f10;
                d();
            }
        }

        public void setTranslateX(float f10) {
            if (f10 != this.f4496h) {
                this.f4496h = f10;
                d();
            }
        }

        public void setTranslateY(float f10) {
            if (f10 != this.f4497i) {
                this.f4497i = f10;
                d();
            }
        }

        public d() {
            super();
            this.f4489a = new Matrix();
            this.f4490b = new ArrayList<>();
            this.f4491c = 0.0f;
            this.f4492d = 0.0f;
            this.f4493e = 0.0f;
            this.f4494f = 1.0f;
            this.f4495g = 1.0f;
            this.f4496h = 0.0f;
            this.f4497i = 0.0f;
            this.f4498j = new Matrix();
            this.f4501m = null;
        }
    }
}
