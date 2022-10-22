package com.mobvoi.health.companion.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridView;
import fg.o;
import fg.q;
/* loaded from: classes2.dex */
public class ShareGridView extends GridView {

    /* renamed from: a  reason: collision with root package name */
    private Bitmap f19084a;

    /* renamed from: b  reason: collision with root package name */
    private Bitmap f19085b;

    /* renamed from: c  reason: collision with root package name */
    private Paint f19086c;

    public ShareGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        View childAt;
        super.dispatchDraw(canvas);
        if (getChildAt(0) != null) {
            int numColumns = getNumColumns();
            int width = getWidth() / numColumns;
            int childCount = getChildCount();
            if (childCount <= 2) {
                float f10 = width;
                canvas.drawLine(f10, childAt.getTop() + 30, f10, childAt.getBottom() - 30, this.f19086c);
                return;
            }
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt2 = getChildAt(i10);
                int left = childAt2.getLeft() + 30;
                int top = childAt2.getTop();
                int height = childAt2.getHeight();
                if (i10 == 0) {
                    canvas.drawBitmap(this.f19084a, left, top - 10, (Paint) null);
                    float f11 = width;
                    canvas.drawLine(f11, top + (height / 3), f11, childAt2.getBottom() + (((childCount - 1) / 2) * height), this.f19086c);
                }
                if (i10 % numColumns == 0) {
                    canvas.drawBitmap(this.f19085b, left, childAt2.getBottom() + 10, this.f19086c);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 2 || motionEvent.getAction() == 0) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    public ShareGridView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f19084a = BitmapFactory.decodeResource(getResources(), q.f26569g0);
        Matrix matrix = new Matrix();
        matrix.postScale(1.0f, 0.5f);
        Bitmap bitmap = this.f19084a;
        this.f19085b = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), this.f19084a.getHeight(), matrix, false);
        Paint paint = new Paint();
        this.f19086c = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f19086c.setColor(context.getResources().getColor(o.f26483s0));
    }
}
