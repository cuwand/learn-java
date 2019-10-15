
class Animal {
	protected float weight;

	public Animal(float weight) {
		this.weight = weight;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public void eat(float gram) {
		this.weight += gram;
	}
}
