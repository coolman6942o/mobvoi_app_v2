package com.unionpay.mobile.android.upwidget;

import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.unionpay.mobile.android.upwidget.j;
import java.util.ArrayList;
import java.util.Iterator;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class p implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f24105a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(j jVar) {
        this.f24105a = jVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i10;
        boolean z10;
        j.a[] aVarArr;
        j.a[] aVarArr2;
        ArrayList arrayList;
        j.a[] aVarArr3;
        int intValue = ((Integer) view.getTag()).intValue();
        i10 = this.f24105a.f24083o;
        if (intValue != i10) {
            this.f24105a.a(intValue);
            z10 = this.f24105a.f24073e;
            if (z10) {
                aVarArr = this.f24105a.f24074f;
                if (!TextUtils.isEmpty(aVarArr[intValue].f24098d)) {
                    aVarArr2 = this.f24105a.f24074f;
                    view.setTag(aVarArr2[intValue].f24098d);
                    arrayList = this.f24105a.f24091w;
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((View.OnClickListener) it.next()).onClick(view);
                    }
                    j jVar = this.f24105a;
                    aVarArr3 = jVar.f24074f;
                    jVar.a((LinearLayout) aVarArr3[intValue].f24097c, true, "正在查询。。。", null, null);
                    this.f24105a.f24073e = false;
                }
            }
            view.setTag(Integer.valueOf(intValue));
        }
    }
}
