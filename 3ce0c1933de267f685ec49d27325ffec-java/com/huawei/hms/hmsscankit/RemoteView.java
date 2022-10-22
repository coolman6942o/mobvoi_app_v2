package com.huawei.hms.hmsscankit;

import android.app.Activity;
import android.app.Fragment;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.os.RemoteException;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.huawei.hms.feature.dynamic.DeferredLifecycleHelper;
import com.huawei.hms.feature.dynamic.LifecycleDelegate;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.feature.dynamic.OnDelegateCreatedListener;
import com.huawei.hms.hmsscankit.api.IOnErrorCallback;
import com.huawei.hms.hmsscankit.api.IOnLightCallback;
import com.huawei.hms.hmsscankit.api.IOnResultCallback;
import com.huawei.hms.hmsscankit.api.IRemoteCreator;
import com.huawei.hms.hmsscankit.api.IRemoteViewDelegate;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanAnalyzerOptions;
import com.huawei.hms.scankit.p._a;
import com.mobvoi.wear.info.IntentInfo;
/* loaded from: classes2.dex */
public class RemoteView extends FrameLayout {
    public static final int REQUEST_CODE_PHOTO = 4371;
    private static final String TAG = "ScanKitRemoteView";
    private Context mContext;
    private a mRemoteHelper;
    private boolean mContinuouslyScan = true;
    private boolean mReturnedBitmap = false;
    private boolean flagForGallery = false;

    /* loaded from: classes2.dex */
    public static class Builder {
        Activity mContext;
        HmsScanAnalyzerOptions mFormat;
        Rect mRect;
        boolean mIsCustomed = true;
        boolean mContinuouslyScan = true;
        boolean mReturnedBitmap = false;

        public RemoteView build() {
            Activity activity = this.mContext;
            boolean z10 = this.mIsCustomed;
            HmsScanAnalyzerOptions hmsScanAnalyzerOptions = this.mFormat;
            return new RemoteView(activity, z10, hmsScanAnalyzerOptions == null ? 0 : hmsScanAnalyzerOptions.mode, this.mRect).setContinuouslyScan(this.mContinuouslyScan).enableReturnBitmap(this.mReturnedBitmap);
        }

        public Builder enableReturnBitmap() {
            this.mReturnedBitmap = true;
            return this;
        }

        public Builder setBoundingBox(Rect rect) {
            this.mRect = rect;
            return this;
        }

        public Builder setContext(Activity activity) {
            this.mContext = activity;
            return this;
        }

        public Builder setContinuouslyScan(boolean z10) {
            this.mContinuouslyScan = z10;
            return this;
        }

        public Builder setFormat(int i10, int... iArr) {
            this.mFormat = new HmsScanAnalyzerOptions.Creator().setHmsScanTypes(i10, iArr).create();
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends DeferredLifecycleHelper<b> {

        /* renamed from: f  reason: collision with root package name */
        private ViewGroup f13976f;

        /* renamed from: g  reason: collision with root package name */
        private Activity f13977g;

        /* renamed from: h  reason: collision with root package name */
        private OnDelegateCreatedListener<b> f13978h;

        /* renamed from: i  reason: collision with root package name */
        private IRemoteViewDelegate f13979i;

        /* renamed from: j  reason: collision with root package name */
        private IOnResultCallback f13980j = null;

        /* renamed from: k  reason: collision with root package name */
        private boolean f13981k;

        /* renamed from: l  reason: collision with root package name */
        private boolean f13982l;

        /* renamed from: m  reason: collision with root package name */
        private int f13983m;

        /* renamed from: n  reason: collision with root package name */
        private IOnLightCallback f13984n;

        /* renamed from: o  reason: collision with root package name */
        private Rect f13985o;

        /* renamed from: p  reason: collision with root package name */
        private Bundle f13986p;

        /* renamed from: q  reason: collision with root package name */
        private boolean f13987q;

        /* renamed from: r  reason: collision with root package name */
        private boolean f13988r;

        a(Activity activity, ViewGroup viewGroup, boolean z10, int i10, Rect rect) {
            this.f13976f = viewGroup;
            this.f13977g = activity;
            this.f13981k = z10;
            this.f13983m = i10;
            this.f13985o = rect;
        }

        @Override // com.huawei.hms.feature.dynamic.DeferredLifecycleHelper
        protected void createDelegate(OnDelegateCreatedListener<b> onDelegateCreatedListener) {
            Bundle bundle;
            IRemoteCreator c10;
            this.f13978h = onDelegateCreatedListener;
            if (onDelegateCreatedListener != null && getDelegate() == null) {
                this.f13979i = null;
                try {
                    bundle = new Bundle();
                    boolean z10 = this.f13981k;
                    if (!z10 && this.f13983m == 0 && this.f13985o == null) {
                        com.huawei.hms.scankit.util.a.c(RemoteView.TAG, "!mCustomed && mFormatValue == 0 && mRect == null");
                    } else {
                        bundle.putBoolean(DetailRect.CUSTOMED_FLAG, z10);
                        bundle.putInt(DetailRect.FORMAT_FLAG, this.f13983m);
                        Rect rect = this.f13985o;
                        if (rect != null) {
                            bundle.putParcelable(DetailRect.RECT_FLAG, rect);
                        }
                    }
                    boolean z11 = this.f13987q;
                    if (z11) {
                        bundle.putBoolean(DetailRect.SCAN_OFFSCEEN_FLAG, z11);
                    }
                    boolean z12 = this.f13982l;
                    if (z12) {
                        bundle.putBoolean(DetailRect.DEEPLINK_JUMP_FLAG, z12);
                        bundle.putAll(this.f13986p);
                    }
                    bundle.putInt(DetailRect.TYPE_TRANS, 3);
                    bundle.putBoolean(DetailRect.RETURN_BITMAP, this.f13988r);
                    bundle.putAll(_a.a(this.f13977g));
                    bundle.putBoolean(DetailRect.SCAN_NEW_UI, true);
                    c10 = j.c(this.f13977g);
                } catch (RemoteException unused) {
                    com.huawei.hms.scankit.util.a.b("exception", "RemoteException");
                }
                if (c10 != null) {
                    this.f13979i = c10.newRemoteViewDelegate(ObjectWrapper.wrap(this.f13977g), ObjectWrapper.wrap(bundle));
                    IRemoteViewDelegate iRemoteViewDelegate = this.f13979i;
                    if (iRemoteViewDelegate != null) {
                        try {
                            IOnResultCallback iOnResultCallback = this.f13980j;
                            if (iOnResultCallback != null) {
                                iRemoteViewDelegate.setOnResultCallback(iOnResultCallback);
                                this.f13979i.setOnClickListener(ObjectWrapper.wrap(new h(this)));
                            }
                            this.f13979i.setOnClickListener(ObjectWrapper.wrap(new i(this)));
                            IOnLightCallback iOnLightCallback = this.f13984n;
                            if (iOnLightCallback != null) {
                                this.f13979i.setOnLightVisbleCallBack(iOnLightCallback);
                            }
                        } catch (RemoteException unused2) {
                            com.huawei.hms.scankit.util.a.b("exception", "RemoteException");
                        }
                        this.f13978h.onDelegateCreated(new b(this.f13976f, this.f13979i));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(boolean z10) {
            this.f13982l = z10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d() {
            IRemoteViewDelegate iRemoteViewDelegate = this.f13979i;
            if (iRemoteViewDelegate != null) {
                try {
                    iRemoteViewDelegate.resumeContinuouslyScan();
                } catch (RemoteException unused) {
                    com.huawei.hms.scankit.util.a.b("exception", "RemoteException");
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean e() {
            IRemoteViewDelegate iRemoteViewDelegate = this.f13979i;
            if (iRemoteViewDelegate == null) {
                return false;
            }
            try {
                iRemoteViewDelegate.turnOffLight();
                return true;
            } catch (RemoteException unused) {
                com.huawei.hms.scankit.util.a.b("exception", "RemoteException");
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean f() {
            IRemoteViewDelegate iRemoteViewDelegate = this.f13979i;
            if (iRemoteViewDelegate == null) {
                return false;
            }
            try {
                iRemoteViewDelegate.turnOnLight();
                return true;
            } catch (RemoteException unused) {
                com.huawei.hms.scankit.util.a.b("exception", "RemoteException");
                return false;
            }
        }

        public void b(boolean z10) {
            this.f13988r = z10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean b() {
            IRemoteViewDelegate iRemoteViewDelegate = this.f13979i;
            if (iRemoteViewDelegate == null) {
                return false;
            }
            try {
                return iRemoteViewDelegate.getLightStatus();
            } catch (RemoteException unused) {
                com.huawei.hms.scankit.util.a.b("exception", "RemoteException");
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c() {
            IRemoteViewDelegate iRemoteViewDelegate = this.f13979i;
            if (iRemoteViewDelegate != null) {
                try {
                    iRemoteViewDelegate.pauseContinuouslyScan();
                } catch (RemoteException unused) {
                    com.huawei.hms.scankit.util.a.b("exception", "RemoteException");
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Bundle bundle) {
            this.f13986p = bundle;
        }

        public void a(boolean z10) {
            this.f13987q = z10;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(IOnResultCallback iOnResultCallback) {
            this.f13980j = iOnResultCallback;
            IRemoteViewDelegate iRemoteViewDelegate = this.f13979i;
            if (iRemoteViewDelegate != null) {
                try {
                    iRemoteViewDelegate.setOnResultCallback(iOnResultCallback);
                } catch (RemoteException unused) {
                    com.huawei.hms.scankit.util.a.b("exception", "RemoteException");
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(IOnErrorCallback iOnErrorCallback) {
            IRemoteViewDelegate iRemoteViewDelegate = this.f13979i;
            if (iRemoteViewDelegate != null) {
                try {
                    iRemoteViewDelegate.setOnErrorCallback(iOnErrorCallback);
                } catch (RemoteException unused) {
                    com.huawei.hms.scankit.util.a.b("exception", "RemoteException");
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(IOnLightCallback iOnLightCallback) {
            this.f13984n = iOnLightCallback;
            IRemoteViewDelegate iRemoteViewDelegate = this.f13979i;
            if (iRemoteViewDelegate != null) {
                try {
                    iRemoteViewDelegate.setOnLightVisbleCallBack(iOnLightCallback);
                } catch (RemoteException unused) {
                    com.huawei.hms.scankit.util.a.b("exception", "RemoteException");
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(int i10, int i11, Intent intent) {
            Bitmap bitmap;
            if (i11 == -1 && intent != null && i10 == 4371) {
                try {
                    String imagePath = RemoteView.getImagePath(this.f13977g, intent);
                    if (!TextUtils.isEmpty(imagePath)) {
                        if (Build.VERSION.SDK_INT <= 28 || RemoteView.this.mContext.getApplicationInfo() == null || RemoteView.this.mContext.getApplicationInfo().targetSdkVersion <= 28) {
                            com.huawei.hms.scankit.util.a.a("ScanBitmap", "compressBitmap below android 29");
                            bitmap = ScanUtil.compressBitmap(this.f13977g, imagePath);
                        } else {
                            com.huawei.hms.scankit.util.a.a("ScanBitmap", "compressBitmap above android 29");
                            bitmap = ScanUtil.compressBitmapForAndroid29(RemoteView.this.mContext, imagePath);
                        }
                        if (bitmap == null) {
                            com.huawei.hms.scankit.util.a.a("ScanBitmap", "compressBitmap above android 29");
                            bitmap = ScanUtil.compressBitmapForAndroid29(RemoteView.this.mContext, imagePath);
                        }
                        HmsScan[] decodeWithBitmap = ScanUtil.decodeWithBitmap(this.f13977g, bitmap, new HmsScanAnalyzerOptions.Creator().setPhotoMode(true).create());
                        IOnResultCallback iOnResultCallback = this.f13980j;
                        if (iOnResultCallback != null) {
                            iOnResultCallback.onResult(decodeWithBitmap);
                        }
                    }
                } catch (RemoteException unused) {
                    com.huawei.hms.scankit.util.a.b(RemoteView.TAG, "RemoteException in remoteview");
                } catch (Error unused2) {
                    com.huawei.hms.scankit.util.a.b(RemoteView.TAG, "Exception in error");
                } catch (IllegalStateException unused3) {
                    com.huawei.hms.scankit.util.a.b(RemoteView.TAG, "IllegalStateException in remoteview");
                } catch (Exception unused4) {
                    com.huawei.hms.scankit.util.a.b(RemoteView.TAG, "Exception in remoteview");
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    private static class b implements LifecycleDelegate {

        /* renamed from: a  reason: collision with root package name */
        private ViewGroup f13990a;

        /* renamed from: b  reason: collision with root package name */
        private View f13991b;

        /* renamed from: c  reason: collision with root package name */
        private IRemoteViewDelegate f13992c;

        b(ViewGroup viewGroup, IRemoteViewDelegate iRemoteViewDelegate) {
            this.f13990a = viewGroup;
            this.f13992c = iRemoteViewDelegate;
        }

        @Override // com.huawei.hms.feature.dynamic.LifecycleDelegate
        public void onCreate(Bundle bundle) {
            try {
                this.f13992c.onCreate(bundle);
                this.f13991b = (View) ObjectWrapper.unwrap(this.f13992c.getView());
                this.f13990a.removeAllViews();
                this.f13990a.addView(this.f13991b);
            } catch (RemoteException unused) {
                com.huawei.hms.scankit.util.a.b("exception", "RemoteException");
            }
        }

        @Override // com.huawei.hms.feature.dynamic.LifecycleDelegate
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            return new View(null);
        }

        @Override // com.huawei.hms.feature.dynamic.LifecycleDelegate
        public void onDestroy() {
            try {
                this.f13992c.onDestroy();
            } catch (RemoteException unused) {
                com.huawei.hms.scankit.util.a.b("exception", "RemoteException");
            }
        }

        @Override // com.huawei.hms.feature.dynamic.LifecycleDelegate
        public void onDestroyView() {
        }

        @Override // com.huawei.hms.feature.dynamic.LifecycleDelegate
        public void onInflate(Activity activity, Bundle bundle, Bundle bundle2) {
        }

        @Override // com.huawei.hms.feature.dynamic.LifecycleDelegate
        public void onLowMemory() {
        }

        @Override // com.huawei.hms.feature.dynamic.LifecycleDelegate
        public void onPause() {
            try {
                this.f13992c.onPause();
            } catch (RemoteException unused) {
                com.huawei.hms.scankit.util.a.b("exception", "RemoteException");
            }
        }

        @Override // com.huawei.hms.feature.dynamic.LifecycleDelegate
        public void onResume() {
            try {
                this.f13992c.onResume();
            } catch (RemoteException unused) {
                com.huawei.hms.scankit.util.a.b("exception", "RemoteException");
            }
        }

        @Override // com.huawei.hms.feature.dynamic.LifecycleDelegate
        public void onSaveInstanceState(Bundle bundle) {
        }

        @Override // com.huawei.hms.feature.dynamic.LifecycleDelegate
        public void onStart() {
            try {
                this.f13992c.onStart();
            } catch (RemoteException unused) {
                com.huawei.hms.scankit.util.a.b("exception", "RemoteException");
            }
        }

        @Override // com.huawei.hms.feature.dynamic.LifecycleDelegate
        public void onStop() {
            try {
                this.f13992c.onStop();
            } catch (RemoteException unused) {
                com.huawei.hms.scankit.util.a.b("exception", "RemoteException");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RemoteView(Activity activity, boolean z10, int i10, Rect rect) {
        super(activity);
        this.mContext = activity;
        this.mRemoteHelper = new a(activity, this, z10, i10, rect);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getImagePath(Context context, Intent intent) {
        Uri data = new Intent(intent).getData();
        if (Build.VERSION.SDK_INT <= 19) {
            return getImagePath(context, data, null);
        }
        if (DocumentsContract.isDocumentUri(context, data)) {
            String documentId = DocumentsContract.getDocumentId(data);
            if ("com.android.providers.media.documents".equals(data.getAuthority())) {
                String str = documentId.split(":")[1];
                return getImagePath(context, MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "_id=" + str);
            } else if (!"com.android.providers.downloads.documents".equals(data.getAuthority())) {
                return null;
            } else {
                try {
                    return getImagePath(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.parseLong(documentId)), null);
                } catch (NumberFormatException unused) {
                    com.huawei.hms.scankit.util.a.b(TAG, "NumberFormatException in withAppendedId");
                    return null;
                } catch (Exception unused2) {
                    com.huawei.hms.scankit.util.a.b(TAG, "Exception in withAppendedId");
                    return null;
                }
            }
        } else if ("content".equalsIgnoreCase(data.getScheme())) {
            return getImagePath(context, data, null);
        } else {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPhotoCode(Activity activity) {
        if (activity.checkPermission("android.permission.READ_EXTERNAL_STORAGE", Process.myPid(), Process.myUid()) == 0) {
            try {
                Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                if (com.huawei.hms.scankit.util.b.c((Context) activity)) {
                    if (com.huawei.hms.scankit.util.b.a(new Intent(), "com.android.gallery3d", activity) != null) {
                        com.huawei.hms.scankit.util.a.c(TAG, "Start Gallery:com.android.gallery3d");
                        intent.setPackage("com.android.gallery3d");
                    } else if (com.huawei.hms.scankit.util.b.a(new Intent(), "com.huawei.photos", activity) != null) {
                        intent.setPackage("com.huawei.photos");
                        com.huawei.hms.scankit.util.a.c(TAG, "Start Gallery:com.huawei.photos");
                    }
                }
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                this.flagForGallery = true;
                activity.startActivityForResult(intent, REQUEST_CODE_PHOTO);
            } catch (Exception unused) {
                com.huawei.hms.scankit.util.a.b(TAG, "startPhotoCode Exception");
            }
        } else if (Build.VERSION.SDK_INT >= 23) {
            activity.requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, REQUEST_CODE_PHOTO);
        }
    }

    RemoteView enableReturnBitmap(boolean z10) {
        this.mReturnedBitmap = z10;
        this.mRemoteHelper.b(z10);
        return this;
    }

    public boolean getLightStatus() {
        return this.mRemoteHelper.b();
    }

    public void onActivityResult(int i10, int i11, Intent intent) {
        Log.i(TAG, "onActivityResult: ");
        this.mRemoteHelper.a(i10, i11, intent);
    }

    public void onCreate(Bundle bundle) {
        Log.i(TAG, "onCreate:");
        Context context = this.mContext;
        if ((context instanceof Activity) && ((Activity) context).getWindow() != null) {
            ((Activity) this.mContext).getWindow().setFlags(IntentInfo.FLAG_RECEIVER_INCLUDE_BACKGROUND, IntentInfo.FLAG_RECEIVER_INCLUDE_BACKGROUND);
        }
        this.mRemoteHelper.onCreate(bundle);
    }

    public final void onDestroy() {
        Log.i(TAG, "onDestroy: ");
        this.mRemoteHelper.onDestroy();
    }

    public final void onPause() {
        Log.i(TAG, "onPause: ");
        this.mRemoteHelper.onPause();
        if (this.flagForGallery) {
            this.mRemoteHelper.onStop();
        }
    }

    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr, Activity activity) {
        if (i10 == 4371 && iArr.length == 1 && iArr[0] == 0) {
            startPhotoCode(activity);
        }
    }

    public final void onResume() {
        Log.i(TAG, "onResume: ");
        this.mRemoteHelper.onResume();
        this.flagForGallery = false;
    }

    public final void onStart() {
        Log.i(TAG, "onStart: ");
        this.mRemoteHelper.onStart();
        this.flagForGallery = false;
    }

    public final void onStop() {
        Log.i(TAG, "onStop: ");
        if (!this.flagForGallery) {
            this.mRemoteHelper.onStop();
        }
    }

    public void pauseContinuouslyScan() {
        this.mRemoteHelper.c();
    }

    public void resumeContinuouslyScan() {
        this.mRemoteHelper.d();
    }

    public void selectPictureFromLocalFile() {
        startPhotoCode((Activity) this.mContext);
    }

    public void selectPictureFromLocalFileFragment(Fragment fragment) {
        Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        fragment.startActivityForResult(intent, REQUEST_CODE_PHOTO);
    }

    RemoteView setContinuouslyScan(boolean z10) {
        this.mContinuouslyScan = z10;
        return this;
    }

    public void setOnErrorCallback(OnErrorCallback onErrorCallback) {
        this.mRemoteHelper.a(new c(onErrorCallback));
    }

    public void setOnLightVisibleCallback(OnLightVisibleCallBack onLightVisibleCallBack) {
        this.mRemoteHelper.a(new d(onLightVisibleCallBack));
    }

    public void setOnResultCallback(OnResultCallback onResultCallback) {
        this.mRemoteHelper.a(new e(onResultCallback, this.mContinuouslyScan));
    }

    public boolean switchLight() {
        return !getLightStatus() ? this.mRemoteHelper.f() : this.mRemoteHelper.e();
    }

    RemoteView(Activity activity, boolean z10, int i10, Rect rect, boolean z11) {
        super(activity);
        this.mContext = activity;
        a aVar = new a(activity, this, z10, i10, rect);
        this.mRemoteHelper = aVar;
        aVar.a(z11);
    }

    RemoteView(Activity activity, boolean z10, Bundle bundle) {
        super(activity);
        this.mContext = activity;
        a aVar = new a(activity, this, false, 0, null);
        this.mRemoteHelper = aVar;
        aVar.c(z10);
        this.mRemoteHelper.a(bundle);
    }

    private static String getImagePath(Context context, Uri uri, String str) {
        String str2 = null;
        try {
            Cursor query = context.getContentResolver().query(uri, new String[]{"_data"}, str, null, null);
            if (query != null) {
                if (query.moveToFirst()) {
                    str2 = query.getString(query.getColumnIndex("_data"));
                }
                query.close();
            }
            return str2;
        } catch (IllegalStateException unused) {
            com.huawei.hms.scankit.util.a.b(TAG, "IllegalStateException in getImagePath");
            return null;
        } catch (Exception unused2) {
            com.huawei.hms.scankit.util.a.b(TAG, "Exception in getImagePath");
            return null;
        }
    }
}
