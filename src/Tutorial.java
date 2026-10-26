public class Tutorial{
    public Tutorial(){

    }

    public void start(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        
        System.out.println("This is a placeholder for the future Tutorial.\n\nPlease press enter to return to previous screen");

            ConsoleHelper.getInput("");
    }
}