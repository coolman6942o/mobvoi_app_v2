package com.mobvoi.assistant.account.ui.widget;

import aa.d;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.annotation.Keep;
import androidx.appcompat.widget.b0;
import pa.c;
import pa.i;
import pa.j;
/* loaded from: classes2.dex */
public class TimerButton extends b0 {

    /* renamed from: g  reason: collision with root package name */
    private boolean f15708g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f15709h;

    /* renamed from: i  reason: collision with root package name */
    private int f15710i;

    /* renamed from: j  reason: collision with root package name */
    private int f15711j;

    /* renamed from: k  reason: collision with root package name */
    private int f15712k;

    /* renamed from: l  reason: collision with root package name */
    private int f15713l;

    /* renamed from: m  reason: collision with root package name */
    private String f15714m;

    /* renamed from: n  reason: collision with root package name */
    private String f15715n;

    /* renamed from: o  reason: collision with root package name */
    private String f15716o;

    /* renamed from: p  reason: collision with root package name */
    private a f15717p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends CountDownTimer {
        a(long j10, long j11) {
            super(j10 * 1000, j11 * 1000);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            TimerButton.this.setEnabled(true);
            TimerButton.this.setClickable(true);
            TimerButton timerButton = TimerButton.this;
            timerButton.setText(timerButton.f15716o);
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j10) {
            String valueOf = String.valueOf(j10 / 1000);
            TimerButton timerButton = TimerButton.this;
            timerButton.setText(String.format(timerButton.f15715n, valueOf));
        }
    }

    public TimerButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void h() {
        this.f15717p = new a(this.f15712k, this.f15713l);
        if (this.f15708g) {
            j();
        }
    }

    private void i() {
        if (!this.f15709h) {
            StateListDrawable stateListDrawable = new StateListDrawable();
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(d.a(4.0f));
            gradientDrawable.setStroke(d.a(1.0f), this.f15710i);
            if (Build.VERSION.SDK_INT >= 21) {
                float a10 = d.a(4.0f);
                stateListDrawable.addState(new int[]{16842919}, new RippleDrawable(ColorStateList.valueOf(this.f15710i), gradientDrawable, new ShapeDrawable(new RoundRectShape(new float[]{a10, a10, a10, a10, a10, a10, a10, a10}, null, null))));
            }
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setCornerRadius(d.a(4.0f));
            gradientDrawable2.setStroke(d.a(1.0f), this.f15711j);
            stateListDrawable.addState(new int[]{16842910}, gradientDrawable);
            stateListDrawable.addState(new int[0], gradientDrawable2);
            setBackground(stateListDrawable);
        }
        setTextColor(new ColorStateList(new int[][]{new int[]{16842910}, new int[0]}, new int[]{this.f15710i, this.f15711j}));
        setText(this.f15714m);
    }

    public void j() {
        this.f15717p.start();
        setEnabled(false);
        setClickable(false);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f15717p.cancel();
    }

    @Keep
    public void setAfterText(String str) {
        this.f15716o = str;
    }

    @Keep
    public void setBeforeText(String str) {
        this.f15714m = str;
    }

    @Keep
    public void setBorderless(boolean z10) {
        this.f15709h = z10;
    }

    @Keep
    public void setColorEnable(int i10) {
        this.f15710i = i10;
    }

    @Keep
    public void setColorUnable(int i10) {
        this.f15711j = i10;
    }

    @Keep
    public void setCountDownFormat(String str) {
        this.f15715n = str;
    }

    @Keep
    public void setCountDownInterval(int i10) {
        this.f15713l = i10;
    }

    @Keep
    public void setCountDownSecond(int i10) {
        this.f15712k = i10;
    }

    public TimerButton(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        int color = getResources().getColor(c.f32618a);
        int color2 = getResources().getColor(c.f32619b);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.f32717a);
        this.f15708g = obtainStyledAttributes.getBoolean(j.f32719c, false);
        this.f15709h = obtainStyledAttributes.getBoolean(j.f32721e, false);
        String string = obtainStyledAttributes.getString(j.f32720d);
        this.f15714m = string;
        if (TextUtils.isEmpty(string)) {
            this.f15714m = getContext().getString(i.f32714x);
        }
        String string2 = obtainStyledAttributes.getString(j.f32724h);
        this.f15715n = string2;
        if (TextUtils.isEmpty(string2)) {
            this.f15715n = getContext().getString(i.X);
        }
        String string3 = obtainStyledAttributes.getString(j.f32718b);
        this.f15716o = string3;
        if (TextUtils.isEmpty(string3)) {
            this.f15716o = getContext().getString(i.U);
        }
        this.f15710i = obtainStyledAttributes.getColor(j.f32722f, color);
        this.f15711j = obtainStyledAttributes.getColor(j.f32723g, color2);
        this.f15712k = obtainStyledAttributes.getInt(j.f32726j, 60);
        this.f15713l = obtainStyledAttributes.getInt(j.f32725i, 1);
        obtainStyledAttributes.recycle();
        setTextSize(2, 15.0f);
        setGravity(17);
        i();
        h();
    }
}
