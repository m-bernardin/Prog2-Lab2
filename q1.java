//1-Create class Student (having name and course_code[] attributes), and class Course (having course_code and course_name attributes). 
// Using array of objects, accept info for some students and courses, and then show the information as his name, and all course names he has taken.
import java.util.*;
public class q1{
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        boolean creatingCourse=true;
        boolean creatingStudent=true;
        int nbCourses=0;
        ArrayList<Course> courses=new ArrayList<>();
        while(creatingCourse){
            System.out.print("Would you like to create a course? (Y/n)\n> ");
            if(input.next().equals("n")){
                creatingCourse=false;
                input.nextLine();
                break;
            }
            input.nextLine();
            System.out.print("Please enter a course name\n> ");
            courses.add(new Course(input.nextLine(),nbCourses));
            ++nbCourses;
        }
        ArrayList<Student> students=new ArrayList<>();
        while(creatingStudent){
            System.out.print("Would you like to create a student? (Y/n)\n> ");
            if(input.next().equals("n")){
                creatingStudent=false;
                input.nextLine();
                break;
            }
            input.nextLine();
            System.out.print("Please enter a student name\n> ");
            String name=input.nextLine();
            boolean addingCourses=true;
            ArrayList<Integer> studentCoursesTemp=new ArrayList<>();
            while(addingCourses){
                System.out.print("Would you like to add a course for this student? ("+name+") (Y/n)\n> ");
                if(input.next().equals("n")){
                    addingCourses=false;
                    input.nextLine();
                    break;
                }
                input.nextLine();
                boolean validCourse=false;
                while(!validCourse){
                    System.out.print("Please enter a course code\n"+getCourses(courses)+"> ");
                    int code=input.nextInt();
                    if(code<=nbCourses&&code>=0){
                        validCourse=true;
                        input.nextLine();
                        studentCoursesTemp.add(code);
                        break;
                    }
                    else System.out.println("Invalid course code...");
                }
            }
            input.close();
            int[] studentCourses=new int[studentCoursesTemp.size()];
            for(int i=0;i<studentCourses.length;++i){
                studentCourses[i]=studentCoursesTemp.get(i);
            }
            students.add(new Student(name,studentCourses));
        }
        String allInfo="All student info:\n";
        for(Student student:students){
            allInfo+=getStudentInfo(student, courses);
        }
        System.out.println(allInfo);
    }
    private static String getCourses(ArrayList<Course> courses){
        String availableCourse="Available courses:\n";
        for(Course course:courses){
            availableCourse+=course.getName()+"("+course.getCourseCode()+")\n";
        }
        return availableCourse;
    }
    private static String getStudentInfo(Student student,ArrayList<Course> courses){
        String info=student.getName()+":\n";
        for(int i=0;i<student.getCourses().length;++i){
            int code=student.getCourses()[i];
            for(Course course:courses){
                if(course.getCourseCode()==code){
                    info+="\t"+course.getName()+"\n";
                    break;
                }
            }
        }
        info+="\n";
        return info;
    }
}