/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package note.vo;

/**
 *
 * @author Administrator
 */
public class Teachercourse {
    private int teachercourseid;
    private String courseid;
    private String teacherid;
    private String classid;
    private String coursename;

    public Teachercourse(String  courseid,String coursename,String classid) {
     
        this.courseid=courseid;
        
        this.coursename=coursename;
        this.classid=classid;
    }

   

    /**
     * @return the teachercourseid
     */
    public int getTeachercourseid() {
        return teachercourseid;
    }

    /**
     * @param teachercourseid the teachercourseid to set
     */
    public void setTeachercourseid(int teachercourseid) {
        this.teachercourseid = teachercourseid;
    }

    /**
     * @return the courseid
     */
    public String getCourseid() {
        return courseid;
    }

    /**
     * @param courseid the courseid to set
     */
    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    /**
     * @return the teacherid
     */
    public String getTeacherid() {
        return teacherid;
    }

    /**
     * @param teacherid the teacherid to set
     */
    public void setTeacherid(String teacherid) {
        this.teacherid = teacherid;
    }
   

    /**
     * @return the classid
     */
    public String getClassid() {
        return classid;
    }

    /**
     * @param classid the classid to set
     */
    public void setClassid(String classid) {
        this.classid = classid;
    }
     

    /**
     * @return the coursename
     */
    public String getCoursename() {
        return coursename;
    }

    /**
     * @param coursename the coursename to set
     */
    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }
     public String toString(){
	return getCoursename();
}
    
}
