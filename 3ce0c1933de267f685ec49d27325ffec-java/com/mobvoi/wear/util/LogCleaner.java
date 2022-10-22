package com.mobvoi.wear.util;

import android.os.AsyncTask;
import android.util.Log;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class LogCleaner {
    public static final long ONE_DAY = 86400000;
    public static final long ONE_HOUR = 3600000;
    public static final long ONE_MINUTE = 60000;
    public static final long ONE_SEC = 1000;
    private static final String TAG = "LogCleaner";

    /* loaded from: classes2.dex */
    private static class CleanFileTask extends AsyncTask<Object, Void, Void> {
        private CleanFileTask() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        public Void doInBackground(Object... objArr) {
            File file;
            long longValue;
            File[] listFiles;
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            try {
                file = (File) objArr[0];
                longValue = ((Long) objArr[2]).longValue();
                listFiles = file.listFiles((FileFilter) objArr[1]);
            } catch (Exception e10) {
                Log.e(LogCleaner.TAG, "Exception when clean old log files, error: " + e10.getMessage());
            }
            if (listFiles == null) {
                Log.e(LogCleaner.TAG, "Error to get null when list files under folder: " + file);
                return null;
            }
            for (File file2 : listFiles) {
                if (Math.abs(currentTimeMillis - file2.lastModified()) > longValue && file2.delete()) {
                    arrayList.add(file2.getPath());
                }
            }
            Log.i(LogCleaner.TAG, String.format("Clean up %d logs: %s", Integer.valueOf(arrayList.size()), arrayList.toString()));
            return null;
        }
    }

    public static void cleanLogsByDateFormat(File file, long j10, FileFilter fileFilter) {
        new CleanFileTask().execute(file, fileFilter, Long.valueOf(j10));
    }
}
