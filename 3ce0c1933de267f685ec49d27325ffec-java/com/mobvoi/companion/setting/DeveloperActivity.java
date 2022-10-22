package com.mobvoi.companion.setting;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.c;
import ce.e;
import ce.f;
import ce.h;
import com.mobvoi.android.common.utils.j;
import com.mobvoi.companion.base.m3.d;
import com.mobvoi.companion.wear.WearPairingPool;
import com.mobvoi.wear.info.WearInfo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import kc.b;
import vb.a;
/* loaded from: classes2.dex */
public class DeveloperActivity extends d implements a.b, View.OnClickListener {
    private static final int PICK_PATH = 1000;
    private static final String TAG = "DeveloperActivity";
    private Uri mDbUri;
    private Switch mDevelopServer;
    private c mLoadingDialog;
    private TextView mPhoneIdValue;
    private TextView mWatchIdValue;

    private void checkDevelopServerStatus() {
        this.mDevelopServer.setChecked(ta.a.y() && yd.c.c());
    }

    private void copyDbFiles(String str) {
        Log.e(TAG, "copyDbFiles() called with: name = [" + str + "]");
        try {
            q0.a b10 = q0.a.b(this, this.mDbUri);
            if (b10 != null) {
                q0.a a10 = b10.a("application/vnd.sqlite3", str);
                if (a10 == null) {
                    Toast.makeText(this, "Can not create db file", 1).show();
                    return;
                }
                ParcelFileDescriptor openFileDescriptor = getContentResolver().openFileDescriptor(a10.c(), "w");
                FileOutputStream fileOutputStream = new FileOutputStream(openFileDescriptor.getFileDescriptor());
                fileOutputStream.write(("Overwritten at " + System.currentTimeMillis() + "\n").getBytes());
                FileInputStream fileInputStream = new FileInputStream(getDatabasePath(str));
                j.b(fileInputStream, fileOutputStream);
                j.a(fileOutputStream);
                j.a(fileInputStream);
                openFileDescriptor.close();
            }
        } catch (Exception e10) {
            e10.printStackTrace();
            Toast.makeText(this, "Failed to copy DB: " + e10.toString(), 1).show();
        }
    }

    private void copyHealthDbFiles() {
        try {
            copyDbFiles("health_common.db");
            copyDbFiles("fitness.db");
            Toast.makeText(this, "Your health DBs copied . Please delete them when you have done your work.", 1).show();
        } catch (Exception e10) {
            Toast.makeText(this, "Failed to copy DB: " + e10.toString(), 1).show();
            e10.printStackTrace();
        }
    }

    private void hideLoadingDialog() {
        c cVar = this.mLoadingDialog;
        if (cVar != null && cVar.isShowing()) {
            this.mLoadingDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showAlertDialog$0(DialogInterface dialogInterface, int i10) {
        startLogout();
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$showAlertDialog$1(DialogInterface dialogInterface, int i10) {
        dialogInterface.dismiss();
        checkDevelopServerStatus();
    }

    private void setClipboard(String str) {
        ((ClipboardManager) getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, str));
    }

    private void showAlertDialog() {
        new c.a(this).q(h.f5872t).h(h.f5870s).d(false).m(h.f5848h, new DialogInterface.OnClickListener() { // from class: com.mobvoi.companion.setting.a
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                DeveloperActivity.this.lambda$showAlertDialog$0(dialogInterface, i10);
            }
        }).j(h.f5844f, new DialogInterface.OnClickListener() { // from class: com.mobvoi.companion.setting.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                DeveloperActivity.this.lambda$showAlertDialog$1(dialogInterface, i10);
            }
        }).t();
    }

    public static void start(Context context) {
        context.startActivity(new Intent(context, DeveloperActivity.class));
    }

    @Override // com.mobvoi.companion.base.m3.d
    protected int getLayoutId() {
        return f.f5807a;
    }

    protected void initView() {
        setTitle(h.f5868r);
        this.mWatchIdValue = (TextView) findViewById(e.f5790n0);
        this.mPhoneIdValue = (TextView) findViewById(e.T);
        this.mDevelopServer = (Switch) findViewById(e.f5785l);
        Switch r02 = (Switch) findViewById(e.f5783k);
        FrameLayout frameLayout = (FrameLayout) findViewById(e.f5788m0);
        FrameLayout frameLayout2 = (FrameLayout) findViewById(e.S);
        FrameLayout frameLayout3 = (FrameLayout) findViewById(e.f5800t);
        WearInfo c10 = com.mobvoi.companion.wear.a.f().c(WearPairingPool.i().h());
        this.mWatchIdValue.setText(c10 == null ? "unknown" : c10.wearDeviceId);
        this.mPhoneIdValue.setText(com.mobvoi.android.common.utils.e.e(this));
        checkDevelopServerStatus();
        r02.setOnClickListener(this);
        this.mDevelopServer.setOnClickListener(this);
        frameLayout.setOnClickListener(this);
        frameLayout2.setOnClickListener(this);
        frameLayout3.setOnClickListener(this);
    }

    @Override // androidx.fragment.app.f, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 1000 && i11 == -1 && intent != null) {
            Uri data = intent.getData();
            this.mDbUri = data;
            getContentResolver().takePersistableUriPermission(this.mDbUri, 3);
            Log.e(TAG, "onActivityResult: " + data);
            copyHealthDbFiles();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == e.f5783k) {
            com.mobvoi.companion.base.settings.a.setDevelopMode(this, false);
            finish();
        } else if (id2 == e.f5785l) {
            showAlertDialog();
        } else if (id2 == e.f5788m0) {
            setClipboard(this.mWatchIdValue.getText().toString());
            Toast.makeText(this, "Watch Id copied to clipboard", 0).show();
        } else if (id2 == e.S) {
            setClipboard(this.mPhoneIdValue.getText().toString());
            Toast.makeText(this, "Phone Id copied to clipboard", 0).show();
        } else if (id2 != e.f5800t) {
        } else {
            if (this.mDbUri == null) {
                openDirectory();
            } else {
                copyHealthDbFiles();
            }
        }
    }

    @Override // vb.a.b
    public void onLogOutIng() {
        if (this.mLoadingDialog == null) {
            this.mLoadingDialog = com.mobvoi.companion.base.m3.f.f16573a.a(this, h.O);
        }
        if (!this.mLoadingDialog.isShowing()) {
            this.mLoadingDialog.show();
        }
    }

    @Override // vb.a.b
    public void onLogoutFailure() {
        hideLoadingDialog();
        checkDevelopServerStatus();
        Toast.makeText(getApplicationContext(), h.N, 0).show();
    }

    @Override // vb.a.b
    public void onLogoutSuccess() {
        ((db.e) b.b().a(db.e.class)).k();
        yd.c.d(!yd.c.c());
        ta.a.J(!ta.a.y());
        hideLoadingDialog();
        Toast.makeText(getApplicationContext(), h.P, 0).show();
        b1.a.b(getApplicationContext()).d(new Intent("action.LOGOUT"));
        yd.c.a();
        Intent intent = new Intent("mobvoi.main");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setFlags(268468224);
        startActivity(intent);
        finish();
    }

    @SuppressLint({"SdCardPath", "InlinedApi"})
    public void openDirectory() {
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory("mobvoi");
        if (externalStoragePublicDirectory == null) {
            externalStoragePublicDirectory = new File("/sdcard/mobvoi");
        }
        Uri fromFile = Uri.fromFile(externalStoragePublicDirectory);
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
        intent.putExtra("android.provider.extra.INITIAL_URI", fromFile);
        startActivityForResult(intent, 1000);
        Toast.makeText(this, "Please select mobvoi dir or create new dir to save db files", 1).show();
    }

    public void startLogout() {
        ((db.e) b.b().a(db.e.class)).c(this);
        a.a(this);
    }
}
