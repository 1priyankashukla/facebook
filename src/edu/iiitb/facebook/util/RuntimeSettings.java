package edu.iiitb.facebook.util;

public class RuntimeSettings {

	public static final String APPLICATION_NAME = "SIS_1";
	public static final String VERSION_ID = " version 0.1"
			+ " dated February 01, 2013";
	public static final String SERVER_IP = "localhost";
	static String databaseName = "facebook";
	static String dbUserID = "root";
	
	static String dbPassword = "123456"; 
	public static String RUN_MODE = "Test"; // "Production"; //
	public static boolean IS_IN_DEBUG_MODE = true; // false; //
	static int portNo = 3306;// 5432; //
	/*public static String scriptSql[] = {
			// " drop database if exists bookstore;",
			// " create database bookstore;",
			" use student_info_sys;",
			
			"DROP TABLE IF EXISTS Result",
			"DROP TABLE IF EXISTS Friendship",
			"DROP TABLE IF EXISTS Bulletin_board",
			"DROP TABLE IF EXISTS Enroll;",
			"DROP TABLE IF EXISTS Subject;",
			"DROP TABLE IF EXISTS Student;",
			"DROP TABLE IF EXISTS Login;",
			
			"CREATE TABLE student_info_sys.Login ("
				+"Login_id INT NOT NULL AUTO_INCREMENT ,"
				+"User_name VARCHAR(15) NULL ,"
				+"Password VARCHAR(15) NULL ,"
				+"Designation VARCHAR(25) NULL ,"
				+"Last_logged_in VARCHAR(45) NULL ,"
				+"PRIMARY KEY (Login_id) ) ;",
				
			
			"CREATE TABLE student_info_sys.Subject ("
				+"subject_id INT NOT NULL AUTO_INCREMENT ,"
				+"subject_name VARCHAR(20) NULL ,"
				+"subject_code VARCHAR(20) NULL ,"
				+"faculty VARCHAR(25) NULL ,"
				+"syllabus VARCHAR(1000) NULL ,"
				+"semester INT(2) NULL ,"
				+"available_to DATETIME NULL ,"
				+"available_from DATETIME NULL ,"
				+"PRIMARY KEY (subject_id) ) ;",
				
			
			"CREATE TABLE student_info_sys.Student ("
				+"Student_id INT NOT NULL AUTO_INCREMENT ,"
				+"Name VARCHAR(25) NULL ,"
				+"Date_of_birth DATETIME NULL ,"
				+"Intrest VARCHAR(50) NULL ,"
				+"Pic_URL VARCHAR(100) NULL ,"
				+"PRIMARY KEY (Student_id) ,"
				+"INDEX fk_Student_1 (Student_id ASC) ,"
				+"CONSTRAINT fk_Student_1 FOREIGN KEY (Student_id ) REFERENCES student_info_sys.Login (Login_id ) ON DELETE NO ACTION ON UPDATE NO ACTION);",
				
			
			"CREATE TABLE student_info_sys.Enroll ("
				+"Enroll_id INT NOT NULL AUTO_INCREMENT ,"
				+"Student_id INT NULL ,"
				+"Subject_id INT NULL ,"
				+"Enrollment_date VARCHAR(45) NULL ,"
				+"PRIMARY KEY (Enroll_id) ,"
				+"INDEX Student_id (Student_id ASC) ,"
				+"INDEX Subject_id (Subject_id ASC) ,"
				+"CONSTRAINT Student_id FOREIGN KEY (Student_id) REFERENCES student_info_sys.Student (Student_id) ON DELETE NO ACTION ON UPDATE NO ACTION,"
				+"CONSTRAINT Subject_id FOREIGN KEY (Subject_id) REFERENCES student_info_sys.Subject (Subject_id) ON DELETE NO ACTION ON UPDATE NO ACTION);",
				
			"CREATE TABLE student_info_sys.Bulletin_board ("
				+"B_id INT NOT NULL AUTO_INCREMENT ,"
				+"Type VARCHAR(15) NULL ,"
				+"Description VARCHAR(1000) NULL ,"
				+"Date DATETIME NULL ,"
				+"Posted_by VARCHAR(45) NULL ,"
				+"PRIMARY KEY (B_id) );",
				
			"CREATE TABLE student_info_sys.Friendship ("
				+"F_id INT NOT NULL AUTO_INCREMENT ,"
				+"Student_id INT NULL ,"
				+"Friend_id INT NULL ,"
				+"PRIMARY KEY (F_id) ,"
				+"FOREIGN KEY Friendship_Student_id(Student_id) REFERENCES student_info_sys.Student (Student_id ),"
				+"FOREIGN KEY Friendship_Friend_id(Friend_id) REFERENCES student_info_sys.Student (Student_id) );",
				
			"CREATE TABLE student_info_sys.Result ("
				+"Result_id INT NOT NULL AUTO_INCREMENT ,"
				+"Student_id INT NULL ,"
				+"Subject_id INT NULL ,"
				+"Marks INT(3) NULL ,"
				+"Grades VARCHAR(2) NULL ,"
				+"Final_result VARCHAR(5) NULL ,"
				+"PRIMARY KEY (Result_id) ,"
				+"FOREIGN KEY Result_Student_id(Student_id) REFERENCES Student (Student_id ),"
				+"FOREIGN KEY Result_Subject_id(Subject_id) REFERENCES Subject(Subject_id));",
				
				"Alter table Student change Date_of_birth Date_of_birth DATE;"
				
	    };

	
*/	
}
