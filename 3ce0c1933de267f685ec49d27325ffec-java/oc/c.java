package oc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.mobvoi.companion.R;
import p1.a;
import p1.b;
/* compiled from: ActivityMedalCenterBinding.java */
/* loaded from: classes2.dex */
public final class c implements a {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayoutCompat f31503a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f31504b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f31505c;

    private c(LinearLayoutCompat linearLayoutCompat, ImageView imageView, LinearLayoutCompat linearLayoutCompat2, RecyclerView recyclerView, TextView textView) {
        this.f31503a = linearLayoutCompat;
        this.f31504b = imageView;
        this.f31505c = recyclerView;
    }

    public static c b(View view) {
        int i10 = R.id.back_img;
        ImageView imageView = (ImageView) b.a(view, i10);
        if (imageView != null) {
            LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) view;
            i10 = R.id.rv_medal_list;
            RecyclerView recyclerView = (RecyclerView) b.a(view, i10);
            if (recyclerView != null) {
                i10 = R.id.tvTitle;
                TextView textView = (TextView) b.a(view, i10);
                if (textView != null) {
                    return new c(linearLayoutCompat, imageView, linearLayoutCompat, recyclerView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static c d(LayoutInflater layoutInflater) {
        return e(layoutInflater, null, false);
    }

    public static c e(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(R.layout.activity_medal_center, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return b(inflate);
    }

    /* renamed from: c */
    public LinearLayoutCompat a() {
        return this.f31503a;
    }
}
