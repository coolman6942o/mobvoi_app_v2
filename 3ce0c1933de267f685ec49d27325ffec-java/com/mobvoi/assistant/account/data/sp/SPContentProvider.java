package com.mobvoi.assistant.account.data.sp;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.mobvoi.wear.providers.HealthDataProviderContracts;
import java.util.Map;
/* loaded from: classes2.dex */
public class SPContentProvider extends ContentProvider {
    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        String[] split = uri.getPath().split("/");
        if (split[1].equals("clean")) {
            a.b(getContext());
            return 0;
        }
        String str2 = split[2];
        if (a.c(getContext(), str2)) {
            a.n(getContext(), str2);
        }
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        String[] split = uri.getPath().split("/");
        String str = split[1];
        String str2 = split[2];
        if (str.equals("contain")) {
            return a.c(getContext(), str2) + "";
        }
        return "" + a.d(getContext(), str2, str);
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        String[] split = uri.getPath().split("/");
        String str = split[1];
        String str2 = split[2];
        Object obj = contentValues.get(HealthDataProviderContracts.NAME_VALUE);
        if (obj == null) {
            return null;
        }
        a.o(getContext(), str2, obj);
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Map<String, ?> e10;
        if (!uri.getPath().split("/")[1].equals("get_all") || (e10 = a.e(getContext())) == null) {
            return null;
        }
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"cursor_name", "cursor_type", "cursor_value"});
        for (String str3 : e10.keySet()) {
            Object[] objArr = new Object[3];
            objArr[0] = str3;
            objArr[2] = e10.get(str3);
            if (objArr[2] instanceof Boolean) {
                objArr[1] = "boolean";
            } else if (objArr[2] instanceof String) {
                objArr[1] = "string";
            } else if (objArr[2] instanceof Integer) {
                objArr[1] = "int";
            } else if (objArr[2] instanceof Long) {
                objArr[1] = "long";
            } else if (objArr[2] instanceof Float) {
                objArr[1] = "float";
            }
            matrixCursor.addRow(objArr);
        }
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        insert(uri, contentValues);
        return 0;
    }
}
