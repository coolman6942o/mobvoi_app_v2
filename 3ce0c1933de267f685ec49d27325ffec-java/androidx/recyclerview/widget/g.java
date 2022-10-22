package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import androidx.core.view.d0;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
/* compiled from: ItemTouchHelper.java */
/* loaded from: classes.dex */
public class g extends RecyclerView.n implements RecyclerView.p {
    private C0043g A;
    private Rect C;
    private long D;

    /* renamed from: d  reason: collision with root package name */
    float f4035d;

    /* renamed from: e  reason: collision with root package name */
    float f4036e;

    /* renamed from: f  reason: collision with root package name */
    private float f4037f;

    /* renamed from: g  reason: collision with root package name */
    private float f4038g;

    /* renamed from: h  reason: collision with root package name */
    float f4039h;

    /* renamed from: i  reason: collision with root package name */
    float f4040i;

    /* renamed from: j  reason: collision with root package name */
    private float f4041j;

    /* renamed from: k  reason: collision with root package name */
    private float f4042k;

    /* renamed from: m  reason: collision with root package name */
    f f4044m;

    /* renamed from: o  reason: collision with root package name */
    int f4046o;

    /* renamed from: q  reason: collision with root package name */
    private int f4048q;

    /* renamed from: r  reason: collision with root package name */
    RecyclerView f4049r;

    /* renamed from: t  reason: collision with root package name */
    VelocityTracker f4051t;

    /* renamed from: u  reason: collision with root package name */
    private List<RecyclerView.b0> f4052u;

    /* renamed from: v  reason: collision with root package name */
    private List<Integer> f4053v;

    /* renamed from: z  reason: collision with root package name */
    androidx.core.view.e f4057z;

    /* renamed from: a  reason: collision with root package name */
    final List<View> f4032a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private final float[] f4033b = new float[2];

    /* renamed from: c  reason: collision with root package name */
    RecyclerView.b0 f4034c = null;

    /* renamed from: l  reason: collision with root package name */
    int f4043l = -1;

    /* renamed from: n  reason: collision with root package name */
    private int f4045n = 0;

    /* renamed from: p  reason: collision with root package name */
    List<h> f4047p = new ArrayList();

    /* renamed from: s  reason: collision with root package name */
    final Runnable f4050s = new a();

    /* renamed from: w  reason: collision with root package name */
    private RecyclerView.j f4054w = null;

    /* renamed from: x  reason: collision with root package name */
    View f4055x = null;

    /* renamed from: y  reason: collision with root package name */
    int f4056y = -1;
    private final RecyclerView.r B = new b();

    /* compiled from: ItemTouchHelper.java */
    /* loaded from: classes.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            g gVar = g.this;
            if (gVar.f4034c != null && gVar.B()) {
                g gVar2 = g.this;
                RecyclerView.b0 b0Var = gVar2.f4034c;
                if (b0Var != null) {
                    gVar2.w(b0Var);
                }
                g gVar3 = g.this;
                gVar3.f4049r.removeCallbacks(gVar3.f4050s);
                d0.l0(g.this.f4049r, this);
            }
        }
    }

    /* compiled from: ItemTouchHelper.java */
    /* loaded from: classes.dex */
    class b implements RecyclerView.r {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            int findPointerIndex;
            h p10;
            g.this.f4057z.a(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                g.this.f4043l = motionEvent.getPointerId(0);
                g.this.f4035d = motionEvent.getX();
                g.this.f4036e = motionEvent.getY();
                g.this.x();
                g gVar = g.this;
                if (gVar.f4034c == null && (p10 = gVar.p(motionEvent)) != null) {
                    g gVar2 = g.this;
                    gVar2.f4035d -= p10.f4077i;
                    gVar2.f4036e -= p10.f4078j;
                    gVar2.o(p10.f4073e, true);
                    if (g.this.f4032a.remove(p10.f4073e.itemView)) {
                        g gVar3 = g.this;
                        gVar3.f4044m.clearView(gVar3.f4049r, p10.f4073e);
                    }
                    g.this.C(p10.f4073e, p10.f4074f);
                    g gVar4 = g.this;
                    gVar4.I(motionEvent, gVar4.f4046o, 0);
                }
            } else if (actionMasked == 3 || actionMasked == 1) {
                g gVar5 = g.this;
                gVar5.f4043l = -1;
                gVar5.C(null, 0);
            } else {
                int i10 = g.this.f4043l;
                if (i10 != -1 && (findPointerIndex = motionEvent.findPointerIndex(i10)) >= 0) {
                    g.this.l(actionMasked, motionEvent, findPointerIndex);
                }
            }
            VelocityTracker velocityTracker = g.this.f4051t;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            return g.this.f4034c != null;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onRequestDisallowInterceptTouchEvent(boolean z10) {
            if (z10) {
                g.this.C(null, 0);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.r
        public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            g.this.f4057z.a(motionEvent);
            VelocityTracker velocityTracker = g.this.f4051t;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            if (g.this.f4043l != -1) {
                int actionMasked = motionEvent.getActionMasked();
                int findPointerIndex = motionEvent.findPointerIndex(g.this.f4043l);
                if (findPointerIndex >= 0) {
                    g.this.l(actionMasked, motionEvent, findPointerIndex);
                }
                g gVar = g.this;
                RecyclerView.b0 b0Var = gVar.f4034c;
                if (b0Var != null) {
                    int i10 = 0;
                    if (actionMasked != 1) {
                        if (actionMasked != 2) {
                            if (actionMasked == 3) {
                                VelocityTracker velocityTracker2 = gVar.f4051t;
                                if (velocityTracker2 != null) {
                                    velocityTracker2.clear();
                                }
                            } else if (actionMasked == 6) {
                                int actionIndex = motionEvent.getActionIndex();
                                int pointerId = motionEvent.getPointerId(actionIndex);
                                g gVar2 = g.this;
                                if (pointerId == gVar2.f4043l) {
                                    if (actionIndex == 0) {
                                        i10 = 1;
                                    }
                                    gVar2.f4043l = motionEvent.getPointerId(i10);
                                    g gVar3 = g.this;
                                    gVar3.I(motionEvent, gVar3.f4046o, actionIndex);
                                    return;
                                }
                                return;
                            } else {
                                return;
                            }
                        } else if (findPointerIndex >= 0) {
                            gVar.I(motionEvent, gVar.f4046o, findPointerIndex);
                            g.this.w(b0Var);
                            g gVar4 = g.this;
                            gVar4.f4049r.removeCallbacks(gVar4.f4050s);
                            g.this.f4050s.run();
                            g.this.f4049r.invalidate();
                            return;
                        } else {
                            return;
                        }
                    }
                    g.this.C(null, 0);
                    g.this.f4043l = -1;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ItemTouchHelper.java */
    /* loaded from: classes.dex */
    public class c extends h {

        /* renamed from: n  reason: collision with root package name */
        final /* synthetic */ int f4060n;

        /* renamed from: o  reason: collision with root package name */
        final /* synthetic */ RecyclerView.b0 f4061o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(RecyclerView.b0 b0Var, int i10, int i11, float f10, float f11, float f12, float f13, int i12, RecyclerView.b0 b0Var2) {
            super(b0Var, i10, i11, f10, f11, f12, f13);
            this.f4060n = i12;
            this.f4061o = b0Var2;
        }

        @Override // androidx.recyclerview.widget.g.h, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (!this.f4079k) {
                if (this.f4060n <= 0) {
                    g gVar = g.this;
                    gVar.f4044m.clearView(gVar.f4049r, this.f4061o);
                } else {
                    g.this.f4032a.add(this.f4061o.itemView);
                    this.f4076h = true;
                    int i10 = this.f4060n;
                    if (i10 > 0) {
                        g.this.y(this, i10);
                    }
                }
                g gVar2 = g.this;
                View view = gVar2.f4055x;
                View view2 = this.f4061o.itemView;
                if (view == view2) {
                    gVar2.A(view2);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ItemTouchHelper.java */
    /* loaded from: classes.dex */
    public class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h f4063a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f4064b;

        d(h hVar, int i10) {
            this.f4063a = hVar;
            this.f4064b = i10;
        }

        @Override // java.lang.Runnable
        public void run() {
            RecyclerView recyclerView = g.this.f4049r;
            if (recyclerView != null && recyclerView.isAttachedToWindow()) {
                h hVar = this.f4063a;
                if (!hVar.f4079k && hVar.f4073e.getAbsoluteAdapterPosition() != -1) {
                    RecyclerView.l itemAnimator = g.this.f4049r.getItemAnimator();
                    if ((itemAnimator == null || !itemAnimator.q(null)) && !g.this.u()) {
                        g.this.f4044m.onSwiped(this.f4063a.f4073e, this.f4064b);
                    } else {
                        g.this.f4049r.post(this);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ItemTouchHelper.java */
    /* loaded from: classes.dex */
    public class e implements RecyclerView.j {
        e() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.j
        public int a(int i10, int i11) {
            g gVar = g.this;
            View view = gVar.f4055x;
            if (view == null) {
                return i11;
            }
            int i12 = gVar.f4056y;
            if (i12 == -1) {
                i12 = gVar.f4049r.indexOfChild(view);
                g.this.f4056y = i12;
            }
            return i11 == i10 + (-1) ? i12 : i11 < i12 ? i11 : i11 + 1;
        }
    }

    /* compiled from: ItemTouchHelper.java */
    /* loaded from: classes.dex */
    public static abstract class f {
        private static final int ABS_HORIZONTAL_DIR_FLAGS = 789516;
        public static final int DEFAULT_DRAG_ANIMATION_DURATION = 200;
        public static final int DEFAULT_SWIPE_ANIMATION_DURATION = 250;
        private static final long DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS = 2000;
        static final int RELATIVE_DIR_FLAGS = 3158064;
        private static final Interpolator sDragScrollInterpolator = new a();
        private static final Interpolator sDragViewScrollCapInterpolator = new b();
        private int mCachedMaxScrollSpeed = -1;

        /* compiled from: ItemTouchHelper.java */
        /* loaded from: classes.dex */
        class a implements Interpolator {
            a() {
            }

            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f10) {
                return f10 * f10 * f10 * f10 * f10;
            }
        }

        /* compiled from: ItemTouchHelper.java */
        /* loaded from: classes.dex */
        class b implements Interpolator {
            b() {
            }

            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f10) {
                float f11 = f10 - 1.0f;
                return (f11 * f11 * f11 * f11 * f11) + 1.0f;
            }
        }

        public static int convertToRelativeDirection(int i10, int i11) {
            int i12;
            int i13 = i10 & ABS_HORIZONTAL_DIR_FLAGS;
            if (i13 == 0) {
                return i10;
            }
            int i14 = i10 & (~i13);
            if (i11 == 0) {
                i12 = i13 << 2;
            } else {
                int i15 = i13 << 1;
                i14 |= (-789517) & i15;
                i12 = (i15 & ABS_HORIZONTAL_DIR_FLAGS) << 2;
            }
            return i14 | i12;
        }

        public static androidx.recyclerview.widget.h getDefaultUIUtil() {
            return androidx.recyclerview.widget.i.f4085a;
        }

        private int getMaxDragScroll(RecyclerView recyclerView) {
            if (this.mCachedMaxScrollSpeed == -1) {
                this.mCachedMaxScrollSpeed = recyclerView.getResources().getDimensionPixelSize(e1.b.f25702d);
            }
            return this.mCachedMaxScrollSpeed;
        }

        public static int makeFlag(int i10, int i11) {
            return i11 << (i10 * 8);
        }

        public static int makeMovementFlags(int i10, int i11) {
            int makeFlag = makeFlag(0, i11 | i10);
            return makeFlag(2, i10) | makeFlag(1, i11) | makeFlag;
        }

        public boolean canDropOver(RecyclerView recyclerView, RecyclerView.b0 b0Var, RecyclerView.b0 b0Var2) {
            return true;
        }

        public RecyclerView.b0 chooseDropTarget(RecyclerView.b0 b0Var, List<RecyclerView.b0> list, int i10, int i11) {
            int bottom;
            int abs;
            int top;
            int abs2;
            int left;
            int abs3;
            int right;
            int abs4;
            int width = i10 + b0Var.itemView.getWidth();
            int height = i11 + b0Var.itemView.getHeight();
            int left2 = i10 - b0Var.itemView.getLeft();
            int top2 = i11 - b0Var.itemView.getTop();
            int size = list.size();
            RecyclerView.b0 b0Var2 = null;
            int i12 = -1;
            for (int i13 = 0; i13 < size; i13++) {
                RecyclerView.b0 b0Var3 = list.get(i13);
                if (left2 > 0 && (right = b0Var3.itemView.getRight() - width) < 0 && b0Var3.itemView.getRight() > b0Var.itemView.getRight() && (abs4 = Math.abs(right)) > i12) {
                    b0Var2 = b0Var3;
                    i12 = abs4;
                }
                if (left2 < 0 && (left = b0Var3.itemView.getLeft() - i10) > 0 && b0Var3.itemView.getLeft() < b0Var.itemView.getLeft() && (abs3 = Math.abs(left)) > i12) {
                    b0Var2 = b0Var3;
                    i12 = abs3;
                }
                if (top2 < 0 && (top = b0Var3.itemView.getTop() - i11) > 0 && b0Var3.itemView.getTop() < b0Var.itemView.getTop() && (abs2 = Math.abs(top)) > i12) {
                    b0Var2 = b0Var3;
                    i12 = abs2;
                }
                if (top2 > 0 && (bottom = b0Var3.itemView.getBottom() - height) < 0 && b0Var3.itemView.getBottom() > b0Var.itemView.getBottom() && (abs = Math.abs(bottom)) > i12) {
                    b0Var2 = b0Var3;
                    i12 = abs;
                }
            }
            return b0Var2;
        }

        public void clearView(RecyclerView recyclerView, RecyclerView.b0 b0Var) {
            androidx.recyclerview.widget.i.f4085a.a(b0Var.itemView);
        }

        public int convertToAbsoluteDirection(int i10, int i11) {
            int i12;
            int i13 = i10 & RELATIVE_DIR_FLAGS;
            if (i13 == 0) {
                return i10;
            }
            int i14 = i10 & (~i13);
            if (i11 == 0) {
                i12 = i13 >> 2;
            } else {
                int i15 = i13 >> 1;
                i14 |= (-3158065) & i15;
                i12 = (i15 & RELATIVE_DIR_FLAGS) >> 2;
            }
            return i14 | i12;
        }

        final int getAbsoluteMovementFlags(RecyclerView recyclerView, RecyclerView.b0 b0Var) {
            return convertToAbsoluteDirection(getMovementFlags(recyclerView, b0Var), d0.E(recyclerView));
        }

        public long getAnimationDuration(RecyclerView recyclerView, int i10, float f10, float f11) {
            RecyclerView.l itemAnimator = recyclerView.getItemAnimator();
            if (itemAnimator == null) {
                return i10 == 8 ? 200L : 250L;
            }
            if (i10 == 8) {
                return itemAnimator.n();
            }
            return itemAnimator.o();
        }

        public int getBoundingBoxMargin() {
            return 0;
        }

        public float getMoveThreshold(RecyclerView.b0 b0Var) {
            return 0.5f;
        }

        public abstract int getMovementFlags(RecyclerView recyclerView, RecyclerView.b0 b0Var);

        public float getSwipeEscapeVelocity(float f10) {
            return f10;
        }

        public float getSwipeThreshold(RecyclerView.b0 b0Var) {
            return 0.5f;
        }

        public float getSwipeVelocityThreshold(float f10) {
            return f10;
        }

        boolean hasDragFlag(RecyclerView recyclerView, RecyclerView.b0 b0Var) {
            return (getAbsoluteMovementFlags(recyclerView, b0Var) & 16711680) != 0;
        }

        boolean hasSwipeFlag(RecyclerView recyclerView, RecyclerView.b0 b0Var) {
            return (getAbsoluteMovementFlags(recyclerView, b0Var) & 65280) != 0;
        }

        public int interpolateOutOfBoundsScroll(RecyclerView recyclerView, int i10, int i11, int i12, long j10) {
            float f10 = 1.0f;
            int signum = (int) (((int) Math.signum(i11)) * getMaxDragScroll(recyclerView) * sDragViewScrollCapInterpolator.getInterpolation(Math.min(1.0f, (Math.abs(i11) * 1.0f) / i10)));
            if (j10 <= DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS) {
                f10 = ((float) j10) / 2000.0f;
            }
            int interpolation = (int) (signum * sDragScrollInterpolator.getInterpolation(f10));
            return interpolation == 0 ? i11 > 0 ? 1 : -1 : interpolation;
        }

        public boolean isItemViewSwipeEnabled() {
            return true;
        }

        public boolean isLongPressDragEnabled() {
            return true;
        }

        public void onChildDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.b0 b0Var, float f10, float f11, int i10, boolean z10) {
            androidx.recyclerview.widget.i.f4085a.d(canvas, recyclerView, b0Var.itemView, f10, f11, i10, z10);
        }

        public void onChildDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.b0 b0Var, float f10, float f11, int i10, boolean z10) {
            androidx.recyclerview.widget.i.f4085a.c(canvas, recyclerView, b0Var.itemView, f10, f11, i10, z10);
        }

        void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.b0 b0Var, List<h> list, int i10, float f10, float f11) {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                h hVar = list.get(i11);
                hVar.e();
                int save = canvas.save();
                onChildDraw(canvas, recyclerView, hVar.f4073e, hVar.f4077i, hVar.f4078j, hVar.f4074f, false);
                canvas.restoreToCount(save);
            }
            if (b0Var != null) {
                int save2 = canvas.save();
                onChildDraw(canvas, recyclerView, b0Var, f10, f11, i10, true);
                canvas.restoreToCount(save2);
            }
        }

        void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.b0 b0Var, List<h> list, int i10, float f10, float f11) {
            int size = list.size();
            boolean z10 = false;
            for (int i11 = 0; i11 < size; i11++) {
                h hVar = list.get(i11);
                int save = canvas.save();
                onChildDrawOver(canvas, recyclerView, hVar.f4073e, hVar.f4077i, hVar.f4078j, hVar.f4074f, false);
                canvas.restoreToCount(save);
            }
            if (b0Var != null) {
                int save2 = canvas.save();
                onChildDrawOver(canvas, recyclerView, b0Var, f10, f11, i10, true);
                canvas.restoreToCount(save2);
            }
            for (int i12 = size - 1; i12 >= 0; i12--) {
                h hVar2 = list.get(i12);
                boolean z11 = hVar2.f4080l;
                if (z11 && !hVar2.f4076h) {
                    list.remove(i12);
                } else if (!z11) {
                    z10 = true;
                }
            }
            if (z10) {
                recyclerView.invalidate();
            }
        }

        public abstract boolean onMove(RecyclerView recyclerView, RecyclerView.b0 b0Var, RecyclerView.b0 b0Var2);

        public void onMoved(RecyclerView recyclerView, RecyclerView.b0 b0Var, int i10, RecyclerView.b0 b0Var2, int i11, int i12, int i13) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof j) {
                ((j) layoutManager).b(b0Var.itemView, b0Var2.itemView, i12, i13);
                return;
            }
            if (layoutManager.l()) {
                if (layoutManager.R(b0Var2.itemView) <= recyclerView.getPaddingLeft()) {
                    recyclerView.o1(i11);
                }
                if (layoutManager.U(b0Var2.itemView) >= recyclerView.getWidth() - recyclerView.getPaddingRight()) {
                    recyclerView.o1(i11);
                }
            }
            if (layoutManager.m()) {
                if (layoutManager.V(b0Var2.itemView) <= recyclerView.getPaddingTop()) {
                    recyclerView.o1(i11);
                }
                if (layoutManager.P(b0Var2.itemView) >= recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                    recyclerView.o1(i11);
                }
            }
        }

        public void onSelectedChanged(RecyclerView.b0 b0Var, int i10) {
            if (b0Var != null) {
                androidx.recyclerview.widget.i.f4085a.b(b0Var.itemView);
            }
        }

        public abstract void onSwiped(RecyclerView.b0 b0Var, int i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ItemTouchHelper.java */
    /* renamed from: androidx.recyclerview.widget.g$g  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0043g extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: a  reason: collision with root package name */
        private boolean f4067a = true;

        C0043g() {
        }

        void a() {
            this.f4067a = false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            View q5;
            RecyclerView.b0 i02;
            if (this.f4067a && (q5 = g.this.q(motionEvent)) != null && (i02 = g.this.f4049r.i0(q5)) != null) {
                g gVar = g.this;
                if (gVar.f4044m.hasDragFlag(gVar.f4049r, i02)) {
                    int pointerId = motionEvent.getPointerId(0);
                    int i10 = g.this.f4043l;
                    if (pointerId == i10) {
                        int findPointerIndex = motionEvent.findPointerIndex(i10);
                        float x10 = motionEvent.getX(findPointerIndex);
                        float y10 = motionEvent.getY(findPointerIndex);
                        g gVar2 = g.this;
                        gVar2.f4035d = x10;
                        gVar2.f4036e = y10;
                        gVar2.f4040i = 0.0f;
                        gVar2.f4039h = 0.0f;
                        if (gVar2.f4044m.isLongPressDragEnabled()) {
                            g.this.C(i02, 2);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ItemTouchHelper.java */
    /* loaded from: classes.dex */
    public static class h implements Animator.AnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        final float f4069a;

        /* renamed from: b  reason: collision with root package name */
        final float f4070b;

        /* renamed from: c  reason: collision with root package name */
        final float f4071c;

        /* renamed from: d  reason: collision with root package name */
        final float f4072d;

        /* renamed from: e  reason: collision with root package name */
        final RecyclerView.b0 f4073e;

        /* renamed from: f  reason: collision with root package name */
        final int f4074f;

        /* renamed from: g  reason: collision with root package name */
        final ValueAnimator f4075g;

        /* renamed from: h  reason: collision with root package name */
        boolean f4076h;

        /* renamed from: i  reason: collision with root package name */
        float f4077i;

        /* renamed from: j  reason: collision with root package name */
        float f4078j;

        /* renamed from: k  reason: collision with root package name */
        boolean f4079k = false;

        /* renamed from: l  reason: collision with root package name */
        boolean f4080l = false;

        /* renamed from: m  reason: collision with root package name */
        private float f4081m;

        /* compiled from: ItemTouchHelper.java */
        /* loaded from: classes.dex */
        class a implements ValueAnimator.AnimatorUpdateListener {
            a() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                h.this.c(valueAnimator.getAnimatedFraction());
            }
        }

        h(RecyclerView.b0 b0Var, int i10, int i11, float f10, float f11, float f12, float f13) {
            this.f4074f = i11;
            this.f4073e = b0Var;
            this.f4069a = f10;
            this.f4070b = f11;
            this.f4071c = f12;
            this.f4072d = f13;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.f4075g = ofFloat;
            ofFloat.addUpdateListener(new a());
            ofFloat.setTarget(b0Var.itemView);
            ofFloat.addListener(this);
            c(0.0f);
        }

        public void a() {
            this.f4075g.cancel();
        }

        public void b(long j10) {
            this.f4075g.setDuration(j10);
        }

        public void c(float f10) {
            this.f4081m = f10;
        }

        public void d() {
            this.f4073e.setIsRecyclable(false);
            this.f4075g.start();
        }

        public void e() {
            float f10 = this.f4069a;
            float f11 = this.f4071c;
            if (f10 == f11) {
                this.f4077i = this.f4073e.itemView.getTranslationX();
            } else {
                this.f4077i = f10 + (this.f4081m * (f11 - f10));
            }
            float f12 = this.f4070b;
            float f13 = this.f4072d;
            if (f12 == f13) {
                this.f4078j = this.f4073e.itemView.getTranslationY();
            } else {
                this.f4078j = f12 + (this.f4081m * (f13 - f12));
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            c(1.0f);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!this.f4080l) {
                this.f4073e.setIsRecyclable(true);
            }
            this.f4080l = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* compiled from: ItemTouchHelper.java */
    /* loaded from: classes.dex */
    public static abstract class i extends f {

        /* renamed from: a  reason: collision with root package name */
        private int f4083a;

        /* renamed from: b  reason: collision with root package name */
        private int f4084b;

        public i(int i10, int i11) {
            this.f4083a = i11;
            this.f4084b = i10;
        }

        public int a(RecyclerView recyclerView, RecyclerView.b0 b0Var) {
            return this.f4084b;
        }

        public int b(RecyclerView recyclerView, RecyclerView.b0 b0Var) {
            return this.f4083a;
        }

        @Override // androidx.recyclerview.widget.g.f
        public int getMovementFlags(RecyclerView recyclerView, RecyclerView.b0 b0Var) {
            return f.makeMovementFlags(a(recyclerView, b0Var), b(recyclerView, b0Var));
        }
    }

    /* compiled from: ItemTouchHelper.java */
    /* loaded from: classes.dex */
    public interface j {
        void b(View view, View view2, int i10, int i11);
    }

    public g(f fVar) {
        this.f4044m = fVar;
    }

    private void D() {
        this.f4048q = ViewConfiguration.get(this.f4049r.getContext()).getScaledTouchSlop();
        this.f4049r.h(this);
        this.f4049r.k(this.B);
        this.f4049r.j(this);
        F();
    }

    private void F() {
        this.A = new C0043g();
        this.f4057z = new androidx.core.view.e(this.f4049r.getContext(), this.A);
    }

    private void G() {
        C0043g gVar = this.A;
        if (gVar != null) {
            gVar.a();
            this.A = null;
        }
        if (this.f4057z != null) {
            this.f4057z = null;
        }
    }

    private int H(RecyclerView.b0 b0Var) {
        if (this.f4045n == 2) {
            return 0;
        }
        int movementFlags = this.f4044m.getMovementFlags(this.f4049r, b0Var);
        int convertToAbsoluteDirection = (this.f4044m.convertToAbsoluteDirection(movementFlags, d0.E(this.f4049r)) & 65280) >> 8;
        if (convertToAbsoluteDirection == 0) {
            return 0;
        }
        int i10 = (movementFlags & 65280) >> 8;
        if (Math.abs(this.f4039h) > Math.abs(this.f4040i)) {
            int k10 = k(b0Var, convertToAbsoluteDirection);
            if (k10 > 0) {
                return (i10 & k10) == 0 ? f.convertToRelativeDirection(k10, d0.E(this.f4049r)) : k10;
            }
            int m10 = m(b0Var, convertToAbsoluteDirection);
            if (m10 > 0) {
                return m10;
            }
        } else {
            int m11 = m(b0Var, convertToAbsoluteDirection);
            if (m11 > 0) {
                return m11;
            }
            int k11 = k(b0Var, convertToAbsoluteDirection);
            if (k11 > 0) {
                return (i10 & k11) == 0 ? f.convertToRelativeDirection(k11, d0.E(this.f4049r)) : k11;
            }
        }
        return 0;
    }

    private void i() {
        if (Build.VERSION.SDK_INT < 21) {
            if (this.f4054w == null) {
                this.f4054w = new e();
            }
            this.f4049r.setChildDrawingOrderCallback(this.f4054w);
        }
    }

    private int k(RecyclerView.b0 b0Var, int i10) {
        if ((i10 & 12) == 0) {
            return 0;
        }
        int i11 = 8;
        int i12 = this.f4039h > 0.0f ? 8 : 4;
        VelocityTracker velocityTracker = this.f4051t;
        if (velocityTracker != null && this.f4043l > -1) {
            velocityTracker.computeCurrentVelocity(1000, this.f4044m.getSwipeVelocityThreshold(this.f4038g));
            float xVelocity = this.f4051t.getXVelocity(this.f4043l);
            float yVelocity = this.f4051t.getYVelocity(this.f4043l);
            if (xVelocity <= 0.0f) {
                i11 = 4;
            }
            float abs = Math.abs(xVelocity);
            if ((i11 & i10) != 0 && i12 == i11 && abs >= this.f4044m.getSwipeEscapeVelocity(this.f4037f) && abs > Math.abs(yVelocity)) {
                return i11;
            }
        }
        float width = this.f4049r.getWidth() * this.f4044m.getSwipeThreshold(b0Var);
        if ((i10 & i12) == 0 || Math.abs(this.f4039h) <= width) {
            return 0;
        }
        return i12;
    }

    private int m(RecyclerView.b0 b0Var, int i10) {
        if ((i10 & 3) == 0) {
            return 0;
        }
        int i11 = 2;
        int i12 = this.f4040i > 0.0f ? 2 : 1;
        VelocityTracker velocityTracker = this.f4051t;
        if (velocityTracker != null && this.f4043l > -1) {
            velocityTracker.computeCurrentVelocity(1000, this.f4044m.getSwipeVelocityThreshold(this.f4038g));
            float xVelocity = this.f4051t.getXVelocity(this.f4043l);
            float yVelocity = this.f4051t.getYVelocity(this.f4043l);
            if (yVelocity <= 0.0f) {
                i11 = 1;
            }
            float abs = Math.abs(yVelocity);
            if ((i11 & i10) != 0 && i11 == i12 && abs >= this.f4044m.getSwipeEscapeVelocity(this.f4037f) && abs > Math.abs(xVelocity)) {
                return i11;
            }
        }
        float height = this.f4049r.getHeight() * this.f4044m.getSwipeThreshold(b0Var);
        if ((i10 & i12) == 0 || Math.abs(this.f4040i) <= height) {
            return 0;
        }
        return i12;
    }

    private void n() {
        this.f4049r.c1(this);
        this.f4049r.e1(this.B);
        this.f4049r.d1(this);
        for (int size = this.f4047p.size() - 1; size >= 0; size--) {
            h hVar = this.f4047p.get(0);
            hVar.a();
            this.f4044m.clearView(this.f4049r, hVar.f4073e);
        }
        this.f4047p.clear();
        this.f4055x = null;
        this.f4056y = -1;
        z();
        G();
    }

    private List<RecyclerView.b0> r(RecyclerView.b0 b0Var) {
        RecyclerView.b0 b0Var2 = b0Var;
        List<RecyclerView.b0> list = this.f4052u;
        if (list == null) {
            this.f4052u = new ArrayList();
            this.f4053v = new ArrayList();
        } else {
            list.clear();
            this.f4053v.clear();
        }
        int boundingBoxMargin = this.f4044m.getBoundingBoxMargin();
        int round = Math.round(this.f4041j + this.f4039h) - boundingBoxMargin;
        int round2 = Math.round(this.f4042k + this.f4040i) - boundingBoxMargin;
        int i10 = boundingBoxMargin * 2;
        int width = b0Var2.itemView.getWidth() + round + i10;
        int height = b0Var2.itemView.getHeight() + round2 + i10;
        int i11 = (round + width) / 2;
        int i12 = (round2 + height) / 2;
        RecyclerView.LayoutManager layoutManager = this.f4049r.getLayoutManager();
        int K = layoutManager.K();
        int i13 = 0;
        while (i13 < K) {
            View J = layoutManager.J(i13);
            if (J != b0Var2.itemView && J.getBottom() >= round2 && J.getTop() <= height && J.getRight() >= round && J.getLeft() <= width) {
                RecyclerView.b0 i02 = this.f4049r.i0(J);
                if (this.f4044m.canDropOver(this.f4049r, this.f4034c, i02)) {
                    int abs = Math.abs(i11 - ((J.getLeft() + J.getRight()) / 2));
                    int abs2 = Math.abs(i12 - ((J.getTop() + J.getBottom()) / 2));
                    int i14 = (abs * abs) + (abs2 * abs2);
                    int size = this.f4052u.size();
                    int i15 = 0;
                    for (int i16 = 0; i16 < size && i14 > this.f4053v.get(i16).intValue(); i16++) {
                        i15++;
                    }
                    this.f4052u.add(i15, i02);
                    this.f4053v.add(i15, Integer.valueOf(i14));
                }
            }
            i13++;
            b0Var2 = b0Var;
        }
        return this.f4052u;
    }

    private RecyclerView.b0 s(MotionEvent motionEvent) {
        View q5;
        RecyclerView.LayoutManager layoutManager = this.f4049r.getLayoutManager();
        int i10 = this.f4043l;
        if (i10 == -1) {
            return null;
        }
        int findPointerIndex = motionEvent.findPointerIndex(i10);
        float abs = Math.abs(motionEvent.getX(findPointerIndex) - this.f4035d);
        float abs2 = Math.abs(motionEvent.getY(findPointerIndex) - this.f4036e);
        int i11 = this.f4048q;
        if (abs < i11 && abs2 < i11) {
            return null;
        }
        if (abs > abs2 && layoutManager.l()) {
            return null;
        }
        if ((abs2 <= abs || !layoutManager.m()) && (q5 = q(motionEvent)) != null) {
            return this.f4049r.i0(q5);
        }
        return null;
    }

    private void t(float[] fArr) {
        if ((this.f4046o & 12) != 0) {
            fArr[0] = (this.f4041j + this.f4039h) - this.f4034c.itemView.getLeft();
        } else {
            fArr[0] = this.f4034c.itemView.getTranslationX();
        }
        if ((this.f4046o & 3) != 0) {
            fArr[1] = (this.f4042k + this.f4040i) - this.f4034c.itemView.getTop();
        } else {
            fArr[1] = this.f4034c.itemView.getTranslationY();
        }
    }

    private static boolean v(View view, float f10, float f11, float f12, float f13) {
        return f10 >= f12 && f10 <= f12 + ((float) view.getWidth()) && f11 >= f13 && f11 <= f13 + ((float) view.getHeight());
    }

    private void z() {
        VelocityTracker velocityTracker = this.f4051t;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f4051t = null;
        }
    }

    void A(View view) {
        if (view == this.f4055x) {
            this.f4055x = null;
            if (this.f4054w != null) {
                this.f4049r.setChildDrawingOrderCallback(null);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00c1, code lost:
        if (r1 > 0) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0100 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x010c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    boolean B() {
        int i10;
        int i11;
        int i12;
        int width;
        if (this.f4034c == null) {
            this.D = Long.MIN_VALUE;
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j10 = this.D;
        long j11 = j10 == Long.MIN_VALUE ? 0L : currentTimeMillis - j10;
        RecyclerView.LayoutManager layoutManager = this.f4049r.getLayoutManager();
        if (this.C == null) {
            this.C = new Rect();
        }
        layoutManager.k(this.f4034c.itemView, this.C);
        if (layoutManager.l()) {
            int i13 = (int) (this.f4041j + this.f4039h);
            int paddingLeft = (i13 - this.C.left) - this.f4049r.getPaddingLeft();
            float f10 = this.f4039h;
            if (f10 < 0.0f && paddingLeft < 0) {
                i10 = paddingLeft;
            } else if (f10 > 0.0f && (width = ((i13 + this.f4034c.itemView.getWidth()) + this.C.right) - (this.f4049r.getWidth() - this.f4049r.getPaddingRight())) > 0) {
                i10 = width;
            }
            if (layoutManager.m()) {
                int i14 = (int) (this.f4042k + this.f4040i);
                int paddingTop = (i14 - this.C.top) - this.f4049r.getPaddingTop();
                float f11 = this.f4040i;
                if (f11 < 0.0f && paddingTop < 0) {
                    i11 = paddingTop;
                } else if (f11 > 0.0f) {
                    i11 = ((i14 + this.f4034c.itemView.getHeight()) + this.C.bottom) - (this.f4049r.getHeight() - this.f4049r.getPaddingBottom());
                }
                if (i10 != 0) {
                    i10 = this.f4044m.interpolateOutOfBoundsScroll(this.f4049r, this.f4034c.itemView.getWidth(), i10, this.f4049r.getWidth(), j11);
                }
                int i15 = i10;
                if (i11 != 0) {
                    i12 = i15;
                    i11 = this.f4044m.interpolateOutOfBoundsScroll(this.f4049r, this.f4034c.itemView.getHeight(), i11, this.f4049r.getHeight(), j11);
                } else {
                    i12 = i15;
                }
                if (i12 == 0 || i11 != 0) {
                    if (this.D == Long.MIN_VALUE) {
                        this.D = currentTimeMillis;
                    }
                    this.f4049r.scrollBy(i12, i11);
                    return true;
                }
                this.D = Long.MIN_VALUE;
                return false;
            }
            i11 = 0;
            if (i10 != 0) {
            }
            int i152 = i10;
            if (i11 != 0) {
            }
            if (i12 == 0) {
            }
            if (this.D == Long.MIN_VALUE) {
            }
            this.f4049r.scrollBy(i12, i11);
            return true;
        }
        i10 = 0;
        if (layoutManager.m()) {
        }
        i11 = 0;
        if (i10 != 0) {
        }
        int i1522 = i10;
        if (i11 != 0) {
        }
        if (i12 == 0) {
        }
        if (this.D == Long.MIN_VALUE) {
        }
        this.f4049r.scrollBy(i12, i11);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0136  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void C(RecyclerView.b0 b0Var, int i10) {
        boolean z10;
        boolean z11;
        ViewParent parent;
        float f10;
        float f11;
        if (b0Var != this.f4034c || i10 != this.f4045n) {
            this.D = Long.MIN_VALUE;
            int i11 = this.f4045n;
            o(b0Var, true);
            this.f4045n = i10;
            if (i10 == 2) {
                if (b0Var != null) {
                    this.f4055x = b0Var.itemView;
                    i();
                } else {
                    throw new IllegalArgumentException("Must pass a ViewHolder when dragging");
                }
            }
            int i12 = (1 << ((i10 * 8) + 8)) - 1;
            RecyclerView.b0 b0Var2 = this.f4034c;
            if (b0Var2 != null) {
                if (b0Var2.itemView.getParent() != null) {
                    int H = i11 == 2 ? 0 : H(b0Var2);
                    z();
                    if (H == 1 || H == 2) {
                        f10 = Math.signum(this.f4040i) * this.f4049r.getHeight();
                        f11 = 0.0f;
                    } else if (H == 4 || H == 8 || H == 16 || H == 32) {
                        f11 = Math.signum(this.f4039h) * this.f4049r.getWidth();
                        f10 = 0.0f;
                    } else {
                        f11 = 0.0f;
                        f10 = 0.0f;
                    }
                    int i13 = i11 == 2 ? 8 : H > 0 ? 2 : 4;
                    t(this.f4033b);
                    float[] fArr = this.f4033b;
                    float f12 = fArr[0];
                    float f13 = fArr[1];
                    c cVar = new c(b0Var2, i13, i11, f12, f13, f11, f10, H, b0Var2);
                    cVar.b(this.f4044m.getAnimationDuration(this.f4049r, i13, f11 - f12, f10 - f13));
                    this.f4047p.add(cVar);
                    cVar.d();
                    z10 = true;
                } else {
                    A(b0Var2.itemView);
                    this.f4044m.clearView(this.f4049r, b0Var2);
                    z10 = false;
                }
                this.f4034c = null;
            } else {
                z10 = false;
            }
            if (b0Var != null) {
                this.f4046o = (this.f4044m.getAbsoluteMovementFlags(this.f4049r, b0Var) & i12) >> (this.f4045n * 8);
                this.f4041j = b0Var.itemView.getLeft();
                this.f4042k = b0Var.itemView.getTop();
                this.f4034c = b0Var;
                if (i10 == 2) {
                    z11 = false;
                    b0Var.itemView.performHapticFeedback(0);
                    parent = this.f4049r.getParent();
                    if (parent != null) {
                        parent.requestDisallowInterceptTouchEvent(this.f4034c != null ? true : z11);
                    }
                    if (!z10) {
                        this.f4049r.getLayoutManager().v1();
                    }
                    this.f4044m.onSelectedChanged(this.f4034c, this.f4045n);
                    this.f4049r.invalidate();
                }
            }
            z11 = false;
            parent = this.f4049r.getParent();
            if (parent != null) {
            }
            if (!z10) {
            }
            this.f4044m.onSelectedChanged(this.f4034c, this.f4045n);
            this.f4049r.invalidate();
        }
    }

    public void E(RecyclerView.b0 b0Var) {
        if (!this.f4044m.hasDragFlag(this.f4049r, b0Var)) {
            Log.e("ItemTouchHelper", "Start drag has been called but dragging is not enabled");
        } else if (b0Var.itemView.getParent() != this.f4049r) {
            Log.e("ItemTouchHelper", "Start drag has been called with a view holder which is not a child of the RecyclerView which is controlled by this ItemTouchHelper.");
        } else {
            x();
            this.f4040i = 0.0f;
            this.f4039h = 0.0f;
            C(b0Var, 2);
        }
    }

    void I(MotionEvent motionEvent, int i10, int i11) {
        float x10 = motionEvent.getX(i11);
        float y10 = motionEvent.getY(i11);
        float f10 = x10 - this.f4035d;
        this.f4039h = f10;
        this.f4040i = y10 - this.f4036e;
        if ((i10 & 4) == 0) {
            this.f4039h = Math.max(0.0f, f10);
        }
        if ((i10 & 8) == 0) {
            this.f4039h = Math.min(0.0f, this.f4039h);
        }
        if ((i10 & 1) == 0) {
            this.f4040i = Math.max(0.0f, this.f4040i);
        }
        if ((i10 & 2) == 0) {
            this.f4040i = Math.min(0.0f, this.f4040i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void a(View view) {
        A(view);
        RecyclerView.b0 i02 = this.f4049r.i0(view);
        if (i02 != null) {
            RecyclerView.b0 b0Var = this.f4034c;
            if (b0Var == null || i02 != b0Var) {
                o(i02, false);
                if (this.f4032a.remove(i02.itemView)) {
                    this.f4044m.clearView(this.f4049r, i02);
                    return;
                }
                return;
            }
            C(null, 0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.p
    public void b(View view) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void d(Rect rect, View view, RecyclerView recyclerView, RecyclerView.y yVar) {
        rect.setEmpty();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void f(Canvas canvas, RecyclerView recyclerView, RecyclerView.y yVar) {
        float f10;
        this.f4056y = -1;
        float f11 = 0.0f;
        if (this.f4034c != null) {
            t(this.f4033b);
            float[] fArr = this.f4033b;
            f11 = fArr[0];
            f10 = fArr[1];
        } else {
            f10 = 0.0f;
        }
        this.f4044m.onDraw(canvas, recyclerView, this.f4034c, this.f4047p, this.f4045n, f11, f10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.n
    public void h(Canvas canvas, RecyclerView recyclerView, RecyclerView.y yVar) {
        float f10;
        float f11 = 0.0f;
        if (this.f4034c != null) {
            t(this.f4033b);
            float[] fArr = this.f4033b;
            f11 = fArr[0];
            f10 = fArr[1];
        } else {
            f10 = 0.0f;
        }
        this.f4044m.onDrawOver(canvas, recyclerView, this.f4034c, this.f4047p, this.f4045n, f11, f10);
    }

    public void j(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f4049r;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                n();
            }
            this.f4049r = recyclerView;
            if (recyclerView != null) {
                Resources resources = recyclerView.getResources();
                this.f4037f = resources.getDimension(e1.b.f25704f);
                this.f4038g = resources.getDimension(e1.b.f25703e);
                D();
            }
        }
    }

    void l(int i10, MotionEvent motionEvent, int i11) {
        RecyclerView.b0 s10;
        int absoluteMovementFlags;
        if (this.f4034c == null && i10 == 2 && this.f4045n != 2 && this.f4044m.isItemViewSwipeEnabled() && this.f4049r.getScrollState() != 1 && (s10 = s(motionEvent)) != null && (absoluteMovementFlags = (this.f4044m.getAbsoluteMovementFlags(this.f4049r, s10) & 65280) >> 8) != 0) {
            float x10 = motionEvent.getX(i11);
            float y10 = motionEvent.getY(i11);
            float f10 = x10 - this.f4035d;
            float f11 = y10 - this.f4036e;
            float abs = Math.abs(f10);
            float abs2 = Math.abs(f11);
            int i12 = this.f4048q;
            if (abs >= i12 || abs2 >= i12) {
                if (abs > abs2) {
                    if (f10 < 0.0f && (absoluteMovementFlags & 4) == 0) {
                        return;
                    }
                    if (f10 > 0.0f && (absoluteMovementFlags & 8) == 0) {
                        return;
                    }
                } else if (f11 < 0.0f && (absoluteMovementFlags & 1) == 0) {
                    return;
                } else {
                    if (f11 > 0.0f && (absoluteMovementFlags & 2) == 0) {
                        return;
                    }
                }
                this.f4040i = 0.0f;
                this.f4039h = 0.0f;
                this.f4043l = motionEvent.getPointerId(0);
                C(s10, 1);
            }
        }
    }

    void o(RecyclerView.b0 b0Var, boolean z10) {
        for (int size = this.f4047p.size() - 1; size >= 0; size--) {
            h hVar = this.f4047p.get(size);
            if (hVar.f4073e == b0Var) {
                hVar.f4079k |= z10;
                if (!hVar.f4080l) {
                    hVar.a();
                }
                this.f4047p.remove(size);
                return;
            }
        }
    }

    h p(MotionEvent motionEvent) {
        if (this.f4047p.isEmpty()) {
            return null;
        }
        View q5 = q(motionEvent);
        for (int size = this.f4047p.size() - 1; size >= 0; size--) {
            h hVar = this.f4047p.get(size);
            if (hVar.f4073e.itemView == q5) {
                return hVar;
            }
        }
        return null;
    }

    View q(MotionEvent motionEvent) {
        float x10 = motionEvent.getX();
        float y10 = motionEvent.getY();
        RecyclerView.b0 b0Var = this.f4034c;
        if (b0Var != null) {
            View view = b0Var.itemView;
            if (v(view, x10, y10, this.f4041j + this.f4039h, this.f4042k + this.f4040i)) {
                return view;
            }
        }
        for (int size = this.f4047p.size() - 1; size >= 0; size--) {
            h hVar = this.f4047p.get(size);
            View view2 = hVar.f4073e.itemView;
            if (v(view2, x10, y10, hVar.f4077i, hVar.f4078j)) {
                return view2;
            }
        }
        return this.f4049r.S(x10, y10);
    }

    boolean u() {
        int size = this.f4047p.size();
        for (int i10 = 0; i10 < size; i10++) {
            if (!this.f4047p.get(i10).f4080l) {
                return true;
            }
        }
        return false;
    }

    void w(RecyclerView.b0 b0Var) {
        if (!this.f4049r.isLayoutRequested() && this.f4045n == 2) {
            float moveThreshold = this.f4044m.getMoveThreshold(b0Var);
            int i10 = (int) (this.f4041j + this.f4039h);
            int i11 = (int) (this.f4042k + this.f4040i);
            if (Math.abs(i11 - b0Var.itemView.getTop()) >= b0Var.itemView.getHeight() * moveThreshold || Math.abs(i10 - b0Var.itemView.getLeft()) >= b0Var.itemView.getWidth() * moveThreshold) {
                List<RecyclerView.b0> r10 = r(b0Var);
                if (r10.size() != 0) {
                    RecyclerView.b0 chooseDropTarget = this.f4044m.chooseDropTarget(b0Var, r10, i10, i11);
                    if (chooseDropTarget == null) {
                        this.f4052u.clear();
                        this.f4053v.clear();
                        return;
                    }
                    int absoluteAdapterPosition = chooseDropTarget.getAbsoluteAdapterPosition();
                    int absoluteAdapterPosition2 = b0Var.getAbsoluteAdapterPosition();
                    if (this.f4044m.onMove(this.f4049r, b0Var, chooseDropTarget)) {
                        this.f4044m.onMoved(this.f4049r, b0Var, absoluteAdapterPosition2, chooseDropTarget, absoluteAdapterPosition, i10, i11);
                    }
                }
            }
        }
    }

    void x() {
        VelocityTracker velocityTracker = this.f4051t;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.f4051t = VelocityTracker.obtain();
    }

    void y(h hVar, int i10) {
        this.f4049r.post(new d(hVar, i10));
    }
}
