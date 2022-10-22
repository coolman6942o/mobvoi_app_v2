package androidx.core.view;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
/* compiled from: GestureDetectorCompat.java */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    private final a f2526a;

    /* compiled from: GestureDetectorCompat.java */
    /* loaded from: classes.dex */
    interface a {
        boolean a(MotionEvent motionEvent);
    }

    /* compiled from: GestureDetectorCompat.java */
    /* loaded from: classes.dex */
    static class b implements a {

        /* renamed from: v  reason: collision with root package name */
        private static final int f2527v = ViewConfiguration.getTapTimeout();

        /* renamed from: w  reason: collision with root package name */
        private static final int f2528w = ViewConfiguration.getDoubleTapTimeout();

        /* renamed from: a  reason: collision with root package name */
        private int f2529a;

        /* renamed from: b  reason: collision with root package name */
        private int f2530b;

        /* renamed from: c  reason: collision with root package name */
        private int f2531c;

        /* renamed from: d  reason: collision with root package name */
        private int f2532d;

        /* renamed from: e  reason: collision with root package name */
        private final Handler f2533e;

        /* renamed from: f  reason: collision with root package name */
        final GestureDetector.OnGestureListener f2534f;

        /* renamed from: g  reason: collision with root package name */
        GestureDetector.OnDoubleTapListener f2535g;

        /* renamed from: h  reason: collision with root package name */
        boolean f2536h;

        /* renamed from: i  reason: collision with root package name */
        boolean f2537i;

        /* renamed from: j  reason: collision with root package name */
        private boolean f2538j;

        /* renamed from: k  reason: collision with root package name */
        private boolean f2539k;

        /* renamed from: l  reason: collision with root package name */
        private boolean f2540l;

        /* renamed from: m  reason: collision with root package name */
        MotionEvent f2541m;

        /* renamed from: n  reason: collision with root package name */
        private MotionEvent f2542n;

        /* renamed from: o  reason: collision with root package name */
        private boolean f2543o;

        /* renamed from: p  reason: collision with root package name */
        private float f2544p;

        /* renamed from: q  reason: collision with root package name */
        private float f2545q;

        /* renamed from: r  reason: collision with root package name */
        private float f2546r;

        /* renamed from: s  reason: collision with root package name */
        private float f2547s;

        /* renamed from: t  reason: collision with root package name */
        private boolean f2548t;

        /* renamed from: u  reason: collision with root package name */
        private VelocityTracker f2549u;

        b(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            if (handler != null) {
                this.f2533e = new a(handler);
            } else {
                this.f2533e = new a();
            }
            this.f2534f = onGestureListener;
            if (onGestureListener instanceof GestureDetector.OnDoubleTapListener) {
                g((GestureDetector.OnDoubleTapListener) onGestureListener);
            }
            e(context);
        }

        private void b() {
            this.f2533e.removeMessages(1);
            this.f2533e.removeMessages(2);
            this.f2533e.removeMessages(3);
            this.f2549u.recycle();
            this.f2549u = null;
            this.f2543o = false;
            this.f2536h = false;
            this.f2539k = false;
            this.f2540l = false;
            this.f2537i = false;
            if (this.f2538j) {
                this.f2538j = false;
            }
        }

        private void c() {
            this.f2533e.removeMessages(1);
            this.f2533e.removeMessages(2);
            this.f2533e.removeMessages(3);
            this.f2543o = false;
            this.f2539k = false;
            this.f2540l = false;
            this.f2537i = false;
            if (this.f2538j) {
                this.f2538j = false;
            }
        }

        private void e(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null");
            } else if (this.f2534f != null) {
                this.f2548t = true;
                ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
                int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
                int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
                this.f2531c = viewConfiguration.getScaledMinimumFlingVelocity();
                this.f2532d = viewConfiguration.getScaledMaximumFlingVelocity();
                this.f2529a = scaledTouchSlop * scaledTouchSlop;
                this.f2530b = scaledDoubleTapSlop * scaledDoubleTapSlop;
            } else {
                throw new IllegalArgumentException("OnGestureListener must not be null");
            }
        }

        private boolean f(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
            if (!this.f2540l || motionEvent3.getEventTime() - motionEvent2.getEventTime() > f2528w) {
                return false;
            }
            int x10 = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
            int y10 = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
            return (x10 * x10) + (y10 * y10) < this.f2530b;
        }

        /* JADX WARN: Removed duplicated region for block: B:102:0x0204  */
        /* JADX WARN: Removed duplicated region for block: B:105:0x021b  */
        @Override // androidx.core.view.e.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean a(MotionEvent motionEvent) {
            boolean z10;
            MotionEvent motionEvent2;
            MotionEvent motionEvent3;
            boolean z11;
            GestureDetector.OnDoubleTapListener onDoubleTapListener;
            int action = motionEvent.getAction();
            if (this.f2549u == null) {
                this.f2549u = VelocityTracker.obtain();
            }
            this.f2549u.addMovement(motionEvent);
            int i10 = action & 255;
            boolean z12 = i10 == 6;
            int actionIndex = z12 ? motionEvent.getActionIndex() : -1;
            int pointerCount = motionEvent.getPointerCount();
            float f10 = 0.0f;
            float f11 = 0.0f;
            for (int i11 = 0; i11 < pointerCount; i11++) {
                if (actionIndex != i11) {
                    f10 += motionEvent.getX(i11);
                    f11 += motionEvent.getY(i11);
                }
            }
            float f12 = z12 ? pointerCount - 1 : pointerCount;
            float f13 = f10 / f12;
            float f14 = f11 / f12;
            if (i10 != 0) {
                if (i10 == 1) {
                    this.f2536h = false;
                    MotionEvent obtain = MotionEvent.obtain(motionEvent);
                    if (this.f2543o) {
                        z11 = this.f2535g.onDoubleTapEvent(motionEvent) | false;
                    } else {
                        if (this.f2538j) {
                            this.f2533e.removeMessages(3);
                            this.f2538j = false;
                        } else if (this.f2539k) {
                            z11 = this.f2534f.onSingleTapUp(motionEvent);
                            if (this.f2537i && (onDoubleTapListener = this.f2535g) != null) {
                                onDoubleTapListener.onSingleTapConfirmed(motionEvent);
                            }
                        } else {
                            VelocityTracker velocityTracker = this.f2549u;
                            int pointerId = motionEvent.getPointerId(0);
                            velocityTracker.computeCurrentVelocity(1000, this.f2532d);
                            float yVelocity = velocityTracker.getYVelocity(pointerId);
                            float xVelocity = velocityTracker.getXVelocity(pointerId);
                            if (Math.abs(yVelocity) > this.f2531c || Math.abs(xVelocity) > this.f2531c) {
                                z11 = this.f2534f.onFling(this.f2541m, motionEvent, xVelocity, yVelocity);
                            }
                        }
                        z11 = false;
                    }
                    MotionEvent motionEvent4 = this.f2542n;
                    if (motionEvent4 != null) {
                        motionEvent4.recycle();
                    }
                    this.f2542n = obtain;
                    VelocityTracker velocityTracker2 = this.f2549u;
                    if (velocityTracker2 != null) {
                        velocityTracker2.recycle();
                        this.f2549u = null;
                    }
                    this.f2543o = false;
                    this.f2537i = false;
                    this.f2533e.removeMessages(1);
                    this.f2533e.removeMessages(2);
                } else if (i10 != 2) {
                    if (i10 == 3) {
                        b();
                        return false;
                    } else if (i10 == 5) {
                        this.f2544p = f13;
                        this.f2546r = f13;
                        this.f2545q = f14;
                        this.f2547s = f14;
                        c();
                        return false;
                    } else if (i10 != 6) {
                        return false;
                    } else {
                        this.f2544p = f13;
                        this.f2546r = f13;
                        this.f2545q = f14;
                        this.f2547s = f14;
                        this.f2549u.computeCurrentVelocity(1000, this.f2532d);
                        int actionIndex2 = motionEvent.getActionIndex();
                        int pointerId2 = motionEvent.getPointerId(actionIndex2);
                        float xVelocity2 = this.f2549u.getXVelocity(pointerId2);
                        float yVelocity2 = this.f2549u.getYVelocity(pointerId2);
                        for (int i12 = 0; i12 < pointerCount; i12++) {
                            if (i12 != actionIndex2) {
                                int pointerId3 = motionEvent.getPointerId(i12);
                                if ((this.f2549u.getXVelocity(pointerId3) * xVelocity2) + (this.f2549u.getYVelocity(pointerId3) * yVelocity2) < 0.0f) {
                                    this.f2549u.clear();
                                    return false;
                                }
                            }
                        }
                        return false;
                    }
                } else if (this.f2538j) {
                    return false;
                } else {
                    float f15 = this.f2544p - f13;
                    float f16 = this.f2545q - f14;
                    if (this.f2543o) {
                        return false | this.f2535g.onDoubleTapEvent(motionEvent);
                    }
                    if (this.f2539k) {
                        int i13 = (int) (f13 - this.f2546r);
                        int i14 = (int) (f14 - this.f2547s);
                        int i15 = (i13 * i13) + (i14 * i14);
                        if (i15 > this.f2529a) {
                            z11 = this.f2534f.onScroll(this.f2541m, motionEvent, f15, f16);
                            this.f2544p = f13;
                            this.f2545q = f14;
                            this.f2539k = false;
                            this.f2533e.removeMessages(3);
                            this.f2533e.removeMessages(1);
                            this.f2533e.removeMessages(2);
                        } else {
                            z11 = false;
                        }
                        if (i15 > this.f2529a) {
                            this.f2540l = false;
                        }
                    } else if (Math.abs(f15) < 1.0f && Math.abs(f16) < 1.0f) {
                        return false;
                    } else {
                        boolean onScroll = this.f2534f.onScroll(this.f2541m, motionEvent, f15, f16);
                        this.f2544p = f13;
                        this.f2545q = f14;
                        return onScroll;
                    }
                }
                return z11;
            }
            if (this.f2535g != null) {
                boolean hasMessages = this.f2533e.hasMessages(3);
                if (hasMessages) {
                    this.f2533e.removeMessages(3);
                }
                MotionEvent motionEvent5 = this.f2541m;
                if (motionEvent5 == null || (motionEvent3 = this.f2542n) == null || !hasMessages || !f(motionEvent5, motionEvent3, motionEvent)) {
                    this.f2533e.sendEmptyMessageDelayed(3, f2528w);
                } else {
                    this.f2543o = true;
                    z10 = this.f2535g.onDoubleTap(this.f2541m) | false | this.f2535g.onDoubleTapEvent(motionEvent);
                    this.f2544p = f13;
                    this.f2546r = f13;
                    this.f2545q = f14;
                    this.f2547s = f14;
                    motionEvent2 = this.f2541m;
                    if (motionEvent2 != null) {
                        motionEvent2.recycle();
                    }
                    this.f2541m = MotionEvent.obtain(motionEvent);
                    this.f2539k = true;
                    this.f2540l = true;
                    this.f2536h = true;
                    this.f2538j = false;
                    this.f2537i = false;
                    if (this.f2548t) {
                        this.f2533e.removeMessages(2);
                        this.f2533e.sendEmptyMessageAtTime(2, this.f2541m.getDownTime() + f2527v + ViewConfiguration.getLongPressTimeout());
                    }
                    this.f2533e.sendEmptyMessageAtTime(1, this.f2541m.getDownTime() + f2527v);
                    return z10 | this.f2534f.onDown(motionEvent);
                }
            }
            z10 = false;
            this.f2544p = f13;
            this.f2546r = f13;
            this.f2545q = f14;
            this.f2547s = f14;
            motionEvent2 = this.f2541m;
            if (motionEvent2 != null) {
            }
            this.f2541m = MotionEvent.obtain(motionEvent);
            this.f2539k = true;
            this.f2540l = true;
            this.f2536h = true;
            this.f2538j = false;
            this.f2537i = false;
            if (this.f2548t) {
            }
            this.f2533e.sendEmptyMessageAtTime(1, this.f2541m.getDownTime() + f2527v);
            return z10 | this.f2534f.onDown(motionEvent);
        }

        void d() {
            this.f2533e.removeMessages(3);
            this.f2537i = false;
            this.f2538j = true;
            this.f2534f.onLongPress(this.f2541m);
        }

        public void g(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
            this.f2535g = onDoubleTapListener;
        }

        /* compiled from: GestureDetectorCompat.java */
        /* loaded from: classes.dex */
        private class a extends Handler {
            a() {
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i10 = message.what;
                if (i10 == 1) {
                    b bVar = b.this;
                    bVar.f2534f.onShowPress(bVar.f2541m);
                } else if (i10 == 2) {
                    b.this.d();
                } else if (i10 == 3) {
                    b bVar2 = b.this;
                    GestureDetector.OnDoubleTapListener onDoubleTapListener = bVar2.f2535g;
                    if (onDoubleTapListener == null) {
                        return;
                    }
                    if (!bVar2.f2536h) {
                        onDoubleTapListener.onSingleTapConfirmed(bVar2.f2541m);
                    } else {
                        bVar2.f2537i = true;
                    }
                } else {
                    throw new RuntimeException("Unknown message " + message);
                }
            }

            a(Handler handler) {
                super(handler.getLooper());
            }
        }
    }

    /* compiled from: GestureDetectorCompat.java */
    /* loaded from: classes.dex */
    static class c implements a {

        /* renamed from: a  reason: collision with root package name */
        private final GestureDetector f2551a;

        c(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            this.f2551a = new GestureDetector(context, onGestureListener, handler);
        }

        @Override // androidx.core.view.e.a
        public boolean a(MotionEvent motionEvent) {
            return this.f2551a.onTouchEvent(motionEvent);
        }
    }

    public e(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    public boolean a(MotionEvent motionEvent) {
        return this.f2526a.a(motionEvent);
    }

    public e(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        if (Build.VERSION.SDK_INT > 17) {
            this.f2526a = new c(context, onGestureListener, handler);
        } else {
            this.f2526a = new b(context, onGestureListener, handler);
        }
    }
}
