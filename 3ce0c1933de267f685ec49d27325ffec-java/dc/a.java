package dc;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.mobvoi.companion.aw.watchfacecenter.q;
import java.util.Objects;
/* compiled from: ActivityWatchfaceBinding.java */
/* loaded from: classes2.dex */
public final class a implements p1.a {

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f25605a;

    private a(FrameLayout frameLayout, FrameLayout frameLayout2) {
        this.f25605a = frameLayout;
    }

    public static a b(View view) {
        Objects.requireNonNull(view, "rootView");
        FrameLayout frameLayout = (FrameLayout) view;
        return new a(frameLayout, frameLayout);
    }

    public static a d(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z10) {
        View inflate = layoutInflater.inflate(q.a_res_0x7f0e006b, viewGroup, false);
        if (z10) {
            viewGroup.addView(inflate);
        }
        return b(inflate);
    }

    /* renamed from: c */
    public FrameLayout a() {
        return this.f25605a;
    }
}
