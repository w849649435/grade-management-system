/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package note.vo;

/**
 *
 * @author Administrator
 */
public class Admin {
    private String  id;
    private String name;
    private String pass;

    /**
     * @return the id
     */
    public String  getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }
    public String toString(){
	return "id= "+getId()+" name= "+getName()+" pass= "+getPass();
}
}
