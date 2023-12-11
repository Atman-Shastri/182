show dbs

use college

db.createCollection("Employee", {
  validator: {
    $jsonSchema: {
      bsonType: "object",
      required: ["empcode"],
      properties: {
        empcode: {
          bsonType: "int"
        },
        empfname: {
          bsonType: "string"
        },
        emplname: {
          bsonType: "string"
        },
        job: {
          bsonType: "string"
        },
        manager: {
          bsonType: "string"
        },
        hiredate: {
          bsonType: "string"
        },
        salary: {
          bsonType: "int"
        },
        commission: {
          bsonType: "int"
        },
        deptcode: {
          bsonType: "int"
        }
      }
    }
  }
})


db.createCollection("Dept", {
  validator: {
    $jsonSchema: {
      bsonType: "object",
      required: ["deptcode"],
      properties: {
        deptcode: {
          bsonType: "int"
        },
        deptname: {
          bsonType: "string"
        },
        location: {
          bsonType: "string"
        }
      }
    }
  }
})


db.Employee.insertMany([
  {
    empcode: 9369,
    empfname: "TONY",
    emplname: "STARK",
    job: "SOFTWAREENGINEER",
    manager: "7902",
    hiredate: "1980-12-17",
    salary: 2800,
    commission: 0,
    deptcode: 20
  },
  {
    empcode: 9499,
    empfname: "TIM",
    emplname: "ADOLF",
    job: "SALESMAN",
    manager: "7698",
    hiredate: "1981-02-20",
    salary: 1600,
    commission: 300,
    deptcode: 30
  },
  {
    empcode: 9566,
    empfname: "KIM",
    emplname: "JARVIS",
    job: "MANAGER",
    manager: "7839",
    hiredate: "1981-04-02",
    salary: 3570,
    commission: 0,
    deptcode: 20
  },
  {
    empcode: 9654,
    empfname: "SAM",
    emplname: "MILES",
    job: "SALESMAN",
    manager: "7698",
    hiredate: "1981-09-28",
    salary: 1250,
    commission: 1400,
    deptcode: 30
  },
  {
    empcode: 9782,
    empfname: "KEVIN",
    emplname: "HILL",
    job: "MANAGER",
    manager: "7839",
    hiredate: "1981-06-09",
    salary: 2940,
    commission: 0,
    deptcode: 10
  },
  {
    empcode: 9788,
    empfname: "CONNIE",
    emplname: "SMITH",
    job: "ANALYST",
    manager: "7566",
    hiredate: "1982-12-09",
    salary: 3000,
    commission: 0,
    deptcode: 20
  },
  {
    empcode: 9839,
    empfname: "ALFRED",
    emplname: "KINSLEY",
    job: "PRESIDENT",
    manager: "7566",
    hiredate: "1981-11-17",
    salary: 5000,
    commission: 0,
    deptcode: 10
  },
  {
    empcode: 9844,
    empfname: "PAUL",
    emplname: "TIMOTHY",
    job: "SALESMAN",
    manager: "7698",
    hiredate: "1981-09-08",
    salary: 1500,
    commission: 0,
    deptcode: 30
  },
  {
    empcode: 9876,
    empfname: "JOHN",
    emplname: "ASGHAR",
    job: "SOFTWAREENGINEER",
    manager: "7788",
    hiredate: "1983-01-12",
    salary: 3100,
    commission: 0,
    deptcode: 20
  },
  {
    empcode: 9900,
    empfname: "ROSE",
    emplname: "SUMMERS",
    job: "TECHNICALLEAD",
    manager: "7698",
    hiredate: "1981-12-03",
    salary: 2950,
    commission: 0,
    deptcode: 20
  },
  {
    empcode: 9902,
    empfname: "ANDREW",
    emplname: "FAULKNER",
    job: "ANALYST",
    manager: "7566",
    hiredate: "1981-12-03",
    salary: 3000,
    commission: 0,
    deptcode: 10
  },
  {
    empcode: 9934,
    empfname: "KAREN",
    emplname: "MATTHEWS",
    job: "SOFTWAREENGINEER",
    manager: "7782",
    hiredate: "1982-01-23",
    salary: 3300,
    commission: 0,
    deptcode: 20
  },
  {
    empcode: 9591,
    empfname: "WENDY",
    emplname: "SHAWN",
    job: "SALESMAN",
    manager: "7698",
    hiredate: "1981-02-22",
    salary: 500,
    commission: 0,
    deptcode: 30
  },
  {
    empcode: 9698,
    empfname: "BELLA",
    emplname: "SWAN",
    job: "MANAGER",
    manager: "7839",
    hiredate: "1981-05-01",
    salary: 3420,
    commission: 0,
    deptcode: 30
  },
  {
    empcode: 9777,
    empfname: "MADII",
    emplname: "HIMBURY",
    job: "ANALYST",
    manager: "7839",
    hiredate: "1981-05-01",
    salary: 2000,
    commission: 200,
    deptcode: 50
  },
  {
    empcode: 9860,
    empfname: "ATHENA",
    emplname: "WILSON",
    job: "ANALYST",
    manager: "7839",
    hiredate: "1992-06-21",
    salary: 7000,
    commission: 100,
    deptcode: 50
  }
]);



db.Dept.insertMany([
  {
    deptcode: 10,
    deptname: "FINANCE",
    location: "EDINBURGH"
  },
  {
    deptcode: 20,
    deptname: "SOFTWARE",
    location: "PADDINGTON"
  },
  {
    deptcode: 30,
    deptname: "SALES",
    location: "MAIDSTONE"
  },
  {
    deptcode: 40,
    deptname: "MARKETING",
    location: "DARLINGTON"
  },
  {
    deptcode: 50,
    deptname: "ADMIN",
    location: "BIRMINGHAM"
  }
]);


db.Employee.find()
db.Dept.find()

db.Employee.find({ "job": { $in: ["SALESMAN", "MANAGER"] } })


db.employee.find({ "job": "ANALYST", "salary": { $lt: 1500 } })

db.Employee.find({
  $or: [
    { "job": "ANALYST" },
    { "salary": { $lt: 1500 } }
  ]
})


db.Employee.find({
  $and: [
    { "job": "ANALYST" },
    {
      $or: [
        { "salary": { $lt: 1500 } },
        { "empfname": /^T/ }
      ]
    }
  ]
})


db.Employee.find().sort({ "job": 1 })

db.Employee.createIndex({ "empcode": 1 })

db.Employee.createIndex({ "empcode": 1 })
db.Employee.createIndex({ "hiredate": 1 })

db.Employee.deleteOne({ "job": "SALESMAN" })


db.Employee.deleteMany({ "job": "SALESMAN" })


db.Employee.deleteMany({})


