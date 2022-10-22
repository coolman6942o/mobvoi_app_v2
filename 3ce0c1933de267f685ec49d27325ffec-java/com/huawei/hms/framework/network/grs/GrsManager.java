package com.huawei.hms.framework.network.grs;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.restclient.hwhttp.plugin.BasePlugin;
import com.huawei.hms.framework.network.restclient.hwhttp.plugin.PluginInterceptor;
import java.io.IOException;
import java.util.Locale;
/* loaded from: classes.dex */
public class GrsManager implements BasePlugin {
    private static final int GRS_KEY_INDEX = 1;
    private static final int GRS_PATH_INDEX = 2;
    private static final String GRS_SCHEMA = "grs://";
    private static final int GRS_SERVICE_INDEX = 0;
    private static final int MAX_GRS_SPLIT = 3;
    private static final String SEPARATOR = "/";
    private static final String TAG = "GrsManager";
    @SuppressLint({"StaticFieldLeak"})
    private static volatile GrsManager instance;
    private GrsConfig grsConfig;
    private g grsInterceptor;

    private GrsManager() {
    }

    public static GrsManager getInstance() {
        if (instance == null) {
            synchronized (GrsManager.class) {
                if (instance == null) {
                    instance = new GrsManager();
                }
            }
        }
        return instance;
    }

    private String getServiceNameUrl(String str, String str2) {
        return GrsApi.synGetGrsUrl(str, str2);
    }

    public static boolean isGRSSchema(String str) {
        return str != null && str.startsWith(GRS_SCHEMA);
    }

    private String[] parseGRSSchema(String str) {
        return StringUtils.substring(str, str.toLowerCase(Locale.ENGLISH).indexOf(GRS_SCHEMA) + 6).split(SEPARATOR, 3);
    }

    public PluginInterceptor getInterceptor() {
        if (this.grsInterceptor == null) {
            this.grsInterceptor = new g();
        }
        return this.grsInterceptor;
    }

    public boolean initGrs(Context context, GrsConfig grsConfig) {
        GrsConfig grsConfig2 = this.grsConfig;
        if (grsConfig2 != null && grsConfig2.equal(grsConfig)) {
            return true;
        }
        this.grsConfig = grsConfig;
        GrsBaseInfo grsBaseInfo = null;
        Context applicationContext = context != null ? context.getApplicationContext() : null;
        GrsConfig grsConfig3 = this.grsConfig;
        if (grsConfig3 != null) {
            grsBaseInfo = grsConfig3.getGrsBaseInfo(applicationContext);
        }
        GrsApi.grsSdkInit(applicationContext, grsBaseInfo);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String parseGrs(String str) {
        String str2;
        String str3;
        String str4;
        if (str.endsWith(SEPARATOR)) {
            str = StringUtils.substring(str, str.indexOf(GRS_SCHEMA), str.length() - 1);
        }
        String[] parseGRSSchema = parseGRSSchema(str);
        if (parseGRSSchema.length == 1) {
            str3 = parseGRSSchema[0];
            str4 = "ROOT";
        } else if (parseGRSSchema.length >= 2) {
            str3 = parseGRSSchema[0];
            str4 = parseGRSSchema[1];
        } else {
            Logger.i(TAG, "parseGrs params.length<1.");
            str2 = "";
            if (!TextUtils.isEmpty(str2)) {
                throw new IOException("can not get url, do grsUrl(serviceName or key) error?");
            } else if (parseGRSSchema.length <= 2) {
                return str2;
            } else {
                if (str2.endsWith(SEPARATOR)) {
                    return str2 + parseGRSSchema[2];
                }
                return str2 + SEPARATOR + parseGRSSchema[2];
            }
        }
        str2 = getServiceNameUrl(str3, str4);
        if (!TextUtils.isEmpty(str2)) {
        }
    }
}
