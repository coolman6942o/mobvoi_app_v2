package com.tendcloud.tenddata;

import android.text.TextUtils;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.zip.CRC32;
/* compiled from: td */
/* loaded from: classes2.dex */
public class ca {

    /* renamed from: a  reason: collision with root package name */
    private static final int f22784a = 25;

    /* renamed from: b  reason: collision with root package name */
    private static ca f22785b;

    /* renamed from: c  reason: collision with root package name */
    private ExecutorService f22786c;

    /* renamed from: e  reason: collision with root package name */
    private CRC32 f22788e;

    /* renamed from: f  reason: collision with root package name */
    private Map<Integer, RandomAccessFile> f22789f;

    /* renamed from: g  reason: collision with root package name */
    private Map<Integer, FileLock> f22790g;

    /* renamed from: h  reason: collision with root package name */
    private Lock f22791h = new ReentrantLock();

    /* renamed from: d  reason: collision with root package name */
    private HashMap<Integer, TreeSet<bz>> f22787d = new HashMap<>();

    /* compiled from: td */
    /* loaded from: classes2.dex */
    class a implements Runnable {
        private final String mFolderPath;
        private final String mNewFolder;
        private final TreeSet<bz> mQueue;

        private void deleteFile(String str, bz bzVar) {
            File file = new File(str + File.separator + bzVar.b());
            if (file.exists()) {
                file.delete();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                TreeSet<bz> treeSet = this.mQueue;
                if (treeSet != null) {
                    treeSet.isEmpty();
                    while (!this.mQueue.isEmpty()) {
                        bz pollFirst = this.mQueue.pollFirst();
                        if (pollFirst != null) {
                            File file = new File(this.mFolderPath);
                            if (file.exists()) {
                                deleteFile(file.getAbsolutePath(), pollFirst);
                            }
                            File file2 = new File(this.mNewFolder);
                            if (file2.exists()) {
                                deleteFile(file2.getAbsolutePath(), pollFirst);
                            }
                        }
                    }
                    this.mQueue.clear();
                }
            } catch (Throwable th2) {
                bf.postSDKError(th2);
            }
        }

        private a(com.tendcloud.tenddata.a aVar) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(ab.f22568h.getFilesDir());
            String str = File.separator;
            sb2.append(str);
            sb2.append(aVar.getDataFolder());
            this.mFolderPath = sb2.toString();
            this.mNewFolder = ab.f22568h.getFilesDir() + str + aVar.getRootFolder() + str + aVar.getDataFolder();
            this.mQueue = (TreeSet) ca.this.f22787d.get(Integer.valueOf(aVar.index()));
        }
    }

    /* compiled from: td */
    /* loaded from: classes2.dex */
    class b implements Runnable {
        private final String mFolderPath;
        private final bz mOperation;

        @Override // java.lang.Runnable
        public void run() {
            try {
                File file = new File(this.mFolderPath + File.separator + this.mOperation.b());
                if (file.exists()) {
                    file.delete();
                }
            } catch (Throwable th2) {
                bf.postSDKError(th2);
            }
        }

        private b(bz bzVar, com.tendcloud.tenddata.a aVar, String str) {
            String absolutePath = ab.f22568h.getFilesDir().getAbsolutePath();
            if (!TextUtils.isEmpty(str)) {
                absolutePath = absolutePath + File.separator + str;
            }
            this.mFolderPath = absolutePath + File.separator + aVar.getDataFolder();
            this.mOperation = bzVar;
        }
    }

    /* compiled from: td */
    /* loaded from: classes2.dex */
    class c implements Runnable {
        private cb callback;
        private com.tendcloud.tenddata.a features;
        private String mFolderPath;
        private final bz mOperation;
        private final ca opm;

        /* JADX WARN: Code restructure failed: missing block: B:24:0x008c, code lost:
            if (r3 == null) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x008e, code lost:
            r3.release();
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0091, code lost:
            r2.close();
            r0 = r7.callback;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0096, code lost:
            if (r0 == null) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x00cf, code lost:
            return;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            FileLock fileLock;
            RandomAccessFile randomAccessFile;
            Throwable th2;
            Throwable th3;
            FileLock lock;
            try {
                try {
                    synchronized (this.opm) {
                        try {
                            File file = new File(this.mFolderPath);
                            if (file.exists() || file.isDirectory() || file.mkdirs()) {
                                ca.this.a(file, this.features);
                                File file2 = new File(this.mFolderPath + File.separator + this.mOperation.b());
                                if (file2.exists() || file2.createNewFile()) {
                                    RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rw");
                                    try {
                                        lock = randomAccessFile2.getChannel().lock();
                                    } catch (Throwable th4) {
                                        th3 = th4;
                                        fileLock = null;
                                        randomAccessFile = randomAccessFile2;
                                    }
                                    try {
                                        randomAccessFile2.seek(1L);
                                        randomAccessFile2.writeInt(this.mOperation.d());
                                        randomAccessFile2.writeInt(this.mOperation.e());
                                        randomAccessFile2.write(this.mOperation.c());
                                        randomAccessFile2.getFD().sync();
                                    } catch (Throwable th5) {
                                        th3 = th5;
                                        randomAccessFile = randomAccessFile2;
                                        fileLock = lock;
                                        while (true) {
                                            try {
                                                break;
                                            } catch (Throwable th6) {
                                                th3 = th6;
                                            }
                                        }
                                        throw th3;
                                    }
                                } else {
                                    return;
                                }
                            } else {
                                return;
                            }
                        } catch (Throwable th7) {
                            th3 = th7;
                            randomAccessFile = null;
                            fileLock = null;
                        }
                    }
                } catch (Throwable th8) {
                    th2 = th8;
                    randomAccessFile = null;
                    fileLock = null;
                }
                try {
                    break;
                    throw th3;
                } catch (Throwable th9) {
                    th2 = th9;
                    try {
                        cb cbVar = this.callback;
                        if (cbVar != null) {
                            cbVar.onStoreFailed();
                            this.callback = null;
                        }
                        bf.postSDKError(th2);
                        if (fileLock != null) {
                            fileLock.release();
                        }
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                            cb cbVar2 = this.callback;
                            if (cbVar2 == null) {
                                return;
                            }
                            cbVar2.onStoreSuccess();
                        }
                    } catch (Throwable th10) {
                        if (fileLock != null) {
                            try {
                                fileLock.release();
                            } catch (Throwable unused) {
                                throw th10;
                            }
                        }
                        if (randomAccessFile != null) {
                            randomAccessFile.close();
                            cb cbVar3 = this.callback;
                            if (cbVar3 != null) {
                                cbVar3.onStoreSuccess();
                            }
                        }
                        throw th10;
                    }
                }
            } catch (Throwable unused2) {
            }
        }

        private c(bz bzVar, bi biVar, ca caVar) {
            File filesDir = ab.f22568h.getFilesDir();
            this.opm = caVar;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(filesDir.toString());
            String str = File.separator;
            sb2.append(str);
            sb2.append(biVar.f22731a.getDataFolder());
            this.mFolderPath = sb2.toString();
            this.mFolderPath = filesDir.toString() + str + biVar.f22731a.getRootFolder() + str + biVar.f22731a.getDataFolder();
            this.mOperation = bzVar;
            this.callback = biVar.f22736f;
            this.features = biVar.f22731a;
        }
    }

    private ca() {
        c();
        for (com.tendcloud.tenddata.a aVar : com.tendcloud.tenddata.a.values()) {
            this.f22787d.put(Integer.valueOf(aVar.index()), new TreeSet<>());
        }
        this.f22786c = Executors.newSingleThreadExecutor();
        this.f22788e = new CRC32();
    }

    private void c() {
        com.tendcloud.tenddata.a[] values;
        this.f22789f = new HashMap();
        this.f22790g = new HashMap();
        try {
            for (com.tendcloud.tenddata.a aVar : com.tendcloud.tenddata.a.values()) {
                File file = new File(ab.f22568h.getFilesDir(), aVar.getRootFolder());
                File file2 = new File(file, aVar.getDataFolder());
                if (file2.exists() || file2.mkdirs()) {
                    this.f22789f.put(Integer.valueOf(aVar.index()), new RandomAccessFile(new File(file, "Lock" + aVar.index()), "rw"));
                } else {
                    return;
                }
            }
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    public void b() {
        File filesDir = ab.f22568h.getFilesDir();
        try {
            int i10 = 0;
            for (com.tendcloud.tenddata.a aVar : com.tendcloud.tenddata.a.values()) {
                File file = new File(filesDir, aVar.getDataFolder());
                if (file.exists()) {
                    for (File file2 : c(file)) {
                        file2.delete();
                    }
                }
            }
            com.tendcloud.tenddata.a[] values = com.tendcloud.tenddata.a.values();
            int length = values.length;
            while (i10 < length) {
                com.tendcloud.tenddata.a aVar2 = values[i10];
                File file3 = new File(filesDir, aVar2.getRootFolder());
                File file4 = new File(file3, aVar2.getDataFolder());
                if (file4.exists()) {
                    for (File file5 : c(file4)) {
                        file5.delete();
                    }
                }
                i10++;
                filesDir = file3;
            }
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    public void clearDataCache(com.tendcloud.tenddata.a aVar) {
        try {
            this.f22787d.get(Integer.valueOf(aVar.index())).clear();
        } catch (Throwable unused) {
        }
    }

    public void confirmRead(com.tendcloud.tenddata.a aVar) {
        new a(aVar).run();
    }

    public void getFileLock(com.tendcloud.tenddata.a aVar) {
        try {
            this.f22791h.lock();
            this.f22790g.put(Integer.valueOf(aVar.index()), this.f22789f.get(Integer.valueOf(aVar.index())).getChannel().lock());
        } catch (Throwable unused) {
        }
    }

    public void releaseFileLock(com.tendcloud.tenddata.a aVar) {
        try {
            if (this.f22790g.get(Integer.valueOf(aVar.index())) != null) {
                this.f22790g.get(Integer.valueOf(aVar.index())).release();
                this.f22791h.unlock();
            }
        } catch (Throwable unused) {
        }
    }

    public static ca a() {
        synchronized (ca.class) {
            if (f22785b == null) {
                f22785b = new ca();
            }
        }
        return f22785b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(File file, com.tendcloud.tenddata.a aVar) {
        try {
            int fileLimitType = aVar.getFileLimitType();
            if (fileLimitType != 1) {
                if (fileLimitType != 2) {
                    if (fileLimitType == 3) {
                        a(file);
                    }
                } else if (file.listFiles().length >= 10) {
                    a(file);
                }
            } else if (b(file) > 25) {
                a(file);
            }
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    private List<File> c(File file) {
        List<File> arrayList = new ArrayList<>();
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return arrayList;
        }
        try {
            arrayList = Arrays.asList(listFiles);
            Collections.sort(arrayList, new Comparator<File>() { // from class: com.tendcloud.tenddata.ca.1
                public int compare(File file2, File file3) {
                    return file2.getName().compareTo(file3.getName());
                }
            });
            return arrayList;
        } catch (Throwable unused) {
            return arrayList;
        }
    }

    private void a(File file) {
        try {
            if (file.isDirectory()) {
                a(c(file).get(0));
            } else {
                file.delete();
            }
        } catch (Throwable th2) {
            bf.postSDKError(th2);
        }
    }

    private int b(File file) {
        File[] listFiles;
        if (file == null) {
            return 0;
        }
        try {
            if (!(!file.isDirectory() || (listFiles = file.listFiles()) == null || listFiles.length == 0)) {
                long j10 = 0;
                for (File file2 : listFiles) {
                    if (file2.isFile()) {
                        j10 += file2.length();
                    }
                }
                return (int) (j10 / 1048576);
            }
            return 0;
        } catch (Throwable th2) {
            bf.postSDKError(th2);
            return 0;
        }
    }

    public synchronized void a(bz bzVar, bi biVar) {
        this.f22786c.execute(new c(bzVar, biVar, this));
    }

    private synchronized void a(bz bzVar, com.tendcloud.tenddata.a aVar) {
        if (!(aVar == null || bzVar == null)) {
            try {
                this.f22787d.get(Integer.valueOf(aVar.index())).add(bzVar);
            } catch (Throwable th2) {
                bf.postSDKError(th2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x010d A[Catch: all -> 0x0118, TRY_ENTER, TryCatch #6 {all -> 0x0118, blocks: (B:30:0x008e, B:31:0x0092, B:43:0x00e5, B:52:0x010d, B:54:0x0113), top: B:83:0x008e }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0113 A[Catch: all -> 0x0118, TRY_LEAVE, TryCatch #6 {all -> 0x0118, blocks: (B:30:0x008e, B:31:0x0092, B:43:0x00e5, B:52:0x010d, B:54:0x0113), top: B:83:0x008e }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x011b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized TreeSet<bz> a(com.tendcloud.tenddata.a aVar, int i10, String str) {
        FileLock fileLock;
        RandomAccessFile randomAccessFile;
        bz bzVar;
        File file;
        File filesDir = ab.f22568h.getFilesDir();
        if (str != null) {
            filesDir = new File(filesDir, str);
        }
        File file2 = new File(filesDir, aVar.getDataFolder());
        if (!file2.exists()) {
            g.iForInternal("operationFolder is not exists: " + file2);
        } else {
            String[] list = file2.list();
            if (list != null && list.length > 0) {
                int min = Math.min(list.length, i10);
                FileLock fileLock2 = null;
                RandomAccessFile randomAccessFile2 = null;
                bz bzVar2 = null;
                for (int i11 = 0; i11 < min; i11++) {
                    try {
                        file = new File(file2, list[i11]);
                    } catch (Throwable unused) {
                        fileLock = fileLock2;
                        randomAccessFile = randomAccessFile2;
                        bzVar = bzVar2;
                    }
                    if (file.length() == 0) {
                        if (fileLock2 != null) {
                            try {
                                fileLock2.release();
                                fileLock2 = null;
                            } catch (Throwable unused2) {
                            }
                        }
                        if (randomAccessFile2 != null) {
                            randomAccessFile2.close();
                        }
                    } else {
                        bzVar = new bz(list[i11]);
                        try {
                            randomAccessFile = new RandomAccessFile(file, "rw");
                            try {
                                fileLock = randomAccessFile.getChannel().tryLock();
                                if (fileLock == null) {
                                    try {
                                        randomAccessFile.close();
                                        if (fileLock != null) {
                                            try {
                                                fileLock.release();
                                                fileLock = null;
                                            } catch (Throwable unused3) {
                                                bzVar2 = bzVar;
                                                randomAccessFile2 = randomAccessFile;
                                                fileLock2 = fileLock;
                                            }
                                        }
                                        randomAccessFile.close();
                                        bzVar2 = bzVar;
                                        fileLock2 = fileLock;
                                    } catch (Throwable unused4) {
                                        this.f22786c.execute(new b(bzVar, aVar, str));
                                        if (fileLock != null) {
                                        }
                                        if (randomAccessFile == null) {
                                        }
                                        bzVar2 = bzVar;
                                        fileLock2 = fileLock;
                                    }
                                } else {
                                    randomAccessFile.seek(1L);
                                    int readInt = randomAccessFile.readInt();
                                    byte[] bArr = new byte[randomAccessFile.readInt()];
                                    randomAccessFile.readFully(bArr);
                                    this.f22788e.reset();
                                    this.f22788e.update(bArr);
                                    if (readInt == ((int) this.f22788e.getValue())) {
                                        try {
                                            bzVar.writeData(bArr);
                                            a(bzVar, aVar);
                                        } catch (Throwable unused5) {
                                            this.f22786c.execute(new b(bzVar, aVar, str));
                                            if (fileLock != null) {
                                                fileLock.release();
                                                fileLock = null;
                                            }
                                            if (randomAccessFile == null) {
                                                randomAccessFile.close();
                                                randomAccessFile2 = null;
                                            } else {
                                                randomAccessFile2 = randomAccessFile;
                                            }
                                            bzVar2 = bzVar;
                                            fileLock2 = fileLock;
                                        }
                                    } else {
                                        this.f22786c.execute(new b(bzVar, aVar, str));
                                    }
                                    fileLock.release();
                                    try {
                                        randomAccessFile.close();
                                        bzVar2 = bzVar;
                                        fileLock2 = null;
                                    } catch (Throwable unused6) {
                                        fileLock = null;
                                        bzVar2 = bzVar;
                                        randomAccessFile2 = randomAccessFile;
                                        fileLock2 = fileLock;
                                    }
                                }
                            } catch (Throwable unused7) {
                                fileLock = fileLock2;
                            }
                        } catch (Throwable unused8) {
                            fileLock = fileLock2;
                            randomAccessFile = randomAccessFile2;
                        }
                    }
                    randomAccessFile2 = null;
                }
            }
        }
        HashMap<Integer, TreeSet<bz>> hashMap = this.f22787d;
        if (hashMap == null) {
            return null;
        }
        return hashMap.get(Integer.valueOf(aVar.index()));
    }
}
