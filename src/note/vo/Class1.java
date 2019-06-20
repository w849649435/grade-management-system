/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package note.vo;

/**
 *
 * @author Administrator
 */
public class Class1 {
      private String  classid;
    private String classname;

    public Class1(String classid, String classname) {
      this.classid=classid;
      this.classname=classname;
    }

    public Class1() {
        
    }
   
     
      public void setClassId(String  classid) {
        this.classid= classid;
    }
 
      public String  getClassId() {
        return classid;
    }
      public String  getClassName() {
        return classname;
    }
 public void setClassName(String  classname) {
        this.classname= classname;
    }

 
       @Override
    public String toString(){
	return getClassName();
}
}
