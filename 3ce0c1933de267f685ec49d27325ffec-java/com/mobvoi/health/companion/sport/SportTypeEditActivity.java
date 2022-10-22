package com.mobvoi.health.companion.sport;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.b;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bh.c;
import bh.e;
import com.alibaba.fastjson.JSON;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.mobvoi.health.common.data.pojo.SportType;
import com.mobvoi.health.companion.sport.SportTypeEditActivity;
import com.mobvoi.health.companion.sport.view.a;
import fg.q;
import fg.s;
import fg.t;
import fg.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import kg.k;
import ug.j;
import ug.m;
/* loaded from: classes2.dex */
public class SportTypeEditActivity extends com.mobvoi.companion.base.m3.a {

    /* renamed from: a  reason: collision with root package name */
    private List<m> f18804a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private List<SportType> f18805b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private k f18806c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a extends BaseQuickAdapter<m, BaseViewHolder> {
        public a(SportTypeEditActivity sportTypeEditActivity, List<m> list) {
            super(t.P, list);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void e(m mVar, CompoundButton compoundButton, boolean z10) {
            mVar.f35435b = z10;
            com.mobvoi.android.common.utils.k.i(BaseQuickAdapter.TAG, "sportTypeStateful.SportType is %s and isSelect %s", mVar.f35434a, Boolean.valueOf(z10));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* renamed from: d */
        public void convert(BaseViewHolder baseViewHolder, final m mVar) {
            TextView textView = (TextView) baseViewHolder.getView(s.f26777s5);
            ImageView imageView = (ImageView) baseViewHolder.getView(s.f26770r5);
            ImageView imageView2 = (ImageView) baseViewHolder.getView(s.f26702i);
            CheckBox checkBox = (CheckBox) baseViewHolder.getView(s.U);
            SportType sportType = mVar.f35434a;
            if (sportType == SportType.AutoRunning || sportType == SportType.AutoWalking || sportType == SportType.AutoCycling) {
                imageView2.setVisibility(0);
                imageView2.setImageResource(q.f26544a);
            } else if (sportType == SportType.Gymnastics || sportType == SportType.Spinning) {
                imageView2.setVisibility(0);
                imageView2.setImageResource(q.f26580j);
            } else {
                imageView2.setVisibility(8);
            }
            a.C0219a e10 = com.mobvoi.health.companion.sport.view.a.d().e(mVar.f35434a);
            if (mVar.f35434a == SportType.Unknown) {
                imageView.setImageResource(q.f26611q2);
                textView.setText(u.f26884f);
                checkBox.setVisibility(8);
            } else {
                imageView.setBackgroundResource(q.f26627u2);
                imageView.setImageDrawable(b.e(this.mContext, e10.f18992a));
                textView.setText(e10.f18994c);
                checkBox.setVisibility(0);
            }
            checkBox.setOnCheckedChangeListener(null);
            checkBox.setChecked(mVar.f35435b);
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.mobvoi.health.companion.sport.b
                @Override // android.widget.CompoundButton.OnCheckedChangeListener
                public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
                    SportTypeEditActivity.a.e(m.this, compoundButton, z10);
                }
            });
        }
    }

    private List<SportType> N() {
        if (Build.VERSION.SDK_INT >= 24) {
            return (List) this.f18804a.stream().filter(ug.k.f35432a).map(j.f35431a).collect(Collectors.toList());
        }
        ArrayList arrayList = new ArrayList();
        for (m mVar : this.f18804a) {
            if (mVar.f35435b) {
                arrayList.add(mVar.f35434a);
            }
        }
        return arrayList;
    }

    private boolean O() {
        return N().size() != this.f18805b.size() || !N().containsAll(this.f18805b);
    }

    private void Q() {
        this.f18805b.addAll(e.b(ta.a.d()));
        for (SportType sportType : m.a()) {
            if (this.f18805b.contains(sportType)) {
                this.f18804a.add(new m(this, sportType, true));
            } else {
                this.f18804a.add(new m(this, sportType, false));
            }
        }
        Collections.sort(this.f18804a, new c());
        this.f18804a.add(0, new m(this, SportType.Unknown, false));
        this.f18806c = new k(this);
    }

    public static void S(Activity activity) {
        activity.startActivityForResult(new Intent(activity, SportTypeEditActivity.class), 1001);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(View view) {
        if (O()) {
            a0();
        } else {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W(View view) {
        if (O()) {
            c0();
        } else {
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(DialogInterface dialogInterface, int i10) {
        c0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(DialogInterface dialogInterface, int i10) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(lg.a aVar) {
        b0(N());
        setResult(-1);
        finish();
    }

    private void a0() {
        new k7.b(this).h(u.f26956r).m(u.f26962s, new DialogInterface.OnClickListener() { // from class: ug.g
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                SportTypeEditActivity.this.X(dialogInterface, i10);
            }
        }).j(u.f26938o, new DialogInterface.OnClickListener() { // from class: ug.f
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                SportTypeEditActivity.this.Y(dialogInterface, i10);
            }
        }).a().show();
    }

    private void b0(List<SportType> list) {
        e.c(ta.a.d(), JSON.toJSONString(list));
    }

    private void c0() {
        if (!this.f18806c.isConnected()) {
            aa.c.b(getResources().getString(u.f26871c4));
        } else {
            this.f18806c.k(N()).Z(cq.a.c()).H(xp.a.b()).M(rx.c.s()).X(new yp.b() { // from class: ug.l
                @Override // yp.b
                public final void call(Object obj) {
                    SportTypeEditActivity.this.Z((lg.a) obj);
                }
            });
        }
    }

    private void initView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(s.X3);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new a(this, this.f18804a));
        ((ImageView) findViewById(s.f26760q1)).setOnClickListener(new View.OnClickListener() { // from class: ug.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SportTypeEditActivity.this.V(view);
            }
        });
        ((TextView) findViewById(s.f26743n5)).setOnClickListener(new View.OnClickListener() { // from class: ug.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SportTypeEditActivity.this.W(view);
            }
        });
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (O()) {
            a0();
        } else {
            super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.a, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(t.f26829c);
        Q();
        initView();
    }
}
