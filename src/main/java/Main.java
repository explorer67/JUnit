
public class Main {

        public static void main(String[] args) {
            Calculator calc = Calculator.instance.get();

            int a = calc.plus.apply(1, 2);
            int b = calc.minus.apply(1,1);
            try {
                int c = calc.devide.apply(a, b);
                calc.println.accept(c);
            } catch (ArithmeticException exception) {
                System.out.println("Деление на ноль");
            }

            int d = -10;
            int e = calc.abs.apply(d);
            calc.println.accept(e);
        }

}
