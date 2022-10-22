package zh;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.mobvoi.companion.health.widget.arty.ArtyTipsTextView;
import p1.a;
import p1.b;
import sh.h;
import sh.i;
/* compiled from: ItemWelcomeBinding.java */
/* loaded from: classes2.dex */
public final class u implements a {

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f37600a;

    /* renamed from: b  reason: collision with root package name */
    public final Button f37601b;

    /* renamed from: c  reason: collision with root package name */
    public final ConstraintLayout f37602c;

    /* renamed from: d  reason: collision with root package name */
    public final ImageView f37603d;

    /* renamed from: e  reason: collision with root package name */
    public final ArtyTipsTextView f37604e;

    private u(ConstraintLayout constraintLayout, Button button, ConstraintLayout constraintLayout2, ImageView imageView, ImageView imageView2, ArtyTipsTextView artyTipsTextView) {
        this.f37600a = constraintLayout;
        this.f37601b = button;
        this.f37602c = constraintLayout2;
        this.f37603d = imageView2;
        this.f37604e = artyTipsTextView;
    }

    public static u b(View view) {
        int i10 = h.f34610a0;
        Button button = (Button) b.a(view, i10);
        if (button != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i10 = h.f34648i1;
            ImageView imageView = (ImageView) b.a(view, i10);
            if (imageView != null) {
                i10 = h.A1;
                ImageView imageView2 = (ImageView) b.a(view, i10);
                if (imageView2 != null) {
                    i10 = h.G3;
                    ArtyTipsTextView artyTipsTextView = (ArtyTipsTextView) b.a(view, i10);
                    if (artyTipsTextView != null) {
                        return new u(constraintLayout, button, constraintLayout, imageView, imageView2, artyTipsTextView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static u d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(i.H0, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return b(inflate);
    }

    /* renamed from: c */
    public ConstraintLayout a() {
        return this.f37600a;
    }
}
