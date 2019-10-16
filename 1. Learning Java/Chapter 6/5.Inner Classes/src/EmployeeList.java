import java.util.NoSuchElementException;

// Here we have a comment representing the machinery that the
// EmployeeListIterator requires. 
// Think for just a second about what you’d have to do to 
// implement that machinery. 
// The resulting class would be completely coupled to the 
// EmployeeList and unusable in other situations. 
// Worse, in order to to function, it must have access 
// to the inner workings of EmployeeList . 
// We would have to allow EmployeeListIterator access to 
// the private array in EmployeeList , 
// exposing this data more widely than it should be. 
// This is less than ideal.

//class EmployeeListIterator implements Iterator {
// lots of knowledge about EmployeeList
//}
public class EmployeeList {
	private Employee[] employees;

	public EmployeeList(Employee[] employees) {
		this.employees = employees;
	}

	Iterator getAnonymousIterator() {
		return new Iterator() {
			int element = 0;

			public boolean hasNext() {
				if (employees[this.element] == null) {
					return false;
				}
				return element < employees.length;
			}

			public Employee next() {
				if (hasNext())
					return employees[element++];
				else
					throw new NoSuchElementException();
			}

			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

	Iterator getIterator() {
		return new Iterator();
	}

	public class Iterator implements java.util.Iterator {
		int element = 0;

		public boolean hasNext() {
			if (employees[this.element] == null) {
				return false;
			}
			return this.element < employees.length;
		}

		public Employee next() {
			if (hasNext()) {
				return employees[this.element++];
			} else
				throw new NoSuchElementException();
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}
