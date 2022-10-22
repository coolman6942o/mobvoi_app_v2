package rj;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import p1.a;
import p1.b;
/* compiled from: RecordItemRecordsBinding.java */
/* loaded from: classes2.dex */
public final class h implements a {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f33589a;

    /* renamed from: b  reason: collision with root package name */
    public final Button f33590b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f33591c;

    /* renamed from: d  reason: collision with root package name */
    public final LinearLayout f33592d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f33593e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f33594f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f33595g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f33596h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f33597i;

    /* renamed from: j  reason: collision with root package name */
    public final TextView f33598j;

    /* renamed from: k  reason: collision with root package name */
    public final TextView f33599k;

    private h(RelativeLayout relativeLayout, Button button, ImageView imageView, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7) {
        this.f33589a = relativeLayout;
        this.f33590b = button;
        this.f33591c = imageView;
        this.f33592d = linearLayout2;
        this.f33593e = textView;
        this.f33594f = textView2;
        this.f33595g = textView3;
        this.f33596h = textView4;
        this.f33597i = textView5;
        this.f33598j = textView6;
        this.f33599k = textView7;
    }

    public static h b(View view) {
        int i10 = com.mobvoi.record.h.f20606m;
        Button button = (Button) b.a(view, i10);
        if (button != null) {
            i10 = com.mobvoi.record.h.J;
            ImageView imageView = (ImageView) b.a(view, i10);
            if (imageView != null) {
                i10 = com.mobvoi.record.h.X;
                LinearLayout linearLayout = (LinearLayout) b.a(view, i10);
                if (linearLayout != null) {
                    i10 = com.mobvoi.record.h.f20581c0;
                    LinearLayout linearLayout2 = (LinearLayout) b.a(view, i10);
                    if (linearLayout2 != null) {
                        i10 = com.mobvoi.record.h.f20633z0;
                        TextView textView = (TextView) b.a(view, i10);
                        if (textView != null) {
                            i10 = com.mobvoi.record.h.K0;
                            TextView textView2 = (TextView) b.a(view, i10);
                            if (textView2 != null) {
                                i10 = com.mobvoi.record.h.N0;
                                TextView textView3 = (TextView) b.a(view, i10);
                                if (textView3 != null) {
                                    i10 = com.mobvoi.record.h.R0;
                                    TextView textView4 = (TextView) b.a(view, i10);
                                    if (textView4 != null) {
                                        i10 = com.mobvoi.record.h.W0;
                                        TextView textView5 = (TextView) b.a(view, i10);
                                        if (textView5 != null) {
                                            i10 = com.mobvoi.record.h.f20579b1;
                                            TextView textView6 = (TextView) b.a(view, i10);
                                            if (textView6 != null) {
                                                i10 = com.mobvoi.record.h.f20591f1;
                                                TextView textView7 = (TextView) b.a(view, i10);
                                                if (textView7 != null) {
                                                    return new h((RelativeLayout) view, button, imageView, linearLayout, linearLayout2, textView, textView2, textView3, textView4, textView5, textView6, textView7);
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

    /* renamed from: c */
    public RelativeLayout a() {
        return this.f33589a;
    }
}
