package com.mobvoi.health.companion.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
/* loaded from: classes2.dex */
public class VpSwipeRefreshLayout extends SwipeRefreshLayout {
    private float S;
    private float T;
    private boolean U;
    private final int V;

    public VpSwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.V = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x000e, code lost:
        if (r0 != 3) goto L21;
     */
    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout, android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (this.U) {
                        return false;
                    }
                    float y10 = motionEvent.getY();
                    float abs = Math.abs(motionEvent.getX() - this.T);
                    float abs2 = Math.abs(y10 - this.S);
                    if (abs > this.V && abs > abs2) {
                        this.U = true;
                        return false;
                    }
                }
            }
            this.U = false;
        } else {
            this.S = motionEvent.getY();
            this.T = motionEvent.getX();
            this.U = false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
