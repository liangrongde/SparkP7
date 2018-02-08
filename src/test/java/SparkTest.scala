import org.apache.spark.{SparkConf, SparkContext}

object SparkTest {

  def main (args : Array[String]): Unit ={
    val conf = new SparkConf().setAppName("Spark Test2").setMaster("spark://172.19.30.17:7077")

    val sc = new SparkContext(conf)

    val rdd = sc.parallelize(Array(1,2,3)).collect()

    for (arg <- rdd) {
      println(arg)
    }

    sc.stop()
  }

}
