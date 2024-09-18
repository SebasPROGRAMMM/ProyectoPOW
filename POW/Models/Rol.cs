namespace Pow.Models
{
    public class Rol
    {
        public int Id { get; set; }
        public string Nombre { get; set; }

        // Propiedades de navegación
        public ICollection<Usuario> Usuarios { get; set; }
    }
}
