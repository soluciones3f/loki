package soluciones3f.loki.auth

class Role {

	String authority

	static mapping = {
		table 'rol'
		cache true
	}

	static constraints = {
		authority blank: false, unique: true
	}
}
