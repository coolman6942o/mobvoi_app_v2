package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;
/* compiled from: TintResources.java */
/* loaded from: classes.dex */
class w0 extends o0 {

    /* renamed from: b  reason: collision with root package name */
    private final WeakReference<Context> f1359b;

    public w0(Context context, Resources resources) {
        super(resources);
        this.f1359b = new WeakReference<>(context);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i10) throws Resources.NotFoundException {
        Drawable a10 = a(i10);
        Context context = this.f1359b.get();
        if (!(a10 == null || context == null)) {
            n0.h().x(context, i10, a10);
        }
        return a10;
    }
}
