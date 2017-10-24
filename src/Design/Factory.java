package Design;

public class Factory {
    interface Computer{

    }
    static class PC implements Computer{

    }
    static class Server implements Computer{

    }
    static Computer createComputer(String kind){
        if(kind.equals("PC"))
            return new PC();
        else return new Server();
    }
    public static void main(String[] args){
        Computer computer = Factory.createComputer("PC");
    }
}

