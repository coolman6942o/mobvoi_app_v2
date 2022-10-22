package oc;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.mobvoi.companion.R;
import p1.a;
import p1.b;
/* compiled from: FragmentEsimHelpRowBinding.java */
/* loaded from: classes2.dex */
public final class i implements a {

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f31529a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f31530b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f31531c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f31532d;

    /* renamed from: e  reason: collision with root package name */
    public final Button f31533e;

    private i(ScrollView scrollView, TextView textView, TextView textView2, ImageView imageView, TextView textView3, TextView textView4, Button button) {
        this.f31529a = scrollView;
        this.f31530b = textView2;
        this.f31531c = imageView;
        this.f31532d = textView3;
        this.f31533e = button;
    }

    public static i b(View view) {
        int i10 = R.id.esim_first;
        TextView textView = (TextView) b.a(view, i10);
        if (textView != null) {
            i10 = R.id.esim_issues;
            TextView textView2 = (TextView) b.a(view, i10);
            if (textView2 != null) {
                i10 = R.id.esim_logo;
                ImageView imageView = (ImageView) b.a(view, i10);
                if (imageView != null) {
                    i10 = R.id.esim_second;
                    TextView textView3 = (TextView) b.a(view, i10);
                    if (textView3 != null) {
                        i10 = R.id.esim_third;
                        TextView textView4 = (TextView) b.a(view, i10);
                        if (textView4 != null) {
                            i10 = R.id.function_btn;
                            Button button = (Button) b.a(view, i10);
                            if (button != null) {
                                return new i((ScrollView) view, textView, textView2, imageView, textView3, textView4, button);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    /* renamed from: c */
    public ScrollView a() {
        return this.f31529a;
    }
}
