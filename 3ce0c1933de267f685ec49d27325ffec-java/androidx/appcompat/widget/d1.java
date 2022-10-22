package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import java.lang.ref.WeakReference;
/* compiled from: VectorEnabledTintResources.java */
/* loaded from: classes.dex */
public class d1 extends o0 {

    /* renamed from: c  reason: collision with root package name */
    private static boolean f1145c = false;

    /* renamed from: b  reason: collision with root package name */
    private final WeakReference<Context> f1146b;

    public d1(Context context, Resources resources) {
        super(resources);
        this.f1146b = new WeakReference<>(context);
    }

    public static boolean b() {
        return f1145c;
    }

    public static boolean c() {
        return b() && Build.VERSION.SDK_INT <= 20;
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i10) throws Resources.NotFoundException {
        Context context = this.f1146b.get();
        if (context != null) {
            return n0.h().t(context, this, i10);
        }
        return a(i10);
    }
}
