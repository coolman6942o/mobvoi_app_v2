package com.mobvoi.mcuwatch.ui.settings.apollo;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.lifecycle.x;
import ci.a;
import com.mobvoi.android.common.utils.m;
import com.mobvoi.apollo.client.q;
import com.mobvoi.companion.base.m3.d;
import com.mobvoi.mcuwatch.engine.n;
import com.mobvoi.mcuwatch.ui.settings.ota.f;
import k7.b;
import kotlin.jvm.internal.i;
import sh.h;
import sh.k;
import zh.c;
/* compiled from: ApolloOtaActivity.kt */
/* loaded from: classes2.dex */
public final class ApolloOtaActivity extends d implements f.a, View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private c f20072a;

    /* renamed from: b  reason: collision with root package name */
    private final com.mobvoi.mcuwatch.ui.settings.ota.c f20073b = new com.mobvoi.mcuwatch.ui.settings.ota.c();

    private final boolean L() {
        if (n.f19178a.e() < this.f20073b.c()) {
            new b(this).q(k.Z).D(getString(k.Y, new Object[]{Integer.valueOf(this.f20073b.c())})).I(getString(17039370), c.f20087a).t();
        } else if (m.b(this)) {
            return true;
        } else {
            Toast.makeText(this, k.G1, 0).show();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(DialogInterface dialogInterface, int i10) {
        dialogInterface.dismiss();
    }

    private final void N() {
        c cVar = this.f20072a;
        if (cVar != null) {
            cVar.f37517c.setVisibility(0);
            c cVar2 = this.f20072a;
            if (cVar2 != null) {
                cVar2.f37519e.setVisibility(8);
                c cVar3 = this.f20072a;
                if (cVar3 != null) {
                    cVar3.f37521g.setVisibility(0);
                    c cVar4 = this.f20072a;
                    if (cVar4 != null) {
                        cVar4.f37516b.setVisibility(0);
                        c cVar5 = this.f20072a;
                        if (cVar5 != null) {
                            cVar5.f37520f.setText(k.R1);
                            c cVar6 = this.f20072a;
                            if (cVar6 != null) {
                                cVar6.f37517c.setText(this.f20073b.i().f());
                                c cVar7 = this.f20072a;
                                if (cVar7 != null) {
                                    cVar7.f37521g.setText(getString(k.f34797e4, new Object[]{this.f20073b.a()}));
                                    c cVar8 = this.f20072a;
                                    if (cVar8 != null) {
                                        cVar8.f37518d.setProgress(0);
                                    } else {
                                        i.u("binding");
                                        throw null;
                                    }
                                } else {
                                    i.u("binding");
                                    throw null;
                                }
                            } else {
                                i.u("binding");
                                throw null;
                            }
                        } else {
                            i.u("binding");
                            throw null;
                        }
                    } else {
                        i.u("binding");
                        throw null;
                    }
                } else {
                    i.u("binding");
                    throw null;
                }
            } else {
                i.u("binding");
                throw null;
            }
        } else {
            i.u("binding");
            throw null;
        }
    }

    private final void O() {
        c cVar = this.f20072a;
        if (cVar != null) {
            cVar.f37520f.setText(k.S1);
            c cVar2 = this.f20072a;
            if (cVar2 != null) {
                cVar2.f37517c.setVisibility(0);
                c cVar3 = this.f20072a;
                if (cVar3 != null) {
                    cVar3.f37517c.setText(this.f20073b.a());
                    c cVar4 = this.f20072a;
                    if (cVar4 != null) {
                        cVar4.f37519e.setVisibility(8);
                        c cVar5 = this.f20072a;
                        if (cVar5 != null) {
                            cVar5.f37521g.setVisibility(8);
                            c cVar6 = this.f20072a;
                            if (cVar6 != null) {
                                cVar6.f37516b.setVisibility(8);
                                c cVar7 = this.f20072a;
                                if (cVar7 != null) {
                                    cVar7.f37518d.setProgress(0);
                                } else {
                                    i.u("binding");
                                    throw null;
                                }
                            } else {
                                i.u("binding");
                                throw null;
                            }
                        } else {
                            i.u("binding");
                            throw null;
                        }
                    } else {
                        i.u("binding");
                        throw null;
                    }
                } else {
                    i.u("binding");
                    throw null;
                }
            } else {
                i.u("binding");
                throw null;
            }
        } else {
            i.u("binding");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(ApolloOtaActivity this$0, String str) {
        i.f(this$0, "this$0");
        if (!(str == null || str.length() == 0)) {
            this$0.N();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(ApolloOtaActivity this$0, DialogInterface dialogInterface, int i10) {
        i.f(this$0, "this$0");
        dialogInterface.dismiss();
        this$0.N();
    }

    private final void T() {
        new b(this).q(k.Z).h(k.T1).I(getString(17039370), new DialogInterface.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.settings.apollo.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                ApolloOtaActivity.U(ApolloOtaActivity.this, dialogInterface, i10);
            }
        }).t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(ApolloOtaActivity this$0, DialogInterface dialogInterface, int i10) {
        i.f(this$0, "this$0");
        dialogInterface.dismiss();
        this$0.finish();
    }

    private final void V() {
        c cVar = this.f20072a;
        if (cVar != null) {
            cVar.f37517c.setVisibility(8);
            c cVar2 = this.f20072a;
            if (cVar2 != null) {
                cVar2.f37519e.setVisibility(0);
                c cVar3 = this.f20072a;
                if (cVar3 != null) {
                    cVar3.f37521g.setVisibility(0);
                    c cVar4 = this.f20072a;
                    if (cVar4 != null) {
                        cVar4.f37516b.setVisibility(8);
                        c cVar5 = this.f20072a;
                        if (cVar5 != null) {
                            cVar5.f37520f.setText(k.V1);
                        } else {
                            i.u("binding");
                            throw null;
                        }
                    } else {
                        i.u("binding");
                        throw null;
                    }
                } else {
                    i.u("binding");
                    throw null;
                }
            } else {
                i.u("binding");
                throw null;
            }
        } else {
            i.u("binding");
            throw null;
        }
    }

    @Override // com.mobvoi.mcuwatch.ui.settings.ota.f.a
    public void b(int i10) {
        c cVar = this.f20072a;
        if (cVar != null) {
            cVar.f37519e.setText(getString(k.f34775b0, new Object[]{Integer.valueOf(i10)}));
            c cVar2 = this.f20072a;
            if (cVar2 != null) {
                cVar2.f37518d.setProgress(i10);
            } else {
                i.u("binding");
                throw null;
            }
        } else {
            i.u("binding");
            throw null;
        }
    }

    @Override // com.mobvoi.mcuwatch.ui.settings.ota.f.a
    public void d(int i10) {
        if (i10 == 1 || i10 == 2) {
            V();
        } else if (i10 == 3) {
            T();
            q.v();
        } else if (i10 == 5) {
            N();
            new b(this).h(k.U1).I(getString(17039370), new DialogInterface.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.settings.apollo.b
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i11) {
                    ApolloOtaActivity.S(ApolloOtaActivity.this, dialogInterface, i11);
                }
            }).t();
        }
    }

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return sh.i.d_res_0x7f0e0022;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!(view != null && view.getId() == h.m0_res_0x7f0b0143)) {
            return;
        }
        if (!a.b().e()) {
            Toast.makeText(this, k.F3, 0).show();
        } else if (this.f20073b.d() && L()) {
            this.f20073b.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        c b10 = c.b(getContentView().getChildAt(0));
        i.e(b10, "bind(contentView.getChildAt(0))");
        this.f20072a = b10;
        if (b10 != null) {
            b10.f37518d.setMax(100);
            c cVar = this.f20072a;
            if (cVar != null) {
                cVar.f37516b.setOnClickListener(this);
                this.f20073b.g(this);
                this.f20073b.i().i(this, new x() { // from class: com.mobvoi.mcuwatch.ui.settings.apollo.d
                    @Override // androidx.lifecycle.x
                    public final void a(Object obj) {
                        ApolloOtaActivity.Q(ApolloOtaActivity.this, (String) obj);
                    }
                });
                O();
                return;
            }
            i.u("binding");
            throw null;
        }
        i.u("binding");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f20073b.release();
    }
}
