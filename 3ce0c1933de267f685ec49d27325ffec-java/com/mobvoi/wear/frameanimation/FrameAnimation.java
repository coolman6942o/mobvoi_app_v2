package com.mobvoi.wear.frameanimation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Message;
import android.util.Log;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import com.mobvoi.android.common.utils.s;
import com.mobvoi.wear.frameanimation.drawer.BitmapDrawer;
import com.mobvoi.wear.frameanimation.drawer.SurfaceViewBitmapDrawer;
import com.mobvoi.wear.frameanimation.drawer.TextureBitmapDrawer;
import com.mobvoi.wear.frameanimation.io.BitmapPool;
import com.mobvoi.wear.frameanimation.io.BitmapPoolImpl;
import com.mobvoi.wear.frameanimation.repeatmode.RepeatInfinite;
import com.mobvoi.wear.frameanimation.repeatmode.RepeatOnce;
import com.mobvoi.wear.frameanimation.repeatmode.RepeatReverse;
import com.mobvoi.wear.frameanimation.repeatmode.RepeatReverseInfinite;
import com.mobvoi.wear.frameanimation.repeatmode.RepeatStrategy;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.f;
import kotlin.jvm.internal.i;
import so.a;
import vo.d;
/* compiled from: FrameAnimation.kt */
/* loaded from: classes2.dex */
public final class FrameAnimation implements AnimationController, s.a {
    private static final int PATH_FILE = 0;
    private final Matrix.ScaleToFit[] MATRIX_SCALE_ARRAY;
    private final int MSG_ANIMATION_START;
    private final int MSG_STOP;
    private final String TAG;
    private FrameAnimationListener animationListener;
    private int drawIndex;
    private Thread drawThread;
    private int frameInterval;
    private boolean freezeLastFrame;
    private volatile boolean isPlaying;
    private Boolean isTextureViewMode;
    private int lastDstHeight;
    private int lastDstWidth;
    private ScaleType lastScaleType;
    private int lastSrcHeight;
    private int lastSrcWidth;
    private BitmapDrawer mBitmapDrawer;
    private BitmapPool mBitmapPool;
    private final Context mContext;
    private Matrix mDrawMatrix;
    private final s mHandler;
    private List<PathData> mPaths;
    private RepeatStrategy mRepeatStrategy;
    private ScaleType mScaleType;
    private SurfaceView mSurfaceView;
    private TextureView mTextureView;
    private boolean relayDraw;
    private boolean supportInBitmap;
    private volatile boolean temporaryStop;
    private AtomicInteger temporaryStopSignal;
    public static final Companion Companion = new Companion(null);
    private static final int PATH_ASSETS = 1;
    private static final int FRAMES_INFINITE = -1;

    /* compiled from: FrameAnimation.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }

        public static /* synthetic */ void getFRAMES_INFINITE$annotations() {
        }

        public static /* synthetic */ void getPATH_ASSETS$annotations() {
        }

        public static /* synthetic */ void getPATH_FILE$annotations() {
        }

        public final int getFRAMES_INFINITE() {
            return FrameAnimation.FRAMES_INFINITE;
        }

        public final int getPATH_ASSETS() {
            return FrameAnimation.PATH_ASSETS;
        }

        public final int getPATH_FILE() {
            return FrameAnimation.PATH_FILE;
        }
    }

    /* compiled from: FrameAnimation.kt */
    /* loaded from: classes2.dex */
    public interface FrameAnimationListener {
        void onAnimationEnd();

        void onAnimationStart();

        void onProgress(float f10, int i10, int i11);
    }

    /* compiled from: FrameAnimation.kt */
    /* loaded from: classes2.dex */
    public static final class PathData {
        private final String path;
        private final int type;

        public PathData(String path, int i10) {
            i.f(path, "path");
            this.path = path;
            this.type = i10;
        }

        public static /* synthetic */ PathData copy$default(PathData pathData, String str, int i10, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = pathData.path;
            }
            if ((i11 & 2) != 0) {
                i10 = pathData.type;
            }
            return pathData.copy(str, i10);
        }

        public final String component1() {
            return this.path;
        }

        public final int component2() {
            return this.type;
        }

        public final PathData copy(String path, int i10) {
            i.f(path, "path");
            return new PathData(path, i10);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PathData)) {
                return false;
            }
            PathData pathData = (PathData) obj;
            return i.b(this.path, pathData.path) && this.type == pathData.type;
        }

        public final String getPath() {
            return this.path;
        }

        public final int getType() {
            return this.type;
        }

        public int hashCode() {
            return (this.path.hashCode() * 31) + this.type;
        }

        public String toString() {
            return "PathData(path=" + this.path + ", type=" + this.type + ')';
        }
    }

    /* compiled from: FrameAnimation.kt */
    /* loaded from: classes2.dex */
    public enum RepeatMode {
        ONCE,
        INFINITE,
        REVERSE_ONCE,
        REVERSE_INFINITE
    }

    /* compiled from: FrameAnimation.kt */
    /* loaded from: classes2.dex */
    public enum ScaleType {
        MATRIX(0),
        FIT_XY(1),
        FIT_START(2),
        FIT_CENTER(3),
        FIT_END(4),
        CENTER(5),
        CENTER_CROP(6),
        CENTER_INSIDE(7);
        
        private final int value;

        ScaleType(int i10) {
            this.value = i10;
        }

        public final int getValue() {
            return this.value;
        }
    }

    /* compiled from: FrameAnimation.kt */
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[RepeatMode.values().length];
            iArr[RepeatMode.INFINITE.ordinal()] = 1;
            iArr[RepeatMode.REVERSE_ONCE.ordinal()] = 2;
            iArr[RepeatMode.REVERSE_INFINITE.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ScaleType.values().length];
            iArr2[ScaleType.MATRIX.ordinal()] = 1;
            iArr2[ScaleType.CENTER.ordinal()] = 2;
            iArr2[ScaleType.CENTER_CROP.ordinal()] = 3;
            iArr2[ScaleType.CENTER_INSIDE.ordinal()] = 4;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    private FrameAnimation(TextureView textureView, SurfaceView surfaceView, Boolean bool, Context context) {
        this.mTextureView = textureView;
        this.mSurfaceView = surfaceView;
        this.isTextureViewMode = bool;
        this.mContext = context;
        this.TAG = FrameAnimation.class.getSimpleName();
        this.frameInterval = 42;
        this.mRepeatStrategy = new RepeatOnce();
        this.temporaryStopSignal = new AtomicInteger(0);
        this.MSG_STOP = 1;
        this.MSG_ANIMATION_START = 2;
        this.mHandler = new s(this);
        this.supportInBitmap = true;
        if (i.b(this.isTextureViewMode, Boolean.TRUE)) {
            TextureView textureView2 = this.mTextureView;
            i.d(textureView2);
            this.mBitmapDrawer = new TextureBitmapDrawer(textureView2);
        } else if (i.b(this.isTextureViewMode, Boolean.FALSE)) {
            SurfaceView surfaceView2 = this.mSurfaceView;
            i.d(surfaceView2);
            this.mBitmapDrawer = new SurfaceViewBitmapDrawer(surfaceView2);
        }
        this.mBitmapPool = new BitmapPoolImpl(context);
        this.MATRIX_SCALE_ARRAY = new Matrix.ScaleToFit[]{Matrix.ScaleToFit.FILL, Matrix.ScaleToFit.START, Matrix.ScaleToFit.CENTER, Matrix.ScaleToFit.END};
        this.mScaleType = ScaleType.CENTER;
        this.mDrawMatrix = new Matrix();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void configureDrawMatrix(Bitmap bitmap, View view) {
        float f10;
        float f11;
        int width = bitmap.getWidth();
        int width2 = view.getWidth();
        int height = bitmap.getHeight();
        int height2 = view.getHeight();
        ScaleType scaleType = this.lastScaleType;
        ScaleType scaleType2 = this.mScaleType;
        if (!(scaleType == scaleType2 && this.lastSrcWidth == width && width2 == this.lastDstWidth && this.lastSrcHeight == height && this.lastDstHeight == height2)) {
            this.lastSrcWidth = width;
            this.lastDstWidth = width2;
            this.lastSrcHeight = height;
            this.lastDstHeight = height2;
            this.lastScaleType = scaleType2;
            int i10 = WhenMappings.$EnumSwitchMapping$1[scaleType2.ordinal()];
            if (i10 == 1) {
                return;
            }
            if (i10 != 2) {
                float f12 = 0.0f;
                if (i10 == 3) {
                    if (height2 * width > width2 * height) {
                        f11 = height2 / height;
                        f12 = (width2 - (width * f11)) * 0.5f;
                        f10 = 0.0f;
                    } else {
                        f11 = width2 / width;
                        f10 = (height2 - (height * f11)) * 0.5f;
                    }
                    this.mDrawMatrix.setScale(f11, f11);
                    this.mDrawMatrix.postTranslate(f12, f10);
                } else if (i10 != 4) {
                    this.mDrawMatrix.setRectToRect(new RectF(0.0f, 0.0f, bitmap.getWidth(), bitmap.getHeight()), new RectF(0.0f, 0.0f, view.getWidth(), view.getHeight()), this.MATRIX_SCALE_ARRAY[this.mScaleType.getValue() - 1]);
                } else {
                    float e10 = (width > width2 || height > height2) ? d.e(width2 / width, height2 / height) : 1.0f;
                    this.mDrawMatrix.setScale(e10, e10);
                    this.mDrawMatrix.postTranslate(a.b((width2 - (width * e10)) * 0.5f), a.b((height2 - (height * e10)) * 0.5f));
                }
            } else {
                this.mDrawMatrix.setTranslate(a.b((width2 - width) * 0.5f), a.b((height2 - height) * 0.5f));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void draw() {
        this.mHandler.sendEmptyMessage(this.MSG_ANIMATION_START);
        this.drawThread = ko.a.b(true, false, null, "FA-DrawThread", 0, new FrameAnimation$draw$1(this), 22, null);
    }

    public static final int getFRAMES_INFINITE() {
        return Companion.getFRAMES_INFINITE();
    }

    public static final int getPATH_ASSETS() {
        return Companion.getPATH_ASSETS();
    }

    public static final int getPATH_FILE() {
        return Companion.getPATH_FILE();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void mayResetTemporaryStopSignal() {
        if (this.temporaryStop && this.temporaryStopSignal.decrementAndGet() == 0) {
            setTemporaryStop(false);
        }
    }

    public final void bindView(TextureView textureView) {
        i.f(textureView, "textureView");
        this.isTextureViewMode = Boolean.TRUE;
        this.mTextureView = textureView;
        this.mBitmapDrawer = new TextureBitmapDrawer(textureView);
    }

    @Override // com.mobvoi.wear.frameanimation.AnimationController
    public void freezeLastFrame(boolean z10) {
        this.freezeLastFrame = z10;
    }

    @Override // com.mobvoi.wear.frameanimation.AnimationController
    public BitmapPool getBitmapPool() {
        return this.mBitmapPool;
    }

    @Override // com.mobvoi.wear.frameanimation.AnimationController
    public int getFrameInterval() {
        return this.frameInterval;
    }

    public final List<PathData> getMPaths() {
        return this.mPaths;
    }

    public final boolean getTemporaryStop() {
        return this.temporaryStop;
    }

    @Override // com.mobvoi.android.common.utils.s.a
    public void handleMessage(Message message) {
        FrameAnimationListener frameAnimationListener;
        Integer valueOf = message == null ? null : Integer.valueOf(message.what);
        int i10 = this.MSG_STOP;
        if (valueOf != null && valueOf.intValue() == i10) {
            stopAnimation();
            return;
        }
        int i11 = this.MSG_ANIMATION_START;
        if (valueOf != null && valueOf.intValue() == i11 && (frameAnimationListener = this.animationListener) != null) {
            frameAnimationListener.onAnimationStart();
        }
    }

    @Override // com.mobvoi.wear.frameanimation.AnimationController
    public boolean isPlaying() {
        return this.isPlaying;
    }

    @Override // com.mobvoi.wear.frameanimation.AnimationController
    public void playAnimation(List<PathData> paths) {
        i.f(paths, "paths");
        playAnimation(paths, 0);
    }

    @Override // com.mobvoi.wear.frameanimation.AnimationController
    public void playAnimationFromAssets(String assetsPath) {
        i.f(assetsPath, "assetsPath");
        playAnimationFromAssets(assetsPath, 0);
    }

    @Override // com.mobvoi.wear.frameanimation.AnimationController
    public void playAnimationFromFile(String filePath) {
        i.f(filePath, "filePath");
        playAnimationFromFile(filePath, 0);
    }

    @Override // com.mobvoi.wear.frameanimation.AnimationController
    public void release() {
        stopAnimationSafely();
        this.mBitmapPool.release();
    }

    @Override // com.mobvoi.wear.frameanimation.AnimationController
    public void setAnimationListener(FrameAnimationListener listener) {
        i.f(listener, "listener");
        this.animationListener = listener;
    }

    @Override // com.mobvoi.wear.frameanimation.AnimationController
    public void setBitmapPool(BitmapPool bitmapPool) {
        i.f(bitmapPool, "bitmapPool");
        this.mBitmapPool = bitmapPool;
    }

    @Override // com.mobvoi.wear.frameanimation.AnimationController
    public void setFrameInterval(int i10) {
        this.frameInterval = d.c(i10, 0);
    }

    @Override // com.mobvoi.wear.frameanimation.AnimationController
    public void setRepeatMode(RepeatMode repeatMode) {
        RepeatStrategy repeatStrategy;
        i.f(repeatMode, "repeatMode");
        int i10 = WhenMappings.$EnumSwitchMapping$0[repeatMode.ordinal()];
        if (i10 == 1) {
            repeatStrategy = new RepeatInfinite();
        } else if (i10 == 2) {
            repeatStrategy = new RepeatReverse();
        } else if (i10 != 3) {
            repeatStrategy = new RepeatOnce();
        } else {
            repeatStrategy = new RepeatReverseInfinite();
        }
        this.mRepeatStrategy = repeatStrategy;
        repeatStrategy.setPaths(new ArrayList());
    }

    @Override // com.mobvoi.wear.frameanimation.AnimationController
    public void setScaleType(ScaleType scaleType) {
        i.f(scaleType, "scaleType");
        this.mScaleType = scaleType;
    }

    @Override // com.mobvoi.wear.frameanimation.AnimationController
    public void setSupportInBitmap(boolean z10) {
        this.supportInBitmap = z10;
    }

    public final void setTemporaryStop(boolean z10) {
        if (z10) {
            this.temporaryStopSignal.set(2);
        }
        this.temporaryStop = z10;
    }

    @Override // com.mobvoi.wear.frameanimation.AnimationController
    public int stopAnimation() {
        return stopAnimation(false);
    }

    @Override // com.mobvoi.wear.frameanimation.AnimationController
    public int stopAnimationSafely() {
        return stopAnimation(true);
    }

    @Override // com.mobvoi.wear.frameanimation.AnimationController
    public boolean supportInBitmap() {
        return this.supportInBitmap;
    }

    private final int stopAnimation(boolean z10) {
        FrameAnimationListener frameAnimationListener;
        Thread thread;
        if (!this.isPlaying) {
            return 0;
        }
        this.isPlaying = false;
        Thread thread2 = this.drawThread;
        if (thread2 != null) {
            thread2.interrupt();
        }
        this.mBitmapPool.stop();
        if (z10 && (thread = this.drawThread) != null) {
            thread.join();
        }
        this.mPaths = null;
        this.mRepeatStrategy.clear();
        if (!this.temporaryStop && (frameAnimationListener = this.animationListener) != null) {
            frameAnimationListener.onAnimationEnd();
        }
        mayResetTemporaryStopSignal();
        return this.drawIndex;
    }

    @Override // com.mobvoi.wear.frameanimation.AnimationController
    public boolean freezeLastFrame() {
        return this.freezeLastFrame;
    }

    @Override // com.mobvoi.wear.frameanimation.AnimationController
    public void playAnimation(List<PathData> paths, int i10) {
        i.f(paths, "paths");
        if (paths.isEmpty()) {
            Log.e(this.TAG, "path is null or empty");
            return;
        }
        if (this.mSurfaceView == null) {
            Objects.requireNonNull(this.mTextureView, "TextureView and SurfaceView is null");
        }
        this.mPaths = paths;
        this.drawIndex = i10;
        this.mRepeatStrategy.setPaths(paths);
        this.mBitmapPool.start(this.mRepeatStrategy, i10);
        if (!this.isPlaying) {
            this.isPlaying = true;
            Thread thread = this.drawThread;
            boolean z10 = false;
            if (thread != null && thread.isAlive()) {
                z10 = true;
            }
            if (z10) {
                this.relayDraw = true;
            } else {
                draw();
            }
        }
    }

    @Override // com.mobvoi.wear.frameanimation.AnimationController
    public void playAnimationFromAssets(String assetsPath, int i10) {
        i.f(assetsPath, "assetsPath");
        playAnimation(FrameAnimationUtil.getPathList(this.mContext, assetsPath), i10);
    }

    @Override // com.mobvoi.wear.frameanimation.AnimationController
    public void playAnimationFromFile(String filePath, int i10) {
        i.f(filePath, "filePath");
        playAnimation(FrameAnimationUtil.getPathList(new File(filePath)), i10);
    }

    @Override // com.mobvoi.wear.frameanimation.AnimationController
    public void setScaleType(Matrix matrix) {
        i.f(matrix, "matrix");
        this.mScaleType = ScaleType.MATRIX;
        this.mDrawMatrix = matrix;
    }

    public final void bindView(SurfaceView surfaceView) {
        i.f(surfaceView, "surfaceView");
        this.isTextureViewMode = Boolean.FALSE;
        this.mSurfaceView = surfaceView;
        this.mBitmapDrawer = new SurfaceViewBitmapDrawer(surfaceView);
    }

    @Override // com.mobvoi.wear.frameanimation.AnimationController
    public void setRepeatMode(RepeatStrategy repeatStrategy) {
        i.f(repeatStrategy, "repeatStrategy");
        this.mRepeatStrategy = repeatStrategy;
        repeatStrategy.setPaths(new ArrayList());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public FrameAnimation(SurfaceView surfaceView) {
        this(null, surfaceView, r0, r1);
        i.f(surfaceView, "surfaceView");
        Boolean bool = Boolean.FALSE;
        Context context = surfaceView.getContext();
        i.e(context, "surfaceView.context");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public FrameAnimation(TextureView textureView) {
        this(textureView, null, r0, r1);
        i.f(textureView, "textureView");
        Boolean bool = Boolean.TRUE;
        Context context = textureView.getContext();
        i.e(context, "textureView.context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FrameAnimation(Context context) {
        this(null, null, null, context);
        i.f(context, "context");
    }
}
