package com.theartofdev.edmodo.cropper;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.app.d;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;
import java.io.File;
import java.io.IOException;
import zm.a;
import zm.b;
import zm.c;
/* loaded from: classes2.dex */
public class CropImageActivity extends d implements CropImageView.g, CropImageView.c {

    /* renamed from: a  reason: collision with root package name */
    private CropImageView f23058a;

    /* renamed from: b  reason: collision with root package name */
    private Uri f23059b;

    /* renamed from: c  reason: collision with root package name */
    private CropImageOptions f23060c;

    private void L(Menu menu, int i10, int i11) {
        Drawable icon;
        MenuItem findItem = menu.findItem(i10);
        if (findItem != null && (icon = findItem.getIcon()) != null) {
            try {
                icon.mutate();
                icon.setColorFilter(i11, PorterDuff.Mode.SRC_ATOP);
                findItem.setIcon(icon);
            } catch (Exception e10) {
                Log.w("AIC", "Failed to update menu item color", e10);
            }
        }
    }

    protected void G() {
        if (this.f23060c.L) {
            J(null, null, 1);
            return;
        }
        Uri outputUri = getOutputUri();
        CropImageView cropImageView = this.f23058a;
        CropImageOptions cropImageOptions = this.f23060c;
        cropImageView.p(outputUri, cropImageOptions.G, cropImageOptions.H, cropImageOptions.I, cropImageOptions.J, cropImageOptions.K);
    }

    protected Intent H(Uri uri, Exception exc, int i10) {
        CropImage.ActivityResult activityResult = new CropImage.ActivityResult(this.f23058a.getImageUri(), uri, exc, this.f23058a.getCropPoints(), this.f23058a.getCropRect(), this.f23058a.getRotatedDegrees(), this.f23058a.getWholeImageRect(), i10);
        Intent intent = new Intent();
        intent.putExtras(getIntent());
        intent.putExtra("CROP_IMAGE_EXTRA_RESULT", activityResult);
        return intent;
    }

    protected void I(int i10) {
        this.f23058a.o(i10);
    }

    protected void J(Uri uri, Exception exc, int i10) {
        setResult(exc == null ? -1 : 204, H(uri, exc, i10));
        finish();
    }

    protected void K() {
        setResult(0);
        finish();
    }

    protected Uri getOutputUri() {
        Uri uri = this.f23060c.F;
        if (uri != null && !uri.equals(Uri.EMPTY)) {
            return uri;
        }
        try {
            Bitmap.CompressFormat compressFormat = this.f23060c.G;
            return Uri.fromFile(File.createTempFile("cropped", compressFormat == Bitmap.CompressFormat.JPEG ? ".jpg" : compressFormat == Bitmap.CompressFormat.PNG ? ".png" : ".webp", getCacheDir()));
        } catch (IOException e10) {
            throw new RuntimeException("Failed to create temp file for output image", e10);
        }
    }

    @Override // com.theartofdev.edmodo.cropper.CropImageView.g
    public void o(CropImageView cropImageView, Uri uri, Exception exc) {
        if (exc == null) {
            Rect rect = this.f23060c.M;
            if (rect != null) {
                this.f23058a.setCropRect(rect);
            }
            int i10 = this.f23060c.N;
            if (i10 > -1) {
                this.f23058a.setRotatedDegrees(i10);
                return;
            }
            return;
        }
        J(null, exc, 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.f, androidx.activity.ComponentActivity, android.app.Activity
    @SuppressLint({"NewApi"})
    public void onActivityResult(int i10, int i11, Intent intent) {
        if (i10 == 200) {
            if (i11 == 0) {
                K();
            }
            if (i11 == -1) {
                Uri h10 = CropImage.h(this, intent);
                this.f23059b = h10;
                if (CropImage.k(this, h10)) {
                    requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 201);
                } else {
                    this.f23058a.setImageUriAsync(this.f23059b);
                }
            }
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        super.onBackPressed();
        K();
    }

    @Override // androidx.fragment.app.f, androidx.activity.ComponentActivity, androidx.core.app.f, android.app.Activity
    @SuppressLint({"NewApi"})
    public void onCreate(Bundle bundle) {
        CharSequence charSequence;
        super.onCreate(bundle);
        setContentView(b.a_res_0x7f0e007b);
        this.f23058a = (CropImageView) findViewById(a.f37636d);
        Bundle bundleExtra = getIntent().getBundleExtra("CROP_IMAGE_EXTRA_BUNDLE");
        this.f23059b = (Uri) bundleExtra.getParcelable("CROP_IMAGE_EXTRA_SOURCE");
        this.f23060c = (CropImageOptions) bundleExtra.getParcelable("CROP_IMAGE_EXTRA_OPTIONS");
        if (bundle == null) {
            Uri uri = this.f23059b;
            if (uri == null || uri.equals(Uri.EMPTY)) {
                if (CropImage.j(this)) {
                    requestPermissions(new String[]{"android.permission.CAMERA"}, 2011);
                } else {
                    CropImage.m(this);
                }
            } else if (CropImage.k(this, this.f23059b)) {
                requestPermissions(new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 201);
            } else {
                this.f23058a.setImageUriAsync(this.f23059b);
            }
        }
        androidx.appcompat.app.a supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            CropImageOptions cropImageOptions = this.f23060c;
            supportActionBar.z((cropImageOptions == null || (charSequence = cropImageOptions.D) == null || charSequence.length() <= 0) ? getResources().getString(zm.d.b_res_0x7f1402bf) : this.f23060c.D);
            supportActionBar.t(true);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(c.a_res_0x7f0f0003, menu);
        CropImageOptions cropImageOptions = this.f23060c;
        if (!cropImageOptions.O) {
            menu.removeItem(a.i_res_0x7f0b01d2);
            menu.removeItem(a.j_res_0x7f0b01d3);
        } else if (cropImageOptions.Q) {
            menu.findItem(a.i_res_0x7f0b01d2).setVisible(true);
        }
        if (!this.f23060c.P) {
            menu.removeItem(a.f_res_0x7f0b01cf);
        }
        if (this.f23060c.U != null) {
            menu.findItem(a.e_res_0x7f0b01ce).setTitle(this.f23060c.U);
        }
        Drawable drawable = null;
        try {
            int i10 = this.f23060c.V;
            if (i10 != 0) {
                drawable = androidx.core.content.b.e(this, i10);
                menu.findItem(a.e_res_0x7f0b01ce).setIcon(drawable);
            }
        } catch (Exception e10) {
            Log.w("AIC", "Failed to read menu crop drawable", e10);
        }
        int i11 = this.f23060c.E;
        if (i11 != 0) {
            L(menu, a.i_res_0x7f0b01d2, i11);
            L(menu, a.j_res_0x7f0b01d3, this.f23060c.E);
            L(menu, a.f_res_0x7f0b01cf, this.f23060c.E);
            if (drawable != null) {
                L(menu, a.e_res_0x7f0b01ce, this.f23060c.E);
            }
        }
        return true;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == a.e_res_0x7f0b01ce) {
            G();
            return true;
        } else if (menuItem.getItemId() == a.i_res_0x7f0b01d2) {
            I(-this.f23060c.R);
            return true;
        } else if (menuItem.getItemId() == a.j_res_0x7f0b01d3) {
            I(this.f23060c.R);
            return true;
        } else if (menuItem.getItemId() == a.g_res_0x7f0b01d0) {
            this.f23058a.f();
            return true;
        } else if (menuItem.getItemId() == a.h_res_0x7f0b01d1) {
            this.f23058a.g();
            return true;
        } else if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            K();
            return true;
        }
    }

    @Override // androidx.fragment.app.f, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int i10, String[] strArr, int[] iArr) {
        if (i10 == 201) {
            Uri uri = this.f23059b;
            if (uri == null || iArr.length <= 0 || iArr[0] != 0) {
                Toast.makeText(this, zm.d.a_res_0x7f1402be, 1).show();
                K();
            } else {
                this.f23058a.setImageUriAsync(uri);
            }
        }
        if (i10 == 2011) {
            CropImage.m(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onStart() {
        super.onStart();
        this.f23058a.setOnSetImageUriCompleteListener(this);
        this.f23058a.setOnCropImageCompleteListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.d, androidx.fragment.app.f, android.app.Activity
    public void onStop() {
        super.onStop();
        this.f23058a.setOnSetImageUriCompleteListener(null);
        this.f23058a.setOnCropImageCompleteListener(null);
    }

    @Override // com.theartofdev.edmodo.cropper.CropImageView.c
    public void q(CropImageView cropImageView, CropImageView.b bVar) {
        J(bVar.g(), bVar.c(), bVar.f());
    }
}
