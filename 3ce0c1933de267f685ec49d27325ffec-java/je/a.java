package je;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import ge.l;
import java.util.Objects;
/* compiled from: FragmentDeviceContainerBinding.java */
/* loaded from: classes2.dex */
public final class a implements p1.a {

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f29551a;

    /* renamed from: b  reason: collision with root package name */
    public final FrameLayout f29552b;

    private a(FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.f29551a = frameLayout;
        this.f29552b = frameLayout2;
    }

    public static a b(View view) {
        Objects.requireNonNull(view, "rootView");
        FrameLayout frameLayout = (FrameLayout) view;
        return new a(frameLayout, frameLayout);
    }

    public static a d(LayoutInflater layoutInflater) {
        return e(layoutInflater, null, false);
    }

    public static a e(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(l.c_res_0x7f0e00c6, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return b(inflate);
    }

    /* renamed from: c */
    public FrameLayout a() {
        return this.f29551a;
    }
}
