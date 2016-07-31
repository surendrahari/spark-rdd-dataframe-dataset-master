package data.big.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class Test {
	private static void fun1() {
		// SparkConf sparkConf = new SparkConf().setAppName("SparkSaveToHDFS");
		// JavaSparkContext ctx = new JavaSparkContext(sparkConf);

		// JavaRDD<Person> personRdd = ctx.parallelize(personList);
		// personRdd.saveAsObjectFile("hdfs://hadoop-master:8020/Peter/test");
	}

	public static void main(String[] args) {

		// Define a configuration to use to interact with Spark
		SparkConf conf = new SparkConf().setMaster("local[*]").setAppName(
				"Work Count App");

		// Create a Java version of the Spark Context from the configuration
		JavaSparkContext sc = new JavaSparkContext(conf);

		// Load the input data, which is a text file read from the command line
		JavaRDD<String> input = sc.textFile("pom2.xml");

//		 JavaStreamingContext jssc = new JavaStreamingContext(conf, new Duration(60000));

		// Create a DStream that will connect to hostname:port, like
		// localhost:9999
		// JavaReceiverInputDStream<String> lines =
		// jssc.socketTextStream("localhost", 9999);

		// Split each line into words
		// JavaDStream<String> input = jssc.textFileStream("pom2.xml");
		// JavaDStream<String> input = lines.flatMap(
		// new FlatMapFunction<String, String>() {
		// @Override public Iterable<String> call(String x) {
		// return Arrays.asList(x.split(" "));
		// }
		// });

		System.out.println(input);

		input.saveAsTextFile("hdfs://namenode:8020/user/input/abc.txt");
		
		// words.foreach(new Function<JavaRDD<String>, Void>() {
		// @Override
		// public Void call(JavaRDD<String> rdd) throws Exception {
		// rdd.saveAsTextFile("hdfs://localhost:8020/user/input/abc.txt");
		// return null;
		// }
		// });

//		 jssc.start();
//		 jssc.awaitTermination();
	}
}
