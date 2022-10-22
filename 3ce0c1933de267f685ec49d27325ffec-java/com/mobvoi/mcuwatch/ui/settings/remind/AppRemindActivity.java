package com.mobvoi.mcuwatch.ui.settings.remind;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.mobvoi.mcuwatch.engine.n;
import com.mobvoi.mcuwatch.ui.settings.remind.AppRemindActivity;
import com.mobvoi.wear.util.DimensionUtils;
import ij.i;
import java.util.ArrayList;
import java.util.List;
import sh.h;
import sh.k;
import wi.e;
/* loaded from: classes2.dex */
public class AppRemindActivity extends e<i> {

    /* renamed from: b  reason: collision with root package name */
    private final String[] f20170b = {"com.tencent.mm", "com.whatsapp", "com.facebook.katana", "com.twitter.android", "com.instagram.android", "org.telegram.messenger", "com.viber.voip", "jp.naver.line.android", "com.google.android.gm", "com.facebook.orca", "com.google.android.talk", "com.google.android.youtube", "com.snapchat.android", "com.ss.android.ugc.trill", "com.Slack", "com.microsoft.office.lync15", "com.pinterest", "com.tumblr", "com.linkedin.android", "com.ubercab", "com.google.android.apps.podcasts", "com.spotify.music", "com.deezer.analytics", "com.waze", "com.spark71.stravatogpx", "com.nike.plusgps", "br.uol.noticias", "com.ebay.mobile", "com.google.android.calendar"};

    /* renamed from: c  reason: collision with root package name */
    private final String[] f20171c = {"com.tencent.mm", "com.sina.weibo", "com.tencent.mobileqq", "com.ss.android.ugc.aweme", "com.smile.gifmake", "com.ss.android.article.news", "com.eg.android.AlipayGphone", "com.taobao.taobao", "com.jingdong.app.mall", "com.alibaba.android.rimet", "com.ss.android.lark", "com.sdu.didi.psnger", "com.dianping.v1", "tv.danmaku.bili", "com.xingin.xhs", "com.xunmeng.pinduoduo", "com.qiyi.video", "com.tencent.weishi", "com.sankuai.meituan", "me.ele"};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends RecyclerView.n {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f20172a;

        a(int i10) {
            this.f20172a = i10;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.n
        public void d(Rect rect, View view, RecyclerView recyclerView, RecyclerView.y yVar) {
            int g02 = recyclerView.g0(view);
            int dp2px = (int) DimensionUtils.dp2px(AppRemindActivity.this.getApplicationContext(), 16.0f);
            if (g02 == 0) {
                rect.top = dp2px;
                rect.bottom = dp2px;
            } else if (g02 == this.f20172a) {
                rect.bottom = dp2px;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class b extends RecyclerView.Adapter<a> {

        /* renamed from: a  reason: collision with root package name */
        List<c> f20174a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public static class a extends RecyclerView.b0 {

            /* renamed from: a  reason: collision with root package name */
            TextView f20175a;

            /* renamed from: b  reason: collision with root package name */
            SwitchMaterial f20176b;

            public a(View view) {
                super(view);
                this.f20175a = (TextView) view.findViewById(h.i_res_0x7f0b009b);
                this.f20176b = (SwitchMaterial) view.findViewById(h.f34622c3);
            }
        }

        b(List<c> list) {
            ArrayList arrayList = new ArrayList();
            this.f20174a = arrayList;
            arrayList.clear();
            this.f20174a.addAll(list);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(CompoundButton compoundButton, boolean z10) {
            String str = (String) compoundButton.getTag();
            if (TextUtils.isEmpty(str)) {
                n.f19178a.O(z10);
                notifyDataSetChanged();
                return;
            }
            n.f19178a.N(str, z10);
        }

        /* renamed from: e */
        public void onBindViewHolder(a aVar, int i10) {
            c cVar = this.f20174a.get(i10);
            aVar.f20175a.setText(cVar.f20177a);
            aVar.f20175a.setCompoundDrawablesRelativeWithIntrinsicBounds(Math.max(cVar.f20178b, 0), 0, 0, 0);
            aVar.f20176b.setTag(cVar.f20179c);
            aVar.f20176b.setOnCheckedChangeListener(null);
            if (TextUtils.isEmpty(cVar.f20179c)) {
                aVar.f20176b.setEnabled(true);
                aVar.f20176b.setChecked(n.f19178a.v());
            } else {
                SwitchMaterial switchMaterial = aVar.f20176b;
                n nVar = n.f19178a;
                switchMaterial.setEnabled(nVar.v());
                aVar.f20176b.setChecked(nVar.d(cVar.f20179c));
            }
            aVar.f20176b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.mobvoi.mcuwatch.ui.settings.remind.a
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                    AppRemindActivity.b.this.d(compoundButton, z10);
                }
            });
        }

        /* renamed from: f */
        public a onCreateViewHolder(ViewGroup viewGroup, int i10) {
            return new a(LayoutInflater.from(viewGroup.getContext()).inflate(sh.i.J, viewGroup, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f20174a.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        String f20177a;

        /* renamed from: b  reason: collision with root package name */
        int f20178b;

        /* renamed from: c  reason: collision with root package name */
        String f20179c;

        c() {
        }

        public static c a(String str, int i10, String str2) {
            c cVar = new c();
            cVar.f20177a = str;
            cVar.f20178b = i10;
            cVar.f20179c = str2;
            return cVar;
        }
    }

    private void initView() {
        String[] strArr;
        TypedArray typedArray;
        String[] strArr2;
        setTitle(k.f34887w3);
        RecyclerView recyclerView = (RecyclerView) findViewById(h.f34720y2);
        String[] strArr3 = this.f20171c;
        if (yd.b.c(this)) {
            strArr2 = getResources().getStringArray(sh.b.d_res_0x7f030006);
            typedArray = getResources().obtainTypedArray(sh.b.b_res_0x7f030004);
            strArr = this.f20170b;
        } else {
            strArr2 = getResources().getStringArray(sh.b.c_res_0x7f030005);
            typedArray = getResources().obtainTypedArray(sh.b.a_res_0x7f030003);
            strArr = strArr3;
        }
        if (typedArray == null || typedArray.length() <= 0) {
            finish();
            return;
        }
        int[] iArr = new int[typedArray.length()];
        for (int i10 = 0; i10 < typedArray.length(); i10++) {
            iArr[i10] = typedArray.getResourceId(i10, 0);
        }
        typedArray.recycle();
        int length = strArr2.length;
        ArrayList arrayList = new ArrayList();
        arrayList.add(c.a(getString(k.f34887w3), -1, null));
        for (int i11 = 0; i11 < length; i11++) {
            arrayList.add(c.a(strArr2[i11], iArr[i11], strArr[i11]));
        }
        recyclerView.h(new a(length));
        recyclerView.setAdapter(new b(arrayList));
    }

    public static void start(Context context) {
        context.startActivity(new Intent(context, AppRemindActivity.class));
    }

    @Override // wi.e
    protected Class<i> I() {
        return i.class;
    }

    @Override // wi.e
    protected boolean K() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: L */
    public i H() {
        return new i();
    }

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return sh.i.f34758v;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // wi.e, com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }
}
