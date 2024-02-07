import controller.DAOAlumno;
import controller.DAOCurso;
import database.HibernateUtil;
import model.Alumno;
import model.Curso;
import model.Direccion;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Entrada {

    public static void main(String[] args) {

        /*
        * @One2One -> unidireccional o bidireccional (tabla_origen Tutor    tabla_destino Alumno)
        * @One2Many -> unidireccional o bidireccional (tabla_origen Curso    tabla_destino List<Alumno>)
        * @Many2Many -> unidireccional o bidireccional (tabla_origen List<Cursos>    tabla_destino List<Alumno>)
        * */

        DAOAlumno operacionesAlumnos = new DAOAlumno();
        //DAOCurso operacionesCursos = new DAOCurso();
        //operacionesAlumnos.insertarAlumno(new Alumno("Nuevo", "Apellido", "correo@gmail.com", 123));
        /*operacionesAlumnos.insertarAlumno(new Alumno("Nuevo",
                "Apellido",
                "correo@gmail.com",
                123,
                new Direccion("Madrid", "Getafe"),
                new Direccion("Madrid", "Villaviciosa")));
        Curso curso = new Curso("123123","123123")
        operacionesAlumnos.insertarAlumno(new Alumno("Nuevo",
                "Apellido",
                "correo@gmail.com",
                123,
                new Direccion("Madrid", "Getafe"),
                new Direccion("Madrid", "Villaviciosa"), curso
                ));
        operacionesCursos.insertarCurso(new Curso("dam","Desarrollo de aplicaciones multiplataforma"));
        operacionesCursos.insertarCurso(new Curso("dam","Desarrollo de aplicaciones multiplataforma"));*/
        /*Curso curso = new Curso("AAAA","AAA");
        operacionesAlumnos.insertarAlumno(new Alumno("Nuevo1",
                "Apellido1",
                "correo1@gmail.com",
                1111,
                new Direccion("Madrid", "Getafe"),
                new Direccion("Madrid", "Villaviciosa"), new Curso("NV","Nuevo")
        ));*/
        //operacionesAlumnos.getAlumnos();
        operacionesAlumnos.getAlumno("qwe",4);
        operacionesAlumnos.actualizarAlumno(1, "qwe");
        operacionesAlumnos.borrarAlumno(1);
    }
}
