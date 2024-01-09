package Q1;
import java.util.ArrayList;
import java.util.Iterator;

class student{
	String name;
	String usn;
	char section;
	double marks;
	String department;
	student(String name,String usn,char section,double marks,String department){
		this.name=name;
		this.usn=usn;
		this.section=section;
		this.marks=marks;
		this.department=department;
	}
	
}

public class StudentProg{
	public static void main(String args[]) {
		ArrayList<student>list=new ArrayList<student>();
		
		list.add(new student("aditya","is001",'A',86.9,"ISE"));
		list.add(new student("ABC","is002",'A',66.9,"CSE"));
		list.add(new student("DEF","is003",'C',76.9,"ISE"));
		list.add(new student("GHI","is004",'B',88.9,"ISE"));
		list.add(new student("JKL","is005",'C',83.9,"CSE"));
		list.add(new student("MNO","is006",'A',84.9,"ISE"));
		
		

		System.out.println("85 marks section students");
		Iterator<student> itr=list.iterator();
		while(itr.hasNext()) {
			student obj=itr.next();
			if(obj.marks>85) {
				System.out.println(obj.name);
			}
		}
		System.out.println();
		
		
		System.out.println("C section students");
		itr=list.iterator();
		while(itr.hasNext()) {
			student obj=itr.next();
			if(obj.section=='C') {
				System.out.println(obj.name);
			}
		}
		
		
		System.out.println("ISE section students");
		itr=list.iterator();
		while(itr.hasNext()) {
			student obj=itr.next();
			if(obj.department.equalsIgnoreCase("ise")) {
				System.out.println(obj.name);
			}
		}
		
	}
	
}




































//class Student {
//   String name;
//   String USN;
//   String dept;
//   String section;
//   double CGPA;
//
//   public Student(String name, String USN, String dept, String section, double CGPA) {
//       this.name = name;
//       this.USN = USN;
//       this.dept = dept;
//       this.section = section;
//       this.CGPA = CGPA;
//   }
//}
//
//public class StudentProg {
//   public static void main(String[] args) {
//       ArrayList<Student> students = new ArrayList<Student>();
//
//       // Add student data
//       students.add(new Student("Alice", "101", "ISE", "C", 9.2));
//       students.add(new Student("Bob", "102", "CSE", "A", 8.1));
//       students.add(new Student("Charlie", "103", "ISE", "B", 7.5));
//       students.add(new Student("David", "104", "ECE", "C", 8.7));
//       students.add(new Student("Emily", "105", "ISE", "C", 8.9));
//
//       // Print students with CGPA > 8.5
//       System.out.println("Students with CGPA > 8.5:");
//       Iterator<Student> iterator = students.iterator();
//       while (iterator.hasNext()) {
//           Student student = iterator.next();
//           if (student.CGPA > 8.5) {
//               System.out.println(student.name + " (" + student.USN + ", " + student.dept + ", " + student.CGPA + ")");
//           }
//       }
//
//       // Print students belonging to 'ISE' department
//       System.out.println("\nStudents in ISE department:");
//       iterator = students.iterator();
//       while (iterator.hasNext()) {
//           Student student = iterator.next();
//           if (student.dept.equals("ISE")) {
//               System.out.println(student.name + " (" + student.USN + ", " + student.section + ")");
//           }
//       }
//
//       // Print students belonging to 'C' section
//       System.out.println("\nStudents in section C:");
//       iterator = students.iterator();
//       while (iterator.hasNext()) {
//           Student student = iterator.next();
//           if (student.section.equals("C")) {
//               System.out.println(student.name + " (" + student.USN + ", " + student.dept + ")");
//           }
//       }
//   }
//}