package iterations;

import java.util.Iterator;

public class Fibonacci implements Iterable<Integer>{

    private int previous;
    private int current;
    private int upperBound;
    private int lowerBound;

    public Fibonacci(int upperBound) {
        this.upperBound = upperBound;
        this.previous = -2;
        this.current = 1;
        this.lowerBound = 0;
    }

    public void setLowerBound(int lowerBound) {
        this.lowerBound = lowerBound;
    }

    public void setUpperBound(int uBound) {
        this.upperBound = uBound;
    }

    public MyIterator getIterator() {
        return new F_MyIterator();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return previous + current <= upperBound;
            }

            @Override
            public Integer next() {
                if (previous == -2) {
                    previous++;
                    return 0;
                }
                if (previous == -1) {
                    previous++;
                    return 1;
                }
                if (previous == 0) {
                    previous++;
                    return 1;
                }
                current = current + previous;
                previous = current - previous;
                return current;
            }
        };
    }

    private class F_MyIterator implements MyIterator {

        @Override
        public boolean hasNext() {
            return previous + current <= upperBound;
        }

        @Override
        public int next() {
            if (previous == -2) {
                previous++;
                return 0;
            }
            if (previous == -1) {
                previous++;
                return 1;
            }
            if (previous == 0) {
                previous++;
                return 1;
            }
            current = current + previous;
            previous = current - previous;
            return current;
        }

        @Override
        public boolean resetIndex() {
            previous = -2;
            current = 1;
            return true;
        }

        @Override
        public boolean hasPrevious() {
            return current != 0 && previous >= lowerBound;
        }

        @Override
        public int current() {
            return current;
        }

        @Override
        public int previous() {
            if (previous < 0) return 0;
            previous = current - previous;
            current = current - previous;
            return current;
        }
    }

}
