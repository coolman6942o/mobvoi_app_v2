package com.mobvoi.companion.health.widget.arty;

import a0.h;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cardiex.arty.lite.models.coach.Question;
import com.mobvoi.companion.R;
import com.mobvoi.wear.util.DimensionUtils;
import java.util.Objects;
import kotlin.jvm.internal.i;
import yc.k;
import zc.a;
/* compiled from: ArtyTipsTextView.kt */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes2.dex */
public final class ArtyTipsTextView extends TextView implements k {

    /* renamed from: a  reason: collision with root package name */
    private final Paint f17138a;

    /* renamed from: b  reason: collision with root package name */
    private final Path f17139b;

    /* renamed from: c  reason: collision with root package name */
    private final float f17140c;

    /* renamed from: d  reason: collision with root package name */
    private final RectF f17141d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ArtyTipsTextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        i.f(context, "context");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ArtyTipsTextView);
        i.e(obtainStyledAttributes, "context.obtainStyledAttributes(attrs, R.styleable.ArtyTipsTextView)");
        int color = obtainStyledAttributes.getColor(R.styleable.ArtyTipsTextView_tipsBgColor, getResources().getColor(R.color.color_274fa6));
        this.f17140c = obtainStyledAttributes.getDimension(R.styleable.ArtyTipsTextView_tipsRadius, DimensionUtils.dp2px(context, 15.0f));
        obtainStyledAttributes.recycle();
        Paint paint = new Paint();
        this.f17138a = paint;
        paint.setColor(color);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        this.f17139b = new Path();
        this.f17141d = new RectF();
        setTypeface(h.h(context, R.font.sfuitext_medium));
    }

    @Override // yc.k
    public void c(a dataArty) {
        i.f(dataArty, "dataArty");
        if (dataArty.c() instanceof String) {
            Object c10 = dataArty.c();
            Objects.requireNonNull(c10, "null cannot be cast to non-null type kotlin.String");
            setText((String) c10);
        } else if (dataArty.c() instanceof Question) {
            Object c11 = dataArty.c();
            Objects.requireNonNull(c11, "null cannot be cast to non-null type com.cardiex.arty.lite.models.coach.Question");
            setText(((Question) c11).getValue());
        }
        setTextColor(getContext().getColor(R.color.white));
        setTextSize(2, 17.0f);
        setPadding((int) DimensionUtils.dp2px(getContext(), 20.0f), (int) DimensionUtils.dp2px(getContext(), 10.0f), (int) DimensionUtils.dp2px(getContext(), 15.0f), (int) DimensionUtils.dp2px(getContext(), 14.0f));
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        ((ViewGroup.MarginLayoutParams) bVar).width = 0;
        ((ViewGroup.MarginLayoutParams) bVar).height = 0;
        bVar.V = true;
        bVar.W = true;
        bVar.Q = 0.784f;
        if (dataArty.a() == 2) {
            bVar.R = 0.4f;
            setMaxLines(5);
        } else if (dataArty.a() == 7) {
            bVar.R = 0.9f;
            setMaxLines(12);
        }
        setEllipsize(TextUtils.TruncateAt.END);
        setLayoutParams(bVar);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        i.f(canvas, "canvas");
        this.f17139b.reset();
        this.f17139b.moveTo(0.0f, 0.0f);
        RectF rectF = this.f17141d;
        float f10 = this.f17140c;
        double d10 = 0.0f;
        rectF.set(0.0f - ((3 * f10) / 2.0f), (float) (d10 - (f10 * 0.134d)), (f10 / 2.0f) + 0.0f, (float) (d10 + (f10 * 1.866d)));
        this.f17139b.arcTo(this.f17141d, 300.0f, 60.0f);
        this.f17139b.lineTo((this.f17140c / 2.0f) + 0.0f, getHeight() - this.f17140c);
        float f11 = 2;
        float f12 = this.f17140c;
        this.f17141d.set((this.f17140c / 2.0f) + 0.0f, getHeight() - (f11 * f12), ((f12 * 5) / 2.0f) + 0.0f, getHeight());
        this.f17139b.arcTo(this.f17141d, 180.0f, -90.0f);
        this.f17139b.lineTo(getWidth() - this.f17140c, getHeight());
        this.f17141d.set(getWidth() - (this.f17140c * f11), getHeight() - (this.f17140c * f11), getWidth(), getHeight());
        this.f17139b.arcTo(this.f17141d, 90.0f, -90.0f);
        this.f17139b.lineTo(getWidth(), getHeight() - this.f17140c);
        this.f17141d.set(getWidth() - (this.f17140c * f11), 0.0f, getWidth(), (f11 * this.f17140c) + 0.0f);
        this.f17139b.arcTo(this.f17141d, 0.0f, -90.0f);
        this.f17139b.lineTo(0.0f, 0.0f);
        canvas.drawPath(this.f17139b, this.f17138a);
        super.onDraw(canvas);
    }

    public final void setTips(String tips) {
        i.f(tips, "tips");
        setText(tips);
        setVisibility(0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ArtyTipsTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        i.f(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ArtyTipsTextView(Context context) {
        this(context, null);
        i.f(context, "context");
    }
}
