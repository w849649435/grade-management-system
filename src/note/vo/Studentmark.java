/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package note.vo;

/**
 *
 * @author Administrator
 */
public class Studentmark {
    private String studentmarkid;
    private String studentid;
    private String courseid;
    private String score;

    /**
     * @return the studentmarkid
     */
    public String getStudentmarkid() {
        return studentmarkid;
    }

    /**
     * @param studentmarkid the studentmarkid to set
     */
    public void setStudentmarkid(String studentmarkid) {
        this.studentmarkid = studentmarkid;
    }

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
     * @return the score
     */
    public String getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(String score) {
        this.score = score;
    }
    
}
