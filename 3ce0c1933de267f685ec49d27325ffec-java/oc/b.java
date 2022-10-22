package oc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.mobvoi.companion.R;
import p1.a;
/* compiled from: ActivityEsimTestBinding.java */
/* loaded from: classes2.dex */
public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f31496a;

    /* renamed from: b  reason: collision with root package name */
    public final Button f31497b;

    /* renamed from: c  reason: collision with root package name */
    public final EditText f31498c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f31499d;

    /* renamed from: e  reason: collision with root package name */
    public final Button f31500e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f31501f;

    /* renamed from: g  reason: collision with root package name */
    public final Button f31502g;

    private b(LinearLayout linearLayout, Button button, EditText editText, TextView textView, Button button2, TextView textView2, Button button3, Button button4) {
        this.f31496a = linearLayout;
        this.f31497b = button;
        this.f31498c = editText;
        this.f31499d = textView;
        this.f31500e = button2;
        this.f31501f = textView2;
        this.f31502g = button4;
    }

    public static b b(View view) {
        int i10 = R.id.get_info;
        Button button = (Button) p1.b.a(view, i10);
        if (button != null) {
            i10 = R.id.lpa_confirm;
            EditText editText = (EditText) p1.b.a(view, i10);
            if (editText != null) {
                i10 = R.id.result;
                TextView textView = (TextView) p1.b.a(view, i10);
                if (textView != null) {
                    i10 = R.id.send_lpa_data;
                    Button button2 = (Button) p1.b.a(view, i10);
                    if (button2 != null) {
                        i10 = R.id.show_info;
                        TextView textView2 = (TextView) p1.b.a(view, i10);
                        if (textView2 != null) {
                            i10 = R.id.start_wearable_activity;
                            Button button3 = (Button) p1.b.a(view, i10);
                            if (button3 != null) {
                                i10 = R.id.start_zxing;
                                Button button4 = (Button) p1.b.a(view, i10);
                                if (button4 != null) {
                                    return new b((LinearLayout) view, button, editText, textView, button2, textView2, button3, button4);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static b d(LayoutInflater layoutInflater) {
        return e(layoutInflater, null, false);
    }

    public static b e(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.activity_esim_test, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return b(inflate);
    }

    /* renamed from: c */
    public LinearLayout a() {
        return this.f31496a;
    }
}
