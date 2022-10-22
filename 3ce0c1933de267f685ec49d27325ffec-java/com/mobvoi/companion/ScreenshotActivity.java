package com.mobvoi.companion;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import com.mobvoi.android.common.utils.k;
import com.mobvoi.companion.base.m3.a;
import com.mobvoi.companion.base.perms.PermissionActivity;
import com.mobvoi.wear.common.base.WearPath;
import com.mobvoi.wear.msgproxy.MessageInfo;
import com.mobvoi.wear.msgproxy.MessageProxyClient;
import com.mobvoi.wear.msgproxy.MessageProxyConstants;
import com.mobvoi.wear.msgproxy.MessageProxyListener;
import com.mobvoi.wear.msgproxy.NodeInfo;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.n;
import kotlin.text.d;
import kotlin.text.t;
import oc.e;
import rx.c;
import rx.j;
import yp.b;
/* compiled from: ScreenshotActivity.kt */
/* loaded from: classes2.dex */
public final class ScreenshotActivity extends a implements MessageProxyListener {
    public static final Companion Companion = new Companion(null);
    private static final String[] MUST_PERMISSIONS = {"android.permission.WRITE_EXTERNAL_STORAGE"};
    private static final int PERM_REQUEST_CODE = 1;
    private static final String SCREENSHOT_FILE_NAME_TEMPLATE = "Watch_Screenshot_%s.jpeg";
    private static final String TAG = "ScreenshotActivity";
    private e binding;
    private int imgNum;
    private final BroadcastReceiver mBluetoothStatusReceiver = new BroadcastReceiver() { // from class: com.mobvoi.companion.ScreenshotActivity$mBluetoothStatusReceiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            i.f(context, "context");
            i.f(intent, "intent");
            String action = intent.getAction();
            if (i.b("android.bluetooth.adapter.action.STATE_CHANGED", action)) {
                int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", Integer.MIN_VALUE);
                int intExtra2 = intent.getIntExtra("android.bluetooth.adapter.extra.PREVIOUS_STATE", 10);
                if ((intExtra == 10 || intExtra == 13) && intExtra2 != 13 && intExtra2 != 10) {
                    ScreenshotActivity.this.bluetoothDisConnect();
                }
            } else if (i.b("android.bluetooth.device.action.ACL_DISCONNECTED", action)) {
                ScreenshotActivity.this.bluetoothDisConnect();
            }
        }
    };
    private String nodeId;
    private int receivedImgNum;
    private j timeOutSubscription;

    /* compiled from: ScreenshotActivity.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void bluetoothDisConnect() {
        changeScreenshotView(false);
        c.A("DelayFinish").l(3L, TimeUnit.SECONDS).H(xp.a.b()).X(new b() { // from class: com.mobvoi.companion.e
            @Override // yp.b
            public final void call(Object obj) {
                ScreenshotActivity.m3bluetoothDisConnect$lambda3(ScreenshotActivity.this, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bluetoothDisConnect$lambda-3  reason: not valid java name */
    public static final void m3bluetoothDisConnect$lambda3(ScreenshotActivity this$0, String str) {
        i.f(this$0, "this$0");
        this$0.finish();
    }

    private final void changeScreenshotView(boolean z10) {
        if (z10) {
            e eVar = this.binding;
            if (eVar != null) {
                eVar.f31518e.setVisibility(0);
                e eVar2 = this.binding;
                if (eVar2 != null) {
                    eVar2.f31515b.f31564b.setVisibility(8);
                } else {
                    i.u("binding");
                    throw null;
                }
            } else {
                i.u("binding");
                throw null;
            }
        } else {
            e eVar3 = this.binding;
            if (eVar3 != null) {
                eVar3.f31518e.setVisibility(8);
                e eVar4 = this.binding;
                if (eVar4 != null) {
                    eVar4.f31515b.f31564b.setVisibility(0);
                } else {
                    i.u("binding");
                    throw null;
                }
            } else {
                i.u("binding");
                throw null;
            }
        }
    }

    private final void exitWhenTimeOut() {
        this.timeOutSubscription = c.A("timeout").l(10L, TimeUnit.SECONDS).H(xp.a.b()).X(new b() { // from class: com.mobvoi.companion.f
            @Override // yp.b
            public final void call(Object obj) {
                ScreenshotActivity.m4exitWhenTimeOut$lambda0(ScreenshotActivity.this, (String) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: exitWhenTimeOut$lambda-0  reason: not valid java name */
    public static final void m4exitWhenTimeOut$lambda0(ScreenshotActivity this$0, String str) {
        i.f(this$0, "this$0");
        aa.c.c(R.string.screen_shot_fail);
        this$0.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onMessageReceived$lambda-1  reason: not valid java name */
    public static final void m5onMessageReceived$lambda1(String str) {
        MessageProxyClient.getInstance().sendMessage(WearPath.ScreenShot.PHOTO_RECEIVED);
    }

    private final void saveImageFile(Bitmap bitmap) {
        Throwable th2;
        IOException e10;
        File createTempFile;
        FileOutputStream fileOutputStream;
        n nVar = n.f30086a;
        String format = String.format(SCREENSHOT_FILE_NAME_TEMPLATE, Arrays.copyOf(new Object[]{new SimpleDateFormat("yyMMdd-HHmmss").format(new Date())}, 1));
        i.e(format, "java.lang.String.format(format, *args)");
        File h10 = com.mobvoi.android.common.utils.b.h(Environment.DIRECTORY_PICTURES);
        i.e(h10, "getFilesDir(Environment.DIRECTORY_PICTURES)");
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                createTempFile = File.createTempFile(format, ".jpg", h10);
                fileOutputStream = new FileOutputStream(createTempFile);
            } catch (Throwable th3) {
                th2 = th3;
            }
        } catch (IOException e11) {
            e10 = e11;
        }
        try {
            if (bitmap.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream)) {
                fileOutputStream.flush();
                String absolutePath = createTempFile.getAbsolutePath();
                i.e(absolutePath, "image.absolutePath");
                MediaScannerConnection.scanFile(this, new String[]{yd.f.c(this, absolutePath, format)}, null, null);
                createTempFile.delete();
            }
            com.mobvoi.android.common.utils.j.a(fileOutputStream);
        } catch (IOException e12) {
            e10 = e12;
            fileOutputStream2 = fileOutputStream;
            k.e(TAG, "Error when save bitmap, ", e10);
            aa.c.c(R.string.screen_shot_fail);
            com.mobvoi.android.common.utils.j.a(fileOutputStream2);
        } catch (Throwable th4) {
            th2 = th4;
            fileOutputStream2 = fileOutputStream;
            com.mobvoi.android.common.utils.j.a(fileOutputStream2);
            throw th2;
        }
    }

    private final void sendWatchScreenShotMsg() {
        MessageProxyClient.getInstance().sendMessage(TextUtils.isEmpty(this.nodeId) ? MessageProxyConstants.NODE_ID_ANY : this.nodeId, WearPath.ScreenShot.LOAD_PHOTO, new byte[0]);
    }

    private final void updateProgress() {
        if (this.receivedImgNum >= this.imgNum) {
            c.A("DelayFinish").l(1500L, TimeUnit.MILLISECONDS).H(xp.a.b()).X(new b() { // from class: com.mobvoi.companion.d
                @Override // yp.b
                public final void call(Object obj) {
                    ScreenshotActivity.m6updateProgress$lambda2(ScreenshotActivity.this, (String) obj);
                }
            });
        }
        int i10 = this.imgNum;
        if (i10 > 0) {
            e eVar = this.binding;
            if (eVar != null) {
                eVar.f31516c.setProgress((this.receivedImgNum * 100) / i10);
                e eVar2 = this.binding;
                if (eVar2 != null) {
                    eVar2.f31517d.setText(getString(R.string.screen_shot_progress, new Object[]{Integer.valueOf(this.receivedImgNum), Integer.valueOf(this.imgNum - this.receivedImgNum)}));
                } else {
                    i.u("binding");
                    throw null;
                }
            } else {
                i.u("binding");
                throw null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: updateProgress$lambda-2  reason: not valid java name */
    public static final void m6updateProgress$lambda2(ScreenshotActivity this$0, String str) {
        i.f(this$0, "this$0");
        this$0.finish();
        aa.c.c(R.string.screen_shot_success);
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (1 == i10 && -1 == i11) {
            e eVar = this.binding;
            if (eVar != null) {
                eVar.f31518e.setVisibility(0);
                sendWatchScreenShotMsg();
                exitWhenTimeOut();
                return;
            }
            i.u("binding");
            throw null;
        }
        finish();
    }

    @Override // com.mobvoi.wear.msgproxy.MessageProxyListener
    public void onConnectedNodesChanged(List<? extends NodeInfo> nodes) {
        i.f(nodes, "nodes");
        k.c(TAG, "onConnectedNodesChanged, %s", nodes.toString());
        if (nodes.isEmpty()) {
            aa.c.c(R.string.screen_shot_fail);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mobvoi.companion.base.m3.a, androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    @SuppressLint({"SourceLockedOrientationActivity"})
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int i10 = Build.VERSION.SDK_INT;
        if (i10 < 26) {
            k.a(TAG, "Compatible for older device");
            setRequestedOrientation(1);
        }
        supportRequestWindowFeature(1);
        e d10 = e.d(getLayoutInflater());
        i.e(d10, "inflate(layoutInflater)");
        this.binding = d10;
        if (d10 != null) {
            setContentView(d10.a());
            this.nodeId = getIntent().getStringExtra("extra_node_id");
            MessageProxyClient.getInstance().addListener(this);
            if (i10 >= 29 || hc.e.i(this, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                e eVar = this.binding;
                if (eVar != null) {
                    eVar.f31518e.setVisibility(0);
                    sendWatchScreenShotMsg();
                    exitWhenTimeOut();
                } else {
                    i.u("binding");
                    throw null;
                }
            } else {
                e eVar2 = this.binding;
                if (eVar2 != null) {
                    eVar2.f31518e.setVisibility(8);
                    String string = getString(R.string.main_permission_denied_rationale);
                    i.e(string, "getString(R.string.main_permission_denied_rationale)");
                    PermissionActivity.start(this, 1, MUST_PERMISSIONS, string, string);
                } else {
                    i.u("binding");
                    throw null;
                }
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
            intentFilter.addAction("android.bluetooth.device.action.ACL_DISCONNECTED");
            registerReceiver(this.mBluetoothStatusReceiver, intentFilter);
            return;
        }
        i.u("binding");
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        MessageProxyClient.getInstance().removeListener(this);
        j jVar = this.timeOutSubscription;
        if (jVar != null) {
            i.d(jVar);
            jVar.unsubscribe();
        }
        unregisterReceiver(this.mBluetoothStatusReceiver);
    }

    @Override // com.mobvoi.wear.msgproxy.MessageProxyListener
    public void onMessageReceived(MessageInfo message) {
        boolean D;
        i.f(message, "message");
        String path = message.getPath();
        i.e(path, "path");
        D = t.D(path, WearPath.ScreenShot.PREFIX, false, 2, null);
        if (D) {
            k.c(TAG, "onMessageReceived: %s ", message);
            if (i.b(WearPath.ScreenShot.PHOTO_NUMS, path)) {
                byte[] payload = message.getPayload();
                i.e(payload, "message.payload");
                int parseInt = Integer.parseInt(new String(payload, d.f30092a));
                this.imgNum = parseInt;
                k.c(TAG, "imgNum == %d", Integer.valueOf(parseInt));
                if (this.imgNum > 0) {
                    j jVar = this.timeOutSubscription;
                    if (jVar != null) {
                        i.d(jVar);
                        jVar.unsubscribe();
                    }
                    MessageProxyClient.getInstance().sendMessage(WearPath.ScreenShot.START_SYNC);
                } else {
                    aa.c.c(R.string.screen_shot_no_photo);
                    finish();
                    return;
                }
            } else if (i.b(WearPath.ScreenShot.PHOTO_DATA, path)) {
                this.receivedImgNum++;
                byte[] payload2 = message.getPayload();
                k.c(TAG, "Photo data received,%s", com.mobvoi.android.common.utils.f.b(payload2));
                Bitmap bitmap = BitmapFactory.decodeByteArray(payload2, 0, payload2.length);
                i.e(bitmap, "bitmap");
                saveImageFile(bitmap);
                c.A("DelaySync").l(1000L, TimeUnit.MILLISECONDS).X(g.f16679a);
            }
            updateProgress();
        }
    }
}
