package pe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import ne.w;
import ne.x;
import p1.a;
/* compiled from: FeedbackDeviceTypeItemBinding.java */
/* loaded from: classes2.dex */
public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f32762a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f32763b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f32764c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f32765d;

    private b(FrameLayout frameLayout, TextView textView, ImageView imageView, TextView textView2) {
        this.f32762a = frameLayout;
        this.f32763b = textView;
        this.f32764c = imageView;
        this.f32765d = textView2;
    }

    public static b b(View view) {
        int i10 = w.f31189d;
        TextView textView = (TextView) p1.b.a(view, i10);
        if (textView != null) {
            i10 = w.f31205t;
            ImageView imageView = (ImageView) p1.b.a(view, i10);
            if (imageView != null) {
                i10 = w.f31206u;
                TextView textView2 = (TextView) p1.b.a(view, i10);
                if (textView2 != null) {
                    return new b((FrameLayout) view, textView, imageView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static b d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(x.f31210d, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return b(inflate);
    }

    /* renamed from: c */
    public FrameLayout a() {
        return this.f32762a;
    }
}
