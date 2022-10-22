package oc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.card.MaterialCardView;
import com.mobvoi.companion.R;
import p1.a;
import p1.b;
/* compiled from: LayoutCardMgrItemBinding.java */
/* loaded from: classes2.dex */
public final class q implements a {

    /* renamed from: a  reason: collision with root package name */
    private final MaterialCardView f31558a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f31559b;

    /* renamed from: c  reason: collision with root package name */
    public final ImageView f31560c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f31561d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f31562e;

    private q(MaterialCardView materialCardView, ImageView imageView, ImageView imageView2, TextView textView, TextView textView2) {
        this.f31558a = materialCardView;
        this.f31559b = imageView;
        this.f31560c = imageView2;
        this.f31561d = textView;
        this.f31562e = textView2;
    }

    public static q b(View view) {
        int i10 = R.id.iv_card_operate;
        ImageView imageView = (ImageView) b.a(view, i10);
        if (imageView != null) {
            i10 = R.id.iv_draggable;
            ImageView imageView2 = (ImageView) b.a(view, i10);
            if (imageView2 != null) {
                i10 = R.id.tv_card_desc;
                TextView textView = (TextView) b.a(view, i10);
                if (textView != null) {
                    i10 = R.id.tv_card_name;
                    TextView textView2 = (TextView) b.a(view, i10);
                    if (textView2 != null) {
                        return new q((MaterialCardView) view, imageView, imageView2, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static q d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.layout_card_mgr_item, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return b(inflate);
    }

    /* renamed from: c */
    public MaterialCardView a() {
        return this.f31558a;
    }
}
