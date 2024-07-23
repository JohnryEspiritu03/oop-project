package Main;

import java.io.File;

public class InventoHub {
    public static void main(String args[]){
        File accountFile = new File("src/Database/Accounts.txt");
        
        if(accountFile.exists()){
            new LoginAccount().setVisible(true);
            //new LoginAccount().setVisible(true);
        }   
        else{
            new CreateAccount().setVisible(true);
        }
    }
}
