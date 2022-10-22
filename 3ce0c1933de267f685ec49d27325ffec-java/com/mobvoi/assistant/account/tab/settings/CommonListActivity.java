package com.mobvoi.assistant.account.tab.settings;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.mobvoi.android.common.utils.b;
import com.mobvoi.assistant.account.tab.settings.CommonListActivity;
import com.mobvoi.assistant.account.tab.webview.OverseaBrowserActivity;
import com.mobvoi.companion.base.m3.d;
import com.mobvoi.companion.setting.Constants;
import com.mobvoi.wear.common.base.TicwatchModels;
import mb.c;
import mb.g;
import ta.a;
/* loaded from: classes2.dex */
public class CommonListActivity extends d {

    /* renamed from: a  reason: collision with root package name */
    public TextView f15649a;

    /* renamed from: b  reason: collision with root package name */
    public LinearLayout f15650b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f15651c;

    /* renamed from: d  reason: collision with root package name */
    private int f15652d;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(String str, View view) {
        N(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(View view) {
        O("Ticwatch-AW");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M(View view) {
        O(TicwatchModels.TICWATCH1);
    }

    private void N(String str) {
        OverseaBrowserActivity.J(this, str);
    }

    private void O(String str) {
        S(str);
    }

    public static void Q(Context context, int i10) {
        Intent intent = new Intent(context, CommonListActivity.class);
        intent.putExtra("common_list_type", i10);
        context.startActivity(intent);
    }

    private void S(String str) {
        Intent intent = new Intent("com.mobvoi.companion.action.FEEDBACK");
        intent.putExtra("wwid", a.x());
        intent.putExtra("type", str);
        intent.setPackage(b.e().getPackageName());
        startActivity(intent);
    }

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return mb.d.a_res_0x7f0e0031;
    }

    protected void initView() {
        this.f15649a = (TextView) findViewById(c.l0_res_0x7f0b0803);
        this.f15650b = (LinearLayout) findViewById(c.x_res_0x7f0b03fb);
        this.f15651c = (LinearLayout) findViewById(c.z_res_0x7f0b0405);
        TextView textView = (TextView) findViewById(c.m0_res_0x7f0b0804);
        int i10 = this.f15652d;
        if (i10 == 0) {
            setTitle(g.f30638g);
            this.f15649a.setText(g.f30647u);
            final String str = lb.c.d() ? Constants.TICWATCH_TAIWAN_FAQ_URL : Constants.TICWATCH_FAQ_URL;
            this.f15650b.setOnClickListener(new View.OnClickListener() { // from class: bb.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CommonListActivity.this.K(str, view);
                }
            });
            this.f15651c.setVisibility(8);
        } else if (i10 == 1) {
            setTitle(g.f30640k);
            this.f15649a.setText(g.f30647u);
            this.f15651c.setVisibility(8);
            this.f15650b.setOnClickListener(new View.OnClickListener() { // from class: bb.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CommonListActivity.this.L(view);
                }
            });
            this.f15651c.setOnClickListener(new View.OnClickListener() { // from class: bb.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CommonListActivity.this.M(view);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f15652d = getIntent().getIntExtra("common_list_type", 0);
        initView();
    }
}
