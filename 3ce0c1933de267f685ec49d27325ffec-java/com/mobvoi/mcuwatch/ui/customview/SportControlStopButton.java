package com.mobvoi.mcuwatch.ui.customview;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.mobvoi.wear.util.DimensionUtils;
import java.util.TimerTask;
import mj.n;
import sh.d;
import sh.f;
/* loaded from: classes2.dex */
public class SportControlStopButton extends z {

    /* renamed from: o  reason: collision with root package name */
    private int f19600o;

    /* renamed from: p  reason: collision with root package name */
    private n f19601p;

    public SportControlStopButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g() {
        requestLayout();
    }

    private void setLayoutParams(int i10) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
        layoutParams.leftMargin = i10;
        setLayoutParams(layoutParams);
    }

    @Override // com.mobvoi.mcuwatch.ui.customview.z
    protected boolean b() {
        return this.f19600o == 0;
    }

    @Override // com.mobvoi.mcuwatch.ui.customview.z
    protected boolean c() {
        return this.f19600o == 1;
    }

    @Override // com.mobvoi.mcuwatch.ui.customview.z
    protected void d(TimerTask timerTask) {
        if (this.f19717k == 0) {
            post(new Runnable() { // from class: com.mobvoi.mcuwatch.ui.customview.d0
                @Override // java.lang.Runnable
                public final void run() {
                    SportControlStopButton.this.g();
                }
            });
        } else {
            postInvalidate();
        }
        int i10 = this.f19717k + 5;
        this.f19717k = i10;
        if (i10 == 100) {
            this.f19601p.i(4, true);
            timerTask.cancel();
            a();
        }
    }

    public void h(int i10) {
        this.f19600o = i10;
        if (i10 == 1) {
            e();
        } else {
            requestLayout();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1 && this.f19600o == 1 && this.f19717k < 100) {
                a();
                h(0);
                setLayoutParams((int) DimensionUtils.dp2px(getContext(), 16.0f));
            }
        } else if (this.f19600o == 0 && this.f19717k == 0) {
            h(1);
            setLayoutParams((int) DimensionUtils.dp2px(getContext(), 1.0f));
        }
        return true;
    }

    public void setWorkShortPresenter(n nVar) {
        this.f19601p = nVar;
    }

    public SportControlStopButton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f19716j = BitmapFactory.decodeResource(getResources(), f.f34572o0);
        this.f19600o = 0;
        this.f19719m = d.E;
        this.f19720n = d.D;
    }
}
