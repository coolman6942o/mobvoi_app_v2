package oc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.material.card.MaterialCardView;
import com.mobvoi.companion.R;
import com.mobvoi.companion.view.StarRatingView;
import p1.a;
import p1.b;
/* compiled from: DialogAppScoringBinding.java */
/* loaded from: classes2.dex */
public final class f implements a {

    /* renamed from: a  reason: collision with root package name */
    private final MaterialCardView f31519a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f31520b;

    /* renamed from: c  reason: collision with root package name */
    public final StarRatingView f31521c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f31522d;

    private f(MaterialCardView materialCardView, TextView textView, TextView textView2, View view, StarRatingView starRatingView, TextView textView3, TextView textView4) {
        this.f31519a = materialCardView;
        this.f31520b = textView;
        this.f31521c = starRatingView;
        this.f31522d = textView3;
    }

    public static f b(View view) {
        View a10;
        int i10 = R.id.cancel_btn;
        TextView textView = (TextView) b.a(view, i10);
        if (textView != null) {
            i10 = R.id.message;
            TextView textView2 = (TextView) b.a(view, i10);
            if (!(textView2 == null || (a10 = b.a(view, (i10 = R.id.middle_line))) == null)) {
                i10 = R.id.star_rating_view;
                StarRatingView starRatingView = (StarRatingView) b.a(view, i10);
                if (starRatingView != null) {
                    i10 = R.id.submit_btn;
                    TextView textView3 = (TextView) b.a(view, i10);
                    if (textView3 != null) {
                        i10 = R.id.title;
                        TextView textView4 = (TextView) b.a(view, i10);
                        if (textView4 != null) {
                            return new f((MaterialCardView) view, textView, textView2, a10, starRatingView, textView3, textView4);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static f d(LayoutInflater layoutInflater) {
        return e(layoutInflater, null, false);
    }

    public static f e(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.dialog_app_scoring, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return b(inflate);
    }

    /* renamed from: c */
    public MaterialCardView a() {
        return this.f31519a;
    }
}
