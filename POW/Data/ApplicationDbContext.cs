using Microsoft.EntityFrameworkCore;
using Pow.Models;

namespace Pow.Data
{
    public class ApplicationDbContext : DbContext
    {
        public ApplicationDbContext(DbContextOptions<ApplicationDbContext> options)
            : base(options)
        {
        }

        public DbSet<Usuario> Usuarios { get; set; }
        public DbSet<Rol> Roles { get; set; }
        public DbSet<Profesor> Profesores { get; set; }
        public DbSet<Estudiante> Estudiantes { get; set; }
        public DbSet<Curso> Cursos { get; set; }
        public DbSet<Materia> Materias { get; set; }
        public DbSet<Periodo> Periodos { get; set; }
        public DbSet<Nota> Notas { get; set; }
        public DbSet<CursoPeriodo> CursoPeriodos { get; set; }
        public DbSet<CursoMateria> CursoMaterias { get; set; }
        public DbSet<AsignacionMateria> AsignacionMaterias { get; set; }
        public DbSet<Reporte> Reportes { get; set; }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<AsignacionMateria>()
                .HasKey(am => new { am.MateriaId, am.ProfesorId });

            modelBuilder.Entity<CursoMateria>()
                .HasKey(cm => new { cm.CursoId, cm.MateriaId });

            modelBuilder.Entity<CursoPeriodo>()
                .HasKey(cp => new { cp.CursoId, cp.PeriodoId });

            base.OnModelCreating(modelBuilder);
        }
    }
}
