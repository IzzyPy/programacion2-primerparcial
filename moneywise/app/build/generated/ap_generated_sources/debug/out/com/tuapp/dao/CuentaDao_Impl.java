package com.tuapp.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.tuapp.entity.Cuenta;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class CuentaDao_Impl implements CuentaDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Cuenta> __insertionAdapterOfCuenta;

  private final EntityDeletionOrUpdateAdapter<Cuenta> __deletionAdapterOfCuenta;

  private final EntityDeletionOrUpdateAdapter<Cuenta> __updateAdapterOfCuenta;

  public CuentaDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCuenta = new EntityInsertionAdapter<Cuenta>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `cuentas` (`id`,`nombre`,`saldoInicial`,`saldoActual`,`usuarioId`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Cuenta entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getNombre() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getNombre());
        }
        statement.bindDouble(3, entity.getSaldoInicial());
        statement.bindDouble(4, entity.getSaldoActual());
        statement.bindLong(5, entity.getUsuarioId());
      }
    };
    this.__deletionAdapterOfCuenta = new EntityDeletionOrUpdateAdapter<Cuenta>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `cuentas` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Cuenta entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfCuenta = new EntityDeletionOrUpdateAdapter<Cuenta>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `cuentas` SET `id` = ?,`nombre` = ?,`saldoInicial` = ?,`saldoActual` = ?,`usuarioId` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Cuenta entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getNombre() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getNombre());
        }
        statement.bindDouble(3, entity.getSaldoInicial());
        statement.bindDouble(4, entity.getSaldoActual());
        statement.bindLong(5, entity.getUsuarioId());
        statement.bindLong(6, entity.getId());
      }
    };
  }

  @Override
  public long insertar(final Cuenta cuenta) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      final long _result = __insertionAdapterOfCuenta.insertAndReturnId(cuenta);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void eliminar(final Cuenta cuenta) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfCuenta.handle(cuenta);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void actualizar(final Cuenta cuenta) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfCuenta.handle(cuenta);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Cuenta> obtenerPorUsuario(final int usuarioId) {
    final String _sql = "SELECT * FROM cuentas WHERE usuarioId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, usuarioId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
      final int _cursorIndexOfSaldoInicial = CursorUtil.getColumnIndexOrThrow(_cursor, "saldoInicial");
      final int _cursorIndexOfSaldoActual = CursorUtil.getColumnIndexOrThrow(_cursor, "saldoActual");
      final int _cursorIndexOfUsuarioId = CursorUtil.getColumnIndexOrThrow(_cursor, "usuarioId");
      final List<Cuenta> _result = new ArrayList<Cuenta>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Cuenta _item;
        final String _tmpNombre;
        if (_cursor.isNull(_cursorIndexOfNombre)) {
          _tmpNombre = null;
        } else {
          _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
        }
        final double _tmpSaldoInicial;
        _tmpSaldoInicial = _cursor.getDouble(_cursorIndexOfSaldoInicial);
        final int _tmpUsuarioId;
        _tmpUsuarioId = _cursor.getInt(_cursorIndexOfUsuarioId);
        _item = new Cuenta(_tmpNombre,_tmpSaldoInicial,_tmpUsuarioId);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final double _tmpSaldoActual;
        _tmpSaldoActual = _cursor.getDouble(_cursorIndexOfSaldoActual);
        _item.setSaldoActual(_tmpSaldoActual);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Cuenta obtenerPorId(final int id) {
    final String _sql = "SELECT * FROM cuentas WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
      final int _cursorIndexOfSaldoInicial = CursorUtil.getColumnIndexOrThrow(_cursor, "saldoInicial");
      final int _cursorIndexOfSaldoActual = CursorUtil.getColumnIndexOrThrow(_cursor, "saldoActual");
      final int _cursorIndexOfUsuarioId = CursorUtil.getColumnIndexOrThrow(_cursor, "usuarioId");
      final Cuenta _result;
      if (_cursor.moveToFirst()) {
        final String _tmpNombre;
        if (_cursor.isNull(_cursorIndexOfNombre)) {
          _tmpNombre = null;
        } else {
          _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
        }
        final double _tmpSaldoInicial;
        _tmpSaldoInicial = _cursor.getDouble(_cursorIndexOfSaldoInicial);
        final int _tmpUsuarioId;
        _tmpUsuarioId = _cursor.getInt(_cursorIndexOfUsuarioId);
        _result = new Cuenta(_tmpNombre,_tmpSaldoInicial,_tmpUsuarioId);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _result.setId(_tmpId);
        final double _tmpSaldoActual;
        _tmpSaldoActual = _cursor.getDouble(_cursorIndexOfSaldoActual);
        _result.setSaldoActual(_tmpSaldoActual);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
