package wa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import p1.a;
import p1.b;
import pa.f;
/* compiled from: FragmentSignPhoneBinding.java */
/* loaded from: classes2.dex */
public final class e implements a {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f36207a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageButton f36208b;

    /* renamed from: c  reason: collision with root package name */
    public final EditText f36209c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f36210d;

    /* renamed from: e  reason: collision with root package name */
    public final CheckBox f36211e;

    /* renamed from: f  reason: collision with root package name */
    public final Button f36212f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f36213g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f36214h;

    /* renamed from: i  reason: collision with root package name */
    public final LinearLayout f36215i;

    /* renamed from: j  reason: collision with root package name */
    public final TextView f36216j;

    /* renamed from: k  reason: collision with root package name */
    public final View f36217k;

    private e(LinearLayout linearLayout, ImageButton imageButton, EditText editText, TextView textView, CheckBox checkBox, Button button, TextView textView2, TextView textView3, LinearLayout linearLayout2, TextView textView4, View view) {
        this.f36207a = linearLayout;
        this.f36208b = imageButton;
        this.f36209c = editText;
        this.f36210d = textView;
        this.f36211e = checkBox;
        this.f36212f = button;
        this.f36213g = textView2;
        this.f36214h = textView3;
        this.f36215i = linearLayout2;
        this.f36216j = textView4;
        this.f36217k = view;
    }

    public static e b(View view) {
        View a10;
        int i10 = pa.e.f32629c;
        ImageButton imageButton = (ImageButton) b.a(view, i10);
        if (imageButton != null) {
            i10 = pa.e.f32631d;
            EditText editText = (EditText) b.a(view, i10);
            if (editText != null) {
                i10 = pa.e.f32651n;
                TextView textView = (TextView) b.a(view, i10);
                if (textView != null) {
                    i10 = pa.e.f32655p;
                    CheckBox checkBox = (CheckBox) b.a(view, i10);
                    if (checkBox != null) {
                        i10 = pa.e.f32659r;
                        Button button = (Button) b.a(view, i10);
                        if (button != null) {
                            i10 = pa.e.O;
                            TextView textView2 = (TextView) b.a(view, i10);
                            if (textView2 != null) {
                                i10 = pa.e.P;
                                TextView textView3 = (TextView) b.a(view, i10);
                                if (textView3 != null) {
                                    i10 = pa.e.Y;
                                    LinearLayout linearLayout = (LinearLayout) b.a(view, i10);
                                    if (linearLayout != null) {
                                        i10 = pa.e.f32644j0;
                                        TextView textView4 = (TextView) b.a(view, i10);
                                        if (!(textView4 == null || (a10 = b.a(view, (i10 = pa.e.f32668v0))) == null)) {
                                            return new e((LinearLayout) view, imageButton, editText, textView, checkBox, button, textView2, textView3, linearLayout, textView4, a10);
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

    public static e d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(f.f32686j, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return b(inflate);
    }

    /* renamed from: c */
    public LinearLayout a() {
        return this.f36207a;
    }
}
