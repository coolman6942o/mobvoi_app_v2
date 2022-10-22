package wi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;
import kotlin.jvm.internal.i;
import p1.a;
import qo.l;
import sh.h;
/* compiled from: BaseVBActivity.kt */
/* loaded from: classes2.dex */
public abstract class d<VB extends a> extends com.mobvoi.companion.base.m3.a {

    /* renamed from: a  reason: collision with root package name */
    private final l<LayoutInflater, VB> f36247a;

    /* renamed from: b  reason: collision with root package name */
    public VB f36248b;

    /* renamed from: c  reason: collision with root package name */
    public Toolbar f36249c;

    /* JADX WARN: Multi-variable type inference failed */
    public d(l<? super LayoutInflater, ? extends VB> inflate) {
        i.f(inflate, "inflate");
        this.f36247a = inflate;
    }

    private final void G(ViewGroup viewGroup, View view, ViewGroup.LayoutParams layoutParams) {
        if (viewGroup != null && view != null) {
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, -1);
            }
            viewGroup.addView(view, layoutParams);
        }
    }

    public final VB H() {
        VB vb2 = this.f36248b;
        if (vb2 != null) {
            return vb2;
        }
        i.u("binding");
        throw null;
    }

    public final Toolbar I() {
        Toolbar toolbar = this.f36249c;
        if (toolbar != null) {
            return toolbar;
        }
        i.u("mToolbar");
        throw null;
    }

    protected abstract boolean J();

    public final void K(VB vb2) {
        i.f(vb2, "<set-?>");
        this.f36248b = vb2;
    }

    public final void L(TextView textView) {
        i.f(textView, "<set-?>");
    }

    public final void M(Toolbar toolbar) {
        i.f(toolbar, "<set-?>");
        this.f36249c = toolbar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void N(int i10) {
        Toast.makeText(this, i10, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void O(String str) {
        Toast.makeText(this, str, 0).show();
    }

    @Override // com.mobvoi.companion.base.m3.a
    public boolean needFitsSystemWindows() {
        return true;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 1) {
            getFragmentManager().popBackStack();
        } else {
            androidx.core.app.a.p(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.a, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(sh.i.K);
        View findViewById = findViewById(h.f34671n3);
        i.e(findViewById, "findViewById(R.id.title_tv)");
        L((TextView) findViewById);
        if (!J()) {
            View findViewById2 = findViewById(h.f34675o3);
            i.e(findViewById2, "findViewById(R.id.toolbar)");
            M((Toolbar) findViewById2);
            I().setVisibility(0);
        }
        l<LayoutInflater, VB> lVar = this.f36247a;
        LayoutInflater layoutInflater = getLayoutInflater();
        i.e(layoutInflater, "layoutInflater");
        K(lVar.invoke(layoutInflater));
        G((LinearLayout) findViewById(h.O), H().a(), null);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem item) {
        i.f(item, "item");
        if (item.getItemId() != 16908332) {
            return super.onOptionsItemSelected(item);
        }
        onBackPressed();
        return true;
    }
}
