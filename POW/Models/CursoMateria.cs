namespace Pow.Models
{
    public class CursoMateria
    {
        public int CursoId { get; set; }
        public int MateriaId { get; set; }

        // Propiedades de navegación
        public Curso Curso { get; set; }
        public Materia Materia { get; set; }
    }
}
