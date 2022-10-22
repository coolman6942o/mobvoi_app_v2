package zh;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.mobvoi.companion.health.widget.arty.ArtyTipsTextView;
import p1.a;
import p1.b;
import sh.h;
import sh.i;
/* compiled from: FragmentQuestionWeightBinding.java */
/* loaded from: classes2.dex */
public final class s implements a {

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f37592a;

    /* renamed from: b  reason: collision with root package name */
    public final Button f37593b;

    /* renamed from: c  reason: collision with root package name */
    public final Switch f37594c;

    /* renamed from: d  reason: collision with root package name */
    public final EditText f37595d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f37596e;

    private s(ConstraintLayout constraintLayout, Button button, LinearLayout linearLayout, ImageView imageView, ArtyTipsTextView artyTipsTextView, Switch r62, EditText editText, TextView textView) {
        this.f37592a = constraintLayout;
        this.f37593b = button;
        this.f37594c = r62;
        this.f37595d = editText;
        this.f37596e = textView;
    }

    public static s b(View view) {
        int i10 = h.f34610a0;
        Button button = (Button) b.a(view, i10);
        if (button != null) {
            i10 = h.f34634f1;
            LinearLayout linearLayout = (LinearLayout) b.a(view, i10);
            if (linearLayout != null) {
                i10 = h.f34648i1;
                ImageView imageView = (ImageView) b.a(view, i10);
                if (imageView != null) {
                    i10 = h.G3;
                    ArtyTipsTextView artyTipsTextView = (ArtyTipsTextView) b.a(view, i10);
                    if (artyTipsTextView != null) {
                        i10 = h.f34681p4;
                        Switch r82 = (Switch) b.a(view, i10);
                        if (r82 != null) {
                            i10 = h.f34722y4;
                            EditText editText = (EditText) b.a(view, i10);
                            if (editText != null) {
                                i10 = h.f34727z4;
                                TextView textView = (TextView) b.a(view, i10);
                                if (textView != null) {
                                    return new s((ConstraintLayout) view, button, linearLayout, imageView, artyTipsTextView, r82, editText, textView);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static s d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(i.f34741j0, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return b(inflate);
    }

    /* renamed from: c */
    public ConstraintLayout a() {
        return this.f37592a;
    }
}
