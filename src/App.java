public class App {
    public static void main(String[] args){
        Product latte = new Product("Latte", 3.5);
        Product americano = new Product("Americano", 2.5);

        latte.printInfo();
        americano.printInfo();
    }
}