package zh;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewpager.widget.ViewPager;
import com.mobvoi.health.companion.ui.DatePicker;
import p1.a;
import p1.b;
import sh.h;
/* compiled from: ActivityCalendarBinding.java */
/* loaded from: classes2.dex */
public final class g implements a {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f37535a;

    /* renamed from: b  reason: collision with root package name */
    public final DatePicker f37536b;

    /* renamed from: c  reason: collision with root package name */
    public final ViewPager f37537c;

    private g(LinearLayout linearLayout, DatePicker datePicker, ViewPager viewPager) {
        this.f37535a = linearLayout;
        this.f37536b = datePicker;
        this.f37537c = viewPager;
    }

    public static g b(View view) {
        int i10 = h.J0;
        DatePicker datePicker = (DatePicker) b.a(view, i10);
        if (datePicker != null) {
            i10 = h.f34717x4;
            ViewPager viewPager = (ViewPager) b.a(view, i10);
            if (viewPager != null) {
                return new g((LinearLayout) view, datePicker, viewPager);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    /* renamed from: c */
    public LinearLayout a() {
        return this.f37535a;
    }
}
