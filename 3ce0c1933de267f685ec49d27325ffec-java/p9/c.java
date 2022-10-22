package p9;

import android.content.Intent;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import r9.b;
/* compiled from: FileDownloadBroadcastHandler.java */
/* loaded from: classes2.dex */
public class c {
    public static void a(FileDownloadModel fileDownloadModel) {
        if (fileDownloadModel == null) {
            throw new IllegalArgumentException();
        } else if (fileDownloadModel.h() == -3) {
            Intent intent = new Intent("filedownloader.intent.action.completed");
            intent.putExtra("model", fileDownloadModel);
            b.a().sendBroadcast(intent);
        } else {
            throw new IllegalStateException();
        }
    }
}
