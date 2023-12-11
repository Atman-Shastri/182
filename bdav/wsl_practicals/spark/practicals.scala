var dept_data = sc.textFile("hdfs://localhost:9000/user/hadoop/dept_data.txt")

var dept_csv_data = sc.textFile("hdfs://localhost:9000/user/hadoop/dept_data.csv")

dept_data.take(2)

var lower_dept_data = dept_data.map(line=>line.toLowerCase())

var upper_dept_data = dept_data.map(line=>line.toUpperCase())

var split_dept_data = dept_data.map(line=>line.split(","))

var partitioned_dept_data = split_dept_data.flatMap(inner=>inner)

var data_starts_A = partitioned_dept_data.filter(line=>line.startsWith("A"))

var dept_without_header = dept_csv_data.mapPartitionsWithIndex { (index, row) => if (index == 0) row.drop(1) else row }

var file_path = "hdfs://localhost:9000/user/hadoop/dept_data.csv,hdfs://localhost:9000/user/hadoop/employee_data.csv"

var merged_csvs = sc.textFile(file_path)

var list = sc.parallelize(List(1,2,3,4,5,3,2))

println("Min in list : "+list.reduce(_ min _))
println("Max in list : "+list.reduce(_ max _))
println("Total in list : "+list.reduce(_ + _))


var tuple = sc.parallelize(List(("Z", 1),("A", 20),("B", 30),("C", 40),("B", 30),("B", 60)))

var min_in_tuple = tuple.reduce((a, b) => if (a._2 < b._2) a else b)

var max_in_tuple = tuple.reduce((a, b) => if (a._2 > b._2) a else b)

var total_in_tuple = tuple.reduce((a, b) => ("Total",a._2 + b._2))
