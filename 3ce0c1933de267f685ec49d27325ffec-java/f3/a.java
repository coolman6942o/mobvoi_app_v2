package f3;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import g3.h;
import java.util.HashMap;
import java.util.Map;
import k3.d;
/* compiled from: FontAssetManager.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    private final AssetManager f26344d;

    /* renamed from: a  reason: collision with root package name */
    private final h<String> f26341a = new h<>();

    /* renamed from: b  reason: collision with root package name */
    private final Map<h<String>, Typeface> f26342b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, Typeface> f26343c = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private String f26345e = ".ttf";

    public a(Drawable.Callback callback, com.airbnb.lottie.a aVar) {
        if (!(callback instanceof View)) {
            d.c("LottieDrawable must be inside of a view for images to work.");
            this.f26344d = null;
            return;
        }
        this.f26344d = ((View) callback).getContext().getAssets();
    }

    private Typeface a(String str) {
        Typeface typeface = this.f26343c.get(str);
        if (typeface != null) {
            return typeface;
        }
        Typeface createFromAsset = Typeface.createFromAsset(this.f26344d, "fonts/" + str + this.f26345e);
        this.f26343c.put(str, createFromAsset);
        return createFromAsset;
    }

    private Typeface d(Typeface typeface, String str) {
        boolean contains = str.contains("Italic");
        boolean contains2 = str.contains("Bold");
        int i10 = (!contains || !contains2) ? contains ? 2 : contains2 ? 1 : 0 : 3;
        return typeface.getStyle() == i10 ? typeface : Typeface.create(typeface, i10);
    }

    public Typeface b(String str, String str2) {
        this.f26341a.b(str, str2);
        Typeface typeface = this.f26342b.get(this.f26341a);
        if (typeface != null) {
            return typeface;
        }
        Typeface d10 = d(a(str), str2);
        this.f26342b.put(this.f26341a, d10);
        return d10;
    }

    public void c(com.airbnb.lottie.a aVar) {
    }
}
