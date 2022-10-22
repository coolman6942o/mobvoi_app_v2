package zh;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.mobvoi.companion.health.widget.arty.ArtyTipsTextView;
import p1.a;
import p1.b;
import sh.h;
import sh.i;
/* compiled from: FragmentQuestionBirthdayBinding.java */
/* loaded from: classes2.dex */
public final class o implements a {

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f37572a;

    /* renamed from: b  reason: collision with root package name */
    public final Button f37573b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f37574c;

    /* renamed from: d  reason: collision with root package name */
    public final EditText f37575d;

    /* renamed from: e  reason: collision with root package name */
    public final EditText f37576e;

    /* renamed from: f  reason: collision with root package name */
    public final EditText f37577f;

    private o(ConstraintLayout constraintLayout, LinearLayout linearLayout, Button button, ImageView imageView, EditText editText, ImageView imageView2, EditText editText2, ArtyTipsTextView artyTipsTextView, EditText editText3) {
        this.f37572a = constraintLayout;
        this.f37573b = button;
        this.f37574c = imageView;
        this.f37575d = editText;
        this.f37576e = editText2;
        this.f37577f = editText3;
    }

    public static o b(View view) {
        int i10 = h.T_res_0x7f0b0104;
        LinearLayout linearLayout = (LinearLayout) b.a(view, i10);
        if (linearLayout != null) {
            i10 = h.f34610a0;
            Button button = (Button) b.a(view, i10);
            if (button != null) {
                i10 = h.o0_res_0x7f0b014d;
                ImageView imageView = (ImageView) b.a(view, i10);
                if (imageView != null) {
                    i10 = h.L0;
                    EditText editText = (EditText) b.a(view, i10);
                    if (editText != null) {
                        i10 = h.f34648i1;
                        ImageView imageView2 = (ImageView) b.a(view, i10);
                        if (imageView2 != null) {
                            i10 = h.f34657k2;
                            EditText editText2 = (EditText) b.a(view, i10);
                            if (editText2 != null) {
                                i10 = h.G3;
                                ArtyTipsTextView artyTipsTextView = (ArtyTipsTextView) b.a(view, i10);
                                if (artyTipsTextView != null) {
                                    i10 = h.E4;
                                    EditText editText3 = (EditText) b.a(view, i10);
                                    if (editText3 != null) {
                                        return new o((ConstraintLayout) view, linearLayout, button, imageView, editText, imageView2, editText2, artyTipsTextView, editText3);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static o d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(i.f34737f0, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return b(inflate);
    }

    /* renamed from: c */
    public ConstraintLayout a() {
        return this.f37572a;
    }
}
