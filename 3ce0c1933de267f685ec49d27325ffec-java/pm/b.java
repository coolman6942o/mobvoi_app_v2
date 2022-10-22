package pm;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.huawei.agconnect.exception.AGCServerException;
import om.a;
import pm.b;
import sm.e;
import sm.f;
/* compiled from: ClassicsAbstract.java */
/* loaded from: classes2.dex */
public abstract class b<T extends b> extends wm.b {

    /* renamed from: d  reason: collision with root package name */
    protected TextView f32880d;

    /* renamed from: e  reason: collision with root package name */
    protected ImageView f32881e;

    /* renamed from: f  reason: collision with root package name */
    protected ImageView f32882f;

    /* renamed from: g  reason: collision with root package name */
    protected e f32883g;

    /* renamed from: h  reason: collision with root package name */
    protected a f32884h;

    /* renamed from: i  reason: collision with root package name */
    protected a f32885i;

    /* renamed from: j  reason: collision with root package name */
    protected boolean f32886j;

    /* renamed from: k  reason: collision with root package name */
    protected boolean f32887k;

    /* renamed from: l  reason: collision with root package name */
    protected int f32888l;

    /* renamed from: m  reason: collision with root package name */
    protected int f32889m = AGCServerException.UNKNOW_EXCEPTION;

    /* renamed from: n  reason: collision with root package name */
    protected int f32890n = 20;

    /* renamed from: o  reason: collision with root package name */
    protected int f32891o = 20;

    /* renamed from: p  reason: collision with root package name */
    protected int f32892p = 0;

    public b(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f36331b = tm.b.f35224d;
    }

    @Override // wm.b, sm.a
    public void a(e eVar, int i10, int i11) {
        this.f32883g = eVar;
        eVar.a(this, this.f32888l);
    }

    @Override // wm.b, sm.a
    public int h(f fVar, boolean z10) {
        ImageView imageView = this.f32882f;
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof Animatable) {
            Animatable animatable = (Animatable) drawable;
            if (animatable.isRunning()) {
                animatable.stop();
            }
        } else {
            imageView.animate().rotation(0.0f).setDuration(0L);
        }
        imageView.setVisibility(8);
        return this.f32889m;
    }

    @Override // wm.b, sm.a
    public void j(f fVar, int i10, int i11) {
        ImageView imageView = this.f32882f;
        if (imageView.getVisibility() != 0) {
            imageView.setVisibility(0);
            Drawable drawable = this.f32882f.getDrawable();
            if (drawable instanceof Animatable) {
                ((Animatable) drawable).start();
            } else {
                imageView.animate().rotation(36000.0f).setDuration(100000L);
            }
        }
    }

    @Override // wm.b, sm.a
    public void n(f fVar, int i10, int i11) {
        j(fVar, i10, i11);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ImageView imageView = this.f32881e;
        ImageView imageView2 = this.f32882f;
        imageView.animate().cancel();
        imageView2.animate().cancel();
        Drawable drawable = this.f32882f.getDrawable();
        if (drawable instanceof Animatable) {
            Animatable animatable = (Animatable) drawable;
            if (animatable.isRunning()) {
                animatable.stop();
            }
        }
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i10, int i11) {
        if (this.f32892p == 0) {
            this.f32890n = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            this.f32891o = paddingBottom;
            if (this.f32890n == 0 || paddingBottom == 0) {
                int paddingLeft = getPaddingLeft();
                int paddingRight = getPaddingRight();
                int i12 = this.f32890n;
                if (i12 == 0) {
                    i12 = xm.b.c(20.0f);
                }
                this.f32890n = i12;
                int i13 = this.f32891o;
                if (i13 == 0) {
                    i13 = xm.b.c(20.0f);
                }
                this.f32891o = i13;
                setPadding(paddingLeft, this.f32890n, paddingRight, i13);
            }
            setClipToPadding(false);
        }
        if (View.MeasureSpec.getMode(i11) == 1073741824) {
            int size = View.MeasureSpec.getSize(i11);
            int i14 = this.f32892p;
            if (size < i14) {
                int i15 = (size - i14) / 2;
                setPadding(getPaddingLeft(), i15, getPaddingRight(), i15);
            } else {
                setPadding(getPaddingLeft(), 0, getPaddingRight(), 0);
            }
        } else {
            setPadding(getPaddingLeft(), this.f32890n, getPaddingRight(), this.f32891o);
        }
        super.onMeasure(i10, i11);
        if (this.f32892p == 0) {
            for (int i16 = 0; i16 < getChildCount(); i16++) {
                int measuredHeight = getChildAt(i16).getMeasuredHeight();
                if (this.f32892p < measuredHeight) {
                    this.f32892p = measuredHeight;
                }
            }
        }
    }

    protected T r() {
        return this;
    }

    public T s(int i10) {
        this.f32886j = true;
        this.f32880d.setTextColor(i10);
        a aVar = this.f32884h;
        if (aVar != null) {
            aVar.a(i10);
            this.f32881e.invalidateDrawable(this.f32884h);
        }
        a aVar2 = this.f32885i;
        if (aVar2 != null) {
            aVar2.a(i10);
            this.f32882f.invalidateDrawable(this.f32885i);
        }
        return r();
    }

    @Override // wm.b, sm.a
    public void setPrimaryColors(int... iArr) {
        if (iArr.length > 0) {
            if (!(getBackground() instanceof BitmapDrawable) && !this.f32887k) {
                t(iArr[0]);
                this.f32887k = false;
            }
            if (!this.f32886j) {
                if (iArr.length > 1) {
                    s(iArr[1]);
                }
                this.f32886j = false;
            }
        }
    }

    public T t(int i10) {
        this.f32887k = true;
        this.f32888l = i10;
        e eVar = this.f32883g;
        if (eVar != null) {
            eVar.a(this, i10);
        }
        return r();
    }
}
