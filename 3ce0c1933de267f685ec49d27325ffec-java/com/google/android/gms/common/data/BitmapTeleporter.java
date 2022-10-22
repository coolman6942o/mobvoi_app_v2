package com.google.android.gms.common.data;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.util.Log;
import c6.a;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
/* loaded from: classes.dex */
public class BitmapTeleporter extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<BitmapTeleporter> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final int f8815a;

    /* renamed from: b  reason: collision with root package name */
    private ParcelFileDescriptor f8816b;

    /* renamed from: c  reason: collision with root package name */
    private final int f8817c;

    /* renamed from: d  reason: collision with root package name */
    private Bitmap f8818d = null;

    /* renamed from: e  reason: collision with root package name */
    private File f8819e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BitmapTeleporter(int i10, ParcelFileDescriptor parcelFileDescriptor, int i11) {
        this.f8815a = i10;
        this.f8816b = parcelFileDescriptor;
        this.f8817c = i11;
    }

    private static void G0(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException e10) {
            Log.w("BitmapTeleporter", "Could not close stream", e10);
        }
    }

    private final FileOutputStream H0() {
        File file = this.f8819e;
        if (file != null) {
            try {
                File createTempFile = File.createTempFile("teleporter", ".tmp", file);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
                    this.f8816b = ParcelFileDescriptor.open(createTempFile, 268435456);
                    createTempFile.delete();
                    return fileOutputStream;
                } catch (FileNotFoundException unused) {
                    throw new IllegalStateException("Temporary file is somehow already deleted");
                }
            } catch (IOException e10) {
                throw new IllegalStateException("Could not create temporary file", e10);
            }
        } else {
            throw new IllegalStateException("setTempDir() must be called before writing this object to a parcel");
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        if (this.f8816b == null) {
            Bitmap bitmap = this.f8818d;
            ByteBuffer allocate = ByteBuffer.allocate(bitmap.getRowBytes() * bitmap.getHeight());
            bitmap.copyPixelsToBuffer(allocate);
            byte[] array = allocate.array();
            DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(H0()));
            try {
                try {
                    dataOutputStream.writeInt(array.length);
                    dataOutputStream.writeInt(bitmap.getWidth());
                    dataOutputStream.writeInt(bitmap.getHeight());
                    dataOutputStream.writeUTF(bitmap.getConfig().toString());
                    dataOutputStream.write(array);
                } catch (IOException e10) {
                    throw new IllegalStateException("Could not write into unlinked file", e10);
                }
            } finally {
                G0(dataOutputStream);
            }
        }
        int a10 = a.a(parcel);
        a.l(parcel, 1, this.f8815a);
        a.r(parcel, 2, this.f8816b, i10 | 1, false);
        a.l(parcel, 3, this.f8817c);
        a.b(parcel, a10);
        this.f8816b = null;
    }
}
