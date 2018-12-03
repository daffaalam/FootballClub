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
                Variables.idTeam + " TEXT, " +
                Variables.idSoccerXML + " TEXT, " +
                Variables.intLoved + " TEXT, " +
                Variables.strTeam + " TEXT, " +
                Variables.strTeamShort + " TEXT, " +
                Variables.strAlternate + " TEXT, " +
                Variables.intFormedYear + " TEXT, " +
                Variables.strSport + " TEXT, " +
                Variables.strLeague + " TEXT, " +
                Variables.idLeague + " TEXT, " +
                Variables.strDivision + " TEXT, " +
                Variables.strManager + " TEXT," +
                Variables.strStadium + " TEXT," +
                Variables.strKeywords + " TEXT," +
                Variables.strRSS + " TEXT," +
                Variables.strStadiumThumb + " TEXT," +
                Variables.strStadiumDescription + " TEXT," +
                Variables.strStadiumLocation + " TEXT," +
                Variables.intStadiumCapacity + " TEXT," +
                Variables.strWebsite + " TEXT," +
                Variables.strFacebook + " TEXT," +
                Variables.strTwitter + " TEXT," +
                Variables.strInstagram + " TEXT," +
                Variables.strDescriptionEN + " TEXT," +
                Variables.strDescriptionDE + " TEXT," +
                Variables.strDescriptionFR + " TEXT," +
                Variables.strDescriptionCN + " TEXT," +
                Variables.strDescriptionIT + " TEXT," +
                Variables.strDescriptionJP + " TEXT," +
                Variables.strDescriptionRU + " TEXT," +
                Variables.strDescriptionES + " TEXT," +
                Variables.strDescriptionPT + " TEXT," +
                Variables.strDescriptionSE + " TEXT," +
                Variables.strDescriptionNL + " TEXT," +
                Variables.strDescriptionHU + " TEXT," +
                Variables.strDescriptionNO + " TEXT," +
                Variables.strDescriptionIL + " TEXT," +
                Variables.strDescriptionPL + " TEXT," +
                Variables.strGender + " TEXT," +
                Variables.strCountry + " TEXT," +
                Variables.strTeamBadge + " TEXT," +
                Variables.strTeamJersey + " TEXT," +
                Variables.strTeamLogo + " TEXT," +
                Variables.strTeamFanart1 + " TEXT," +
                Variables.strTeamFanart2 + " TEXT," +
                Variables.strTeamFanart3 + " TEXT," +
                Variables.strTeamFanart4 + " TEXT," +
                Variables.strTeamBanner + " TEXT," +
                Variables.strYoutube + " TEXT," +
                Variables.strLocked + " TEXT " +
                " )"
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
        contentValues.put(Variables.idTeam, String.valueOf(teamsItem_.getIdTeam()));
        contentValues.put(Variables.idSoccerXML, String.valueOf(teamsItem_.getIdSoccerXML()));
        contentValues.put(Variables.intLoved, String.valueOf(teamsItem_.getIntLoved()));
        contentValues.put(Variables.strTeam, String.valueOf(teamsItem_.getStrTeam()));
        contentValues.put(Variables.strTeamShort, String.valueOf(teamsItem_.getStrTeamShort()));
        contentValues.put(Variables.strAlternate, String.valueOf(teamsItem_.getStrAlternate()));
        contentValues.put(Variables.intFormedYear, String.valueOf(teamsItem_.getIntFormedYear()));
        contentValues.put(Variables.strSport, String.valueOf(teamsItem_.getStrSport()));
        contentValues.put(Variables.strLeague, String.valueOf(teamsItem_.getStrLeague()));
        contentValues.put(Variables.idLeague, String.valueOf(teamsItem_.getIdLeague()));
        contentValues.put(Variables.strDivision, String.valueOf(teamsItem_.getStrDivision()));
        contentValues.put(Variables.strManager, String.valueOf(teamsItem_.getStrManager()));
        contentValues.put(Variables.strStadium, String.valueOf(teamsItem_.getStrStadium()));
        contentValues.put(Variables.strKeywords, String.valueOf(teamsItem_.getStrKeywords()));
        contentValues.put(Variables.strRSS, String.valueOf(teamsItem_.getStrRSS()));
        contentValues.put(Variables.strStadiumThumb, String.valueOf(teamsItem_.getStrStadiumThumb()));
        contentValues.put(Variables.strStadiumDescription, String.valueOf(teamsItem_.getStrStadiumDescription()));
        contentValues.put(Variables.strStadiumLocation, String.valueOf(teamsItem_.getStrStadiumLocation()));
        contentValues.put(Variables.intStadiumCapacity, String.valueOf(teamsItem_.getIntStadiumCapacity()));
        contentValues.put(Variables.strWebsite, String.valueOf(teamsItem_.getStrWebsite()));
        contentValues.put(Variables.strFacebook, String.valueOf(teamsItem_.getStrFacebook()));
        contentValues.put(Variables.strTwitter, String.valueOf(teamsItem_.getStrTwitter()));
        contentValues.put(Variables.strInstagram, String.valueOf(teamsItem_.getStrInstagram()));
        contentValues.put(Variables.strDescriptionEN, String.valueOf(teamsItem_.getStrDescriptionEN()));
        contentValues.put(Variables.strDescriptionDE, String.valueOf(teamsItem_.getStrDescriptionDE()));
        contentValues.put(Variables.strDescriptionFR, String.valueOf(teamsItem_.getStrDescriptionFR()));
        contentValues.put(Variables.strDescriptionCN, String.valueOf(teamsItem_.getStrDescriptionCN()));
        contentValues.put(Variables.strDescriptionIT, String.valueOf(teamsItem_.getStrDescriptionIT()));
        contentValues.put(Variables.strDescriptionJP, String.valueOf(teamsItem_.getStrDescriptionJP()));
        contentValues.put(Variables.strDescriptionRU, String.valueOf(teamsItem_.getStrDescriptionRU()));
        contentValues.put(Variables.strDescriptionES, String.valueOf(teamsItem_.getStrDescriptionES()));
        contentValues.put(Variables.strDescriptionPT, String.valueOf(teamsItem_.getStrDescriptionPT()));
        contentValues.put(Variables.strDescriptionSE, String.valueOf(teamsItem_.getStrDescriptionSE()));
        contentValues.put(Variables.strDescriptionNL, String.valueOf(teamsItem_.getStrDescriptionNL()));
        contentValues.put(Variables.strDescriptionHU, String.valueOf(teamsItem_.getStrDescriptionHU()));
        contentValues.put(Variables.strDescriptionNO, String.valueOf(teamsItem_.getStrDescriptionNO()));
        contentValues.put(Variables.strDescriptionIL, String.valueOf(teamsItem_.getStrDescriptionIL()));
        contentValues.put(Variables.strDescriptionPL, String.valueOf(teamsItem_.getStrDescriptionPL()));
        contentValues.put(Variables.strGender, String.valueOf(teamsItem_.getStrGender()));
        contentValues.put(Variables.strCountry, String.valueOf(teamsItem_.getStrCountry()));
        contentValues.put(Variables.strTeamBadge, String.valueOf(teamsItem_.getStrTeamBadge()));
        contentValues.put(Variables.strTeamJersey, String.valueOf(teamsItem_.getStrTeamJersey()));
        contentValues.put(Variables.strTeamLogo, String.valueOf(teamsItem_.getStrTeamLogo()));
        contentValues.put(Variables.strTeamFanart1, String.valueOf(teamsItem_.getStrTeamFanart1()));
        contentValues.put(Variables.strTeamFanart2, String.valueOf(teamsItem_.getStrTeamFanart2()));
        contentValues.put(Variables.strTeamFanart3, String.valueOf(teamsItem_.getStrTeamFanart3()));
        contentValues.put(Variables.strTeamFanart4, String.valueOf(teamsItem_.getStrTeamFanart4()));
        contentValues.put(Variables.strTeamBanner, String.valueOf(teamsItem_.getStrTeamBanner()));
        contentValues.put(Variables.strYoutube, String.valueOf(teamsItem_.getStrYoutube()));
        contentValues.put(Variables.strLocked, String.valueOf(teamsItem_.getStrLocked()));
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
                teamsItem.setIdTeam(cursor.getString(0));
                teamsItem.setIdSoccerXML(cursor.getString(1));
                teamsItem.setIntLoved(cursor.getString(2));
                teamsItem.setStrTeam(cursor.getString(3));
                teamsItem.setStrTeamShort(cursor.getString(4));
                teamsItem.setStrAlternate(cursor.getString(5));
                teamsItem.setIntFormedYear(cursor.getString(6));
                teamsItem.setStrSport(cursor.getString(7));
                teamsItem.setStrLeague(cursor.getString(8));
                teamsItem.setIdLeague(cursor.getString(9));
                teamsItem.setStrDivision(cursor.getString(10));
                teamsItem.setStrManager(cursor.getString(11));
                teamsItem.setStrStadium(cursor.getString(12));
                teamsItem.setStrKeywords(cursor.getString(13));
                teamsItem.setStrRSS(cursor.getString(14));
                teamsItem.setStrStadiumThumb(cursor.getString(15));
                teamsItem.setStrStadiumDescription(cursor.getString(16));
                teamsItem.setStrStadiumLocation(cursor.getString(17));
                teamsItem.setIntStadiumCapacity(cursor.getString(18));
                teamsItem.setStrWebsite(cursor.getString(19));
                teamsItem.setStrFacebook(cursor.getString(20));
                teamsItem.setStrTwitter(cursor.getString(21));
                teamsItem.setStrInstagram(cursor.getString(22));
                teamsItem.setStrDescriptionEN(cursor.getString(23));
                teamsItem.setStrDescriptionDE(cursor.getString(24));
                teamsItem.setStrDescriptionFR(cursor.getString(25));
                teamsItem.setStrDescriptionCN(cursor.getString(26));
                teamsItem.setStrDescriptionIT(cursor.getString(27));
                teamsItem.setStrDescriptionJP(cursor.getString(28));
                teamsItem.setStrDescriptionRU(cursor.getString(29));
                teamsItem.setStrDescriptionES(cursor.getString(30));
                teamsItem.setStrDescriptionPT(cursor.getString(31));
                teamsItem.setStrDescriptionSE(cursor.getString(32));
                teamsItem.setStrDescriptionNL(cursor.getString(33));
                teamsItem.setStrDescriptionHU(cursor.getString(34));
                teamsItem.setStrDescriptionNO(cursor.getString(35));
                teamsItem.setStrDescriptionIL(cursor.getString(36));
                teamsItem.setStrDescriptionPL(cursor.getString(37));
                teamsItem.setStrGender(cursor.getString(38));
                teamsItem.setStrCountry(cursor.getString(39));
                teamsItem.setStrTeamBadge(cursor.getString(40));
                teamsItem.setStrTeamJersey(cursor.getString(41));
                teamsItem.setStrTeamLogo(cursor.getString(42));
                teamsItem.setStrTeamFanart1(cursor.getString(43));
                teamsItem.setStrTeamFanart2(cursor.getString(44));
                teamsItem.setStrTeamFanart3(cursor.getString(45));
                teamsItem.setStrTeamFanart4(cursor.getString(46));
                teamsItem.setStrTeamBanner(cursor.getString(47));
                teamsItem.setStrYoutube(cursor.getString(48));
                teamsItem.setStrLocked(cursor.getString(49));
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
