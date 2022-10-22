package com.mobvoi.mcuwatch.ui.workout;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.projection.MediaProjectionManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.c;
import androidx.appcompat.widget.Toolbar;
import cd.g;
import com.mobvoi.android.common.utils.s;
import com.mobvoi.companion.base.m3.d;
import com.mobvoi.mcuwatch.bean.SportControlBean;
import com.mobvoi.mcuwatch.ui.customview.SportControlMainView;
import com.mobvoi.mcuwatch.ui.customview.SportControlTitleView;
import com.mobvoi.mcuwatch.ui.customview.SportRealtimeDataView;
import com.mobvoi.mcuwatch.ui.workout.WorkoutActivity;
import java.util.ArrayList;
import k7.b;
import mj.a;
import mj.i;
import mj.j;
import mj.n;
import sh.f;
import sh.h;
import sh.k;
/* loaded from: classes2.dex */
public class WorkoutActivity extends d implements a, s.a {

    /* renamed from: a  reason: collision with root package name */
    FrameLayout f20249a;

    /* renamed from: b  reason: collision with root package name */
    SportControlTitleView f20250b;

    /* renamed from: c  reason: collision with root package name */
    SportRealtimeDataView f20251c;

    /* renamed from: d  reason: collision with root package name */
    j f20252d;

    /* renamed from: e  reason: collision with root package name */
    SportControlMainView f20253e;

    /* renamed from: f  reason: collision with root package name */
    ImageView f20254f;

    /* renamed from: g  reason: collision with root package name */
    private n f20255g;

    /* renamed from: h  reason: collision with root package name */
    private final s f20256h = new s(this);

    /* renamed from: i  reason: collision with root package name */
    c f20257i;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K(DialogInterface dialogInterface, int i10) {
        dialogInterface.dismiss();
        mj.c.e().i();
        this.f20255g.i(1, true);
    }

    private void L() {
        this.f20257i = new b(this).h(k.A2).d(false).j(k.f34848p0, i.f30807a).m(k.f34853q0, new DialogInterface.OnClickListener() { // from class: mj.h
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                WorkoutActivity.this.K(dialogInterface, i10);
            }
        }).t();
    }

    @SuppressLint({"WrongConstant"})
    private void M() {
        startActivityForResult(((MediaProjectionManager) getSystemService("media_projection")).createScreenCaptureIntent(), 200);
    }

    @Override // mj.a
    public boolean a(int i10) {
        if (i10 == 1) {
            if (mj.c.e().g()) {
                L();
                return false;
            }
        } else if (i10 == 4) {
            Message.obtain(this.f20256h, 2).sendToTarget();
        }
        return true;
    }

    @Override // mj.a
    public Handler getHandler() {
        return this.f20256h;
    }

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return sh.i.f34729a1;
    }

    @Override // com.mobvoi.android.common.utils.s.a
    public void handleMessage(Message message) {
        int i10 = message.what;
        if (i10 == 1) {
            SportControlBean sportControlBean = (SportControlBean) message.obj;
            this.f20251c.F(sportControlBean);
            this.f20255g.h(44, sportControlBean);
        } else if (i10 == 2) {
            this.f20254f.setVisibility(0);
        }
    }

    protected void initView() {
        getToolbar().setVisibility(8);
        Toolbar toolbar = (Toolbar) findViewById(h.C4);
        toolbar.setNavigationIcon(f.f34545f0);
        setSupportActionBar(toolbar);
        androidx.appcompat.app.a supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.t(true);
            supportActionBar.u(false);
        }
        this.f20253e = (SportControlMainView) findViewById(h.S2);
        this.f20249a = (FrameLayout) findViewById(h.f34616b1);
        this.f20250b = (SportControlTitleView) findViewById(h.T2);
        this.f20251c = (SportRealtimeDataView) findViewById(h.V2);
        this.f20254f = (ImageView) findViewById(h.B4);
        this.f20252d = new j(g.b().a().a(this.f20249a));
        n nVar = new n(this.f20252d, this);
        this.f20255g = nVar;
        this.f20253e.setWorkShortPresenter(nVar);
        this.f20250b.setWorkShortPresenter(this.f20255g);
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f20253e);
        arrayList.add(this.f20250b);
        arrayList.add(this.f20251c);
        this.f20255g.t(arrayList);
        this.f20255g.i(0, true);
        this.f20255g.j(1);
    }

    @Override // mj.a
    public void j() {
        Toast.makeText(this, k.f34892x2, 0).show();
        finish();
    }

    @Override // androidx.fragment.app.f, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i11 == -1 && i10 == 200) {
            Intent intent2 = new Intent(this, ScreenRecorderService.class);
            intent2.putExtra("result_data", intent);
            if (Build.VERSION.SDK_INT >= 26) {
                startForegroundService(intent2);
            } else {
                startService(intent2);
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        int l10 = this.f20255g.l();
        if (l10 == 0 || l10 == 4) {
            super.onBackPressed();
        } else {
            Toast.makeText(this, k.A1, 0).show();
        }
    }

    public void onClickWorkoutShare(View view) {
        M();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.d, androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.f20255g.o();
        c cVar = this.f20257i;
        if (cVar != null && cVar.isShowing()) {
            this.f20257i.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, android.app.Activity
    public void onPause() {
        super.onPause();
        this.f20255g.p();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f20255g.q();
    }

    @Override // mj.a
    public void r(SportControlBean sportControlBean) {
        Message.obtain(this.f20256h, 1, sportControlBean).sendToTarget();
    }
}
