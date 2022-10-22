package nf;

import android.os.Bundle;
import android.view.View;
import com.mobvoi.android.common.utils.k;
/* compiled from: MVPFragment.java */
/* loaded from: classes2.dex */
public abstract class e extends b {

    /* renamed from: b  reason: collision with root package name */
    private g f31234b;

    /* renamed from: c  reason: collision with root package name */
    private f f31235c;

    protected abstract f Z();

    protected abstract g a0();

    @Override // nf.b, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f31234b = a0();
    }

    @Override // nf.b, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f31234b.a();
        this.f31234b = null;
    }

    @Override // nf.b, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f31234b.d();
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z10) {
        super.onHiddenChanged(z10);
        k.c("mvp.ui.base", "Fragment %s hidden changed to %s", getClass().getSimpleName(), Boolean.valueOf(z10));
        if (z10) {
            this.f31235c.setViewModel(null);
        } else {
            this.f31235c.setViewModel(this.f31234b);
        }
    }

    @Override // nf.b, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        this.f31235c.setViewModel(null);
    }

    @Override // nf.b, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.f31235c.setViewModel(this.f31234b);
    }

    @Override // nf.b, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f31235c = Z();
        this.f31234b.b();
    }
}
