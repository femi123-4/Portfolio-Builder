import java.util.ArrayList;
//import java.util.Dictionary;
import java.util.Map;

public class user {
    String name;
    String aboutMe;
    ArrayList<String> skills;
    Map <String, String> projects;

    public user(String n, String am, ArrayList<String> sk, Map <String, String> pr ){
        name = n;
        aboutMe = am;
        skills = sk;
        projects = pr;
    }
    
    public String getName(){
        return name;
    }
    public String getAboutMe(){
        return aboutMe;
    }

    public ArrayList<String> getSkills(){
        return skills;
    }

    public  Map <String, String> getProjects(){
        return projects;
    }

    /*public String toString(){
        return name + " " + email;
    }*/
    

}
