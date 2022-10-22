package com.mobvoi.health.companion.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import fg.p;
/* loaded from: classes2.dex */
public class ShowWeeksDatePicker extends DatePicker {
    private float S = getResources().getDimensionPixelSize(p.f26501d);

    public ShowWeeksDatePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // com.mobvoi.health.companion.ui.DatePicker, android.widget.LinearLayout, android.view.View
    protected void onDraw(Canvas canvas) {
        float f10 = this.f19076x;
        int[] iArr = this.f19069q;
        this.f19070r.setColor(this.f19059g);
        this.f19070r.setTextAlign(Paint.Align.CENTER);
        for (int i10 : iArr) {
            String str = this.f19068p.get(i10);
            float height = (getHeight() - (this.f19072t / 2.0f)) - this.S;
            if (this.f19063k != i10) {
                this.f19070r.setColor(this.f19058f);
            } else if (this.f19057e) {
                this.f19070r.setColor(-1);
                canvas.drawPoint((this.f19074v / 2) + f10, height, this.f19071s);
            } else {
                this.f19070r.setColor(this.f19059g);
            }
            String[] split = str.split(",");
            if (split != null && split.length == 2) {
                canvas.drawText(split[0], (this.f19074v / 2) + f10, height - ((this.f19070r.ascent() + this.f19070r.descent()) / 2.0f), this.f19070r);
                this.f19070r.setColor(this.f19058f);
                canvas.drawText(split[1], (this.f19074v / 2) + f10, ((this.f19072t + (this.S * 2.0f)) / 2.0f) - ((this.f19070r.ascent() + this.f19070r.descent()) / 2.0f), this.f19070r);
            }
            f10 += this.f19074v;
        }
    }
}
