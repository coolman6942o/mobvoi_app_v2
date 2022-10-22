package yc;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.mobvoi.companion.R;
import com.mobvoi.wear.util.DimensionUtils;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import zc.a;
/* compiled from: ArtyCardTakeReadingView.kt */
/* loaded from: classes2.dex */
public final class j extends ConstraintLayout implements k {

    /* renamed from: u  reason: collision with root package name */
    private final Context f36985u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(Context mContext, AttributeSet attributeSet, int i10) {
        super(mContext, attributeSet, i10);
        i.f(mContext, "mContext");
        this.f36985u = mContext;
        E();
    }

    private final void E() {
        setBackgroundResource(R.drawable.arty_home_card_arty_chart_shape);
        ImageView imageView = new ImageView(this.f36985u);
        int i10 = R.id.arty_home_card_take_reading_guide_iv;
        imageView.setId(i10);
        imageView.setBackgroundResource(R.drawable.ic_arty_take_reading);
        ConstraintLayout.b bVar = new ConstraintLayout.b(-2, -1);
        ((ViewGroup.MarginLayoutParams) bVar).leftMargin = (int) DimensionUtils.dp2px(this.f36985u, 32.0f);
        bVar.f1790d = 0;
        bVar.f1798h = 0;
        imageView.setLayoutParams(bVar);
        addView(imageView);
        TextView textView = new TextView(this.f36985u);
        textView.setText(getResources().getString(R.string.arty_tips_take_reading_guide));
        textView.setTextSize(2, 14.0f);
        ConstraintLayout.b bVar2 = new ConstraintLayout.b(0, -2);
        bVar2.f1798h = 0;
        bVar2.f1804k = 0;
        bVar2.f1792e = i10;
        bVar2.f1796g = 0;
        ((ViewGroup.MarginLayoutParams) bVar2).leftMargin = (int) DimensionUtils.dp2px(this.f36985u, 21.0f);
        ((ViewGroup.MarginLayoutParams) bVar2).rightMargin = (int) DimensionUtils.dp2px(this.f36985u, 26.0f);
        textView.setLayoutParams(bVar2);
        addView(textView);
    }

    @Override // yc.k
    public void c(a dataArty) {
        i.f(dataArty, "dataArty");
    }

    public /* synthetic */ j(Context context, AttributeSet attributeSet, int i10, int i11, f fVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
