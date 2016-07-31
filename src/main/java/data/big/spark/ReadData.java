package data.big.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class ReadData {

	public static void main(String[] args) {
		// Define a configuration to use to interact with Spark
		SparkConf conf = new SparkConf().setMaster("local[*]").setAppName("Work Count App");

		// Create a Java version of the Spark Context from the configuration
		// Load the input data, which is a text file read from the command line
		JavaRDD<String> input = (new JavaSparkContext(conf)).textFile("hdfs://localhost:9000/user/input/test.java");

		System.out.println(input.count());
		System.out.println(input.toArray());
		
	}
}
