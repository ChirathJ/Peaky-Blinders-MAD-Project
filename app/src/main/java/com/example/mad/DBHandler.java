package com.example.mad;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;


public class DBHandler extends SQLiteOpenHelper {

    private Context context;
    private static final int VERSION = 1;
    private static final String DB_NAME = "Orders";
    private static final String TABLE_NAME = "Orders";

    //Column names
    private  static final String ID = "id";
    private  static final  String ITEM_NAME = "itemName";
    private static  final String BRAND = "brand";
    private static final String CUSTOMER = "customer";
    private  static final String DESCRIPTION = "description";
    private  static final String REQ_DATE = "reqDate";




    public DBHandler(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        String TABLE_CREATE_QUERY = "CREATE TABLE "+TABLE_NAME+" "+
                "("
                +ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                +ITEM_NAME+" TEXT,"
                +BRAND+" TEXT,"
                +CUSTOMER+" TEXT,"
                +DESCRIPTION+" TEXT,"
                +REQ_DATE+" TEXT"+
                ");";

        db.execSQL(TABLE_CREATE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String DROP_TABLE_QUERY = "DROP TABLE IF EXISTS "+ TABLE_NAME;
        //Drop older table if existed
        db.execSQL(DROP_TABLE_QUERY);
        // create table again
        onCreate(db);

    }


    public void addOrders(OrdersModelClass ordersModelClass){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(ITEM_NAME,ordersModelClass.getItemName());
        contentValues.put(BRAND,ordersModelClass.getBrand());
        contentValues.put(CUSTOMER,ordersModelClass.getCustomer());
        contentValues.put(DESCRIPTION,ordersModelClass.getDescription());
        contentValues.put(REQ_DATE,ordersModelClass.getReqDate());

        //save to table
        long result =  sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        if (result==-1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Added Successfully!", Toast.LENGTH_SHORT).show();
        }


    }


    /*public List<OrdersModelClass> getAllOrders(){

        List<OrdersModelClass> orders = new ArrayList();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM "+TABLE_NAME;

        Cursor cursor = db.rawQuery(query,null);

        if(cursor.moveToFirst()){
            do{
                // Create new Order object
                OrdersModelClass order = new OrdersModelClass();

                order.setOrderId(cursor.getInt(0));
                order.setItemName(cursor.getString(1));
                order.setBrand(cursor.getString(2));
                order.setCustomer(cursor.getString(3));
                order.setDescription(cursor.getString(4));
                order.setReqDate(cursor.getString(5));

                //we  use cursor object to get values from the database
                orders.add(order);

            }while (cursor.moveToFirst());

        }

        return orders;

    }*/

    Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    void updateData(String row_id, String name, String brand, String customer, String description, String reqDate){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(ITEM_NAME,name);
        contentValues.put(BRAND,brand);
        contentValues.put(CUSTOMER,customer);
        contentValues.put(DESCRIPTION,description);
        contentValues.put(REQ_DATE,reqDate);

        long result = db.update(TABLE_NAME, contentValues, "id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Updated Successfully!", Toast.LENGTH_SHORT).show();
        }
    }


    void deleteOneRow(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, "id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Failed to Delete.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Successfully Deleted.", Toast.LENGTH_SHORT).show();
        }
    }




}