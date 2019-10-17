import java.util.List;

class Trap<T> {
	T trapped;
	List<T> listTrapped;

	public void snare(T trapped) {
		this.trapped = trapped;
	}

	public T release() {
		return trapped;
	}

	public void trapAll(List<T> list) {
		this.listTrapped = list;
	}
	
	public List<T> getAll() {
		return listTrapped;
	}
}