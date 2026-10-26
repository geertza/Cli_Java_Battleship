public class StartMenu {
    Rules rules = new Rules();
    Tutorial tutorial = new Tutorial();
    String selection;
    Boolean deciding;
    public void display(){
        deciding=true;
        System.out.print("\033[H\033[2J");
        System.out.flush();
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
            selection = ConsoleHelper.getInput("");
            if (selection == null) {
                System.out.println("You didn't enter anything. Please make a selection.");
                return;
            }
            selection = selection.toLowerCase().trim();
            if (selection.equals("p") || selection.equals("play")){
                deciding= false;
                new GameConfig().start();
            }
            else if (selection.equals("r") || selection.equals("rules")){
                deciding= false;
                openRules();
            }
            else if (selection.equals("t") || selection.equals("tutorial")){
                deciding= false;
                openTutorial();
            }
            else if (selection.equals("q") || selection.equals("quit")){
                deciding= false;
                quit();
            }
            else {
                System.out.println("Invalid selection. Please choose Play, Rules, Tutorial, or Quit.");
            }
        }
    }                       

    public void openRules(){
        rules.printRules();
        display();
    }
    
    public void openTutorial(){
        tutorial.start();
        display();
    }

    public void quit(){
        App.quit();
    }
                                                      
}
