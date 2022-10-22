package yd;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.mobvoi.android.common.utils.k;
import hc.e;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/* compiled from: UnicomSdcardUtil.java */
/* loaded from: classes2.dex */
public class q {
    private static void a(Context context) {
        String str = Environment.getExternalStorageDirectory() + "/com.cu.rsp/" + context.getPackageName() + ".txt";
        if (TextUtils.isEmpty(b(str))) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("packageName", (Object) context.getPackageName());
                jSONObject.put("interface-version", (Object) "1.0");
                jSONObject.put("oem-name", (Object) "出门问问");
                c(jSONObject.toString(), str);
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    private static String b(String str) {
        try {
            File file = new File(str);
            if (!file.exists()) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream(file);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    String byteArrayOutputStream2 = byteArrayOutputStream.toString();
                    byteArrayOutputStream.close();
                    fileInputStream.close();
                    return byteArrayOutputStream2;
                }
            }
        } catch (IOException e10) {
            k.e("UnicomSdcardUtil", "error when readFile, ", e10);
            return null;
        }
    }

    private static void c(String str, String str2) {
        try {
            File file = new File(str2);
            if (!file.exists()) {
                new File(file.getParent()).mkdirs();
                file.createNewFile();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(str.getBytes());
            fileOutputStream.close();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static void d(Context context) {
        if (e.i(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            a(context);
        }
    }
}
