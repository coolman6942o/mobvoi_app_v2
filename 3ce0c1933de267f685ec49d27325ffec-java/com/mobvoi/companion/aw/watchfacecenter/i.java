package com.mobvoi.companion.aw.watchfacecenter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.c;
import com.bumptech.glide.g;
import com.mobvoi.companion.aw.watchfacecenter.bean.WatchFaceBean;
import com.mobvoi.companion.aw.watchfacecenter.glide.f;
import m5.b;
/* compiled from: Constants.kt */
/* loaded from: classes2.dex */
public final class i {
    @SuppressLint({"CheckResult"})
    public static final g<Bitmap> a(WatchFaceBean watchFaceBean, Context context) {
        kotlin.jvm.internal.i.f(watchFaceBean, "<this>");
        kotlin.jvm.internal.i.f(context, "context");
        g<Bitmap> j10 = c.u(context).j();
        if (kotlin.jvm.internal.i.b(watchFaceBean.c(), "com.mobvoi.ticwear.watchface.service.ImageWatchFace") && watchFaceBean.m() != null) {
            j10.w0(watchFaceBean.m());
        } else if (watchFaceBean.b() == 2 || watchFaceBean.b() == 1) {
            if (kotlin.jvm.internal.i.b(watchFaceBean.c(), "com.mobvoi.ticwear.watchface.service.ImageWatchFace")) {
                j10.a0(new b(Long.valueOf(l.f16454a.a())));
            }
            String c10 = watchFaceBean.c();
            if (c10 == null) {
                c10 = "";
            }
            j10.y0(new f(c10));
        } else {
            j10.z0(watchFaceBean.p());
        }
        kotlin.jvm.internal.i.e(j10, "with(context)\n        .asBitmap()\n        .also {\n            if (className == ImageWatchFace.CLASS_NAME && preview != null) {\n                it.load(preview)\n            } else if (category == WatchFaceBean.CategoryType.DOWNLOAD\n                || category == WatchFaceBean.CategoryType.FEATURED\n            ) {\n                it.also {\n                    if (className == ImageWatchFace.CLASS_NAME) {\n                        it.signature(ObjectKey(KeyContainer.timeMills))\n                    }\n                }.load(BluetoothWfImageReq(className ?: \"\"))\n            } else {\n                it.load(previewUrl)\n            }\n        }");
        return j10;
    }
}
