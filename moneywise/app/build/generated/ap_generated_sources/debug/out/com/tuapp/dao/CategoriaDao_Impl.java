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
import com.tuapp.entity.Categoria;
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
public final class CategoriaDao_Impl implements CategoriaDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Categoria> __insertionAdapterOfCategoria;

  private final EntityDeletionOrUpdateAdapter<Categoria> __deletionAdapterOfCategoria;

  private final EntityDeletionOrUpdateAdapter<Categoria> __updateAdapterOfCategoria;

  public CategoriaDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCategoria = new EntityInsertionAdapter<Categoria>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `categorias` (`id`,`nombre`,`tipo`,`icono`,`usuarioId`) VALUES (nullif(?, 0),?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Categoria entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getNombre() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getNombre());
        }
        if (entity.getTipo() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getTipo());
        }
        if (entity.getIcono() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getIcono());
        }
        statement.bindLong(5, entity.getUsuarioId());
      }
    };
    this.__deletionAdapterOfCategoria = new EntityDeletionOrUpdateAdapter<Categoria>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `categorias` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Categoria entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfCategoria = new EntityDeletionOrUpdateAdapter<Categoria>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `categorias` SET `id` = ?,`nombre` = ?,`tipo` = ?,`icono` = ?,`usuarioId` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement, final Categoria entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getNombre() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getNombre());
        }
        if (entity.getTipo() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getTipo());
        }
        if (entity.getIcono() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getIcono());
        }
        statement.bindLong(5, entity.getUsuarioId());
        statement.bindLong(6, entity.getId());
      }
    };
  }

  @Override
  public long insertar(final Categoria categoria) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      final long _result = __insertionAdapterOfCategoria.insertAndReturnId(categoria);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void eliminar(final Categoria categoria) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfCategoria.handle(categoria);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void actualizar(final Categoria categoria) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfCategoria.handle(categoria);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<Categoria> obtenerPorUsuario(final int usuarioId) {
    final String _sql = "SELECT * FROM categorias WHERE usuarioId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, usuarioId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
      final int _cursorIndexOfTipo = CursorUtil.getColumnIndexOrThrow(_cursor, "tipo");
      final int _cursorIndexOfIcono = CursorUtil.getColumnIndexOrThrow(_cursor, "icono");
      final int _cursorIndexOfUsuarioId = CursorUtil.getColumnIndexOrThrow(_cursor, "usuarioId");
      final List<Categoria> _result = new ArrayList<Categoria>(_cursor.getCount());
      while (_cursor.moveToNext()) {
        final Categoria _item;
        final String _tmpNombre;
        if (_cursor.isNull(_cursorIndexOfNombre)) {
          _tmpNombre = null;
        } else {
          _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
        }
        final String _tmpTipo;
        if (_cursor.isNull(_cursorIndexOfTipo)) {
          _tmpTipo = null;
        } else {
          _tmpTipo = _cursor.getString(_cursorIndexOfTipo);
        }
        final String _tmpIcono;
        if (_cursor.isNull(_cursorIndexOfIcono)) {
          _tmpIcono = null;
        } else {
          _tmpIcono = _cursor.getString(_cursorIndexOfIcono);
        }
        final int _tmpUsuarioId;
        _tmpUsuarioId = _cursor.getInt(_cursorIndexOfUsuarioId);
        _item = new Categoria(_tmpNombre,_tmpTipo,_tmpIcono,_tmpUsuarioId);
        final int _tmpId;
        _tmpId = _cursor.getInt(_cursorIndexOfId);
        _item.setId(_tmpId);
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
