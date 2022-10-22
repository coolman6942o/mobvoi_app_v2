package com.google.android.gms.common.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepName;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import q6.d;
/* loaded from: classes.dex */
public final class ImageManager {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f8843a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static HashSet<Uri> f8844b = new HashSet<>();

    @KeepName
    /* loaded from: classes.dex */
    private final class ImageReceiver extends ResultReceiver {

        /* renamed from: a  reason: collision with root package name */
        private final Uri f8845a;

        /* renamed from: b  reason: collision with root package name */
        private final ArrayList<com.google.android.gms.common.images.a> f8846b;

        /* renamed from: c  reason: collision with root package name */
        private final /* synthetic */ ImageManager f8847c;

        @Override // android.os.ResultReceiver
        public final void onReceiveResult(int i10, Bundle bundle) {
            ImageManager.h(this.f8847c).execute(new b(this.f8847c, this.f8845a, (ParcelFileDescriptor) bundle.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }
    }

    /* loaded from: classes.dex */
    private static final class a extends q.a<Object, Bitmap> {
    }

    /* loaded from: classes.dex */
    private final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final Uri f8848a;

        /* renamed from: b  reason: collision with root package name */
        private final ParcelFileDescriptor f8849b;

        /* renamed from: c  reason: collision with root package name */
        private final /* synthetic */ ImageManager f8850c;

        public b(ImageManager imageManager, Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
            this.f8848a = uri;
            this.f8849b = parcelFileDescriptor;
        }

        @Override // java.lang.Runnable
        public final void run() {
            b6.b.b("LoadBitmapFromDiskRunnable can't be executed in the main thread");
            ParcelFileDescriptor parcelFileDescriptor = this.f8849b;
            boolean z10 = false;
            Bitmap bitmap = null;
            if (parcelFileDescriptor != null) {
                try {
                    bitmap = BitmapFactory.decodeFileDescriptor(parcelFileDescriptor.getFileDescriptor());
                } catch (OutOfMemoryError e10) {
                    String valueOf = String.valueOf(this.f8848a);
                    StringBuilder sb2 = new StringBuilder(valueOf.length() + 34);
                    sb2.append("OOM while loading bitmap for uri: ");
                    sb2.append(valueOf);
                    Log.e("ImageManager", sb2.toString(), e10);
                    z10 = true;
                }
                try {
                    this.f8849b.close();
                } catch (IOException e11) {
                    Log.e("ImageManager", "closed failed", e11);
                }
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            ImageManager.i(this.f8850c).post(new c(this.f8850c, this.f8848a, bitmap, z10, countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException unused) {
                String valueOf2 = String.valueOf(this.f8848a);
                StringBuilder sb3 = new StringBuilder(valueOf2.length() + 32);
                sb3.append("Latch interrupted while posting ");
                sb3.append(valueOf2);
                Log.w("ImageManager", sb3.toString());
            }
        }
    }

    /* loaded from: classes.dex */
    private final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final Uri f8851a;

        /* renamed from: b  reason: collision with root package name */
        private final Bitmap f8852b;

        /* renamed from: c  reason: collision with root package name */
        private final CountDownLatch f8853c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f8854d;

        /* renamed from: e  reason: collision with root package name */
        private final /* synthetic */ ImageManager f8855e;

        public c(ImageManager imageManager, Uri uri, Bitmap bitmap, boolean z10, CountDownLatch countDownLatch) {
            this.f8851a = uri;
            this.f8852b = bitmap;
            this.f8854d = z10;
            this.f8853c = countDownLatch;
        }

        @Override // java.lang.Runnable
        public final void run() {
            b6.b.a("OnBitmapLoadedRunnable must be executed in the main thread");
            boolean z10 = this.f8852b != null;
            ImageManager.j(this.f8855e);
            ImageReceiver imageReceiver = (ImageReceiver) ImageManager.g(this.f8855e).remove(this.f8851a);
            if (imageReceiver != null) {
                ArrayList arrayList = imageReceiver.f8846b;
                int size = arrayList.size();
                for (int i10 = 0; i10 < size; i10++) {
                    com.google.android.gms.common.images.a aVar = (com.google.android.gms.common.images.a) arrayList.get(i10);
                    if (z10) {
                        aVar.a(ImageManager.b(this.f8855e), this.f8852b, false);
                    } else {
                        ImageManager.f(this.f8855e).put(this.f8851a, Long.valueOf(SystemClock.elapsedRealtime()));
                        aVar.b(ImageManager.b(this.f8855e), ImageManager.c(this.f8855e), false);
                    }
                    ImageManager.a(this.f8855e).remove(aVar);
                }
            }
            this.f8853c.countDown();
            synchronized (ImageManager.f8843a) {
                ImageManager.f8844b.remove(this.f8851a);
            }
        }
    }

    static /* synthetic */ Map a(ImageManager imageManager) {
        throw null;
    }

    static /* synthetic */ Context b(ImageManager imageManager) {
        throw null;
    }

    static /* synthetic */ d c(ImageManager imageManager) {
        throw null;
    }

    static /* synthetic */ Map f(ImageManager imageManager) {
        throw null;
    }

    static /* synthetic */ Map g(ImageManager imageManager) {
        throw null;
    }

    static /* synthetic */ ExecutorService h(ImageManager imageManager) {
        throw null;
    }

    static /* synthetic */ Handler i(ImageManager imageManager) {
        throw null;
    }

    static /* synthetic */ a j(ImageManager imageManager) {
        throw null;
    }
}
