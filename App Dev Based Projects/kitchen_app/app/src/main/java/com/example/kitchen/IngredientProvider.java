package com.example.kitchen;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import static java.security.AccessController.getContext;

public class IngredientProvider extends ContentProvider {

    public static final String LOG_TAG = IngredientProvider.class.getSimpleName();

    private static final int INGREDIENTS = 100;
    private static final int INGREDIENT_ID = 101;

    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    static{
        sUriMatcher.addURI(IngredientContract.CONTENT_AUTHORITY, IngredientContract.PATH_INGREDIENTS, INGREDIENTS);
        sUriMatcher.addURI(IngredientContract.CONTENT_AUTHORITY, IngredientContract.PATH_INGREDIENTS + "/#", INGREDIENT_ID);
    }

    private ingredientDbHelper mDbHelper;

    @Override
    public boolean onCreate(){
        mDbHelper = new ingredientDbHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        SQLiteDatabase database = mDbHelper.getReadableDatabase();
        Cursor cursor = null;

        int match = sUriMatcher.match(uri);
        switch(match){
            case INGREDIENTS:
                cursor = database.query(IngredientContract.IngredientEntry.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
                break;
            case INGREDIENT_ID:
                selection = IngredientContract.IngredientEntry._ID + "=?";
                selectionArgs = new String[] { String.valueOf(ContentUris.parseId(uri))};
                cursor = database.query(IngredientContract.IngredientEntry.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
                break;
            default:
                throw new IllegalArgumentException("Cannot query unknown URI " + uri);
        }
        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        final int match = sUriMatcher.match(uri);
        switch (match) {
            case INGREDIENTS:
                return IngredientContract.IngredientEntry.CONTENT_LIST_TYPE;
            case INGREDIENT_ID:
                return IngredientContract.IngredientEntry.CONTENT_ITEM_TYPE;
            default:
                throw new IllegalStateException("Unknown URI " + uri + " with match " + match);
        }
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        final int match = sUriMatcher.match(uri);
        switch (match) {
            case INGREDIENTS:
                return insertIngredient(uri, contentValues);
            default:
                throw new IllegalArgumentException("Insertion is not supported for " + uri);
        }
    }
    private Uri insertIngredient(Uri uri, ContentValues values) {
        // Check that the name is not null
        String name = values.getAsString(IngredientContract.IngredientEntry.COLUMN_INGREDIENT_NAME);
        if (name == null) {
            throw new IllegalArgumentException("Pet requires a name");
        }
        // Check that the gender is valid
        Integer measurement = values.getAsInteger(IngredientContract.IngredientEntry.COLUMN_INGREDIENT_MEASUREMENT);
        if (measurement == null ) {
            throw new IllegalArgumentException("Ingredient requires valid unit of measurement");
        }

        // If the weight is provided, check that it's greater than or equal to 0 kg
        Integer quantity = values.getAsInteger(IngredientContract.IngredientEntry.COLUMN_INGREDIENT_QUANTITY);
        if (quantity != null && quantity < 0) {
            throw new IllegalArgumentException("Ingredient requires valid quantity");
        }

        // No need to check the breed, any value is valid (including null).

        // Get writeable database
        SQLiteDatabase database = mDbHelper.getWritableDatabase();

        // Insert the new pet with the given values
        long id = database.insert(IngredientContract.IngredientEntry.TABLE_NAME, null, values);
        // If the ID is -1, then the insertion failed. Log an error and return null.
        if (id == -1) {
            Log.e(LOG_TAG, "Failed to insert row for " + uri);
            return null;
        }

        // Return the new URI with the ID (of the newly inserted row) appended at the end
        return ContentUris.withAppendedId(uri, id);
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        SQLiteDatabase database = mDbHelper.getWritableDatabase();

        final int match = sUriMatcher.match(uri);
        switch (match) {
            case INGREDIENTS:
                // Delete all rows that match the selection and selection args
                return database.delete(IngredientContract.IngredientEntry.TABLE_NAME, selection, selectionArgs);
            case INGREDIENT_ID:
                // Delete a single row given by the ID in the URI
                selection = IngredientContract.IngredientEntry._ID + "=?";
                selectionArgs = new String[] { String.valueOf(ContentUris.parseId(uri)) };
                return database.delete(IngredientContract.IngredientEntry.TABLE_NAME, selection, selectionArgs);
            default:
                throw new IllegalArgumentException("Deletion is not supported for " + uri);
        }
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String selection, @Nullable String[] selectionArgs) {
        final int match = sUriMatcher.match(uri);
        switch (match) {
            case INGREDIENTS:
                return updateIngredient(uri, contentValues, selection, selectionArgs);
            case INGREDIENT_ID:
                // For the PET_ID code, extract out the ID from the URI,
                // so we know which row to update. Selection will be "_id=?" and selection
                // arguments will be a String array containing the actual ID.
                selection = IngredientContract.IngredientEntry._ID + "=?";
                selectionArgs = new String[] { String.valueOf(ContentUris.parseId(uri)) };
                return updateIngredient(uri, contentValues, selection, selectionArgs);
            default:
                throw new IllegalArgumentException("Update is not supported for " + uri);
        }
    }
    private int updateIngredient(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        // If the {@link PetEntry#COLUMN_PET_NAME} key is present,
        // check that the name value is not null.
        if (values.containsKey(IngredientContract.IngredientEntry.COLUMN_INGREDIENT_NAME)) {
            String name = values.getAsString(IngredientContract.IngredientEntry.COLUMN_INGREDIENT_NAME);
            if (name == null) {
                throw new IllegalArgumentException("Ingredient requires a name");
            }
        }

        // If the {@link PetEntry#COLUMN_PET_GENDER} key is present,
        // check that the gender value is valid.
        if (values.containsKey(IngredientContract.IngredientEntry.COLUMN_INGREDIENT_MEASUREMENT)) {
            Integer measurement = values.getAsInteger(IngredientContract.IngredientEntry.COLUMN_INGREDIENT_MEASUREMENT);
            if (measurement == null) {
                throw new IllegalArgumentException("Ingredient requires valid measurement unit");
            }
        }

        // If the {@link PetEntry#COLUMN_PET_WEIGHT} key is present,
        // check that the weight value is valid.
        if (values.containsKey(IngredientContract.IngredientEntry.COLUMN_INGREDIENT_QUANTITY)) {
            // Check that the weight is greater than or equal to 0 kg
            Integer quantity = values.getAsInteger(IngredientContract.IngredientEntry.COLUMN_INGREDIENT_QUANTITY);
            if (quantity != null && quantity < 0) {
                throw new IllegalArgumentException("Pet requires valid weight");
            }
        }

        // No need to check the breed, any value is valid (including null).

        // If there are no values to update, then don't try to update the database
        if (values.size() == 0) {
            return 0;
        }

        // Otherwise, get writeable database to update the data
        SQLiteDatabase database = mDbHelper.getWritableDatabase();

        // Returns the number of database rows affected by the update statement
        return database.update(IngredientContract.IngredientEntry.TABLE_NAME, values, selection, selectionArgs);
    }

}



















