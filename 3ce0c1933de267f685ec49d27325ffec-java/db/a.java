package db;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.f;
import com.mobvoi.android.common.utils.b;
import eb.c;
import java.util.ArrayList;
import java.util.List;
/* compiled from: OverseaManager.java */
/* loaded from: classes2.dex */
public class a implements e {

    /* renamed from: c  reason: collision with root package name */
    private static final List<c> f25600c;

    /* renamed from: a  reason: collision with root package name */
    private String f25601a;

    /* renamed from: b  reason: collision with root package name */
    private String f25602b;

    static {
        ArrayList arrayList = new ArrayList();
        f25600c = arrayList;
        arrayList.add(new c(xa.a.a_res_0x7f080139, "google"));
    }

    @Override // db.e
    public List<c> a() {
        return f25600c;
    }

    @Override // db.e
    public void b(String str, int i10, int i11, Intent intent) {
        Log.e("aaaa", "onActivityResult() called with: type = [" + str + "], requestCode = [" + i10 + "], resultCode = [" + i11 + "], data = [" + intent + "]");
        Application e10 = b.e();
        if ("google".equals(str)) {
            c.b(e10).h(i10, i11, intent);
        }
    }

    @Override // db.e
    public void c(f fVar) {
        c.b(fVar).c(fVar, this.f25602b);
    }

    @Override // db.e
    public /* synthetic */ String d() {
        return d.b(this);
    }

    @Override // db.e
    public void e() {
    }

    @Override // db.e
    public void f(String str, String str2, String str3) {
        if ("google".equals(str)) {
            m(str2, str3);
        }
    }

    @Override // db.e
    public void g(Fragment fragment, String str, b bVar) {
        Application e10 = b.e();
        if ("google".equals(str)) {
            c.b(e10).f(fragment, bVar);
        }
    }

    @Override // db.e
    public boolean h() {
        return !TextUtils.isEmpty(l());
    }

    @Override // db.e
    public void i(Activity activity, b bVar) {
        c.b(activity).i(bVar);
    }

    @Override // db.e
    public /* synthetic */ void j() {
        d.a(this);
    }

    @Override // db.e
    public void k() {
        Application e10 = b.e();
        if (h() && ta.a.z()) {
            c.b(e10).g(e10);
        }
    }

    public String l() {
        return this.f25601a;
    }

    public void m(String str, String str2) {
        this.f25601a = str;
        this.f25602b = str2;
    }

    @Override // db.e
    public void release() {
    }
}
