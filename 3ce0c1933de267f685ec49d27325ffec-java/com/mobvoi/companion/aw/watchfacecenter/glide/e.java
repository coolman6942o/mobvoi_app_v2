package com.mobvoi.companion.aw.watchfacecenter.glide;

import com.mobvoi.android.common.utils.k;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import x4.n;
import x4.o;
import x4.r;
/* compiled from: BluetoothWfImageLoaderFactory.kt */
/* loaded from: classes2.dex */
public final class e implements o<f, ByteBuffer> {

    /* compiled from: BluetoothWfImageLoaderFactory.kt */
    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    static {
        new a(null);
    }

    @Override // x4.o
    public n<f, ByteBuffer> b(r multiFactory) {
        i.f(multiFactory, "multiFactory");
        k.a("BluetoothWfImageLoaderFactory", "WatchFaceImageLoaderFactory build().");
        b.f16436a.b();
        return new d();
    }
}
