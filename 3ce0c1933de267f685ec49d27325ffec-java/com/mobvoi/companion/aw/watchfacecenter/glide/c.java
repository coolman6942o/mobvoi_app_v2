package com.mobvoi.companion.aw.watchfacecenter.glide;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.mobvoi.android.common.utils.k;
import java.nio.ByteBuffer;
import kotlin.Pair;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import r4.d;
/* compiled from: BluetoothWfImageFetcher.kt */
/* loaded from: classes2.dex */
public final class c implements d<ByteBuffer> {

    /* renamed from: a  reason: collision with root package name */
    private final String f16443a;

    /* renamed from: b  reason: collision with root package name */
    private Pair<String, Long> f16444b;

    /* compiled from: BluetoothWfImageFetcher.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* compiled from: BluetoothWfImageFetcher.kt */
    /* loaded from: classes2.dex */
    public static final class b implements g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d.a<? super ByteBuffer> f16445a;

        b(d.a<? super ByteBuffer> aVar) {
            this.f16445a = aVar;
        }

        @Override // com.mobvoi.companion.aw.watchfacecenter.glide.g
        public void a(ByteBuffer byteBuffer) {
            i.f(byteBuffer, "byteBuffer");
            this.f16445a.f(byteBuffer);
        }
    }

    static {
        new a(null);
    }

    public c(String className) {
        i.f(className, "className");
        this.f16443a = className;
    }

    @Override // r4.d
    public Class<ByteBuffer> a() {
        return ByteBuffer.class;
    }

    @Override // r4.d
    public DataSource b() {
        return DataSource.REMOTE;
    }

    @Override // r4.d
    public void c() {
        k.a("BluetoothWfImageFetcher", "BluetoothWfImageFetcher" + this + " cleanup(): " + this.f16443a);
        Pair<String, Long> pair = this.f16444b;
        if (pair != null) {
            com.mobvoi.companion.aw.watchfacecenter.glide.b.f16436a.f(pair);
        }
    }

    @Override // r4.d
    public void cancel() {
        k.a("BluetoothWfImageFetcher", "BluetoothWfImageFetcher" + this + " cancel(): " + this.f16443a);
        Pair<String, Long> pair = this.f16444b;
        if (pair != null) {
            com.mobvoi.companion.aw.watchfacecenter.glide.b.f16436a.f(pair);
        }
    }

    @Override // r4.d
    public void e(Priority priority, d.a<? super ByteBuffer> callback) {
        i.f(priority, "priority");
        i.f(callback, "callback");
        k.a("BluetoothWfImageFetcher", "BluetoothWfImageFetcher" + this + " loadData(): " + this.f16443a);
        Pair<String, Long> pair = new Pair<>(this.f16443a, Long.valueOf(System.currentTimeMillis()));
        this.f16444b = pair;
        com.mobvoi.companion.aw.watchfacecenter.glide.b.f16436a.c(pair, new b(callback));
    }
}
