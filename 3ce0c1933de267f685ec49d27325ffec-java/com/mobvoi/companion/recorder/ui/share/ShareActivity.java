package com.mobvoi.companion.recorder.ui.share;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;
import androidx.appcompat.app.d;
import com.mobvoi.wear.contacts.ContactConstant;
import com.unionpay.tsmservice.data.Constant;
import hd.a;
import hd.b;
import hd.c;
import hd.e;
import java.util.Arrays;
import java.util.Objects;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.n;
/* compiled from: ShareActivity.kt */
/* loaded from: classes2.dex */
public final class ShareActivity extends d implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private String f17404a;

    /* renamed from: b  reason: collision with root package name */
    private String f17405b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f17406c;

    /* renamed from: d  reason: collision with root package name */
    private View f17407d;

    /* renamed from: e  reason: collision with root package name */
    private View f17408e;

    /* renamed from: f  reason: collision with root package name */
    private View f17409f;

    private final void G() {
        if (getWindow() != null) {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.width = -1;
            attributes.height = -2;
            attributes.windowAnimations = e.f27814a;
            attributes.gravity = 80;
            getWindow().setAttributes(attributes);
        }
        View findViewById = findViewById(b.b_res_0x7f0b0615);
        i.e(findViewById, "findViewById(R.id.share_to_copy)");
        this.f17407d = findViewById;
        View findViewById2 = findViewById(b.c_res_0x7f0b0616);
        i.e(findViewById2, "findViewById(R.id.share_to_system)");
        this.f17408e = findViewById2;
        View findViewById3 = findViewById(b.f27811a);
        i.e(findViewById3, "findViewById(R.id.cancel)");
        this.f17409f = findViewById3;
        View view = this.f17407d;
        if (view != null) {
            view.setOnClickListener(this);
            View view2 = this.f17408e;
            if (view2 != null) {
                view2.setOnClickListener(this);
                View view3 = this.f17409f;
                if (view3 != null) {
                    view3.setOnClickListener(this);
                } else {
                    i.u(Constant.CASH_LOAD_CANCEL);
                    throw null;
                }
            } else {
                i.u("share_to_system");
                throw null;
            }
        } else {
            i.u("share_to_copy");
            throw null;
        }
    }

    private final void H() {
        n nVar = n.f30086a;
        String format = String.format("http://h5.mobvoi.com/vpa-record-share/dist/index.html?file_id=%s", Arrays.copyOf(new Object[]{this.f17404a}, 1));
        i.e(format, "java.lang.String.format(format, *args)");
        String string = getString(hd.d.f27813b);
        i.e(string, "getString(R.string.record_share_title)");
        ic.b.d(this, format, string, "", a.f27810a);
        finish();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Integer valueOf = view == null ? null : Integer.valueOf(view.getId());
        int i10 = b.b_res_0x7f0b0615;
        if (valueOf != null && valueOf.intValue() == i10) {
            Object systemService = getSystemService("clipboard");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.content.ClipboardManager");
            ((ClipboardManager) systemService).setPrimaryClip(ClipData.newPlainText("", this.f17405b));
            Toast.makeText(this, getString(hd.d.f27812a), 1).show();
            finish();
            return;
        }
        int i11 = b.c_res_0x7f0b0616;
        if (valueOf != null && valueOf.intValue() == i11) {
            H();
            return;
        }
        int i12 = b.f27811a;
        if (valueOf != null && valueOf.intValue() == i12) {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(c.a_res_0x7f0e0054);
        G();
        this.f17404a = getIntent().getStringExtra("id");
        getIntent().getStringExtra("url");
        getIntent().getStringExtra(ContactConstant.CallsRecordKeys.NAME);
        this.f17405b = getIntent().getStringExtra("text");
        boolean booleanExtra = getIntent().getBooleanExtra("converted", false);
        this.f17406c = booleanExtra;
        if (booleanExtra) {
            View view = this.f17407d;
            if (view != null) {
                view.setVisibility(0);
            } else {
                i.u("share_to_copy");
                throw null;
            }
        } else {
            View view2 = this.f17407d;
            if (view2 != null) {
                view2.setVisibility(8);
            } else {
                i.u("share_to_copy");
                throw null;
            }
        }
        ic.b.a(new ic.a());
    }
}
