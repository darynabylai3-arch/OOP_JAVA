package lab3.problem_1.InterfaceEx;

public class Main{
    interface Sweet{
        void Sweety();
    }
    interface Spice{
        void Spicy();
    }
    interface Salt{
        void Salty();
    }

    static class Marmelad implements Sweet,Spice,Salt{
        @Override
        public void Sweety(){
            System.out.println("Sweet Marmelad");
        }
        public void Spicy(){
            System.out.println("Spicy marmelad");
        }
        public void Salty(){
            System.out.println("Salty marmelad");
        }
    }
    public static void main(String[] args){
        Marmelad marmelad = new Marmelad();
        marmelad.Salty();
        marmelad.Spicy();
    }
}