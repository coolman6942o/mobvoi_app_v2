package com.mobvoi.mcuwatch.ui.onlinedial.apollo;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.r;
import androidx.viewpager.widget.ViewPager;
import com.google.android.material.tabs.TabLayout;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.i;
import sh.f;
import sh.h;
import sh.k;
/* compiled from: ApolloOnlineDialActivity.kt */
/* loaded from: classes2.dex */
public final class ApolloOnlineDialActivity extends com.mobvoi.companion.base.m3.d {

    /* renamed from: a  reason: collision with root package name */
    private String[] f19903a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f19904b = {f.L, f.M};

    /* renamed from: c  reason: collision with root package name */
    private final io.d f19905c;

    /* renamed from: d  reason: collision with root package name */
    private final io.d f19906d;

    /* compiled from: ApolloOnlineDialActivity.kt */
    /* loaded from: classes2.dex */
    private final class a extends r {

        /* renamed from: h  reason: collision with root package name */
        final /* synthetic */ ApolloOnlineDialActivity f19907h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ApolloOnlineDialActivity this$0, FragmentManager fm2) {
            super(fm2, 1);
            i.f(this$0, "this$0");
            i.f(fm2, "fm");
            this.f19907h = this$0;
        }

        @Override // androidx.viewpager.widget.a
        public int d() {
            return 1;
        }

        @Override // androidx.viewpager.widget.a
        public CharSequence f(int i10) {
            String[] strArr = this.f19907h.f19903a;
            if (strArr != null) {
                return strArr[i10];
            }
            i.u("mTabArrays");
            throw null;
        }

        @Override // androidx.fragment.app.r
        public Fragment t(int i10) {
            return i10 == 0 ? this.f19907h.L() : this.f19907h.K();
        }
    }

    /* compiled from: ApolloOnlineDialActivity.kt */
    /* loaded from: classes2.dex */
    static final class b extends Lambda implements qo.a<p> {
        public static final b INSTANCE = new b();

        b() {
            super(0);
        }

        /* renamed from: a */
        public final p invoke() {
            return new p();
        }
    }

    /* compiled from: ApolloOnlineDialActivity.kt */
    /* loaded from: classes2.dex */
    static final class c extends Lambda implements qo.a<s> {
        public static final c INSTANCE = new c();

        c() {
            super(0);
        }

        /* renamed from: a */
        public final s invoke() {
            return new s();
        }
    }

    /* compiled from: ApolloOnlineDialActivity.kt */
    /* loaded from: classes2.dex */
    public static final class d implements TabLayout.d {
        d() {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void a(TabLayout.g gVar) {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void b(TabLayout.g tab) {
            i.f(tab, "tab");
            ApolloOnlineDialActivity apolloOnlineDialActivity = ApolloOnlineDialActivity.this;
            String[] strArr = apolloOnlineDialActivity.f19903a;
            if (strArr != null) {
                apolloOnlineDialActivity.setTitle(strArr[tab.g()]);
            } else {
                i.u("mTabArrays");
                throw null;
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void c(TabLayout.g gVar) {
        }
    }

    public ApolloOnlineDialActivity() {
        io.d a10;
        io.d a11;
        a10 = io.f.a(c.INSTANCE);
        this.f19905c = a10;
        a11 = io.f.a(b.INSTANCE);
        this.f19906d = a11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Fragment K() {
        return (Fragment) this.f19906d.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Fragment L() {
        return (Fragment) this.f19905c.getValue();
    }

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return sh.i.p_res_0x7f0e0045;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        K().onActivityResult(i10, i11, intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        int[] iArr;
        super.onCreate(bundle);
        setTitle(k.V2);
        ViewPager viewPager = (ViewPager) findViewById(h.f34635f2);
        TabLayout tabLayout = (TabLayout) findViewById(h.f34630e2);
        tabLayout.setVisibility(8);
        String[] stringArray = getResources().getStringArray(sh.b.s_res_0x7f03001f);
        i.e(stringArray, "resources.getStringArray(R.array.dial_home_tabs)");
        this.f19903a = stringArray;
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        i.e(supportFragmentManager, "supportFragmentManager");
        viewPager.setAdapter(new a(this, supportFragmentManager));
        tabLayout.setupWithViewPager(viewPager);
        int i10 = 0;
        for (int i11 : this.f19904b) {
            i10++;
            TabLayout.g x10 = tabLayout.x(i10);
            if (x10 != null) {
                x10.p(i11);
            }
        }
        tabLayout.d(new d());
    }
}
