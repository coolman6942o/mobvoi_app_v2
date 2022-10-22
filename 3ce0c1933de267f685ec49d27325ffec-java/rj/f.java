package rj;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.mobvoi.record.h;
import com.mobvoi.record.i;
import p1.a;
import p1.b;
/* compiled from: RecordFragmentRedeemCodeBinding.java */
/* loaded from: classes2.dex */
public final class f implements a {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f33579a;

    /* renamed from: b  reason: collision with root package name */
    public final Button f33580b;

    /* renamed from: c  reason: collision with root package name */
    public final EditText f33581c;

    /* renamed from: d  reason: collision with root package name */
    public final j f33582d;

    /* renamed from: e  reason: collision with root package name */
    public final Toolbar f33583e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f33584f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f33585g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f33586h;

    private f(RelativeLayout relativeLayout, Button button, EditText editText, j jVar, LinearLayout linearLayout, Toolbar toolbar, TextView textView, TextView textView2, TextView textView3) {
        this.f33579a = relativeLayout;
        this.f33580b = button;
        this.f33581c = editText;
        this.f33582d = jVar;
        this.f33583e = toolbar;
        this.f33584f = textView;
        this.f33585g = textView2;
        this.f33586h = textView3;
    }

    public static f b(View view) {
        View a10;
        int i10 = h.f20616r;
        Button button = (Button) b.a(view, i10);
        if (button != null) {
            i10 = h.f20626w;
            EditText editText = (EditText) b.a(view, i10);
            if (!(editText == null || (a10 = b.a(view, (i10 = h.Q))) == null)) {
                j b10 = j.b(a10);
                i10 = h.S;
                LinearLayout linearLayout = (LinearLayout) b.a(view, i10);
                if (linearLayout != null) {
                    i10 = h.f20615q0;
                    Toolbar toolbar = (Toolbar) b.a(view, i10);
                    if (toolbar != null) {
                        i10 = h.f20619s0;
                        TextView textView = (TextView) b.a(view, i10);
                        if (textView != null) {
                            i10 = h.A0;
                            TextView textView2 = (TextView) b.a(view, i10);
                            if (textView2 != null) {
                                i10 = h.f20594g1;
                                TextView textView3 = (TextView) b.a(view, i10);
                                if (textView3 != null) {
                                    return new f((RelativeLayout) view, button, editText, b10, linearLayout, toolbar, textView, textView2, textView3);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static f d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(i.f20646m, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return b(inflate);
    }

    /* renamed from: c */
    public RelativeLayout a() {
        return this.f33579a;
    }
}
