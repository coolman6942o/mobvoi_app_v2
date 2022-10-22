package com.mobvoi.companion;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.d;
import com.mobvoi.companion.view.crop.CropImageView;
import gc.e;
import java.io.File;
import java.io.IOException;
import kotlin.jvm.internal.i;
/* compiled from: CropImageActivity.kt */
/* loaded from: classes2.dex */
public final class CropImageActivity extends d implements CropImageView.f, CropImageView.b {
    private Uri cropImageInputUri;
    private CropImageView cropImageView;
    private TextView tvCancelCrop;
    private TextView tvConfirmCrop;
    private ImageView tvRotateImage;

    private final Uri getOutputUri() {
        try {
            return Uri.fromFile(File.createTempFile("cropped", ".jpg", getCacheDir()));
        } catch (IOException unused) {
            return Uri.EMPTY;
        }
    }

    private final Intent getResultIntent(Uri uri) {
        Intent intent = new Intent();
        intent.putExtra(MobvoiCropParams.EXTRA_CROP_OUTPUT_URI, uri);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreate$lambda-0  reason: not valid java name */
    public static final void m0onCreate$lambda0(CropImageActivity this$0, View view) {
        i.f(this$0, "this$0");
        CropImageView cropImageView = this$0.cropImageView;
        if (cropImageView != null) {
            cropImageView.m(this$0.getOutputUri());
        } else {
            i.u("cropImageView");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreate$lambda-1  reason: not valid java name */
    public static final void m1onCreate$lambda1(CropImageActivity this$0, View view) {
        i.f(this$0, "this$0");
        this$0.finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCreate$lambda-2  reason: not valid java name */
    public static final void m2onCreate$lambda2(CropImageActivity this$0, View view) {
        i.f(this$0, "this$0");
        CropImageView cropImageView = this$0.cropImageView;
        if (cropImageView != null) {
            cropImageView.l(-90);
        } else {
            i.u("cropImageView");
            throw null;
        }
    }

    private final void setResult(Uri uri, Exception exc) {
        setResult(exc == null ? -1 : 0, getResultIntent(uri));
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(e.f27355b);
        View findViewById = findViewById(gc.d.f27337h);
        i.e(findViewById, "findViewById(R.id.cropImageView)");
        this.cropImageView = (CropImageView) findViewById;
        View findViewById2 = findViewById(gc.d.f27352w);
        i.e(findViewById2, "findViewById(R.id.tvConfirmCrop)");
        this.tvConfirmCrop = (TextView) findViewById2;
        View findViewById3 = findViewById(gc.d.f27351v);
        i.e(findViewById3, "findViewById(R.id.tvCancelCrop)");
        this.tvCancelCrop = (TextView) findViewById3;
        View findViewById4 = findViewById(gc.d.f27353x);
        i.e(findViewById4, "findViewById(R.id.tvRotateImage)");
        this.tvRotateImage = (ImageView) findViewById4;
        Uri uri = (Uri) getIntent().getParcelableExtra(MobvoiCropParams.EXTRA_CROP_INPUT_URI);
        this.cropImageInputUri = uri;
        if (uri != null) {
            CropImageView cropImageView = this.cropImageView;
            if (cropImageView != null) {
                cropImageView.setImageUriAsync(uri);
            } else {
                i.u("cropImageView");
                throw null;
            }
        }
        TextView textView = this.tvConfirmCrop;
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.companion.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CropImageActivity.m0onCreate$lambda0(CropImageActivity.this, view);
                }
            });
            TextView textView2 = this.tvCancelCrop;
            if (textView2 != null) {
                textView2.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.companion.a
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        CropImageActivity.m1onCreate$lambda1(CropImageActivity.this, view);
                    }
                });
                ImageView imageView = this.tvRotateImage;
                if (imageView != null) {
                    imageView.setOnClickListener(new View.OnClickListener() { // from class: com.mobvoi.companion.b
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            CropImageActivity.m2onCreate$lambda2(CropImageActivity.this, view);
                        }
                    });
                } else {
                    i.u("tvRotateImage");
                    throw null;
                }
            } else {
                i.u("tvCancelCrop");
                throw null;
            }
        } else {
            i.u("tvConfirmCrop");
            throw null;
        }
    }

    @Override // com.mobvoi.companion.view.crop.CropImageView.b
    public void onCropImageComplete(CropImageView view, CropImageView.a aVar) {
        i.f(view, "view");
        if (aVar != null) {
            setResult(aVar.b(), aVar.a());
        }
    }

    @Override // com.mobvoi.companion.view.crop.CropImageView.f
    public void onSetImageUriComplete(CropImageView view, Uri uri, Exception exc) {
        i.f(view, "view");
        if (exc != null) {
            setResult(uri, exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onStart() {
        super.onStart();
        CropImageView cropImageView = this.cropImageView;
        if (cropImageView != null) {
            cropImageView.setOnSetImageUriCompleteListener(this);
            CropImageView cropImageView2 = this.cropImageView;
            if (cropImageView2 != null) {
                cropImageView2.setOnCropImageCompleteListener(this);
            } else {
                i.u("cropImageView");
                throw null;
            }
        } else {
            i.u("cropImageView");
            throw null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onStop() {
        super.onStop();
        CropImageView cropImageView = this.cropImageView;
        if (cropImageView != null) {
            cropImageView.setOnSetImageUriCompleteListener(null);
            CropImageView cropImageView2 = this.cropImageView;
            if (cropImageView2 != null) {
                cropImageView2.setOnCropImageCompleteListener(null);
            } else {
                i.u("cropImageView");
                throw null;
            }
        } else {
            i.u("cropImageView");
            throw null;
        }
    }
}
