package com.unionpay.mobile.android.upwidget;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;
import java.lang.ref.WeakReference;
/* loaded from: classes2.dex */
public class UPScrollView extends ScrollView {

    /* renamed from: a  reason: collision with root package name */
    private WeakReference<a> f24016a;

    /* renamed from: b  reason: collision with root package name */
    private int f24017b;

    /* renamed from: c  reason: collision with root package name */
    private ViewTreeObserver.OnGlobalLayoutListener f24018c;

    /* renamed from: d  reason: collision with root package name */
    private Handler f24019d;

    /* loaded from: classes2.dex */
    public interface a {
        void e(int i10);
    }

    public UPScrollView(Context context) {
        this(context, null);
    }

    public UPScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public UPScrollView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f24019d = new v(this);
        this.f24018c = new u(this);
    }

    public final void a(a aVar) {
        this.f24016a = new WeakReference<>(aVar);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnGlobalLayoutListener(this.f24018c);
    }

    @Override // android.widget.ScrollView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeGlobalOnLayoutListener(this.f24018c);
    }

    @Override // android.widget.ScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        WeakReference<a> weakReference = this.f24016a;
        if (!(weakReference == null || weakReference.get() == null)) {
            int scrollY = getScrollY();
            this.f24017b = scrollY;
            this.f24016a.get().e(scrollY);
        }
        if (motionEvent.getAction() == 1) {
            Handler handler = this.f24019d;
            handler.sendMessageDelayed(handler.obtainMessage(), 5L);
        }
        return super.onTouchEvent(motionEvent);
    }
}
