package oc;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mobvoi.companion.R;
import com.mobvoi.qr.QRCodeReaderView;
import p1.a;
import p1.b;
/* compiled from: FragmentQrScanBinding.java */
/* loaded from: classes2.dex */
public final class n implements a {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f31550a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f31551b;

    /* renamed from: c  reason: collision with root package name */
    public final QRCodeReaderView f31552c;

    private n(RelativeLayout relativeLayout, TextView textView, ImageView imageView, QRCodeReaderView qRCodeReaderView, TextView textView2) {
        this.f31550a = relativeLayout;
        this.f31551b = textView;
        this.f31552c = qRCodeReaderView;
    }

    public static n b(View view) {
        int i10 = R.id.local_qr;
        TextView textView = (TextView) b.a(view, i10);
        if (textView != null) {
            i10 = R.id.qr_window;
            ImageView imageView = (ImageView) b.a(view, i10);
            if (imageView != null) {
                i10 = R.id.qrdecoderview;
                QRCodeReaderView qRCodeReaderView = (QRCodeReaderView) b.a(view, i10);
                if (qRCodeReaderView != null) {
                    i10 = R.id.tip_action;
                    TextView textView2 = (TextView) b.a(view, i10);
                    if (textView2 != null) {
                        return new n((RelativeLayout) view, textView, imageView, qRCodeReaderView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    /* renamed from: c */
    public RelativeLayout a() {
        return this.f31550a;
    }
}
