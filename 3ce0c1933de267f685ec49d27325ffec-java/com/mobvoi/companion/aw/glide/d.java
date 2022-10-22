package com.mobvoi.companion.aw.glide;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.MediaMetadataRetriever;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.mobvoi.android.common.utils.k;
import java.util.HashMap;
import q4.e;
import r4.d;
import x4.g;
import x4.n;
import x4.o;
import x4.r;
/* compiled from: ThumbUtils.java */
/* loaded from: classes2.dex */
public class d {

    /* compiled from: ThumbUtils.java */
    /* loaded from: classes2.dex */
    public static class b implements o<g, Bitmap> {
        @Override // x4.o
        public n<g, Bitmap> b(r rVar) {
            return new c();
        }
    }

    /* compiled from: ThumbUtils.java */
    /* loaded from: classes2.dex */
    private static class c implements n<g, Bitmap> {
        private c() {
        }

        /* renamed from: c */
        public n.a<Bitmap> b(g gVar, int i10, int i11, e eVar) {
            return new n.a<>(gVar, new C0198d(gVar.c(), i10, i11));
        }

        /* renamed from: d */
        public boolean a(g gVar) {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ThumbUtils.java */
    /* renamed from: com.mobvoi.companion.aw.glide.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0198d implements r4.d<Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        String f16265a;

        /* renamed from: b  reason: collision with root package name */
        int f16266b;

        /* renamed from: c  reason: collision with root package name */
        int f16267c;

        C0198d(String str, int i10, int i11) {
            this.f16265a = str;
            this.f16266b = i10;
            this.f16267c = i11;
        }

        @Override // r4.d
        public Class<Bitmap> a() {
            return Bitmap.class;
        }

        @Override // r4.d
        public DataSource b() {
            return DataSource.LOCAL;
        }

        @Override // r4.d
        public void c() {
        }

        @Override // r4.d
        public void cancel() {
        }

        @Override // r4.d
        public void e(Priority priority, d.a<? super Bitmap> aVar) {
            aVar.f(d.b(this.f16265a, 5L, this.f16266b, this.f16267c));
        }
    }

    public static Bitmap a(String str, long j10) {
        StringBuilder sb2;
        Bitmap bitmap = null;
        if (str == null) {
            return null;
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                if (str.startsWith("http")) {
                    mediaMetadataRetriever.setDataSource(str, new HashMap());
                } else {
                    mediaMetadataRetriever.setDataSource(str);
                }
                bitmap = mediaMetadataRetriever.getFrameAtTime(j10);
            } catch (Exception e10) {
                k.d("ThumbUtils", "getVideoThumbnail filePath=" + str + " e" + e10);
                try {
                    mediaMetadataRetriever.release();
                } catch (Exception e11) {
                    e = e11;
                    sb2 = new StringBuilder();
                    sb2.append("getVideoThumbnail e=");
                    sb2.append(e);
                    k.d("ThumbUtils", sb2.toString());
                    return bitmap;
                }
            }
            try {
                mediaMetadataRetriever.release();
            } catch (Exception e12) {
                e = e12;
                sb2 = new StringBuilder();
                sb2.append("getVideoThumbnail e=");
                sb2.append(e);
                k.d("ThumbUtils", sb2.toString());
                return bitmap;
            }
            return bitmap;
        } catch (Throwable th2) {
            try {
                mediaMetadataRetriever.release();
            } catch (Exception e13) {
                k.d("ThumbUtils", "getVideoThumbnail e=" + e13);
            }
            throw th2;
        }
    }

    public static Bitmap b(String str, long j10, int i10, int i11) {
        Bitmap a10 = a(str, j10);
        if (a10 == null) {
            return null;
        }
        int width = a10.getWidth();
        int height = a10.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(i10 / width, i11 / height);
        return Bitmap.createBitmap(a10, 0, 0, width, height, matrix, true);
    }
}
