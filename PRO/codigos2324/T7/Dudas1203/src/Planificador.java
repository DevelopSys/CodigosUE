import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Planificador implements Serializable {

    private int numeroTareas;
    private String nombre;
    private boolean allComplet;

    public Planificador(String nombre) {
        this.nombre = nombre;
    }
}
