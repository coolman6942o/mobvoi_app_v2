package com.mobvoi.companion.aw.ui.quickcontrol;

import android.os.Bundle;
import androidx.navigation.NavController;
import androidx.navigation.e;
import androidx.navigation.m;
import androidx.navigation.s;
import com.mobvoi.companion.base.m3.d;
import io.f;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.i;
import od.b;
import od.c;
/* compiled from: QuickControlActivity.kt */
/* loaded from: classes2.dex */
public final class QuickControlActivity extends d {

    /* renamed from: a  reason: collision with root package name */
    private final io.d f16332a;

    /* compiled from: QuickControlActivity.kt */
    /* loaded from: classes2.dex */
    static final class a extends Lambda implements qo.a<String> {
        a() {
            super(0);
        }

        @Override // qo.a
        public final String invoke() {
            return QuickControlActivity.this.getIntent().getStringExtra("node_id_key");
        }
    }

    public QuickControlActivity() {
        io.d a10;
        a10 = f.a(new a());
        this.f16332a = a10;
    }

    private final String H() {
        return (String) this.f16332a.getValue();
    }

    private final void I() {
        NavController a10 = s.a(this, b.k_res_0x7f0b04c0);
        i.e(a10, "findNavController(this, R.id.nav_quick_control_fragment)");
        m k10 = a10.k();
        i.e(k10, "controller.graph");
        e a11 = new e.a().b(H()).a();
        i.e(a11, "Builder()\n            .setDefaultValue(mNodeId)\n            .build()");
        k10.a("node_id_key", a11);
    }

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return c.c_res_0x7f0e004b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        I();
    }
}
