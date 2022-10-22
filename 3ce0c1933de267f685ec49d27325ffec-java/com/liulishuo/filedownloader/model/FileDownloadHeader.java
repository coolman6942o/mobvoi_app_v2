package com.liulishuo.filedownloader.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes2.dex */
public class FileDownloadHeader implements Parcelable {
    public static final Parcelable.Creator<FileDownloadHeader> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private HashMap<String, List<String>> f15228a;

    /* loaded from: classes2.dex */
    static class a implements Parcelable.Creator<FileDownloadHeader> {
        a() {
        }

        /* renamed from: a */
        public FileDownloadHeader createFromParcel(Parcel parcel) {
            return new FileDownloadHeader(parcel);
        }

        /* renamed from: b */
        public FileDownloadHeader[] newArray(int i10) {
            return new FileDownloadHeader[i10];
        }
    }

    public FileDownloadHeader() {
    }

    public HashMap<String, List<String>> a() {
        return this.f15228a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return this.f15228a.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeMap(this.f15228a);
    }

    protected FileDownloadHeader(Parcel parcel) {
        this.f15228a = parcel.readHashMap(String.class.getClassLoader());
    }
}
