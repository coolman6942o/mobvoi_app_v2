package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WrappedDrawableState.java */
/* loaded from: classes.dex */
public final class d extends Drawable.ConstantState {

    /* renamed from: a  reason: collision with root package name */
    int f2474a;

    /* renamed from: b  reason: collision with root package name */
    Drawable.ConstantState f2475b;

    /* renamed from: c  reason: collision with root package name */
    ColorStateList f2476c;

    /* renamed from: d  reason: collision with root package name */
    PorterDuff.Mode f2477d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(d dVar) {
        this.f2476c = null;
        this.f2477d = b.f2466g;
        if (dVar != null) {
            this.f2474a = dVar.f2474a;
            this.f2475b = dVar.f2475b;
            this.f2476c = dVar.f2476c;
            this.f2477d = dVar.f2477d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return this.f2475b != null;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        int i10 = this.f2474a;
        Drawable.ConstantState constantState = this.f2475b;
        return i10 | (constantState != null ? constantState.getChangingConfigurations() : 0);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable() {
        return newDrawable(null);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public Drawable newDrawable(Resources resources) {
        if (Build.VERSION.SDK_INT >= 21) {
            return new c(this, resources);
        }
        return new b(this, resources);
    }
}
