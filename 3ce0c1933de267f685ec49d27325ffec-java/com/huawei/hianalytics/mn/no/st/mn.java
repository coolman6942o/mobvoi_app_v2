package com.huawei.hianalytics.mn.no.st;

import com.huawei.hianalytics.mn.mn.no;
import com.huawei.hianalytics.mn.no.b.pq;
import com.huawei.hianalytics.mn.no.mn.no;
import java.io.File;
import java.io.IOException;
/* loaded from: classes.dex */
public class mn {

    /* renamed from: mn  reason: collision with root package name */
    private String f13617mn = no.a().getFilesDir().getPath();

    private String mn(String str) {
        File file = new File(no(str), "hianalytics_".concat(String.valueOf(str)));
        if (mn(file)) {
            return pq.mn(file);
        }
        String no2 = com.huawei.hianalytics.mn.no.mn.no.mn().no(no.mn.RSA);
        pq.mn(file, no2);
        return no2;
    }

    private void mn(String str, String str2) {
        File file = new File(no(str));
        File file2 = new File(no(str), "hianalytics_".concat(String.valueOf(str)));
        if (!file.exists() && file.mkdirs()) {
            com.huawei.hianalytics.mn.no.qr.mn.no("ComponentManager", "file directory is mkdirs");
        }
        if (mn(file2)) {
            pq.mn(file2, str2);
        } else {
            com.huawei.hianalytics.mn.no.qr.mn.op("ComponentManager", "refreshComponent():file is not found,and file is create failed");
        }
    }

    private boolean mn(File file) {
        if (file.exists()) {
            return true;
        }
        try {
            return file.createNewFile();
        } catch (IOException unused) {
            com.huawei.hianalytics.mn.no.qr.mn.op("ComponentManager", "create new file error!");
            return false;
        }
    }

    private char[] mn(String str, String str2, String str3, String str4) {
        byte[] no2 = com.huawei.hianalytics.mn.no.mn.no.mn().no(str);
        byte[] no3 = com.huawei.hianalytics.mn.no.mn.no.mn().no(str2);
        byte[] no4 = com.huawei.hianalytics.mn.no.mn.no.mn().no(str3);
        byte[] no5 = com.huawei.hianalytics.mn.no.mn.no.mn().no(str4);
        int length = no2.length;
        if (length > no3.length) {
            length = no3.length;
        }
        if (length > no4.length) {
            length = no4.length;
        }
        if (length > no5.length) {
            length = no5.length;
        }
        char[] cArr = new char[length];
        for (int i10 = 0; i10 < length; i10++) {
            cArr[i10] = (char) (((no2[i10] ^ no3[i10]) ^ no4[i10]) ^ no5[i10]);
        }
        return cArr;
    }

    private String no(String str) {
        return this.f13617mn + "/hms/component/".replace("component", str);
    }

    private boolean no() {
        long no2 = com.huawei.hianalytics.mn.no.uv.mn.no(com.huawei.hianalytics.mn.mn.no.a(), "Privacy_MY", "assemblyFlash", -1L);
        if (-1 != no2) {
            return System.currentTimeMillis() - no2 > 31536000000L;
        }
        com.huawei.hianalytics.mn.no.qr.mn.no("ComponentManager", "First init components");
        return true;
    }

    private String op() {
        return "f6040d0e807aaec325ecf44823765544e92905158169f694b282bf17388632cf95a83bae7d2d235c1f039b0df1dcca5fda619b6f7f459f2ff8d70ddb7b601592fe29fcae58c028f319b3b12495e67aa5390942a997a8cb572c8030b2df5c2b622608bea02b0c3e5d4dff3f72c9e3204049a45c0760cd3604af8d57f0e0c693cc";
    }

    public String mn() {
        String str;
        String str2;
        String str3;
        String str4;
        String op2 = op();
        if (no()) {
            com.huawei.hianalytics.mn.no.qr.mn.no("ComponentManager", "refresh components");
            com.huawei.hianalytics.mn.no.mn.no mn2 = com.huawei.hianalytics.mn.no.mn.no.mn();
            no.mn mnVar = no.mn.RSA;
            str4 = mn2.no(mnVar);
            mn("aprpap", str4);
            str = com.huawei.hianalytics.mn.no.mn.no.mn().no(mnVar);
            mn("febdoc", str);
            str2 = com.huawei.hianalytics.mn.no.mn.no.mn().no(mnVar);
            mn("marfil", str2);
            str3 = com.huawei.hianalytics.mn.no.mn.no.mn().no(mnVar);
            mn("maywnj", str3);
            com.huawei.hianalytics.mn.no.uv.mn.mn(com.huawei.hianalytics.mn.mn.no.a(), "Privacy_MY", "assemblyFlash", System.currentTimeMillis());
        } else {
            str4 = mn("aprpap");
            str = mn("febdoc");
            str2 = mn("marfil");
            str3 = mn("maywnj");
        }
        return com.huawei.hianalytics.mn.no.mn.no.mn().mn(mn(str4, str, str2, op2), com.huawei.hianalytics.mn.no.mn.no.mn().no(str3));
    }
}
