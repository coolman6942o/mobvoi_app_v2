package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.core.view.i0;
import androidx.core.widget.g;
import f.c;
import java.lang.reflect.Field;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DropDownListView.java */
/* loaded from: classes.dex */
public class h0 extends ListView {

    /* renamed from: a  reason: collision with root package name */
    private final Rect f1174a = new Rect();

    /* renamed from: b  reason: collision with root package name */
    private int f1175b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f1176c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f1177d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f1178e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f1179f;

    /* renamed from: g  reason: collision with root package name */
    private Field f1180g;

    /* renamed from: h  reason: collision with root package name */
    private a f1181h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f1182i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f1183j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f1184k;

    /* renamed from: l  reason: collision with root package name */
    private i0 f1185l;

    /* renamed from: m  reason: collision with root package name */
    private g f1186m;

    /* renamed from: n  reason: collision with root package name */
    b f1187n;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DropDownListView.java */
    /* loaded from: classes.dex */
    public static class a extends c {

        /* renamed from: b  reason: collision with root package name */
        private boolean f1188b = true;

        a(Drawable drawable) {
            super(drawable);
        }

        void c(boolean z10) {
            this.f1188b = z10;
        }

        @Override // f.c, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.f1188b) {
                super.draw(canvas);
            }
        }

        @Override // f.c, android.graphics.drawable.Drawable
        public void setHotspot(float f10, float f11) {
            if (this.f1188b) {
                super.setHotspot(f10, f11);
            }
        }

        @Override // f.c, android.graphics.drawable.Drawable
        public void setHotspotBounds(int i10, int i11, int i12, int i13) {
            if (this.f1188b) {
                super.setHotspotBounds(i10, i11, i12, i13);
            }
        }

        @Override // f.c, android.graphics.drawable.Drawable
        public boolean setState(int[] iArr) {
            if (this.f1188b) {
                return super.setState(iArr);
            }
            return false;
        }

        @Override // f.c, android.graphics.drawable.Drawable
        public boolean setVisible(boolean z10, boolean z11) {
            if (this.f1188b) {
                return super.setVisible(z10, z11);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: DropDownListView.java */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        b() {
        }

        public void a() {
            h0 h0Var = h0.this;
            h0Var.f1187n = null;
            h0Var.removeCallbacks(this);
        }

        public void b() {
            h0.this.post(this);
        }

        @Override // java.lang.Runnable
        public void run() {
            h0 h0Var = h0.this;
            h0Var.f1187n = null;
            h0Var.drawableStateChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h0(Context context, boolean z10) {
        super(context, null, d.a.C);
        this.f1183j = z10;
        setCacheColorHint(0);
        try {
            Field declaredField = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.f1180g = declaredField;
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e10) {
            e10.printStackTrace();
        }
    }

    private void a() {
        this.f1184k = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.f1179f - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        i0 i0Var = this.f1185l;
        if (i0Var != null) {
            i0Var.b();
            this.f1185l = null;
        }
    }

    private void b(View view, int i10) {
        performItemClick(view, i10, getItemIdAtPosition(i10));
    }

    private void c(Canvas canvas) {
        Drawable selector;
        if (!this.f1174a.isEmpty() && (selector = getSelector()) != null) {
            selector.setBounds(this.f1174a);
            selector.draw(canvas);
        }
    }

    private void f(int i10, View view) {
        Rect rect = this.f1174a;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f1175b;
        rect.top -= this.f1176c;
        rect.right += this.f1177d;
        rect.bottom += this.f1178e;
        try {
            boolean z10 = this.f1180g.getBoolean(this);
            if (view.isEnabled() != z10) {
                this.f1180g.set(this, Boolean.valueOf(!z10));
                if (i10 != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException e10) {
            e10.printStackTrace();
        }
    }

    private void g(int i10, View view) {
        Drawable selector = getSelector();
        boolean z10 = true;
        boolean z11 = (selector == null || i10 == -1) ? false : true;
        if (z11) {
            selector.setVisible(false, false);
        }
        f(i10, view);
        if (z11) {
            Rect rect = this.f1174a;
            float exactCenterX = rect.exactCenterX();
            float exactCenterY = rect.exactCenterY();
            if (getVisibility() != 0) {
                z10 = false;
            }
            selector.setVisible(z10, false);
            androidx.core.graphics.drawable.a.k(selector, exactCenterX, exactCenterY);
        }
    }

    private void h(int i10, View view, float f10, float f11) {
        g(i10, view);
        Drawable selector = getSelector();
        if (selector != null && i10 != -1) {
            androidx.core.graphics.drawable.a.k(selector, f10, f11);
        }
    }

    private void i(View view, int i10, float f10, float f11) {
        View childAt;
        this.f1184k = true;
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 21) {
            drawableHotspotChanged(f10, f11);
        }
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        int i12 = this.f1179f;
        if (!(i12 == -1 || (childAt = getChildAt(i12 - getFirstVisiblePosition())) == null || childAt == view || !childAt.isPressed())) {
            childAt.setPressed(false);
        }
        this.f1179f = i10;
        float left = f10 - view.getLeft();
        float top = f11 - view.getTop();
        if (i11 >= 21) {
            view.drawableHotspotChanged(left, top);
        }
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        h(i10, view, f10, f11);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    private boolean j() {
        return this.f1184k;
    }

    private void k() {
        Drawable selector = getSelector();
        if (selector != null && j() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    private void setSelectorEnabled(boolean z10) {
        a aVar = this.f1181h;
        if (aVar != null) {
            aVar.c(z10);
        }
    }

    public int d(int i10, int i11, int i12, int i13, int i14) {
        int i15;
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int i16 = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        View view = null;
        while (i17 < count) {
            int itemViewType = adapter.getItemViewType(i17);
            if (itemViewType != i18) {
                view = null;
                i18 = itemViewType;
            }
            view = adapter.getView(i17, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i20 = layoutParams.height;
            if (i20 > 0) {
                i15 = View.MeasureSpec.makeMeasureSpec(i20, 1073741824);
            } else {
                i15 = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            view.measure(i10, i15);
            view.forceLayout();
            if (i17 > 0) {
                i16 += dividerHeight;
            }
            i16 += view.getMeasuredHeight();
            if (i16 >= i13) {
                return (i14 < 0 || i17 <= i14 || i19 <= 0 || i16 == i13) ? i13 : i19;
            }
            if (i14 >= 0 && i17 >= i14) {
                i19 = i16;
            }
            i17++;
        }
        return i16;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        c(canvas);
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.f1187n == null) {
            super.drawableStateChanged();
            setSelectorEnabled(true);
            k();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000c, code lost:
        if (r0 != 3) goto L8;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0048 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0065  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean e(MotionEvent motionEvent, int i10) {
        boolean z10;
        boolean z11;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1) {
            z11 = false;
        } else if (actionMasked == 2) {
            z11 = true;
        }
        int findPointerIndex = motionEvent.findPointerIndex(i10);
        if (findPointerIndex >= 0) {
            int x10 = (int) motionEvent.getX(findPointerIndex);
            int y10 = (int) motionEvent.getY(findPointerIndex);
            int pointToPosition = pointToPosition(x10, y10);
            if (pointToPosition == -1) {
                z10 = true;
                if (z11 || z10) {
                    a();
                }
                if (z11) {
                    if (this.f1186m == null) {
                        this.f1186m = new g(this);
                    }
                    this.f1186m.m(true);
                    this.f1186m.onTouch(this, motionEvent);
                } else {
                    g gVar = this.f1186m;
                    if (gVar != null) {
                        gVar.m(false);
                    }
                }
                return z11;
            }
            View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
            i(childAt, pointToPosition, x10, y10);
            if (actionMasked == 1) {
                b(childAt, pointToPosition);
            }
            z10 = false;
            z11 = true;
            if (z11) {
            }
            a();
            if (z11) {
            }
            return z11;
        }
        z10 = false;
        z11 = false;
        if (z11) {
        }
        a();
        if (z11) {
        }
        return z11;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean hasFocus() {
        return this.f1183j || super.hasFocus();
    }

    @Override // android.view.View
    public boolean hasWindowFocus() {
        return this.f1183j || super.hasWindowFocus();
    }

    @Override // android.view.View
    public boolean isFocused() {
        return this.f1183j || super.isFocused();
    }

    @Override // android.view.View
    public boolean isInTouchMode() {
        return (this.f1183j && this.f1182i) || super.isInTouchMode();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.f1187n = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (Build.VERSION.SDK_INT < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f1187n == null) {
            b bVar = new b();
            this.f1187n = bVar;
            bVar.b();
        }
        boolean onHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (!(pointToPosition == -1 || pointToPosition == getSelectedItemPosition())) {
                View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    setSelectionFromTop(pointToPosition, childAt.getTop() - getTop());
                }
                k();
            }
        } else {
            setSelection(-1);
        }
        return onHoverEvent;
    }

    @Override // android.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f1179f = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        b bVar = this.f1187n;
        if (bVar != null) {
            bVar.a();
        }
        return super.onTouchEvent(motionEvent);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setListSelectionHidden(boolean z10) {
        this.f1182i = z10;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        a aVar = drawable != null ? new a(drawable) : null;
        this.f1181h = aVar;
        super.setSelector(aVar);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f1175b = rect.left;
        this.f1176c = rect.top;
        this.f1177d = rect.right;
        this.f1178e = rect.bottom;
    }
}
