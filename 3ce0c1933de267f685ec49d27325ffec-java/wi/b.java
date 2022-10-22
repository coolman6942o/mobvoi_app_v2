package wi;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import android.widget.Toast;
import androidx.appcompat.app.c;
import com.alipay.sdk.app.PayTask;
import com.mobvoi.mcuwatch.engine.m;
import com.mobvoi.mcuwatch.engine.s;
import com.mobvoi.mcuwatch.engine.u;
import ij.i;
import java.lang.ref.WeakReference;
import sh.k;
/* compiled from: BaseMcuVmActivity.java */
/* loaded from: classes2.dex */
public abstract class b extends e<i> implements m {

    /* renamed from: b  reason: collision with root package name */
    protected c f36239b;

    /* renamed from: c  reason: collision with root package name */
    protected Handler f36240c = new Handler(Looper.getMainLooper());

    /* renamed from: d  reason: collision with root package name */
    protected int f36241d = -1;

    /* renamed from: e  reason: collision with root package name */
    protected SparseArray<a> f36242e = new SparseArray<>();

    /* renamed from: f  reason: collision with root package name */
    protected boolean f36243f = true;

    /* renamed from: g  reason: collision with root package name */
    protected Runnable f36244g = new Runnable() { // from class: wi.a
        @Override // java.lang.Runnable
        public final void run() {
            b.this.S();
        }
    };

    /* compiled from: BaseMcuVmActivity.java */
    /* loaded from: classes2.dex */
    public interface a {
        void a(Object... objArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S() {
        Toast.makeText(this, getString(k.R2), 0).show();
        if (this.f36241d != -1) {
            N();
        } else {
            O();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void M(int i10, Object... objArr) {
        this.f36241d = i10;
        if (!ci.a.b().e()) {
            Toast.makeText(this, k.F3, 0).show();
            N();
        } else if (s.f19186a.d()) {
            Toast.makeText(this, k.J4, 0).show();
            N();
        } else {
            U();
            if (this.f36242e.get(this.f36241d) != null) {
                this.f36242e.get(this.f36241d).a(objArr);
            }
        }
    }

    protected abstract void N();

    protected void O() {
        c cVar;
        this.f36240c.removeCallbacksAndMessages(null);
        if (!isFinishing() && (cVar = this.f36239b) != null && cVar.isShowing()) {
            this.f36239b.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Q() {
        if (this.f36243f) {
            u.f19202a.i0(new WeakReference<>(this));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void T() {
        this.f36241d = -1;
        O();
    }

    protected void U() {
        if (this.f36239b == null) {
            this.f36239b = new ae.b().a(this);
        }
        if (!isFinishing() && !this.f36239b.isShowing()) {
            this.f36239b.show();
            this.f36239b.setCancelable(false);
        }
        this.f36240c.removeCallbacks(this.f36244g);
        this.f36240c.postDelayed(this.f36244g, PayTask.f6879j);
    }

    protected abstract void initView();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // wi.e, com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Q();
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // wi.e, com.mobvoi.companion.base.m3.d, androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f36240c.removeCallbacks(this.f36244g);
        this.f36242e.clear();
    }
}
