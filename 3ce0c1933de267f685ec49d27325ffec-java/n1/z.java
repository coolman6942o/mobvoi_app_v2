package n1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.d0;
import java.util.ArrayList;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ViewOverlayApi14.java */
/* loaded from: classes.dex */
public class z implements b0 {

    /* renamed from: a  reason: collision with root package name */
    protected a f31000a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ViewOverlayApi14.java */
    /* loaded from: classes.dex */
    public static class a extends ViewGroup {

        /* renamed from: a  reason: collision with root package name */
        ViewGroup f31001a;

        /* renamed from: b  reason: collision with root package name */
        View f31002b;

        /* renamed from: c  reason: collision with root package name */
        ArrayList<Drawable> f31003c = null;

        /* renamed from: d  reason: collision with root package name */
        z f31004d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f31005e;

        static {
            try {
                Class cls = Integer.TYPE;
                ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", cls, cls, Rect.class);
            } catch (NoSuchMethodException unused) {
            }
        }

        a(Context context, ViewGroup viewGroup, View view, z zVar) {
            super(context);
            this.f31001a = viewGroup;
            this.f31002b = view;
            setRight(viewGroup.getWidth());
            setBottom(viewGroup.getHeight());
            viewGroup.addView(this);
            this.f31004d = zVar;
        }

        private void c() {
            if (this.f31005e) {
                throw new IllegalStateException("This overlay was disposed already. Please use a new one via ViewGroupUtils.getOverlay()");
            }
        }

        private void d() {
            if (getChildCount() == 0) {
                ArrayList<Drawable> arrayList = this.f31003c;
                if (arrayList == null || arrayList.size() == 0) {
                    this.f31005e = true;
                    this.f31001a.removeView(this);
                }
            }
        }

        private void e(int[] iArr) {
            int[] iArr2 = new int[2];
            int[] iArr3 = new int[2];
            this.f31001a.getLocationOnScreen(iArr2);
            this.f31002b.getLocationOnScreen(iArr3);
            iArr[0] = iArr3[0] - iArr2[0];
            iArr[1] = iArr3[1] - iArr2[1];
        }

        public void a(Drawable drawable) {
            c();
            if (this.f31003c == null) {
                this.f31003c = new ArrayList<>();
            }
            if (!this.f31003c.contains(drawable)) {
                this.f31003c.add(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback(this);
            }
        }

        public void b(View view) {
            c();
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (!(viewGroup == this.f31001a || viewGroup.getParent() == null || !d0.W(viewGroup))) {
                    int[] iArr = new int[2];
                    int[] iArr2 = new int[2];
                    viewGroup.getLocationOnScreen(iArr);
                    this.f31001a.getLocationOnScreen(iArr2);
                    d0.d0(view, iArr[0] - iArr2[0]);
                    d0.e0(view, iArr[1] - iArr2[1]);
                }
                viewGroup.removeView(view);
                if (view.getParent() != null) {
                    viewGroup.removeView(view);
                }
            }
            super.addView(view);
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            this.f31001a.getLocationOnScreen(iArr);
            this.f31002b.getLocationOnScreen(iArr2);
            canvas.translate(iArr2[0] - iArr[0], iArr2[1] - iArr[1]);
            canvas.clipRect(new Rect(0, 0, this.f31002b.getWidth(), this.f31002b.getHeight()));
            super.dispatchDraw(canvas);
            ArrayList<Drawable> arrayList = this.f31003c;
            int size = arrayList == null ? 0 : arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                this.f31003c.get(i10).draw(canvas);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        public void f(Drawable drawable) {
            ArrayList<Drawable> arrayList = this.f31003c;
            if (arrayList != null) {
                arrayList.remove(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback(null);
                d();
            }
        }

        public void g(View view) {
            super.removeView(view);
            d();
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
            if (this.f31001a == null) {
                return null;
            }
            rect.offset(iArr[0], iArr[1]);
            if (this.f31001a instanceof ViewGroup) {
                iArr[0] = 0;
                iArr[1] = 0;
                int[] iArr2 = new int[2];
                e(iArr2);
                rect.offset(iArr2[0], iArr2[1]);
                return super.invalidateChildInParent(iArr, rect);
            }
            invalidate(rect);
            return null;
        }

        @Override // android.view.View, android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            invalidate(drawable.getBounds());
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z10, int i10, int i11, int i12, int i13) {
        }

        @Override // android.view.View
        protected boolean verifyDrawable(Drawable drawable) {
            ArrayList<Drawable> arrayList;
            return super.verifyDrawable(drawable) || ((arrayList = this.f31003c) != null && arrayList.contains(drawable));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(Context context, ViewGroup viewGroup, View view) {
        this.f31000a = new a(context, viewGroup, view, this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static z e(View view) {
        ViewGroup f10 = f(view);
        if (f10 == null) {
            return null;
        }
        int childCount = f10.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = f10.getChildAt(i10);
            if (childAt instanceof a) {
                return ((a) childAt).f31004d;
            }
        }
        return new u(f10.getContext(), f10, view);
    }

    static ViewGroup f(View view) {
        while (view != null) {
            if (view.getId() == 16908290 && (view instanceof ViewGroup)) {
                return (ViewGroup) view;
            }
            if (view.getParent() instanceof ViewGroup) {
                view = (ViewGroup) view.getParent();
            }
        }
        return null;
    }

    @Override // n1.b0
    public void a(Drawable drawable) {
        this.f31000a.a(drawable);
    }

    @Override // n1.b0
    public void b(Drawable drawable) {
        this.f31000a.f(drawable);
    }
}
