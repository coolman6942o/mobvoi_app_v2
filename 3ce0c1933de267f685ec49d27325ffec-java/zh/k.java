package zh;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.mobvoi.companion.health.widget.arty.ArtyTipsTextView;
import p1.a;
import p1.b;
import sh.h;
import sh.i;
/* compiled from: ActivitySetUpCompleteBinding.java */
/* loaded from: classes2.dex */
public final class k implements a {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f37550a;

    /* renamed from: b  reason: collision with root package name */
    public final Button f37551b;

    /* renamed from: c  reason: collision with root package name */
    public final Button f37552c;

    /* renamed from: d  reason: collision with root package name */
    public final ConstraintLayout f37553d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f37554e;

    /* renamed from: f  reason: collision with root package name */
    public final ArtyTipsTextView f37555f;

    private k(LinearLayout linearLayout, Button button, Button button2, ConstraintLayout constraintLayout, Toolbar toolbar, ImageView imageView, ImageView imageView2, ArtyTipsTextView artyTipsTextView) {
        this.f37550a = linearLayout;
        this.f37551b = button;
        this.f37552c = button2;
        this.f37553d = constraintLayout;
        this.f37554e = imageView2;
        this.f37555f = artyTipsTextView;
    }

    public static k b(View view) {
        int i10 = h.Z;
        Button button = (Button) b.a(view, i10);
        if (button != null) {
            i10 = h.f34610a0;
            Button button2 = (Button) b.a(view, i10);
            if (button2 != null) {
                i10 = h.f34718y0;
                ConstraintLayout constraintLayout = (ConstraintLayout) b.a(view, i10);
                if (constraintLayout != null) {
                    i10 = h.I0;
                    Toolbar toolbar = (Toolbar) b.a(view, i10);
                    if (toolbar != null) {
                        i10 = h.f34648i1;
                        ImageView imageView = (ImageView) b.a(view, i10);
                        if (imageView != null) {
                            i10 = h.A1;
                            ImageView imageView2 = (ImageView) b.a(view, i10);
                            if (imageView2 != null) {
                                i10 = h.G3;
                                ArtyTipsTextView artyTipsTextView = (ArtyTipsTextView) b.a(view, i10);
                                if (artyTipsTextView != null) {
                                    return new k((LinearLayout) view, button, button2, constraintLayout, toolbar, imageView, imageView2, artyTipsTextView);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static k d(LayoutInflater layoutInflater) {
        return e(layoutInflater, null, false);
    }

    public static k e(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(i.f34752s, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return b(inflate);
    }

    /* renamed from: c */
    public LinearLayout a() {
        return this.f37550a;
    }
}
