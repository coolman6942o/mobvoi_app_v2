package com.mobvoi.mcuwatch.ui.customview;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.mobvoi.mcuwatch.ui.customview.SportControlStatusView;
import com.mobvoi.wear.util.DimensionUtils;
import java.util.Timer;
import java.util.TimerTask;
import mj.n;
import sh.d;
import sh.f;
import sh.h;
import sh.i;
/* loaded from: classes2.dex */
public class SportControlStatusView extends ConstraintLayout implements View.OnClickListener {
    private Timer A;
    GradientDrawable B;
    n C;
    private boolean D;
    private final TimerTask E;

    /* renamed from: u  reason: collision with root package name */
    private final Context f19593u;

    /* renamed from: v  reason: collision with root package name */
    private ImageView f19594v;

    /* renamed from: w  reason: collision with root package name */
    private ImageView f19595w;

    /* renamed from: x  reason: collision with root package name */
    private TextView f19596x;

    /* renamed from: y  reason: collision with root package name */
    private int f19597y;

    /* renamed from: z  reason: collision with root package name */
    private int f19598z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends TimerTask {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b() {
            if (SportControlStatusView.this.f19598z == 0) {
                SportControlStatusView.this.C.i(2, true);
                SportControlStatusView.this.A.cancel();
            } else if (SportControlStatusView.this.f19597y == 1) {
                SportControlStatusView.this.f19596x.setText(String.valueOf(SportControlStatusView.G(SportControlStatusView.this)));
            }
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            SportControlStatusView.this.f19596x.post(new Runnable() { // from class: com.mobvoi.mcuwatch.ui.customview.c0
                @Override // java.lang.Runnable
                public final void run() {
                    SportControlStatusView.a.this.b();
                }
            });
        }
    }

    public SportControlStatusView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    static /* synthetic */ int G(SportControlStatusView sportControlStatusView) {
        int i10 = sportControlStatusView.f19598z;
        sportControlStatusView.f19598z = i10 - 1;
        return i10;
    }

    private void J() {
        LayoutInflater.from(this.f19593u).inflate(i.W0, (ViewGroup) this, true);
        this.f19594v = (ImageView) findViewById(h.R_res_0x7f0b00fe);
        this.f19595w = (ImageView) findViewById(h.B1);
        this.f19596x = (TextView) findViewById(h.B3);
        this.f19594v.setOnClickListener(this);
        this.B = (GradientDrawable) this.f19594v.getBackground();
        this.A = new Timer();
    }

    private void K() {
        this.f19594v.setBackground(this.B);
        this.f19595w.setBackground(getResources().getDrawable(f.f34569n0));
        this.f19596x.setVisibility(8);
    }

    public void a(int i10) {
        this.f19597y = i10;
        if (i10 == 0) {
            this.B.setColor(getResources().getColor(d.f34466z));
            K();
        } else if (i10 == 1) {
            this.f19595w.setVisibility(8);
            this.f19596x.setVisibility(0);
            this.A.schedule(this.E, 0L, 1000L);
        } else if (i10 == 2) {
            this.f19595w.setVisibility(0);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLayoutParams();
            layoutParams.width = (int) DimensionUtils.dp2px(getContext(), 80.0f);
            setLayoutParams(layoutParams);
            this.B.setColor(getResources().getColor(d.E));
            this.f19594v.setBackground(this.B);
            this.f19595w.setBackground(getResources().getDrawable(f.f34575p0));
            if (this.D) {
                this.f19595w.setTranslationX(0.0f);
                this.D = false;
            }
            this.f19596x.setVisibility(8);
        } else if (i10 == 3) {
            this.B.setColor(getResources().getColor(d.B));
            this.f19595w.setTranslationX(DimensionUtils.dp2px(getContext(), 2.0f));
            this.D = true;
            K();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == h.R_res_0x7f0b00fe) {
            int i10 = this.f19597y;
            if (i10 == 0) {
                this.C.i(1, true);
            } else if (i10 == 2) {
                this.C.i(3, true);
            } else if (i10 == 3) {
                this.C.i(2, true);
            }
        }
    }

    public void setWorkShortPresenter(n nVar) {
        this.C = nVar;
    }

    public SportControlStatusView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f19598z = 3;
        this.D = false;
        this.E = new a();
        this.f19593u = context;
        J();
    }
}
