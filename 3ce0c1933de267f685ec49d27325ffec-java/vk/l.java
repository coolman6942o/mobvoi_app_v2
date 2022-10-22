package vk;

import android.os.AsyncTask;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class l extends AsyncTask<k, Void, h> {
    private l(i iVar) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public h doInBackground(k... kVarArr) {
        return i.c(kVarArr[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public void onPostExecute(h hVar) {
        if (hVar != null) {
            c.b("status code: " + hVar.f35813a);
            c.b(hVar.f35814b);
            e eVar = hVar.f35816d;
            if (eVar != null) {
                eVar.a(hVar);
                return;
            }
            return;
        }
        c.c("response is null");
    }
}
