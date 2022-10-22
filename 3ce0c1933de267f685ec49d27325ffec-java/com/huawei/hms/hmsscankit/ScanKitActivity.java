package com.huawei.hms.hmsscankit;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.OrientationEventListener;
import android.view.ViewGroup;
import android.view.Window;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanBase;
import com.huawei.hms.scankit.R;
import com.huawei.hms.scankit.util.a;
/* loaded from: classes2.dex */
public class ScanKitActivity extends Activity {
    private static final String TAG = "ScanKitActivity";
    private int lastRotation = Integer.MAX_VALUE;
    private OrientationEventListener mOrientationListener;
    private RemoteView remoteView;

    private void startOrientationChangeListener() {
        OrientationEventListener orientationEventListener = new OrientationEventListener(this) { // from class: com.huawei.hms.hmsscankit.ScanKitActivity.2
            @Override // android.view.OrientationEventListener
            public void onOrientationChanged(int i10) {
                try {
                    int rotation = ScanKitActivity.this.getWindowManager().getDefaultDisplay().getRotation();
                    if (Math.abs(ScanKitActivity.this.lastRotation - rotation) == 2) {
                        ScanKitActivity.this.recreate();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("onOrientationChanged: currentRotation");
                        sb2.append(rotation);
                        Log.i(ScanKitActivity.TAG, sb2.toString());
                    }
                    ScanKitActivity.this.lastRotation = rotation;
                } catch (RuntimeException unused) {
                    Log.e(ScanKitActivity.TAG, "onOrientationChanged: RuntimeException");
                }
            }
        };
        this.mOrientationListener = orientationEventListener;
        orientationEventListener.enable();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        this.remoteView.onActivityResult(i10, i11, intent);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006c  */
    @Override // android.app.Activity
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onCreate(Bundle bundle) {
        int i10;
        int i11;
        Window window;
        super.onCreate(bundle);
        requestWindowFeature(1);
        setContentView(R.layout.scankit_layout);
        boolean z10 = false;
        try {
        } catch (NullPointerException unused) {
            a.c(TAG, "getIntExtra can not get");
        }
        if (getIntent() != null) {
            i10 = getIntent().getIntExtra(HmsScanBase.SCAN_FORMAT_FLAG, 0);
            RemoteView remoteView = new RemoteView(this, false, i10, null);
            this.remoteView = remoteView;
            remoteView.setOnResultCallback(new OnResultCallback() { // from class: com.huawei.hms.hmsscankit.ScanKitActivity.1
                @Override // com.huawei.hms.hmsscankit.OnResultCallback
                public void onResult(HmsScan[] hmsScanArr) {
                    if (hmsScanArr != null && hmsScanArr.length > 0 && hmsScanArr[0] != null && !TextUtils.isEmpty(hmsScanArr[0].originalValue)) {
                        Log.i(ScanKitActivity.TAG, "onResult: obtain scanResult");
                        Intent intent = new Intent();
                        intent.putExtra(ScanUtil.RESULT, hmsScanArr[0]);
                        ScanKitActivity.this.setResult(-1, intent);
                        ScanKitActivity.this.finish();
                    }
                }
            });
            this.remoteView.onCreate(bundle);
            ((ViewGroup) findViewById(R.id.ll_top)).addView(this.remoteView);
            i11 = Build.VERSION.SDK_INT;
            if (i11 >= 24) {
                z10 = isInMultiWindowMode();
            }
            if (i11 >= 19 && (window = getWindow()) != null) {
                window.addFlags(201326592);
                if (z10) {
                    window.clearFlags(134217728);
                }
            }
            if (i11 >= 28) {
                startOrientationChangeListener();
            }
            Log.i(TAG, "ScankitActivity on create");
        }
        i10 = 0;
        RemoteView remoteView2 = new RemoteView(this, false, i10, null);
        this.remoteView = remoteView2;
        remoteView2.setOnResultCallback(new OnResultCallback() { // from class: com.huawei.hms.hmsscankit.ScanKitActivity.1
            @Override // com.huawei.hms.hmsscankit.OnResultCallback
            public void onResult(HmsScan[] hmsScanArr) {
                if (hmsScanArr != null && hmsScanArr.length > 0 && hmsScanArr[0] != null && !TextUtils.isEmpty(hmsScanArr[0].originalValue)) {
                    Log.i(ScanKitActivity.TAG, "onResult: obtain scanResult");
                    Intent intent = new Intent();
                    intent.putExtra(ScanUtil.RESULT, hmsScanArr[0]);
                    ScanKitActivity.this.setResult(-1, intent);
                    ScanKitActivity.this.finish();
                }
            }
        });
        this.remoteView.onCreate(bundle);
        ((ViewGroup) findViewById(R.id.ll_top)).addView(this.remoteView);
        i11 = Build.VERSION.SDK_INT;
        if (i11 >= 24) {
        }
        if (i11 >= 19) {
            window.addFlags(201326592);
            if (z10) {
            }
        }
        if (i11 >= 28) {
        }
        Log.i(TAG, "ScankitActivity on create");
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.remoteView.onDestroy();
        Log.i(TAG, "ScankitActivity onDestroy");
        OrientationEventListener orientationEventListener = this.mOrientationListener;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.remoteView.onPause();
        Log.i(TAG, "ScankitActivity onPause");
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        this.remoteView.onRequestPermissionsResult(i10, strArr, iArr, this);
        super.onRequestPermissionsResult(i10, strArr, iArr);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.remoteView.onResume();
        Log.i(TAG, "ScankitActivity onResume");
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        this.remoteView.onStart();
        Log.i(TAG, "ScankitActivity onStart");
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        this.remoteView.onStop();
        Log.i(TAG, "ScankitActivity onStop");
    }
}
