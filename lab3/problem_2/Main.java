package lab3.problem_2;

public class Main {
    interface Breathing{
        void breath();
    }

    interface Moving extends Breathing{
        void swim();
    }

    static class Plankton implements Breathing{
        @Override
        public void breath(){
            System.out.println("EXISTING");
        }
    }
    static class Penguin implements Moving{
        @Override
        public void breath(){
            System.out.println("Breath");
        }
        @Override
        public void swim(){
            System.out.println("Penguin is swimming");
        }
    }
    public static void main(String[] args){
    Penguin kodi = new Penguin();
    kodi.swim();
    Plankton planki = new Plankton();
    planki.breath();
}

}

