package inheritance;

public interface CharSeq {

	int length();

    char charAt(int index);

    CharSequence subSequence(int start, int end);

    String toString();

}
