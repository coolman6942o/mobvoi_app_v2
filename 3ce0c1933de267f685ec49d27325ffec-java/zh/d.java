package zh;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.mobvoi.mcuwatch.article.widget.ArticleTitleBar;
import p1.a;
import p1.b;
import sh.h;
import sh.i;
/* compiled from: ActivityArticleBinding.java */
/* loaded from: classes2.dex */
public final class d implements a {

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f37522a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f37523b;

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f37524c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f37525d;

    /* renamed from: e  reason: collision with root package name */
    public final ImageView f37526e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f37527f;

    /* renamed from: g  reason: collision with root package name */
    public final NestedScrollView f37528g;

    /* renamed from: h  reason: collision with root package name */
    public final ArticleTitleBar f37529h;

    private d(FrameLayout frameLayout, TextView textView, LinearLayout linearLayout, TextView textView2, ImageView imageView, TextView textView3, NestedScrollView nestedScrollView, ArticleTitleBar articleTitleBar) {
        this.f37522a = frameLayout;
        this.f37523b = textView;
        this.f37524c = linearLayout;
        this.f37525d = textView2;
        this.f37526e = imageView;
        this.f37527f = textView3;
        this.f37528g = nestedScrollView;
        this.f37529h = articleTitleBar;
    }

    public static d b(View view) {
        int i10 = h.j_res_0x7f0b009e;
        TextView textView = (TextView) b.a(view, i10);
        if (textView != null) {
            i10 = h.n_res_0x7f0b00a2;
            LinearLayout linearLayout = (LinearLayout) b.a(view, i10);
            if (linearLayout != null) {
                i10 = h.o_res_0x7f0b00a3;
                TextView textView2 = (TextView) b.a(view, i10);
                if (textView2 != null) {
                    i10 = h.q_res_0x7f0b00a5;
                    ImageView imageView = (ImageView) b.a(view, i10);
                    if (imageView != null) {
                        i10 = h.f34639g1;
                        TextView textView3 = (TextView) b.a(view, i10);
                        if (textView3 != null) {
                            i10 = h.O2;
                            NestedScrollView nestedScrollView = (NestedScrollView) b.a(view, i10);
                            if (nestedScrollView != null) {
                                i10 = h.f34636f3;
                                ArticleTitleBar articleTitleBar = (ArticleTitleBar) b.a(view, i10);
                                if (articleTitleBar != null) {
                                    return new d((FrameLayout) view, textView, linearLayout, textView2, imageView, textView3, nestedScrollView, articleTitleBar);
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
        View inflate = layoutInflater.inflate(i.f_res_0x7f0e0024, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return b(inflate);
    }

    /* renamed from: c */
    public FrameLayout a() {
        return this.f37522a;
    }
}
