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
import com.tuapp.data.Converters;
import com.tuapp.entity.Transaccion;
import java.lang.Class;
import java.lang.Double;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class TransaccionDao_Impl implements TransaccionDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Transaccion> __insertionAdapterOfTransaccion;

  private final EntityDeletionOrUpdateAdapter<Transaccion> __deletionAdapterOfTransaccion;

  private final EntityDeletionOrUpdateAdapter<Transaccion> __updateAdapterOfTransaccion;

  public TransaccionDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfTransaccion = new EntityInsertionAdapter<Transaccion>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `transacciones` (`id`,`usuarioId`,`descripcion`,`monto`,`tipo`,`fecha`,`categoriaId`,`cuentaId`) VALUES (?,?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          final Transaccion entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindLong(1, entity.getId());
        }
        if (entity.getUsuarioId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindLong(2, entity.getUsuarioId());
        }
        if (entity.getDescripcion() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getDescripcion());
        }
        if (entity.getMonto() == null) {
          statement.bindNull(4);
        } else {
          statement.bindDouble(4, entity.getMonto());
        }
        if (entity.getTipo() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getTipo());
        }
        final Long _tmp = Converters.dateToTimestamp(entity.getFecha());
        if (_tmp == null) {
          statement.bindNull(6);
        } else {
          statement.bindLong(6, _tmp);
        }
        if (entity.getCategoriaId() == null) {
          statement.bindNull(7);
        } else {
          statement.bindLong(7, entity.getCategoriaId());
        }
        if (entity.getCuentaId() == null) {
          statement.bindNull(8);
        } else {
          statement.bindLong(8, entity.getCuentaId());
        }
      }
    };
    this.__deletionAdapterOfTransaccion = new EntityDeletionOrUpdateAdapter<Transaccion>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `transacciones` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          final Transaccion entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindLong(1, entity.getId());
        }
      }
    };
    this.__updateAdapterOfTransaccion = new EntityDeletionOrUpdateAdapter<Transaccion>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `transacciones` SET `id` = ?,`usuarioId` = ?,`descripcion` = ?,`monto` = ?,`tipo` = ?,`fecha` = ?,`categoriaId` = ?,`cuentaId` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          final Transaccion entity) {
        if (entity.getId() == null) {
          statement.bindNull(1);
        } else {
          statement.bindLong(1, entity.getId());
        }
        if (entity.getUsuarioId() == null) {
          statement.bindNull(2);
        } else {
          statement.bindLong(2, entity.getUsuarioId());
        }
        if (entity.getDescripcion() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getDescripcion());
        }
        if (entity.getMonto() == null) {
          statement.bindNull(4);
        } else {
          statement.bindDouble(4, entity.getMonto());
        }
        if (entity.getTipo() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getTipo());
        }
        final Long _tmp = Converters.dateToTimestamp(entity.getFecha());
        if (_tmp == null) {
          statement.bindNull(6);
        } else {
          statement.bindLong(6, _tmp);
        }
        if (entity.getCategoriaId() == null) {
          statement.bindNull(7);
        } else {
          statement.bindLong(7, entity.getCategoriaId());
        }
        if (entity.getCuentaId() == null) {
          statement.bindNull(8);
        } else {
          statement.bindLong(8, entity.getCuentaId());
        }
        if (entity.getId() == null) {
          statement.bindNull(9);
        } else {
          statement.bindLong(9, entity.getId());
        }
      }
    };
  }

  @Override
  public long insertar(final Transaccion transaccion) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      final long _result = __insertionAdapterOfTransaccion.insertAndReturnId(transaccion);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void eliminar(final Transaccion transaccion) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfTransaccion.handle(transaccion);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void actualizar(final Transaccion transaccion) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfTransaccion.handle(transaccion);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Transaccion> obtenerPorCuenta(final int cuentaId) {
    final String _sql = "SELECT * FROM transacciones WHERE cuentaId = ? ORDER BY fecha DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, cuentaId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfUsuarioId = CursorUtil.getColumnIndexOrThrow(_cursor, "usuarioId");
      final int _cursorIndexOfDescripcion = CursorUtil.getColumnIndexOrThrow(_cursor, "descripcion");
      final int _cursorIndexOfMonto = CursorUtil.getColumnIndexOrThrow(_cursor, "monto");
      final int _cursorIndexOfTipo = CursorUtil.getColumnIndexOrThrow(_cursor, "tipo");
      final int _cursorIndexOfFecha = CursorUtil.getColumnIndexOrThrow(_cursor, "fecha");
      final int _cursorIndexOfCategoriaId = CursorUtil.getColumnIndexOrThrow(_cursor, "categoriaId");
      final int _cursorIndexOfCuentaId = CursorUtil.getColumnIndexOrThrow(_cursor, "cuentaId");
      final List<Transaccion> _result = new ArrayList<Transaccion>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Transaccion _item;
        _item = new Transaccion();
        final Long _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getLong(_cursorIndexOfId);
        }
        _item.setId(_tmpId);
        final Long _tmpUsuarioId;
        if (_cursor.isNull(_cursorIndexOfUsuarioId)) {
          _tmpUsuarioId = null;
        } else {
          _tmpUsuarioId = _cursor.getLong(_cursorIndexOfUsuarioId);
        }
        _item.setUsuarioId(_tmpUsuarioId);
        final String _tmpDescripcion;
        if (_cursor.isNull(_cursorIndexOfDescripcion)) {
          _tmpDescripcion = null;
        } else {
          _tmpDescripcion = _cursor.getString(_cursorIndexOfDescripcion);
        }
        _item.setDescripcion(_tmpDescripcion);
        final Double _tmpMonto;
        if (_cursor.isNull(_cursorIndexOfMonto)) {
          _tmpMonto = null;
        } else {
          _tmpMonto = _cursor.getDouble(_cursorIndexOfMonto);
        }
        _item.setMonto(_tmpMonto);
        final String _tmpTipo;
        if (_cursor.isNull(_cursorIndexOfTipo)) {
          _tmpTipo = null;
        } else {
          _tmpTipo = _cursor.getString(_cursorIndexOfTipo);
        }
        _item.setTipo(_tmpTipo);
        final Date _tmpFecha;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfFecha)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfFecha);
        }
        _tmpFecha = Converters.fromTimestamp(_tmp);
        _item.setFecha(_tmpFecha);
        final Long _tmpCategoriaId;
        if (_cursor.isNull(_cursorIndexOfCategoriaId)) {
          _tmpCategoriaId = null;
        } else {
          _tmpCategoriaId = _cursor.getLong(_cursorIndexOfCategoriaId);
        }
        _item.setCategoriaId(_tmpCategoriaId);
        final Long _tmpCuentaId;
        if (_cursor.isNull(_cursorIndexOfCuentaId)) {
          _tmpCuentaId = null;
        } else {
          _tmpCuentaId = _cursor.getLong(_cursorIndexOfCuentaId);
        }
        _item.setCuentaId(_tmpCuentaId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Transaccion obtenerPorId(final int id) {
    final String _sql = "SELECT * FROM transacciones WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfUsuarioId = CursorUtil.getColumnIndexOrThrow(_cursor, "usuarioId");
      final int _cursorIndexOfDescripcion = CursorUtil.getColumnIndexOrThrow(_cursor, "descripcion");
      final int _cursorIndexOfMonto = CursorUtil.getColumnIndexOrThrow(_cursor, "monto");
      final int _cursorIndexOfTipo = CursorUtil.getColumnIndexOrThrow(_cursor, "tipo");
      final int _cursorIndexOfFecha = CursorUtil.getColumnIndexOrThrow(_cursor, "fecha");
      final int _cursorIndexOfCategoriaId = CursorUtil.getColumnIndexOrThrow(_cursor, "categoriaId");
      final int _cursorIndexOfCuentaId = CursorUtil.getColumnIndexOrThrow(_cursor, "cuentaId");
      final Transaccion _result;
      if (_cursor.moveToFirst()) {
        _result = new Transaccion();
        final Long _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getLong(_cursorIndexOfId);
        }
        _result.setId(_tmpId);
        final Long _tmpUsuarioId;
        if (_cursor.isNull(_cursorIndexOfUsuarioId)) {
          _tmpUsuarioId = null;
        } else {
          _tmpUsuarioId = _cursor.getLong(_cursorIndexOfUsuarioId);
        }
        _result.setUsuarioId(_tmpUsuarioId);
        final String _tmpDescripcion;
        if (_cursor.isNull(_cursorIndexOfDescripcion)) {
          _tmpDescripcion = null;
        } else {
          _tmpDescripcion = _cursor.getString(_cursorIndexOfDescripcion);
        }
        _result.setDescripcion(_tmpDescripcion);
        final Double _tmpMonto;
        if (_cursor.isNull(_cursorIndexOfMonto)) {
          _tmpMonto = null;
        } else {
          _tmpMonto = _cursor.getDouble(_cursorIndexOfMonto);
        }
        _result.setMonto(_tmpMonto);
        final String _tmpTipo;
        if (_cursor.isNull(_cursorIndexOfTipo)) {
          _tmpTipo = null;
        } else {
          _tmpTipo = _cursor.getString(_cursorIndexOfTipo);
        }
        _result.setTipo(_tmpTipo);
        final Date _tmpFecha;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfFecha)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfFecha);
        }
        _tmpFecha = Converters.fromTimestamp(_tmp);
        _result.setFecha(_tmpFecha);
        final Long _tmpCategoriaId;
        if (_cursor.isNull(_cursorIndexOfCategoriaId)) {
          _tmpCategoriaId = null;
        } else {
          _tmpCategoriaId = _cursor.getLong(_cursorIndexOfCategoriaId);
        }
        _result.setCategoriaId(_tmpCategoriaId);
        final Long _tmpCuentaId;
        if (_cursor.isNull(_cursorIndexOfCuentaId)) {
          _tmpCuentaId = null;
        } else {
          _tmpCuentaId = _cursor.getLong(_cursorIndexOfCuentaId);
        }
        _result.setCuentaId(_tmpCuentaId);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Transaccion> obtenerPorUsuario(final int usuarioId) {
    final String _sql = "SELECT * FROM transacciones WHERE usuarioId = ? ORDER BY fecha DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, usuarioId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfUsuarioId = CursorUtil.getColumnIndexOrThrow(_cursor, "usuarioId");
      final int _cursorIndexOfDescripcion = CursorUtil.getColumnIndexOrThrow(_cursor, "descripcion");
      final int _cursorIndexOfMonto = CursorUtil.getColumnIndexOrThrow(_cursor, "monto");
      final int _cursorIndexOfTipo = CursorUtil.getColumnIndexOrThrow(_cursor, "tipo");
      final int _cursorIndexOfFecha = CursorUtil.getColumnIndexOrThrow(_cursor, "fecha");
      final int _cursorIndexOfCategoriaId = CursorUtil.getColumnIndexOrThrow(_cursor, "categoriaId");
      final int _cursorIndexOfCuentaId = CursorUtil.getColumnIndexOrThrow(_cursor, "cuentaId");
      final List<Transaccion> _result = new ArrayList<Transaccion>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Transaccion _item;
        _item = new Transaccion();
        final Long _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getLong(_cursorIndexOfId);
        }
        _item.setId(_tmpId);
        final Long _tmpUsuarioId;
        if (_cursor.isNull(_cursorIndexOfUsuarioId)) {
          _tmpUsuarioId = null;
        } else {
          _tmpUsuarioId = _cursor.getLong(_cursorIndexOfUsuarioId);
        }
        _item.setUsuarioId(_tmpUsuarioId);
        final String _tmpDescripcion;
        if (_cursor.isNull(_cursorIndexOfDescripcion)) {
          _tmpDescripcion = null;
        } else {
          _tmpDescripcion = _cursor.getString(_cursorIndexOfDescripcion);
        }
        _item.setDescripcion(_tmpDescripcion);
        final Double _tmpMonto;
        if (_cursor.isNull(_cursorIndexOfMonto)) {
          _tmpMonto = null;
        } else {
          _tmpMonto = _cursor.getDouble(_cursorIndexOfMonto);
        }
        _item.setMonto(_tmpMonto);
        final String _tmpTipo;
        if (_cursor.isNull(_cursorIndexOfTipo)) {
          _tmpTipo = null;
        } else {
          _tmpTipo = _cursor.getString(_cursorIndexOfTipo);
        }
        _item.setTipo(_tmpTipo);
        final Date _tmpFecha;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfFecha)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfFecha);
        }
        _tmpFecha = Converters.fromTimestamp(_tmp);
        _item.setFecha(_tmpFecha);
        final Long _tmpCategoriaId;
        if (_cursor.isNull(_cursorIndexOfCategoriaId)) {
          _tmpCategoriaId = null;
        } else {
          _tmpCategoriaId = _cursor.getLong(_cursorIndexOfCategoriaId);
        }
        _item.setCategoriaId(_tmpCategoriaId);
        final Long _tmpCuentaId;
        if (_cursor.isNull(_cursorIndexOfCuentaId)) {
          _tmpCuentaId = null;
        } else {
          _tmpCuentaId = _cursor.getLong(_cursorIndexOfCuentaId);
        }
        _item.setCuentaId(_tmpCuentaId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public double obtenerTotalIngresos(final int usuarioId) {
    final String _sql = "SELECT COALESCE(SUM(monto), 0) FROM transacciones WHERE usuarioId = ? AND tipo = 'INGRESO'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, usuarioId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final double _result;
      if (_cursor.moveToFirst()) {
        _result = _cursor.getDouble(0);
      } else {
        _result = 0.0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public double obtenerTotalGastos(final int usuarioId) {
    final String _sql = "SELECT COALESCE(SUM(monto), 0) FROM transacciones WHERE usuarioId = ? AND tipo = 'GASTO'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, usuarioId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final double _result;
      if (_cursor.moveToFirst()) {
        _result = _cursor.getDouble(0);
      } else {
        _result = 0.0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Transaccion> obtenerPorTipo(final int usuarioId, final String tipo) {
    final String _sql = "SELECT * FROM transacciones WHERE usuarioId = ? AND tipo = ? ORDER BY fecha DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, usuarioId);
    _argIndex = 2;
    if (tipo == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, tipo);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfUsuarioId = CursorUtil.getColumnIndexOrThrow(_cursor, "usuarioId");
      final int _cursorIndexOfDescripcion = CursorUtil.getColumnIndexOrThrow(_cursor, "descripcion");
      final int _cursorIndexOfMonto = CursorUtil.getColumnIndexOrThrow(_cursor, "monto");
      final int _cursorIndexOfTipo = CursorUtil.getColumnIndexOrThrow(_cursor, "tipo");
      final int _cursorIndexOfFecha = CursorUtil.getColumnIndexOrThrow(_cursor, "fecha");
      final int _cursorIndexOfCategoriaId = CursorUtil.getColumnIndexOrThrow(_cursor, "categoriaId");
      final int _cursorIndexOfCuentaId = CursorUtil.getColumnIndexOrThrow(_cursor, "cuentaId");
      final List<Transaccion> _result = new ArrayList<Transaccion>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Transaccion _item;
        _item = new Transaccion();
        final Long _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getLong(_cursorIndexOfId);
        }
        _item.setId(_tmpId);
        final Long _tmpUsuarioId;
        if (_cursor.isNull(_cursorIndexOfUsuarioId)) {
          _tmpUsuarioId = null;
        } else {
          _tmpUsuarioId = _cursor.getLong(_cursorIndexOfUsuarioId);
        }
        _item.setUsuarioId(_tmpUsuarioId);
        final String _tmpDescripcion;
        if (_cursor.isNull(_cursorIndexOfDescripcion)) {
          _tmpDescripcion = null;
        } else {
          _tmpDescripcion = _cursor.getString(_cursorIndexOfDescripcion);
        }
        _item.setDescripcion(_tmpDescripcion);
        final Double _tmpMonto;
        if (_cursor.isNull(_cursorIndexOfMonto)) {
          _tmpMonto = null;
        } else {
          _tmpMonto = _cursor.getDouble(_cursorIndexOfMonto);
        }
        _item.setMonto(_tmpMonto);
        final String _tmpTipo;
        if (_cursor.isNull(_cursorIndexOfTipo)) {
          _tmpTipo = null;
        } else {
          _tmpTipo = _cursor.getString(_cursorIndexOfTipo);
        }
        _item.setTipo(_tmpTipo);
        final Date _tmpFecha;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfFecha)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfFecha);
        }
        _tmpFecha = Converters.fromTimestamp(_tmp);
        _item.setFecha(_tmpFecha);
        final Long _tmpCategoriaId;
        if (_cursor.isNull(_cursorIndexOfCategoriaId)) {
          _tmpCategoriaId = null;
        } else {
          _tmpCategoriaId = _cursor.getLong(_cursorIndexOfCategoriaId);
        }
        _item.setCategoriaId(_tmpCategoriaId);
        final Long _tmpCuentaId;
        if (_cursor.isNull(_cursorIndexOfCuentaId)) {
          _tmpCuentaId = null;
        } else {
          _tmpCuentaId = _cursor.getLong(_cursorIndexOfCuentaId);
        }
        _item.setCuentaId(_tmpCuentaId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Transaccion> obtenerPorCategoria(final int categoriaId) {
    final String _sql = "SELECT * FROM transacciones WHERE categoriaId = ? ORDER BY fecha DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, categoriaId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfUsuarioId = CursorUtil.getColumnIndexOrThrow(_cursor, "usuarioId");
      final int _cursorIndexOfDescripcion = CursorUtil.getColumnIndexOrThrow(_cursor, "descripcion");
      final int _cursorIndexOfMonto = CursorUtil.getColumnIndexOrThrow(_cursor, "monto");
      final int _cursorIndexOfTipo = CursorUtil.getColumnIndexOrThrow(_cursor, "tipo");
      final int _cursorIndexOfFecha = CursorUtil.getColumnIndexOrThrow(_cursor, "fecha");
      final int _cursorIndexOfCategoriaId = CursorUtil.getColumnIndexOrThrow(_cursor, "categoriaId");
      final int _cursorIndexOfCuentaId = CursorUtil.getColumnIndexOrThrow(_cursor, "cuentaId");
      final List<Transaccion> _result = new ArrayList<Transaccion>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Transaccion _item;
        _item = new Transaccion();
        final Long _tmpId;
        if (_cursor.isNull(_cursorIndexOfId)) {
          _tmpId = null;
        } else {
          _tmpId = _cursor.getLong(_cursorIndexOfId);
        }
        _item.setId(_tmpId);
        final Long _tmpUsuarioId;
        if (_cursor.isNull(_cursorIndexOfUsuarioId)) {
          _tmpUsuarioId = null;
        } else {
          _tmpUsuarioId = _cursor.getLong(_cursorIndexOfUsuarioId);
        }
        _item.setUsuarioId(_tmpUsuarioId);
        final String _tmpDescripcion;
        if (_cursor.isNull(_cursorIndexOfDescripcion)) {
          _tmpDescripcion = null;
        } else {
          _tmpDescripcion = _cursor.getString(_cursorIndexOfDescripcion);
        }
        _item.setDescripcion(_tmpDescripcion);
        final Double _tmpMonto;
        if (_cursor.isNull(_cursorIndexOfMonto)) {
          _tmpMonto = null;
        } else {
          _tmpMonto = _cursor.getDouble(_cursorIndexOfMonto);
        }
        _item.setMonto(_tmpMonto);
        final String _tmpTipo;
        if (_cursor.isNull(_cursorIndexOfTipo)) {
          _tmpTipo = null;
        } else {
          _tmpTipo = _cursor.getString(_cursorIndexOfTipo);
        }
        _item.setTipo(_tmpTipo);
        final Date _tmpFecha;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfFecha)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfFecha);
        }
        _tmpFecha = Converters.fromTimestamp(_tmp);
        _item.setFecha(_tmpFecha);
        final Long _tmpCategoriaId;
        if (_cursor.isNull(_cursorIndexOfCategoriaId)) {
          _tmpCategoriaId = null;
        } else {
          _tmpCategoriaId = _cursor.getLong(_cursorIndexOfCategoriaId);
        }
        _item.setCategoriaId(_tmpCategoriaId);
        final Long _tmpCuentaId;
        if (_cursor.isNull(_cursorIndexOfCuentaId)) {
          _tmpCuentaId = null;
        } else {
          _tmpCuentaId = _cursor.getLong(_cursorIndexOfCuentaId);
        }
        _item.setCuentaId(_tmpCuentaId);
        _result.add(_item);
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
