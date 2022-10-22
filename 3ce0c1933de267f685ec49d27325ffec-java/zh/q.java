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
/* compiled from: FragmentQuestionHeightBinding.java */
/* loaded from: classes2.dex */
public final class q implements a {

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f37582a;

    /* renamed from: b  reason: collision with root package name */
    public final Button f37583b;

    /* renamed from: c  reason: collision with root package name */
    public final EditText f37584c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f37585d;

    /* renamed from: e  reason: collision with root package name */
    public final EditText f37586e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f37587f;

    /* renamed from: g  reason: collision with root package name */
    public final Switch f37588g;

    private q(ConstraintLayout constraintLayout, Button button, EditText editText, TextView textView, LinearLayout linearLayout, ImageView imageView, EditText editText2, TextView textView2, ArtyTipsTextView artyTipsTextView, Switch r10) {
        this.f37582a = constraintLayout;
        this.f37583b = button;
        this.f37584c = editText;
        this.f37585d = textView;
        this.f37586e = editText2;
        this.f37587f = textView2;
        this.f37588g = r10;
    }

    public static q b(View view) {
        int i10 = h.f34610a0;
        Button button = (Button) b.a(view, i10);
        if (button != null) {
            i10 = h.f34620c1;
            EditText editText = (EditText) b.a(view, i10);
            if (editText != null) {
                i10 = h.f34625d1;
                TextView textView = (TextView) b.a(view, i10);
                if (textView != null) {
                    i10 = h.f34634f1;
                    LinearLayout linearLayout = (LinearLayout) b.a(view, i10);
                    if (linearLayout != null) {
                        i10 = h.f34648i1;
                        ImageView imageView = (ImageView) b.a(view, i10);
                        if (imageView != null) {
                            i10 = h.f34656k1;
                            EditText editText2 = (EditText) b.a(view, i10);
                            if (editText2 != null) {
                                i10 = h.f34660l1;
                                TextView textView2 = (TextView) b.a(view, i10);
                                if (textView2 != null) {
                                    i10 = h.G3;
                                    ArtyTipsTextView artyTipsTextView = (ArtyTipsTextView) b.a(view, i10);
                                    if (artyTipsTextView != null) {
                                        i10 = h.f34681p4;
                                        Switch r12 = (Switch) b.a(view, i10);
                                        if (r12 != null) {
                                            return new q((ConstraintLayout) view, button, editText, textView, linearLayout, imageView, editText2, textView2, artyTipsTextView, r12);
                                        }
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

    public static q d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(i.f34739h0, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return b(inflate);
    }

    /* renamed from: c */
    public ConstraintLayout a() {
        return this.f37582a;
    }
}
