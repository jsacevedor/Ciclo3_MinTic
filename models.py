from tkinter import commondialog
from django.db import models

# Create your models here.
class Carrera(models.Model):
    codigo = models.CharField(max_length=3,primary_key=True)
    nombre = models.CharField(max_length=35)
    duracion = models.PositiveSmallIntegerField(default=5)

    def __str__(self):
        txt = "{0} (duracion: {1} año(s))"
        return txt.format(self.nombre, self.duracion)

class Estudiante(models.Model):
    ident=models.CharField(max_length=10,primary_key=True)
    apellidopat = models.CharField(max_length=35)
    apellidomat = models.CharField(max_length=35)
    nombres = models.CharField(max_length=35)
    fechanacimiento = models.DateField()
    sexos =[
        ('F','Femenino'),
        ('M','Masculino')
    ]
    sexo = models.CharField(max_length=1,choices= sexos, default='F')
    carrera = models.ForeignKey(Carrera,null=False, blank=False,on_delete=models.CASCADE)
    estado = models.BooleanField(default = True)

    def nombrecompleto(self):
        txt = "{0} {1} {2}"
        return txt.format(self.apellidopat,self.apellidomat,self.nombres)

    def __str__(self):
        txt = "{0} / Carrera: {1} / {2} "
        if self.estado:
            estadoEstudiante = "Activo"
        else:
            estadoEstudiante = "InActivo"
        return txt.format(self.nombrecompleto(),self.carrera,estadoEstudiante)

class curso(models.Model):
    codigo = models.CharField(max_length=6,primary_key=True)
    nombre = models.CharField(max_length=30)
    creditos = models.PositiveSmallIntegerField()
    docente = models.CharField(max_length=50)

    def __str__(self):
        txt = "{0}  {1}/ Docente: {2}"
        return txt.format(self.nombre,self.codigo,self.docente)


class matricula(models.Model):
    id = models.AutoField(primary_key=True)
    id_estudiante = models.ForeignKey(Estudiante,null=False, blank=False,on_delete=models.CASCADE)
    curso = models.ForeignKey(curso,null=False, blank=False,on_delete=models.CASCADE)
    Fechamatricula = models.DateTimeField(auto_now_add=True)

    def __str__(self):
        txt = "{0} Curso {1} * Fecha:{2}"
        fechaMat = self.Fechamatricula.strftime("%A %d %m%Y %H:%M:%S")
        return txt.format(self.id_estudiante.nombrecompleto(),self.curso,fechaMat)