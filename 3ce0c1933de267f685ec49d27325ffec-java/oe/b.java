package oe;

import android.app.Application;
import android.os.Bundle;
import android.text.TextUtils;
import com.mobvoi.android.common.json.JsonBean;
import com.mobvoi.companion.common.analytics.Module;
import com.mobvoi.wear.common.base.WearPath;
/* compiled from: FeedbackParam.java */
/* loaded from: classes2.dex */
public class b implements JsonBean {
    private a callback;
    private oe.a feedbackLog;
    private String logPath;
    private String logPrefix;
    private String pkg;
    private String source;

    /* compiled from: FeedbackParam.java */
    /* loaded from: classes2.dex */
    public interface a {
        void a(Bundle bundle);

        void b(Bundle bundle);
    }

    public b(String str, String str2, String str3, String str4, a aVar) {
        str2 = TextUtils.isEmpty(str2) ? b(str) : str2;
        str3 = TextUtils.isEmpty(str3) ? str : str3;
        this.pkg = str;
        this.source = str4;
        this.logPath = str2;
        this.callback = aVar;
        this.logPrefix = str3;
        e();
    }

    private String b(String str) {
        Application e10 = com.mobvoi.android.common.utils.b.e();
        return e10.getExternalFilesDir(str + WearPath.Log.LOG).getAbsolutePath();
    }

    private void e() {
        c cVar = new c();
        cVar.b(this.logPath);
        cVar.c(this.logPrefix);
        oe.a aVar = new oe.a();
        this.feedbackLog = aVar;
        aVar.a(this.source, cVar);
    }

    private String f(String str) {
        str.hashCode();
        return (str.equals("ticpodsolo") || str.equals("ticpodpro")) ? Module.TICPODS : str;
    }

    public a a() {
        return this.callback;
    }

    public String c() {
        return d(this.source);
    }

    public String d(String str) {
        String f10 = f(str);
        oe.a aVar = this.feedbackLog;
        if (aVar != null && aVar.b().containsKey(f10)) {
            return this.feedbackLog.b().get(f10).a();
        }
        throw new IllegalStateException("please init ");
    }
}
