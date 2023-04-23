package base;

public class Measure {
	private double value;
	private Unit unit;
	private int precision;

	public Measure(double value) {
		this.value = value;
	}

	public void setPrecision(int precision) {
		this.precision = precision;
	}

	public void addUnit(String name, double exp) {
		unit = new Unit(name, exp, unit);
	}
	
	public String toString() {
		String s = String.format("%."+precision+"f", value);
		
		return s + unit;
	}


	public static Builder value(double v) {
		return new Builder(v);
	}

	public static class Builder {
		private Measure object;
		private String unitName;

		public Builder(double v) {
			object = new Measure(v);
		}

		public Builder is(String name) {
			unitName = name;
			return this;
		}

		public Builder by(String name) {
			if (unitName != null) {
				object.addUnit(unitName, 1);
			}
			unitName = name;
			return this;
		}

		public Builder squared() {
			object.addUnit(unitName, 2);
			unitName = null;
			return this;
		}

		public Builder to(double exponent) {
			object.addUnit(unitName, exponent);
			unitName = null;
			return this;
		}

		public Measure done() {
			return object;
		}

		public Builder withPrecision(int precision) {
			object.setPrecision(precision);
			return this;
		}
		
	}

	private static class Unit {
		String name;
		double exp;
		Unit next;

		Unit(String name, double exp, Unit next) {
			this.name = name;
			this.exp = exp;
			this.next = next;
		}
		
		public String toString() {
			return (next==null?"":next) + " " + 
					name+(exp==1?"":"^"+String.format("%.0f", exp) );
		}
	}
	
	public static void main(String[] args) {
		Measure power;
		
		power = new Measure(10.4);
		power.addUnit("kg", 1);
		power.addUnit("m", 2);
		power.addUnit("s", -3);
		power.setPrecision(2);
		
		System.out.println(power);

		power = Measure.value(10.4).
				 is("kg").by("m").squared().by("s").to(-3).
			     withPrecision(2).done();

		System.out.println(power);
	}
}
