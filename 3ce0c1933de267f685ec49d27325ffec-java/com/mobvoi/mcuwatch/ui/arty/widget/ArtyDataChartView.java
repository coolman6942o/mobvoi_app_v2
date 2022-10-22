package com.mobvoi.mcuwatch.ui.arty.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import gg.c;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sh.d;
import sh.e;
import sh.g;
import si.h;
/* loaded from: classes2.dex */
public class ArtyDataChartView extends View {
    private int A;
    private boolean B;
    private final RectF C;

    /* renamed from: a  reason: collision with root package name */
    private int[] f19317a;

    /* renamed from: b  reason: collision with root package name */
    private final String[] f19318b;

    /* renamed from: c  reason: collision with root package name */
    private final String[] f19319c;

    /* renamed from: d  reason: collision with root package name */
    private final String[] f19320d;

    /* renamed from: e  reason: collision with root package name */
    private final int[] f19321e;

    /* renamed from: f  reason: collision with root package name */
    private final SparseArray<c> f19322f;

    /* renamed from: g  reason: collision with root package name */
    private final HashMap<Integer, List<c>> f19323g;

    /* renamed from: h  reason: collision with root package name */
    private final List<b> f19324h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f19325i;

    /* renamed from: j  reason: collision with root package name */
    private int f19326j;

    /* renamed from: k  reason: collision with root package name */
    private final Paint f19327k;

    /* renamed from: l  reason: collision with root package name */
    private final Paint f19328l;

    /* renamed from: m  reason: collision with root package name */
    private final Paint f19329m;

    /* renamed from: n  reason: collision with root package name */
    private final Paint f19330n;

    /* renamed from: o  reason: collision with root package name */
    private final Paint f19331o;

    /* renamed from: p  reason: collision with root package name */
    private final float f19332p;

    /* renamed from: q  reason: collision with root package name */
    private final float f19333q;

    /* renamed from: r  reason: collision with root package name */
    private final float f19334r;

    /* renamed from: s  reason: collision with root package name */
    private final float f19335s;

    /* renamed from: t  reason: collision with root package name */
    private final float f19336t;

    /* renamed from: u  reason: collision with root package name */
    private final float f19337u;

    /* renamed from: v  reason: collision with root package name */
    private final float f19338v;

    /* renamed from: w  reason: collision with root package name */
    private final float f19339w;

    /* renamed from: x  reason: collision with root package name */
    private int f19340x;

    /* renamed from: y  reason: collision with root package name */
    private int f19341y;

    /* renamed from: z  reason: collision with root package name */
    private int f19342z;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        int f19343a;

        /* renamed from: b  reason: collision with root package name */
        int f19344b;

        /* renamed from: c  reason: collision with root package name */
        int f19345c;

        /* renamed from: d  reason: collision with root package name */
        float f19346d;

        /* renamed from: e  reason: collision with root package name */
        float f19347e;

        /* renamed from: f  reason: collision with root package name */
        LinearGradient f19348f;

        private b() {
        }
    }

    public ArtyDataChartView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void f(Canvas canvas, b bVar, float f10, boolean z10) {
        this.f19330n.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawLine(f10, bVar.f19346d, f10, bVar.f19347e, this.f19330n);
        if (z10) {
            k(this.f19329m, bVar.f19343a);
            float dimension = getResources().getDimension(e.K0);
            float strokeWidth = bVar.f19346d + (this.f19330n.getStrokeWidth() / 2.0f);
            Resources resources = getResources();
            int i10 = e.J0;
            canvas.drawCircle(f10, strokeWidth + resources.getDimension(i10), dimension, this.f19329m);
            canvas.drawCircle(f10, (bVar.f19347e - (this.f19330n.getStrokeWidth() / 2.0f)) - getResources().getDimension(i10), dimension, this.f19329m);
            this.f19329m.setColor(getResources().getColor(d.f34444b0));
            this.f19329m.setTextSize(getResources().getDimension(e.O0));
            canvas.drawText(String.valueOf(bVar.f19343a), f10, ((bVar.f19346d + (this.f19330n.getStrokeWidth() / 2.0f)) + getResources().getDimension(e.f34500l)) - this.f19329m.getFontMetrics().top, this.f19329m);
            canvas.drawText(String.valueOf(bVar.f19344b), f10, ((bVar.f19347e - (this.f19330n.getStrokeWidth() / 2.0f)) - getResources().getDimension(e.f34497k)) - this.f19329m.getFontMetrics().bottom, this.f19329m);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0150  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void g(Canvas canvas) {
        float f10;
        int i10;
        float f11;
        int i11;
        float f12;
        int i12;
        boolean z10;
        float f13;
        float f14;
        float dimension = getResources().getDimension(e.R0) + this.f19338v;
        int i13 = this.f19340x;
        int i14 = 3;
        boolean z11 = false;
        int i15 = 1;
        if (i13 == 0) {
            f14 = getResources().getDimension(e.M0);
            f13 = ((getWidth() - f14) - getResources().getDimension(e.N0)) / (this.f19324h.size() - 1);
            this.f19330n.setStrokeWidth(getResources().getDimension(e.Q0));
        } else if (i13 == 1) {
            float dimension2 = getResources().getDimension(e.f34518u);
            float dimension3 = getResources().getDimension(e.f34520v);
            Resources resources = getResources();
            int i16 = e.f34522w;
            f10 = (((getWidth() - dimension2) - dimension3) - resources.getDimension(i16)) / (this.f19324h.size() - 1);
            this.f19330n.setStrokeWidth(getResources().getDimension(i16));
            String[] strArr = this.f19319c;
            i10 = (Integer.parseInt(this.f19319c[0]) + Integer.parseInt(strArr[strArr.length - 1])) / 2;
            f11 = dimension2;
            this.f19329m.setTextAlign(Paint.Align.CENTER);
            i11 = 0;
            while (i11 < this.f19324h.size()) {
                b bVar = this.f19324h.get(i11);
                if (this.B) {
                    this.f19329m.setColor(getResources().getColor(d.f34459s));
                } else {
                    this.f19329m.setColor(this.A);
                }
                this.f19329m.setTextSize(getResources().getDimension(e.f34516t));
                float f15 = (i11 * f10) + f11;
                float strokeWidth = (this.f19330n.getStrokeWidth() / 2.0f) + f15;
                float f16 = dimension - this.f19329m.getFontMetrics().top;
                int i17 = this.f19340x;
                if (i17 == 0) {
                    canvas.drawText(this.f19318b[i11], f15, f16, this.f19329m);
                    f12 = f15;
                } else {
                    if (i17 == i15) {
                        if (i11 == 0) {
                            canvas.drawText(this.f19319c[i11], strokeWidth, f16, this.f19329m);
                        }
                        int size = this.f19324h.size();
                        int i18 = i15 == 1 ? 1 : 0;
                        int i19 = i15 == 1 ? 1 : 0;
                        if (i11 == size - i18) {
                            String[] strArr2 = this.f19319c;
                            canvas.drawText(strArr2[strArr2.length - i15], strokeWidth, f16, this.f19329m);
                        }
                        if (i11 == i10 - 1) {
                            canvas.drawText(String.valueOf(i10), strokeWidth, f16, this.f19329m);
                        }
                    } else if (i17 == 2) {
                        canvas.drawText(this.f19320d[bVar.f19345c], strokeWidth, f16, this.f19329m);
                    } else if (i17 == i14) {
                        canvas.drawText(this.f19320d[i11], strokeWidth, f16, this.f19329m);
                    }
                    f12 = strokeWidth;
                }
                if (bVar.f19343a > 0) {
                    this.f19330n.setShader(bVar.f19348f);
                    if (bVar.f19344b > 0) {
                        int i20 = this.f19340x;
                        if (i20 == 0 || i20 == 2) {
                            boolean z12 = i15 == 1 ? 1 : 0;
                            Object[] objArr = i15 == 1 ? 1 : 0;
                            z10 = z12;
                        } else {
                            z10 = z11;
                        }
                        f(canvas, bVar, f12, z10);
                    } else {
                        this.f19330n.setStrokeCap(Paint.Cap.BUTT);
                        this.C.set(f12 - (this.f19330n.getStrokeWidth() / 2.0f), bVar.f19347e, (this.f19330n.getStrokeWidth() / 2.0f) + f12, bVar.f19347e + this.f19330n.getStrokeWidth());
                        float f17 = f12;
                        i12 = i11;
                        canvas.drawArc(this.C, 180.0f, 180.0f, false, this.f19330n);
                        canvas.drawLine(f17, bVar.f19346d - 1.0f, f17, (bVar.f19347e + (this.f19330n.getStrokeWidth() / 2.0f)) - 1.0f, this.f19330n);
                        int i21 = this.f19340x;
                        if (i21 == 0 || i21 == 2) {
                            k(this.f19329m, bVar.f19343a);
                            canvas.drawCircle(f17, bVar.f19347e - getResources().getDimension(e.J0), getResources().getDimension(e.K0), this.f19329m);
                            canvas.drawText(String.valueOf(bVar.f19343a), f17, (bVar.f19347e - getResources().getDimension(e.L0)) - this.f19331o.getFontMetrics().bottom, this.f19331o);
                        }
                        i11 = i12 + 1;
                        i14 = 3;
                        z11 = false;
                        i15 = 1;
                    }
                }
                i12 = i11;
                i11 = i12 + 1;
                i14 = 3;
                z11 = false;
                i15 = 1;
            }
        } else if (i13 == 2) {
            f14 = getResources().getDimension(e.f34526y);
            float dimension4 = getResources().getDimension(e.f34528z);
            Resources resources2 = getResources();
            int i22 = e.A;
            f13 = (((getWidth() - f14) - dimension4) - resources2.getDimension(i22)) / (this.f19324h.size() - 1);
            this.f19330n.setStrokeWidth(getResources().getDimension(i22));
        } else if (i13 == 3) {
            f14 = getResources().getDimension(e.f34480e0);
            float dimension5 = getResources().getDimension(e.f34483f0);
            Resources resources3 = getResources();
            int i23 = e.f34486g0;
            f13 = (((getWidth() - f14) - dimension5) - resources3.getDimension(i23)) / (this.f19324h.size() - 1);
            this.f19330n.setStrokeWidth(getResources().getDimension(i23));
        } else {
            throw new IllegalStateException("Unexpected value: " + this.f19340x);
        }
        f11 = f14;
        f10 = f13;
        i10 = 0;
        this.f19329m.setTextAlign(Paint.Align.CENTER);
        i11 = 0;
        while (i11 < this.f19324h.size()) {
        }
    }

    private void h(int i10, SparseArray<c> sparseArray) {
        int i11;
        int i12;
        this.f19324h.clear();
        for (int i13 = 0; i13 < i10; i13++) {
            c cVar = sparseArray.get(i13);
            int i14 = -1;
            if (cVar != null) {
                gg.a aVar = null;
                if (cVar instanceof gg.a) {
                    aVar = (gg.a) cVar;
                }
                int i15 = this.f19341y;
                if (i15 == 0) {
                    i12 = cVar.f27459c;
                    if (aVar != null) {
                        i14 = aVar.f27454j;
                    }
                } else if (i15 == 1) {
                    i12 = cVar.f27457a;
                    if (aVar != null) {
                        i14 = aVar.f27452h;
                    }
                } else if (i15 == 2) {
                    i12 = cVar.f27458b;
                    if (aVar != null) {
                        i14 = aVar.f27453i;
                    }
                }
                i11 = i14;
                i14 = i12;
                this.f19324h.add(i(i14, i11, 0));
            }
            i11 = -1;
            this.f19324h.add(i(i14, i11, 0));
        }
    }

    private b i(int i10, int i11, int i12) {
        b bVar = new b();
        bVar.f19343a = i10;
        bVar.f19345c = i12;
        if (i10 > 0) {
            bVar.f19344b = i11;
            com.mobvoi.companion.health.widget.arty.a aVar = com.mobvoi.companion.health.widget.arty.a.f17142a;
            int h10 = aVar.h(this.f19342z, i10, false);
            int h11 = aVar.h(this.f19342z, i10, true);
            if (i11 > 0) {
                float f10 = this.f19338v;
                float f11 = this.f19339w;
                bVar.f19346d = f10 - ((i10 / 100.0f) * f11);
                bVar.f19347e = f10 - ((i11 / 100.0f) * f11);
            } else {
                float f12 = this.f19338v;
                bVar.f19346d = f12 - 1.0f;
                if (this.f19342z == 1) {
                    this.f19317a = new int[]{120, 90, 60, 30};
                    bVar.f19347e = f12 - ((i10 / 120.0f) * this.f19339w);
                } else {
                    bVar.f19347e = f12 - ((i10 / 100.0f) * this.f19339w);
                }
            }
            bVar.f19348f = new LinearGradient(0.0f, bVar.f19346d, 0.0f, bVar.f19347e, h10, h11, Shader.TileMode.CLAMP);
        }
        return bVar;
    }

    private void j(int i10, HashMap<Integer, List<c>> hashMap, boolean z10) {
        int i11;
        int i12;
        this.f19324h.clear();
        for (int i13 = 0; i13 < i10; i13++) {
            int i14 = (!z10 || this.f19325i) ? i13 : i13 + 6;
            List<c> list = hashMap.get(Integer.valueOf(i14));
            int i15 = -1;
            if (list != null) {
                int i16 = -1;
                i11 = -1;
                for (c cVar : list) {
                    gg.a aVar = null;
                    if (cVar instanceof gg.a) {
                        aVar = (gg.a) cVar;
                    }
                    int i17 = this.f19341y;
                    if (i17 == 0) {
                        int i18 = cVar.f27459c;
                        if (i16 < i18) {
                            i16 = i18;
                        }
                        if (aVar != null && i11 < (i12 = aVar.f27454j)) {
                            i11 = i12;
                        }
                    } else if (i17 == 1) {
                        if (i16 == -1) {
                            i16 = cVar.f27457a;
                        } else {
                            i16 += cVar.f27457a;
                        }
                        if (aVar != null) {
                            if (i11 == -1) {
                                i11 = aVar.f27452h;
                            } else {
                                i11 += aVar.f27452h;
                            }
                        }
                    } else if (i17 == 2) {
                        if (i16 == -1) {
                            i16 = cVar.f27458b;
                        }
                        int i19 = cVar.f27458b;
                        if (i16 > i19) {
                            i16 = i19;
                        }
                        if (aVar != null) {
                            if (i11 == -1) {
                                i11 = aVar.f27453i;
                            }
                            i12 = aVar.f27453i;
                            if (i11 > i12) {
                                i11 = i12;
                            }
                        }
                    }
                }
                if (this.f19341y == 1) {
                    i15 = i16 / list.size();
                    if (i11 > 0) {
                        i11 /= list.size();
                    }
                } else {
                    i15 = i16;
                }
            } else {
                i11 = -1;
            }
            this.f19324h.add(i(i15, i11, i14));
        }
    }

    private void k(Paint paint, int i10) {
        int i11 = this.f19342z;
        if (i11 == 1 || i11 == 4) {
            paint.setColor(this.f19321e[0]);
            return;
        }
        boolean z10 = i11 == 3;
        if (i10 >= 75) {
            int[] iArr = this.f19321e;
            paint.setColor(z10 ? iArr[3] : iArr[0]);
        } else if (i10 >= 50) {
            int[] iArr2 = this.f19321e;
            paint.setColor(z10 ? iArr2[2] : iArr2[1]);
        } else if (i10 >= 25) {
            int[] iArr3 = this.f19321e;
            paint.setColor(z10 ? iArr3[1] : iArr3[2]);
        } else {
            int[] iArr4 = this.f19321e;
            paint.setColor(z10 ? iArr4[0] : iArr4[3]);
        }
    }

    public void a(Boolean bool) {
        this.f19325i = bool.booleanValue();
    }

    public void b(h.c cVar) {
        int i10 = this.f19340x;
        if (i10 == 1) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(cVar.f34962b);
            this.f19319c[1] = String.valueOf(calendar.getActualMaximum(5));
        } else if (i10 == 2) {
            this.f19325i = cVar.f34965e;
        }
    }

    public void c(int i10) {
        this.f19340x = i10;
    }

    public void d(int i10) {
        this.f19341y = i10;
        int i11 = this.f19340x;
        if (i11 == 0 || i11 == 1) {
            h(this.f19326j, this.f19322f);
        } else if (i11 == 2) {
            j(this.f19326j, this.f19323g, true);
        } else if (i11 == 3) {
            j(this.f19326j, this.f19323g, false);
        }
        postInvalidate();
    }

    public void e() {
        this.f19322f.clear();
        this.f19323g.clear();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.B) {
            this.f19329m.setColor(getResources().getColor(d.f34460t));
        } else {
            this.f19329m.setColor(this.A);
        }
        this.f19329m.setTextAlign(Paint.Align.LEFT);
        this.f19329m.setTextSize(getResources().getDimension(e.f34516t));
        float f10 = this.f19329m.getFontMetrics().bottom;
        float dimension = getResources().getDimension(e.f34492i0);
        float dimension2 = getResources().getDimension(e.f34495j0);
        float dimension3 = getResources().getDimension(e.f34489h0);
        this.f19328l.setStrokeWidth(getResources().getDimension(e.f34498k0));
        if (this.B) {
            this.f19328l.setColor(getResources().getColor(d.f34459s));
        } else {
            this.f19328l.setColor(this.A);
        }
        this.f19328l.setStrokeCap(Paint.Cap.ROUND);
        for (int i10 = 0; i10 < 4; i10++) {
            float f11 = i10;
            float f12 = this.f19332p + (this.f19336t * f11) + (f11 * this.f19337u);
            canvas.drawLine(this.f19334r, f12, getWidth() - this.f19335s, f12, this.f19327k);
            canvas.drawText(String.valueOf(this.f19317a[i10]), this.f19334r, f12 - f10, this.f19329m);
            this.f19328l.setColor(this.f19321e[i10]);
            int i11 = this.f19342z;
            if (!(i11 == 0 || i11 == 2)) {
                if (i11 == 3) {
                    this.f19328l.setColor(this.f19321e[(4 - i10) - 1]);
                }
            }
            float f13 = f12 + dimension2;
            canvas.drawLine(dimension, f13, dimension, f13 + dimension3, this.f19328l);
        }
        if (this.B) {
            this.f19328l.setColor(getResources().getColor(d.f34459s));
        } else {
            this.f19328l.setColor(this.A);
        }
        this.f19328l.setStrokeWidth(getResources().getDimension(e.f34507o0));
        this.f19328l.setStrokeCap(Paint.Cap.BUTT);
        canvas.drawLine(this.f19334r, this.f19338v, getWidth() - this.f19335s, this.f19338v, this.f19328l);
        if (this.f19324h.size() != 0) {
            g(canvas);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i10, int i11) {
        super.onMeasure(i10, View.MeasureSpec.makeMeasureSpec((int) (this.f19333q + this.f19338v), Integer.MIN_VALUE));
    }

    public void setArtyDataType(int i10) {
        this.f19342z = i10;
    }

    public void setArtyDetailData(Map<Long, List<c>> map) {
        int i10;
        int i11;
        Calendar calendar = Calendar.getInstance();
        e();
        int i12 = this.f19340x;
        boolean z10 = false;
        if (i12 == 0 || i12 == 1) {
            Iterator<Map.Entry<Long, List<c>>> it = map.entrySet().iterator();
            while (true) {
                i10 = 7;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<Long, List<c>> next = it.next();
                calendar.setTimeInMillis(next.getKey().longValue());
                if (this.f19340x == 0) {
                    i11 = calendar.get(7);
                } else {
                    i11 = calendar.get(5);
                }
                int i13 = i11 - 1;
                if (i13 < 0) {
                    i13 = 0;
                }
                this.f19322f.put(i13, next.getValue().get(this.f19342z));
            }
            if (this.f19340x != 0) {
                i10 = Integer.parseInt(this.f19319c[1]);
            }
            this.f19326j = i10;
            h(i10, this.f19322f);
        } else if (i12 == 2 || i12 == 3) {
            for (Map.Entry<Long, List<c>> entry : map.entrySet()) {
                calendar.setTimeInMillis(entry.getKey().longValue());
                int i14 = calendar.get(2);
                if (!this.f19323g.containsKey(Integer.valueOf(i14))) {
                    this.f19323g.put(Integer.valueOf(i14), new ArrayList());
                }
                this.f19323g.get(Integer.valueOf(i14)).add(entry.getValue().get(this.f19342z));
            }
            if (this.f19340x == 2) {
                z10 = true;
            }
            int i15 = z10 ? 6 : 12;
            this.f19326j = i15;
            j(i15, this.f19323g, z10);
        }
        postInvalidate();
    }

    public ArtyDataChartView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.f19317a = new int[]{100, 75, 50, 25};
        this.f19318b = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        this.f19319c = new String[]{"1", "30"};
        this.f19320d = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        this.f19321e = new int[]{getResources().getColor(d.f34457q), getResources().getColor(d.f34456p), getResources().getColor(d.f34463w), getResources().getColor(d.f34458r)};
        this.f19322f = new SparseArray<>();
        this.f19323g = new HashMap<>();
        this.f19324h = new ArrayList();
        this.f19325i = true;
        this.C = new RectF();
        this.B = j7.a.f(j7.a.e(this, 16842801, -16777216));
        this.A = j7.a.e(this, sh.c.f34440b, -7829368);
        Paint paint = new Paint(1);
        this.f19327k = paint;
        Resources resources = getResources();
        int i11 = e.f34507o0;
        paint.setStrokeWidth(resources.getDimension(i11));
        paint.setPathEffect(new DashPathEffect(new float[]{10.0f, 10.0f}, 0.0f));
        if (this.B) {
            paint.setColor(getResources().getColor(d.f34460t));
        } else {
            paint.setColor(this.A);
        }
        Paint paint2 = new Paint(1);
        this.f19328l = paint2;
        paint2.setAntiAlias(true);
        Paint paint3 = new Paint(1);
        this.f19329m = paint3;
        paint3.setAntiAlias(true);
        Paint paint4 = new Paint(1);
        this.f19330n = paint4;
        paint4.setAntiAlias(true);
        paint4.setStyle(Paint.Style.FILL);
        Paint paint5 = new Paint(1);
        this.f19331o = paint5;
        paint5.setAntiAlias(true);
        paint5.setFakeBoldText(true);
        paint5.setTextAlign(Paint.Align.CENTER);
        paint5.setColor(getResources().getColor(d.f34444b0));
        paint5.setTextSize(getResources().getDimension(e.O0));
        paint3.setTypeface(a0.h.h(getContext(), g.f34608b));
        paint5.setTypeface(a0.h.h(getContext(), g.f34607a));
        float dimension = getResources().getDimension(e.f34509p0);
        this.f19332p = dimension;
        this.f19333q = getResources().getDimension(e.f34514s);
        this.f19334r = getResources().getDimension(e.f34503m0);
        this.f19335s = getResources().getDimension(e.f34505n0);
        float dimension2 = getResources().getDimension(e.f34501l0);
        this.f19336t = dimension2;
        float dimension3 = getResources().getDimension(i11);
        this.f19337u = dimension3;
        this.f19338v = dimension + ((dimension2 + dimension3) * 4.0f);
        this.f19339w = getResources().getDimension(e.P0);
    }
}
