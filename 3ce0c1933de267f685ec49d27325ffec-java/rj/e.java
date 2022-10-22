package rj;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import com.mobvoi.record.h;
import com.mobvoi.record.i;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import p1.a;
import p1.b;
/* compiled from: RecordFragmentRecordsBinding.java */
/* loaded from: classes2.dex */
public final class e implements a {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f33573a;

    /* renamed from: b  reason: collision with root package name */
    public final ImageView f33574b;

    /* renamed from: c  reason: collision with root package name */
    public final RecyclerView f33575c;

    /* renamed from: d  reason: collision with root package name */
    public final SmartRefreshLayout f33576d;

    /* renamed from: e  reason: collision with root package name */
    public final Toolbar f33577e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f33578f;

    private e(LinearLayout linearLayout, ImageView imageView, RecyclerView recyclerView, SmartRefreshLayout smartRefreshLayout, Toolbar toolbar, TextView textView) {
        this.f33573a = linearLayout;
        this.f33574b = imageView;
        this.f33575c = recyclerView;
        this.f33576d = smartRefreshLayout;
        this.f33577e = toolbar;
        this.f33578f = textView;
    }

    public static e b(View view) {
        int i10 = h.F;
        ImageView imageView = (ImageView) b.a(view, i10);
        if (imageView != null) {
            i10 = h.f20605l0;
            RecyclerView recyclerView = (RecyclerView) b.a(view, i10);
            if (recyclerView != null) {
                i10 = h.f20611o0;
                SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) b.a(view, i10);
                if (smartRefreshLayout != null) {
                    i10 = h.f20615q0;
                    Toolbar toolbar = (Toolbar) b.a(view, i10);
                    if (toolbar != null) {
                        i10 = h.f20594g1;
                        TextView textView = (TextView) b.a(view, i10);
                        if (textView != null) {
                            return new e((LinearLayout) view, imageView, recyclerView, smartRefreshLayout, toolbar, textView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static e d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(i.f20645l, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return b(inflate);
    }

    /* renamed from: c */
    public LinearLayout a() {
        return this.f33573a;
    }
}
