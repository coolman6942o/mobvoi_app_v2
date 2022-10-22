package com.mobvoi.record;

import android.util.Pair;
import androidx.lifecycle.f0;
import androidx.lifecycle.w;
import com.googlecode.protobuf.format.JsonFormat;
import com.mobvoi.companion.proto.AccountProto;
import com.mobvoi.companion.proto.PayProto;
import com.mobvoi.companion.proto.ProductProto;
import com.mobvoi.companion.proto.ResponseProto;
import com.mobvoi.companion.proto.SoundProto;
import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.c;
/* loaded from: classes2.dex */
public class RecordViewModel extends f0 {

    /* renamed from: b  reason: collision with root package name */
    private rx.j f20364b;

    /* renamed from: c  reason: collision with root package name */
    public w<List<ProductProto.SoundProduct>> f20365c = new w<>();

    /* renamed from: d  reason: collision with root package name */
    public w<String> f20366d = new w<>();

    /* renamed from: e  reason: collision with root package name */
    public w<PayProto.SoundPayResp> f20367e = new w<>();

    /* renamed from: a  reason: collision with root package name */
    private final ld.e f20363a = ld.e.h();

    /* renamed from: f  reason: collision with root package name */
    private final w<List<SoundProto.SoundFile>> f20368f = new w<>();

    /* renamed from: g  reason: collision with root package name */
    private final w<String> f20369g = new w<>();

    /* renamed from: h  reason: collision with root package name */
    private final w<String> f20370h = new w<>();

    /* renamed from: i  reason: collision with root package name */
    private final w<String> f20371i = new w<>();

    /* renamed from: j  reason: collision with root package name */
    private final w<SoundProto.SoundConvertResultResp> f20372j = new w<>();

    /* renamed from: k  reason: collision with root package name */
    private final w<String> f20373k = new w<>();

    /* renamed from: l  reason: collision with root package name */
    private final w<String> f20374l = new w<>();

    /* renamed from: m  reason: collision with root package name */
    private final w<String[]> f20375m = new w<>();

    /* renamed from: n  reason: collision with root package name */
    private final w<AccountProto.SoundAccountResp> f20376n = new w<>();

    /* renamed from: o  reason: collision with root package name */
    private final w<String> f20377o = new w<>();

    /* renamed from: p  reason: collision with root package name */
    private final w<Pair<String, String>> f20378p = new w<>();

    /* loaded from: classes2.dex */
    class a extends rx.i<ResponseProto.CommonResp> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f20379a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f20380b;

        a(String str, String str2) {
            this.f20379a = str;
            this.f20380b = str2;
        }

        /* renamed from: b */
        public void onNext(ResponseProto.CommonResp commonResp) {
            if (commonResp.getErrCode() == 0) {
                RecordViewModel.this.f20378p.o(new Pair(this.f20379a, this.f20380b));
                return;
            }
            com.mobvoi.android.common.utils.k.a("RecordsViewModel", "renameSpeaker: " + commonResp.getErrMsg());
        }

        @Override // rx.d
        public void onCompleted() {
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            com.mobvoi.android.common.utils.k.a("RecordsViewModel", "renameSpeaker: " + th2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class b extends rx.i<ResponseProto.CommonResp> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String[] f20382a;

        b(String[] strArr) {
            this.f20382a = strArr;
        }

        /* renamed from: b */
        public void onNext(ResponseProto.CommonResp commonResp) {
            com.mobvoi.android.common.utils.k.a("RecordsViewModel", "更改关键字: " + commonResp.toString());
            RecordViewModel.this.f20375m.o(this.f20382a);
        }

        @Override // rx.d
        public void onCompleted() {
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            com.mobvoi.android.common.utils.k.a("RecordsViewModel", "更改关键字: " + th2.getMessage());
        }
    }

    /* loaded from: classes2.dex */
    class c extends rx.i<AccountProto.SoundAccountResp> {
        c() {
        }

        /* renamed from: b */
        public void onNext(AccountProto.SoundAccountResp soundAccountResp) {
            com.mobvoi.android.common.utils.k.a("RecordsViewModel", "绑定时长券: " + soundAccountResp.toString());
            com.mobvoi.android.common.utils.k.a("RecordsViewModel", "绑定时长券: " + soundAccountResp.getErrMsg());
            RecordViewModel.this.f20376n.o(soundAccountResp);
        }

        @Override // rx.d
        public void onCompleted() {
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            com.mobvoi.android.common.utils.k.a("RecordsViewModel", "绑定时长券: " + th2.getMessage());
        }
    }

    /* loaded from: classes2.dex */
    class d extends rx.i<ProductProto.SoundProductResp> {
        d() {
        }

        /* renamed from: b */
        public void onNext(ProductProto.SoundProductResp soundProductResp) {
            com.mobvoi.android.common.utils.k.a("RecordsViewModel", "获取产品列表: " + JsonFormat.i(soundProductResp));
            if (soundProductResp.getErrCode() == 0) {
                RecordViewModel.this.f20365c.o(soundProductResp.getSoundProductsList());
                return;
            }
            com.mobvoi.android.common.utils.k.a("RecordsViewModel", "获取产品列表: " + soundProductResp.getErrMsg());
        }

        @Override // rx.d
        public void onCompleted() {
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            com.mobvoi.android.common.utils.k.a("RecordsViewModel", "获取产品列表: " + th2.getMessage());
        }
    }

    /* loaded from: classes2.dex */
    class e extends rx.i<ProductProto.SoundProductResp> {
        e() {
        }

        /* renamed from: b */
        public void onNext(ProductProto.SoundProductResp soundProductResp) {
            com.mobvoi.android.common.utils.k.a("RecordsViewModel", "获取产品列表: " + JsonFormat.i(soundProductResp));
            if (soundProductResp.getErrCode() == 0) {
                RecordViewModel.this.f20365c.o(soundProductResp.getSoundProductsList());
                return;
            }
            com.mobvoi.android.common.utils.k.a("RecordsViewModel", "获取产品列表: " + soundProductResp.getErrMsg());
        }

        @Override // rx.d
        public void onCompleted() {
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            com.mobvoi.android.common.utils.k.a("RecordsViewModel", "获取产品列表: " + th2.getMessage());
        }
    }

    /* loaded from: classes2.dex */
    class f extends rx.i<ResponseProto.CommonResp> {
        f() {
        }

        /* renamed from: b */
        public void onNext(ResponseProto.CommonResp commonResp) {
            if (commonResp.getErrCode() == 0) {
                com.mobvoi.android.common.utils.k.a("RecordsViewModel", "支付成功---" + commonResp.toString());
                RecordViewModel.this.f20366d.o(commonResp.getErrMsg());
                return;
            }
            com.mobvoi.android.common.utils.k.a("RecordsViewModel", "支付失败---");
        }

        @Override // rx.d
        public void onCompleted() {
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            com.mobvoi.android.common.utils.k.a("RecordsViewModel", "支付失败----" + th2.getMessage());
        }
    }

    /* loaded from: classes2.dex */
    class g extends rx.i<PayProto.SoundPayResp> {
        g() {
        }

        /* renamed from: b */
        public void onNext(PayProto.SoundPayResp soundPayResp) {
            com.mobvoi.android.common.utils.k.a("RecordsViewModel", "创建订单成功: " + JsonFormat.i(soundPayResp));
            if (soundPayResp.getErrCode() == 0) {
                RecordViewModel.this.f20367e.o(soundPayResp);
                return;
            }
            com.mobvoi.android.common.utils.k.a("RecordsViewModel", "创建订单失败" + soundPayResp.getErrMsg());
            RecordViewModel.this.f20367e.o(null);
        }

        @Override // rx.d
        public void onCompleted() {
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            com.mobvoi.android.common.utils.k.a("RecordsViewModel", "创建订单失败: " + th2.getMessage());
            RecordViewModel.this.f20367e.o(null);
        }
    }

    /* loaded from: classes2.dex */
    class h extends rx.i<SoundProto.SoundFileResp> {
        h() {
        }

        /* renamed from: b */
        public void onNext(SoundProto.SoundFileResp soundFileResp) {
            com.mobvoi.android.common.utils.k.a("RecordsViewModel", "onNext: " + soundFileResp);
            if (soundFileResp.getErrCode() == 0) {
                RecordViewModel.this.f20368f.o(soundFileResp.getSoundFilesList());
                return;
            }
            com.mobvoi.android.common.utils.k.a("RecordsViewModel", "onNext error： " + soundFileResp.getErrMsg());
        }

        @Override // rx.d
        public void onCompleted() {
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            com.mobvoi.android.common.utils.k.a("RecordsViewModel", "onError : " + th2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class i extends rx.i<SoundProto.SoundFileResp> {
        i() {
        }

        /* renamed from: b */
        public void onNext(SoundProto.SoundFileResp soundFileResp) {
            com.mobvoi.android.common.utils.k.a("RecordsViewModel", "删除文件: " + soundFileResp.toString());
            if (soundFileResp.getErrCode() == 0) {
                RecordViewModel.this.f20369g.o(soundFileResp.getErrMsg());
                return;
            }
            com.mobvoi.android.common.utils.k.a("RecordsViewModel", "删除文件: " + soundFileResp.getErrMsg());
        }

        @Override // rx.d
        public void onCompleted() {
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            com.mobvoi.android.common.utils.k.a("RecordsViewModel", "删除文件: " + th2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class j extends rx.i<SoundProto.SoundFileResp> {
        j() {
        }

        /* renamed from: b */
        public void onNext(SoundProto.SoundFileResp soundFileResp) {
            com.mobvoi.android.common.utils.k.a("RecordsViewModel", "重命名: " + soundFileResp.toString());
            if (soundFileResp.getErrCode() == 0) {
                RecordViewModel.this.f20370h.o(soundFileResp.getErrMsg());
                return;
            }
            com.mobvoi.android.common.utils.k.a("RecordsViewModel", "重命名: " + soundFileResp.getErrMsg());
        }

        @Override // rx.d
        public void onCompleted() {
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            com.mobvoi.android.common.utils.k.a("RecordsViewModel", "重命名: " + th2.getMessage());
        }
    }

    /* loaded from: classes2.dex */
    class k extends rx.i<SoundProto.SoundConvertResultResp> {
        k() {
        }

        /* renamed from: b */
        public void onNext(SoundProto.SoundConvertResultResp soundConvertResultResp) {
            com.mobvoi.android.common.utils.k.c("RecordsViewModel", "startConvert: %s", soundConvertResultResp.toString());
            if (soundConvertResultResp.getErrCode() == 0 || soundConvertResultResp.getErrCode() == 3004) {
                RecordViewModel.this.f20371i.o(soundConvertResultResp.getErrMsg());
                return;
            }
            com.mobvoi.android.common.utils.k.a("RecordsViewModel", "开始转录: " + soundConvertResultResp.getErrMsg());
        }

        @Override // rx.d
        public void onCompleted() {
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            com.mobvoi.android.common.utils.k.e("RecordsViewModel", "startConvert onError", th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class l extends rx.i<SoundProto.SoundConvertResultResp> {
        l() {
        }

        /* renamed from: b */
        public void onNext(SoundProto.SoundConvertResultResp soundConvertResultResp) {
            com.mobvoi.android.common.utils.k.a("RecordsViewModel", "转录结果: " + JsonFormat.i(soundConvertResultResp));
            if (soundConvertResultResp.getErrCode() == 0 || soundConvertResultResp.getErrCode() == 3004) {
                RecordViewModel.this.f20372j.o(soundConvertResultResp);
                return;
            }
            com.mobvoi.android.common.utils.k.a("RecordsViewModel", "转录结果: " + soundConvertResultResp.getErrMsg());
        }

        @Override // rx.d
        public void onCompleted() {
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            com.mobvoi.android.common.utils.k.a("RecordsViewModel", "转录结果onError: " + th2.getMessage());
        }
    }

    /* loaded from: classes2.dex */
    class m extends rx.i<SoundProto.SoundFileResp> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f20394a;

        m(boolean z10) {
            this.f20394a = z10;
        }

        /* renamed from: b */
        public void onNext(SoundProto.SoundFileResp soundFileResp) {
            com.mobvoi.android.common.utils.k.a("RecordsViewModel", "打点结果" + soundFileResp.toString());
            if (soundFileResp.getErrCode() != 0) {
                com.mobvoi.android.common.utils.k.a("RecordsViewModel", "打点结果" + soundFileResp.getErrMsg());
            } else if (this.f20394a) {
                RecordViewModel.this.f20374l.o(soundFileResp.getErrMsg());
            } else {
                RecordViewModel.this.f20373k.o(soundFileResp.getErrMsg());
            }
        }

        @Override // rx.d
        public void onCompleted() {
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            com.mobvoi.android.common.utils.k.a("RecordsViewModel", "打点Error: " + th2.getMessage());
        }
    }

    /* loaded from: classes2.dex */
    class n extends rx.i<AccountProto.SoundAccountResp> {
        n() {
        }

        /* renamed from: b */
        public void onNext(AccountProto.SoundAccountResp soundAccountResp) {
            com.mobvoi.android.common.utils.k.a("RecordsViewModel", "账户信息: " + JsonFormat.i(soundAccountResp));
            if (soundAccountResp.getErrCode() == 0) {
                RecordViewModel.this.f20376n.o(soundAccountResp);
                return;
            }
            com.mobvoi.android.common.utils.k.a("RecordsViewModel", "账户信息: " + soundAccountResp.getErrMsg());
        }

        @Override // rx.d
        public void onCompleted() {
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            com.mobvoi.android.common.utils.k.a("RecordsViewModel", "账户信息: " + th2.getMessage());
        }
    }

    /* loaded from: classes2.dex */
    class o extends rx.i<ResponseProto.CommonResp> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f20397a;

        o(String str) {
            this.f20397a = str;
        }

        /* renamed from: b */
        public void onNext(ResponseProto.CommonResp commonResp) {
            if (commonResp.getErrCode() == 0) {
                com.mobvoi.android.common.utils.k.a("RecordsViewModel", "更改某段内容成功: " + commonResp.toString());
                RecordViewModel.this.f20377o.o(this.f20397a);
                return;
            }
            com.mobvoi.android.common.utils.k.a("RecordsViewModel", "更改某段内容失败1: " + commonResp.getErrMsg());
        }

        @Override // rx.d
        public void onCompleted() {
        }

        @Override // rx.d
        public void onError(Throwable th2) {
            com.mobvoi.android.common.utils.k.a("RecordsViewModel", "更改某段内容失败2: " + th2.getMessage());
        }
    }

    public RecordViewModel() {
        new w();
        new w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ rx.c G(String str, String str2, Long l10) {
        return this.f20363a.g(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Boolean H(SoundProto.SoundConvertResultResp soundConvertResultResp) {
        return Boolean.valueOf(soundConvertResultResp.getPercentage() == 100.0f || soundConvertResultResp.getErrCode() == 3004 || soundConvertResultResp.getErrCode() == 1002);
    }

    public void A(final String str) {
        final String s10 = ta.a.s();
        this.f20364b = rx.c.y(0L, 3L, TimeUnit.SECONDS).v(new yp.g() { // from class: com.mobvoi.record.n
            @Override // yp.g
            public final Object call(Object obj) {
                c G;
                G = RecordViewModel.this.G(s10, str, (Long) obj);
                return G;
            }
        }).b0(com.mobvoi.record.o.f20688a).Z(cq.a.c()).H(xp.a.b()).V(new l());
    }

    public w<String> B() {
        return this.f20369g;
    }

    public w<List<SoundProto.SoundFile>> C() {
        return this.f20368f;
    }

    public void D(int i10, int i11) {
        this.f20363a.n(ta.a.s(), i10, i11).Z(cq.a.c()).H(xp.a.b()).V(new h());
    }

    public w<String> E() {
        return this.f20370h;
    }

    public w<SoundProto.SoundConvertResultResp> F() {
        return this.f20372j;
    }

    public void I(String str, int i10, String str2) {
        this.f20363a.k(ta.a.s(), SoundProto.ModifiedTextReq.newBuilder().setFileId(str).setOffset(i10).setModifiedText(str2).build()).Z(cq.a.c()).H(xp.a.b()).V(new o(str2));
    }

    public void J(PayProto.SoundPay soundPay) {
        ld.e.h().l(ta.a.s(), soundPay).Z(cq.a.c()).H(xp.a.b()).V(new g());
    }

    public void K(String str) {
        ld.e.h().a(ta.a.s(), str).Z(cq.a.c()).H(xp.a.b()).V(new f());
    }

    public void L(String str, String[] strArr) {
        this.f20363a.p(ta.a.s(), str, strArr).Z(cq.a.c()).H(xp.a.b()).V(new b(strArr));
    }

    public void M(String str, String str2) {
        this.f20363a.o(ta.a.s(), SoundProto.RenameReq.newBuilder().setFileId(str).setFileName(str2).build()).Z(cq.a.c()).H(xp.a.b()).V(new j());
    }

    public void N(String str, int i10, String str2, String str3) {
        this.f20363a.q(ta.a.s(), str, i10, str3).Z(cq.a.c()).H(xp.a.b()).V(new a(str2, str3));
    }

    public void O(String str, int i10, int i11, String str2) {
        this.f20363a.r(ta.a.s(), str, i10, i11, str2).Z(cq.a.c()).H(xp.a.b()).V(new k());
    }

    public void n(SoundProto.SoundFile soundFile, boolean z10) {
        this.f20363a.b(ta.a.s(), soundFile).Z(cq.a.c()).H(xp.a.b()).V(new m(z10));
    }

    public void o(String str) {
        ld.e.h().c(ta.a.s(), str).Z(cq.a.c()).H(xp.a.b()).V(new c());
    }

    public void p(String str) {
        this.f20363a.e(ta.a.s(), str).Z(cq.a.c()).H(xp.a.b()).V(new i());
    }

    public void q() {
        this.f20363a.f(ta.a.s()).Z(cq.a.c()).H(xp.a.b()).V(new n());
    }

    public w<AccountProto.SoundAccountResp> r() {
        return this.f20376n;
    }

    public w<String> s() {
        return this.f20373k;
    }

    public w<Pair<String, String>> t() {
        return this.f20378p;
    }

    public w<String> u() {
        return this.f20371i;
    }

    public w<String> v() {
        return this.f20374l;
    }

    public w<String[]> w() {
        return this.f20375m;
    }

    public w<String> x() {
        return this.f20377o;
    }

    public void y() {
        ld.e.h().i(ta.a.s()).Z(cq.a.c()).H(xp.a.b()).V(new d());
    }

    public void z() {
        ld.e.h().j(ta.a.s()).Z(cq.a.c()).H(xp.a.b()).V(new e());
    }
}
