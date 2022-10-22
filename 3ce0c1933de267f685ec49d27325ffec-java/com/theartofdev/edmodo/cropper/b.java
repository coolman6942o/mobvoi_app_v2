package com.theartofdev.edmodo.cropper;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.DisplayMetrics;
import com.theartofdev.edmodo.cropper.c;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BitmapLoadingWorkerTask.java */
/* loaded from: classes2.dex */
public final class b extends AsyncTask<Void, Void, a> {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<CropImageView> f23179a;

    /* renamed from: b  reason: collision with root package name */
    private final Uri f23180b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f23181c;

    /* renamed from: d  reason: collision with root package name */
    private final int f23182d;

    /* renamed from: e  reason: collision with root package name */
    private final int f23183e;

    public b(CropImageView cropImageView, Uri uri) {
        this.f23180b = uri;
        this.f23179a = new WeakReference<>(cropImageView);
        this.f23181c = cropImageView.getContext();
        DisplayMetrics displayMetrics = cropImageView.getResources().getDisplayMetrics();
        float f10 = displayMetrics.density;
        double d10 = f10 > 1.0f ? 1.0f / f10 : 1.0d;
        this.f23182d = (int) (displayMetrics.widthPixels * d10);
        this.f23183e = (int) (displayMetrics.heightPixels * d10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public a doInBackground(Void... voidArr) {
        try {
            if (isCancelled()) {
                return null;
            }
            c.a l10 = c.l(this.f23181c, this.f23180b, this.f23182d, this.f23183e);
            if (isCancelled()) {
                return null;
            }
            c.b A = c.A(l10.f23196a, this.f23181c, this.f23180b);
            return new a(this.f23180b, A.f23198a, l10.f23197b, A.f23199b);
        } catch (Exception e10) {
            return new a(this.f23180b, e10);
        }
    }

    public Uri b() {
        return this.f23180b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public void onPostExecute(a aVar) {
        Bitmap bitmap;
        CropImageView cropImageView;
        if (aVar != null) {
            boolean z10 = false;
            if (!isCancelled() && (cropImageView = this.f23179a.get()) != null) {
                z10 = true;
                cropImageView.n(aVar);
            }
            if (!z10 && (bitmap = aVar.f23185b) != null) {
                bitmap.recycle();
            }
        }
    }

    /* compiled from: BitmapLoadingWorkerTask.java */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Uri f23184a;

        /* renamed from: b  reason: collision with root package name */
        public final Bitmap f23185b;

        /* renamed from: c  reason: collision with root package name */
        public final int f23186c;

        /* renamed from: d  reason: collision with root package name */
        public final int f23187d;

        /* renamed from: e  reason: collision with root package name */
        public final Exception f23188e;

        a(Uri uri, Bitmap bitmap, int i10, int i11) {
            this.f23184a = uri;
            this.f23185b = bitmap;
            this.f23186c = i10;
            this.f23187d = i11;
            this.f23188e = null;
        }

        a(Uri uri, Exception exc) {
            this.f23184a = uri;
            this.f23185b = null;
            this.f23186c = 0;
            this.f23187d = 0;
            this.f23188e = exc;
        }
    }
}
