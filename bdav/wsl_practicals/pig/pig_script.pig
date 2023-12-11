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

emp_acs_order = ORDER emp_data by salary ASC;
DUMP emp_asc_order;

ordered_job = order emp_data by job;
job_details = foreach ordered_job generate empcode, CONCAT(empfname,' ',emplname), SUBSTRING(job,1,4);

student_data = LOAD 
'/home/hadoop/practicals/pig/students.txt'
USING PigStorage(',') AS (  
rollno      :int,
studname     :chararray,
program     :chararray
);

batch_A = FILTER student_data by rollno <=62;
batch_B = FILTER student_data by rollno >62;
dump batch_A;
dump batch_B;

unioned_students = UNION batch_A, batch_B;
dump unioned_students;

emp_row_count = FOREACH (GROUP emp_data ALL) GENERATE COUNT(emp_data) AS row_count;
dump emp_row_count;

emp_grouped_dept_data = GROUP emp_data BY deptcode;
max_salary_by_department = FOREACH emp_grouped_dept_data GENERATE group, MAX(emp_data.salary);
dump max_salary_by_department;

dept_code_is_30 = FILTER emp_data BY deptcode == 30;
dump dept_code_is_30;

first_five_rows = LIMIT emp_data 5;
dump first_five_rows;