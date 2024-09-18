using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Pow.Models;
using BCrypt.Net;
using Pow.Data; // Si estás usando BCrypt para hashing de contraseñas

namespace Pow.Pages.Account
{
    public class RegisterModel : PageModel
    {
        private readonly ApplicationDbContext _context;

        public RegisterModel(ApplicationDbContext context)
        {
            _context = context;
        }

        [BindProperty]
        public RegisterInputModel Input { get; set; }

        public class RegisterInputModel
        {
            public string Email { get; set; }
            public string Password { get; set; }
            public string Nombre { get; set; }
            public int RolId { get; set; }
        }

        public void OnGet()
        {
        }

        public IActionResult OnPost()
        {
            if (!ModelState.IsValid)
            {
                return Page();
            }

            var passwordHash = BCrypt.Net.BCrypt.HashPassword(Input.Password);

            var usuario = new Usuario
            {
                Email = Input.Email,
                PasswordHash = passwordHash,
                Nombre = Input.Nombre,
                RolId = Input.RolId
            };

            _context.Usuarios.Add(usuario);
            _context.SaveChanges();

            return RedirectToPage("/Index"); // Redirige a la página de inicio o a una página de éxito
        }
    }
}
