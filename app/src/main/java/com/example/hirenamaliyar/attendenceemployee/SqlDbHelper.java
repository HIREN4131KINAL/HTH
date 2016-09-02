package com.example.hirenamaliyar.attendenceemployee;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqlDbHelper extends SQLiteOpenHelper {

    static String DATABASE_NAME = "Employee_Attendence";
    public static final String TABLE_NAME = "EmployeeTable";

    public static final String KEY_FullName = "name";
    public static final String KEY_Email = "email";
    public static final String KEY_WorkDept = "work_department";
    public static final String KEY_Designation = "designation";
    public static final String KEY_ContactNo = "phone_number";
    public static final String KEY_DateOfBirth = "date_of_birth";
    public static final String KEY_DateOfHire = "date_of_hire";
    public static final String KEY_Gender = "gender";
    public static final String KEY_Salary = "salary";
    public static final String KEY_Emiratsid = "emirats_id";
    public static final String KEY_PassportNo = "passport_no";
    public static final String KEY_Nationality = "nationality";

    public SqlDbHelper(Context context, String databaseName,SQLiteDatabase.CursorFactory factory,
                       int version) {

        super(context, databaseName, factory, version);

    }


    @Override
    public void onCreate(SQLiteDatabase database) {


        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (id INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_FullName + " VARCHAR, " + KEY_Email + " VARCHAR, " + KEY_WorkDept + " VARCHAR," + KEY_Designation + " VARCHAR," + KEY_ContactNo + " VARCHAR," + KEY_DateOfBirth + " VARCHAR," + KEY_DateOfHire + " VARCHAR," + KEY_Gender + " VARCHAR," + KEY_Salary + " VARCHAR, " + KEY_Emiratsid + " VARCHAR, " + KEY_PassportNo + " VARCHAR, " + KEY_Nationality + " VARCHAR)";
        database.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }

}
