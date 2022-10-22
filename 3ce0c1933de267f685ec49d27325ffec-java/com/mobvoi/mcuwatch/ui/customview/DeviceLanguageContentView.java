package com.mobvoi.mcuwatch.ui.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.mobvoi.android.common.utils.b;
import com.mobvoi.companion.ui.e;
import java.util.HashMap;
import java.util.List;
import sh.h;
import sh.i;
/* loaded from: classes2.dex */
public class DeviceLanguageContentView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private LinearLayout f19582a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f19583b = true;

    /* renamed from: c  reason: collision with root package name */
    private final HashMap<String, Integer> f19584c = new HashMap<>();

    public DeviceLanguageContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private int a(int i10, Context context) {
        return i10 * (context.getResources().getDisplayMetrics().densityDpi / 160);
    }

    private void b() {
        this.f19584c.put("language_default", 0);
        this.f19584c.put("language_english", 1);
        this.f19584c.put("language_german", 2);
        this.f19584c.put("language_spanish", 3);
        this.f19584c.put("language_france", 4);
        this.f19584c.put("language_italy", 5);
        this.f19584c.put("language_rusia", 6);
        this.f19584c.put("language_japan", 7);
        this.f19584c.put("language_portugal", 8);
    }

    private void c(View view) {
        this.f19582a = (LinearLayout) view.findViewById(h.C0);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        c(LayoutInflater.from(getContext()).inflate(i.O, (ViewGroup) this, true));
        b();
    }

    public void setContentData(List<e> list) {
        if (!(list == null || list.isEmpty())) {
            this.f19582a.removeAllViews();
            if (list.size() > 6 && this.f19583b) {
                list = list.subList(0, 6);
            }
            if (list.size() > 0) {
                for (int i10 = 0; i10 < list.size(); i10++) {
                    e eVar = list.get(i10);
                    ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(new ViewGroup.LayoutParams(-1, -2));
                    if (i10 == 0) {
                        marginLayoutParams.setMargins(0, a(5, b.e()), 0, a(16, b.e()));
                    } else {
                        marginLayoutParams.setMargins(0, 0, 0, 0);
                    }
                    o oVar = new o(getContext());
                    oVar.a(eVar);
                    this.f19582a.addView(oVar, marginLayoutParams);
                }
            }
        }
    }

    public void setLanguageItemsCheckedIconVisible(String str) {
        View childAt;
        for (int i10 = 0; i10 < this.f19582a.getChildCount(); i10++) {
            this.f19582a.getChildAt(i10).findViewById(h.f34724z1).setVisibility(8);
        }
        if (!(this.f19584c.get(str) == null || (childAt = this.f19582a.getChildAt(this.f19584c.get(str).intValue())) == null)) {
            childAt.findViewById(h.f34724z1).setVisibility(0);
        }
    }

    public void setLimitDataLength(boolean z10) {
        this.f19583b = z10;
    }
}
