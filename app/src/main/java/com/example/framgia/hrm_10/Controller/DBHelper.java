package com.example.framgia.hrm_10.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.framgia.hrm_10.Model.Staff;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by framgia on 02/06/2016.
 */
public class DBHelper extends SQLiteOpenHelper {
    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "contactsManager";

    // Contacts table name
    private static final String TABLE_CONTACTS = "contacts";
    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_PLACE_OF_BIRTH ="placeofbirth";
    private static final String KEY_BIRTHDAY = "birthyday";
    private static final String KEY_PHONE = "phone";
    private static final String KEY_POSITION_IN_COMPANY = "positionincompany";
    private static final String KEY_STATUS = "status";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        createContacts(db);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

        // Create tables again
        onCreate(db);
    }
    private void createContacts(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT," + KEY_PLACE_OF_BIRTH +" TEXT,"
                + KEY_BIRTHDAY +" TEXT," + KEY_PHONE +" TEXT,"+ KEY_POSITION_IN_COMPANY +" TEXT,"
                + KEY_STATUS + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }
    /**
    * All CRUD(Create, Read, Update, Delete) Operations
    */
    // Adding new contact
    public void addContact(Staff contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.getName());
        values.put(KEY_PLACE_OF_BIRTH,contact.getPlace_of_birth());
        values.put(KEY_BIRTHDAY,contact.getBirthday());
        values.put(KEY_PHONE, contact.getPhone());
        values.put(KEY_POSITION_IN_COMPANY, contact.getPosition_in_company());
        values.put(KEY_STATUS, contact.getStatus());

        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values);
        db.close(); // Closing database connection
    }
    // Getting single contact
    public Staff getContact(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CONTACTS, new String[] { KEY_ID,
                        KEY_NAME,KEY_PLACE_OF_BIRTH,KEY_BIRTHDAY, KEY_PHONE,
                KEY_POSITION_IN_COMPANY,KEY_STATUS }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Staff contact = new Staff(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2),cursor.getString(3),
                cursor.getString(4),cursor.getString(5),cursor.getColumnName(6));
        // return contact
        return contact;
    }
    // Getting All Contacts
    public List<Staff> getAllContacts() {
        List<Staff> contactList = new ArrayList<Staff>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Staff contact = new Staff();
                contact.setId(Integer.parseInt(cursor.getString(0)));
                contact.setName(cursor.getString(1));
                contact.setPlace_of_birth(cursor.getString(2));
                contact.setBirthday(cursor.getString(3));
                contact.setPhone(cursor.getString(4));
                contact.setPosition_in_company(cursor.getString(5));
                contact.setStatus(cursor.getString(6));
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }
    // Updating single contact
    public int updateContact(Staff contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.getName());
        values.put(KEY_PLACE_OF_BIRTH,contact.getPlace_of_birth());
        values.put(KEY_BIRTHDAY,contact.getBirthday());
        values.put(KEY_PHONE, contact.getPhone());
        values.put(KEY_POSITION_IN_COMPANY, contact.getPosition_in_company());
        values.put(KEY_STATUS, contact.getStatus());

        // updating row
        return db.update(TABLE_CONTACTS, values, KEY_ID + " = ?",
                new String[] { String.valueOf(contact.getId()) });
    }

    // Deleting single contact
    public void deleteContact(Staff contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACTS, KEY_ID + " = ?",
                new String[] { String.valueOf(contact.getId()) });
        db.close();
    }
    // Deleting single contact
    public void deleteContact(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACTS, KEY_ID + " = ?",
                new String[] { String.valueOf(id) });
        db.close();
    }

    // Getting contacts Count
    public int getContactsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_CONTACTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        // return count
        return cursor.getCount();
    }
    public int login(String name,String pass){
        if (name.equals("admin")&&pass.equals("admin")){
            // admin
            return 1;
        }else if(name.equals("")&&pass.equals("")){
            // normal
            return 2;
        }
            // not
            return 0;
    }
}
