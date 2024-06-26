package com.kelompok6.hitungpengeluaran.database.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.kelompok6.hitungpengeluaran.model.ModelDatabase;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class DatabaseDao_Impl implements DatabaseDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<ModelDatabase> __insertionAdapterOfModelDatabase;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllPengeluaran;

  private final SharedSQLiteStatement __preparedStmtOfDeleteSinglePengeluaran;

  private final SharedSQLiteStatement __preparedStmtOfUpdateDataPengeluaran;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllPemasukan;

  private final SharedSQLiteStatement __preparedStmtOfDeleteSinglePemasukan;

  private final SharedSQLiteStatement __preparedStmtOfUpdateDataPemasukan;

  public DatabaseDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfModelDatabase = new EntityInsertionAdapter<ModelDatabase>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `tbl_keuangan` (`uid`,`tipe`,`keterangan`,`jml_uang`,`tanggal`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, ModelDatabase value) {
        stmt.bindLong(1, value.uid);
        if (value.tipe == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.tipe);
        }
        if (value.keterangan == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.keterangan);
        }
        stmt.bindLong(4, value.jmlUang);
        if (value.tanggal == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.tanggal);
        }
      }
    };
    this.__preparedStmtOfDeleteAllPengeluaran = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM tbl_keuangan WHERE tipe = 'pengeluaran'";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteSinglePengeluaran = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM tbl_keuangan WHERE uid= ? and tipe = 'pengeluaran'";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateDataPengeluaran = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE tbl_keuangan SET keterangan = ?, tanggal = ?, jml_uang = ? WHERE uid = ? and tipe = 'pengeluaran'";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteAllPemasukan = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM tbl_keuangan WHERE tipe = 'pemasukan'";
        return _query;
      }
    };
    this.__preparedStmtOfDeleteSinglePemasukan = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM tbl_keuangan WHERE uid= ? and tipe = 'pemasukan'";
        return _query;
      }
    };
    this.__preparedStmtOfUpdateDataPemasukan = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "UPDATE tbl_keuangan SET keterangan = ?, tanggal = ?, jml_uang = ? WHERE uid = ? and tipe = 'pemasukan'";
        return _query;
      }
    };
  }

  @Override
  public void insertPengeluaran(final ModelDatabase... pengeluaran) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfModelDatabase.insert(pengeluaran);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void insertPemasukan(final ModelDatabase... pemasukan) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfModelDatabase.insert(pemasukan);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAllPengeluaran() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllPengeluaran.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAllPengeluaran.release(_stmt);
    }
  }

  @Override
  public void deleteSinglePengeluaran(final int uid) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteSinglePengeluaran.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, uid);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteSinglePengeluaran.release(_stmt);
    }
  }

  @Override
  public void updateDataPengeluaran(final String keterangan, final String tgl, final int harga,
      final int uid) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateDataPengeluaran.acquire();
    int _argIndex = 1;
    if (keterangan == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, keterangan);
    }
    _argIndex = 2;
    if (tgl == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, tgl);
    }
    _argIndex = 3;
    _stmt.bindLong(_argIndex, harga);
    _argIndex = 4;
    _stmt.bindLong(_argIndex, uid);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateDataPengeluaran.release(_stmt);
    }
  }

  @Override
  public void deleteAllPemasukan() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllPemasukan.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteAllPemasukan.release(_stmt);
    }
  }

  @Override
  public void deleteSinglePemasukan(final int uid) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteSinglePemasukan.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, uid);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfDeleteSinglePemasukan.release(_stmt);
    }
  }

  @Override
  public void updateDataPemasukan(final String keterangan, final String tgl, final int harga,
      final int uid) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfUpdateDataPemasukan.acquire();
    int _argIndex = 1;
    if (keterangan == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, keterangan);
    }
    _argIndex = 2;
    if (tgl == null) {
      _stmt.bindNull(_argIndex);
    } else {
      _stmt.bindString(_argIndex, tgl);
    }
    _argIndex = 3;
    _stmt.bindLong(_argIndex, harga);
    _argIndex = 4;
    _stmt.bindLong(_argIndex, uid);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfUpdateDataPemasukan.release(_stmt);
    }
  }

  @Override
  public LiveData<List<ModelDatabase>> getAllPengeluaran() {
    final String _sql = "SELECT * FROM tbl_keuangan WHERE tipe = 'pengeluaran'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"tbl_keuangan"}, false, new Callable<List<ModelDatabase>>() {
      @Override
      public List<ModelDatabase> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
          final int _cursorIndexOfTipe = CursorUtil.getColumnIndexOrThrow(_cursor, "tipe");
          final int _cursorIndexOfKeterangan = CursorUtil.getColumnIndexOrThrow(_cursor, "keterangan");
          final int _cursorIndexOfJmlUang = CursorUtil.getColumnIndexOrThrow(_cursor, "jml_uang");
          final int _cursorIndexOfTanggal = CursorUtil.getColumnIndexOrThrow(_cursor, "tanggal");
          final List<ModelDatabase> _result = new ArrayList<ModelDatabase>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ModelDatabase _item;
            _item = new ModelDatabase();
            _item.uid = _cursor.getInt(_cursorIndexOfUid);
            if (_cursor.isNull(_cursorIndexOfTipe)) {
              _item.tipe = null;
            } else {
              _item.tipe = _cursor.getString(_cursorIndexOfTipe);
            }
            if (_cursor.isNull(_cursorIndexOfKeterangan)) {
              _item.keterangan = null;
            } else {
              _item.keterangan = _cursor.getString(_cursorIndexOfKeterangan);
            }
            _item.jmlUang = _cursor.getInt(_cursorIndexOfJmlUang);
            if (_cursor.isNull(_cursorIndexOfTanggal)) {
              _item.tanggal = null;
            } else {
              _item.tanggal = _cursor.getString(_cursorIndexOfTanggal);
            }
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<Integer> getTotalPengeluaran() {
    final String _sql = "SELECT SUM(jml_uang) FROM tbl_keuangan WHERE tipe = 'pengeluaran'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"tbl_keuangan"}, false, new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if(_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<List<ModelDatabase>> getAllPemasukan() {
    final String _sql = "SELECT * FROM tbl_keuangan WHERE tipe = 'pemasukan'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"tbl_keuangan"}, false, new Callable<List<ModelDatabase>>() {
      @Override
      public List<ModelDatabase> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfUid = CursorUtil.getColumnIndexOrThrow(_cursor, "uid");
          final int _cursorIndexOfTipe = CursorUtil.getColumnIndexOrThrow(_cursor, "tipe");
          final int _cursorIndexOfKeterangan = CursorUtil.getColumnIndexOrThrow(_cursor, "keterangan");
          final int _cursorIndexOfJmlUang = CursorUtil.getColumnIndexOrThrow(_cursor, "jml_uang");
          final int _cursorIndexOfTanggal = CursorUtil.getColumnIndexOrThrow(_cursor, "tanggal");
          final List<ModelDatabase> _result = new ArrayList<ModelDatabase>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final ModelDatabase _item;
            _item = new ModelDatabase();
            _item.uid = _cursor.getInt(_cursorIndexOfUid);
            if (_cursor.isNull(_cursorIndexOfTipe)) {
              _item.tipe = null;
            } else {
              _item.tipe = _cursor.getString(_cursorIndexOfTipe);
            }
            if (_cursor.isNull(_cursorIndexOfKeterangan)) {
              _item.keterangan = null;
            } else {
              _item.keterangan = _cursor.getString(_cursorIndexOfKeterangan);
            }
            _item.jmlUang = _cursor.getInt(_cursorIndexOfJmlUang);
            if (_cursor.isNull(_cursorIndexOfTanggal)) {
              _item.tanggal = null;
            } else {
              _item.tanggal = _cursor.getString(_cursorIndexOfTanggal);
            }
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<Integer> getTotalPemasukan() {
    final String _sql = "SELECT SUM(jml_uang) FROM tbl_keuangan WHERE tipe = 'pemasukan'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"tbl_keuangan"}, false, new Callable<Integer>() {
      @Override
      public Integer call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Integer _result;
          if(_cursor.moveToFirst()) {
            final Integer _tmp;
            if (_cursor.isNull(0)) {
              _tmp = null;
            } else {
              _tmp = _cursor.getInt(0);
            }
            _result = _tmp;
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
