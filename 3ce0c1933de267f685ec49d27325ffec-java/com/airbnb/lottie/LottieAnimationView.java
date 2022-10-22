package com.airbnb.lottie;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.q;
import androidx.core.view.d0;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;
import k3.h;
/* loaded from: classes.dex */
public class LottieAnimationView extends q {

    /* renamed from: v  reason: collision with root package name */
    private static final String f6387v = LottieAnimationView.class.getSimpleName();

    /* renamed from: w  reason: collision with root package name */
    private static final h<Throwable> f6388w = new a();

    /* renamed from: f  reason: collision with root package name */
    private h<Throwable> f6391f;

    /* renamed from: i  reason: collision with root package name */
    private boolean f6394i;

    /* renamed from: j  reason: collision with root package name */
    private String f6395j;

    /* renamed from: k  reason: collision with root package name */
    private int f6396k;

    /* renamed from: t  reason: collision with root package name */
    private m<com.airbnb.lottie.d> f6405t;

    /* renamed from: u  reason: collision with root package name */
    private com.airbnb.lottie.d f6406u;

    /* renamed from: d  reason: collision with root package name */
    private final h<com.airbnb.lottie.d> f6389d = new b();

    /* renamed from: e  reason: collision with root package name */
    private final h<Throwable> f6390e = new c();

    /* renamed from: g  reason: collision with root package name */
    private int f6392g = 0;

    /* renamed from: h  reason: collision with root package name */
    private final f f6393h = new f();

    /* renamed from: l  reason: collision with root package name */
    private boolean f6397l = false;

    /* renamed from: m  reason: collision with root package name */
    private boolean f6398m = false;

    /* renamed from: n  reason: collision with root package name */
    private boolean f6399n = false;

    /* renamed from: o  reason: collision with root package name */
    private boolean f6400o = false;

    /* renamed from: p  reason: collision with root package name */
    private boolean f6401p = true;

    /* renamed from: q  reason: collision with root package name */
    private RenderMode f6402q = RenderMode.AUTOMATIC;

    /* renamed from: r  reason: collision with root package name */
    private Set<j> f6403r = new HashSet();

    /* renamed from: s  reason: collision with root package name */
    private int f6404s = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        String f6407a;

        /* renamed from: b  reason: collision with root package name */
        int f6408b;

        /* renamed from: c  reason: collision with root package name */
        float f6409c;

        /* renamed from: d  reason: collision with root package name */
        boolean f6410d;

        /* renamed from: e  reason: collision with root package name */
        String f6411e;

        /* renamed from: f  reason: collision with root package name */
        int f6412f;

        /* renamed from: g  reason: collision with root package name */
        int f6413g;

        /* loaded from: classes.dex */
        class a implements Parcelable.Creator<SavedState> {
            a() {
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            /* renamed from: b */
            public SavedState[] newArray(int i10) {
                return new SavedState[i10];
            }
        }

        /* synthetic */ SavedState(Parcel parcel, a aVar) {
            this(parcel);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i10) {
            super.writeToParcel(parcel, i10);
            parcel.writeString(this.f6407a);
            parcel.writeFloat(this.f6409c);
            parcel.writeInt(this.f6410d ? 1 : 0);
            parcel.writeString(this.f6411e);
            parcel.writeInt(this.f6412f);
            parcel.writeInt(this.f6413g);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f6407a = parcel.readString();
            this.f6409c = parcel.readFloat();
            this.f6410d = parcel.readInt() != 1 ? false : true;
            this.f6411e = parcel.readString();
            this.f6412f = parcel.readInt();
            this.f6413g = parcel.readInt();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements h<Throwable> {
        a() {
        }

        /* renamed from: b */
        public void a(Throwable th2) {
            if (h.k(th2)) {
                k3.d.d("Unable to load composition.", th2);
                return;
            }
            throw new IllegalStateException("Unable to parse composition", th2);
        }
    }

    /* loaded from: classes.dex */
    class b implements h<com.airbnb.lottie.d> {
        b() {
        }

        /* renamed from: b */
        public void a(com.airbnb.lottie.d dVar) {
            LottieAnimationView.this.setComposition(dVar);
        }
    }

    /* loaded from: classes.dex */
    class c implements h<Throwable> {
        c() {
        }

        /* renamed from: b */
        public void a(Throwable th2) {
            if (LottieAnimationView.this.f6392g != 0) {
                LottieAnimationView lottieAnimationView = LottieAnimationView.this;
                lottieAnimationView.setImageResource(lottieAnimationView.f6392g);
            }
            (LottieAnimationView.this.f6391f == null ? LottieAnimationView.f6388w : LottieAnimationView.this.f6391f).a(th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static /* synthetic */ class d {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f6416a;

        static {
            int[] iArr = new int[RenderMode.values().length];
            f6416a = iArr;
            try {
                iArr[RenderMode.HARDWARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6416a[RenderMode.SOFTWARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6416a[RenderMode.AUTOMATIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        l(attributeSet);
    }

    private void h() {
        m<com.airbnb.lottie.d> mVar = this.f6405t;
        if (mVar != null) {
            mVar.k(this.f6389d);
            this.f6405t.j(this.f6390e);
        }
    }

    private void i() {
        this.f6406u = null;
        this.f6393h.f();
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003b, code lost:
        if (r3 != false) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void k() {
        com.airbnb.lottie.d dVar;
        int i10 = d.f6416a[this.f6402q.ordinal()];
        int i11 = 2;
        if (i10 != 1) {
            if (i10 != 2 && i10 == 3) {
                com.airbnb.lottie.d dVar2 = this.f6406u;
                boolean z10 = false;
                if ((dVar2 == null || !dVar2.p() || Build.VERSION.SDK_INT >= 28) && (((dVar = this.f6406u) == null || dVar.l() <= 4) && Build.VERSION.SDK_INT >= 21)) {
                    z10 = true;
                }
            }
            i11 = 1;
        }
        if (i11 != getLayerType()) {
            setLayerType(i11, null);
        }
    }

    private void l(AttributeSet attributeSet) {
        String string;
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, o.f6672a);
        boolean z10 = false;
        if (!isInEditMode()) {
            this.f6401p = obtainStyledAttributes.getBoolean(o.f6674c, true);
            int i10 = o.f6682k;
            boolean hasValue = obtainStyledAttributes.hasValue(i10);
            int i11 = o.f6678g;
            boolean hasValue2 = obtainStyledAttributes.hasValue(i11);
            int i12 = o.f6688q;
            boolean hasValue3 = obtainStyledAttributes.hasValue(i12);
            if (!hasValue || !hasValue2) {
                if (hasValue) {
                    int resourceId = obtainStyledAttributes.getResourceId(i10, 0);
                    if (resourceId != 0) {
                        setAnimation(resourceId);
                    }
                } else if (hasValue2) {
                    String string2 = obtainStyledAttributes.getString(i11);
                    if (string2 != null) {
                        setAnimation(string2);
                    }
                } else if (hasValue3 && (string = obtainStyledAttributes.getString(i12)) != null) {
                    setAnimationFromUrl(string);
                }
                setFallbackResource(obtainStyledAttributes.getResourceId(o.f6677f, 0));
            } else {
                throw new IllegalArgumentException("lottie_rawRes and lottie_fileName cannot be used at the same time. Please use only one at once.");
            }
        }
        if (obtainStyledAttributes.getBoolean(o.f6673b, false)) {
            this.f6399n = true;
            this.f6400o = true;
        }
        if (obtainStyledAttributes.getBoolean(o.f6680i, false)) {
            this.f6393h.a0(-1);
        }
        int i13 = o.f6685n;
        if (obtainStyledAttributes.hasValue(i13)) {
            setRepeatMode(obtainStyledAttributes.getInt(i13, 1));
        }
        int i14 = o.f6684m;
        if (obtainStyledAttributes.hasValue(i14)) {
            setRepeatCount(obtainStyledAttributes.getInt(i14, -1));
        }
        int i15 = o.f6687p;
        if (obtainStyledAttributes.hasValue(i15)) {
            setSpeed(obtainStyledAttributes.getFloat(i15, 1.0f));
        }
        setImageAssetsFolder(obtainStyledAttributes.getString(o.f6679h));
        setProgress(obtainStyledAttributes.getFloat(o.f6681j, 0.0f));
        j(obtainStyledAttributes.getBoolean(o.f6676e, false));
        int i16 = o.f6675d;
        if (obtainStyledAttributes.hasValue(i16)) {
            f(new g3.d("**"), k.C, new l3.c(new p(obtainStyledAttributes.getColor(i16, 0))));
        }
        int i17 = o.f6686o;
        if (obtainStyledAttributes.hasValue(i17)) {
            this.f6393h.d0(obtainStyledAttributes.getFloat(i17, 1.0f));
        }
        int i18 = o.f6683l;
        if (obtainStyledAttributes.hasValue(i18)) {
            RenderMode renderMode = RenderMode.AUTOMATIC;
            int i19 = obtainStyledAttributes.getInt(i18, renderMode.ordinal());
            if (i19 >= RenderMode.values().length) {
                i19 = renderMode.ordinal();
            }
            setRenderMode(RenderMode.values()[i19]);
        }
        if (getScaleType() != null) {
            this.f6393h.e0(getScaleType());
        }
        obtainStyledAttributes.recycle();
        f fVar = this.f6393h;
        if (h.f(getContext()) != 0.0f) {
            z10 = true;
        }
        fVar.g0(Boolean.valueOf(z10));
        k();
        this.f6394i = true;
    }

    private void setCompositionTask(m<com.airbnb.lottie.d> mVar) {
        i();
        h();
        this.f6405t = mVar.f(this.f6389d).e(this.f6390e);
    }

    @Override // android.view.View
    public void buildDrawingCache(boolean z10) {
        com.airbnb.lottie.c.a("buildDrawingCache");
        this.f6404s++;
        super.buildDrawingCache(z10);
        if (this.f6404s == 1 && getWidth() > 0 && getHeight() > 0 && getLayerType() == 1 && getDrawingCache(z10) == null) {
            setRenderMode(RenderMode.HARDWARE);
        }
        this.f6404s--;
        com.airbnb.lottie.c.b("buildDrawingCache");
    }

    public <T> void f(g3.d dVar, T t10, l3.c<T> cVar) {
        this.f6393h.c(dVar, t10, cVar);
    }

    public void g() {
        this.f6399n = false;
        this.f6398m = false;
        this.f6397l = false;
        this.f6393h.e();
        k();
    }

    public com.airbnb.lottie.d getComposition() {
        return this.f6406u;
    }

    public long getDuration() {
        com.airbnb.lottie.d dVar = this.f6406u;
        if (dVar != null) {
            return dVar.d();
        }
        return 0L;
    }

    public int getFrame() {
        return this.f6393h.p();
    }

    public String getImageAssetsFolder() {
        return this.f6393h.s();
    }

    public float getMaxFrame() {
        return this.f6393h.t();
    }

    public float getMinFrame() {
        return this.f6393h.v();
    }

    public n getPerformanceTracker() {
        return this.f6393h.w();
    }

    public float getProgress() {
        return this.f6393h.x();
    }

    public int getRepeatCount() {
        return this.f6393h.y();
    }

    public int getRepeatMode() {
        return this.f6393h.z();
    }

    public float getScale() {
        return this.f6393h.A();
    }

    public float getSpeed() {
        return this.f6393h.B();
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        f fVar = this.f6393h;
        if (drawable2 == fVar) {
            super.invalidateDrawable(fVar);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    public void j(boolean z10) {
        this.f6393h.j(z10);
    }

    public boolean m() {
        return this.f6393h.E();
    }

    public void n() {
        this.f6400o = false;
        this.f6399n = false;
        this.f6398m = false;
        this.f6397l = false;
        this.f6393h.G();
        k();
    }

    public void o() {
        if (isShown()) {
            this.f6393h.H();
            k();
            return;
        }
        this.f6397l = true;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f6400o || this.f6399n) {
            o();
            this.f6400o = false;
            this.f6399n = false;
        }
        if (Build.VERSION.SDK_INT < 23) {
            onVisibilityChanged(this, getVisibility());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        if (m()) {
            g();
            this.f6399n = true;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        String str = savedState.f6407a;
        this.f6395j = str;
        if (!TextUtils.isEmpty(str)) {
            setAnimation(this.f6395j);
        }
        int i10 = savedState.f6408b;
        this.f6396k = i10;
        if (i10 != 0) {
            setAnimation(i10);
        }
        setProgress(savedState.f6409c);
        if (savedState.f6410d) {
            o();
        }
        this.f6393h.P(savedState.f6411e);
        setRepeatMode(savedState.f6412f);
        setRepeatCount(savedState.f6413g);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f6407a = this.f6395j;
        savedState.f6408b = this.f6396k;
        savedState.f6409c = this.f6393h.x();
        savedState.f6410d = this.f6393h.E() || (!d0.W(this) && this.f6399n);
        savedState.f6411e = this.f6393h.s();
        savedState.f6412f = this.f6393h.z();
        savedState.f6413g = this.f6393h.y();
        return savedState;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i10) {
        if (this.f6394i) {
            if (isShown()) {
                if (this.f6398m) {
                    p();
                } else if (this.f6397l) {
                    o();
                }
                this.f6398m = false;
                this.f6397l = false;
            } else if (m()) {
                n();
                this.f6398m = true;
            }
        }
    }

    public void p() {
        if (isShown()) {
            this.f6393h.J();
            k();
            return;
        }
        this.f6397l = false;
        this.f6398m = true;
    }

    public void q(InputStream inputStream, String str) {
        setCompositionTask(e.g(inputStream, str));
    }

    public void r(String str, String str2) {
        q(new ByteArrayInputStream(str.getBytes()), str2);
    }

    public void setAnimation(int i10) {
        this.f6396k = i10;
        this.f6395j = null;
        setCompositionTask(this.f6401p ? e.l(getContext(), i10) : e.m(getContext(), i10, null));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        r(str, null);
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(this.f6401p ? e.p(getContext(), str) : e.q(getContext(), str, null));
    }

    public void setApplyingOpacityToLayersEnabled(boolean z10) {
        this.f6393h.K(z10);
    }

    public void setCacheComposition(boolean z10) {
        this.f6401p = z10;
    }

    public void setComposition(com.airbnb.lottie.d dVar) {
        if (com.airbnb.lottie.c.f6417a) {
            String str = f6387v;
            Log.v(str, "Set Composition \n" + dVar);
        }
        this.f6393h.setCallback(this);
        this.f6406u = dVar;
        boolean L = this.f6393h.L(dVar);
        k();
        if (getDrawable() != this.f6393h || L) {
            onVisibilityChanged(this, getVisibility());
            requestLayout();
            for (j jVar : this.f6403r) {
                jVar.a(dVar);
            }
        }
    }

    public void setFailureListener(h<Throwable> hVar) {
        this.f6391f = hVar;
    }

    public void setFallbackResource(int i10) {
        this.f6392g = i10;
    }

    public void setFontAssetDelegate(com.airbnb.lottie.a aVar) {
        this.f6393h.M(aVar);
    }

    public void setFrame(int i10) {
        this.f6393h.N(i10);
    }

    public void setImageAssetDelegate(com.airbnb.lottie.b bVar) {
        this.f6393h.O(bVar);
    }

    public void setImageAssetsFolder(String str) {
        this.f6393h.P(str);
    }

    @Override // androidx.appcompat.widget.q, android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        h();
        super.setImageBitmap(bitmap);
    }

    @Override // androidx.appcompat.widget.q, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        h();
        super.setImageDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.q, android.widget.ImageView
    public void setImageResource(int i10) {
        h();
        super.setImageResource(i10);
    }

    public void setMaxFrame(int i10) {
        this.f6393h.Q(i10);
    }

    public void setMaxProgress(float f10) {
        this.f6393h.S(f10);
    }

    public void setMinAndMaxFrame(String str) {
        this.f6393h.U(str);
    }

    public void setMinFrame(int i10) {
        this.f6393h.V(i10);
    }

    public void setMinProgress(float f10) {
        this.f6393h.X(f10);
    }

    public void setPerformanceTrackingEnabled(boolean z10) {
        this.f6393h.Y(z10);
    }

    public void setProgress(float f10) {
        this.f6393h.Z(f10);
    }

    public void setRenderMode(RenderMode renderMode) {
        this.f6402q = renderMode;
        k();
    }

    public void setRepeatCount(int i10) {
        this.f6393h.a0(i10);
    }

    public void setRepeatMode(int i10) {
        this.f6393h.b0(i10);
    }

    public void setSafeMode(boolean z10) {
        this.f6393h.c0(z10);
    }

    public void setScale(float f10) {
        this.f6393h.d0(f10);
        if (getDrawable() == this.f6393h) {
            setImageDrawable(null);
            setImageDrawable(this.f6393h);
        }
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        super.setScaleType(scaleType);
        f fVar = this.f6393h;
        if (fVar != null) {
            fVar.e0(scaleType);
        }
    }

    public void setSpeed(float f10) {
        this.f6393h.f0(f10);
    }

    public void setTextDelegate(q qVar) {
        this.f6393h.h0(qVar);
    }

    public void setMaxFrame(String str) {
        this.f6393h.R(str);
    }

    public void setMinFrame(String str) {
        this.f6393h.W(str);
    }

    public void setAnimation(String str) {
        this.f6395j = str;
        this.f6396k = 0;
        setCompositionTask(this.f6401p ? e.d(getContext(), str) : e.e(getContext(), str, null));
    }
}
