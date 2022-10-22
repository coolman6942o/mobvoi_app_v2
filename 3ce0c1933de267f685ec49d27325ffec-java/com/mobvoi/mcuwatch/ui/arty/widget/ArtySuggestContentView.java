package com.mobvoi.mcuwatch.ui.arty.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cardiex.arty.lite.models.coach.ArtyLatest;
import com.mobvoi.companion.health.widget.arty.a;
import com.mobvoi.mcuwatch.engine.n;
import com.mobvoi.mcuwatch.ui.arty.ArtyAboutActivity;
import com.mobvoi.wear.util.DimensionUtils;
import sh.f;
import sh.h;
import sh.i;
import sh.k;
/* loaded from: classes2.dex */
public class ArtySuggestContentView extends ConstraintLayout {

    /* renamed from: u  reason: collision with root package name */
    private Context f19448u;

    /* renamed from: v  reason: collision with root package name */
    private ImageView f19449v;

    /* renamed from: w  reason: collision with root package name */
    private float f19450w;

    /* renamed from: x  reason: collision with root package name */
    private int f19451x;

    /* renamed from: y  reason: collision with root package name */
    private TextView f19452y;

    public ArtySuggestContentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        LayoutInflater.from(this.f19448u).inflate(i.P0, (ViewGroup) this, true);
        this.f19449v = (ImageView) findViewById(h.f34692s1);
        this.f19452y = (TextView) findViewById(h.f34642g4);
        setElevation(DimensionUtils.dp2px(this.f19448u, 2.0f));
        setBackgroundResource(f.f34600x1);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            float x10 = motionEvent.getX();
            float y10 = motionEvent.getY();
            float abs = Math.abs(getWidth() - x10);
            float width = this.f19449v.getWidth() + this.f19449v.getTop();
            this.f19450w = width;
            if (abs < width && y10 < width) {
                ArtyAboutActivity.S(this.f19448u, this.f19451x);
                return true;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setArtyLatestValue(ArtyLatest artyLatest) {
        if (artyLatest.getCurrentComponent() != null) {
            try {
                this.f19451x = a.f17142a.a(artyLatest.getCurrentComponent().getArtyType());
                double percentile = artyLatest.getPercentile();
                int i10 = this.f19451x;
                if (i10 != 0) {
                    if (i10 != 1) {
                        if (i10 != 2) {
                            if (i10 != 3) {
                                if (i10 == 4 && percentile > n.f19178a.b()) {
                                    this.f19452y.setText(k.C_res_0x7f140114);
                                    setVisibility(0);
                                }
                            } else if (percentile >= 75.0d) {
                                this.f19452y.setText(k.E);
                                setVisibility(0);
                            }
                        } else if (percentile > 0.0d) {
                            this.f19452y.setText(getContext().getString(k.D, Double.valueOf(artyLatest.getPercentile())));
                            setVisibility(0);
                        }
                    } else if (percentile >= 60.0d && percentile <= 70.0d) {
                        this.f19452y.setText(k.G);
                        setVisibility(0);
                    }
                } else if (percentile > 0.0d) {
                    this.f19452y.setText(getContext().getString(k.F, Double.valueOf(artyLatest.getPercentile())));
                    setVisibility(0);
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public ArtySuggestContentView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f19448u = context;
    }
}
