package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.cardview.widget.g;
/* compiled from: CardViewBaseImpl.java */
/* loaded from: classes.dex */
class c implements e {

    /* renamed from: a  reason: collision with root package name */
    final RectF f1408a = new RectF();

    /* compiled from: CardViewBaseImpl.java */
    /* loaded from: classes.dex */
    class a implements g.a {
        a() {
        }

        @Override // androidx.cardview.widget.g.a
        public void a(Canvas canvas, RectF rectF, float f10, Paint paint) {
            float f11 = 2.0f * f10;
            float width = (rectF.width() - f11) - 1.0f;
            float height = (rectF.height() - f11) - 1.0f;
            if (f10 >= 1.0f) {
                float f12 = f10 + 0.5f;
                float f13 = -f12;
                c.this.f1408a.set(f13, f13, f12, f12);
                int save = canvas.save();
                canvas.translate(rectF.left + f12, rectF.top + f12);
                canvas.drawArc(c.this.f1408a, 180.0f, 90.0f, true, paint);
                canvas.translate(width, 0.0f);
                canvas.rotate(90.0f);
                canvas.drawArc(c.this.f1408a, 180.0f, 90.0f, true, paint);
                canvas.translate(height, 0.0f);
                canvas.rotate(90.0f);
                canvas.drawArc(c.this.f1408a, 180.0f, 90.0f, true, paint);
                canvas.translate(width, 0.0f);
                canvas.rotate(90.0f);
                canvas.drawArc(c.this.f1408a, 180.0f, 90.0f, true, paint);
                canvas.restoreToCount(save);
                float f14 = rectF.top;
                canvas.drawRect((rectF.left + f12) - 1.0f, f14, (rectF.right - f12) + 1.0f, f14 + f12, paint);
                float f15 = rectF.bottom;
                canvas.drawRect((rectF.left + f12) - 1.0f, f15 - f12, (rectF.right - f12) + 1.0f, f15, paint);
            }
            canvas.drawRect(rectF.left, rectF.top + f10, rectF.right, rectF.bottom - f10, paint);
        }
    }

    private g p(Context context, ColorStateList colorStateList, float f10, float f11, float f12) {
        return new g(context.getResources(), colorStateList, f10, f11, f12);
    }

    private g q(d dVar) {
        return (g) dVar.f();
    }

    @Override // androidx.cardview.widget.e
    public void a(d dVar, Context context, ColorStateList colorStateList, float f10, float f11, float f12) {
        g p10 = p(context, colorStateList, f10, f11, f12);
        p10.m(dVar.d());
        dVar.c(p10);
        i(dVar);
    }

    @Override // androidx.cardview.widget.e
    public void b(d dVar, float f10) {
        q(dVar).p(f10);
        i(dVar);
    }

    @Override // androidx.cardview.widget.e
    public float c(d dVar) {
        return q(dVar).l();
    }

    @Override // androidx.cardview.widget.e
    public float d(d dVar) {
        return q(dVar).g();
    }

    @Override // androidx.cardview.widget.e
    public void e(d dVar) {
    }

    @Override // androidx.cardview.widget.e
    public void f(d dVar, float f10) {
        q(dVar).r(f10);
    }

    @Override // androidx.cardview.widget.e
    public float g(d dVar) {
        return q(dVar).i();
    }

    @Override // androidx.cardview.widget.e
    public ColorStateList h(d dVar) {
        return q(dVar).f();
    }

    @Override // androidx.cardview.widget.e
    public void i(d dVar) {
        Rect rect = new Rect();
        q(dVar).h(rect);
        dVar.b((int) Math.ceil(l(dVar)), (int) Math.ceil(k(dVar)));
        dVar.a(rect.left, rect.top, rect.right, rect.bottom);
    }

    @Override // androidx.cardview.widget.e
    public void j() {
        g.f1422r = new a();
    }

    @Override // androidx.cardview.widget.e
    public float k(d dVar) {
        return q(dVar).j();
    }

    @Override // androidx.cardview.widget.e
    public float l(d dVar) {
        return q(dVar).k();
    }

    @Override // androidx.cardview.widget.e
    public void m(d dVar) {
        q(dVar).m(dVar.d());
        i(dVar);
    }

    @Override // androidx.cardview.widget.e
    public void n(d dVar, ColorStateList colorStateList) {
        q(dVar).o(colorStateList);
    }

    @Override // androidx.cardview.widget.e
    public void o(d dVar, float f10) {
        q(dVar).q(f10);
        i(dVar);
    }
}
