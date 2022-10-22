package wa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.mobvoi.assistant.account.ui.widget.TimerButton;
import p1.a;
import p1.b;
import pa.e;
import pa.f;
/* compiled from: FragmentSignCaptchaBinding.java */
/* loaded from: classes2.dex */
public final class d implements a {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f36196a;

    /* renamed from: b  reason: collision with root package name */
    public final EditText f36197b;

    /* renamed from: c  reason: collision with root package name */
    public final Button f36198c;

    /* renamed from: d  reason: collision with root package name */
    public final LinearLayout f36199d;

    /* renamed from: e  reason: collision with root package name */
    public final EditText f36200e;

    /* renamed from: f  reason: collision with root package name */
    public final CheckBox f36201f;

    /* renamed from: g  reason: collision with root package name */
    public final TimerButton f36202g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f36203h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f36204i;

    /* renamed from: j  reason: collision with root package name */
    public final View f36205j;

    /* renamed from: k  reason: collision with root package name */
    public final View f36206k;

    private d(LinearLayout linearLayout, EditText editText, Button button, LinearLayout linearLayout2, LinearLayout linearLayout3, EditText editText2, CheckBox checkBox, TimerButton timerButton, TextView textView, TextView textView2, View view, View view2) {
        this.f36196a = linearLayout;
        this.f36197b = editText;
        this.f36198c = button;
        this.f36199d = linearLayout3;
        this.f36200e = editText2;
        this.f36201f = checkBox;
        this.f36202g = timerButton;
        this.f36203h = textView;
        this.f36204i = textView2;
        this.f36205j = view;
        this.f36206k = view2;
    }

    public static d b(View view) {
        View a10;
        View a11;
        int i10 = e.f32653o;
        EditText editText = (EditText) b.a(view, i10);
        if (editText != null) {
            i10 = e.f32659r;
            Button button = (Button) b.a(view, i10);
            if (button != null) {
                i10 = e.f32665u;
                LinearLayout linearLayout = (LinearLayout) b.a(view, i10);
                if (linearLayout != null) {
                    i10 = e.F;
                    LinearLayout linearLayout2 = (LinearLayout) b.a(view, i10);
                    if (linearLayout2 != null) {
                        i10 = e.f32626a0;
                        EditText editText2 = (EditText) b.a(view, i10);
                        if (editText2 != null) {
                            i10 = e.f32628b0;
                            CheckBox checkBox = (CheckBox) b.a(view, i10);
                            if (checkBox != null) {
                                i10 = e.f32642i0;
                                TimerButton timerButton = (TimerButton) b.a(view, i10);
                                if (timerButton != null) {
                                    i10 = e.f32646k0;
                                    TextView textView = (TextView) b.a(view, i10);
                                    if (textView != null) {
                                        i10 = e.f32650m0;
                                        TextView textView2 = (TextView) b.a(view, i10);
                                        if (!(textView2 == null || (a10 = b.a(view, (i10 = e.f32670w0))) == null || (a11 = b.a(view, (i10 = e.f32672x0))) == null)) {
                                            return new d((LinearLayout) view, editText, button, linearLayout, linearLayout2, editText2, checkBox, timerButton, textView, textView2, a10, a11);
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

    public static d d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(f.f32685i, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return b(inflate);
    }

    /* renamed from: c */
    public LinearLayout a() {
        return this.f36196a;
    }
}
