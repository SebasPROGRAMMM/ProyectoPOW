namespace Pow.Models
{
    public class Usuario
    {
        public int Id { get; set; }
        public string Email { get; set; }
        public string PasswordHash { get; set; }
        public string Nombre { get; set; }
        public int RolId { get; set; }  // Esta propiedad debe ser establecida

        // Propiedades de navegación
        public Rol Rol { get; set; }
        public Profesor Profesor { get; set; }
        public Estudiante Estudiante { get; set; }
    }
}
