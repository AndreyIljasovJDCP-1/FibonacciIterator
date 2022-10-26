package iterations;

public interface MyIterator {
    boolean hasNext();

    int next();

    boolean resetIndex();

    boolean hasPrevious();

    int current();

    int previous();

}
