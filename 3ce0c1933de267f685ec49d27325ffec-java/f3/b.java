package f3;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import com.airbnb.lottie.g;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import k3.d;
import k3.h;
/* compiled from: ImageAssetManager.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: e  reason: collision with root package name */
    private static final Object f26346e = new Object();

    /* renamed from: a  reason: collision with root package name */
    private final Context f26347a;

    /* renamed from: b  reason: collision with root package name */
    private String f26348b;

    /* renamed from: c  reason: collision with root package name */
    private com.airbnb.lottie.b f26349c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<String, g> f26350d;

    public b(Drawable.Callback callback, String str, com.airbnb.lottie.b bVar, Map<String, g> map) {
        String str2;
        this.f26348b = str;
        if (!TextUtils.isEmpty(str)) {
            if (this.f26348b.charAt(str2.length() - 1) != '/') {
                this.f26348b += '/';
            }
        }
        if (!(callback instanceof View)) {
            d.c("LottieDrawable must be inside of a view for images to work.");
            this.f26350d = new HashMap();
            this.f26347a = null;
            return;
        }
        this.f26347a = ((View) callback).getContext();
        this.f26350d = map;
        d(bVar);
    }

    private Bitmap c(String str, Bitmap bitmap) {
        synchronized (f26346e) {
            this.f26350d.get(str).f(bitmap);
        }
        return bitmap;
    }

    public Bitmap a(String str) {
        g gVar = this.f26350d.get(str);
        if (gVar == null) {
            return null;
        }
        Bitmap a10 = gVar.a();
        if (a10 != null) {
            return a10;
        }
        com.airbnb.lottie.b bVar = this.f26349c;
        if (bVar != null) {
            Bitmap a11 = bVar.a(gVar);
            if (a11 != null) {
                c(str, a11);
            }
            return a11;
        }
        String b10 = gVar.b();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (!b10.startsWith("data:") || b10.indexOf("base64,") <= 0) {
            try {
                if (!TextUtils.isEmpty(this.f26348b)) {
                    AssetManager assets = this.f26347a.getAssets();
                    return c(str, h.l(BitmapFactory.decodeStream(assets.open(this.f26348b + b10), null, options), gVar.e(), gVar.c()));
                }
                throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
            } catch (IOException e10) {
                d.d("Unable to open asset.", e10);
                return null;
            }
        } else {
            try {
                byte[] decode = Base64.decode(b10.substring(b10.indexOf(44) + 1), 0);
                return c(str, BitmapFactory.decodeByteArray(decode, 0, decode.length, options));
            } catch (IllegalArgumentException e11) {
                d.d("data URL did not have correct base64 format.", e11);
                return null;
            }
        }
    }

    public boolean b(Context context) {
        return (context == null && this.f26347a == null) || this.f26347a.equals(context);
    }

    public void d(com.airbnb.lottie.b bVar) {
        this.f26349c = bVar;
    }
}
