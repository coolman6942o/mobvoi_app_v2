package zh;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.mobvoi.companion.health.widget.arty.ArtyTipsTextView;
import p1.a;
import p1.b;
import sh.h;
import sh.i;
/* compiled from: FragmentQuestionNameBinding.java */
/* loaded from: classes2.dex */
public final class r implements a {

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f37589a;

    /* renamed from: b  reason: collision with root package name */
    public final Button f37590b;

    /* renamed from: c  reason: collision with root package name */
    public final EditText f37591c;

    private r(ConstraintLayout constraintLayout, Button button, ImageView imageView, EditText editText, ArtyTipsTextView artyTipsTextView) {
        this.f37589a = constraintLayout;
        this.f37590b = button;
        this.f37591c = editText;
    }

    public static r b(View view) {
        int i10 = h.f34610a0;
        Button button = (Button) b.a(view, i10);
        if (button != null) {
            i10 = h.f34648i1;
            ImageView imageView = (ImageView) b.a(view, i10);
            if (imageView != null) {
                i10 = h.f34661l2;
                EditText editText = (EditText) b.a(view, i10);
                if (editText != null) {
                    i10 = h.G3;
                    ArtyTipsTextView artyTipsTextView = (ArtyTipsTextView) b.a(view, i10);
                    if (artyTipsTextView != null) {
                        return new r((ConstraintLayout) view, button, imageView, editText, artyTipsTextView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static r d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(i.f34740i0, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return b(inflate);
    }

    /* renamed from: c */
    public ConstraintLayout a() {
        return this.f37589a;
    }
}
