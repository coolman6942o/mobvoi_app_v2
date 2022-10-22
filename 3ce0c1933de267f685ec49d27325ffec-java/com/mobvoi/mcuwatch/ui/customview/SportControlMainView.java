package com.mobvoi.mcuwatch.ui.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.mobvoi.mcuwatch.ui.customview.SportControlLockButton;
import mj.b;
import mj.n;
import sh.h;
import sh.i;
/* loaded from: classes2.dex */
public class SportControlMainView extends RelativeLayout implements b {

    /* renamed from: a  reason: collision with root package name */
    private final Context f19589a;

    /* renamed from: b  reason: collision with root package name */
    private SportControlStatusView f19590b;

    /* renamed from: c  reason: collision with root package name */
    private SportControlLockButton f19591c;

    /* renamed from: d  reason: collision with root package name */
    private SportControlStopButton f19592d;

    public SportControlMainView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void c() {
        LayoutInflater.from(this.f19589a).inflate(i.V0, (ViewGroup) this, true);
        this.f19592d = (SportControlStopButton) findViewById(h.X2);
        this.f19590b = (SportControlStatusView) findViewById(h.W2);
        SportControlLockButton sportControlLockButton = (SportControlLockButton) findViewById(h.U2);
        this.f19591c = sportControlLockButton;
        sportControlLockButton.setLockStatusChangeCallback(new SportControlLockButton.a() { // from class: com.mobvoi.mcuwatch.ui.customview.a0
            @Override // com.mobvoi.mcuwatch.ui.customview.SportControlLockButton.a
            public final void a(int i10) {
                SportControlMainView.this.f(i10);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e(int i10) {
        if (i10 == 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f19591c.getLayoutParams();
            layoutParams.removeRule(14);
            layoutParams.addRule(11);
            this.f19591c.setLayoutParams(layoutParams);
            this.f19592d.setVisibility(0);
            this.f19590b.setVisibility(0);
            this.f19591c.setVisibility(0);
        } else if (i10 == 1 || i10 == 2) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f19591c.getLayoutParams();
            layoutParams2.removeRule(11);
            layoutParams2.addRule(14);
            this.f19591c.setLayoutParams(layoutParams2);
            this.f19592d.setVisibility(8);
            this.f19590b.setVisibility(8);
            this.f19591c.setVisibility(0);
        }
    }

    @Override // mj.b
    public void a(int i10) {
        this.f19590b.a(i10);
        if (i10 == 0 || i10 == 1) {
            this.f19592d.setVisibility(8);
            this.f19590b.setVisibility(0);
            this.f19591c.setVisibility(8);
        } else if (i10 == 2 || i10 == 3) {
            this.f19592d.setVisibility(0);
            this.f19590b.setVisibility(0);
            this.f19591c.setVisibility(0);
        } else if (i10 == 4) {
            this.f19592d.setVisibility(8);
            this.f19590b.setVisibility(8);
            this.f19591c.setVisibility(8);
        }
    }

    @Override // mj.b
    public void d(int i10) {
    }

    public void f(final int i10) {
        this.f19590b.post(new Runnable() { // from class: com.mobvoi.mcuwatch.ui.customview.b0
            @Override // java.lang.Runnable
            public final void run() {
                SportControlMainView.this.e(i10);
            }
        });
    }

    public void setWorkShortPresenter(n nVar) {
        this.f19590b.setWorkShortPresenter(nVar);
        this.f19592d.setWorkShortPresenter(nVar);
    }

    public SportControlMainView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f19589a = context;
        c();
    }
}
