package com.bjsxt.scala.spark.topn

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object TopN {

    def main(args: Array[String]) {
      val conf = new SparkConf().setAppName("TopN").setMaster("local")
      val sc = new SparkContext(conf)
      
      val lines=sc.textFile("top.txt")
      
      val lineList=lines.map(x=>(x.split(",")(0),x))
      
      val sortRdd = lineList.sortByKey(false)

      
      val resultRDD  = sortRdd.map(x=>x._2)
      
      for(a <-resultRDD.take(5)){
        println(a)
      }


      println("--------")
      resultRDD.take(5).foreach(println)
      
      
    }
}