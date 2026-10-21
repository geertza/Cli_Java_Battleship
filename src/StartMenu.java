public class StartMenu {
    ConsoleHelper con = new ConsoleHelper();
    Rules rules = new Rules();
    Tutorial tutorial = new Tutorial();
    String selection;
    Boolean deciding;
    public void display(){
        deciding=true;
        System.out.println(" _______    ______   ________  ________  __        ________   ______   __    __  ______  _______    ");
        System.out.println("/       \\  /      \\ /        |/        |/  |      /        | /      \\ /  |  /  |/      |/       \\ ");
        System.out.println("$$$$$$$  |/$$$$$$  |$$$$$$$$/ $$$$$$$$/ $$ |      $$$$$$$$/ /$$$$$$  |$$ |  $$ |$$$$$$/ $$$$$$$  |  ");
        System.out.println("$$ |__$$ |$$ |__$$ |   $$ |      $$ |   $$ |      $$ |__    $$ \\__$$/ $$ |__$$ |  $$ |  $$ |__$$ |  ");
        System.out.println("$$    $$< $$    $$ |   $$ |      $$ |   $$ |      $$    |   $$      \\ $$    $$ |  $$ |  $$    $$/ ");
        System.out.println("$$$$$$$  |$$$$$$$$ |   $$ |      $$ |   $$ |      $$$$$/     $$$$$$  |$$$$$$$$ |  $$ |  $$$$$$$/  ");
        System.out.println("$$ |__$$ |$$ |  $$ |   $$ |      $$ |   $$ |_____ $$ |_____ /  \\__$$ |$$ |  $$ | _$$ |_ $$ |   ");
        System.out.println("$$    $$/ $$ |  $$ |   $$ |      $$ |   $$       |$$       |$$    $$/ $$ |  $$ |/ $$   |$$ |");
        System.out.println("$$$$$$$/  $$/   $$/    $$/       $$/    $$$$$$$$/ $$$$$$$$/  $$$$$$/  $$/   $$/ $$$$$$/ $$/   ");  

        System.out.println("                                            Start Menu");
        System.out.println("                              (P)lay - (R)ules - (T)utorial - (Q)uit");
        while(deciding){
            selection = con.getInput("");
            selection = selection.toLowerCase();
            if (selection.equals("p")){
                deciding= false;
                play();
            }
            else if (selection.equals("r")){
                deciding= false;
                openRules();
            }
            else if (selection.equals("t")){
                deciding= false;
                openTutorial();
            }
            else if (selection.equals("q")){
                deciding= false;
                quit();
            }
        }
    }                       
    
    public void play(){
        System.out.println("                Would you like to resume a previous save game or make a new game?");
        System.out.println("                                     (N)ew Game - (L)oad Game");
    }

    public void openRules(){
        rules.display();
    }
    
    public void openTutorial(){
        tutorial.start();
    }

    public void quit(){
        Game.quit();
    }
                                                      
}
