using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using System.Threading.Tasks;
using Pow.Data;
using Pow.Models;

namespace Pow.Controllers
{
    public class AccountController : Controller
    {
        private readonly ApplicationDbContext _context;

        public AccountController(ApplicationDbContext context)
        {
            _context = context;
        }

        [HttpGet]
        public IActionResult Register()
        {
            // Cargar roles para el formulario
            ViewBag.Roles = _context.Roles.ToList();
            return View();
        }

        [HttpPost]
        public async Task<IActionResult> Register(Usuario user, int selectedRoleId)
        {
            if (ModelState.IsValid)
            {
                if (await _context.Usuarios.AnyAsync(u => u.Email == user.Email))
                {
                    ModelState.AddModelError(string.Empty, "El correo electrónico ya está en uso.");
                    return View(user);
                }

                user.RolId = selectedRoleId;
                user.PasswordHash = BCrypt.Net.BCrypt.HashPassword(user.PasswordHash);
                _context.Usuarios.Add(user);
                await _context.SaveChangesAsync();
                return RedirectToAction("Login");
            }
            ViewBag.Roles = _context.Roles.ToList();
            return View(user);
        }

        [HttpGet]
        public IActionResult Login()
        {
            return View();
        }

        [HttpPost]
        public async Task<IActionResult> Login(string email, string password)
        {
            var user = await _context.Usuarios
                .Include(u => u.Rol)
                .FirstOrDefaultAsync(u => u.Email == email);

            if (user == null || !BCrypt.Net.BCrypt.Verify(password, user.PasswordHash))
            {
                ModelState.AddModelError(string.Empty, "Credenciales inválidas.");
                return View();
            }

            // Aquí puedes configurar la autenticación, por ejemplo con cookies
            return RedirectToAction("Index", "Home");
        }
    }
}
