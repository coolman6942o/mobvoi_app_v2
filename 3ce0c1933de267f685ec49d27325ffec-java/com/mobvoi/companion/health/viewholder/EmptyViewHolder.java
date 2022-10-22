package com.mobvoi.companion.health.viewholder;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.mobvoi.companion.R;
import kotlin.jvm.internal.i;
import xc.b;
/* compiled from: EmptyViewHolder.kt */
/* loaded from: classes2.dex */
public final class EmptyViewHolder extends i {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmptyViewHolder(ViewGroup parentView) {
        super(parentView, R.layout.layout_home_tab_first);
        i.f(parentView, "parentView");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: attachBehindView$lambda-0  reason: not valid java name */
    public static final boolean m12attachBehindView$lambda0(View behindView, View view, MotionEvent motionEvent) {
        i.f(behindView, "$behindView");
        view.getParent().requestDisallowInterceptTouchEvent(true);
        return behindView.dispatchTouchEvent(motionEvent);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void attachBehindView(final View behindView) {
        i.f(behindView, "behindView");
        this.itemView.setOnTouchListener(new View.OnTouchListener() { // from class: com.mobvoi.companion.health.viewholder.f
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean z10;
                z10 = EmptyViewHolder.m12attachBehindView$lambda0(behindView, view, motionEvent);
                return z10;
            }
        });
    }

    @Override // com.mobvoi.companion.health.viewholder.i
    protected boolean needClick() {
        return false;
    }

    @Override // com.mobvoi.companion.health.viewholder.i
    protected void onBindData(b<?> data) {
        i.f(data, "data");
    }

    @Override // com.mobvoi.companion.health.viewholder.i
    protected void onDataEmpty() {
    }

    @Override // com.mobvoi.companion.health.viewholder.i
    protected void onItemClick(b<?> data, int i10, a controlInterface) {
        i.f(data, "data");
        i.f(controlInterface, "controlInterface");
    }
}
