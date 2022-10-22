package rj;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.mobvoi.record.h;
import p1.a;
import p1.b;
/* compiled from: RecordLayoutRedeemResultBinding.java */
/* loaded from: classes2.dex */
public final class j implements a {

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f33603a;

    /* renamed from: b  reason: collision with root package name */
    public final View f33604b;

    private j(ConstraintLayout constraintLayout, Button button, ImageView imageView, TextView textView, TextView textView2, View view) {
        this.f33603a = constraintLayout;
        this.f33604b = view;
    }

    public static j b(View view) {
        View a10;
        int i10 = h.f20600j;
        Button button = (Button) b.a(view, i10);
        if (button != null) {
            i10 = h.G;
            ImageView imageView = (ImageView) b.a(view, i10);
            if (imageView != null) {
                i10 = h.S0;
                TextView textView = (TextView) b.a(view, i10);
                if (textView != null) {
                    i10 = h.W0;
                    TextView textView2 = (TextView) b.a(view, i10);
                    if (!(textView2 == null || (a10 = b.a(view, (i10 = h.f20597h1))) == null)) {
                        return new j((ConstraintLayout) view, button, imageView, textView, textView2, a10);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    /* renamed from: c */
    public ConstraintLayout a() {
        return this.f33603a;
    }
}
