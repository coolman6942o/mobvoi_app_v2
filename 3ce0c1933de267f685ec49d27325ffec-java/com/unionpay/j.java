package com.unionpay;

import android.app.AlertDialog;
import android.view.View;
import com.unionpay.utils.k;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class j implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ UPPayWapActivity f23305a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(UPPayWapActivity uPPayWapActivity) {
        this.f23305a = uPPayWapActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.f23305a);
        this.f23305a.f23252d = builder.create();
        builder.setMessage(k.a().f24586a);
        builder.setTitle(k.a().f24589d);
        builder.setPositiveButton(k.a().f24587b, new k(this));
        builder.setNegativeButton(k.a().f24588c, new l(this));
        builder.create().show();
    }
}
