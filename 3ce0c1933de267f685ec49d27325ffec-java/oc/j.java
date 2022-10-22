package oc;

import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import com.mobvoi.companion.R;
import p1.a;
import p1.b;
/* compiled from: FragmentEsimTaiwanTutorialBinding.java */
/* loaded from: classes2.dex */
public final class j implements a {

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f31534a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f31535b;

    /* renamed from: c  reason: collision with root package name */
    public final Button f31536c;

    private j(ScrollView scrollView, TextView textView, TextView textView2, TextView textView3, Button button) {
        this.f31534a = scrollView;
        this.f31535b = textView;
        this.f31536c = button;
    }

    public static j b(View view) {
        int i10 = R.id.esim_issues;
        TextView textView = (TextView) b.a(view, i10);
        if (textView != null) {
            i10 = R.id.how_to_open;
            TextView textView2 = (TextView) b.a(view, i10);
            if (textView2 != null) {
                i10 = R.id.how_to_open2;
                TextView textView3 = (TextView) b.a(view, i10);
                if (textView3 != null) {
                    i10 = R.id.open_offline;
                    Button button = (Button) b.a(view, i10);
                    if (button != null) {
                        return new j((ScrollView) view, textView, textView2, textView3, button);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    /* renamed from: c */
    public ScrollView a() {
        return this.f31534a;
    }
}
