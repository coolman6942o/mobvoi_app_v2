package oc;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.button.MaterialButton;
import com.mobvoi.companion.R;
import p1.a;
import p1.b;
/* compiled from: FragmentOfflineSimBinding.java */
/* loaded from: classes2.dex */
public final class m implements a {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f31547a;

    /* renamed from: b  reason: collision with root package name */
    public final MaterialButton f31548b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f31549c;

    private m(LinearLayout linearLayout, MaterialButton materialButton, TextView textView) {
        this.f31547a = linearLayout;
        this.f31548b = materialButton;
        this.f31549c = textView;
    }

    public static m b(View view) {
        int i10 = R.id.open_now;
        MaterialButton materialButton = (MaterialButton) b.a(view, i10);
        if (materialButton != null) {
            i10 = R.id.see_regions;
            TextView textView = (TextView) b.a(view, i10);
            if (textView != null) {
                return new m((LinearLayout) view, materialButton, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    /* renamed from: c */
    public LinearLayout a() {
        return this.f31547a;
    }
}
