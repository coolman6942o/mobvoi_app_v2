package oc;

import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.mobvoi.companion.R;
import p1.a;
import p1.b;
/* compiled from: FragmentSimOpenTutorialBinding.java */
/* loaded from: classes2.dex */
public final class p implements a {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f31555a;

    /* renamed from: b  reason: collision with root package name */
    public final Button f31556b;

    /* renamed from: c  reason: collision with root package name */
    public final Button f31557c;

    private p(RelativeLayout relativeLayout, Button button, Button button2) {
        this.f31555a = relativeLayout;
        this.f31556b = button;
        this.f31557c = button2;
    }

    public static p b(View view) {
        int i10 = R.id.open_now;
        Button button = (Button) b.a(view, i10);
        if (button != null) {
            i10 = R.id.open_tutorial;
            Button button2 = (Button) b.a(view, i10);
            if (button2 != null) {
                return new p((RelativeLayout) view, button, button2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    /* renamed from: c */
    public RelativeLayout a() {
        return this.f31555a;
    }
}
