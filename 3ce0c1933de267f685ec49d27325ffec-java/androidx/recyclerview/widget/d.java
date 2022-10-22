package androidx.recyclerview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
/* compiled from: DividerItemDecoration.java */
/* loaded from: classes.dex */
public class d extends RecyclerView.n {

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f3982d = {16843284};

    /* renamed from: a  reason: collision with root package name */
    private Drawable f3983a;

    /* renamed from: b  reason: collision with root package name */
    private int f3984b;

    /* renamed from: c  reason: collision with root package name */
    private final Rect f3985c = new Rect();

    public d(Context context, int i10) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f3982d);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        this.f3983a = drawable;
        if (drawable == null) {
            Log.w("DividerItem", "@android:attr/listDivider was not set in the theme used for this DividerItemDecoration. Please set that attribute all call setDrawable()");
        }
        obtainStyledAttributes.recycle();
        l(i10);
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
        int childCount = recyclerView.getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = recyclerView.getChildAt(i12);
            recyclerView.getLayoutManager().Q(childAt, this.f3985c);
            int round = this.f3985c.right + Math.round(childAt.getTranslationX());
            this.f3983a.setBounds(round - this.f3983a.getIntrinsicWidth(), i11, round, i10);
            this.f3983a.draw(canvas);
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
        int childCount = recyclerView.getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = recyclerView.getChildAt(i12);
            recyclerView.k0(childAt, this.f3985c);
            int round = this.f3985c.bottom + Math.round(childAt.getTranslationY());
            this.f3983a.setBounds(i11, round - this.f3983a.getIntrinsicHeight(), i10, round);
            this.f3983a.draw(canvas);
        }
        canvas.restore();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void d(Rect rect, View view, RecyclerView recyclerView, RecyclerView.y yVar) {
        Drawable drawable = this.f3983a;
        if (drawable == null) {
            rect.set(0, 0, 0, 0);
        } else if (this.f3984b == 1) {
            rect.set(0, 0, 0, drawable.getIntrinsicHeight());
        } else {
            rect.set(0, 0, drawable.getIntrinsicWidth(), 0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void f(Canvas canvas, RecyclerView recyclerView, RecyclerView.y yVar) {
        if (recyclerView.getLayoutManager() != null && this.f3983a != null) {
            if (this.f3984b == 1) {
                j(canvas, recyclerView);
            } else {
                i(canvas, recyclerView);
            }
        }
    }

    public void k(Drawable drawable) {
        if (drawable != null) {
            this.f3983a = drawable;
            return;
        }
        throw new IllegalArgumentException("Drawable cannot be null.");
    }

    public void l(int i10) {
        if (i10 == 0 || i10 == 1) {
            this.f3984b = i10;
            return;
        }
        throw new IllegalArgumentException("Invalid orientation. It should be either HORIZONTAL or VERTICAL");
    }
}
