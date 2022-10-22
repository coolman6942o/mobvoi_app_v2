package c5;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import n5.j;
import t4.c;
/* compiled from: DrawableResource.java */
/* loaded from: classes.dex */
public abstract class b<T extends Drawable> implements c<T>, t4.b {

    /* renamed from: a  reason: collision with root package name */
    protected final T f5578a;

    public b(T t10) {
        this.f5578a = (T) j.d(t10);
    }

    @Override // t4.b
    public void a() {
        T t10 = this.f5578a;
        if (t10 instanceof BitmapDrawable) {
            ((BitmapDrawable) t10).getBitmap().prepareToDraw();
        } else if (t10 instanceof e5.c) {
            ((e5.c) t10).e().prepareToDraw();
        }
    }

    /* renamed from: e */
    public final T get() {
        Drawable.ConstantState constantState = this.f5578a.getConstantState();
        if (constantState == null) {
            return this.f5578a;
        }
        return (T) constantState.newDrawable();
    }
}
