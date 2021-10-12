package com.example.kitchen;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

    public class ingredientDbHelper extends SQLiteOpenHelper {

        public static final String LOG_TAG = ingredientDbHelper.class.getSimpleName();

        /** Name of the database file */
        private static final String DATABASE_NAME = "ingredient.db";

        /**
         * Database version. If you change the database schema, you must increment the database version.
         */
        private static final int DATABASE_VERSION = 1;


        public ingredientDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        /**
         * This is called when the database is created for the first time.
         */
        @Override
        public void onCreate(SQLiteDatabase db) {
            // Create a String that contains the SQL statement to create the pets table
            String SQL_CREATE_INGREDIENTS_TABLE =  "CREATE TABLE " + IngredientContract.IngredientEntry.TABLE_NAME + " ("
                    + IngredientContract.IngredientEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + IngredientContract.IngredientEntry.COLUMN_INGREDIENT_NAME + " TEXT NOT NULL, "
                    + IngredientContract.IngredientEntry.COLUMN_INGREDIENT_MEASUREMENT + " INTEGER NOT NULL, "
                    + IngredientContract.IngredientEntry.COLUMN_INGREDIENT_QUANTITY + " INTEGER NOT NULL DEFAULT 0);";
            // Execute the SQL statement
            db.execSQL(SQL_CREATE_INGREDIENTS_TABLE);
        }

        /**
         * This is called when the database needs to be upgraded.
         */
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // The database is still at version 1, so there's nothing to do be done here.
        }
    }


