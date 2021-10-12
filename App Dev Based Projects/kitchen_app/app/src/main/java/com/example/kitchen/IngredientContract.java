package com.example.kitchen;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

public class IngredientContract {

    public static final String CONTENT_AUTHORITY = "com.example.android.kitchen";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_INGREDIENTS = "ingredients";
    public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_INGREDIENTS);


    // To prevent someone from accidentally instantiating the contract class,
        // give it an empty constructor.
        private IngredientContract() {}

        /**
         * Inner class that defines constant values for the pets database table.
         * Each entry in the table represents a single pet.
         */
        public static final class IngredientEntry implements BaseColumns {
            public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_INGREDIENTS);

            public static final String CONTENT_LIST_TYPE =
                    ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_INGREDIENTS;

            public static final String CONTENT_ITEM_TYPE =
                    ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_INGREDIENTS;

            public final static String TABLE_NAME = "ingredients";

            /**
             * Unique ID number for the ingredient (only for use in the database table).
             *
             * Type: INTEGER
             */
            public final static String _ID = BaseColumns._ID;

            public final static String COLUMN_INGREDIENT_NAME ="name";

            public final static String COLUMN_INGREDIENT_MEASUREMENT = "unit";

            public final static String COLUMN_INGREDIENT_QUANTITY = "quantity";

            public static final int MEASUREMENT_KG = 0;
            public static final int MEASUREMENT_GM = 1;
            public static final int MEASUREMENT_L = 2;
            public static final int MEASUREMENT_ML = 3;
            public static final int MEASUREMENT_DOZEN = 4;
            public static final int MEASUREMENT_PACKETS = 5;
        }

    }



