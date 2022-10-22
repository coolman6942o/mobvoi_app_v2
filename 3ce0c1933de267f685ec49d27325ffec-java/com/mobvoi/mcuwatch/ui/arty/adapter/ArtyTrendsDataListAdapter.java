package com.mobvoi.mcuwatch.ui.arty.adapter;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import gg.f;
import j7.a;
import java.util.List;
import nj.u;
import sh.h;
import sh.i;
import ti.b;
/* loaded from: classes2.dex */
public class ArtyTrendsDataListAdapter extends BaseMultiItemQuickAdapter<b, BaseViewHolder> {

    /* renamed from: a  reason: collision with root package name */
    private final String[] f19314a;

    /* renamed from: b  reason: collision with root package name */
    private final String[] f19315b;

    /* renamed from: c  reason: collision with root package name */
    private final int[] f19316c;

    public ArtyTrendsDataListAdapter(Context context, List<b> list) {
        super(list);
        this.f19314a = context.getResources().getStringArray(sh.b.o_res_0x7f030017);
        this.f19315b = context.getResources().getStringArray(sh.b.m_res_0x7f030015);
        TypedArray obtainTypedArray = context.getResources().obtainTypedArray(sh.b.k_res_0x7f030013);
        this.f19316c = new int[obtainTypedArray.length()];
        for (int i10 = 0; i10 < obtainTypedArray.length(); i10++) {
            this.f19316c[i10] = obtainTypedArray.getColor(i10, 0);
        }
        obtainTypedArray.recycle();
        addItemType(0, i.Q0);
        addItemType(1, i.R0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public void convert(BaseViewHolder baseViewHolder, b bVar) {
        f b10;
        int i10;
        String str;
        String str2;
        int itemType = bVar.getItemType();
        if (itemType == 0) {
            baseViewHolder.getView(h.f34629e1).setBackground(new ColorDrawable(a.e(baseViewHolder.itemView, 16842808, -7829368)));
        } else if (itemType == 1 && (b10 = bVar.b()) != null) {
            TextView textView = (TextView) baseViewHolder.getView(h.K_res_0x7f0b00c4);
            TextView textView2 = (TextView) baseViewHolder.getView(h.C_res_0x7f0b00ba);
            int i11 = b10.f27465b;
            ((TextView) baseViewHolder.getView(h.G)).setText(u.b(b10.f27464a));
            ((TextView) baseViewHolder.getView(h.J_res_0x7f0b00c3)).setText(this.f19314a[bVar.a()]);
            if (b10 instanceof gg.b) {
                gg.b bVar2 = (gg.b) b10;
                textView.setText(bVar2.f27465b + "-" + bVar2.f27456c);
            } else {
                textView.setText(String.valueOf(i11));
            }
            int a10 = bVar.a();
            if (a10 == 0 || a10 == 2 || a10 == 3) {
                boolean z10 = a10 == 3;
                if (i11 >= 75) {
                    String[] strArr = this.f19315b;
                    str = z10 ? strArr[3] : strArr[0];
                    i10 = z10 ? this.f19316c[3] : this.f19316c[0];
                } else {
                    if (i11 >= 50) {
                        String[] strArr2 = this.f19315b;
                        str2 = z10 ? strArr2[2] : strArr2[1];
                        i10 = z10 ? this.f19316c[2] : this.f19316c[1];
                    } else if (i11 >= 25) {
                        String[] strArr3 = this.f19315b;
                        str2 = z10 ? strArr3[1] : strArr3[2];
                        i10 = z10 ? this.f19316c[1] : this.f19316c[2];
                    } else {
                        String[] strArr4 = this.f19315b;
                        str = z10 ? strArr4[0] : strArr4[3];
                        i10 = z10 ? this.f19316c[0] : this.f19316c[3];
                    }
                    str = str2;
                }
                textView2.setText(str);
                textView2.setTextColor(i10);
                textView2.setVisibility(0);
                return;
            }
            textView2.setVisibility(8);
        }
    }
}
