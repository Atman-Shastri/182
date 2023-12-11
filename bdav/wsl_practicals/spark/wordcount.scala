var data = sc.textFile("hdfs://localhost:9000/user/hadoop/sample-file.txt")
data.collect

var datasplit= data.flatMap(line => line.split(" "))
datasplit.collect

var mapdata = datasplit.map(word => (word,1));
mapdata.collect

var counts = mapdata.reduceByKey(_ + _);
counts.collect

var outputDir = "/home/hadoop/wordcount_output"
// val fs = org.apache.hadoop.fs.FileSystem.get(sc.hadoopConfiguration)
// val outputPath = new org.apache.hadoop.fs.Path(outputDir)
// if (fs.exists(outputPath)) {
//   fs.delete(outputPath, true)
// }

counts.saveAsTextFile(outputDir);
