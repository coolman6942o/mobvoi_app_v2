package ld;

import com.mobvoi.companion.proto.AccountProto;
import com.mobvoi.companion.proto.FilecountProto;
import com.mobvoi.companion.proto.PayProto;
import com.mobvoi.companion.proto.ProductProto;
import com.mobvoi.companion.proto.ResponseProto;
import com.mobvoi.companion.proto.SoundProto;
import java.io.File;
import java.util.concurrent.TimeUnit;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.y;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.protobuf.ProtoConverterFactory;
import rx.c;
/* compiled from: SoundApiHelper.java */
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private d f30451a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SoundApiHelper.java */
    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private static e f30452a = new e();
    }

    private d d(y yVar, String str) {
        return (d) new Retrofit.Builder().client(yVar).baseUrl(str).addConverterFactory(ProtoConverterFactory.create()).addConverterFactory(GsonConverterFactory.create()).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).build().create(d.class);
    }

    public static e h() {
        return b.f30452a;
    }

    public c<ResponseProto.CommonResp> a(String str, String str2) {
        return this.f30451a.e(str, str2);
    }

    public c<SoundProto.SoundFileResp> b(String str, SoundProto.SoundFile soundFile) {
        return this.f30451a.d(str, soundFile);
    }

    public c<AccountProto.SoundAccountResp> c(String str, String str2) {
        return this.f30451a.i(str, str2);
    }

    public c<SoundProto.SoundFileResp> e(String str, String str2) {
        return this.f30451a.c(str, str2);
    }

    public c<AccountProto.SoundAccountResp> f(String str) {
        return this.f30451a.o(str);
    }

    public c<SoundProto.SoundConvertResultResp> g(String str, String str2) {
        return this.f30451a.k(str, str2);
    }

    public c<ProductProto.SoundProductResp> i(String str) {
        return this.f30451a.b(str);
    }

    public c<ProductProto.SoundProductResp> j(String str) {
        return this.f30451a.g(str, "en-US");
    }

    public c<ResponseProto.CommonResp> k(String str, SoundProto.ModifiedTextReq modifiedTextReq) {
        return this.f30451a.j(str, modifiedTextReq);
    }

    public c<PayProto.SoundPayResp> l(String str, PayProto.SoundPay soundPay) {
        return this.f30451a.m(str, soundPay);
    }

    public c<FilecountProto.SoundFilecountResp> m(String str) {
        return this.f30451a.h(str);
    }

    public c<SoundProto.SoundFileResp> n(String str, int i10, int i11) {
        return this.f30451a.a(str, i10, i11);
    }

    public c<SoundProto.SoundFileResp> o(String str, SoundProto.RenameReq renameReq) {
        return this.f30451a.n(str, renameReq);
    }

    public c<ResponseProto.CommonResp> p(String str, String str2, String[] strArr) {
        return this.f30451a.l(str, str2, strArr);
    }

    public c<ResponseProto.CommonResp> q(String str, String str2, int i10, String str3) {
        return this.f30451a.f(str, str2, i10, str3);
    }

    public c<SoundProto.SoundConvertResultResp> r(String str, String str2, int i10, int i11, String str3) {
        return this.f30451a.p(str, str2, i10, i11, str3);
    }

    private e() {
        this.f30451a = d(new y.a().e(20L, TimeUnit.SECONDS).d(new okhttp3.c(new File(com.mobvoi.android.common.utils.b.e().getExternalCacheDir(), "cacheFile"), 10485760L)).a(new ld.a()).b(new ld.a()).a(new HttpLoggingInterceptor().d(HttpLoggingInterceptor.Level.BODY)).a(new c()).c(), "https://mcloud.ticwear.com");
    }
}
