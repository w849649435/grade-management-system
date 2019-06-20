/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package note.vo;

/**
 *
 * @author Administrator
 */
public class Teacher {
    private String teacherid;
    private String teachername;
    private String teacherpassword;

    public Teacher(String teacherid, String teachername, String teacherpassword) {
        this.teacherid=teacherid;
        this.teachername=teachername;
        this.teacherpassword=teacherpassword;
    }

    public Teacher() {
       
    }

	public String getTeacherid() {
		return teacherid;
	}

	public void setTeacherid(String teacherid) {
		this.teacherid = teacherid;
	}

	public String getTeachername() {
		return teachername;
	}

	public void setTeachername(String teachername) {
		this.teachername = teachername;
	}

	public String getTeacherpassword() {
		return teacherpassword;
	}

	public void setTeacherpassword(String teacherpassword) {
		this.teacherpassword = teacherpassword;
	}

	@Override
	public String toString() {
		return "Teacher [teacherid=" + teacherid + ", teachername=" + teachername + ", teacherpassword="
				+ teacherpassword + "]";
	}
    
}

 

