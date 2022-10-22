package com.mobvoi.health.common.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.wear.util.DimensionUtils;
import java.util.ArrayList;
import java.util.List;
import mf.e;
/* loaded from: classes2.dex */
public class HistogramView extends View {

    /* renamed from: a  reason: collision with root package name */
    private final d f18002a;

    /* renamed from: b  reason: collision with root package name */
    private c f18003b;

    /* renamed from: c  reason: collision with root package name */
    private float f18004c;

    /* renamed from: d  reason: collision with root package name */
    private float f18005d;

    /* renamed from: e  reason: collision with root package name */
    private float f18006e;

    /* renamed from: f  reason: collision with root package name */
    private float f18007f;

    /* renamed from: g  reason: collision with root package name */
    private List<b> f18008g;

    /* renamed from: h  reason: collision with root package name */
    private float f18009h;

    /* renamed from: i  reason: collision with root package name */
    private float f18010i;

    /* renamed from: j  reason: collision with root package name */
    private float f18011j;

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public float f18012a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f18013b;

        /* renamed from: c  reason: collision with root package name */
        public String f18014c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        final Paint f18015a;

        /* renamed from: b  reason: collision with root package name */
        final Paint f18016b;

        /* renamed from: c  reason: collision with root package name */
        final Paint f18017c;

        /* renamed from: d  reason: collision with root package name */
        final TextPaint f18018d;

        private c(d dVar) {
            Paint paint = new Paint();
            this.f18015a = paint;
            paint.setColor(dVar.f18025g);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(dVar.f18027i);
            paint.setAntiAlias(true);
            paint.setStrokeCap(Paint.Cap.ROUND);
            paint.setColor(dVar.f18028j);
            Paint paint2 = new Paint();
            this.f18016b = paint2;
            paint2.setColor(dVar.f18025g);
            paint2.setStyle(Paint.Style.STROKE);
            paint2.setAntiAlias(true);
            paint2.setStrokeCap(Paint.Cap.ROUND);
            paint2.setStrokeWidth(dVar.f18027i);
            Paint paint3 = new Paint();
            this.f18017c = paint3;
            float f10 = dVar.f18032n;
            paint3.setPathEffect(new DashPathEffect(new float[]{f10, f10}, 0.0f));
            paint3.setColor(dVar.f18029k);
            paint3.setAntiAlias(true);
            paint3.setStyle(Paint.Style.STROKE);
            paint3.setStrokeWidth(dVar.f18026h);
            TextPaint textPaint = new TextPaint();
            this.f18018d = textPaint;
            textPaint.setTextAlign(Paint.Align.CENTER);
            textPaint.setAntiAlias(true);
            textPaint.setColor(dVar.f18030l);
            textPaint.setTextSize(dVar.f18031m);
        }
    }

    /* loaded from: classes2.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public int f18019a;

        /* renamed from: b  reason: collision with root package name */
        boolean f18020b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f18021c;

        /* renamed from: d  reason: collision with root package name */
        boolean f18022d;

        /* renamed from: e  reason: collision with root package name */
        public float[] f18023e;

        /* renamed from: f  reason: collision with root package name */
        public float f18024f;

        /* renamed from: h  reason: collision with root package name */
        public float f18026h;

        /* renamed from: i  reason: collision with root package name */
        public float f18027i;

        /* renamed from: m  reason: collision with root package name */
        public float f18031m;

        /* renamed from: n  reason: collision with root package name */
        public float f18032n;

        /* renamed from: g  reason: collision with root package name */
        public int f18025g = -1;

        /* renamed from: j  reason: collision with root package name */
        public int f18028j = 60;

        /* renamed from: k  reason: collision with root package name */
        public int f18029k = -7829368;

        /* renamed from: l  reason: collision with root package name */
        public int f18030l = -7829368;
    }

    public HistogramView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private float a(int i10) {
        return i10 / this.f18008g.size();
    }

    private float b(int i10) {
        float a10 = a(i10);
        float[] fArr = this.f18002a.f18023e;
        return fArr == null ? a10 - 2.0f : (a10 * fArr[0]) / (fArr[0] + fArr[1]);
    }

    private void c(Canvas canvas, float f10) {
        if (this.f18002a.f18020b) {
            float f11 = this.f18006e;
            canvas.drawLine(f10, f11, f10, f11 - this.f18005d, this.f18003b.f18015a);
        }
    }

    private void d(Canvas canvas, float f10, boolean z10) {
        if (this.f18002a.f18021c && z10) {
            canvas.drawLine(f10, this.f18006e, f10, 0.0f, this.f18003b.f18017c);
        }
    }

    private void e(Canvas canvas, float f10, float f11) {
        if (f11 > 0.0f) {
            float f12 = this.f18006e;
            canvas.drawLine(f10, f12, f10, f12 - (this.f18007f * (f11 / this.f18011j)), this.f18003b.f18016b);
        }
    }

    private void f(Canvas canvas, String str, float f10) {
        if (this.f18002a.f18022d && !TextUtils.isEmpty(str)) {
            float measureText = this.f18003b.f18018d.measureText(str) / 2.0f;
            if (measureText > f10) {
                f10 = measureText + 1.0f;
            } else if (measureText > canvas.getWidth() - f10) {
                f10 = (canvas.getWidth() - measureText) - 1.0f;
            }
            canvas.drawText(str, f10, this.f18004c, this.f18003b.f18018d);
        }
    }

    private float[] g(String str) {
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split(":");
            if (split.length == 2) {
                try {
                    return new float[]{Float.parseFloat(split[0]), Float.parseFloat(split[1])};
                } catch (Exception e10) {
                    k.e("health.histogram", "pleasee input a correct ratio", e10);
                    throw new NumberFormatException("pleasee input a correct ratio");
                }
            }
        }
        return null;
    }

    private void h() {
        l(this.f18002a);
        if (this.f18002a.f18022d) {
            this.f18010i = cg.a.b(this.f18003b.f18018d) * 2.0f;
        }
    }

    private float i(int i10) {
        return b(i10) + ((int) (i10 * this.f18002a.f18024f)) + this.f18010i;
    }

    private boolean k(int i10, int i11) {
        List<b> list = this.f18008g;
        return list == null || list.size() < 2 || i10 <= 0 || i11 <= 0;
    }

    private void l(d dVar) {
        this.f18003b = new c(dVar);
    }

    public d getDrawStyle() {
        return this.f18002a;
    }

    public List<b> getItems() {
        return this.f18008g;
    }

    public void j() {
        l(this.f18002a);
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!k(canvas.getWidth(), canvas.getHeight())) {
            float f10 = this.f18009h / 2.0f;
            for (int i10 = 0; i10 < this.f18008g.size(); i10++) {
                float f11 = (this.f18009h * i10) + f10;
                b bVar = this.f18008g.get(i10);
                d(canvas, f11, bVar.f18013b);
                c(canvas, f11);
                e(canvas, f11, bVar.f18012a);
                f(canvas, bVar.f18014c, f11);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        int defaultSize = View.getDefaultSize(getSuggestedMinimumWidth(), i10);
        if (defaultSize <= 0) {
            setMeasuredDimension(0, 0);
        } else if (View.MeasureSpec.getMode(i11) != 1073741824) {
            setMeasuredDimension(defaultSize, (int) (i(defaultSize) + 0.5f));
        } else {
            super.onMeasure(i10, i11);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        if (!k(i10, i11)) {
            float b10 = b(i10);
            this.f18009h = a(i10);
            float f10 = i11;
            float f11 = this.f18010i;
            this.f18006e = (f10 - f11) - (b10 / 2.0f);
            this.f18004c = f10 - (f11 / 3.0f);
            float f12 = (f10 - f11) - b10;
            this.f18007f = f12;
            d dVar = this.f18002a;
            if (dVar.f18019a == 1) {
                this.f18005d = f12;
            } else {
                this.f18005d = 0.01f;
            }
            dVar.f18027i = b10;
            l(dVar);
        }
    }

    public void setProgress(List<b> list) {
        this.f18008g = list;
        invalidate();
    }

    public HistogramView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        d dVar = new d();
        this.f18002a = dVar;
        this.f18008g = new ArrayList();
        this.f18011j = 1.0f;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, e.f30756i, i10, 0);
        if (obtainStyledAttributes != null) {
            dVar.f18019a = obtainStyledAttributes.getInt(e.f30767t, 0);
            dVar.f18020b = obtainStyledAttributes.getBoolean(e.f30758k, true);
            dVar.f18021c = obtainStyledAttributes.getBoolean(e.f30760m, true);
            dVar.f18026h = obtainStyledAttributes.getDimension(e.f30762o, DimensionUtils.dp2px(context, 1.0f));
            dVar.f18029k = obtainStyledAttributes.getColor(e.f30759l, -7829368);
            dVar.f18022d = obtainStyledAttributes.getBoolean(e.f30769v, true);
            dVar.f18030l = obtainStyledAttributes.getColor(e.f30768u, -7829368);
            int color = obtainStyledAttributes.getColor(e.f30765r, -1);
            dVar.f18025g = color;
            dVar.f18028j = obtainStyledAttributes.getInt(e.f30757j, cg.a.a(color, 0.4f));
            dVar.f18031m = obtainStyledAttributes.getDimension(e.f30770w, DimensionUtils.dp2px(context, 16.0f));
            dVar.f18032n = obtainStyledAttributes.getDimension(e.f30761n, DimensionUtils.dp2px(context, 3.0f));
            dVar.f18024f = obtainStyledAttributes.getFloat(e.f30763p, 0.3f);
            this.f18008g = com.mobvoi.health.common.ui.view.a.a(obtainStyledAttributes.getInt(e.f30764q, 0));
            dVar.f18023e = g(obtainStyledAttributes.getString(e.f30766s));
            obtainStyledAttributes.recycle();
        }
        h();
    }
}
