//package data.big.spark;
//
//import java.sql.DriverManager;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.Statement;
//
//public class MysqlDBTest {
//	public static void main(String []args) {
//		Connection con = null;
//        Statement st = null;
//        ResultSet rs = null;
//
//        String url = "jdbc:mysql://localhost:3306/test";
//        String user = "root";
//        String password = "admin";
//
//        try {
//            con = (Connection) DriverManager.getConnection(url, user, password);
//            st = (Statement) con.createStatement();
//            //rs = st.executeQuery("SELECT VERSION()");
//            rs = st.executeQuery("SELECT * FROM EMP");
//            while (rs.next()) {
//                System.out.println(rs.getString(1) + " : " + rs.getString(2) + " : " + rs.getString(3));
//            }
//        } catch (SQLException ex) {
//        	ex.printStackTrace();
//        } finally {
//            try {
//                if (rs != null) {
//                    rs.close();
//                }
//                if (st != null) {
//                    st.close();
//                }
//                if (con != null) {
//                    con.close();
//                }
//            } catch (SQLException ex) {
//            	ex.printStackTrace();
//            }
//        }
//	}
//}
