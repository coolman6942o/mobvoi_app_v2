package com.huawei.hms.mlsdk.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.huawei.agconnect.AGConnectInstance;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.ml.common.utils.SmartLog;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
/* loaded from: classes2.dex */
public class AgConnectInfo {
    private String apiKey;
    private String applicationId;
    private String certFingerprint;
    private List<String> haCollectorUrls;
    private List<String> mlServiceUrls;
    private String packageName;
    private String region;

    /* loaded from: classes2.dex */
    private static final class AgConnectKey {
        public static String ANALYTICS_COLLECTOR_URL = "service/analytics/collector_url";
        public static String API_KEY = "client/api_key";
        public static String APPLICATION_ID = "client/app_id";
        public static String ML_SERVICE_URL = "service/ml/mlservice_url";
        public static String PACKAGE_NAME = "client/package_name";
        public static String REGION = "region";

        private AgConnectKey() {
        }
    }

    public AgConnectInfo(Context context) {
        this.mlServiceUrls = new ArrayList();
        this.haCollectorUrls = new ArrayList();
        context = context == null ? AGConnectInstance.getInstance().getContext() : context;
        if (context != null) {
            AGConnectServicesConfig fromContext = AGConnectServicesConfig.fromContext(context);
            SmartLog.i("AgConnectInfo", "AGConnectServicesConfig: " + fromContext + "context: " + context);
            this.region = fromContext.getString(AgConnectKey.REGION);
            SmartLog.i("AgConnectInfo", "AGConnectServicesConfig: " + fromContext + "region: " + this.region);
            String string = fromContext.getString(AgConnectKey.PACKAGE_NAME);
            this.packageName = string;
            if (string == null) {
                this.packageName = context.getPackageName();
            } else {
                SmartLog.i("AgConnectInfo", "AGConnectServicesConfig: " + fromContext + "packageName: " + this.packageName);
            }
            String string2 = fromContext.getString(AgConnectKey.APPLICATION_ID);
            this.applicationId = string2;
            if (string2 == null) {
                this.applicationId = this.packageName;
            } else {
                SmartLog.i("AgConnectInfo", "AGConnectServicesConfig: " + fromContext + "packageName: " + this.packageName);
            }
            this.apiKey = fromContext.getString(AgConnectKey.API_KEY);
            SmartLog.i("AgConnectInfo", "AGConnectServicesConfig: " + fromContext + "apiKey: " + this.apiKey);
            this.certFingerprint = getRawSignature(context);
            SmartLog.i("AgConnectInfo", "AGConnectServicesConfig: " + fromContext + "certFingerprint: " + this.certFingerprint);
            String string3 = fromContext.getString(AgConnectKey.ML_SERVICE_URL);
            if (string3 != null) {
                for (String str : string3.split(",")) {
                    String lowerCase = str.trim().toLowerCase(Locale.ENGLISH);
                    if (!lowerCase.startsWith("http://") && !lowerCase.startsWith("https://")) {
                        lowerCase = "https://" + lowerCase;
                    }
                    if (!lowerCase.endsWith("/")) {
                        lowerCase = lowerCase + "/";
                    }
                    this.mlServiceUrls.add(lowerCase);
                }
            }
            String string4 = fromContext.getString(AgConnectKey.ANALYTICS_COLLECTOR_URL);
            if (string4 != null) {
                for (String str2 : string4.split(",")) {
                    String lowerCase2 = str2.trim().toLowerCase(Locale.ENGLISH);
                    if (!lowerCase2.startsWith("http://") && !lowerCase2.startsWith("https://")) {
                        lowerCase2 = "https://" + lowerCase2;
                    }
                    this.haCollectorUrls.add(lowerCase2);
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("Context not found.");
    }

    private String getRawSignature(Context context) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
        } catch (PackageManager.NameNotFoundException unused) {
        }
        if (packageInfo == null) {
            return "";
        }
        Signature signature = null;
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null || signatureArr.length <= 0) {
            SmartLog.i("AgConnectInfo", "signature is null ");
        } else {
            signature = signatureArr[0];
            SmartLog.i("AgConnectInfo", "signature is not null ");
        }
        if (signature != null) {
            return getSignatureString(signature, "SHA256");
        }
        return "";
    }

    private final String getSignatureString(Signature signature, String str) {
        try {
            byte[] byteArray = signature.toByteArray();
            StringBuffer stringBuffer = new StringBuffer();
            MessageDigest messageDigest = MessageDigest.getInstance(str);
            messageDigest.reset();
            messageDigest.update(byteArray);
            byte[] digest = messageDigest.digest();
            for (int i10 = 0; i10 < digest.length; i10++) {
                if (Integer.toHexString(digest[i10] & 255).length() == 1) {
                    stringBuffer.append("0");
                    stringBuffer.append(Integer.toHexString(digest[i10] & 255));
                } else {
                    stringBuffer.append(Integer.toHexString(digest[i10] & 255));
                }
                if (i10 != digest.length - 1) {
                    stringBuffer.append(":");
                }
            }
            return stringBuffer.toString().toUpperCase(Locale.ENGLISH);
        } catch (Throwable unused) {
            return null;
        }
    }

    public String getApiKey() {
        return this.apiKey;
    }

    public String getApplicationId() {
        return this.applicationId;
    }

    public String getCertFingerprint() {
        return this.certFingerprint;
    }

    public List<String> getHaCollectorUrls() {
        return this.haCollectorUrls;
    }

    public List<String> getMLServiceUrls() {
        return this.mlServiceUrls;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getRegion() {
        return this.region;
    }

    public AgConnectInfo() {
        this(null);
    }
}
