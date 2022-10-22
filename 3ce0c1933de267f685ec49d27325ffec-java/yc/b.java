package yc;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cardiex.arty.lite.models.coach.ArtyComponent;
import com.cardiex.arty.lite.models.coach.ArtyType;
import com.mobvoi.companion.R;
import gg.d;
import io.m;
import java.util.Objects;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
/* compiled from: ArtyCardComponentView.kt */
/* loaded from: classes2.dex */
public final class b extends View implements k {
    private float A;
    private float B;
    private int C;
    private float D;

    /* renamed from: a  reason: collision with root package name */
    private String f36917a;

    /* renamed from: b  reason: collision with root package name */
    private String f36918b;

    /* renamed from: c  reason: collision with root package name */
    private int f36919c;

    /* renamed from: d  reason: collision with root package name */
    private int f36920d;

    /* renamed from: e  reason: collision with root package name */
    private float f36921e;

    /* renamed from: f  reason: collision with root package name */
    private float f36922f;

    /* renamed from: g  reason: collision with root package name */
    private float f36923g;

    /* renamed from: h  reason: collision with root package name */
    private float f36924h;

    /* renamed from: i  reason: collision with root package name */
    private float f36925i;

    /* renamed from: j  reason: collision with root package name */
    private float f36926j;

    /* renamed from: k  reason: collision with root package name */
    private float f36927k;

    /* renamed from: l  reason: collision with root package name */
    private float f36928l;

    /* renamed from: m  reason: collision with root package name */
    private int f36929m;

    /* renamed from: n  reason: collision with root package name */
    private String f36930n;

    /* renamed from: o  reason: collision with root package name */
    private final Paint f36931o;

    /* renamed from: p  reason: collision with root package name */
    private final Paint f36932p;

    /* renamed from: q  reason: collision with root package name */
    private final RectF f36933q;

    /* renamed from: r  reason: collision with root package name */
    private SweepGradient f36934r;

    /* renamed from: s  reason: collision with root package name */
    private LinearGradient f36935s;

    /* renamed from: t  reason: collision with root package name */
    private int f36936t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f36937u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f36938v;

    /* renamed from: w  reason: collision with root package name */
    private boolean f36939w;

    /* renamed from: x  reason: collision with root package name */
    private Bitmap f36940x;

    /* renamed from: y  reason: collision with root package name */
    private float f36941y;

    /* renamed from: z  reason: collision with root package name */
    private float f36942z;

    /* compiled from: ArtyCardComponentView.kt */
    /* loaded from: classes2.dex */
    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f36943a;

        static {
            int[] iArr = new int[ArtyType.values().length];
            iArr[ArtyType.ARTY.ordinal()] = 1;
            iArr[ArtyType.TRU_HR.ordinal()] = 2;
            iArr[ArtyType.E_CAP.ordinal()] = 3;
            iArr[ArtyType.HSX.ordinal()] = 4;
            iArr[ArtyType.AGE.ordinal()] = 5;
            f36943a = iArr;
        }
    }

    public /* synthetic */ b(Context context, AttributeSet attributeSet, int i10, int i11, f fVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    private final void a(ArtyComponent artyComponent) {
        int value = (int) artyComponent.getValue();
        this.f36920d = value;
        this.f36930n = String.valueOf(value);
        if (artyComponent.getArtyType() == ArtyType.AGE) {
            double d10 = 2;
            int spread = (int) (this.f36920d - (artyComponent.getSpread() / d10));
            int spread2 = (int) (this.f36920d + (artyComponent.getSpread() / d10));
            if (spread != spread2) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(spread);
                sb2.append('-');
                sb2.append(spread2);
                this.f36930n = sb2.toString();
            }
        }
        this.f36929m = d.a(com.mobvoi.companion.health.widget.arty.a.f17142a.a(artyComponent.getArtyType()), this.f36920d);
        b();
        ArtyType artyType = artyComponent.getArtyType();
        int i10 = artyType == null ? -1 : a.f36943a[artyType.ordinal()];
        if (i10 == 1) {
            e();
            this.f36936t = 0;
            String string = getResources().getString(R.string.arty_card_total_value);
            i.e(string, "resources.getString(R.string.arty_card_total_value)");
            this.f36917a = string;
            String string2 = getResources().getString(R.string.arty_card_component_score_name);
            i.e(string2, "resources.getString(R.string.arty_card_component_score_name)");
            this.f36918b = string2;
            this.f36938v = true;
            if (this.f36937u) {
                this.f36928l = getResources().getDimension(R.dimen.arty_card_score_stroke_width);
                this.f36924h = getResources().getDimension(R.dimen.arty_card_score_value_text_size);
            } else {
                this.f36928l = getResources().getDimension(R.dimen.arty_card_score_min_stroke_width);
                this.f36924h = getResources().getDimension(R.dimen.arty_card_score_min_value_text_size);
                this.f36925i = getResources().getDimension(R.dimen.arty_card_score_min_value_unit_size);
            }
            this.f36932p.setStrokeWidth(this.f36928l);
        } else if (i10 == 2) {
            this.f36936t = 1;
            String string3 = getResources().getString(R.string.arty_component_unit_bpm);
            i.e(string3, "resources.getString(R.string.arty_component_unit_bpm)");
            this.f36917a = string3;
            String string4 = getResources().getString(R.string.arty_card_component_truhr_name);
            i.e(string4, "resources.getString(R.string.arty_card_component_truhr_name)");
            this.f36918b = string4;
            this.f36941y = 0.8f;
            if (this.f36937u) {
                this.f36924h = getResources().getDimension(R.dimen.arty_card_score_value_text_size);
                return;
            }
            this.f36940x = BitmapFactory.decodeResource(getResources(), R.drawable.ic_home_card_large_truhr);
            this.f36924h = getResources().getDimension(R.dimen.arty_card_score_min_value_text_size);
            this.f36925i = getResources().getDimension(R.dimen.arty_card_ecap_min_value_unit_size);
            this.D = 0.2f;
        } else if (i10 == 3) {
            e();
            this.f36936t = 2;
            String string5 = getResources().getString(R.string.arty_component_unit_percent);
            i.e(string5, "resources.getString(R.string.arty_component_unit_percent)");
            this.f36917a = string5;
            String string6 = getResources().getString(R.string.arty_card_component_ecap_name);
            i.e(string6, "resources.getString(R.string.arty_card_component_ecap_name)");
            this.f36918b = string6;
            this.f36938v = true;
            if (this.f36937u) {
                this.f36928l = getResources().getDimension(R.dimen.arty_card_score_stroke_width);
                this.f36924h = getResources().getDimension(R.dimen.arty_card_score_value_text_size);
            } else {
                this.f36928l = getResources().getDimension(R.dimen.arty_card_score_min_stroke_width);
                this.f36924h = getResources().getDimension(R.dimen.arty_card_ecap_min_value_text_size);
                this.f36925i = getResources().getDimension(R.dimen.arty_card_ecap_min_value_unit_size);
                this.f36940x = BitmapFactory.decodeResource(getResources(), R.drawable.ic_home_card_ecap);
                this.D = 0.25f;
            }
            this.f36932p.setStrokeWidth(this.f36928l);
        } else if (i10 == 4) {
            this.f36936t = 3;
            String string7 = getResources().getString(R.string.arty_component_unit_percent);
            i.e(string7, "resources.getString(R.string.arty_component_unit_percent)");
            this.f36917a = string7;
            String string8 = getResources().getString(R.string.arty_card_component_hsx_name);
            i.e(string8, "resources.getString(R.string.arty_card_component_hsx_name)");
            this.f36918b = string8;
            this.f36939w = true;
            if (this.f36937u) {
                this.f36942z = 0.2f;
                this.f36941y = 0.7f;
                this.A = 0.95f;
                this.f36928l = getResources().getDimension(R.dimen.arty_card_hsx_pg_stroke_width);
                this.f36924h = getResources().getDimension(R.dimen.arty_card_score_value_text_size);
                this.f36925i = getResources().getDimension(R.dimen.arty_card_hsx_unit_large_text_size);
            } else {
                this.f36928l = getResources().getDimension(R.dimen.arty_card_hsx_pg_stroke_min_width);
                this.f36940x = BitmapFactory.decodeResource(getResources(), R.drawable.ic_home_card_large_hsx);
                this.f36924h = getResources().getDimension(R.dimen.arty_card_score_min_value_text_size);
                this.f36925i = getResources().getDimension(R.dimen.arty_card_ecap_min_value_unit_size);
                this.D = 0.18f;
            }
            this.f36932p.setStrokeWidth(this.f36928l);
        } else if (i10 == 5) {
            this.f36936t = 4;
            String string9 = getResources().getString(R.string.arty_component_unit_years);
            i.e(string9, "resources.getString(R.string.arty_component_unit_years)");
            this.f36917a = string9;
            String string10 = getResources().getString(R.string.arty_card_component_artyAge_name);
            i.e(string10, "resources.getString(R.string.arty_card_component_artyAge_name)");
            this.f36918b = string10;
            this.f36941y = 0.8f;
            if (this.f36937u) {
                this.f36924h = getResources().getDimension(R.dimen.arty_card_age_value_text_size);
                return;
            }
            this.f36940x = BitmapFactory.decodeResource(getResources(), R.drawable.ic_home_card_large_arty_age);
            this.f36924h = getResources().getDimension(R.dimen.arty_card_age_min_value_text_size);
            this.f36925i = getResources().getDimension(R.dimen.arty_card_ecap_min_value_unit_size);
            this.D = 0.2f;
        }
    }

    private final void b() {
        if (this.f36937u) {
            this.f36923g = getResources().getDimension(R.dimen.arty_card_score_name_text_size);
            this.f36925i = getResources().getDimension(R.dimen.arty_card_score_total_value_size);
            this.f36926j = getResources().getDimension(R.dimen.arty_card_score_name_translate);
            this.f36927k = getResources().getDimension(R.dimen.arty_card_score_total_value_translate);
            return;
        }
        this.f36923g = getResources().getDimension(R.dimen.arty_card_score_min_name_text_size);
        this.f36926j = getResources().getDimension(R.dimen.arty_card_score_min_name_translate);
        this.f36927k = -getResources().getDimension(R.dimen.arty_card_score_min_total_value_translate);
    }

    @Override // yc.k
    public void c(zc.a dataArty) {
        i.f(dataArty, "dataArty");
        if (dataArty.c() instanceof ArtyComponent) {
            Object c10 = dataArty.c();
            Objects.requireNonNull(c10, "null cannot be cast to non-null type com.cardiex.arty.lite.models.coach.ArtyComponent");
            ArtyComponent artyComponent = (ArtyComponent) c10;
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
            ((ViewGroup.MarginLayoutParams) bVar).width = 0;
            ((ViewGroup.MarginLayoutParams) bVar).height = 0;
            bVar.F = "1:1";
            bVar.V = true;
            int a10 = dataArty.a();
            if (a10 == 1) {
                this.f36937u = true;
                bVar.Q = 0.673f;
            } else if (a10 == 4) {
                this.f36937u = false;
                bVar.Q = 0.402f;
            }
            a(artyComponent);
            setLayoutParams(bVar);
        }
    }

    public final void d() {
        com.mobvoi.companion.health.widget.arty.a aVar = com.mobvoi.companion.health.widget.arty.a.f17142a;
        this.f36919c = aVar.l(3, this.f36920d);
        int[] iArr = {aVar.i()[this.f36919c], aVar.j()[this.f36919c]};
        float f10 = 2;
        this.f36935s = new LinearGradient(0.0f, this.C - (this.f36928l / f10), (getWidth() * this.f36920d) / 100.0f, this.C - (this.f36928l / f10), iArr[1], iArr[0], Shader.TileMode.CLAMP);
    }

    public final void e() {
        com.mobvoi.companion.health.widget.arty.a aVar = com.mobvoi.companion.health.widget.arty.a.f17142a;
        this.f36919c = aVar.l(0, this.f36920d);
        int[] iArr = {aVar.i()[this.f36919c], aVar.j()[this.f36919c]};
        Matrix matrix = new Matrix();
        matrix.setRotate(90.0f, this.f36921e, this.f36922f);
        SweepGradient sweepGradient = new SweepGradient(this.f36921e, this.f36922f, iArr, (float[]) null);
        this.f36934r = sweepGradient;
        sweepGradient.setLocalMatrix(matrix);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f10;
        Bitmap bitmap;
        i.f(canvas, "canvas");
        super.onDraw(canvas);
        this.f36921e = getWidth() / 2.0f;
        m mVar = null;
        if (this.f36938v) {
            this.f36932p.setShader(null);
            this.f36932p.setColor(getResources().getColor(R.color.arty_pb_bg_color, null));
            this.f36922f = getHeight() / 2.0f;
            float width = (getWidth() / 2.0f) - (this.f36928l / 2);
            canvas.drawCircle(this.f36921e, this.f36922f, width, this.f36932p);
            if (this.f36920d > 0) {
                RectF rectF = this.f36933q;
                float f11 = this.f36921e;
                float f12 = this.f36922f;
                rectF.set(f11 - width, f12 - width, f11 + width, f12 + width);
                this.f36932p.setStrokeCap(Paint.Cap.ROUND);
                Paint paint = this.f36932p;
                SweepGradient sweepGradient = this.f36934r;
                if (sweepGradient != null) {
                    paint.setShader(sweepGradient);
                    canvas.drawArc(this.f36933q, 90.0f, (this.f36920d * 360.0f) / 100, false, this.f36932p);
                } else {
                    i.u("mSweepGradient");
                    throw null;
                }
            }
        }
        if (this.f36939w) {
            this.f36932p.setShader(null);
            this.f36932p.setStrokeCap(Paint.Cap.ROUND);
            this.f36932p.setColor(getResources().getColor(R.color.arty_pb_bg_color, null));
            float f13 = this.f36928l;
            float height = (getHeight() * this.A) - (f13 / 2);
            canvas.drawLine(f13, height, getWidth() - this.f36928l, height, this.f36932p);
            if (this.f36920d > 0) {
                Paint paint2 = this.f36932p;
                LinearGradient linearGradient = this.f36935s;
                if (linearGradient != null) {
                    paint2.setShader(linearGradient);
                    float f14 = this.f36928l;
                    canvas.drawLine(this.f36928l, height, (((float) (getWidth() * this.f36920d)) / 100.0f) - f14 <= 0.0f ? f14 : ((getWidth() * this.f36920d) / 100.0f) - this.f36928l, height, this.f36932p);
                } else {
                    i.u("mLinearGradient");
                    throw null;
                }
            }
        }
        Bitmap bitmap2 = this.f36940x;
        if (bitmap2 != null) {
            canvas.drawBitmap(bitmap2, (getWidth() / 2.0f) - (bitmap2.getWidth() / 2.0f), this.B, this.f36931o);
            mVar = m.f28349a;
        }
        if (mVar == null) {
            this.f36931o.setTextSize(this.f36923g);
            this.f36931o.setColor(j7.a.e(this, R.attr.colorPrimaryInverse, -16777216));
            this.f36931o.setTextAlign(Paint.Align.CENTER);
            Paint.FontMetrics fontMetrics = this.f36931o.getFontMetrics();
            float f15 = 2;
            canvas.drawText(this.f36918b, this.f36921e, (((getHeight() * this.f36942z) + ((fontMetrics.bottom - fontMetrics.top) / f15)) - ((fontMetrics.descent + fontMetrics.ascent) / f15)) - this.f36926j, this.f36931o);
        }
        this.f36931o.setTextSize(this.f36924h);
        this.f36931o.setTextAlign(Paint.Align.CENTER);
        Paint.FontMetrics fontMetrics2 = this.f36931o.getFontMetrics();
        int i10 = this.f36936t;
        if (i10 == 2 || i10 == 1 || i10 == 4) {
            f10 = (getHeight() / 2.0f) - (fontMetrics2.ascent / 2);
        } else {
            float f16 = fontMetrics2.descent;
            f10 = ((getHeight() / 2.0f) + ((f16 - fontMetrics2.ascent) / 2)) - f16;
        }
        if (this.f36920d > 0) {
            canvas.drawText(this.f36930n, this.f36921e, f10, this.f36931o);
        } else {
            canvas.drawText("-", this.f36921e, f10, this.f36931o);
        }
        this.f36931o.setTextSize(this.f36925i);
        this.f36931o.setColor(j7.a.e(this, R.attr.colorOnSurfaceVariant, -7829368));
        this.f36931o.setTextAlign(Paint.Align.LEFT);
        float measureText = this.f36931o.measureText(this.f36917a);
        com.mobvoi.companion.health.widget.arty.a aVar = com.mobvoi.companion.health.widget.arty.a.f17142a;
        float width2 = aVar.k()[this.f36919c].getWidth();
        float dimension = getResources().getDimension(R.dimen.arty_card_score_value_rise_margin);
        Paint.FontMetrics fontMetrics3 = this.f36931o.getFontMetrics();
        float height2 = getHeight() * this.f36941y;
        float f17 = fontMetrics3.descent;
        float f18 = 2;
        float f19 = ((height2 + ((f17 - fontMetrics3.ascent) / f18)) - f17) - this.f36927k;
        int i11 = this.f36929m;
        if (i11 != 0) {
            float f20 = measureText + dimension + width2;
            if (i11 > 0) {
                bitmap = aVar.k()[this.f36919c];
            } else {
                bitmap = aVar.f()[this.f36919c];
            }
            canvas.drawBitmap(bitmap, (this.f36921e - (f20 / f18)) + measureText + dimension, f19 - aVar.k()[this.f36919c].getHeight(), this.f36931o);
            measureText = f20;
        }
        canvas.drawText(this.f36917a, this.f36921e - (measureText / f18), f19, this.f36931o);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i10, int i11, int i12, int i13) {
        super.onSizeChanged(i10, i11, i12, i13);
        this.C = i11;
        Bitmap bitmap = this.f36940x;
        if (bitmap != null) {
            this.B = (i11 * this.D) - (bitmap.getWidth() / 2);
        }
        if (this.f36936t == 3) {
            d();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        i.f(context, "context");
        String string = getResources().getString(R.string.arty_card_total_value);
        i.e(string, "resources.getString(R.string.arty_card_total_value)");
        this.f36917a = string;
        String string2 = getResources().getString(R.string.arty_card_component_score_name);
        i.e(string2, "resources.getString(R.string.arty_card_component_score_name)");
        this.f36918b = string2;
        this.f36930n = "";
        Paint paint = new Paint(1);
        this.f36931o = paint;
        Paint paint2 = new Paint(1);
        this.f36932p = paint2;
        this.f36941y = 0.75f;
        this.f36942z = 0.25f;
        this.A = 1.0f;
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint2.setAntiAlias(true);
        paint2.setStyle(Paint.Style.STROKE);
        this.f36933q = new RectF();
    }
}
