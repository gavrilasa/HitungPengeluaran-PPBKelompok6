package com.kelompok6.hitungpengeluaran.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.kelompok6.hitungpengeluaran.database.dao.DatabaseDao;
import com.kelompok6.hitungpengeluaran.model.ModelDatabase;

@Database(entities = {ModelDatabase.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DatabaseDao databaseDao();
}
