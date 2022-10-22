package com.mobvoi.companion.view.crop;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.DisplayMetrics;
import com.mobvoi.companion.view.crop.c;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BitmapLoadingWorkerTask.java */
/* loaded from: classes2.dex */
public final class b extends AsyncTask<Void, Void, a> {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<CropImageView> f17766a;

    /* renamed from: b  reason: collision with root package name */
    private final Uri f17767b;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: c  reason: collision with root package name */
    private final Context f17768c;

    /* renamed from: d  reason: collision with root package name */
    private final int f17769d;

    /* renamed from: e  reason: collision with root package name */
    private final int f17770e;

    public b(CropImageView cropImageView, Uri uri) {
        this.f17767b = uri;
        this.f17766a = new WeakReference<>(cropImageView);
        this.f17768c = cropImageView.getContext().getApplicationContext();
        DisplayMetrics displayMetrics = cropImageView.getResources().getDisplayMetrics();
        float f10 = displayMetrics.density;
        double d10 = f10 > 1.0f ? 1.0f / f10 : 1.0d;
        this.f17769d = (int) (displayMetrics.widthPixels * d10);
        this.f17770e = (int) (displayMetrics.heightPixels * d10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public a doInBackground(Void... voidArr) {
        try {
            if (isCancelled()) {
                return null;
            }
            c.a l10 = c.l(this.f17768c, this.f17767b, this.f17769d, this.f17770e);
            if (isCancelled()) {
                return null;
            }
            c.b A = c.A(l10.f17783a, this.f17768c, this.f17767b);
            return new a(this.f17767b, A.f17785a, l10.f17784b, A.f17786b);
        } catch (Exception e10) {
            return new a(this.f17767b, e10);
        }
    }

    public Uri b() {
        return this.f17767b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: c */
    public void onPostExecute(a aVar) {
        Bitmap bitmap;
        CropImageView cropImageView;
        if (aVar != null) {
            boolean z10 = false;
            if (!isCancelled() && (cropImageView = this.f17766a.get()) != null) {
                z10 = true;
                cropImageView.k(aVar);
            }
            if (!z10 && (bitmap = aVar.f17772b) != null) {
                bitmap.recycle();
            }
        }
    }

    /* compiled from: BitmapLoadingWorkerTask.java */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Uri f17771a;

        /* renamed from: b  reason: collision with root package name */
        public final Bitmap f17772b;

        /* renamed from: c  reason: collision with root package name */
        public final int f17773c;

        /* renamed from: d  reason: collision with root package name */
        public final int f17774d;

        /* renamed from: e  reason: collision with root package name */
        public final Exception f17775e;

        a(Uri uri, Bitmap bitmap, int i10, int i11) {
            this.f17771a = uri;
            this.f17772b = bitmap;
            this.f17773c = i10;
            this.f17774d = i11;
            this.f17775e = null;
        }

        a(Uri uri, Exception exc) {
            this.f17771a = uri;
            this.f17772b = null;
            this.f17773c = 0;
            this.f17774d = 0;
            this.f17775e = exc;
        }
    }
}
