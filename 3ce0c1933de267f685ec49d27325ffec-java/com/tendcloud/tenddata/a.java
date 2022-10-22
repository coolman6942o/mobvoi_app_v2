package com.tendcloud.tenddata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* compiled from: td */
/* loaded from: classes2.dex */
public abstract class a {
    private static volatile List<String> FeaturesList = new ArrayList();
    public static final String MF_JSON = "UNIFIED_SDK_JSON";
    public static final a UNIVERSAL;
    private static final a[] service;
    private int indexNum;
    private String nameString;

    static {
        a aVar = new a("SDK", 99) { // from class: com.tendcloud.tenddata.a.1
            private boolean isUrlUpdated = false;
            private String url;

            @Override // com.tendcloud.tenddata.a
            public String getCert() {
                return "";
            }

            @Override // com.tendcloud.tenddata.a
            public String getDataFolder() {
                return a.super.getDataFolder();
            }

            @Override // com.tendcloud.tenddata.a
            public int getFileLimitType() {
                return a.super.getFileLimitType();
            }

            @Override // com.tendcloud.tenddata.a
            public String getHost() {
                return aa.f22530b;
            }

            @Override // com.tendcloud.tenddata.a
            public String getIP() {
                return aa.f22532d;
            }

            @Override // com.tendcloud.tenddata.a
            public String getMessageFormat() {
                return a.MF_JSON;
            }

            @Override // com.tendcloud.tenddata.a
            public String getRootFolder() {
                return a.super.getRootFolder();
            }

            @Override // com.tendcloud.tenddata.a
            public String getUrl() {
                return this.isUrlUpdated ? this.url : aa.f22536h;
            }

            @Override // com.tendcloud.tenddata.a
            public void setUrl(String str) {
                this.isUrlUpdated = true;
                this.url = str;
            }
        };
        UNIVERSAL = aVar;
        service = new a[]{aVar};
    }

    protected a(String str, int i10) {
        this.nameString = str;
        this.indexNum = i10;
        addFeatures2List(str);
    }

    private void addFeatures2List(String str) {
        try {
            if (!u.b(str) && !FeaturesList.contains(str)) {
                FeaturesList.add(str);
            }
        } catch (Throwable unused) {
        }
    }

    public static ArrayList<a> getFeaturesList() {
        ArrayList<a> arrayList = new ArrayList<>();
        for (int i10 = 0; i10 < FeaturesList.size(); i10++) {
            try {
                if (valueOf(FeaturesList.get(i10)) != null) {
                    arrayList.add(valueOf(FeaturesList.get(i10)));
                }
            } catch (Throwable unused) {
            }
        }
        return arrayList;
    }

    public static List<String> getFeaturesNameList() {
        return FeaturesList;
    }

    public static a valueOf(String str) {
        a aVar = UNIVERSAL;
        if (str.equals(aVar.name())) {
            return aVar;
        }
        return null;
    }

    public static a[] values() {
        a[] aVarArr = service;
        return (a[]) Arrays.copyOf(aVarArr, aVarArr.length);
    }

    public abstract String getCert();

    public String getDataFolder() {
        return "td_database" + index() + ci.f22805c;
    }

    public int getFileLimitType() {
        return 1;
    }

    public abstract String getHost();

    public abstract String getIP();

    public abstract String getMessageFormat();

    public String getRootFolder() {
        return aa.f22550v;
    }

    public abstract String getUrl();

    public int index() {
        return this.indexNum;
    }

    public String name() {
        return this.nameString;
    }

    public boolean needToSendData() {
        return true;
    }

    public void setUrl(String str) {
    }

    protected a(String str, int i10, boolean z10) {
        this.nameString = str;
        this.indexNum = i10;
    }
}
