public class Animal {

    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public void hacerSonido() {
        System.out.println(name + " hace un sonido x");
    }

    public void comer() {
        System.out.println(name + " esta comiendo.");
    }
}
