public class Student{
    String name;
    int[] courses;
    public int[] getCourses(){
        return courses;
    }
    public void setCourses(int[] courses){
        this.courses = courses;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public Student(String name,int[] courses){
        this.name=name;
        this.courses=courses;
    }
}