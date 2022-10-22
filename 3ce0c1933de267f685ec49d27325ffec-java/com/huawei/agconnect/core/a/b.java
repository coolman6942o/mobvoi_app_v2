package com.huawei.agconnect.core.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import com.huawei.agconnect.core.Service;
import com.huawei.agconnect.core.ServiceDiscovery;
import com.huawei.agconnect.core.ServiceRegistrar;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private Context f13508a;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a implements Serializable, Comparator<Map.Entry<String, Integer>> {
        private a() {
        }

        /* renamed from: a */
        public int compare(Map.Entry<String, Integer> entry, Map.Entry<String, Integer> entry2) {
            return entry.getValue().intValue() - entry2.getValue().intValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context) {
        this.f13508a = context;
    }

    private <T extends ServiceRegistrar> T a(String str) {
        String str2;
        String str3;
        StringBuilder sb2;
        try {
            Class<?> cls = Class.forName(str);
            if (ServiceRegistrar.class.isAssignableFrom(cls)) {
                return (T) Class.forName(str).newInstance();
            }
            Log.e("ServiceRegistrarParser", cls + " must extends from ServiceRegistrar.");
            return null;
        } catch (ClassNotFoundException e10) {
            str2 = "Can not found service class, " + e10.getMessage();
            Log.e("ServiceRegistrarParser", str2);
            return null;
        } catch (IllegalAccessException e11) {
            sb2 = new StringBuilder();
            sb2.append("instantiate service class exception ");
            str3 = e11.getLocalizedMessage();
            sb2.append(str3);
            str2 = sb2.toString();
            Log.e("ServiceRegistrarParser", str2);
            return null;
        } catch (InstantiationException e12) {
            sb2 = new StringBuilder();
            sb2.append("instantiate service class exception ");
            str3 = e12.getLocalizedMessage();
            sb2.append(str3);
            str2 = sb2.toString();
            Log.e("ServiceRegistrarParser", str2);
            return null;
        }
    }

    private List<String> b() {
        StringBuilder sb2;
        ArrayList arrayList = new ArrayList();
        Bundle c10 = c();
        if (c10 == null) {
            return arrayList;
        }
        HashMap hashMap = new HashMap(10);
        for (String str : c10.keySet()) {
            if ("com.huawei.agconnect.core.ServiceRegistrar".equals(c10.getString(str))) {
                String[] split = str.split(":");
                if (split.length == 2) {
                    try {
                        hashMap.put(split[0], Integer.valueOf(split[1]));
                    } catch (NumberFormatException e10) {
                        sb2 = new StringBuilder();
                        sb2.append("registrar configuration format error:");
                        str = e10.getMessage();
                    }
                } else if (split.length == 1) {
                    hashMap.put(split[0], 1000);
                } else {
                    sb2 = new StringBuilder();
                    sb2.append("registrar configuration error, ");
                    sb2.append(str);
                    Log.e("ServiceRegistrarParser", sb2.toString());
                }
            }
        }
        ArrayList<Map.Entry> arrayList2 = new ArrayList(hashMap.entrySet());
        Collections.sort(arrayList2, new a());
        for (Map.Entry entry : arrayList2) {
            arrayList.add(entry.getKey());
        }
        return arrayList;
    }

    private Bundle c() {
        ServiceInfo serviceInfo;
        PackageManager packageManager = this.f13508a.getPackageManager();
        if (packageManager == null) {
            return null;
        }
        try {
            serviceInfo = packageManager.getServiceInfo(new ComponentName(this.f13508a, ServiceDiscovery.class), 128);
        } catch (PackageManager.NameNotFoundException e10) {
            Log.e("ServiceRegistrarParser", "get ServiceDiscovery exception." + e10.getLocalizedMessage());
        }
        if (serviceInfo != null) {
            return serviceInfo.metaData;
        }
        Log.e("ServiceRegistrarParser", "Can not found ServiceDiscovery service.");
        return null;
    }

    public List<Service> a() {
        Log.i("ServiceRegistrarParser", "getServices");
        List<String> b10 = b();
        ArrayList arrayList = new ArrayList();
        for (String str : b10) {
            ServiceRegistrar a10 = a(str);
            if (a10 != null) {
                a10.initialize(this.f13508a);
                List<Service> services = a10.getServices(this.f13508a);
                if (services != null) {
                    arrayList.addAll(services);
                }
            }
        }
        Log.i("ServiceRegistrarParser", "services:" + Integer.valueOf(arrayList.size()));
        return arrayList;
    }
}
