package je;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import ge.k;
import ge.l;
import p1.a;
import p1.b;
/* compiled from: FragmentDeviceTabBinding.java */
/* loaded from: classes2.dex */
public final class c implements a {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f29556a;

    /* renamed from: b  reason: collision with root package name */
    public final TabLayout f29557b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f29558c;

    /* renamed from: d  reason: collision with root package name */
    public final Toolbar f29559d;

    /* renamed from: e  reason: collision with root package name */
    public final ViewPager f29560e;

    private c(RelativeLayout relativeLayout, TabLayout tabLayout, ImageView imageView, Toolbar toolbar, ViewPager viewPager) {
        this.f29556a = relativeLayout;
        this.f29557b = tabLayout;
        this.f29558c = imageView;
        this.f29559d = toolbar;
        this.f29560e = viewPager;
    }

    public static c b(View view) {
        int i10 = k.f27428d;
        TabLayout tabLayout = (TabLayout) b.a(view, i10);
        if (tabLayout != null) {
            i10 = k.f_res_0x7f0b039d;
            ImageView imageView = (ImageView) b.a(view, i10);
            if (imageView != null) {
                i10 = k.f27429h;
                Toolbar toolbar = (Toolbar) b.a(view, i10);
                if (toolbar != null) {
                    i10 = k.f27430k;
                    ViewPager viewPager = (ViewPager) b.a(view, i10);
                    if (viewPager != null) {
                        return new c((RelativeLayout) view, tabLayout, imageView, toolbar, viewPager);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static c d(LayoutInflater layoutInflater) {
        return e(layoutInflater, null, false);
    }

    public static c e(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(l.f_res_0x7f0e00c9, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return b(inflate);
    }

    /* renamed from: c */
    public RelativeLayout a() {
        return this.f29556a;
    }
}
