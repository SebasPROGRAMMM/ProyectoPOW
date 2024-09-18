namespace Pow.Models
{
    public class AsignacionMateria
    {
        public int MateriaId { get; set; }
        public int ProfesorId { get; set; }

        // Propiedades de navegación
        public Materia Materia { get; set; }
        public Profesor Profesor { get; set; }
    }
}
