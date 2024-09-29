package actividad1;

import java.util.Objects;

/*	CONSIGNA
Usa una clase o estructura Usuario que tenga un identificador único (por ejemplo, un
nombre o un número de ID).		
*/
public class Usuario {

	private int id;
	
	public Usuario(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + "]";
	}
	
	
}
