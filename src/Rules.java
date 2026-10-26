public class Rules {
    ConsoleHelper con = new ConsoleHelper();
    
    public Rules(){

    }

    public void display(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        
        System.out.println("This is a placeholder for the future Rules page.\n\nPlease press enter to return to previous screen");

        ConsoleHelper.getInput("");
    }

}