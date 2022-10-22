package oc;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.mobvoi.companion.R;
import p1.a;
import p1.b;
/* compiled from: LayoutScreenshotNoDisconnectBinding.java */
/* loaded from: classes2.dex */
public final class r implements a {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f31563a;

    /* renamed from: b  reason: collision with root package name */
    public final LinearLayout f31564b;

    private r(LinearLayout linearLayout, ImageView imageView, TextView textView, LinearLayout linearLayout2) {
        this.f31563a = linearLayout;
        this.f31564b = linearLayout2;
    }

    public static r b(View view) {
        int i10 = R.id.iv_bluetooth;
        ImageView imageView = (ImageView) b.a(view, i10);
        if (imageView != null) {
            i10 = R.id.tv_screenshot_tips;
            TextView textView = (TextView) b.a(view, i10);
            if (textView != null) {
                LinearLayout linearLayout = (LinearLayout) view;
                return new r(linearLayout, imageView, textView, linearLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    /* renamed from: c */
    public LinearLayout a() {
        return this.f31563a;
    }
}
