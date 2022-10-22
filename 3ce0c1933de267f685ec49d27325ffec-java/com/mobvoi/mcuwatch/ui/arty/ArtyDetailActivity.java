package com.mobvoi.mcuwatch.ui.arty;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import com.mobvoi.mcuwatch.ui.arty.widget.ArtyDataTitleView;
import com.mobvoi.mcuwatch.ui.arty.widget.d;
import gg.e;
import java.util.ArrayList;
import java.util.List;
import sh.h;
import sh.i;
import ui.f;
import ui.o;
/* loaded from: classes2.dex */
public class ArtyDetailActivity extends com.mobvoi.companion.base.m3.a {

    /* renamed from: a  reason: collision with root package name */
    ViewPager f19304a;

    /* renamed from: b  reason: collision with root package name */
    c f19305b;

    /* renamed from: c  reason: collision with root package name */
    ArtyDataTitleView f19306c;

    /* renamed from: d  reason: collision with root package name */
    d f19307d;

    /* renamed from: e  reason: collision with root package name */
    f f19308e;

    /* renamed from: f  reason: collision with root package name */
    e f19309f;

    /* loaded from: classes2.dex */
    class a extends ViewPager.m {
        a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.m, androidx.viewpager.widget.ViewPager.j
        public void v(int i10) {
            ArtyDetailActivity.this.f19306c.setSelectTitleView(i10);
        }
    }

    /* loaded from: classes2.dex */
    class b implements ArtyDataTitleView.a {
        b() {
        }

        @Override // com.mobvoi.mcuwatch.ui.arty.widget.ArtyDataTitleView.a
        public void a() {
            ArtyDetailActivity.this.finish();
        }

        @Override // com.mobvoi.mcuwatch.ui.arty.widget.ArtyDataTitleView.a
        public void b(int i10) {
            ArtyDetailActivity.this.f19304a.setCurrentItem(i10);
        }
    }

    /* loaded from: classes2.dex */
    class c extends androidx.viewpager.widget.a {

        /* renamed from: c  reason: collision with root package name */
        List<o<e>> f19312c;

        c(List<o<e>> list) {
            this.f19312c = list;
        }

        @Override // androidx.viewpager.widget.a
        public void a(ViewGroup viewGroup, int i10, Object obj) {
            o<e> oVar = this.f19312c.get(i10);
            oVar.T();
            viewGroup.removeView(oVar);
        }

        @Override // androidx.viewpager.widget.a
        public int d() {
            return this.f19312c.size();
        }

        @Override // androidx.viewpager.widget.a
        public int e(Object obj) {
            return super.e(obj);
        }

        @Override // androidx.viewpager.widget.a
        public Object h(ViewGroup viewGroup, int i10) {
            o<e> oVar = this.f19312c.get(i10);
            oVar.setViewModel((o<e>) ArtyDetailActivity.this.f19309f);
            viewGroup.addView(oVar);
            return this.f19312c.get(i10);
        }

        @Override // androidx.viewpager.widget.a
        public boolean i(View view, Object obj) {
            return view == obj;
        }

        public void t(Bundle bundle) {
            List<o<e>> list = this.f19312c;
            if (list != null) {
                for (o<e> oVar : list) {
                    oVar.setArtyBundleData(bundle);
                }
            }
        }
    }

    @Override // com.mobvoi.companion.base.m3.a
    public boolean needFitsSystemWindows() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.a, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(i.Z0);
        this.f19304a = (ViewPager) findViewById(h.f34707v4);
        this.f19306c = (ArtyDataTitleView) findViewById(h.y_res_0x7f0b00ae);
        this.f19307d = new d(this);
        this.f19308e = new f(this);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f19308e);
        arrayList.add(this.f19307d);
        this.f19309f = new e();
        Bundle extras = getIntent().getExtras();
        this.f19306c.l(extras.getInt("data_type"), this.f19309f);
        c cVar = new c(arrayList);
        this.f19305b = cVar;
        this.f19304a.setAdapter(cVar);
        this.f19304a.c(new a());
        this.f19306c.setSelectTitleClickListener(new b());
        this.f19305b.t(extras);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f19306c.k();
    }
}
