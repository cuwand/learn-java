import java.util.ArrayList;
import java.util.Date;

public class FixedTypeArrayList extends ArrayList {
	public boolean add(Object o) {
		return super.add(o);
	}

	public Object add(Date d) {
		return super.add(d);
	} // overloaded method
}
