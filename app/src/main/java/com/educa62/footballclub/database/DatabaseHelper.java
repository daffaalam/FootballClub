package com.educa62.footballclub.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.educa62.footballclub.model.TeamsItem;
import com.educa62.footballclub.tool.Variables;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private SQLiteDatabase sqLiteDatabase;

    public DatabaseHelper(Context context) {
        super(context, Variables.DATABASE_NAME, null, Variables.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + Variables.TABLE_NAME + " ( " +
                Variables.TAG_ID + " TEXT, " +
                Variables.TAG_NAME + " TEXT, " +
                Variables.TAG_SHORT_NAME + " TEXT, " +
                Variables.TAG_TLA + " TEXT, " +
                Variables.TAG_CREST_URL + " TEXT, " +
                Variables.TAG_ADDRESS + " TEXT, " +
                Variables.TAG_PHONE + " TEXT, " +
                Variables.TAG_WEBSITE + " TEXT, " +
                Variables.TAG_EMAIL + " TEXT, " +
                Variables.TAG_CLUB_COLORS + " TEXT, " +
                Variables.TAG_VENUE + " TEXT, " +
                Variables.TAG_LAST_UPDATE + " TEXT )"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Variables.TABLE_NAME);
        onCreate(db);
    }

    public void inputTeamsItem(TeamsItem teamsItem_) {
        sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Variables.TAG_ID, String.valueOf(teamsItem_.getId()));
        contentValues.put(Variables.TAG_NAME, String.valueOf(teamsItem_.getName()));
        contentValues.put(Variables.TAG_SHORT_NAME, String.valueOf(teamsItem_.getShortName()));
        contentValues.put(Variables.TAG_TLA, String.valueOf(teamsItem_.getTla()));
        contentValues.put(Variables.TAG_CREST_URL, String.valueOf(teamsItem_.getCrestUrl()));
        contentValues.put(Variables.TAG_ADDRESS, String.valueOf(teamsItem_.getAddress()));
        contentValues.put(Variables.TAG_PHONE, String.valueOf(teamsItem_.getPhone()));
        contentValues.put(Variables.TAG_WEBSITE, String.valueOf(teamsItem_.getWebsite()));
        contentValues.put(Variables.TAG_EMAIL, String.valueOf(teamsItem_.getEmail()));
        contentValues.put(Variables.TAG_CLUB_COLORS, String.valueOf(teamsItem_.getClubColors()));
        contentValues.put(Variables.TAG_VENUE, String.valueOf(teamsItem_.getVenue()));
        contentValues.put(Variables.TAG_LAST_UPDATE, String.valueOf(teamsItem_.getLastUpdated()));
        sqLiteDatabase.insert(Variables.TABLE_NAME, null, contentValues);
        sqLiteDatabase.close();
    }

    public List<TeamsItem> getTeamsItemList() {
        sqLiteDatabase = this.getWritableDatabase();
        List<TeamsItem> teamsItemList = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + Variables.TABLE_NAME, null);
        if (cursor.moveToFirst()) {
            do {
                TeamsItem teamsItem = new TeamsItem();
                teamsItem.setId(cursor.getInt(0));
                teamsItem.setName(cursor.getString(1));
                teamsItem.setShortName(cursor.getString(2));
                teamsItem.setTla(cursor.getString(3));
                teamsItem.setCrestUrl(cursor.getString(4));
                teamsItem.setAddress(cursor.getString(5));
                teamsItem.setPhone(cursor.getString(6));
                teamsItem.setWebsite(cursor.getString(7));
                teamsItem.setEmail(cursor.getString(8));
                teamsItem.setClubColors(cursor.getString(9));
                teamsItem.setVenue(cursor.getString(10));
                teamsItem.setLastUpdated(cursor.getString(11));
                teamsItemList.add(teamsItem);
            } while (cursor.moveToNext());
        }
        sqLiteDatabase.close();
        cursor.close();
        return teamsItemList;
    }

    public void deleteTeamsItemAll() {
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.execSQL("DELETE FROM " + Variables.TABLE_NAME);
        sqLiteDatabase.close();
    }
}
