package ba;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
/* compiled from: RecyclerViewItemDecoration.java */
/* loaded from: classes2.dex */
public class a extends RecyclerView.n {

    /* renamed from: a  reason: collision with root package name */
    private int f5113a;

    /* renamed from: b  reason: collision with root package name */
    private int f5114b;

    /* renamed from: c  reason: collision with root package name */
    private int f5115c;

    /* renamed from: d  reason: collision with root package name */
    private int f5116d;

    /* renamed from: e  reason: collision with root package name */
    private int f5117e;

    /* renamed from: f  reason: collision with root package name */
    private int f5118f;

    /* renamed from: g  reason: collision with root package name */
    private int f5119g;

    /* renamed from: h  reason: collision with root package name */
    private Paint f5120h;

    public a(int i10, int i11, int i12, int i13) {
        this(i10, i11, i12, i13, i13, i13, i13);
    }

    private void i(Canvas canvas, RecyclerView recyclerView) {
        int childCount = recyclerView.getChildCount();
        int W2 = ((GridLayoutManager) recyclerView.getLayoutManager()).W2();
        int itemCount = recyclerView.getAdapter().getItemCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = recyclerView.getChildAt(i10);
            int right = childAt.getRight() + (this.f5115c / 2);
            int bottom = childAt.getBottom() + (this.f5115c / 2);
            if (!n(i10, itemCount, W2)) {
                float f10 = bottom;
                canvas.drawLine(childAt.getLeft() + this.f5116d, f10, childAt.getRight() - this.f5118f, f10, this.f5120h);
            }
            if (n(i10, itemCount, W2) && !m(i10, W2)) {
                float f11 = right;
                canvas.drawLine(f11, childAt.getTop() + this.f5117e, f11, childAt.getBottom() - this.f5119g, this.f5120h);
            } else if (!m(i10, W2)) {
                float f12 = right;
                canvas.drawLine(f12, childAt.getTop() + this.f5117e, f12, bottom - this.f5119g, this.f5120h);
            }
        }
    }

    private void j(Canvas canvas, RecyclerView recyclerView) {
        int childCount = recyclerView.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            if (i10 != childCount - 1) {
                float bottom = recyclerView.getChildAt(i10).getBottom() + (this.f5115c / 2);
                canvas.drawLine(this.f5116d, bottom, recyclerView.getWidth() - this.f5118f, bottom, this.f5120h);
            }
        }
    }

    private void k(Canvas canvas, RecyclerView recyclerView) {
        int childCount = recyclerView.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            if (i10 != childCount - 1) {
                float right = recyclerView.getChildAt(i10).getRight() + (this.f5115c / 2);
                canvas.drawLine(right, this.f5117e, right, recyclerView.getHeight() - this.f5119g, this.f5120h);
            }
        }
    }

    private void l() {
        Paint paint = new Paint();
        this.f5120h = paint;
        paint.setColor(this.f5114b);
        this.f5120h.setStyle(Paint.Style.STROKE);
        this.f5120h.setStrokeWidth(this.f5115c);
    }

    private boolean m(int i10, int i11) {
        return (i10 + 1) % i11 == 0;
    }

    private boolean n(int i10, int i11, int i12) {
        return i10 / i12 == (i11 - 1) / i12;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void d(Rect rect, View view, RecyclerView recyclerView, RecyclerView.y yVar) {
        if (this.f5113a == 0 && recyclerView.h0(view) != recyclerView.getAdapter().getItemCount() - 1) {
            rect.set(0, 0, 0, this.f5115c);
        } else if (this.f5113a == 1 && recyclerView.h0(view) != recyclerView.getAdapter().getItemCount() - 1) {
            rect.set(0, 0, this.f5115c, 0);
        } else if (this.f5113a == 2) {
            int W2 = ((GridLayoutManager) recyclerView.getLayoutManager()).W2();
            int itemCount = recyclerView.getAdapter().getItemCount();
            if (n(recyclerView.h0(view), itemCount, W2) && m(recyclerView.h0(view), W2)) {
                rect.set(0, 0, 0, 0);
            } else if (n(recyclerView.h0(view), itemCount, W2)) {
                rect.set(0, 0, this.f5115c, 0);
            } else if ((recyclerView.h0(view) + 1) % W2 != 0) {
                int i10 = this.f5115c;
                rect.set(0, 0, i10, i10);
            } else {
                rect.set(0, 0, 0, this.f5115c);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void f(Canvas canvas, RecyclerView recyclerView, RecyclerView.y yVar) {
        this.f5120h.setColor(this.f5114b);
        int i10 = this.f5113a;
        if (i10 == 0) {
            j(canvas, recyclerView);
        } else if (i10 == 1) {
            k(canvas, recyclerView);
        } else if (i10 == 2) {
            i(canvas, recyclerView);
        }
    }

    public a(int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        this.f5113a = i10;
        this.f5114b = i11;
        this.f5115c = i12;
        this.f5116d = i13;
        this.f5117e = i14;
        this.f5118f = i15;
        this.f5119g = i16;
        l();
    }
}
