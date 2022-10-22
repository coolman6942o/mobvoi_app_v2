package com.liulishuo.filedownloader.model;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes2.dex */
public class FileDownloadTaskAtom implements Parcelable {
    public static final Parcelable.Creator<FileDownloadTaskAtom> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private String f15241a;

    /* renamed from: b  reason: collision with root package name */
    private String f15242b;

    /* renamed from: c  reason: collision with root package name */
    private long f15243c;

    /* loaded from: classes2.dex */
    static class a implements Parcelable.Creator<FileDownloadTaskAtom> {
        a() {
        }

        /* renamed from: a */
        public FileDownloadTaskAtom createFromParcel(Parcel parcel) {
            return new FileDownloadTaskAtom(parcel);
        }

        /* renamed from: b */
        public FileDownloadTaskAtom[] newArray(int i10) {
            return new FileDownloadTaskAtom[i10];
        }
    }

    protected FileDownloadTaskAtom(Parcel parcel) {
        this.f15241a = parcel.readString();
        this.f15242b = parcel.readString();
        this.f15243c = parcel.readLong();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f15241a);
        parcel.writeString(this.f15242b);
        parcel.writeLong(this.f15243c);
    }
}
