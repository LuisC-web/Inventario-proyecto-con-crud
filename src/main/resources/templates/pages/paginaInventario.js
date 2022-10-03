

function mostrarAgregerarProducto() {
    document.getElementById("agregarP").classList.remove("ocultar");
    document.getElementById("tabladeProductos").classList.add("ocultar");

}

function cerrraAgregarProducto() {

    document.getElementById("agregarP").classList.add("ocultar");
    document.getElementById("tabladeProductos").classList.remove("ocultar");
}

document.getElementById("AgregarP").addEventListener("click", mostrarAgregerarProducto);

document.getElementById("boton-cerrarAgregarProducto").addEventListener("click", cerrraAgregarProducto);