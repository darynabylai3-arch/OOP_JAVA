public class DragonLaunchTest {
    public static void main(String[] args) {
        DragonLaunch dl = new DragonLaunch();

        dl.kidnap(new Person(Gender.BOY));
        dl.kidnap(new Person(Gender.BOY));
        dl.kidnap(new Person(Gender.GIRL));
        dl.kidnap(new Person(Gender.GIRL));

        System.out.println(dl);
        System.out.println("Dragon eats? " + dl.willDragonEatOrNot());
        System.out.println(dl);
    }
}
