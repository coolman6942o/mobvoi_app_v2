package yc;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cardiex.arty.lite.models.coach.ArtyComponent;
import com.cardiex.arty.lite.models.coach.ArtyScore;
import com.mobvoi.companion.R;
import com.mobvoi.wear.util.DimensionUtils;
import java.util.Objects;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import zc.a;
/* compiled from: ArtyScoreSubComponentView.kt */
/* loaded from: classes2.dex */
public final class l extends View implements k {

    /* renamed from: a  reason: collision with root package name */
    private final Context f36986a;

    /* renamed from: b  reason: collision with root package name */
    private final Paint f36987b;

    /* renamed from: c  reason: collision with root package name */
    private final Paint f36988c;

    /* renamed from: d  reason: collision with root package name */
    private float f36989d;

    /* renamed from: e  reason: collision with root package name */
    private final float f36990e;

    /* renamed from: f  reason: collision with root package name */
    private final Bitmap[] f36991f;

    /* renamed from: g  reason: collision with root package name */
    private final int[] f36992g;

    /* renamed from: h  reason: collision with root package name */
    private final int[] f36993h;

    /* renamed from: i  reason: collision with root package name */
    private final double[] f36994i;

    /* renamed from: j  reason: collision with root package name */
    private double f36995j;

    /* renamed from: k  reason: collision with root package name */
    private final int[] f36996k;

    public /* synthetic */ l(Context context, AttributeSet attributeSet, int i10, int i11, f fVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    @Override // yc.k
    public void c(a dataArty) {
        double[] dArr;
        i.f(dataArty, "dataArty");
        if (dataArty.c() instanceof ArtyScore) {
            Object c10 = dataArty.c();
            Objects.requireNonNull(c10, "null cannot be cast to non-null type com.cardiex.arty.lite.models.coach.ArtyScore");
            ArtyScore artyScore = (ArtyScore) c10;
            double[] dArr2 = this.f36994i;
            ArtyComponent truHr = artyScore.getTruHr();
            double d10 = 0.0d;
            dArr2[0] = truHr == null ? 0.0d : truHr.getValue();
            double[] dArr3 = this.f36994i;
            ArtyComponent hsx = artyScore.getHsx();
            dArr3[1] = hsx == null ? 0.0d : hsx.getValue();
            double[] dArr4 = this.f36994i;
            ArtyComponent eCap = artyScore.getECap();
            dArr4[2] = eCap == null ? 0.0d : eCap.getValue();
            ArtyComponent age = artyScore.getAge();
            this.f36995j = age == null ? 0.0d : age.getSpread();
            double[] dArr5 = this.f36994i;
            ArtyComponent age2 = artyScore.getAge();
            if (age2 != null) {
                d10 = age2.getValue();
            }
            dArr5[3] = d10;
            int i10 = 0;
            for (double d11 : this.f36994i) {
                i10++;
                if (i10 == 3) {
                    Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), this.f36992g[com.mobvoi.companion.health.widget.arty.a.f17142a.l(2, (int) d11)]);
                    i.e(decodeResource, "decodeResource(resources, mArtyECapEnable[colorIndex])");
                    this.f36991f[i10 - 1] = decodeResource;
                } else if (i10 == 2) {
                    Bitmap decodeResource2 = BitmapFactory.decodeResource(getResources(), this.f36993h[com.mobvoi.companion.health.widget.arty.a.f17142a.l(3, (int) d11)]);
                    i.e(decodeResource2, "decodeResource(resources, mArtyHsxEnable[colorIndex])");
                    this.f36991f[i10 - 1] = decodeResource2;
                }
            }
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
            ((ViewGroup.MarginLayoutParams) bVar).width = 0;
            ((ViewGroup.MarginLayoutParams) bVar).height = 0;
            bVar.V = true;
            bVar.W = true;
            bVar.Q = 0.755f;
            bVar.R = 0.375f;
            setLayoutParams(bVar);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i10;
        int i11;
        i.f(canvas, "canvas");
        int i12 = 0;
        int width = this.f36991f[0].getWidth();
        this.f36989d = (((getWidth() - getPaddingLeft()) - getPaddingRight()) - (width * 4)) / 5.0f;
        this.f36987b.setTextSize(getResources().getDimension(R.dimen.arty_score_sub_component_value_size));
        float height = (((getHeight() - width) - (this.f36987b.getFontMetrics().descent - this.f36987b.getFontMetrics().ascent)) - ((this.f36988c.getFontMetrics().descent - this.f36988c.getFontMetrics().ascent) - this.f36990e)) / 2;
        float f10 = this.f36987b.getFontMetrics().descent - this.f36987b.getFontMetrics().ascent;
        int length = this.f36991f.length - 1;
        if (length >= 0) {
            while (true) {
                int i13 = i12 + 1;
                Bitmap bitmap = this.f36991f[i12];
                float f11 = this.f36989d;
                float width2 = f11 + ((bitmap.getWidth() + f11) * i12);
                canvas.drawBitmap(bitmap, width2, height, this.f36987b);
                String valueOf = String.valueOf((int) this.f36994i[i12]);
                float height2 = ((bitmap.getHeight() + height) - this.f36987b.getFontMetrics().ascent) - this.f36990e;
                if (i12 == 3) {
                    double[] dArr = this.f36994i;
                    double d10 = dArr[i12];
                    double d11 = this.f36995j;
                    i11 = length;
                    i10 = i13;
                    double d12 = 2.0f;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append((int) (d10 - (d11 / d12)));
                    sb2.append('-');
                    sb2.append((int) (dArr[i12] + (d11 / d12)));
                    valueOf = sb2.toString();
                    this.f36987b.setTextSize(getResources().getDimension(R.dimen.arty_card_score_name_text_size));
                    height2 += this.f36987b.getFontMetrics().descent / 8;
                } else {
                    i11 = length;
                    i10 = i13;
                }
                canvas.drawText(valueOf, (bitmap.getWidth() / 2) + width2, height2, this.f36987b);
                canvas.drawText(this.f36986a.getString(this.f36996k[i12]), (bitmap.getWidth() / 2) + width2, (((bitmap.getHeight() + height) + f10) - this.f36988c.getFontMetrics().ascent) - this.f36990e, this.f36988c);
                int i14 = i11;
                int i15 = i10;
                if (i15 <= i14) {
                    length = i14;
                    i12 = i15;
                } else {
                    return;
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(Context mContext, AttributeSet attributeSet, int i10) {
        super(mContext, attributeSet, i10);
        i.f(mContext, "mContext");
        this.f36986a = mContext;
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.icon_truhr_enable);
        i.e(decodeResource, "decodeResource(resources, R.drawable.icon_truhr_enable)");
        Resources resources = getResources();
        int i11 = R.drawable.ic_ecap_small_green;
        Bitmap decodeResource2 = BitmapFactory.decodeResource(resources, i11);
        i.e(decodeResource2, "decodeResource(resources, R.drawable.ic_ecap_small_green)");
        Resources resources2 = getResources();
        int i12 = R.drawable.ic_hsx_small_green;
        Bitmap decodeResource3 = BitmapFactory.decodeResource(resources2, i12);
        i.e(decodeResource3, "decodeResource(resources, R.drawable.ic_hsx_small_green)");
        Bitmap decodeResource4 = BitmapFactory.decodeResource(getResources(), R.drawable.icon_arty_age_enable);
        i.e(decodeResource4, "decodeResource(resources, R.drawable.icon_arty_age_enable)");
        this.f36991f = new Bitmap[]{decodeResource, decodeResource2, decodeResource3, decodeResource4};
        this.f36992g = new int[]{i11, R.drawable.ic_ecap_small_blue, R.drawable.ic_ecap_small_yellow, R.drawable.ic_ecap_small_red};
        this.f36993h = new int[]{i12, R.drawable.ic_hsx_small_blue, R.drawable.ic_hsx_small_yellow, R.drawable.ic_hsx_small_red};
        this.f36994i = new double[4];
        int i13 = R.string.arty_component_unit_percent;
        this.f36996k = new int[]{R.string.arty_component_unit_bpm, i13, i13, R.string.arty_component_unit_years};
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(DimensionUtils.dp2px(mContext, 20.0f));
        gradientDrawable.setStroke((int) DimensionUtils.dp2px(mContext, 2.0f), getResources().getColor(R.color.home_tab_card_arty_chart_bg));
        setBackground(gradientDrawable);
        Paint paint = new Paint();
        this.f36987b = paint;
        paint.setColor(j7.a.e(this, R.attr.colorPrimaryInverse, -16777216));
        paint.setTextSize(getResources().getDimension(R.dimen.arty_score_sub_component_value_size));
        paint.setStyle(Paint.Style.FILL);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f36988c = paint2;
        paint2.setColor(j7.a.e(this, R.attr.colorOnSurfaceVariant, -7829368));
        paint2.setTextSize(getResources().getDimension(R.dimen.arty_score_sub_component_unit_size));
        paint2.setStyle(Paint.Style.FILL);
        paint2.setTextAlign(Paint.Align.CENTER);
        paint2.setAntiAlias(true);
        this.f36990e = getResources().getDimension(R.dimen.arty_score_sub_component_value_translate_top);
    }
}
