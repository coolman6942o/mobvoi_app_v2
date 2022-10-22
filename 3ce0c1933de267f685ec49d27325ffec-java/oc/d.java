package oc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.mobvoi.companion.R;
import p1.a;
import p1.b;
/* compiled from: ActivityMedalDetailBinding.java */
/* loaded from: classes2.dex */
public final class d implements a {

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f31506a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f31507b;

    /* renamed from: c  reason: collision with root package name */
    public final Button f31508c;

    /* renamed from: d  reason: collision with root package name */
    public final ScrollView f31509d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f31510e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f31511f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f31512g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f31513h;

    private d(ScrollView scrollView, ImageView imageView, Button button, ScrollView scrollView2, ImageView imageView2, RelativeLayout relativeLayout, TextView textView, TextView textView2, TextView textView3) {
        this.f31506a = scrollView;
        this.f31507b = imageView;
        this.f31508c = button;
        this.f31509d = scrollView2;
        this.f31510e = imageView2;
        this.f31511f = textView;
        this.f31512g = textView2;
        this.f31513h = textView3;
    }

    public static d b(View view) {
        int i10 = R.id.bg_medal_detail;
        ImageView imageView = (ImageView) b.a(view, i10);
        if (imageView != null) {
            i10 = R.id.btn_get_medal;
            Button button = (Button) b.a(view, i10);
            if (button != null) {
                ScrollView scrollView = (ScrollView) view;
                i10 = R.id.iv_week_medal_detail;
                ImageView imageView2 = (ImageView) b.a(view, i10);
                if (imageView2 != null) {
                    i10 = R.id.rl_medal;
                    RelativeLayout relativeLayout = (RelativeLayout) b.a(view, i10);
                    if (relativeLayout != null) {
                        i10 = R.id.tv_current_month;
                        TextView textView = (TextView) b.a(view, i10);
                        if (textView != null) {
                            i10 = R.id.tv_current_week;
                            TextView textView2 = (TextView) b.a(view, i10);
                            if (textView2 != null) {
                                i10 = R.id.tv_week_sport_time;
                                TextView textView3 = (TextView) b.a(view, i10);
                                if (textView3 != null) {
                                    return new d(scrollView, imageView, button, scrollView, imageView2, relativeLayout, textView, textView2, textView3);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static d d(LayoutInflater layoutInflater) {
        return e(layoutInflater, null, false);
    }

    public static d e(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.activity_medal_detail, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return b(inflate);
    }

    /* renamed from: c */
    public ScrollView a() {
        return this.f31506a;
    }
}
