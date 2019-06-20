/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package note.vo;

public class User{
private int id;
private String name;
private String pass;
private String email;

public void setId(int id){
	this.id=id;
}

public void setName(String name){
	this.name=name;
}

public void setPass(String pass){
	this.pass=pass;
}

public void setEmail(String email){
	this.email=email;
}

public int getId(){
	return id;
}

public String getName(){
	return name;
}

public String getPass(){
	return pass;
}

public String getEmail(){
	return email;
}

public String toString(){
	return "id= "+getId()+" name= "+getName()+" pass= "+getPass()+" email= "+getEmail();
}
}
