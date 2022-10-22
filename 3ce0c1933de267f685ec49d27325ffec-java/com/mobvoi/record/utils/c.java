package com.mobvoi.record.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
/* compiled from: SwipeHelper.java */
/* loaded from: classes2.dex */
public abstract class c extends g.i {

    /* renamed from: c  reason: collision with root package name */
    private RecyclerView f20697c;

    /* renamed from: e  reason: collision with root package name */
    private GestureDetector f20699e;

    /* renamed from: f  reason: collision with root package name */
    private int f20700f = -1;

    /* renamed from: g  reason: collision with root package name */
    private float f20701g = 0.5f;

    /* renamed from: j  reason: collision with root package name */
    private GestureDetector.SimpleOnGestureListener f20704j = new a();

    /* renamed from: k  reason: collision with root package name */
    private View.OnTouchListener f20705k = new b();

    /* renamed from: d  reason: collision with root package name */
    private List<d> f20698d = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    private Map<Integer, List<d>> f20702h = new HashMap();

    /* renamed from: i  reason: collision with root package name */
    private Queue<Integer> f20703i = new C0240c();

    /* compiled from: SwipeHelper.java */
    /* loaded from: classes2.dex */
    class a extends GestureDetector.SimpleOnGestureListener {
        a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            Iterator it = c.this.f20698d.iterator();
            while (it.hasNext() && !((d) it.next()).a(motionEvent.getX(), motionEvent.getY())) {
            }
            return true;
        }
    }

    /* compiled from: SwipeHelper.java */
    /* loaded from: classes2.dex */
    class b implements View.OnTouchListener {
        b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (c.this.f20700f < 0) {
                return false;
            }
            Point point = new Point((int) motionEvent.getRawX(), (int) motionEvent.getRawY());
            RecyclerView.b0 Z = c.this.f20697c.Z(c.this.f20700f);
            if (Z != null) {
                View view2 = Z.itemView;
                Rect rect = new Rect();
                view2.getGlobalVisibleRect(rect);
                if (motionEvent.getAction() == 0 || motionEvent.getAction() == 1 || motionEvent.getAction() == 2) {
                    int i10 = rect.top;
                    int i11 = point.y;
                    if (i10 >= i11 || rect.bottom <= i11) {
                        c.this.f20703i.add(Integer.valueOf(c.this.f20700f));
                        c.this.f20700f = -1;
                        c.this.m();
                    } else {
                        c.this.f20699e.onTouchEvent(motionEvent);
                    }
                }
            }
            return false;
        }
    }

    /* compiled from: SwipeHelper.java */
    /* renamed from: com.mobvoi.record.utils.c$c  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    class C0240c extends LinkedList<Integer> {
        C0240c() {
        }

        /* renamed from: a */
        public boolean add(Integer num) {
            if (contains(num)) {
                return false;
            }
            return super.add(num);
        }
    }

    /* compiled from: SwipeHelper.java */
    /* loaded from: classes2.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        private String f20708a;

        /* renamed from: b  reason: collision with root package name */
        private int f20709b;

        /* renamed from: c  reason: collision with root package name */
        private int f20710c;

        /* renamed from: d  reason: collision with root package name */
        private RectF f20711d;

        /* renamed from: e  reason: collision with root package name */
        private e f20712e;

        public d(String str, int i10, e eVar) {
            this.f20708a = str;
            this.f20709b = i10;
            this.f20712e = eVar;
        }

        public boolean a(float f10, float f11) {
            RectF rectF = this.f20711d;
            if (rectF == null || !rectF.contains(f10, f11)) {
                return false;
            }
            this.f20712e.a(this.f20710c);
            return true;
        }

        public void b(Canvas canvas, RectF rectF, int i10) {
            Paint paint = new Paint();
            paint.setColor(this.f20709b);
            canvas.drawRect(rectF, paint);
            paint.setColor(-1);
            paint.setTextSize(TypedValue.applyDimension(2, 15.0f, Resources.getSystem().getDisplayMetrics()));
            Rect rect = new Rect();
            float height = rectF.height();
            float width = rectF.width();
            paint.setTextAlign(Paint.Align.LEFT);
            String str = this.f20708a;
            paint.getTextBounds(str, 0, str.length(), rect);
            String str2 = this.f20708a;
            if (rect.width() > width) {
                String str3 = this.f20708a;
                int breakText = paint.breakText(str3, 0, str3.length(), true, width, null);
                str2 = this.f20708a.substring(0, breakText > 2 ? breakText - 2 : 1);
            }
            paint.getTextBounds(str2, 0, str2.length(), rect);
            canvas.drawText(str2, rectF.left + (((width / 2.0f) - (rect.width() / 2.0f)) - rect.left), rectF.top + (((height / 2.0f) + (rect.height() / 2.0f)) - rect.bottom), paint);
            this.f20711d = rectF;
            this.f20710c = i10;
        }
    }

    /* compiled from: SwipeHelper.java */
    /* loaded from: classes2.dex */
    public interface e {
        void a(int i10);
    }

    public c(Context context) {
        super(0, 4);
        this.f20699e = new GestureDetector(context, this.f20704j);
    }

    private void k(Canvas canvas, View view, List<d> list, int i10, float f10) {
        float right = view.getRight();
        float size = (f10 * (-1.0f)) / list.size();
        for (d dVar : list) {
            float f11 = right - size;
            dVar.b(canvas, new RectF(f11, view.getTop(), right, view.getBottom()), i10);
            right = f11;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void m() {
        while (!this.f20703i.isEmpty()) {
            int intValue = this.f20703i.poll().intValue();
            if (intValue > -1) {
                this.f20697c.getAdapter().notifyItemChanged(intValue);
            }
        }
    }

    @Override // androidx.recyclerview.widget.g.f
    public float getSwipeEscapeVelocity(float f10) {
        return f10 * 0.1f;
    }

    @Override // androidx.recyclerview.widget.g.f
    public float getSwipeThreshold(RecyclerView.b0 b0Var) {
        return this.f20701g;
    }

    @Override // androidx.recyclerview.widget.g.f
    public float getSwipeVelocityThreshold(float f10) {
        return f10 * 5.0f;
    }

    public void j(RecyclerView recyclerView) {
        this.f20697c = recyclerView;
        recyclerView.setOnTouchListener(this.f20705k);
        new g(this).j(this.f20697c);
    }

    public abstract void l(RecyclerView.b0 b0Var, List<d> list);

    @Override // androidx.recyclerview.widget.g.f
    public void onChildDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.b0 b0Var, float f10, float f11, int i10, boolean z10) {
        float f12;
        int adapterPosition = b0Var.getAdapterPosition();
        View view = b0Var.itemView;
        if (adapterPosition < 0) {
            this.f20700f = adapterPosition;
            return;
        }
        if (i10 != 1 || f10 >= 0.0f) {
            f12 = f10;
        } else {
            List<d> arrayList = new ArrayList<>();
            if (!this.f20702h.containsKey(Integer.valueOf(adapterPosition))) {
                l(b0Var, arrayList);
                this.f20702h.put(Integer.valueOf(adapterPosition), arrayList);
            } else {
                arrayList = this.f20702h.get(Integer.valueOf(adapterPosition));
            }
            List<d> list = arrayList;
            float size = ((list.size() * f10) * 280.0f) / view.getWidth();
            k(canvas, view, list, adapterPosition, size);
            f12 = size;
        }
        super.onChildDraw(canvas, recyclerView, b0Var, f12, f11, i10, z10);
    }

    @Override // androidx.recyclerview.widget.g.f
    public boolean onMove(RecyclerView recyclerView, RecyclerView.b0 b0Var, RecyclerView.b0 b0Var2) {
        return false;
    }

    @Override // androidx.recyclerview.widget.g.f
    public void onSwiped(RecyclerView.b0 b0Var, int i10) {
        int adapterPosition = b0Var.getAdapterPosition();
        int i11 = this.f20700f;
        if (i11 != adapterPosition) {
            this.f20703i.add(Integer.valueOf(i11));
        }
        this.f20700f = adapterPosition;
        if (this.f20702h.containsKey(Integer.valueOf(adapterPosition))) {
            this.f20698d = this.f20702h.get(Integer.valueOf(this.f20700f));
        } else {
            this.f20698d.clear();
        }
        this.f20702h.clear();
        this.f20701g = this.f20698d.size() * 0.5f * 280.0f;
        m();
    }
}
