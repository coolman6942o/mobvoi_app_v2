package zh;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.mobvoi.companion.health.widget.arty.ArtyTipsTextView;
import p1.a;
import p1.b;
import sh.h;
import sh.i;
/* compiled from: FragmentQuestionGenderBinding.java */
/* loaded from: classes2.dex */
public final class p implements a {

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f37578a;

    /* renamed from: b  reason: collision with root package name */
    public final Button f37579b;

    /* renamed from: c  reason: collision with root package name */
    public final RadioButton f37580c;

    /* renamed from: d  reason: collision with root package name */
    public final RadioButton f37581d;

    private p(ConstraintLayout constraintLayout, Button button, RadioButton radioButton, ImageView imageView, RadioButton radioButton2, ArtyTipsTextView artyTipsTextView) {
        this.f37578a = constraintLayout;
        this.f37579b = button;
        this.f37580c = radioButton;
        this.f37581d = radioButton2;
    }

    public static p b(View view) {
        int i10 = h.f34610a0;
        Button button = (Button) b.a(view, i10);
        if (button != null) {
            i10 = h.W0;
            RadioButton radioButton = (RadioButton) b.a(view, i10);
            if (radioButton != null) {
                i10 = h.f34648i1;
                ImageView imageView = (ImageView) b.a(view, i10);
                if (imageView != null) {
                    i10 = h.f34640g2;
                    RadioButton radioButton2 = (RadioButton) b.a(view, i10);
                    if (radioButton2 != null) {
                        i10 = h.G3;
                        ArtyTipsTextView artyTipsTextView = (ArtyTipsTextView) b.a(view, i10);
                        if (artyTipsTextView != null) {
                            return new p((ConstraintLayout) view, button, radioButton, imageView, radioButton2, artyTipsTextView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static p d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(i.f34738g0, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return b(inflate);
    }

    /* renamed from: c */
    public ConstraintLayout a() {
        return this.f37578a;
    }
}
