package iterations;

public interface MyIterator {
    boolean hasNext();

    int next();

    boolean reset();

    boolean hasPrevious();

    int current();

    int previous();

}
