package com.mobvoi.companion.aw.watchfacecenter.fragment;

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import androidx.lifecycle.h0;
import androidx.lifecycle.x;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import cc.g;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.companion.MobvoiCropParams;
import com.mobvoi.companion.MobvoiPhotoCropHelper;
import com.mobvoi.companion.aw.watchfacecenter.WatchFaceViewModel;
import com.mobvoi.companion.aw.watchfacecenter.bean.WatchFaceBean;
import com.mobvoi.companion.aw.watchfacecenter.p;
import com.mobvoi.companion.aw.watchfacecenter.q;
import com.mobvoi.companion.aw.watchfacecenter.s;
import com.mobvoi.wear.common.base.WearPath;
import com.mobvoi.wear.msgproxy.MessageInfo;
import io.m;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.text.t;
import lb.c;
import rx.j;
import zb.d;
/* compiled from: WatchFaceDetailFragment.kt */
/* loaded from: classes2.dex */
public final class r extends com.mobvoi.companion.aw.watchfacecenter.fragment.a implements zb.a {

    /* renamed from: c  reason: collision with root package name */
    private WatchFaceBean f16407c;

    /* renamed from: d  reason: collision with root package name */
    private Bitmap f16408d;

    /* renamed from: e  reason: collision with root package name */
    private String f16409e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f16410f;

    /* renamed from: g  reason: collision with root package name */
    private WatchFaceViewModel f16411g;

    /* renamed from: h  reason: collision with root package name */
    private int f16412h;

    /* renamed from: i  reason: collision with root package name */
    private int f16413i;

    /* renamed from: j  reason: collision with root package name */
    private SwipeRefreshLayout f16414j;

    /* renamed from: k  reason: collision with root package name */
    private RecyclerView f16415k;

    /* compiled from: WatchFaceDetailFragment.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: WatchFaceDetailFragment.kt */
    /* loaded from: classes2.dex */
    public static final class b extends RecyclerView.n {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RecyclerView f16416a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ r f16417b;

        b(RecyclerView recyclerView, r rVar) {
            this.f16416a = recyclerView;
            this.f16417b = rVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.n
        public void d(Rect outRect, View view, RecyclerView parent, RecyclerView.y state) {
            i.f(outRect, "outRect");
            i.f(view, "view");
            i.f(parent, "parent");
            i.f(state, "state");
            int g02 = parent.g0(view);
            RecyclerView.Adapter adapter = this.f16416a.getAdapter();
            Objects.requireNonNull(adapter, "null cannot be cast to non-null type com.mobvoi.companion.aw.watchfacecenter.adapter.WatchFaceDetailAdapter");
            int i10 = ((d) adapter).d() ? this.f16417b.f16413i : this.f16417b.f16412h;
            if (g02 <= 1) {
                i10 = 0;
            }
            outRect.top = i10;
        }
    }

    static {
        new a(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A0(r this$0) {
        i.f(this$0, "this$0");
        WatchFaceBean watchFaceBean = this$0.f16407c;
        if (watchFaceBean != null) {
            watchFaceBean.A(true);
        }
        RecyclerView recyclerView = this$0.f16415k;
        if (recyclerView != null) {
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            if (adapter != null) {
                adapter.notifyItemRangeChanged(0, 2);
                return;
            }
            return;
        }
        i.u("rvWatchFaceDetail");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B0(r this$0) {
        i.f(this$0, "this$0");
        WatchFaceBean watchFaceBean = this$0.f16407c;
        if (watchFaceBean != null) {
            watchFaceBean.A(true);
        }
        RecyclerView recyclerView = this$0.f16415k;
        if (recyclerView != null) {
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            if (adapter != null) {
                adapter.notifyItemRangeChanged(0, 2);
                return;
            }
            return;
        }
        i.u("rvWatchFaceDetail");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(r this$0) {
        i.f(this$0, "this$0");
        WatchFaceBean watchFaceBean = this$0.f16407c;
        if (watchFaceBean != null) {
            watchFaceBean.A(true);
        }
        RecyclerView recyclerView = this$0.f16415k;
        if (recyclerView != null) {
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            if (adapter != null) {
                adapter.notifyItemChanged(0);
                return;
            }
            return;
        }
        i.u("rvWatchFaceDetail");
        throw null;
    }

    private final void D0(Bitmap bitmap) {
        WatchFaceBean watchFaceBean = this.f16407c;
        if (watchFaceBean != null) {
            watchFaceBean.F(bitmap);
        }
        RecyclerView recyclerView = this.f16415k;
        if (recyclerView != null) {
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
                return;
            }
            return;
        }
        i.u("rvWatchFaceDetail");
        throw null;
    }

    private final void E0(Bitmap bitmap) {
        Bitmap a10 = fc.a.a(bitmap);
        this.f16408d = a10;
        if (a10 != null) {
            WatchFaceBean watchFaceBean = this.f16407c;
            if (watchFaceBean != null) {
                watchFaceBean.A(true);
            }
            D0(a10);
        }
    }

    private final void F0() {
        new k7.b(requireActivity()).B(new String[]{getString(s.f16467c), getString(s.f16468d)}, new DialogInterface.OnClickListener() { // from class: com.mobvoi.companion.aw.watchfacecenter.fragment.i
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                r.G0(r.this, dialogInterface, i10);
            }
        }).a().show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G0(r this$0, DialogInterface dialogInterface, int i10) {
        i.f(this$0, "this$0");
        if (i10 != 0) {
            c.e(this$0.getActivity(), 100);
        } else if (this$0.s0("android.permission.CAMERA")) {
            this$0.H0();
        }
    }

    private final void H0() {
        MobvoiPhotoCropHelper mobvoiPhotoCropHelper = MobvoiPhotoCropHelper.INSTANCE;
        Context requireContext = requireContext();
        i.e(requireContext, "requireContext()");
        String generateCameraFilePath = mobvoiPhotoCropHelper.generateCameraFilePath(requireContext);
        this.f16409e = generateCameraFilePath;
        mobvoiPhotoCropHelper.launchCameraActivity(this, generateCameraFilePath, 101);
    }

    private final boolean s0(String... strArr) {
        int length = strArr.length;
        boolean z10 = false;
        int i10 = 0;
        while (true) {
            if (i10 >= length) {
                z10 = true;
                break;
            }
            String str = strArr[i10];
            i10++;
            if (-1 == androidx.core.content.b.a(requireActivity(), str)) {
                break;
            }
        }
        if (!z10) {
            androidx.core.app.a.s(requireActivity(), strArr, 10);
        }
        return z10;
    }

    private final void t0(int i10, Uri uri) {
        MobvoiPhotoCropHelper.INSTANCE.launchCropImageActivity(this, uri, i10);
    }

    private final void u0(MessageInfo messageInfo) {
        if (i.b(messageInfo.getPath(), WearPath.WatchfaceMarket.SET_CONFIRM)) {
            if (this.f16410f) {
                WatchFaceBean watchFaceBean = this.f16407c;
                if (watchFaceBean != null) {
                    watchFaceBean.A(false);
                }
                WatchFaceBean watchFaceBean2 = this.f16407c;
                if (watchFaceBean2 != null) {
                    WatchFaceViewModel watchFaceViewModel = this.f16411g;
                    if (watchFaceViewModel != null) {
                        watchFaceViewModel.Z(watchFaceBean2);
                    } else {
                        i.u("viewModel");
                        throw null;
                    }
                }
            }
            RecyclerView recyclerView = this.f16415k;
            if (recyclerView != null) {
                RecyclerView.Adapter adapter = recyclerView.getAdapter();
                if (adapter != null) {
                    adapter.notifyItemChanged(0);
                    return;
                }
                return;
            }
            i.u("rvWatchFaceDetail");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v0(r this$0, MessageInfo msg) {
        i.f(this$0, "this$0");
        i.e(msg, "msg");
        this$0.u0(msg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w0(r this$0, Context context, g gVar) {
        i.f(this$0, "this$0");
        i.f(context, "$context");
        cc.a a10 = gVar.a();
        if (a10 != null) {
            WatchFaceBean watchFaceBean = new WatchFaceBean();
            watchFaceBean.B(a10.e());
            watchFaceBean.D(a10.a());
            WatchFaceBean watchFaceBean2 = this$0.f16407c;
            watchFaceBean.v(watchFaceBean2 == null ? null : watchFaceBean2.c());
            watchFaceBean.H(TextUtils.isEmpty(a10.i()) ? a10.d() : a10.i());
            String a11 = a10.a();
            if (a11 == null) {
                a11 = "";
            }
            watchFaceBean.x(new ComponentName(context, a11));
            watchFaceBean.u(2);
            watchFaceBean.C(a10.f());
            watchFaceBean.y(a10.b());
            watchFaceBean.z(a10.c());
            watchFaceBean.G(a10.h());
            watchFaceBean.I(a10.g());
            watchFaceBean.j();
            this$0.f16407c = watchFaceBean;
            RecyclerView recyclerView = this$0.f16415k;
            if (recyclerView != null) {
                RecyclerView.Adapter adapter = recyclerView.getAdapter();
                Objects.requireNonNull(adapter, "null cannot be cast to non-null type com.mobvoi.companion.aw.watchfacecenter.adapter.WatchFaceDetailAdapter");
                d dVar = (d) adapter;
                dVar.f(watchFaceBean);
                dVar.notifyDataSetChanged();
                return;
            }
            i.u("rvWatchFaceDetail");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(Throwable th2) {
        k.d("WatchFaceDetailFragment", th2.getMessage());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y0(r this$0) {
        i.f(this$0, "this$0");
        SwipeRefreshLayout swipeRefreshLayout = this$0.f16414j;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setRefreshing(true);
        } else {
            i.u("swipeRefreshLayout");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z0(r this$0) {
        i.f(this$0, "this$0");
        SwipeRefreshLayout swipeRefreshLayout = this$0.f16414j;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setRefreshing(false);
            SwipeRefreshLayout swipeRefreshLayout2 = this$0.f16414j;
            if (swipeRefreshLayout2 != null) {
                swipeRefreshLayout2.setEnabled(false);
            } else {
                i.u("swipeRefreshLayout");
                throw null;
            }
        } else {
            i.u("swipeRefreshLayout");
            throw null;
        }
    }

    @Override // zb.a
    public void J(boolean z10) {
        WatchFaceBean watchFaceBean = this.f16407c;
        if (watchFaceBean != null) {
            watchFaceBean.J(z10 ? 1 : 0);
        }
        Y().post(new Runnable() { // from class: com.mobvoi.companion.aw.watchfacecenter.fragment.l
            @Override // java.lang.Runnable
            public final void run() {
                r.A0(r.this);
            }
        });
    }

    @Override // zb.a
    public void N() {
        WatchFaceBean watchFaceBean = this.f16407c;
        if (watchFaceBean != null) {
            com.mobvoi.companion.aw.watchfacecenter.fragment.a.g0(this, watchFaceBean, "wfDetailClickBtn", null, 4, null);
            if (this.f16410f) {
                WatchFaceViewModel watchFaceViewModel = this.f16411g;
                if (watchFaceViewModel != null) {
                    watchFaceViewModel.A(watchFaceBean, this.f16408d, a0());
                } else {
                    i.u("viewModel");
                    throw null;
                }
            } else {
                WatchFaceViewModel watchFaceViewModel2 = this.f16411g;
                if (watchFaceViewModel2 != null) {
                    watchFaceViewModel2.B(watchFaceBean, a0());
                } else {
                    i.u("viewModel");
                    throw null;
                }
            }
        }
    }

    @Override // com.mobvoi.companion.aw.watchfacecenter.fragment.a
    public int Z() {
        return q.b_res_0x7f0e00c4;
    }

    @Override // com.mobvoi.companion.aw.watchfacecenter.fragment.a
    public void b0(final Context context) {
        String k10;
        boolean q5;
        String str;
        i.f(context, "context");
        androidx.fragment.app.f requireActivity = requireActivity();
        i.e(requireActivity, "requireActivity()");
        WatchFaceViewModel watchFaceViewModel = (WatchFaceViewModel) new h0(requireActivity).a(WatchFaceViewModel.class);
        this.f16411g = watchFaceViewModel;
        if (watchFaceViewModel != null) {
            watchFaceViewModel.u().i(this, new x() { // from class: com.mobvoi.companion.aw.watchfacecenter.fragment.j
                @Override // androidx.lifecycle.x
                public final void a(Object obj) {
                    r.v0(r.this, (MessageInfo) obj);
                }
            });
            Bundle arguments = getArguments();
            WatchFaceBean watchFaceBean = arguments == null ? null : (WatchFaceBean) arguments.getParcelable("watchface_bean");
            WatchFaceBean a10 = watchFaceBean == null ? null : watchFaceBean.clone();
            this.f16407c = a10;
            this.f16410f = TextUtils.equals("com.mobvoi.ticwear.watchface.service.ImageWatchFace", a10 == null ? null : a10.c());
            WatchFaceBean watchFaceBean2 = this.f16407c;
            if (watchFaceBean2 != null) {
                watchFaceBean2.j();
            }
            WatchFaceBean watchFaceBean3 = this.f16407c;
            boolean z10 = true;
            String str2 = "";
            if (watchFaceBean3 != null) {
                q5 = t.q(watchFaceBean3.i(), getString(s.x_res_0x7f14125b), false, 2, null);
                watchFaceBean3.A(!q5);
                WatchFaceViewModel watchFaceViewModel2 = this.f16411g;
                if (watchFaceViewModel2 != null) {
                    WatchFaceBean watchFaceBean4 = this.f16407c;
                    if (watchFaceBean4 == null || (str = watchFaceBean4.i()) == null) {
                        str = str2;
                    }
                    watchFaceViewModel2.a0(str);
                    RecyclerView recyclerView = this.f16415k;
                    if (recyclerView != null) {
                        d dVar = new d(context, watchFaceBean3);
                        dVar.e(this);
                        m mVar = m.f28349a;
                        recyclerView.setAdapter(dVar);
                        recyclerView.setLayoutManager(new LinearLayoutManager(context));
                        recyclerView.setItemAnimator(null);
                        recyclerView.h(new b(recyclerView, this));
                    } else {
                        i.u("rvWatchFaceDetail");
                        throw null;
                    }
                } else {
                    i.u("viewModel");
                    throw null;
                }
            }
            WatchFaceBean watchFaceBean5 = this.f16407c;
            if (watchFaceBean5 == null || watchFaceBean5.b() != 2) {
                z10 = false;
            }
            if (z10) {
                WatchFaceViewModel watchFaceViewModel3 = this.f16411g;
                if (watchFaceViewModel3 == null) {
                    i.u("viewModel");
                    throw null;
                } else if (watchFaceViewModel3 != null) {
                    WatchFaceBean watchFaceBean6 = this.f16407c;
                    if (!(watchFaceBean6 == null || (k10 = watchFaceBean6.k()) == null)) {
                        str2 = k10;
                    }
                    j Y = watchFaceViewModel3.T(str2).Z(cq.a.c()).H(xp.a.b()).q(new yp.a() { // from class: com.mobvoi.companion.aw.watchfacecenter.fragment.n
                        @Override // yp.a
                        public final void call() {
                            r.y0(r.this);
                        }
                    }).r(new yp.a() { // from class: com.mobvoi.companion.aw.watchfacecenter.fragment.o
                        @Override // yp.a
                        public final void call() {
                            r.z0(r.this);
                        }
                    }).Y(new yp.b() { // from class: com.mobvoi.companion.aw.watchfacecenter.fragment.p
                        @Override // yp.b
                        public final void call(Object obj) {
                            r.w0(r.this, context, (g) obj);
                        }
                    }, q.f16406a);
                    i.e(Y, "viewModel.requestWatchFaceDetail(watchFaceInfo?.pkg ?: \"\")\n                .subscribeOn(Schedulers.io())\n                .observeOn(AndroidSchedulers.mainThread())\n                .doOnSubscribe {\n                    swipeRefreshLayout.isRefreshing = true\n                }.doOnTerminate {\n                    swipeRefreshLayout.isRefreshing = false\n                    swipeRefreshLayout.isEnabled = false\n                }.subscribe({ resp ->\n                    resp.dataBean?.let { bean ->\n                        val watchFaceBean = WatchFaceBean().apply {\n                            name = bean.name\n                            pkg = bean.apkPackageName\n                            className = watchFaceInfo?.className\n                            previewUrl = if (TextUtils.isEmpty(bean.thumbnailUrl)) bean.logoUrl\n                            else bean.thumbnailUrl\n                            componentName = ComponentName(\n                                context, bean.apkPackageName\n                                    ?: \"\"\n                            )\n                            category = WatchFaceBean.CategoryType.DOWNLOAD\n                            needPay = bean.needPay\n                            description = bean.description\n                            developerName = bean.developerName\n                            previewImages = bean.snapshotUrlList\n                            price = bean.price\n                        }\n                        isNeedPay = watchFaceBean.needPay\n                        watchFaceInfo = watchFaceBean\n                        with(rvWatchFaceDetail.adapter as WatchFaceDetailAdapter) {\n                            updateWatchInfo(watchFaceBean)\n                            notifyDataSetChanged()\n                        }\n                    }\n                }, { t ->\n                    LogUtil.e(TAG, t.message)\n                })");
                    watchFaceViewModel3.o(Y);
                } else {
                    i.u("viewModel");
                    throw null;
                }
            }
        } else {
            i.u("viewModel");
            throw null;
        }
    }

    @Override // com.mobvoi.companion.aw.watchfacecenter.fragment.a
    protected void c0(Context context) {
        i.f(context, "context");
        this.f16412h = aa.d.b(8.0f, context);
        this.f16413i = aa.d.b(12.0f, context);
    }

    @Override // com.mobvoi.companion.aw.watchfacecenter.fragment.a
    public void d0(Context context, View view) {
        i.f(context, "context");
        i.f(view, "view");
        View findViewById = view.findViewById(p.y_res_0x7f0b06f7);
        i.e(findViewById, "view.findViewById(R.id.swipeRefreshLayout)");
        this.f16414j = (SwipeRefreshLayout) findViewById;
        View findViewById2 = view.findViewById(p.r_res_0x7f0b05ba);
        i.e(findViewById2, "view.findViewById(R.id.rvWatchFaceDetail)");
        this.f16415k = (RecyclerView) findViewById2;
        SwipeRefreshLayout swipeRefreshLayout = this.f16414j;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setColorSchemeResources(com.mobvoi.companion.aw.watchfacecenter.m.d_res_0x7f06062e);
            swipeRefreshLayout.setEnabled(false);
            return;
        }
        i.u("swipeRefreshLayout");
        throw null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i10, int i11, Intent intent) {
        String str;
        super.onActivityResult(i10, i11, intent);
        k.a("WatchFaceDetailFragment", "WatchfaceDetailFrg onActivityResult(): requestCode" + i10 + ", resultCode" + i11);
        switch (i10) {
            case 100:
                if (i11 == -1 && intent != null && intent.getData() != null) {
                    MobvoiPhotoCropHelper mobvoiPhotoCropHelper = MobvoiPhotoCropHelper.INSTANCE;
                    androidx.fragment.app.f requireActivity = requireActivity();
                    i.e(requireActivity, "requireActivity()");
                    Uri data = intent.getData();
                    Objects.requireNonNull(data, "null cannot be cast to non-null type android.net.Uri");
                    File createTmpFileForChooseImage = mobvoiPhotoCropHelper.createTmpFileForChooseImage(requireActivity, data);
                    if (createTmpFileForChooseImage != null) {
                        androidx.fragment.app.f requireActivity2 = requireActivity();
                        i.e(requireActivity2, "requireActivity()");
                        t0(102, mobvoiPhotoCropHelper.getUriForFile(requireActivity2, createTmpFileForChooseImage));
                        return;
                    }
                    return;
                }
                return;
            case 101:
                if (i11 == -1 && (str = this.f16409e) != null) {
                    if (!(str.length() == 0)) {
                        File file = new File(str);
                        if (file.exists()) {
                            k.a("WatchFaceDetailFragment", "CAMERA_REQUEST_CODE: path is " + str + " and file exists");
                            MobvoiPhotoCropHelper mobvoiPhotoCropHelper2 = MobvoiPhotoCropHelper.INSTANCE;
                            androidx.fragment.app.f requireActivity3 = requireActivity();
                            i.e(requireActivity3, "requireActivity()");
                            t0(102, mobvoiPhotoCropHelper2.getUriForFile(requireActivity3, file));
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            case 102:
                if (i11 == -1 && intent != null) {
                    Bitmap bitmap = null;
                    try {
                        Uri uri = (Uri) intent.getParcelableExtra(MobvoiCropParams.EXTRA_CROP_OUTPUT_URI);
                        if (uri != null) {
                            bitmap = BitmapFactory.decodeStream(requireActivity().getContentResolver().openInputStream(uri));
                        }
                    } catch (FileNotFoundException e10) {
                        k.d("WatchFaceDetailFragment", e10.getMessage());
                    }
                    if (bitmap != null) {
                        E0(bitmap);
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        Y().removeCallbacksAndMessages(null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onHiddenChanged(boolean z10) {
        super.onHiddenChanged(z10);
        if (!z10) {
            WatchFaceViewModel watchFaceViewModel = this.f16411g;
            if (watchFaceViewModel != null) {
                watchFaceViewModel.r(false);
            } else {
                i.u("viewModel");
                throw null;
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        sb.a.h(requireActivity(), "awWfDetail");
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        sb.a.i(requireActivity(), "awWfDetail");
    }

    @Override // zb.a
    public void p(int i10) {
        WatchFaceBean watchFaceBean = this.f16407c;
        if (watchFaceBean != null) {
            watchFaceBean.E(Integer.valueOf(i10));
        }
        Y().post(new Runnable() { // from class: com.mobvoi.companion.aw.watchfacecenter.fragment.m
            @Override // java.lang.Runnable
            public final void run() {
                r.C0(r.this);
            }
        });
    }

    @Override // zb.a
    public void s(boolean z10) {
        WatchFaceBean watchFaceBean = this.f16407c;
        if (watchFaceBean != null) {
            watchFaceBean.K(z10 ? 1 : 0);
        }
        Y().post(new Runnable() { // from class: com.mobvoi.companion.aw.watchfacecenter.fragment.k
            @Override // java.lang.Runnable
            public final void run() {
                r.B0(r.this);
            }
        });
    }

    @Override // zb.a
    public void v() {
        WatchFaceViewModel watchFaceViewModel = this.f16411g;
        if (watchFaceViewModel == null) {
            i.u("viewModel");
            throw null;
        } else if (watchFaceViewModel.s(a0())) {
            WatchFaceViewModel watchFaceViewModel2 = this.f16411g;
            if (watchFaceViewModel2 != null) {
                if (watchFaceViewModel2.w()) {
                    Toast.makeText(getContext(), s.f16473s, 1).show();
                }
                F0();
                return;
            }
            i.u("viewModel");
            throw null;
        }
    }
}
