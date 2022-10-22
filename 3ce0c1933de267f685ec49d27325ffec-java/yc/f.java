package yc;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.c;
import com.mobvoi.companion.R;
import kotlin.jvm.internal.i;
import rc.b;
/* compiled from: ArtyCardGuideView.kt */
/* loaded from: classes2.dex */
public final class f extends ConstraintLayout {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        i.f(context, "context");
        LayoutInflater.from(context).inflate(R.layout.layout_home_tab_mcu_arty_guide_card, (ViewGroup) this, true);
        ViewPager2 viewPager2 = (ViewPager2) findViewById(R.id.arty_viewpager);
        viewPager2.setAdapter(new b());
        new c((TabLayout) findViewById(R.id.main_tab), viewPager2, e.f36976a).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(TabLayout.g tab, int i10) {
        i.f(tab, "tab");
    }

    public /* synthetic */ f(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.f fVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
