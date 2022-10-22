package androidx.vectordrawable.graphics.drawable;

import a0.i;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: AnimatedVectorDrawableCompat.java */
/* loaded from: classes.dex */
public class c extends h implements Animatable {

    /* renamed from: b  reason: collision with root package name */
    private b f4452b;

    /* renamed from: c  reason: collision with root package name */
    private Context f4453c;

    /* renamed from: d  reason: collision with root package name */
    private ArgbEvaluator f4454d;

    /* renamed from: e  reason: collision with root package name */
    final Drawable.Callback f4455e;

    /* compiled from: AnimatedVectorDrawableCompat.java */
    /* loaded from: classes.dex */
    class a implements Drawable.Callback {
        a() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            c.this.invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j10) {
            c.this.scheduleSelf(runnable, j10);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            c.this.unscheduleSelf(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AnimatedVectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class b extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        int f4457a;

        /* renamed from: b  reason: collision with root package name */
        i f4458b;

        /* renamed from: c  reason: collision with root package name */
        AnimatorSet f4459c;

        /* renamed from: d  reason: collision with root package name */
        ArrayList<Animator> f4460d;

        /* renamed from: e  reason: collision with root package name */
        androidx.collection.a<Animator, String> f4461e;

        public b(Context context, b bVar, Drawable.Callback callback, Resources resources) {
            if (bVar != null) {
                this.f4457a = bVar.f4457a;
                i iVar = bVar.f4458b;
                if (iVar != null) {
                    Drawable.ConstantState constantState = iVar.getConstantState();
                    if (resources != null) {
                        this.f4458b = (i) constantState.newDrawable(resources);
                    } else {
                        this.f4458b = (i) constantState.newDrawable();
                    }
                    i iVar2 = (i) this.f4458b.mutate();
                    this.f4458b = iVar2;
                    iVar2.setCallback(callback);
                    this.f4458b.setBounds(bVar.f4458b.getBounds());
                    this.f4458b.h(false);
                }
                ArrayList<Animator> arrayList = bVar.f4460d;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.f4460d = new ArrayList<>(size);
                    this.f4461e = new androidx.collection.a<>(size);
                    for (int i10 = 0; i10 < size; i10++) {
                        Animator animator = bVar.f4460d.get(i10);
                        Animator clone = animator.clone();
                        String str = bVar.f4461e.get(animator);
                        clone.setTarget(this.f4458b.d(str));
                        this.f4460d.add(clone);
                        this.f4461e.put(clone, str);
                    }
                    a();
                }
            }
        }

        public void a() {
            if (this.f4459c == null) {
                this.f4459c = new AnimatorSet();
            }
            this.f4459c.playTogether(this.f4460d);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f4457a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    c() {
        this(null, null, null);
    }

    public static c a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        c cVar = new c(context);
        cVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return cVar;
    }

    private void b(String str, Animator animator) {
        animator.setTarget(this.f4452b.f4458b.d(str));
        if (Build.VERSION.SDK_INT < 21) {
            c(animator);
        }
        b bVar = this.f4452b;
        if (bVar.f4460d == null) {
            bVar.f4460d = new ArrayList<>();
            this.f4452b.f4461e = new androidx.collection.a<>();
        }
        this.f4452b.f4460d.add(animator);
        this.f4452b.f4461e.put(animator, str);
    }

    private void c(Animator animator) {
        ArrayList<Animator> childAnimations;
        if ((animator instanceof AnimatorSet) && (childAnimations = ((AnimatorSet) animator).getChildAnimations()) != null) {
            for (int i10 = 0; i10 < childAnimations.size(); i10++) {
                c(childAnimations.get(i10));
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.f4454d == null) {
                    this.f4454d = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.f4454d);
            }
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.h, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        Drawable drawable = this.f4467a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.a(drawable, theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f4467a;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.b(drawable);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f4467a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        this.f4452b.f4458b.draw(canvas);
        if (this.f4452b.f4459c.isStarted()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f4467a;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.d(drawable);
        }
        return this.f4452b.f4458b.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f4467a;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f4452b.f4457a;
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f4467a;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.e(drawable);
        }
        return this.f4452b.f4458b.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f4467a == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new C0050c(this.f4467a.getConstantState());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f4467a;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return this.f4452b.f4458b.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f4467a;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return this.f4452b.f4458b.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f4467a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return this.f4452b.f4458b.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.f4467a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.g(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    TypedArray s10 = i.s(resources, theme, attributeSet, androidx.vectordrawable.graphics.drawable.a.f4444e);
                    int resourceId = s10.getResourceId(0, 0);
                    if (resourceId != 0) {
                        i b10 = i.b(resources, resourceId, theme);
                        b10.h(false);
                        b10.setCallback(this.f4455e);
                        i iVar = this.f4452b.f4458b;
                        if (iVar != null) {
                            iVar.setCallback(null);
                        }
                        this.f4452b.f4458b = b10;
                    }
                    s10.recycle();
                } else if ("target".equals(name)) {
                    TypedArray obtainAttributes = resources.obtainAttributes(attributeSet, androidx.vectordrawable.graphics.drawable.a.f4445f);
                    String string = obtainAttributes.getString(0);
                    int resourceId2 = obtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.f4453c;
                        if (context != null) {
                            b(string, e.i(context, resourceId2));
                        } else {
                            obtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    obtainAttributes.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
        this.f4452b.a();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f4467a;
        if (drawable != null) {
            return androidx.core.graphics.drawable.a.h(drawable);
        }
        return this.f4452b.f4458b.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        Drawable drawable = this.f4467a;
        if (drawable != null) {
            return ((AnimatedVectorDrawable) drawable).isRunning();
        }
        return this.f4452b.f4459c.isRunning();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        Drawable drawable = this.f4467a;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return this.f4452b.f4458b.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f4467a;
        if (drawable != null) {
            drawable.mutate();
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f4467a;
        if (drawable != null) {
            drawable.setBounds(rect);
        } else {
            this.f4452b.f4458b.setBounds(rect);
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.h, android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i10) {
        Drawable drawable = this.f4467a;
        if (drawable != null) {
            return drawable.setLevel(i10);
        }
        return this.f4452b.f4458b.setLevel(i10);
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f4467a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        return this.f4452b.f4458b.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i10) {
        Drawable drawable = this.f4467a;
        if (drawable != null) {
            drawable.setAlpha(i10);
        } else {
            this.f4452b.f4458b.setAlpha(i10);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z10) {
        Drawable drawable = this.f4467a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.j(drawable, z10);
        } else {
            this.f4452b.f4458b.setAutoMirrored(z10);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f4467a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.f4452b.f4458b.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable, c0.d
    public void setTint(int i10) {
        Drawable drawable = this.f4467a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.n(drawable, i10);
        } else {
            this.f4452b.f4458b.setTint(i10);
        }
    }

    @Override // android.graphics.drawable.Drawable, c0.d
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f4467a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.o(drawable, colorStateList);
        } else {
            this.f4452b.f4458b.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable, c0.d
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f4467a;
        if (drawable != null) {
            androidx.core.graphics.drawable.a.p(drawable, mode);
        } else {
            this.f4452b.f4458b.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z10, boolean z11) {
        Drawable drawable = this.f4467a;
        if (drawable != null) {
            return drawable.setVisible(z10, z11);
        }
        this.f4452b.f4458b.setVisible(z10, z11);
        return super.setVisible(z10, z11);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        Drawable drawable = this.f4467a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).start();
        } else if (!this.f4452b.f4459c.isStarted()) {
            this.f4452b.f4459c.start();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        Drawable drawable = this.f4467a;
        if (drawable != null) {
            ((AnimatedVectorDrawable) drawable).stop();
        } else {
            this.f4452b.f4459c.end();
        }
    }

    private c(Context context) {
        this(context, null, null);
    }

    /* compiled from: AnimatedVectorDrawableCompat.java */
    /* renamed from: androidx.vectordrawable.graphics.drawable.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private static class C0050c extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        private final Drawable.ConstantState f4462a;

        public C0050c(Drawable.ConstantState constantState) {
            this.f4462a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f4462a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f4462a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            c cVar = new c();
            Drawable newDrawable = this.f4462a.newDrawable();
            cVar.f4467a = newDrawable;
            newDrawable.setCallback(cVar.f4455e);
            return cVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            c cVar = new c();
            Drawable newDrawable = this.f4462a.newDrawable(resources);
            cVar.f4467a = newDrawable;
            newDrawable.setCallback(cVar.f4455e);
            return cVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            c cVar = new c();
            Drawable newDrawable = this.f4462a.newDrawable(resources, theme);
            cVar.f4467a = newDrawable;
            newDrawable.setCallback(cVar.f4455e);
            return cVar;
        }
    }

    private c(Context context, b bVar, Resources resources) {
        this.f4454d = null;
        a aVar = new a();
        this.f4455e = aVar;
        this.f4453c = context;
        if (bVar != null) {
            this.f4452b = bVar;
        } else {
            this.f4452b = new b(context, bVar, aVar, resources);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        inflate(resources, xmlPullParser, attributeSet, null);
    }
}
