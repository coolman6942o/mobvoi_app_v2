package wi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.lifecycle.f0;
import androidx.lifecycle.h0;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.companion.base.m3.d;
/* compiled from: BaseVmActivity.java */
/* loaded from: classes2.dex */
public abstract class e<T extends f0> extends d {

    /* renamed from: a  reason: collision with root package name */
    private BroadcastReceiver f36250a = new a();

    /* compiled from: BaseVmActivity.java */
    /* loaded from: classes2.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            k.f("BaseVmActivity", "onReceive %s", action);
            if ("action.PAIR_SUCCESS".equals(action)) {
                e.this.J();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BaseVmActivity.java */
    /* loaded from: classes2.dex */
    public class b implements h0.b {
        b() {
        }

        @Override // androidx.lifecycle.h0.b
        public <VM extends f0> VM a(Class<VM> cls) {
            return (VM) e.this.H();
        }
    }

    protected T H() {
        return null;
    }

    protected abstract Class<T> I();

    protected void J() {
        finish();
    }

    protected boolean K() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        if (getIntent() != null) {
            getIntent().getStringExtra("mac_address");
        }
        super.onCreate(bundle);
        if (K()) {
            new h0(this, new b()).a(I());
        } else {
            new h0(this).a(I());
        }
        b1.a.b(this).c(this.f36250a, new IntentFilter("action.PAIR_SUCCESS"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        b1.a.b(this).e(this.f36250a);
    }
}
