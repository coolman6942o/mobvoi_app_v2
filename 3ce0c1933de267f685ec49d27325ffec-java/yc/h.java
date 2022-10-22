package yc;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bumptech.glide.c;
import com.mobvoi.companion.R;
import com.mobvoi.wear.util.DimensionUtils;
import java.util.Objects;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import zc.a;
/* compiled from: ArtyCardPlayVideoView.kt */
/* loaded from: classes2.dex */
public final class h extends ConstraintLayout implements k {

    /* renamed from: u  reason: collision with root package name */
    private m f36979u;

    /* renamed from: v  reason: collision with root package name */
    private ImageView f36980v;

    public /* synthetic */ h(Context context, AttributeSet attributeSet, int i10, int i11, f fVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(h this$0, ImageView artyStartPlayVideoView, View view) {
        i.f(this$0, "this$0");
        i.f(artyStartPlayVideoView, "$artyStartPlayVideoView");
        this$0.f36979u.a();
        this$0.f36980v.setVisibility(8);
        artyStartPlayVideoView.setVisibility(8);
    }

    @Override // yc.k
    public void c(a dataArty) {
        i.f(dataArty, "dataArty");
        if (dataArty.c() instanceof String) {
            Object c10 = dataArty.c();
            Objects.requireNonNull(c10, "null cannot be cast to non-null type kotlin.String");
            String str = (String) c10;
            this.f36979u.setDataSource(str);
            c.u(getContext()).w(new j5.c().k(0L).c()).r(str).u0(this.f36980v);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        i.f(context, "context");
        this.f36979u = new m(context, null, 0, 6, null);
        this.f36980v = new ImageView(context);
        ConstraintLayout.b bVar = new ConstraintLayout.b(-1, -1);
        bVar.f1790d = 0;
        bVar.f1798h = 0;
        bVar.f1796g = 0;
        bVar.f1804k = 0;
        this.f36979u.setLayoutParams(bVar);
        addView(this.f36979u);
        ConstraintLayout.b bVar2 = new ConstraintLayout.b(-1, -1);
        bVar2.f1790d = 0;
        bVar2.f1798h = 0;
        bVar2.f1796g = 0;
        bVar2.f1804k = 0;
        this.f36980v.setLayoutParams(bVar2);
        addView(this.f36980v);
        TextView textView = new TextView(context);
        textView.setText(R.string.arty_card_skip_video);
        textView.setTextSize(2, 14.0f);
        textView.setTextColor(getResources().getColor(R.color.white, null));
        textView.setBackground(getResources().getDrawable(R.drawable.arty_text_under_line, null));
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        ConstraintLayout.b bVar3 = new ConstraintLayout.b(-2, -2);
        bVar3.f1796g = 0;
        bVar3.f1798h = 0;
        ((ViewGroup.MarginLayoutParams) bVar3).topMargin = (int) DimensionUtils.dp2px(context, 16.0f);
        ((ViewGroup.MarginLayoutParams) bVar3).rightMargin = (int) DimensionUtils.dp2px(context, 18.0f);
        textView.setLayoutParams(bVar3);
        addView(textView);
        final ImageView imageView = new ImageView(context);
        imageView.setImageResource(R.drawable.arty_play_icon);
        ConstraintLayout.b bVar4 = new ConstraintLayout.b(-2, -2);
        bVar4.f1790d = 0;
        bVar4.f1796g = 0;
        bVar4.f1798h = 0;
        bVar4.f1804k = 0;
        imageView.setLayoutParams(bVar4);
        imageView.setOnClickListener(new View.OnClickListener() { // from class: yc.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                h.F(h.this, imageView, view);
            }
        });
        addView(imageView);
    }
}
