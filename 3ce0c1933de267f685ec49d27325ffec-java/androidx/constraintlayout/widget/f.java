package androidx.constraintlayout.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
/* compiled from: Placeholder.java */
/* loaded from: classes.dex */
public class f extends View {

    /* renamed from: a  reason: collision with root package name */
    private int f1973a;

    /* renamed from: b  reason: collision with root package name */
    private View f1974b;

    /* renamed from: c  reason: collision with root package name */
    private int f1975c;

    public void a(ConstraintLayout constraintLayout) {
        if (this.f1974b != null) {
            ConstraintLayout.b bVar = (ConstraintLayout.b) getLayoutParams();
            ConstraintLayout.b bVar2 = (ConstraintLayout.b) this.f1974b.getLayoutParams();
            bVar2.f1817q0.a1(0);
            ConstraintWidget.DimensionBehaviour y10 = bVar.f1817q0.y();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
            if (y10 != dimensionBehaviour) {
                bVar.f1817q0.b1(bVar2.f1817q0.R());
            }
            if (bVar.f1817q0.O() != dimensionBehaviour) {
                bVar.f1817q0.C0(bVar2.f1817q0.v());
            }
            bVar2.f1817q0.a1(8);
        }
    }

    public void b(ConstraintLayout constraintLayout) {
        if (this.f1973a == -1 && !isInEditMode()) {
            setVisibility(this.f1975c);
        }
        View findViewById = constraintLayout.findViewById(this.f1973a);
        this.f1974b = findViewById;
        if (findViewById != null) {
            ((ConstraintLayout.b) findViewById.getLayoutParams()).f1793e0 = true;
            this.f1974b.setVisibility(0);
            setVisibility(0);
        }
    }

    public View getContent() {
        return this.f1974b;
    }

    public int getEmptyVisibility() {
        return this.f1975c;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(223, 223, 223);
            Paint paint = new Paint();
            paint.setARGB(255, 210, 210, 210);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize(rect.height());
            int height = rect.height();
            int width = rect.width();
            paint.setTextAlign(Paint.Align.LEFT);
            paint.getTextBounds("?", 0, 1, rect);
            canvas.drawText("?", ((width / 2.0f) - (rect.width() / 2.0f)) - rect.left, ((height / 2.0f) + (rect.height() / 2.0f)) - rect.bottom, paint);
        }
    }

    public void setContentId(int i10) {
        View findViewById;
        if (this.f1973a != i10) {
            View view = this.f1974b;
            if (view != null) {
                view.setVisibility(0);
                ((ConstraintLayout.b) this.f1974b.getLayoutParams()).f1793e0 = false;
                this.f1974b = null;
            }
            this.f1973a = i10;
            if (i10 != -1 && (findViewById = ((View) getParent()).findViewById(i10)) != null) {
                findViewById.setVisibility(8);
            }
        }
    }

    public void setEmptyVisibility(int i10) {
        this.f1975c = i10;
    }
}
