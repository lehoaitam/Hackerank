package Design;

import java.util.Arrays;
import java.util.List;

public class AbstractFactoryDemo {
    interface Computer{
        void print();
    }
    static class PC implements Computer {
        public void print(){
            System.out.println("PC");
        }

    }
    static class Server implements Computer {
        public void print(){
            System.out.println("Server");
        }
    }
    interface AbstractFactory{
        Computer createComputer();
    }
    static class PCFactory implements AbstractFactory{
        public Computer createComputer(){
            return new PC();
        }
    }
    static class ServerFactory implements AbstractFactory{
        public Computer createComputer(){
            return new Server();
        }
    }
    public static void main(String[] args){
        List<AbstractFactory> abstractFactorys = Arrays.asList(new PCFactory(), new ServerFactory());
        for(AbstractFactory factory: abstractFactorys){
            Computer computer = factory.createComputer();
            computer.print();
        }

    }
}
