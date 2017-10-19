package de.fhro.inf.prg3.a04.models;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author Peter Kurfer
 * Created on 10/19/17.
 */
public abstract class Plant {
	private static int InstanceCounter = 0;

	private final int id;
	private final double height;
	private final String family;

	public Plant(double height, String family) {
		this.id = ++InstanceCounter;
		this.height = height;
		this.family = family;
	}

	public int getId() {
		return id;
	}

	public double getHeight() {
		return height;
	}

	public String getFamily() {
		return family;
	}

	public abstract PlantColor getColor();

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (!(o instanceof Plant)) return false;

		Plant plant = (Plant) o;

		return new EqualsBuilder()
				.append(getId(), plant.getId())
				.append(getHeight(), plant.getHeight())
				.append(getFamily(), plant.getFamily())
				.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
				.append(getId())
				.append(getHeight())
				.append(getFamily())
				.toHashCode();
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this)
				.append("id", id)
				.append("height", height)
				.append("family", family)
				.toString();
	}
}
