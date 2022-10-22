package rj;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.mobvoi.record.h;
import com.mobvoi.record.i;
import p1.a;
import p1.b;
/* compiled from: RecordFragmentRemarkBinding.java */
/* loaded from: classes2.dex */
public final class g implements a {

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f33587a;

    /* renamed from: b  reason: collision with root package name */
    public final RecyclerView f33588b;

    private g(FrameLayout frameLayout, RecyclerView recyclerView) {
        this.f33587a = frameLayout;
        this.f33588b = recyclerView;
    }

    public static g b(View view) {
        int i10 = h.f20607m0;
        RecyclerView recyclerView = (RecyclerView) b.a(view, i10);
        if (recyclerView != null) {
            return new g((FrameLayout) view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i10)));
    }

    public static g d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(i.f20647n, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return b(inflate);
    }

    /* renamed from: c */
    public FrameLayout a() {
        return this.f33587a;
    }
}
