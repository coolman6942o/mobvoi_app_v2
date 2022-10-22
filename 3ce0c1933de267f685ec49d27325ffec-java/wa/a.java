package wa;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.mobvoi.assistant.account.ui.widget.TimerButton;
import p1.b;
import pa.e;
import pa.f;
/* compiled from: FragmentLoginBinding.java */
/* loaded from: classes2.dex */
public final class a implements p1.a {

    /* renamed from: a  reason: collision with root package name */
    private final NestedScrollView f36161a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageButton f36162b;

    /* renamed from: c  reason: collision with root package name */
    public final EditText f36163c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f36164d;

    /* renamed from: e  reason: collision with root package name */
    public final CheckBox f36165e;

    /* renamed from: f  reason: collision with root package name */
    public final LinearLayout f36166f;

    /* renamed from: g  reason: collision with root package name */
    public final Button f36167g;

    /* renamed from: h  reason: collision with root package name */
    public final LinearLayout f36168h;

    /* renamed from: i  reason: collision with root package name */
    public final RelativeLayout f36169i;

    /* renamed from: j  reason: collision with root package name */
    public final CheckBox f36170j;

    /* renamed from: k  reason: collision with root package name */
    public final View f36171k;

    /* renamed from: l  reason: collision with root package name */
    public final TextView f36172l;

    /* renamed from: m  reason: collision with root package name */
    public final EditText f36173m;

    /* renamed from: n  reason: collision with root package name */
    public final CheckBox f36174n;

    /* renamed from: o  reason: collision with root package name */
    public final LinearLayout f36175o;

    /* renamed from: p  reason: collision with root package name */
    public final TimerButton f36176p;

    /* renamed from: q  reason: collision with root package name */
    public final TextView f36177q;

    /* renamed from: r  reason: collision with root package name */
    public final TextView f36178r;

    private a(NestedScrollView nestedScrollView, ImageButton imageButton, EditText editText, TextView textView, CheckBox checkBox, LinearLayout linearLayout, LinearLayout linearLayout2, Button button, LinearLayout linearLayout3, RelativeLayout relativeLayout, CheckBox checkBox2, View view, TextView textView2, EditText editText2, CheckBox checkBox3, LinearLayout linearLayout4, TimerButton timerButton, TextView textView3, TextView textView4) {
        this.f36161a = nestedScrollView;
        this.f36162b = imageButton;
        this.f36163c = editText;
        this.f36164d = textView;
        this.f36165e = checkBox;
        this.f36166f = linearLayout;
        this.f36167g = button;
        this.f36168h = linearLayout3;
        this.f36169i = relativeLayout;
        this.f36170j = checkBox2;
        this.f36171k = view;
        this.f36172l = textView2;
        this.f36173m = editText2;
        this.f36174n = checkBox3;
        this.f36175o = linearLayout4;
        this.f36176p = timerButton;
        this.f36177q = textView3;
        this.f36178r = textView4;
    }

    public static a b(View view) {
        View a10;
        int i10 = e.f32629c;
        ImageButton imageButton = (ImageButton) b.a(view, i10);
        if (imageButton != null) {
            i10 = e.f32631d;
            EditText editText = (EditText) b.a(view, i10);
            if (editText != null) {
                i10 = e.f32633e;
                TextView textView = (TextView) b.a(view, i10);
                if (textView != null) {
                    i10 = e.f32657q;
                    CheckBox checkBox = (CheckBox) b.a(view, i10);
                    if (checkBox != null) {
                        i10 = e.G;
                        LinearLayout linearLayout = (LinearLayout) b.a(view, i10);
                        if (linearLayout != null) {
                            i10 = e.H;
                            LinearLayout linearLayout2 = (LinearLayout) b.a(view, i10);
                            if (linearLayout2 != null) {
                                i10 = e.J;
                                Button button = (Button) b.a(view, i10);
                                if (button != null) {
                                    i10 = e.K;
                                    LinearLayout linearLayout3 = (LinearLayout) b.a(view, i10);
                                    if (linearLayout3 != null) {
                                        i10 = e.L;
                                        RelativeLayout relativeLayout = (RelativeLayout) b.a(view, i10);
                                        if (relativeLayout != null) {
                                            i10 = e.M;
                                            CheckBox checkBox2 = (CheckBox) b.a(view, i10);
                                            if (!(checkBox2 == null || (a10 = b.a(view, (i10 = e.N))) == null)) {
                                                i10 = e.O;
                                                TextView textView2 = (TextView) b.a(view, i10);
                                                if (textView2 != null) {
                                                    i10 = e.f32626a0;
                                                    EditText editText2 = (EditText) b.a(view, i10);
                                                    if (editText2 != null) {
                                                        i10 = e.f32628b0;
                                                        CheckBox checkBox3 = (CheckBox) b.a(view, i10);
                                                        if (checkBox3 != null) {
                                                            i10 = e.f32638g0;
                                                            LinearLayout linearLayout4 = (LinearLayout) b.a(view, i10);
                                                            if (linearLayout4 != null) {
                                                                i10 = e.f32640h0;
                                                                TimerButton timerButton = (TimerButton) b.a(view, i10);
                                                                if (timerButton != null) {
                                                                    i10 = e.f32644j0;
                                                                    TextView textView3 = (TextView) b.a(view, i10);
                                                                    if (textView3 != null) {
                                                                        i10 = e.f32652n0;
                                                                        TextView textView4 = (TextView) b.a(view, i10);
                                                                        if (textView4 != null) {
                                                                            return new a((NestedScrollView) view, imageButton, editText, textView, checkBox, linearLayout, linearLayout2, button, linearLayout3, relativeLayout, checkBox2, a10, textView2, editText2, checkBox3, linearLayout4, timerButton, textView3, textView4);
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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

    public static a d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(f.f32681e, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return b(inflate);
    }

    /* renamed from: c */
    public NestedScrollView a() {
        return this.f36161a;
    }
}
