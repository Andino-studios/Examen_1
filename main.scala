case class Libro(titulo: String, autor: String, paginas: Int, anio: Int)
case class AutorInfo(autor: String, totalPaginas: Int, cantidadLibros: Int)

object AnalisisEditorial extends App {

  val catalogo: List[Libro] = List(
    Libro("Programación en Scala", "Ana Ruiz", 150, 2010),
    Libro("Fundamentos de FP", "Juan Pérez", 165, 2011),
    Libro("Algoritmos Modernos", "Carlos León", 180, 2012),
    Libro("Estructuras de Datos", "María Gómez", 195, 2013),
    Libro("Introducción a la Programación", "Luis Andrade", 210, 2014),
    Libro("Técnicas de Depuración", "Ana Ruiz", 225, 2015),
    Libro("Diseño de Sistemas", "Juan Pérez", 240, 2016),
    Libro("Patrones de Diseño", "Carlos León", 255, 2017),
    Libro("Aplicaciones Web", "María Gómez", 270, 2018),
    Libro("Cómputo en la Nube", "Luis Andrade", 285, 2019),
    Libro("Arquitectura de Software", "Ana Ruiz", 300, 2015),
    Libro("Bases de Datos", "Juan Pérez", 315, 2016),
    Libro("Microservicios", "Carlos León", 330, 2017),
    Libro("Concurrencia en Java", "María Gómez", 345, 2018),
    Libro("Pruebas Automatizadas", "Luis Andrade", 360, 2019),
    Libro("Seguridad Aplicada", "Ana Ruiz", 375, 2016),
    Libro("DevOps Práctico", "Juan Pérez", 390, 2017),
    Libro("Análisis de Datos", "Carlos León", 405, 2018),
    Libro("Machine Learning Básico", "María Gómez", 420, 2019),
    Libro("Redes de Computadores", "Luis Andrade", 435, 2019)
  )
  def autorMasProductivo(minPaginas: Int, minAnio: Int): Option[AutorInfo] = {
    val filtrados = catalogo.filter(l => l.paginas >= minPaginas && l.anio >= minAnio)
    if (filtrados.isEmpty) return None
    val autores = filtrados.map(_.autor).distinct
    val infoPorAutor = autores.map { autorActual =>
      val librosAutor = filtrados.filter(l => l.autor == autorActual)
      val paginasTotales = librosAutor.map(_.paginas).sum
      val cantidad = librosAutor.length
      AutorInfo(autorActual, paginasTotales, cantidad)
    }
    val mejor = infoPorAutor.reduce((a, b) =>
      if (a.totalPaginas > b.totalPaginas) a else b
    )
    Some(mejor)
  }
  val resultado = autorMasProductivo(minPaginas = 250, minAnio = 2016)

}
