package wi;

import android.view.LayoutInflater;
import android.widget.Toast;
import com.mobvoi.companion.base.m3.d;
import kotlin.jvm.internal.i;
import p1.a;
import qo.l;
/* compiled from: BaseToolbarVBActivity.kt */
/* loaded from: classes2.dex */
public abstract class c<VB extends a> extends d {

    /* renamed from: a  reason: collision with root package name */
    private final l<LayoutInflater, VB> f36245a;

    /* renamed from: b  reason: collision with root package name */
    public VB f36246b;

    /* JADX WARN: Multi-variable type inference failed */
    public c(l<? super LayoutInflater, ? extends VB> inflate) {
        i.f(inflate, "inflate");
        this.f36245a = inflate;
    }

    public final VB H() {
        VB vb2 = this.f36246b;
        if (vb2 != null) {
            return vb2;
        }
        i.u("binding");
        throw null;
    }

    public final void I(VB vb2) {
        i.f(vb2, "<set-?>");
        this.f36246b = vb2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void J(int i10) {
        Toast.makeText(this, i10, 0).show();
    }

    @Override // com.mobvoi.companion.base.m3.d, androidx.appcompat.app.d, androidx.activity.ComponentActivity, android.app.Activity
    public void setContentView(int i10) {
        l<LayoutInflater, VB> lVar = this.f36245a;
        LayoutInflater layoutInflater = getLayoutInflater();
        i.e(layoutInflater, "layoutInflater");
        I(lVar.invoke(layoutInflater));
        super.setContentView(H().a());
    }
}
