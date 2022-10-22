package zh;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.makeramen.roundedimageview.RoundedImageView;
import p1.a;
import p1.b;
import sh.h;
import sh.i;
/* compiled from: DialogPicUpgradeBinding.java */
/* loaded from: classes2.dex */
public final class m implements a {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f37558a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f37559b;

    /* renamed from: c  reason: collision with root package name */
    public final RoundedImageView f37560c;

    /* renamed from: d  reason: collision with root package name */
    public final ProgressBar f37561d;

    /* renamed from: e  reason: collision with root package name */
    public final RelativeLayout f37562e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f37563f;

    /* renamed from: g  reason: collision with root package name */
    public final Button f37564g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f37565h;

    private m(RelativeLayout relativeLayout, ImageView imageView, RoundedImageView roundedImageView, ProgressBar progressBar, RelativeLayout relativeLayout2, TextView textView, Button button, TextView textView2) {
        this.f37558a = relativeLayout;
        this.f37559b = imageView;
        this.f37560c = roundedImageView;
        this.f37561d = progressBar;
        this.f37562e = relativeLayout2;
        this.f37563f = textView;
        this.f37564g = button;
        this.f37565h = textView2;
    }

    public static m b(View view) {
        int i10 = h.f34709w1;
        ImageView imageView = (ImageView) b.a(view, i10);
        if (imageView != null) {
            i10 = h.f34673o1;
            RoundedImageView roundedImageView = (RoundedImageView) b.a(view, i10);
            if (roundedImageView != null) {
                i10 = h.f34701u2;
                ProgressBar progressBar = (ProgressBar) b.a(view, i10);
                if (progressBar != null) {
                    i10 = h.E2;
                    RelativeLayout relativeLayout = (RelativeLayout) b.a(view, i10);
                    if (relativeLayout != null) {
                        i10 = h.f34680p3;
                        TextView textView = (TextView) b.a(view, i10);
                        if (textView != null) {
                            i10 = h.f34672n4;
                            Button button = (Button) b.a(view, i10);
                            if (button != null) {
                                i10 = h.f34676o4;
                                TextView textView2 = (TextView) b.a(view, i10);
                                if (textView2 != null) {
                                    return new m((RelativeLayout) view, imageView, roundedImageView, progressBar, relativeLayout, textView, button, textView2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static m d(LayoutInflater layoutInflater) {
        return e(layoutInflater, null, false);
    }

    public static m e(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(i.S, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return b(inflate);
    }

    /* renamed from: c */
    public RelativeLayout a() {
        return this.f37558a;
    }
}
