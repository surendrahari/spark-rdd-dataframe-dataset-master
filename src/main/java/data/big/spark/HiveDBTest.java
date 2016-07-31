package data.big.spark;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.hive.HiveContext;

public class HiveDBTest {

	private static String driverName = "org.apache.hadoop.hive.jdbc.HiveDriver";

	public static void main(String[] args) throws Exception {
		show_Spark();
	}

	private static void show_Spark() throws Exception {
		// Define a configuration to use to interact with Spark
		SparkConf conf = new SparkConf().setMaster("local[*]").setAppName(
				"Work Count App");

		// Create a Java version of the Spark Context from the configuration
		// Load the input data, which is a text file read from the command line
		JavaSparkContext sc = new JavaSparkContext(conf);
		HiveContext hc = new HiveContext(sc);

		// System.out.println(input.count());
		// System.out.println(input.toArray());
	}

	private static void show() throws SQLException, ClassNotFoundException {
		System.out.println("begin...");
		// Register driver and create driver instance
		Class.forName(driverName);
		System.out.println("driver loaded...");
		// get connection
		Connection con = DriverManager.getConnection(
				"jdbc:hive2://localhost:10000/default", "hiveuser",
				"hivepassword");
		System.out.println("connection...");
		Statement stmt = (Statement) con.createStatement();
		System.out.println("created statement...");
		ResultSet rs = stmt.executeQuery("show databases");
		System.out.println("results...");
		while (rs.next()) {
			System.out.println(rs.getObject(1));
		}
		System.out.println("End..");
		con.close();
	}
}
