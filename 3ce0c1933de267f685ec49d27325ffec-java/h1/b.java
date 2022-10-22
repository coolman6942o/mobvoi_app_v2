package h1;

import android.database.Cursor;
import android.database.MatrixCursor;
import android.os.Build;
import android.util.Log;
import java.util.Arrays;
/* compiled from: CursorUtil.java */
/* loaded from: classes.dex */
public class b {
    public static Cursor a(Cursor cursor) {
        try {
            MatrixCursor matrixCursor = new MatrixCursor(cursor.getColumnNames(), cursor.getCount());
            while (cursor.moveToNext()) {
                Object[] objArr = new Object[cursor.getColumnCount()];
                for (int i10 = 0; i10 < cursor.getColumnCount(); i10++) {
                    int type = cursor.getType(i10);
                    if (type == 0) {
                        objArr[i10] = null;
                    } else if (type == 1) {
                        objArr[i10] = Long.valueOf(cursor.getLong(i10));
                    } else if (type == 2) {
                        objArr[i10] = Double.valueOf(cursor.getDouble(i10));
                    } else if (type == 3) {
                        objArr[i10] = cursor.getString(i10);
                    } else if (type == 4) {
                        objArr[i10] = cursor.getBlob(i10);
                    } else {
                        throw new IllegalStateException();
                    }
                }
                matrixCursor.addRow(objArr);
            }
            return matrixCursor;
        } finally {
            cursor.close();
        }
    }

    private static int b(Cursor cursor, String str) {
        if (Build.VERSION.SDK_INT <= 25 && str.length() != 0) {
            return c(cursor.getColumnNames(), str);
        }
        return -1;
    }

    static int c(String[] strArr, String str) {
        String str2 = "." + str;
        String str3 = "." + str + "`";
        for (int i10 = 0; i10 < strArr.length; i10++) {
            String str4 = strArr[i10];
            if (str4.length() >= str.length() + 2) {
                if (str4.endsWith(str2)) {
                    return i10;
                }
                if (str4.charAt(0) == '`' && str4.endsWith(str3)) {
                    return i10;
                }
            }
        }
        return -1;
    }

    public static int d(Cursor cursor, String str) {
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex >= 0) {
            return columnIndex;
        }
        int columnIndex2 = cursor.getColumnIndex("`" + str + "`");
        return columnIndex2 >= 0 ? columnIndex2 : b(cursor, str);
    }

    public static int e(Cursor cursor, String str) {
        String str2;
        int d10 = d(cursor, str);
        if (d10 >= 0) {
            return d10;
        }
        try {
            str2 = Arrays.toString(cursor.getColumnNames());
        } catch (Exception e10) {
            Log.d("RoomCursorUtil", "Cannot collect column names for debug purposes", e10);
            str2 = "";
        }
        throw new IllegalArgumentException("column '" + str + "' does not exist. Available columns: " + str2);
    }
}
