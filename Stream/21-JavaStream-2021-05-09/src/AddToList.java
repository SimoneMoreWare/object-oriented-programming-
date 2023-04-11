import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class AddToList<T> implements Collector <T, List<T>, List<T>> {

	@Override
	public Supplier<List<T>> supplier() {
		return ArrayList<T>::new;
	}

	@Override
	public BiConsumer<List<T>, T> accumulator() {
		return List<T>::add;
	}

	@Override
	public BinaryOperator<List<T>> combiner() {
		// TODO Auto-generated method stub
		return (a,b) -> {
			a.addAll(b);
			return a;
		};
	}

	@Override
	public Function<List<T>, List<T>> finisher() {
		// TODO Auto-generated method stub
		//return Function.identity();
		return a -> a;
	}

	@Override
	public Set<Characteristics> characteristics() {
		// TODO Auto-generated method stub
		HashSet<Characteristics> hs = new HashSet<Characteristics>();
		hs.add(Characteristics.UNORDERED);
		return hs;
	}


}
