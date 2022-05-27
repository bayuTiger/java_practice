package inheritance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

// LooseCouplingInterfacePractice, InMemoryDB, SQLiteDB の3クラスで使用している DatabaseIF というインタフェースを作成

// class LooseCouplingInterfacePractice {
//   // 以下の戻り値で使用している DatabaseIF は疎結合を目的としたもの。
//   // 戻り値をInterfaceとすることで、実際に返すインスタンスをenvの値によって差し替えられるようにしている。
//   // メソッドを InMemoryDB getDB(String env) 等のように定義すると、InMemoryDB しか返せないし、
//   // もし返す型を変えたい、となったとき、getDBメソッドだけではなく、getDBメソッドを呼んでいる側も治す必要がでてくる。
//   // 戻り値をInterfaceとすることで、呼び出し側はどんなインスタンスが返されるか考慮する必要がなくなり、修正頻度を減らすことができる。
//   // getDBの実装者も、呼び出し側を考慮することなく、返すインスタンスの変更ができるようになる。
//   public static DatabaseIF getDB(String env) {
//     if (env != null && env.equals("production")) {
//       return new SQLiteDB("jdbc:sqlite:./test.sqlite3");
//     }
//     return new InMemoryDB();
//   }

//   public static DatabaseIF getDB() {
//     return getDB("");
//   }; // 引数なしで呼び出すことができるように追加

//   public static void main(String[] args) {
//     DatabaseIF db = getDB("production");
//     List<Map<String, Object>> result = db.select("users");
//     System.out.println(result);
//   }
// }

// class InMemoryDB implements DatabaseIF {
//   private Map<String, List<Map<String, Object>>> data;

//   public InMemoryDB() {
//     this.data = new HashMap<>();

//     // テストデータ投入
//     List<Map<String, Object>> users = new ArrayList<>();
//     Map<String, Object> row = new HashMap<>();
//     row.put("id", 1);
//     row.put("username", "test");
//     users.add(row);
//     this.data.put("users", users);
//   }

//   public List<Map<String, Object>> select(String tableName) {
//     return this.data.get(tableName);
//   }

//   public void insert(String tableName, Map<String, Object> row) {
//     this.data.get(tableName).add(row);
//   }
// }

// class SQLiteDB implements DatabaseIF {
//   private Connection conn;

//   public SQLiteDB(String jdbcUrl) {
//     try {
//       Class.forName("org.sqlite.JDBC");

//       this.conn = DriverManager.getConnection(jdbcUrl);
//       Statement stmt = conn.createStatement();
//       String sql = "create table if not exists users(id integer primary key, username text)";
//       stmt.executeUpdate(sql);

//       // テストデータ投入
//       sql = "insert into users (id, username) values (1, 'test')";
//       stmt.executeUpdate(sql);
//     } catch (SQLException | ClassNotFoundException e) {
//       throw new RuntimeException(e);
//     }
//   }

//   public List<Map<String, Object>> select(String tableName) {
//     final String sql = "select * from " + tableName;
//     List<Map<String, Object>> result = new ArrayList<>();

//     try (PreparedStatement ps = conn.prepareStatement(sql);
//         ResultSet rs = ps.executeQuery();) {
//       ResultSetMetaData meta = rs.getMetaData();
//       int columnCount = meta.getColumnCount();
//       while (rs.next()) {
//         Map<String, Object> row = new HashMap<>();
//         for (int i = 1; i <= columnCount; i++) {
//           row.put(meta.getColumnLabel(i), rs.getObject(i));
//         }
//         result.add(row);
//       }
//     } catch (SQLException e) {
//       throw new RuntimeException(e);
//     }

//     return result;
//   }

//   public void insert(String tableName, Map<String, Object> row) {
//     StringBuilder sb = new StringBuilder("insert into " + tableName + "( ");
//     boolean isFirstRow = true;

//     for (Entry<String, Object> entry : row.entrySet()) {
//       if (!isFirstRow) {
//         sb.append(",");
//       }
//       sb.append(entry.getKey());
//     }
//     sb.append(" ) VALUES ( ");

//     isFirstRow = true;
//     for (int i = 0; i < row.size(); i++) {
//       if (!isFirstRow) {
//         sb.append(",");
//       }
//       sb.append("?");
//     }
//     sb.append(")");

//     final String sql = sb.toString();

//     try {
//       this.conn.setAutoCommit(false);

//       try (PreparedStatement ps = conn.prepareStatement(sql)) {
//         int count = 1;
//         for (Object value : row.values()) {
//           ps.setObject(count++, value);
//         }

//         this.conn.commit();
//       } catch (SQLException e) {
//         this.conn.rollback();
//         throw e;
//       }
//     } catch (Exception e) {
//       throw new RuntimeException(e);
//     }
//   }
// }

interface DatabaseIF {

  List<Map<String, Object>> select(String string);
  public void insert(String tableName, Map<String, Object> row);

}

public class LooseCouplingInterfacePractice {

  public static DatabaseIF getDB(String env) {
    if (env != null && env.equals("production")) {
      return new SQLiteDB("jdbc:sqlite:./test.sqlite3");
    }
    return new InMemoryDB();
  }

  // 引数なしで呼び出すことができるように追加
  public static void main(String[] args) {
    DatabaseIF db = getDB("production");
    List<Map<String, Object>> result = db.select("users");
    System.out.println(result);
  }
}

class InMemoryDB implements DatabaseIF {
  private Map<String, List<Map<String, Object>>> data;

  public InMemoryDB() {
    this.data = new HashMap<>();

    // テストデータ投入
    List<Map<String, Object>> users = new ArrayList<>();
    Map<String, Object> row = new HashMap<>();
    row.put("id", 1);
    row.put("username", "test");
    users.add(row);
    this.data.put("users", users);
  }

  public List<Map<String, Object>> select(String tableName) {
    return this.data.get(tableName);
  }

  public void insert(String tableName, Map<String, Object> row) {
    this.data.get(tableName).add(row);
  }
}

class SQLiteDB implements DatabaseIF {
  private Connection conn;

  public SQLiteDB(String jdbcUrl) {
    try {
      Class.forName("org.sqlite.JDBC");

      this.conn = DriverManager.getConnection(jdbcUrl);
      Statement stmt = conn.createStatement();
      String sql = "create table if not exists users(id integer primary key, username text)";
      stmt.executeUpdate(sql);

      // テストデータ投入
      sql = "insert into users (id, username) values (1, 'test')";
      stmt.executeUpdate(sql);
    } catch (SQLException | ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  public List<Map<String, Object>> select(String tableName) {
    final String sql = "select * from " + tableName;
    List<Map<String, Object>> result = new ArrayList<>();

    try (PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();) {
      ResultSetMetaData meta = rs.getMetaData();
      int columnCount = meta.getColumnCount();
      while (rs.next()) {
        Map<String, Object> row = new HashMap<>();
        for (int i = 1; i <= columnCount; i++) {
          row.put(meta.getColumnLabel(i), rs.getObject(i));
        }
        result.add(row);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

    return result;
  }

  public void insert(String tableName, Map<String, Object> row) {
    StringBuilder sb = new StringBuilder("insert into " + tableName + "( ");
    boolean isFirstRow = true;

    for (Entry<String, Object> entry : row.entrySet()) {
      if (!isFirstRow) {
        sb.append(",");
      }
      sb.append(entry.getKey());
    }
    sb.append(" ) VALUES ( ");

    isFirstRow = true;
    for (int i = 0; i < row.size(); i++) {
      if (!isFirstRow) {
        sb.append(",");
      }
      sb.append("?");
    }
    sb.append(")");

    final String sql = sb.toString();

    try {
      this.conn.setAutoCommit(false);

      try (PreparedStatement ps = conn.prepareStatement(sql)) {
        int count = 1;
        for (Object value : row.values()) {
          ps.setObject(count++, value);
        }

        this.conn.commit();
      } catch (SQLException e) {
        this.conn.rollback();
        throw e;
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
