package com.tuapp.dao;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.tuapp.entity.Presupuesto;
import java.lang.Class;
import java.lang.Double;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class PresupuestoDao_Impl implements PresupuestoDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Presupuesto> __insertionAdapterOfPresupuesto;

  private final EntityDeletionOrUpdateAdapter<Presupuesto> __deletionAdapterOfPresupuesto;

  private final EntityDeletionOrUpdateAdapter<Presupuesto> __updateAdapterOfPresupuesto;

  private final SharedSQLiteStatement __preparedStmtOfActualizarMontoGastado;

  private final SharedSQLiteStatement __preparedStmtOfReducirMontoGastado;

  private final SharedSQLiteStatement __preparedStmtOfEliminarTodosPorUsuario;

  public PresupuestoDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPresupuesto = new EntityInsertionAdapter<Presupuesto>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `presupuestos` (`id`,`nombre`,`montoTotal`,`montoGastado`,`mes`,`usuarioId`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          final Presupuesto entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getNombre() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getNombre());
        }
        statement.bindDouble(3, entity.getMontoTotal());
        statement.bindDouble(4, entity.getMontoGastado());
        if (entity.getMes() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getMes());
        }
        statement.bindLong(6, entity.getUsuarioId());
      }
    };
    this.__deletionAdapterOfPresupuesto = new EntityDeletionOrUpdateAdapter<Presupuesto>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `presupuestos` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          final Presupuesto entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfPresupuesto = new EntityDeletionOrUpdateAdapter<Presupuesto>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `presupuestos` SET `id` = ?,`nombre` = ?,`montoTotal` = ?,`montoGastado` = ?,`mes` = ?,`usuarioId` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          final Presupuesto entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getNombre() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getNombre());
        }
        statement.bindDouble(3, entity.getMontoTotal());
        statement.bindDouble(4, entity.getMontoGastado());
        if (entity.getMes() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getMes());
        }
        statement.bindLong(6, entity.getUsuarioId());
        statement.bindLong(7, entity.getId());
      }
    };
    this.__preparedStmtOfActualizarMontoGastado = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE presupuestos SET montoGastado = montoGastado + ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfReducirMontoGastado = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE presupuestos SET montoGastado = montoGastado - ? WHERE id = ?";
        return _query;
      }
    };
    this.__preparedStmtOfEliminarTodosPorUsuario = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM presupuestos WHERE usuarioId = ?";
        return _query;
      }
    };
  }

  @Override
  public long insertar(final Presupuesto presupuesto) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      final long _result = __insertionAdapterOfPresupuesto.insertAndReturnId(presupuesto);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void eliminar(final Presupuesto presupuesto) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfPresupuesto.handle(presupuesto);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void actualizar(final Presupuesto presupuesto) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfPresupuesto.handle(presupuesto);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void actualizarMontoGastado(final int presupuestoId, final double monto) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfActualizarMontoGastado.acquire();
    int _argIndex = 1;
    _stmt.bindDouble(_argIndex, monto);
    _argIndex = 2;
    _stmt.bindLong(_argIndex, presupuestoId);
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfActualizarMontoGastado.release(_stmt);
    }
  }

  @Override
  public void reducirMontoGastado(final int presupuestoId, final double monto) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfReducirMontoGastado.acquire();
    int _argIndex = 1;
    _stmt.bindDouble(_argIndex, monto);
    _argIndex = 2;
    _stmt.bindLong(_argIndex, presupuestoId);
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfReducirMontoGastado.release(_stmt);
    }
  }

  @Override
  public void eliminarTodosPorUsuario(final int usuarioId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfEliminarTodosPorUsuario.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, usuarioId);
    try {
      __db.beginTransaction();
      try {
        _stmt.executeUpdateDelete();
        __db.setTransactionSuccessful();
      } finally {
        __db.endTransaction();
      }
    } finally {
      __preparedStmtOfEliminarTodosPorUsuario.release(_stmt);
    }
  }

  @Override
  public Presupuesto obtenerPorId(final int id) {
    final String _sql = "SELECT * FROM presupuestos WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
      final int _cursorIndexOfMontoTotal = CursorUtil.getColumnIndexOrThrow(_cursor, "montoTotal");
      final int _cursorIndexOfMontoGastado = CursorUtil.getColumnIndexOrThrow(_cursor, "montoGastado");
      final int _cursorIndexOfMes = CursorUtil.getColumnIndexOrThrow(_cursor, "mes");
      final int _cursorIndexOfUsuarioId = CursorUtil.getColumnIndexOrThrow(_cursor, "usuarioId");
      final Presupuesto _result;
      if (_cursor.moveToFirst()) {
        _result = new Presupuesto();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _result.setId(_tmpId);
        final String _tmpNombre;
        if (_cursor.isNull(_cursorIndexOfNombre)) {
          _tmpNombre = null;
        } else {
          _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
        }
        _result.setNombre(_tmpNombre);
        final double _tmpMontoTotal;
        _tmpMontoTotal = _cursor.getDouble(_cursorIndexOfMontoTotal);
        _result.setMontoTotal(_tmpMontoTotal);
        final double _tmpMontoGastado;
        _tmpMontoGastado = _cursor.getDouble(_cursorIndexOfMontoGastado);
        _result.setMontoGastado(_tmpMontoGastado);
        final String _tmpMes;
        if (_cursor.isNull(_cursorIndexOfMes)) {
          _tmpMes = null;
        } else {
          _tmpMes = _cursor.getString(_cursorIndexOfMes);
        }
        _result.setMes(_tmpMes);
        final int _tmpUsuarioId;
        _tmpUsuarioId = _cursor.getInt(_cursorIndexOfUsuarioId);
        _result.setUsuarioId(_tmpUsuarioId);
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
  public List<Presupuesto> obtenerPorUsuario(final int usuarioId) {
    final String _sql = "SELECT * FROM presupuestos WHERE usuarioId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, usuarioId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
      final int _cursorIndexOfMontoTotal = CursorUtil.getColumnIndexOrThrow(_cursor, "montoTotal");
      final int _cursorIndexOfMontoGastado = CursorUtil.getColumnIndexOrThrow(_cursor, "montoGastado");
      final int _cursorIndexOfMes = CursorUtil.getColumnIndexOrThrow(_cursor, "mes");
      final int _cursorIndexOfUsuarioId = CursorUtil.getColumnIndexOrThrow(_cursor, "usuarioId");
      final List<Presupuesto> _result = new ArrayList<Presupuesto>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Presupuesto _item;
        _item = new Presupuesto();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpNombre;
        if (_cursor.isNull(_cursorIndexOfNombre)) {
          _tmpNombre = null;
        } else {
          _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
        }
        _item.setNombre(_tmpNombre);
        final double _tmpMontoTotal;
        _tmpMontoTotal = _cursor.getDouble(_cursorIndexOfMontoTotal);
        _item.setMontoTotal(_tmpMontoTotal);
        final double _tmpMontoGastado;
        _tmpMontoGastado = _cursor.getDouble(_cursorIndexOfMontoGastado);
        _item.setMontoGastado(_tmpMontoGastado);
        final String _tmpMes;
        if (_cursor.isNull(_cursorIndexOfMes)) {
          _tmpMes = null;
        } else {
          _tmpMes = _cursor.getString(_cursorIndexOfMes);
        }
        _item.setMes(_tmpMes);
        final int _tmpUsuarioId;
        _tmpUsuarioId = _cursor.getInt(_cursorIndexOfUsuarioId);
        _item.setUsuarioId(_tmpUsuarioId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Presupuesto> obtenerPorUsuarioYMes(final int usuarioId, final String mes) {
    final String _sql = "SELECT * FROM presupuestos WHERE usuarioId = ? AND mes = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, usuarioId);
    _argIndex = 2;
    if (mes == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, mes);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
      final int _cursorIndexOfMontoTotal = CursorUtil.getColumnIndexOrThrow(_cursor, "montoTotal");
      final int _cursorIndexOfMontoGastado = CursorUtil.getColumnIndexOrThrow(_cursor, "montoGastado");
      final int _cursorIndexOfMes = CursorUtil.getColumnIndexOrThrow(_cursor, "mes");
      final int _cursorIndexOfUsuarioId = CursorUtil.getColumnIndexOrThrow(_cursor, "usuarioId");
      final List<Presupuesto> _result = new ArrayList<Presupuesto>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Presupuesto _item;
        _item = new Presupuesto();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpNombre;
        if (_cursor.isNull(_cursorIndexOfNombre)) {
          _tmpNombre = null;
        } else {
          _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
        }
        _item.setNombre(_tmpNombre);
        final double _tmpMontoTotal;
        _tmpMontoTotal = _cursor.getDouble(_cursorIndexOfMontoTotal);
        _item.setMontoTotal(_tmpMontoTotal);
        final double _tmpMontoGastado;
        _tmpMontoGastado = _cursor.getDouble(_cursorIndexOfMontoGastado);
        _item.setMontoGastado(_tmpMontoGastado);
        final String _tmpMes;
        if (_cursor.isNull(_cursorIndexOfMes)) {
          _tmpMes = null;
        } else {
          _tmpMes = _cursor.getString(_cursorIndexOfMes);
        }
        _item.setMes(_tmpMes);
        final int _tmpUsuarioId;
        _tmpUsuarioId = _cursor.getInt(_cursorIndexOfUsuarioId);
        _item.setUsuarioId(_tmpUsuarioId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Presupuesto> buscarPorNombre(final int usuarioId, final String nombre) {
    final String _sql = "SELECT * FROM presupuestos WHERE usuarioId = ? AND nombre LIKE '%' || ? || '%'";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, usuarioId);
    _argIndex = 2;
    if (nombre == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, nombre);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
      final int _cursorIndexOfMontoTotal = CursorUtil.getColumnIndexOrThrow(_cursor, "montoTotal");
      final int _cursorIndexOfMontoGastado = CursorUtil.getColumnIndexOrThrow(_cursor, "montoGastado");
      final int _cursorIndexOfMes = CursorUtil.getColumnIndexOrThrow(_cursor, "mes");
      final int _cursorIndexOfUsuarioId = CursorUtil.getColumnIndexOrThrow(_cursor, "usuarioId");
      final List<Presupuesto> _result = new ArrayList<Presupuesto>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Presupuesto _item;
        _item = new Presupuesto();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpNombre;
        if (_cursor.isNull(_cursorIndexOfNombre)) {
          _tmpNombre = null;
        } else {
          _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
        }
        _item.setNombre(_tmpNombre);
        final double _tmpMontoTotal;
        _tmpMontoTotal = _cursor.getDouble(_cursorIndexOfMontoTotal);
        _item.setMontoTotal(_tmpMontoTotal);
        final double _tmpMontoGastado;
        _tmpMontoGastado = _cursor.getDouble(_cursorIndexOfMontoGastado);
        _item.setMontoGastado(_tmpMontoGastado);
        final String _tmpMes;
        if (_cursor.isNull(_cursorIndexOfMes)) {
          _tmpMes = null;
        } else {
          _tmpMes = _cursor.getString(_cursorIndexOfMes);
        }
        _item.setMes(_tmpMes);
        final int _tmpUsuarioId;
        _tmpUsuarioId = _cursor.getInt(_cursorIndexOfUsuarioId);
        _item.setUsuarioId(_tmpUsuarioId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public Double obtenerTotalPresupuestado(final int usuarioId, final String mes) {
    final String _sql = "SELECT SUM(montoTotal) FROM presupuestos WHERE usuarioId = ? AND mes = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, usuarioId);
    _argIndex = 2;
    if (mes == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, mes);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final Double _result;
      if (_cursor.moveToFirst()) {
        final Double _tmp;
        if (_cursor.isNull(0)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getDouble(0);
        }
        _result = _tmp;
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
  public Double obtenerTotalGastado(final int usuarioId, final String mes) {
    final String _sql = "SELECT SUM(montoGastado) FROM presupuestos WHERE usuarioId = ? AND mes = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, usuarioId);
    _argIndex = 2;
    if (mes == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, mes);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final Double _result;
      if (_cursor.moveToFirst()) {
        final Double _tmp;
        if (_cursor.isNull(0)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getDouble(0);
        }
        _result = _tmp;
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
  public List<Presupuesto> obtenerPresupuestosCercaDelLimite(final int usuarioId) {
    final String _sql = "SELECT * FROM presupuestos WHERE usuarioId = ? AND montoGastado > montoTotal * 0.8";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, usuarioId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
      final int _cursorIndexOfMontoTotal = CursorUtil.getColumnIndexOrThrow(_cursor, "montoTotal");
      final int _cursorIndexOfMontoGastado = CursorUtil.getColumnIndexOrThrow(_cursor, "montoGastado");
      final int _cursorIndexOfMes = CursorUtil.getColumnIndexOrThrow(_cursor, "mes");
      final int _cursorIndexOfUsuarioId = CursorUtil.getColumnIndexOrThrow(_cursor, "usuarioId");
      final List<Presupuesto> _result = new ArrayList<Presupuesto>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Presupuesto _item;
        _item = new Presupuesto();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpNombre;
        if (_cursor.isNull(_cursorIndexOfNombre)) {
          _tmpNombre = null;
        } else {
          _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
        }
        _item.setNombre(_tmpNombre);
        final double _tmpMontoTotal;
        _tmpMontoTotal = _cursor.getDouble(_cursorIndexOfMontoTotal);
        _item.setMontoTotal(_tmpMontoTotal);
        final double _tmpMontoGastado;
        _tmpMontoGastado = _cursor.getDouble(_cursorIndexOfMontoGastado);
        _item.setMontoGastado(_tmpMontoGastado);
        final String _tmpMes;
        if (_cursor.isNull(_cursorIndexOfMes)) {
          _tmpMes = null;
        } else {
          _tmpMes = _cursor.getString(_cursorIndexOfMes);
        }
        _item.setMes(_tmpMes);
        final int _tmpUsuarioId;
        _tmpUsuarioId = _cursor.getInt(_cursorIndexOfUsuarioId);
        _item.setUsuarioId(_tmpUsuarioId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public List<Presupuesto> obtenerPresupuestosExcedidos(final int usuarioId) {
    final String _sql = "SELECT * FROM presupuestos WHERE usuarioId = ? AND montoGastado > montoTotal";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, usuarioId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
      final int _cursorIndexOfMontoTotal = CursorUtil.getColumnIndexOrThrow(_cursor, "montoTotal");
      final int _cursorIndexOfMontoGastado = CursorUtil.getColumnIndexOrThrow(_cursor, "montoGastado");
      final int _cursorIndexOfMes = CursorUtil.getColumnIndexOrThrow(_cursor, "mes");
      final int _cursorIndexOfUsuarioId = CursorUtil.getColumnIndexOrThrow(_cursor, "usuarioId");
      final List<Presupuesto> _result = new ArrayList<Presupuesto>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Presupuesto _item;
        _item = new Presupuesto();
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpNombre;
        if (_cursor.isNull(_cursorIndexOfNombre)) {
          _tmpNombre = null;
        } else {
          _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
        }
        _item.setNombre(_tmpNombre);
        final double _tmpMontoTotal;
        _tmpMontoTotal = _cursor.getDouble(_cursorIndexOfMontoTotal);
        _item.setMontoTotal(_tmpMontoTotal);
        final double _tmpMontoGastado;
        _tmpMontoGastado = _cursor.getDouble(_cursorIndexOfMontoGastado);
        _item.setMontoGastado(_tmpMontoGastado);
        final String _tmpMes;
        if (_cursor.isNull(_cursorIndexOfMes)) {
          _tmpMes = null;
        } else {
          _tmpMes = _cursor.getString(_cursorIndexOfMes);
        }
        _item.setMes(_tmpMes);
        final int _tmpUsuarioId;
        _tmpUsuarioId = _cursor.getInt(_cursorIndexOfUsuarioId);
        _item.setUsuarioId(_tmpUsuarioId);
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
