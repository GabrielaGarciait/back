<!Doctype html>
<!--Directivas para importar clases-->
<%@page import="ar.com.codoacodo.domain.Producto"%>
<%@page import="java.util.List"%>

<html lang="es">
	<head>
		<jsp:include page="styles.jsp"/>
	</head>
		<!--Codigo html para mostrar la tabla que viene desde el controller-->
	<body>
		<!--Aca va el navbar.jsp-->
		<jsp:include page="navbar.jsp"/>
		<main class="container">
			<h1>Listado de Libros</h1>
			<jsp:include page="mensajeria.jsp"/>
			<section>
				<table class="table">
				  <thead>
				    <tr>
				      <th scope="col">#</th>
				      <th scope="col">C&oacute;digo</th>
				      <th scope="col">T&iacute;tulo</th>
				      <th scope="col">Precio</th>
				      <th scope="col">Fecha Alta</th>
				      <th scope="col">Autor</th>
				      <th scope="col">Imagen</th>
				      <th scope="col">&nbsp;</th>
				    </tr>
				  </thead>
				  <tbody>
				  <% //scriplet
				  	//Codigo java
				  	//En la jsp existe un objeto llamado request que esta implicito.
				  	//Capturar la lista que guardamos en el controller.
				  	List<Producto> listado = (List<Producto>)request.getAttribute("productos");
				  	for(Producto p : listado){
				  %>
				    <tr>
				      <th scope="row"><%=p.getId()%></th>
				      <td><%=p.getCodigo()%></td>
				      <td><%=p.getTitulo()%></td>
				      <td><%=p.getPrecio()%></td>
				      <td><%=p.getFechaAlta()%></td>
				      <td><%=p.getAutor()%></td>
				      <td><%=p.getImg()%></td>
				      <td>
				      <a class="btn btn-primary" role="button" href="<%=request.getContextPath()%>/EditarProductoController?id=<%=p.getId()%>">Editar</a> 
				      <!-- Button trigger modal -->
						<button type="button" 
								class="btn btn-danger" 
								data-bs-toggle="modal" 
								data-bs-target="#exampleModal"
								onclick="setProductoId(<%=p.getId()%>)">
						  	Eliminar
						</button>
					</td>
				    </tr>
				  <%
				  	}
				  %>
				  </tbody>
				</table>
			</section>
		</main>
		<!-- Modal -->
		<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		    	<form action="<%=request.getContextPath()%>/DeleteProductoController">
		    	  <input type="hidden" name="idProducto" id="idProducto">
			      <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalLabel">Eliminar Libro</h5>
			        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			      </div>
			      <div class="modal-body">
			        ?Confirma que desea eliminar?
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
			        <button type="submit" class="btn btn-primary">Eliminar</button>
			      </div>
			     </form>
		    </div>
		  </div>
		</div>
		<jsp:include page="scripts.jsp"/>
		<script>
			function setProductoId(id) {
				document.getElementById('idProducto').value=id;
			}
		</script>
	</body>
</html>



















