package fg;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.Toast;
import com.mobvoi.android.common.utils.j;
import ic.b;
import ic.d;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
/* compiled from: HealthSnapshotShareTask.java */
/* loaded from: classes2.dex */
public class k extends AsyncTask<Bitmap, Void, Boolean> {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: a  reason: collision with root package name */
    private Context f26438a;

    public k(Context context) {
        this.f26438a = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public Boolean doInBackground(Bitmap... bitmapArr) {
        Throwable th2;
        FileNotFoundException e10;
        FileOutputStream fileOutputStream;
        Bitmap bitmap = bitmapArr[0];
        File a10 = d.a(this.f26438a);
        try {
            if (a10.exists() || a10.createNewFile()) {
                FileOutputStream fileOutputStream2 = null;
                try {
                    try {
                        fileOutputStream = new FileOutputStream(a10);
                    } catch (Throwable th3) {
                        th2 = th3;
                    }
                } catch (FileNotFoundException e11) {
                    e10 = e11;
                }
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                    j.a(fileOutputStream);
                    return Boolean.TRUE;
                } catch (FileNotFoundException e12) {
                    e10 = e12;
                    fileOutputStream2 = fileOutputStream;
                    com.mobvoi.android.common.utils.k.e("health.companion.share", "save and share Health Snapshot:", e10);
                    Boolean bool = Boolean.FALSE;
                    j.a(fileOutputStream2);
                    return bool;
                } catch (Throwable th4) {
                    th2 = th4;
                    fileOutputStream2 = fileOutputStream;
                    j.a(fileOutputStream2);
                    throw th2;
                }
            } else {
                com.mobvoi.android.common.utils.k.d("health.companion.share", "File for QQ sharing does not existed & created failed.");
                return Boolean.FALSE;
            }
        } catch (IOException e13) {
            com.mobvoi.android.common.utils.k.e("health.companion.share", "Create image file for QQ sharing failed: ", e13);
            return Boolean.FALSE;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public void onPostExecute(Boolean bool) {
        if (bool.booleanValue()) {
            b.c(this.f26438a);
        } else {
            Toast.makeText(this.f26438a, u.f26954q3, 0).show();
        }
    }
}
