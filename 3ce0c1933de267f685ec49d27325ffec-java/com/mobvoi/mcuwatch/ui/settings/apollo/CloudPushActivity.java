package com.mobvoi.mcuwatch.ui.settings.apollo;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.CompoundButton;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.mobvoi.apollo.client.r;
import com.mobvoi.companion.base.m3.d;
import com.mobvoi.mcuwatch.ui.settings.apollo.CloudPushActivity;
import com.mobvoi.mcuwatch.ui.settings.apollo.e;
import io.f;
import java.util.Objects;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.i;
import sh.k;
/* compiled from: CloudPushActivity.kt */
/* loaded from: classes2.dex */
public final class CloudPushActivity extends d {

    /* renamed from: a  reason: collision with root package name */
    private zh.a f20074a;

    /* renamed from: b  reason: collision with root package name */
    private final io.d f20075b;

    /* renamed from: c  reason: collision with root package name */
    private androidx.appcompat.app.c f20076c;

    /* compiled from: CloudPushActivity.kt */
    /* loaded from: classes2.dex */
    static final class a extends Lambda implements qo.a<r> {
        a() {
            super(0);
        }

        /* renamed from: a */
        public final r invoke() {
            return new r(CloudPushActivity.this);
        }
    }

    /* compiled from: CloudPushActivity.kt */
    /* loaded from: classes2.dex */
    public static final class b extends ClickableSpan {
        b() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            i.f(widget, "widget");
            NotificationSolutionActivity.f20084a.b(CloudPushActivity.this);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds) {
            i.f(ds, "ds");
            ds.setColor(CloudPushActivity.this.getColor(sh.d.f34447g));
            ds.setUnderlineText(false);
        }
    }

    /* compiled from: CloudPushActivity.kt */
    /* loaded from: classes2.dex */
    public static final class c extends e {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(CloudPushActivity this$0, CompoundButton compoundButton, boolean z10) {
            i.f(this$0, "this$0");
            Object tag = compoundButton.getTag();
            Objects.requireNonNull(tag, "null cannot be cast to non-null type kotlin.String");
            this$0.O().z((String) tag, z10);
        }

        @Override // com.mobvoi.mcuwatch.ui.settings.apollo.e
        public void c(e.b holder, e.a item) {
            i.f(holder, "holder");
            i.f(item, "item");
            holder.a().f37599c.setTag(item.c());
            SwitchMaterial switchMaterial = holder.a().f37599c;
            zh.a aVar = CloudPushActivity.this.f20074a;
            if (aVar != null) {
                switchMaterial.setEnabled(aVar.f37510d.isEnabled() && CloudPushActivity.this.O().m());
                holder.a().f37599c.setChecked(CloudPushActivity.this.O().k(item.c()));
                SwitchMaterial switchMaterial2 = holder.a().f37599c;
                final CloudPushActivity cloudPushActivity = CloudPushActivity.this;
                switchMaterial2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.mobvoi.mcuwatch.ui.settings.apollo.l
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                        CloudPushActivity.c.g(CloudPushActivity.this, compoundButton, z10);
                    }
                });
                return;
            }
            i.u("binding");
            throw null;
        }
    }

    public CloudPushActivity() {
        io.d a10;
        a10 = f.a(new a());
        this.f20075b = a10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final r O() {
        return (r) this.f20075b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(CloudPushActivity this$0, CompoundButton compoundButton, boolean z10) {
        i.f(this$0, "this$0");
        if (z10) {
            this$0.U();
            return;
        }
        this$0.O().t(z10);
        zh.a aVar = this$0.f20074a;
        if (aVar != null) {
            RecyclerView.Adapter adapter = aVar.f37509c.getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
                return;
            }
            return;
        }
        i.u("binding");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(CloudPushActivity this$0, DialogInterface dialog, int i10) {
        i.f(this$0, "this$0");
        i.f(dialog, "dialog");
        dialog.dismiss();
        this$0.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(CloudPushActivity this$0, DialogInterface noName_0, int i10) {
        i.f(this$0, "this$0");
        i.f(noName_0, "$noName_0");
        this$0.startActivity(new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"));
    }

    @SuppressLint({"NotifyDataSetChanged"})
    private final void U() {
        new k7.b(this).q(k.f34813i0).h(k.f34808h0).d(false).j(k.f34848p0, new DialogInterface.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.settings.apollo.h
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                CloudPushActivity.V(CloudPushActivity.this, dialogInterface, i10);
            }
        }).m(k.f34818j0, new DialogInterface.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.settings.apollo.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                CloudPushActivity.W(CloudPushActivity.this, dialogInterface, i10);
            }
        }).t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(CloudPushActivity this$0, DialogInterface dialog, int i10) {
        i.f(this$0, "this$0");
        i.f(dialog, "dialog");
        dialog.dismiss();
        zh.a aVar = this$0.f20074a;
        if (aVar != null) {
            aVar.f37510d.setChecked(false);
        } else {
            i.u("binding");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(CloudPushActivity this$0, DialogInterface dialog, int i10) {
        i.f(this$0, "this$0");
        i.f(dialog, "dialog");
        dialog.dismiss();
        this$0.O().t(true);
        zh.a aVar = this$0.f20074a;
        if (aVar != null) {
            RecyclerView.Adapter adapter = aVar.f37509c.getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
                return;
            }
            return;
        }
        i.u("binding");
        throw null;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    private final void initView() {
        setTitle(k.f34833m0);
        String string = getString(k.f34828l0);
        i.e(string, "getString(R.string.cloud_push_tip_1)");
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new b(), string.length() - 6, string.length(), 33);
        zh.a aVar = this.f20074a;
        if (aVar != null) {
            aVar.f37508b.setText(spannableString);
            zh.a aVar2 = this.f20074a;
            if (aVar2 != null) {
                aVar2.f37508b.setMovementMethod(LinkMovementMethod.getInstance());
                zh.a aVar3 = this.f20074a;
                if (aVar3 != null) {
                    aVar3.f37510d.setEnabled(kc.d.a(this));
                    zh.a aVar4 = this.f20074a;
                    if (aVar4 != null) {
                        aVar4.f37510d.setChecked(O().m());
                        zh.a aVar5 = this.f20074a;
                        if (aVar5 != null) {
                            aVar5.f37510d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.mobvoi.mcuwatch.ui.settings.apollo.k
                                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                                public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                                    CloudPushActivity.Q(CloudPushActivity.this, compoundButton, z10);
                                }
                            });
                            c cVar = new c();
                            zh.a aVar6 = this.f20074a;
                            if (aVar6 != null) {
                                aVar6.f37509c.setAdapter(cVar);
                                zh.a aVar7 = this.f20074a;
                                if (aVar7 != null) {
                                    aVar7.f37509c.h(new l7.a(this, 1));
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

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return sh.i.b_res_0x7f0e0020;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zh.a b10 = zh.a.b(getContentView().getChildAt(0));
        i.e(b10, "bind(contentView.getChildAt(0))");
        this.f20074a = b10;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, android.app.Activity
    @SuppressLint({"NotifyDataSetChanged"})
    public void onResume() {
        androidx.appcompat.app.c cVar;
        super.onResume();
        boolean a10 = kc.d.a(this);
        zh.a aVar = this.f20074a;
        if (aVar != null) {
            if (aVar.f37510d.isEnabled() != a10) {
                zh.a aVar2 = this.f20074a;
                if (aVar2 != null) {
                    aVar2.f37510d.setEnabled(a10);
                    zh.a aVar3 = this.f20074a;
                    if (aVar3 != null) {
                        RecyclerView.Adapter adapter = aVar3.f37509c.getAdapter();
                        if (adapter != null) {
                            adapter.notifyDataSetChanged();
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
            boolean z10 = false;
            if (!a10) {
                this.f20076c = new k7.b(this).h(k.e_res_0x7f140063).d(false).j(k.M1, new DialogInterface.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.settings.apollo.i
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i10) {
                        CloudPushActivity.S(CloudPushActivity.this, dialogInterface, i10);
                    }
                }).m(k.N1, new DialogInterface.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.settings.apollo.j
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i10) {
                        CloudPushActivity.T(CloudPushActivity.this, dialogInterface, i10);
                    }
                }).t();
                return;
            }
            androidx.appcompat.app.c cVar2 = this.f20076c;
            if (cVar2 != null && cVar2.isShowing()) {
                z10 = true;
            }
            if (z10 && (cVar = this.f20076c) != null) {
                cVar.dismiss();
                return;
            }
            return;
        }
        i.u("binding");
        throw null;
    }
}
