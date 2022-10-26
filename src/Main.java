import iterations.Fibonacci;
import iterations.MyIterator;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        // применение Iterator
        for (Iterator<Integer> iterator = new Fibonacci(250).iterator(); iterator.hasNext(); ) {
            int fibonacciNumber = iterator.next();
            System.out.println("Число Фибоначчи: " + fibonacciNumber);
        }
        // применение MyIterator
        Fibonacci fibonacci = new Fibonacci(250);
        MyIterator myIterator = fibonacci.getIterator();

        while (myIterator.hasNext()) {
            System.out.println(myIterator.next());
        }
        System.out.println("Текущий элемент: " + myIterator.current());
        System.out.println("Предыдущий элемент: " + myIterator.previous());
        System.out.println("Сброс индекса: " + myIterator.resetIndex());
        System.out.println("Текущий элемент: " + myIterator.current());
        System.out.println("Предыдущий элемент: " + myIterator.previous());

        System.out.println("Установка верхней границы: 89");
        fibonacci.setUpperBound(89);

        while (myIterator.hasNext()) {
            System.out.println(myIterator.next());
        }

        System.out.println("Установка нижней границы: 21");
        fibonacci.setLowerBound(21);
        System.out.println("Обратный цикл: ");

        while (myIterator.hasPrevious()) {
            System.out.println(myIterator.previous());
        }
        System.out.println("Текущий элемент: " + myIterator.current());
        System.out.println("Предыдущий элемент: " + myIterator.previous());
    }
}