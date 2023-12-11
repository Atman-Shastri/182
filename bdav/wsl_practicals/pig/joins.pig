emp_data = LOAD 
'/home/hadoop/practicals/pig/employee_data.txt'
USING PigStorage(',') AS (  
empcode      :int,
empfname     :chararray,
emplname     :chararray,
job          :chararray,
manager      :chararray,
hiredate     :chararray,
salary       :int,
commission   :int,
deptcode     :int
);

dept_data = LOAD 
'/home/hadoop/practicals/pig/dept_data.txt'
USING PigStorage(',') AS (  
 deptcode     :int,
   deptname   :chararray,
   location   :chararray
);

inner_join = JOIN emp_data BY deptcode, dept_data BY deptcode;
left_join = JOIN emp_data BY deptcode LEFT OUTER, dept_data BY deptcode;
right_join = JOIN emp_data BY deptcode RIGHT OUTER, dept_data BY deptcode;
full_outer_join = JOIN emp_data BY deptcode FULL OUTER, dept_data BY deptcode;

--DUMP inner_join;
--DUMP left_join;
--DUMP right_join;
DUMP full_outer_join;