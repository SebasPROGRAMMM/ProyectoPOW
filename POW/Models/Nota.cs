namespace Pow.Models
{
    public class Nota
    {
        public int Id { get; set; }
        public int EstudianteId { get; set; }
        public int MateriaId { get; set; }
        public int PeriodoId { get; set; }
        public decimal Valor { get; set; }

        // Propiedades de navegación
        public Estudiante Estudiante { get; set; }
        public Materia Materia { get; set; }
        public Periodo Periodo { get; set; }
    }
}
