package com.mobvoi.companion.view.crop;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import com.mobvoi.companion.view.crop.CropImageView;
import com.mobvoi.companion.view.crop.c;
import java.lang.ref.WeakReference;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BitmapCroppingWorkerTask.java */
/* loaded from: classes2.dex */
public final class a extends AsyncTask<Void, Void, C0211a> {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference<CropImageView> f17743a;

    /* renamed from: b  reason: collision with root package name */
    private final Bitmap f17744b;

    /* renamed from: c  reason: collision with root package name */
    private final Uri f17745c;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: d  reason: collision with root package name */
    private final Context f17746d;

    /* renamed from: e  reason: collision with root package name */
    private final float[] f17747e;

    /* renamed from: f  reason: collision with root package name */
    private final int f17748f;

    /* renamed from: g  reason: collision with root package name */
    private final int f17749g;

    /* renamed from: h  reason: collision with root package name */
    private final int f17750h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f17751i;

    /* renamed from: j  reason: collision with root package name */
    private final int f17752j;

    /* renamed from: k  reason: collision with root package name */
    private final int f17753k;

    /* renamed from: l  reason: collision with root package name */
    private final int f17754l;

    /* renamed from: m  reason: collision with root package name */
    private final int f17755m;

    /* renamed from: n  reason: collision with root package name */
    private final boolean f17756n;

    /* renamed from: o  reason: collision with root package name */
    private final boolean f17757o;

    /* renamed from: p  reason: collision with root package name */
    private final CropImageView.RequestSizeOptions f17758p;

    /* renamed from: q  reason: collision with root package name */
    private final Uri f17759q;

    /* renamed from: r  reason: collision with root package name */
    private final Bitmap.CompressFormat f17760r;

    /* renamed from: s  reason: collision with root package name */
    private final int f17761s;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(CropImageView cropImageView, Bitmap bitmap, float[] fArr, int i10, boolean z10, int i11, int i12, int i13, int i14, boolean z11, boolean z12, CropImageView.RequestSizeOptions requestSizeOptions, Uri uri, Bitmap.CompressFormat compressFormat, int i15) {
        this.f17743a = new WeakReference<>(cropImageView);
        this.f17746d = cropImageView.getContext().getApplicationContext();
        this.f17744b = bitmap;
        this.f17747e = fArr;
        this.f17745c = null;
        this.f17748f = i10;
        this.f17751i = z10;
        this.f17752j = i11;
        this.f17753k = i12;
        this.f17754l = i13;
        this.f17755m = i14;
        this.f17756n = z11;
        this.f17757o = z12;
        this.f17758p = requestSizeOptions;
        this.f17759q = uri;
        this.f17760r = compressFormat;
        this.f17761s = i15;
        this.f17749g = 0;
        this.f17750h = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public C0211a doInBackground(Void... voidArr) {
        c.a aVar;
        boolean z10 = true;
        try {
            if (isCancelled()) {
                return null;
            }
            Uri uri = this.f17745c;
            if (uri != null) {
                aVar = c.d(this.f17746d, uri, this.f17747e, this.f17748f, this.f17749g, this.f17750h, this.f17751i, this.f17752j, this.f17753k, this.f17754l, this.f17755m, this.f17756n, this.f17757o);
            } else {
                Bitmap bitmap = this.f17744b;
                if (bitmap == null) {
                    return new C0211a((Bitmap) null, 1);
                }
                aVar = c.g(bitmap, this.f17747e, this.f17748f, this.f17751i, this.f17752j, this.f17753k, this.f17756n, this.f17757o);
            }
            Bitmap y10 = c.y(aVar.f17783a, this.f17754l, this.f17755m, this.f17758p);
            Uri uri2 = this.f17759q;
            if (uri2 == null) {
                return new C0211a(y10, aVar.f17784b);
            }
            c.C(this.f17746d, y10, uri2, this.f17760r, this.f17761s);
            if (y10 != null) {
                y10.recycle();
            }
            return new C0211a(this.f17759q, aVar.f17784b);
        } catch (Exception e10) {
            if (this.f17759q == null) {
                z10 = false;
            }
            return new C0211a(e10, z10);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public void onPostExecute(C0211a aVar) {
        Bitmap bitmap;
        CropImageView cropImageView;
        if (aVar != null) {
            boolean z10 = false;
            if (!isCancelled() && (cropImageView = this.f17743a.get()) != null) {
                z10 = true;
                cropImageView.j(aVar);
            }
            if (!z10 && (bitmap = aVar.f17762a) != null) {
                bitmap.recycle();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: BitmapCroppingWorkerTask.java */
    /* renamed from: com.mobvoi.companion.view.crop.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0211a {

        /* renamed from: a  reason: collision with root package name */
        public final Bitmap f17762a;

        /* renamed from: b  reason: collision with root package name */
        public final Uri f17763b;

        /* renamed from: c  reason: collision with root package name */
        final Exception f17764c;

        /* renamed from: d  reason: collision with root package name */
        final int f17765d;

        C0211a(Bitmap bitmap, int i10) {
            this.f17762a = bitmap;
            this.f17763b = null;
            this.f17764c = null;
            this.f17765d = i10;
        }

        C0211a(Uri uri, int i10) {
            this.f17762a = null;
            this.f17763b = uri;
            this.f17764c = null;
            this.f17765d = i10;
        }

        C0211a(Exception exc, boolean z10) {
            this.f17762a = null;
            this.f17763b = null;
            this.f17764c = exc;
            this.f17765d = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(CropImageView cropImageView, Uri uri, float[] fArr, int i10, int i11, int i12, boolean z10, int i13, int i14, int i15, int i16, boolean z11, boolean z12, CropImageView.RequestSizeOptions requestSizeOptions, Uri uri2, Bitmap.CompressFormat compressFormat, int i17) {
        this.f17743a = new WeakReference<>(cropImageView);
        this.f17746d = cropImageView.getContext().getApplicationContext();
        this.f17745c = uri;
        this.f17747e = fArr;
        this.f17748f = i10;
        this.f17751i = z10;
        this.f17752j = i13;
        this.f17753k = i14;
        this.f17749g = i11;
        this.f17750h = i12;
        this.f17754l = i15;
        this.f17755m = i16;
        this.f17756n = z11;
        this.f17757o = z12;
        this.f17758p = requestSizeOptions;
        this.f17759q = uri2;
        this.f17760r = compressFormat;
        this.f17761s = i17;
        this.f17744b = null;
    }
}
