package com.theartofdev.edmodo.cropper;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import com.theartofdev.edmodo.cropper.CropImageView;
import com.theartofdev.edmodo.cropper.c;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BitmapCroppingWorkerTask.java */
/* loaded from: classes2.dex */
public final class a extends AsyncTask<Void, Void, C0260a> {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<CropImageView> f23156a;

    /* renamed from: b  reason: collision with root package name */
    private final Bitmap f23157b;

    /* renamed from: c  reason: collision with root package name */
    private final Uri f23158c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f23159d;

    /* renamed from: e  reason: collision with root package name */
    private final float[] f23160e;

    /* renamed from: f  reason: collision with root package name */
    private final int f23161f;

    /* renamed from: g  reason: collision with root package name */
    private final int f23162g;

    /* renamed from: h  reason: collision with root package name */
    private final int f23163h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f23164i;

    /* renamed from: j  reason: collision with root package name */
    private final int f23165j;

    /* renamed from: k  reason: collision with root package name */
    private final int f23166k;

    /* renamed from: l  reason: collision with root package name */
    private final int f23167l;

    /* renamed from: m  reason: collision with root package name */
    private final int f23168m;

    /* renamed from: n  reason: collision with root package name */
    private final boolean f23169n;

    /* renamed from: o  reason: collision with root package name */
    private final boolean f23170o;

    /* renamed from: p  reason: collision with root package name */
    private final CropImageView.RequestSizeOptions f23171p;

    /* renamed from: q  reason: collision with root package name */
    private final Uri f23172q;

    /* renamed from: r  reason: collision with root package name */
    private final Bitmap.CompressFormat f23173r;

    /* renamed from: s  reason: collision with root package name */
    private final int f23174s;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(CropImageView cropImageView, Bitmap bitmap, float[] fArr, int i10, boolean z10, int i11, int i12, int i13, int i14, boolean z11, boolean z12, CropImageView.RequestSizeOptions requestSizeOptions, Uri uri, Bitmap.CompressFormat compressFormat, int i15) {
        this.f23156a = new WeakReference<>(cropImageView);
        this.f23159d = cropImageView.getContext();
        this.f23157b = bitmap;
        this.f23160e = fArr;
        this.f23158c = null;
        this.f23161f = i10;
        this.f23164i = z10;
        this.f23165j = i11;
        this.f23166k = i12;
        this.f23167l = i13;
        this.f23168m = i14;
        this.f23169n = z11;
        this.f23170o = z12;
        this.f23171p = requestSizeOptions;
        this.f23172q = uri;
        this.f23173r = compressFormat;
        this.f23174s = i15;
        this.f23162g = 0;
        this.f23163h = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public C0260a doInBackground(Void... voidArr) {
        c.a aVar;
        boolean z10 = true;
        try {
            if (isCancelled()) {
                return null;
            }
            Uri uri = this.f23158c;
            if (uri != null) {
                aVar = c.d(this.f23159d, uri, this.f23160e, this.f23161f, this.f23162g, this.f23163h, this.f23164i, this.f23165j, this.f23166k, this.f23167l, this.f23168m, this.f23169n, this.f23170o);
            } else {
                Bitmap bitmap = this.f23157b;
                if (bitmap == null) {
                    return new C0260a((Bitmap) null, 1);
                }
                aVar = c.g(bitmap, this.f23160e, this.f23161f, this.f23164i, this.f23165j, this.f23166k, this.f23169n, this.f23170o);
            }
            Bitmap y10 = c.y(aVar.f23196a, this.f23167l, this.f23168m, this.f23171p);
            Uri uri2 = this.f23172q;
            if (uri2 == null) {
                return new C0260a(y10, aVar.f23197b);
            }
            c.C(this.f23159d, y10, uri2, this.f23173r, this.f23174s);
            if (y10 != null) {
                y10.recycle();
            }
            return new C0260a(this.f23172q, aVar.f23197b);
        } catch (Exception e10) {
            if (this.f23172q == null) {
                z10 = false;
            }
            return new C0260a(e10, z10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public void onPostExecute(C0260a aVar) {
        Bitmap bitmap;
        CropImageView cropImageView;
        if (aVar != null) {
            boolean z10 = false;
            if (!isCancelled() && (cropImageView = this.f23156a.get()) != null) {
                z10 = true;
                cropImageView.m(aVar);
            }
            if (!z10 && (bitmap = aVar.f23175a) != null) {
                bitmap.recycle();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BitmapCroppingWorkerTask.java */
    /* renamed from: com.theartofdev.edmodo.cropper.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0260a {

        /* renamed from: a  reason: collision with root package name */
        public final Bitmap f23175a;

        /* renamed from: b  reason: collision with root package name */
        public final Uri f23176b;

        /* renamed from: c  reason: collision with root package name */
        final Exception f23177c;

        /* renamed from: d  reason: collision with root package name */
        final int f23178d;

        C0260a(Bitmap bitmap, int i10) {
            this.f23175a = bitmap;
            this.f23176b = null;
            this.f23177c = null;
            this.f23178d = i10;
        }

        C0260a(Uri uri, int i10) {
            this.f23175a = null;
            this.f23176b = uri;
            this.f23177c = null;
            this.f23178d = i10;
        }

        C0260a(Exception exc, boolean z10) {
            this.f23175a = null;
            this.f23176b = null;
            this.f23177c = exc;
            this.f23178d = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(CropImageView cropImageView, Uri uri, float[] fArr, int i10, int i11, int i12, boolean z10, int i13, int i14, int i15, int i16, boolean z11, boolean z12, CropImageView.RequestSizeOptions requestSizeOptions, Uri uri2, Bitmap.CompressFormat compressFormat, int i17) {
        this.f23156a = new WeakReference<>(cropImageView);
        this.f23159d = cropImageView.getContext();
        this.f23158c = uri;
        this.f23160e = fArr;
        this.f23161f = i10;
        this.f23164i = z10;
        this.f23165j = i13;
        this.f23166k = i14;
        this.f23162g = i11;
        this.f23163h = i12;
        this.f23167l = i15;
        this.f23168m = i16;
        this.f23169n = z11;
        this.f23170o = z12;
        this.f23171p = requestSizeOptions;
        this.f23172q = uri2;
        this.f23173r = compressFormat;
        this.f23174s = i17;
        this.f23157b = null;
    }
}
