CREATE TABLE IF NOT EXISTS college.department
(
   deptcode   INT,
   deptname   STRING,
   location   STRING
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ',';

CREATE TABLE IF NOT EXISTS college.employee
(
empcode      INT,
empfname     STRING,
emplname     STRING,
job          STRING,
manager      STRING,
hiredate     STRING,
salary       INT,
commission   INT,
deptcode     INT
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ',';

LOAD DATA LOCAL INPATH '/home/hadoop/practicals/hive/dept.csv'
INTO TABLE college.department;


LOAD DATA LOCAL INPATH '/home/hadoop/practicals/hive/emp.csv'
INTO TABLE college.employee;

SELECT job, COUNT(empfname)
FROM college.employee
GROUP BY job;

SELECT empfname||" "||emplname AS empfullname, hiredate
FROM college.employee
WHERE job = 'MANAGER'
ORDER BY hiredate asc;

SELECT concat(empfname," ",emplname) AS empfullname, salary
FROM college.employee
WHERE job = 'ANALYST' AND deptcode = 20;

--Inner Join
SELECT e.empfname, e.deptcode, d.deptname, d.location
FROM college.employee e
INNER JOIN college.department d
ON e.deptcode = d.deptcode;

--Left Join
SELECT e.empfname, e.deptcode, d.deptname, d.location
FROM college.employee e
LEFT JOIN college.department d
ON e.deptcode = d.deptcode;

--Right Join
SELECT e.empfname, e.deptcode, d.deptname, d.location
FROM college.employee e
RIGHT JOIN college.department d
ON e.deptcode = d.deptcode;

--Full Outer Join
SELECT e.empfname, e.deptcode, d.deptname, d.location
FROM (SELECT empfname, deptcode from college.employee where job = 'ANALYST') e
FULL OUTER JOIN college.department d
ON e.deptcode = d.deptcode;


CREATE VIEW college.costly_employee_vw AS
SELECT e.empfname, e.job, e.salary
FROM college.employee e
WHERE e.salary > 2000
AND e.job NOT LIKE 'M%';

DROP VIEW college.costly_employee_vw;

CREATE INDEX index_emp
ON TABLE employee(empcode)
AS 'org.apache.hadoop.hive.ql.index.compact.CompactIndexHandler'
WITH DEFERRED REBUILD;

DROP Index index_emp ON college.employee;

CREATE EXTERNAL TABLE college.student
(
roll      INT,
stfname     STRING,
stlname     STRING,
course      STRING
)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
LOCATION '/user/hadoop/student'
;

CREATE TABLE college.student_course
(
roll      INT,
stfname     STRING,
stlname     STRING
)
PARTITIONED BY (course STRING)
ROW FORMAT DELIMITED
FIELDS TERMINATED BY ','
;

set hive.exec.dynamic.partition=false;
set hive.exec.dynamic.partition.mode=strict;

INSERT OVERWRITE TABLE college.student_course  
PARTITION(course='HTML')
SELECT roll, stfname, stlname
FROM college.student
where course = 'HTML';

INSERT OVERWRITE TABLE college.student_course  
PARTITION(course='HADOOP')
SELECT roll, stfname, stlname
FROM college.student
where course = 'HADOOP';

ALTER TABLE college.student_course
ADD PARTITION (course='PYTHON');

ALTER TABLE college.student_course DROP PARTITION (course='PYTHON');

set hive.exec.dynamic.partition=true;
set hive.exec.dynamic.partition.mode=nonstrict;

INSERT OVERWRITE TABLE college.student_course  
PARTITION(course)  
SELECT roll, stfname, stlname, course  
FROM college.student;

SELECT * FROM college.student_course;

SHOW PARTITIONS college.student_course;

SHOW PARTITIONS college.student_course
PARTITION (course='HADOOP');
