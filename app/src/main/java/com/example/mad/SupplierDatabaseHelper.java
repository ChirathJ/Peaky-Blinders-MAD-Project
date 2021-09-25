package com.example.mad;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

class SupplierDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "Supplier.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "Supplier";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NAME = "supplierName";
    private static final String COLUMN_ADDRESS = "supplierAddress";
    private static final String COLUMN_EMAIL = "supplierEmail";
    private static final String COLUMN_PHONE = "supplierPhone";

    SupplierDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_ADDRESS + " TEXT, " +
                COLUMN_EMAIL + " TEXT, " +
                COLUMN_PHONE + " INTEGER);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    void addSupplier(String name, String address, String email, String phone){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NAME, name);
        cv.put(COLUMN_ADDRESS, address);
        cv.put(COLUMN_EMAIL, email);
        cv.put(COLUMN_PHONE, phone);
        long result = db.insert(TABLE_NAME,null, cv);
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    void updateData(String row_id, String name, String address, String email, int phone){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NAME, name);
        cv.put(COLUMN_ADDRESS, address);
        cv.put(COLUMN_EMAIL, email);
        cv.put(COLUMN_PHONE, phone);

        long result = db.update(TABLE_NAME, cv, "_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Updated Successfully!", Toast.LENGTH_SHORT).show();
        }
    }
    void deleteOneRow(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, "_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Failed to Delete.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Successfully Deleted.", Toast.LENGTH_SHORT).show();
        }
    }
}