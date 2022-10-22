package zh;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.makeramen.roundedimageview.RoundedImageView;
import com.mobvoi.mcuwatch.ui.onlinedial.CustomDialGridView;
import p1.a;
import p1.b;
import sh.h;
import sh.i;
/* compiled from: FragmentCustomDialBinding.java */
/* loaded from: classes2.dex */
public final class n implements a {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f37566a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f37567b;

    /* renamed from: c  reason: collision with root package name */
    public final RoundedImageView f37568c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f37569d;

    /* renamed from: e  reason: collision with root package name */
    public final Button f37570e;

    /* renamed from: f  reason: collision with root package name */
    public final CustomDialGridView f37571f;

    private n(RelativeLayout relativeLayout, RelativeLayout relativeLayout2, ImageView imageView, RoundedImageView roundedImageView, ImageView imageView2, Button button, CustomDialGridView customDialGridView) {
        this.f37566a = relativeLayout;
        this.f37567b = imageView;
        this.f37568c = roundedImageView;
        this.f37569d = imageView2;
        this.f37570e = button;
        this.f37571f = customDialGridView;
    }

    public static n b(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view;
        int i10 = h.O0;
        ImageView imageView = (ImageView) b.a(view, i10);
        if (imageView != null) {
            i10 = h.f34649i2;
            RoundedImageView roundedImageView = (RoundedImageView) b.a(view, i10);
            if (roundedImageView != null) {
                i10 = h.Q2;
                ImageView imageView2 = (ImageView) b.a(view, i10);
                if (imageView2 != null) {
                    i10 = h.f34627d3;
                    Button button = (Button) b.a(view, i10);
                    if (button != null) {
                        i10 = h.D4;
                        CustomDialGridView customDialGridView = (CustomDialGridView) b.a(view, i10);
                        if (customDialGridView != null) {
                            return new n(relativeLayout, relativeLayout, imageView, roundedImageView, imageView2, button, customDialGridView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static n d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(i.f34730b0, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return b(inflate);
    }

    /* renamed from: c */
    public RelativeLayout a() {
        return this.f37566a;
    }
}
