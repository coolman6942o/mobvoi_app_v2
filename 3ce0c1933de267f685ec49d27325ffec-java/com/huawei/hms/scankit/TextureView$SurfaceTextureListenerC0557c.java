package com.huawei.hms.scankit;

import android.app.Activity;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Process;
import android.view.TextureView;
import com.huawei.hms.scankit.util.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CaptureHelper.java */
/* renamed from: com.huawei.hms.scankit.c  reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class TextureView$SurfaceTextureListenerC0557c implements TextureView.SurfaceTextureListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ C0559e f14309a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TextureView$SurfaceTextureListenerC0557c(C0559e eVar) {
        this.f14309a = eVar;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i10, int i11) {
        boolean z10;
        Context context;
        Context context2;
        Context context3;
        TextureView textureView;
        this.f14309a.E = false;
        if (surfaceTexture == null) {
            a.b(C0559e.f14347a, "*** WARNING *** surfaceCreated() gave us a null surface!");
        }
        z10 = this.f14309a.f14363q;
        if (!z10) {
            this.f14309a.f14363q = true;
            context = this.f14309a.f14353g;
            if (context.checkPermission("android.permission.CAMERA", Process.myPid(), Process.myUid()) == 0) {
                C0559e eVar = this.f14309a;
                textureView = eVar.f14358l;
                eVar.a(textureView);
                return;
            }
            context2 = this.f14309a.f14353g;
            if ((context2 instanceof Activity) && Build.VERSION.SDK_INT >= 23) {
                this.f14309a.E = true;
                context3 = this.f14309a.f14353g;
                ((Activity) context3).requestPermissions(new String[]{"android.permission.CAMERA"}, 1);
            }
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.f14309a.f14363q = false;
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i10, int i11) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }
}
