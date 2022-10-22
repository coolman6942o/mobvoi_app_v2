package com.mobvoi.companion.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.mobvoi.companion.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class StarRatingView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private Drawable f17673a;

    /* renamed from: b  reason: collision with root package name */
    private Drawable f17674b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f17675c;

    /* renamed from: d  reason: collision with root package name */
    private float f17676d;

    /* renamed from: g  reason: collision with root package name */
    private float f17679g;

    /* renamed from: i  reason: collision with root package name */
    private a f17681i;

    /* renamed from: f  reason: collision with root package name */
    private float[] f17678f = new float[5];

    /* renamed from: h  reason: collision with root package name */
    private int f17680h = getPaddingLeft();

    /* renamed from: e  reason: collision with root package name */
    private List<ImageView> f17677e = new ArrayList();

    /* loaded from: classes2.dex */
    public interface a {
        void x(int i10);
    }

    public StarRatingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.StarRatingView);
        this.f17673a = obtainStyledAttributes.getDrawable(R.styleable.StarRatingView_stat_on);
        this.f17674b = obtainStyledAttributes.getDrawable(R.styleable.StarRatingView_stat_off);
        this.f17675c = obtainStyledAttributes.getBoolean(R.styleable.StarRatingView_ratable, false);
        int intrinsicWidth = this.f17673a.getIntrinsicWidth() / 2;
        float intrinsicWidth2 = this.f17673a.getIntrinsicWidth();
        this.f17679g = intrinsicWidth2;
        this.f17676d = obtainStyledAttributes.getDimension(R.styleable.StarRatingView_star_padding, intrinsicWidth2 / 3.0f);
        for (int i10 = 0; i10 < 5; i10++) {
            ImageView imageView = new ImageView(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            if (i10 == 0) {
                layoutParams.setMargins(0, 0, ((int) this.f17676d) / 2, 0);
                this.f17678f[0] = 0.0f;
            } else if (i10 == 4) {
                layoutParams.setMargins(((int) this.f17676d) / 2, 0, 0, 0);
                float f10 = i10;
                this.f17678f[i10] = (this.f17679g * f10) + (f10 * this.f17676d);
            } else {
                float f11 = this.f17676d;
                layoutParams.setMargins(((int) f11) / 2, 0, ((int) f11) / 2, 0);
                float f12 = i10;
                this.f17678f[i10] = (this.f17679g * f12) + (f12 * this.f17676d);
            }
            imageView.setLayoutParams(layoutParams);
            imageView.setImageDrawable(this.f17674b);
            this.f17677e.add(imageView);
            addView(this.f17677e.get(i10));
        }
        setOrientation(0);
        obtainStyledAttributes.recycle();
    }

    private int a(float f10) {
        float f11 = f10 - this.f17680h;
        int i10 = 0;
        while (true) {
            float[] fArr = this.f17678f;
            if (i10 >= fArr.length) {
                return 5;
            }
            if (fArr[i10] > f11) {
                return i10;
            }
            i10++;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f17675c) {
            return super.onTouchEvent(motionEvent);
        }
        setRate(a(motionEvent.getX()));
        return true;
    }

    public void setOnRateChangeListener(a aVar) {
        this.f17681i = aVar;
    }

    public void setRatable(boolean z10) {
        this.f17675c = z10;
    }

    public void setRate(int i10) {
        a aVar;
        removeAllViews();
        for (int i11 = 0; i11 < this.f17677e.size(); i11++) {
            if (i11 < i10) {
                this.f17677e.get(i11).setImageDrawable(this.f17673a);
            } else {
                this.f17677e.get(i11).setImageDrawable(this.f17674b);
            }
            addView(this.f17677e.get(i11));
        }
        if (this.f17675c && (aVar = this.f17681i) != null) {
            aVar.x(i10);
        }
    }
}
