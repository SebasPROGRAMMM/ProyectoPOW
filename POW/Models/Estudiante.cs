namespace Pow.Models
{
    public class Estudiante
    {
        public int Id { get; set; }
        public int UsuarioId { get; set; }

        // Propiedades de navegación
        public Usuario Usuario { get; set; }
    }
}
