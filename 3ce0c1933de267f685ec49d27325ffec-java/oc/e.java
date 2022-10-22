package oc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mobvoi.companion.R;
import com.mobvoi.companion.view.RoundProgressBar;
import p1.a;
import p1.b;
/* compiled from: ActivityScreenshotBinding.java */
/* loaded from: classes2.dex */
public final class e implements a {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f31514a;

    /* renamed from: b  reason: collision with root package name */
    public final r f31515b;

    /* renamed from: c  reason: collision with root package name */
    public final RoundProgressBar f31516c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f31517d;

    /* renamed from: e  reason: collision with root package name */
    public final LinearLayout f31518e;

    private e(RelativeLayout relativeLayout, r rVar, RoundProgressBar roundProgressBar, TextView textView, LinearLayout linearLayout) {
        this.f31514a = relativeLayout;
        this.f31515b = rVar;
        this.f31516c = roundProgressBar;
        this.f31517d = textView;
        this.f31518e = linearLayout;
    }

    public static e b(View view) {
        int i10 = R.id.layout_no_disconnect;
        View a10 = b.a(view, i10);
        if (a10 != null) {
            r b10 = r.b(a10);
            i10 = R.id.progress_bar;
            RoundProgressBar roundProgressBar = (RoundProgressBar) b.a(view, i10);
            if (roundProgressBar != null) {
                i10 = R.id.progress_tv;
                TextView textView = (TextView) b.a(view, i10);
                if (textView != null) {
                    i10 = R.id.view_bluetooth_connect;
                    LinearLayout linearLayout = (LinearLayout) b.a(view, i10);
                    if (linearLayout != null) {
                        return new e((RelativeLayout) view, b10, roundProgressBar, textView, linearLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static e d(LayoutInflater layoutInflater) {
        return e(layoutInflater, null, false);
    }

    public static e e(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.activity_screenshot, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return b(inflate);
    }

    /* renamed from: c */
    public RelativeLayout a() {
        return this.f31514a;
    }
}
