package rj;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.mobvoi.record.h;
import p1.a;
import p1.b;
/* compiled from: RecordLayoutRecordBottomBinding.java */
/* loaded from: classes2.dex */
public final class i implements a {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f33600a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f33601b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f33602c;

    private i(LinearLayout linearLayout, ImageView imageView, ImageView imageView2) {
        this.f33600a = linearLayout;
        this.f33601b = imageView;
        this.f33602c = imageView2;
    }

    public static i b(View view) {
        int i10 = h.C;
        ImageView imageView = (ImageView) b.a(view, i10);
        if (imageView != null) {
            i10 = h.I;
            ImageView imageView2 = (ImageView) b.a(view, i10);
            if (imageView2 != null) {
                return new i((LinearLayout) view, imageView, imageView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    /* renamed from: c */
    public LinearLayout a() {
        return this.f33600a;
    }
}
