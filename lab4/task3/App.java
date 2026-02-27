package lab4.task3;

interface Game{
    void a();
    void b();
    void c();
}
interface IGame extends Game{
    void d();
}

class LogicGame implements IGame{
    public void a() { System.out.println("LogicGame a"); }
    public void b() { System.out.println("LogicGame b"); }
    public void c() { System.out.println("LogicGame c"); }
    public void d() { System.out.println("LogicGame d"); }
}

class MemoryGame implements IGame{
    public void a() { System.out.println("MemoryGame a"); }
    public void b() { System.out.println("MemoryGame b"); }
    public void c() { System.out.println("MemoryGame c"); }
    public void d() { System.out.println("MemoryGame d"); }
}

public class App {
    static void getStatistics(Game g) {
        g.a();
        g.b();
        g.c();
        if (g instanceof IGame) {
            ((IGame) g).d();
        }
    }

    public static void main(String[] args) {
        LogicGame logic = new LogicGame();
        MemoryGame memory = new MemoryGame();

        System.out.println("LogicGame stats:");
        getStatistics(logic);

        System.out.println("\nMemoryGame stats:");
        getStatistics(memory);
    }
}