package cccev.dsl.model

open class ReferenceFramework(
	val identifier: String,
) {
	override fun toString(): String {
		return "ReferenceFramework(identifier='$identifier')"
	}

	override fun equals(other: Any?): Boolean {
		if (this === other) return true
		if (other == null || this::class != other::class) return false

		other as ReferenceFramework

		if (identifier != other.identifier) return false

		return true
	}

	override fun hashCode(): Int {
		return identifier.hashCode()
	}


}
