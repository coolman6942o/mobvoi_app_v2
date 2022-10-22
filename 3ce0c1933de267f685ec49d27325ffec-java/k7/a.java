package k7;

import android.app.Dialog;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
/* compiled from: InsetDialogOnTouchListener.java */
/* loaded from: classes.dex */
public class a implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    private final Dialog f29794a;

    /* renamed from: b  reason: collision with root package name */
    private final int f29795b;

    /* renamed from: c  reason: collision with root package name */
    private final int f29796c;

    /* renamed from: d  reason: collision with root package name */
    private final int f29797d;

    public a(Dialog dialog, Rect rect) {
        this.f29794a = dialog;
        this.f29795b = rect.left;
        this.f29796c = rect.top;
        this.f29797d = ViewConfiguration.get(dialog.getContext()).getScaledWindowTouchSlop();
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        View findViewById = view.findViewById(16908290);
        int left = this.f29795b + findViewById.getLeft();
        int width = findViewById.getWidth() + left;
        int top = this.f29796c + findViewById.getTop();
        if (new RectF(left, top, width, findViewById.getHeight() + top).contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        if (motionEvent.getAction() == 1) {
            obtain.setAction(4);
        }
        if (Build.VERSION.SDK_INT < 28) {
            obtain.setAction(0);
            int i10 = this.f29797d;
            obtain.setLocation((-i10) - 1, (-i10) - 1);
        }
        view.performClick();
        return this.f29794a.onTouchEvent(obtain);
    }
}
