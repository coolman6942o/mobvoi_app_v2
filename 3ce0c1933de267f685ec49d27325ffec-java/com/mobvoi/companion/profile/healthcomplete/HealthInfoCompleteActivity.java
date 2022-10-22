package com.mobvoi.companion.profile.healthcomplete;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.u;
import ce.e;
import ce.f;
import ce.h;
import com.mobvoi.companion.WearableUiUtils;
import com.mobvoi.companion.base.m3.d;
import com.mobvoi.companion.base.ui.view.CustomViewPager;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class HealthInfoCompleteActivity extends d implements f {

    /* renamed from: a  reason: collision with root package name */
    private CustomViewPager f17342a;

    /* renamed from: e  reason: collision with root package name */
    private id.a f17346e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f17347f;

    /* renamed from: h  reason: collision with root package name */
    private Intent f17349h;

    /* renamed from: b  reason: collision with root package name */
    private List<Fragment> f17343b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private List<String> f17344c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private int f17345d = 0;

    /* renamed from: g  reason: collision with root package name */
    private List<a> f17348g = new ArrayList();

    /* loaded from: classes2.dex */
    public interface a {
        void q(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b extends u {
        public b(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // androidx.viewpager.widget.a
        public int d() {
            return HealthInfoCompleteActivity.this.f17343b.size();
        }

        @Override // androidx.fragment.app.u
        public Fragment t(int i10) {
            return (Fragment) HealthInfoCompleteActivity.this.f17343b.get(i10);
        }
    }

    private void J() {
        ta.a.G(true);
        this.f17346e.b(ta.a.e());
    }

    public void I() {
        int i10;
        if (this.f17345d < this.f17343b.size() && (i10 = this.f17345d) > 0) {
            if (this.f17343b.get(i10).getView() != null) {
                this.f17343b.get(this.f17345d).getView().setAlpha(0.3f);
            }
            if (this.f17343b.get(this.f17345d - 1).getView() != null) {
                this.f17343b.get(this.f17345d - 1).getView().setAlpha(1.0f);
            }
        }
        if (this.f17345d == 2 && this.f17343b.get(0).getView() != null) {
            this.f17343b.get(0).getView().setAlpha(0.3f);
        }
    }

    public void K() {
        if (this.f17345d < this.f17343b.size() - 1) {
            if (this.f17343b.get(this.f17345d).getView() != null) {
                this.f17343b.get(this.f17345d).getView().setAlpha(0.3f);
            }
            if (this.f17343b.get(this.f17345d + 1).getView() != null) {
                this.f17343b.get(this.f17345d + 1).getView().setAlpha(1.0f);
            }
        }
    }

    public void L() {
        this.f17343b.add(new com.mobvoi.companion.profile.healthcomplete.b());
        this.f17343b.add(new com.mobvoi.companion.profile.healthcomplete.a());
        this.f17343b.add(new c());
        this.f17343b.add(new e());
        this.f17343b.add(new d());
        this.f17344c.add(getResources().getString(h.f5875u0));
        this.f17344c.add(getResources().getString(h.D));
        this.f17344c.add(getResources().getString(h.F));
        this.f17344c.add(getResources().getString(h.L));
        this.f17344c.add(getResources().getString(h.H));
        if (getIntent() != null) {
            this.f17349h = (Intent) getIntent().getParcelableExtra(WearableUiUtils.FOLLOW_INTENT);
        }
    }

    public void M() {
        CustomViewPager customViewPager = (CustomViewPager) findViewById(e.f5786l0);
        this.f17342a = customViewPager;
        customViewPager.setAdapter(new b(getSupportFragmentManager()));
        this.f17342a.setScanScroll(false);
        this.f17342a.setCurrentItem(0);
        this.f17346e = new id.a(getApplicationContext());
    }

    public void N(String str) {
        List<a> list = this.f17348g;
        if (list != null && list.size() > 0) {
            for (int i10 = 0; i10 < this.f17348g.size(); i10++) {
                a aVar = this.f17348g.get(i10);
                if (aVar != null) {
                    aVar.q(str);
                }
            }
        }
    }

    public void O() {
        Intent intent = this.f17349h;
        if (intent != null) {
            startActivity(intent);
        }
        finish();
    }

    public void Q(a aVar) {
        List<a> list;
        if (aVar != null && (list = this.f17348g) != null) {
            list.add(aVar);
        }
    }

    public void S(a aVar) {
        List<a> list;
        if (aVar != null && (list = this.f17348g) != null && list.contains(aVar)) {
            this.f17348g.remove(aVar);
        }
    }

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return f.f5822p;
    }

    @Override // com.mobvoi.companion.profile.healthcomplete.f
    public void m(int i10, String str) {
        if (i10 == 1) {
            this.f17347f = true;
            ta.a.c0(str);
        } else if (i10 == 2) {
            this.f17347f = true;
            ta.a.N(str);
        } else if (i10 == 3) {
            this.f17347f = true;
            ta.a.Z(Integer.parseInt(str));
        } else if (i10 == 4) {
            this.f17347f = true;
            ta.a.F(str);
        } else if (i10 == 5) {
            ta.a.a0(Integer.parseInt(str));
        }
    }

    @Override // com.mobvoi.companion.profile.healthcomplete.f
    public void next() {
        if (this.f17345d < this.f17343b.size() - 1) {
            K();
            CustomViewPager customViewPager = this.f17342a;
            int i10 = this.f17345d + 1;
            this.f17345d = i10;
            customViewPager.R(i10, true);
            return;
        }
        if (this.f17347f) {
            J();
        }
        O();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setTitle(h.U);
        L();
        M();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        List<a> list = this.f17348g;
        if (list != null && list.size() > 0) {
            this.f17348g.clear();
        }
    }

    @Override // com.mobvoi.companion.profile.healthcomplete.f
    public void z() {
        int i10 = this.f17345d;
        if (i10 >= 0 && i10 < this.f17343b.size()) {
            I();
            CustomViewPager customViewPager = this.f17342a;
            int i11 = this.f17345d - 1;
            this.f17345d = i11;
            customViewPager.R(i11, true);
        }
    }
}
