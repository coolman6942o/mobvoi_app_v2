package com.tendcloud.tenddata;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.concurrent.ConcurrentHashMap;
/* compiled from: td */
/* loaded from: classes2.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private static ConcurrentHashMap<String, a> f22943a = new ConcurrentHashMap<>();

    /* compiled from: td */
    /* loaded from: classes2.dex */
    static class a {
        private FileLock fileLock;
        private RandomAccessFile randomAccessFile;

        private a() {
        }
    }

    /* compiled from: td */
    /* loaded from: classes2.dex */
    public enum b {
        Custom_Device_Id_Lock_File("Custom_Device_Id_Lock_File"),
        Cloud_Control_Lock_File("Cloud_Control_Cache_Param"),
        App_Lock_File("__App_Synchronous_Lock__"),
        Tracking_Lock_File("__Tracking_Synchronous_Lock__"),
        Env_Lock_File("__Env_Synchronous_Lock__"),
        Game_Lock_File("__Game_Synchronous_Lock__"),
        Push_Lock_File("__Push_Synchronous_Lock__"),
        EAuth_Lock_File("__EAuth_Synchronous_Lock__"),
        App_SQL_Lock_File("__AppSQL_Synchronous_Lock__"),
        BG_Lock_File("__BG_Synchronous_Lock__"),
        Universal_Lock_File("__SDK_Synchronous_Lock__"),
        AES_DATA_LOCK("_AES_DATA_LOCK"),
        AES_DATA_ENTRYCP_LOCK("_AES_DATA_ENTCRYPT_LOCK"),
        AES_SALT_LOCK("_AES_SALT_LOCK"),
        AES_IV_LOCK("_AES_IV_LOCK");
        
        private final String filePath;

        b(String str) {
            File filesDir = ab.f22568h.getFilesDir();
            this.filePath = new File(filesDir, ab.f22581u + str).getAbsolutePath();
        }

        public static String getFeatureLockFileName(int i10) {
            if (i10 == 0) {
                return App_Lock_File.toString();
            }
            if (i10 == 1) {
                return Tracking_Lock_File.toString();
            }
            if (i10 == 2) {
                return Env_Lock_File.toString();
            }
            if (i10 == 3) {
                return Game_Lock_File.toString();
            }
            if (i10 == 4) {
                return Push_Lock_File.toString();
            }
            if (i10 == 6) {
                return EAuth_Lock_File.toString();
            }
            if (i10 == 7) {
                return App_SQL_Lock_File.toString();
            }
            if (i10 == 8) {
                return BG_Lock_File.toString();
            }
            if (i10 != 99) {
                return null;
            }
            return Universal_Lock_File.toString();
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.filePath;
        }
    }

    public static boolean a(String str) {
        a aVar;
        RandomAccessFile randomAccessFile;
        try {
            if (!u.b(str)) {
                File file = new File(str);
                if (f22943a.containsKey(str)) {
                    aVar = f22943a.get(str);
                    randomAccessFile = aVar.randomAccessFile;
                } else {
                    a aVar2 = new a();
                    RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rw");
                    aVar2.randomAccessFile = randomAccessFile2;
                    f22943a.put(str, aVar2);
                    aVar = aVar2;
                    randomAccessFile = randomAccessFile2;
                }
                aVar.fileLock = randomAccessFile.getChannel().tryLock();
                return aVar.fileLock != null;
            }
            throw new RuntimeException("LockManager Error: filePath can not be null!");
        } catch (Throwable unused) {
            return false;
        }
    }

    public static RandomAccessFile b(String str) {
        try {
            if (!u.b(str)) {
                File file = new File(str);
                if (f22943a.containsKey(str)) {
                    return f22943a.get(str).randomAccessFile;
                }
                a aVar = new a();
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                aVar.randomAccessFile = randomAccessFile;
                f22943a.put(str, aVar);
                return randomAccessFile;
            }
            throw new RuntimeException("LockManager Error: filePath can not be null!");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void getFileLock(String str) {
        a aVar;
        RandomAccessFile randomAccessFile;
        try {
            if (!u.b(str)) {
                File file = new File(str);
                if (f22943a.containsKey(str)) {
                    aVar = f22943a.get(str);
                    randomAccessFile = aVar.randomAccessFile;
                } else {
                    a aVar2 = new a();
                    RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rw");
                    aVar2.randomAccessFile = randomAccessFile2;
                    f22943a.put(str, aVar2);
                    aVar = aVar2;
                    randomAccessFile = randomAccessFile2;
                }
                aVar.fileLock = randomAccessFile.getChannel().lock();
                return;
            }
            throw new RuntimeException("LockManager Error: filePath can not be null!");
        } catch (Throwable unused) {
        }
    }

    public static void releaseFileLock(String str) {
        try {
            if (u.b(str)) {
                throw new RuntimeException("LockManager Error: filePath can not be null!");
            } else if (f22943a.containsKey(str)) {
                a aVar = f22943a.get(str);
                if (aVar.fileLock != null) {
                    aVar.fileLock.release();
                }
            } else {
                throw new RuntimeException("LockManager Error: there is no information about this file in the cache!");
            }
        } catch (Throwable unused) {
        }
    }
}
