package com.mobvoi.mcuwatch.ui.onlinedial;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.r;
import androidx.viewpager.widget.ViewPager;
import cj.s;
import com.google.android.material.tabs.TabLayout;
import com.mobvoi.companion.base.m3.d;
import com.mobvoi.mcuwatch.engine.u;
import com.yc.pedometer.dial.OnlineDialUtil;
import nj.k;
import sh.f;
import sh.h;
import sh.i;
/* loaded from: classes2.dex */
public class OnlineDialActivity extends d {

    /* renamed from: a  reason: collision with root package name */
    ViewPager f19869a;

    /* renamed from: b  reason: collision with root package name */
    TabLayout f19870b;

    /* renamed from: c  reason: collision with root package name */
    private String[] f19871c;

    /* renamed from: d  reason: collision with root package name */
    private int[] f19872d = {f.L, f.M};

    /* renamed from: e  reason: collision with root package name */
    private s f19873e;

    /* renamed from: f  reason: collision with root package name */
    private com.mobvoi.mcuwatch.ui.onlinedial.a f19874f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements TabLayout.d {
        a() {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void a(TabLayout.g gVar) {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void b(TabLayout.g gVar) {
            OnlineDialActivity onlineDialActivity = OnlineDialActivity.this;
            onlineDialActivity.setTitle(onlineDialActivity.f19871c[gVar.g()]);
            OnlineDialActivity.this.M(gVar.g());
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void c(TabLayout.g gVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class b extends r {

        /* renamed from: h  reason: collision with root package name */
        private String[] f19876h;

        public b(FragmentManager fragmentManager, String[] strArr) {
            super(fragmentManager);
            this.f19876h = strArr;
        }

        @Override // androidx.viewpager.widget.a
        public int d() {
            String[] strArr = this.f19876h;
            if (strArr == null) {
                return 0;
            }
            return strArr.length;
        }

        @Override // androidx.viewpager.widget.a
        public CharSequence f(int i10) {
            return this.f19876h[i10];
        }

        @Override // androidx.fragment.app.r
        public Fragment t(int i10) {
            if (i10 == 0) {
                return OnlineDialActivity.this.f19873e;
            }
            if (i10 != 1) {
                return null;
            }
            return OnlineDialActivity.this.f19874f;
        }
    }

    private void L() {
        this.f19871c = getResources().getStringArray(sh.b.s_res_0x7f03001f);
        this.f19873e = s.i0();
        this.f19874f = com.mobvoi.mcuwatch.ui.onlinedial.a.f19878x.a();
        u.f19202a.I().d1(this.f19873e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M(int i10) {
        u.f19202a.I().d1(i10 == 0 ? this.f19873e : this.f19874f);
        OnlineDialUtil.j().l(i10 == 0 ? OnlineDialUtil.DialStatus.RegularDial : OnlineDialUtil.DialStatus.CustomDial);
    }

    private void initView() {
        this.f19869a.setAdapter(new b(getSupportFragmentManager(), this.f19871c));
        this.f19870b.setupWithViewPager(this.f19869a);
        for (int i10 = 0; i10 < this.f19872d.length; i10++) {
            this.f19870b.x(i10).p(this.f19872d[i10]);
        }
        this.f19870b.d(new a());
        M(0);
    }

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return i.p_res_0x7f0e0045;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        com.mobvoi.mcuwatch.ui.onlinedial.a aVar = this.f19874f;
        if (aVar != null) {
            aVar.onActivityResult(i10, i11, intent);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (!k.f31276a) {
            super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f19869a = (ViewPager) findViewById(h.f34635f2);
        this.f19870b = (TabLayout) findViewById(h.f34630e2);
        setTitle(sh.k.V2);
        L();
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        u.f19202a.I().d1(null);
    }
}
