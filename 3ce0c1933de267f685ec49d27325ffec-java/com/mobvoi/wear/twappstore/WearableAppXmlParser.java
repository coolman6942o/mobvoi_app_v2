package com.mobvoi.wear.twappstore;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import com.mobvoi.android.common.utils.k;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class WearableAppXmlParser {
    public static final String ORIGINAL_PKG_NAME_TAG = "originalPackageName";
    public static final String PATH_TAG = "path";
    public static final String RAW_PATH_RES_ID_TAG = "rawPathResId";
    private static final String TAG = "WearableAppXmlParser";
    public static final String VERSION_CODE_TAG = "versionCode";
    public static final String VERSION_NAME_TAG = "versionName";
    public static final String WEARABLE_APP_PKG = "package";
    public static final String WEARABLE_APP_TAG = "wearableApp";

    public static Map<String, String> parse(PackageManager packageManager, ApplicationInfo applicationInfo, int i10) {
        String str = null;
        if (!(packageManager == null || applicationInfo == null || i10 == 0)) {
            HashMap hashMap = new HashMap();
            try {
                Resources resourcesForApplication = packageManager.getResourcesForApplication(applicationInfo);
                if (resourcesForApplication == null) {
                    k.a(TAG, "Resource is null.");
                    return null;
                }
                try {
                    XmlResourceParser xml = resourcesForApplication.getXml(i10);
                    int i11 = 0;
                    while (xml.next() != 1) {
                        try {
                            i11 = xml.getEventType();
                        } catch (Exception e10) {
                            k.b(TAG, "Error when parse xml.", e10);
                        }
                        if (i11 == 2) {
                            str = xml.getName();
                            if (WEARABLE_APP_TAG.equals(str)) {
                                int attributeCount = xml.getAttributeCount();
                                for (int i12 = 0; i12 < attributeCount; i12++) {
                                    if ("package".equals(xml.getAttributeName(i12))) {
                                        hashMap.put("package", xml.getAttributeValue(i12));
                                    }
                                }
                            }
                        }
                        if (i11 == 4 && str != null) {
                            if (VERSION_CODE_TAG.equals(str)) {
                                hashMap.put(VERSION_CODE_TAG, xml.getText());
                            } else if (VERSION_NAME_TAG.equals(str)) {
                                hashMap.put(VERSION_NAME_TAG, xml.getText());
                            } else if ("path".equals(str)) {
                                hashMap.put("path", xml.getText());
                            } else if (RAW_PATH_RES_ID_TAG.equals(str)) {
                                hashMap.put(RAW_PATH_RES_ID_TAG, xml.getText());
                            } else if (ORIGINAL_PKG_NAME_TAG.equals(str)) {
                                hashMap.put(ORIGINAL_PKG_NAME_TAG, xml.getText());
                            }
                        }
                    }
                    xml.close();
                    return hashMap;
                } catch (Exception e11) {
                    k.b(TAG, "Error when get xml from resource.", e11);
                    return null;
                }
            } catch (PackageManager.NameNotFoundException e12) {
                k.b(TAG, "Error when get resources from application", e12);
            }
        }
        return null;
    }
}
