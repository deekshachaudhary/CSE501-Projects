package exercises8;

public class StockHolding {

	private final String name;
	private final String owner;
	private int numShares;
	private int pricePerShare;

	public StockHolding(String name, String owner, int numShares, int pricePerShare) {
		super();
		this.name = name;
		this.owner = owner;
		this.numShares = numShares;
		this.pricePerShare = pricePerShare;
	}

	@Override
	public String toString() {
		return "StockHolding [name=" + name + ", owner=" + owner + ", numShares=" + numShares + ", pricePerShare="
				+ pricePerShare + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + numShares;
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		result = prime * result + pricePerShare;
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
		StockHolding other = (StockHolding) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (numShares != other.numShares)
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		if (pricePerShare != other.pricePerShare)
			return false;
		return true;
	}

	public int getNumShares() {
		return numShares;
	}

	public void setNumShares(int numShares) {
		this.numShares = numShares;
	}

	public int getPricePerShare() {
		return pricePerShare;
	}

	public void setPricePerShare(int pricePerShare) {
		this.pricePerShare = pricePerShare;
	}

	public String getName() {
		return name;
	}

	public String getOwner() {
		return owner;
	}
	
	

}
