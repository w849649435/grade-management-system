/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package note.vo;

/**
 *
 * @author Administrator
 */
public class Student {
        private String  studentid;
    private String studentname;
    private String studentpassword;
   private String  studentclass;
  
 

    /**
     * @return the studentid
     */
    public String getStudentid() {
        return studentid;
    }

    /**
     * @param studentid the studentid to set
     */
    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    /**
     * @return the studentname
     */
    public String getStudentname() {
        return studentname;
    }

    /**
     * @param studentname the studentname to set
     */
    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    /**
     * @return the studentpassword
     */
    public String getStudentpassword() {
        return studentpassword;
    }

    /**
     * @param studentpassword the studentpassword to set
     */
    public void setStudentpassword(String studentpassword) {
        this.studentpassword = studentpassword;
    }

    /**
     * @return the studentclass
     */
    public String getStudentclass() {
        return studentclass;
    }
 
   
    public void setStudentclass(String studentclass) {
        this.studentclass = studentclass;
    }

  @Override
    public String toString(){
	return "id="+getStudentid()+" name= "+getStudentname()+ "pass="+getStudentpassword()+
                "ctudentclass="+ getStudentclass();
}
}