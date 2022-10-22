package oc;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.material.button.MaterialButton;
import com.mobvoi.companion.R;
import p1.a;
import p1.b;
/* compiled from: FragmentJupiterSimTutorialBinding.java */
/* loaded from: classes2.dex */
public final class l implements a {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f31543a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f31544b;

    /* renamed from: c  reason: collision with root package name */
    public final MaterialButton f31545c;

    /* renamed from: d  reason: collision with root package name */
    public final MaterialButton f31546d;

    private l(LinearLayout linearLayout, TextView textView, MaterialButton materialButton, MaterialButton materialButton2) {
        this.f31543a = linearLayout;
        this.f31544b = textView;
        this.f31545c = materialButton;
        this.f31546d = materialButton2;
    }

    public static l b(View view) {
        int i10 = R.id.how_to_open;
        TextView textView = (TextView) b.a(view, i10);
        if (textView != null) {
            i10 = R.id.open_offline;
            MaterialButton materialButton = (MaterialButton) b.a(view, i10);
            if (materialButton != null) {
                i10 = R.id.open_online;
                MaterialButton materialButton2 = (MaterialButton) b.a(view, i10);
                if (materialButton2 != null) {
                    return new l((LinearLayout) view, textView, materialButton, materialButton2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    /* renamed from: c */
    public LinearLayout a() {
        return this.f31543a;
    }
}
