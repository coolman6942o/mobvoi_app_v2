package androidx.core.view;

import android.view.View;
import android.view.ViewTreeObserver;
import java.util.Objects;
/* compiled from: OneShotPreDrawListener.java */
/* loaded from: classes.dex */
public final class y implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: a  reason: collision with root package name */
    private final View f2626a;

    /* renamed from: b  reason: collision with root package name */
    private ViewTreeObserver f2627b;

    /* renamed from: c  reason: collision with root package name */
    private final Runnable f2628c;

    private y(View view, Runnable runnable) {
        this.f2626a = view;
        this.f2627b = view.getViewTreeObserver();
        this.f2628c = runnable;
    }

    public static y a(View view, Runnable runnable) {
        Objects.requireNonNull(view, "view == null");
        Objects.requireNonNull(runnable, "runnable == null");
        y yVar = new y(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(yVar);
        view.addOnAttachStateChangeListener(yVar);
        return yVar;
    }

    public void b() {
        if (this.f2627b.isAlive()) {
            this.f2627b.removeOnPreDrawListener(this);
        } else {
            this.f2626a.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.f2626a.removeOnAttachStateChangeListener(this);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        b();
        this.f2628c.run();
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
        this.f2627b = view.getViewTreeObserver();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        b();
    }
}
