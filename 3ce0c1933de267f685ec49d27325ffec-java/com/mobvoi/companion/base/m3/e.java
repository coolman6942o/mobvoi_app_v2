package com.mobvoi.companion.base.m3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import kotlin.jvm.internal.i;
import p1.a;
/* compiled from: BaseViewBindingToolbarActivity.kt */
/* loaded from: classes2.dex */
public abstract class e<VB extends a> extends d {

    /* renamed from: a  reason: collision with root package name */
    private VB f16572a;

    protected abstract VB H(LayoutInflater layoutInflater, ViewGroup viewGroup);

    public final VB I() {
        VB vb2 = this.f16572a;
        if (vb2 != null) {
            return vb2;
        }
        i.u("binding");
        throw null;
    }

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LayoutInflater layoutInflater = getLayoutInflater();
        i.e(layoutInflater, "layoutInflater");
        this.f16572a = H(layoutInflater, getContentView());
        setContentView(I().a());
    }
}
