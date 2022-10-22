package com.mobvoi.companion.account;

import android.content.Context;
import android.content.Intent;
import uc.a;
import uc.b;
/* compiled from: BindSportSelectUtility.java */
/* loaded from: classes2.dex */
public class c implements a {
    @Override // uc.a
    public void a(Context context, b bVar) {
        Intent intent = new Intent();
        intent.setClass(context, DataBindActivity.class);
        context.startActivity(intent);
    }
}
