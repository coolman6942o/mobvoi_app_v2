package com.mobvoi.health.companion.system;

import com.mobvoi.wear.info.SharedWearInfoHelper;
import java.util.Map;
import java.util.TreeMap;
/* loaded from: classes2.dex */
public class WearDevices {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, b> f19008a;

    /* loaded from: classes2.dex */
    public enum DeviceType {
        Unknown("unknown"),
        Watch("watch"),
        Phone(SharedWearInfoHelper.PhoneInfo.TABLE),
        Band("band"),
        Pods("pods"),
        TicLite("ticLite");
        
        public final String name;

        DeviceType(String str) {
            this.name = str;
        }

        public static DeviceType from(String str) {
            DeviceType[] values;
            if (str == null) {
                return Unknown;
            }
            for (DeviceType deviceType : values()) {
                if (deviceType.name.equals(str)) {
                    return deviceType;
                }
            }
            return Unknown;
        }
    }

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final Map<String, b> f19009a = new TreeMap();

        public a a(b bVar) {
            this.f19009a.put(bVar.f19011b, bVar);
            return this;
        }

        public WearDevices b() {
            return new WearDevices(this.f19009a);
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public DeviceType f19010a;

        /* renamed from: b  reason: collision with root package name */
        public String f19011b;

        /* renamed from: c  reason: collision with root package name */
        public String f19012c;

        /* renamed from: d  reason: collision with root package name */
        public String f19013d;
    }

    public WearDevices(Map<String, b> map) {
        this.f19008a = map;
    }

    public b a(String str) {
        return this.f19008a.get(str);
    }
}
