package com.mobvoi.health.companion.sleep.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import fg.o;
import fg.p;
import java.util.List;
import sg.e;
/* loaded from: classes2.dex */
public class SleepTypePercentBar extends View {

    /* renamed from: a  reason: collision with root package name */
    private Paint f18763a;

    /* renamed from: b  reason: collision with root package name */
    private List<e> f18764b;

    /* renamed from: c  reason: collision with root package name */
    private float f18765c;

    /* renamed from: d  reason: collision with root package name */
    private float f18766d;

    /* renamed from: e  reason: collision with root package name */
    private float f18767e;

    /* renamed from: f  reason: collision with root package name */
    private float f18768f;

    /* renamed from: g  reason: collision with root package name */
    private float f18769g;

    public SleepTypePercentBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a() {
        float f10;
        float f11;
        this.f18765c = getPaddingTop();
        this.f18766d = getHeight() - getPaddingBottom();
        this.f18767e = getPaddingLeft();
        this.f18768f = getWidth() - getPaddingRight();
        List<e> list = this.f18764b;
        if (list != null && list.size() > 0) {
            float size = (this.f18768f - this.f18767e) - ((this.f18764b.size() - 1) * this.f18769g);
            float f12 = this.f18767e;
            for (e eVar : this.f18764b) {
                int i10 = eVar.f34423a;
                if (i10 > 0) {
                    eVar.f34426d = f12;
                    f10 = f12 + ((i10 * size) / 100.0f);
                    eVar.f34427e = f10;
                    f11 = this.f18769g;
                } else if (i10 == 0 && eVar.f34424b > 0) {
                    eVar.f34426d = f12;
                    f10 = f12 + 1.0f;
                    eVar.f34427e = f10;
                    f11 = this.f18769g;
                }
                f12 = f10 + f11;
            }
        }
    }

    private void b() {
        this.f18769g = getResources().getDimension(p.f26504e0);
        Paint paint = new Paint(1);
        this.f18763a = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f18763a.setStrokeWidth(getResources().getDimensionPixelSize(p.f26527q));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        List<e> list = this.f18764b;
        if (list == null || list.size() <= 0) {
            this.f18763a.setColor(getResources().getColor(o.f26456f));
            canvas.drawRect(this.f18767e, this.f18765c, this.f18768f, this.f18766d, this.f18763a);
            return;
        }
        for (int i10 = 0; i10 < this.f18764b.size(); i10++) {
            e eVar = this.f18764b.get(i10);
            this.f18763a.setColor(getResources().getColor(eVar.a()));
            canvas.drawRect(eVar.f34426d, this.f18765c, eVar.f34427e, this.f18766d, this.f18763a);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        a();
    }

    public void setPercents(List<e> list) {
        this.f18764b = list;
        a();
        invalidate();
    }

    public SleepTypePercentBar(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        b();
    }
}
