package com.mobvoi.mcuwatch.ui.customview;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.view.MotionEvent;
import java.util.TimerTask;
import sh.d;
import sh.f;
/* loaded from: classes2.dex */
public class SportControlLockButton extends z {

    /* renamed from: o  reason: collision with root package name */
    private int f19587o;

    /* renamed from: p  reason: collision with root package name */
    private a f19588p;

    /* loaded from: classes2.dex */
    public interface a {
        void a(int i10);
    }

    public SportControlLockButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void f() {
        this.f19716j = this.f19587o == 0 ? BitmapFactory.decodeResource(getResources(), f.f34566m0) : BitmapFactory.decodeResource(getResources(), f.f34578q0);
        this.f19719m = this.f19587o == 0 ? d.f34466z : d.A;
    }

    @Override // com.mobvoi.mcuwatch.ui.customview.z
    protected boolean b() {
        int i10 = this.f19587o;
        return i10 == 0 || i10 == 1;
    }

    @Override // com.mobvoi.mcuwatch.ui.customview.z
    protected boolean c() {
        return this.f19587o == 2;
    }

    @Override // com.mobvoi.mcuwatch.ui.customview.z
    protected void d(TimerTask timerTask) {
        this.f19717k += 5;
        postInvalidate();
        if (this.f19717k == 100) {
            g(0);
            timerTask.cancel();
            a();
        }
    }

    public void g(int i10) {
        a aVar = this.f19588p;
        if (aVar != null) {
            aVar.a(i10);
        }
        this.f19587o = i10;
        f();
        if (this.f19587o == 2) {
            e();
        } else {
            postInvalidate();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            int i10 = this.f19587o;
            if (i10 == 1 && this.f19717k == 0) {
                g(2);
            } else if (i10 == 0) {
                g(1);
            }
        } else if (actionMasked == 1 && this.f19587o == 2 && this.f19717k < 100) {
            a();
            g(1);
        }
        return true;
    }

    public void setLockStatusChangeCallback(a aVar) {
        this.f19588p = aVar;
    }

    public SportControlLockButton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f19587o = 0;
        this.f19720n = d.C;
        f();
    }
}
