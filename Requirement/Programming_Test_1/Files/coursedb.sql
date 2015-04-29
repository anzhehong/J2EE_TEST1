

CREATE TABLE Courses (
  code VARCHAR(8) primary key, 
  name VARCHAR(64),
  description VARCHAR(640)
) ;

CREATE TABLE Teachers (
  id VARCHAR(8) primary key,
  name VARCHAR(32),
  title VARCHAR(32),
  email VARCHAR(64)
) ;

CREATE TABLE TaughtCourses (
  tcid int auto_increment primary key,
  course VARCHAR(8),
  tid VARCHAR(8),
  classid VARCHAR(2),
  semester INT,
  numberOfStudents INT,
  FOREIGN KEY (tid)
      REFERENCES Teachers(id),
  FOREIGN KEY (course)
      REFERENCES Courses(code)
      
) ;

INSERT INTO Courses VALUES ('420244','Database Systems','A database is an organized collection of data. 
The data is typically organized to model aspects of reality in a way that supports processes requiring 
information. Database management systems are computer software applications that interact with the user, 
other applications, and the database itself to capture and analyze data.');

INSERT INTO Courses VALUES ('420172','Software Architecture','Software architecture is the high level 
structure of a software system, the discipline of creating such structures, and the documentation of 
these structures.') ;

INSERT INTO Courses VALUES ('420168','Introduction to Computer Science','Computer science is the scientific 
and practical approach to computation and its applications.') ;

INSERT INTO Courses VALUES ('420311','Object Oriented Programming','Object-oriented programming (OOP) is a 
programming paradigm based on the concept of "objects", which are data structures that contain data, in the 
form of fields, often known as attributes; and code, in the form of procedures, often known as methods. ') ;

INSERT INTO Courses VALUES ('420111','Introduction to Software Testing','Software testing is an investigation 
conducted to provide stakeholders with information about the quality of the product or service under test.') ;

INSERT INTO Courses VALUES ('420342','Software Engineering','Software engineering is the study and an application 
of engineering to the design, development, and maintenance of software.') ;

INSERT INTO Courses VALUES ('420331','SQL Server','A relational database server from Microsoft.') ;

INSERT INTO Courses VALUES ('420230','GIS','A geographic information system (GIS) is a system designed to capture, 
store, manipulate, analyze, manage, and present all types of spatial or geographical data. ') ;

INSERT INTO Courses VALUES ('420024','Operating Systems','An operating system (OS) is software that manages computer 
hardware and software resources and provides common services for computer programs.');

INSERT INTO Courses VALUES ('420266','Algorithms','In mathematics and computer science, an algorithm is a self-contained 
step-by-step set of operations to be performed. Algorithms exist that perform calculation, data processing, and automated 
reasoning.');




INSERT INTO Teachers VALUES ('22001', 'CAO Buyang','Professor','caobuyang@tongji.edu.cn') ;
INSERT INTO Teachers VALUES ('22002', 'MU Bin','Professor','mubin@tongji.edu.cn') ;
INSERT INTO Teachers VALUES ('22003', 'YUAN Shijin','Associate Professor','yuanshijin@tongji.edu.cn') ;
INSERT INTO Teachers VALUES ('22004', 'ZHANG Huijuan','Associate Professor','zhanghuijuan@tongji.edu.cn') ;
INSERT INTO Teachers VALUES ('22005', 'LIU Qin','Professor','liuqin@tongji.edu.cn') ;
INSERT INTO Teachers VALUES ('22006', 'SHEN Ying','Assistant Professor','shenying@tongji.edu.cn') ;
INSERT INTO Teachers VALUES ('22007', 'DU Qingfeng','Professor','duqingfeng@tongji.edu.cn') ;
INSERT INTO Teachers VALUES ('22008', 'LI Jiangfeng','Assistant Professor','lijiangfeng@tongji.edu.cn') ;
INSERT INTO Teachers VALUES ('22009', 'FAN Hongfei','Assistant Professor','fanhongfei@tongji.edu.cn') ;
INSERT INTO Teachers VALUES ('22010', 'XU Yanling','Associate Professor','xuyanling@tongji.edu.cn') ;




INSERT INTO TaughtCourses (course, tid, classid, semester, numberOfStudents) VALUES ('420168','22008','A',1,160) ;
INSERT INTO TaughtCourses (course, tid, classid, semester, numberOfStudents) VALUES ('420311','22009','A',2,160) ;
INSERT INTO TaughtCourses (course, tid, classid, semester, numberOfStudents) VALUES ('420266','22010','A',3,160);
INSERT INTO TaughtCourses (course, tid, classid, semester, numberOfStudents) VALUES ('420024','22004','A',4,100) ;
INSERT INTO TaughtCourses (course, tid, classid, semester, numberOfStudents) VALUES ('420244','22002','B',4,60) ;
INSERT INTO TaughtCourses (course, tid, classid, semester, numberOfStudents) VALUES ('420244','22003','A',4,120) ;
INSERT INTO TaughtCourses (course, tid, classid, semester, numberOfStudents) VALUES ('420342','22007','A',5,140) ;
INSERT INTO TaughtCourses (course, tid, classid, semester, numberOfStudents) VALUES ('420172','22006','A',5,60) ;
INSERT INTO TaughtCourses (course, tid, classid, semester, numberOfStudents) VALUES ('420331','22003','A',5,30) ;
INSERT INTO TaughtCourses (course, tid, classid, semester, numberOfStudents) VALUES ('420230','22001','A',6,30) ;
INSERT INTO TaughtCourses (course, tid, classid, semester, numberOfStudents) VALUES ('420111','22005','A',6,60) ;
INSERT INTO TaughtCourses (course, tid, classid, semester, numberOfStudents) VALUES ('420111','22007','B',6,80) ;

