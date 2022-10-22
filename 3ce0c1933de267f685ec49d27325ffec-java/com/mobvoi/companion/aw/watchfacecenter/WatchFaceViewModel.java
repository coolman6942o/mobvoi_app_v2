package com.mobvoi.companion.aw.watchfacecenter;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.lifecycle.w;
import cc.e;
import cc.f;
import com.alipay.sdk.app.PayTask;
import com.huawei.agconnect.exception.AGCServerException;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.android.common.utils.q;
import com.mobvoi.companion.aw.watchfacecenter.WatchFaceViewModel;
import com.mobvoi.companion.aw.watchfacecenter.bean.WatchFaceBean;
import com.mobvoi.wear.common.base.WearPath;
import com.mobvoi.wear.msgproxy.MessageInfo;
import com.mobvoi.wear.msgproxy.MessageProxyClient;
import com.mobvoi.wear.msgproxy.MessageProxyListener;
import com.mobvoi.wear.msgproxy.NodeInfo;
import io.m;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.text.d;
import rx.Emitter;
import rx.c;
import rx.j;
import yp.g;
import yp.h;
/* compiled from: WatchFaceViewModel.kt */
/* loaded from: classes2.dex */
public final class WatchFaceViewModel extends androidx.lifecycle.b implements MessageProxyListener {

    /* renamed from: a  reason: collision with root package name */
    private final HashMap<String, String> f16347a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f16348b;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f16350d;

    /* renamed from: m  reason: collision with root package name */
    private boolean f16359m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f16360n;

    /* renamed from: c  reason: collision with root package name */
    private final Handler f16349c = new Handler(Looper.getMainLooper());

    /* renamed from: e  reason: collision with root package name */
    private SparseArray<List<WatchFaceBean>> f16351e = new SparseArray<>();

    /* renamed from: f  reason: collision with root package name */
    private final ac.b f16352f = new ac.b();

    /* renamed from: g  reason: collision with root package name */
    private final w<String> f16353g = new w<>();

    /* renamed from: h  reason: collision with root package name */
    private final w<MessageInfo> f16354h = new w<>();

    /* renamed from: i  reason: collision with root package name */
    private final w<String> f16355i = new w<>();

    /* renamed from: j  reason: collision with root package name */
    private final w<Boolean> f16356j = new w<>();

    /* renamed from: k  reason: collision with root package name */
    private final w<Boolean> f16357k = new w<>();

    /* renamed from: l  reason: collision with root package name */
    private final w<WatchFaceBean> f16358l = new w<>();

    /* renamed from: o  reason: collision with root package name */
    private final dq.b f16361o = new dq.b();

    /* compiled from: WatchFaceViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: WatchFaceViewModel.kt */
    /* loaded from: classes2.dex */
    public static final class b extends u {

        /* renamed from: c  reason: collision with root package name */
        private boolean f16362c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f16363d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Context f16364e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ Emitter<List<e>> f16365f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Context context, Emitter<List<e>> emitter) {
            super(context);
            this.f16364e = context;
            this.f16365f = emitter;
        }

        @Override // com.mobvoi.wear.msgproxy.MessageProxyListener
        public void onMessageReceived(MessageInfo message) {
            i.f(message, "message");
            k.a("WatchFaceViewModel", i.n("onMessageReceived ", message.getPath()));
            String path = message.getPath();
            if (i.b(path, WearPath.WatchfaceMarket.FEATURED_LIST)) {
                this.f16362c = true;
                String string = this.f16364e.getString(s.f16471h);
                i.e(string, "context.getString(R.string.featured)");
                this.f16365f.onNext(a(string, message, 100));
                if (this.f16363d && this.f16362c) {
                    b();
                    this.f16365f.onCompleted();
                }
            } else if (i.b(path, WearPath.WatchfaceMarket.DOWNLOAD_LIST)) {
                this.f16363d = true;
                String string2 = this.f16364e.getString(s.f16469e);
                i.e(string2, "context.getString(R.string.download)");
                this.f16365f.onNext(a(string2, message, 101));
                if (this.f16363d && this.f16362c) {
                    b();
                    this.f16365f.onCompleted();
                }
            }
        }
    }

    static {
        new a(null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchFaceViewModel(Application application) {
        super(application);
        i.f(application, "application");
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(WearPath.WatchfaceMarket.SET_CONFIRM, WearPath.WatchfaceMarket.SET);
        hashMap.put(WearPath.WatchfaceMarket.NEED_SHOW_DATE_AND_WEEK_CONFIRM, WearPath.WatchfaceMarket.NEED_SHOW_DATE_AND_WEEK);
        hashMap.put(WearPath.WatchfaceMarket.NEED_SHOW_BATTERY_CONFIRM, WearPath.WatchfaceMarket.NEED_SHOW_BATTERY);
        hashMap.put(WearPath.WatchfaceMarket.BACK_IMAGE_CONFIRM, WearPath.WatchfaceMarket.BACK_IMAGE);
        hashMap.put(WearPath.WatchfaceMarket.TIME_PLACE_CONFIRM, WearPath.WatchfaceMarket.TIME_PLACE);
        m mVar = m.f28349a;
        this.f16347a = hashMap;
        this.f16348b = application.getApplicationContext();
        this.f16360n = true;
        this.f16350d = !i.b("com.mobvoi.baiding", application.getPackageName());
        MessageProxyClient.getInstance().addListener(this);
        this.f16360n = q.a(application, "watchface_center_pref", "needGrantPermission", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final byte[] C(Bitmap bitmap) {
        byte[] bArr;
        if (bitmap == null) {
            bArr = null;
        } else {
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, AGCServerException.AUTHENTICATION_INVALID, (bitmap.getHeight() * AGCServerException.AUTHENTICATION_INVALID) / bitmap.getWidth(), true);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            createScaledBitmap.compress(Bitmap.CompressFormat.JPEG, 90, byteArrayOutputStream);
            bArr = byteArrayOutputStream.toByteArray();
        }
        return bArr == null ? new byte[0] : bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(WatchFaceBean watchFaceInfo, WatchFaceViewModel this$0, String str, byte[] imageBytes) {
        i.f(watchFaceInfo, "$watchFaceInfo");
        i.f(this$0, "this$0");
        String json = new com.google.gson.f().c().b().s(watchFaceInfo);
        i.e(json, "json");
        byte[] bytes = json.getBytes(d.f30092a);
        i.e(bytes, "(this as java.lang.String).getBytes(charset)");
        ByteBuffer put = ByteBuffer.allocate(bytes.length + 4 + imageBytes.length).putInt(bytes.length).put(bytes);
        i.e(imageBytes, "imageBytes");
        if (!(imageBytes.length == 0)) {
            put.put(imageBytes);
        }
        byte[] array = put.array();
        i.e(array, "byteBuffer.array()");
        this$0.Y(str, WearPath.WatchfaceMarket.SET_IMAGE_WATCHFACE, array);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(Throwable th2) {
        k.d("WatchFaceViewModel", th2.getMessage());
    }

    private final void G() {
        this.f16349c.removeCallbacksAndMessages(null);
    }

    private final void H(String str) {
        this.f16349c.removeCallbacksAndMessages(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArrayList J() {
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(ArrayList arrayList, List list) {
        arrayList.addAll(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArrayList L(WatchFaceViewModel this_run, Context context, ArrayList listFromWatch, ArrayList listFromNetwork) {
        List<WatchFaceBean> c10;
        i.f(this_run, "$this_run");
        i.f(context, "$context");
        this_run.f16351e.clear();
        i.e(listFromNetwork, "listFromNetwork");
        if (!listFromNetwork.isEmpty()) {
            Iterator it = listFromNetwork.iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                this_run.f16351e.put(eVar.a(), eVar.c());
            }
        }
        i.e(listFromWatch, "listFromWatch");
        if (!listFromWatch.isEmpty()) {
            Iterator it2 = listFromWatch.iterator();
            while (it2.hasNext()) {
                e eVar2 = (e) it2.next();
                this_run.f16351e.put(eVar2.a(), eVar2.c());
                if (eVar2.a() == 100 && (c10 = eVar2.c()) != null) {
                    Iterator<WatchFaceBean> it3 = c10.iterator();
                    while (true) {
                        if (it3.hasNext()) {
                            WatchFaceBean next = it3.next();
                            if (i.b(next.c(), "com.mobvoi.ticwear.watchface.service.ImageWatchFace")) {
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(next);
                                listFromNetwork.add(new e(100, context.getApplicationContext().getString(s.i_res_0x7f14089e), false, arrayList, 0, 0));
                                break;
                            }
                        }
                    }
                }
            }
        }
        return listFromNetwork;
    }

    private final c<List<e>> M(final Context context) {
        c<List<e>> h10 = c.h(new yp.b() { // from class: com.mobvoi.companion.aw.watchfacecenter.b0
            @Override // yp.b
            public final void call(Object obj) {
                WatchFaceViewModel.N(context, (Emitter) obj);
            }
        }, Emitter.BackpressureMode.LATEST);
        i.e(h10, "create({ emitter ->\n            val watchFaceMessageProxyImpl = object : WatchFaceMessageProxyImpl(context) {\n                var hasReceivedFeaturedList = false\n                var hasReceivedDownloadList = false\n\n                override fun onMessageReceived(message: MessageInfo) {\n                    LogUtil.d(TAG, \"onMessageReceived ${message.path}\")\n                    when (message.path) {\n                        WearPath.WatchfaceMarket.FEATURED_LIST -> {\n                            hasReceivedFeaturedList = true\n                            val list = parseWatchFaceMessage(\n                                context.getString(R.string.featured), message,\n                                WatchfaceCard.POS_FEATURED\n                            )\n                            emitter.onNext(list)\n                            if (hasReceivedDownloadList and hasReceivedFeaturedList) {\n                                unregisterSelf()\n                                emitter.onCompleted()\n                            }\n                        }\n                        WearPath.WatchfaceMarket.DOWNLOAD_LIST -> {\n                            hasReceivedDownloadList = true\n                            val list = parseWatchFaceMessage(\n                                context.getString(R.string.download), message,\n                                WatchfaceCard.POS_DOWNLOAD\n                            )\n                            emitter.onNext(list)\n                            if (hasReceivedDownloadList and hasReceivedFeaturedList) {\n                                unregisterSelf()\n                                emitter.onCompleted()\n                            }\n                        }\n                    }\n                }\n            }\n            MessageProxyClient.getInstance().addListener(watchFaceMessageProxyImpl)\n            MessageProxyClient.getInstance().sendMessage(WearPath.WatchfaceMarket.FEATURED_LIST)\n\n            emitter.setCancellation {\n                MessageProxyClient.getInstance().removeListener(watchFaceMessageProxyImpl)\n            }\n        }, Emitter.BackpressureMode.LATEST)");
        return h10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(Context context, Emitter emitter) {
        i.f(context, "$context");
        final b bVar = new b(context, emitter);
        MessageProxyClient.getInstance().addListener(bVar);
        MessageProxyClient.getInstance().sendMessage(WearPath.WatchfaceMarket.FEATURED_LIST);
        emitter.a(new yp.e() { // from class: com.mobvoi.companion.aw.watchfacecenter.f0
            @Override // yp.e
            public final void cancel() {
                WatchFaceViewModel.O(WatchFaceViewModel.b.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O(b watchFaceMessageProxyImpl) {
        i.f(watchFaceMessageProxyImpl, "$watchFaceMessageProxyImpl");
        MessageProxyClient.getInstance().removeListener(watchFaceMessageProxyImpl);
    }

    private final c<ArrayList<e>> P(final Context context) {
        return c.A(Boolean.valueOf(com.mobvoi.android.common.utils.m.b(context))).v(new g() { // from class: com.mobvoi.companion.aw.watchfacecenter.x
            @Override // yp.g
            public final Object call(Object obj) {
                c Q;
                Q = WatchFaceViewModel.Q(WatchFaceViewModel.this, context, (Boolean) obj);
                return Q;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final c Q(WatchFaceViewModel this$0, final Context context, Boolean hasNetwork) {
        i.f(this$0, "this$0");
        i.f(context, "$context");
        k.a("WatchFaceViewModel", "start requestWatchFaceCardListByNetwork");
        i.e(hasNetwork, "hasNetwork");
        if (hasNetwork.booleanValue()) {
            ac.b bVar = this$0.f16352f;
            boolean z10 = this$0.f16350d;
            String x10 = ta.a.x();
            i.e(x10, "getWwid()");
            return bVar.c(z10, x10).c0(10L, TimeUnit.SECONDS, c.A(new cc.f())).v(new g() { // from class: com.mobvoi.companion.aw.watchfacecenter.w
                @Override // yp.g
                public final Object call(Object obj) {
                    c R;
                    R = WatchFaceViewModel.R(context, (cc.f) obj);
                    return R;
                }
            }).N(y.f16566a);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new e(0, context.getString(s.f16472r), false, new ArrayList(), 2, 0, 32, null));
        return c.A(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final c R(Context context, cc.f fVar) {
        i.f(context, "$context");
        ArrayList arrayList = new ArrayList();
        List<f.a> a10 = fVar.a();
        if (a10 != null) {
            for (f.a aVar : a10) {
                if (aVar.d() != 0) {
                    ArrayList arrayList2 = new ArrayList();
                    List<f.a.C0082a> a11 = aVar.a();
                    if (a11 != null) {
                        for (f.a.C0082a aVar2 : a11) {
                            WatchFaceBean watchFaceBean = new WatchFaceBean();
                            watchFaceBean.B(aVar2.e());
                            watchFaceBean.D(aVar2.a());
                            watchFaceBean.H(!TextUtils.isEmpty(aVar2.i()) ? aVar2.i() : aVar2.d());
                            String a12 = aVar2.a();
                            if (a12 == null) {
                                a12 = "";
                            }
                            watchFaceBean.x(new ComponentName(context, a12));
                            watchFaceBean.u(0);
                            watchFaceBean.C(aVar2.f());
                            watchFaceBean.y(aVar2.b());
                            watchFaceBean.z(aVar2.c());
                            watchFaceBean.G(aVar2.h());
                            watchFaceBean.I(aVar2.g());
                            arrayList2.add(watchFaceBean);
                        }
                    }
                    if (!arrayList2.isEmpty()) {
                        int b10 = aVar.b();
                        String e10 = aVar.e();
                        if (e10 == null) {
                            e10 = "";
                        }
                        Integer c10 = aVar.c();
                        arrayList.add(new e(b10, e10, true, arrayList2, 0, c10 == null ? 0 : c10.intValue()));
                    }
                }
            }
        }
        return c.A(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArrayList S(Throwable th2) {
        k.d("WatchFaceViewModel", i.n("Error happens when fetch card list: ", th2.getMessage()));
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final c W(Context context, cc.d dVar) {
        List<cc.a> a10;
        i.f(context, "$context");
        ArrayList arrayList = new ArrayList();
        cc.c a11 = dVar.a();
        if (!(a11 == null || (a10 = a11.a()) == null)) {
            for (cc.a aVar : a10) {
                WatchFaceBean watchFaceBean = new WatchFaceBean();
                watchFaceBean.B(aVar.e());
                watchFaceBean.D(aVar.a());
                watchFaceBean.H(aVar.i());
                String a12 = aVar.a();
                if (a12 == null) {
                    a12 = "";
                }
                watchFaceBean.x(new ComponentName(context, a12));
                watchFaceBean.u(0);
                watchFaceBean.C(aVar.f());
                watchFaceBean.y(aVar.b());
                watchFaceBean.z(aVar.c());
                watchFaceBean.G(aVar.h());
                watchFaceBean.I(aVar.g());
                arrayList.add(watchFaceBean);
            }
        }
        return c.A(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final c X(Context context, cc.d dVar) {
        List<cc.a> a10;
        i.f(context, "$context");
        ArrayList arrayList = new ArrayList();
        cc.c a11 = dVar.a();
        if (!(a11 == null || (a10 = a11.a()) == null)) {
            for (cc.a aVar : a10) {
                WatchFaceBean watchFaceBean = new WatchFaceBean();
                watchFaceBean.B(aVar.e());
                watchFaceBean.D(aVar.a());
                watchFaceBean.H(aVar.i());
                String a12 = aVar.a();
                if (a12 == null) {
                    a12 = "";
                }
                watchFaceBean.x(new ComponentName(context, a12));
                watchFaceBean.u(0);
                watchFaceBean.C(aVar.f());
                watchFaceBean.y(aVar.b());
                watchFaceBean.z(aVar.c());
                watchFaceBean.G(aVar.h());
                watchFaceBean.I(aVar.g());
                arrayList.add(watchFaceBean);
            }
        }
        return c.A(arrayList);
    }

    private final void p(final String str) {
        if (this.f16347a.get(str) != null) {
            H(str);
            this.f16349c.postAtTime(new Runnable() { // from class: com.mobvoi.companion.aw.watchfacecenter.v
                @Override // java.lang.Runnable
                public final void run() {
                    WatchFaceViewModel.q(WatchFaceViewModel.this, str);
                }
            }, str, SystemClock.uptimeMillis() + PayTask.f6879j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(WatchFaceViewModel this$0, String path) {
        i.f(this$0, "this$0");
        i.f(path, "$path");
        this$0.v().m(path);
    }

    public final void A(final WatchFaceBean watchFaceInfo, final Bitmap bitmap, final String str) {
        i.f(watchFaceInfo, "watchFaceInfo");
        if (s(str)) {
            this.f16359m = false;
            this.f16361o.a(c.x(new Callable() { // from class: com.mobvoi.companion.aw.watchfacecenter.a0
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    byte[] C;
                    C = WatchFaceViewModel.C(bitmap);
                    return C;
                }
            }).Z(cq.a.c()).H(xp.a.b()).Y(new yp.b() { // from class: com.mobvoi.companion.aw.watchfacecenter.c0
                @Override // yp.b
                public final void call(Object obj) {
                    WatchFaceViewModel.D(WatchFaceBean.this, this, str, (byte[]) obj);
                }
            }, d0.f16375a));
        }
    }

    public final void B(WatchFaceBean watchFaceInfo, String str) {
        i.f(watchFaceInfo, "watchFaceInfo");
        if (s(str)) {
            this.f16359m = watchFaceInfo.j();
            String json = new com.google.gson.f().c().b().s(watchFaceInfo);
            i.e(json, "json");
            byte[] bytes = json.getBytes(d.f30092a);
            i.e(bytes, "(this as java.lang.String).getBytes(charset)");
            Y(str, WearPath.WatchfaceMarket.SET, bytes);
        }
    }

    public final boolean F() {
        return this.f16359m;
    }

    public final c<ArrayList<e>> I(final Context context) {
        i.f(context, "context");
        c<ArrayList<e>> H = c.l0(M(context).b(g0.f16434a, e0.f16376a).c0(5000L, TimeUnit.MILLISECONDS, c.A(new ArrayList())).Z(cq.a.c()), P(context).Z(cq.a.c()), new h() { // from class: com.mobvoi.companion.aw.watchfacecenter.z
            @Override // yp.h
            public final Object a(Object obj, Object obj2) {
                ArrayList L;
                L = WatchFaceViewModel.L(WatchFaceViewModel.this, context, (ArrayList) obj, (ArrayList) obj2);
                return L;
            }
        }).Z(cq.a.c()).H(xp.a.b());
        i.e(H, "run {\n        val observableFromWatch = requestFeaturedAndDownloadList(context)\n            .collect(Func0 { return@Func0 ArrayList<WatchFaceCardBean>() }) { total, single ->\n                total.addAll(single)\n            }.timeout(5000L, TimeUnit.MILLISECONDS, Observable.just(ArrayList()))\n            .subscribeOn(Schedulers.io())\n        val observableFromNetwork =\n            requestWatchFaceCardListByNetwork(context).subscribeOn(Schedulers.io())\n        Observable.zip(\n            observableFromWatch,\n            observableFromNetwork\n        ) { listFromWatch, listFromNetwork ->\n            watchFaceBeanSparse.clear()\n            if (listFromNetwork.isNotEmpty()) {\n                for (cardBean in listFromNetwork) {\n                    watchFaceBeanSparse.put(cardBean.cardIndex, cardBean.cardWatchBeanList)\n                }\n            }\n            if (listFromWatch.isNotEmpty()) {\n                for (cardBean in listFromWatch) {\n                    watchFaceBeanSparse.put(cardBean.cardIndex, cardBean.cardWatchBeanList)\n                    if (cardBean.cardIndex == WatchfaceCard.POS_FEATURED) {\n                        cardBean.cardWatchBeanList?.let { featuredList ->\n                            innerLoop@ for (bean in featuredList) {\n                                if (bean.className == ImageWatchFace.CLASS_NAME) {\n                                    val imageWatchFace = ArrayList<WatchFaceBean>().apply {\n                                        add(bean)\n                                    }\n                                    listFromNetwork.add(\n                                        WatchFaceCardBean(\n                                            WatchfaceCard.POS_FEATURED,\n                                            context.applicationContext.getString(R.string.image_watch_face),\n                                            false,\n                                            imageWatchFace,\n                                            DataType.NORMAL_DATA,\n                                            0\n                                        )\n                                    )\n                                    break@innerLoop\n                                }\n                            }\n                        }\n                    }\n                }\n            }\n            return@zip listFromNetwork\n        }.subscribeOn(Schedulers.io())\n            .observeOn(AndroidSchedulers.mainThread())\n    }");
        return H;
    }

    public final c<cc.g> T(String pkgName) {
        i.f(pkgName, "pkgName");
        return this.f16352f.d(pkgName, this.f16350d);
    }

    public final c<ArrayList<WatchFaceBean>> U(final Context context, int i10, int i11) {
        i.f(context, "context");
        c v10 = this.f16352f.e(String.valueOf(i10), String.valueOf(i11), this.f16350d).v(new g() { // from class: com.mobvoi.companion.aw.watchfacecenter.i0
            @Override // yp.g
            public final Object call(Object obj) {
                c W;
                W = WatchFaceViewModel.W(context, (cc.d) obj);
                return W;
            }
        });
        i.e(v10, "helper.getWatchFaceList(pageNum.toString(), pageSize.toString(), isOversea)\n            .flatMap { resp ->\n                val watchFaceList = ArrayList<WatchFaceBean>()\n                resp.data?.data?.let { list ->\n                    for (bean in list) {\n                        val watchFaceBean = WatchFaceBean().apply {\n                            name = bean.name\n                            pkg = bean.apkPackageName\n                            previewUrl = bean.thumbnailUrl\n                            componentName = ComponentName(\n                                context, bean.apkPackageName\n                                    ?: \"\"\n                            )\n                            category = WatchFaceBean.CategoryType.RECOMMEND\n                            needPay = bean.needPay\n                            description = bean.description\n                            developerName = bean.developerName\n                            previewImages = bean.snapshotUrlList\n                            price = bean.price\n                        }\n                        watchFaceList.add(watchFaceBean)\n                    }\n                }\n                return@flatMap Observable.just(watchFaceList)\n            }");
        return v10;
    }

    public final c<ArrayList<WatchFaceBean>> V(final Context context, int i10, int i11, int i12, int i13) {
        i.f(context, "context");
        ac.b bVar = this.f16352f;
        String x10 = ta.a.x();
        i.e(x10, "getWwid()");
        c v10 = bVar.b(i12, i13, i10, i11, x10, this.f16350d).v(new g() { // from class: com.mobvoi.companion.aw.watchfacecenter.h0
            @Override // yp.g
            public final Object call(Object obj) {
                c X;
                X = WatchFaceViewModel.X(context, (cc.d) obj);
                return X;
            }
        });
        i.e(v10, "helper.getMoreWatchFace(\n            categoryId, secondCategoryId, pageNum, pageSize,\n            AccountPreferenceHelper.getWwid(), isOversea\n        )\n            .flatMap { resp ->\n                val watchFaceList = ArrayList<WatchFaceBean>()\n                resp.data?.data?.let {\n                    for (bean in it) {\n                        val watchFaceBean = WatchFaceBean().apply {\n                            name = bean.name\n                            pkg = bean.apkPackageName\n                            previewUrl = bean.thumbnailUrl\n                            componentName = ComponentName(\n                                context, bean.apkPackageName\n                                    ?: \"\"\n                            )\n                            category = WatchFaceBean.CategoryType.RECOMMEND\n                            needPay = bean.needPay\n                            description = bean.description\n                            developerName = bean.developerName\n                            previewImages = bean.snapshotUrlList\n                            price = bean.price\n                        }\n                        watchFaceList.add(watchFaceBean)\n                    }\n                }\n                return@flatMap Observable.just(watchFaceList)\n            }");
        return v10;
    }

    public final void Y(String str, String path, byte[] payload) {
        i.f(path, "path");
        i.f(payload, "payload");
        if (str != null) {
            MessageProxyClient.getInstance().sendMessage(str, path, payload);
            p(path);
        }
    }

    public final void Z(WatchFaceBean watchFaceBean) {
        i.f(watchFaceBean, "watchFaceBean");
        this.f16358l.m(watchFaceBean);
    }

    public final void a0(String title) {
        i.f(title, "title");
        this.f16353g.m(title);
    }

    public final void o(j subscription) {
        i.f(subscription, "subscription");
        this.f16361o.a(subscription);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.f0
    public void onCleared() {
        super.onCleared();
        k.a("WatchFaceViewModel", "WatchFaceViewModel onCleared");
        MessageProxyClient.getInstance().removeListener(this);
        this.f16361o.b();
        G();
        this.f16351e.clear();
    }

    @Override // com.mobvoi.wear.msgproxy.MessageProxyListener
    public void onConnectedNodesChanged(List<NodeInfo> nodes) {
        i.f(nodes, "nodes");
    }

    @Override // com.mobvoi.wear.msgproxy.MessageProxyListener
    public void onMessageReceived(MessageInfo message) {
        i.f(message, "message");
        k.d("WatchFaceViewModel", i.n("onMessageReceived ", message.getPath()));
        if (this.f16360n && i.b(WearPath.WatchfaceMarket.BACK_IMAGE_CONFIRM, message.getPath())) {
            this.f16360n = false;
            q.e(this.f16348b, "watchface_center_pref", "needGrantPermission", false);
        }
        String str = this.f16347a.get(message.getPath());
        if (str != null) {
            H(str);
        }
        this.f16354h.m(message);
    }

    public final void r(boolean z10) {
        this.f16357k.m(Boolean.valueOf(z10));
    }

    public final boolean s(String str) {
        boolean c10 = yd.k.c(str);
        k.h("WatchFaceViewModel", i.n("checkDeviceConnect TicConnectUtils.isTicDeviceConnected() = ", Boolean.valueOf(c10)));
        this.f16356j.m(Boolean.valueOf(c10));
        return c10;
    }

    public final w<WatchFaceBean> t() {
        return this.f16358l;
    }

    public final w<MessageInfo> u() {
        return this.f16354h;
    }

    public final w<String> v() {
        return this.f16355i;
    }

    public final boolean w() {
        return this.f16360n;
    }

    public final w<String> x() {
        return this.f16353g;
    }

    public final List<WatchFaceBean> y(int i10) {
        return this.f16351e.get(i10);
    }

    public final w<Boolean> z() {
        return this.f16356j;
    }
}
