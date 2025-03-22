//package Portfolio project;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;


public class mainPage {
    //creates a html format for skill that would be replaced with the user's information
    static String generateSkills(user user) {
        String storeSkills = "";
        for(String s: user.getSkills()){
            storeSkills = storeSkills +  "<div class=\"skill-item\">" + s + "</div>\n";
        }
        return storeSkills;
    }

    //creates a html format for projects that would be replaced with the user's informati
    static String generateProjects(user user) {
        Map <String, String> temp = user.getProjects();
        String storeProjects = "";
        for (Map.Entry<String, String> entry : temp.entrySet()) {
            storeProjects = storeProjects + "<div class= \"project-card\" > \n <h3>" + entry.getKey() + "</h3> \n<p>" + entry.getValue() + "</p> \n</div>";
        }
        return storeProjects;
    }
        public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        
        // gets the users name
        System.out.println("Input your name");
        String name = input.nextLine();

        // gets description of user
        System.out.println("Input your about yourself");
        String aboutYou = input.nextLine();

        //gets the skill the user has and adds them to a list the user is allowed to input as many things as they wan until they says "no"
        System.out.println("Input your skills. Att the end of the list of your skill type NO" );
        ArrayList <String> skills = new ArrayList<>();
        String skill = "";
        while(!(skill.toUpperCase().equals("NO"))){
            skill = input.nextLine();
            if(skill.toUpperCase().equals("NO")){
                break;
            }
            skills.add(skill);
        }
            
        // gets the project name and description and stores them in a hashtable. The user is allowed to input the project name and description until the user say s"no"

        //INPROVEMENTS: This can be futher expanded into a includinng, the project name, image or gif of project, description of project - partially resovled 
        Map <String, String> projects = new Hashtable<>();
        String pName = "";
        String pDescription = "";
        while (!(pName.toUpperCase().equals("NO"))){
            System.out.println("Input your project's name OR  if you don;t have anything else to input type NO ");
            pName = input.nextLine();
            if(pName.toUpperCase().equals("NO")){
                break;
            }
            System.out.println("Input your project's description");
            pDescription = input.nextLine();
            projects.put(pName, pDescription);
        }

        //get all the users information and stores it into a user object
        user person = new user(name,  aboutYou, skills, projects);
        
        // get the template file and store the update versions with the users input into the replaces
        String templateContent = new String(Files.readAllBytes(Paths.get("/Users/femielias/VS code/Portfolio project/template.html")));
        String replaced = templateContent.replace("[NAME]", person.getName()).replace("[About Me]", person.getAboutMe()).replace("[SkillPlaceholder]", generateSkills(person)).replace("[ProjectPlaceholder]", generateProjects(person));
        
        // stores the informa6tion from replaces into the porfolio file
        try{
            File folder = new File ("/Users/femielias/VS code/Portfolio project", "portfolio.html");
            FileWriter writer = new FileWriter(folder);
            writer.write(replaced);
            writer.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        input.close();
    }

    
}


