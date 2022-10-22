package hb;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.mobvoi.android.common.utils.k;
import db.b;
import db.e;
import java.lang.ref.WeakReference;
import pa.i;
/* compiled from: AuthPresenterImpl.java */
/* loaded from: classes2.dex */
public class a implements b, b {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<c> f27801a;

    /* renamed from: b  reason: collision with root package name */
    private final WeakReference<Fragment> f27802b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f27803c;

    /* renamed from: d  reason: collision with root package name */
    private final e f27804d;

    public a(Fragment fragment, c cVar) {
        e eVar = (e) kc.b.b().a(e.class);
        this.f27804d = eVar;
        this.f27803c = fragment.requireContext();
        this.f27802b = new WeakReference<>(fragment);
        this.f27801a = new WeakReference<>(cVar);
        if (eVar.h()) {
            eVar.i(fragment.requireActivity(), this);
        }
    }

    @Override // hb.b
    public void a(int i10, int i11, Intent intent) {
        this.f27804d.b("qq", i10, i11, intent);
    }

    @Override // hb.b
    public void c(String str) {
        Fragment fragment = this.f27802b.get();
        if (fragment != null) {
            this.f27804d.g(fragment, str, this);
        }
    }

    @Override // db.b
    public void d(String str, String str2) {
        this.f27801a.get().C();
        Toast.makeText(this.f27803c, i.f32703m, 0).show();
        k.c("LoginPresenterImpl", "authFail type : %s, msg : %s", str, str2);
    }

    @Override // db.b
    public void g(String str, String str2) {
    }

    @Override // qa.a
    public void unsubscribe() {
    }
}
