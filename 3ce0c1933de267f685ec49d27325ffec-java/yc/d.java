package yc;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.GradientDrawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cardiex.arty.lite.models.coach.ArtyComponent;
import com.cardiex.arty.lite.models.coach.ArtyGraph;
import com.cardiex.arty.lite.models.coach.ArtyType;
import com.mobvoi.companion.R;
import com.mobvoi.wear.util.DimensionUtils;
import com.mobvoi.wear.util.LogCleaner;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import kotlin.collections.q;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: ArtyCardGraphView.kt */
/* loaded from: classes2.dex */
public final class d extends View implements k {

    /* renamed from: a  reason: collision with root package name */
    private final long f36947a;

    /* renamed from: b  reason: collision with root package name */
    private TextPaint f36948b;

    /* renamed from: c  reason: collision with root package name */
    private TextPaint f36949c;

    /* renamed from: d  reason: collision with root package name */
    private Paint f36950d;

    /* renamed from: e  reason: collision with root package name */
    private Paint f36951e;

    /* renamed from: f  reason: collision with root package name */
    private Paint f36952f;

    /* renamed from: g  reason: collision with root package name */
    private float f36953g;

    /* renamed from: h  reason: collision with root package name */
    private DashPathEffect f36954h;

    /* renamed from: i  reason: collision with root package name */
    private float f36955i;

    /* renamed from: j  reason: collision with root package name */
    private float f36956j;

    /* renamed from: k  reason: collision with root package name */
    private float f36957k;

    /* renamed from: l  reason: collision with root package name */
    private LinearGradient f36958l;

    /* renamed from: m  reason: collision with root package name */
    private LinearGradient[] f36959m;

    /* renamed from: n  reason: collision with root package name */
    private int f36960n;

    /* renamed from: o  reason: collision with root package name */
    private a f36961o;

    /* renamed from: p  reason: collision with root package name */
    private int f36962p;

    /* renamed from: q  reason: collision with root package name */
    private String f36963q;

    /* renamed from: r  reason: collision with root package name */
    private RectF f36964r;

    /* renamed from: s  reason: collision with root package name */
    private int f36965s;

    /* renamed from: t  reason: collision with root package name */
    private int f36966t;

    /* renamed from: u  reason: collision with root package name */
    private final Bitmap[] f36967u;

    /* renamed from: v  reason: collision with root package name */
    private int[] f36968v;

    /* renamed from: w  reason: collision with root package name */
    private int[] f36969w;

    /* renamed from: x  reason: collision with root package name */
    private float[] f36970x;

    /* renamed from: y  reason: collision with root package name */
    private int[] f36971y;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ArtyCardGraphView.kt */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private int f36972a;

        /* renamed from: b  reason: collision with root package name */
        private int f36973b;

        /* renamed from: c  reason: collision with root package name */
        private int f36974c;

        public final int a() {
            return this.f36974c;
        }

        public final int b() {
            return this.f36972a;
        }

        public final int c() {
            return this.f36973b;
        }

        public final void d() {
            this.f36972a = 0;
            this.f36973b = 0;
            this.f36974c = 0;
        }

        public final void e(int i10) {
            this.f36974c = i10;
        }

        public final void f(int i10) {
            this.f36972a = i10;
        }

        public final void g(int i10) {
            this.f36973b = i10;
        }
    }

    /* compiled from: ArtyCardGraphView.kt */
    /* loaded from: classes2.dex */
    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f36975a;

        static {
            int[] iArr = new int[ArtyType.values().length];
            iArr[ArtyType.ARTY.ordinal()] = 1;
            iArr[ArtyType.AGE.ordinal()] = 2;
            iArr[ArtyType.HSX.ordinal()] = 3;
            iArr[ArtyType.TRU_HR.ordinal()] = 4;
            iArr[ArtyType.E_CAP.ordinal()] = 5;
            f36975a = iArr;
        }
    }

    /* compiled from: Comparisons.kt */
    /* loaded from: classes2.dex */
    public static final class c<T> implements Comparator {
        @Override // java.util.Comparator
        public final int compare(T t10, T t11) {
            int a10;
            a10 = jo.b.a(Long.valueOf(((ArtyComponent) t10).getTimestamp()), Long.valueOf(((ArtyComponent) t11).getTimestamp()));
            return a10;
        }
    }

    public /* synthetic */ d(Context context, AttributeSet attributeSet, int i10, int i11, f fVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    private final int a(Date date) {
        int i10 = 0;
        int[] iArr = {R.string.arty_card_graph_week_sun, R.string.arty_card_graph_week_mon, R.string.arty_card_graph_week_tue, R.string.arty_card_graph_week_wed, R.string.arty_card_graph_week_thu, R.string.arty_card_graph_week_fri, R.string.arty_card_graph_week_sat};
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int i11 = calendar.get(7) - 1;
        if (i11 >= 0) {
            i10 = i11;
        }
        return iArr[i10];
    }

    private final void b(int i10, int i11, int i12) {
        this.f36961o.g(i10);
        this.f36961o.f(i11);
        this.f36961o.e(i12);
    }

    private final void setArtyDataType(ArtyType artyType) {
        int i10 = b.f36975a[artyType.ordinal()];
        if (i10 == 1) {
            this.f36962p = 0;
            String string = getResources().getString(R.string.arty_card_graph_arty_score_trend);
            i.e(string, "resources.getString(R.string.arty_card_graph_arty_score_trend)");
            this.f36963q = string;
        } else if (i10 == 2) {
            this.f36962p = 4;
            String string2 = getResources().getString(R.string.arty_card_graph_artyage_trend);
            i.e(string2, "resources.getString(R.string.arty_card_graph_artyage_trend)");
            this.f36963q = string2;
        } else if (i10 == 3) {
            this.f36962p = 3;
            String string3 = getResources().getString(R.string.arty_card_graph_hsx_trend);
            i.e(string3, "resources.getString(R.string.arty_card_graph_hsx_trend)");
            this.f36963q = string3;
        } else if (i10 == 4) {
            this.f36962p = 1;
            String string4 = getResources().getString(R.string.arty_card_graph_truhr_trend);
            i.e(string4, "resources.getString(R.string.arty_card_graph_truhr_trend)");
            this.f36963q = string4;
        } else if (i10 == 5) {
            this.f36962p = 2;
            String string5 = getResources().getString(R.string.arty_card_graph_ecap_trend);
            i.e(string5, "resources.getString(R.string.arty_card_graph_ecap_trend)");
            this.f36963q = string5;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00f4 A[LOOP:1: B:17:0x00a0->B:31:0x00f4, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f0 A[SYNTHETIC] */
    @Override // yc.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(zc.a dataArty) {
        boolean z10;
        i.f(dataArty, "dataArty");
        if (dataArty.c() instanceof ArtyGraph) {
            Object c10 = dataArty.c();
            Objects.requireNonNull(c10, "null cannot be cast to non-null type com.cardiex.arty.lite.models.coach.ArtyGraph");
            ArtyGraph artyGraph = (ArtyGraph) c10;
            ArrayList arrayList = new ArrayList();
            List<ArtyComponent> data = artyGraph.getData();
            if (data != null) {
                for (ArtyComponent artyComponent : data) {
                    arrayList.add(artyComponent);
                }
            }
            if (arrayList.size() != 0) {
                if (arrayList.size() > 1) {
                    q.r(arrayList, new c());
                }
                setData(artyGraph.getArtyType());
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
                ((ViewGroup.MarginLayoutParams) bVar).width = 0;
                ((ViewGroup.MarginLayoutParams) bVar).height = 0;
                bVar.V = true;
                bVar.W = true;
                bVar.Q = 0.495f;
                bVar.R = 0.498f;
                setLayoutParams(bVar);
                long b10 = eg.c.b(((ArtyComponent) arrayList.get(0)).getTimestamp());
                long b11 = (eg.c.b(((ArtyComponent) arrayList.get(arrayList.size() - 1)).getTimestamp()) - b10) / this.f36947a;
                int size = arrayList.size();
                int i10 = 0;
                while (true) {
                    int i11 = i10 + 1;
                    if (size > 0) {
                        int i12 = 0;
                        while (true) {
                            int i13 = i12 + 1;
                            ArtyComponent artyComponent2 = (ArtyComponent) arrayList.get(i12);
                            if (b10 == eg.c.b(artyComponent2.getTimestamp())) {
                                this.f36968v[i10] = a(new Date(b10));
                                this.f36971y[i10] = (int) artyComponent2.getValue();
                                z10 = true;
                                break;
                            } else if (i13 >= size) {
                                break;
                            } else {
                                i12 = i13;
                            }
                        }
                        if (!z10) {
                            this.f36968v[i10] = a(new Date(b10));
                            this.f36971y[i10] = 0;
                        }
                        b10 += this.f36947a;
                        if (i11 < 7) {
                            postInvalidate();
                            return;
                        }
                        i10 = i11;
                    }
                    z10 = false;
                    if (!z10) {
                    }
                    b10 += this.f36947a;
                    if (i11 < 7) {
                    }
                }
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        i.f(canvas, "canvas");
        super.onDraw(canvas);
        int i10 = this.f36962p;
        if (i10 == 3 || i10 == 2 || i10 == 0) {
            RectF rectF = this.f36964r;
            float f10 = rectF.left;
            float f11 = rectF.top;
            RectF rectF2 = this.f36964r;
            canvas.drawRect(f10, f11, getWidth() - rectF2.right, rectF2.bottom, this.f36951e);
        }
        this.f36948b.setTextSize(getResources().getDimension(R.dimen.arty_card_graph_score_trend_size));
        this.f36948b.setColor(this.f36965s);
        canvas.drawText(this.f36963q, getWidth() / 2.0f, getResources().getDimension(R.dimen.arty_card_graph_score_trend_margin_top) - this.f36948b.getFontMetrics().top, this.f36948b);
        int i11 = this.f36962p;
        if (i11 == 0 || i11 == 2) {
            this.f36948b.setTextSize(getResources().getDimension(R.dimen.arty_card_graph_opt_range_size));
            this.f36948b.setColor(getResources().getColor(R.color.arty_card_bar_green_end_color, null));
            canvas.drawText(getResources().getString(R.string.arty_card_graph_score_opt_range), getWidth() / 2.0f, getResources().getDimension(R.dimen.arty_card_graph_opt_range_margin_top) - this.f36948b.getFontMetrics().top, this.f36948b);
            canvas.drawLine(this.f36956j, getHeight() / 2.0f, getWidth() - this.f36956j, getHeight() / 2.0f, this.f36952f);
        } else if (i11 == 3) {
            float height = (getHeight() - getResources().getDimension(R.dimen.arty_card_graph_hsx_opt_range_height)) - getResources().getDimension(R.dimen.arty_card_graph_hsx_opt_range_margin_bottom);
            canvas.drawLine(this.f36956j, height, getWidth() - this.f36956j, height, this.f36952f);
        }
        this.f36948b.setTextSize(getResources().getDimension(R.dimen.arty_card_graph_week_text_size));
        int i12 = 0;
        int length = this.f36968v.length - 1;
        if (length >= 0) {
            while (true) {
                int i13 = i12 + 1;
                float f12 = this.f36955i;
                float width = ((getWidth() / 2) - (3 * f12)) + (i12 * f12);
                int i14 = this.f36971y[i12];
                float height2 = (getHeight() - getResources().getDimension(R.dimen.arty_card_graph_bar_margin_bottom)) - (this.f36950d.getStrokeWidth() / 2);
                if (i14 > 0) {
                    float dimension = (height2 - ((getResources().getDimension(R.dimen.arty_card_graph_bar_max_height) * i14) / 100.0f)) + this.f36950d.getStrokeWidth();
                    float f13 = dimension >= height2 ? height2 : dimension;
                    this.f36950d.setShader(this.f36959m[i12]);
                    canvas.drawLine(width, height2, width, f13, this.f36950d);
                    this.f36948b.setColor(this.f36965s);
                    canvas.drawText(getResources().getString(this.f36968v[i12]), width, getHeight() - (getResources().getDimension(R.dimen.arty_card_graph_week_margin_bottom) + this.f36948b.getFontMetrics().descent), this.f36948b);
                } else {
                    this.f36948b.setColor(this.f36966t);
                    canvas.drawText(getResources().getString(this.f36968v[i12]), width, getHeight() - (getResources().getDimension(R.dimen.arty_card_graph_week_margin_bottom) + this.f36948b.getFontMetrics().descent), this.f36948b);
                }
                if (i13 > length) {
                    break;
                }
                i12 = i13;
            }
        }
        this.f36948b.setTextSize(getResources().getDimension(R.dimen.arty_card_graph_bar_value_text_size));
        this.f36948b.setColor(getResources().getColor(R.color.white, null));
        if (this.f36961o.c() > 0) {
            Bitmap bitmap = this.f36967u[this.f36961o.a()];
            float width2 = ((getWidth() / 2) - (3 * this.f36955i)) + (this.f36961o.b() * this.f36955i);
            float height3 = (((getHeight() - getResources().getDimension(R.dimen.arty_card_graph_bar_margin_bottom)) - ((getResources().getDimension(R.dimen.arty_card_graph_bar_max_height) * this.f36961o.c()) / 100.0f)) - getResources().getDimension(R.dimen.arty_card_graph_bar_value_margin_bottom)) - bitmap.getHeight();
            canvas.drawBitmap(bitmap, width2 - (bitmap.getWidth() / 2.0f), height3, this.f36948b);
            this.f36948b.setColor(this.f36965s);
            canvas.drawText(String.valueOf(this.f36961o.c()), width2, ((height3 + (bitmap.getHeight() / 2)) + ((this.f36948b.ascent() - this.f36948b.descent()) / 2)) - this.f36948b.ascent(), this.f36948b);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        int[] x10;
        super.onSizeChanged(i10, i11, i12, i13);
        int i14 = this.f36962p;
        if (i14 == 0 || i14 == 2) {
            this.f36964r.set(this.f36956j, (getHeight() / 2) - this.f36957k, this.f36956j, getHeight() / 2.0f);
        } else if (i14 == 3) {
            float dimension = getResources().getDimension(R.dimen.arty_card_graph_hsx_opt_range_height);
            float height = (getHeight() - dimension) - getResources().getDimension(R.dimen.arty_card_graph_hsx_opt_range_margin_bottom);
            RectF rectF = this.f36964r;
            float f10 = this.f36956j;
            rectF.set(f10, height, f10, dimension + height);
            x10 = kotlin.collections.i.x(this.f36969w);
            this.f36969w = x10;
        }
        RectF rectF2 = this.f36964r;
        LinearGradient linearGradient = new LinearGradient(rectF2.left, rectF2.top, rectF2.right, rectF2.bottom, this.f36969w, this.f36970x, Shader.TileMode.CLAMP);
        this.f36958l = linearGradient;
        this.f36951e.setShader(linearGradient);
        int length = this.f36971y.length - 1;
        if (length >= 0) {
            int i15 = 0;
            while (true) {
                int i16 = i15 + 1;
                int i17 = this.f36971y[i15];
                if (i17 > 0) {
                    com.mobvoi.companion.health.widget.arty.a aVar = com.mobvoi.companion.health.widget.arty.a.f17142a;
                    this.f36960n = aVar.l(this.f36962p, i17);
                    if (i15 == 0 || ((this.f36962p == 0 && i17 > this.f36961o.c()) || ((this.f36962p == 2 && i17 > this.f36961o.c()) || ((this.f36962p == 3 && i17 < this.f36961o.c()) || ((this.f36962p == 4 && i17 < this.f36961o.c()) || (this.f36962p == 1 && i17 < this.f36961o.c())))))) {
                        b(i17, i15, this.f36960n);
                    }
                    this.f36955i = ((getWidth() - (this.f36950d.getStrokeWidth() * 7)) / 11.0f) + this.f36950d.getStrokeWidth();
                    float f11 = this.f36955i;
                    float width = ((getWidth() / 2) - (3 * f11)) + (i15 * f11);
                    float height2 = getHeight() - getResources().getDimension(R.dimen.arty_card_graph_bar_margin_bottom);
                    float dimension2 = height2 - ((getResources().getDimension(R.dimen.arty_card_graph_bar_max_height) * i17) / 100.0f);
                    int[] iArr = {aVar.j()[this.f36960n], aVar.i()[this.f36960n]};
                    this.f36959m[i15] = new LinearGradient(width, height2, width, dimension2, iArr[0], iArr[1], Shader.TileMode.CLAMP);
                }
                if (i16 <= length) {
                    i15 = i16;
                } else {
                    return;
                }
            }
        }
    }

    public final void setData(ArtyType artyType) {
        i.f(artyType, "artyType");
        setArtyDataType(artyType);
        this.f36961o.d();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        i.f(context, "context");
        this.f36947a = LogCleaner.ONE_DAY;
        this.f36948b = new TextPaint();
        this.f36949c = new TextPaint();
        this.f36950d = new Paint(1);
        this.f36951e = new Paint(1);
        this.f36952f = new Paint(1);
        this.f36953g = getResources().getDimension(R.dimen.arty_card_graph_dash_line_width);
        float f10 = this.f36953g;
        this.f36954h = new DashPathEffect(new float[]{f10, f10}, 0.0f);
        this.f36955i = getResources().getDimension(R.dimen.arty_card_graph_bar_interval);
        Resources resources = getResources();
        int i11 = R.dimen.arty_card_graph_dash_line_height;
        this.f36956j = resources.getDimension(i11);
        this.f36957k = getResources().getDimension(R.dimen.arty_card_graph_opt_range_height);
        this.f36959m = new LinearGradient[7];
        this.f36963q = "";
        this.f36964r = new RectF();
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.ic_arty_value_bg_green);
        i.e(decodeResource, "decodeResource(resources, R.drawable.ic_arty_value_bg_green)");
        Bitmap decodeResource2 = BitmapFactory.decodeResource(getResources(), R.drawable.ic_arty_value_bg_blue);
        i.e(decodeResource2, "decodeResource(resources, R.drawable.ic_arty_value_bg_blue)");
        Bitmap decodeResource3 = BitmapFactory.decodeResource(getResources(), R.drawable.ic_arty_value_bg_yellow);
        i.e(decodeResource3, "decodeResource(resources, R.drawable.ic_arty_value_bg_yellow)");
        Bitmap decodeResource4 = BitmapFactory.decodeResource(getResources(), R.drawable.ic_arty_value_bg_red);
        i.e(decodeResource4, "decodeResource(resources, R.drawable.ic_arty_value_bg_red)");
        this.f36967u = new Bitmap[]{decodeResource, decodeResource2, decodeResource3, decodeResource4};
        this.f36968v = new int[7];
        this.f36969w = new int[]{getResources().getColor(R.color.arty_card_score_opt_range_start_color, null), getResources().getColor(R.color.arty_card_score_opt_range_middle_color, null), getResources().getColor(R.color.arty_card_score_opt_range_end_color, null)};
        this.f36970x = new float[]{0.0f, 0.5f, 1.0f};
        this.f36971y = new int[7];
        this.f36948b.setStyle(Paint.Style.FILL);
        this.f36948b.setAntiAlias(true);
        this.f36948b.setTextAlign(Paint.Align.CENTER);
        this.f36949c.setStyle(Paint.Style.FILL);
        this.f36949c.setAntiAlias(true);
        this.f36949c.setTextAlign(Paint.Align.LEFT);
        this.f36949c.setTextSize(getResources().getDimension(R.dimen.arty_card_graph_score_trend_size));
        this.f36949c.setColor(getResources().getColor(R.color.black, null));
        this.f36950d.setStyle(Paint.Style.FILL);
        this.f36950d.setStrokeCap(Paint.Cap.ROUND);
        this.f36950d.setStrokeWidth(getResources().getDimension(R.dimen.arty_card_graph_bar_stroke_width));
        this.f36951e.setStyle(Paint.Style.FILL);
        this.f36951e.setAntiAlias(true);
        this.f36952f.setStyle(Paint.Style.STROKE);
        this.f36952f.setPathEffect(this.f36954h);
        this.f36952f.setColor(getResources().getColor(R.color.arty_card_score_opt_range_color, null));
        this.f36952f.setStrokeWidth(getResources().getDimension(i11));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(DimensionUtils.dp2px(context, 20.0f));
        gradientDrawable.setStroke((int) this.f36956j, getResources().getColor(R.color.home_tab_card_arty_chart_bg, null));
        setBackground(gradientDrawable);
        this.f36965s = j7.a.e(this, R.attr.colorPrimaryInverse, -16777216);
        this.f36966t = j7.a.e(this, R.attr.colorOnSurfaceVariant, -7829368);
        this.f36961o = new a();
    }
}
