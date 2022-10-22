package com.google.android.material.badge;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.d0;
import com.google.android.material.internal.h;
import d7.b;
import d7.d;
import d7.f;
import d7.i;
import d7.j;
import d7.k;
import d7.l;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;
import t7.c;
import w7.g;
/* loaded from: classes.dex */
public class BadgeDrawable extends Drawable implements h.b {

    /* renamed from: q  reason: collision with root package name */
    private static final int f10407q = k.f25350o;

    /* renamed from: r  reason: collision with root package name */
    private static final int f10408r = b.f25148d;

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<Context> f10409a;

    /* renamed from: c  reason: collision with root package name */
    private final h f10411c;

    /* renamed from: e  reason: collision with root package name */
    private float f10413e;

    /* renamed from: f  reason: collision with root package name */
    private float f10414f;

    /* renamed from: g  reason: collision with root package name */
    private float f10415g;

    /* renamed from: h  reason: collision with root package name */
    private final SavedState f10416h;

    /* renamed from: i  reason: collision with root package name */
    private float f10417i;

    /* renamed from: j  reason: collision with root package name */
    private float f10418j;

    /* renamed from: k  reason: collision with root package name */
    private int f10419k;

    /* renamed from: l  reason: collision with root package name */
    private float f10420l;

    /* renamed from: m  reason: collision with root package name */
    private float f10421m;

    /* renamed from: n  reason: collision with root package name */
    private float f10422n;

    /* renamed from: o  reason: collision with root package name */
    private WeakReference<View> f10423o;

    /* renamed from: p  reason: collision with root package name */
    private WeakReference<FrameLayout> f10424p;

    /* renamed from: d  reason: collision with root package name */
    private final Rect f10412d = new Rect();

    /* renamed from: b  reason: collision with root package name */
    private final g f10410b = new g();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f10441a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ FrameLayout f10442b;

        a(View view, FrameLayout frameLayout) {
            this.f10441a = view;
            this.f10442b = frameLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            BadgeDrawable.this.L(this.f10441a, this.f10442b);
        }
    }

    private BadgeDrawable(Context context) {
        this.f10409a = new WeakReference<>(context);
        com.google.android.material.internal.k.c(context);
        Resources resources = context.getResources();
        this.f10413e = resources.getDimensionPixelSize(d.T);
        this.f10415g = resources.getDimensionPixelSize(d.S);
        this.f10414f = resources.getDimensionPixelSize(d.V);
        h hVar = new h(this);
        this.f10411c = hVar;
        hVar.e().setTextAlign(Paint.Align.CENTER);
        this.f10416h = new SavedState(context);
        F(k.f25340e);
    }

    private void E(t7.d dVar) {
        Context context;
        if (this.f10411c.d() != dVar && (context = this.f10409a.get()) != null) {
            this.f10411c.h(dVar, context);
            M();
        }
    }

    private void F(int i10) {
        Context context = this.f10409a.get();
        if (context != null) {
            E(new t7.d(context, i10));
        }
    }

    private void J(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup == null || viewGroup.getId() != f.E) {
            WeakReference<FrameLayout> weakReference = this.f10424p;
            if (weakReference == null || weakReference.get() != viewGroup) {
                K(view);
                FrameLayout frameLayout = new FrameLayout(view.getContext());
                frameLayout.setId(f.E);
                frameLayout.setClipChildren(false);
                frameLayout.setClipToPadding(false);
                frameLayout.setLayoutParams(view.getLayoutParams());
                frameLayout.setMinimumWidth(view.getWidth());
                frameLayout.setMinimumHeight(view.getHeight());
                int indexOfChild = viewGroup.indexOfChild(view);
                viewGroup.removeViewAt(indexOfChild);
                view.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
                frameLayout.addView(view);
                viewGroup.addView(frameLayout, indexOfChild);
                this.f10424p = new WeakReference<>(frameLayout);
                frameLayout.post(new a(view, frameLayout));
            }
        }
    }

    private static void K(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        viewGroup.setClipChildren(false);
        viewGroup.setClipToPadding(false);
    }

    private void M() {
        Context context = this.f10409a.get();
        WeakReference<View> weakReference = this.f10423o;
        FrameLayout frameLayout = null;
        View view = weakReference != null ? weakReference.get() : null;
        if (context != null && view != null) {
            Rect rect = new Rect();
            rect.set(this.f10412d);
            Rect rect2 = new Rect();
            view.getDrawingRect(rect2);
            WeakReference<FrameLayout> weakReference2 = this.f10424p;
            if (weakReference2 != null) {
                frameLayout = weakReference2.get();
            }
            if (frameLayout != null || com.google.android.material.badge.a.f10444a) {
                if (frameLayout == null) {
                    frameLayout = (ViewGroup) view.getParent();
                }
                frameLayout.offsetDescendantRectToMyCoords(view, rect2);
            }
            b(context, rect2, view);
            com.google.android.material.badge.a.f(this.f10412d, this.f10417i, this.f10418j, this.f10421m, this.f10422n);
            this.f10410b.W(this.f10420l);
            if (!rect.equals(this.f10412d)) {
                this.f10410b.setBounds(this.f10412d);
            }
        }
    }

    private void N() {
        this.f10419k = ((int) Math.pow(10.0d, l() - 1.0d)) - 1;
    }

    private void b(Context context, Rect rect, View view) {
        int p10 = p();
        int i10 = this.f10416h.f10433i;
        if (i10 == 8388691 || i10 == 8388693) {
            this.f10418j = rect.bottom - p10;
        } else {
            this.f10418j = rect.top + p10;
        }
        if (m() <= 9) {
            float f10 = !r() ? this.f10413e : this.f10414f;
            this.f10420l = f10;
            this.f10422n = f10;
            this.f10421m = f10;
        } else {
            float f11 = this.f10414f;
            this.f10420l = f11;
            this.f10422n = f11;
            this.f10421m = (this.f10411c.f(g()) / 2.0f) + this.f10415g;
        }
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(r() ? d.U : d.R);
        int o10 = o();
        int i11 = this.f10416h.f10433i;
        if (i11 == 8388659 || i11 == 8388691) {
            this.f10417i = d0.E(view) == 0 ? (rect.left - this.f10421m) + dimensionPixelSize + o10 : ((rect.right + this.f10421m) - dimensionPixelSize) - o10;
        } else {
            this.f10417i = d0.E(view) == 0 ? ((rect.right + this.f10421m) - dimensionPixelSize) - o10 : (rect.left - this.f10421m) + dimensionPixelSize + o10;
        }
    }

    public static BadgeDrawable c(Context context) {
        return d(context, null, f10408r, f10407q);
    }

    private static BadgeDrawable d(Context context, AttributeSet attributeSet, int i10, int i11) {
        BadgeDrawable badgeDrawable = new BadgeDrawable(context);
        badgeDrawable.s(context, attributeSet, i10, i11);
        return badgeDrawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BadgeDrawable e(Context context, SavedState savedState) {
        BadgeDrawable badgeDrawable = new BadgeDrawable(context);
        badgeDrawable.u(savedState);
        return badgeDrawable;
    }

    private void f(Canvas canvas) {
        Rect rect = new Rect();
        String g10 = g();
        this.f10411c.e().getTextBounds(g10, 0, g10.length(), rect);
        canvas.drawText(g10, this.f10417i, this.f10418j + (rect.height() / 2), this.f10411c.e());
    }

    private String g() {
        if (m() <= this.f10419k) {
            return NumberFormat.getInstance().format(m());
        }
        Context context = this.f10409a.get();
        return context == null ? "" : context.getString(j.f25329t, Integer.valueOf(this.f10419k), "+");
    }

    private int o() {
        return (r() ? this.f10416h.f10437m : this.f10416h.f10435k) + this.f10416h.f10439o;
    }

    private int p() {
        return (r() ? this.f10416h.f10438n : this.f10416h.f10436l) + this.f10416h.f10440p;
    }

    private void s(Context context, AttributeSet attributeSet, int i10, int i11) {
        TypedArray h10 = com.google.android.material.internal.k.h(context, attributeSet, l.f25466n, i10, i11, new int[0]);
        C(h10.getInt(l.f25537w, 4));
        int i12 = l.f25545x;
        if (h10.hasValue(i12)) {
            D(h10.getInt(i12, 0));
        }
        x(t(context, h10, l.f25474o));
        int i13 = l.f25497r;
        if (h10.hasValue(i13)) {
            z(t(context, h10, i13));
        }
        y(h10.getInt(l.f25482p, 8388661));
        B(h10.getDimensionPixelOffset(l.f25521u, 0));
        H(h10.getDimensionPixelOffset(l.f25553y, 0));
        A(h10.getDimensionPixelOffset(l.f25529v, k()));
        G(h10.getDimensionPixelOffset(l.f25561z, q()));
        int i14 = l.f25490q;
        if (h10.hasValue(i14)) {
            this.f10413e = h10.getDimensionPixelSize(i14, (int) this.f10413e);
        }
        int i15 = l.f25505s;
        if (h10.hasValue(i15)) {
            this.f10415g = h10.getDimensionPixelSize(i15, (int) this.f10415g);
        }
        int i16 = l.f25513t;
        if (h10.hasValue(i16)) {
            this.f10414f = h10.getDimensionPixelSize(i16, (int) this.f10414f);
        }
        h10.recycle();
    }

    private static int t(Context context, TypedArray typedArray, int i10) {
        return c.a(context, typedArray, i10).getDefaultColor();
    }

    private void u(SavedState savedState) {
        C(savedState.f10429e);
        if (savedState.f10428d != -1) {
            D(savedState.f10428d);
        }
        x(savedState.f10425a);
        z(savedState.f10426b);
        y(savedState.f10433i);
        B(savedState.f10435k);
        H(savedState.f10436l);
        A(savedState.f10437m);
        G(savedState.f10438n);
        v(savedState.f10439o);
        w(savedState.f10440p);
        I(savedState.f10434j);
    }

    public void A(int i10) {
        this.f10416h.f10437m = i10;
        M();
    }

    public void B(int i10) {
        this.f10416h.f10435k = i10;
        M();
    }

    public void C(int i10) {
        if (this.f10416h.f10429e != i10) {
            this.f10416h.f10429e = i10;
            N();
            this.f10411c.i(true);
            M();
            invalidateSelf();
        }
    }

    public void D(int i10) {
        int max = Math.max(0, i10);
        if (this.f10416h.f10428d != max) {
            this.f10416h.f10428d = max;
            this.f10411c.i(true);
            M();
            invalidateSelf();
        }
    }

    public void G(int i10) {
        this.f10416h.f10438n = i10;
        M();
    }

    public void H(int i10) {
        this.f10416h.f10436l = i10;
        M();
    }

    public void I(boolean z10) {
        setVisible(z10, false);
        this.f10416h.f10434j = z10;
        if (com.google.android.material.badge.a.f10444a && i() != null && !z10) {
            ((ViewGroup) i().getParent()).invalidate();
        }
    }

    public void L(View view, FrameLayout frameLayout) {
        this.f10423o = new WeakReference<>(view);
        boolean z10 = com.google.android.material.badge.a.f10444a;
        if (!z10 || frameLayout != null) {
            this.f10424p = new WeakReference<>(frameLayout);
        } else {
            J(view);
        }
        if (!z10) {
            K(view);
        }
        M();
        invalidateSelf();
    }

    @Override // com.google.android.material.internal.h.b
    public void a() {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!getBounds().isEmpty() && getAlpha() != 0 && isVisible()) {
            this.f10410b.draw(canvas);
            if (r()) {
                f(canvas);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f10416h.f10427c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f10412d.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f10412d.width();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public CharSequence h() {
        Context context;
        if (!isVisible()) {
            return null;
        }
        if (!r()) {
            return this.f10416h.f10430f;
        }
        if (this.f10416h.f10431g <= 0 || (context = this.f10409a.get()) == null) {
            return null;
        }
        if (m() <= this.f10419k) {
            return context.getResources().getQuantityString(this.f10416h.f10431g, m(), Integer.valueOf(m()));
        }
        return context.getString(this.f10416h.f10432h, Integer.valueOf(this.f10419k));
    }

    public FrameLayout i() {
        WeakReference<FrameLayout> weakReference = this.f10424p;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return false;
    }

    public int j() {
        return this.f10416h.f10435k;
    }

    public int k() {
        return this.f10416h.f10435k;
    }

    public int l() {
        return this.f10416h.f10429e;
    }

    public int m() {
        if (!r()) {
            return 0;
        }
        return this.f10416h.f10428d;
    }

    public SavedState n() {
        return this.f10416h;
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.h.b
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    public int q() {
        return this.f10416h.f10436l;
    }

    public boolean r() {
        return this.f10416h.f10428d != -1;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        this.f10416h.f10427c = i10;
        this.f10411c.e().setAlpha(i10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    void v(int i10) {
        this.f10416h.f10439o = i10;
        M();
    }

    void w(int i10) {
        this.f10416h.f10440p = i10;
        M();
    }

    public void x(int i10) {
        this.f10416h.f10425a = i10;
        ColorStateList valueOf = ColorStateList.valueOf(i10);
        if (this.f10410b.x() != valueOf) {
            this.f10410b.Z(valueOf);
            invalidateSelf();
        }
    }

    public void y(int i10) {
        if (this.f10416h.f10433i != i10) {
            this.f10416h.f10433i = i10;
            WeakReference<View> weakReference = this.f10423o;
            if (weakReference != null && weakReference.get() != null) {
                View view = this.f10423o.get();
                WeakReference<FrameLayout> weakReference2 = this.f10424p;
                L(view, weakReference2 != null ? weakReference2.get() : null);
            }
        }
    }

    public void z(int i10) {
        this.f10416h.f10426b = i10;
        if (this.f10411c.e().getColor() != i10) {
            this.f10411c.e().setColor(i10);
            invalidateSelf();
        }
    }

    /* loaded from: classes.dex */
    public static final class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        private int f10425a;

        /* renamed from: b  reason: collision with root package name */
        private int f10426b;

        /* renamed from: c  reason: collision with root package name */
        private int f10427c;

        /* renamed from: d  reason: collision with root package name */
        private int f10428d;

        /* renamed from: e  reason: collision with root package name */
        private int f10429e;

        /* renamed from: f  reason: collision with root package name */
        private CharSequence f10430f;

        /* renamed from: g  reason: collision with root package name */
        private int f10431g;

        /* renamed from: h  reason: collision with root package name */
        private int f10432h;

        /* renamed from: i  reason: collision with root package name */
        private int f10433i;

        /* renamed from: j  reason: collision with root package name */
        private boolean f10434j;

        /* renamed from: k  reason: collision with root package name */
        private int f10435k;

        /* renamed from: l  reason: collision with root package name */
        private int f10436l;

        /* renamed from: m  reason: collision with root package name */
        private int f10437m;

        /* renamed from: n  reason: collision with root package name */
        private int f10438n;

        /* renamed from: o  reason: collision with root package name */
        private int f10439o;

        /* renamed from: p  reason: collision with root package name */
        private int f10440p;

        /* loaded from: classes.dex */
        static class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: b */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        public SavedState(Context context) {
            this.f10427c = 255;
            this.f10428d = -1;
            this.f10426b = new t7.d(context, k.f25340e).i().getDefaultColor();
            this.f10430f = context.getString(j.f25326q);
            this.f10431g = i.f25309a;
            this.f10432h = j.f25328s;
            this.f10434j = true;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            parcel.writeInt(this.f10425a);
            parcel.writeInt(this.f10426b);
            parcel.writeInt(this.f10427c);
            parcel.writeInt(this.f10428d);
            parcel.writeInt(this.f10429e);
            parcel.writeString(this.f10430f.toString());
            parcel.writeInt(this.f10431g);
            parcel.writeInt(this.f10433i);
            parcel.writeInt(this.f10435k);
            parcel.writeInt(this.f10436l);
            parcel.writeInt(this.f10437m);
            parcel.writeInt(this.f10438n);
            parcel.writeInt(this.f10439o);
            parcel.writeInt(this.f10440p);
            parcel.writeInt(this.f10434j ? 1 : 0);
        }

        protected SavedState(Parcel parcel) {
            this.f10427c = 255;
            this.f10428d = -1;
            this.f10425a = parcel.readInt();
            this.f10426b = parcel.readInt();
            this.f10427c = parcel.readInt();
            this.f10428d = parcel.readInt();
            this.f10429e = parcel.readInt();
            this.f10430f = parcel.readString();
            this.f10431g = parcel.readInt();
            this.f10433i = parcel.readInt();
            this.f10435k = parcel.readInt();
            this.f10436l = parcel.readInt();
            this.f10437m = parcel.readInt();
            this.f10438n = parcel.readInt();
            this.f10439o = parcel.readInt();
            this.f10440p = parcel.readInt();
            this.f10434j = parcel.readInt() != 0;
        }
    }
}
