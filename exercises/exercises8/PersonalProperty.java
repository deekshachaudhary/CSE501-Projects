package exercises8;

public class PersonalProperty implements Valuable{
	
	private final int initialValue;
	private final int yearsOld;
	
	public PersonalProperty(int initialValue, int yearsOld) {
		super();
		this.initialValue = initialValue;
		this.yearsOld = yearsOld;
	}

	public int depreciatedValue() {
		return (int)(this.initialValue *
				Math.pow(0.80, yearsOld));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + initialValue;
		result = prime * result + yearsOld;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonalProperty other = (PersonalProperty) obj;
		if (initialValue != other.initialValue)
			return false;
		if (yearsOld != other.yearsOld)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PersonalProperty [initialValue=" + initialValue + ", yearsOld=" + yearsOld + "]";
	}

	@Override
	public int getLiquidValue() {
		return this.depreciatedValue();
	}
	
	
	
}
