package com.mobvoi.wear.util;

import android.util.Log;
import com.mobvoi.android.common.utils.j;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes2.dex */
public class CommandLineUtils {
    public static final int ERROR = -1;
    private static final String TAG = "CommandLineUtils";

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0100 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00ee A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v11, types: [int] */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int exec(List<String> list, boolean z10, OutputStream outputStream, OutputStream outputStream2) {
        Process process;
        Throwable th2;
        Exception e10;
        DataOutputStream dataOutputStream;
        int i10 = -1;
        if (list == 0 || list.isEmpty()) {
            return -1;
        }
        DataOutputStream dataOutputStream2 = null;
        try {
            if (z10) {
                process = Runtime.getRuntime().exec("su", (String[]) null, (File) null);
                try {
                    try {
                        dataOutputStream = new DataOutputStream(process.getOutputStream());
                    } catch (Exception e11) {
                        e10 = e11;
                    }
                } catch (Throwable th3) {
                    th2 = th3;
                }
                try {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        dataOutputStream.writeBytes(((String) it.next()) + "\n");
                        dataOutputStream.flush();
                    }
                    dataOutputStream.writeBytes("exit\n");
                    dataOutputStream.flush();
                    if (outputStream != null) {
                        j.b(process.getInputStream(), outputStream);
                    }
                    if (outputStream2 != null) {
                        j.b(process.getErrorStream(), outputStream2);
                    }
                    process.waitFor();
                    dataOutputStream2 = dataOutputStream;
                    list = process.exitValue();
                } catch (Exception e12) {
                    e10 = e12;
                    dataOutputStream2 = dataOutputStream;
                    Log.e(TAG, "Error running commands: " + list + ", err_msg: " + e10.getMessage());
                    if (dataOutputStream2 != null) {
                    }
                    if (process != 0) {
                    }
                    return i10;
                } catch (Throwable th4) {
                    th2 = th4;
                    dataOutputStream2 = dataOutputStream;
                    if (dataOutputStream2 != null) {
                    }
                    if (process != 0) {
                    }
                    throw th2;
                }
            } else {
                int i11 = -1;
                Process process2 = null;
                for (String str : list) {
                    try {
                        try {
                            try {
                                process2 = Runtime.getRuntime().exec(str);
                                process2.waitFor();
                                i11 = process2.exitValue();
                                if (outputStream != null) {
                                    j.b(process2.getInputStream(), outputStream);
                                }
                                if (outputStream2 != null) {
                                    j.b(process2.getErrorStream(), outputStream2);
                                }
                            } catch (Exception e13) {
                                e10 = e13;
                                process = process2;
                                Log.e(TAG, "Error running commands: " + list + ", err_msg: " + e10.getMessage());
                                if (dataOutputStream2 != null) {
                                    try {
                                        dataOutputStream2.close();
                                    } catch (IOException e14) {
                                        e14.printStackTrace();
                                    }
                                }
                                if (process != 0) {
                                    process.destroy();
                                }
                                return i10;
                            }
                        } catch (Throwable th5) {
                            th2 = th5;
                            process = process2;
                            if (dataOutputStream2 != null) {
                                try {
                                    dataOutputStream2.close();
                                } catch (IOException e15) {
                                    e15.printStackTrace();
                                }
                            }
                            if (process != 0) {
                                process.destroy();
                            }
                            throw th2;
                        }
                    } catch (Exception e16) {
                        e10 = e16;
                        i10 = i11;
                    }
                }
                list = i11;
                process = process2;
            }
            if (dataOutputStream2 != null) {
                try {
                    dataOutputStream2.close();
                } catch (IOException e17) {
                    e17.printStackTrace();
                }
            }
            if (process == null) {
                return list;
            }
            process.destroy();
            return list;
        } catch (Exception e18) {
            e10 = e18;
            process = dataOutputStream2;
        } catch (Throwable th6) {
            th2 = th6;
            process = dataOutputStream2;
        }
    }

    public static boolean execRootCmds(String... strArr) {
        return exec(Arrays.asList(strArr), true, null, null) == 0;
    }

    public static int exec(List<String> list) {
        return exec(list, false, null, null);
    }
}
