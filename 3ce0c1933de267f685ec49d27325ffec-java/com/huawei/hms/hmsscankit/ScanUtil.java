package com.huawei.hms.hmsscankit;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import com.amap.api.services.core.AMapException;
import com.huawei.hms.ml.scan.HmsBuildBitmapOption;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanAnalyzerOptions;
import com.huawei.hms.ml.scan.HmsScanBase;
import com.huawei.hms.mlsdk.common.MLFrame;
import com.huawei.hms.scankit.p.C0645yb;
import com.huawei.hms.scankit.util.a;
import com.huawei.hms.scankit.util.b;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
/* loaded from: classes2.dex */
public class ScanUtil {
    public static final int CAMERA_ININT_ERROR = -1000;
    static final String CONTEXT_METHOD = "initializeModule";
    static final String CONTEXT_PATH = "com.huawei.hms.feature.DynamicModuleInitializer";
    static final String CREATOR_PATH = "com.huawei.hms.scankit.Creator";
    public static final int ERROR_NO_CAMERA_PERMISSION = 1;
    public static final int ERROR_NO_READ_PERMISSION = 2;
    private static final int MAX_BITMAP_SIZE = 52428800;
    static final String MODULE_SCANKIT = "huawei_module_scankit";
    static final String MODULE_SCANKIT_LOCAL = "huawei_module_scankit_local";
    public static final String RESULT = "SCAN_RESULT";
    public static final int SUCCESS = 0;

    public static Bitmap buildBitmap(String str, int i10, int i11, int i12, HmsBuildBitmapOption hmsBuildBitmapOption) throws WriterException {
        return new C0645yb().a(str, i10, i11, i12, hmsBuildBitmapOption);
    }

    public static Bitmap compressBitmap(Context context, String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        dealBitmapFactoryOption(context, options);
        return BitmapFactory.decodeFile(str, options);
    }

    /* JADX WARN: Multi-variable type inference failed. Error: jadx.core.utils.exceptions.JadxRuntimeException: TypeSearchVarInfo not found in map for var: r4v3 java.lang.Object
    	at jadx.core.dex.visitors.typeinference.TypeSearchState.getVarInfo(TypeSearchState.java:34)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.lambda$resolveIndependentVariables$1(TypeSearch.java:174)
    	at java.base/java.util.stream.MatchOps$1MatchSink.accept(MatchOps.java:90)
    	at java.base/java.util.ArrayList$ArrayListSpliterator.tryAdvance(ArrayList.java:1632)
    	at java.base/java.util.stream.ReferencePipeline$7$1.accept(ReferencePipeline.java:278)
    	at java.base/java.util.ArrayList$ArrayListSpliterator.tryAdvance(ArrayList.java:1632)
    	at java.base/java.util.stream.ReferencePipeline.forEachWithCancel(ReferencePipeline.java:127)
    	at java.base/java.util.stream.AbstractPipeline.copyIntoWithCancel(AbstractPipeline.java:502)
    	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:488)
    	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
    	at java.base/java.util.stream.MatchOps$MatchOp.evaluateSequential(MatchOps.java:230)
    	at java.base/java.util.stream.MatchOps$MatchOp.evaluateSequential(MatchOps.java:196)
    	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
    	at java.base/java.util.stream.ReferencePipeline.allMatch(ReferencePipeline.java:533)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.resolveIndependentVariables(TypeSearch.java:174)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1541)
    	at jadx.core.dex.visitors.typeinference.TypeSearch.run(TypeSearch.java:63)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.runMultiVariableSearch(TypeInferenceVisitor.java:158)
    	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:109)
     */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x0092: MOVE  (r4 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:33:0x0092 */
    /* JADX WARN: Removed duplicated region for block: B:40:0x005c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0095 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap compressBitmapForAndroid29(Context context, String str) {
        Throwable th2;
        Cursor cursor;
        Uri withAppendedPath;
        Uri uri = null;
        uri = null;
        uri = null;
        uri = null;
        Cursor cursor2 = null;
        uri = null;
        uri = null;
        try {
            try {
                try {
                    cursor = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "_data=?", new String[]{str}, null);
                } catch (Throwable th3) {
                    th2 = th3;
                    if (cursor2 != null) {
                        try {
                            cursor2.close();
                        } catch (Exception unused) {
                            a.b("exception", "Exception");
                        }
                    }
                    throw th2;
                }
            } catch (NullPointerException unused2) {
                cursor = null;
            } catch (Exception unused3) {
                cursor = null;
            } catch (Throwable th4) {
                th2 = th4;
                if (cursor2 != null) {
                }
                throw th2;
            }
        } catch (Exception unused4) {
            a.b("exception", "Exception");
        }
        if (cursor != null) {
            try {
            } catch (NullPointerException unused5) {
                a.b("exception", "NullPointerException");
                if (cursor != null) {
                    cursor.close();
                }
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                getBitmapFromUri(context, uri, options);
                dealBitmapFactoryOption(context, options);
                return getBitmapFromUri(context, uri, options);
            } catch (Exception unused6) {
                a.b("exception", "Exception");
                if (cursor != null) {
                    cursor.close();
                }
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inJustDecodeBounds = true;
                getBitmapFromUri(context, uri, options2);
                dealBitmapFactoryOption(context, options2);
                return getBitmapFromUri(context, uri, options2);
            }
            if (cursor.moveToFirst()) {
                withAppendedPath = Uri.withAppendedPath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, String.valueOf(cursor.getInt(cursor.getColumnIndex("_id"))));
                uri = withAppendedPath;
                if (cursor != null) {
                    try {
                        cursor.close();
                    } catch (Exception unused7) {
                        a.b("exception", "Exception");
                    }
                }
                BitmapFactory.Options options22 = new BitmapFactory.Options();
                options22.inJustDecodeBounds = true;
                getBitmapFromUri(context, uri, options22);
                dealBitmapFactoryOption(context, options22);
                return getBitmapFromUri(context, uri, options22);
            }
        }
        if (new File(str).exists()) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("_data", str);
            withAppendedPath = context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
            uri = withAppendedPath;
        }
        if (cursor != null) {
        }
        BitmapFactory.Options options222 = new BitmapFactory.Options();
        options222.inJustDecodeBounds = true;
        getBitmapFromUri(context, uri, options222);
        dealBitmapFactoryOption(context, options222);
        return getBitmapFromUri(context, uri, options222);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0058  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void dealBitmapFactoryOption(Context context, BitmapFactory.Options options) {
        boolean z10;
        ActivityManager.MemoryInfo memoryInfo;
        int i10 = options.outWidth;
        int i11 = options.outHeight;
        if (i10 != 0 && i11 != 0) {
            if (i10 > i11) {
                i10 = i11;
            }
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(new ActivityManager.MemoryInfo());
                } catch (NullPointerException unused) {
                    a.b("exception", "NullPointerException");
                } catch (Exception unused2) {
                    a.b("exception", "Exception");
                }
                if (memoryInfo.totalMem / Math.pow(1024.0d, 3.0d) >= 5.5d) {
                    z10 = false;
                    int i12 = !z10 ? AMapException.CODE_AMAP_SERVICE_INVALID_PARAMS : AMapException.CODE_AMAP_ROUTE_OUT_OF_SERVICE;
                    options.inSampleSize = i10 <= i12 ? Math.round(i10 / i12) : 1;
                    options.inJustDecodeBounds = false;
                    options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                    options.inPurgeable = true;
                    options.inInputShareable = true;
                }
            }
            z10 = true;
            if (!z10) {
            }
            options.inSampleSize = i10 <= i12 ? Math.round(i10 / i12) : 1;
            options.inJustDecodeBounds = false;
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            options.inPurgeable = true;
            options.inInputShareable = true;
        }
    }

    public static HmsScan[] decodeWithBitmap(Context context, Bitmap bitmap, HmsScanAnalyzerOptions hmsScanAnalyzerOptions) {
        if (bitmap != null && bitmap.getWidth() * bitmap.getHeight() <= MAX_BITMAP_SIZE) {
            return g.a(context, bitmap, hmsScanAnalyzerOptions);
        }
        if (bitmap != null) {
            a.d("ScanUtil", "input image is too large:" + bitmap.getWidth());
        }
        return new HmsScan[0];
    }

    public static HmsScan[] detectForHmsDector(Context context, MLFrame mLFrame, HmsScanAnalyzerOptions hmsScanAnalyzerOptions) {
        return b.a(context, mLFrame, hmsScanAnalyzerOptions);
    }

    private static Bitmap getBitmapFromUri(Context context, Uri uri, BitmapFactory.Options options) {
        if (uri == null) {
            a.a("ScanBitmap", "uri == null");
            return null;
        }
        try {
            ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(uri, "r");
            Bitmap decodeFileDescriptor = BitmapFactory.decodeFileDescriptor(openFileDescriptor.getFileDescriptor(), null, options);
            openFileDescriptor.close();
            return decodeFileDescriptor;
        } catch (FileNotFoundException unused) {
            a.b("exception", "FileNotFoundException");
            return null;
        } catch (IOException unused2) {
            a.b("exception", "IOException");
            return null;
        } catch (Exception unused3) {
            a.b("exception", "Exception");
            return null;
        }
    }

    public static boolean isScanAvailable(Context context) {
        return true;
    }

    static Bundle queryDeepLinkInfo(Context context, Bundle bundle) {
        return g.a(context, bundle);
    }

    public static boolean selfPermissionGranted(Context context, int i10, String str) {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        if (i10 >= 23) {
            if (b.a(str) == null || context.checkSelfPermission(str) == 0) {
                return true;
            }
        } else if (b.a(context, str) == 0) {
            return true;
        }
        return false;
    }

    public static int startScan(Activity activity, int i10, HmsScanAnalyzerOptions hmsScanAnalyzerOptions) {
        int i11;
        try {
            i11 = activity.getPackageManager().getPackageInfo(activity.getPackageName(), 0).applicationInfo.targetSdkVersion;
        } catch (PackageManager.NameNotFoundException unused) {
            a.b("exception", "NameNotFoundException");
            i11 = 28;
        }
        if (!selfPermissionGranted(activity, i11, "android.permission.CAMERA")) {
            return 1;
        }
        Intent intent = new Intent(activity, ScanKitActivity.class);
        if (hmsScanAnalyzerOptions != null) {
            intent.putExtra(HmsScanBase.SCAN_FORMAT_FLAG, hmsScanAnalyzerOptions.mode);
        }
        activity.startActivityForResult(intent, i10);
        return 0;
    }
}
