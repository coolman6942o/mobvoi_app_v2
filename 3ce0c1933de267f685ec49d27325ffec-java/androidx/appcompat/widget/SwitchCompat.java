package androidx.appcompat.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.core.view.d0;
import androidx.core.widget.j;
import androidx.emoji2.text.d;
import d.h;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class SwitchCompat extends CompoundButton {
    private static final Property<SwitchCompat, Float> R = new a(Float.class, "thumbPos");
    private static final int[] S = {16842912};
    private int A;
    private int B;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private final TextPaint H;
    private ColorStateList I;
    private Layout J;
    private Layout K;
    private TransformationMethod L;
    ObjectAnimator M;
    private final a0 N;
    private m O;
    private b P;
    private final Rect Q;

    /* renamed from: a  reason: collision with root package name */
    private Drawable f993a;

    /* renamed from: b  reason: collision with root package name */
    private ColorStateList f994b;

    /* renamed from: c  reason: collision with root package name */
    private PorterDuff.Mode f995c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f996d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f997e;

    /* renamed from: f  reason: collision with root package name */
    private Drawable f998f;

    /* renamed from: g  reason: collision with root package name */
    private ColorStateList f999g;

    /* renamed from: h  reason: collision with root package name */
    private PorterDuff.Mode f1000h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f1001i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f1002j;

    /* renamed from: k  reason: collision with root package name */
    private int f1003k;

    /* renamed from: l  reason: collision with root package name */
    private int f1004l;

    /* renamed from: m  reason: collision with root package name */
    private int f1005m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f1006n;

    /* renamed from: o  reason: collision with root package name */
    private CharSequence f1007o;

    /* renamed from: p  reason: collision with root package name */
    private CharSequence f1008p;

    /* renamed from: q  reason: collision with root package name */
    private CharSequence f1009q;

    /* renamed from: r  reason: collision with root package name */
    private CharSequence f1010r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f1011s;

    /* renamed from: t  reason: collision with root package name */
    private int f1012t;

    /* renamed from: u  reason: collision with root package name */
    private int f1013u;

    /* renamed from: v  reason: collision with root package name */
    private float f1014v;

    /* renamed from: w  reason: collision with root package name */
    private float f1015w;

    /* renamed from: x  reason: collision with root package name */
    private VelocityTracker f1016x;

    /* renamed from: y  reason: collision with root package name */
    private int f1017y;

    /* renamed from: z  reason: collision with root package name */
    float f1018z;

    /* loaded from: classes.dex */
    class a extends Property<SwitchCompat, Float> {
        a(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: a */
        public Float get(SwitchCompat switchCompat) {
            return Float.valueOf(switchCompat.f1018z);
        }

        /* renamed from: b */
        public void set(SwitchCompat switchCompat, Float f10) {
            switchCompat.setThumbPosition(f10.floatValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b extends d.e {

        /* renamed from: a  reason: collision with root package name */
        private final Reference<SwitchCompat> f1019a;

        b(SwitchCompat switchCompat) {
            this.f1019a = new WeakReference(switchCompat);
        }

        @Override // androidx.emoji2.text.d.e
        public void a(Throwable th2) {
            SwitchCompat switchCompat = this.f1019a.get();
            if (switchCompat != null) {
                switchCompat.j();
            }
        }

        @Override // androidx.emoji2.text.d.e
        public void b() {
            SwitchCompat switchCompat = this.f1019a.get();
            if (switchCompat != null) {
                switchCompat.j();
            }
        }
    }

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, d.a.N);
    }

    private void a(boolean z10) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, R, z10 ? 1.0f : 0.0f);
        this.M = ofFloat;
        ofFloat.setDuration(250L);
        if (Build.VERSION.SDK_INT >= 18) {
            this.M.setAutoCancel(true);
        }
        this.M.start();
    }

    private void b() {
        Drawable drawable = this.f993a;
        if (drawable == null) {
            return;
        }
        if (this.f996d || this.f997e) {
            Drawable mutate = androidx.core.graphics.drawable.a.r(drawable).mutate();
            this.f993a = mutate;
            if (this.f996d) {
                androidx.core.graphics.drawable.a.o(mutate, this.f994b);
            }
            if (this.f997e) {
                androidx.core.graphics.drawable.a.p(this.f993a, this.f995c);
            }
            if (this.f993a.isStateful()) {
                this.f993a.setState(getDrawableState());
            }
        }
    }

    private void c() {
        Drawable drawable = this.f998f;
        if (drawable == null) {
            return;
        }
        if (this.f1001i || this.f1002j) {
            Drawable mutate = androidx.core.graphics.drawable.a.r(drawable).mutate();
            this.f998f = mutate;
            if (this.f1001i) {
                androidx.core.graphics.drawable.a.o(mutate, this.f999g);
            }
            if (this.f1002j) {
                androidx.core.graphics.drawable.a.p(this.f998f, this.f1000h);
            }
            if (this.f998f.isStateful()) {
                this.f998f.setState(getDrawableState());
            }
        }
    }

    private void d() {
        ObjectAnimator objectAnimator = this.M;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    private void e(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(3);
        super.onTouchEvent(obtain);
        obtain.recycle();
    }

    private static float f(float f10, float f11, float f12) {
        return f10 < f11 ? f11 : f10 > f12 ? f12 : f10;
    }

    private CharSequence g(CharSequence charSequence) {
        TransformationMethod f10 = getEmojiTextViewHelper().f(this.L);
        return f10 != null ? f10.getTransformation(charSequence, this) : charSequence;
    }

    private m getEmojiTextViewHelper() {
        if (this.O == null) {
            this.O = new m(this);
        }
        return this.O;
    }

    private boolean getTargetCheckedState() {
        return this.f1018z > 0.5f;
    }

    private int getThumbOffset() {
        float f10;
        if (e1.b(this)) {
            f10 = 1.0f - this.f1018z;
        } else {
            f10 = this.f1018z;
        }
        return (int) ((f10 * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Rect rect;
        Drawable drawable = this.f998f;
        if (drawable == null) {
            return 0;
        }
        Rect rect2 = this.Q;
        drawable.getPadding(rect2);
        Drawable drawable2 = this.f993a;
        if (drawable2 != null) {
            rect = g0.d(drawable2);
        } else {
            rect = g0.f1161c;
        }
        return ((((this.A - this.C) - rect2.left) - rect2.right) - rect.left) - rect.right;
    }

    private boolean h(float f10, float f11) {
        if (this.f993a == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.f993a.getPadding(this.Q);
        int i10 = this.E;
        int i11 = this.f1013u;
        int i12 = i10 - i11;
        int i13 = (this.D + thumbOffset) - i11;
        Rect rect = this.Q;
        return f10 > ((float) i13) && f10 < ((float) ((((this.C + i13) + rect.left) + rect.right) + i11)) && f11 > ((float) i12) && f11 < ((float) (this.G + i11));
    }

    private Layout i(CharSequence charSequence) {
        TextPaint textPaint = this.H;
        return new StaticLayout(charSequence, textPaint, charSequence != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence, textPaint)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    private void k() {
        if (Build.VERSION.SDK_INT >= 30) {
            CharSequence charSequence = this.f1009q;
            if (charSequence == null) {
                charSequence = getResources().getString(h.f24836b);
            }
            d0.L0(this, charSequence);
        }
    }

    private void l() {
        if (Build.VERSION.SDK_INT >= 30) {
            CharSequence charSequence = this.f1007o;
            if (charSequence == null) {
                charSequence = getResources().getString(h.f24837c);
            }
            d0.L0(this, charSequence);
        }
    }

    private void o(int i10, int i11) {
        Typeface typeface;
        if (i10 == 1) {
            typeface = Typeface.SANS_SERIF;
        } else if (i10 != 2) {
            typeface = i10 != 3 ? null : Typeface.MONOSPACE;
        } else {
            typeface = Typeface.SERIF;
        }
        n(typeface, i11);
    }

    private void p() {
        if (this.P == null && this.O.b() && d.h()) {
            d b10 = d.b();
            int d10 = b10.d();
            if (d10 == 3 || d10 == 0) {
                b bVar = new b(this);
                this.P = bVar;
                b10.s(bVar);
            }
        }
    }

    private void q(MotionEvent motionEvent) {
        this.f1012t = 0;
        boolean z10 = true;
        boolean z11 = motionEvent.getAction() == 1 && isEnabled();
        boolean isChecked = isChecked();
        if (z11) {
            this.f1016x.computeCurrentVelocity(1000);
            float xVelocity = this.f1016x.getXVelocity();
            if (Math.abs(xVelocity) <= this.f1017y) {
                z10 = getTargetCheckedState();
            } else if (!e1.b(this) ? xVelocity <= 0.0f : xVelocity >= 0.0f) {
                z10 = false;
            }
        } else {
            z10 = isChecked;
        }
        if (z10 != isChecked) {
            playSoundEffect(0);
        }
        setChecked(z10);
        e(motionEvent);
    }

    private void setTextOffInternal(CharSequence charSequence) {
        this.f1009q = charSequence;
        this.f1010r = g(charSequence);
        this.K = null;
        if (this.f1011s) {
            p();
        }
    }

    private void setTextOnInternal(CharSequence charSequence) {
        this.f1007o = charSequence;
        this.f1008p = g(charSequence);
        this.J = null;
        if (this.f1011s) {
            p();
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Rect rect;
        int i10;
        int i11;
        Rect rect2 = this.Q;
        int i12 = this.D;
        int i13 = this.E;
        int i14 = this.F;
        int i15 = this.G;
        int thumbOffset = getThumbOffset() + i12;
        Drawable drawable = this.f993a;
        if (drawable != null) {
            rect = g0.d(drawable);
        } else {
            rect = g0.f1161c;
        }
        Drawable drawable2 = this.f998f;
        if (drawable2 != null) {
            drawable2.getPadding(rect2);
            int i16 = rect2.left;
            thumbOffset += i16;
            if (rect != null) {
                int i17 = rect.left;
                if (i17 > i16) {
                    i12 += i17 - i16;
                }
                int i18 = rect.top;
                int i19 = rect2.top;
                i10 = i18 > i19 ? (i18 - i19) + i13 : i13;
                int i20 = rect.right;
                int i21 = rect2.right;
                if (i20 > i21) {
                    i14 -= i20 - i21;
                }
                int i22 = rect.bottom;
                int i23 = rect2.bottom;
                if (i22 > i23) {
                    i11 = i15 - (i22 - i23);
                    this.f998f.setBounds(i12, i10, i14, i11);
                }
            } else {
                i10 = i13;
            }
            i11 = i15;
            this.f998f.setBounds(i12, i10, i14, i11);
        }
        Drawable drawable3 = this.f993a;
        if (drawable3 != null) {
            drawable3.getPadding(rect2);
            int i24 = thumbOffset - rect2.left;
            int i25 = thumbOffset + this.C + rect2.right;
            this.f993a.setBounds(i24, i13, i25, i15);
            Drawable background = getBackground();
            if (background != null) {
                androidx.core.graphics.drawable.a.l(background, i24, i13, i25, i15);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableHotspotChanged(float f10, float f11) {
        if (Build.VERSION.SDK_INT >= 21) {
            super.drawableHotspotChanged(f10, f11);
        }
        Drawable drawable = this.f993a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.k(drawable, f10, f11);
        }
        Drawable drawable2 = this.f998f;
        if (drawable2 != null) {
            androidx.core.graphics.drawable.a.k(drawable2, f10, f11);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f993a;
        boolean z10 = false;
        if (drawable != null && drawable.isStateful()) {
            z10 = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.f998f;
        if (drawable2 != null && drawable2.isStateful()) {
            z10 |= drawable2.setState(drawableState);
        }
        if (z10) {
            invalidate();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (!e1.b(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.A;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.f1005m : compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (e1.b(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.A;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.f1005m : compoundPaddingRight;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return j.s(super.getCustomSelectionActionModeCallback());
    }

    public boolean getShowText() {
        return this.f1011s;
    }

    public boolean getSplitTrack() {
        return this.f1006n;
    }

    public int getSwitchMinWidth() {
        return this.f1004l;
    }

    public int getSwitchPadding() {
        return this.f1005m;
    }

    public CharSequence getTextOff() {
        return this.f1009q;
    }

    public CharSequence getTextOn() {
        return this.f1007o;
    }

    public Drawable getThumbDrawable() {
        return this.f993a;
    }

    public int getThumbTextPadding() {
        return this.f1003k;
    }

    public ColorStateList getThumbTintList() {
        return this.f994b;
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.f995c;
    }

    public Drawable getTrackDrawable() {
        return this.f998f;
    }

    public ColorStateList getTrackTintList() {
        return this.f999g;
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.f1000h;
    }

    void j() {
        setTextOnInternal(this.f1007o);
        setTextOffInternal(this.f1009q);
        requestLayout();
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f993a;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        Drawable drawable2 = this.f998f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
        }
        ObjectAnimator objectAnimator = this.M;
        if (objectAnimator != null && objectAnimator.isStarted()) {
            this.M.end();
            this.M = null;
        }
    }

    public void m(Context context, int i10) {
        x0 t10 = x0.t(context, i10, d.j.V2);
        ColorStateList c10 = t10.c(d.j.Z2);
        if (c10 != null) {
            this.I = c10;
        } else {
            this.I = getTextColors();
        }
        int f10 = t10.f(d.j.W2, 0);
        if (f10 != 0) {
            float f11 = f10;
            if (f11 != this.H.getTextSize()) {
                this.H.setTextSize(f11);
                requestLayout();
            }
        }
        o(t10.k(d.j.X2, -1), t10.k(d.j.Y2, -1));
        if (t10.a(d.j.f24888g3, false)) {
            this.L = new h.a(getContext());
        } else {
            this.L = null;
        }
        setTextOnInternal(this.f1007o);
        setTextOffInternal(this.f1009q);
        t10.w();
    }

    public void n(Typeface typeface, int i10) {
        Typeface typeface2;
        float f10 = 0.0f;
        boolean z10 = false;
        if (i10 > 0) {
            if (typeface == null) {
                typeface2 = Typeface.defaultFromStyle(i10);
            } else {
                typeface2 = Typeface.create(typeface, i10);
            }
            setSwitchTypeface(typeface2);
            int i11 = (~(typeface2 != null ? typeface2.getStyle() : 0)) & i10;
            TextPaint textPaint = this.H;
            if ((i11 & 1) != 0) {
                z10 = true;
            }
            textPaint.setFakeBoldText(z10);
            TextPaint textPaint2 = this.H;
            if ((i11 & 2) != 0) {
                f10 = -0.25f;
            }
            textPaint2.setTextSkewX(f10);
            return;
        }
        this.H.setFakeBoldText(false);
        this.H.setTextSkewX(0.0f);
        setSwitchTypeface(typeface);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i10) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i10 + 1);
        if (isChecked()) {
            CompoundButton.mergeDrawableStates(onCreateDrawableState, S);
        }
        return onCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        int i10;
        super.onDraw(canvas);
        Rect rect = this.Q;
        Drawable drawable = this.f998f;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i11 = this.E;
        int i12 = this.G;
        int i13 = i11 + rect.top;
        int i14 = i12 - rect.bottom;
        Drawable drawable2 = this.f993a;
        if (drawable != null) {
            if (!this.f1006n || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect d10 = g0.d(drawable2);
                drawable2.copyBounds(rect);
                rect.left += d10.left;
                rect.right -= d10.right;
                int save = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(save);
            }
        }
        int save2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Layout layout = getTargetCheckedState() ? this.J : this.K;
        if (layout != null) {
            int[] drawableState = getDrawableState();
            ColorStateList colorStateList = this.I;
            if (colorStateList != null) {
                this.H.setColor(colorStateList.getColorForState(drawableState, 0));
            }
            this.H.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                i10 = bounds.left + bounds.right;
            } else {
                i10 = getWidth();
            }
            canvas.translate((i10 / 2) - (layout.getWidth() / 2), ((i13 + i14) / 2) - (layout.getHeight() / 2));
            layout.draw(canvas);
        }
        canvas.restoreToCount(save2);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
        if (Build.VERSION.SDK_INT < 30) {
            CharSequence charSequence = isChecked() ? this.f1007o : this.f1009q;
            if (!TextUtils.isEmpty(charSequence)) {
                CharSequence text = accessibilityNodeInfo.getText();
                if (TextUtils.isEmpty(text)) {
                    accessibilityNodeInfo.setText(charSequence);
                    return;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append(text);
                sb2.append(' ');
                sb2.append(charSequence);
                accessibilityNodeInfo.setText(sb2);
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        super.onLayout(z10, i10, i11, i12, i13);
        int i20 = 0;
        if (this.f993a != null) {
            Rect rect = this.Q;
            Drawable drawable = this.f998f;
            if (drawable != null) {
                drawable.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect d10 = g0.d(this.f993a);
            i14 = Math.max(0, d10.left - rect.left);
            i20 = Math.max(0, d10.right - rect.right);
        } else {
            i14 = 0;
        }
        if (e1.b(this)) {
            i16 = getPaddingLeft() + i14;
            i15 = ((this.A + i16) - i14) - i20;
        } else {
            i15 = (getWidth() - getPaddingRight()) - i20;
            i16 = (i15 - this.A) + i14 + i20;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            i19 = this.B;
            i18 = (((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2) - (i19 / 2);
        } else if (gravity != 80) {
            i18 = getPaddingTop();
            i19 = this.B;
        } else {
            i17 = getHeight() - getPaddingBottom();
            i18 = i17 - this.B;
            this.D = i16;
            this.E = i18;
            this.G = i17;
            this.F = i15;
        }
        i17 = i19 + i18;
        this.D = i16;
        this.E = i18;
        this.G = i17;
        this.F = i15;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i10, int i11) {
        int i12;
        int i13;
        if (this.f1011s) {
            if (this.J == null) {
                this.J = i(this.f1008p);
            }
            if (this.K == null) {
                this.K = i(this.f1010r);
            }
        }
        Rect rect = this.Q;
        Drawable drawable = this.f993a;
        int i14 = 0;
        if (drawable != null) {
            drawable.getPadding(rect);
            i13 = (this.f993a.getIntrinsicWidth() - rect.left) - rect.right;
            i12 = this.f993a.getIntrinsicHeight();
        } else {
            i13 = 0;
            i12 = 0;
        }
        this.C = Math.max(this.f1011s ? Math.max(this.J.getWidth(), this.K.getWidth()) + (this.f1003k * 2) : 0, i13);
        Drawable drawable2 = this.f998f;
        if (drawable2 != null) {
            drawable2.getPadding(rect);
            i14 = this.f998f.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int i15 = rect.left;
        int i16 = rect.right;
        Drawable drawable3 = this.f993a;
        if (drawable3 != null) {
            Rect d10 = g0.d(drawable3);
            i15 = Math.max(i15, d10.left);
            i16 = Math.max(i16, d10.right);
        }
        int max = Math.max(this.f1004l, (this.C * 2) + i15 + i16);
        int max2 = Math.max(i14, i12);
        this.A = max;
        this.B = max2;
        super.onMeasure(i10, i11);
        if (getMeasuredHeight() < max2) {
            setMeasuredDimension(getMeasuredWidthAndState(), max2);
        }
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.f1007o : this.f1009q;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0012, code lost:
        if (r0 != 3) goto L42;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f1016x.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i10 = this.f1012t;
                    if (i10 == 1) {
                        float x10 = motionEvent.getX();
                        float y10 = motionEvent.getY();
                        if (Math.abs(x10 - this.f1014v) > this.f1013u || Math.abs(y10 - this.f1015w) > this.f1013u) {
                            this.f1012t = 2;
                            getParent().requestDisallowInterceptTouchEvent(true);
                            this.f1014v = x10;
                            this.f1015w = y10;
                            return true;
                        }
                    } else if (i10 == 2) {
                        float x11 = motionEvent.getX();
                        int thumbScrollRange = getThumbScrollRange();
                        float f10 = x11 - this.f1014v;
                        float f11 = thumbScrollRange != 0 ? f10 / thumbScrollRange : f10 > 0.0f ? 1.0f : -1.0f;
                        if (e1.b(this)) {
                            f11 = -f11;
                        }
                        float f12 = f(this.f1018z + f11, 0.0f, 1.0f);
                        if (f12 != this.f1018z) {
                            this.f1014v = x11;
                            setThumbPosition(f12);
                        }
                        return true;
                    }
                }
            }
            if (this.f1012t == 2) {
                q(motionEvent);
                super.onTouchEvent(motionEvent);
                return true;
            }
            this.f1012t = 0;
            this.f1016x.clear();
        } else {
            float x12 = motionEvent.getX();
            float y11 = motionEvent.getY();
            if (isEnabled() && h(x12, y11)) {
                this.f1012t = 1;
                this.f1014v = x12;
                this.f1015w = y11;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z10) {
        super.setAllCaps(z10);
        getEmojiTextViewHelper().d(z10);
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z10) {
        super.setChecked(z10);
        boolean isChecked = isChecked();
        if (isChecked) {
            l();
        } else {
            k();
        }
        if (getWindowToken() == null || !d0.X(this)) {
            d();
            setThumbPosition(isChecked ? 1.0f : 0.0f);
            return;
        }
        a(isChecked);
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(j.t(this, callback));
    }

    public void setEmojiCompatEnabled(boolean z10) {
        getEmojiTextViewHelper().e(z10);
        setTextOnInternal(this.f1007o);
        setTextOffInternal(this.f1009q);
        requestLayout();
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setShowText(boolean z10) {
        if (this.f1011s != z10) {
            this.f1011s = z10;
            requestLayout();
            if (z10) {
                p();
            }
        }
    }

    public void setSplitTrack(boolean z10) {
        this.f1006n = z10;
        invalidate();
    }

    public void setSwitchMinWidth(int i10) {
        this.f1004l = i10;
        requestLayout();
    }

    public void setSwitchPadding(int i10) {
        this.f1005m = i10;
        requestLayout();
    }

    public void setSwitchTypeface(Typeface typeface) {
        if ((this.H.getTypeface() != null && !this.H.getTypeface().equals(typeface)) || (this.H.getTypeface() == null && typeface != null)) {
            this.H.setTypeface(typeface);
            requestLayout();
            invalidate();
        }
    }

    public void setTextOff(CharSequence charSequence) {
        setTextOffInternal(charSequence);
        requestLayout();
        if (!isChecked()) {
            k();
        }
    }

    public void setTextOn(CharSequence charSequence) {
        setTextOnInternal(charSequence);
        requestLayout();
        if (isChecked()) {
            l();
        }
    }

    public void setThumbDrawable(Drawable drawable) {
        Drawable drawable2 = this.f993a;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f993a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    void setThumbPosition(float f10) {
        this.f1018z = f10;
        invalidate();
    }

    public void setThumbResource(int i10) {
        setThumbDrawable(e.a.b(getContext(), i10));
    }

    public void setThumbTextPadding(int i10) {
        this.f1003k = i10;
        requestLayout();
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.f994b = colorStateList;
        this.f996d = true;
        b();
    }

    public void setThumbTintMode(PorterDuff.Mode mode) {
        this.f995c = mode;
        this.f997e = true;
        b();
    }

    public void setTrackDrawable(Drawable drawable) {
        Drawable drawable2 = this.f998f;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.f998f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i10) {
        setTrackDrawable(e.a.b(getContext(), i10));
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.f999g = colorStateList;
        this.f1001i = true;
        c();
    }

    public void setTrackTintMode(PorterDuff.Mode mode) {
        this.f1000h = mode;
        this.f1002j = true;
        c();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f993a || drawable == this.f998f;
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f994b = null;
        this.f995c = null;
        this.f996d = false;
        this.f997e = false;
        this.f999g = null;
        this.f1000h = null;
        this.f1001i = false;
        this.f1002j = false;
        this.f1016x = VelocityTracker.obtain();
        this.Q = new Rect();
        s0.a(this, getContext());
        TextPaint textPaint = new TextPaint(1);
        this.H = textPaint;
        textPaint.density = getResources().getDisplayMetrics().density;
        int[] iArr = d.j.G2;
        x0 v10 = x0.v(context, attributeSet, iArr, i10, 0);
        d0.r0(this, context, iArr, attributeSet, v10.r(), i10, 0);
        Drawable g10 = v10.g(d.j.J2);
        this.f993a = g10;
        if (g10 != null) {
            g10.setCallback(this);
        }
        Drawable g11 = v10.g(d.j.S2);
        this.f998f = g11;
        if (g11 != null) {
            g11.setCallback(this);
        }
        setTextOnInternal(v10.p(d.j.H2));
        setTextOffInternal(v10.p(d.j.I2));
        this.f1011s = v10.a(d.j.K2, true);
        this.f1003k = v10.f(d.j.P2, 0);
        this.f1004l = v10.f(d.j.M2, 0);
        this.f1005m = v10.f(d.j.N2, 0);
        this.f1006n = v10.a(d.j.L2, false);
        ColorStateList c10 = v10.c(d.j.Q2);
        if (c10 != null) {
            this.f994b = c10;
            this.f996d = true;
        }
        PorterDuff.Mode e10 = g0.e(v10.k(d.j.R2, -1), null);
        if (this.f995c != e10) {
            this.f995c = e10;
            this.f997e = true;
        }
        if (this.f996d || this.f997e) {
            b();
        }
        ColorStateList c11 = v10.c(d.j.T2);
        if (c11 != null) {
            this.f999g = c11;
            this.f1001i = true;
        }
        PorterDuff.Mode e11 = g0.e(v10.k(d.j.U2, -1), null);
        if (this.f1000h != e11) {
            this.f1000h = e11;
            this.f1002j = true;
        }
        if (this.f1001i || this.f1002j) {
            c();
        }
        int n10 = v10.n(d.j.O2, 0);
        if (n10 != 0) {
            m(context, n10);
        }
        a0 a0Var = new a0(this);
        this.N = a0Var;
        a0Var.m(attributeSet, i10);
        v10.w();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f1013u = viewConfiguration.getScaledTouchSlop();
        this.f1017y = viewConfiguration.getScaledMinimumFlingVelocity();
        getEmojiTextViewHelper().c(attributeSet, i10);
        refreshDrawableState();
        setChecked(isChecked());
    }
}
