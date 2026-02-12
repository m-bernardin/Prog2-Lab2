public class Course{
    String name;
    int courseCode;
    public int getCourseCode(){
        return courseCode;
    }
    public void setCourseCode(int courseCode){
        this.courseCode = courseCode;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public Course(String name,int course_code){
        this.name=name;
        this.courseCode=course_code;
    }
}