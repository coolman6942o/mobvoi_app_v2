package mc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import lc.b;
import lc.c;
/* compiled from: ActivityMessageDebugBinding.java */
/* loaded from: classes2.dex */
public final class a implements p1.a {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f30649a;

    /* renamed from: b  reason: collision with root package name */
    public final Button f30650b;

    /* renamed from: c  reason: collision with root package name */
    public final Button f30651c;

    /* renamed from: d  reason: collision with root package name */
    public final Button f30652d;

    /* renamed from: e  reason: collision with root package name */
    public final Button f30653e;

    private a(RelativeLayout relativeLayout, Button button, Button button2, Button button3, Button button4) {
        this.f30649a = relativeLayout;
        this.f30650b = button;
        this.f30651c = button2;
        this.f30652d = button3;
        this.f30653e = button4;
    }

    public static a b(View view) {
        int i10 = b.a_res_0x7f0b01fe;
        Button button = (Button) p1.b.a(view, i10);
        if (button != null) {
            i10 = b.b_res_0x7f0b01ff;
            Button button2 = (Button) p1.b.a(view, i10);
            if (button2 != null) {
                i10 = b.c_res_0x7f0b0200;
                Button button3 = (Button) p1.b.a(view, i10);
                if (button3 != null) {
                    i10 = b.d_res_0x7f0b0201;
                    Button button4 = (Button) p1.b.a(view, i10);
                    if (button4 != null) {
                        return new a((RelativeLayout) view, button, button2, button3, button4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static a d(LayoutInflater layoutInflater) {
        return e(layoutInflater, null, false);
    }

    public static a e(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(c.a_res_0x7f0e0043, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return b(inflate);
    }

    /* renamed from: c */
    public RelativeLayout a() {
        return this.f30649a;
    }
}
