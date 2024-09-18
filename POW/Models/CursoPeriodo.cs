namespace Pow.Models
{
    public class CursoPeriodo
    {
        public int CursoId { get; set; }
        public int PeriodoId { get; set; }

        // Propiedades de navegación
        public Curso Curso { get; set; }
        public Periodo Periodo { get; set; }
    }
}

