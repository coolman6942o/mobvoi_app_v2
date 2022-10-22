package zh;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import p1.a;
import p1.b;
import sh.h;
import sh.i;
/* compiled from: LayoutSearchBlankPageBinding.java */
/* loaded from: classes2.dex */
public final class v implements a {

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f37605a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f37606b;

    /* renamed from: c  reason: collision with root package name */
    public final LottieAnimationView f37607c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f37608d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f37609e;

    private v(ConstraintLayout constraintLayout, ImageView imageView, LottieAnimationView lottieAnimationView, TextView textView, TextView textView2) {
        this.f37605a = constraintLayout;
        this.f37606b = imageView;
        this.f37607c = lottieAnimationView;
        this.f37608d = textView;
        this.f37609e = textView2;
    }

    public static v b(View view) {
        int i10 = h.f34652j1;
        ImageView imageView = (ImageView) b.a(view, i10);
        if (imageView != null) {
            i10 = h.f34626d2;
            LottieAnimationView lottieAnimationView = (LottieAnimationView) b.a(view, i10);
            if (lottieAnimationView != null) {
                i10 = h.F3;
                TextView textView = (TextView) b.a(view, i10);
                if (textView != null) {
                    i10 = h.f34647h4;
                    TextView textView2 = (TextView) b.a(view, i10);
                    if (textView2 != null) {
                        return new v((ConstraintLayout) view, imageView, lottieAnimationView, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static v d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(i.U0, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return b(inflate);
    }

    /* renamed from: c */
    public ConstraintLayout a() {
        return this.f37605a;
    }
}
