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
import com.mobvoi.mcuwatch.ui.settings.apollo.e;
import io.f;
import java.util.Objects;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.i;
import sh.k;
/* compiled from: NotificationSettingActivity.kt */
/* loaded from: classes2.dex */
public final class NotificationSettingActivity extends d {

    /* renamed from: a  reason: collision with root package name */
    private zh.b f20079a;

    /* renamed from: b  reason: collision with root package name */
    private final io.d f20080b;

    /* renamed from: c  reason: collision with root package name */
    private androidx.appcompat.app.c f20081c;

    /* compiled from: NotificationSettingActivity.kt */
    /* loaded from: classes2.dex */
    static final class a extends Lambda implements qo.a<r> {
        a() {
            super(0);
        }

        /* renamed from: a */
        public final r invoke() {
            return new r(NotificationSettingActivity.this);
        }
    }

    /* compiled from: NotificationSettingActivity.kt */
    /* loaded from: classes2.dex */
    public static final class b extends ClickableSpan {
        b() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            i.f(widget, "widget");
            NotificationSolutionActivity.f20084a.a(NotificationSettingActivity.this);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint ds) {
            i.f(ds, "ds");
            ds.setColor(NotificationSettingActivity.this.getColor(sh.d.f34447g));
            ds.setUnderlineText(false);
        }
    }

    /* compiled from: NotificationSettingActivity.kt */
    /* loaded from: classes2.dex */
    public static final class c extends e {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void g(CompoundButton compoundButton, boolean z10) {
            Object tag = compoundButton.getTag();
            Objects.requireNonNull(tag, "null cannot be cast to non-null type kotlin.String");
            String str = (String) tag;
        }

        @Override // com.mobvoi.mcuwatch.ui.settings.apollo.e
        public void c(e.b holder, e.a item) {
            i.f(holder, "holder");
            i.f(item, "item");
            holder.a().f37599c.setTag(item.c());
            SwitchMaterial switchMaterial = holder.a().f37599c;
            zh.b bVar = NotificationSettingActivity.this.f20079a;
            if (bVar != null) {
                switchMaterial.setEnabled(bVar.f37514d.isEnabled() && NotificationSettingActivity.this.O().h());
                holder.a().f37599c.setChecked(NotificationSettingActivity.this.O().i(item.c()));
                holder.a().f37599c.setOnCheckedChangeListener(r.f20106a);
                return;
            }
            i.u("binding");
            throw null;
        }
    }

    public NotificationSettingActivity() {
        io.d a10;
        a10 = f.a(new a());
        this.f20080b = a10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final r O() {
        return (r) this.f20080b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(NotificationSettingActivity this$0, CompoundButton compoundButton, boolean z10) {
        i.f(this$0, "this$0");
        if (z10) {
            this$0.O().x(z10);
            zh.b bVar = this$0.f20079a;
            if (bVar != null) {
                RecyclerView.Adapter adapter = bVar.f37513c.getAdapter();
                if (adapter != null) {
                    adapter.notifyDataSetChanged();
                    return;
                }
                return;
            }
            i.u("binding");
            throw null;
        }
        this$0.U();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(NotificationSettingActivity this$0, DialogInterface dialog, int i10) {
        i.f(this$0, "this$0");
        i.f(dialog, "dialog");
        dialog.dismiss();
        this$0.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(NotificationSettingActivity this$0, DialogInterface noName_0, int i10) {
        i.f(this$0, "this$0");
        i.f(noName_0, "$noName_0");
        this$0.startActivity(new Intent("android.settings.ACTION_NOTIFICATION_LISTENER_SETTINGS"));
    }

    @SuppressLint({"NotifyDataSetChanged"})
    private final void U() {
        new k7.b(this).h(k.Q4).d(false).j(k.f34848p0, new DialogInterface.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.settings.apollo.p
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                NotificationSettingActivity.V(NotificationSettingActivity.this, dialogInterface, i10);
            }
        }).m(k.P4, new DialogInterface.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.settings.apollo.o
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                NotificationSettingActivity.W(NotificationSettingActivity.this, dialogInterface, i10);
            }
        }).t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(NotificationSettingActivity this$0, DialogInterface dialog, int i10) {
        i.f(this$0, "this$0");
        i.f(dialog, "dialog");
        dialog.dismiss();
        zh.b bVar = this$0.f20079a;
        if (bVar != null) {
            bVar.f37514d.setChecked(true);
        } else {
            i.u("binding");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(NotificationSettingActivity this$0, DialogInterface dialog, int i10) {
        i.f(this$0, "this$0");
        i.f(dialog, "dialog");
        dialog.dismiss();
        this$0.O().x(false);
        zh.b bVar = this$0.f20079a;
        if (bVar != null) {
            RecyclerView.Adapter adapter = bVar.f37513c.getAdapter();
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
        setTitle(k.R4);
        String string = getString(k.T4);
        i.e(string, "getString(R.string.watch_receive_notify_tip_1)");
        SpannableString spannableString = new SpannableString(string);
        spannableString.setSpan(new b(), string.length() - 6, string.length(), 33);
        zh.b bVar = this.f20079a;
        if (bVar != null) {
            bVar.f37512b.setText(spannableString);
            zh.b bVar2 = this.f20079a;
            if (bVar2 != null) {
                bVar2.f37512b.setMovementMethod(LinkMovementMethod.getInstance());
                zh.b bVar3 = this.f20079a;
                if (bVar3 != null) {
                    bVar3.f37514d.setEnabled(kc.d.a(this));
                    zh.b bVar4 = this.f20079a;
                    if (bVar4 != null) {
                        bVar4.f37514d.setChecked(O().h());
                        zh.b bVar5 = this.f20079a;
                        if (bVar5 != null) {
                            bVar5.f37514d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.mobvoi.mcuwatch.ui.settings.apollo.q
                                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                                public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                                    NotificationSettingActivity.Q(NotificationSettingActivity.this, compoundButton, z10);
                                }
                            });
                            c cVar = new c();
                            zh.b bVar6 = this.f20079a;
                            if (bVar6 != null) {
                                bVar6.f37513c.setAdapter(cVar);
                                zh.b bVar7 = this.f20079a;
                                if (bVar7 != null) {
                                    bVar7.f37513c.h(new l7.a(this, 1));
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
        return sh.i.c_res_0x7f0e0021;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zh.b b10 = zh.b.b(getContentView().getChildAt(0));
        i.e(b10, "bind(contentView.getChildAt(0))");
        this.f20079a = b10;
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, android.app.Activity
    @SuppressLint({"NotifyDataSetChanged"})
    public void onResume() {
        androidx.appcompat.app.c cVar;
        super.onResume();
        boolean a10 = kc.d.a(this);
        zh.b bVar = this.f20079a;
        if (bVar != null) {
            if (bVar.f37514d.isEnabled() != a10) {
                zh.b bVar2 = this.f20079a;
                if (bVar2 != null) {
                    bVar2.f37514d.setEnabled(a10);
                    zh.b bVar3 = this.f20079a;
                    if (bVar3 != null) {
                        RecyclerView.Adapter adapter = bVar3.f37513c.getAdapter();
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
                this.f20081c = new k7.b(this).h(k.e_res_0x7f140063).d(false).j(k.M1, new DialogInterface.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.settings.apollo.m
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i10) {
                        NotificationSettingActivity.S(NotificationSettingActivity.this, dialogInterface, i10);
                    }
                }).m(k.N1, new DialogInterface.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.settings.apollo.n
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i10) {
                        NotificationSettingActivity.T(NotificationSettingActivity.this, dialogInterface, i10);
                    }
                }).t();
                return;
            }
            androidx.appcompat.app.c cVar2 = this.f20081c;
            if (cVar2 != null && cVar2.isShowing()) {
                z10 = true;
            }
            if (z10 && (cVar = this.f20081c) != null) {
                cVar.dismiss();
                return;
            }
            return;
        }
        i.u("binding");
        throw null;
    }
}
