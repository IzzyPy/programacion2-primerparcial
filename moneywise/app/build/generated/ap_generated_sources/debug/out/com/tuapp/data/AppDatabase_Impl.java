package com.tuapp.data;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.migration.AutoMigrationSpec;
import androidx.room.migration.Migration;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.tuapp.dao.CategoriaDao;
import com.tuapp.dao.CategoriaDao_Impl;
import com.tuapp.dao.CuentaDao;
import com.tuapp.dao.CuentaDao_Impl;
import com.tuapp.dao.PresupuestoDao;
import com.tuapp.dao.PresupuestoDao_Impl;
import com.tuapp.dao.TransaccionDao;
import com.tuapp.dao.TransaccionDao_Impl;
import com.tuapp.dao.UsuarioDao;
import com.tuapp.dao.UsuarioDao_Impl;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile UsuarioDao _usuarioDao;

  private volatile PresupuestoDao _presupuestoDao;

  private volatile CuentaDao _cuentaDao;

  private volatile TransaccionDao _transaccionDao;

  private volatile CategoriaDao _categoriaDao;

  @Override
  @NonNull
  protected SupportSQLiteOpenHelper createOpenHelper(@NonNull final DatabaseConfiguration config) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(config, new RoomOpenHelper.Delegate(1) {
      @Override
      public void createAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS `usuarios` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `nombre` TEXT, `email` TEXT, `password` TEXT)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `presupuestos` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `nombre` TEXT, `montoTotal` REAL NOT NULL, `montoGastado` REAL NOT NULL, `mes` TEXT, `usuarioId` INTEGER NOT NULL, FOREIGN KEY(`usuarioId`) REFERENCES `usuarios`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_presupuestos_usuarioId` ON `presupuestos` (`usuarioId`)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `cuentas` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `nombre` TEXT, `saldoInicial` REAL NOT NULL, `saldoActual` REAL NOT NULL, `usuarioId` INTEGER NOT NULL, FOREIGN KEY(`usuarioId`) REFERENCES `usuarios`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_cuentas_usuarioId` ON `cuentas` (`usuarioId`)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `transacciones` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `usuarioId` INTEGER, `descripcion` TEXT, `monto` REAL, `tipo` TEXT, `fecha` INTEGER, `categoriaId` INTEGER, `cuentaId` INTEGER, FOREIGN KEY(`usuarioId`) REFERENCES `usuarios`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE , FOREIGN KEY(`categoriaId`) REFERENCES `categorias`(`id`) ON UPDATE NO ACTION ON DELETE SET NULL , FOREIGN KEY(`cuentaId`) REFERENCES `cuentas`(`id`) ON UPDATE NO ACTION ON DELETE SET NULL )");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_transacciones_usuarioId` ON `transacciones` (`usuarioId`)");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_transacciones_categoriaId` ON `transacciones` (`categoriaId`)");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_transacciones_cuentaId` ON `transacciones` (`cuentaId`)");
        db.execSQL("CREATE TABLE IF NOT EXISTS `categorias` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `nombre` TEXT, `tipo` TEXT, `icono` TEXT, `usuarioId` INTEGER NOT NULL, FOREIGN KEY(`usuarioId`) REFERENCES `usuarios`(`id`) ON UPDATE NO ACTION ON DELETE CASCADE )");
        db.execSQL("CREATE INDEX IF NOT EXISTS `index_categorias_usuarioId` ON `categorias` (`usuarioId`)");
        db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'd37326f27958edc3d0ff93d432a68165')");
      }

      @Override
      public void dropAllTables(@NonNull final SupportSQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS `usuarios`");
        db.execSQL("DROP TABLE IF EXISTS `presupuestos`");
        db.execSQL("DROP TABLE IF EXISTS `cuentas`");
        db.execSQL("DROP TABLE IF EXISTS `transacciones`");
        db.execSQL("DROP TABLE IF EXISTS `categorias`");
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onDestructiveMigration(db);
          }
        }
      }

      @Override
      public void onCreate(@NonNull final SupportSQLiteDatabase db) {
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onCreate(db);
          }
        }
      }

      @Override
      public void onOpen(@NonNull final SupportSQLiteDatabase db) {
        mDatabase = db;
        db.execSQL("PRAGMA foreign_keys = ON");
        internalInitInvalidationTracker(db);
        final List<? extends RoomDatabase.Callback> _callbacks = mCallbacks;
        if (_callbacks != null) {
          for (RoomDatabase.Callback _callback : _callbacks) {
            _callback.onOpen(db);
          }
        }
      }

      @Override
      public void onPreMigrate(@NonNull final SupportSQLiteDatabase db) {
        DBUtil.dropFtsSyncTriggers(db);
      }

      @Override
      public void onPostMigrate(@NonNull final SupportSQLiteDatabase db) {
      }

      @Override
      @NonNull
      public RoomOpenHelper.ValidationResult onValidateSchema(
          @NonNull final SupportSQLiteDatabase db) {
        final HashMap<String, TableInfo.Column> _columnsUsuarios = new HashMap<String, TableInfo.Column>(4);
        _columnsUsuarios.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsuarios.put("nombre", new TableInfo.Column("nombre", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsuarios.put("email", new TableInfo.Column("email", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsUsuarios.put("password", new TableInfo.Column("password", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysUsuarios = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesUsuarios = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoUsuarios = new TableInfo("usuarios", _columnsUsuarios, _foreignKeysUsuarios, _indicesUsuarios);
        final TableInfo _existingUsuarios = TableInfo.read(db, "usuarios");
        if (!_infoUsuarios.equals(_existingUsuarios)) {
          return new RoomOpenHelper.ValidationResult(false, "usuarios(com.tuapp.entity.Usuario).\n"
                  + " Expected:\n" + _infoUsuarios + "\n"
                  + " Found:\n" + _existingUsuarios);
        }
        final HashMap<String, TableInfo.Column> _columnsPresupuestos = new HashMap<String, TableInfo.Column>(6);
        _columnsPresupuestos.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPresupuestos.put("nombre", new TableInfo.Column("nombre", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPresupuestos.put("montoTotal", new TableInfo.Column("montoTotal", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPresupuestos.put("montoGastado", new TableInfo.Column("montoGastado", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPresupuestos.put("mes", new TableInfo.Column("mes", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsPresupuestos.put("usuarioId", new TableInfo.Column("usuarioId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysPresupuestos = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysPresupuestos.add(new TableInfo.ForeignKey("usuarios", "CASCADE", "NO ACTION", Arrays.asList("usuarioId"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesPresupuestos = new HashSet<TableInfo.Index>(1);
        _indicesPresupuestos.add(new TableInfo.Index("index_presupuestos_usuarioId", false, Arrays.asList("usuarioId"), Arrays.asList("ASC")));
        final TableInfo _infoPresupuestos = new TableInfo("presupuestos", _columnsPresupuestos, _foreignKeysPresupuestos, _indicesPresupuestos);
        final TableInfo _existingPresupuestos = TableInfo.read(db, "presupuestos");
        if (!_infoPresupuestos.equals(_existingPresupuestos)) {
          return new RoomOpenHelper.ValidationResult(false, "presupuestos(com.tuapp.entity.Presupuesto).\n"
                  + " Expected:\n" + _infoPresupuestos + "\n"
                  + " Found:\n" + _existingPresupuestos);
        }
        final HashMap<String, TableInfo.Column> _columnsCuentas = new HashMap<String, TableInfo.Column>(5);
        _columnsCuentas.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCuentas.put("nombre", new TableInfo.Column("nombre", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCuentas.put("saldoInicial", new TableInfo.Column("saldoInicial", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCuentas.put("saldoActual", new TableInfo.Column("saldoActual", "REAL", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCuentas.put("usuarioId", new TableInfo.Column("usuarioId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCuentas = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysCuentas.add(new TableInfo.ForeignKey("usuarios", "CASCADE", "NO ACTION", Arrays.asList("usuarioId"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesCuentas = new HashSet<TableInfo.Index>(1);
        _indicesCuentas.add(new TableInfo.Index("index_cuentas_usuarioId", false, Arrays.asList("usuarioId"), Arrays.asList("ASC")));
        final TableInfo _infoCuentas = new TableInfo("cuentas", _columnsCuentas, _foreignKeysCuentas, _indicesCuentas);
        final TableInfo _existingCuentas = TableInfo.read(db, "cuentas");
        if (!_infoCuentas.equals(_existingCuentas)) {
          return new RoomOpenHelper.ValidationResult(false, "cuentas(com.tuapp.entity.Cuenta).\n"
                  + " Expected:\n" + _infoCuentas + "\n"
                  + " Found:\n" + _existingCuentas);
        }
        final HashMap<String, TableInfo.Column> _columnsTransacciones = new HashMap<String, TableInfo.Column>(8);
        _columnsTransacciones.put("id", new TableInfo.Column("id", "INTEGER", false, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTransacciones.put("usuarioId", new TableInfo.Column("usuarioId", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTransacciones.put("descripcion", new TableInfo.Column("descripcion", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTransacciones.put("monto", new TableInfo.Column("monto", "REAL", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTransacciones.put("tipo", new TableInfo.Column("tipo", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTransacciones.put("fecha", new TableInfo.Column("fecha", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTransacciones.put("categoriaId", new TableInfo.Column("categoriaId", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTransacciones.put("cuentaId", new TableInfo.Column("cuentaId", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTransacciones = new HashSet<TableInfo.ForeignKey>(3);
        _foreignKeysTransacciones.add(new TableInfo.ForeignKey("usuarios", "CASCADE", "NO ACTION", Arrays.asList("usuarioId"), Arrays.asList("id")));
        _foreignKeysTransacciones.add(new TableInfo.ForeignKey("categorias", "SET NULL", "NO ACTION", Arrays.asList("categoriaId"), Arrays.asList("id")));
        _foreignKeysTransacciones.add(new TableInfo.ForeignKey("cuentas", "SET NULL", "NO ACTION", Arrays.asList("cuentaId"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesTransacciones = new HashSet<TableInfo.Index>(3);
        _indicesTransacciones.add(new TableInfo.Index("index_transacciones_usuarioId", false, Arrays.asList("usuarioId"), Arrays.asList("ASC")));
        _indicesTransacciones.add(new TableInfo.Index("index_transacciones_categoriaId", false, Arrays.asList("categoriaId"), Arrays.asList("ASC")));
        _indicesTransacciones.add(new TableInfo.Index("index_transacciones_cuentaId", false, Arrays.asList("cuentaId"), Arrays.asList("ASC")));
        final TableInfo _infoTransacciones = new TableInfo("transacciones", _columnsTransacciones, _foreignKeysTransacciones, _indicesTransacciones);
        final TableInfo _existingTransacciones = TableInfo.read(db, "transacciones");
        if (!_infoTransacciones.equals(_existingTransacciones)) {
          return new RoomOpenHelper.ValidationResult(false, "transacciones(com.tuapp.entity.Transaccion).\n"
                  + " Expected:\n" + _infoTransacciones + "\n"
                  + " Found:\n" + _existingTransacciones);
        }
        final HashMap<String, TableInfo.Column> _columnsCategorias = new HashMap<String, TableInfo.Column>(5);
        _columnsCategorias.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCategorias.put("nombre", new TableInfo.Column("nombre", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCategorias.put("tipo", new TableInfo.Column("tipo", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCategorias.put("icono", new TableInfo.Column("icono", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsCategorias.put("usuarioId", new TableInfo.Column("usuarioId", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysCategorias = new HashSet<TableInfo.ForeignKey>(1);
        _foreignKeysCategorias.add(new TableInfo.ForeignKey("usuarios", "CASCADE", "NO ACTION", Arrays.asList("usuarioId"), Arrays.asList("id")));
        final HashSet<TableInfo.Index> _indicesCategorias = new HashSet<TableInfo.Index>(1);
        _indicesCategorias.add(new TableInfo.Index("index_categorias_usuarioId", false, Arrays.asList("usuarioId"), Arrays.asList("ASC")));
        final TableInfo _infoCategorias = new TableInfo("categorias", _columnsCategorias, _foreignKeysCategorias, _indicesCategorias);
        final TableInfo _existingCategorias = TableInfo.read(db, "categorias");
        if (!_infoCategorias.equals(_existingCategorias)) {
          return new RoomOpenHelper.ValidationResult(false, "categorias(com.tuapp.entity.Categoria).\n"
                  + " Expected:\n" + _infoCategorias + "\n"
                  + " Found:\n" + _existingCategorias);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "d37326f27958edc3d0ff93d432a68165", "01459119116f06a63edad94d41039d33");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(config.context).name(config.name).callback(_openCallback).build();
    final SupportSQLiteOpenHelper _helper = config.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  @NonNull
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(0);
    final HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "usuarios","presupuestos","cuentas","transacciones","categorias");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    final boolean _supportsDeferForeignKeys = android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP;
    try {
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = FALSE");
      }
      super.beginTransaction();
      if (_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA defer_foreign_keys = TRUE");
      }
      _db.execSQL("DELETE FROM `usuarios`");
      _db.execSQL("DELETE FROM `presupuestos`");
      _db.execSQL("DELETE FROM `cuentas`");
      _db.execSQL("DELETE FROM `transacciones`");
      _db.execSQL("DELETE FROM `categorias`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      if (!_supportsDeferForeignKeys) {
        _db.execSQL("PRAGMA foreign_keys = TRUE");
      }
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  @NonNull
  protected Map<Class<?>, List<Class<?>>> getRequiredTypeConverters() {
    final HashMap<Class<?>, List<Class<?>>> _typeConvertersMap = new HashMap<Class<?>, List<Class<?>>>();
    _typeConvertersMap.put(UsuarioDao.class, UsuarioDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(PresupuestoDao.class, PresupuestoDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(CuentaDao.class, CuentaDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(TransaccionDao.class, TransaccionDao_Impl.getRequiredConverters());
    _typeConvertersMap.put(CategoriaDao.class, CategoriaDao_Impl.getRequiredConverters());
    return _typeConvertersMap;
  }

  @Override
  @NonNull
  public Set<Class<? extends AutoMigrationSpec>> getRequiredAutoMigrationSpecs() {
    final HashSet<Class<? extends AutoMigrationSpec>> _autoMigrationSpecsSet = new HashSet<Class<? extends AutoMigrationSpec>>();
    return _autoMigrationSpecsSet;
  }

  @Override
  @NonNull
  public List<Migration> getAutoMigrations(
      @NonNull final Map<Class<? extends AutoMigrationSpec>, AutoMigrationSpec> autoMigrationSpecs) {
    final List<Migration> _autoMigrations = new ArrayList<Migration>();
    return _autoMigrations;
  }

  @Override
  public UsuarioDao usuarioDao() {
    if (_usuarioDao != null) {
      return _usuarioDao;
    } else {
      synchronized(this) {
        if(_usuarioDao == null) {
          _usuarioDao = new UsuarioDao_Impl(this);
        }
        return _usuarioDao;
      }
    }
  }

  @Override
  public PresupuestoDao presupuestoDao() {
    if (_presupuestoDao != null) {
      return _presupuestoDao;
    } else {
      synchronized(this) {
        if(_presupuestoDao == null) {
          _presupuestoDao = new PresupuestoDao_Impl(this);
        }
        return _presupuestoDao;
      }
    }
  }

  @Override
  public CuentaDao cuentaDao() {
    if (_cuentaDao != null) {
      return _cuentaDao;
    } else {
      synchronized(this) {
        if(_cuentaDao == null) {
          _cuentaDao = new CuentaDao_Impl(this);
        }
        return _cuentaDao;
      }
    }
  }

  @Override
  public TransaccionDao transaccionDao() {
    if (_transaccionDao != null) {
      return _transaccionDao;
    } else {
      synchronized(this) {
        if(_transaccionDao == null) {
          _transaccionDao = new TransaccionDao_Impl(this);
        }
        return _transaccionDao;
      }
    }
  }

  @Override
  public CategoriaDao categoriaDao() {
    if (_categoriaDao != null) {
      return _categoriaDao;
    } else {
      synchronized(this) {
        if(_categoriaDao == null) {
          _categoriaDao = new CategoriaDao_Impl(this);
        }
        return _categoriaDao;
      }
    }
  }
}
