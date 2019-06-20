/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package note.vo;

/**
 *
 * @author Administrator
 */
public class Course {
    
    private String courseid;
    private String coursename;

    public Course(String courseid, String coursename) {
       this.courseid=courseid;
       this.coursename=coursename;
    }

    public Course() {
        
    }


 public String getCourseId() {
        return  courseid;
    }
 public void setId(String  courseid) {
        this.courseid = courseid;
    }
 
 public String getCourseName() {
        return coursename;
    }
  public void setCoursename(String  coursename) {
        this.coursename = coursename;
    }
    @Override
    
     public String toString(){
	return getCourseName();
}
}