using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;
using Pow.Models; // Asegúrate de que el namespace sea correcto
using System.Linq;
using BCrypt.Net;
using Pow.Data;

namespace Pow.Pages.Account
{
    public class LoginModel : PageModel
    {
        private readonly ApplicationDbContext _context;

        public LoginModel(ApplicationDbContext context)
        {
            _context = context;
        }

        [BindProperty]
        public LoginInputModel Input { get; set; }

        public class LoginInputModel
        {
            public string Email { get; set; }
            public string Password { get; set; }
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

            var user = _context.Usuarios.FirstOrDefault(u => u.Email == Input.Email);
                      if (user == null || !BCrypt.Net.BCrypt.Verify(Input.Password, user.PasswordHash))
            {
                ModelState.AddModelError(string.Empty, "Credenciales inválidas.");
                return Page();
            }

            // Redirigir según el rol
            if (user.RolId == 1) // Estudiante
            {
                return RedirectToPage("/Account/EstudianteBienvenido");
            }
            else if (user.RolId == 2) // Profesor
            {
                return RedirectToPage("/Account/ProfesorBienvenido");
            }

            return RedirectToPage("/Index");
        }
    }
}
