package pe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import ne.w;
import ne.x;
import p1.b;
/* compiled from: FeedbackDeviceItemBinding.java */
/* loaded from: classes2.dex */
public final class a implements p1.a {

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f32760a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f32761b;

    private a(FrameLayout frameLayout, TextView textView) {
        this.f32760a = frameLayout;
        this.f32761b = textView;
    }

    public static a b(View view) {
        int i10 = w.f31190e;
        TextView textView = (TextView) b.a(view, i10);
        if (textView != null) {
            return new a((FrameLayout) view, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static a d(LayoutInflater layoutInflater) {
        return e(layoutInflater, null, false);
    }

    public static a e(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(x.f31209c, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return b(inflate);
    }

    /* renamed from: c */
    public FrameLayout a() {
        return this.f32760a;
    }
}
