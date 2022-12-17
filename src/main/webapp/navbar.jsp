<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand" href="<%=request.getContextPath()%>">Home</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="<%=request.getContextPath()%>/nuevo.jsp">Nuevo Libro</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" href="<%=request.getContextPath()%>/FindAllProductoController">Listado de Libros</a>
        </li>
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            FullStack
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li><a class="dropdown-item" href="https://gabrielagarciait.github.io/tpIntegrador/index.html">HTML / CSS </a></li>
            <li><a class="dropdown-item" href="https://gabrielagarciait.github.io/practicaObligatoria/index.html">Bootstrap</a></li>
            <li><a class="dropdown-item" href="https://gabrielagarciait.github.io/tpIntegrador/tpIntegradorJS/index.html">JavaScript</a></li>
            <li><hr class="dropdown-divider"></li>
            <li><a class="dropdown-item" href="https://gabrielagarciait.github.io/SQL/Registros.jpg">Base de Datos</a></li>
            <li><a class="dropdown-item" href="https://gabrielagarciait.github.io/imagenes/habilidadesBlandas.jpg">Habilidades Blandas</a></li>
          </ul>
        </li>
      </ul>
      <!--Formulario de busqueda de producto.-->
      <form class="d-flex"
      	action="<%=request.getContextPath()%>/SearchProductosController">
        <input class="form-control me-2"
        	   name="claveBusqueda" 
        	   type="search" 
        	   placeholder="T&iacute;tulo del libro" 
        	   aria-label="Search">
        <button class="btn btn-success" type="submit">
        	Buscar
        </button>
      </form>
    </div>
  </div>
</nav>