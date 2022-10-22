package l7;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.d0;
import androidx.recyclerview.widget.RecyclerView;
import d7.b;
import d7.d;
import d7.k;
import d7.l;
import t7.c;
/* compiled from: MaterialDividerItemDecoration.java */
/* loaded from: classes.dex */
public class a extends RecyclerView.n {

    /* renamed from: h  reason: collision with root package name */
    private static final int f30428h = k.f25361z;

    /* renamed from: a  reason: collision with root package name */
    private Drawable f30429a;

    /* renamed from: b  reason: collision with root package name */
    private int f30430b;

    /* renamed from: c  reason: collision with root package name */
    private int f30431c;

    /* renamed from: d  reason: collision with root package name */
    private int f30432d;

    /* renamed from: e  reason: collision with root package name */
    private int f30433e;

    /* renamed from: f  reason: collision with root package name */
    private int f30434f;

    /* renamed from: g  reason: collision with root package name */
    private final Rect f30435g;

    public a(Context context, int i10) {
        this(context, null, i10);
    }

    private void i(Canvas canvas, RecyclerView recyclerView) {
        int i10;
        int i11;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            i11 = recyclerView.getPaddingTop();
            i10 = recyclerView.getHeight() - recyclerView.getPaddingBottom();
            canvas.clipRect(recyclerView.getPaddingLeft(), i11, recyclerView.getWidth() - recyclerView.getPaddingRight(), i10);
        } else {
            i10 = recyclerView.getHeight();
            i11 = 0;
        }
        int i12 = i11 + this.f30433e;
        int i13 = i10 - this.f30434f;
        int childCount = recyclerView.getChildCount();
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = recyclerView.getChildAt(i14);
            recyclerView.getLayoutManager().Q(childAt, this.f30435g);
            int round = this.f30435g.right + Math.round(childAt.getTranslationX());
            this.f30429a.setBounds((round - this.f30429a.getIntrinsicWidth()) - this.f30430b, i12, round, i13);
            this.f30429a.draw(canvas);
        }
        canvas.restore();
    }

    private void j(Canvas canvas, RecyclerView recyclerView) {
        int i10;
        int i11;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            i11 = recyclerView.getPaddingLeft();
            i10 = recyclerView.getWidth() - recyclerView.getPaddingRight();
            canvas.clipRect(i11, recyclerView.getPaddingTop(), i10, recyclerView.getHeight() - recyclerView.getPaddingBottom());
        } else {
            i10 = recyclerView.getWidth();
            i11 = 0;
        }
        boolean z10 = true;
        if (d0.E(recyclerView) != 1) {
            z10 = false;
        }
        int i12 = i11 + (z10 ? this.f30434f : this.f30433e);
        int i13 = i10 - (z10 ? this.f30433e : this.f30434f);
        int childCount = recyclerView.getChildCount();
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = recyclerView.getChildAt(i14);
            recyclerView.k0(childAt, this.f30435g);
            int round = this.f30435g.bottom + Math.round(childAt.getTranslationY());
            this.f30429a.setBounds(i12, (round - this.f30429a.getIntrinsicHeight()) - this.f30430b, i13, round);
            this.f30429a.draw(canvas);
        }
        canvas.restore();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void d(Rect rect, View view, RecyclerView recyclerView, RecyclerView.y yVar) {
        rect.set(0, 0, 0, 0);
        if (this.f30432d == 1) {
            rect.bottom = this.f30429a.getIntrinsicHeight() + this.f30430b;
        } else {
            rect.right = this.f30429a.getIntrinsicWidth() + this.f30430b;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void f(Canvas canvas, RecyclerView recyclerView, RecyclerView.y yVar) {
        if (recyclerView.getLayoutManager() != null) {
            if (this.f30432d == 1) {
                j(canvas, recyclerView);
            } else {
                i(canvas, recyclerView);
            }
        }
    }

    public void k(int i10) {
        this.f30431c = i10;
        Drawable r10 = androidx.core.graphics.drawable.a.r(this.f30429a);
        this.f30429a = r10;
        androidx.core.graphics.drawable.a.n(r10, i10);
    }

    public void l(int i10) {
        this.f30433e = i10;
    }

    public void m(int i10) {
        if (i10 == 0 || i10 == 1) {
            this.f30432d = i10;
            return;
        }
        throw new IllegalArgumentException("Invalid orientation: " + i10 + ". It should be either HORIZONTAL or VERTICAL");
    }

    public a(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, b.G, i10);
    }

    public a(Context context, AttributeSet attributeSet, int i10, int i11) {
        this.f30435g = new Rect();
        TypedArray h10 = com.google.android.material.internal.k.h(context, attributeSet, l.f25398e3, i10, f30428h, new int[0]);
        this.f30431c = c.a(context, h10, l.f25406f3).getDefaultColor();
        this.f30430b = h10.getDimensionPixelSize(l.f25430i3, context.getResources().getDimensionPixelSize(d.A));
        this.f30433e = h10.getDimensionPixelOffset(l.f25422h3, 0);
        this.f30434f = h10.getDimensionPixelOffset(l.f25414g3, 0);
        h10.recycle();
        this.f30429a = new ShapeDrawable();
        k(this.f30431c);
        m(i11);
    }
}
