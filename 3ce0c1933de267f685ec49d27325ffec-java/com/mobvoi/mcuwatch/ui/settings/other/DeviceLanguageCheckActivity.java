package com.mobvoi.mcuwatch.ui.settings.other;

import android.view.View;
import com.mobvoi.companion.ui.e;
import com.mobvoi.mcuwatch.engine.f;
import com.mobvoi.mcuwatch.engine.n;
import com.mobvoi.mcuwatch.engine.u;
import com.mobvoi.mcuwatch.ui.customview.DeviceLanguageContentView;
import com.mobvoi.mcuwatch.ui.settings.other.DeviceLanguageCheckActivity;
import ij.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sh.h;
import sh.k;
import wi.b;
/* loaded from: classes2.dex */
public class DeviceLanguageCheckActivity extends b {

    /* renamed from: h  reason: collision with root package name */
    DeviceLanguageContentView f20141h;

    /* renamed from: i  reason: collision with root package name */
    private String f20142i = n.f19178a.k();

    /* renamed from: j  reason: collision with root package name */
    private List<e> f20143j;

    /* renamed from: k  reason: collision with root package name */
    private Map<Integer, a> f20144k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        int f20145a;

        /* renamed from: b  reason: collision with root package name */
        String f20146b;

        /* renamed from: c  reason: collision with root package name */
        int f20147c;

        a(int i10, String str, int i11) {
            this.f20145a = i10;
            this.f20146b = str;
            this.f20147c = i11;
        }
    }

    private List<e> Y() {
        if (this.f20143j == null) {
            this.f20143j = new ArrayList();
        }
        this.f20143j.clear();
        this.f20143j.add(new e(k.U3, 0, new View.OnClickListener() { // from class: kj.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DeviceLanguageCheckActivity.this.Z(view);
            }
        }));
        ArrayList<Integer> integerArrayListExtra = getIntent().getIntegerArrayListExtra("display_lang");
        if (integerArrayListExtra != null && integerArrayListExtra.size() > 0) {
            for (Integer num : integerArrayListExtra) {
                final a aVar = this.f20144k.get(Integer.valueOf(num.intValue()));
                if (aVar != null) {
                    this.f20143j.add(new e(aVar.f20145a, 0, new View.OnClickListener() { // from class: com.mobvoi.mcuwatch.ui.settings.other.a
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            DeviceLanguageCheckActivity.this.a0(aVar, view);
                        }
                    }));
                }
            }
        }
        return this.f20143j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(View view) {
        this.f20142i = "language_default";
        this.f20141h.setLanguageItemsCheckedIconVisible("language_default");
        c0(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(a aVar, View view) {
        String str = aVar.f20146b;
        this.f20142i = str;
        this.f20141h.setLanguageItemsCheckedIconVisible(str);
        c0(aVar.f20147c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b0(Object[] objArr) {
        f.z(u.f19202a, ((Integer) objArr[0]).intValue());
    }

    private void c0(int i10) {
        n.f19178a.j0(false);
        M(0, Integer.valueOf(i10));
    }

    private void d0() {
        this.f20141h.setLanguageItemsCheckedIconVisible(n.f19178a.k());
    }

    @Override // wi.e
    protected Class<i> I() {
        return i.class;
    }

    @Override // wi.b
    protected void N() {
        if (this.f36241d == 0) {
            d0();
            T();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // wi.b
    public void Q() {
        super.Q();
        this.f36242e.put(0, kj.b.f29990a);
        HashMap hashMap = new HashMap();
        this.f20144k = hashMap;
        hashMap.put(2, new a(k.V3, "language_english", 2));
        this.f20144k.put(16, new a(k.X3, "language_german", 5));
        this.f20144k.put(32, new a(k.f34785c4, "language_spanish", 6));
        this.f20144k.put(64, new a(k.W3, "language_france", 7));
        this.f20144k.put(128, new a(k.Y3, "language_italy", 8));
        this.f20144k.put(8192, new a(k.f34779b4, "language_rusia", 14));
        this.f20144k.put(8, new a(k.Z3, "language_japan", 4));
        this.f20144k.put(256, new a(k.f34773a4, "language_portugal", 9));
    }

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return sh.i.f34760w;
    }

    @Override // wi.b
    protected void initView() {
        setTitle(k.E3);
        DeviceLanguageContentView deviceLanguageContentView = (DeviceLanguageContentView) findViewById(h.D0);
        this.f20141h = deviceLanguageContentView;
        deviceLanguageContentView.setLimitDataLength(false);
        this.f20141h.setContentData(Y());
        d0();
    }

    @Override // com.mobvoi.mcuwatch.engine.m
    public void p() {
        if (this.f36241d == 0) {
            n.f19178a.W(this.f20142i);
            T();
        }
    }
}
