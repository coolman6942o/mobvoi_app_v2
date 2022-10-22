package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.core.view.d0;
import com.google.android.material.internal.m;
import d7.f;
import j0.d;
import java.util.Calendar;
import java.util.Iterator;
import k0.c;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class MaterialCalendarGridView extends GridView {

    /* renamed from: a  reason: collision with root package name */
    private final Calendar f10732a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f10733b;

    /* loaded from: classes.dex */
    class a extends androidx.core.view.a {
        a(MaterialCalendarGridView materialCalendarGridView) {
        }

        @Override // androidx.core.view.a
        public void g(View view, c cVar) {
            super.g(view, cVar);
            cVar.c0(null);
        }
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void a(int i10, Rect rect) {
        if (i10 == 33) {
            setSelection(getAdapter2().i());
        } else if (i10 == 130) {
            setSelection(getAdapter2().b());
        } else {
            super.onFocusChanged(true, i10, rect);
        }
    }

    private View c(int i10) {
        return getChildAt(i10 - getFirstVisiblePosition());
    }

    private static int d(View view) {
        return view.getLeft() + (view.getWidth() / 2);
    }

    private static boolean e(Long l10, Long l11, Long l12, Long l13) {
        return l10 == null || l11 == null || l12 == null || l13 == null || l12.longValue() > l11.longValue() || l13.longValue() < l10.longValue();
    }

    /* renamed from: b */
    public j getAdapter2() {
        return (j) super.getAdapter();
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter2().notifyDataSetChanged();
    }

    @Override // android.view.View
    protected final void onDraw(Canvas canvas) {
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        j b10 = getAdapter2();
        DateSelector<?> dateSelector = b10.f10841b;
        b bVar = b10.f10843d;
        int max = Math.max(b10.b(), getFirstVisiblePosition());
        int min = Math.min(b10.i(), getLastVisiblePosition());
        Long c10 = b10.getItem(max);
        Long c11 = b10.getItem(min);
        Iterator<d<Long, Long>> it = dateSelector.q().iterator();
        while (it.hasNext()) {
            d<Long, Long> next = it.next();
            Long l10 = next.f29364a;
            if (l10 == null) {
                materialCalendarGridView = this;
            } else if (next.f29365b != null) {
                long longValue = l10.longValue();
                long longValue2 = next.f29365b.longValue();
                if (!e(c10, c11, Long.valueOf(longValue), Long.valueOf(longValue2))) {
                    boolean d10 = m.d(this);
                    if (longValue < c10.longValue()) {
                        if (b10.f(max)) {
                            i17 = 0;
                        } else if (!d10) {
                            i17 = materialCalendarGridView.c(max - 1).getRight();
                        } else {
                            i17 = materialCalendarGridView.c(max - 1).getLeft();
                        }
                        i10 = i17;
                        i11 = max;
                    } else {
                        materialCalendarGridView.f10732a.setTimeInMillis(longValue);
                        i11 = b10.a(materialCalendarGridView.f10732a.get(5));
                        i10 = d(materialCalendarGridView.c(i11));
                    }
                    if (longValue2 > c11.longValue()) {
                        if (b10.g(min)) {
                            i16 = getWidth();
                        } else if (!d10) {
                            i16 = materialCalendarGridView.c(min).getRight();
                        } else {
                            i16 = materialCalendarGridView.c(min).getLeft();
                        }
                        i12 = i16;
                        i13 = min;
                    } else {
                        materialCalendarGridView.f10732a.setTimeInMillis(longValue2);
                        i13 = b10.a(materialCalendarGridView.f10732a.get(5));
                        i12 = d(materialCalendarGridView.c(i13));
                    }
                    int itemId = (int) b10.getItemId(i11);
                    max = max;
                    min = min;
                    int itemId2 = (int) b10.getItemId(i13);
                    while (itemId <= itemId2) {
                        int numColumns = getNumColumns() * itemId;
                        int numColumns2 = (numColumns + getNumColumns()) - 1;
                        View c12 = materialCalendarGridView.c(numColumns);
                        int top = c12.getTop() + bVar.f10763a.c();
                        b10 = b10;
                        int bottom = c12.getBottom() - bVar.f10763a.b();
                        if (!d10) {
                            i15 = numColumns > i11 ? 0 : i10;
                            i14 = i13 > numColumns2 ? getWidth() : i12;
                        } else {
                            int i18 = i13 > numColumns2 ? 0 : i12;
                            int width = numColumns > i11 ? getWidth() : i10;
                            i15 = i18;
                            i14 = width;
                        }
                        it = it;
                        canvas.drawRect(i15, top, i14, bottom, bVar.f10770h);
                        itemId++;
                        materialCalendarGridView = this;
                    }
                    materialCalendarGridView = this;
                }
            }
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    protected void onFocusChanged(boolean z10, int i10, Rect rect) {
        if (z10) {
            a(i10, rect);
        } else {
            super.onFocusChanged(false, i10, rect);
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i10, KeyEvent keyEvent) {
        if (!super.onKeyDown(i10, keyEvent)) {
            return false;
        }
        if (getSelectedItemPosition() == -1 || getSelectedItemPosition() >= getAdapter2().b()) {
            return true;
        }
        if (19 != i10) {
            return false;
        }
        setSelection(getAdapter2().b());
        return true;
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i10, int i11) {
        if (this.f10733b) {
            super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec(16777215, Integer.MIN_VALUE));
            getLayoutParams().height = getMeasuredHeight();
            return;
        }
        super.onMeasure(i10, i11);
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public void setSelection(int i10) {
        if (i10 < getAdapter2().b()) {
            super.setSelection(getAdapter2().b());
        } else {
            super.setSelection(i10);
        }
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f10732a = p.q();
        if (g.G0(getContext())) {
            setNextFocusLeftId(f.f25242a);
            setNextFocusRightId(f.f25246c);
        }
        this.f10733b = g.H0(getContext());
        d0.t0(this, new a(this));
    }

    @Override // android.widget.GridView, android.widget.AbsListView
    public final void setAdapter(ListAdapter listAdapter) {
        if (listAdapter instanceof j) {
            super.setAdapter(listAdapter);
            return;
        }
        throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), j.class.getCanonicalName()));
    }
}
